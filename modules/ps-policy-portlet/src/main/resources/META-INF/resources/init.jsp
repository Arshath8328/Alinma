<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>

<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<script src="/o/atmc-theme/vendor/bootstrap_select/js/bootstrap-select.min.js"></script>

<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/bootstrap_select/css/bootstrap-select.min.css">

<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page	import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page	import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>

<liferay-theme:defineObjects />

<portlet:defineObjects />