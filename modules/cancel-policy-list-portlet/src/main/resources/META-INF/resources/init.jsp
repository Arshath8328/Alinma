<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>

<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.dao.search.RowChecker" %>
<%@page import="com.liferay.portal.kernel.dao.search.EmptyOnClickRowChecker" %>
<%@page import="com.liferay.portal.kernel.portlet.PortalPreferences" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletPreferencesFactoryUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletProvider" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletProviderUtil" %>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil" %>
<%@page import="com.liferay.taglib.search.ResultRow" %>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="javax.portlet.WindowState" %>

<liferay-theme:defineObjects />
<liferay-frontend:defineObjects />
<portlet:defineObjects />

<%
PortalPreferences portalPreferences = PortletPreferencesFactoryUtil.getPortalPreferences(liferayPortletRequest);
%>