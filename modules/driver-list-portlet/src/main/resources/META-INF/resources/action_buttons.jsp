<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%
/* Quotation quotation = (Quotation) request.getAttribute("view.jsp-quotation");
Log _log = LogFactoryUtil.getLog(AdminPolicyListPortlet.class);
ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW );
String quotationString = "";
if (row != null) {
	quotation = (Quotation)row.getObject();
}
try{
	Gson gson = new Gson();
	quotationString = gson.toJson(quotation);
	quotationString = quotationString.replaceAll("\"", "'");
}
catch(Exception e)
{
	
} */

%>
<style>
.modal-dialog 
{
	z-index:1 !important;
}
</style>
<%try{%>
<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
			<li  id="accept_" url="">
				<a href="javascript:void(0)"><liferay-ui:message key="Accept" /></a>
			</li>
			<li id="reject_" url="" status="">
				<a href="javascript:void(0)"><span class="text-danger"><liferay-ui:message key="reject" /></span></a>
			</li>
</liferay-ui:icon-menu>
<% }catch(Exception e){e.printStackTrace(); }%>


