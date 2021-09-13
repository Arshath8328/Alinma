<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<%@page import="com.atmc.web.constants.LoginPortletKeys"%>
<%@page import="com.atmc.web.constants.OTPPortletKeys"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>


<%@page import="com.liferay.portal.kernel.exception.EmailAddressException" %>
<%@page import="com.liferay.portal.kernel.exception.GroupFriendlyURLException" %>
<%@page import="com.liferay.portal.kernel.exception.NoSuchCountryException" %>
<%@page import="com.liferay.portal.kernel.exception.NoSuchListTypeException" %>
<%@page import="com.liferay.portal.kernel.exception.NoSuchRegionException" %>
<%@page import="com.liferay.portal.kernel.exception.NoSuchUserException" %>
<%@page import="com.liferay.portal.kernel.exception.PasswordExpiredException" %>
<%@page import="com.liferay.portal.kernel.exception.PhoneNumberException" %>
<%@page import="com.liferay.portal.kernel.exception.PhoneNumberExtensionException" %>
<%@page import="com.liferay.portal.kernel.exception.RequiredFieldException" %>
<%@page import="com.liferay.portal.kernel.exception.RequiredReminderQueryException" %>
<%@page import="com.liferay.portal.kernel.exception.SendPasswordException" %>
<%@page import="com.liferay.portal.kernel.exception.TermsOfUseException" %>
<%@page import="com.liferay.portal.kernel.exception.UserActiveException" %>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException" %>
<%@page import="com.liferay.portal.kernel.exception.UserIdException" %>
<%@page import="com.liferay.portal.kernel.exception.UserLockoutException" %>
<%@page import="com.liferay.portal.kernel.exception.UserPasswordException" %>
<%@page import="com.liferay.portal.kernel.exception.UserReminderQueryException"%>
<%@page import="com.liferay.portal.kernel.exception.UserScreenNameException" %>

<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.util.GetterUtil" %>
<%@page import="com.liferay.users.admin.kernel.util.UsersAdmin" %>
<%@page import="com.liferay.portal.kernel.model.ModelHintsConstants" %>
<%@page import="com.liferay.portal.kernel.util.PropsKeys" %>
<%@page import="com.liferay.portal.kernel.util.PropsUtil" %>
<%@page import="com.liferay.portal.kernel.servlet.SessionErrors" %>
<liferay-theme:defineObjects />

<portlet:defineObjects />