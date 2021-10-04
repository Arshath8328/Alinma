<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="java.sql.Blob"%>
<%@page import="com.ejada.atmc.acl.db.model.QuotationSurvey"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationDriver"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationCustUploads"%>
<%@page import="com.atmc.bsl.db.service.QuotationLocalServiceUtil"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationAdminUpload"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationCover"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationHistory"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="/init.jsp" %>
 
<%
Log _log = LogFactoryUtil.getLog(this.getClass());

Quotation quotation = (Quotation) request.getAttribute("quotation");
String najmStatus = "";
_log.info("Retrieving uploads of quotation:" + quotation.getQuotationId() + " with ref:" + quotation.getReferenceNo());
QuotationCustUploads uploads=QuotationLocalServiceUtil.getCustomQuotationCustUploads(quotation.getQuotationId()+"");
_log.info("Lease File Name:" + uploads.getLeaseFileName());

String currLocale = themeDisplay.getLocale().toString();

String pattern = "##.##";
DecimalFormat decimalFormat = new DecimalFormat(pattern);

//TT #457
if((quotation.getPolicyNo() != null && !quotation.getPolicyNo().equals("")) 
		&& (quotation.getQuoteStatus() != null && quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.POLICY_STATUS_ACTIVE)))
{
	najmStatus = QuotationLocalServiceUtil.getNajmStatusByPolicyNo(quotation.getPolicyNo());
}

boolean isOD = quotation.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) ? true : false;
boolean isIstimara = (String.valueOf(quotation.getVehicleIdType())).equals(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD) ? true : false;
boolean isCustomCard = (String.valueOf(quotation.getVehicleIdType())).equals(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD) ? true : false;
boolean isTOO = (String.valueOf(quotation.getVehicleIdType())).equals(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD) ? true : false;

String statusClass = "text-success";
if(quotation.getQuoteStatus().equals("PA"))
	statusClass = "text-success";
else if(quotation.getQuoteStatus().equals("RJ"))
	statusClass = "text-danger";
else 
	statusClass = "text-warning";
%>

<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>
<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="policy_details"/></h1>
<div class="container-fluid-1280">
	<h3 class="pull-right"><i class="material-icons <%=statusClass%>">&#xE061;</i><%=LanguageUtil.get(request,quotation.getQuoteStatus())%></h3>
	<div class="tab">
		<ul class="nav nav-tabs">
			<li class="active">
				<a href="#tab-1" role="tab" data-toggle="tab"><liferay-ui:message key="policy_request"/></a>
			</li>
			<li>
				<a href="#tab-2" role="tab" data-toggle="tab"><liferay-ui:message key="track_history"/></a>
			</li>
		</ul>
	</div>
	<div class="tab-content bg-white pad-10">
		<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
			<table class="table table-bordered">
				<tr> 
					<td width="25%">
						<liferay-ui:message key="quote_ref"/> <span class="text-primary"><%=quotation.getReferenceNo()%></span><br/>
						<liferay-ui:message key="policy_no"/> <span class="text-primary"><%=(!quotation.getPolicyNo().equals(""))?quotation.getPolicyNo():LanguageUtil.get(request,"policy_not_issues")%></span>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="requested_by"/></span><br/>
						<%=quotation.getInsuredName()%>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="vehicle_type_V"/></span><br/>
						<%=quotation.getVehicleMakeEn()%>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="date_received"/></span><br/>
						<%=quotation.getQuoteSubmissionDate() != null ? quotation.getQuoteSubmissionDate() : ""%>
					</td> 
				</tr>
			</table>
			<h4 class="text-primary"><liferay-ui:message key="policy_details"/></h4>
			<table class="table table-bordered"> 
				<tr> 
					<td width="40%"><liferay-ui:message key="product"/></td> 
					<td width="60%" class="text-muted"><%=quotation.getProductCode()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_status"/></td> 
					<td class="text-muted"><%=LanguageUtil.get(request,quotation.getQuoteStatus())%></td> 
				</tr>	
				<tr> 
					<td><liferay-ui:message key="tot_prem"/></td> 
					<td class="text-muted"><%=decimalFormat.format(quotation.getGrossPrem())%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_tax"/></td> 
					<td class="text-muted"><%=quotation.getPolicyTaxes()*100%>%</td>
				</tr>
				<%
					if(najmStatus != null && !najmStatus.equals("") && !quotation.getPolicyNo().equals(""))
					{
				 %>
						<tr> 
							<td><liferay-ui:message key="najmStatus"/></td> 
							<td class="text-muted"><%=najmStatus%></td>
						</tr>
				<%
					}
				%>
															 
			</table>
			<h4 class="text-primary"><liferay-ui:message key="policy_holder_details"/></h4>
			<table class="table table-bordered">
				<tr> 
					<td width="40%"><liferay-ui:message key="id_number"/></td> 
					<td width="60%" class="text-muted"><%=quotation.getInsuredId()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_name"/></td> 
					<td class="text-muted"><%=quotation.getInsuredName()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_dob"/></td> 
					<%
						SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
					%> 
					 <td class="text-muted"><%=dmyDateFormatter.format(quotation.getInsuredDob()) %></td>
				</tr>	
				<tr> 
					<td><liferay-ui:message key="policy_holder_mob"/></td> 
					<td class="text-muted">0<%=quotation.getInsuredMobile()%></td>  
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_email"/></td> 
					<td class="text-muted"><%=quotation.getInsuredEmail()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_address"/></td> 
					<td class="text-muted">
						<%=quotation.getAddressBuildingNo()%> <%=quotation.getAddressUnitNo()%> <%=quotation.getAddressStreet()%> <%=quotation.getAddressDistrict()%> <%=quotation.getCity()%> <%=quotation.getAddressZipCode()%> <%=quotation.getAddressAddNo()%>
					</td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="insured_id"/></td> 
					<td class="text-muted"><%=quotation.getInsuredId()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="insured_name"/></td> 
					<td class="text-muted"><%=quotation.getInsuredName()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="insured_dob"/></td> 
					<td class="text-muted"><%=dmyDateFormatter.format(quotation.getInsuredDob()) %></td> 
				</tr>	
				<tr> 
					<td><liferay-ui:message key="est_exp_date"/></td> 
					<td class="text-muted"><%=quotation.getVehicleEstExpiryDate() != null ? dmyDateFormatter.format(quotation.getVehicleEstExpiryDate()) : ""%></td> 
				</tr>										 
			</table>
			<h4 class="text-primary"><liferay-ui:message key="veh_det"/></h4>
			<table class="table table-bordered"> 
				<tr> 
					<td width="40%">
						<liferay-ui:message key="veh_id_type"/>
					</td> 
					<td width="60%" class="text-muted">
						<%
							String vehType = String.valueOf(quotation.getVehicleIdType());
							String vIdtype = "";
							if(vehType.equals(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD))
								vIdtype = LanguageUtil.get(request,"ist_card");
							else if(vehType.equals(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))
								vIdtype = LanguageUtil.get(request,"cust_card");
							else if(vehType.equals(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))
								vIdtype = LanguageUtil.get(request,"trns_owner");
						%>
						<%=vIdtype%>
					</td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="veh_id_no"/></td> 
					<td class="text-muted"><%=quotation.getVehicleId()%></td>
				</tr>	
				<tr> 
					<td><liferay-ui:message key="chassis_no"/></td> 
					<td class="text-muted"><%=quotation.getVehicleChassisNo()%></td>  
				</tr>
				<tr> 
					<td><liferay-ui:message key="body_type"/></td> 
					<td class="text-muted"><%=quotation.getVehicleBodyTypeEn()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="mfg_year"/></td> 
					<td class="text-muted"><%=quotation.getVehicleMfgYear()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="veh_val"/></td> 
					<td class="text-muted"><%=quotation.getVehicleValue() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="color"/></td> 
					<td class="text-muted"><%=quotation.getVehicleColorEn()%></td>
				</tr>
				<%
					if(quotation.getAgencyRepair() !=null)
					{
				%>
						<tr> 
							<td><liferay-ui:message key="repair_options"/></td> 
							<td class="text-muted">
							<%
								if(quotation.getAgencyRepair().equals("1"))
								{
							%>
									<liferay-ui:message key="agency"/>
							<%
								}
								else if(quotation.getAgencyRepair().equals("0"))
								{
							%>
									<liferay-ui:message key="non_agency"/>
							<%	
								}
							%>
							</td> 
						</tr>
				<%
					}
				%>
				<tr> 
					<td><liferay-ui:message key="deductible"/></td> 
					<td class="text-muted"><%=quotation.getDeductibleValue()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="premium"/></td> 
					<td class="text-muted"><%=decimalFormat.format(quotation.getNetPrem())%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="discounts"/> + <liferay-ui:message key="loyalty"/></td> 
					<td class="text-muted"><%=quotation.getDiscountAmount()%> + <%=quotation.getLoyaltyDiscount()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="loading"/></td> 
					<td class="text-muted"><%=quotation.getLoadingAmount() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="tot_prem"/></td> 
					<td class="text-muted"><%=quotation.getGrossPrem() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="no_claim_yrs"/></td> 
					<td class="text-muted"><%=quotation.getNcdYears()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="use_veh"/></td> 
					<td class="text-muted"><%=quotation.getPurposeOfVehicleDesc()%></td>
				</tr>
				<% 
					if((isIstimara || isTOO) && isOD)
					{
				%>
				<tr> 
							<td><liferay-ui:message key="car_front_image"/></td> 
					<td class="text-muted">
								<portlet:resourceURL var="carFrontURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="carFront"/>
							<portlet:param name="fileName" value="<%=quotation.getReferenceNo() + "-Car Front Image" %>"/>
							<portlet:param name="originalFileName" value="<%=uploads.getCarFrontFileName() %>"/>
						 </portlet:resourceURL>
								<liferay-ui:message key="car_front_image"/>
								<a href="${carFrontURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<tr> 
							<td><liferay-ui:message key="car_back_image"/></td> 
					<td class="text-muted">
								<portlet:resourceURL var="carBackURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="carBack"/>
							<portlet:param name="fileName" value="<%=quotation.getReferenceNo() + "-Car Back Image" %>"/>
							<portlet:param name="originalFileName" value="<%=uploads.getCarBackFileName() %>"/>
						 </portlet:resourceURL>
								<liferay-ui:message key="car_back_image"/>
								<a href="${carBackURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<tr> 
							<td><liferay-ui:message key="car_right_image"/></td> 
					<td class="text-muted">
								<portlet:resourceURL var="carRightURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="carRight"/>
							<portlet:param name="fileName" value="<%=quotation.getReferenceNo() + "-Car Right Image"  %>"/>
							<portlet:param name="originalFileName" value="<%=uploads.getCarRightFileName() %>"/>
						 </portlet:resourceURL>
								<liferay-ui:message key="car_right_image"/>
								<a href="${carRightURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<tr> 
							<td><liferay-ui:message key="car_left_image"/></td> 
					<td class="text-muted">
								<portlet:resourceURL var="carLeftURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="carLeft"/>
							<portlet:param name="fileName" value="<%=quotation.getReferenceNo() + "-Car Left Image"  %>"/>
							<portlet:param name="originalFileName" value="<%=uploads.getCarLeftFileName() %>"/>
						 </portlet:resourceURL>
								<liferay-ui:message key="car_left_image"/>
								<a href="${carLeftURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
<%
				if(uploads.getEngineChassisNoFileName()!=null && !uploads.getEngineChassisNoFileName().equals(""))
				{
%>										 
				<tr> 
							<td><liferay-ui:message key="eng_chassis_image"/></td> 
							<td class="text-muted">
								<portlet:resourceURL var="engChassisURL">
								 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
								 	<portlet:param name="cust" value="true"/>
								 	<portlet:param name="type" value="engChassis"/>
								 	<portlet:param name="fileName" value="<%=quotation.getReferenceNo() + "-Engine Chassis Image"  %>"/>
								 	<portlet:param name="originalFileName" value="<%=uploads.getEngineChassisNoFileName() %>"/>
								 </portlet:resourceURL>
								<liferay-ui:message key="eng_chassis_image"/>
								<a href="${engChassisURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
							</td>
						</tr>	
				<%
				}
			}
				%>									 
		</table>
<%
_log.info("cover"+quotation.getCoversList());
if(!quotation.getCoversList().isEmpty())
{
	_log.info("cover size"+quotation.getCoversList().size());
	
	List <QuotationCover> coverlist=quotation.getCoversList();
	
	for (int i=0;i<coverlist.size();i++)
	{
		QuotationCover cover=coverlist.get(i);
 %>
			<h4 class="text-primary"><liferay-ui:message key="additional_covers"/></h4>
			<table class="table table-bordered"> 
				<%
					if(!quotation.getPolicyNo().equals("")){
				 %>
						<tr> 
							<td><liferay-ui:message key="ben_term"/></td> 
							<td class="text-muted"><%=cover.getBenfTerm()%></td>
						</tr>
				<%
					}
				%>
				<tr> 
					<td><liferay-ui:message key="tot_prem"/></td> 
					<td class="text-muted"><%=cover.getCoverPrem() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="sum_coverd"/></td> 
					<td class="text-muted"><%=cover.getCoverSi()%></td>
				</tr>	
				<tr> 
					<td><liferay-ui:message key="description"/></td> 
					<td class="text-muted"><%=currLocale.equals("en_US") ? cover.getCoverDesc():cover.getCoverDescAr()%></td>
				</tr>
		</table>
<%
 	}
}
%>
<%
	if(quotation.getQuotationDrivers()!=(null)&& !quotation.getQuotationDrivers().isEmpty() &&quotation.getQuotationDrivers().get(0)!=null)
	{

 %>
		<h4 class="text-primary"><liferay-ui:message key="additional_driver"/></h4><br/>
<%
		for(int i = 0 ; i < quotation.getQuotationDrivers().size(); i++)
		{
			QuotationDriver driver = quotation.getQuotationDrivers().get(i);
			if(driver != null)
			{
 %>
				<h5 class="text-primary"><liferay-ui:message key="driver"/> <%=i %></h5>
			<table class="table table-bordered">
				<tr>
					<td width="40%"><liferay-ui:message key="driver_name"/></td>
						<td width="60%" class="text-muted"><%=driver.getDriverName() %></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_id_lic_no"/></td>
						<td class="text-muted"><%=driver.getDriverId() %></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_dob"/></td>
						<td class="text-muted"><%=driver.getDriverDob() %></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_nat"/></td>
						<td class="text-muted"><%=currLocale.equals("en_US")?driver.getDriverNationalityDescEN():driver.getDriverNationalityDescAR() %></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_gender"/></td>
						<td class="text-muted"><%=driver.getDriverGender().equals("M")?LanguageUtil.get(request,"male"):LanguageUtil.get(request,"female") %></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="rel"/></td>
						<td class="text-muted"><%=LanguageUtil.get(request, "INSURED_RELATION_" + driver.getInsuredRelative()) %></td>
					</tr>
					<%
						if(driver.getInsuredRelative() !=null && !driver.getInsuredRelative().equals("") && !driver.getInsuredRelative().equals("-1"))
						{
					%>
							<tr>
								<td><liferay-ui:message key="rel_proof"/></td>
								<td class="text-muted">
									<portlet:resourceURL var="relProofURL">
								 		<portlet:param name="fileId" value="<%=driver.getAddDriverId()+"" %>"/>
								 		<portlet:param name="cust" value="true"/>
									 	<portlet:param name="type" value="relationProof"/>
									 	<portlet:param name="fileName" value="<%=driver.getRelationProofFileName() %>"/>
								 	</portlet:resourceURL>
								 	<%=driver.getRelationProofFileName() %>
									<a href="${relProofURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
										
								</td>
					<td class="text-muted"><%=quotation.getQuotationDrivers().get(0).getDriverGender().equals("M")?LanguageUtil.get(request,"male"):LanguageUtil.get(request,"female")%></td>
				</tr>
					<%
						}
					%>
			</table>
<%
			}
		}
	}
%>
<%

_log.info("Uploads:" + uploads);
if(uploads!=null)
{
	_log.info("We have uploads");

 %>
			<h4 class="text-primary"><liferay-ui:message key="attchements"/></h4>
			<table class="table table-bordered">
				<%
					if(uploads.getIdFileName() !=null && !uploads.getIdFileName().equals(""))
					{
				%>
				<tr>
					<th class="bg-gray" width="40%"><liferay-ui:message key="id"/></th>
					<td width="60%">
								 <portlet:resourceURL var="idFileURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="id"/>
								 	<portlet:param name="fileName" value="<%=uploads.getIdFileName() %>"/>
						 </portlet:resourceURL>
						 <%=uploads.getIdFileName() %>
								 <a href="${idFileURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<%
					}
					if(uploads.getLicenseFileName() !=null && !uploads.getLicenseFileName().equals(""))
					{
				%>
				<tr>
					<th class="bg-gray"><liferay-ui:message key="driver_licsence"/></th>
					<td>
								<portlet:resourceURL var="licFileURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
						 	<portlet:param name="type" value="license"/>
								 	<portlet:param name="fileName" value="<%=uploads.getLicenseFileName() %>"/>
						 </portlet:resourceURL>
						 <%=uploads.getLicenseFileName() %>
								<a href="${licFileURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<%
					}
					if((isCustomCard || isIstimara ) && isOD && uploads.getIstFileName()!=null && !uploads.getIstFileName().equals(""))
					{
				%>
				<tr>
				<%
						if(isCustomCard)
						{
				%>
					<th class="bg-gray"><liferay-ui:message key="cust_card"/></th>
				<%
						}
						else if(isIstimara)
						{
				%>
					<th class="bg-gray"><liferay-ui:message key="police_report"/></th>
				<%
						}
				%>
					<td>
								<portlet:resourceURL var="istFileURL">
						 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
						 	<portlet:param name="cust" value="true"/>
								 	<portlet:param name="type" value="custCard"/>
								 	<portlet:param name="fileName" value="<%=uploads.getIstFileName() %>"/>
						 </portlet:resourceURL>
						 <%=uploads.getIstFileName() %>
								<a href="${istFileURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
							</td>
						</tr>
				<%
					}
					if(isTOO && uploads.getLeaseFileName() !=null && !uploads.getLeaseFileName().equals(""))
					{
				%>
						<tr>
							<th class="bg-gray"><liferay-ui:message key="lease_image"/></th>
							<td>
								<portlet:resourceURL var="leaseFileURL">
								 	<portlet:param name="fileId" value="<%=uploads.getId()+"" %>"/>
								 	<portlet:param name="cust" value="true"/>
								 	<portlet:param name="type" value="leaseFile"/>
								 	<portlet:param name="fileName" value="<%=uploads.getLeaseFileName() %>"/>
								 </portlet:resourceURL>
								 <%=quotation.getLeaseFileName() %>
								<a href="${leaseFileURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
					</td>
				</tr>
				<%
					}
					List<QuotationSurvey> surveyVideoList = null;
					long surveyID = 0L;
					String videoName = null;
					try
					{
						_log.info("Checking if we have video. Quote Status:" + quotation.getQuoteStatus());
						if(quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE))
						{
							surveyVideoList = QuotationLocalServiceUtil.findQuotationSurveyVideo(quotation.getReferenceNo());
							if(surveyVideoList != null && surveyVideoList.size() > 0 )
							{	_log.info("We have video to display");
								surveyID = surveyVideoList.get(0).getSurveyId();
								videoName = surveyVideoList.get(0).getSurveyVideoFileName();
							}
						}
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
					if(surveyVideoList != null && surveyVideoList.size() > 0 && quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE))
					{
				%>
						<tr>
							<th class="bg-gray"><liferay-ui:message key="video_survey"/></th>
							<td>
							<portlet:resourceURL var="surveyVideoURL">
								<portlet:param name="quoteID" value="<%=quotation.getReferenceNo() %>"/>
								<portlet:param name="type" value="video"/>
								<portlet:param name="fileName" value="<%=videoName %>"/>
								<portlet:param name="videoID" value="<%=String.valueOf(surveyID) %>"/>
							</portlet:resourceURL>
							
							
							<a href="javascript:void(0)" onclick="viewVideoinNewTab()"><liferay-ui:message key="see_video"/></a>
							<a href="${surveyVideoURL}"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
							</td>
						</tr>
				<%
					}
				%>			
			</table>
<%} %>
<portlet:actionURL var="submitFileAction" name="submitFile">
<portlet:param name="myview" value="details"/>
<portlet:param name="quotationId" value="<%=quotation.getQuotationId()+"" %>"/>
</portlet:actionURL>

			<aui:form action="<%= submitFileAction %>" method="post" enctype="multipart/form-data" id="uploadForm" name="uploadForm" cssClass="form-inline" label="">
				<aui:fieldset label="" cssClass="row">
					<div class="col-md-12">
						<div class="form-group has-feedback"> 
							<input id="selectedFile" class="form-control" onclick="$('#<portlet:namespace/>adminFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
							<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
						</div>
						<input class="btn btn-default" type="submit" id="<portlet:namespace/>uploadBtn" name="<portlet:namespace/>uploadBtn"  disabled="disabled" value='<liferay-ui:message key="upload"/>' />
						<br/>
						<aui:input type="file" name="adminFile" id="adminFile" cssClass="sr-only" label="" onChange="selectFile($(this))">
							<aui:validator name="required" errorMessage='Please Choose a File' />
							<aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
                            <%--<aui:validator name="custom" errorMessage="max_upload_size">
                                    function(val,node,junction){
                                    	var uploadSize=true;
                                    	var size=0;
                                    	var fileInput = document.getElementById("<portlet:namespace/>adminFile");
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
			                        	var fileInput = document.getElementById("<portlet:namespace/>adminFile");
										var fileName = "";
											if(fileInput.files.length>0)
												fileName = fileInput.files.item(0).name;
										var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
										return regex.test(fileName);
									}
			                   </aui:validator>
						</aui:input>
					</div>
				</aui:fieldset>
				<liferay-captcha:captcha url="<%=captchaURL%>" />
			</aui:form>

<h4 class="text-primary"><liferay-ui:message key="uploaded_attchements"/></h4>
<%
if(quotation.getAdminFilesUplods()!=null){
	List <QuotationAdminUpload> adminUploadFile=quotation.getAdminFilesUplods();
	for (int i=0;i<adminUploadFile.size();i++){
		QuotationAdminUpload file=adminUploadFile.get(i);
 
 %>
 <portlet:actionURL var="deleteFileAction" name="deleteFile">
	<portlet:param name="myview" value="details"/>
	<portlet:param name="fileId" value="<%=file.getId()+"" %>"/>
	<portlet:param name="quotationId" value="<%=quotation.getQuotationId()+"" %>"/>
</portlet:actionURL>
 <portlet:actionURL var="dowmloadFileAction" name="downloadFile">
	<portlet:param name="myview" value="details"/>
	<portlet:param name="fileId" value="<%=file.getId()+"" %>"/>
	<portlet:param name="quotationId" value="<%=quotation.getQuotationId()+"" %>"/>
</portlet:actionURL>
 <portlet:resourceURL var="downloadURL">
 	<portlet:param name="fileId" value="<%=file.getId()+"" %>"/>
 	<portlet:param name="cust" value="false"/>
 </portlet:resourceURL>
<form  action="<%= deleteFileAction %>" method="post" enctype="multipart/form-data" >
 <table class="table"> 
		<tr> 
			<td>
				<%=file.getFileName()%>
				<a href="<%= downloadURL %>"><i class="material-icons md-36 pull-right text-primary">&#xE2C4;</i></a>
				<a href="<%= deleteFileAction %>"><i class="material-icons md-36 pull-right text-danger">delete_outline</i></a>
			</td>
		</tr>
	</table>	
</form>
<%
 }
}
%>
	<div class="row">
		<div class="col-md-12">
			<ul class="list-btns text-right">
				<li class="pull-left">
					<a class="btn btn-lg btn-xs-block btn-link text-muted" role="button" onclick="window.history.go(-1); return false;">
						<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
					</a>
				</li>
				<li>
					<a role="button" class="btn btn-lg" onClick="Print();"><i class="material-icons text-primary md-36">&#xE8AD;</i></a>
				</li>
				<li>
				   
					<portlet:actionURL var="rejectURL" name="rejectQuotation" >
						<portlet:param name="quotationId"  value="<%=quotation.getQuotationId()+""%>"/>
						<portlet:param name="quotationStatus"  value="<%=quotation.getQuoteStatus()+""%>"/>
					</portlet:actionURL>
				  	<% if(quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTE_STATUS_PENDING_SURVEY) || quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE)){ %>

						<a role="button" id="rejectQuot" class="btn btn-danger btn-outline btn-lg" href="javascript:void(0)"><liferay-ui:message key="reject"/></a>
					<%} %>
				</li>
				<li>
					
					<portlet:actionURL var="acceptURL" name="acceptQuotation">
						<portlet:param name="quotationId" value="<%=quotation.getQuotationId()+""%>"/>
						<portlet:param name="insName" value="<%=quotation.getInsuredName()%>"/>
						<portlet:param name="insEmail" value="<%=quotation.getInsuredEmail()%>"/>
						<portlet:param name="insMobile" value="<%=quotation.getInsuredMobile()%>"/>
					</portlet:actionURL>
					<%if(quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTE_STATUS_PENDING_SURVEY) || quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE)){ %>
			
						<a class="btn btn-primary btn-lg" id="acceptQuot" type="button"  href="javascript:void(0)" ><liferay-ui:message key="approve"/></a>
					<%} %>
				</li>
				
			</ul>
		</div>
	</div>
</div>
		<div class="tab-pane fade" role="tabpane2" id="tab-2">
<div class="panel-group cover-type-group" id="accordion">
<% 
if(quotation.getQuotationHistory()!=null && quotation.getQuotationHistory().size() > 0){
	List <QuotationHistory> quotationHistory=quotation.getQuotationHistory();
	for (int i=0;i<quotationHistory.size();i++){
		QuotationHistory quoHistory=quotationHistory.get(i);
		boolean isReason = (quoHistory.getReason() != null && !quoHistory.getReason().equals(""));
%>

	<div class="panel panel-default">
		<div class="panel-heading" role="tab">
			<h4 class="panel-title"> 
				<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" href="<%=isReason ? "#accordion-" + i : "javascript:void(0)" %>" class="accordion-toggle collapsed">
					Staff User :<%=quoHistory.getStatus() %><br/>
					<%=quoHistory.getDateTime() %>
				</a>
			</h4>
		</div>
		<%
			if(isReason)
			{
		%>
			<div class="panel-collapse collapse" id="accordion-<%=i%>" role="tabpanel">
				<div class="panel-body">
					<p> <%=quoHistory.getReason() %></p>
				</div>
			</div>
		<%
			}
		%>
	</div>
<%
	}
}
%>
	
</div>
</div>
	</div>
</div> 


<div id="accept_popup_content"></div>
<div id="accept_popup_body" style="display:none;">
		<form method="post" >
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12">
					<h4 class="text-primary text-left"><liferay-ui:message key="accept_new_policy"/></h4>
					<div class="form-group text-left"> 
						<label class="control-label" for="formInput56"><liferay-ui:message key="rems"/></label>
							<aui:input type="Text" name="reason" label="" class="form-control" value="">
						</aui:input>
					</div>	
						 
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<a role="button" class="btn btn-primary btn-lg btn-xs-block" href="${acceptURL.toString()}" id="confirmBtn"><liferay-ui:message key="confirm" /></a>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</form>

</div>

<div id="reject_popup_content"></div>
<div id="reject_popup_body" style="display:none;">
		<aui:form method="post" action="${rejectURL.toString()}">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12 text-left">
					<label class="control-label" for="formInput56"><liferay-ui:message key="reason_rej"/></label>
					<aui:select  id="reason" name="reason" cssClass="form-control" label="">
						<aui:option value="0,0"><liferay-ui:message key="reject_reason_0" /></aui:option>
						<%
							if(quotation.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_PENDING_SURVEY_APPROVE))
							{
						%>
								<aui:option value="1,1"><liferay-ui:message key="reject_reason_1" /></aui:option>
								<aui:option value="2,1"><liferay-ui:message key="reject_reason_2" /></aui:option>
								<aui:option value="3,1"><liferay-ui:message key="reject_reason_3" /></aui:option>
								<aui:option value="4,1"><liferay-ui:message key="reject_reason_4" /></aui:option>
								<aui:option value="5,1"><liferay-ui:message key="reject_reason_5" /></aui:option>
								<aui:option value="6,1"><liferay-ui:message key="reject_reason_6" /></aui:option>
						<%
							}
						%>
						<aui:validator name="required" errorMessage="required_field_validator"/>
					</aui:select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<button role="button" class="btn btn-primary btn-lg btn-xs-block" type="submit" id="submitBtn"><liferay-ui:message key="confirm" /></button>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</aui:form>

</div>

<script>
console.log('<portlet:namespace/>');
function selectFile() {
	var obj = document.getElementById("<portlet:namespace />adminFile"); 
	if(obj.files !=null  && obj.files.length > 0)
	{
		$("[id*='uploadBtn']").attr('disabled' , false);
		$('[id*="selectedFile"]').val(obj.files.item(0).name);
	}
	else
	{
		$('[id*="selectedFile"]').val('');
		$("[id*='uploadBtn']").attr('disabled' , true);
	}
		
};
function Print(){
	 self.print();
}

function viewVideoinNewTab()
{
  var videoHTML = '<video width="400" controls autoplay preload="none"><source src="${surveyVideoURL}" id="video_here"><liferay-ui:message key="video_not_supported" /></video>';
  var myWindow = window.open("",  "width=400,height=400");
  myWindow.document.write(videoHTML);
}

</script>
<aui:script>

	$('#acceptQuot').on('click', function(event) {
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: $('#accept_popup_body').html(),
				headerContent: '',
				centered: true,
				modal: true,
				resizable: false,
				width: 600,
				height: 300,
				render: '#accept_popup_content'
			});						
			dialog.on('visibleChange', function(event) {
				if (!event.newVal) {
					//window.location = '/group/staff/manage_customer_service';
					$("#confirmBtn").attr('href', '');
				}
			});
		});
		
		AUI().use('aui-form-validator',
			    function(A) {
			    	 A.mix(A.config.FormValidator.RULES,{
			    		checkFilename:function(val,node,junction){
							var fileInput = document.getElementById("<portlet:namespace/>adminFile");
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
			             checkFilename:"Enter a Valid File Name"
			          },
			          true
			         );
			         
			         rules.<portlet:namespace/>adminFile = {
			        		 required: false,
			        		 checkFilename:true
			         }
			         
			          
			         var fieldStrings = {
			     		   <portlet:namespace/>adminFile: {
			     			  checkFilename:"Enter a Valid File Name"
			     		   }
			      		}; 
			        
					   	frmValidator = new A.FormValidator(
					    {
					     boundingBox: "#<portlet:namespace/>uploadForm",
					     rules: rules,
					     fieldStrings: fieldStrings,
					     validateOnBlur: false
					    });
				
				      frmValidator.validate();
				      if(!frmValidator.hasErrors())
			    	  {
			    	 		$("#<portlet:namespace/>uploadForm").submit();
			    	  }
				      
				});
	});
	$('#rejectQuot').on('click', function(event) {
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: $('#reject_popup_body').html(),
				headerContent: '',
				centered: true,
				modal: true,
				resizable: false,
				width: 600,
				height: 300,
				render: '#reject_popup_content'
			});						
			dialog.on('visibleChange', function(event) {
				if (!event.newVal) {
					//window.location = '/group/staff/manage_customer_service';
					$("#submitBtn").attr('href', '');
				}
			});
		});
	});		
	function validateFile()
	{
		var myFormValidator = eval('Liferay.Form._INSTANCES.<portlet:namespace/>uploadForm.formValidator');
		
		myFormValidator.validateField("<portlet:namespace/>adminFile");

		if (!myFormValidator.hasErrors()) {
			$("#<portlet:namespace/>uploadForm").submit();
		}
	}
	
</aui:script>