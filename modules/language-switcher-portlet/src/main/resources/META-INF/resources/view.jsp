<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@ include file="/init.jsp" %>


<%
ThemeDisplay resources_viwe_jsp_themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
String title = resources_viwe_jsp_themeDisplay.getLayout().getName(resources_viwe_jsp_themeDisplay.getLocale());
%>

<a href="http://localhost:8080/ar/web/guest"+title><b><liferay-ui:message key="languageSwitcher.langAr"/></b></a>
<a href="http://localhost:8080/en/web/guest"+title><b><liferay-ui:message key="languageSwitcher.langEn"/></b></a>
