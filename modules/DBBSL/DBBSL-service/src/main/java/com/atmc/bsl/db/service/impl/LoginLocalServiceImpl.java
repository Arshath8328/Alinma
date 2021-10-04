/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.AuthUser;
import com.atmc.bsl.db.service.OTPLocalServiceUtil;
import com.atmc.bsl.db.service.base.LoginLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.liferay.petra.string.CharPool;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.cluster.ClusterExecutorUtil;
import com.liferay.portal.kernel.cluster.ClusterNode;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.DestinationNames;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.CompanyConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.UserTracker;
import com.liferay.portal.kernel.security.access.control.AccessControlUtil;
import com.liferay.portal.kernel.security.auth.AuthException;
import com.liferay.portal.kernel.security.auth.AuthTokenUtil;
import com.liferay.portal.kernel.security.auth.AuthenticatedUserUUIDStoreUtil;
import com.liferay.portal.kernel.security.auth.Authenticator;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManager;
import com.liferay.portal.kernel.security.auth.session.AuthenticatedSessionManagerUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.liveusers.LiveUsers;
import com.liferay.util.Encryptor;

import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

/**
 * The implementation of the login local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.LoginLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LoginLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Login", service = AopService.class)
public class LoginLocalServiceImpl extends LoginLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.LoginLocalServiceUtil} to access the login
	 * local service.
	 */

	public void logout() throws Exception {
		HttpServletRequest request = PortalUtil
				.getOriginalServletRequest(AccessControlUtil.getAccessControlContext().getRequest());

		HttpServletResponse response = AccessControlUtil.getAccessControlContext().getResponse();

		AuthenticatedSessionManagerUtil.logout(request, response);

	}

	public Set<String> getReminderQueryQuestions() throws PortalException {
		HttpServletRequest request = AccessControlUtil.getAccessControlContext().getRequest();
		User user = PortalUtil.getUser(request);
		return user.getReminderQueryQuestions();
	}

	public AuthUser validateUser(String idIqama, String email) throws PortalException {
		HttpServletRequest request = AccessControlUtil.getAccessControlContext().getRequest();

		Customer customer = CustomerLocalServiceUtil.fetchCustomer(idIqama);
		Company company = PortalUtil.getCompany(request);

		if (customer != null) {

			User user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), idIqama);
			if (user == null) {

				user = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), email);

				if (user == null) {

					return getAuthUser(customer, company.getCompanyId(), AuthTokenUtil.getToken(request), email,
							idIqama);
				} else {
					throw new UserEmailAddressException.MustNotBeDuplicate(user.getUserId(), user.getEmailAddress());
				}

			} else {
				throw new UserScreenNameException.MustNotBeDuplicate(user.getUserId(), user.getScreenName());
			}

		} else {
			throw new UserScreenNameException.MustNotBeNull();
		}

	}

	public AuthUser authenticateUser(String login, String password) throws PortalException {
		HttpServletRequest request = AccessControlUtil.getAccessControlContext().getRequest();

		Company company = PortalUtil.getCompany(request);

		Map<String, String[]> headerMap = new HashMap<>();

		Enumeration<String> enu1 = request.getHeaderNames();

		while (enu1.hasMoreElements()) {
			String name = enu1.nextElement();

			Enumeration<String> enu2 = request.getHeaders(name);

			List<String> headers = new ArrayList<>();

			while (enu2.hasMoreElements()) {
				String value = enu2.nextElement();

				headers.add(value);
			}

			headerMap.put(name, headers.toArray(new String[headers.size()]));
		}

		Map<String, String[]> parameterMap = request.getParameterMap();
		Map<String, Object> resultsMap = new HashMap<>();

		// authenticate user
		int authResult = Authenticator.FAILURE;
		authResult = UserLocalServiceUtil.authenticateByScreenName(company.getCompanyId(), login, password, headerMap,
				parameterMap, resultsMap);

		User user = (User) resultsMap.get("user");

		if (authResult != Authenticator.SUCCESS) {
			if (user != null) {
				user = UserLocalServiceUtil.fetchUser(user.getUserId());
			}

			if (user != null) {
				UserLocalServiceUtil.checkLockout(user);
			}

			throw new AuthException();
		}

		return getAuthUser(user, company.getCompanyId(), AuthTokenUtil.getToken(request));

	}

	private AuthUser getAuthUser(User user, long companyId, String authToken) {

		AuthUser authUser = new AuthUser();
		authUser.setEnglishName(user.getFullName());
		authUser.setArabicName((String) user.getExpandoBridge().getAttribute("arabicName", false));
		authUser.setEmail(user.getEmailAddress());
		authUser.setIqamaId(user.getScreenName());
		authUser.setMobile(user.getPhones().iterator().next().getNumber());
		authUser.setUserId(String.valueOf(user.getUserId()));
		authUser.setAuthToken(authToken);
		authUser.setCompanyId(String.valueOf(companyId));
		authUser.setOtpSecret(OTPLocalServiceUtil.generateSecret());
		authUser.setLastLoginDate(user.getLastLoginDate());

		if (user.getExpandoBridge().getAttribute("workshopId", false) != null)
			authUser.setWorkshopId((String) user.getExpandoBridge().getAttribute("workshopId", false));

		// first time login case, redirect to change password
		if (user.getPasswordReset() && user.getLastLoginDate() == null)
			authUser.setFirstTimeLogin(true);
		else
			authUser.setFirstTimeLogin(false);

		return authUser;

	}

	private AuthUser getAuthUser(Customer customer, long companyId, String authToken, String email, String iqamaId) {
		AuthUser authUser = new AuthUser();
		authUser.setEnglishName(customer.getNameEn());
		authUser.setArabicName(customer.getNameAr());
		authUser.setEmail(email);
		authUser.setIqamaId(iqamaId);
		authUser.setMobile(customer.getPhone());
		authUser.setAuthToken(authToken);
		authUser.setCompanyId(String.valueOf(companyId));
		authUser.setOtpSecret(OTPLocalServiceUtil.generateSecret());
		return authUser;

	}

	public AuthUser login(String login, String password, String rememberMe) throws Exception {

		HttpServletRequest request = AccessControlUtil.getAccessControlContext().getRequest();
		HttpServletResponse response = AccessControlUtil.getAccessControlContext().getResponse();

		String authType = CompanyConstants.AUTH_TYPE_SN;
		Company company = PortalUtil.getCompany(request);
		// _authenticatedSessionManager.login( request, response, login, password,
		// Boolean.valueOf(rememberMe), authType);
		User user = login(request, response, login, password, Boolean.valueOf(rememberMe), authType);
		user.setLastLoginDate(new Date());
		UserLocalServiceUtil.updateUser(user);

		return getAuthUser(user, company.getCompanyId(), AuthTokenUtil.getToken(request));
	}

	private User login(HttpServletRequest request, HttpServletResponse response, String login, String password,
			boolean rememberMe, String authType) throws Exception {

		request = PortalUtil.getOriginalServletRequest(request);

		String queryString = request.getQueryString();

		if (Validator.isNotNull(queryString) && queryString.contains("password=")) {

			String passwordParameterName = "password=";

			String portletId = PortalUtil.getPortletId(request);

			if (portletId != null) {
				passwordParameterName = PortalUtil.getPortletNamespace(portletId) + passwordParameterName;
			}

			int index = queryString.indexOf(passwordParameterName);

			if ((index == 0) || ((index > 0) && (queryString.charAt(index - 1) == CharPool.AMPERSAND))) {

				if (_log.isWarnEnabled()) {
					String referer = request.getHeader(HttpHeaders.REFERER);

					StringBundler sb = new StringBundler(4);

					sb.append("Ignoring login attempt because the password ");
					sb.append("parameter was found for the request with the ");
					sb.append("referer header: ");
					sb.append(referer);

					_log.warn(sb.toString());
				}

				return null;
			}
		}

		// CookieKeys.validateSupportCookie(request);

		HttpSession session = request.getSession();

		Company company = PortalUtil.getCompany(request);

		User user = _getAuthenticatedUser(request, login, password, authType);

		if (!GetterUtil.getBoolean(PropsUtil.get(PropsKeys.AUTH_SIMULTANEOUS_LOGINS))) {
			signOutSimultaneousLogins(user.getUserId());
		}

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SESSION_ENABLE_PHISHING_PROTECTION))) {
			session = renewSession(request, session);
		}

		// Set cookies

		String domain = CookieKeys.getDomain(request);

		if (Validator.isNull(domain)) {
			domain = null;
		}

		String userIdString = String.valueOf(user.getUserId());

		session.setAttribute("j_username", userIdString);

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.PORTAL_JAAS_PLAIN_PASSWORD))) {
			session.setAttribute("j_password", password);
		} else {
			session.setAttribute("j_password", user.getPassword());
		}

		session.setAttribute("j_remoteuser", userIdString);

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SESSION_STORE_PASSWORD))) {
			session.setAttribute(WebKeys.USER_PASSWORD, password);
		}

		Cookie companyIdCookie = new Cookie(CookieKeys.COMPANY_ID, String.valueOf(company.getCompanyId()));

		if (domain != null) {
			companyIdCookie.setDomain(domain);
		}

		companyIdCookie.setPath(StringPool.SLASH);

		Cookie idCookie = new Cookie(CookieKeys.ID, Encryptor.encrypt(company.getKeyObj(), userIdString));

		if (domain != null) {
			idCookie.setDomain(domain);
		}

		idCookie.setPath(StringPool.SLASH);

		int loginMaxAge = GetterUtil.getInteger(PropsUtil.get(PropsKeys.COMPANY_SECURITY_AUTO_LOGIN_MAX_AGE),
				CookieKeys.MAX_AGE);

		if (GetterUtil.getBoolean(PropsUtil.get(PropsKeys.SESSION_DISABLED))) {
			rememberMe = true;
		}

		if (rememberMe) {
			companyIdCookie.setMaxAge(loginMaxAge);
			idCookie.setMaxAge(loginMaxAge);
		} else {

			// This was explicitly changed from 0 to -1 so that the cookie lasts
			// as long as the browser. This allows an external servlet wrapped
			// in AutoLoginFilter to work throughout the client connection. The
			// cookies ARE removed on an actual logout, so there is no security
			// issue. See LEP-4678 and LEP-5177.

			companyIdCookie.setMaxAge(-1);
			idCookie.setMaxAge(-1);
		}

		boolean secure = request.isSecure();

		if (secure && !GetterUtil.getBoolean(PropsUtil.get(PropsKeys.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS))
				&& !StringUtil.equalsIgnoreCase(Http.HTTPS, PropsUtil.get(PropsKeys.WEB_SERVER_PROTOCOL))) {

			Boolean httpsInitial = (Boolean) session.getAttribute(WebKeys.HTTPS_INITIAL);

			if ((httpsInitial == null) || !httpsInitial.booleanValue()) {
				secure = false;
			}
		}

		CookieKeys.addCookie(request, response, companyIdCookie, secure);
		CookieKeys.addCookie(request, response, idCookie, secure);

		if (rememberMe) {
			Cookie loginCookie = new Cookie(CookieKeys.LOGIN, login);

			if (domain != null) {
				loginCookie.setDomain(domain);
			}

			loginCookie.setMaxAge(loginMaxAge);
			loginCookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(request, response, loginCookie, secure);

			Cookie passwordCookie = new Cookie(CookieKeys.PASSWORD, Encryptor.encrypt(company.getKeyObj(), password));

			if (domain != null) {
				passwordCookie.setDomain(domain);
			}

			passwordCookie.setMaxAge(loginMaxAge);
			passwordCookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(request, response, passwordCookie, secure);

			Cookie rememberMeCookie = new Cookie(CookieKeys.REMEMBER_ME, Boolean.TRUE.toString());

			if (domain != null) {
				rememberMeCookie.setDomain(domain);
			}

			rememberMeCookie.setMaxAge(loginMaxAge);
			rememberMeCookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(request, response, rememberMeCookie, secure);

			Cookie screenNameCookie = new Cookie(CookieKeys.SCREEN_NAME,
					Encryptor.encrypt(company.getKeyObj(), user.getScreenName()));

			if (domain != null) {
				screenNameCookie.setDomain(domain);
			}

			screenNameCookie.setMaxAge(loginMaxAge);
			screenNameCookie.setPath(StringPool.SLASH);

			CookieKeys.addCookie(request, response, screenNameCookie, secure);
		}

		if (GetterUtil.getBoolean(PropsUtil.get("auth.user.uuid.store.enabled"))) {
			String userUUID = userIdString.concat(StringPool.PERIOD).concat(String.valueOf(System.nanoTime()));

			Cookie userUUIDCookie = new Cookie(CookieKeys.USER_UUID, Encryptor.encrypt(company.getKeyObj(), userUUID));

			userUUIDCookie.setPath(StringPool.SLASH);

			session.setAttribute(CookieKeys.USER_UUID, userUUID);

			if (rememberMe) {
				userUUIDCookie.setMaxAge(loginMaxAge);
			} else {
				userUUIDCookie.setMaxAge(-1);
			}

			CookieKeys.addCookie(request, response, userUUIDCookie, secure);

			AuthenticatedUserUUIDStoreUtil.register(userUUID);
		}

		return user;
	}

	private User _getAuthenticatedUser(HttpServletRequest request, String login, String password, String authType)
			throws PortalException {

		long userId = GetterUtil.getLong(login);

		Company company = PortalUtil.getCompany(request);

		String requestURI = request.getRequestURI();

		String contextPath = PortalUtil.getPathContext();

		if (requestURI.startsWith(contextPath.concat("/api/liferay"))) {
			throw new AuthException();
		} else {
			Map<String, String[]> headerMap = new HashMap<>();

			Enumeration<String> enu1 = request.getHeaderNames();

			while (enu1.hasMoreElements()) {
				String name = enu1.nextElement();

				Enumeration<String> enu2 = request.getHeaders(name);

				List<String> headers = new ArrayList<>();

				while (enu2.hasMoreElements()) {
					String value = enu2.nextElement();

					headers.add(value);
				}

				headerMap.put(name, headers.toArray(new String[headers.size()]));
			}

			Map<String, String[]> parameterMap = request.getParameterMap();
			Map<String, Object> resultsMap = new HashMap<>();

			if (Validator.isNull(authType)) {
				authType = company.getAuthType();
			}

			int authResult = Authenticator.FAILURE;

			if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
				authResult = UserLocalServiceUtil.authenticateByEmailAddress(company.getCompanyId(), login, password,
						headerMap, parameterMap, resultsMap);
			} else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
				authResult = UserLocalServiceUtil.authenticateByScreenName(company.getCompanyId(), login, password,
						headerMap, parameterMap, resultsMap);
			} else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
				authResult = UserLocalServiceUtil.authenticateByUserId(company.getCompanyId(), userId, password,
						headerMap, parameterMap, resultsMap);
			}

			User user = (User) resultsMap.get("user");

			if (authResult != Authenticator.SUCCESS) {
				if (user != null) {
					user = UserLocalServiceUtil.fetchUser(user.getUserId());
				}

				if (user != null) {
					UserLocalServiceUtil.checkLockout(user);
				}

				throw new AuthException();
			}

			return user;
		}
	}

	private HttpSession renewSession(HttpServletRequest request, HttpSession session) throws Exception {

		// Invalidate the previous session to prevent session fixation attacks

		String[] protectedAttributeNames = PropsUtil.getArray(PropsKeys.SESSION_PHISHING_PROTECTED_ATTRIBUTES);

		Map<String, Object> protectedAttributes = new HashMap<>();

		for (String protectedAttributeName : protectedAttributeNames) {
			Object protectedAttributeValue = session.getAttribute(protectedAttributeName);

			if (protectedAttributeValue == null) {
				continue;
			}

			protectedAttributes.put(protectedAttributeName, protectedAttributeValue);
		}

		session.invalidate();

		session = request.getSession(true);

		for (String protectedAttributeName : protectedAttributeNames) {
			Object protectedAttributeValue = protectedAttributes.get(protectedAttributeName);

			if (protectedAttributeValue == null) {
				continue;
			}

			session.setAttribute(protectedAttributeName, protectedAttributeValue);
		}

		return session;
	}

	private void signOutSimultaneousLogins(long userId) throws Exception {
		long companyId = CompanyLocalServiceUtil.getCompanyIdByUserId(userId);

		Map<String, UserTracker> sessionUsers = LiveUsers.getSessionUsers(companyId);

		List<UserTracker> userTrackers = new ArrayList<>(sessionUsers.values());

		for (UserTracker userTracker : userTrackers) {
			if (userId != userTracker.getUserId()) {
				continue;
			}

			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

			ClusterNode clusterNode = ClusterExecutorUtil.getLocalClusterNode();

			if (clusterNode != null) {
				jsonObject.put("clusterNodeId", clusterNode.getClusterNodeId());
			}

			jsonObject.put("command", "signOut");
			jsonObject.put("companyId", companyId);
			jsonObject.put("sessionId", userTracker.getSessionId());
			jsonObject.put("userId", userId);

			MessageBusUtil.sendMessage(DestinationNames.LIVE_USERS, jsonObject.toString());
		}
	}

	private static final Log _log = LogFactoryUtil.getLog(LoginLocalServiceImpl.class);

	@Reference
	private AuthenticatedSessionManager _authenticatedSessionManager;

}