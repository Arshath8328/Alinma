<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationDriverLicense"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationDriver"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%
	List educationList = (List) request.getAttribute("educationList");
	List countries = (List) request.getAttribute("countries");
	List licTypes = (List) request.getAttribute("licTypes");
	List cities = (List) request.getAttribute("cities");

	Quotation quot = (Quotation) request.getAttribute("quot");
	QuotationDriver driver = (QuotationDriver) request.getAttribute("driver");
	boolean isEdit = false;
	QuotationDriverLicense ksaLicense = null;
	List<QuotationDriverLicense> otherLicenses = new ArrayList();
	if (driver != null) {
		isEdit = true;
		for (int licCount = 0; driver.getDriverLicences()!=null && licCount < driver.getDriverLicences().size(); licCount++) {
			QuotationDriverLicense license = driver.getDriverLicences().get(licCount);
			if (license.getLicCountry().equals("03")) {
				ksaLicense = license;
			} else
				otherLicenses.add(license);
		}
	}
%>
		<portlet:resourceURL var="captchaURL"/>
		<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<div class="row">
	<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
		<div class="portlet-content">
			<div id="error_container"></div>
			<form name="<portlet:namespace/>addDriverForm"	id="<portlet:namespace/>addDriverForm">
				<ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message	key="drv_dets" /></li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label">
										<div role="group" class="btn-group btn-group-justified"
											data-toggle="buttons">
											<label class="btn btn-default idTypeBtn <%=(!isEdit || (isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_SAUDI))) ? "active" : ""%> focus control-label">
												<input type="radio" name="<portlet:namespace/>driverIdType" id="idTypeSaudi" value="<%=BuyMotorPolicyPortletKeys.ID_TYPE_SAUDI%>" autocomplete="off" <%=(!isEdit || (isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_SAUDI))) ? "checked='true'" : ""%> onchange="manageTypeValidation();" />
												<liferay-ui:message key="saudi_id" />
											</label>
											<label class="btn btn-default control-label idTypeBtn <%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA)) ? "active" : ""%> ">
												<input type="radio" name="<portlet:namespace/>driverIdType" id="idTypeIqama" value="<%=BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA%>" autocomplete="off" <%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA)) ? "checked='true'" : ""%> onchange="manageTypeValidation();" />
												<liferay-ui:message key="iqama_id" />
											</label>
										</div>
									</label>
									<input class="form-control" type="text" name="<portlet:namespace />driverId" id="<portlet:namespace />driverId" placeholder="105XXXXXXXX" <%=(isEdit) ? ("value='" + driver.getDriverId() + "'") : ""%> />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label dobLbl"style="padding: 12px 0 11px 0;"><liferay-ui:message	key="driver_dob_h" /></label>
									<input class="form-control" type="text" readonly placeholder="dd/mm/yyyy" <%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA)) ? "style='display:none;'" : ""%> name="<portlet:namespace />driverDobH" id="<portlet:namespace />driverDobH" <%=(isEdit) ? ("value='" + driver.getDriverDobH() + "'") : ""%> />
									<input class="form-control" type="text" readonly placeholder="dd/mm/yyyy" <%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA)) ? "" : "style='display:none;'"%> name="<portlet:namespace/>driverDob" id="driverDob" <%=(isEdit) ? ("value='" + dmyDateFormatter.format(driver.getDriverDob()) + "'") : ""%> />
									<span class="glyphicon form-control-feedback glyphicon-calendar text-muted" style="padding: 22px 0 0 0;"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="education" /></label>
									<select class="form-control" name="<portlet:namespace />driverEdu" id="<portlet:namespace />driverEdu">
										<option value="-1"><liferay-ui:message key="please_select_option" /></option>
<%
											for (int eCount = 0; eCount < educationList.size(); eCount++)
											{
												CodeMasterDetails edu = (CodeMasterDetails) educationList.get(eCount);
												String selected = "";
												if (isEdit && driver.getDriverEdu() != null && driver.getDriverEdu().equals(edu.getCodeSub()))
													selected = "selected";
%>
										<option value="<%=edu.getCodeSub()%>" <%=selected%>><%=currLocale.equals("en_US") ? edu.getCodeDesc() : edu.getCodeDescAr()%></option>
<%
											}
%>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="no_child_16" /></label> <select class="form-control"
										id="<portlet:namespace />driverNoChild"
										name="<portlet:namespace />driverNoChild">
										<option value="-1"><liferay-ui:message key="please_select_option" /></option>
										<%
											for (int cCount = 0; cCount < 11; cCount++) {
												String selected = "";
												if (isEdit && driver.getDriverNoChild() != null && Integer.valueOf(driver.getDriverNoChild()) == cCount)
													selected = "selected";
										%>
										<option value="<%=cCount%>" <%=selected%>><%=cCount%></option>
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
									<label class="control-control control-label"><liferay-ui:message key="are_you_relative_insured" /></label> 
									<select id="<portlet:namespace/>insuredRelative" name="<portlet:namespace/>insuredRelative" class="form-control">
										<option value="-1"><liferay-ui:message key="please_select_option" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_1%>"><liferay-ui:message key="INSURED_RELATION_1" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_2%>"><liferay-ui:message key="INSURED_RELATION_2" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_3%>"><liferay-ui:message key="INSURED_RELATION_3" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_4%>"><liferay-ui:message key="INSURED_RELATION_4" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_5%>"><liferay-ui:message key="INSURED_RELATION_5" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_6%>"><liferay-ui:message key="INSURED_RELATION_6" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_7%>"><liferay-ui:message key="INSURED_RELATION_7" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_8%>"><liferay-ui:message key="INSURED_RELATION_8" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_9%>"><liferay-ui:message key="INSURED_RELATION_9" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_10%>"><liferay-ui:message key="INSURED_RELATION_10" /></option>
										<option value="<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_0%>"><liferay-ui:message key="INSURED_RELATION_0" /></option>
									</select>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12" id="proofDiv" style="display:none;">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="uploaded_attchements" /></label> 
									<input id="<portlet:namespace/>selectedFile" readonly name="<portlet:namespace/>selectedFile" class="form-control" placeholder="<%=LanguageUtil.get(request, "sel_file_loc") %>" data-toggle="tooltip" data-placement="bottom" title="advise customer" data-inputID="<portlet:namespace/>uploadFile" onclick="$('#<portlet:namespace/>uploadFile').click();">
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
								</div>
							</div>
						</div>
						<div class="alert alert-info" role="alert"><liferay-ui:message key="inaccurate_info_disclaimer" /></div>
						
						<div class="row" id="drvMstatusRow"
							<%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA)) ? "style='display:none;'" : ""%>>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="marital_status" /></label> 
									<select class="form-control" id="<portlet:namespace />driverMarStats" name="<portlet:namespace />driverMarStats">
										<option value="-1"><liferay-ui:message key="please_select_option" /></option>
										<option value="Single" <%=(isEdit && driver.getDriverMaritalStatus() != null && driver.getDriverMaritalStatus().equals("Single")) ? "selected" : ""%>><liferay-ui:message key="single" /></option>
										<option value="Married" <%=(isEdit && driver.getDriverMaritalStatus() != null && driver.getDriverMaritalStatus().equals("Married")) ? "selected" : ""%>><liferay-ui:message key="married" /></option>
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
										<label class="control-control control-label"><liferay-ui:message key="country_drv_lic" /></label>
										<select class="form-control" id="<portlet:namespace />_0_driverLicCountry" name="<portlet:namespace />_0_driverLicCountry" disabled>
											<option value="-1"><liferay-ui:message key="please_select_option" /></option>
											<%
												for (int cCount = 0; cCount < countries.size(); cCount++) {
													CodeMasterDetails country = (CodeMasterDetails) countries.get(cCount);
													String selected = "";
													if (country.getCodeSub().equals("03"))
														selected = "selected";
											%>
											<option value="<%=country.getCodeSub()%>" <%=selected%>><%=currLocale.equals("en_US") ? country.getCodeDesc() : country.getCodeDescAr()%></option>
											<%
												}
											%>
										</select>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-control control-label"><liferay-ui:message key="type_drv_lic" /></label>
										<select class="form-control"	id="<portlet:namespace />_0_driverLicType" name="<portlet:namespace />_0_driverLicType">
											<option value="-1"><liferay-ui:message key="please_select_option" /></option>
<%
												for (int lCount = 0; lCount < licTypes.size(); lCount++)
												{
													CodeMasterDetails type = (CodeMasterDetails) licTypes.get(lCount);
													String selected = "";
													if (isEdit && ksaLicense != null && ksaLicense.getLicType().equals(type.getCodeSub()))
														selected = "selected";
%>
											<option value="<%=type.getCodeSub()%>" <%=selected%>><%=currLocale.equals("en_US") ? type.getCodeDesc() : type.getCodeDescAr()%></option>
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
										<label class="control-control control-label"><liferay-ui:message key="no_yrs" /></label>
										<input class="form-control" type="text"	placeholder="<%=LanguageUtil.get(request, "plz_enter")%>"	id="<portlet:namespace />_0_driverLicYrs" name="<portlet:namespace />_0_driverLicYrs" <%=(isEdit && ksaLicense != null) ? ("value='" + ksaLicense.getLicYrs() + "'") : ""%> data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content='<%= LanguageUtil.get(request,"if_held_less_year_zero") %>'>
										<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
									</div>
								</div>
							</div>
						</div>

						
						





						<div id="input_fields_wrap">
							<%
								if (isEdit && otherLicenses != null && !otherLicenses.isEmpty())
								{
									for (int licCount = 0; licCount < otherLicenses.size(); licCount++)
									{
										QuotationDriverLicense license = otherLicenses.get(licCount);
							%>
							<div class="licenseData">
								<hr />
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="country_drv_lic" /></label> <select class="form-control" id="<portlet:namespace />_<%=licCount + 1%>_driverLicCountry" name="<portlet:namespace />_<%=licCount + 1%>_driverLicCountry">
												<option value="-1"><liferay-ui:message key="please_select_option" /></option>
<%
													for (int cCount = 0; cCount < countries.size(); cCount++)
													{
																CodeMasterDetails country = (CodeMasterDetails) countries.get(cCount);
																String selected = "";

																if (license.getLicCountry() != null && license.getLicCountry().equals(country.getCodeSub()))
																	selected = "selected";
%>
												<option value="<%=country.getCodeSub()%>" <%=selected%>><%=currLocale.equals("en_US") ? country.getCodeDesc() : country.getCodeDescAr()%></option>
<%
													}
%>
											</select>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="type_drv_lic" /></label> <select class="form-control" id="<portlet:namespace />_<%=licCount + 1%>_driverLicType" name="<portlet:namespace />_<%=licCount + 1%>_driverLicType">
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
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-control control-label"><liferay-ui:message key="no_yrs" /></label> <input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />_<%=licCount + 1%>_driverLicYrs" name="<portlet:namespace />_<%=licCount + 1%>_driverLicYrs" value="<%=license.getLicYrs()%>" data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content='<%= LanguageUtil.get(request,"if_held_less_year_zero") %>'>
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
								</div>
							</div>
<%
								}
							}
%>

						</div> <%
 	if (!isEdit || (isEdit && otherLicenses != null && otherLicenses.size() < 2)) {
 %>
						<div class="row">
							<div class="col-md-12">
								<button id="add_field_btn" class="btn btn-default btn-xs-block"
									type="button">
									<i class="glyphicon glyphicon-plus"></i>
									<liferay-ui:message key="add_another_country" />
								</button>
							</div>
						</div> <%
 	}
 %>
					</li>
				</ul>
				<br />
				<ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message key="drv_acc_history" /></li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="fault_accidents_made" /></label>
									<label class="switch control-label"> <input type="checkbox" id="driverNoFaultId" <%=(isEdit && driver.getDriverNOFault() > 0) ? "checked" : ""%> />
										<div></div>
										<span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no")%>"></span>
									</label>
									<div class="row nFaultDiv"
										<%=(isEdit && driver.getDriverNOFault() > 0) ? "" : "style='display:none;'"%>>
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />driverNOFault" name="<portlet:namespace />driverNOFault" <%=(isEdit && driver.getDriverNOFault() > 0) ? ("value='" + driver.getDriverNOFault() + "'") : ""%> />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="fault_accids_submit" /></label>
									<label class="switch control-label"> <input type="checkbox" id="driverNoClaimId" <%=(isEdit && driver.getDriverNOClaim() > 0) ? "checked" : ""%> />
										<div></div> <span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no") %>"></span>
									</label>
									<div class="row nClaimDiv"
										style="<%=(isEdit && driver.getDriverNOClaim() > 0) ? "" : "display:none"%>">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_enter") %>" id="<portlet:namespace />driverNOClaim" name="<portlet:namespace />driverNOClaim" <%=(isEdit && driver.getDriverNOClaim() > 0) ? ("value='" + driver.getDriverNOClaim() + "'") : ""%> />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="road_convs" /></label> <label class="switch control-label">
										<input type="checkbox" id="driverConvictionsId" <%=(isEdit && driver.getDriverConvictions() != null && !driver.getDriverConvictions().equals(""))? "checked": ""%> />
										<div></div> <span label-yes="<%=LanguageUtil.get(request, "yes") %>" label-no="<%=LanguageUtil.get(request, "no") %>"></span>
									</label>
									<div class="row dConvsDiv"
										style="<%=(isEdit && driver.getDriverConvictions() != null && !driver.getDriverConvictions().equals(""))? "": "display:none"%>">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder="<%=LanguageUtil.get(request, "plz_specify") %>" id="<portlet:namespace />driverConvictions" name="<portlet:namespace />driverConvictions" <%=(isEdit && driver.getDriverConvictions() != null) ? ("value='" + driver.getDriverConvictions() + "'"):""%> />
										</div>
									</div>
								</div>
								<div class="form-group">
									<label class="control-label text-primary"><liferay-ui:message key="med_conds" /></label>
									<div class="row">
										<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
											<input class="form-control" type="text" placeholder='<%= LanguageUtil.get(request,"optional") %>' id="<portlet:namespace />driverMedConds" name="<portlet:namespace />driverMedConds" <%=(isEdit && driver.getDriverMedConds() != null) ? ("value='" + driver.getDriverMedConds() + "'") : ""%> />
										</div>
									</div>
								</div>
							</div>
						</div>
					</li>
				</ul>
				<br />
				<ul class="list-group no-margin">
					<li class="list-group-item bg-gray"><liferay-ui:message key="drv_nat_addr" /></li>
					<li class="list-group-item">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="building_no" /></label> <input class="form-control" type="text"
										placeholder="" id="<portlet:namespace />buildNo"
										name="<portlet:namespace />buildNo"
										value="<%=(isEdit && driver.getDriverNatAddress() != null
					&& driver.getDriverNatAddress().getBuildNo() != null)
							? driver.getDriverNatAddress().getBuildNo()
							: ""%>" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="street_name" /></label> <input class="form-control" type="text" placeholder="" id="<portlet:namespace />stName" name="<portlet:namespace />stName" value="<%=(isEdit && driver.getDriverNatAddress() != null && driver.getDriverNatAddress().getStName() != null)? driver.getDriverNatAddress().getStName(): ""%>" />
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="district" /></label> <input class="form-control" type="text" placeholder="" id="<portlet:namespace />district" name="<portlet:namespace />district" value="<%=(isEdit && driver.getDriverNatAddress() != null && driver.getDriverNatAddress().getDistrict() != null) ? driver.getDriverNatAddress().getDistrict() : ""%>" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="city" /></label> <select class="form-control" name="<portlet:namespace/>city" id="<portlet:namespace/>city">
										<option value="-1"><liferay-ui:message key="please_select_option" /></option>
										<%
											for (int cityCount = 0; cities != null && cityCount < cities.size(); cityCount++) {
												CodeMasterDetails city = (CodeMasterDetails) cities.get(cityCount);
												String selected = "";
												if (isEdit && driver.getDriverNatAddress() != null && driver.getDriverNatAddress().getCity() != null
														&& driver.getDriverNatAddress().getCity().equals(city.getCodeSub()))
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
										placeholder="" id="<portlet:namespace />zipCode"
										name="<portlet:namespace />zipCode"
										value="<%=(isEdit && driver.getDriverNatAddress() != null
					&& driver.getDriverNatAddress().getZipCode() != null)
							? driver.getDriverNatAddress().getZipCode()
							: ""%>" />
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-control control-label"><liferay-ui:message key="add_no" /></label>
									<input class="form-control" type="text" placeholder="<%= LanguageUtil.get(request,"optional") %>" id="<portlet:namespace />addNo" name="<portlet:namespace />addNo" value="<%=(isEdit && driver.getDriverNatAddress() != null && driver.getDriverNatAddress().getAddNo() != null)? driver.getDriverNatAddress().getAddNo(): ""%>" />
								</div>
							</div>
						</div>
					</li>
				</ul>
				<br />
				<ul class="list-group no-margin">
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
				</ul>
				<br />
				<div class="row">
					<div class="col-md-12 no-pad">
						<ul class="list-btns">
							<li>
								<button class="btn btn-primary btn-lg btn-xs-block" type="button" onClick="saveDriver($(this));">
									<liferay-ui:message key="save" />
								</button>
							</li>
						</ul>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>

<%
	PortletURL resourceURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
			themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	resourceURL.setParameter("resourceType", "addriver");
	String resourceURLVal = resourceURL.toString();
	if (resourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
		resourceURLVal = resourceURLVal.substring(0, resourceURLVal.lastIndexOf("&p_p_lifecycle=1"));
%>
<form id="submitForm" class="hidden" enctype="multipart/form-data"
	action="${resourceURLVal}">
	<input type="hidden" id="<portlet:namespace/>driver" name="<portlet:namespace/>driver" value="" />
	<aui:input type="file" name="uploadFile" id="uploadFile" cssClass="sr-only" label="" title="">
		 <aui:validator name="acceptFiles">'jpg,jpeg,png,pdf,doc,docx'</aui:validator>
         <%--<aui:validator name="custom" errorMessage="max_upload_size">
			function(val,node,junction){
				var uploadSize=true;
               var size=0;
              var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
               for(var num1=0;num1<fileInput.files.length;num1++)
                {
                                    			        var file=fileInput.files[num1];
                                    		            if(file.size>2097152)
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
                                    	</aui:validator>--%>
                                    	<aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
					                        function(val,node,junction){
					                        	var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
												var fileName = "";
													if(fileInput.files.length>0)
														fileName = fileInput.files.item(0).name;
												var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
												return regex.test(fileName);
											}
										</aui:validator>
	</aui:input>
	<liferay-captcha:captcha url="<%=captchaURL%>" />
		
	</form>
<script>

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
	if(<%=isEdit%>)
	{
	    var insuredRelative = "<%=driver != null ? driver.getInsuredRelative() : "-1"%>";
	    $("#<portlet:namespace/>insuredRelative").val(insuredRelative);
	    if(insuredRelative != "-1" && insuredRelative != '<%=BuyMotorPolicyPortletKeys.INSURED_RELATION_0%>')
		{
			document.getElementById('<portlet:namespace/>selectedFile').value = "<%=driver != null ? driver.getRelationProofFileName() : ""%>"
			$("#proofDiv").show();
		}
	    else {
			document.getElementById('<portlet:namespace/>selectedFile').value = "";
			$("#proofDiv").hide();
		}
	}
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
			$("#driverDob").val(((convertedDate._day<10)?("0"+convertedDate._day):convertedDate._day)+"/"+((convertedDate._month<10)?("0"+convertedDate._month):convertedDate._month)+"/"+convertedDate._year);
		}
		else
		{
			$("#driverDob").val("");
		}					
	}

	<%=currLocale.equals("en_US") ? "" : ", isRTL: true"%>
});

$("#driverDob").calendarsPicker({
	calendar: $.calendars.instance('gregorian'<%=currLocale.equals("en_US") ? "" : ",'ar-EG'"%>),
	dateFormat: 'dd/mm/yyyy',
	maxDate: 0,
	yearRange: '-100:2018',
	<%=currLocale.equals("en_US") ? "" : "isRTL: true,"%>
	onClose: function(dates){
		var zDate = $("#driverDob").val().split("/");
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
var max_fields      = 5; 
var wrapper         = $("#input_fields_wrap"); 
var add_button      = $("#add_field_btn"); 

var x = 0;
if(<%=isEdit%>)
	x = <%=(otherLicenses != null && !otherLicenses.isEmpty()) ? otherLicenses.size() : 0%>;
var countriesContent = $("#<portlet:namespace />_0_driverLicCountry").html().replace("selected=\"\"","");
var typesContent = $("#<portlet:namespace />_0_driverLicType").html();

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
var allowedCharacters = "<%=(isEdit && driver.getDriverIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.ID_TYPE_IQAMA))
					? "2"
					: "1"%>";
function manageTypeValidation()
{
	$("#<portlet:namespace />driverDobH").val("");
	$("#driverDob").val("");

	if($('#idTypeSaudi').is(":checked"))
	{
		allowedCharacters = "1";
		$("#<portlet:namespace />driverDobH").show();
		$("#driverDob").hide();
		$(".dobLbl").text("<%=LanguageUtil.get(request, "driver_dob_h")%>");
		$("#drvMstatusRow").show();
	}
	else
	{
		allowedCharacters = "2";
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
				custUpload:function(val, fieldNode, ruleValue){
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
				},
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
			    custUpload: true
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
		
		var today = new Date();
		var drvDob = $("#driverDob").val();
	    var birthDate = new Date(drvDob.split("/")[2],parseInt(drvDob.split("/")[1]-1),drvDob.split("/")[0]);
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
		
		var isEdit = <%=isEdit%>;
    	
		if(!isEdit && <%=quot.isMainDriver()%> && $("#<portlet:namespace />driverId").val()=="<%=quot.getInsuredId()%>")
		{
			$("#error_container").html('<div class="portlet-msg-error">You have to enter a different driver other than the vehicle owner.</div>');
			$("html, body").animate({ scrollTop: 0 }, "slow");
    		return false;
		}
		
		if($("#proofDiv").is(":visible") && document.getElementById("<portlet:namespace/>selectedFile").value == "")
	    {
		    $("#error_container").html('<div class="portlet-msg-error">You have to select a file for a proof of relation</div>');
			$("html, body").animate({ scrollTop: 0 }, "slow");
			return false;
	    }

    	var addedDrivers = $('.driversTbl', window.parent.document).find("input[name='<portlet:namespace />quotDrivers']");
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
	    }
 
	    var driver = {};
		driver.driverId = $("#<portlet:namespace />driverId").val();
		driver.driverIdType = $("input[name='<portlet:namespace />driverIdType']:checked").val()
		driver.driverDobH = $("#<portlet:namespace />driverDobH").val();
		driver.driverDob = birthDate.toISOString();
		driver.driverEdu = $("#<portlet:namespace />driverEdu option:selected").val();
		driver.driverNoChild = $("#<portlet:namespace />driverNoChild option:selected").val();
		driver.insuredRelative = $("#<portlet:namespace />insuredRelative").val();
		if($("#drvMstatusRow").is(":visible"))
			driver.driverMaritalStatus = $("#<portlet:namespace />driverMarStats option:selected").val();
		
		var driverLicences = [];
		$(".licenseData").each(function(){
			var driverLicense = {};
			driverLicense.LicCountry = $(this).find("select[name*='driverLicCountry'] option:selected").val();
			driverLicense.LicType = $(this).find("select[name*='driverLicType'] option:selected").val();
			driverLicense.LicYrs = $(this).find("input[name*='driverLicYrs']").val();

			driverLicences.push(driverLicense);
		});
		driver.driverLicences = driverLicences;
		
		driver.driverNOFault = parseInt($("#<portlet:namespace />driverNOFault").val());
		driver.driverNOClaim = parseInt($("#<portlet:namespace />driverNOClaim").val());
		driver.driverConvictions = $("#<portlet:namespace />driverConvictions").val();
		driver.driverMedConds = $("#<portlet:namespace />driverMedConds").val();
		
		var driverNatAddress = {};
		driverNatAddress.buildNo = $("#<portlet:namespace />buildNo").val();
		driverNatAddress.stName = $("#<portlet:namespace />stName").val();
		driverNatAddress.district = $("#<portlet:namespace />district").val();
		driverNatAddress.city = $("#<portlet:namespace />city").val();
		driverNatAddress.zipCode = $("#<portlet:namespace />zipCode").val();
		driverNatAddress.addNo = $("#<portlet:namespace />addNo").val();
		driver.driverNatAddress = driverNatAddress;
		
		if($(".officeAddDiv").is(":visible"))
		{
			var driverOffNatAddress = {};
			driverOffNatAddress.buildNo = $("#<portlet:namespace />offBuildNo").val();
			driverOffNatAddress.stName = $("#<portlet:namespace />offStName").val();
			driverOffNatAddress.district = $("#<portlet:namespace />offDistrict").val();
			driverOffNatAddress.city = $("#<portlet:namespace />offCity").val();
			driverOffNatAddress.zipCode = $("#<portlet:namespace />offZipCode").val();
			driverOffNatAddress.addNo = $("#<portlet:namespace />offAddNo").val();
			driver.driverOffNatAddress = driverOffNatAddress;
		}
		
		driver.insuredRelative = $("#<portlet:namespace />insuredRelative").val();
		
		
		
		var selectedFiles = document.getElementById("<portlet:namespace/>uploadFile").files;
		if(selectedFiles.length > 0)
		{
			driver.relationProofFileName = document.getElementById("<portlet:namespace/>uploadFile").files[0].name;
		}
		if(isEdit)
		    driver.relationProofFileName = document.getElementById('<portlet:namespace/>selectedFile').value;
		
		$("#submitForm").find("#<portlet:namespace/>driver").val(JSON.stringify(driver));
		
		AUI().use('aui-io-request', function(A){
			
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
	    });
	}
}
document.getElementById('<portlet:namespace/>uploadFile').onchange = function () {
	document.getElementById('<portlet:namespace/>selectedFile').value =  this.files.item(0).name; 
	};

</script>