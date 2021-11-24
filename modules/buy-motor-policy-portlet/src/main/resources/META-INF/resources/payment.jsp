<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationCover"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.Quotation"%>
<%@ include file="/init.jsp"%>
<script>
        window.__define = window.define;
        window.__require = window.require;
        window.define = undefined;
        window.require = undefined;
    </script>
<script type="text/javascript" src="/o/atmc-theme/vendor/sha/sha256.js"></script>
<script>
        window.define = window.__define;
        window.require = window.__require;
        window.__define = undefined;
        window.__require = undefined;
    </script>
<%
	String tokenizationUrl = PropsUtil.get("com.ejada.atmc.payfort.tokenization.url");
	List cities = (List)request.getAttribute("cities");
	String pFail = (request.getAttribute("paymentFail")!=null)?(String)request.getAttribute("paymentFail"):(request.getParameter("paymentFail")!=null)?request.getParameter("paymentFail"):null;
	boolean paymentFail = Boolean.valueOf(pFail).booleanValue();
	String paymentErrorCode = null;
	String paymentErrorMsg = null;
	boolean mobileSessionError = false;
	
	Log _log = LogFactoryUtil.getLog(this.getClass());

	if(paymentFail)
	{
		paymentErrorCode = (String)request.getAttribute("purchaseErrorCode");
		paymentErrorMsg = (String)request.getAttribute("purchaseErrorMsg");
	}
	String buyPortletId = (String)request.getAttribute(WebKeys.PORTLET_ID);
	PortletURL portletReturnUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.ACTION_PHASE);
	portletReturnUrl.setWindowState(WindowState.NORMAL);
	portletReturnUrl.setPortletMode(PortletMode.VIEW);
	portletReturnUrl.setParameter(ActionRequest.ACTION_NAME, "tokenizationResult");

	Quotation quot = (Quotation)request.getAttribute("quot");
	
	if(request.getAttribute("MOBILE_SESSION_ERROR")!=null)
		mobileSessionError = (boolean)request.getAttribute("MOBILE_SESSION_ERROR");
	
	_log.info("mobileSessionError:" + mobileSessionError);
	
	boolean payPolicy = (request.getAttribute("payPolicy")!=null)?((Boolean)request.getAttribute("payPolicy")):false;
	Gson gson = new Gson();
	String quotDets = gson.toJson(quot);
	_log.info("  ----------------------  Quotation Details  ------------------- ");
	_log.info(quotDets);
	_log.info(" -------------------------- End Quotation Details ---------------------- ");
	quotDets = quotDets.replaceAll("\"", "'");
	quotDets = quotDets.replaceAll("\\r\\n", "");
	_log.info("  ----------------------  Quotation Details After Fix  ------------------- ");
	_log.info(quotDets);
	_log.info(" -------------------------- End Quotation Details After Fix---------------------- ");
	
	PortletURL downloadQuotUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadQuotUrl.setParameter("quotId", ""+quot.getQuotationId());
	String downloadUrlVal = downloadQuotUrl.toString(); 
	if(downloadUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		downloadUrlVal = downloadUrlVal.substring(0, downloadUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	_log.info("------------------ Quotation Download URL = " + downloadUrlVal+" ----------------------");
	
	PortletURL resourceURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	resourceURL.setParameter("resourceType", "saveAddress");
	String resourceURLVal = resourceURL.toString(); 
	if(resourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
		resourceURLVal = resourceURLVal.substring(0, resourceURLVal.lastIndexOf("&p_p_lifecycle=1"));
	
	PortletURL quickQuoteURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	quickQuoteURL.setParameter("resourceType", "quickQuote");
	String quickQuoteURLVal = quickQuoteURL.toString(); 
	if(quickQuoteURLVal.indexOf("&p_p_lifecycle=1") != -1)
		quickQuoteURLVal = quickQuoteURLVal.substring(0, quickQuoteURLVal.lastIndexOf("&p_p_lifecycle=1"));
	
	
	String requestPhrase = PropsUtil.get("com.ejada.atmc.payfort.sha.requestPhrase");
	String merchantIdentifier = PropsUtil.get("com.ejada.atmc.payfort.merchantIdentifier");
	String accessCode = PropsUtil.get("com.ejada.atmc.payfort.accessCode");
	
	_log.info("Payfort Config:" + requestPhrase + "-" + merchantIdentifier + "-" + accessCode);
%>
<portlet:actionURL name="results" var="results">
	<portlet:param name="myview" value="results" />
</portlet:actionURL>

<portlet:actionURL name="personalInfo" var="personalInfo">
	<portlet:param name="myview" value="personal_info" />
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>
<form id="personalInfoBackForm" name="personalInfoBackForm" role="form" action="<%=personalInfo %>" method="post">
	<input type="hidden" name="<portlet:namespace/>quot" id="<portlet:namespace/>quot" value="<%=quotDets %>"/>
</form>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<aui:form id="quotForm" name="quotForm" role="form" action="<%=results+"&mobileView=true"%>" method="post">
			<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
			<input type="hidden" name="<portlet:namespace/>pmntType" value="" />
			<input type="hidden" name="<portlet:namespace/>mobileView" value="true" />
			<input type="hidden" name="<portlet:namespace/>totalAmount" value="" />
			<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL %>" message="Payment Error" />
			<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL %>" message='<%= LanguageUtil.get(request,"policy_issuance_error") %>' />
			<div class="row">
				<div class="col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 col-sm-12 col-xs-12 portlet-content text-center">
					<ul class="nav nav-tabs" style="width:100%">
						<li class="active" style="display:table-cell;width:1%;float:none;">
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
							</a>
						</li>
						<li style="display:table-cell;width:1%;float:none;">
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
							</a>
						</li>
						<li style="display:table-cell;width:1%;float:none;">
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
					<ul class="list-group no-margin"> 
						<li class="list-group-item bg-gray">
							<div class="row vcenter">
								<div class="col-md-8">
									<liferay-ui:message key="ins_nat_addr"/>
								</div>
								<div class="col-md-4">
									<div class="btn btn-default btn-outline pull-right" onclick="window.open('https://address.gov.sa/en/e-services/register-your-address')">
										<liferay-ui:message key="reg_addr"/>
									</div>
								</div>
							</div>
						</li>	
						<li class="list-group-item">
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="building_no"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressBuildingNo()!=0)?quot.getAddressBuildingNo():"" %>" <%=(isUserSignedIn)?"disabled":"" %>  name="<portlet:namespace/>buildingNo" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="street_name"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressStreet()!=null)?quot.getAddressStreet():"" %>" <%=(isUserSignedIn)?"disabled":"" %> name="<portlet:namespace/>streetName" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="district"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressDistrict()!=null)?quot.getAddressDistrict():"" %>" <%=(isUserSignedIn)?"disabled":"" %> name="<portlet:namespace/>district" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="city"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getCityDesc()!=null)?quot.getCityDesc():"" %>" <%=(isUserSignedIn)?"disabled":"" %>  name="<portlet:namespace/>city" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="zip_code"/></label>
										<input class="form-control" type="text" placeholder=""  value="<%=(quot.getAddressZipCode()!=0)?quot.getAddressZipCode():"" %>" name="<portlet:namespace/>zipCode" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="add_info"/></label>
										<input class="form-control" type="text" placeholder="Select"  name="<portlet:namespace/>addInfo" />
									</div>
								</div>
							</div>
						</li>
					</ul>
					<br/>
					<ul class="list-group no-margin">
						<li class="list-group-item bg-gray"><liferay-ui:message key="off_nat_addr"/></li>					 
						<li class="list-group-item">
							<div class="form-group">
								<label class="control-label text-primary"><liferay-ui:message key="nat_addr_off"/></label>
								<label class="switch control-label">
									<input type="checkbox" id="OffAddress"/>
									<div></div>
									<span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
								</label>
							</div>
							<div class="officeAddDiv" style="display:none;">
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="building_no"/></label>
											<input class="form-control" type="text" placeholder="" id="<portlet:namespace />offBuildNo" name="<portlet:namespace />offBuildNo"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="street_name"/></label>
											<input class="form-control" type="text" placeholder="" id="<portlet:namespace />offStName" name="<portlet:namespace />offStName"/>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="district"/></label>
											<input class="form-control" type="text" placeholder="" id="<portlet:namespace />offDistrict" name="<portlet:namespace />offDistrict"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="city"/></label>
											<select class="form-control" name="<portlet:namespace/>offCity" id="<portlet:namespace/>offCity">
												<option value="-1"><liferay-ui:message key="please_select_option"/></option>
<%
	for(int cityCount=0; cities!=null && cityCount<cities.size();cityCount++)
	{
		CodeMasterDetails city = (CodeMasterDetails)cities.get(cityCount);
%>										
												<option value="<%=city.getCodeSub() %>" ><%=(currLocale.equals("en_US") )?city.getCodeDesc():city.getCodeDescAr() %></option>
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
											<label class="control-control control-label"><liferay-ui:message key="zip_code"/></label>
											<input class="form-control" type="text" placeholder="" id="<portlet:namespace />offZipCode" name="<portlet:namespace />offZipCode"/>
										</div>
									</div>
									<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
										<div class="form-group">
											<label class="control-control control-label"><liferay-ui:message key="add_no"/></label>
											<input class="form-control" type="text" placeholder='<%= LanguageUtil.get(request,"optional") %>' id="<portlet:namespace />offAddNo" name="<portlet:namespace />offAddNo"/>
										</div>
									</div>
								</div>
							</div>
						</li>
					</ul>
					<br/>
				</div>
			</div>
		</aui:form>
	</div>
</div>

<div class="row vcenter bg-white">
	<div class="col-md-8 text-right no-pad">
		<ul class="list-btns">
			<li>
				<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn" onclick="validateQuoteFormAndSubmit();">Pay <%=numberFormat.format(quot.getGrossPrem()) %></button>
			</li>
		</ul>
	</div>
</div>


<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div class="text-center">
		 <liferay-ui:message key="quote_saved_no"/> <span class="text-primary"> <%=quot.getReferenceNo() %></span> <liferay-ui:message key="quote_valid_day"/>
		 <br/>
		 <small class="text-muted"><liferay-ui:message key="quote_navigation"/></small>
	</div>
</div>
<div id="cover_type" style="display:none;">
	<div class="row">
<%
	Calendar nextDayCal = new GregorianCalendar();
	nextDayCal.setTime(new Date());
	nextDayCal.add(Calendar.DAY_OF_YEAR, 1);
	Date nextDayDate = nextDayCal.getTime();
	// if tomorrow's date is equat to the renewal policy effective date, then this policy expiry date was due, and policy was already expired.
	boolean productChanged = (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL) || (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) && quot.getPolicyEffDate()== nextDayDate))?true:false;
%>	
        <div class="col-md-12" style="padding-left:15px;padding-right:15px;">
	        <div class="coverage_container clearfix" style="position: relative;">
				<div class="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"coverage_tpl":"coverage_comp" %>">
				<span class="icon <%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"icon-car-insurance":"icon-transport" %> md-48 text-primary"></span>	
			    <h4><liferay-ui:message key="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"comprehensive_coverage":"third_party_cover" %>"/></h4>
					<br>
					<p><liferay-ui:message key="starting_from"/></p>
					<h2><small><liferay-ui:message key="sar"/> <%=numberFormat.format(quot.getNetPrem()) %></small></h2>
					<div class="btn btn-lg btn-default btn-outline" onclick="editOptionsSubmit(false);"><liferay-ui:message key="current_cover"/></div>
				</div>
				<div class="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"coverage_comp":"coverage_tpl" %>">
				<span class="best-value"><liferay-ui:message key="best_value"/></span>
				<span class="icon <%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"icon-transport":"icon-car-insurance" %> md-48 text-primary"></span>	
			    <h4><liferay-ui:message key="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"third_party_cover":"comprehensive_coverage" %>"/></h4>
					<br>
					<p><liferay-ui:message key="starting_from"/></p>
					<h2><small id="otherCoverage"><liferay-ui:message key="sar"/> 0</small></h2>
					<div class="btn btn-lg btn-primary" onclick="editOptionsSubmit(<%=productChanged%>);"><liferay-ui:message key="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"downgrade":"upgrade" %>"/></div>
				</div>
			</div>
        </div>
    </div>
</div>
<div id="payment_issue" style="display:none;">
	<div class="row">
        <div class="col-md-12">
        	<%=(paymentErrorMsg!=null)?(paymentErrorMsg+" ("+paymentErrorCode+")"):"" %>
        	<br/><br/>
        	<liferay-ui:message key="pmnt_prob_persist"/>
        </div>
    </div>
</div>
<form name="pmntForm" id="pmntForm" action="<%=tokenizationUrl %>" method="post">
	<input type="hidden" name="return_url" id="return_url" value="<%=portletReturnUrl.toString()%>">
	<input type="hidden" name="service_command" id="service_command" value="TOKENIZATION">
	<input type="hidden" name="access_code" id="access_code" value="<%=accessCode%>">
	<input type="hidden" name="merchant_identifier" id="merchant_identifier" value="<%=merchantIdentifier %>">
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
<script>
window.parent.postMessage({
    'msgType': 'pmntPage',
    'pageLoaded': 'true',
    'mobileSessionError':'<%=mobileSessionError%>'
}, "*");

$(function() {
	$('#OffAddress').change(function () {
		$('.officeAddDiv').toggle();
	});
	
});

function agreeTerms(){
	if($('#termsAndCons').is(":checked")){
		$('#submitBtn').removeAttr('disabled');
	}
	else{
		$('#submitBtn').attr('disabled','true');
	}
}
</script>
<aui:script>
	var paymentFail = <%=paymentFail%>;
	var payPolicy = <%=payPolicy%>;
	var requestPhrase = '<%=requestPhrase%>';
	console.log("Request Phrase:" + requestPhrase);
	
	if(paymentFail && <%=paymentErrorCode!=null%> && <%=paymentErrorMsg!=null%>)
	{
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				cssClass: "compose-dialog",
				bodyContent: $('#payment_issue').html(),
				headerContent: '<h4 class="no-margin text-primary">Issue with Payment</h4>',
				centered: true,
				modal: true,
				height: 230,
				render: '#aui_popup_content',
				close: true
			});
			dialog.addToolbar(
		      [
		        {
		          label: '<liferay-ui:message key="close"/>',
		          cssClass: 'btn-primary',
		          on: {
		            click: function() {
		            	dialog.hide();
		            }
		          }
		        }
		      ]
		    );

		});
		
	}
	var rules = {};
	if(!<%=isUserSignedIn%>)
	{
		rules.<portlet:namespace/>buildingNo = 
		{
            required: true
	    }
		rules.<portlet:namespace/>buildingNo = 
		{
            required: true
	    }
		rules.<portlet:namespace/>streetName = 
		{
            required: true
	    }
		rules.<portlet:namespace/>district = 
		{
            required: true
	    }
		rules.<portlet:namespace/>city = 
		{
            required: true
	    }
		rules.<portlet:namespace/>zipCode = 
		{
            required: true
	    }
	}
	
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
					}
				},
			    true
			);
			
			A.mix(A.config.FormValidator.STRINGS,
			    {
					onlyEngLetters:'<liferay-ui:message key="only_en_letters"/>',
					custOlpId:'Please enter valid ID'
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
				required: true
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
			rules.<portlet:namespace/>masterExpYear =
			{
				required: true
			}
			rules.<portlet:namespace/>masterVerfCode =
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
		if (frmValidator)
			frmValidator.resetAllFields();

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
	            required: true, 
	            number: true,
	            min:1,
	            maxLength: 4
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
			
		}
		AUI().use('aui-form-validator', function(B) {
			frmValidator = new B.FormValidator({
			    boundingBox: '#<portlet:namespace/>quotForm',
			    rules:rules
			});
	
		});
	
		frmValidator.validate();

		if(!frmValidator.hasErrors())
		{
			window.parent.postMessage({
			    'msgType': 'submitPmntPage'
			}, "*");
			if($(".officeAddDiv").is(":visible") || !<%=isUserSignedIn%>)
				saveAddressFields(pmntTypeVal);
			else
				doPayment(pmntTypeVal);
		}
	
	 }
	 
	function doPayment(pmntTypeVal)
	{
		if(pmntTypeVal == "VISA" || pmntTypeVal == "MASTERCARD")
		{
			
			$("#<portlet:namespace/>pmntType").val(pmntTypeVal).appendTo('#<portlet:namespace/>quotForm');
			var access_code = $("#access_code").val();
			var language = $("#language").val();
			var merchant_identifier = $("#merchant_identifier").val();
			var currTime = new Date().getTime();
			var merchant_reference = $("#merchant_reference").val()+"_"+currTime;
			$("#merchant_reference").val(merchant_reference);

			var csc = (pmntTypeVal == "VISA")?$("#<portlet:namespace/>visaVerfCode").val():$("#<portlet:namespace/>masterVerfCode").val();
			csc = toHex(csc);
			$("#card_security_code").val(csc);

			var return_url = $("#return_url").val();
			return_url += "&payment_option="+pmntTypeVal+"&csc="+csc+"&mobileView=true";
			$("#return_url").val(return_url);
			var service_command = $("#service_command").val();

			var  signature = requestPhrase + 'access_code='+access_code+'language='+language+'merchant_identifier='+merchant_identifier+'merchant_reference='+merchant_reference+'return_url='+return_url+'service_command='+service_command+requestPhrase;

			var expiry_date;
			if(pmntTypeVal == "VISA")
				expiry_date = $("#<portlet:namespace/>visaExpYear").val().substring(2, 4) + $("#<portlet:namespace/>visaExpMonth").val();
			else
				expiry_date = $("#<portlet:namespace/>masterCardYear").val().substring(2, 4) + $("#<portlet:namespace/>masterExpMonth").val();
			$("#expiry_date").val(expiry_date);
			$("#card_number").val((pmntTypeVal == "VISA")?$("#<portlet:namespace/>visaCardNo").val():$("#<portlet:namespace/>masterCardNo").val());
			$("#card_security_code").val((pmntTypeVal == "VISA")?$("#<portlet:namespace/>visaVerfCode").val():$("#<portlet:namespace/>masterVerfCode").val());

			var sha256 = new jsSHA('SHA-256', 'TEXT');
			sha256.update(signature);
			var hash = sha256.getHash("HEX");
			$("#signature").val(hash).appendTo('#pmntForm');
			$("#pmntForm").submit();
			//window.location=return_url;
		}
		else
		{
			$('input[name="<portlet:namespace/>totalAmount"]').val('<%=quot.getNetPrem()%>');
			$("#<portlet:namespace/>quotForm").submit();
		}
	}
	
	function saveAddressFields(pmntTypeVal)
	{
		var natAddress;
		if(!<%=isUserSignedIn%>)
		{
			natAddress = {};
			natAddress.buildNo = $("input[name='<portlet:namespace />buildingNo']").val();
			natAddress.stName = $("input[name='<portlet:namespace />streetName']").val();
			natAddress.district = $("input[name='<portlet:namespace />district']").val();
			natAddress.city = $("select[name='<portlet:namespace />city']").val();
			natAddress.zipCode = $("input[name='<portlet:namespace />zipCode']").val();
			natAddress.addNo = $("input[name='<portlet:namespace />addInfo']").val();
		}
		var offAddress;
		if($(".officeAddDiv").is(":visible"))
		{
			offAddress = {};
			offAddress.buildNo = $("input[name='<portlet:namespace />offBuildNo']").val();
			offAddress.stName = $("input[name='<portlet:namespace />offStName']").val();
			offAddress.district = $("input[name='<portlet:namespace />offDistrict']").val();
			offAddress.city = $("select[name='<portlet:namespace />offCity'] option:selected").val();
			offAddress.zipCode = $("input[name='<portlet:namespace />offZipCode']").val();
			offAddress.addNo = $("input[name='<portlet:namespace />offAddNo']").val();
		}
		
		AUI().use('aui-io-request', function(A){
	        A.io.request('<%=resourceURLVal%>', {
               method: 'post',
               dataType: 'json',
               data: {"<portlet:namespace/>quotDets":"<%=quotDets%>","<portlet:namespace/>natAddress":JSON.stringify(natAddress),"<portlet:namespace/>offAddress":JSON.stringify(offAddress)},
               on: {
                    success: function(data)
                    {
                    	var res = this.get('responseData');
                    	if(res.indexOf('success') > -1)
                    	{
                			doPayment(pmntTypeVal);
                    	}
                    	else if(res.indexOf('error') > -1)
                    	{
							alert("error saving address");
                    	}
                    }
               }
            });
	    });
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
	
	function editOptionsSubmit(productChanged)
	{
		var quotDets = "<%=quotDets%>";
		var jsonQuot = JSON.parse(quotDets.replace(/'/g, "\""));
		jsonQuot.productChanged = productChanged;
		jsonQuot.productCode = (productChanged)?"<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL:BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE%>":jsonQuot.productCode;
		console.log(jsonQuot);
		$("#personalInfoBackForm").find("#<portlet:namespace/>quot").val(JSON.stringify(jsonQuot).replace(/\"/g, "'"));
		$('#personalInfoBackForm').submit();
	}
	
	function editRenewOptions()
	{
		$("#otherCoverage").text("SAR 0");
		AUI().use('aui-io-request', function(A){
	        A.io.request('<%=quickQuoteURLVal%>', {
               method: 'post',
               dataType: 'json',
               data: {"<portlet:namespace/>quotDets":"<%=quotDets%>"},
               on: {
                    success: function(data)
                    {
                    	var res = this.get('responseData');
                    	if(res.indexOf('success') > -1)
                    	{
        					$("#otherCoverage").text("SAR "+res.split("#")[1]);
                    		AUI().use('aui-modal', function(A) {
                    			var dialog = new A.Modal({
                    				title: "",
                    				cssClass: "renew-dialog",
                    				bodyContent: $('#cover_type').html(),
                    				headerContent: '<h4 class="no-margin"><liferay-ui:message key="choose_cvr_typ"/></h4>',
                    				centered: true,
                    				modal: true,
                    				width:600,
                    				render: '#aui_popup_content',
                    				close: true
                    			});
                    		});
                    	}
                    	else if(res.indexOf('error') > -1) {
                    	}
                    }
               }
            });
	    });
	}
(function (global)
{
	if(typeof (global) === "undefined")
	{
		throw new Error("window is undefined");
	}
    var _hash = "#";
    var noBackPlease = function () {
        global.location.href += "#";
	 
        global.setTimeout(function () {
            global.location.href += "#";
        }, 50);
	};
	 
    global.onhashchange = function () {
        if (global.location.hash !== _hash) {
            global.location.hash = _hash;
        }
    };
	 
	global.onload = function () {
		noBackPlease();
		document.body.onkeydown = function (e)
		{
            var elm = e.target.nodeName.toLowerCase();
            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea'))
            {
                e.preventDefault();
            }
            e.stopPropagation();
	    };
	};
	 
})(window);	
</aui:script>