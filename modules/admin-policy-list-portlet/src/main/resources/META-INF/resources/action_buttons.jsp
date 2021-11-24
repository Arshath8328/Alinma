<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="admin.policy.list.portlet.AdminPolicyListPortlet"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.Quotation"%>
<%@ include file="/init.jsp"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.google.gson.Gson"%>

<%
	Quotation quotation = (Quotation) request.getAttribute("view.jsp-quotation");
	Log _log = LogFactoryUtil.getLog(AdminPolicyListPortlet.class);
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	String quotationString = "";
	if (row != null) {
		quotation = (Quotation) row.getObject();
	}
	try {
		Gson gson = new Gson();
		quotationString = gson.toJson(quotation);
		quotationString = quotationString.replaceAll("\"", "'");
	} catch (Exception e) {

	}
%>
<style>
.modal-dialog {
	z-index: 1 !important;
}
</style>
<%
	try {
%>
<liferay-ui:icon-menu direction="left-side"
	icon="<%=StringPool.BLANK%>" markupView="lexicon"
	message="<%=StringPool.BLANK%>" showWhenSingleIcon="<%=true%>">
	<portlet:actionURL var="details" name="quotationDetails">
		<portlet:param name="myview" value="details" />
		<portlet:param name="quotationId"
			value="<%=quotation.getQuotationId() + ""%>" />
	</portlet:actionURL>
	<liferay-ui:icon message="Details" url="<%=details.toString()%>" />
	<%
		if (quotation.getQuoteStatus().equals("PS") || quotation.getQuoteStatus().equals("PSA")) {
	%>
	<portlet:actionURL var="acceptURL" name="acceptQuotation">
		<portlet:param name="quotationId"
			value="<%=quotation.getQuotationId() + ""%>" />
		<portlet:param name="insName" value="<%=quotation.getInsuredName()%>" />
		<portlet:param name="insEmail"
			value="<%=quotation.getInsuredEmail()%>" />
		<portlet:param name="insMobile"
			value="<%=quotation.getInsuredMobile()%>" />
	</portlet:actionURL>

	<li id="accept_<%=quotation.getQuotationId()%>" url="${acceptURL}">
		<a href="javascript:void(0)"><liferay-ui:message key="Accept" /></a>
	</li>
	<aui:script use="liferay-util-window,liferay-portlet-url">
				$('#accept_<%=quotation.getQuotationId()%>').on('click', function(event) {
					//openModal();
					var url = $(this).attr('url');
					//alert(url);
					openModal();
					$("#confirmBtn").attr('href', url);
				});
				function openModal()
				{
					AUI().use('aui-modal', function(A) {
						var dialog = new A.Modal({
							title: "",
							bodyContent: $('#accept_popup_body').html(),
							headerContent: '',
							centered: true,
							modal: true,
							resizable: false,
							width: 600,
							height: 300,
							render: '#accept_popup_content'
						});						
						dialog.on('visibleChange', function(event) {
							if (!event.newVal) {
								//window.location = '/group/staff/manage_customer_service';
								$("#confirmBtn").attr('href', '');
							}
						});
					});
				}				
			</aui:script>
	<%
		}
	%>

	<%
		if (quotation.getQuoteStatus().equals("PS") || quotation.getQuoteStatus().equals("PSA")) {
	%>
	<portlet:actionURL var="rejectURL" name="rejectQuotation">
		<portlet:param name="quotationId"
			value="<%=quotation.getQuotationId() + ""%>" />
		<portlet:param name="quotationStatus"
			value="<%=quotation.getQuoteStatus() + ""%>" />
	</portlet:actionURL>

	<li id="reject_<%=quotation.getQuotationId()%>" url="${rejectURL}"
		status="<%=quotation.getQuoteStatus()+""%>"><a
		href="javascript:void(0)"><span class="text-danger"><liferay-ui:message
					key="reject" /></span></a></li>
	<aui:script use="liferay-util-window,liferay-portlet-url">
				$('#reject_<%=quotation.getQuotationId()%>').on('click', function(event) {
					//openModal();
					$("[id*='reason']").val('0,0');
					var url = $(this).attr('url');
					//alert(url);
					var status = $(this).attr('status');
					if(status != 'PSA')
					    $("[id*='reason'] option[value!='0,0']").hide();
					else
					    $("[id*='reason'] option[value!='0,0']").show();
					openRejectModal();
					$("[id*='rejectForm']").attr('action', url);
				});		
				function openRejectModal()
				{
					AUI().use('aui-modal', function(A) {
						var dialog = new A.Modal({
							title: "",
							bodyContent: $('#reject_popup_body').html(),
							headerContent: '',
							centered: true,
							modal: true,
							resizable: false,
							width: 600,
							height: 300,
							render: '#reject_popup_content'
						});						
						dialog.on('visibleChange', function(event) {
							if (!event.newVal) {
								//window.location = '/group/staff/manage_customer_service';
								$("[id*='rejectForm']").attr('action', '');
							}
						});
					});
				}			
			</aui:script>
	<%
		}
	%>
</liferay-ui:icon-menu>
<%
	} catch (Exception e) {
		e.printStackTrace();
	}
%>


