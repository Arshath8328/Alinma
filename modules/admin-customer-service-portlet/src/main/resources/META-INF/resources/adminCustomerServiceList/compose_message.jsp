<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>


<%
	boolean signedIn = themeDisplay.isSignedIn();
%>
<div class="row">
	<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1">
		<div class="portlet-content no-margin">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
					<h4 class="text-primary"><liferay-ui:message key="leave_msg" /></h4>
					<aui:form role="form" method="post" id="composeForm" name="composeForm" >
						<aui:fieldset>
							<div class="row">
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
									<div class="form-group"> 
										<label class="control-label" for="formInput52"><liferay-ui:message key="serv_req" /></label>												 
										<aui:select id="srvReqCatDD" name="srvReqCatDD" cssClass="form-control" label=""> 
											<aui:option value="-1" selected="true" disabled="disabled"><liferay-ui:message key="please_select_option" /></aui:option>
											<aui:option value="complaints"><liferay-ui:message key="<%="Service_Request_Cat_complaints"%>" /></aui:option>
											<aui:option value="inquiries"><liferay-ui:message key="<%="Service_Request_Cat_inquiries"%>" /></aui:option>
											<aui:option value="suggestions"><liferay-ui:message key="<%="Service_Request_Cat_suggestions"%>" /></aui:option>
											<aui:validator name="custom" errorMessage='Please select from list' > 
												function (val, fieldNode, ruleValue) {
													return (val != '-1');
												}
											</aui:validator>
										</aui:select>
									</div>											 
								</div>
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
									<div class="form-group" id="srvReqTypeDD"> 
										<label class="control-label" for="formInput62"><liferay-ui:message key="type" /></label>
										<aui:select  id="emptyTypesDD" name="emptyTypesDD" cssClass="" label=""> 									
											<aui:option value="-1" selected="true" disabled="disabled"><liferay-ui:message key="please_select_option" /></aui:option>
										</aui:select>
										<aui:select  id="complaintTypesDD" name="complaintTypesDD" cssClass="" label=""> 									
											<aui:option value="-1" selected="true" disabled="disabled"><liferay-ui:message key="please_select_option" /></aui:option>
											<aui:option value="delay_in_claim"><liferay-ui:message key="Service_Request_Type_delay_in_claim" /></aui:option>
											<aui:option value="claim_amount_reduced"><liferay-ui:message key="Service_Request_Type_claim_amount_reduced" /></aui:option>
											<aui:option value="reject_claim"><liferay-ui:message key="Service_Request_Type_reject_claim" /></aui:option>
											<aui:option value="bad_behave"><liferay-ui:message key="Service_Request_Type_bad_behave" /></aui:option>
											<aui:option value="delay_in_policy_cancel"><liferay-ui:message key="Service_Request_Type_delay_in_policy_cancel" /></aui:option>
											<aui:option value="not_answering_the_calls"><liferay-ui:message key="Service_Request_Type_not_answering_the_calls" /></aui:option>
											<aui:option value="others"><liferay-ui:message key="Service_Request_Type_others" /></aui:option>
											<aui:validator name="custom" errorMessage='Please select from list' > 
												function (val, fieldNode, ruleValue) {
													return (val != '-1');
												}
											</aui:validator>
										</aui:select>
										<aui:select id="inquiryTypesDD" name="inquiryTypesDD" cssClass="hidden"  label=""> 
											<aui:option value="-1" selected="true" disabled="disabled"><liferay-ui:message key="please_select_option" /></aui:option>	
											<aui:option value="cancel_policy"><liferay-ui:message key="Service_Request_Type_cancel_policy" /></aui:option>
											<aui:option value="general_inquiries"><liferay-ui:message key="Service_Request_Type_general_inquiries" /></aui:option>
											<aui:option value="renewals"><liferay-ui:message key="Service_Request_Type_renewals" /></aui:option>
											<aui:option value="claims_process"><liferay-ui:message key="Service_Request_Type_claims_process" /></aui:option>
											<aui:option value="branch_location"><liferay-ui:message key="Service_Request_Type_branch_location" /></aui:option>
											<aui:option value="policy_changes"><liferay-ui:message key="Service_Request_Type_policy_changes" /></aui:option>
											<aui:option value="cheque_pick_up"><liferay-ui:message key="Service_Request_Type_cheque_pick_up" /></aui:option>
											<aui:option value="claims_status"><liferay-ui:message key="Service_Request_Type_claims_status" /></aui:option>
											<aui:option value="not_answering_the_calls"><liferay-ui:message key="Service_Request_Type_not_answering_the_calls" /></aui:option>
											<aui:option value="others"><liferay-ui:message key="Service_Request_Type_others" /></aui:option>
											<aui:validator name="custom" errorMessage='Please select from list' > 
												function (val, fieldNode, ruleValue) {
													return (val != '-1');
												}
											</aui:validator>
										</aui:select>
										<aui:select id="suggestionTypesDD" name="suggestionTypesDD" cssClass="hidden"  label=""> 
											<aui:option value="-1" selected="true" disabled="disabled"><liferay-ui:message key="please_select_option" /></aui:option>							
											<aui:option value="claims"><liferay-ui:message key="Service_Request_Type_claims" /></aui:option>
											<aui:option value="renewals"><liferay-ui:message key="Service_Request_Type_renewals" /></aui:option>
											<aui:option value="others"><liferay-ui:message key="Service_Request_Type_others" /></aui:option>
											<aui:validator name="custom" errorMessage='Please select from list' > 
												function (val, fieldNode, ruleValue) {
													return (val != '-1');
												}
											</aui:validator>
										</aui:select>
									</div>											 
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
									<div class="form-group"> 
										<label class="control-label" for="formInput45"><liferay-ui:message key="product" /></label>												 
										<select id="<portlet:namespace/>productID" name="<portlet:namespace/>productID" class="form-control"> 
											<option value="-1"><liferay-ui:message key="please_select_option" /></option>
											<option value="motor_comperh"><liferay-ui:message key="<%="Service_Request_Product_motor_comperh"%>" /></option>
											<option value="motor_tp"><liferay-ui:message key="<%="Service_Request_Product_motor_tp"%>" /></option>
											<option value="life_insurance_prods"><liferay-ui:message key="<%="Service_Request_Product_life_insurance_prods"%>" /></option>
											<option value="med_insurance_prods"><liferay-ui:message key="<%="Service_Request_Product_med_insurance_prods"%>" /></option>
											<option value="corp_prods"><liferay-ui:message key="<%="Service_Request_Product_corp_prods"%>" /></option>
										</select>
									</div>											 
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="ur_msg" /></label>
										<aui:input type="textarea" cssClass="form-control" id="msgTxt" name="msgTxt" rows="3" placeholder="enter_ur_msg" label="">
											<aui:validator name="required" errorMessage='Please Enter a request message' />
											<e:forHtmlContent value="${param.value}" />
										</aui:input>
									</div>											 
								</div>
							</div>
							
									<div class="row">
										<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
											<div class="form-group"> 
												<label class="control-label" for="custName"><liferay-ui:message key="name" /></label>												 
												<aui:input type="text" id="custName" placeholder="enter_your_name" name="custName" cssClass="form-control" label="">
													<aui:validator name="required"/>
												</aui:input>
											</div>											 
										</div>
										<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
											<div class="form-group"> 
												<label class="control-label" for="iqamaID"><liferay-ui:message key="saudi_id_iqama" /></label>												 
												<aui:input type="text" id="iqamaID" placeholder="1/2XXXXXXXXX" name="iqamaID" cssClass="form-control" label="">
												<aui:validator name="required"/>
 												<aui:validator name="custom" errorMessage='invalid_id_iqama'>
 													function (val, fieldNode, ruleValue) {
														return ( (val.startsWith("1") || val.startsWith("2")) && val.length == 10);
													}
 												</aui:validator>
												</aui:input>
											</div>											 
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
											<div class="form-group"> 
												<label class="control-label" for="<portlet:namespace/>custEmail"><liferay-ui:message key="email" /></label>												 
												<aui:input type="text" id="custEmail" placeholder="XXXX@XXXX.XXX" name="custEmail" cssClass="form-control" label="">
													<aui:validator name="required"/>
	 												<aui:validator name="email"/>
												</aui:input>
											</div>											 
										</div>
										<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
											<div class="form-group"> 
												<label class="control-label" for="custMobile"><liferay-ui:message key="mobile_number" /></label>
												<aui:input type="text" id="custMobile" placeholder="054 XXXXXXX" name="custMobile" cssClass="form-control" label="">
												<aui:validator name="required"/>
 												<aui:validator name="custom" errorMessage='invalid_mobile' >
 													function (val, fieldNode, ruleValue) {
														return (val.startsWith("05") && val.length == 10);
													}
 												</aui:validator>
												</aui:input>
											</div>											 
										</div>
									</div>
									<div class="row">
										<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
											<div class="form-group"> 
												<label class="checkbox-inline" for="<portlet:namespace/>sendCopyCB">												 
													<input type="checkbox" id="<portlet:namespace/>sendCopyCB" name="<portlet:namespace/>sendCopyCB" class="form-check-input" />
													<liferay-ui:message key="send_copy" />
												</label> 
											</div>											 
										</div>
									</div>
							
							<div class="row">
								<div class="col-md-12 text-right no-pad">
									<ul class="list-btns">
										<li>
											<aui:a id="cancelBtn" name="cancelBtn" cssClass="btn btn-lg btn-xs-block btn-outline btn-default" role="button" href="/group/staff/manage_customer_service" label="">
												<liferay-ui:message key="cancel" />
											</aui:a>
										</li>
										<li>
											<button id="submitCustomerRequest" onclick="validateCompose()" class="btn btn-primary btn-lg btn-xs-block" type="button"><liferay-ui:message key="send" /> <i class="material-icons md-24">&#xE163;</i></button>
										</li>
									</ul>
								</div>
							</div>
						</aui:fieldset>
					</aui:form>
				</div>
			</div>
		</div>					 
	</div>
</div>
<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div class="text-center">
		<h2><liferay-ui:message key="message_sent" /></h2>
	</div>
</div>
<portlet:resourceURL var="resourceURL"/>


<script>
	$(document).ready(function(){
		
		$("#<portlet:namespace/>sendCopyCB").click();
		$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().attr("hidden", "true");
		$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().attr("hidden", "true");
		$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().attr("hidden", "true");
		$("#<portlet:namespace/>srvReqCatDD").on("change", function(){
			var selectedVal = $(this).val();
			if(selectedVal == "complaints")
			{
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", false).parent().removeAttr("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().attr("hidden","true");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().attr("hidden","true");
			}
			else if(selectedVal == "inquiries")
			{
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", false).parent().removeAttr("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", false).parent().removeAttr("hidden");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().attr("hidden", "true");
			}
			else if(selectedVal == "suggestions")
			{
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", false).parent().removeAttr("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().attr("hidden", "true");
			}
			else
			{
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", false).parent().removeAttr("hidden");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().attr("hidden", "true");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().attr("hidden", "true");
			}
			$("#srvReqTypeDD [role='alert']").parent().remove();
			$("#srvReqTypeDD .has-error").removeClass('has-error');
		});
	});




function validateCompose()
{
	
	var myFormValidator = eval("Liferay.Form._INSTANCES.<portlet:namespace/>composeForm.formValidator");
	
	if($("#<portlet:namespace/>complaintTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>complaintTypesDD");
	else if($("#<portlet:namespace/>inquiryTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>inquiryTypesDD");
	else if($("#<portlet:namespace/>suggestionTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>suggestionTypesDD");
	
	myFormValidator.validateField("<portlet:namespace/>srvReqCatDD");
	myFormValidator.validateField("<portlet:namespace/>msgTxt");
	
	if(!<%=signedIn%>)
	{
		myFormValidator.validateField("<portlet:namespace/>custName");
		myFormValidator.validateField("<portlet:namespace/>iqamaID");
		myFormValidator.validateField("<portlet:namespace/>custEmail");
		myFormValidator.validateField("<portlet:namespace/>custMobile");
	}
	
	var elementExists = $(".g-recaptcha").length;
    if(elementExists>0){
    	$( "#temp" ).remove();
		var captchaValue = grecaptcha.getResponse();
		if(captchaValue.length == 0) {
			$("#callback-blankCatcha").append('<label id="temp"	style="color: #c60f13 !important; line-height: normal; font-size: 14px !important;">Captcha	is required.</label>');
			$("#callback-blankCatcha").show();
			return false;
		}
     }

	if (!myFormValidator.hasErrors()) {
		document.getElementById("submitCustomerRequest").disabled=true
		submitForm();
	}
}

function callback(){
	$("#callback-blankCatcha").hide();
	$( "#temp" ).hide();
    return true; 
}

function submitForm()
{
		
	AUI().use('aui-base', 'io','aui-io-request', function(A){
		
        A.io.request('<%=resourceURL.toString()%>', {
               method: 'post',
               dataType: 'json',
               form: {
                   id: '<portlet:namespace/>composeForm'
               },
               on: {
                    success: function(data)
                    {
                    	var res = this.get('responseData');
                    	if(res == 'success') successFn();
                    	else if(res == 'error') {
                    		window.location = '/group/customer/compose_new_service_request';
                    	}
                    	else if(res == 'XSS_ERROR') {
                    		window.location = '/web/customer/error';
                    	}
                    	
                    }
               }
            });
    });
}

function successFn()
{
	document.getElementById("submitCustomerRequest").disabled=false;
	AUI().use('aui-base', 'io','aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				cssClass: "compose-dialog",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '<h4><liferay-ui:message key="cust_serv" /></h4>',
				centered: true,
				modal: true,
				height: 230,
				render: '#aui_popup_content'
			});
			dialog.addToolbar(
			      [
			        {
			          label: 'Done',
			          cssClass: 'btn-primary',
			          on: {
			            click: function() {
			            	dialog.hide();
			            }
			          }
			        }
			      ]
			    );
			dialog.on('visibleChange', function(event) {
				if (!event.newVal) {
					if(<%=signedIn%>)
					{
						window.location = '/group/customer/customer_service';
					}
					else
					{
						$('input, textarea').val('');
						$('#<portlet:namespace/>complaintTypesDD').val('-1');
						$('#<portlet:namespace/>productID').val('-1');
					}
				}
			});
		});	
}

</script>
<%-- 
<script>
	$(document).ready(function(){
		
		$("#<portlet:namespace/>inquiryTypesDD").removeClass("hidden").prop("disabled", true).parent().addClass("hidden");
		$("#<portlet:namespace/>suggestionTypesDD").removeClass("hidden").prop("disabled", true).parent().addClass("hidden");
		$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().addClass("hidden");
		
		$("#<portlet:namespace/>srvReqCatDD").on("change", function(){
			var selectedVal = $(this).val();
			if(selectedVal == "complaints")
			{
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", false).parent().removeClass("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().addClass("hidden");
			}
			else if(selectedVal == "inquiries")
			{
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", false).parent().removeClass("hidden");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().addClass("hidden");
			}
			else if(selectedVal == "suggestions")
			{
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", false).parent().removeClass("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", true).parent().addClass("hidden");
			}
			else
			{
				$("#<portlet:namespace/>emptyTypesDD").prop("disabled", false).parent().removeClass("hidden");
				$("#<portlet:namespace/>complaintTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>suggestionTypesDD").prop("disabled", true).parent().addClass("hidden");
				$("#<portlet:namespace/>inquiryTypesDD").prop("disabled", true).parent().addClass("hidden");
			}
			$("#srvReqTypeDD [role='alert']").parent().remove();
			$("#srvReqTypeDD .has-error").removeClass('has-error');
		});
	});
</script>

<aui:script>

function validateCompose()
{
	var myFormValidator = eval('Liferay.Form._INSTANCES.<portlet:namespace/>composeForm.formValidator');
	
	if($("#<portlet:namespace/>complaintTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>complaintTypesDD");
	else if($("#<portlet:namespace/>inquiryTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>inquiryTypesDD");
	else if($("#<portlet:namespace/>suggestionTypesDD").is(":visible")) 
		myFormValidator.validateField("<portlet:namespace/>suggestionTypesDD");
	
	myFormValidator.validateField("<portlet:namespace/>msgTxt");
	myFormValidator.validateField("<portlet:namespace/>srvReqCatDD");

	myFormValidator.validateField("<portlet:namespace/>custName");
	myFormValidator.validateField("<portlet:namespace/>iqamaID");
	myFormValidator.validateField("<portlet:namespace/>custEmail");
	myFormValidator.validateField("<portlet:namespace/>custMobile");

	if (!myFormValidator.hasErrors()) {
		document.getElementById("submitCustomerRequest").disabled=true;
		submitForm();
	}
}

function submitForm()
{
		
	AUI().use('aui-base', 'io','aui-io-request', function(A){
		
        A.io.request('<%=resourceURL.toString()%>', {
               method: 'post',
               dataType: 'json',
               form: {
                   id: '<portlet:namespace/>composeForm'
               },
               on: {
                    success: function(data)
                    {
                    	var res = this.get('responseData');
                    	if(res == 'success') successFn();
                    	else if(res == 'error') {
                    		window.location = '/group/staff/compose_new_service_request';
                    	}
                    }
               }
            });
    });
}

function successFn()
{
	document.getElementById("submitCustomerRequest").disabled=false;
	AUI().use('aui-modal','aui-base', 'io','aui-io-request', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '<h3><liferay-ui:message key="cust_serv" /></h3>',
				centered: true,
				modal: true,
				width: 500,
				height: 300,
				render: '#aui_popup_content'
			});
			dialog.addToolbar(
			      [
			        {
			          label: 'Done',
			          cssClass: 'btn-primary',
			          on: {
			            click: function() {
			            	dialog.hide();
			            }
			          }
			        }
			      ]
			    );
			dialog.on('visibleChange', function(event) {
				if (!event.newVal) {
					if(<%=signedIn%>)
					{
						window.location = '/group/staff/manage_customer_service';
					}
					else
					{
						$('input, textarea').val('');
						$('#<portlet:namespace/>complaintTypesDD').val('-1');
						$('#<portlet:namespace/>productID').val('-1');
					}
					
				}
			});
		});	
}


</aui:script> --%>