<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.atmc.otp.constants.OtpPortletKeys"%>
<%@page import="com.atmc.web.constants.LoginPortletKeys"%>
<%@page import="com.atmc.bsl.db.exception.YaqeenException"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil" %>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@ include file="init.jsp"%>
<%
	boolean isBack = ParamUtil.getBoolean(request, "isBack");
	boolean yaqeenError = (request.getAttribute(BuyMotorPolicyPortletKeys.YAQEEN_ERROR)!=null)?((Boolean)request.getAttribute(BuyMotorPolicyPortletKeys.YAQEEN_ERROR)):false;
	boolean genericError = (request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR)!=null)?((Boolean)request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR)):false;
	boolean maxQuoteError = (request.getAttribute(BuyMotorPolicyPortletKeys.MAX_QUOTE_ERROR)!=null)?((Boolean)request.getAttribute(BuyMotorPolicyPortletKeys.MAX_QUOTE_ERROR)):false;
	boolean renewablePolicyExistsError = (request.getAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR)!=null)?((Boolean)request.getAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR)):false;
	boolean nonExpiredPolicyExistsError = (request.getAttribute(BuyMotorPolicyPortletKeys.POLICY_EXISTS_ERROR)!=null)?((Boolean)request.getAttribute(BuyMotorPolicyPortletKeys.POLICY_EXISTS_ERROR)):false;
	String yaqeenMessage = (yaqeenError)?(String)request.getAttribute(BuyMotorPolicyPortletKeys.YAQEEN_MESSAGE):"";
	String maxQuoteMessage = (maxQuoteError)?(String)request.getAttribute(BuyMotorPolicyPortletKeys.MAX_QUOTE_ERROR_MESSAGE):"";
	String genericMessage = (genericError)?(String)request.getAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE):"";
	String renewablePolicyExistsMessage = (renewablePolicyExistsError)?(String)request.getAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR_MESSAGE):"";
	boolean userRegistered = (request.getAttribute("userRegistered")!=null)?((Boolean)request.getAttribute("userRegistered")):false;
	String nonExpiredPolicyExistsMessage = (nonExpiredPolicyExistsError)?(String)request.getAttribute(BuyMotorPolicyPortletKeys.POLICY_EXISTS_ERROR_MESSAGE):"";
	if(yaqeenError || genericError)
		isBack = true;
	Quotation quot = (Quotation)request.getAttribute("quot");
	boolean isMainDriver = quot != null ? quot.isMainDriver() : true;
	long vIdType = (isBack)?quot.getVehicleIdType():0l;
%>
<portlet:actionURL name="personalInfo" var="personalInfo" >
</portlet:actionURL>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<div class="row bg-white margin-top">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><liferay-ui:message key="ind_app"/></h3>
	</div>
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
	</div>
</div>
<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL %>" message="Payment Error" />
<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL %>" message='<%= LanguageUtil.get(request,"policy_issuance_error") %>' />
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1">
		<div class="portlet-content">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-offset-1 col-md-10 col-lg-10 col-lg-offset-1">
				<div class="policy">
					<h3><liferay-ui:message key="sel_reg_type"/></h3>
					<ul class="nav nav-tabs nav-justified">
						<li class="<%=(!isBack ||(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)))?"active":"" %>" onclick="enableCals(1);">
							<a href="#tab-1" role="tab" data-toggle="tab"><i class="icon icon-business-3 md-36"></i> <liferay-ui:message key="ist_card"/></a>
						</li>
						<li class="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?"active":"" %>" onclick="enableCals(2);">
							<a href="#tab-2" role="tab" data-toggle="tab"><i class="icon icon-cruise-ship md-36"></i> <liferay-ui:message key="cust_card"/> </a>
						</li>
						<li class="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?"active":"" %>" onclick="enableCals(3);">
							<a href="#tab-3" role="tab" data-toggle="tab"><i class="icon icon-transfer md-36"></i> <liferay-ui:message key="trns_owner"/> </a>
						</li>
					</ul>
					<aui:form id="form1" cssClass="abc" name="form1" role="form" action="<%=personalInfo %>" method="post" enctype="multipart/form-data">
					<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.ERROR_OLD_VEHICLE_YEAR %>" message="veh_age_old" />
					<liferay-ui:error exception="<%= YaqeenException.class %>" message="yaqeen-error" />
						<input type="hidden" name="<portlet:namespace/>myview" value="personal_info"/>
						<div class="tab-content">
							<div class="tab-pane fade <%=(!isBack ||(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)))?"in active":"" %>" role="tabpanel" id="tab-1">
								<%-- <div class="row">
									<div class="col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="type_cover"/></label>
											<div role="group" class="btn-group btn-group-justified"	data-toggle="buttons">
												<label class="btn btn-default  <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"active":"" %> control-label">
													<input type="radio" name="<portlet:namespace/>IstOptions" id="IstTplOptions" value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL %>" autocomplete="off"  <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"checked='true'":"" %>/><liferay-ui:message key="tpl_cover"/>
												</label>
												<label class="btn btn-default control-label  <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"active":"" %>">
													<input type="radio" name="<portlet:namespace/>IstOptions" id="IstCompOptions" value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE %>" autocomplete="off" <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"checked='true'":"" %>/><liferay-ui:message key="comprehensive"/>
												</label>
											</div>
										</div>
									</div>
								</div> --%>
								<div class="row">
									<div class="col-md-12 col-sm-6">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="main_driver"/></label>
											<label class="switch control-label">
												<input type="checkbox" tabindex="1" <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD) && !isMainDriver)?"":"checked='true'"%> name="<portlet:namespace/>IstMainDriver" id="IstMainDriver" value="true"/>
												<div></div>
												<span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
											</label>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message key="saudi_id_iqama"/></label>
											<input class="form-control" tabindex="2" name="<portlet:namespace/>IstIqamaId" <%=(isUserSignedIn)?"readonly":"" %> id="IstIqamaId" type="text" placeholder="XXXXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?quot.getInsuredId():(isUserSignedIn)?PortalUtil.getUser(request).getScreenName():""%>"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message key="veh_seq_no"/></label>
											<input class="form-control" tabindex="3"  name="<portlet:namespace/>IstVehSeqNo" id="IstVehSeqNo" type="text" placeholder="XXXXXXXXX" <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?("value='"+quot.getVehicleId()+"'"):"" %> data-toggle="popover" data-trigger="hover" data-html="true" data-placement="top" data-content="<img src='/o/atmc-theme/images/li.png' height='150px'/>"/>
											<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message key="dob_g"/></label>
											<input id="IstDobG"  tabindex="4"  name="<portlet:namespace/>IstDobG" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?(dateFormatter.format(quot.getInsuredDob())):""%>"/>
											<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message key="dob_h"/></label>
											<input id="IstDobH"  tabindex="5" name="<portlet:namespace/>IstDobH" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?quot.getInsuredDobH():""%>"/>
											<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="email"/></label>
											<input  tabindex="6"  name="<portlet:namespace/>IstEmail" id="IstEmail" class="form-control" type="text"	placeholder="Example@atmc.com.sa"  value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?quot.getInsuredEmail():""%>"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="mobile_no"/></label>
											<input  tabindex="7" name="<portlet:namespace/>IstMobileNo" id="IstMobileNo" class="form-control" type="text" placeholder="05XXXXXXXX"  value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?quot.getInsuredMobile():""%>"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-12">
										<div class="form-group">
											<label class="control-label"></label>
											<label class="text-primary checkbox-inline"><input  tabindex="8" name="<portlet:namespace/>IstAgreement" id="IstAgreement" type="checkbox" /><liferay-ui:message key="buy_policy_agreement" /></label>
										</div>
									</div>
								</div>
							</div>
							<div class="tab-pane fade <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?"in active":"" %>" role="tabpanel" id="tab-2">
								<%-- <div class="row">
									<div class="col-md-6 col-sm-12 col-xs-12">
										<div class="form-group">
											<label><liferay-ui:message key="type_cover"/></label>
											<div role="group" class="btn-group btn-group-justified"	data-toggle="buttons">
												<label class="btn btn-default <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"active focus":"" %>">
													<input type="radio"  tabindex="9" name="<portlet:namespace/>CustOptions" id="CustTplOptions"  value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL %>" autocomplete="off" <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"checked='true'":"" %>/><liferay-ui:message key="tpl_cover"/>
												</label>
												<label class="btn btn-default <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"active focus":"" %>">
													<input type="radio"	 tabindex="10" name="<portlet:namespace/>CustOptions" id="CustCompOptions" value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE %>" autocomplete="off" <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"checked='true'":"" %>/><liferay-ui:message key="comprehensive"/>
												</label>
											</div>
										</div>
									</div>
								</div> --%>
								<div class="row">
									<div class="col-md-12">
										<label><liferay-ui:message key="main_driver"/></label>
										<label class="switch">
											<input type="checkbox"  tabindex="11" name="<portlet:namespace/>CustMainDriver" id="custMainDriver" value="true" <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD) && !isMainDriver)?"":"checked='true'"%>/>
											<div></div>
											<span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
										</label>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="saudi_id_iqama"/></label>
											<input  tabindex="12" name="<portlet:namespace/>CustIqamaId" <%=(isUserSignedIn)?"readonly":"" %> id="CustIqamaId" class="form-control" type="text" placeholder="XXXXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?quot.getInsuredId():(isUserSignedIn)?PortalUtil.getUser(request).getScreenName():""%>"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-md-6">
										<div class="form-group has-feedback">
											<label class="control-label"><liferay-ui:message key="cust_card_no"/></label>
											<input  tabindex="13" name="<portlet:namespace/>CustCardNo" id="CustCardNo" class="form-control" type="text" placeholder="XXXXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?quot.getVehicleId():""%>"  data-toggle="popover" data-trigger="hover" data-html="true" data-placement="top" data-content="<img src='/o/atmc-theme/images/custom_id_card.jpg' height='150px'/>" data-original-title="" title=""/>
											<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
										</div>
									</div>
									<div class="col-md-6">
										<div class="form-group">
											<label class="control-label"><liferay-ui:message key="year_manufacurer"/></label>
											<select name="<portlet:namespace/>CustMfgYear" id="CustMfgYear" class="form-control"  tabindex="14">
												<option value="-1" selected><liferay-ui:message key="please_select_option"/></option>
<%
	Calendar cal = new GregorianCalendar();
	cal.setTime(new Date());
	cal.add(Calendar.YEAR, 2);
	for(int yCount=0; yCount<11; yCount++)
	{
		cal.add(Calendar.YEAR, -1);
		int year = cal.get(Calendar.YEAR);
		String selected = "";
		if(isBack && vIdType == Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))
		{
			if(year == quot.getVehicleMfgYear())
				selected="selected";
		}
%>
												<option value="<%=year%>" <%=selected %>><%=year %></option>
<%
	}
%>
										</select>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="dob_g"/></label>
										<input  tabindex="15" id="CustDobG" name="<portlet:namespace/>CustDobG" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?dateFormatter.format(quot.getInsuredDob()):""%>"/>
										<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="dob_h"/></label>
										<input  tabindex="16" id="CustDobH" name="<portlet:namespace/>CustDobH" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?quot.getInsuredDobH():""%>"/>
										<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="mobile_no"/></label>
										<input  tabindex="17" name="<portlet:namespace/>CustMobileNo" id="CustMobileNo" class="form-control" type="text" placeholder="05XXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?quot.getInsuredMobile():""%>"/>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="email"/></label>
										<input  tabindex="18" name="<portlet:namespace/>CustEmail" id="CustEmail" class="form-control" type="text" placeholder="Example@atmc.com.sa" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))?quot.getInsuredEmail():""%>"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label"></label>
										<label class="text-primary checkbox-inline"><input  tabindex="19" name="<portlet:namespace/>CustAgreement" id="CustAgreement" type="checkbox" /><liferay-ui:message key="buy_policy_agreement" /></label>
									</div>
								</div>
							</div>
						</div>
						<div class="tab-pane fade <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?"in active":"" %>" role="tabpanel" id="tab-3">
							<%-- <div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label><liferay-ui:message key="type_cover"/></label>
										<div role="group" class="btn-group btn-group-justified"	data-toggle="buttons">
											<label class="btn btn-default <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"active focus":"" %>">
												<input type="radio"  tabindex="20" name="<portlet:namespace/>TransOptions" id="TransTplOptions" value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL %>" autocomplete="off"   <%=(!isBack ||(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)))?"checked='true'":"" %>/><liferay-ui:message key="tpl_cover"/>
											</label>
											<label class="btn btn-default <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"active focus":"" %>">
												<input type="radio"	tabindex="21" name="<portlet:namespace/>TransOptions" id="TransCompOptions" value="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE %>" autocomplete="off" <%=(isBack && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"checked='true'":"" %>/><liferay-ui:message key="comprehensive"/>
											</label>
										</div>
									</div>
								</div>
							</div> --%>
							<div class="row">
								<div class="col-md-12">
									<label><liferay-ui:message key="new_owner_main_drv"/> </label>
									<label class="switch">
										<input tabindex="22" name="<portlet:namespace/>TransMainDriver" id="TransMainDriver" type="checkbox" <%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD) && !isMainDriver)?"":"checked='true'"%> value="true"/>
										<div></div>
										<span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
									</label>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="new_iqama_id"/></label>
										<input tabindex="23" name="<portlet:namespace/>newIqamaId" <%=(isUserSignedIn)?"readonly":"" %> id="TransNewIqamaId" class="form-control" type="text"	placeholder="XXXXXXXXXX"  value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getInsuredId():(isUserSignedIn)?PortalUtil.getUser(request).getScreenName():""%>" data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content='<%= LanguageUtil.get(request,"id_represent_id_iqama_cr") %>'/>
										<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="old_iqama_id"/></label>
										<input tabindex="24" name="<portlet:namespace/>oldIqamaId" id="TransOldIqamaId" class="form-control" type="text" placeholder="XXXXXXXXXX"  value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getOldIqamaId():""%>" data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content='<%= LanguageUtil.get(request,"id_represent_id_iqama_cr") %>'/>
										<span class="glyphicon form-control-feedback glyphicon-info-sign text-muted"></span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="dob_h"/></label>
										<input tabindex="25" id="TransDobH" name="<portlet:namespace/>TransDobH" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getInsuredDobH():""%>"/>
										<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-label"><liferay-ui:message key="dob_g"/></label>
										<input tabindex="26" id="TransDobG" name="<portlet:namespace/>TransDobG" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?(dateFormatter.format(quot.getInsuredDob())):""%>"/>
										<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="veh_seq_no"/></label>
										<input tabindex="27" name="<portlet:namespace/>TransVehSeqNo" id="TransVehSeqNo" class="form-control" type="text" placeholder="XXXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getVehicleId():""%>"/>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="email"/></label>
										<input tabindex="28" name="<portlet:namespace/>TransEmail" id="TransEmail" class="form-control" type="text"	placeholder="Example@atmc.com.sa" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getInsuredEmail():""%>"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="mobile_no"/></label>
										<input tabindex="29" name="<portlet:namespace/>TransMobileNo" Id="TransMobileNo" class="form-control" type="text" placeholder="05XXXXXXXX" value="<%=(isBack && vIdType==Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))?quot.getInsuredMobile():""%>"/>
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group has-feedback">
										<label class="control-label">
											<liferay-ui:message key="lease_cert_ownership"/>
										</label> 
										<input tabindex="30" readonly id="<portlet:namespace/>selectedLeaseFile" name="<portlet:namespace/>selectedLeaseFile" class="form-control" onclick="$('#<portlet:namespace/>selectedLeaseFile').val('');$('#<portlet:namespace/>leaseFile').click();" value="<%=(isBack && quot.getLeaseFileName()!=null)?quot.getLeaseFileName():""%>" placeholder='<liferay-ui:message key="sel_file_loc" />'  value="<%=(isBack && quot.getLeaseFileName()!=null)?quot.getLeaseFileName():""%>"/> 
										<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
										<input type="file" name="<portlet:namespace/>leaseFile" id="<portlet:namespace/>leaseFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedLeaseFile').val(this.files.item(0).name);"/>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-12">
									<div class="form-group">
										<label class="control-label"></label>
										<label class="text-primary checkbox-inline"><input tabindex="31"  name="<portlet:namespace/>TransAgreement" id="TransAgreement" type="checkbox" /><liferay-ui:message key="buy_policy_agreement" /></label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<liferay-captcha:captcha url="<%=captchaURL%>" />
				</aui:form>
				</div>
			</div>
<%
	String homePageUrl = (isUserSignedIn)?"/group/customer/dashboard":"/web/customer/motor-insurance_individual";
%>			
			<div class="col-sm-12 col-xs-12 col-md-offset-1 col-md-10 col-lg-8 col-lg-offset-2 text-right no-pad">
				<ul class="list-btns">
					<li>
						<button class="btn btn-lg btn-xs-block btn-link text-muted" tabindex="32" 	role="button" onclick="window.location='<%=homePageUrl%>'"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/> </button>
					<li>
						<button id="proceedBtn" class="btn btn-primary btn-lg btn-xs-block" tabindex="33"  type="button" onclick="validateAndSubmit();"><liferay-ui:message key="proceed"/></button>
					</li>
				</ul>
			</div>
			</div>
		</div>
	</div>
</div>
<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div class="<%=(!nonExpiredPolicyExistsError)?"text-center":"" %>">
<%
	if(nonExpiredPolicyExistsError)
	{
%>	
		<p style="overflow-wrap:break-word;"><%=nonExpiredPolicyExistsMessage %></p>
<%
	}
	else
	{
%>		<h4 style="overflow-wrap:break-word;"><%=(yaqeenError)?yaqeenMessage:(genericError)?genericMessage:maxQuoteMessage %></h4>
<%
	}
%>
	</div>
<%
	if(nonExpiredPolicyExistsError)
	{
%>	
	<br/>
	<div class="row text-left">
        <div class="col-md-12">
        	<button class="btn btn-primary btn-lg btn-xs-block" type="button" onclick="$('.close').click().click();"><liferay-ui:message key="close"/></button>
        </div>
    </div>
<%
	}
%>	
</div>
<liferay-portlet:renderURL portletName="<%=LoginPortletKeys.LOGIN%>" var="loginPortletURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="<%=userRegistered?"/login/login":"/login/register" %>" />
	<liferay-portlet:param name="buyMotorMsg" value="<%=(userRegistered)?"ren_policy_exists_login":"ren_policy_exists_reg" %>" />
</liferay-portlet:renderURL>
<form name="validateOtpForm" method="post" id="validateOtpForm" target="<portlet:namespace />dialog">
	<input type="hidden" name="<%=OtpPortletKeys.MOBILE_NUMBER%>" id="<%=OtpPortletKeys.MOBILE_NUMBER%>"/>
</form>

<script>
$(function () {
	$('[data-toggle="popover"]').popover()
});
</script>
<aui:script>
var yaqeenError = <%=yaqeenError%>;
var maxQuoteError = <%=maxQuoteError%>;
var genericError = <%=genericError%>;
var nonExpiredPolicyExistsError = <%=nonExpiredPolicyExistsError%>;
if(yaqeenError || maxQuoteError || genericError || nonExpiredPolicyExistsError)
{
	if(<%=isMainDriver%>)
		$("#IstMainDriver").attr("checked", true);
	else
		$("#IstMainDriver").attr("checked", false);	
	AUI().use('aui-modal', function(A) {		
		var dialog = new A.Modal({
			title: (yaqeenError)?"YAQEEN Error":"Quote Limit Error",
			bodyContent: $('#aui_popup_body').html(),
			headerContent: '<h4 class="no-margin text-primary">'+((yaqeenError)?'<liferay-ui:message key="error_msg"/>':(genericError)?'Generic Error':(nonExpiredPolicyExistsError)?'Already Insured':'Quote Limit Error')+'</h4>',
			centered: true,
			modal: true,
			height: 200,
			render: '#aui_popup_content'
		});
		dialog.render();
	});
}
else if(!<%=isUserSignedIn%>)
{
	if(<%=renewablePolicyExistsError%>)
	{

		Liferay.Util.openWindow({
			cache: false,
			dialog: {
				destroyOnHide: true,
				cssClass: 'atmc-popup',
				align: Liferay.Util.Window.ALIGN_CENTER,
				modal:true,
				resizable: false,
				width: 845,
				height: 421
			},
			dialogIframe: {
				id: '<portlet:namespace />dialog',
				uri: '<%=loginPortletURL.toString()%>'
			},
			uri: '<%=loginPortletURL.toString()%>'
		});
	}
}
var isBack=<%=isBack%>;
var vType = <%=vIdType%>;
if(isBack)
{
	var vType = <%=vIdType%>;
	enableCals(vType);
}
else	
  	enableCals(1);
var frmValidator;
var inputTemplate = "<input type='hidden' name='' value=''/>";
var vehType = (isBack)?vType:1;
var rules;
var fieldStrings;
function enableCals(type)
{
	
	var DobH;
	var DobG;
	vehType = type;

	if(type == 3)	
	{
		DobH = $("#TransDobH");
		DobG = $("#TransDobG");
		rules = {
		    <portlet:namespace/>selectedLeaseFile: {
		    	required: true,
		    	uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG, DOC, DOCX',
		        checkFilename:true
		    },
			<portlet:namespace/>newIqamaId: {
	            required: true, 
	            rangeLength: [10,10],
	            min:1,
	            number: true,
	            checkSum: true
		    },
	        <portlet:namespace/>oldIqamaId: {
	            required: true,
	            rangeLength: [10,10],
	            min:1,
	            number: true,
	            checkSum: true
	        },
	        <portlet:namespace/>TransVehSeqNo: {
	            required: true,
	            rangeLength: [6,10],
	            min:1,
	            number: true
		    },
		    <portlet:namespace/>TransDobH: {
	            required: true
		    },
		    <portlet:namespace/>TransDobG: {
	            required: true
		    },
	        <portlet:namespace/>TransMobileNo: {
	            required: true,
	            rangeLength: [10,10],
	            number: true,
	            ksaMobile: true
		    },
		    <portlet:namespace/>TransEmail: {
	            required: true,
	            email: true,
	            estEmail:true
		    },
		    <portlet:namespace/>TransAgreement: {
	            required: true
		    }
		}
		
		fieldStrings = {
		    <portlet:namespace/>TransMobileNo: {
				rangeLength: '<liferay-ui:message key="mob_no_length"/>',
				ksaMobile: '<liferay-ui:message key="mob_no_start"/>'
		    },
		    <portlet:namespace/>newIqamaId: {
				rangeLength: '<liferay-ui:message key="enter_valid_num"/>',
				min: '<liferay-ui:message key="enter_valid_num"/>'
		    },
		    <portlet:namespace/>TransEmail: {
		    	 estEmail: '<liferay-ui:message key="enter_a_valid_email"/>'
		    },
		    <portlet:namespace/>oldIqamaId: {
				rangeLength: '<liferay-ui:message key="enter_valid_num"/>',
				min: '<liferay-ui:message key="enter_valid_num"/>'
		    },
		    <portlet:namespace/>TransVehSeqNo: {min:'<liferay-ui:message key="enter_valid_num"/>'}
		}
	}
	else if(type == 1)	
	{
		DobH = $("#IstDobH");
		DobG = $("#IstDobG");
		rules = {
			<portlet:namespace/>IstIqamaId: {
	            required: true,
	            rangeLength: [10,10],
	            min:1,
	            number: true,
	            checkSum: true
		    },
	        <portlet:namespace/>IstVehSeqNo: {
	            required: true,
	            rangeLength: [6,10],
	            min:1,
	            number: true
		    },
		    <portlet:namespace/>IstDobH: {
	            required: true
		    },
		    <portlet:namespace/>IstDobG: {
	            required: true
		    },
		    <portlet:namespace/>IstMobileNo: {
	            required: true,
	            rangeLength: [10,10],
	            number: true,
	            ksaMobile: true
		    },
		    <portlet:namespace/>IstEmail: {
	            required: true,
	            email: true,
	            estEmail:true
		    },
		    <portlet:namespace/>IstAgreement: {
	            required: true
		    }
		}
		
		fieldStrings = {
			<portlet:namespace/>IstMobileNo: {
				rangeLength: '<liferay-ui:message key="mob_no_length"/>',
				ksaMobile: '<liferay-ui:message key="mob_no_start"/>'
		    },
		    <portlet:namespace/>IstIqamaId: {
				rangeLength: '<liferay-ui:message key="enter_a_valid_number"/>',
				min: '<liferay-ui:message key="enter_a_valid_number"/>'
		    },
		    <portlet:namespace/>IstEmail: {
		    	 estEmail: '<liferay-ui:message key="enter_a_valid_email"/>'
		    },
		    <portlet:namespace/>IstVehSeqNo: {min:'<liferay-ui:message key="enter_valid_num"/>'}
		}
	}
	else if(type == 2)	
	{
		DobH = $("#CustDobH");
		DobG = $("#CustDobG");
		rules = {
			<portlet:namespace/>CustIqamaId: {
	            required: true,
	            rangeLength: [10,10],
	            min:1,
	            number: true,
	            checkSum: true
		    },
	        <portlet:namespace/>CustCardNo: {
	            required: true,
	            rangeLength: [6,10],
	            min:1,
	            number: true
		    },
		    <portlet:namespace/>CustDobH: {
	            required: true
		    },
		    <portlet:namespace/>CustDobG: {
	            required: true
		    },
	        <portlet:namespace/>CustMobileNo: {
	            required: true,
	            rangeLength: [10,10],
	            number: true,
	            ksaMobile: true
		    },
		    <portlet:namespace/>CustEmail: {
	            required: true,
	            email: true,
	            estEmail:true
		    },
		    <portlet:namespace/>CustMfgYear: {
	            custDropDown: true
		    },
		    <portlet:namespace/>CustAgreement: {
	            required: true
		    }
		}
		fieldStrings = {
		    <portlet:namespace/>CustMobileNo: {
				rangeLength: '<liferay-ui:message key="mob_no_length"/>',
				ksaMobile: '<liferay-ui:message key="mob_no_length"/>'
		    },
		    <portlet:namespace/>CustIqamaId: {
				rangeLength: '<liferay-ui:message key="enter_valid_num"/>',
				min: '<liferay-ui:message key="enter_valid_num"/>'
		    },
		    <portlet:namespace/>CustEmail: {
		    	estEmail: '<liferay-ui:message key="enter_a_valid_email"/>'
		    },
		    <portlet:namespace/>CustCardNo: {min:'<liferay-ui:message key="enter_valid_num"/>'}
		}
	}
	console.log(rules);

	$(DobH).calendarsPicker({
		calendar: $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ?"": ",'ar'" %>),
		dateFormat: 'yyyy-mm-dd',
		maxDate: 0,
		yearRange: '-100:1439',
		<%= currLocale.equals("en_US") ?"": "isRTL: true," %>
		onClose: function(dates){
			var zDate = $(DobH).val().split("-"); 
			if($(DobH).val() != "")
			{
				var jd = $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ?"": ",'ar'" %>).newDate(parseInt(zDate[0]), parseInt(zDate[1]), parseInt(zDate[2])).toJD();
				var convertedDate = $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar'" %>).fromJD(jd); 
				$(DobG).calendarsPicker('setDate', convertedDate);
			}
			else
			{
				$(DobG).val("");
			}	
			if($("#IstEmail").is(':visible'))		{	$("#IstEmail").click(); 	$("#IstEmail").focus();	}
			if($("#CustMobileNo").is(':visible'))	{	$("#CustMobileNo").click();	$("#CustMobileNo").focus();	}
			if($("#TransVehSeqNo").is(':visible'))	{	$("#TransVehSeqNo").click();$("#TransVehSeqNo").focus();	}	
		}
	});

	$(DobG).calendarsPicker({
		calendar: $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>),
		dateFormat: 'yyyy-mm-dd',
		maxDate: 0,
		yearRange: '-100:2018',
		<%= currLocale.equals("en_US") ? "":"isRTL: true," %>
		onClose: function(dates){
			var zDate = $(DobG).val().split("-"); 
			if($(DobG).val() != "")
			{
				var jd = $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>).newDate(parseInt(zDate[0]), parseInt(zDate[1]), parseInt(zDate[2])).toJD();
				var convertedDate = $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ? "":",'ar'" %>).fromJD(jd); 
				$(DobH).calendarsPicker('setDate', convertedDate);
			}
			else
			{
				$(DobH).val("");
			}
			if($("#IstEmail").is(':visible'))		{	$("#IstEmail").click(); 	$("#IstEmail").focus();	}
			if($("#CustMobileNo").is(':visible'))	{	$("#CustMobileNo").click();	$("#CustMobileNo").focus();	}
			if($("#TransVehSeqNo").is(':visible'))	{	$("#TransVehSeqNo").click();$("#TransVehSeqNo").focus();	}	
		}
	});
			}
function validateAndSubmit()
{
	if (frmValidator)
		frmValidator.resetAllFields();
	$("#<portlet:namespace/>form1 .form-validator-stack").remove();
	$("#<portlet:namespace/>form1 .error-field").removeClass("error-field");
	$("#<portlet:namespace/>form1 .has-error").removeClass("has-error");
	$("#<portlet:namespace/>form1 input").removeAttr("aria-invalid");
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
				checkFilename:function(val,node,junction){
					return validateFileName(node._node.name);
				},
				ksaMobile:function(val, fieldNode, ruleValue){
					var allowedCharacters = '05';
					var regex = new RegExp('(^05)([0-9]{8})');
					return regex.test(val);
				},
				estEmail:function(val, fieldNode, ruleValue){
					var regex = new RegExp('^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+\.[a-zA-Z0-9-.]');
					return regex.test(val);
				},
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
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
				uploadFileSize:'<liferay-ui:message key="max_upload_size"/>',
				ksaMobile:'<liferay-ui:message key="mob_no_start"/>',
				custDropDown:'<liferay-ui:message key="plz_select_value"/>',
				checkSum:'<liferay-ui:message key="enter_valid_id"/>',
	            checkFilename:"Enter a Valid File Name"
			},
		    true
		);
		
		if(vehType == 3 && !($("#TransNewIqamaId").val().startsWith("1") || $("#TransNewIqamaId").val().startsWith("2")))
			rules.<portlet:namespace/>newIqamaId = 
			{
				required: true, 
	            min:1,
	            number: true
	        };
		else if(vehType == 3 && ($("#TransNewIqamaId").val().startsWith("1") || $("#TransNewIqamaId").val().startsWith("2")))
			rules.<portlet:namespace/>newIqamaId = 
			{
				required: true,
				rangeLength: [10,10],
	            min:1,
	            number: true
	        };
		//console.log("form Validator")
		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>form1',
		    rules: rules,
			fieldStrings: fieldStrings,
			validateOnBlur: false
		});
	});

	//frmValidator.resetAllFields();
	if($("#IstEmail").is(':visible'))
		$("#IstEmail").val($("#IstEmail").val().trim());
	if($("#CustEmail").is(':visible'))
		$("#CustEmail").val($("#CustEmail").val().trim());
	if($("#TransEmail").is(':visible'))
		$("#TransEmail").val($("#TransEmail").val().trim());
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
    	$(inputTemplate).attr('name','<portlet:namespace/>vehType').val(vehType).appendTo('#<portlet:namespace/>form1');
    	//$("#form1").submit();
    	if(!<%=isUserSignedIn%>)
    	{
    		var mobNo = (vehType == 1)?($("#IstMobileNo").val()):(vehType == 2)?($("#CustMobileNo").val()):($("#TransMobileNo").val()); 
    		console.log(mobNo);


<%-- 		var actionURL = Liferay.PortletURL.createActionURL();
			actionURL.setWindowState("<%= LiferayWindowState.POP_UP.toString() %>");
			actionURL.setName("/auth/otp");
			actionURL.setPortletId("<%=OtpPortletKeys.OTP%>");
			actionURL.setParameter("mvcRenderCommandName","/auth/otp");
			actionURL.setParameter("<%=OtpPortletKeys.CMD%>","<%=OtpPortletKeys.CMD_SEND%>");
			actionURL.setParameter("<%=OtpPortletKeys.REDIRECT_JS_METHOD%>","doSubmition"); --%>
		
			<!-- Refer to https://help.liferay.com/hc/en-us/articles/360029005812-Working-with-URLs-in-JavaScript#liferay-util-portleturl -->
			<liferay-portlet:actionURL portletName="<%=OtpPortletKeys.OTP%>" name="/auth/otp" var="otpPortletURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
				<liferay-portlet:param name="mvcRenderCommandName" value="/auth/otp" />
				<liferay-portlet:param name="<%=OtpPortletKeys.CMD%>" value="<%=OtpPortletKeys.CMD_SEND %>" />
				<liferay-portlet:param name="<%= OtpPortletKeys.REDIRECT_JS_METHOD %>" value="doSubmition" />
			</liferay-portlet:actionURL>
			<%
				PortletURL portletURL = PortletURLFactoryUtil.create(request, OtpPortletKeys.OTP, layout, PortletRequest.ACTION_PHASE);
				portletURL.setWindowState(LiferayWindowState.POP_UP);
				portletURL.setParameter("mvcRenderCommandName", "/auth/otp");
				portletURL.setParameter(ActionRequest.ACTION_NAME, "/auth/otp");
				portletURL.setParameter(OtpPortletKeys.CMD, OtpPortletKeys.CMD_SEND);
				portletURL.setParameter(OtpPortletKeys.REDIRECT_JS_METHOD, "doSubmition");
			%>
			var actionURL = Liferay.Util.PortletURL.createActionURL(
								Liferay.currentURL,
								{
	    							'p_p_id': "ATMCOTP",
	    							"mvcRenderCommandName":"/auth/otp",
	    							"<%=OtpPortletKeys.CMD%>":"<%=OtpPortletKeys.CMD_SEND%>",
	    							"<%=OtpPortletKeys.REDIRECT_JS_METHOD%>":"doSubmition"
	  							});
			
			actionURL = "<%= portletURL.toString() %>";
	    	Liferay.Util.openWindow({
				cache: false,
				dialog: {
					destroyOnHide: true,
					cssClass: 'atmc-otp-sm',
					headerContent: '<liferay-ui:message key="otp_sent_prov_mob"/>',
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal:true,
					resizable: false,
					width: 500,
					height: 200,
					after: {
						render: function(evt) {
							$(".modal-body").append("<iframe class='dialog-iframe-node' frameborder='0' id='<portlet:namespace />dialog' name='<portlet:namespace />dialog'/>");
							$.when( $("#<portlet:namespace />dialog").length == 1).then(function(){
								$('#validateOtpForm').attr('action',actionURL.toString());
								$('#validateOtpForm #<%=OtpPortletKeys.MOBILE_NUMBER%>').val(mobNo);
								$('#validateOtpForm').submit();
								$(".modal-body").addClass("dialog-iframe-bd");
								$(".modal-body").css("padding","0px");
							});
						}
					}

				},
				dialogIframe: {
					id: '<portlet:namespace />dialog',
				},
				title: 'OTPPortlet',
				uri: ''
			});
    	}
    	else
    		doSubmition();
    }
}
function validateFileName(objId){
	var fileObjId = $("#"+objId).closest(".form-group").find("input[type='file']").attr("id");
	var fileInput = document.getElementById(fileObjId);
	var fileName = "";
	if(fileInput.files.length>0)
		fileName = fileInput.files.item(0).name;
	var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
	return regex.test(fileName);
}
function validateUploadSize(objId, maxSize)
{
	
	var uploadSize=true;
	var fileObjId = $("#"+objId).closest(".form-group").find("input[type='file']").attr("id");
	var fileInput = document.getElementById(fileObjId);
	//console.log(fileObjId);
	//console.log(fileInput);
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
function doSubmition(){
	 var A = AUI();
	 var loadingMask = new A.LoadingMask({
	 	'strings.loading' : 'This is my custom loading message',
	 	target : A.getBody()
	 });
	 loadingMask.show();
	$("#<portlet:namespace/>form1").submit();
}

</aui:script>