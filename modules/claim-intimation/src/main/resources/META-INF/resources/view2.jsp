<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="claim.intimation.constants.ClaimIntimationPortletKeys"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="claim.intimation.portlet.ClaimIntimationPortlet"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="com.liferay.portal.kernel.util.HtmlUtil"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.LinkedHashSet"%>

<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="java.util.Map"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<% 
	List<CodeMasterDetails> causeOfLossList = (List<CodeMasterDetails>)request.getAttribute("causeOfLossList");
	List<CodeMasterDetails> claimTypeList = (List<CodeMasterDetails>)request.getAttribute("claimTypeList");
	List<CodeMasterDetails>  natureOfLossList = (List<CodeMasterDetails>)request.getAttribute("natureOfLossList");
	List<CodeMasterDetails>  cityList = (List<CodeMasterDetails>)request.getAttribute("cityList");
	List<CodeMasterDetails>  vehicleModelList = (List<CodeMasterDetails>)request.getAttribute("vehicleModelList");
	List<CodeMasterDetails>  nationalityList = (List<CodeMasterDetails>)request.getAttribute("nationalityList");
	List<CodeMasterDetails>  bankList = (List<CodeMasterDetails>)request.getAttribute("bankList");

	String lang = themeDisplay.getLocale().toString();
	Map<String, String> manufactMap = (Map<String,String>) request.getAttribute("manufactMap");
	Map<String, String> manufactMapAR = ClaimIntimationPortlet.manufactMapAR;
	
	Map<String, List<CodeMasterDetails>> vehicleMakeModelPair = ClaimIntimationPortlet.vehicleMakeModelPair;
	Map<String, List<CodeMasterDetails>> vehicleMakeModelPairAR = ClaimIntimationPortlet.vehicleMakeModelPairAR;
	
	Map<String, Set<Map<String, String>>> requiredDocumentsListMap = ClaimIntimationPortlet.requiredDocumentsMap;
	
	String currLocale = themeDisplay.getLocale().toString();
	String googleSiteKey =  PropsUtil.get("google.siteKey");
%>
<style>
.has-error .form-control {
    border-color: #a94442;}
    
    div#_ATMCClaimIntimation_mobileNumberHelper {
    margin-top: 40px;
    margin-left: 150px;
    position: absolute;
}
    div#_ATMCClaimIntimation_phoneCodeHelper {
    position: absolute;
    margin-top: 40px;
}
.required {
    color: #a94442;
}
label.control-label {
    margin: 16px 0px;
}

#attachMore{
    border: solid thin blue;
    background-color: white;
    border-radius: 7px;
}
.tooltip1 {
  position: relative;
  display: inline-block;
  border-bottom: 1px dotted black;
}

.tooltip1 .tooltiptext1 {
  visibility: hidden;
  width: 120px;
  background-color: black;
  color: #fff;
  text-align: center;
  border-radius: 6px;
  padding: 5px 0;
  position: absolute;
  z-index: 1;
  bottom: 100%;
  left: 50%;
  margin-left: -60px;
  
  /* Fade in tooltip1 - takes 1 second to go from 0% to 100% opac: */
  opacity: 0;
  transition: opacity 1s;
}

.tooltip1:hover .tooltiptext1 {
  visibility: visible;
  opacity: 1;
}
</style>
<portlet:resourceURL var="validateOnPolicyAndChassisURL" id="validateOnPolicyAndChassis"/>

<portlet:resourceURL var="captchaURL"/>

<portlet:actionURL name="intimateClaim"  var="claimIntimationURL">
</portlet:actionURL>
<%
PortletURL resourceURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
		themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
String resourceURLVal = resourceURL.toString();
if (resourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
	resourceURLVal = resourceURLVal.substring(0, resourceURLVal.lastIndexOf("&p_p_lifecycle=1"));
%>
<aui:form action="<%= claimIntimationURL %>" method="post" name="claimIntimationForm" enctype="multipart/form-data" id="claimIntimationForm" role="form">
<liferay-ui:error key="claims_error_input" message="claims_error_input" />
<liferay-ui:error exception="<%= NoSuchNajmCaseNoException.class %>" message="claims_error_najm_nonajmcase" />
<liferay-ui:error exception="<%= NoSuchNajmVehicleNoException.class %>" message="claims_error_najm_novehicleno" />
<liferay-ui:error exception="<%= NoSuchNajmOtherPartyException.class %>" message="claims_error_najm_nootherparty" />
<liferay-ui:error key="InvalidClaimDataEntered" message="invalid-claim-data-entered"></liferay-ui:error>
						
	<div class="row margin-top">
		<div class="col-md-10 col-md-offset-1">
			<h3 class="text-primary"><liferay-ui:message key="claim-report-claim"/></h3>
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
							<h3 class="pad-5"><liferay-ui:message key="claim-please-select-claim-type"/></h3>
							<div class="radio-group">
								<input id="<portlet:namespace/>claimType_1" class="radio-group-option" checked="true" label="" name="<portlet:namespace/>claimType" type="radio" value="V" />
								<label id="<portlet:namespace/>lblVehicle" class="radio-group-label" for="_ATMCClaimIntimation_claimType_1"><i class="material-icons md-48">&#xE531;</i> <liferay-ui:message key="claim-vehicle"/></label>
								<%--><input id="<portlet:namespace/>claimType_2" class="radio-group-option" checked="false" label="" name="<portlet:namespace/>claimType" type="radio" value="P" >
								</input>
							   	<label id="<portlet:namespace/>lblProperty" class="radio-group-label" for="_ATMCClaimIntimation_claimType_2"><i class="material-icons md-48">&#xE0AF;</i> <liferay-ui:message key="claims_property"/></label> --%>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-type"/></label>
									<select class="form-control" name="<portlet:namespace/>claimantType" id="<portlet:namespace/>claimantType" onchange="changeClaimType()" label="">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
									<%
											if(Validator.isNotNull(claimTypeList)){
												for (CodeMasterDetails claimType : claimTypeList) {
													String claimTypeDesc = (lang.equals("en_US"))?claimType.getCodeDesc():claimType.getCodeDescAr();
													%>
													<option value="<%=claimType.getCodeSub() %>"><%=claimTypeDesc%></option>
													<% 
												}
											} %>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback" hidden id="iban-field">
									<label class="control-label"><liferay-ui:message key="claim-iban-bank-number"/></label>
									<input id="<portlet:namespace/>ibanNumber" name="<portlet:namespace/>ibanNumber" class="form-control" type="text" placeholder="Iban Number" label="">
									</input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-policy-no"/></label>
									<input id="<portlet:namespace/>policyNumber" name="<portlet:namespace/>policyNumber" class="form-control" type="text" placeholder="Poilcy Number" label="">
									</input>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" id="bank-field" hidden>
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claim-bank-name"/></label>
									<select class="form-control" name="<portlet:namespace/>bankName" label="">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<%
											if(Validator.isNotNull(bankList)){
												for (CodeMasterDetails causeOfLoss : bankList) {
													String causeOfLossDesc = (lang.equals("en_US"))?causeOfLoss.getCodeDesc():causeOfLoss.getCodeDescAr();
													%>
													<option value="<%=causeOfLoss.getCodeSub() %>"><%=causeOfLossDesc%></option>
													<% 
												}
											} else {
												%>
												<option value="1">Bank1</option>
												<option value="2">Bank2</option>
											<%} %>
									</select>
								</div>
							</div>
						</div>
						<div class="row" id="<portlet:namespace/>vehicleIdent">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<div role="group" class="btn-group btn-group-justified" data-toggle="buttons">
										<label id="<portlet:namespace/>lblPlateNumber" class="">
											<input label="" name="<portlet:namespace/>vehicleIdentType" type="hidden" value="<%=ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_PLATE_NUMBER %>" />
											<liferay-ui:message key="claim-vehicle-plate-no"/>
										</label>
									</div>
								</div>
								<div class="form-group" style="margin-top: 1.5rem;">
									<input onkeypress='return validateQty(event);' class="form-control" showRequiredLabel="false" name="<portlet:namespace/>plateNumber" id="<portlet:namespace/>plateNumber" label="" 
									placeholder="<%=LanguageUtil.get(request,"claims_enter_plate_number") %>">
									</input>															
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 l1l2l3">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claim-plate-alphabet"/></label>
									<div class="row">															
									<%
										for (int i=1; i <= 3; i++)
										{
											String selectName = "plateL" + i; %>
											<div class="col-md-4">
											<select class="form-control" name="<portlet:namespace/><%=selectName %>" label=""> <%
											if(ClaimIntimationPortlet.plateLetters!= null) {
												for (CodeMasterDetails plate : ClaimIntimationPortlet.plateLetters) {
													String plateLetter = (lang.equals("en_US"))?plate.getCodeDesc():plate.getCodeDescAr();
													%>
													<option value="<%=plate.getCodeSub() %>"><%=plateLetter%></option>
													<% 
												}%> </select></div> <%
											} else {%>
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
										}
									%>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-sequence-no"/></label>
									<input label="" id="<portlet:namespace/>sequenceNumber" onkeypress="return validateSequenceNumber(event)" name="<portlet:namespace/>sequenceNumber" class="form-control" type="text" placeholder="Sequence Number">
									</input>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-chassis-no"/></label>
									<input id="<portlet:namespace/>chassisNumber" onkeypress="return validateNumericField(event)"  name="<portlet:namespace/>chassisNumber" class="form-control" type="text" placeholder="Chassis Number" label="">
 									</input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-driver-mobile-no"/></label>
									<div style="display:flex;">
										<select class="form-control" name="<portlet:namespace/>phoneCode" id="<portlet:namespace/>phoneCode" style="max-width: 20%;  padding: 0px;" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
											<%
												if(Validator.isNotNull(ClaimIntimationPortlet.phoneCodes)){
													for (CodeMasterDetails code : ClaimIntimationPortlet.phoneCodes) {
														String phoneCode = (lang.equals("en_US"))?code.getCodeDesc():code.getCodeDescAr();
														%>
														<option value="<%=code.getCodeSub() %>"><%=phoneCode%> <%=code.getCodeSub()%></option>
														<% 
													}
												} 	%>						
										<input label=""  id="<portlet:namespace/>mobileNumber"  name="<portlet:namespace/>mobileNumber" class="form-control" type="text" placeholder="Mobile Number">
									</div>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claim-cause-of-loss"/></label>
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
						</div>
						
						
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claim-accident-city"/></label>
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
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-date-of-loss"/></label>
									<input label="" id="<portlet:namespace/>dateOfLossOrAccident"  tabindex="4"  name="<portlet:namespace/>dateOfLossOrAccident" class="form-control" type="date" placeholder="yyyy-mm-dd" >
									</input>
								</div>
							</div>
						</div>
						
						<div class="row">
                        	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-accident-desc"/></label>
                        			<textarea id="accidentDescription" name="<portlet:namespace/>accidentDescription" class="form-control" placeholder="Accident Description" >
                        			</textarea>
                        		</div>
                        	</div>
                        </div>
                        
                        
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claim-source-of-report"/></label>
									<select class="form-control" name="<portlet:namespace/>sourceOfAccidentReport" id="<portlet:namespace/>sourceOfAccidentReport" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="<%= ClaimIntimationPortletKeys.SOURCE_OF_ACCIDENT_REPORT_NAJM %>">NAJM</option>
										<option value="<%= ClaimIntimationPortletKeys.SOURCE_OF_ACCIDENT_REPORT_MUROOR %>">MUROOR</option>
										<option value="<%= ClaimIntimationPortletKeys.SOURCE_OF_ACCIDENT_REPORT_CIVIL_DEFENCE %>">CIVIL DEFENCE</option>
										<option value="<%= ClaimIntimationPortletKeys.POLICE %>">POLICE</option>
										
									</select>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col xs-12">
								<label class="control-label"><liferay-ui:message key="claim-police-report-NAJM-case-no"/></label>
								<input label="" id="<portlet:namespace/>accidentReportNumber"  name="<portlet:namespace/>accidentReportNumber" class="form-control" type="text" placeholder="Accident Number">
								</input>
							</div>
						</div>
						
						
						<div class="row">
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                      			<label class="control-label"><liferay-ui:message key="claim-vehicle-make"/></label>
                        		<select class="form-control" id="<portlet:namespace/>vehicleMake" name="<portlet:namespace/>vehicleMake" label="" onchange="setVehicleModels(this.value)">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
									<%
										Map<String, String> manuFactMap = (lang.equals("en_US")) ? manufactMap : manufactMapAR;
										if(!manuFactMap.isEmpty()){
											for (Map.Entry<String,String> entry : manuFactMap.entrySet()) {
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
								</select>
                        	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                      			<label class="control-label"><liferay-ui:message key="claim-vehicle-model"/></label>
                        		<select class="form-control" id="<portlet:namespace/>vehicleModel" name="<portlet:namespace/>vehicleModel" label="">
									<option value="-1"><liferay-ui:message key="please_select_option"/></option>
									<%--
										if(vehicleModelList != null){
											for (CodeMasterDetails vehicleModel : vehicleModelList) {
												String vehicleModelName = (lang.equals("en_US"))?vehicleModel.getCodeDesc():vehicleModel.getCodeDescAr();
												%>
												<option value="<%=vehicleModel.getCodeSub() %>"><%=vehicleModelName%></option>
												<%
											}
										} else {
										%>
											<option value="abc">abc</option>
											<option value="xyz">xyz</option>
											<option value="pqr">pqr</option>
										<%} 
									--%>
								</select>
                        	</div>
                        </div>

                        <div class="row">
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-driver-name"/></label>
                        			<input label="" id="<portlet:namespace/>driverName" onkeypress="return validateDriverName(event);" name="<portlet:namespace/>driverName" class="form-control" type="text" >
                        			</input>
                        		</div>
                        	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-driver-nationality"/></label>
                        			<select class="form-control" name="<portlet:namespace/>driverNationality" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<%
											if(vehicleModelList != null){
												for (CodeMasterDetails nationality : nationalityList) {
													String nationaName = (lang.equals("en_US"))?nationality.getCodeDesc():nationality.getCodeDescAr();
													%>
													<option value="<%=nationality.getCodeSub() %>"><%=nationaName%></option>
													<%
												}
											} else {
											%>
												<option value="abc">abc</option>
												<option value="xyz">xyz</option>
												<option value="pqr">pqr</option>
											<%} 
										%>
									</select>
                        		</div>
                        	</div>
                        </div>
                        <div class="row">
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-national-id"/></label>
                        			<input label="" id="<portlet:namespace/>driverNationalId" onkeypress="return validateNumericField(event)" name="<portlet:namespace/>driverNationalId" class="form-control" type="text" >
                        			</input>
                        		</div>
                        	</div>
                        	<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                        		<div class="form-group has-feedback">
									<label class="control-label">Date Of Birth</label>
									<input label="" id="<portlet:namespace/>dateOfBirthG"  name="<portlet:namespace/>dateOfBirthG" class="form-control" type="date" placeholder="yyyy-mm-dd" >
									</input>
								</div>
                        	</div>
                        </div>
                        <div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-driver-gender"/></label>
                        			<select class="form-control" name="<portlet:namespace/>driverGender" label="">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="1">MALE</option>
										<option value="2">FEMALE</option>
										<option value="3">OTHER</option>
									</select>
                        		</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="claim-email-id"/></label>
                        			<input label="" id="<portlet:namespace/>emailId"  name="<portlet:namespace/>emailId" class="form-control" type="text" placeholder="Email ID" />
                        		</div>
							</div>
						</div>
						<br/>
						<div class="row">
							<label><liferay-ui:message key="claim-upload-file"/></label>
							<div class="element" style="margin-bottom: 2%;width:100%">
								<input type="file" style="display:inline" name="_ATMCClaimIntimation_claimIntimationAttachments"  id="_ATMCClaimIntimation_claimIntimationAttachments1"/>
								<i id="tooltip1-info" class="glyphicon glyphicon-info-sign tooltip1"></i>
							</div>
							<div id="moreImageUpload" style="width: 100%"></div>
							<div class="clear"></div>
							<div id="moreImageUploadLink" style="display:none;margin-bottom: 5%">
								<a href="javascript:void(0)"  id="attachMore" onclick="attachMore()">Attach another file</a>
							</div>
						</div>
						<br/>
						<div class="row">
							<div class="col-md-12 margin-bottom">
								<liferay-captcha:captcha url="<%=captchaURL%>" />
								<span id="callback-blankCatcha" class="captcha_error"></span><br>
							</div>
						</div>	
						<%-- <div class="row">
							<div class="g-recaptcha required" data-sitekey="<%= googleSiteKey %>"data-callback="callback" ></div>
							<span id="callback-blankCatcha" class="captcha_error"></span><br>
						</div>	 --%>
						<br/>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<label class="text-primary checkbox-inline">
								<input name="confirmationCheckbox" id="confirmationCheckbox" type="checkbox" onclick="isCheckedFunction()" style="display: inline" />
								<liferay-ui:message key="claim-intimation-confirm-checkbox"/></label>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 text-right no-pad">
								<ul class="list-btns">
									<li>
										<button id="submitClaimIntimation" class="btn btn-primary btn-lg btn-xs-block" type="submit" value="<%=LanguageUtil.get(request,"claims_proceed") %>" 
										onclick="validateFormAndSubmit()">Proceed</button>
									</li>
								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</aui:form>	
<form action="${validateOnPolicyAndChassisURL}" id="validateOnPolicyAndChassisForm">
	<input type="hidden" name="<portlet:namespace/>chassisNumber" id="<portlet:namespace/>chassisNumber1"/>
	<input type="hidden" name="<portlet:namespace/>policyNumber" id="<portlet:namespace/>policyNumber1"/>
	<input type="hidden" name="<portlet:namespace/>dateOfLossOrAccident" id="<portlet:namespace/>dateOfLossOrAccident1"/>
</form>
<script>
var requiredDocumentsMap = new Map();
var vehicleMakeModelPair = new Map();
$(document).ready(function() {
	<% 
	for(Map.Entry<String, Set<Map<String, String>>> setx : requiredDocumentsListMap.entrySet()) {
		Set<Map<String, String>> documentStringSet = setx.getValue();
		Map<String, String>[] documentStringArray = documentStringSet.toArray(new HashMap[documentStringSet.size()]);
		Map<String, String> thisMap = new HashMap<>();
		if(currLocale.equals("en_US"))
			thisMap = documentStringArray[0];
		else 
			thisMap = documentStringArray[1];%>
		var url = [];
		<%
		for(Map.Entry<String,String> iterateMap : thisMap.entrySet()) {%>
			url.push('<%=iterateMap.getValue()%>');
			<%
		}%>
		requiredDocumentsMap.set('<%=setx.getKey()%>',url); <%
	}
	%>
	console.log(requiredDocumentsMap);
});
$(document).ready(function() {
	<% 
	for(Map.Entry<String, List<CodeMasterDetails>> setx : vehicleMakeModelPair.entrySet()) {%>
		var models = new Map();
		<%for(CodeMasterDetails vehicleModel : setx.getValue()){%>
			models.set('<%=lang.equals("en_US") ? HtmlUtil.escape(vehicleModel.getCodeDesc()) : HtmlUtil.escape(vehicleModel.getCodeDescAr())%>','<%=vehicleModel.getCodeSub()%>');
		<%}%>
		vehicleMakeModelPair.set('<%=setx.getKey()%>', models); <%
	}
	%>
	console.log(requiredDocumentsMap);
});
function setVehicleModels(selectedMake){
	var modelMap = vehicleMakeModelPair.get(selectedMake);
	var options = '';
	$('#_ATMCClaimIntimation_vehicleModel').empty();
	modelMap.forEach(function(value, key, map){
		options += '<option value="'+value+'">'+key+'</option>';
	});
	$(options).fadeIn('slow').appendTo('#_ATMCClaimIntimation_vehicleModel');
}
var upload_number = 2;
$(document).ready(function() {
	$("input[id^='_ATMCClaimIntimation_claimIntimationAttachments']").each(function() {
		var id = parseInt(this.id.replace("_ATMCClaimIntimation_claimIntimationAttachments", ""));
		$("#_ATMCClaimIntimation_claimIntimationAttachments" + id).change(function() {
			if ($("#_ATMCClaimIntimation_claimIntimationAttachments" + id).val() != "") {
				$("#moreImageUploadLink").show();
			} else {
				$("#moreImageUploadLink").hide();
			}
		});
	});
});

function toggleAddAnotherFileButton(id) {
	if ($("#"+id).val() != "") {
		$("#moreImageUploadLink").show();
	} else {
		$("#moreImageUploadLink").hide();
	}
}
function attachMore(){
	var moreUploadTag = '';
	moreUploadTag += '<input type="file"id="_ATMCClaimIntimation_claimIntimationAttachments' + upload_number + '"  onchange="toggleAddAnotherFileButton(this.id)" name="_ATMCClaimIntimation_claimIntimationAttachments"/>';
	$('<dl style="margin-bottom: 2%; width:100%" id="another_file' + upload_number + '">' + moreUploadTag + '</dl>').fadeIn('slow').appendTo('#moreImageUpload');
	upload_number++;
}
function del_file(eleId) {
	var ele = document.getElementById("delete_file" + eleId);
	ele.parentNode.removeChild(ele);
}
/*function attachFilesAndSubmit(){
	var formdata = new FormData($("#_ATMCClaimIntimation_claimIntimationForm")[0]);
	var files = formdata.getAll("upload_file");
	var attachments = formdata.get("_ATMCClaimIntimation_claimIntimationAttachments");
	for(let i=0; i<files.length; i++){
		formdata.append("_ATMCClaimIntimation_claimIntimationAttachments", formdata.getAll("upload_file")[i]);
	}
}*/
$(document).ready(function() {
	var plateNumberPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_plate_number") %>";
	var customNumberPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_custom_number") %>";
	var najmIdPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_najm_id") %>";
	var muroorIdPlaceholderTxt = "<%=LanguageUtil.get(request,"claims_enter_muroor_id") %>";
	$("#accidentDescription").val('');
	$('#submitClaimIntimation').attr("disabled", true);
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
function validateNumericField(event){
	var key = window.event ? event.keyCode : event.which;
//    var mobileNoLength = $("#_ATMCClaimIntimation_phoneCode").val().length + $("#_ATMCClaimIntimation_mobileNumber").val().length;
//    if(mobileNoLength >= 10){
//    	return false;
//    }
    if ( key < 48 || key > 57 ) {
        return false;
    }
    else return true;
}
function validateSequenceNumber(event){
	var key = window.event ? event.keyCode : event.which;
    var seqLength = $("#_ATMCClaimIntimation_sequenceNumber").val().length;
    if(seqLength >= 9){
    	return false;
    }
    else return true;
}
function validateDriverName(event){
	var key = window.event ? event.keyCode : event.which;
	  return (/[a-z]/i.test(event.key) || key == 8 || key == 32);
}

function validateQty(event) {
    var key = window.event ? event.keyCode : event.which;
  
    if($("#_ATMCClaimIntimation_plateNumber").val().length >=4){
    	return false;}
    else if ( key < 48 || key > 57 ) {
        return false;
    }
    else return true;
};
function validateOnPolicyAndChassis(){
	var chassisNumber = $('#<portlet:namespace/>chassisNumber').val();
	var policyNumber =  $('#<portlet:namespace/>policyNumber').val();
	var dateOfLossOrAccident = $('#<portlet:namespace/>dateOfLossOrAccident').val();
	 $('#_ATMCClaimIntimation_chassisNumber1').val(chassisNumber);
	 $('#_ATMCClaimIntimation_policyNumber1').val(policyNumber);
	 $('#_ATMCClaimIntimation_dateOfLossOrAccident1').val(dateOfLossOrAccident);
	 var isDateValid = false;
	 $.ajax({
		url: '${validateOnPolicyAndChassisURL}',
		dataType: "json",
		data:{
			'chassisNumber' : chassisNumber,
			'policyNumber' : policyNumber,
			'dateOfLossOrAccident':dateOfLossOrAccident
		},
		success : function(data) {
			if(data.isError){
				alert('invalid data!');
			} else {
				isDateValid = true;
			}
		}
	}).done(function(){
		if(isDateValid){
			$('#submitClaimIntimation').attr('disabled',true);
			$("#_ATMCClaimIntimation_claimIntimationForm").submit();
		}
	});
	// $('#validateOnPolicyAndChassisForm').submit();
}
function isCheckedFunction(){
	if(!$('#confirmationCheckbox').is(":checked")){
		$('#submitClaimIntimation').attr("disabled", true);
	} else {
		$('#submitClaimIntimation').attr("disabled", false);
	}
}
/*function setRequiredDocuments(key){
	var documents = [];
	$("#moreImageUpload").empty();
	documents = requiredDocumentsMap.get(key);
	for(let i=0; i< documents.length; i++){
		var moreUploadTag = '';
		moreUploadTag += '<label style="margin-top: 7%">'+documents[i]+'</label><div class="element" style="display: flex;">';
		moreUploadTag += '<input type="file" id="_ATMCClaimIntimation_claimIntimationAttachments'+i+'" name="_ATMCClaimIntimation_claimIntimationAttachments'+i+'"/>';
		$('<dl id="delete_file' + i + '" >' + moreUploadTag + '</dl>').fadeIn('slow').appendTo('#moreImageUpload');
	}
	var	docs = '<input type="hidden" name="_ATMCClaimIntimation_documentsLength" value="'+documents.length+'"/>';
	$(docs).fadeIn('slow').appendTo('#moreImageUpload');
}*/

function setTopolTipMessage(key){
	var documents = [];
	$("#moreImageUpload").empty();
	$("#tooltip1-info").empty()
	documents = requiredDocumentsMap.get(key);
	var Tooltiptext="Required Documents : ";
	for(let i=0; i< documents.length; i++){
		var moreUploadTag = '';
		Tooltiptext +=  documents[i] + ", ";
	}
	Tooltiptext = Tooltiptext.substring(0,Tooltiptext.lastIndexOf(","));
	moreUploadTag += '<span style="line-height: 2rem; width: 270px" class="tooltiptext1">'+Tooltiptext+'</span>';
	$(moreUploadTag).fadeIn('slow').appendTo('#tooltip1-info');
	/*var	docs = '<input type="hidden" name="_ATMCClaimIntimation_documentsLength" value="'+documents.length+'"/>';
	$(docs).fadeIn('slow').appendTo('#tooltip1-info');*/
}


function changeClaimType(){
	if($('#_ATMCClaimIntimation_claimantType').val() == '2'){
		$('#iban-field').removeAttr('hidden');
		$('#bank-field').removeAttr('hidden');
	} else {
		$('#_ATMCClaimIntimation_ibanNumber').val('');
		$('#_ATMCClaimIntimation_bankName').val('');
		$('#iban-field').attr('hidden', true);
		$('#bank-field').attr('hidden', true);
	}
	/*setRequiredDocuments($('#_ATMCClaimIntimation_claimantType').val());*/
	setTopolTipMessage($('#_ATMCClaimIntimation_claimantType').val());
}
</script>

<aui:script>
var frmValidator;
var rules;
		rules = 
		{
		    <portlet:namespace/>claimType_1: {
	            required: true		    
			},
			<portlet:namespace/>plateNumber: {
				required: true
			},
		    <portlet:namespace/>claimantType: {
	            custDropDown: true
		    },
		    <portlet:namespace/>policyNumber: {
	            required: true
		    },
		    <portlet:namespace/>plateL1: {
	            custDropDown: true
		    },
		    <portlet:namespace/>plateL2: {
	            custDropDown: true
		    },
		    <portlet:namespace/>plateL3: {
	            custDropDown: true
		    },
		    <portlet:namespace/>sequenceNumber: {
	            required: true
		    },
		    <portlet:namespace/>chassisNumber: {
	            required: true, 
	            chassisNumberValid: true
	        },
		    <portlet:namespace/>phoneCode: {
		    	custDropDown: true    
		    },
		    <portlet:namespace/>mobileNumber: {
		    	required: true, 
				number: true,
				digits: true
		    },
		    <portlet:namespace/>causeOfLoss: {
	            custDropDown: true
		    },
		    <portlet:namespace/>accidentCity: {
	            custDropDown: true
		    },
		    <portlet:namespace/>dateOfLossOrAccident: {
		    	required: true
		    },
		    <portlet:namespace/>accidentDescription: {
		    	required: true
		    },
		    <portlet:namespace/>sourceOfAccidentReport: {
		    	custDropDown: true
		    },
		    <portlet:namespace/>accidentReportNumber: {
		    	required: true
		    },
		    <portlet:namespace/>vehicleMake: {
	            custDropDown: true
		    },
		     <portlet:namespace/>vehicleModel: {
	            custDropDown: true
		    },
		    <portlet:namespace/>driverName: {
		    	required: true
		    },
		    <portlet:namespace/>driverNationality: {
		    	custDropDown: true
		    },
		    <portlet:namespace/>driverNationalId: {
		    	required: true,
		    	nationalId: true
		    },
		    <portlet:namespace/>dateOfBirthG: {
		    	required: true
		    },
		    <portlet:namespace/>driverGender: {
		    	custDropDown: true
		    },
		    <portlet:namespace/>emailId: {
		    	required: true
		    }, 
		    <portlet:namespace/>claimIntimationAttachments: {
		    	required: true
		    }, 
		    <portlet:namespace/>claimIntimationAttachments1: {
		    	required: true
		    }
		 }
function validateFormAndSubmit()
{
	if (frmValidator) {
		frmValidator.resetAllFields();
		frmValidator.destroy();
	}
	
	$("#<portlet:namespace/>claimIntimationForm .form-validator-stack").remove();
	$("#<portlet:namespace/>claimIntimationForm .error-field").removeClass("error-field");
	$("#<portlet:namespace/>claimIntimationForm .has-error").removeClass("has-error");
	$("#<portlet:namespace/>claimIntimationForm input").removeAttr("aria-invalid");
    var fieldsMatch = ($("#iban").val() == $("#copyIban").val())?true:false;
	AUI().use('aui-form-validator', 'aui-overlay-context-panel',function(A) {
	  var DEFAULTS_FORM_VALIDATOR = A.config.FormValidator;
		A.mix(DEFAULTS_FORM_VALIDATOR.RULES,
			{
				chassisNumberValid:function (val, fieldNode, ruleValue) {
					return (val.length >= 14 && val.length <= 20);
				},
				mobileNumberValid:function (val, fieldNode, ruleValue) {
					var isMobileValid = true;
					if(val.length != 10 || !val.startsWith('05'))
						isMobileValid = false;
					return isMobileValid;
				},
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
				},
				nationalId:function(val, fieldNode, ruleValue){
					return (val.length==10);
				}
			},
		    true
		);
		
		A.mix(DEFAULTS_FORM_VALIDATOR.STRINGS,
			{
				uploadFileSize:'<liferay-ui:message key="max_upload_size"/>',
				mobileNumberValid:'<liferay-ui:message key="invalid_mobile"/>',
				chassisNumberValid:'<liferay-ui:message key="invalid_chassis_number"/>',
				iban:'<liferay-ui:message key="invalid_iban"/>',
				customFieldMatch:'<liferay-ui:message key="values_not_match"/>',
				custDropDown:'<liferay-ui:message key="plz_select_value"/>',
				nationalId: 'Invalid National-Id'
			},
			true
		);
		
		if($('#<portlet:namespace/>claimantType').val() == '2'){
			delete rules.<portlet:namespace/>chassisNumber;
			delete rules.<portlet:namespace/>policyNumber;
			delete rules.<portlet:namespace/>sequenceNumber;
			rules.<portlet:namespace/>bankName = {required: true};
			rules.<portlet:namespace/>ibanNumber = {required: true};
		}
		var alertBlocks = document.getElementsByClassName("form-validator-stack help-block");
		for(let i=0; i< alertBlocks.length; i++){
			alertBlocks[i].remove();
		}
		
		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>claimIntimationForm',
		    rules:rules,
		    validateOnBlur: false
		});
	});
	$("#_ATMCClaimIntimation_claimIntimationForm .form-validator-stack").remove();
	$("#_ATMCClaimIntimation_claimIntimationForm .error-field").removeClass("error-field");
	$("#_ATMCClaimIntimation_claimIntimationForm .has-error").removeClass("has-error");
	$("#<portlet:namespace/>claimIntimationForm input").removeAttr("aria-invalid");
}	
</aui:script>
