<%@page import="java.text.DecimalFormat"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_dataTables/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_dataTables/dataTables.bootstrap.min.js"></script>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<liferay-theme:defineObjects />
<portlet:defineObjects />
<%
	String currLocale = themeDisplay.getLocale().toString();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	NumberFormat numberFormat = NumberFormat.getInstance();
	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
%>



<%-- 
<%
	String currLocale = themeDisplay.getLocale().toString();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	NumberFormat numberFormat = NumberFormat.getInstance();
	boolean isUserSignedIn = themeDisplay.isSignedIn();
	DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");
%> --%>
