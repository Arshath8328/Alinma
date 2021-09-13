<%@page import="com.atmc.web.constants.ClaimIntimationPortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.atmc.bsl.db.domain.claim.NajmClaim"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp"%>

<%
	boolean isSignedIn = themeDisplay.isSignedIn();
	String email = "";
	if (isSignedIn == true) {
		User currentUser = PortalUtil.getUser(request);
		email = currentUser.getEmailAddress();
	} else {
		email = "";
	}

	NajmClaim najmClaim = (NajmClaim) request.getAttribute("najmClaimObj");
	ODSClaimIntimation odsClaimInt = (ODSClaimIntimation) request.getAttribute("odsClaimIntObj");

	String policyTypeFlag = (String) request.getAttribute("policyTypeFlag");
	String currLocale = themeDisplay.getLocale().toString();
%>

<portlet:actionURL var="najmClmSub" name="submitNajm">
	<portlet:param name="myview" value="result" />
</portlet:actionURL>
<portlet:renderURL var="termsAndCondUrl"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="myview" value="termsAndCond" />
</portlet:renderURL>

<portlet:actionURL name="backToLanding" var="backToLanding">
	<portlet:param name="isBack" value="true" />
</portlet:actionURL>
<form id="landingBackForm" name="landingBackForm" role="form"
	action="<%=backToLanding%>" method="post">
	<input type="hidden" name="<portlet:namespace/>odsClmIntm" value="" />
</form>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary">
			<liferay-ui:message key="report_claim" />
		</h3>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive"
			src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<div class="row">
			<div
				class="col-sm-12 col-xs-12 col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
				<aui:form action="<%=najmClmSub%>" method="post"
					enctype="multipart/form-data">
					<div class="row">
						<liferay-ui:error key="failed_submit" message="claim_intm_error" />
						<div class="col-sm-12 col-xs-12 col-md-12 col-lg-12">
							<div class="portlet-content">
								<ul class="nav nav-pills nav-stacked nav-justified">
									<li><a class="text-primary" href="#"><i
											class="icon icon-business-3  md-36"></i> <liferay-ui:message
												key="app_rev" /></a></li>
									<li class="disabled"><a href="#"><i
											class="icon icon-list md-36"></i> <liferay-ui:message
												key="appr_accpt" /></a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<liferay-ui:error key="invalid_iban" message="Ivalid IBAN" />
								<label class="control-label"><liferay-ui:message
										key="veh_acc_no" /></label>
								<aui:input name="iban" label="" id="iban" class="form-control"
									type="text" placeholder="SA4050 XXXXXX XXXXXX XXXXXXXX"
									onchange="checkForConfirm();">
									<aui:validator errorMessage="IBAN not valid." name="custom">
							                function(val, fieldNode, ruleValue) {
							                        var regex = /^(SA)([0-9a-zA-Z]{22})$/;
							                        return regex.test(val);
							                }
							        </aui:validator>
									<aui:validator name="required"
										errorMessage="required_field_validator" />
								</aui:input>
								<small>*<liferay-ui:message key="mistake_resp" /></small>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<aui:input name="ibanConfirm" label="" id="ibanConfirm"
									class="form-control" type="text" onpaste="return false;"
									placeholder="confirm_veh_acc_num" onchange="checkForConfirm();">
									<aui:validator name="equalTo" errorMessage="IBAN not Matching">'#<portlet:namespace />iban'</aui:validator>
									<aui:validator name="required"
										errorMessage="required_field_validator" />
								</aui:input>
							</div>
						</div>
					</div>

					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message
										key="email" /></label>
								<aui:input type="text" name="email" label=""
									placeholder="mail@mymail.com" class="form-control"
									value="<%=email%>" disabled="<%=isSignedIn%>">
									<aui:validator name="required"
										errorMessage="required_field_validator" />
									<aui:validator name="email"
										errorMessage="pls_enter_valid_email" />
								</aui:input>
							</div>
						</div>
					</div>
					<div class="row vcenter">
						<div class="col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<h3>
								<liferay-ui:message key="rev_appl" />
							</h3>
						</div>
						<div class="text-right col-xs-6 col-sm-6 col-md-6 col-lg-6">
							<img src="/o/atmc-theme/images/logo.svg" width="75%" />
						</div>
					</div>
					<div class="row">
						<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
							<table class="table table-bordered">
								<tbody>
									<tr>
										<td width="40%" class="text-primary"><small
											class="text-muted"><liferay-ui:message key="name" /></small><br /><%=najmClaim.getName()%></td>
										<td class="text-primary"><small class="text-muted"><liferay-ui:message
													key="compensation_amount" /></small><br /><%=najmClaim.getLiabiltiyAmt()%>
											SAR</td>
										<%
											String plateNumber = "";
												if (policyTypeFlag.equals(ClaimIntimationPortletKeys.TRX_TPL))
													plateNumber = odsClaimInt.getTpplateno();
												else
													plateNumber = odsClaimInt.getVehidentivalue();
										%>
										<td class="text-primary"><small class="text-muted"><liferay-ui:message
													key="claims_plate_no" /></small><br /><%=plateNumber%></td>
										<%
											SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
										%>
										<td class="text-primary"><small class="text-muted"><liferay-ui:message
													key="claims_date" /></small><br /><%=dmyDateFormatter.format(new Date())%></td>
									</tr>
								</tbody>
							</table>
						</div>
						<div class="col-sm-12 col-xs-12 col-md-12 col-lg-12">
							<h4>
								<liferay-ui:message key="claims_claimant_details" />
							</h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message
												key="claims_id_number" /></th>
										<td><%=najmClaim.getCipiId()%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message
												key="claims_claimant_mobile" /></th>
										<td><%=najmClaim.getPhoneNo()%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="claims_iban" /></th>
										<td><span id="ibanLabel" class="text-danger"><liferay-ui:message
													key="iban_not_correct" /></span></td>
									</tr>
								</tbody>
							</table>
							<h4>
								<liferay-ui:message key="claims_details" />
							</h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message
												key="claims_policy_number" /></th>
										<td><%=odsClaimInt.getPolicyno()%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message
												key="claims_policy_type" /></th>
										<td><liferay-ui:message
												key="<%=LanguageUtil.get(request, "claim_type_" + odsClaimInt.getTransaction())%>" /></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="type_damage" /></th>
										<%
											System.out.println(odsClaimInt.getDamageflag());
										%>
										<td><liferay-ui:message
												key="<%=LanguageUtil.get(request, "vehicle_type_" + odsClaimInt.getDamageflag())%>" /></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message
												key="city_acc_loc" /></th>
										<td><%=currLocale.equals("en_US") ? najmClaim.getCityDesEN() : najmClaim.getCityDesAr()%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="acc_date" /></th>
										<%
											SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy hhmm");
												Date accDate = sdf.parse(najmClaim.getCallDt());
										%>
										<td><fmt:formatDate pattern="dd/MM/yyyy"
												value="<%=accDate%>" /></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="acc_time" /></th>
										<td><fmt:formatDate pattern="hh:mm a"
												value="<%=accDate%>" /></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="acc_surv" /></th>
										<td><liferay-ui:message
												key="<%=LanguageUtil.get(request, "claim_status_" + odsClaimInt.getReportmode())%>" /></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="perc_resp" /></th>
										<td><%=najmClaim.getLiabiltiyPerc()%>%</td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="acc_desc" /></th>
										<td><%=currLocale.equals("en_US") ? najmClaim.getCauseEn() : najmClaim.getCauseEn()%></td>
									</tr>
								</tbody>
							</table>
							<%
								if (policyTypeFlag.equals(ClaimIntimationPortletKeys.TRX_TPL)) {
							%>
							<h4>
								<liferay-ui:message key="other_party_details" />
							</h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<th width="40%" class="bg-gray"><liferay-ui:message
												key="id_number" /></th>
										<td>${najmClaimTPObj.getCipiId()}</td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="driver_name" /></th>
										<td>${najmClaimTPObj.getName()}</td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message
												key="claims_driver_mobile" /></th>
										<td>${najmClaimTPObj.getPhoneNo()}</td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="plate_no" /></th>
										<td><%=odsClaimInt.getVehidentivalue()%></td>
									</tr>
									<tr>
										<th class="bg-gray"><liferay-ui:message key="ins_comp" /></th>
										<td>${najmClaimTPObj.getInsComp()}</td>
									</tr>
								</tbody>
							</table>
							<%
								}
							%>
							<h4>
								<liferay-ui:message key="sub_docs" />
							</h4>
							<table class="table table-bordered">
								<tbody>
									<tr>
										<td class="bg-gray" width="40%"><liferay-ui:message
												key="najm_slip" /></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback">
													<input id="selectedNajmSlipFile" class="form-control"
														onclick="$('#<portlet:namespace/>najmSlipFile').click();"
														placeholder='<liferay-ui:message key="select_file"/>'>
													<span
														class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="najmSlipFile"
														id="najmSlipFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
														<aui:validator name="custom"
															errorMessage="max_upload_size">
									                            function(val,node,junction){
										                        var uploadSize=true;
																var size=0;
																var fileInput = document.getElementById("<portlet:namespace />najmSlipFile");
																for(var num1=0;num1<fileInput.files.length;num1++)
																{
																	var file=fileInput.files[num1]; 
																	if(file.size>2097152)
																	{ 
																		uploadSize=false; 
																	} else { 
																		uploadSize=true; 
																	}
																	size+=file.size; 
																} if(uploadSize==true){ 
																	return true;
																} else{ 
																	return false; 
																}
															} 
														</aui:validator>
														                   	 <aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
                        function(val,node,junction){
                        	var fileInput = document.getElementById("<portlet:namespace/>najmSlipFile");
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
										if (policyTypeFlag.equals(ClaimIntimationPortletKeys.TRX_TPL)) {
									%>
									<tr>
										<td class="bg-gray"><liferay-ui:message
												key="damage_ests_quots" /></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback">
													<input id="selectedDamageEstQuotFile" class="form-control"
														onclick="$('#<portlet:namespace/>damageEstQuotFile').click();"
														placeholder='<liferay-ui:message key="select_file"/>'>
													<span
														class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="damageEstQuotFile"
														id="damageEstQuotFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
														<aui:validator name="custom"
															errorMessage="max_upload_size">
									                            function(val,node,junction){
										                            var uploadSize=true;
																	var size=0;
																	var fileInput = document.getElementById("<portlet:namespace />damageEstQuotFile");
																	for(var num1=0;num1<fileInput.files.length
																;num1++)
																	{
																	      var
																file=fileInput.files[num1]; if(file.size>2097152)
															{ uploadSize=false; } else { uploadSize=true; }
															size+=file.size; } if(uploadSize==true){ return true;
															}else{ return false; } } 
														</aui:validator>
													</aui:input>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td class="bg-gray"><liferay-ui:message key="iban_copy" /></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback">
													<input id="selectedBankIbanFile" class="form-control"
														onclick="$('#<portlet:namespace/>bankIbanFile').click();"
														placeholder='<liferay-ui:message key="select_file"/>'>
													<span
														class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="bankIbanFile"
														id="bankIbanFile" cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
														<aui:validator name="custom"
															errorMessage="max_upload_size">
									                            function(val,node,junction){
										                            var uploadSize=true;
																	var size=0;
																	var fileInput = document.getElementById("<portlet:namespace />bankIbanFile");
																	for(var num1=0;num1<fileInput.files.length
																;num1++)
																	{
																	      var
																file=fileInput.files[num1]; if(file.size>2097152)
															{ uploadSize=false; } else { uploadSize=true; }
															size+=file.size; } if(uploadSize==true){ return true;
															}else{ return false; } } 
														</aui:validator>
													</aui:input>
												</div>
											</div>
										</td>
									</tr>
									<tr>
										<td class="bg-gray"><liferay-ui:message key="owner_id" /></td>
										<td>
											<div class="col-md-12">
												<div class="form-group has-feedback">
													<input id="selectedOwnerIdFile" class="form-control"
														onclick="$('#<portlet:namespace/>ownerIdFile').click();"
														placeholder='<liferay-ui:message key="select_file"/>'>
													<span
														class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
													<aui:input type="file" name="ownerIdFile" id="ownerIdFile"
														cssClass="sr-only" label="">
														<aui:validator name="acceptFiles">'jpg,png,pdf,jpeg'</aui:validator>
														<aui:validator name="custom"
															errorMessage="max_upload_size">
									                            function(val,node,junction){
										                            var uploadSize=true;
																	var size=0;
																	var fileInput = document.getElementById("<portlet:namespace />ownerIdFile");
																	for(var num1=0;num1<fileInput.files.length
																;num1++)
																	{
																	      var
																file=fileInput.files[num1]; if(file.size>2097152)
															{ uploadSize=false; } else { uploadSize=true; }
															size+=file.size; } if(uploadSize==true){ return true;
															}else{ return false; } } 
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
							<a id="termsAndCondLink" class="text-muted"><span
								class="glyphicon glyphicon-list-alt"></span> <liferay-ui:message
									key="t_c" /></a> <br>
							<div class="form-group">
								<label class="checkbox-inline text-muted"> <input
									class="control-label" id="termsAndCon" type="checkbox" value=""
									onchange="agreeTerms();"> <liferay-ui:message
										key="ack_data_correct" />
								</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-right no-pad">
							<ul class="list-btns">
								<li>
									<button class="btn btn-lg btn-xs-block btn-link text-muted"
										type="submit" onclick="$('#landingBackForm').submit();">
										<i class="material-icons md-24">&#xE5C4;</i>
										<liferay-ui:message key="back" />
									</button>
								</li>
								<li>
									<button class="btn btn-primary btn-lg btn-xs-block"
										type="submit" id="submitBtn" disabled>
										<liferay-ui:message key="submit" />
									</button>
								</li>
							</ul>
						</div>
					</div>
				</aui:form>
			</div>
		</div>
	</div>
</div>
<div id="aui_popup_content"></div>
<div id="aui_popup_body" style="display: none;">
	<div class="row margin-top">
		<div class="col-md-12">
			<p>
				<liferay-ui:message key="terms_and_conditions" />
			</p>
			<p class="text-primary">
				<liferay-ui:message key="post_terms" />
			</p>
		</div>
	</div>
</div>
<script>
var flag= '<%=policyTypeFlag%>';
	document.getElementById('<portlet:namespace/>najmSlipFile').onchange = function () {
	document.getElementById('selectedNajmSlipFile').value =  this.files.item(0).name; 
};
if(flag=='<%=ClaimIntimationPortletKeys.TRX_TPL%>
	') {
		document.getElementById('<portlet:namespace/>damageEstQuotFile').onchange = function() {
			document.getElementById('selectedDamageEstQuotFile').value = this.files
					.item(0).name;
		};
		document.getElementById('<portlet:namespace/>bankIbanFile').onchange = function() {
			document.getElementById('selectedBankIbanFile').value = this.files
					.item(0).name;
		};
		document.getElementById('<portlet:namespace/>ownerIdFile').onchange = function() {
			document.getElementById('selectedOwnerIdFile').value = this.files
					.item(0).name;
		};
	}

	var regex = new RegExp('(^SA)([0-9a-zA-Z]{22})');

	function checkForConfirm() {
		if ($('#<portlet:namespace />iban').val() != ""
				&& $('#<portlet:namespace />ibanConfirm').val() != ""
				&& regex.test($('#<portlet:namespace />iban').val())
				&& regex.test($('#<portlet:namespace />ibanConfirm').val())) {
			$('#ibanLabel').text($('#<portlet:namespace />iban').val())
					.removeClass("text-danger");

		} else {
			$('#ibanLabel').text("IBAN not entered correctly above").addClass(
					"text-danger");
		}

	}

	function agreeTerms() {
		if ($('#termsAndCon').is(":checked")) {
			$('#submitBtn').removeAttr('disabled');
		} else {
			$('#submitBtn').attr('disabled', 'disabled');
		}
	}
</script>
<aui:script use="liferay-util-window,liferay-portlet-url">
	A
			.one('#termsAndCondLink')
			.on(
					'click',
					function(event) {
						AUI()
								.use(
										'aui-modal',
										function(A) {
											var dialog = new A.Modal(
													{
														title : "",
														bodyContent : AUI()
																.one(
																		'#aui_popup_body')
																.html(),
														headerContent : '<h3 class="no-margin"><liferay-ui:message key="t_c"/></h3>',
														centered : true,
														modal : true,
														width : 800,
														height : 400,
														render : '#aui_popup_content'
													});
											dialog
													.addToolbar([
															{
																label : '<liferay-ui:message key="agree_t&c"/>',
																cssClass : 'btn-primary',
																on : {
																	click : function() {
																		window.parent.document
																				.getElementById('termsAndCon').checked = true;
																		window.parent
																				.agreeTerms();
																		dialog
																				.hide();
																	}
																}
															},
															{
																label : '<liferay-ui:message key="dont_agree"/>',
																cssClass : 'btn-default btn-outline',
																on : {
																	click : function() {
																		window.parent.document
																				.getElementById('termsAndCon').checked = false;
																		window.parent
																				.agreeTerms();
																		dialog
																				.hide();
																	}
																}
															} ]);
										});
					});
</aui:script>
		

	