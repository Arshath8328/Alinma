<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ejada.atmc.acl.db.model.CLMNajmUploads"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.MuroorTPUploads"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.MuroorODUploads"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.atmc.web.constants.ClaimIntimationPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.ClaimAdminUpload"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.ClaimHistory"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow"%>
<%@page import="com.atmc.bsl.db.service.ClaimLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.ejada.atmc.bsl.db.domain.claim.Claim"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationCustUploads"%>
<%@page import="com.atmc.bsl.db.service.QuotationLocalServiceUtil"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationAdminUpload"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationCover"%>
<%@page import="java.util.List"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationHistory"%>
<%@ include file="/init.jsp" %>
<%@page import="javax.portlet.ActionRequest"%>
<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="Claim_details"/></h1>
<%

Log _log = LogFactoryUtil.getLog(this.getClass());


Claim claim = (Claim) request.getAttribute("claim");
String product=(String) request.getAttribute("policyProduct");
String lang = themeDisplay.getLocale().toString();
User currentUser = PortalUtil.getUser(request);
List<Role> userRoles = themeDisplay.getUser().getRoles();
String roleName="";
for(Role role :userRoles){
	if(role.getName().equals("Claim Processor")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Claim Manager")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Surveyor")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Recovery")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Finance")){
		roleName=role.getName();
		break;
	}
}
List<ClaimWorkflow> claimWORkFlowList = ClaimLocalServiceUtil.getRoleWorkflowByRoleStatus(roleName,claim.getWorkflowStatus());
MuroorODUploads odMuroorUploads= (MuroorODUploads) request.getAttribute("OD_Muroor_Uploads");
MuroorTPUploads tpMuroorUploads= (MuroorTPUploads) request.getAttribute("TP_Muroor_Uploads");
CLMNajmUploads najmUploads = (CLMNajmUploads) request.getAttribute("najmUploads");
boolean isFiles=false;
%>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="file.failed" message="file.failed" />

<div class="container-fluid-1280">
<div class="tab">
	<ul class="nav nav-tabs">
		<li class="active">
			<a href="#tab-1" role="tab" data-toggle="tab"><liferay-ui:message key="claim_req"/></a>
		</li>
		<li>
			<a href="#tab-2" role="tab" data-toggle="tab"><liferay-ui:message key="track_history"/></a>
		</li>
	</ul>
</div>
<div class="tab-content bg-white pad-10">
<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
			<table class="table table-bordered">
		<tr> 
					<td>
						<liferay-ui:message key="claims_ref_number"/><br/>
						<%=claim.getClaimNo()%>
					</td> 
					<td>
						<liferay-ui:message key="clmt"/><br/>
						<%=claim.getClaimAntName()%>
					</td> 
					<td>
						<liferay-ui:message key="policy_no"/><br/>
						<%=claim.getPolicyNo()%>
					</td> 
					<td>
						<liferay-ui:message key="date_received"/><br/>
						<%=claim.getClaimIntmDate()%>
					</td> 
		</tr>
</table>
			<h4 class="text-primary"><liferay-ui:message key="clm_dets"/></h4>
			<table class="table table-bordered"> 
		<tr> 
					<td width="40%"><liferay-ui:message key="claims_id_number"/></td> 
					<td width="60%"><%=claim.getIqamaId()%></td>
		</tr>
		<tr> 
					<td><liferay-ui:message key="claims_claimant_name"/></td> 
			<td><%=claim.getClaimAntName()%></td> 
		</tr>	
		<tr> 
					<td><liferay-ui:message key="claims_claimant_mobile"/></td> 
					<td><%=claim.getClaimAntPhone()%></td>
		</tr>
	<!--  	<tr> 
					<td><liferay-ui:message key="claims_claimant_email"/></td> 
					<td></td>
		</tr>-->
		<tr> 
					<td><liferay-ui:message key="claims_iban"/></td> 
					<td><%=claim.getIban()%></td>
		</tr>										 
</table>
			<h4 class="text-primary"><liferay-ui:message key="claims_details"/></h4>
			<table class="table table-bordered">
		<tr> 
					<td width="40%"><liferay-ui:message key="policy_no"/></td> 
					<td width="60%"><%=claim.getPolicyNo()%></td> 
		</tr>
		<tr> 
					<td><liferay-ui:message key="claims_policy_type"/></td> 
						<c:choose> 
							<c:when test="<%=lang.equals("en_US") %>">
							    <td><%= claim.getProductDescEn() %></td>
							 </c:when>
							 <c:otherwise>
							    <td><%= claim.getProductDescAr() %></td>
							 </c:otherwise>
						</c:choose>
		</tr>	
		<tr>
			<th class="bg-gray"><liferay-ui:message key="city_loc"/></th>
			<c:choose> 
						<c:when test="<%=lang.equals("en_US") %>">
				    <td><%=claim.getLossLocation()%></td>
				 </c:when>
				 <c:otherwise>
				    <td><%=claim.getLossLocationAr()%></td>
				 </c:otherwise>
			</c:choose>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="acc_date"/></th>
			<td>
				<fmt:formatDate pattern="dd/MM/yyyy" value="<%=claim.getClaimLossDate()%>" />
			</td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="acc_time"/></th>
			<td><fmt:formatDate pattern="hh:mm a" value="<%=claim.getClaimLossDate()%>" /></td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="acc_surv"/></th>
			<td><liferay-ui:message key="<%=LanguageUtil.get(request, "claim_status_"+claim.getReportType())%>"/></td>
			
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="perc_resp"/></th>
			<td><%=claim.getFaultPercent()%>%</td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="claims_accident_desc"/></th>
			<td><%=claim.getLossRemarks()%></td>
		</tr>										 
</table>
<h4><liferay-ui:message key="tpl_dets"/></h4>
<table class="table table-bordered">
	<tbody>
		<tr>
			<th width="50%" class="bg-gray"><liferay-ui:message key="claims_id_number"/></th>
			<td><%=claim.getTpID()%></td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="claims_driver_name"/></th>
			<td><%=claim.getTpDriverName()%></td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="claims_driver_mobile"/></th>
			<td><%=claim.getTpMobileNo()%></td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="ins_co"/></th>
			<td><%=claim.getTpInsuranceCo()%></td>
		</tr>
		<tr>
			<th class="bg-gray"><liferay-ui:message key="iban_no"/></th>
			<td><%=claim.getTpIban()%></td>
		</tr>
	</tbody>
</table>
<h4><liferay-ui:message key="attachments"/></h4>

						<table class="table table-bordered">
							<tbody>
<% 
		if(claim.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR))
		{
			if(product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE))
			{
				if(odMuroorUploads.getDriverLicenseName()!=null && !(odMuroorUploads.getDriverLicenseName().equals("")))
				{
					 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="driverLicenseURL">
								<portlet:param name="fileType" value="driverLicense"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=odMuroorUploads.getDriverLicenseName()%><a href="<%=driverLicenseURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
				}
				if(odMuroorUploads.getVehRegistName()!=null && !(odMuroorUploads.getVehRegistName().equals("")))
				{
					 isFiles=true;
%>	
						<tr>
							<portlet:resourceURL var="vehRegistURL">
								<portlet:param name="fileType" value="vehRegist"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=odMuroorUploads.getVehRegistName()%><a href="<%=vehRegistURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
				}
				if(odMuroorUploads.getPolicyCopyName()!=null && !(odMuroorUploads.getPolicyCopyName().equals("")))
				{
					 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="policyCopyURL">
								<portlet:param name="fileType" value="policyCopy"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=odMuroorUploads.getPolicyCopyName()%><a href="<%=policyCopyURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
				}
			}
			else if(product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL))
			{
				if(tpMuroorUploads!=null)
				{
					if(tpMuroorUploads.getDriverLicenseName()!=null && !(tpMuroorUploads.getDriverLicenseName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="driverLicURL">
								<portlet:param name="fileType" value="driverLic"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getDriverLicenseName()%><a href="<%=driverLicURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getVehRegistName()!=null && !(tpMuroorUploads.getVehRegistName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="vehRegstURL">
								<portlet:param name="fileType" value="vehRegst"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getVehRegistName()%><a href="<%=vehRegstURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getFrontPhotoName()!=null && !(tpMuroorUploads.getFrontPhotoName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="frontPhotoURL">
								<portlet:param name="fileType" value="frontPhoto"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getFrontPhotoName()%><a href="<%=frontPhotoURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getRearPhotoName()!=null && !(tpMuroorUploads.getRearPhotoName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="rearPhotoURL">
								<portlet:param name="fileType" value="rearPhoto"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getRearPhotoName()%><a href="<%=rearPhotoURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getRightSidePhotoName()!=null && !(tpMuroorUploads.getRightSidePhotoName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="rightSidePhotoURL">
								<portlet:param name="fileType" value="rightSidePhoto"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getRightSidePhotoName()%><a href="<%=rightSidePhotoURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getLeftSidePhotoName()!=null && !(tpMuroorUploads.getLeftSidePhotoName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="leftSidePhotoURL">
								<portlet:param name="fileType" value="leftSidePhoto"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getLeftSidePhotoName()%><a href="<%=leftSidePhotoURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getBankIbanName()!=null && !(tpMuroorUploads.getBankIbanName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="bankIbanURL">
								<portlet:param name="fileType" value="bankIban"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getBankIbanName()%><a href="<%=bankIbanURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
					if(tpMuroorUploads.getOwnerIdName()!=null && !(tpMuroorUploads.getOwnerIdName().equals("")))
					{
						 isFiles=true;
%>
						<tr>
							<portlet:resourceURL var="ownerIdURL">
								<portlet:param name="fileType" value="ownerId"/>
							 </portlet:resourceURL>
							<td class="bg-gray"><%=tpMuroorUploads.getOwnerIdName()%><a href="<%=ownerIdURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
						</tr>
<%
					}
				}
			}
		}
		else if(claim.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM))
		{
			if (najmUploads.getNajmSlip() != null) {
				 isFiles=true;
%>
					<tr>
						<portlet:resourceURL var="downNajmSlipURL">
							<portlet:param name="fileType" value="najmSlip"/>
						 </portlet:resourceURL>
						<td class="bg-gray">${najmUploads.getNajmSlipName()}<a href="<%=downNajmSlipURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
<%
			}
				if(product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL))
				{
					if (najmUploads.getDamageEstQuot() != null) {
						 isFiles=true;
%>
					<tr>
						<portlet:resourceURL var="downDamageEstURL">
							<portlet:param name="fileType" value="damageEst"/>
						 </portlet:resourceURL>
						<td class="bg-gray">${najmUploads.getDamageEstQuotName()}<a href="<%=downDamageEstURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
				<%
					}
					if (najmUploads.getBankIban() != null) {
						 isFiles=true;
				%>
					<tr>
						<portlet:resourceURL var="downBankIbanURL">
							<portlet:param name="fileType" value="bankIban"/>
						 </portlet:resourceURL>
						<td class="bg-gray">${najmUploads.getBankIbanName()}<a href="<%=downBankIbanURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
				<% 
					}
					if (najmUploads.getOwnerId() != null) {
						 isFiles=true;
				%>
					<tr>
						<portlet:resourceURL var="downOwnerIdURL">
							<portlet:param name="fileType" value="ownerId"/>
						 </portlet:resourceURL>
						<td class="bg-gray">${najmUploads.getOwnerIdName()}<a href="<%=downOwnerIdURL%>"><span class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
<%					}
				}

			}
%>
							</tbody>
						</table>
						<% 
if(!isFiles){
				%>	
						<p class="text-primary"><liferay-ui:message key="no_attchements"/></p>
					
				
<%} %>



<portlet:actionURL var="submitFileAction" name="submitFile">
<portlet:param name="myview" value="details"/>
<portlet:param name="claimRefNo" value="<%=claim.getClaimNo()%>"/>
<portlet:param name="policyNo" value="<%=claim.getPolicyNo()%>"/>
<portlet:param name="policyProductDescAr" value="<%=claim.getProductDescAr()%>"/>
<portlet:param name="policyProductDescEN" value="<%=claim.getProductDescEn()%>"/>
<portlet:param name="policyProduct" value="<%=claim.getProduct()%>"/>
</portlet:actionURL>

<form action="<%= submitFileAction %>" method="post" enctype="multipart/form-data" class="form-inline">
	<div class="row">
		<div class="col-md-12">
			<div class="form-group has-feedback"> 
				<input id="selectedFile" class="form-control" onclick="$('#<portlet:namespace/>adminFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
					<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
					<aui:input type="file" name="adminFile" id="adminFile" cssClass="sr-only" label="">
						<aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
                    	<aui:validator name="custom" errorMessage="max_upload_size">
                            function(val,node,junction){
                           	var uploadSize=true;
                           	var size=0;
                           	var fileInput = document.getElementById("<portlet:namespace/>adminFile");
                           	for(var num1=0;num1<fileInput.files.length;num1++)
                           	{
                                var file=fileInput.files[num1];
                           		if(file.size>2097152)
                           		{
                           			uploadSize=false;
                           		}
                           		else
                           		{
                         			uploadSize=true;
                           		}
                          		size+=file.size;
                           	}
                          	if(uploadSize==true){
                          		return true;
                         	}else{
                  				return false;
                      		}
                     	}
                   	 </aui:validator>
                   	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>adminFile");
							var fileName = "";
								if(fileInput.files.length>0)
									fileName = fileInput.files.item(0).name;
							var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
							return regex.test(fileName);
						}
                   	 </aui:validator>
				</aui:input>
				<liferay-captcha:captcha url="<%=captchaURL%>" />
			</div>
			<input class="btn btn-default" type="submit" value="Upload" />
		</div>
	</div>
</form>

<h4 class="text-primary"><liferay-ui:message key="upload_attachs"/></h4>
<%
_log.info(claim.getClaimAdminUpload());
if(claim.getClaimAdminUpload()!=null){
	List <ClaimAdminUpload> adminUploadFile=claim.getClaimAdminUpload();
	for (int i=0;i<adminUploadFile.size();i++){
		ClaimAdminUpload file=adminUploadFile.get(i);
 
 %>
 <portlet:actionURL var="deleteFileAction" name="deleteFile">
	<portlet:param name="myview" value="details"/>
	<portlet:param name="fileId" value="<%=file.getId()+"" %>"/>
	<portlet:param name="claimRefNo" value="<%=claim.getClaimNo()%>"/>
	<portlet:param name="policyNo" value="<%=claim.getPolicyNo()%>"/>
	<portlet:param name="policyProductDescAr" value="<%=claim.getProductDescAr()%>"/>
	<portlet:param name="policyProductDescEN" value="<%=claim.getProductDescEn()%>"/>
	<portlet:param name="policyProduct" value="<%=claim.getProduct()%>"/>
</portlet:actionURL>

 <portlet:resourceURL var="downloadURL">
 	<portlet:param name="fileId" value="<%=file.getId()+"" %>"/>
 	<portlet:param name="fileType" value="admin"/>
 	<portlet:param name="fileName" value="<%=file.getFileName()%>"/>
 </portlet:resourceURL>
<form  action="<%= deleteFileAction %>" method="post" enctype="multipart/form-data" >
 <table class="table"> 
		<tr> 
			<td width="40%"><a class="text-muted" href="<%= downloadURL %>"><%=file.getFileName()%></a></td>
			<td width="60%"><a class="text-muted" href="<%= deleteFileAction %>">X</a></td>
		</tr>
	</table>	
</form>
<%
 }
}
%>
	<div class="row">
		<div class="col-md-12">
			<ul class="list-btns">
			 	<li class="pull-right">
			 		<%
			 			if(claimWORkFlowList.size()>0)
			 			{ 
			 		%>
				 		<div class="dropup"> 
						 	<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> Update Status <span class="caret"></span> </button>
							 <ul class="dropdown-menu" aria-labelledby="dropdownMenu2"> 
							 	
							 <% for(ClaimWorkflow claimWORkFlow :claimWORkFlowList)
							 	{ 
							 %>
							 	<li>
							 		
							 		<div id="openDiv" class="btn btn-link" id="reject_<%=claim.getClaimNo()%>" onclick="updateStatusFn('<%=claimWORkFlow.getNewStatus()%>');"><%=claimWORkFlow.getAction()%></div>
							 	</li> 
							 	<%
							 		}
							 	%>
							 </ul>
						 </div>
					 <%
						 }
					 %>
			 	</li>
			 	<li class="pull-left">
					<a class="btn btn-lg btn-xs-block btn-link text-muted" role="button" onclick="window.history.go(-1); return false;">
						<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
					</a>
				</li>
	 		</ul>
	 	</div>
	 </div>
	 
		
</div>
<div class="tab-pane fade" role="tabpane2" id="tab-2">
<div class="panel-group cover-type-group" id="accordion">
<% 
_log.info(claim.getClaimNo()+claim.getClaimHistory());
if(claim.getClaimHistory()!=null){
	List <ClaimHistory> claimHistory=claim.getClaimHistory();
	for (int i=0;i<claimHistory.size();i++){
		ClaimHistory clmHistory=claimHistory.get(i);
%>

	<div class="panel panel-default">
		<div class="panel-heading" role="tab">
			<h4 class="panel-title"> 
				<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" href="#accordion-" class="accordion-toggle collapsed">
					Staff User :<%=LanguageUtil.get(request, "claims_status_"+clmHistory.getStatus())%><br/>
					<%=clmHistory.getHisoryDate()%>
				</a>
			</h4>
		</div>
		<div class="panel-collapse collapse" id="accordion-" role="tabpanel">
			<div class="panel-body">
				<p><%=clmHistory.getReason()%> </p>
			</div>
		</div>
	</div>
<%
	}
}
%>
	
</div>
</div>
</div>
</div> 
<script>
document.getElementById('<portlet:namespace/>adminFile').onchange = function () {
	document.getElementById('selectedFile').value =  this.files.item(0).name; 
};
</script>

<aui:script>
	 function updateStatusFn(status) {
	   	var renderURL =Liferay.PortletURL.createActionURL();
	   	renderURL.setPortletId("<%=themeDisplay.getPortletDisplay().getId()%>");
	   	renderURL.setParameter("myview","details");
	   	renderURL.setParameter("claimRefNo","<%=claim.getClaimNo()%>");
	   	renderURL.setParameter("newStatus",status);
		renderURL.setParameter("policyNo","<%=claim.getPolicyNo()%>");
		renderURL.setParameter("policyProduct","<%=claim.getProduct()%>");
	   	renderURL.setName("updateStatus");

	   	console.log("renderUrL : "+renderURL);
			//openModal();
			//var url = $(this).attr('url');
			//alert(url);
			openUpdateModal();
			$("#submitBtn").attr('href', renderURL);
		
	
	}
		function openUpdateModal()
		{
			AUI().use('aui-modal', function(A) {
				var dialog = new A.Modal({
					title: "",
					bodyContent: $('#update_popup_body').html(),
					headerContent: '',
					centered: true,
					modal: true,
					resizable: false,
					width: 600,
					height: 300,
					render: '#update_popup_content'
				});						
				dialog.on('visibleChange', function(event) {
					if (!event.newVal) {
						//window.location = '/group/staff/manage_customer_service';
						$("#submitBtn").attr('href', '');
					}
				});
			});
		}
	</aui:script>
	
	<div id="update_popup_content"></div>
	<div id="update_popup_body" style="display:none;">
			<form method="post" >
				<div class="row">
					<div class="col-sm-12 col-xs-12 col-md-12 text-left">
						<h4 class="text-primary"><liferay-ui:message key="Claims Request Management"/></h4>
						<div class="form-group"> 
							<label class="control-label" for="formInput56"><liferay-ui:message key="Remarks"/></label>
								<aui:input type="Text" name="reason" label="" class="form-control" value="">
							</aui:input>
						</div>	
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<ul class="list-btns">
							<li>
								<a role="button" class="btn btn-primary btn-lg btn-xs-block" href="" id="submitBtn"><liferay-ui:message key="confirm" /></a>
							</li>
							<li>
								<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
							</li>
						</ul>		
					</div>				
				</div>
			</form>

	</div>
