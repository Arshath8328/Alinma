<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.atmc.bsl.db.service.QuotationLocalServiceUtil"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="java.util.ArrayList"%>
<%@page
	import="com.atmc.bsl.db.domain.quotation.QuotationDriverLicense"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationDriver"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page
	import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<link rel="stylesheet" type="text/css"
	href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<%@ include file="init.jsp"%>
<%
	List<CodeMasterDetails> educationList = QuotationLocalServiceUtil.getEducationList();
	List<CodeMasterDetails> countryList = QuotationLocalServiceUtil.getCountries();
	List<CodeMasterDetails> licenseTypes = QuotationLocalServiceUtil.getLicenseTypes();
	List<CodeMasterDetails> cities = QuotationLocalServiceUtil.getCities();
	String polNumber = (String) request.getParameter("polNumber");
	System.out.print("polNumber" + polNumber);

	String buyPortletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
	String tokenizationUrl = PropsUtil.get("com.ejada.atmc.payfort.tokenization.url");
	PortletURL portletReturnUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(),
			PortletRequest.ACTION_PHASE);
	portletReturnUrl.setWindowState(WindowState.NORMAL);
	portletReturnUrl.setPortletMode(PortletMode.VIEW);
	portletReturnUrl.setParameter(ActionRequest.ACTION_NAME, "tokenizationResult");

	/* 	
		String requestPhrase = PropsUtil.get("com.ejada.atmc.payfort.sha.requestPhrase");
		String merchantIdentifier = PropsUtil.get("com.ejada.atmc.payfort.merchantIdentifier");
		String accessCode = PropsUtil.get("com.ejada.atmc.payfort.accessCode"); */
%>



<portlet:actionURL name="addDriverForm" var="addDriverForm" />

		<portlet:resourceURL var="captchaURL"/>
		<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="portlet-content">
			<div id="error_container"></div>
			<form name="<portlet:namespace/>addDriverForm" method="post"
				id="<portlet:namespace/>addDriverForm" action="<%=addDriverForm%>"
				enctype="multipart/form-data">
				<ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message
							key="drv_dets" /></li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label">
										<div role="group" class="btn-group btn-group-justified"
											data-toggle="buttons">
											<label class="btn btn-default idTypeBtn focus control-label">
												<input type="radio" name="<portlet:namespace/>driverIdType"
												id="idTypeSaudi"
												value="<%=BuyMotorPolicyPortletKeys.ID_TYPE_SAUDI%>"
												autocomplete="off" onchange="manageTypeValidation();" /> <liferay-ui:message
													key="saudi_id" />
											</label> <label
												class="btn btn-default idTypeBtn control-label idTypeBtn">
												<input type="radio" name="<portlet:namespace/>driverIdType"
												id="idTypeIqama"
												value="<%=BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA%>"
												onchange="manageTypeValidation();" /> <liferay-ui:message
													key="iqama_id" />
											</label>
										</div>
									</label> <input class="form-control" type="text"
										name="<portlet:namespace />driverId"
										id="<portlet:namespace />driverId" placeholder="105XXXXXXXX" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label dobLbl"
										style="padding: 12px 0 11px 0;"><liferay-ui:message
											key="driver_dob_h" /></label> <input class="form-control"
										type="text" readonly placeholder="dd/mm/yyyy"
										name="<portlet:namespace />driverDobH"
										id="<portlet:namespace />driverDobH" /> <input
										class="form-control" type="text" readonly
										placeholder="dd/mm/yyyy" name="<portlet:namespace/>driverDob"
										id="<portlet:namespace />driverDob" /> <span
										class="glyphicon form-control-feedback glyphicon-calendar text-muted"
										style="padding: 22px 0 0 0;"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="education" /></label> <select class="form-control"
										name="<portlet:namespace />driverEdu"
										id="<portlet:namespace />driverEdu">
										<option value="-1"><liferay-ui:message
												key="please_select_option" /></option>
										<%
											for (CodeMasterDetails edu : educationList) {
										%>
										<option value="<%=edu.getCodeSub()%>"><%=currLocale.equals("en_US") ? edu.getCodeDesc() : edu.getCodeDescAr()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="no_child_16" /></label> <select class="form-control"
										id="<portlet:namespace />driverNoChild"
										name="<portlet:namespace />driverNoChild">
										<option value="-1"><liferay-ui:message
												key="please_select_option" /></option>
										<%
											for (int cCount = 0; cCount < 11; cCount++) {
										%>
										<option value="<%=cCount%>"><%=cCount%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="are_you_relative_insured" /></label> <select
										id="<portlet:namespace/>insuredRelative"
										name="<portlet:namespace/>insuredRelative"
										class="form-control">
										<option value="-1"><liferay-ui:message
												key="please_select_option" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_1%>"><liferay-ui:message
												key="INSURED_RELATION_1" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_2%>"><liferay-ui:message
												key="INSURED_RELATION_2" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_3%>"><liferay-ui:message
												key="INSURED_RELATION_3" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_4%>"><liferay-ui:message
												key="INSURED_RELATION_4" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_5%>"><liferay-ui:message
												key="INSURED_RELATION_5" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_6%>"><liferay-ui:message
												key="INSURED_RELATION_6" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_7%>"><liferay-ui:message
												key="INSURED_RELATION_7" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_8%>"><liferay-ui:message
												key="INSURED_RELATION_8" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_9%>"><liferay-ui:message
												key="INSURED_RELATION_9" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_10%>"><liferay-ui:message
												key="INSURED_RELATION_10" /></option>
										<option
											value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_0%>"><liferay-ui:message
												key="INSURED_RELATION_0" /></option>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" id="proofDiv"
								style="display: none;">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message
											key="uploaded_attchements" /></label>
									<aui:input id="selectedFile" type="file"
										readonly name="selectedFile"
										class="form-control"
										placeholder="<%=LanguageUtil.get(request, "sel_file_loc")%>"
										data-toggle="tooltip" data-placement="bottom"
										title="advise customer">
										<aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
										<aui:validator name="custom" errorMessage="max_upload_size">
	                                            function(val,node,junction){
	                                            var uploadSize=true;
	                                            var size=0;
	                                            var fileInput = document.getElementById("<portlet:namespace />selectedFile");
	                                            for(var num1=0;num1<fileInput.files.length;num1++)
	                                            {
	                                                var file=fileInput.files[num1]; if(file.size>2097152)
											{ uploadSize=false; } else { uploadSize=true; }
											size+=file.size; } if(uploadSize==true){ return true; }else{
											return false; } } 
										</aui:validator>
										<aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
											function(val,node,junction){
												var fileInput = document.getElementById("<portlet:namespace/>selectedFile");
												var fileName = "";
												if(fileInput.files.length>0)
													fileName = fileInput.files.item(0).name;
													var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
													return regex.test(fileName);
												}
										</aui:validator>
									</aui:input>
									<liferay-captcha:captcha url="<%=captchaURL%>" />
									<span
										class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
								</div>
							</div>
						</div>
						<div class="alert alert-info" role="alert">
							<liferay-ui:message key="inaccurate_info_disclaimer" />
						</div>

						<div class="row" id="drvMstatusRow">

							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="marital_status" /></label> <select class="form-control"
										id="<portlet:namespace />driverMarStats"
										name="<portlet:namespace />driverMarStats">
										<option value="-1"><liferay-ui:message
												key="please_select_option" /></option>
										<option value="Single"><liferay-ui:message
												key="single" /></option>
										<option value="Married"><liferay-ui:message
												key="married" /></option>
									</select>
								</div>
							</div>
						</div>
						<p class="text-primary">
							<liferay-ui:message key="list_drv_lic" />
						</p>
						<div class="licenseData">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message
												key="country_drv_lic" /></label> <select class="form-control"
											id="<portlet:namespace />driverLicCountry"
											name="<portlet:namespace />driverLicCountry">
											<option value="-1"><liferay-ui:message
													key="please_select_option" /></option>
											<%
												for (CodeMasterDetails country : countryList) {
											%>
											<option value="<%=country.getCodeSub()%>"><%=currLocale.equals("en_US") ? country.getCodeDesc() : country.getCodeDescAr()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message
												key="type_drv_lic" /></label> <select class="form-control"
											id="<portlet:namespace />driverLicType"
											name="<portlet:namespace />_0_driverLicType">
											<option value="-1"><liferay-ui:message
													key="please_select_option" /></option>
											<%
												for (CodeMasterDetails type : licenseTypes) {
											%>
											<option value="<%=type.getCodeSub()%>"><%=currLocale.equals("en_US") ? type.getCodeDesc() : type.getCodeDescAr()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-control control-label"><liferay-ui:message
												key="no_yrs" /></label> <input class="form-control" type="text"
											placeholder="<%=LanguageUtil.get(request, "plz_enter")%>"
											id="<portlet:namespace />driverLicYrs"
											name="<portlet:namespace />driverLicYrs"
											data-toggle="popover" data-trigger="hover" data-html="false"
											data-placement="top"
											data-content='<%=LanguageUtil.get(request, "if_held_less_year_zero")%>'>
										<span
											class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
									</div>
								</div>
							</div>
						</div>

						<div id="input_fields_wrap">
							<%-- <%
								if (isEdit && otherLicenses != null && !otherLicenses.isEmpty())
								{
									for (int licCount = 0; licCount < otherLicenses.size(); licCount++)
									{
										QuotationDriverLicense license = otherLicenses.get(licCount);
							%> --%>
							<%-- <div class="licenseData">
								<hr />
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="country_drv_lic" /></label> <select class="form-control" id="<portlet:namespace />_driverLicCountry" name="<portlet:namespace />_driverLicCountry">
												<option value="-1"><liferay-ui:message key="please_select_option" /></option>
  <%
												for ( CodeMasterDetails country :countryList) {
											%>
											<option value="<%=country.getCodeSub()%>"><%=currLocale.equals("en_US") ? country.getCodeDesc() : country.getCodeDescAr()%></option>
											<%
												}
											%> 
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="type_drv_lic" /></label> <select class="form-control" id="<portlet:namespace />_driverLicType" name="<portlet:namespace />_driverLicType">
												<option value="-1"><liferay-ui:message key="please_select_option" /></option>
<%
													for (int lCount = 0; lCount < licTypes.size(); lCount++)
													{
																CodeMasterDetails type = (CodeMasterDetails) licTypes.get(lCount);
																String selected = "";
																if (license.getLicType() != null && license.getLicType().equals(type.getCodeSub()))
																	selected = "selected";
%>
												<option value="<%=type.getCodeSub()%>" <%=selected%>><%=currLocale.equals("en_US") ? type.getCodeDesc() : type.getCodeDescAr()%></option>
<%
													}
%>
											</select>
										</div>
									</div>
								</div> --%>
							<%-- <div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-control control-label"><liferay-ui:message key="no_yrs" /></label> <input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />_driverLicYrs" name="<portlet:namespace />_driverLicYrs" value="" data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content='<%= LanguageUtil.get(request,"if_held_less_year_zero") %>'>
											<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
										</div>
									</div>
									<div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'>
										<div class='col-md-12'>
											<button class='btn btn-danger btn-outline btn-xs-block remove_field' onclick='removeField(this);' type='button'>
												<i class='glyphicon glyphicon-minus'></i>
												<liferay-ui:message key="remove_lic" />
											</button>
										</div>
									</div>
								</div> --%>
						</div> <%-- <%
								}
							}
%> --%> <%-- 						<%
 	if (!isEdit || (isEdit && otherLicenses != null && otherLicenses.size() < 2)) {
 %> --%> <%-- <div class="row">
							<div class="col-md-12">
								<button id="add_field_btn" class="btn btn-default btn-xs-block"
									type="button">
									<i class="glyphicon glyphicon-plus"></i>
									<liferay-ui:message key="add_another_country" />
								</button>
							</div>
						</div>  --%> <%-- 						<%
 	}
 %>
	 --%>
					</li>
				</ul>
				<br />
				<%-- <ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message key="drv_acc_history" /></li>
					 <li class="list-group-item">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="fault_accidents_made" /></label>
									<label class="switch control-label"> <input type="checkbox" id="driverNoFaultId"  />
										<div></div>
										<span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no")%>"></span>
									</label>
									<div class="row nFaultDiv"
										>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />driverNOFault" name="<portlet:namespace />driverNOFault"  />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="fault_accids_submit" /></label>
									<label class="switch control-label"> <input type="checkbox" id="driverNoClaimId"  />
										<div></div> <span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no") %>"></span>
									</label>
									<div class="row nClaimDiv"
										style="">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />driverNOClaim" name="<portlet:namespace />driverNOClaim" />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="road_convs" /></label> <label class="switch control-label">
										<input type="checkbox" id="driverConvictionsId"  />
										<div></div> <span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no") %>"></span>
									</label>
									<div class="row dConvsDiv"
										style="">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_specify") %>" id="<portlet:namespace />driverConvictions" name="<portlet:namespace />driverConvictions"  />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="med_conds" /></label>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder='<%= LanguageUtil.get(request,"optional") %>' id="<portlet:namespace />driverMedConds" name="<portlet:namespace />driverMedConds"  />
										</div>
									</div>
								</div>
							</div>
						</div>
					</li> 
				</ul> --%>
				<br />
				<ul class="list-group no-margin ">
					<li class="list-group-item bg-gray"><liferay-ui:message
							key="drv_nat_addr" /></li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="building_no" /></label> <input class="form-control" type="text"
										placeholder="" id="<portlet:namespace />buildNo"
										name="<portlet:namespace />buildNo" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="street_name" /></label> <input class="form-control" type="text"
										placeholder="" id="<portlet:namespace />stName"
										name="<portlet:namespace />stName" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="district" /></label> <input class="form-control" type="text"
										placeholder="" id="<portlet:namespace />district"
										name="<portlet:namespace />district" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="city" /></label> <select class="form-control"
										name="<portlet:namespace/>city" id="<portlet:namespace/>city">
										<option value="-1"><liferay-ui:message
												key="please_select_option" /></option>
										<%
											for (CodeMasterDetails cityDetails : cities) {
										%>
										<option value="<%=cityDetails.getCodeSub()%>"><%=(currLocale.equals("en_US")) ? cityDetails.getCodeDesc() : cityDetails.getCodeDescAr()%></option>
										<%
											}
										%>
									</select>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="zip_code" /></label> <input class="form-control" type="text"
										placeholder="" id="<portlet:namespace />zipCode"
										name="<portlet:namespace />zipCode" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message
											key="add_no" /></label> <input type="hidden" value="<%=polNumber%>"
										name="<portlet:namespace/>polNumber"> <input
										class="form-control" type="text"
										placeholder="<%=LanguageUtil.get(request, "optional")%>"
										id="<portlet:namespace />addNo"
										name="<portlet:namespace />addNo" value="" />
								</div>
							</div>
						</div>
					</li>
				</ul>
				<br />
				<%-- <ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message key="off_nat_addr" /></li>
					<li class="list-group-item">
						<div class="form-group">
							<label class="control-label text-primary"><liferay-ui:message key="nat_addr_off" /></label> <label class="switch control-label">
								<input type="checkbox"
								<%=(isEdit && driver.getDriverOffNatAddress() != null) ? "checked" : ""%>
								id="OffAddress" />
								<div></div> <span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no") %>"></span>
							</label>
						</div>
						<div class="officeAddDiv"
							<%=(isEdit && driver.getDriverOffNatAddress() != null) ? "" : "style='display:none;'"%>>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="building_no" /></label> <input class="form-control" type="text"
											placeholder="" id="<portlet:namespace />offBuildNo"
											name="<portlet:namespace />offBuildNo"
											value="<%=(isEdit && driver.getDriverOffNatAddress() != null
					&& driver.getDriverOffNatAddress().getBuildNo() != null)
							? driver.getDriverOffNatAddress().getBuildNo()
							: ""%>" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="street_name" /></label> <input class="form-control" type="text"
											placeholder="" id="<portlet:namespace />offStName"
											name="<portlet:namespace />offStName"
											value="<%=(isEdit && driver.getDriverOffNatAddress() != null
					&& driver.getDriverOffNatAddress().getStName() != null)
							? driver.getDriverOffNatAddress().getStName()
							: ""%>" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="district" /></label> <input class="form-control" type="text"
											placeholder="" id="<portlet:namespace />offDistrict"
											name="<portlet:namespace />offDistrict"
											value="<%=(isEdit && driver.getDriverOffNatAddress() != null
					&& driver.getDriverOffNatAddress().getDistrict() != null)
							? driver.getDriverOffNatAddress().getDistrict()
							: ""%>" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="city" /></label> <select class="form-control"
											name="<portlet:namespace/>offCity"
											id="<portlet:namespace/>offCity">
											<option value="-1"><liferay-ui:message key="please_select_option" /></option>
											<%
												for (int cityCount = 0; cities != null && cityCount < cities.size(); cityCount++) {
													CodeMasterDetails city = (CodeMasterDetails) cities.get(cityCount);
													String selected = "";
													if (isEdit && driver.getDriverOffNatAddress() != null
															&& driver.getDriverOffNatAddress().getCity() != null
															&& driver.getDriverOffNatAddress().getCity().equals(city.getCodeSub()))
														selected = "selected";
											%>
											<option value="<%=city.getCodeSub()%>" <%=selected%>><%=(currLocale.equals("en_US")) ? city.getCodeDesc() : city.getCodeDescAr()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="zip_code" /></label> <input class="form-control" type="text"
											placeholder="" id="<portlet:namespace />offZipCode"
											name="<portlet:namespace />offZipCode"
											value="<%=(isEdit && driver.getDriverOffNatAddress() != null
					&& driver.getDriverOffNatAddress().getZipCode() != null)
							? driver.getDriverOffNatAddress().getZipCode()
							: ""%>" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="add_no" /></label> <input class="form-control" type="text"
											placeholder='<%= LanguageUtil.get(request,"optional") %>' id="<portlet:namespace />offAddNo"
											name="<portlet:namespace />offAddNo"
											value="<%=(isEdit && driver.getDriverOffNatAddress() != null
					&& driver.getDriverOffNatAddress().getAddNo() != null)
							? driver.getDriverOffNatAddress().getAddNo()
							: ""%>" />
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul> --%>
				<br />
				<div class="row">
					<div class="col-md-12 no-pad">
						<ul class="list-btns">
							<li>
								<button class="btn btn-primary btn-lg btn-xs-block"
									type="submit" onClick="saveDriver($(this));">
									<liferay-ui:message key="save" />
								</button>
							</li>
						</ul>
					</div>
				</div>
			</form>
			<%-- <ul class="nav nav-tabs nav-justified">
						<li class="active">
							<a href="#tab-1" role="tab" data-toggle="tab" onclick="buildValRules('VISA');">
								<span class="icon icon-business md-48">
									<span class="path1"></span>
									<span class="path2"></span>
									<span class="path3"></span>
									<span class="path4"></span>
									<span class="path5"></span>
									<span class="path6"></span>
									<span class="path7"></span>
									<span class="path8"></span>
									<span class="path9"></span>
									<span class="path10"></span>
									<span class="path11"></span>
									<span class="path12"></span>
									<span class="path13"></span>
									<span class="path14"></span>
									<span class="path15"></span>
								</span>
								&nbsp;&nbsp;<liferay-ui:message key="visa_card"/>
							</a>
						</li>
						<li>
							<a href="#tab-2" role="tab" data-toggle="tab" onclick="buildValRules('MASTERCARD');">
								<span class="icon icon-business-1 md-48">
									<span class="path1"></span>
									<span class="path2"></span>
									<span class="path3"></span>
									<span class="path4"></span>
									<span class="path5"></span>
									<span class="path6"></span>
									<span class="path7"></span>
									<span class="path8"></span>
									<span class="path9"></span>
									<span class="path10"></span>
									<span class="path11"></span>
									<span class="path12"></span>
									<span class="path13"></span>
									<span class="path14"></span>
									<span class="path15"></span>
									<span class="path16"></span>
									<span class="path17"></span>
									<span class="path18"></span>
									<span class="path19"></span>
									<span class="path20"></span>
									<span class="path21"></span>
									<span class="path22"></span>
									<span class="path23"></span>
									<span class="path24"></span>
									<span class="path25"></span>
									<span class="path26"></span>
								</span>
								&nbsp;&nbsp;<liferay-ui:message key="master_card"/>
							</a>
						</li>
						<li>
							<a href="#tab-4" role="tab" data-toggle="tab" onclick="buildValRules('MADA');">
								<span class="icon icon-mada md-48">
									<span class="path1"></span>
									<span class="path2"></span>
									<span class="path3"></span>
									<span class="path4"></span>
									<span class="path5"></span>
									<span class="path6"></span>
									<span class="path7"></span>
									<span class="path8"></span>
								</span>
								&nbsp;&nbsp;<liferay-ui:message key="mada_debit_card"/>
							</a>
						</li>


					</ul>
					<div class="tab-content bg-white pad-10">
						<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-12">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-sm-6">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="card_no"/></label>
										<input class="form-control" type="text" placeholder="122X XXXX XXXX XXXX" name="<portlet:namespace/>visaCardNo" id="<portlet:namespace/>visaCardNo" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="name_card"/></label>
										<input class="form-control" type="text"  name="<portlet:namespace/>visaNameCard" oninput="this.value = this.value.toUpperCase();" id="<portlet:namespace/>visaNameCard"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="exp_date"/> </label>
										<div class="row">
											<div class="col-md-6">
												<input class="form-control" type="text" placeholder="mm" id="<portlet:namespace/>visaExpMonth" name="<portlet:namespace/>visaExpMonth"/>
											</div>
											<div class="col-md-6">
												<input class="form-control" type="text" placeholder="YYYY" id="<portlet:namespace/>visaExpYear"  name="<portlet:namespace/>visaExpYear"/>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label">&nbsp;</label>
										<input class="form-control" type="text" placeholder="Verification Code"  name="<portlet:namespace/>visaVerfCode" id="<portlet:namespace/>visaVerfCode"/>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" role="tabpane2" id="tab-2">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-12">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-sm-6">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="card_no"/></label>
										<input class="form-control" type="text" placeholder="122X XXXX XXXX XXXX" id="<portlet:namespace/>masterCardNo" name="<portlet:namespace/>masterCardNo"/>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="name_card"/></label>
										<input class="form-control" type="text"  name="<portlet:namespace/>masterNameCard" oninput="this.value = this.value.toUpperCase();"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="exp_date"/> </label>
										<div class="row">
											<div class="col-md-6">
												<input class="form-control" type="text" placeholder="mm" id="<portlet:namespace/>masterExpMonth" name="<portlet:namespace/>masterExpMonth"/>
											</div>
											<div class="col-md-6">
											<input class="form-control" type="text" placeholder="YYYY" id="<portlet:namespace/>masterCardYear" name="<portlet:namespace/>masterCardYear"/>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"></label>
										<input class="form-control" type="text" placeholder="Verification Code" id="<portlet:namespace/>masterVerfCode" name="<portlet:namespace/>masterVerfCode"/>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" role="tabpane2" id="tab-4">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-12">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-sm-6">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="card_no"/></label>
										<input class="form-control" type="text" placeholder="122X XXXX XXXX XXXX" id="<portlet:namespace/>madaCardNo" name="<portlet:namespace/>madaCardNo"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="exp_date"/> </label>
										<div class="row">
											<div class="col-md-6">
												<input class="form-control" type="text" placeholder="mm" id="<portlet:namespace/>madaExpMonth" name="<portlet:namespace/>madaExpMonth"/>
											</div>
											<div class="col-md-6">
											<input class="form-control" type="text" placeholder="YYYY" id="<portlet:namespace/>madaCardYear" name="<portlet:namespace/>madaCardYear"/>
											</div>
										</div>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label">CVV</label>
										<input class="form-control" type="text" placeholder="Verification Code" id="<portlet:namespace/>madaVerfCode" name="<portlet:namespace/>madaVerfCode"/>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade" role="tabpane3" id="tab-3">
							<div class="row">
								<div class="col-md-6 col-sm-6 col-xs-12">
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-sm-6">
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="sadad_id"/></label>
										<input class="form-control" type="text" placeholder=""  name="<portlet:namespace/>olpID"/>
									</div>
								</div>
							</div>
						</div>
					</div>
					<div class="text-right no-pad">
					<ul class="list-btns">
						<li>				
							<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn" onclick="validateQuoteFormAndSubmit();" disabled><liferay-ui:message key="confirm"/></button>
						</li>
					</ul>
				</div>
	 <form name="pmntForm" id="pmntForm" action="<%=tokenizationUrl %>" method="post">
	<input type="hidden" name="return_url" id="return_url" value="<%=portletReturnUrl.toString()%>">
	<input type="hidden" name="service_command" id="service_command" value="TOKENIZATION">
	<input type="hidden" name="access_code" id="access_code" value="<%=accessCode%>">
	<input type="hidden" name="merchant_identifier" id="merchant_identifier" value="<%=merchantIdentifier%>">
	<input type="hidden" name="merchant_reference" id="merchant_reference" value="<%=quot.getReferenceNo() %>">
	<input type="hidden" name="language" id="language" value="<%=(currLocale.equals("en_US"))?"en":"ar"%>">
	<input type="hidden" name="expiry_date" id="expiry_date" value="2105">
	<input type="hidden" name="card_number" id="card_number" value="4005550000000001">
	<input type="hidden" name="card_security_code" id="card_security_code" value="123">
	<input type="hidden" name="signature" id="signature" value="">
</form> 
<div id="aui_popup_content_2">
</div>
<div id="aui_popup_body_2" style="display:none;">
	<div class="row margin-top">
		<div class="col-md-12">
			<p><liferay-ui:message key="tc_txt_1" /></p>
			<p><liferay-ui:message key="tc_txt_2" /></p>
			<p><liferay-ui:message key="tc_txt_3" /></p>
			<p><liferay-ui:message key="tc_txt_4" /></p>
			<p><liferay-ui:message key="tc_txt_5" /></p>
			<p><liferay-ui:message key="tc_txt_6" /></p>
			<p><liferay-ui:message key="tc_txt_7" /></p>
			<p><liferay-ui:message key="tc_txt_8" /></p>
			<p><liferay-ui:message key="tc_txt_9" /></p>
		</div>
	</div>
</div>	
		</div>
	</div>
</div> --%>
			<%
				PortletURL resourceURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
						themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
				resourceURL.setParameter("resourceType", "addriver");
				String resourceURLVal = resourceURL.toString();
				if (resourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
					resourceURLVal = resourceURLVal.substring(0, resourceURLVal.lastIndexOf("&p_p_lifecycle=1"));
			%>
			<%-- <form id="submitForm" class="hidden" enctype="multipart/form-data"
	action="${resourceURLVal}">
	<input type="hidden" id="<portlet:namespace/>driver" name="<portlet:namespace/>driver" value="" />
	<aui:input type="file" name="uploadFile" id="uploadFile" cssClass="sr-only" label="" title=""></aui:input>
	</form>  --%>
			<aui:script>

$(function() {
	$("#error_container").html("");
	$('[data-toggle="popover"]').popover();
	$('#driverNoFaultId').change(function () {
		$('.nFaultDiv').toggle();
	});
	$('#driverNoClaimId').change(function () {
		$('.nClaimDiv').toggle();
	});
	$('#driverConvictionsId').change(function () {
		$('.dConvsDiv').toggle();
	});
	$('#OffAddress').change(function () {
		$('.officeAddDiv').toggle();
	});
	$('[data-toggle="tooltip"]').tooltip();
	
});


$("#<portlet:namespace/>insuredRelative").on('change', function(){
	var  selectedVal = $(this).val();
    if(selectedVal != '-1' && selectedVal != "<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_0%>")
	{
		$("#proofDiv").show();
	}
    else 
	{
		$("#proofDiv").hide();
	}
    document.getElementById('<portlet:namespace/>selectedFile').value = "";
});


$("#<portlet:namespace />driverDobH").calendarsPicker({
	calendar: $.calendars.instance('ummalqura'<%=currLocale.equals("en_US") ? "" : ",'ar'"%>),
	dateFormat: 'dd/mm/yyyy',
	maxDate: 0,
	yearRange: '-100:1439',
	onClose: function(dates){
		var zDate = $("#<portlet:namespace />driverDobH").val().split("/");
		if($("#driverDobH").val() != "")
		{
			var jd = $.calendars.instance('ummalqura'<%=currLocale.equals("en_US") ? "" : ",'ar'"%>).newDate(parseInt(zDate[2]), parseInt(zDate[1]), parseInt(zDate[0])).toJD();
			var convertedDate = $.calendars.instance('gregorian'<%=currLocale.equals("en_US") ? "" : ",'ar'"%>).fromJD(jd);
			//var convertedDateParts = convertedDate.split("-");
			console.log(convertedDate);
			$("#<portlet:namespace />driverDob").val(((convertedDate._day<10)?("0"+convertedDate._day):convertedDate._day)+"/"+((convertedDate._month<10)?("0"+convertedDate._month):convertedDate._month)+"/"+convertedDate._year);
		}
		else
		{
			$("#driverDob").val("");
		}					
	}

	<%=currLocale.equals("en_US") ? "" : ", isRTL: true"%>
});

$("#<portlet:namespace />driverDob").calendarsPicker({
	calendar: $.calendars.instance('gregorian'<%=currLocale.equals("en_US") ? "" : ",'ar-EG'"%>),
	dateFormat: 'dd/mm/yyyy',
	maxDate: 0,
	yearRange: '-100:2018',
	<%=currLocale.equals("en_US") ? "" : "isRTL: true,"%>
	onClose: function(dates){
		var zDate = $("#<portlet:namespace />driverDob").val().split("/");
		if($("#driverDob").val() != "")
		{
			var jd = $.calendars.instance('gregorian'<%=currLocale.equals("en_US") ? "" : ",'ar'"%>).newDate(parseInt(zDate[2]), parseInt(zDate[1]), parseInt(zDate[0])).toJD();
			var convertedDate = $.calendars.instance('ummalqura'<%=currLocale.equals("en_US") ? "" : ",'ar'"%>).fromJD(jd);
			//var convertedDateParts = convertedDate.split("-");
			console.log(convertedDate);
			$("#<portlet:namespace />driverDobH").val(((convertedDate._day<10)?("0"+convertedDate._day):convertedDate._day)+"/"+((convertedDate._month<10)?("0"+convertedDate._month):convertedDate._month)+"/"+convertedDate._year);
		}
		else
		{
			$("#<portlet:namespace />driverDobH").val("");
		}
	}
});
var max_fields      = 3; 
var wrapper         = $("#input_fields_wrap"); 
var add_button      = $("#add_field_btn"); 

$(add_button).click(function(e){ 

	if(x < max_fields)
	{
		if(x>0)
		{
			$("#input_fields_wrap").find(".licenseData").each(function(index){
				$(this).find("select[name*='driverLicCountry']").attr("name", "<portlet:namespace />_"+parseInt(index+1)+"_driverLicCountry").attr("id", "<portlet:namespace />_"+parseInt(index+1)+"_driverLicCountry");
				$(this).find("select[name*='driverLicType']").attr("name", "<portlet:namespace />_"+parseInt(index+1)+"_driverLicType").attr("id", "<portlet:namespace />_"+parseInt(index+1)+"_driverLicType");
				$(this).find("input[name*='driverLicYrs']").attr("name","<portlet:namespace />_"+parseInt(index+1)+"_driverLicYrs").attr("id", "<portlet:namespace />_"+parseInt(index+1)+"_driverLicYrs");
			});
		}
		
		var currSize = $("#input_fields_wrap").find(".licenseData").size();
		var country_row	= "<div class='licenseData'><hr/><div class='row'><div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'><div class='form-group'><label class='control-control control-label'><liferay-ui:message key='country_drv_lic'/></label><select class='form-control' id='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicCountry' name='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicCountry'>"+countriesContent+"</select></div></div><div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'><div class='form-group'><label class='control-control control-label'><liferay-ui:message key='type_drv_lic'/></label><select class='form-control' id='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicType' name='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicType'>"+typesContent+"</select></div></div></div><div class='row row-eq-height vcenter'><div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'><div class='form-group has-feedback'><label class='control-control control-label'><liferay-ui:message key='no_yrs'/></label><input class='form-control' type='text'  id='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicYrs' name='<portlet:namespace />_"+parseInt(currSize+1)+"_driverLicYrs' placeholder='<liferay-ui:message key='plz_enter'/>' data-toggle='popover' data-trigger='hover' data-html='false' data-placement='top' data-content='<%= LanguageUtil.get(request,"if_held_less_year_zero") %>'><span class='glyphicon form-control-feedback glyphicon-info-sign text-muted'></span></div></div><div class='col-lg-6 col-md-6 col-sm-6 col-xs-12'><div class='col-md-12'><button class='btn btn-danger btn-outline btn-xs-block remove_field' onclick='removeField(this);' type='button'><i class='glyphicon glyphicon-minus'></i> <liferay-ui:message key='remove_lic'/></button></div></div></div></div>";
		
		x++; 
		$(country_row).appendTo(wrapper); 
	}
	
	if(x == max_fields) {
		$(add_button).hide();
	}
	$('[data-toggle="popover"]').popover();
});		
function removeField(elem)
{
	elem.closest('.licenseData').remove();
	x--;
	if(x < max_fields)
	{ 
		$(add_button).show();
	}
}

var frmValidator;
function manageTypeValidation()
{
	$("#<portlet:namespace />driverDobH").val("");
	$("#driverDob").val("");
	if($('#idTypeSaudi').is(":checked"))
	{
		allowedCharacters = "1";
		/* $("#<portlet:namespace />driverIdType").val('1'); */
		$("#<portlet:namespace />driverDobH").show();
		$("#driverDob").hide();
		$(".dobLbl").text("<%=LanguageUtil.get(request, "driver_dob_h")%>");
		$("#drvMstatusRow").show();
	}
	else
	{
		allowedCharacters = "2";
		/* $("#<portlet:namespace />driverIdType").val('2'); */
		$("#<portlet:namespace />driverDobH").hide();
		$("#driverDob").show();
		$(".dobLbl").text("<%=LanguageUtil.get(request, "driver_dob")%>");
		$("#drvMstatusRow").hide();
	}
}
function saveDriver(obj)
{
	if(obj.prop("disabled")==false)
    	obj.prop("disabled", true);

	setTimeout(function () {
        if(obj.prop("disabled")==true)
        	obj.prop("disabled", false);
    }, 1500);
	
	if (frmValidator)
		frmValidator.resetAllFields();
	
	AUI().use('aui-form-validator', function(A) {
		A.mix(A.config.FormValidator.RULES,
			{
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
				},
				custId:function(val, fieldNode, ruleValue){
					var regex = new RegExp('(^'+allowedCharacters+')');
					return regex.test(val);
				},
				/*  custUpload:function(val, fieldNode, ruleValue){
				    var elemID = $(fieldNode).attr("data-inputID");
				    console.log(elemID);
				    var files = document.getElementById(elemID).files;
				    console.log(files);
				    if(files != null && files.length > 0)
					{
						var size = (Math.round((files[0].size / 1024) * 100) / 100);
						console.log(size);
						if(size > 2048)
					    {
						    return false;
					    }
						var fileType = files[0].type;
						if(fileType != "application/pdf" && fileType != "image/png" && fileType != "image/jpeg")
					    {
					    	return false;
					    }
					}
					return true;
				},  */
				checkSum:function(val, fieldNode, ruleValue){
    				var flag = true;
    				var keyLength = 10;
					var len = val.length;
				
					if(len < keyLength)
					{
						flag = false;
					}
					else
					{
						var iqamaNumber = new Array();
						var iqamaOddSum = new Array();
						var oddString = "";
						var oddValues = 0;
						var evenValues = 0;
						var totalValues = 0;
						var checkDigit = "";
						var checkDigitValue = 0;
				
						for(var i = 0; i < len-1; i++)
						{
							iqamaNumber[i] = eval(val.charAt(i));
						}
				
						for(var i = 0; i < len-1; i += 2)
						{
							oddString += (iqamaNumber[i] * 2).toString();
						}
				
						for(var i = 0; i < oddString.length; i++)
						{
							iqamaOddSum[i] = eval(oddString.charAt(i));
						}
				
						for(var i = 0; i < iqamaOddSum.length; i++)
						{
							oddValues += iqamaOddSum[i];
						}
				
						for(var i = 1; i < len-1; i += 2)
						{
							evenValues += iqamaNumber[i];
						}
				
						totalValues = evenValues + oddValues;
						checkDigit = totalValues.toString();
						checkDigit = checkDigit.charAt(checkDigit.length-1);
						checkDigitValue = eval(10 - checkDigit);
				
						if(checkDigitValue == 10)
						{
							if(checkDigitValue.toString().charAt(1) != val.charAt(len-1))
							{
								flag = false;
							}
						}
						else if(checkDigitValue.toString() != val.charAt(len-1))
						{
							flag = false;
						}
					}
					return flag;
    			}
			},
		    true
		);
		
		A.mix(A.config.FormValidator.STRINGS,
			{
				custDropDown:'<liferay-ui:message key="plz_select_value"/>',
				custId:'<liferay-ui:message key="enter_valid_num"/>',
				checkSum:'<liferay-ui:message key="enter_valid_id"/>',
				custUpload:'<liferay-ui:message key="invalid_file"/>'
			},
			true
		);
		var rules = 
		{
			<portlet:namespace/>driverId: {
	            required: true,
	            rangeLength: [10,10],
	            custId: true,
	            min:1,
	            number: true,
	            checkSum: true
		    },
			<portlet:namespace/>driverEdu: {
	            required: true, 
	            custDropDown: true
		    },
		    <portlet:namespace/>driverNoChild: {
		    	required: true, 
	            custDropDown: true
		    },
			<portlet:namespace/>buildNo: {
	            required: true, 
	            number: true,
	            min:1,
	            maxLength: 4
		    },
			<portlet:namespace/>stName: {
	            required: true
		    },
			<portlet:namespace/>district: {
	            required: true
		    },
			<portlet:namespace/>city: {
		    	required: true, 
	            custDropDown: true
		    },
			<portlet:namespace/>zipCode: {
	            required: true, 
	            number: true,
	            rangeLength: [5,5]
		    },
			<portlet:namespace/>addNo: {
	            number: true,
	            min:1,
	            maxLength: 4
		    },
		    <portlet:namespace/>insuredRelative: {
		    	required: true, 
	            custDropDown: true
		    }
		    
		    
		}
		
		if($("#<portlet:namespace/>driverDobH").is(":visible"))
		{
			rules.<portlet:namespace/>driverDobH = {
				required: true
		    }
		}
		else if($("#driverDob").is(":visible"))
		{
			rules.<portlet:namespace/>driverDob = {
				required: true
		    }
		}
		

		if($("#drvMstatusRow").is(":visible"))
		{
		    rules.<portlet:namespace/>driverMarStats= {
	            custDropDown: true
		    }
		}
		
		if($("#<portlet:namespace/>selectedFile").is(":visible"))
		{
		    rules.<portlet:namespace/>selectedFile= {
			    required: true,
			    custUpload: false
		    }
		}
		
		$(".licenseData").each(function(){
			var licCountryName = $(this).find("select[name*='driverLicCountry']").attr("name");
			var licTypeName = $(this).find("select[name*='driverLicType']").attr("name");
			var licYrsName = $(this).find("input[name*='driverLicYrs']").attr("name");
			var driverNOFault = $(this).find("input[name*='driverNOFault']").attr("name");
			var driverNOClaim = $(this).find("input[name*='driverNOClaim']").attr("name");
			
			rules[licCountryName]= {
	            required: true, 
	            custDropDown: true
		    }
			rules[licTypeName]= {
	            required: true, 
	            custDropDown: true
		    }
			rules[licYrsName]= {
	            required: true, 
	            number: true,
	            min:0
		    }
		});
		
		if($(".nFaultDiv").is(":visible"))
		{
			rules.<portlet:namespace/>driverNOFault = {
				required: true,
				number: true,
	            min:1
		    }
		}
		
		if($(".nClaimDiv").is(":visible"))
		{
			rules.<portlet:namespace/>driverNOClaim = {
				required: true,
				number: true,
	            min:1
		    }
		}
		
		if($(".dConvsDiv").is(":visible"))
		{
			rules.<portlet:namespace/>driverConvictions = {
				required: true
		    }
		}

		var fieldStrings = {
		    <portlet:namespace/>driverId: {
				rangeLength: '<liferay-ui:message key="enter_a_valid_number"/>',
				min: '<liferay-ui:message key="enter_a_valid_number"/>'
		    },
		    <portlet:namespace/>zipCode: {
				rangeLength: '<liferay-ui:message key="enter_5_digits"/>'
		    }
		}
		
		if($(".officeAddDiv").is(":visible"))
		{
			rules.<portlet:namespace/>offBuildNo = {
	            required: true, 
	            number: true,
	            min:1,
	            maxLength: 4
		    }
			rules.<portlet:namespace/>offStName = {
	            required: true
		    }
			rules.<portlet:namespace/>offDistrict = {
	            required: true
		    }
			rules.<portlet:namespace/>offCity= {
		    	required: true, 
	            custDropDown: true
		    }
			rules.<portlet:namespace/>offZipCode = {
	            required: true, 
	            number: true,
	            rangeLength: [5,5]
		    }
			rules.<portlet:namespace/>offAddNo = {
	            number: true,
	            min:1,
	            maxLength: 4
		    }	
			
			fieldStrings.<portlet:namespace/>offZipCode =
			{
				rangeLength: '<liferay-ui:message key="enter_valid_num"/>'
			}
		}
		
		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>addDriverForm',
		    rules:rules,
		    fieldStrings: fieldStrings,
		    validateOnBlur: false
		});
	});
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
		
		/* var today = new Date();
		alert("dob before split ");
		var drvDob = $("#driverDob").val();
	    var birthDate = new Date(drvDob.split("/")[2],parseInt(drvDob.split("/")[1]-1),drvDob.split("/")[0]);
	    alert("dob after split ");
	    console.log(birthDate);
	    var age = today.getFullYear() - birthDate.getFullYear();
	    var m = today.getMonth() - birthDate.getMonth();
	    if (m < 0 || (m === 0 && today.getDate() < birthDate.getDate())) {
	        age--;
	    }
	    if(age <16 || age >75)
	    {
	    	$("#error_container").html('<div class="portlet-msg-error"><liferay-ui:message key="age_limit_err"/></div>');
	    	$("html, body").animate({ scrollTop: 0 }, "slow");
	    	return false;
	    }
	     */
	    
		
		
    	
		
		
		if($("#proofDiv").is(":visible") && document.getElementById("<portlet:namespace/>selectedFile").value == "")
	    {
		    $("#error_container").html('<div class="portlet-msg-error">You have to select a file for a proof of relation</div>');
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
	    }
		
		
		$("#<portlet:namespace/>addDriverForm").submit();

    	/* var addedDrivers = $('.driversTbl', window.parent.document).find("input[name='<portlet:namespace />quotDrivers']");
	    console.log(addedDrivers);
    	if(!isEdit && addedDrivers != null && addedDrivers.length >0)
	    {
	    	var driverExists = false;
	    	addedDrivers.each(function(index) {
	    		var driverDet = $(this).val().replace(/'/g, "\"");
	    		driverDet = driverDet.replace(/#/g, ",")
	    		var driver = JSON.parse(driverDet);
	    		if(driver.driverId == $("#<portlet:namespace />driverId").val())
	    		{
		    		console.log( driver);
		    		$("#error_container").html('<div class="portlet-msg-error">This Driver has already been added.</div>');
		    		$("html, body").animate({ scrollTop: 0 }, "slow");
		    		driverExists = true;
		    		return false;
	    		}
	    	});
	    	if(driverExists)
	    		return false;
	    } */
 
	   
	    </aui:script>
						


			
					<aui:script>
	    
	    var pmntTypeVal = "VISA";
		buildValRules(pmntTypeVal);
		function buildValRules(pmntType)
		{
			rules = {};
			$("#<portlet:namespace/>quotForm .form-validator-stack").remove();
			$("#<portlet:namespace/>quotForm .error-field").removeClass("error-field");
			$("#<portlet:namespace/>quotForm .has-error").removeClass("has-error");
			$("#<portlet:namespace/>quotForm input").removeAttr("aria-invalid");

			AUI().use('aui-form-validator', function(A) {
				A.mix(A.config.FormValidator.RULES,
					{
						onlyEngLetters:function(val, fieldNode, ruleValue){
							var regex = new RegExp('^[a-zA-Z\040\-]+$');
							return regex.test(val);
						},
						custOlpId:function(val, fieldNode, ruleValue){
							var regex = new RegExp('^[a-zA-Z0-9_@.]*[a-zA-Z]+[a-zA-Z0-9_@.]*$');
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
						onlyEngLetters:'<liferay-ui:message key="only_en_letters"/>',
						custOlpId:'Please enter valid ID',
						custDropDown:'<liferay-ui:message key="plz_select_value"/>'
					},
				    true
				);
			});
			
			pmntTypeVal = pmntType;
			if(pmntType == "VISA")
			{
				rules.<portlet:namespace/>visaCardNo=
				{
					required: true,
					number:true,
					min:1,
					maxLength: 16
				}
				rules.<portlet:namespace/>visaNameCard =
				{
					required: true,
					onlyEngLetters:true,
					maxLength: 40
			   	}
				rules.<portlet:namespace/>visaExpMonth = 
				{
					required: true
				}
				rules.<portlet:namespace/>visaExpYear =
				{
					required: true,
					maxLength: 4
				}
				rules.<portlet:namespace/>visaVerfCode=
				{
					required: true,
					number: true,
					maxLength: 4
				}
				
			}
			else if(pmntType == "MASTERCARD")
			{
				rules.<portlet:namespace/>masterCardNo =
				{
					required: true,
					number:true,
					min:1,
					maxLength: 16
				}
				rules.<portlet:namespace/>masterNameCard=
				{
					required: true,
					onlyEngLetters:true,
					maxLength: 40
				}
				rules.<portlet:namespace/>masterExpMonth =
				{
					required: true
				}
				rules.<portlet:namespace/>masterCardYear =
				{
					required: true,
					maxLength: 4
				}
				rules.<portlet:namespace/>masterVerfCode =
				{
					required: true,
					number: true,
					maxLength: 4
				}
			 }
			else if(pmntType == "MADA")
			{
				rules.<portlet:namespace/>madaCardNo =
				{
					required: true,
					number:true,
					min:1,
					maxLength: 16
				}
				rules.<portlet:namespace/>madaExpMonth =
				{
					required: true
				}
				rules.<portlet:namespace/>madaCardYear =
				{
					required: true,
					maxLength: 4
				}
				rules.<portlet:namespace/>madaVerfCode =
				{
					required: true,
					number: true,
					maxLength: 4
				}
			 }
			 else if(pmntType == "OLP")
			 {
				rules.<portlet:namespace/>olpID =
				{
					required: true,
					custOlpId: true,
					rangeLength: [6,12]
				}
			 }
			
			rules.<portlet:namespace/>pmntTerms =
			{
				required: true
			}
		 }
		
	    var frmValidator;
		function validateQuoteFormAndSubmit()
		{
		    $("#submitBtn").attr('disabled', true);
		    if (frmValidator)
				frmValidator.resetAllFields();
			AUI().use('aui-form-validator', function(A) {
				frmValidator = new A.FormValidator({
				    boundingBox: '#<portlet:namespace/>quotForm',
				    rules:rules
				});
		
			});
			
			frmValidator.validate();

			if(!frmValidator.hasErrors())
			{
				
					doPayment(pmntTypeVal);
			}
		
		 }
		 
		function doPayment(pmntTypeVal)
		{
			if(pmntTypeVal == "VISA" || pmntTypeVal == "MASTERCARD" || pmntTypeVal == "MADA")
			{
			    //$("#submitBtn").attr('disabled', true);
				$("#<portlet:namespace/>pmntType").val(pmntTypeVal).appendTo('#<portlet:namespace/>quotForm');
				var access_code = $("#access_code").val();
				var language = $("#language").val();
				var merchant_identifier = $("#merchant_identifier").val();
				var currTime = new Date().getTime();
				var merchant_reference = $("#merchant_reference").val()+"_"+currTime;
				$("#merchant_reference").val(merchant_reference);

				var csc = '';
				if(pmntTypeVal == "VISA")
				    csc = $("#<portlet:namespace/>visaVerfCode").val()
				else if(pmntTypeVal == "MASTERCARD")
				    csc = $("#<portlet:namespace/>masterVerfCode").val();
				else if(pmntTypeVal == "MADA")
				    csc = $("#<portlet:namespace/>madaVerfCode").val();
				
				csc = toHex(csc);
				$("#card_security_code").val(csc);

				var return_url = $("#return_url").val();
				//return_url += "&payment_option="+pmntTypeVal+"&csc="+csc+"&token_name=3432432&status=2";
				return_url += "&payment_option="+pmntTypeVal+"&csc="+csc;
				$("#return_url").val(return_url);
				var service_command = $("#service_command").val();

				var  signature = requestPhrase + 'access_code='+access_code+'language='+language+'merchant_identifier='+merchant_identifier+'merchant_reference='+merchant_reference+'return_url='+return_url+'service_command='+service_command+requestPhrase;

				var expiry_date;
				var card_number;
				var verf_code;
				if(pmntTypeVal == "VISA")
			    {
					if($("#<portlet:namespace/>visaExpYear").val().length>=4)
					expiry_date = $("#<portlet:namespace/>visaExpYear").val().substring(2, 4) + $("#<portlet:namespace/>visaExpMonth").val();
					else
					expiry_date = $("#<portlet:namespace/>visaExpYear").val()+ $("#<portlet:namespace/>visaExpMonth").val();
					card_number = $("#<portlet:namespace/>visaCardNo").val();
					verf_code = $("#<portlet:namespace/>visaVerfCode").val(); 
			    }
				else if(pmntTypeVal == "MASTERCARD")
			    {
					if($("#<portlet:namespace/>masterCardYear").val().length>=4)
					expiry_date = $("#<portlet:namespace/>masterCardYear").val().substring(2, 4) + $("#<portlet:namespace/>masterExpMonth").val();
					else
						expiry_date = $("#<portlet:namespace/>masterCardYear").val() + $("#<portlet:namespace/>masterExpMonth").val();
					card_number = $("#<portlet:namespace/>masterCardNo").val();
					verf_code = $("#<portlet:namespace/>masterVerfCode").val();
			    }
				else if(pmntTypeVal == "MADA")
			    {
					if(expiry_date = $("#<portlet:namespace/>madaCardYear").val().length >=4)
					expiry_date = $("#<portlet:namespace/>madaCardYear").val().substring(2, 4) + $("#<portlet:namespace/>madaExpMonth").val();
					else
					expiry_date = $("#<portlet:namespace/>madaCardYear").val()+$("#<portlet:namespace/>madaExpMonth").val();
					card_number = $("#<portlet:namespace/>madaCardNo").val();
					verf_code = $("#<portlet:namespace/>madaVerfCode").val();
			    }
				
				$("#expiry_date").val(expiry_date);
				$("#card_number").val(card_number);
				$("#card_security_code").val(verf_code);

				var sha256 = new jsSHA('SHA-256', 'TEXT');
				sha256.update(signature);
				var hash = sha256.getHash("HEX");
				$("#signature").val(hash).appendTo('#pmntForm');
				$("#pmntForm").submit();
				//window.location=return_url;
			}
			else
			{
				/* $(inputTemplate).attr('name','<portlet:namespace/>totalAmount').val('').appendTo('#<portlet:namespace/>quotForm'); */
				$("#<portlet:namespace/>quotForm").submit();
			}
		}
		
		
		
		
		function toHex(tmp)
		{
			var str = '', i = 0, tmp_len = tmp.length, c;
		 
		    for (; i < tmp_len; i += 1)
		    {
		        c = tmp.charCodeAt(i);
		        str += c.toString(16); + ' ';
		    }
		    return str;
		}
		function termsAndCondFn()
		{
			AUI().use('aui-modal', function(A) {
					var dialog = new A.Modal({
						title: "",
						bodyContent: AUI().one('#aui_popup_body_2').html(),
						headerContent: '<h3 class="no-margin"><liferay-ui:message key="t_c"/></h3>',
						centered: true,
						modal: true,
						height: 400,
						render: '#aui_popup_content'
					});
					dialog.addToolbar(
					      [
					        {
					        	label: '<liferay-ui:message key="agree_t&c"/>',
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
	    
	    
	    
 		/* AUI().use('aui-io-request', function(A){
			
	        A.io.request('<%=resourceURLVal%>', {
	               method: 'post',
	               dataType: 'json',
	               form: {
	                   id: 'submitForm',
	                   upload: true
	               },
	               on: {
	            	   failure: function() {
	            		   //alert(1);
                       }, 
                       error: function() {
	               	   		//alert(2);
                       }, 
	            	   success: function()
	                   {
	            	   		//alert(3);
	                   },
	                   complete: function(jqXHR, textStatus)
	                   {
	                       //alert(4);
	                    	var res = jqXHR.details[1]['responseText'];
	                    	if(res .indexOf('success') > -1)
	                    	{
	                    		driver = JSON.parse(res.split("#")[1]);
	                    		window.parent.addDriver(driver, isEdit);
	                    		$('.close', window.parent.document).click().click();
	                    	}
	                    	else if(res.indexOf('error') > -1) {
	                    		window.parent.addDriver(driver, isEdit, res.split("#")[1]);
	                    		$('.close', window.parent.document).click().click();
	                    	}
	                   }
                       
	               }
	            });
	    });  */
	}
}
/* document.getElementById('<portlet:namespace/>uploadFile').onchange = function () {
	document.getElementById('<portlet:namespace/>selectedFile').value =  this.files.item(0).name; 
	}; */

</aui:script>