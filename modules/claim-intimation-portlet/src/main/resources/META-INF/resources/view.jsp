<%@page import="com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException"%>
<%@page import="com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.atmc.web.constants.ClaimIntimationPortletKeys"%>
<%@ include file="/init.jsp" %>
<% 
	List<CodeMasterDetails> causeOfLossList = (List<CodeMasterDetails>)request.getAttribute("causeOfLossList");
	List<CodeMasterDetails>  natureOfLossList = (List<CodeMasterDetails>)request.getAttribute("natureOfLossList");
	String lang =themeDisplay.getLocale().toString();
	

%>

<portlet:actionURL name="intimateClaim"  var="claimIntimationURL">
</portlet:actionURL>
<aui:form action="<%= claimIntimationURL %>" method="post" name="claimIntimationForm" role="form">
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
						<div class="row">
							<h3 class="pad-5"><liferay-ui:message key="claims_select_claim_type"/></h3>
							<div class="radio-group">
								<aui:input id="claimType_1" cssClass="radio-group-option" checked="true" label="" name="claimType" type="radio" value="V" />
								<label id="lblVehicle" class="radio-group-label" for="_ATMCClaimIntimation_claimType_1"><i class="material-icons md-48">&#xE531;</i> <liferay-ui:message key="claims_vehicle"/></label>
								<aui:input id="claimType_2" cssClass="radio-group-option" checked="false" label="" name="claimType" type="radio" value="P" />
							  	<label id="lblProperty" class="radio-group-label" for="_ATMCClaimIntimation_claimType_2"><i class="material-icons md-48">&#xE0AF;</i> <liferay-ui:message key="claims_property"/></label>
							</div>
						</div>
						<div class="row" id="vehicleIdent">
							<div class="col-md-6 col-sm-6">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="claims_enter_proceed"/></label>
									<div role="group" class="btn-group btn-group-justified" data-toggle="buttons">
										<label id="lblPlateNumber" class="btn btn-default active control-label">
											<aui:input checked="true" label="" name="vehicleIdentType" type="radio" value="<%=ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_PLATE_NUMBER %>" /><liferay-ui:message key="claims_plate_number"/>
										</label>
										<label id="lblCustomNumber" class="btn btn-default control-label">
											<aui:input checked="false" label="" name="vehicleIdentType" type="radio" value="<%=ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_CUSTOM %>" /><liferay-ui:message key="claims_custom_number"/>
										</label>
									</div>
								</div>
								<div class="form-group">
									<aui:input cssClass="form-control" showRequiredLabel="false" name="plateNumber" id="plateNumber" label="" placeholder="<%=LanguageUtil.get(request,"claims_enter_plate_number") %>" oninput="this.value = this.value.replace(/[^0-9.]/g, '')">
										<aui:validator name="required">
											function() {
                        						return AUI.$('#<portlet:namespace />claimType_1').prop('checked');
                							}
                						</aui:validator>
									</aui:input>															
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
												<aui:select name="<%=selectName %>" label="">
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_A") %>"><%=LanguageUtil.get(request,"plate_letter_A") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_B") %>"><%=LanguageUtil.get(request,"plate_letter_B") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_D") %>"><%=LanguageUtil.get(request,"plate_letter_D") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_E") %>"><%=LanguageUtil.get(request,"plate_letter_E") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_G") %>"><%=LanguageUtil.get(request,"plate_letter_G") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_H") %>"><%=LanguageUtil.get(request,"plate_letter_H") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_J") %>"><%=LanguageUtil.get(request,"plate_letter_J") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_K") %>"><%=LanguageUtil.get(request,"plate_letter_K") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_L") %>"><%=LanguageUtil.get(request,"plate_letter_L") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_N") %>"><%=LanguageUtil.get(request,"plate_letter_N") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_R") %>"><%=LanguageUtil.get(request,"plate_letter_R") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_S") %>"><%=LanguageUtil.get(request,"plate_letter_S") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_T") %>"><%=LanguageUtil.get(request,"plate_letter_T") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_U") %>"><%=LanguageUtil.get(request,"plate_letter_U") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_V") %>"><%=LanguageUtil.get(request,"plate_letter_V") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_X") %>"><%=LanguageUtil.get(request,"plate_letter_X") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_Z") %>"><%=LanguageUtil.get(request,"plate_letter_Z") %></aui:option>
												</aui:select>
											</c:when>
											<c:otherwise>
												<aui:select name="<%=selectName %>" label="">
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_A") %>"><%=LanguageUtil.get(request,"plate_letter_A") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_B") %>"><%=LanguageUtil.get(request,"plate_letter_B") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_J") %>"><%=LanguageUtil.get(request,"plate_letter_J") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_D") %>"><%=LanguageUtil.get(request,"plate_letter_D") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_R") %>"><%=LanguageUtil.get(request,"plate_letter_R") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_S") %>"><%=LanguageUtil.get(request,"plate_letter_S") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_X") %>"><%=LanguageUtil.get(request,"plate_letter_X") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_T") %>"><%=LanguageUtil.get(request,"plate_letter_T") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_E") %>"><%=LanguageUtil.get(request,"plate_letter_E") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_G") %>"><%=LanguageUtil.get(request,"plate_letter_G") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_K") %>"><%=LanguageUtil.get(request,"plate_letter_K") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_L") %>"><%=LanguageUtil.get(request,"plate_letter_L") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_Z") %>"><%=LanguageUtil.get(request,"plate_letter_Z") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_N") %>"><%=LanguageUtil.get(request,"plate_letter_N") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_H") %>"><%=LanguageUtil.get(request,"plate_letter_H") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_U") %>"><%=LanguageUtil.get(request,"plate_letter_U") %></aui:option>
													<aui:option  value="<%=LanguageUtil.get(request,"plate_letter_V") %>"><%=LanguageUtil.get(request,"plate_letter_V") %></aui:option>
												</aui:select>
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
						<label class="control-label"><liferay-ui:message key="claims_accident_reportby"/></label>
						<div role="group" class="btn-group btn-group-justified" data-toggle="buttons">
							<label id="lblNajm" class="btn btn-default active control-label">
								<aui:input checked="true" label="" name="reportMode" type="radio" value="<%=ClaimIntimationPortletKeys.REPORT_MODE_NAJM %>" /><liferay-ui:message key="claims_najm"/>
							</label>
							<label id="lblMuroor" class="btn btn-default control-label">
								<aui:input checked="false" label="" name="reportMode" type="radio" value="<%=ClaimIntimationPortletKeys.REPORT_MODE_MUROOR %>" /><liferay-ui:message key="claims_muroor"/>
							</label>
						</div>
						<br>
						<div class="form-group">
							<aui:input cssClass="form-control" showRequiredLabel="false" name="reportNumber" id="reportNumber" label="" placeholder="<%=LanguageUtil.get(request,"claims_enter_najm_id") %>">
								<aui:validator name="required" />
							</aui:input>															
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label"><liferay-ui:message key="claims_cause_of_loss"/></label>
								<aui:select cssClass="form-control" name="causeOfLoss" label="">
								<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
									<%
									for (CodeMasterDetails causeOfLoss : causeOfLossList) {
										
										String causeOfLossDesc = (lang.equals("en_US"))?causeOfLoss.getCodeDesc():causeOfLoss.getCodeDescAr();
		
									%>
									<aui:option value="<%=causeOfLoss.getCodeSub() %>"><%=causeOfLossDesc%></aui:option>
									<% 
									}
									%>
									<aui:validator name="custom" errorMessage='<%=LanguageUtil.get(request,"claims_select_cause_of_loss") %>' > 
										function (val, fieldNode, ruleValue) {
											return (val != '-1');
										}
									</aui:validator>									 
								</aui:select>
						</div>
					</div>
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<div class="form-group">
							<label class="control-label"><liferay-ui:message key="claims_nature_of_loss"/></label>
							<aui:select cssClass="form-control" name="natureOfLoss" label="">
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
									<%
									for (CodeMasterDetails natureOfLoss : natureOfLossList) {
										
										String natureOfLossDesc = (lang.equals("en_US"))?natureOfLoss.getCodeDesc():natureOfLoss.getCodeDescAr();
		
									%>
									<aui:option value="<%=natureOfLoss.getCodeSub() %>"><%=natureOfLossDesc%></aui:option>
									<% 
									}
									%>
									<aui:validator name="custom" errorMessage='<%=LanguageUtil.get(request,"claims_select_nature_of_loss") %>' > 
										function (val, fieldNode, ruleValue) {
											return (val != '-1');
										}
									</aui:validator>									 
									
							</aui:select>
						</div>
					</div>
				</div>
						<div class="row">
					<div class="col-md-12 text-right no-pad">
						<ul class="list-btns">
							<li>
								<aui:button cssClass="btn btn-primary btn-lg btn-xs-block" type="submit" value="<%=LanguageUtil.get(request,"claims_proceed") %>"/>
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
	
	
});
</script>