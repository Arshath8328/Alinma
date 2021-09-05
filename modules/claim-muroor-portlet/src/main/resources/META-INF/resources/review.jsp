<%@page import="com.liferay.portal.kernel.exception.UserScreenNameException"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation"%>
<%@ include file="/init.jsp"%>

<portlet:actionURL var="submitMuroorClaim" name="submitMuroorClaim">
	<portlet:param name="myview" value="result"/>
</portlet:actionURL>

<%
	boolean isSignedIn=themeDisplay.isSignedIn();
	boolean tpFlag = (Boolean) request.getAttribute("TP_TYPE_FLAG");
	String email="";
	if(tpFlag)
	{
		email = (String) request.getAttribute("TP_MAIL");
	}
	else
	{
		if(isSignedIn==true){
			User  currentUser = PortalUtil.getUser(request);
			email=currentUser.getEmailAddress();
		}
		else{
			email="";
		}
	}
	
	SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	String claimDate = dateFormatter.format(new Date());
	
	String accidentLocation = (String) request.getAttribute("AccidentLocation");
	String accidentTime = (String) request.getAttribute("AccidentTime");
	String timeGroup = (String) request.getAttribute("TimeGroup");
	String accidentDate = (String) request.getAttribute("AccidentDate");
	String insurrCompany = (String) request.getAttribute("InsurrCompany");
	
	ODSClaimIntimation odsClaimInt = (ODSClaimIntimation) request.getAttribute("ClaimIntimationData");
	String mobile = (String) request.getAttribute("OD_MOBILE");
	String id = (String) request.getAttribute("OD_ID");
	String name = (String) request.getAttribute("OD_NAME");

%>

<portlet:actionURL name="applyAccidentInfo" var="applyAccidentInfo">
	<portlet:param name="isBack" value="true"/>
	<portlet:param name="myview" value="step3"/>
</portlet:actionURL>
<form id="accInfoBackForm" name="accInfoBackForm" role="form" action="<%=applyAccidentInfo %>" method="post">
	<input type="hidden" name="<portlet:namespace/>accidentTime" value="<%=accidentTime %>"/>
	<input type="hidden" name="<portlet:namespace/>accidentDate" value="<%=accidentDate %>"/>
	<input type="hidden" name="<portlet:namespace/>timeGroup" value="<%=timeGroup %>"/>
	<input type="hidden" name="<portlet:namespace/>tpFlag" value="<%=tpFlag %>"/>
</form>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary">Report a Claim</h3>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
				<span class="sr-only">100% Complete</span>
	</div>
</div>
	</div>
</div>

<div class="row">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<div class="row">
			<div class="col-sm-12 col-xs-12 col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<aui:form id="reviewTPLClaim" action="<%=submitMuroorClaim %>" method="post" enctype="multipart/form-data">
					<div class="row">
						<div class="col-sm-12 col-xs-12 col-md-12 col-lg-12">
							<div class="portlet-content">
							<%
								if(tpFlag)
								{
							%>
								<liferay-ui:error key="failed_submit" message="claim_intm_error" />
								<ul class="nav nav-pills nav-stacked nav-justified">
									<li>
										<a class="text-primary" href="#"><i class="icon icon-transport-1 md-36"></i> <liferay-ui:message key="drv_info"/></a>
									</li>
									<li>
										<a href="#"><i class="icon icon-transport md-36"></i><liferay-ui:message key="veh_acc_info"/> </a>
									</li>
									<li>
										<a href="#"><i class="icon icon-list md-36"></i><liferay-ui:message key="appr_accpt"/></a>
									</li>
								</ul>											 
							<%
								}
								else
								{
							%>	
									<ul class="nav nav-pills nav-stacked nav-justified">
										<li>
											<a class="text-primary" href="#"><i class="icon icon-transport md-36"></i> <liferay-ui:message key="acc_parts"/></a>
										</li>
										<li>
											<a href="#"><i class="icon icon-business-3 md-36"></i> <liferay-ui:message key="app_rev"/></a>
										</li>
									</ul>
							<%
								}
							%>											 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
							<liferay-ui:error key="invalid_iban" message="Ivalid IBAN" /> 
								<label class="control-label"><liferay-ui:message key="report_iban"/></label>
								<aui:input name="iban" id="iban" class="form-control" type="text" placeholder="SA 40395000XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" onchange="checkForConfirm();" label="">
									 <aui:validator errorMessage="IBAN not valid." name="custom">
							                function(val, fieldNode, ruleValue) {
							                        var regex = /^(SA)([0-9a-zA-Z]{22})$/;
							                        return regex.test(val);
							                }
							        </aui:validator>
							        <aui:validator name="required"/>
							        <aui:validator name="rangeLength" errorMessage="Please enter a valid IBAN">[24,24]</aui:validator>
								</aui:input>
								<small>*<liferay-ui:message key="mistake_resp"/></small>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<aui:input name="ibanConfirm" id="ibanConfirm" class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "confirm_veh_acc_num")%>"  onchange="checkForConfirm();" label="">
									<aui:validator name="equalTo"  errorMessage="IBAN not matching">'#<portlet:namespace />iban'</aui:validator>
									<aui:validator name="required" errorMessage="required_field_validator"/>
								</aui:input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="email"/></label>
								<%
									if(isSignedIn)
									{
								%>
										<aui:input type="text" id="email" name="email" label="" placeholder="mail@mymail.com" class="form-control" value="<%=email%>" readonly="<%=isSignedIn%>">
											<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="email" errorMessage="pls_enter_valid_email"/>
										</aui:input>
								<%
									}
									else
									{
								%>
										<aui:input type="text" id="email" name="email" label="" placeholder="mail@mymail.com" class="form-control" onchange="updateMail();" value="<%=email%>">
											<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="email" errorMessage="pls_enter_valid_email"/>
										</aui:input>
								<% 	} %>
							</div>
						</div>
					</div>
					<div class="row vcenter">
						<div class="col-xs-5 col-sm-6 col-md-6 col-lg-6">
							<h3 class="no-margin"><liferay-ui:message key="rev_appl"/></h3> 
						</div>
						<div class="text-right col-xs-7 col-sm-6 col-md-6 col-lg-6">
							<img src="/o/atmc-theme/images/logo.svg" height="40px" /> 
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<table class="table table-bordered ej-table align-left"> 
								<tbody> 
									<tr> 
										<td class="text-primary"><small class="text-muted"><liferay-ui:message key="name"/></small><br /><%=tpFlag?odsClaimInt.getTpdrivername():name %></td>
										<%
											if(tpFlag)
											{
										%> 
										<td class="text-primary"><small class="text-muted"><liferay-ui:message key="compensation_amount"/></small><br /><%=decimalFormat.format(odsClaimInt.getAmount())%> <liferay-ui:message key="sar"/></td>
										<%
											} 
										%> 
										<td class="text-primary"><small class="text-muted"><liferay-ui:message key="claims_plate_no"/></small><br /><%=(tpFlag)?odsClaimInt.getTpplateno():odsClaimInt.getVehidentivalue()%></td> 
										<td class="text-primary"><small class="text-muted"><liferay-ui:message key="claims_date"/></small><br /><%=claimDate%></td> 
									</tr>												 
								</tbody>
							</table>										 
						</div>
						<div class="col-sm-12 col-xs-12 col-md-12 col-lg-12">
							<h4><liferay-ui:message key="claims_claimant_details"/></h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message key="claims_id_number"/></th>
										<td><%=tpFlag?odsClaimInt.getTpid():id %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_claimant_name"/></th>
										<td><%=tpFlag?odsClaimInt.getTpdrivername():name %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_claimant_mobile"/></th>
										<td><%=(tpFlag)?odsClaimInt.getTpmobile():mobile %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_claimant_email"/></th>
										<td><span id="emailVal"></span><%=email%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_iban"/></th>
										<td><span id="ibanLabel" class="text-danger"><liferay-ui:message key="iban_not_correct"/></span></td>
									</tr>
								</tbody>
							</table>
							<h4><liferay-ui:message key="claims_details"/></h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message key="claims_policy_number"/></th>
										<td><%=odsClaimInt.getPolicyno() %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_policy_type"/></th>
										<td><liferay-ui:message key="<%=LanguageUtil.get(request, "claim_type_"+odsClaimInt.getTransaction())%>"/></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="type_damage"/></th>
										<td><%=LanguageUtil.get(request, "vehicle_type_" + odsClaimInt.getDamageflag())%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="city_acc_loc"/></th>
										<td><%=accidentLocation %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_accident_date"/></th>
										<td><%=accidentDate%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_accident_time"/></th>
										<td><%=accidentTime+" "+timeGroup%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_accident_surveyor"/></th>
										<td><liferay-ui:message key="<%=LanguageUtil.get(request, "claim_status_"+odsClaimInt.getReportmode())%>"/></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_percentage_of_responsibility"/></th>
										<td><%=odsClaimInt.getFaultpercent()+"%"%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_accident_desc"/></th>
										<td><%=odsClaimInt.getLossremarks() %></td>
									</tr>
								</tbody>
							</table>
<%
				if(tpFlag)
				{
%>
							<h4>OTHER PARTY DETAILS</h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message key="id_number"/></th>
										<td><%=id%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="driver_name"/></th>
										<td><%=name%></td> 
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_driver_mobile"/></th>
										<td><%=mobile %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="plate_no"/></th>
										<td><%=odsClaimInt.getVehidentivalue() %></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="ins_comp"/></th>
										<td><%=insurrCompany%></td>
									</tr>
								</tbody>
							</table>
<%
				}
%>
							<h4><liferay-ui:message key="sub_docs"/></h4>						
							<table class="table table-bordered">
								<tbody>
									<tr>
										<td width="40%" class="bg-gray"><liferay-ui:message key="drv_lic"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedDriverLicense" class="form-control" onclick="$('#<portlet:namespace/>driverLicenseFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="driverLicenseFile" id="driverLicenseFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="veh_reg"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedVehReg" class="form-control" onclick="$('#<portlet:namespace/>vehRegFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="vehRegFile" id="vehRegFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>vehRegFile");
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
					if(tpFlag)
					{
%>									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="photo_front"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedFrontPhoto" class="form-control" onclick="$('#<portlet:namespace/>frontPhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="frontPhotoFile" id="frontPhotoFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>frontPhotoFile");
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
									
									<tr>
									<td class="bg-gray"><liferay-ui:message key="photo_rear"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedRearPhoto" class="form-control" onclick="$('#<portlet:namespace/>rearPhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="rearPhotoFile" id="rearPhotoFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>rearPhotoFile");
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
									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="photo_right"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedRightSidePhoto" class="form-control" onclick="$('#<portlet:namespace/>rightSidePhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="rightSidePhotoFile" id="rightSidePhotoFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>rightSidePhotoFile");
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
									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="photo_left"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedLeftSidePhoto" class="form-control" onclick="$('#<portlet:namespace/>leftSidePhotoFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="leftSidePhotoFile" id="leftSidePhotoFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>leftSidePhotoFile");
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

									<tr>
										<td class="bg-gray"><liferay-ui:message key="iban_copy"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedIBAN" class="form-control" onclick="$('#<portlet:namespace/>ibanFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="ibanFile" id="ibanFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>ibanFile");
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
									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="owner_id"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedOwnerIdFile" class="form-control" onclick="$('#<portlet:namespace/>ownerIdFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="ownerIdFile" id="ownerIdFile" cssClass="sr-only" label="">
													 	<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
													 	<aui:validator name="custom" errorMessage="File size should not be more than 10Mb">
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>ownerIdFile");
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
					else
					{
%>									
									<tr>
										<td class="bg-gray"><liferay-ui:message key="policy_copy"/></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback"> 
													<input id="selectedPolicyFile" class="form-control" onclick="$('#<portlet:namespace/>policyFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
													<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="policyFile" id="policyFile" cssClass="sr-only" label="">
													 	<aui:validator name="acceptFiles">'jpg,jpeg,png,pdf'</aui:validator>
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
								                                           	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>policyFile");
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
%>
								</tbody>
							</table>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 col-sm-12 col-xs-12 col-lg-12">
							<button id="termsAndCondLink" onclick="termsAndCondFn()" class="btn btn-link text-muted no-pad"><span class="glyphicon glyphicon-list-alt"></span>   <liferay-ui:message key="t_c"/></button>
							<br>
							<div class="form-group">
								<label class="checkbox-inline">
									<input class="control-label" id="termsAndCons" type="checkbox" value="" onchange="agreeTerms();">  <liferay-ui:message key="ack_data_correct"/>        
								</label>
							</div>								 
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-right no-pad">
							<ul class="list-btns">
								<li>
									<button class="btn btn-lg text-muted btn-xs-block btn-link" type="button" onclick="$('#accInfoBackForm').submit();"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back"/> </button>
								</li>
								<li>
									<button class="btn btn-primary btn-lg btn-xs-block" type="submit" id="submitBtn" disabled><liferay-ui:message key="submit"/> </button>
								</li>
							</ul>
						</div>
					</div>
					
					<input type="hidden" name="<portlet:namespace/>accidentTime" value="<%=accidentTime %>"/>
					<input type="hidden" name="<portlet:namespace/>accidentDate" value="<%=accidentDate %>"/>
					<input type="hidden" name="<portlet:namespace/>timeGroup" value="<%=timeGroup %>"/>
					<input type="hidden" name="<portlet:namespace/>accidentLocation" value="<%=accidentLocation %>"/>
					<input type="hidden" name="<portlet:namespace/>name" value="<%=name %>"/>
					<input type="hidden" name="<portlet:namespace/>id" value="<%=id %>"/>
					<input type="hidden" name="<portlet:namespace/>mobile" value="<%=mobile %>"/>
					<%
						if(tpFlag)
						{
					%>
							<input type="hidden" name="<portlet:namespace/>insurrCompany" value="<%=insurrCompany %>"/>
					<%
						}
					%>
				</aui:form>
			</div>
		</div>					 
	</div>
</div>

<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div class="row margin-top">
		<div class="col-md-12">
			<p><liferay-ui:message key="terms_provs"/></p>
			<p><liferay-ui:message key="agree_grant_stud_claim"/></p>
			<p><liferay-ui:message key="agree_grant_prov_inf"/></p>
		</div>
	</div>
</div>

<script>

var flag=<%=tpFlag%>;

document.getElementById('<portlet:namespace/>driverLicenseFile').onchange = function () {
	document.getElementById('selectedDriverLicense').value =  this.files.item(0).name; 
};

document.getElementById('<portlet:namespace/>vehRegFile').onchange = function () {
	document.getElementById('selectedVehReg').value =  this.files.item(0).name; 
};
if(flag)
{
	document.getElementById('<portlet:namespace/>frontPhotoFile').onchange = function () {
		document.getElementById('selectedFrontPhoto').value =  this.files.item(0).name; 
	};
	
	document.getElementById('<portlet:namespace/>rearPhotoFile').onchange = function () {
		document.getElementById('selectedRearPhoto').value =  this.files.item(0).name; 
	};
	
	document.getElementById('<portlet:namespace/>rightSidePhotoFile').onchange = function () {
		document.getElementById('selectedRightSidePhoto').value =  this.files.item(0).name; 
	};
	
	document.getElementById('<portlet:namespace/>leftSidePhotoFile').onchange = function () {
		document.getElementById('selectedLeftSidePhoto').value =  this.files.item(0).name; 
	};
	
	document.getElementById('<portlet:namespace/>ibanFile').onchange = function () {
		document.getElementById('selectedIBAN').value =  this.files.item(0).name; 
	};
	
	document.getElementById('<portlet:namespace/>ownerIdFile').onchange = function () {
		document.getElementById('selectedOwnerIdFile').value =  this.files.item(0).name; 
	};
}
else
{
	document.getElementById('<portlet:namespace/>policyFile').onchange = function () {
		document.getElementById('selectedPolicyFile').value =  this.files.item(0).name; 
	};
}
var regex = /^(SA)([0-9a-zA-Z]{22})$/;
var mailRegex = /^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$/;

function checkForConfirm()
{
	if($('#<portlet:namespace/>iban').val()!="" && $('#<portlet:namespace/>ibanConfirm').val()!="" && regex.test($('#<portlet:namespace/>iban').val()) && regex.test($('#<portlet:namespace/>ibanConfirm').val()))
	{
		$('#ibanLabel').text($('#<portlet:namespace/>iban').val()).removeClass("text-danger");
	
		
	}else
	{
		$('#ibanLabel').text("IBAN not entered correctly above").addClass("text-danger");
	}
		
}

function updateMail()
{
	if($('#<portlet:namespace/>email').val()!="" && mailRegex.test($('#<portlet:namespace/>email').val()))
	{
		$('#emailVal').text($('#<portlet:namespace/>email').val());
	}
}

function agreeTerms(){
	if($('#termsAndCons').is(":checked")){
		$('#submitBtn').removeAttr('disabled');
	}
	else{
		$('#submitBtn').attr('disabled','true');
	}
}
</script>
<aui:script>
function termsAndCondFn()
{
	AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '<h3 class="no-margin"><liferay-ui:message key="t_c"/></h3>',
				centered: true,
				modal: true,
				width: 800,
				height: 400,
				render: '#aui_popup_content'
			});
			dialog.addToolbar(
			      [
			        {
			        	label: '<liferay-ui:message key="agree_t"/>',
			        	cssClass: 'btn-primary',
			        	on: {
			        		click: function() {
			        			window.parent.document.getElementById('termsAndCons').checked = true;
			        			window.parent.agreeTerms();
			        			dialog.hide();
			        		}
			        	}
			        },
			        {
			        	label: '<liferay-ui:message key="dont_agree"/>',
			        	cssClass: 'btn-default btn-outline',
			        	on: {
			        		click: function() {
			        			window.parent.document.getElementById('termsAndCons').checked = false;
			        			window.parent.agreeTerms();
			        			dialog.hide();
			        		}
			        	}
			        }
			      ]
			    );
		});	
}
</aui:script>