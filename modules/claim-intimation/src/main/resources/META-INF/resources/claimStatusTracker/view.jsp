<%@page
	import="com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ejada.atmc.acl.db.model.ClaimIntimationMtr"%>
<%@page import="claim.intimation.constants.ClaimIntimationPortletKeys"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page
	import="com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException"%>
<%@page
	import="com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException"%>
<%@page
	import="com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException"%>
<%@page
	import="com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException"%>
<%@page
	import="com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<liferay-ui:error key="delete_error" message="file_delete_error" />
<liferay-ui:success key="delete_success" message="file_delete_success" />
<style>
label[for] {
    padding: 10px !important; 
}

#claims-table th, #claims-table td{
	padding: 10px;
}
#claims-table {
margin:3% auto;  border-collapse: collapse !important;
}
#claims-table th{
	font-weight: bold;
}
</style>
<portlet:actionURL name="checkClaimStatus" var="checkClaimStatusURL">
</portlet:actionURL>
<%
	List<ClaimIntimationMtrDTO> claimsList = (List<ClaimIntimationMtrDTO>) request.getAttribute("claimsList");
%>

<form action="<%=checkClaimStatusURL%>" method="post"
	name="<portlet:namespace/>claimIntimationForm"
	id="<portlet:namespace/>claimIntimationForm" role="form">
	<div class="row margin-top">
		<div class="col-md-10 col-md-offset-1">
			<h3 class="text-primary">
				<liferay-ui:message key="claims_report_claim" />
			</h3>
		</div>
		<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
			<img class="img-responsive"
				src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="portlet-content">
				<div class="row">
					<h4><liferay-ui:message key="claim.status.portlet.find.claim"/></h4>
					<%-- <div
						class="col-sm-12 col-xs-12 col-md-offset-1 col-md-10 col-lg-10 col-lg-offset-1" style="margin:auto; text-align:center">
						<div class="radio-group" style="width: fit-content; display: inline-block;">
							<input id="<portlet:namespace/>findByCategory1"
								class="radio-group-option" checked="true" label=""
								name="<portlet:namespace/>findByCategory" type="radio" value=1 />
							<label id="<portlet:namespace/>lblVehicle"
								class="radio-group-label"
								for="_ATMCClaimStatusTracker_findByCategory1"> claim id</label>

							<input id="<portlet:namespace/>findByCategory2"
								class="radio-group-option" checked="false" label=""
								name="<portlet:namespace/>findByCategory" type="radio" value=2 />
							<label id="<portlet:namespace/>lblProperty"
								class="radio-group-label"
								for="_ATMCClaimStatusTracker_findByCategory2">
								intimation reference no</label> <input
								id="<portlet:namespace/>findByCategory3"
								class="radio-group-option" checked="false" label=""
								name="<portlet:namespace/>findByCategory" type="radio" value=3 />
							<label id="<portlet:namespace/>lblProperty"
								class="radio-group-label"
								for="_ATMCClaimStatusTracker_findByCategory3"> Mobile no</label>

							<input id="<portlet:namespace/>findByCategory4"
								class="radio-group-option" checked="false" label=""
								name="<portlet:namespace/>findByCategory" type="radio" value=4 />
							<label id="<portlet:namespace/>lblProperty"
								class="radio-group-label"
								for="_ATMCClaimStatusTracker_findByCategory4"> National
								Id</label>
						</div>
					</div> --%>
				</div>
				<div class="row"  style="margin-left: 36%">
					<input type="text" name="<portlet:namespace/>findByValue"
						id="<portlet:namespace/>findByValue" placeholder="Type value" />
					<button type="submit">Submit</button>
				</div>
				<%
					if (claimsList != null && !claimsList.isEmpty()) { %>
						<table border="1px solid black" id="claims-table">
							<tr>
								<th>Claim Intimation Reference Number</th>
								<th>Claim Number</th>
								<th>Claim Status</th>
							</tr>
						<%	for (ClaimIntimationMtrDTO claim : claimsList) {
							%>
							<tr>
								<td><%=claim.getClaimIntimationMtr().getIntimationReferenceNo()%></td>
								<td><%=claim.getClaimNumber()!=null ? claim.getClaimNumber() : ""%></td>
								<td><%=claim.getClaimStatus()%></td>
							</tr>
							<%
						}
					}
					%>
					</table>
			</div>
		</div>
	</div>
</form>