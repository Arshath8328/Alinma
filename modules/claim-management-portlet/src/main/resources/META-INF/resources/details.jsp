<%@page import="claim.management.portlet.ClaimManagementPortlet"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.claim.MuroorTPUploads"%>
<%@page import="com.atmc.bsl.db.domain.claim.MuroorODUploads"%>
<%@page import="java.util.List"%>
<%@page import="com.atmc.web.constants.ClaimIntimationPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.claim.Claim"%>
<%@ include file="/claimsmgmt/init.jsp"%>

<%
	String lang = themeDisplay.getLocale().toString();
	Claim claimDetails = (Claim) request.getAttribute("claimDetails");
	String product = (String) request.getAttribute("product");
	String reportType = (String) request.getAttribute("reportType");
	List<Object[]> najmUploadsFileNames = (List<Object[]>) request.getAttribute("najmUploadsFileNames");
	MuroorODUploads odMuroorUploads = (MuroorODUploads) request.getAttribute("OD_Muroor_Uploads");
	MuroorTPUploads tpMuroorUploads = (MuroorTPUploads) request.getAttribute("TP_Muroor_Uploads");
	
	PortletURL downloadURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadURL.setParameter("download", "true");
	downloadURL.setParameter("fileType", "mainReport");
	String downloadURLVal = downloadURL.toString(); 
	if(downloadURLVal.indexOf("&p_p_lifecycle=1") != -1)
		downloadURLVal = downloadURLVal.substring(0, downloadURLVal.lastIndexOf("&p_p_lifecycle=1"));
	
	PortletURL printURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	printURL.setParameter("download", "false");
	printURL.setParameter("fileType", "mainReport");
	String printURLVal = printURL.toString(); 
	if(printURLVal.indexOf("&p_p_lifecycle=1") != -1)
		printURLVal = printURLVal.substring(0, printURLVal.lastIndexOf("&p_p_lifecycle=1"));
%>

<div class="row margin-top">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad">
		<div class="headerBanner">
			<img class="img-responsive"
				src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
			<h3 class="text-primary pageTitle">
				<liferay-ui:message key="claims_application_details" />
			</h3>
			<div class="printDownloadsection">
				<a href="javascript:;" onclick="window.open('<%= printURLVal%>')"><i class="material-icons md-36">&#xE8AD;</i></a>&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%= downloadURLVal %>"><i class="material-icons md-36">&#xE415;</i></a>
			</div>
		</div>
	</div>
</div>
<div class="row vcenter pad-5">
	<div
		class="col-lg-offset-2 col-md-offset-2 col-md-4 col-lg-4 col-xs-6 col-sm-6">
		<h3>
			<liferay-ui:message key="claims_ref_number" />
			&nbsp;<span class="text-muted">${claimDetails.getClaimNo()}</span>
		</h3>
		<p>
			<liferay-ui:message key="${claimStatusKey}" />
		</p>
	</div>
	<div class="text-right col-xs-6 col-sm-6 col-md-4 col-lg-4">
		<img src="/o/atmc-theme/images/logo.svg" width="75%" />
	</div>
</div>
<div class="row">
	<div
		class="col-xs-12 col-sm-12 col-md-8 col-lg-8 col-lg-offset-2 col-md-offset-2">
		<table class="table table-bordered">
			<tbody>
				<tr>
					<td class="text-primary"><small class="text-muted"><liferay-ui:message
								key="claims_name" /></small><br />${claimDetails.getClaimAntName()}</td>
					<td class="text-primary"><small class="text-muted"><liferay-ui:message
								key="claims_amount_of_compensation" /></small><br /> <fmt:formatNumber
							type="number" maxFractionDigits="2"
							value="${claimDetails.getClaimAmount()}" /> SAR</td>
					<td class="text-primary"><small class="text-muted"><liferay-ui:message
								key="claims_plate_no" /></small><br />${claimDetails.getEnPlateNo()}
						${claimDetails.getEnPlateL1()} ${claimDetails.getEnPlateL2()}
						${claimDetails.getEnPlateL3()}</td>
					<td class="text-primary"><small class="text-muted"><liferay-ui:message
								key="claims_date" /></small><br /> <fmt:formatDate
							pattern="dd/MM/yyyy" value="${claimDetails.getClaimIntmDate()}" /></td>
				</tr>
			</tbody>
		</table>
	</div>
	<div
		class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
		<div class="portlet-content">
			<h4>
				<liferay-ui:message key="claims_claimant_details" />
			</h4>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th width="50%" class="bg-gray"><liferay-ui:message
								key="claims_id_number" /></th>
						<td>${claimDetails.getIqamaId()}</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_claimant_name" /></th>
						<td>${claimDetails.getClaimAntName()}</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_claimant_mobile" /></th>
						<td>${claimDetails.getClaimAntPhone()}</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_claimant_email" /></th>
						<td>${user.getEmailAddress()}</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message key="claims_iban" /></th>
						<td>${claimDetails.getIban()}</td>
					</tr>
				</tbody>
			</table>
			<h4>
				<liferay-ui:message key="claims_details" />
			</h4>
			<table class="table table-bordered">
				<tbody>
					<tr>
						<th width="50%" class="bg-gray"><liferay-ui:message
								key="claims_policy_number" /></th>
						<td>${claimDetails.getPolicyNo()}</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_policy_type" /></th>
						<c:choose>
							<c:when test="<%=lang.equals("en_US")%>">
								<td>${productDescEn }</td>
							</c:when>
							<c:otherwise>
								<td>${productDescAr }</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message key="claims_city" />
							/ <liferay-ui:message key="claims_accident_location" /></th>
						<c:choose>
							<c:when test="<%=lang.equals("en_US")%>">
								<td>${claimDetails.getLossLocation()}</td>
							</c:when>
							<c:otherwise>
								<td>${claimDetails.getLossLocationAr()}</td>
							</c:otherwise>
						</c:choose>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_accident_date" /></th>
						<td><fmt:formatDate pattern="dd/MM/yyyy"
								value="${claimDetails.getClaimLossDate()}" /></td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_accident_time" /></th>
						<td><fmt:formatDate pattern="hh:mm a"
								value="${claimDetails.getClaimLossDate()}" /></td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_accident_surveyor" /></th>
						<c:choose>
							<c:when test="${claimDetails.getReportType() == '03'}">
								<td><liferay-ui:message key="claims_najm" /></td>
							</c:when>
							<c:when test="${claimDetails.getReportType() == '01'}">
								<td><liferay-ui:message key="claims_muroor" /></td>
							</c:when>
							<c:otherwise>
								<td></td>
							</c:otherwise>
						</c:choose>

					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_percentage_of_responsibility" /></th>
						<td>${claimDetails.getFaultPercent()}%</td>
					</tr>
					<tr>
						<th class="bg-gray"><liferay-ui:message
								key="claims_accident_desc" /></th>
						<td>${claimDetails.getLossRemarks()}</td>
					</tr>
				</tbody>
			</table>

			<c:if test="${product == '13102'}">
				<h4>
					<liferay-ui:message key="claims_third_party_details" />
				</h4>
				<table class="table table-bordered">
					<tbody>
						<tr>
							<th width="50%" class="bg-gray"><liferay-ui:message
									key="claims_id_number" /></th>
							<td>${claimDetails.getTpID()}</td>
						</tr>
						<tr>
							<th class="bg-gray"><liferay-ui:message
									key="claims_driver_name" /></th>
							<td>${claimDetails.getTpDriverName()}</td>
						</tr>
						<tr>
							<th class="bg-gray"><liferay-ui:message
									key="claims_driver_mobile" /></th>
							<td>${claimDetails.getTpMobileNo()}</td>
						</tr>
						<tr>
							<th class="bg-gray"><liferay-ui:message
									key="claims_plate_no" /></th>
							<td>${claimDetails.getTpPlateNo()}
								${claimDetails.getTpPlateL1()} ${claimDetails.getTpPlateL2()}
								${claimDetails.getTpPlateL3()}</td>
						</tr>
						<tr>
							<th class="bg-gray"><liferay-ui:message
									key="claims_insurance_company" /></th>
							<td></td>
						</tr>
					</tbody>
				</table>

			</c:if>

			<h4>
				<liferay-ui:message key="claims_submitted_docs" />
			</h4>
	
			<portlet:actionURL var="submitExtraNajmFileAction" name="submitExtraNajmFile">
				<portlet:param name="myview" value="details"/>
				<portlet:param name="claimNumber" value="<%=claimDetails.getClaimNo() %>"/>
				<portlet:param name="policyNumber" value="<%=claimDetails.getPolicyNo()%>"/>
				<portlet:param name="productDescAr" value="<%=claimDetails.getProductDescAr()%>"/>
				<portlet:param name="productDescEn" value="<%=claimDetails.getProductDescEn()%>"/>
				<portlet:param name="product" value="<%=claimDetails.getProduct()%>"/>
				<portlet:param name="reportType" value="<%=claimDetails.getReportType() %>"/>
			</portlet:actionURL>
			<aui:form action="<%= submitExtraNajmFileAction %>" method="post" enctype="multipart/form-data" id="uploadForm" name="uploadForm" cssClass="form-inline" label="">
			
			<table class="table table-bordered">
				<tbody>
					<%
						if (claimDetails.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
							if (product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					%>
					<%
								if((odMuroorUploads.getDriverLicenseName()==null || odMuroorUploads.getDriverLicenseName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
								{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="drv_lic"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedDriverLicense" class="form-control" onclick="$('#<portlet:namespace/>driverLicenseFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="driverLicenseFile" id="driverLicenseFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>driverLicenseFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
                        	var fileInput = document.getElementById("<portlet:namespace/>driverLicenseFile");
							var fileName = "";
								if(fileInput.files.length>0)
									fileName = fileInput.files.item(0).name;
							var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
							return regex.test(fileName);
						}
                   	 </aui:validator>
				                        
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(odMuroorUploads.getDriverLicenseName()!=null && !(odMuroorUploads.getDriverLicenseName().equals("")))
						{
					%>		
					<tr>
						<portlet:resourceURL var="driverLicenseURL">
							<portlet:param name="fileType" value="driverLicense" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=odMuroorUploads.getDriverLicenseName()%><a
							href="<%=driverLicenseURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((odMuroorUploads.getVehRegistName()== null || odMuroorUploads.getVehRegistName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="veh_reg"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedVehReg" class="form-control" onclick="$('#<portlet:namespace/>vehRegFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="vehRegFile" id="vehRegFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>vehRegFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(odMuroorUploads.getVehRegistName()!= null && !(odMuroorUploads.getVehRegistName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="vehRegistURL">
							<portlet:param name="fileType" value="vehRegist" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=odMuroorUploads.getVehRegistName()%><a
							href="<%=vehRegistURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((odMuroorUploads.getPolicyCopyName()== null || odMuroorUploads.getPolicyCopyName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="policy_copy"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedPolicyFile" class="form-control" onclick="$('#<portlet:namespace/>policyFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="policyFile" id="policyFile" cssClass="sr-only" label="">
									 	<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
									 	<aui:validator name="required" errorMessage="required_field_validator" />
									 	<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>policyFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(odMuroorUploads.getPolicyCopyName()!= null && !(odMuroorUploads.getPolicyCopyName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="policyCopyURL">
							<portlet:param name="fileType" value="policyCopy" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=odMuroorUploads.getPolicyCopyName()%><a
							href="<%=policyCopyURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((odMuroorUploads.getDriverLicenseName()==null || odMuroorUploads.getVehRegistName()==null || odMuroorUploads.getPolicyCopyName()== null) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){
					%>
					<tr>
						<td>
							<input class="btn btn-default" type="submit" id="<portlet:namespace/>uploadBtn" name="<portlet:namespace/>uploadBtn" value="<%=LanguageUtil.get(request,"UploadExtraDocument")%>" />
						</td>
					</tr>
			<%
					}
			
				} else if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
						if (tpMuroorUploads != null) {
			%>
				<%
						if((tpMuroorUploads.getDriverLicenseName()==null || tpMuroorUploads.getDriverLicenseName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
				%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="drv_lic"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedDriverLic" class="form-control" onclick="$('#<portlet:namespace/>driverLicFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="driverLicFile" id="driverLicFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>driverLicFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getDriverLicenseName()!=null && !(tpMuroorUploads.getDriverLicenseName().equals("")))
						{
					%>		
					<tr>
						<portlet:resourceURL var="driverLicURL">
							<portlet:param name="fileType" value="driverLic" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getDriverLicenseName()%><a
							href="<%=driverLicURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getVehRegistName()==null || tpMuroorUploads.getVehRegistName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
						<tr>
						<td>
							<div>
								<div><liferay-ui:message key="veh_reg"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedVehRegst" class="form-control" onclick="$('#<portlet:namespace/>vehRegstFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="vehRegstFile" id="vehRegstFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>vehRegstFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getVehRegistName()!=null && !(tpMuroorUploads.getVehRegistName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="vehRegstURL">
							<portlet:param name="fileType" value="vehRegst" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getVehRegistName()%><a
							href="<%=vehRegstURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getFrontPhotoName()==null || tpMuroorUploads.getFrontPhotoName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="photo_front"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedFrontPhoto" class="form-control" onclick="$('#<portlet:namespace/>frontPhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="frontPhotoFile" id="frontPhotoFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>frontPhotoFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getFrontPhotoName()!=null && !(tpMuroorUploads.getFrontPhotoName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="frontPhotoURL">
							<portlet:param name="fileType" value="frontPhoto" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getFrontPhotoName()%><a
							href="<%=frontPhotoURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getRearPhotoName()==null || tpMuroorUploads.getRearPhotoName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="photo_rear"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedRearPhoto" class="form-control" onclick="$('#<portlet:namespace/>rearPhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="rearPhotoFile" id="rearPhotoFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>rearPhotoFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getRearPhotoName()!=null && !(tpMuroorUploads.getRearPhotoName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="rearPhotoURL">
							<portlet:param name="fileType" value="rearPhoto" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getRearPhotoName()%><a
							href="<%=rearPhotoURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getRightSidePhotoName()==null || tpMuroorUploads.getRightSidePhotoName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
					<td>
						<div>
							<div><liferay-ui:message key="photo_right"/></div>
							<div class="form-group has-feedback"> 
								<input id="selectedRightSidePhoto" class="form-control" onclick="$('#<portlet:namespace/>rightSidePhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
								<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
								<aui:input type="file" name="rightSidePhotoFile" id="rightSidePhotoFile" cssClass="sr-only" label="">
									<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
									<aui:validator name="required" errorMessage="required_field_validator" />
									<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
			                            function(val,node,junction){
				                            var uploadSize=true;
											var size=0;
											var fileInput = document.getElementById("<portlet:namespace/>rightSidePhotoFile");
											for(var num1=0;num1<fileInput.files.length;num1++)
											{
											      var file=fileInput.files[num1];
											       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getRightSidePhotoName()!=null && !(tpMuroorUploads.getRightSidePhotoName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="rightSidePhotoURL">
							<portlet:param name="fileType" value="rightSidePhoto" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getRightSidePhotoName()%><a
							href="<%=rightSidePhotoURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getLeftSidePhotoName()==null || tpMuroorUploads.getLeftSidePhotoName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="photo_left"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedLeftSidePhoto" class="form-control" onclick="$('#<portlet:namespace/>leftSidePhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="leftSidePhotoFile" id="leftSidePhotoFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>leftSidePhotoFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getLeftSidePhotoName()!=null && !(tpMuroorUploads.getLeftSidePhotoName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="leftSidePhotoURL">
							<portlet:param name="fileType" value="leftSidePhoto" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getLeftSidePhotoName()%><a
							href="<%=leftSidePhotoURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getBankIbanName()==null || tpMuroorUploads.getBankIbanName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="iban_copy"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedIBAN" class="form-control" onclick="$('#<portlet:namespace/>ibanFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="ibanFile" id="ibanFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator" />
										<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>ibanFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getBankIbanName()!=null && !(tpMuroorUploads.getBankIbanName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="bankIbanURL">
							<portlet:param name="fileType" value="bankIban" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getBankIbanName()%><a
							href="<%=bankIbanURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						if((tpMuroorUploads.getOwnerIdName()== null || tpMuroorUploads.getOwnerIdName().equals("")) && claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS))
						{
					%>
					<tr>
						<td>
							<div>
								<div><liferay-ui:message key="owner_id"/></div>
								<div class="form-group has-feedback"> 
									<input id="selectedTPOwnerIdFile" class="form-control" onclick="$('#<portlet:namespace/>ownerIdTPFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="ownerIdTPFile" id="ownerIdTPFile" cssClass="sr-only" label="">
									 	<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
									 	<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>ownerIdTPFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%
						}
						else if(tpMuroorUploads.getOwnerIdName()!= null && !(tpMuroorUploads.getOwnerIdName().equals("")))
						{
					%>
					<tr>
						<portlet:resourceURL var="ownerIdURL">
							<portlet:param name="fileType" value="ownerId" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=tpMuroorUploads.getOwnerIdName()%><a
							href="<%=ownerIdURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
						
						if((tpMuroorUploads.getDriverLicenseName()==null || tpMuroorUploads.getVehRegistName()==null || tpMuroorUploads.getFrontPhotoName()== null || tpMuroorUploads.getRearPhotoName()== null
								|| tpMuroorUploads.getRightSidePhotoName()==null || tpMuroorUploads.getLeftSidePhotoName() ==null || tpMuroorUploads.getBankIbanName() == null || tpMuroorUploads.getOwnerIdName() ==null) 
								&& claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){
					%>
					<tr>
						<td>
							<input class="btn btn-default" type="submit" id="<portlet:namespace/>uploadBtn" name="<portlet:namespace/>uploadBtn" value="<%=LanguageUtil.get(request,"UploadExtraDocument")%>" />
						</td>
					</tr>
					
					<%			
					}
					%>
					
					<%
						}
							}
						} else if (claimDetails.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM) && najmUploadsFileNames!=null) {
							if ((najmUploadsFileNames.get(0)[0] == null||najmUploadsFileNames.get(0)[0].equals("") )&&  claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)) {
					%>
					<tr>
						<td>
							<div >
								<div class="form-group has-feedback">
									<input id="selectedNajmSlipFile" class="form-control"
										onclick="$('#<portlet:namespace/>najmSlipFile').click();"
										placeholder="<liferay-ui:message key="select_file"/>"/> <span
										class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="najmSlipFile" id="najmSlipFile"
										cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
										<aui:validator name="required"
											errorMessage="required_field_validator" />
										<aui:validator name="custom"
											errorMessage="File size should not be more than 5Mb">
					                            function(val,node,junction){
						                            var uploadSize=true;
													var size=0;
													var fileInput = document.getElementById("<portlet:namespace />najmSlipFile");
													for(var num1=0;num1<fileInput.files.length
												;num1++)
													{
													      var
												file=fileInput.files[num1]; if(file.size>10485760)
											{ uploadSize=false; } else { uploadSize=true; }
											size+=file.size; } if(uploadSize==true){ return true; }else{
											return false; } } 
										</aui:validator>
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					
					
					<%
						} else {
					%>
					<tr>
						<portlet:resourceURL var="downNajmSlipURL">
							<portlet:param name="fileType" value="najmSlip" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=najmUploadsFileNames.get(0)[0]%><a
							href="<%=downNajmSlipURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
						}
					%>
					<%
						if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
							if ((najmUploadsFileNames.get(0)[1] == null || najmUploadsFileNames.get(0)[1].equals("")) &&  claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){
					%>
					<tr>
						<td>
							<div>
								<div class="form-group has-feedback"> 
									<input id="selectedDamageEstQuotFile" class="form-control" onclick="$('#<portlet:namespace/>damageEstQuotFile').click();" placeholder="<liferay-ui:message key="select_file"/>"/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="damageEstQuotFile" id="damageEstQuotFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="custom" errorMessage="File size should not be more than 5Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>damageEstQuotFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<% } else { %>
					<tr>
						<portlet:resourceURL var="downDamageEstURL">
							<portlet:param name="fileType" value="damageEst" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=najmUploadsFileNames.get(0)[1]%><a
							href="<%=downDamageEstURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					
					<%} if ((najmUploadsFileNames.get(0)[2] == null || najmUploadsFileNames.get(0)[2].equals("") )&&  claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){%>
					<tr>
						<td>
							<div >
								<div class="form-group has-feedback"> 
									<input id="selectedBankIbanFile" class="form-control" onclick="$('#<portlet:namespace/>bankIbanFile').click();" placeholder="<liferay-ui:message key="select_file"/>"/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="bankIbanFile" id="bankIbanFile" cssClass="sr-only" label="">
										<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
										<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="custom" errorMessage="File size should not be more than 5Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>bankIbanFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%} else { %>
					<tr>
						<portlet:resourceURL var="downBankIbanURL">
							<portlet:param name="fileType" value="bankIban" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=najmUploadsFileNames.get(0)[2]%><a
							href="<%=downBankIbanURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					
					
					<%}if ((najmUploadsFileNames.get(0)[3] == null || najmUploadsFileNames.get(0)[3].equals("")) &&  claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){ %>
					<tr>
						<td>
							<div >
								<div class="form-group has-feedback"> 
									<input id="selectedOwnerIdFile" class="form-control" onclick="$('#<portlet:namespace/>ownerIdFile').click();" placeholder="<liferay-ui:message key="select_file"/>"/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
									<aui:input type="file" name="ownerIdFile" id="ownerIdFile" cssClass="sr-only" label="">
									 	<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
									 	<aui:validator name="custom" errorMessage="File size should not be more than 5Mb">
				                            function(val,node,junction){
					                            var uploadSize=true;
												var size=0;
												var fileInput = document.getElementById("<portlet:namespace/>ownerIdFile");
												for(var num1=0;num1<fileInput.files.length;num1++)
												{
												      var file=fileInput.files[num1];
												       if(file.size>10485760)
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
									</aui:input>
								</div>
							</div>
						</td>
					</tr>
					<%}else {%>
					<tr>
						<portlet:resourceURL var="downOwnerIdURL">
							<portlet:param name="fileType" value="ownerId" />
						</portlet:resourceURL>
						<td class="bg-gray"><%=najmUploadsFileNames.get(0)[3]%><a
							href="<%=downOwnerIdURL%>"><span
								class="glyphicon glyphicon-download-alt pull-right"></span></a></td>
					</tr>
					<%
					}
					if((najmUploadsFileNames.get(0)[0] != null || najmUploadsFileNames.get(0)[1] != null || najmUploadsFileNames.get(0)[2] != null ||najmUploadsFileNames.get(0)[3] != null)&& claimDetails.getWorkflowStatus().equals(ClaimManagementPortlet.MISSING_DOCS_STATUS)){
					%>
					<input class="btn btn-default" type="submit" id="<portlet:namespace/>uploadBtn" name="<portlet:namespace/>uploadBtn"  value="UploadExtraDocument" />
					
					<%
					}
						}
						}
					%>
				</tbody>
			</table>
			</aui:form>
		</div>
	</div>
</div>
<aui:script>
var flag= '<%=product%>';
var reportType = '<%=reportType%>';

if(reportType == '<%=ClaimIntimationPortletKeys.REPORT_MODE_MUROOR%>')
{
	if(flag=='<%=ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE%>')
	{
		$('#<portlet:namespace/>driverLicenseFile').change(function () {
			$('#selectedDriverLicense').val(this.files.item(0).name); 
		});

		$('#<portlet:namespace/>vehRegFile').change(function () {
			$('#selectedVehReg').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>policyFile').change(function () {
			$('#selectedPolicyFile').val(this.files.item(0).name); 
		});
	}
	else if(flag=='<%=ClaimIntimationPortletKeys.PRODUCT_TPL%>')
	{
		$('#<portlet:namespace/>driverLicFile').change(function () {
			$('#selectedDriverLic').val(this.files.item(0).name); 
		});

		$('#<portlet:namespace/>vehRegstFile').change(function () {
			$('#selectedVehRegst').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>frontPhotoFile').change(function () {
			$('#selectedFrontPhoto').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>rearPhotoFile').change(function () {
			$('#selectedRearPhoto').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>rightSidePhotoFile').change(function () {
			$('#selectedRightSidePhoto').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>leftSidePhotoFile').change(function () {
			$('#selectedLeftSidePhoto').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>ibanFile').change(function () {
			$('#selectedIBAN').val(this.files.item(0).name); 
		});
		
		$('#<portlet:namespace/>ownerIdTPFile').change (function () {
			$('#selectedTPOwnerIdFile').val(this.files.item(0).name); 
		});
	}
}
else if(reportType == '<%=ClaimIntimationPortletKeys.REPORT_MODE_NAJM%>')
{
	$('#<portlet:namespace/>najmSlipFile').change(function () {
		$('#selectedNajmSlipFile').val(this.files.item(0).name); 
	});
	if(flag=='<%=ClaimIntimationPortletKeys.PRODUCT_TPL%>'){
		$('#<portlet:namespace/>damageEstQuotFile').change ( function () {
			$('#selectedDamageEstQuotFile').val(this.files.item(0).name); 
		});
		$('#<portlet:namespace/>bankIbanFile').change ( function () {
			$('#selectedBankIbanFile').val(this.files.item(0).name); 
		});
		$('#<portlet:namespace/>ownerIdFile').change ( function () {
			$('#selectedOwnerIdFile').val(this.files.item(0).name); 
		});
	}
}
</aui:script>