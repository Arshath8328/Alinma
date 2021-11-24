<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.bsl.db.service.QuotationLocalServiceUtil"%>
<%@page import="com.atmc.web.util.FileUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
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
<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/bootstrap_select/css/bootstrap-select.min.css">
<script src="/o/atmc-theme/vendor/bootstrap_select/js/bootstrap-select.min.js"></script>
<%-- <%@ include file="/init.jsp"%> --%>

<%@ include file="init.jsp"%>

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
/* PortletURL saveImagesresourceURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
saveImagesresourceURL.setParameter("resourceType", "saveImages");
String saveImagesresourceURLVal = saveImagesresourceURL.toString(); 
if(saveImagesresourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
	saveImagesresourceURLVal = saveImagesresourceURLVal.substring(0, saveImagesresourceURLVal.lastIndexOf("&p_p_lifecycle=1"));  */
 



	String tokenizationUrl = PropsUtil.get("com.ejada.atmc.payfort.tokenization.url");
	List cities = (List)request.getAttribute("cities");
	String pFail = (request.getAttribute("paymentFail")!=null)?(String)request.getAttribute("paymentFail"):(request.getParameter("paymentFail")!=null)?request.getParameter("paymentFail"):null;
	boolean paymentFail = Boolean.valueOf(pFail).booleanValue();
	boolean invIBAN = request.getAttribute("invalidIBAN") != null ? (boolean)request.getAttribute("invalidIBAN") : false;
	List engineSizes =  QuotationLocalServiceUtil.geEngineSizes();
	List parkLocs =  QuotationLocalServiceUtil.getParkingLocations();
	String paymentErrorCode = null;
	String paymentErrorMsg = null;
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

	Log _log = LogFactoryUtil.getLog(this.getClass());

	boolean isMCCQuoteNull = false;
	Quotation quot = (Quotation)request.getAttribute("quote");
	Quotation  quotDet = (Quotation)request.getAttribute("quot");
	if(Validator.isNull(quot)) {
		isMCCQuoteNull = true;
		quot=quotDet;
		_log.info("Quot - MCC was null therefore assigned with Quote-MTP values");
	}
	boolean payPolicy = (request.getAttribute("payPolicy")!=null)?((Boolean)request.getAttribute("payPolicy")):false;
	Gson gson = new Gson();
	String quotDets = gson.toJson(quotDet);
	
	Gson gsonlogin = new Gson();
	String quotDetslogin = gsonlogin.toJson(quot);
	quotDetslogin = quotDetslogin.replace("\"", "'");
	quotDetslogin = quotDetslogin.replaceAll("\\r\\n", "");
	
	Gson gsontp = new Gson();
	String quotDetTp = gsontp.toJson(quotDet);
	quotDetTp = quotDetTp.replaceAll("\"", "'");
	_log.info("  ----------------------  Quotation Details  ------------------- ");
	_log.info(quotDets);
	_log.info(" -------------------------- End Quotation Details ---------------------- ");
	quotDets = quotDets.replaceAll("\"", "'");
	quotDets = quotDets.replaceAll("\\r\\n", "");
	_log.info("  ----------------------  Quotation Details After Fix  ------------------- ");
	_log.info(quotDets);
	_log.info(" -------------------------- End Quotation Details After Fix---------------------- ");
	
	String downloadUrlVal = null;
	if(Validator.isNotNull(quot) && quot.getNetPrem() != 0)
	{ 
	PortletURL downloadQuotUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadQuotUrl.setParameter("quotId", ""+quot.getQuotationId());
	downloadQuotUrl.setParameter("insuredId", ""+quot.getInsuredId());
	downloadUrlVal = downloadQuotUrl.toString(); 
	if(downloadUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		downloadUrlVal = downloadUrlVal.substring(0, downloadUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	_log.info("------------------ Quotation Download URL = " + downloadUrlVal+" ----------------------");
	}
	/* if(!isUserSignedIn)
	{
	PortletURL downloadQuotUrlTp =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadQuotUrlTp.setParameter("quotId", ""+quotDet.getQuotationId());
	String downloadUrlValTp = downloadQuotUrlTp.toString(); 
	if(downloadUrlValTp.indexOf("&p_p_lifecycle=1") != -1)
		downloadUrlValTp = downloadUrlValTp.substring(0, downloadUrlValTp.lastIndexOf("&p_p_lifecycle=1"));
	_log.info("------------------ Quotation Download URL = " + downloadUrlValTp+" ----------------------");
	} */
	PortletURL resourceURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	resourceURL.setParameter("resourceType", "saveAddress");
	String resourceURLVal = resourceURL.toString(); 
	if(resourceURLVal.indexOf("&p_p_lifecycle=1") != -1)
		resourceURLVal = resourceURLVal.substring(0, resourceURLVal.lastIndexOf("&p_p_lifecycle=1"));

	/* PortletURL resourceURLSaveImage = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	resourceURLSaveImage.setParameter("resourceType", "saveImages"); */
	
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
</portlet:actionURL>

<portlet:actionURL name="personalInfo" var="personalInfo">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>
<form id="personalInfoBackForm" name="personalInfoBackForm" role="form" action="<%=personalInfo %>" method="post">
	<input type="hidden" name="<portlet:namespace/>quot" id="<portlet:namespace/>quot" value="<%=quotDets %>"/>
	<input type="hidden" name="<portlet:namespace/>myview" value="personal_info" />
</form>
 <div class="row bg-white">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><%=(Validator.isNotNull(quot) && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?LanguageUtil.get(request, "comp_product"):LanguageUtil.get(request, "tpl_product") %></h3>
	</div>
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive"
			src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
	</div>
</div>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<aui:form id="quotForm" name="quotForm" role="form" action="<%=results%>" method="post"  >
			<input type="hidden" name="<portlet:namespace/>quot" id="quote" value="<%=quotDets %>"/>
			<input type="hidden" name="<portlet:namespace/>pmntType" value="" />
			<input type="hidden" name="<portlet:namespace/>myview" value="results" />
			<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL %>" message="Payment Error" />
			<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL %>" message='<%= LanguageUtil.get(request,"policy_issuance_error") %>' />
			<div class="row vcenter">
				<div class="col-xs-6 col-sm-6 col-md-offset-1 col-md-5 col-lg-5 col-lg-offset-2">
					<h3 class="no-margin">
						<%-- <liferay-ui:message key="your_quotation"/><br /> <small><liferay-ui:message key="quot_no"/> <%=quot.getReferenceNo() %></small> --%>
						<%-- <liferay-ui:message key="your_quotation"/><br /> <small><liferay-ui:message key="quot_no"/> <%=tpQuot.getReferenceNo() %></small> --%>
					</h3>
				</div>
				<div class="text-right col-xs-6 col-sm-6 col-md-3 col-lg-3">
					<img src="/o/atmc-theme/images/logo.svg" class="img-responsive" />
				</div>
			</div>
			<div class="row">
				<div
					class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
					<table class="table table-bordered ej-table align-left">
						<tbody>
							<tr>
								<td>
									<div class="row">
										<%-- <div class="col-xs-4 col-sm-4 col-md-4 col-lg-4">
											<i class="car-<%=(FileUtil.MAKES_LIST.contains(quot.getVehicleMake()))?quot.getVehicleMake():"1" %>" style="font-size:35px;"></i>
										</div> --%>
	    								<div class="col-xs-8 col-sm-8 col-md-8 col-lg-8 text-primary">
	    									<%=(currLocale.equals("en_US"))?(quot.getVehicleMakeEn()+" "+quot.getVehicleModelEn()):(quot.getVehicleMakeAr()+" "+quot.getVehicleModelAr()) %>
	    									<br /> <small class="text-muted"><%=quot.getVehicleMfgYear() %></small>
	    								</div>
	    							</div>
	    						</td>
								<td class="text-primary"><%=quot.getInsuredName() %></td>
<%
	if(!BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD.equals(""+quot.getVehicleIdType()))
	{
%>								
								<td class="text-primary"><%=quot.getVehiclePlateNo() +" "+quot.getVehiclePlateL3()+" "+quot.getVehiclePlateL2()+" "+quot.getVehiclePlateL1() %></td>
<%
	}
	Date fromDate =  quot.getPolicyEffDate();
	Calendar cal = new GregorianCalendar();
	cal.setTime(fromDate);
	cal.add(Calendar.YEAR, 1);
	cal.add(Calendar.DAY_OF_MONTH, -1);
	/* cal.add(Calendar.DAY_OF_MONTH, 60); */
	Date effToDate = cal.getTime();
%>								
								<td class="bg-primary">From <%=dmyDateFormatter.format(fromDate) %><br>To <%=dmyDateFormatter.format(effToDate) %></td>
							</tr>
						</tbody>
					</table>
				</div>
				<div
					class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
					<div class="portlet-content">
						<h4><liferay-ui:message key="owner_dets"/></h4>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="ins_type"/></th>
									<td><%=(quot.getVehicleIdType()== Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))?LanguageUtil.get(request, "ist_card"):(quot.getVehicleIdType()== Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD)?LanguageUtil.get(request, "cust_card"):LanguageUtil.get(request, "trns_owner")) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><%=LanguageUtil.get(request, "id_number") %></th>
									<td><%=quot.getInsuredId() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="driver_dob"/></th>
									<td><%=(quot.getInsuredDob()!=null)?dmyDateFormatter.format(quot.getInsuredDob()):"" %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="email"/></th>
									<td><%=quot.getInsuredEmail() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="mob_no"/></th>
									<td><%=quot.getInsuredMobile() %></td>
								</tr>
							</tbody>
						</table>
<%
	if(quot.getQuotationDrivers() !=null && !quot.getQuotationDrivers().isEmpty())
	{
		int drvCount = 0;
		for(QuotationDriver addDriver : quot.getQuotationDrivers())
		{
			drvCount++;
%>						
						<h4><liferay-ui:message key="add_driver"/> #<%=drvCount %></h4>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th width="40%" class="bg-gray"><%=LanguageUtil.get(request, "driver_name") %></th>
									<td><%=addDriver.getDriverName() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="dri_id"/></th>
									<td><%=addDriver.getDriverId() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="ncd_year"/></th>
									<td><%=addDriver.getNcdYears() %></td>
								</tr>
							</tbody>
						</table>
<%
		}
	}
%>
						<h4><liferay-ui:message key="veh_det"/></h4>
						<table class="table table-bordered">
							<tbody>
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="make"/></th>
									<td><%=(currLocale.equals("en_US"))?quot.getVehicleMakeEn():quot.getVehicleMakeAr() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="mod_ver"/></th>
									<td><%=(currLocale.equals("en_US"))?quot.getVehicleModelEn():quot.getVehicleModelAr() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="body_type"/></th>
									<td><%=(currLocale.equals("en_US"))?quot.getVehicleBodyTypeEn():quot.getVehicleBodyTypeAr() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="year_make"/></th>
									<td><%=quot.getVehicleMfgYear() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="plate_no"/></th>
									<td><%=(!BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD.equals(""+quot.getVehicleIdType()))?(quot.getVehiclePlateNo() +" "+quot.getVehiclePlateL3()+" "+quot.getVehiclePlateL2()+" "+quot.getVehiclePlateL1()):""%></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="veh_use"/></th>
									<td><%=quot.getPurposeOfVehicleDesc() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="chassis_no"/></th>
									<td><%=quot.getVehicleChassisNo() %></td>
								</tr>
								<tr>
									<th class="bg-gray"><%=(!BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD.equals(""+quot.getVehicleIdType()))?LanguageUtil.get(request, "seq_no"):LanguageUtil.get(request, "cust_card") %></th>
									<td><%=quot.getVehicleId() %></td>
								</tr>
							</tbody>
						</table>
<%
	if(quot.getCoversList() !=null && !quot.getCoversList().isEmpty())
	{
%>						
						<h4><liferay-ui:message key="add_ben"/></h4>
						<table class="table table-bordered">
							<tbody>
<%
		for(int cCount=0;cCount<quot.getCoversList().size();cCount++)
		{
			QuotationCover cover = quot.getCoversList().get(cCount);
%>
								<tr>
									<th width="40%" class="bg-gray"><%=cover.getCoverName() %></th>
									<td>SAR <%=numberFormat.format(cover.getCoverPrem()) %></td>
								</tr>
<%
		}
%>
							</tbody>
						</table>
<%
	}
%>						




<%


Calendar calen = new GregorianCalendar();
calen.setTime(new Date());
int currentYear = calen.get(Calendar.YEAR);
long vehMfgYr =  quot.getVehicleMfgYear();
if(!isUserSignedIn)
{
if(!isMCCQuoteNull && quot!=null && !(currentYear - vehMfgYr >=11) && quot.getNetPrem()!= 0)
{
%>
 <div class="row">
 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<h4><liferay-ui:message key="pmnt_dets_od"/></h4>
						<table class="table table-bordered">
							<tbody>
<%
	/* double premAmount = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21() + quot.getLoadingAmount();
_log.info( "NetPrem() >>>>>"+quot.getNetPrem()+"LoadingAmount >>>>>" +quot.getLoadingAmount()+ "premAmountTp "+premAmount ); */ 
%>							
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="quote_no"/></th>
									<td><%=quot.getReferenceNo() %></td>
								</tr>
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="premium"/></th>
									<td><%=numberFormat.format(quot.getNetPrem()) %></td>
								</tr>
						
								<tr>
									<th class="bg-gray"><liferay-ui:message key="val_veh_rate"/></th>
									<td><%=numberFormat.format(quot.getVehicleValue()) %></td>
								</tr>							
<%
	double discountAmount = quot.getDiscountAmount();
	if(quot.getLoyaltyDiscount() !=null && !quot.getLoyaltyDiscount().equals(""))
		discountAmount += Double.valueOf(quot.getLoyaltyDiscount());
%>								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="no_claim"/></th>
									<td><%=numberFormat.format(discountAmount) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="loading_amt"/></th>
									<td><%= numberFormat.format(quot.getLoadingAmount())  %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><%=(quot.getSaeedService()!=null && quot.getSaeedService()!="" ? quot.getSaeedService() : 0 ) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><liferay-ui:message key="discount_percent_od"/></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="discount_rate"/></th>
									<%-- <td><%=new Double (quot.getDiscountPrem() + quot.getLoyaltyDiscountPer()).longValue()%> %</td> --%>
									 <td><%=new Double (quot.getDiscountPrem()).longValue()%> %</td>
									
								</tr>
<%
	double vatAmount = (quot.getGrossPrem()/(1+quot.getPolicyTaxes()))*quot.getPolicyTaxes();
%> 								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="vat_05"/></th>
									<td><%=numberFormat.format(vatAmount) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="total_pmnt_amount"/></th>
									<td><%=numberFormat.format(quot.getGrossPrem()) %></td>
								</tr>
							</tbody>
						</table>
						<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="comprehensive" style="width: 100%;"><liferay-ui:message key="comp_ins"/></button></div>						
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<h4><liferay-ui:message key="pmnt_dets_tp"/></h4>
						<table class="table table-bordered">
							<tbody>
<%
/* double premAmountTp = quotDet.getNetPrem() + quotDet.getAgencyRepairOut() + quotDet.getDriverAgeLess21() + quotDet.getLoadingAmount();
_log.info( "NetPrem() >>>>>"+quotDet.getNetPrem()+"LoadingAmount >>>>>" +quotDet.getLoadingAmount()+ "premAmountTp "+premAmountTp );  */
%>								
									<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="quote_no"/></th>
									<td><%=quotDet.getReferenceNo() %></td>
								</tr>
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="premium"/></th>
									<td><%=numberFormat.format(quotDet.getNetPrem()) %></td>
								</tr>
							
								<tr>
									<th class="bg-gray"><liferay-ui:message key="val_veh_rate"/></th>
									<td><%=numberFormat.format(quotDet.getVehicleValue()) %></td>
								</tr>
<%
	double discountAmountTp = quotDet.getDiscountAmount();
	if(quotDet.getLoyaltyDiscount() !=null && !quotDet.getLoyaltyDiscount().equals(""))
		discountAmountTp += Double.valueOf(quotDet.getLoyaltyDiscount());
%>								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="no_claim"/></th>
									<td><%=numberFormat.format(discountAmountTp) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="loading_amt"/></th>
									<td><%=numberFormat.format(quotDet.getLoadingAmount())%></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><%=(quotDet.getSaeedService()!=null && quotDet.getSaeedService()!="" ? quotDet.getSaeedService() : 0  )%></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><liferay-ui:message key="discount_percent_tp"/></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="discount_rate"/></th>
									<%-- <td><%=new Double (quotDet.getDiscountPrem() + quotDet.getLoyaltyDiscountPer()).longValue()%> %</td> --%>
									<td><%=new Double (quotDet.getDiscountPrem()).longValue()%> %</td>
								</tr>
<%
	double vatAmountTp = (quotDet.getGrossPrem()/(1+quotDet.getPolicyTaxes()))*quotDet.getPolicyTaxes();
%> 								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="vat_05"/></th>
									<td><%=numberFormat.format(vatAmountTp) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="total_pmnt_amount"/></th>
									<td><%=numberFormat.format(quotDet.getGrossPrem()) %></td>
								</tr>
							</tbody>
						</table>
						
						<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="thirdparty" style="width: 100%;"><liferay-ui:message key="tpl_ins"/></button>
						</br>
	</div>					
	</div>
	<%
}
else
{
	%>
	
	<h4><liferay-ui:message key="pmnt_dets"/></h4>
						<h4><liferay-ui:message key="pmnt_dets_tp"/></h4>
						<table class="table table-bordered">
							<tbody>
<%
	double premAmountTp = quotDet.getNetPrem() + quotDet.getAgencyRepairOut() + quotDet.getDriverAgeLess21() + quotDet.getLoadingAmount();

_log.info( "NetPrem() >>>>>"+quotDet.getNetPrem()+"LoadingAmount >>>>>" +quotDet.getLoadingAmount()+ "premAmountTp "+premAmountTp );

%>								
									<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="quote_no"/></th>
									<td><%=quotDet.getReferenceNo() %></td>
								</tr>
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="premium"/></th>
									<td><%=numberFormat.format(quotDet.getNetPrem()) %></td>
								</tr>
							
								<tr>
									<th class="bg-gray"><liferay-ui:message key="val_veh_rate"/></th>
									<td><%=numberFormat.format(quotDet.getVehicleValue()) %></td>
								</tr>
<%
	double discountAmountTp = quotDet.getDiscountAmount();
	if(quotDet.getLoyaltyDiscount() !=null && !quotDet.getLoyaltyDiscount().equals(""))
		discountAmountTp += Double.valueOf(quotDet.getLoyaltyDiscount());
%>								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="no_claim"/></th>
									<td><%=numberFormat.format(discountAmountTp) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="loading_amt"/></th>
									<td><%=numberFormat.format(quotDet.getLoadingAmount()) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="discount_rate"/></th>
									<%-- <td><%=new Double (quotDet.getDiscountPrem() + quotDet.getLoyaltyDiscountPer()).longValue()%> %</td> --%>
									<td><%=new Double (quotDet.getDiscountPrem()).longValue()%> %</td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><%=(quotDet.getSaeedService()!=null && quotDet.getSaeedService()!="" ? quotDet.getSaeedService() : 0 ) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><liferay-ui:message key="discount_percent_tp"/></td>
								</tr>
<%
	double vatAmountTp = (quotDet.getGrossPrem()/(1+quotDet.getPolicyTaxes()))*quotDet.getPolicyTaxes();
%> 								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="vat_05"/></th>
									<td><%=numberFormat.format(vatAmountTp) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="total_pmnt_amount"/></th>
									<td><%=numberFormat.format(quotDet.getGrossPrem()) %></td>
								</tr>
							</tbody>
						</table>
						<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="thirdparty" style="width: 100%;"><liferay-ui:message key="tpl_ins"/></button>
	</div>					
	</div>
	<% 
	
}
}
	%>
	</br>		
	
	<%
	
	if(isUserSignedIn)
	{
		
		%>
		<h4><liferay-ui:message key="pmnt_dets"/></h4>
						<table class="table table-bordered">
							<tbody>
<%
	/* double premAmount = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21() + quot.getLoadingAmount();
	_log.info( "NetPrem() >>>>>"+quot.getNetPrem()+"LoadingAmount >>>>>" +quot.getLoadingAmount()+ "premAmountTp "+premAmount );
 */
%>							
								<tr>
									<th width="40%" class="bg-gray"><liferay-ui:message key="premium"/></th>
									<td><%=numberFormat.format(quot.getNetPrem()) %></td>
								</tr>
<%
	if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))
	{
%>								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="val_veh_rate"/></th>
									<td><%=numberFormat.format(quot.getVehicleValue()) %></td>
								</tr>
<%
	}
%>								
<%
	double discountAmount = quot.getDiscountAmount();
	if(quot.getLoyaltyDiscount() !=null && !quot.getLoyaltyDiscount().equals(""))
		discountAmount += Double.valueOf(quot.getLoyaltyDiscount());
%>								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="no_claim"/></th>
									<td><%=numberFormat.format(discountAmount) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="loading_amt"/></th>
									<td><%=numberFormat.format(quot.getLoadingAmount())  %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="discount_rate"/></th>
									<%-- <td><%=new Double (quot.getDiscountPrem() + quot.getLoyaltyDiscountPer()).longValue()%> %</td> --%>
									<td><%=new Double (quot.getDiscountPrem()).longValue()%></td>
								</tr>
<%
	double vatAmount = (quot.getGrossPrem()/(1+quot.getPolicyTaxes()))*quot.getPolicyTaxes();
%> 								
								<tr>
									<th class="bg-gray"><liferay-ui:message key="vat_05"/></th>
									<td><%=numberFormat.format(vatAmount) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><%=(quot.getSaeedService()!=null && quot.getSaeedService()!="" ? quot.getSaeedService() : 0 ) %></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="special_discount"/></th>
									<td><liferay-ui:message key="discount_percent_od"/></td>
								</tr>
								<tr>
									<th class="bg-gray"><liferay-ui:message key="total_pmnt_amount"/></th>
									<td><%=numberFormat.format(quot.getGrossPrem()) %></td>
								</tr>
							</tbody>
						</table>
		<%
	}
	%>
					</div>
					<div><%=LanguageUtil.get(request, "disclaimer") %> : <%=LanguageUtil.get(request, "policy_cncl_fees") %></div>
				</div>
			</div>		
			<div class="row bg-primary vcenter">
				<div class="col-lg-6 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
					<div class="media">
						<div class="media-left">
							<i class="material-icons md-36">&#xE862;</i>
						</div>
						<div class="media-body">
							<p><liferay-ui:message key="activation_email"/></p>
							<p><liferay-ui:message key="login_email"/></p>
						</div>
					</div>
				</div>
				<%
				if(!isUserSignedIn)
				{
					PortletURL downloadQuotUrlTp =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
					downloadQuotUrlTp.setParameter("quotId", ""+quotDet.getQuotationId());
					downloadQuotUrlTp.setParameter("insuredId", ""+quotDet.getInsuredId());
					String downloadUrlValTp = downloadQuotUrlTp.toString();
					if(downloadUrlValTp.indexOf("&p_p_lifecycle=1") != -1)
						downloadUrlValTp = downloadUrlValTp.substring(0, downloadUrlValTp.lastIndexOf("&p_p_lifecycle=1"));
					_log.info("------------------ Quotation Download URL = " + downloadUrlValTp+" ----------------------");
				%>
				<div class="col-lg-2 text-right">
					<div class="btn btn-link text-white" onclick="self.print();"><i class="material-icons md-36">&#xE8AD;</i></div>
					
					 <%
					 if(!isMCCQuoteNull && quot!=null && !(currentYear - vehMfgYr >=11) && quot.getNetPrem()!=0)
					 {
					%> 
					<div class="btn btn-link text-white" onclick="window.location='<%=downloadUrlVal%>'">
					<i class="material-icons md-36">&#xE415;</i></div>
					<%
					 }
					%>
					<div class="btn btn-link text-white" onclick="window.location='<%=downloadUrlValTp%>'">
					<i class="material-icons md-36">&#xE415;</i>
				</div>
			</div>
			<%	
				}
				else
				{
			%>
				<div class="col-lg-2 text-right">
					<div class="btn btn-link text-white" onclick="self.print();"><i class="material-icons md-36">&#xE8AD;</i></div>
					<div class="btn btn-link text-white" onclick="window.location='<%=downloadUrlVal%>'"><i class="material-icons md-36">&#xE415;</i></div>
				</div>
				
				<%
				}
				%>			
</div>
			<%
			
			if(!isUserSignedIn)
			{
			%>
			<div class="row" id = "additionalDetails"  style="display: none">
			<%
			}
			else
			{
			%>
			<div class="row" id = "additionalDetails">
			<%
			}
			%>
				<div class="col-md-8 col-md-offset-2 col-lg-8 col-lg-offset-2 col-sm-12 col-xs-12 portlet-content">
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
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressBuildingNo()!=0)?quot.getAddressBuildingNo():"" %>" disabled name="<portlet:namespace/>buildingNo" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="street_name"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressStreet()!=null)?quot.getAddressStreet():"" %>" disabled name="<portlet:namespace/>streetName" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="district"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getAddressDistrict()!=null)?quot.getAddressDistrict():"" %>" disabled name="<portlet:namespace/>district" />
									</div>
								</div>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="city"/></label>
										<input class="form-control" type="text" placeholder="" value="<%=(quot.getCityDesc()!=null)?quot.getCityDesc():"" %>" disabled name="<portlet:namespace/>city" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
									<div class="form-group">
										<label class="control-label"><liferay-ui:message key="zip_code"/></label>
										<input class="form-control" type="text" placeholder=""  value="<%=(quot.getAddressZipCode()!=0)?quot.getAddressZipCode():"" %>" disabled name="<portlet:namespace/>zipCode" />
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
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="veh_acc_no"/></label>
									<input class="form-control" required="required" type="text" name="<portlet:namespace/>iban" id="iban" placeholder="SA 40395000XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX" value="<%=(quot.getVehicleOwnerIban()!=null)?quot.getVehicleOwnerIban():""%>" oninput="this.value = this.value.toUpperCase();"/>
									<small><liferay-ui:message key="mistake_resp"/></small>
								</div>
							</div>
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group">
									<input class="form-control" type="text" name="<portlet:namespace/>copyIban" id="copyIban" onpaste="return false;" placeholder="<liferay-ui:message key="confirm_veh_acc_num"/>" oninput="this.value = this.value.toUpperCase();"/>
								</div>
							</div>
							 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="mileage_expected"/></label>
									<select class="form-control" required="required" name="<portlet:namespace/>expMileRange" id="expMileRange">
										<option value="-1"><liferay-ui:message key="please_select_option"/></option>
										<option value="0 - 4999" <%=(quot.getVehicleLowerExpectedMileagePerYear() == 0  && quot.getVehicleUpperExpectedMileagePerYear() == 4999)?"selected":"" %>>0 - 4,999</option>
										<option value="5000 - 9999" <%=( quot.getVehicleLowerExpectedMileagePerYear() == 5000  && quot.getVehicleUpperExpectedMileagePerYear() == 9999)?"selected":"" %>>5,000 - 9,999</option>
										<option value="10000 - 19999" <%=( quot.getVehicleLowerExpectedMileagePerYear() == 10000  && quot.getVehicleUpperExpectedMileagePerYear() == 19999)?"selected":"" %>>10,000 - 19,999</option>
										<option value="20000 - 39999" <%=(quot.getVehicleLowerExpectedMileagePerYear() == 20000  && quot.getVehicleUpperExpectedMileagePerYear() == 39999)?"selected":"" %>>20,000 - 39,999</option>
										<option value="40000 - 40000" <%=(quot.getVehicleLowerExpectedMileagePerYear() == 40000  && quot.getVehicleUpperExpectedMileagePerYear() == 40000)?"selected":"" %>>40,000 & above</option>
									</select>
									<%-- <input type="hidden" name="<portlet:namespace/>addressCityCode" value="<%=addressCityCode%>"/> --%>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="cur_mileage"/></label>
									<input class="form-control" type="text" required="required" name="<portlet:namespace/>currMile" id="currMile"/>
								</div>
							</div>
						 <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="loc_veh_night"/></label>
									<select	class="form-control" required="required" name="<portlet:namespace/>nightLocation" id="nightLocation">
										<option value="-1" selected><liferay-ui:message key="please_select_option"/></option>
<%
	for(int plCount=0; parkLocs!=null && plCount<parkLocs.size();plCount++)
	{
		String selected = "";
		CodeMasterDetails park = (CodeMasterDetails)parkLocs.get(plCount);
		if(quot.getVehicleNightLocation()!=null && quot.getVehicleNightLocation().equals(park.getCodeSub()))
			selected = "selected";
		
%>										
										<option <%=selected %> value="<%=park.getCodeSub()%>"><%=(currLocale.equals("en_US") )?park.getCodeDesc():park.getCodeDescAr() %></option>
<%
	}
%>										
									</select>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								 <div class="form-group">
									<label class="control-label"><liferay-ui:message key="eng_size"/> </label>
									<select	class="form-control" name="<portlet:namespace/>engSize" id="engSize" required="required">
										<option value="-1" selected><liferay-ui:message key="please_select_option"/></option>
<%
		for(int esCount=0; engineSizes!=null && esCount<engineSizes.size();esCount++)
		{
			CodeMasterDetails eSize = (CodeMasterDetails)engineSizes.get(esCount); 
%>										
										<option value="<%=eSize.getCodeSub() %>" <%=(quot.getVehicleEngineSize()!=null && quot.getVehicleEngineSize().equals(eSize.getCodeSub()))?"selected":"" %>><%=(currLocale.equals("en_US") )?eSize.getCodeDesc():eSize.getCodeDescAr() %></option>
<%
		}
%>										
									</select>
								</div> 
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="trans_type"/> </label>
									<select	class="form-control" name="<portlet:namespace/>transType" id="transType" required="required">
										<option value="-1" selected><liferay-ui:message key="please_select_option"/></option>
										<option value="1" <%=(quot.getVehicleTransType()!=null && quot.getVehicleTransType().equals("1"))?"selected":"" %>><liferay-ui:message key="automatic"/></option>
										<option value="2" <%=(quot.getVehicleTransType()!=null && quot.getVehicleTransType().equals("2"))?"selected":"" %>><liferay-ui:message key="manual"/></option>
									</select>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="veh_specs"/> </label>
<%
	String[] vehSpecs = null;
	if(quot.getVehicleSpecs()!=null)
		vehSpecs = quot.getVehicleSpecs().split("\\|");
%>									
									<select	class="form-control selectpicker" required="required" multiple name="vehSpecsdd" id="<portlet:namespace/>vehSpecsdd" title="<liferay-ui:message key="please_select_option"/>">
										<option value="Anti-theft-alarm" <%=(vehSpecs!=null && vehSpecs.length>0 && vehSpecs[0].equals("1"))?"selected":"" %>><liferay-ui:message key="anti_theft_alarm"/></option>
										<option value="Anti-lock-braking-system" <%=(vehSpecs!=null && vehSpecs.length>1 && vehSpecs[1].equals("1"))?"selected":"" %>><liferay-ui:message key="anti_lock_brak_sys"/></option>
										<option value="Automatic-Braking-ABS" <%=(vehSpecs!=null && vehSpecs.length>2 && vehSpecs[2].equals("1"))?"selected":"" %>><liferay-ui:message key="auto_braking_sys"/></option>
										<option value="Cruise-Control" <%=(vehSpecs!=null && vehSpecs.length>3 && vehSpecs[3].equals("1"))?"selected":"" %>><liferay-ui:message key="cruise_control"/></option>
										<option value="Adaptive-Cruise-Control" <%=(vehSpecs!=null && vehSpecs.length>4 && vehSpecs[4].equals("1"))?"selected":"" %>><liferay-ui:message key="adaptive_cruise_control"/></option>
										<option value="Rear-Parking-Sensors" <%=(vehSpecs!=null && vehSpecs.length>5 && vehSpecs[5].equals("1"))?"selected":"" %>><liferay-ui:message key="rear_parking_sen"/></option>
										<option value="Front-Sensors" <%=(vehSpecs!=null && vehSpecs.length>6 && vehSpecs[6].equals("1"))?"selected":"" %>><liferay-ui:message key="front_sensors"/></option>
										<option value="Rear-Camera" <%=( vehSpecs!=null && vehSpecs.length>7 && vehSpecs[7].equals("1"))?"selected":"" %>><liferay-ui:message key="rear_camera"/></option>
										<option value="Front-Camera" <%=(vehSpecs!=null && vehSpecs.length>8 && vehSpecs[8].equals("1"))?"selected":"" %>><liferay-ui:message key="front_camera"/></option>
										<option value="360-degree-Camera" <%=(vehSpecs!=null && vehSpecs.length>9 && vehSpecs[9].equals("1"))?"selected":"" %>><liferay-ui:message key="degree_camera"/></option>
										<option value="Fire-Extinguisher" <%=(vehSpecs!=null && vehSpecs.length>10 && vehSpecs[10].equals("1"))?"selected":"" %>><liferay-ui:message key="extinguisher"/></option>
									</select>
									<input type="hidden" name ="<portlet:namespace/>vehSpecs" id="vehSpecs" value="<%=(quot.getVehicleSpecs()!=null)?quot.getVehicleSpecs():""%>"/>
									<input type="hidden" name ="<portlet:namespace/>selectedInsType" id="selectedInsType"/>
								</div>
							</div>
							
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group">
									<label class="control-label"><liferay-ui:message key="veh_axle_weight"/></label>
									<input class="form-control" type="text" required="required" name="<portlet:namespace/>vehAxle" id="vehAxle" placeholder='<liferay-ui:message key="commerical_veh"/>'/>
								</div>
							</div>
							
							<div class="row">
							<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
								<div class="form-group"> 
									<label class="control-label"><liferay-ui:message key="mods_in_car"/></label>
									<textarea class="form-control" id="carMods" name="<portlet:namespace/>carMods" rows="3" placeholder='<liferay-ui:message key="type_details"/>'>
										<e:forHtmlContent value="${param.value}" />
									</textarea>
								</div>									 
							</div>
						</div>
						</li>
					</ul>
					
					
					
					
					<%
			if(isUserSignedIn && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) && !quot.isRenew())
			{
			%>
			<div class="saveImagesForm" id = "saveImagesForm" style="display: block"> 
			
			<%
			}
			else
			{
			%>
			<div class="saveImagesForm" id = "saveImagesForm" style="display: none">
<%
			}
%>			
					 <!-- <div class="saveImagesForm" id = "saveImagesForm" style="display: block"> --> 
					  <%
					  _log.info("car images >>>>>>>>>>>>>>>1"+quot.isRenew());
					  _log.info("car images >>>>>>>>>>>>>>>2222"+!quot.isRenew());
	if((quot.getVehicleIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD) || quot.getVehicleIdType() == Long.valueOf(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD)) && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) || quot.getProductCode() == "OD" && !quot.isRenew())
	{
%>	
					<!-- <form name="saveImagesForm" id = "saveImagesForm"  style="display: none"> -->
					
					 <ul class="list-group no-margin " id = "saveImagesForm" >  
					<ul class="list-group no-margin">
						<li class="list-group-item bg-gray"><liferay-ui:message key="veh_photos"/></li>	
						<li class="list-group-item">
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="car_photo_front"/>
									</label> 
									<input readonly id="<portlet:namespace/>selectedCarFrontFile" name="<portlet:namespace/>selectedCarFrontFile" class="form-control" onclick="$('#<portlet:namespace/>selectedCarFrontFile').val('');$('#<portlet:namespace/>carFrontFile').click();"  placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>carFrontFile" id="<portlet:namespace/>carFrontFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedCarFrontFile').val(this.files.item(0).name);"/>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="car_photo_back"/>
									</label> 
									<input readonly id="<portlet:namespace/>selectedCarBackFile" name="<portlet:namespace/>selectedCarBackFile" class="form-control" onclick="$('#<portlet:namespace/>selectedCarBackFile').val('');$('#<portlet:namespace/>carBackFile').click();"  placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>carBackFile" id="<portlet:namespace/>carBackFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedCarBackFile').val(this.files.item(0).name);"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="car_photo_left"/>
									</label> 
									<input readonly id="<portlet:namespace/>selectedCarLeftFile" name="<portlet:namespace/>selectedCarLeftFile" class="form-control" onclick="$('#<portlet:namespace/>selectedCarLeftFile').val('');$('#<portlet:namespace/>carLeftFile').click();"  placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>carLeftFile" id="<portlet:namespace/>carLeftFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedCarLeftFile').val(this.files.item(0).name);"/>
								</div>
							</div>
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="car_photo_right"/>
									</label> 
									<input readonly id="<portlet:namespace/>selectedCarRightFile" name="<portlet:namespace/>selectedCarRightFile" class="form-control" onclick="$('#<portlet:namespace/>selectedCarRightFile').val('');$('#<portlet:namespace/>carRightFile').click();"  placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>carRightFile" id="<portlet:namespace/>carRightFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedCarRightFile').val(this.files.item(0).name);"/>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="eng_chass_no"/>
									</label> 
									<input readonly id="<portlet:namespace/>selectedEngChassNoFile" name="<portlet:namespace/>selectedEngChassNoFile" class="form-control" onclick="$('#<portlet:namespace/>selectedEngChassNoFile').val('');$('#<portlet:namespace/>engChassNoFile').click();" placeholder='<liferay-ui:message key="sel_file_loc"/>'  data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content="The easiest way to find the chassis numbert is to stand outside the vehicle on the driver's side and look at the corner of the dashboard where it meets the windshield. If the VIN cannot be found there, open the driver's side door and look at the door post (where the door latches when it is closed). Take a picture and upload."/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>engChassNoFile" id="<portlet:namespace/>engChassNoFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedEngChassNoFile').val(this.files.item(0).name);"/>
								</div>
							</div>
						</div>
						<input type="hidden" value="<%= quot.getInsuredId()%>" name = 'idDuringImageSaving'>
						<liferay-ui:message key="images_disclaimer_1"/>
						<liferay-ui:message key="images_disclaimer_2"/>
						</li>
					</ul>	
<%
	}
%> 
</div>
					<br/>
					<ul class="nav nav-tabs nav-justified">
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
				</div>
			</div>
		<liferay-captcha:captcha url="<%=captchaURL%>" />
		
		</aui:form>
	</div>
</div>

			<%
			if(!isUserSignedIn)
			{
			%>
			<div class="row vcenter total-payable" id ="paymentDetCpmo" style="display:none;">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 no-pad">
					<h3 class="text-primary">
						<small class="text-muted"><liferay-ui:message key="total_pmnt_amount"/></small>
						<br /><liferay-ui:message key="sar"/> <%=numberFormat.format(quot.getGrossPrem()) %> / <liferay-ui:message key="year"/></h3> 
				</div>
			</div>
			
			
			<div class="row vcenter total-payable" id ="paymentDetTp" style="display:none;">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 no-pad">
					<h3 class="text-primary">
						<small class="text-muted"><liferay-ui:message key="total_pmnt_amount"/></small>
						<br /><liferay-ui:message key="sar"/> <%=numberFormat.format(quotDet.getGrossPrem()) %> / <liferay-ui:message key="year"/></h3> 
				</div>
			</div>
			
			<%
			}
			
			else
			{
			%>
			<div class="row vcenter total-payable" id ="paymentDetCpmo">
				<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 no-pad">
					<h3 class="text-primary">
						<small class="text-muted"><liferay-ui:message key="total_pmnt_amount"/></small>
						<br /><liferay-ui:message key="sar"/> <%=numberFormat.format(quot.getGrossPrem()) %> / <liferay-ui:message key="year"/></h3> 
				</div>
			</div>
<%
			}
%>			
			
			<div class="row vcenter bg-white">
				<div class="col-md-4">
					<button id="termsAndCondLink" onclick="termsAndCondFn()" class="btn btn-link text-muted no-pad"><span class="glyphicon glyphicon-list-alt"></span>   <liferay-ui:message key="t_c"/></button>
					<br>
					<div class="form-group">
						<label class="checkbox-inline">
							<input class="control-label" id="termsAndCons" type="checkbox" value="" onchange="agreeTerms();">  <liferay-ui:message key="ack_data_correct"/>        
						</label>
					</div>
				</div>
				<div class="col-md-8 text-right no-pad">
					<ul class="list-btns">
						<li>
<%
		if(quot.isRenew())
		{
%>							
							<button class="btn btn-default btn-lg btn-xs-block" type="button" data-toggle="popover" data-trigger="hover" data-placement="top" data-html="true" onclick="editRenewOptions();"><liferay-ui:message key="edit_opts"/></button>
<%
		}
%>							
							<button style="pointer-events: none" class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn" onclick="validateQuoteFormAndSubmit();" disabled><liferay-ui:message key="confirm"/></button>
						</li>
					</ul>
				</div>
			</div>



<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div class="text-center">
	<%--  <liferay-ui:message key="quote_saved_no"/> <span class="text-primary"> <%=quot.getReferenceNo() %></span> <liferay-ui:message key="quote_valid_day"/> --%>
			<liferay-ui:message key="quote_saved_no"/> <span class="text-primary"></span> <liferay-ui:message key="quote_valid_day"/>
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
					<button class="btn btn-lg btn-default btn-outline" onclick="editOptionsSubmit(false);"><liferay-ui:message key="current_cover"/></button>
				</div>
				<div class="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"coverage_comp":"coverage_tpl" %>">
				<span class="best-value"><liferay-ui:message key="best_value"/></span>
				<span class="icon <%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"icon-transport":"icon-car-insurance" %> md-48 text-primary"></span>	
			    <h4><liferay-ui:message key="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"third_party_cover":"comprehensive_coverage" %>"/></h4>
					<br>
					<p><liferay-ui:message key="starting_from"/></p>
					<h2><small id="otherCoverage"><liferay-ui:message key="sar"/> 0</small></h2>
					<button class="btn btn-lg btn-primary" onclick="editOptionsSubmit(true);" <%=(quot.getVehicleMfgYear()<Calendar.getInstance().get(Calendar.YEAR) && Calendar.getInstance().get(Calendar.YEAR)-quot.getVehicleMfgYear()>=10 && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)?"disabled":"") %>><liferay-ui:message key="<%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?"downgrade":"upgrade" %>"/></button>
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
   	<br/>
	<div class="row text-left">
        <div class="col-md-12">
        	<button class="btn btn-primary btn-lg btn-xs-block" type="button" onclick="$('.close', window.parent.document).click().click();"><liferay-ui:message key="close"/></button>
        </div>
    </div>
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

<script>
/* $(function() {
	$('#OffAddress').change(function () {
		$('.officeAddDiv').toggle();
	});
	if ( window.history.replaceState ) {
		window.history.replaceState( null, null, window.location.href );
	}

}); */

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
	
	if(!paymentFail && !payPolicy)
	{
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				cssClass: "compose-dialog",
				bodyContent: $('#aui_popup_body').html(),
				headerContent: '<h4 class="no-margin"><liferay-ui:message key="rev_quot"/></h4>',
				centered: true,
				modal: true,
				height: 230,
				render: '#aui_popup_content',
				close: true
			});
			dialog.addToolbar(
				      [
				        {
				          label: 'OK',
				          cssClass: 'btn-outline',
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
	else if(paymentFail && <%=paymentErrorCode!=null%> && <%=paymentErrorMsg!=null%>)
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
	/* function buildValRules(pmntType)
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
			rules.<portlet:namespace/>madaExpYear =
			{
				required: true
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
	 */
	
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
						},
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
						}
					},
				    true
				);
				
				A.mix(A.config.FormValidator.STRINGS,
				    {
						onlyEngLetters:'<liferay-ui:message key="only_en_letters"/>',
						custOlpId:'Please enter valid ID',
						custDropDown:'<liferay-ui:message key="plz_select_value"/>',
						uploadFileSize:'<liferay-ui:message key="max_upload_size"/>',
			            checkFilename:"Enter a Valid File Name"
					},
				    true
				);
			});
			
			function validateFileName(fileName){
				var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
				return regex.test(fileName);
			}
			
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
			
			if(!<%=isUserSignedIn%> || <%=isUserSignedIn%>)
			{
				rules.<portlet:namespace/>iban = 
				{
		            required: true
			    }
				rules.<portlet:namespace/>copyIban = 
				{
		            required: true
			    }
				
				rules.<portlet:namespace/>currMile = 
				{
						required: true,
						number: true,
						min:1
			    }
				rules.<portlet:namespace/>nightLocation = 
				{
						required: true,
						custDropDown: true
			    }
				rules.<portlet:namespace/>expMileRange = 
				{
						required: true,
						custDropDown: true
			    }
				rules.<portlet:namespace/>engSize = 
				{
						required: true,
						custDropDown: true
			    }
				rules.<portlet:namespace/>transType = 
				{
						required: true,
						custDropDown: true
			    }
				rules.<portlet:namespace/>vehAxle = 
				{
						number: true,
						min:1
			    }
			}
			
			 
			
		 }
    var frmValidator;
	 function validateQuoteFormAndSubmit()
		{
		    $("#submitBtn").attr('disabled', true);
		    if (frmValidator)
				frmValidator.resetAllFields();
		    
		    
		    if($(".saveImagesForm").is(":visible"))
			{ 
			rules.<portlet:namespace/>selectedCarFrontFile =
			{
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG'
		    }
		    rules.<portlet:namespace/>selectedCarBackFile =
		    {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG',
		        checkFilename:true
		    }
		    rules.<portlet:namespace/>selectedCarLeftFile=
		    {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG',
		        checkFilename:true
		    }
		    rules.<portlet:namespace/>selectedCarRightFile=
		    {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG',
		        checkFilename:true
		    }
		    rules.<portlet:namespace/>selectedEngChassNoFile=
		    {
	            required: true, 
	            uploadFileSize: true,
	            acceptFiles: 'JPG, JPEG ,PDF ,PNG',
		        checkFilename:true
		    }
			 } 
		    
		    
		    
		    
		    
		    
			AUI().use('aui-form-validator', function(A) {
				frmValidator = new A.FormValidator({
				    boundingBox: '#<portlet:namespace/>quotForm',
				    rules:rules
				});
		
			});
			
			frmValidator.validate();

			if(!frmValidator.hasErrors())
			{
				/*  if($(".officeAddDiv").is(":visible") || !<%=isUserSignedIn%>) */ 
				if(!<%=isUserSignedIn%> || <%=isUserSignedIn%>)
					saveAddressFields(pmntTypeVal);
				else
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
			console.log("signature :::::::::::::::::::::::::::::::::::: "+signature);
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
			console.log("hash ::::::::::::::::::::::::: sha256.getHash(HEX)"+ sha256);
			var hash = sha256.getHash("HEX");
			console.log("hash ::::::::::::::::::::::::: sha256.getHash(HEX)"+ hash);
			$("#signature").val(hash).appendTo('#pmntForm');
			console.log(document.getElementById("pmntForm"));
			$("#pmntForm").submit();
			//window.location=return_url;
		}
		else
		{
			$(inputTemplate).attr('name','<portlet:namespace/>totalAmount').val('<%=quot.getNetPrem()%>').appendTo('#<portlet:namespace/>quotForm');
			$("#<portlet:namespace/>quotForm").submit();
		}
	}
	
	function populateVehSpecs()
	{
		var selVehSpecs = $("#<portlet:namespace/>vehSpecsdd").val();
		var vehSpecs = [];
		if($.inArray("Anti-theft-alarm", selVehSpecs) >-1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Anti-lock-braking-system", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Automatic-Braking-ABS", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Cruise-Control", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Adaptive-Cruise-Control", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Rear-Parking-Sensors", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Front-Sensors", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Rear-Camera", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Front-Camera", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("360-degree-Camera", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		if($.inArray("Fire-Extinguisher", selVehSpecs) > -1)
			vehSpecs.push("1");
		else
			vehSpecs.push("0");
		
		console.log(vehSpecs);
		$("#<portlet:namespace/>vehSpecs").val(vehSpecs.join("|"));
	}
	
	function saveAddressFields(pmntTypeVal)
	{
		var natAddress;
		if(!<%=isUserSignedIn%> || <%=isUserSignedIn%> )
		{
			natAddress = {};
			natAddress.buildNo = $("input[name='<portlet:namespace />buildingNo']").val();
			natAddress.stName = $("input[name='<portlet:namespace />streetName']").val();
			natAddress.district = $("input[name='<portlet:namespace />district']").val();
			natAddress.city = $("select[name='<portlet:namespace />city']").val();
			natAddress.zipCode = $("input[name='<portlet:namespace />zipCode']").val();
			natAddress.addNo = $("input[name='<portlet:namespace />addInfo']").val();
		}
		if(!<%=isUserSignedIn%> || <%=isUserSignedIn%>)
		{
			populateVehSpecs();
			
			var iban = $('#iban').val();
			var currMile = $('#currMile').val();
			var nightLocation =$('#nightLocation').val();
			var expMileRange = $("select[name='<portlet:namespace />expMileRange']").val();
			var engSize   =$('#engSize').val();
			var transType = $('#transType').val();
			var vehSpecsdd = $('#vehSpecsdd').val();
			var vehAxle  =$('#vehAxle').val();
			var carMods  = $('#carMods').val();
			var vehSpecs  = $('#vehSpecs').val();
			var selectedProduct = $('#selectedInsType').val();
		}
		/* $("select[name='<portlet:namespace />expMileRange']").val(); */
		
		AUI().use('aui-io-request', function(A){
	        A.io.request('<%=resourceURLVal%>', {
               method: 'post',
               dataType: 'json',
               data: {"<portlet:namespace/>quotDets":"<%=quotDets%>",
            	   "<portlet:namespace/>quotdetslogin":"<%=quotDetslogin%>",
            	   	  "<portlet:namespace/>quotDetTp":"<%=quotDetTp%>",            	   
            	   	  '<portlet:namespace/>iban':iban,
            	   		'<portlet:namespace/>engSize':engSize,
            	   		'<portlet:namespace/>currMile':currMile,
            	   		'<portlet:namespace/>transType':transType,
            	   		'<portlet:namespace/>expMileRange':expMileRange,
            	   		'<portlet:namespace/>nightLocation':nightLocation,
            	   		'<portlet:namespace/>vehAxle':vehAxle,
            	   		'<portlet:namespace/>carMods':carMods,
            	   		'<portlet:namespace/>vehSpecs':vehSpecs,
            	   		'<portlet:namespace/>selectedProduct':selectedProduct,
            	      	"<portlet:namespace/>natAddress":JSON.stringify(natAddress)
            	   },
               on: {
                    success: function(data)
                    {
                    	var res = this.get('responseData');
                    	if(res.indexOf('success') > -1)
                    	{
                			doPayment(pmntTypeVal);
                    	}
                    	 if(res.indexOf('error') > -1)
                    	{
							alert("error saving address");
                    	}
                    	 if(res.indexOf('ibanError') > -1)
                     	{
 							alert("error iban");
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
		if(productChanged && jsonQuot.productCode == "<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE%>")
			jsonQuot.quoteStatus = "<%=BuyMotorPolicyPortletKeys.QUOTE_STATUS_PENDING_PAYMENT%>";
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
<script>

<%--  function saveImages(){
    AUI().use('aui-io-request', function(A){
        A.io.request('<%=saveImagesresourceURLVal%>',
        	{
               method: 'POST',
               form: {
                   id: 'save_images_form',
                   upload: true
                   
               }
            });
    });
} --%>

<%--  function saveImages()
{ 
	 alert("inside save images");
	var resourceURLSaveImage = '<%= resourceURLSaveImage.toString() %>';
	//var save_images_form = $('#<portlet:namespace/>save_images_form')[0];
	// Create an FormData object
	   $.ajax({
	       type: 'POST',
	       enctype: 'multipart/form-data',
	       url: resourceURLSaveImage,
	       cache: false,
	       data: new FormData($('#saveImagesForm')[0]),
	       traditional: true,
	       contentType: false,
	       processData: false
	   });
} --%>
 
<%--  $('#mailBtn').click(function(e){
		e.preventDefault();
		//$('#<portlet:namespace/>htmlData').val($('#<portlet:namespace/>softwareData').html());
		var mailURL = '<%= mailURL.toString() %>';
		//$('#<portlet:namespace />mailFm').attr('action',mailURL);
		//$('#<portlet:namespace />mailFm').submit();
     // Get form
     var form = $('#<portlet:namespace />mailFm')[0];
		// Create an FormData object
     var data = new FormData(form);
     $.ajax({
         type: "POST",
         enctype: 'multipart/form-data',
         url: mailURL,
         data: data,
         processData: false,
         contentType: false,
         cache: false,
         success: function (data) {alert(data);}
     });
	});
  --%>

</script>
</script>

<%
if(!isUserSignedIn)
{
%>
<script type="text/javascript">
$(document).ready(function(){
$("#thirdparty").click(function() {
	$('#merchant_reference').val('<%=Validator.isNotNull(quotDet) ?  quotDet.getReferenceNo() : "0" %>');
	$('#selectedInsType').val("TP");
    $('#additionalDetails').show();
    /* $('#saveImagesForm').hide(); */
    $('.saveImagesForm').css("display", "none");
    $('#paymentDetTp').show();
    $('#paymentDetCpmo').hide();
});

$("#comprehensive").click(function() {
	$('#merchant_reference').val('<%=quot.getReferenceNo()%>');
	 $('#paymentDetTp').hide();
	 $('#selectedInsType').val("OD");
    $('#additionalDetails').show();
    $('.saveImagesForm').css("display", "block");
    $('#paymentDetCpmo').show();
});
});
</script>
<%
}
%>












