<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.search.ServiceRequestSearchTerms"%>
<%@page import="com.atmc.web.search.ServiceRequestSearch"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.model.RoleConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.atmc.web.constants.*"%>
<%@ include file="/init.jsp" %>

<%
String policyNumber = (String) request.getParameter("policyNumber");
System.out.println("policyNumber inside assign_to.jsp >>>>>>>>"+policyNumber);


%>

<liferay-ui:error key="close_error" message="error_update_service_request" />  

<div class="row">
	<div class="btn-toolbar-button close">
		<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
			<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
		</svg>
	</div>
</div>


<div class="container bg-white">
	<h3 class="text-primary"><liferay-ui:message key="reason_for_rej" /></h3>

	<portlet:actionURL var="rejectUrl" name="rejectDetails">
		<portlet:param name="myview" value="assign_to"/>
	</portlet:actionURL>
	
	
	<aui:form id="assignForm" action="<%=rejectUrl %>" name="assignForm" method="post"  class="form-inline">
		<aui:fieldset>
			<aui:input type="hidden" name="policyNumber" id="refNo" value="<%=policyNumber %>" />
			<aui:input type="hidden" name="portletInstanceID" id="portletInstanceID" value="" />
			<div class="row">
				<div class="col-md-12">
					<form> 
						<div class="row">
							<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
								<div class="form-group"> 
									<label class="control-label" for="<portlet:namespace/>srvReqCatDD"><liferay-ui:message key="select_role" /></label>												 
									<select id="<portlet:namespace/>roleDD" name="<portlet:namespace/>rejectionReason" class="form-control"> 
										<option value="Finance"><liferay-ui:message key="rejection_reason_1"/></option>
										<option value="Claim Manager"><liferay-ui:message key="rejection_reason_2"/></option>
										<option value="Claim Processor"><liferay-ui:message key="rejection_reason_3"/></option>
										<option value="Surveyor"><liferay-ui:message key="rejection_reason_4"/></option>
										<option value="Surveyor"><liferay-ui:message key="rejection_reason_5"/></option>
									</select>
								</div>									 
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 no-pad">
								<ul class="list-btns">
									<li>
										<button  class="btn btn-primary btn-lg" type="submit"><liferay-ui:message key="confirm" /> 
											<i class="material-icons md-24">&#xE163;</i>
										</button>
									</li>
									<li>
										<a onclick="$('button.close', window.parent.document).click().click();" id="cancelBtn" name="cancelBtn" 
												cssClass="btn btn-lg text-muted btn-link" role="button" href="javascript:;">
											<liferay-ui:message key="cancel" />
										</a>
									</li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row"></div>
		</aui:fieldset>
	</aui:form>
</div>
<script>
function addFiles()
{
	var selectedFiles = document.getElementById("<portlet:namespace/>uploadFile").files;
	$("#listOfFiles ul").html('');
	for(var i = 0 ; i < selectedFiles.length; i++)
	{
			$("#listOfFiles ul").append("<li><span>" + selectedFiles[i].name + "</span></li>")
	}
}



</script>

