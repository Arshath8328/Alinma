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
<% 
	List<CodeMasterDetails> causeOfLossList = (List<CodeMasterDetails>)request.getAttribute("causeOfLossList");
	List<CodeMasterDetails>  natureOfLossList = (List<CodeMasterDetails>)request.getAttribute("natureOfLossList");
	List<CodeMasterDetails>  cityList = (List<CodeMasterDetails>)request.getAttribute("cityList");
	String lang = themeDisplay.getLocale().toString();
	Map<String, String> manufactMap = (Map<String,String>) request.getAttribute("manufactMap");
	String currLocale = themeDisplay.getLocale().toString();
%>
<style>
label.control-label {
    margin: 16px 0px;
}

</style>
<portlet:actionURL name="intimateClaim"  var="claimIntimationURL">
</portlet:actionURL>
<form action="<%= claimIntimationURL %>" method="post" name="<portlet:namespace/>claimIntimationForm" enctype="multipart/form-data" id="<portlet:namespace/>claimIntimationForm" role="form">
<liferay-ui:error key="claims_error_input" message="claims_error_input" />
<liferay-ui:error exception="<%= NoSuchPolicyHDRException.class %>" message="claims_error_nopolicy" />
<liferay-ui:error exception="<%= NoSuchPolicyVEHException.class %>" message="claims_error_nopolicyveh" />
<liferay-ui:error exception="<%= NoSuchNajmCaseNoException.class %>" message="claims_error_najm_nonajmcase" />
<liferay-ui:error exception="<%= NoSuchNajmVehicleNoException.class %>" message="claims_error_najm_novehicleno" />
<liferay-ui:error exception="<%= NoSuchNajmOtherPartyException.class %>" message="claims_error_najm_nootherparty" />

						
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
						<div class="row" style="display:contents">
							<h3 class="pad-5"><liferay-ui:message key="claims_select_claim_type"/></h3>
							<div class="radio-group">
								<input id="<portlet:namespace/>claimType_1" class="radio-group-option" checked="true" label="" name="<portlet:namespace/>claimType" type="radio" value="V" />
								<label id="<portlet:namespace/>lblVehicle" class="radio-group-label" for="_ATMCClaimIntimation_claimType_1"><i class="material-icons md-48">&#xE531;</i> <liferay-ui:message key="claims_vehicle"/></label>
								<input id="<portlet:namespace/>claimType_2" class="radio-group-option" checked="false" label="" name="<portlet:namespace/>claimType" type="radio" value="P" >
								</input>
							  	<label id="<portlet:namespace/>lblProperty" class="radio-group-label" for="_ATMCClaimIntimation_claimType_2"><i class="material-icons md-48">&#xE0AF;</i> <liferay-ui:message key="claims_property"/></label>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Claimant Type</label>
									<select class="form-control" name="<portlet:namespace/>claimantType" label="">
										<option value="policy_owner">Policy Owner</option>
										<option value="thirdParty">Third Party</option>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Policy Number</label>
									<input id="<portlet:namespace/>policyNumber" name="<portlet:namespace/>policyNumber" class="form-control" type="text" placeholder="Poilcy Number" label="">
									</input>
								</div>
							</div>
						</div>
						<div class="row" id="<portlet:namespace/>vehicleIdent">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claims_enter_proceed"/></label>
									<div role="group" class="btn-group btn-group-justified" data-toggle="buttons">
										<label id="<portlet:namespace/>lblPlateNumber" class="btn btn-default active control-label">
											<input checked="true" label="" name="<portlet:namespace/>vehicleIdentType" type="radio" value="<%=ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_PLATE_NUMBER %>" /><liferay-ui:message key="claims_plate_number"/>
										</label>
										<%--  <label id="<portlet:namespace/>lblCustomNumber" class="btn btn-default control-label">
											<input checked="false" label="" name="<portlet:namespace/>vehicleIdentType" type="radio" value="<%=ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_CUSTOM %>" /><liferay-ui:message key="claims_custom_number"/>
										</label> --%>
									</div>
								</div>
								<div class="form-group" style="margin-top: 34px">
									<input class="form-control" showRequiredLabel="false" name="<portlet:namespace/>plateNumber" id="<portlet:namespace/>plateNumber" label="" placeholder="<%=LanguageUtil.get(request,"claims_enter_plate_number") %>" oninput="this.value = this.value.replace(/[^0-9.]/g, '')">
									</input>															
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 l1l2l3">
								<div class="form-group hidden-xs"><label class="control-label"></label><div>&nbsp;</div></div>
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claims_vehicle_plate_letters"/></label>
									<div class="row">															
									<%
										for (int i=1; i <= 3; i++)
										{
											String selectName = "plateL" + i;
									%>
									<div class="col-md-4">
										<c:choose>
											<c:when test="<%= lang.equals("en_US") %>">
												<select class="form-control" name="<portlet:namespace/><%=selectName %>" label="">
													<option  value="<%=LanguageUtil.get(request,"plate_letter_A") %>"><%=LanguageUtil.get(request,"plate_letter_A") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_B") %>"><%=LanguageUtil.get(request,"plate_letter_B") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_D") %>"><%=LanguageUtil.get(request,"plate_letter_D") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_E") %>"><%=LanguageUtil.get(request,"plate_letter_E") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_G") %>"><%=LanguageUtil.get(request,"plate_letter_G") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_H") %>"><%=LanguageUtil.get(request,"plate_letter_H") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_J") %>"><%=LanguageUtil.get(request,"plate_letter_J") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_K") %>"><%=LanguageUtil.get(request,"plate_letter_K") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_L") %>"><%=LanguageUtil.get(request,"plate_letter_L") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_N") %>"><%=LanguageUtil.get(request,"plate_letter_N") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_R") %>"><%=LanguageUtil.get(request,"plate_letter_R") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_S") %>"><%=LanguageUtil.get(request,"plate_letter_S") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_T") %>"><%=LanguageUtil.get(request,"plate_letter_T") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_U") %>"><%=LanguageUtil.get(request,"plate_letter_U") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_V") %>"><%=LanguageUtil.get(request,"plate_letter_V") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_X") %>"><%=LanguageUtil.get(request,"plate_letter_X") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_Z") %>"><%=LanguageUtil.get(request,"plate_letter_Z") %></option>
												</select>
											</c:when>
											<c:otherwise>
												<select class="form-control" name="<portlet:namespace/><%=selectName %>" label="">
													<option  value="<%=LanguageUtil.get(request,"plate_letter_A") %>"><%=LanguageUtil.get(request,"plate_letter_A") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_B") %>"><%=LanguageUtil.get(request,"plate_letter_B") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_J") %>"><%=LanguageUtil.get(request,"plate_letter_J") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_D") %>"><%=LanguageUtil.get(request,"plate_letter_D") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_R") %>"><%=LanguageUtil.get(request,"plate_letter_R") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_S") %>"><%=LanguageUtil.get(request,"plate_letter_S") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_X") %>"><%=LanguageUtil.get(request,"plate_letter_X") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_T") %>"><%=LanguageUtil.get(request,"plate_letter_T") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_E") %>"><%=LanguageUtil.get(request,"plate_letter_E") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_G") %>"><%=LanguageUtil.get(request,"plate_letter_G") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_K") %>"><%=LanguageUtil.get(request,"plate_letter_K") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_L") %>"><%=LanguageUtil.get(request,"plate_letter_L") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_Z") %>"><%=LanguageUtil.get(request,"plate_letter_Z") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_N") %>"><%=LanguageUtil.get(request,"plate_letter_N") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_H") %>"><%=LanguageUtil.get(request,"plate_letter_H") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_U") %>"><%=LanguageUtil.get(request,"plate_letter_U") %></option>
													<option  value="<%=LanguageUtil.get(request,"plate_letter_V") %>"><%=LanguageUtil.get(request,"plate_letter_V") %></option>
												</select>
											</c:otherwise>
										</c:choose>
									</div>
									<% 
										}
									%>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Sequence Number</label>
									<input label="" id="<portlet:namespace/>sequenceNumber"  name="<portlet:namespace/>sequenceNumber" class="form-control" type="text" placeholder="Sequence Number">
									</input>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Chassis Number</label>
									<input id="<portlet:namespace/>chassisNumber"  name="<portlet:namespace/>chassisNumber" class="form-control" type="text" placeholder="Chassis Number" label="">
<%-- 										<validator name="<portlet:namespace/>custom" errorMessage='<%= LanguageUtil.get(request, "invalid_chassis_number") %>'>
	 										function (val, fieldNode, ruleValue) {
												return (val.length <= 20);
											}
	 									</validator> --%>
 									</input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Mobile Number</label>
									<input label="" id="<portlet:namespace/>mobileNumber"  name="<portlet:namespace/>mobileNumber" class="form-control" type="text" placeholder="Mobile Number">
<%-- 										<validator name="<portlet:namespace/>custom" errorMessage='<%=LanguageUtil.get(request,"invalid_mobile") %>' > 
											function (val, fieldNode, ruleValue) {
												var isMobileValid = true;
												if(val.length != 10 || !val.startsWith('05'))
													isMobileValid = false;
												return isMobileValid;
											}
										</validator> --%>
									</input>
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claims_cause_of_loss"/></label>
									<select class="form-control" name="<portlet:namespace/>causeOfLoss" label="">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<%
											if(Validator.isNotNull(causeOfLossList)){
												for (CodeMasterDetails causeOfLoss : causeOfLossList) {
													String causeOfLossDesc = (lang.equals("en_US"))?causeOfLoss.getCodeDesc():causeOfLoss.getCodeDescAr();
													%>
													<option value="<%=causeOfLoss.getCodeSub() %>"><%=causeOfLossDesc%></option>
													<% 
												}
											} else {
												%>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_COLLISION %>">Collision</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_BURNT %>">Burnt</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_CRACKING%>">Cracking</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_OWN_DAMAGE %>">Own-Damage</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_THEFT %>">Theft</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_THIRD_PARTY_PROPERTY_DAMAGE%>">Third party property damage</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_THIRD_PARTY_BODILY_INGURY %>">Third party bodily ingury</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_THIRD_PARTY_PROPERTY_DAMAGE_BODILY_INGURY %>">Third party property damage / bodily ingury</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_DEATH %>">Death</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_FIRE %>">Fire</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_MISCELLANEOUS_DAMAGE%>">miscellaneous damage</option>
												<option value="<%=ClaimIntimationPortletKeys.CAUSE_OF_LOSS_OTHERS %>">others</option>
											<%} %>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label">Accident City</label>
										<select class="form-control" name="<portlet:namespace/>accidentCity" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<%
										if(Validator.isNotNull(cityList)){
											for (CodeMasterDetails accidentCity : cityList) {
												String accidentCityName = (lang.equals("en_US"))?accidentCity.getCodeDesc():accidentCity.getCodeDescAr();
												%>
												<option value="<%=accidentCity.getCodeSub() %>"><%=accidentCityName%></option>
												<%
											}
										} else {
										%>
											<option value="abc">abc</option>
											<option value="xyz">xyz</option>
											<option value="pqr">pqr</option>
										<%} %>
									</select>
								</div>
							</div>
						</div>
						
						
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">Date Of Loss/Accident</label>
									<input label="" id="<portlet:namespace/>dateOfLossOrAccident"  tabindex="4"  name="<portlet:namespace/>dateOfLossOrAccident" class="form-control" type="date" placeholder="yyyy-mm-dd" >
									</input>
								</div>
							</div>
						</div>
						
						<div class="row">
                        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Accident Description</label>
                        			<textarea id="<portlet:namespace/>accidentDescription"  tabindex="4"  name="<portlet:namespace/><portlet:namespace/>accidentDescription" class="form-control" type="text" placeholder="Accident Description" >
                        			</textarea>
                        		</div>
                        	</div>
                        </div>
                        
                        
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label">Source Of Accident Report</label>
									<select class="form-control" name="<portlet:namespace/>sourceOfAccidentReport" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="NAJM">NAJM</option>
										<option value="MUROOR">MUROOR</option>
										<option value="CIVIL DEFENCE">CIVIL DEFENCE</option>
										
									<%-- 	<validator name="<portlet:namespace/>custom" errorMessage='<%=LanguageUtil.get(request,"claims_select_source_of_accident_report") %>' >
											function (val, fieldNode, ruleValue) {
												return (val != '-1');
											}
										</validator> --%>
									</select>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col xs-12">
								<label class="control-label">Accident Report Number</label>
								<input label="" id="<portlet:namespace/>accidentReportNumber"  name="<portlet:namespace/>accidentReportNumber" class="form-control" type="text" placeholder="Accident Number">
								</input>
							</div>
						</div>
						
						
						<div class="row">
                        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                      			<label class="control-label">Vehicle Make</label>
                        		<select class="form-control" name="<portlet:namespace/>vehicleMake" label="">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
									<%
										if(!manufactMap.isEmpty()){
											for (Map.Entry<String,String> entry : manufactMap.entrySet()) {
												%>
												<option value="<%=entry.getValue() %>"><%=entry.getKey()%></option>
												<%
											}
										} else {
										%>
											<option value="abc">abc</option>
											<option value="xyz">xyz</option>
											<option value="pqr">pqr</option>
										<%} 
									%>
									<%-- <validator name="<portlet:namespace/>custom" errorMessage='<%=LanguageUtil.get(request,"claims_select_accident_city") %>' >
										function (val, fieldNode, ruleValue) {
											return (val != '-1');
										}
									</validator> --%>
								</select>
                        	</div>
                        </div>
						
						
                        <div class="row">
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Driver Name</label>
                        			<input label="" id="<portlet:namespace/>driverName" name="<portlet:namespace/>driverName" class="form-control" type="text" >
                        			</input>
                        		</div>
                        	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Driver Nationality</label>
                        			<input label="" id="<portlet:namespace/>driverNationality" name="<portlet:namespace/>driverNationality" class="form-control" type="text" >
                        			</input>
                        		</div>
                        	</div>
                        </div>
                        <div class="row">
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Driver National Id</label>
                        			<input label="" id="<portlet:namespace/>driverNationalId" name="<portlet:namespace/>driverNationalId" class="form-control" type="text" >
                        			</input>
                        		</div>
                        	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Date Of Birth</label>
									<input label="" id="<portlet:namespace/>dateOfBirthG"  tabindex="4"  name="<portlet:namespace/>dateOfBirthG" class="form-control" type="date" placeholder="yyyy-mm-dd" >
									</input>
								</div>
                        	</div>
                        </div>
                        <div class="row">
							<div class="col-md-12">
								<div class="form-group has-feedback">
									<label class="control-label">Driver Gender</label>
                        			<select class="form-control" name="<portlet:namespace/>driverGender" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="1">MALE</option>
										<option value="2">FEMALE</option>
										<option value="3">OTHER</option>
									</select>
                        		</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-6">
								<label class="control-label">Attachments</label>
								<input class="form-control" label="" type="file" id="<portlet:namespace/>claimIntimationAttachments" name="<portlet:namespace/>claimIntimationAttachments" multiple="true">
								</input>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 text-right no-pad">
								<ul class="list-btns">
									<li>
										<button id="submitClaimIntimation" class="btn btn-primary btn-lg btn-xs-block" type="submit" value="<%=LanguageUtil.get(request,"claims_proceed") %>" onclick="validateFormAndSubmit()">Proceed</button>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</form>
			
<script>
$(document).ready(function() {
	var plateNumberPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_plate_number") %>";
	var customNumberPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_custom_number") %>";
	var najmIdPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_najm_id") %>";
	var muroorIdPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_muroor_id") %>";
	
	$("#lblPlateNumber").click(function(e){
		$(".l1l2l3").show();
		$("#<portlet:namespace/>plateNumber").val('');
		$("#<portlet:namespace/>plateNumber").attr('placeholder',plateNumberPlaceholderTxt);
		$("#<portlet:namespace/>plateNumber").attr("oninput","this.value = this.value.replace(/[^0-9]/g, '');");
	})
	$("#lblCustomNumber").click(function(e){
		$(".l1l2l3").hide();
		$("#<portlet:namespace/>plateNumber").val('');
		$("#<portlet:namespace/>plateNumber").attr('placeholder',customNumberPlaceholderTxt);
		$("#<portlet:namespace/>plateNumber").removeAttr("oninput");
	})
	
	$("#lblNajm").click(function(e){
		$("#<portlet:namespace/>reportNumber").val('');
		$("#<portlet:namespace/>reportNumber").attr('placeholder',najmIdPlaceholderTxt);
	})
	$("#lblMuroor").click(function(e){
		$("#<portlet:namespace/>reportNumber").val('');
		$("#<portlet:namespace/>reportNumber").attr('placeholder',muroorIdPlaceholderTxt);
	})

	var local = "<%=currLocale%>";

		function backToStep1() {
			if (local == "en_US") {
				$(".middle-wrap").animate({
					left : "0"
				});
			} else {
				$(".middle-wrap").animate({
					right : "0"
				});
			}
		}
});
</script>

<aui:script>
var frmValidator;
function validateFormAndSubmit()
{
	if (frmValidator != undefined)
		frmValidator.resetAllFields();
    var fieldsMatch = ($("#iban").val() == $("#copyIban").val())?true:false;
	AUI().use('aui-form-validator', function(A) {
		A.mix(A.config.FormValidator.RULES,
			{
				uploadFileSize:function(val, fieldNode, ruleValue){
		        	console.log(fieldNode);
		        	//alert(fieldNode._node.name);
		        	var isValid = validateUploadSize(fieldNode._node.name, 2097152);
					if(isValid)
						return true;
					else
						return false;
				},
				customFieldMatch:function(val, fieldNode, ruleValue){
					if(fieldsMatch)
						return true;
					else
						return false;
				},
				chassisNumberValid:function (val, fieldNode, ruleValue) {
					return (val.length >= 14 && val.length <= 20);
				},
				iban:function(val, fieldNode, ruleValue){
					var regex = new RegExp('^(SA)([0-9 A-Z]){22}$');
					return regex.test(val);
				},
				mobileNumberValid:function (val, fieldNode, ruleValue) {
					var isMobileValid = true;
					if(val.length != 10 || !val.startsWith('05'))
						isMobileValid = false;
					return isMobileValid;
				},
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
				}
			},
		    true
		);
		
		A.mix(A.config.FormValidator.STRINGS,
			{
				uploadFileSize:'<liferay-ui:message key="max_upload_size"/>',
				mobileNumberValid:'<liferay-ui:message key="invalid_mobile"/>',
				chassisNumberValid:'<liferay-ui:message key="invalid_chassis_number"/>',
				iban:'<liferay-ui:message key="invalid_iban"/>',
				customFieldMatch:'<liferay-ui:message key="values_not_match"/>',
				custDropDown:'<liferay-ui:message key="plz_select_value"/>'
			},
			true
		);
		var rules = 
		{
		    <portlet:namespace/>claimType_1: {
	            required: true		    
			},
		    <portlet:namespace/>claimType_2: {
	            required: true
		    },
		    <portlet:namespace/>claimantType: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>policyNumber: {
	            required: true
		    },
		    <portlet:namespace/>plateL1: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>plateL2: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>plateL3: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>sequenceNumber: {
	            required: true
		    },
		    <portlet:namespace/>chassisNumber: {
	            required: true, 
	            chassisNumberValid: true
		    },
		    <portlet:namespace/>mobileNumber: {
		    	required: true, 
				number: true,
	            mobileNumberValid: true
		    },
		    <portlet:namespace/>causeOfLoss: {
		    	required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>accidentCity: {
		    	required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>dateOfLossOrAccident: {
		    	required: true
		    },
		    <portlet:namespace/>accidentDescription: {
		    	required: true
		    },
		    <portlet:namespace/>sourceOfAccidentReport: {
		    	required: true,
		    	custDropDown: true
		    },
		    <portlet:namespace/>accidentReportNumber: {
		    	required: true
		    },
		    <portlet:namespace/>vehicleMake: {
		    	required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>driverName: {
		    	required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>driverNationality: {
		    	required: true
		    },
		    <portlet:namespace/>driverNationalId: {
		    	required: true
		    },
		    <portlet:namespace/>dateOfBirthG: {
		    	required: true
		    },
		    <portlet:namespace/>driverGender: {
		    	required: true,
		    	custDropDown: true
		    },
		    <portlet:namespace/>claimIntimationAttachments: {
		    	required: true
		    }
		}

		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>claimIntimationForm',
		    rules:rules,
		    validateOnBlur: false
		});
		
	});
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
		$('#submitClaimIntimation').attr('disabled',true);
		$("#<portlet:namespace/>claimIntimationForm").submit();
	}
}	

</aui:script>
