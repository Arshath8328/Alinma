<%@page import="java.text.DateFormat"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ejada.atmc.acl.db.model.ClaimIntimationMtr"%>
<%@page import="claim.intimation.constants.ClaimIntimationPortletKeys"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<liferay-ui:error key="delete_error" message="file_delete_error" /> 
<liferay-ui:success key="delete_success" message="file_delete_success"/>
<%
	ClaimIntimationMtr claimIntimationMtr = (ClaimIntimationMtr) renderRequest.getAttribute("claimIntimationMtr");

	Log _log = LogFactoryUtil.getLog(this.getClass());
%>
	<div class="row margin-top">
		<div class="col-md-10 col-md-offset-1">
			<h3 class="text-primary"><liferay-ui:message key="claims_report_claim"/></h3>
		</div>
		<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
			<img class="img-responsive" src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
		</div>
	</div>
	<div class="row">
		<div class="col-md-10 col-md-offset-1">
			<div class="portlet-content">
				<div class="row">
					<div class="col-sm-12 col-xs-12 col-md-offset-1 col-md-10 col-lg-10 col-lg-offset-1">
						<div class="row">
							<h6>You have initiated a claim. Please followup on the status of your claim using this intimation reference number : </h6>
							<h5><b><%= claimIntimationMtr.getIntimationReferenceNo() %></b></h5>
						</div>
						<br/>
						<br/>
						<br/>
						<div class="row">
							<h6>This is your claim-id : </h6><br/>
							<h5><b><%= claimIntimationMtr.getClaimIntimationMotorId() %></b></h5>
						</div>
						<br/>
						<br/>
						<br/>
						<div class="row">
							<h6>Please contact customer service : </h6><br/>
							<h5><b>8001240211</b></h5>
						</div>						
					</div>
				</div>
			</div>
		</div>
	</div>