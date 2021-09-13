<%@page import="java.util.Calendar"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.constants.PolicyListPortletKeys"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicleCover"%>
<%@page import="java.util.List"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicleDriver"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.atmc.bsl.db.domain.policy.Policy"%>
<%@ include file="/init.jsp"%>
<%
	Policy policy = (Policy) request.getAttribute("policy");
	PolicyVehicle pVeh = (PolicyVehicle)request.getAttribute("pVeh");
	
	String renewErrorCode = (String)request.getAttribute("errorCode");
	String renewErrorMsg = (String)request.getAttribute("errorMsg");
	
	Gson gson = new Gson();
	String policyDets = gson.toJson(policy);
	policyDets = policyDets.replaceAll("\"", "'");
	
	String policyVehDets = gson.toJson(pVeh);
	policyVehDets = policyVehDets.replaceAll("\"", "'");
	
	long currDateTime =new Date().getTime();
	long toDateTime = policy.getExpiryDate().getTime();
	long daysDiff = (toDateTime - currDateTime)/ (1000 * 60 * 60 * 24);

	String pStatus = policy.getPolicyStatus();
	boolean withinExpiryPeriod = false;
    int daysAfterExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysAfterExp"));
	if(pStatus != null && pStatus.equals("EX") && daysDiff<0)
	{
        int daysTillExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysTillExp"));
		if(Math.abs(daysDiff) <= daysTillExp)
			withinExpiryPeriod = true;
	}
	
%>
<portlet:renderURL var="policyListURL">
	<portlet:param name="myview" value="policy_list"/>
</portlet:renderURL>
<%
	PortletURL scheduleUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	scheduleUrl.setParameter("policyNo", policy.getPolicyNo());
	scheduleUrl.setParameter("vehId", pVeh.getVehId());
	scheduleUrl.setParameter("type", "schedule");
	String scheduleUrlVal = scheduleUrl.toString(); 
	if(scheduleUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		scheduleUrlVal = scheduleUrlVal.substring(0, scheduleUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	
	
	PortletURL certificateUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	certificateUrl.setParameter("policyNo", policy.getPolicyNo());
	certificateUrl.setParameter("vehId", pVeh.getVehId());
	certificateUrl.setParameter("type", "certificate");
	String certificateUrlVal = certificateUrl.toString(); 
	if(certificateUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		certificateUrlVal = certificateUrlVal.substring(0, certificateUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	
	
	PortletURL taxInvoiceUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	taxInvoiceUrl.setParameter("policyNo", policy.getPolicyNo());
	taxInvoiceUrl.setParameter("vehId", pVeh.getVehId());
	taxInvoiceUrl.setParameter("type", "tax");
	String taxInvoiceUrlVal = taxInvoiceUrl.toString(); 
	if(taxInvoiceUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		taxInvoiceUrlVal = taxInvoiceUrlVal.substring(0, taxInvoiceUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	
	
	PortletURL vFleetListingUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	vFleetListingUrl.setParameter("policyNo", policy.getPolicyNo());
	vFleetListingUrl.setParameter("vehId", pVeh.getVehId());
	vFleetListingUrl.setParameter("type", "vehicle_fleet_listing");
	String vFleetListingUrlVal = vFleetListingUrl.toString(); 
	if(vFleetListingUrlVal.indexOf("&p_p_lifecycle=1") != -1)
		vFleetListingUrlVal = vFleetListingUrlVal.substring(0, vFleetListingUrlVal.lastIndexOf("&p_p_lifecycle=1"));
	System.err.println("policy.getPolicyTaxes() >>>> " + policy.getPolicyTaxes());
	System.err.println("policy.getSumInsured()>>>> " + policy.getSumInsured());

%>
<div class="row bg-body">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad">
		<div class="headerBanner">
			<img class="img-responsive"	src="/o/atmc-theme/images/review_quotation_image.png" width="100%" /> 
			<h3 class="text-primary pageTitle"><%=(policy.getProduct().equals(""+PolicyListPortletKeys.PRODUCT_CODE_TPL_VAL))?LanguageUtil.get(request, "tpl_policy_dets"):LanguageUtil.get(request, "od_policy_dets") %></h3>
			<div class="printDownloadsection">
				<a class="btn-link" onclick="self.print();"><i class="material-icons">&#xE8AD;</i>&nbsp;&nbsp;<liferay-ui:message key="print" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="<%=scheduleUrlVal%>"><i class="material-icons">&#xE415;</i>&nbsp;&nbsp;<liferay-ui:message key="download" /></a>
			</div>
		</div>
	</div>
</div>
<div class="row bg-body">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad bg-white">
		<br/>
		<div class="row vcenter">
			<div class="col-md-offset-1 col-md-6 col-lg-6 col-xs-6 col-sm-6">
				<h3><liferay-ui:message key="policy_no"/>&nbsp;<span class="text-muted"><%=policy.getPolicyNo() %></span></h3>
			</div>
			<div class="text-right col-xs-4 col-sm-4 col-md-4 col-lg-4">
				<img src="/o/atmc-theme/images/logo.svg" height="40px" />
			</div>
		</div>
		<div class="row margin-top">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="text-primary"><%=(currLocale.equals("en_US")?pVeh.getMakeEn():pVeh.getMakeAr())+" "+(currLocale.equals("en_US")?pVeh.getModelEn():pVeh.getModelAr()) %><br />
							<small class="text-muted"><%=pVeh.getMfgYear() %></small></td>
							<td class="text-primary"><%=policy.getInsuredName() %></td>
							<td class="text-primary"><%=(currLocale.equals("en_US"))?(pVeh.getEnPlateNo() +" "+pVeh.getEnPlateL1()+" "+pVeh.getEnPlateL2()+" "+pVeh.getEnPlateL3()):(pVeh.getArPlateNo()+pVeh.getArPlateL1()+" "+pVeh.getArPlateL2()+" "+pVeh.getArPlateL3())%></td>
							<td class="<%=(daysDiff >daysAfterExp)?"bg-primary":"bg-danger" %>"><liferay-ui:message key="from"/> <%=dateFormatter.format(policy.getInceptionDate()) %><br><liferay-ui:message key="to"/> <%=dateFormatter.format(policy.getExpiryDate()) %>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
				<div class="portlet-content">
					<h4><liferay-ui:message key="policy_dets"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="policy_status"/></th>
								<td><%=(currLocale.equals("en_US"))?policy.getPolicyStatusEn():policy.getPolicyStatusAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="najm_status"/></th>
								<td><%=pVeh.getNajmStatus()%></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="tot_prem"/></th>
								<td><%=numberFormat.format(policy.getTotalPremium()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_tax"/></th>
								<td><%=(policy.getPolicyTaxes() != null && !policy.getPolicyTaxes().equals(""))?numberFormat.format(Double.valueOf(policy.getPolicyTaxes())):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="sum_insured"/></th>
								<td><%=numberFormat.format(policy.getSumInsured()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="no_claim"/></th>
								<td><%=numberFormat.format(pVeh.getDiscounts()) %></td>
							</tr>
						</tbody>
					</table>
					<h4><liferay-ui:message key="policy_holder_dets"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="id_number"/></th>
								<td><%=policy.getIqamaId() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_name"/></th>
								<td><%=policy.getCustName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_dob"/></th>
								<td><%=(policy.getInsuredBirthDate()!=null)?dateFormatter.format(policy.getInsuredBirthDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_mob"/></th>
								<td><%=policy.getInsuredMobile() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_email"/></th>
								<td><%=policy.getInsuredEmail() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_address"/></th>
								<td><%=policy.getInsuredAddr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="occupation"/></th>
								<td><%=policy.getOccuptation() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="insured_id"/></th>
								<td><%=policy.getInsuredId() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="insured_name"/></th>
								<td><%=policy.getInsuredName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="insured_dob"/></th>
								<td><%=(policy.getInsuredBirthDate()!=null)?dateFormatter.format(policy.getInsuredBirthDate()):"" %></td>
							</tr>
						</tbody>
					</table>
					<h4><liferay-ui:message key="veh_det"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="veh_id_type"/></th>
								<td><%=(currLocale.equals("en_US"))?pVeh.getVehicleDefTypeDesc():pVeh.getVehicleDefTypeDescAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="veh_id_no"/></th>
								<td><%=pVeh.getVehicleSeqCustom() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="chassis_no"/></th>
								<td><%=pVeh.getChassisNo() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="est_exp_date"/></th>
								<td><%=(pVeh.getEstemaraExpiryDate()!=null)?pVeh.getEstemaraExpiryDate():"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="body_type"/></th>
								<td><%=(currLocale.equals("en_US"))?pVeh.getBodyTypeEn():pVeh.getBodyTypeAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="mfg_year"/></th>
								<td><%=pVeh.getMfgYear() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="veh_val"/></th>
								<td><%=numberFormat.format(pVeh.getVehicleValue()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="color"/></th>
								<td><%=(currLocale.equals("en_US"))?pVeh.getColorEn():pVeh.getColorAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="agency_repair"/></th>
								<td><%=(pVeh.getAgencyRepair().equals("0")?(LanguageUtil.get(request,"no")):(LanguageUtil.get(request,"yes"))) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="deductible"/></th>
								<td><%=numberFormat.format(pVeh.getDeductible()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="premium"/></th>
								<td><%=numberFormat.format(pVeh.getPremium()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="discounts"/></th>
								<td><%=numberFormat.format(pVeh.getDiscounts()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="loading"/></th>
								<td><%=pVeh.getLoading() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="tot_prem"/></th>
								<td><%=numberFormat.format(pVeh.getTotalPremium()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="no_claim_yrs"/></th>
								<td><%=pVeh.getNoofClaimFreeYears() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="use_veh"/></th>
								<td><%=(currLocale.equals("en_US"))?pVeh.getUseOfCehicleEn():pVeh.getUseOfCehicleAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="najm_plate_type"/></th>
								<td><%=(currLocale.equals("en_US"))?pVeh.getNajmPlateTypeEn():pVeh.getNajmPlateTypeAr()%></td>
							</tr>
						</tbody>
					</table>
		<%
			List vehicleCovers = pVeh.getVehicleCovers();
			if(vehicleCovers != null && !vehicleCovers.isEmpty())
			{
		%>
					<h4><liferay-ui:message key="add_covers"/></h4>
		<%
				for(int cCount=0;cCount<vehicleCovers.size();cCount++)
				{
					PolicyVehicleCover cover = (PolicyVehicleCover)vehicleCovers.get(cCount);
		%>				
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="description"/></th>
								<td><%=cover.getDescription() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="ben_term"/></th>
								<td><%=cover.getBenefitTerm() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="tot_prem"/></th>
								<td><%=numberFormat.format(cover.getPremium()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="sum_coverd"/></th>
								<td><%=numberFormat.format(cover.getSumCovered()) %></td>
							</tr>
						</tbody>
					</table>
		<%
				}
			}
		
			List vehicleDrivers = pVeh.getVehicleDrivers();
			if(vehicleDrivers!= null && !vehicleDrivers.isEmpty())
			{
				
		%>
					<h4><liferay-ui:message key="add_driver"/></h4>
		<%
				for(int dCount=0;dCount<vehicleDrivers.size();dCount++)
				{
					PolicyVehicleDriver driver = (PolicyVehicleDriver)vehicleDrivers.get(dCount);
		%>			
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="driver_name"/></th>
								<td><%=driver.getDriverName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="driver_id_lic_no"/></th>
								<td><%=driver.getDriverLicenseNo() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="driver_dob"/></th>
								<td><%=(driver.getDriverBirthDate()!=null)?dateFormatter.format(driver.getDriverBirthDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="driver_nat"/></th>
								<td><%=currLocale.equals("en_US")?driver.getDriverNationalityEn():driver.getDriverNationalityAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="driver_gender"/></th>
								<td><%=currLocale.equals("en_US")?driver.getDriverGenderEn():driver.getDriverGenderAr() %></td>
							</tr>
						</tbody>
					</table>
		<%
				}
			}
		%>			
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-right no-pad">
				<ul class="list-btns">
				<%
					if(pVeh.getNajmStatus().equals("Success"))
					{
				%>
					<li class="pull-left">
						<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="${policyListURL}">
							<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
						</a>
					</li>
					<li>
						<div class="dropup">
							<button  class="btn btn-default dropdown-toggle btn-lg" type="button" id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false"> <liferay-ui:message key="download_docs"/> <span class="caret"></span> </button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
								<li><a href="<%=scheduleUrlVal%>"><liferay-ui:message key="policy_scehd"/></a></li>
								<li><a href="<%=taxInvoiceUrlVal%>"><liferay-ui:message key="ta_invoice"/></a></li>
								<li><a href="<%=certificateUrlVal%>"><liferay-ui:message key="policy_cert"/></a></li>
								<li><a href="<%=vFleetListingUrlVal%>"><liferay-ui:message key="veh_fleet_list"/></a></li>
							</ul>
						</div>
					</li>
				<%
					}
				%>
					<li>
						<button class="btn btn-lg btn-xs-block btn-default" type="button" onclick="window.location='/group/customer/customer_service';"><liferay-ui:message key="service_req"/></button>
					</li>
					<li>
						<button style="pointer-events: none" class="btn btn-primary btn-lg btn-xs-block" type="button" onclick="renewPolicy();" <%=(daysDiff>daysAfterExp||(pStatus.equals("EX")&& !withinExpiryPeriod))?"disabled":"" %>><liferay-ui:message key="renew"/></button>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>


<%
	String pageName="/buy_motor_policy";
	long buyMotorPlid = 0L;
	String motorPortletId = BuyMotorPolicyPortletKeys.BUYMOTORPOLICY;
	try
	{
		System.out.println("current page name ---------------------- "+themeDisplay.getLayout().getName());
		Layout motorPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, pageName);
		LayoutTypePortlet buyMotorLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(motorPortletLayout);
		motorPortletId = buyMotorLayoutTypePortlet.getPortletIds().get(0);
		buyMotorPlid = motorPortletLayout.getPlid();
		System.out.println("Pliid==>"+buyMotorPlid);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	PortletURL renewUrl = PortletURLFactoryUtil.create(request, motorPortletId, buyMotorPlid, PortletRequest.ACTION_PHASE);
	renewUrl.setWindowState(WindowState.NORMAL);
	renewUrl.setPortletMode(PortletMode.VIEW);
	renewUrl.setParameter(ActionRequest.ACTION_NAME, "renewPolicy");
	
	String buyMotorPortletNamespace = PortalUtil.getPortletNamespace(BuyMotorPolicyPortletKeys.BUYMOTORPOLICY); 
	//renewUrl.setParameter("policy", policyDets);
%>
<form id="renewQuotForm" name="renewQuotForm" role="form" action="<%=renewUrl.toString() %>" method="post">
	<input type="hidden" name="policyNo" value="<%=policy.getPolicyNo() %>"/>
	<input type="hidden" name="policyVehId" value="<%=pVeh.getVehId() %>"/>
	<input type="hidden" name="oldVehMfg" value="false"/>
	<input type="hidden" name="myview" value="quotation"/>
</form>
<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
<%
	if(renewErrorCode != null && renewErrorCode.equals(""+BuyMotorPolicyPortletKeys.YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED))
	{
%>	
	<div class="row">
		<div class="col-md-12"><%=renewErrorMsg%></div>
	</div>
	<br/>
	<div class="row vcenter">
		<div class="col-md-5">
			<div class="btn btn-primary btn-lg btn-xs-block" onclick="window.open('https://address.gov.sa/en/e-services/register-your-address')">
				Register National Address
			</div>
		</div>
		<div class="col-md-7">
			Note: this button will redirect you away from ATMC
		</div>
	</div>
<%
	}
	else
	{
%>
	<div>
		<h4 style="overflow-wrap:break-word;"><%=(renewErrorCode !=null && !renewErrorCode.equals("") && renewErrorMsg !=null && !renewErrorMsg.equals(""))?(renewErrorCode.equals(""+BuyMotorPolicyPortletKeys.YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED))?renewErrorMsg:(renewErrorCode+": "+renewErrorMsg):"" %></h4>
	</div>
<%
	}
%>
</div>
<div id="aui_renew_popup_body" style="display:none;">
	<div class="text-center">
		<h4 style="overflow-wrap:break-word;"><%=LanguageUtil.get(request, "old_veh_mfg_renew") %></h4>
	</div>
	<br/>
	<div class="row">
        <div class="col-md-12 text-center">
        	<button class="btn btn-primary btn-lg btn-xs-block" type="button" onclick="renewProceed();"><liferay-ui:message key="ok"/></button>
        	<button class="btn btn-default btn-lg btn-xs-block" type="button" onclick="$('.close').click().click();"><liferay-ui:message key="cancel"/></button>
        </div>
    </div>
</div>

<script>
var errorCode = '<%=renewErrorCode%>';
var errorMsg = '<%=renewErrorMsg%>';
if(errorCode != "null" && errorMsg!="null")
{
	AUI().use('aui-modal', function(A) {
		var dialog = new A.Modal({
			title: "Error",
			bodyContent: $('#aui_popup_body').html(),
			headerContent: '<h4 class="no-margin <%=(renewErrorCode != null && renewErrorCode.equals(""+BuyMotorPolicyPortletKeys.YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED))?"text-primary":""%>"><%=(renewErrorCode != null && renewErrorCode.equals(""+BuyMotorPolicyPortletKeys.YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED))?"National Address Missing":"Error"%></h4>',
			centered: true,
			modal: true,
			height: 200,
			render: '#aui_popup_content'
		});
		dialog.render();
	});
}
function renewPolicy()
{
	if(<%=policy.getProduct().equals(""+PolicyListPortletKeys.PRODUCT_CODE_COMPREHENSIVE_VAL) && (pVeh.getMfgYear()<Calendar.getInstance().get(Calendar.YEAR) && Calendar.getInstance().get(Calendar.YEAR)-pVeh.getMfgYear()>=10)%>)
	{
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "Error",
				bodyContent: AUI().one('#aui_renew_popup_body').html(),
				headerContent: '<h4 class="no-margin text-primary">Error</h4>',
				centered: true,
				modal: true,
				height: 225,
				render: '#aui_popup_content'
			});
			dialog.render();
		});
	}
	else
		$('#renewQuotForm').submit();
}
function renewProceed()
{
	$('#renewQuotForm').find("input[name='oldVehMfg']").val("true");
	$('#renewQuotForm').submit();
}
</script>