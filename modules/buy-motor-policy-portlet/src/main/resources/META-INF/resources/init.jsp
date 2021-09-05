<%@page import="java.text.NumberFormat"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<liferay-theme:defineObjects />
<%@page import="org.owasp.encoder.Encode"%>

<portlet:defineObjects />
<%
	String currLocale = themeDisplay.getLocale().toString();
	SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	NumberFormat numberFormat = NumberFormat.getInstance();
	boolean isUserSignedIn = themeDisplay.isSignedIn();
%>
