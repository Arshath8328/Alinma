<%@page import="com.atmc.bsl.db.domain.quotation.QuotationDriver"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.liferay.portal.kernel.service.persistence.PortletUtil"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="init.jsp"%>
<%
	boolean isBack = ParamUtil.getBoolean(request, "isBack");
	if(ParamUtil.getBoolean(request, "missingRenewParams"))
		isBack = true;
	Quotation quot = (Quotation)request.getAttribute("quot");
	boolean underAgeDriver = (isBack)?quot.isUnderAgeDriver():false;
	List educationList = (List)request.getAttribute("educationList");
	Gson gson = new Gson();
	String quotDets = gson.toJson(quot);
	quotDets = quotDets.replaceAll("\"", "'");
	boolean isMainDriver = quot.isMainDriver();
	//boolean invIBAN = request.getAttribute("invalidIBAN") != null ? (boolean)request.getAttribute("invalidIBAN") : false;

%>
<portlet:actionURL name="vehicleInfo" var="vehicleInfo" >
</portlet:actionURL>

<portlet:actionURL name="landing" var="landing">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>
<form id="landingBackForm" name="landingBackForm" role="form" action="<%=landing %>" method="post">
	<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
	<input type="hidden" name="<portlet:namespace/>isMainDriver" value="<%=isMainDriver %>"/>
</form>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1">
		<%-- <h3 class="text-primary"><%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?LanguageUtil.get(request, "comp_product"):LanguageUtil.get(request, "tpl_product") %></h3> --%>
	</div>
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%;">
				<span class="sr-only">33% Complete</span>
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
						<li style="width:33.333%; float:left">
							<a class="text-primary" href="javascript:void(0);">
								<i class="icon icon-id-card md-36"></i> <liferay-ui:message key="personal_info"/>
							</a>
						<li class="disabled" style="width:33.333%; float:left">
							<a href="javascript:void(0);">
								<i class="icon icon-transport-3 md-36"></i> <liferay-ui:message key="vehicle_info"/>
							</a>
						</li>
						<li class="disabled" style="width:33.333%; float:left">
							<a href="javascript:void(0);">
								<i class="icon icon-shield md-36"></i> <liferay-ui:message key="insurance_options"/>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-sm-12 col-xs-12 col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1">
				<div class="portlet-content">
				<form id="<portlet:namespace/>form1" name="<portlet:namespace/>form1" role="form" action="<%=vehicleInfo %>" method="post" enctype="multipart/form-data">
				<ul class="list-group no-margin"> 
					<li class="list-group-item bg-gray"><liferay-ui:message key="personal_det"/></li>	
					<li class="list-group-item">					
							 <liferay-ui:error key="invalid_iban" message="Invalid IBAN" /> 
						<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
						<input type="hidden" name="<portlet:namespace/>myview" value="vehicle_info"/>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="veh_owner_name"/></label>
									<input class="form-control" type="text" placeholder="XXXXXXXXXX" disabled value="<%=quot.getInsuredName()%>"/>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="dob_g"/></label>
									<input class="form-control" type="text" placeholder="XXXXXXXXXX" disabled value="<%=(quot.getInsuredDob()!=null && !quot.getInsuredDob().equals(""))?dateFormatter.format(quot.getInsuredDob()):""%>"/>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="education"/></label>
									<select name="<portlet:namespace/>education" id="<portlet:namespace/>education" class="form-control">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
<%
	for(int eCount=0; educationList!=null && eCount<educationList.size();eCount++)
	{
		CodeMasterDetails edu = (CodeMasterDetails)educationList.get(eCount);
		String selected = "";
		if(isBack && quot.getInsuredEducation()!=null && quot.getInsuredEducation().equals(edu.getCodeSub()))
			selected = "selected";
%>	
												<option value="<%=edu.getCodeSub()%>" <%=selected %>><%=currLocale.equals("en_US")?edu.getCodeDesc():edu.getCodeDescAr()%></option>
<%
	}
%>										
									</select>
								</div>
							</div>
<%-- <%
	if(quot.getInsuredIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_SAUDI))
	{
%>	 --%>						
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="marital_status"/></label>
									<select name="<portlet:namespace/>maritalStatus" id="<portlet:namespace/>maritalStatus" class="form-control">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="Single" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Single"))?"selected":"" %>><liferay-ui:message key="single" /></option>
										<option value="Married" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Married"))?"selected":"" %>><liferay-ui:message key="married" /></option>
										<%-- <option value="Widowed" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Widowed"))?"selected":"" %>><liferay-ui:message key="status_widowed" /></option>
										<option value="Divorced" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Divorced"))?"selected":"" %>><liferay-ui:message key="status_divorced" /></option>
										<option value="Seperated" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Seperated"))?"selected":"" %>><liferay-ui:message key="status_seperated" /></option> --%>
										<option value="Others" <%=(isBack && quot.getInsuredMaritalStatus()!=null && quot.getInsuredMaritalStatus().equals("Others"))?"selected":"" %>><liferay-ui:message key="status_others" /></option>
									</select>
								</div>
							</div>
<%-- <%
	}
%> --%>							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="no_child_16"/></label>
									<select name="<portlet:namespace/>childUnder16" id="<portlet:namespace/>childUnder16" class="form-control">
<%
	for(int cCount=0; cCount<11;cCount++)
	{
		String selected = "";
		if(isBack && quot.getInsuredNoChildUnder16() == cCount)
			selected = "selected";
		
%>	
												<option value="<%=cCount%>" <%=selected %>><%=cCount%></option>
<%
	}
%>										
									</select>
								</div>
							</div>
							<%-- <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="veh_acc_no"/></label>
									<input class="form-control" type="text" name="<portlet:namespace/>iban" id="iban" placeholder="SA 40395000XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" value="<%=(isBack && quot.getVehicleOwnerIban()!=null)?quot.getVehicleOwnerIban():""%>" oninput="this.value = this.value.toUpperCase();"/>
									<small><liferay-ui:message key="mistake_resp"/></small>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<input class="form-control" type="text" name="<portlet:namespace/>copyIban" id="copyIban" onpaste="return false;" placeholder="<liferay-ui:message key="confirm_veh_acc_num"/>" oninput="this.value = this.value.toUpperCase();"/>
								</div>
							</div> --%>
<%
	if(isMainDriver)
	{
%>	
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<p class="text-primary"><liferay-ui:message key="valid_driver_add"/></p>
									<label class="switch control-label">
										<input type="checkbox" name="<portlet:namespace/>underAgeDriver" id="underAgeDriver" value="true" onclick="manageReason($(this));" <%=(isBack && quot.isUnderAgeDriver())?"checked='true'":"" %>/>
										<div></div>
										<span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
									</label>
								</div>
							</div>
<%
	}
%>
						</div>
					</li>
				</ul><br/>
				<ul class="list-group no-margin"> 
					<li class="list-group-item bg-gray"><liferay-ui:message key="add_drvs"/></li>					 
					<li class="list-group-item">
						<div class="row text-center" data-pg-collapsed>
							<span class="text-muted drv_stat">
								<liferay-ui:message key="<%=(isMainDriver)?"add_add_drv":"no_add_drv" %>"/>
							</span>
						</div>
						<div class="row" data-pg-collapsed>
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<table class="table table-bordered driversTbl">
<%
	if(isBack && quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty())
	{
		for(QuotationDriver drv:quot.getQuotationDrivers())
		{
			String drvDets = gson.toJson(drv);
			drvDets = drvDets.replaceAll("\"", "'");
			drvDets = drvDets.replaceAll(",", "#");
%>	
									<tr>
										<td class=" bg-gray"><%=drv.getDriverName() %>
											<div class="row pull-right">
												<div class="col-md-6" style="border-right:1px solid #ddd;">
													<span class="btn btn-link no-pad" onclick="editDriverPopup(this);">
														<i class="glyphicon glyphicon-pencil text-primary"></i>
													</span>
												</div>
												<div class="col-md-6">
													<span class="btn btn-link no-pad" onclick="confirmRemove(this);">
														<i class="glyphicon glyphicon-trash text-danger"></i>
													</span>
												</div>
											</div>
											<input type="hidden" name="<portlet:namespace/>quotDrivers" value="<%=drvDets%>">
										</td>
									</tr>
<%
		}
	}
%>							
								</table>
							</div>
						</div>
						<div class="row" data-pg-collapsed>
							<div class="col-md-12">
								<button id="openDriverPopup" class="btn btn-default btn-xs-block" type="button" data-toggle="popover" data-trigger="hover" data-placement="top" data-html="true" data-content='<liferay-ui:message key="add_driver_hover" />' <%=(isBack && quot.getQuotationDrivers() != null && quot.getQuotationDrivers().size()>=2)?"style='display:none;'":"" %>>
									<i class="glyphicon glyphicon-plus"></i> <liferay-ui:message key="add_new_drv"/>
								</button>
							</div>
						</div>						 
					</li>
				</ul>
				<div class="row">
					<div class="col-md-12 text-right no-pad">
						<ul class="list-btns">
							<li>
								<button class="btn btn-lg btn-xs-block btn-link text-muted" role="button" type="button" onclick="$('#landingBackForm').submit();">
									<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
								</button>
							</li>
							<li>
								<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn" onclick="validateFormAndSubmit();"><liferay-ui:message key="continue"/></button>
							</li>
						</ul>
					</div>
				</div>
				</form>
				</div>
			</div>
		</div>
	</div>
</div>

<div id="aui_popup_content">
</div>
<!-- <div id="aui_popup_body" style="display:none;">
	<div>
		<h5><liferay-ui:message key="invalid_iban"/></h5>
	</div>
</div> -->
<portlet:actionURL var="addDriverPortletURL" name="addDiver" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
</portlet:actionURL>
<form id="AddDriverForm" name="landingBackForm" role="form" action="<%=addDriverPortletURL %>" method="post" target="driverFrame">
	<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
	<input type="hidden" id="<portlet:namespace/>driver" name="<portlet:namespace/>driver" value=""/>
	<input type="hidden" name="<portlet:namespace/>myview" value="add_driver"/>
</form>
<div id="aui_popup_content_remove_drv">
</div>
<div id="aui_popup_body_remove_drv" style="display:none;">
	<div class="text-center">
		<h4 style="overflow-wrap:break-word;"><liferay-ui:message key="remove_drv_confirm"/></h4>
	</div>
	<div class="row text-center">
		<div class="col-md-12 no-pad">
			<ul class="list-btns">
				<li>
					<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn" onclick="removeRow();"><liferay-ui:message key="confirm"/></button>
				</li>
				<li>
					<button class="btn btn-lg btn-xs-block btn-default" role="button" type="button" onclick="$('.close', window.parent.document).click().click();"><liferay-ui:message key="cancel"/></button>
				</li>
			</ul>
		</div>
	</div>
</div>
	
<aui:script>

var underAgeDriver = <%=underAgeDriver%>;
var objToRemove;
var frmValidator;
var editRowIndex = 0;
var max_fields = 2; 
var x = 0;

$(function() {
	$('[data-toggle="popover"]').popover()
});
$(document).ready(function() {

	x = $('.driversTbl').find("input[name='<portlet:namespace />quotDrivers']").length;
	var isBack = <%=isBack%>;

	console.log(x);
	manageDriversChange();

	if(isBack && underAgeDriver)
	{
		manageReason($("#underAgeDriver"));
	}
	/* iban */
	
});

function confirmRemove(obj)
{
	if($(".driversTbl tr").length==1 && !<%=isMainDriver%>)
		return false;
	objToRemove = obj;
	AUI().use('aui-modal', function(A) {
		var dialog = new A.Modal({
			title: "Confirm",
			bodyContent: AUI().one('#aui_popup_body_remove_drv').html(),
			headerContent: '<h4 class="no-margin"><liferay-ui:message key="confirm"/></h4>',
			centered: true,
			modal: true,
			height: 200,
			render: '#aui_popup_content_remove_drv'
		});
		dialog.render();
	});
}
$(document).on("keypress", ":input:not(textarea)", function(event) {
    return event.keyCode != 13;
});
AUI().use('liferay-util-window,liferay-portlet-url', function(A) {
	A.one('#openDriverPopup').on('click', function(event) {
		$('#AddDriverForm').find("#<portlet:namespace/>driver").val("");
		openPopup();
	    
	}); 
});

function validateFormAndSubmit()
{
	if (frmValidator)
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
				iban:function(val, fieldNode, ruleValue){
					var regex = new RegExp('^(SA)([0-9 A-Z]){22}$');
					return regex.test(val);
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
				iban:'<liferay-ui:message key="invalid_iban"/>',
				customFieldMatch:'<liferay-ui:message key="values_not_match"/>',
				custDropDown:'<liferay-ui:message key="plz_select_value"/>'
			},
			true
		);
		var rules = 
		{
		    <portlet:namespace/>education: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>maritalStatus: {
		    	required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>childUnder16: {
		    	required: true, 
	            custDropDown: true
		    }
		}

		rules.<portlet:namespace/>iban = {
			required: true,
			iban: true,
			customFieldMatch: true
        }
		rules.<portlet:namespace/>copyIban = {
            required: true,
			iban: true,
			customFieldMatch: true
	    }

		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>form1',
		    rules:rules,
		    validateOnBlur: false
		});
		
	});
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
		$("#<portlet:namespace/>form1").submit();
	}
}	

function manageReason(obj){
	if(obj.is(":checked"))
	{
		$(".drv_stat").text("<%=LanguageUtil.get(request, "add_one_drv")%>");
		underAgeDriver = true;
	}
	else
	{		
		$(".drv_stat").text("<%=LanguageUtil.get(request, "add_add_drv")%>");
		underAgeDriver = false;
	}
	
	manageDriversChange();
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
    }
    return uploadSize;
}

function addDriver(driver, isEdit, error)
{
	var driverData = JSON.stringify(driver);
	
	console.log(driverData);
	driverData = driverData.replace(/\"/g, "'")
	driverData = driverData.replace(/,/g, "#")
	console.log(driver);

	if(isEdit)
	{
// 	    if(error)
// 		{
    		var driversTable = $(".driversTbl");
			$("tr",driversTable).eq(editRowIndex).remove();
			addDriver(driver, false, error);
// 		}
// 	    else
// 		{
// 			var driversTable = $(".driversTbl");
// 			$("tr",driversTable).eq(editRowIndex).find("input[name='<portlet:namespace/>quotDrivers']").val(driverData);
// 		}
	}
	else
	{
		var currDriversCount = $(".driversTbl tr").length;
		var dData = driver.driverName == null ? driver.driverId : driver.driverName;
		var errorClass = "";
		if(error )
		{
			errorClass="error-driver";
			if(driver.driverName == null)
				dData = driver.driverId;
		}
		var drvRow = '<tr class="'+errorClass+'"><td class=" bg-gray">'+dData+'<div class="row pull-right"><div class="col-md-6" style="border-right:1px solid #ddd"><span class="btn btn-link no-pad" onclick="editDriverPopup(this);"><i class="glyphicon glyphicon-pencil text-primary"></i></span></div><div class="col-md-6"><span class="btn btn-link no-pad" onclick="confirmRemove(this);"><i class="glyphicon glyphicon-trash text-danger"></i></span></div></div>';
		if(error)
			drvRow += '<br/><span class="text-danger">'+error+'</span>';
		drvRow += '<input type="hidden" name="<portlet:namespace/>quotDrivers" value="'+driverData+'"/>';
		drvRow += '</td></tr>';
		$('.driversTbl').append(drvRow);
		$.when( $(".driversTbl tr").length == currDriversCount+1).then(function(){
			manageDriversChange();
		});
	}
// 	alert("max_fields : " + max_fields);
// 	alert("x : " + x);
// 	if(x < max_fields)
// 	{
// 		x++;
// 	}
// 	if(x == max_fields) 
// 	{
// 		$("#openDriverPopup").hide();
// 	}
	if($('.driversTbl').find("input[name='<portlet:namespace />quotDrivers']").length >= max_fields)
	{
	    $("#openDriverPopup").hide();
	}
}

function openPopup()
{
	Liferay.Util.openWindow(
	{
		cache: false,
		dialog: {
			destroyOnHide: true,
			headerContent: '<liferay-ui:message key="add_driver"/>',
			align: Liferay.Util.Window.ALIGN_CENTER,
			modal:true,
			resizable: false,
			width: 845,
			after: {
				render: function(evt) {
					$(".modal-body").append("<iframe class='dialog-iframe-node' frameborder='0' id='driverFrame' name='driverFrame'/>");
					$.when( $("#driverFrame").length == 1).then(function(){
						$('#AddDriverForm').submit();
						$(".modal-body").addClass("dialog-iframe-bd");
						$(".modal-body").css("padding","0px");
					});
				}
			}
		},
		dialogIframe: {
			id: 'driverFrame',
			on: {
					load : function(evt) {
						alert('Hope this works new');
					}
				}
			
		},
		uri: ''
	});
}

function removeRow(){
	$('.close', window.parent.document).click().click();
	elem = objToRemove;
	elem.closest('tr').remove();
	manageDriversChange();
// 	x--;
// 	if(x < max_fields)
// 	{ 
// 		$("#openDriverPopup").show();
// 	}
	if($('.driversTbl').find("input[name='<portlet:namespace />quotDrivers']").length < max_fields)
	{
	    $("#openDriverPopup").show();
	}
}

function manageDriversChange()
{
	console.log("manageDriversChange");
	if($(".driversTbl tr.error-driver").length>0 ||((underAgeDriver || !<%=isMainDriver%>) && ($(".driversTbl tr").length == 0 )))
		$("#submitBtn").attr("disabled",true);
	else
		$("#submitBtn").removeAttr("disabled");
	
	if($(".driversTbl tr").length == 0)
		$(".drv_stat").show();
	else
		$(".drv_stat").hide();
}

function editDriverPopup(obj)
{
	editRowIndex = $(obj).closest("tr").index();
	var driversTable = $(".driversTbl");
	var driverData = $("tr",driversTable).eq(editRowIndex).find("input[name='<portlet:namespace/>quotDrivers']").val();
	$('#AddDriverForm').find("#<portlet:namespace/>driver").val(driverData);
	openPopup();
}
</aui:script>
