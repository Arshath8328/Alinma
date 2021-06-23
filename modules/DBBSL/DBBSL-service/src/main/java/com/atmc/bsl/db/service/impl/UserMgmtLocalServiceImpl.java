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

import com.atmc.bsl.db.service.base.UserMgmtLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.CountryConstants;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.ListType;
import com.liferay.portal.kernel.model.ListTypeConstants;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.OrganizationConstants;
import com.liferay.portal.kernel.model.RegionConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.ListTypeServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringUtil;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the user mgmt local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.UserMgmtLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see UserMgmtLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.UserMgmt", service = AopService.class)
public class UserMgmtLocalServiceImpl extends UserMgmtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.bsl.db.service.UserMgmtLocalServiceUtil} to access the user
	 * mgmt local service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(UserMgmtLocalServiceImpl.class);

	private int orgSyncPageSize = Integer.valueOf(PropsUtil.get("org.sync.pagesize"));

	public User createUser(long companyId, String login, String password, String englishName, String arabicName,
			Locale language, String mobile, String email, ServiceContext serviceContext) throws PortalException {

		return doCreateUser(companyId, login, password, englishName, arabicName, language, mobile, email,
				serviceContext, null, null);

	}

	public User createUser(long companyId, String login, String password, String englishName, String arabicName,
			Locale language, String mobile, String email, ServiceContext serviceContext, String reminderQueryQuestion,
			String reminderQueryAnswer) throws PortalException {

		return doCreateUser(companyId, login, password, englishName, arabicName, language, mobile, email,
				serviceContext, reminderQueryQuestion, reminderQueryAnswer);

	}

	private User doCreateUser(long companyId, String login, String password, String englishName, String arabicName,
			Locale language, String mobile, String email, ServiceContext serviceContext, String reminderQueryQuestion,
			String reminderQueryAnswer) throws PortalException {

		_log.info("doCreateUser start");

		long creatorUserId = 0;
		boolean autoPassword = (password == null) ? true : false;
		String password1 = password;
		String password2 = password;
		boolean autoScreenName = false;
		String screenName = login;
		long facebookId = 0;
		String openId = StringPool.BLANK;
		// Locale locale = new Locale(language);

		englishName = englishName.trim();
		String firstName = StringUtil.extractFirst(englishName, " ");
		String lastName = StringUtil.extractLast(englishName, " ");
		String middleName = StringUtil.removeFromList(StringUtil.removeFromList(englishName, firstName, " "), lastName,
				" ");

		_log.info("firstName:" + firstName);
		_log.info("middleName:" + middleName);
		_log.info("lastName:" + lastName);

		long prefixId = 0;
		long suffixId = 0;
		boolean male = true;
		int birthdayMonth;
		int birthdayDay;
		int birthdayYear;
		long[] organizationIds = {};
		long[] roleIds = {};
		long[] userGroupIds = null;
		boolean sendEmail = (autoPassword) ? true : false;

		String jobTitle = StringPool.BLANK;
		String emailAddress = email;

		Calendar birthdayCal = CalendarFactoryUtil.getCalendar();
		birthdayCal.set(1970, Calendar.JANUARY, 1);
		birthdayMonth = birthdayCal.get(Calendar.MONTH);
		birthdayDay = birthdayCal.get(Calendar.DAY_OF_MONTH);
		birthdayYear = birthdayCal.get(Calendar.YEAR);

		Group guestGroup = GroupLocalServiceUtil.getGroup(companyId, GroupConstants.GUEST);
		// Group atmcSiteGroup = GroupLocalServiceUtil.getGroup(companyId, "customer");
		_log.info("Default User Registration site:" + PropsUtil.get("default.reg.sitename"));
		Group atmcSiteGroup = GroupLocalServiceUtil.getGroup(companyId, PropsUtil.get("default.reg.sitename"));

		long[] groupIds = new long[] { guestGroup.getGroupId(), atmcSiteGroup.getGroupId() };

		_log.info("Logging group Ids" + groupIds[0] + " .." + groupIds[1]);

		User user = UserLocalServiceUtil.addUser(creatorUserId, companyId, autoPassword, password1, password2,
				autoScreenName, screenName, emailAddress, facebookId, openId, language, firstName, middleName, lastName,
				prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
				roleIds, userGroupIds, sendEmail, serviceContext);

		_log.info("User Created");

		if (!autoPassword) {
			user.setAgreedToTermsOfUse(true);
			user.setPasswordReset(false);
			user.setReminderQueryQuestion(reminderQueryQuestion);
			user.setReminderQueryAnswer(reminderQueryAnswer);
			user.setLastLoginDate(new Date());
		}

		List<ListType> phoneTypes = ListTypeServiceUtil.getListTypes(Contact.class.getName() + ListTypeConstants.PHONE);
		long mobilePhoneTypeId = 0;
		for (ListType phoneType : phoneTypes) {
			String phoneTypeName = phoneType.getName();
			if (phoneTypeName.equals("mobile-phone")) {
				mobilePhoneTypeId = phoneType.getListTypeId();
			}
		}

		// adding mobile
		PhoneLocalServiceUtil.addPhone(user.getUserId(), Contact.class.getName(), user.getContactId(), mobile, "",
				mobilePhoneTypeId, true, serviceContext);

		// adding custom field
		user.getExpandoBridge().setAttribute("arabicName", arabicName, false);

		UserLocalServiceUtil.updateUser(user);

		return user;

	}

	public User changeFirstTimeLoginPassword(long userId, String password, String reminderQueryQuestion,
			String reminderQueryAnswer) throws PortalException {
		User user = UserLocalServiceUtil.updatePassword(userId, password, password, false, false);
		user.setAgreedToTermsOfUse(true);
		user.setPasswordReset(false);
		user.setReminderQueryQuestion(reminderQueryQuestion);
		user.setReminderQueryAnswer(reminderQueryAnswer);
		user.setLastLoginDate(new Date());
		UserLocalServiceUtil.updateUser(user);
		return user;
	}

	public long getAdminId() {
		long defaultCompanyId = PortalUtil.getDefaultCompanyId();
		Role adminRole;
		try {
			adminRole = RoleLocalServiceUtil.getRole(defaultCompanyId, "Administrator");

			List<User> adminUsers = UserLocalServiceUtil.getRoleUsers(adminRole.getRoleId());
			if (adminUsers != null && !adminUsers.isEmpty()) {
				return adminUsers.get(0).getUserId();
			} else
				return -1;
		} catch (PortalException e) {
			e.printStackTrace();
			return -1;
		}
	}

	public void synchronizeOrgs(ServiceContext context) {

		_log.info("synchronizeOrgs: START");

		try {
			List<Organization> allLiferayOrgs = new ArrayList<Organization>();
			int orgCount = OrganizationLocalServiceUtil.getOrganizationsCount();
			int orgsIndexStart = 0;
			int orgsIndexEnd = orgSyncPageSize;
			while (orgsIndexStart < orgCount) {
				List<Organization> liferayOrgs = OrganizationLocalServiceUtil.getOrganizations(orgsIndexStart,
						orgsIndexEnd);
				allLiferayOrgs.addAll(liferayOrgs);
				orgsIndexStart += orgSyncPageSize;
				orgsIndexEnd = orgsIndexStart + orgSyncPageSize;
				if (orgsIndexEnd > orgCount)
					orgsIndexEnd = orgCount;

			}
			_log.info("synchronizeOrgs: ALL liferay Orgs Count:"
					+ ((allLiferayOrgs != null) ? allLiferayOrgs.size() : "NULL"));

			List<Customer> allATMCOrgs = new ArrayList<Customer>();
			int atmcOrgCount = CustomerLocalServiceUtil.getCustomersCount();
			int atmcOrgsIndexStart = 0;
			int atmcOrgIndexEnd = orgSyncPageSize;
			while (atmcOrgsIndexStart < atmcOrgCount) {
				List<Customer> atmcOrgs = CustomerLocalServiceUtil.getCustomers(atmcOrgsIndexStart, atmcOrgIndexEnd);
				allATMCOrgs.addAll(atmcOrgs);
				atmcOrgsIndexStart += orgSyncPageSize;
				atmcOrgIndexEnd = atmcOrgsIndexStart + orgSyncPageSize;
				if (atmcOrgIndexEnd > atmcOrgCount)
					atmcOrgIndexEnd = atmcOrgCount;
			}

			_log.info("synchronizeOrgs: ATMC Orgs Count:" + ((allATMCOrgs != null) ? allATMCOrgs.size() : "NULL"));

			for (Customer customer : allATMCOrgs) {

				boolean found = false;
				for (Organization org : allLiferayOrgs) {
					if (org.getExpandoBridge().getAttribute("CRNumber", false) != null) {
						String orgCRNumber = (String) org.getExpandoBridge().getAttribute("CRNumber", false);
						if (orgCRNumber.equals(customer.getId())) {
							// _log.info("synchronizeOrgs: Org " + orgCRNumber + " exists in
							// Liferay.SKIPPING");
							found = true;
							break;
						}
					}
				}

				if (!found) {
					_log.info("synchronizeOrgs: Creating Org with CRNumber:" + customer.getId() + ", nameEn:"
							+ customer.getNameEn());
					createOrg(customer.getId(), customer.getNameEn(), customer.getNameAr(), context);
				}

			}

			_log.info("synchronizeOrgs END");

		} catch (Throwable t) {
			t.printStackTrace();
			_log.error("synchronizeOrgs:Failed to synchronize  Orgs", t);
		}

	}

	public boolean createOrg(String orgCRNumber, String orgName, String orgArabicName, ServiceContext context) {

		// ServiceContext serviceContext = ServiceContextFactory.

		context.setAddGroupPermissions(true);
		context.setAddGuestPermissions(true);

		try {
			Organization org = OrganizationLocalServiceUtil.addOrganization(getAdminId(),
					OrganizationConstants.DEFAULT_PARENT_ORGANIZATION_ID, orgName,
					OrganizationConstants.TYPE_ORGANIZATION, RegionConstants.DEFAULT_REGION_ID,
					CountryConstants.DEFAULT_COUNTRY_ID, ListTypeConstants.ORGANIZATION_STATUS_DEFAULT, "", false,
					context);

			org.getExpandoBridge().setAttribute("arabicName", orgArabicName, false);
			org.getExpandoBridge().setAttribute("CRNumber", orgCRNumber, false);
			OrganizationLocalServiceUtil.updateOrganization(org);
		} catch (PortalException e) {
			e.printStackTrace();
			_log.error("Failed To create Org", e);
			return false;
		}

		return true;
	}

}