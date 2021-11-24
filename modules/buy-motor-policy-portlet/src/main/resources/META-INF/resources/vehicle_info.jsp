<%@page import="com.ejada.atmc.acl.db.model.CodeMaster"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.Quotation"%>
<%@ include file="init.jsp"%>


<link rel="stylesheet" type="text/css"
	href="/o/atmc-theme/vendor/bootstrap_select/css/bootstrap-select.min.css">
<script
	src="/o/atmc-theme/vendor/bootstrap_select/js/bootstrap-select.min.js"></script>
<%
	boolean isBack = ParamUtil.getBoolean(request, "isBack");
	Quotation quot = (Quotation) request.getAttribute("quot");
	//System.out.print("quot details inside vehicle info jsp "+quot);

	boolean genericError = (request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR) != null)
			? ((Boolean) request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR))
			: false;
	String genericMessage = (genericError)
			? (String) request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE)
			: "";
	if (genericError || quot.isRenew())
		isBack = true;

	boolean hasExistingIns = (isBack && quot.getExistingCompanyName() != null) ? true : false;
	List insCompanies = (List) request.getAttribute("insCompanies");
	List purposeList = (List) request.getAttribute("purposeList");
	List cities = (List) request.getAttribute("cities");
	List dedVals = (List) request.getAttribute("dedVals");
	List parkLocs = (List) request.getAttribute("parkLocs");
	List engineSizes = (List) request.getAttribute("engineSizes");

	Gson gson = new Gson();
	String quotDets = gson.toJson(quot);
	quotDets = quotDets.replaceAll("\"", "'");
%>
<portlet:actionURL name="personalInfo" var="personalInfo">
	<portlet:param name="isBack" value="true" />
</portlet:actionURL>
<form id="personalInfoBackForm" name="personalInfoBackForm" role="form"
	action="<%=personalInfo%>" method="post">
	<input type="hidden" name="<portlet:namespace/>quot"
		value="<%=quotDets%>" /> <input type="hidden"
		name="<portlet:namespace/>myview" value="personal_info" />
</form>

<portlet:actionURL name="insuranceOptions" var="insuranceOptions">
</portlet:actionURL>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))
					? LanguageUtil.get(request, "comp_product")
					: LanguageUtil.get(request, "tpl_product")%></h3>
	</div>
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive"
			src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="66"
				aria-valuemin="0" aria-valuemax="100" style="width: 66%;">
				<span class="sr-only">66% Complete</span>
			</div>
		</div>
	</div>
</div>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<div class="row">
			<div
				class="col-sm-12 col-xs-12 col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1">
				<div class="portlet-content">
					<ul class="nav nav-pills nav-stacked nav-justified">
						<li class="disabled" style="width:33.333%; float:left"><a
							class="text-primary" href="javascript:void(0);"> <i
								class="icon icon-id-card md-36"></i> <liferay-ui:message
									key="personal_info" />
						</a></li>
						<li style="width:33.333%; float:left"><a href="javascript:void(0);"> <i
								class="icon icon-transport-3 md-36"></i> <liferay-ui:message
									key="vehicle_info" />
						</a></li>
						<li class="disabled" style="width:33.333%; float:left"><a
							href="javascript:void(0);"> <i class="icon icon-shield md-36"></i>
								<liferay-ui:message key="insurance_options" />
						</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div
				class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
				<div class="portlet-content">
					<aui:form id="form2" name="form2" role="form"
						action="<%=insuranceOptions%>" method="post"
						enctype="multipart/form-data">
						<input type="hidden" name="<portlet:namespace/>myview"
							value="insurance_options" />
						<input type="hidden" name="<portlet:namespace/>quot"
							value="<%=quotDets%>" />
						<ul class="list-group no-margin">
							<li class="list-group-item bg-gray"><liferay-ui:message
									key="veh_det" /></li>
							<li class="list-group-item">
								<div class="row">
									<%
										if (!(String.valueOf(quot.getVehicleIdType())).equals(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD)) {
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="plate_type" /> </label> <input class="form-control"
												type="text"
												placeholder='<liferay-ui:message key="private_car"/>'
												value="<%=quot.getVehiclePlateTypeDesc()%>" disabled />
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="plate_no" /></label>
											<div class="row">
												<div class="col-md-3">
													<input class="form-control" type="text" placeholder="5836"
														value="<%=quot.getVehiclePlateNo()%>" disabled />
												</div>
												<div class="col-md-3">
													<input class="form-control" type="text" placeholder="1/A"
														value="<%=quot.getVehiclePlateL1()%>" disabled />
												</div>
												<div class="col-md-3">
													<input class="form-control" type="text" placeholder="1/A"
														value="<%=quot.getVehiclePlateL2()%>" disabled />
												</div>
												<div class="col-md-3">
													<input class="form-control" type="text" placeholder="1/A"
														value="<%=quot.getVehiclePlateL3()%>" disabled />
												</div>
											</div>
										</div>
									</div>
									<%
										} else {
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="chassis_no" /> </label> <input class="form-control"
												type="text"
												placeholder='<liferay-ui:message key="private_car"/>'
												value="<%=quot.getVehicleChassisNo()%>" disabled />
										</div>
									</div>
									<%
										}
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="city" /> </label> <select class="form-control"
												name="<portlet:namespace/>city"
												id="<portlet:namespace/>city"
												<%=("" + quot.getVehicleIdType()).equals(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)
						? "disabled"
						: ""%>>
												<option value="-1"><liferay-ui:message
														key="please_select_option" /></option>
												<%
													String addressCityCode = "";

														for (int cityCount = 0; cities != null && cityCount < cities.size(); cityCount++) {
															CodeMasterDetails city = (CodeMasterDetails) cities.get(cityCount);
															// setting address city code for the policy issuance call
															if (city.getCodeDesc() != null && city.getCodeDesc().equalsIgnoreCase(quot.getCityDesc()))
																addressCityCode = city.getCodeSub();
												%>
												<option
													<%=(quot.getVehicleCity() != null && quot.getVehicleCity().equals(city.getCodeSub()))
							? "selected"
							: ""%>
													value="<%=city.getCodeSub()%>"><%=(currLocale.equals("en_US")) ? city.getCodeDesc() : city.getCodeDescAr()%></option>
												<%
													}
												%>
											</select> <input type="hidden"
												name="<portlet:namespace/>addressCityCode"
												value="<%=addressCityCode%>" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="purpose_veh" /> </label> <select class="form-control"
												name="<portlet:namespace/>vPurpose">
												<option value="-1" selected><liferay-ui:message
														key="please_select_option" /></option>
												<%
													for (int pCount = 0; purposeList != null && pCount < purposeList.size(); pCount++) {
															String selected = "";
															CodeMasterDetails purpose = (CodeMasterDetails) purposeList.get(pCount);

															if (isBack && quot.getPurposeOfVehicle() != null
																	&& quot.getPurposeOfVehicle().equals(purpose.getCodeSub()))
																selected = "selected";
												%>
												<option <%=selected%>
													value="<%=purpose.getCodeSub() + ";"
							+ ((currLocale.equals("en_US")) ? purpose.getCodeDesc() : purpose.getCodeDescAr())%>"><%=(currLocale.equals("en_US")) ? purpose.getCodeDesc() : purpose.getCodeDescAr()%></option>
												<%
													}
												%>
											</select>
										</div>
									</div>
									<%
										if (quot.getVehicleIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ID_TYPE_CUSTOM_CARD)) {
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-label"> <liferay-ui:message
													key="cust_card" />
											</label> <input readonly
												id="<portlet:namespace/>selectedCustCardFile"
												name="<portlet:namespace/>selectedCustCardFile"
												class="form-control"
												onclick="$('#<portlet:namespace/>selectedCustCardFile').val('');$('#<portlet:namespace/>custCardFile').click();"
												value="<%=(isBack && quot.getCustCardFileName() != null) ? quot.getCustCardFileName() : ""%>"
												placeholder='<liferay-ui:message key="sel_file_loc"/>' /> <span
												class="glyphicon form-control-feedback glyphicon-paperclip text-muted" />
											<input type="file" name="<portlet:namespace/>custCardFile"
												id="<portlet:namespace/>custCardFile" class="sr-only"
												label=""
												onchange="$('#<portlet:namespace/>selectedCustCardFile').val(this.files.item(0).name);" />
										</div>
									</div>
									<%
										}
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="veh_val" /></label> <input class="form-control" type="text"
												placeholder="20,000.00 SAR"
												name="<portlet:namespace/>vValue"
												<%=(isBack) ? ("value='" + quot.getVehicleValue() + "'") : ""%>
												id="vValue" />
										</div>
									</div>
									<%
										Calendar cal = new GregorianCalendar();
											cal.setTime(new Date());
											long mfgYear = quot.getVehicleMfgYear();
											long diff = cal.get(Calendar.YEAR) - mfgYear;

											/* if(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))
											{ */
									%>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12 dValueDiv">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="ded_val" /> </label> <select class="form-control"
												name="<portlet:namespace/>dedValue" id="dedValue">
												<option value="-1" selected><liferay-ui:message
														key="please_select_option" /></option>
												<%
													for (int pCount = 0; dedVals != null && pCount < dedVals.size(); pCount++) {
															CodeMasterDetails dVal = (CodeMasterDetails) dedVals.get(pCount);
												%>
												<option value="<%=dVal.getCodeSub()%>"
													<%=(quot.getDeductibleValue() != null && quot.getDeductibleValue().equals(dVal.getCodeSub()))
							? "selected"
							: ""%>><%=(dVal != null && !dVal.equals(""))
							? numberFormat.format(Double.valueOf(dVal.getCodeDesc()))
							: ""%> SAR
												</option>
												<%
													}
												%>
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="repair_opts" /></label> <select class="form-control"
												name="<portlet:namespace/>repairOptions" id="repairOptions"
												<%=(diff > 5) ? "readonly" : ""%>>
												<option value="-1" selected><liferay-ui:message
														key="please_select_option" /></option>
												<%
													if (diff > 5) {
												%>
												<option value="0" selected><liferay-ui:message
														key="workshop_repair" /></option>
												<%
													} else {
												%>
												<option value="1"
													<%=(isBack && quot.getAgencyRepair() != null && quot.getAgencyRepair().equals("1"))
							? "selected"
							: ""%>><liferay-ui:message
														key="agency" /></option>
												<option value="0"
													<%=(isBack && quot.getAgencyRepair() != null && quot.getAgencyRepair().equals("0"))
							? "selected"
							: ""%>><liferay-ui:message
														key="non_agency" /></option>
												<%
													}
												%>
											</select> <small class="text-primary"><liferay-ui:message
													key="agency_repair" /></small>
										</div>
									</div>
									<%-- <%
	}
%> --%>
								</div>
							</li>
						</ul>
						<br />
						<br />
						<ul class="list-group no-margin">
							<li class="list-group-item bg-gray"><liferay-ui:message
									key="quest_ans" /></li>
							<li class="list-group-item">
								<div class="row">
									<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
										<p>
											<liferay-ui:message key="ans_me" />
										</p>
										<div class="form-group">
											<label class="control-label text-primary"><liferay-ui:message
													key="acc_part" /> </label> <label class="switch control-label">
												<input type="checkbox" name="<portlet:namespace/>accDeath"
												value="true"
												<%=(isBack && quot.isAccDeath()) ? "checked='true'" : ""%> />
												<div></div> <span
												label-yes='<liferay-ui:message key="yes"/>'
												label-no='<liferay-ui:message key="no"/>'></span>
											</label>
										</div>
										<div class="form-group">
											<label class="control-label text-primary"><liferay-ui:message
													key="motor_accident" /> </label> <label
												class="switch control-label"> <input type="checkbox"
												name="<portlet:namespace/>vehMotorAcc" value="true"
												<%=(isBack && quot.isVehMotorAcc()) ? "checked='true'" : ""%> />
												<div></div> <span
												label-yes='<liferay-ui:message key="yes"/>'
												label-no='<liferay-ui:message key="no"/>'></span>
											</label>
										</div>
										<div class="form-group">
											<label class="control-label text-primary"><liferay-ui:message
													key="traffic_viols" /> </label> <label
												class="switch control-label"> <input type="checkbox"
												name="<portlet:namespace/>convTraffViols" value="true"
												<%=(isBack && quot.isConvTraffViols()) ? "checked='true'" : ""%> />
												<div></div> <span
												label-yes='<liferay-ui:message key="yes"/>'
												label-no='<liferay-ui:message key="no"/>'></span>
											</label>
										</div>
										<div class="form-group">
											<label class="control-label text-primary"><liferay-ui:message
													key="policy_any_ins_co" /></label> <label
												class="switch control-label"> <input type="checkbox"
												id="otherInsChk" onclick="manageOtherCompany($(this));"
												<%=(isBack && (quot.getExistingPolicyNo() != null)) ? "checked='true'" : ""%> />
												<div></div> <span
												label-yes='<liferay-ui:message key="yes"/>'
												label-no='<liferay-ui:message key="no"/>'></span>
											</label>
										</div>
									</div>
								</div>
								<div class="row otherCompDiv" style="display: none;">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="ins_comp" /> </label> <select class="form-control"
												name="<portlet:namespace/>InsCo" id="InsCo">
												<option value="-1" selected><liferay-ui:message
														key="please_select_option" /></option>
												<%
													for (int cCount = 0; insCompanies != null && cCount < insCompanies.size(); cCount++) {
															CodeMaster insCo = (CodeMaster) insCompanies.get(cCount);

															String selected = "";
															if (isBack && quot.getExistingCompanyName() != null
																	&& quot.getExistingCompanyName().equals(insCo.getCode()))
																selected = "selected";
												%>
												<option value="<%=insCo.getCode()%>" <%=selected%>><%=(currLocale.equals("en_US")) ? insCo.getCodeDesc() : insCo.getCodeDescAr()%></option>
												<%
													}
												%>
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message
													key="claims_policy_number" /> </label> <input type="text"
												class="form-control" name="<portlet:namespace/>InsPolicyNo"
												id="InsPolicyNo"
												value="<%=(isBack && quot.getExistingPolicyNo() != null) ? quot.getExistingPolicyNo() : ""%>" />
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message
													key="exp_date" /> </label> <input type="text" class="form-control"
												readonly="readonly" name="<portlet:namespace/>InsExp"
												id="InsExp"
												value="<%=(isBack && quot.getExistingExpDate() != null) ? quot.getExistingExpDate() : ""%>" />
											<span
												class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
										</div>
									</div>
								</div>
							</li>
						</ul>
						<div class="row">
							<div class="col-md-12 text-right no-pad">
								<ul class="list-btns">
									<li>
										<button class="btn btn-lg btn-xs-block btn-link text-muted"
											onclick="$('#personalInfoBackForm').submit();" role="button"
											type="button">
											<i class="material-icons md-24">&#xE5C4;</i>
											<liferay-ui:message key="back" />
										</button>
									</li>
									<li>
										<button class="btn btn-primary btn-lg btn-xs-block"
											type="button" onclick="validateVehFormAndSubmit();">
											<liferay-ui:message key="continue" />
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
</div>
<div id="aui_popup_content"></div>
<div id="aui_popup_body" style="display: none;">
	<div class="text-center">
		<h4 style="overflow-wrap: break-word;"><%=genericMessage%></h4>
	</div>
</div>
<script>
$(function () {
	$('[data-toggle="popover"]').popover()
});
$(document).on("keypress", ":input:not(textarea)", function(event) {
    return event.keyCode != 13;
});
var genericError = <%=genericError%>;
if(genericError)
{
	AUI().use('aui-modal', function(A) {
		var dialog = new A.Modal({
			title: "Generic Error",
			bodyContent: AUI().one('#aui_popup_body').html(),
			headerContent: '<h4 class="no-margin"><liferay-ui:message key="gen_err"/></h4>',
			centered: true,
			modal: true,
			height: 200,
			render: '#aui_popup_content'
		});
		dialog.render();
	});
}
$("#InsExp").calendarsPicker({
	calendar: $.calendars.instance('gregorian'<%=currLocale.equals("en_US") ? "" : ",'ar-EG'"%>),
	dateFormat: 'dd/mm/yyyy',
	yearRange: 'c-100:c+0',
	<%=currLocale.equals("en_US") ? "" : " isRTL: true"%>
});

var isBack = <%=isBack%>;
var hasExistingIns = <%=hasExistingIns%>;
if(isBack && hasExistingIns)
{
	manageOtherCompany($("#otherInsChk"));
}

function manageOtherCompany(obj)
{
	if(obj.is(":checked"))
		$(".otherCompDiv").show();
	else
		$(".otherCompDiv").hide();
}
var frmValidator;
function validateVehFormAndSubmit()
{
	if (frmValidator)
		frmValidator.resetAllFields();
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
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
				},
				checkFilename:function(val,node,junction){
					var fileInput = document.getElementById("<portlet:namespace/>idFile");
					var fileName = "";
					if(fileInput.files.length>0)
						fileName = fileInput.files.item(0).name;
						var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
						return regex.test(fileName);
				}
			},
		    true
		);
		
		A.mix(A.config.FormValidator.STRINGS,
			{
				uploadFileSize:'<liferay-ui:message key="max_upload_size"/>',
				vValue:'<liferay-ui:message key="max_vehicle_value"/>',
				custDropDown:'<liferay-ui:message key="plz_select_value"/>'
			},
			true
		);
		var rules = 
		{
			<portlet:namespace/>vPurpose: {
				custDropDown: true
		    },
			<portlet:namespace/>selectedCustCardFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>selectedCarFrontFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>selectedCarBackFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>selectedCarLeftFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>selectedCarRightFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>selectedEngChassNoFile: {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX'
		    },
		    <portlet:namespace/>vValue: {
				required: true,
				number: true,
				range:[20000,200000],
		    },
			<portlet:namespace/>repairOptions: {
				custDropDown: true
		    },
		    <portlet:namespace/>currMile: {
				required: true,
				number: true,
				min:1
		    },
		    <portlet:namespace/>expMileRange: {
				required: true,
				custDropDown: true
		    },
		    <portlet:namespace/>nightLocation: {
				required: true,
				custDropDown: true
		    },
		    <portlet:namespace/>engSize: {
				required: true,
				custDropDown: true
		    },
		    <portlet:namespace/>transType: {
				required: true,
				custDropDown: true
		    },
		    <portlet:namespace/>vehAxle: {
				required: false,
				number: true,
				min:1
		    }
		}
		if($(".dValueDiv").is(":visible"))
		{
			rules.<portlet:namespace/>dedValue = {
					custDropDown: true
	        }
		}

		if(!$("select[name='<portlet:namespace/>city']").attr("disabled"))
		{
			rules.<portlet:namespace/>city = {
				custDropDown: true
		    }
		}
		if($(".otherCompDiv").is(":visible"))
		{
			
			rules.<portlet:namespace/>InsCo = {
					custDropDown: true
	        }
			rules.<portlet:namespace/>InsPolicyNo = {
		            required: true
		    }
			rules.<portlet:namespace/>InsExp = {
		            required: true
		    }
				
		}
		
		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>form2',
		    rules:rules,
		    validateOnBlur: false
		    
		});
		
	});
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
		var inputTemplate = "<input type='hidden' name='' value=''/>";
		$(inputTemplate).attr('name','<portlet:namespace/>addressCityCode').val($("#<portlet:namespace/>addressCityCode").val()).appendTo('#<portlet:namespace/>form2');
		//populateVehSpecs();
		$("#<portlet:namespace/>form2").submit();
	}
}	
function validateUploadSize(objId, maxSize)
{
	var uploadSize=true;
	var fileObjId = $("#"+objId).closest(".form-group").find("input[type='file']").attr("id");
	var fileInput = document.getElementById(fileObjId);
    var size=0;
    for(var num1=0;num1<fileInput.files.length;num1++)
    {
		var file=fileInput.files[num1];
		if(file.size>maxSize)
		{
			fileInput.focus();
			uploadSize=false;
		}
		else
		{
			uploadSize=true;
		}
		size+=file.size;
		var fileName = file.name;
		var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
		if(uploadSize)
			uploadSize = regex.test(fileName);
    }
    return uploadSize;
}
</script>
