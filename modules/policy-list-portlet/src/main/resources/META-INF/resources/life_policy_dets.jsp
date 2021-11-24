<%@page import="java.util.Date"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyBeneficiary"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyFund"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyVehicleCover"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyPayment"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="javax.swing.text.DateFormatter"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.Policy"%>
<%@ include file="/init.jsp"%>
<%
	Policy policy = (Policy)request.getAttribute("policy");

	long currDateTime =new Date().getTime();
	long toDateTime = policy.getExpiryDate().getTime();
	long daysDiff = (currDateTime < toDateTime)?(toDateTime - currDateTime)/ (1000 * 60 * 60 * 24):0;
%>
<div class="row bg-body">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad">
		<div class="headerBanner">
			<img class="img-responsive"	src="/o/atmc-theme/images/review_quotation_image.png" width="100%" /> 
			<h3 class="text-primary pageTitle"><liferay-ui:message key="life_policy_dets"/></h3>
			<div class="printDownloadsection">
				<a href=""><i class="material-icons">&#xE8AD;</i><liferay-ui:message key="print" /></a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
				<a href=""><i class="material-icons">&#xE415;</i><liferay-ui:message key="download" /></a>
			</div>
		</div>
	</div>
</div>
<div class="row bg-body">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad bg-white">
		<br/>
		<div class="row vcenter">
			<div class="col-md-offset-1 col-md-6 col-lg-6 col-xs-6 col-sm-6">
				<h3>
					<liferay-ui:message key="policy_no"/>&nbsp;<span class="text-muted"><%=policy.getPolicyNo() %></span>
				</h3>
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
							<td class="text-primary"><liferay-ui:message key="sum_insured"/><br />
							<small class="text-muted"><%=numberFormat.format(policy.getSumInsured()) %></small></td>
							<td class="text-primary"><%=policy.getInsuredName() %></td>
							<td class="text-primary"><%=policy.getPolicyTerm() %></td>
							<td class="<%=(daysDiff >45)?"bg-primary":"bg-danger"%>"><liferay-ui:message key="from"/> <%=dateFormatter.format(policy.getInceptionDate()) %><br><liferay-ui:message key="to"/> <%=dateFormatter.format(policy.getExpiryDate()) %>
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
								<th width="40%" class="bg-gray"><liferay-ui:message key="product"/></th>
								<td><%=(currLocale.equals("en_US"))?policy.getProductEn():policy.getProductAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_status"/></th>
								<td><%=policy.getPolicyStatus() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="tot_prem"/></th>
								<td><%=numberFormat.format(policy.getTotalPremium()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="sum_insured"/></th>
								<td><%=numberFormat.format(policy.getSumInsured()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_term"/></th>
								<td><%=policy.getPolicyTerm() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="next_due_date"/></th>
								<td><%=(policy.getNextDueDate()!=null)?dateFormatter.format(policy.getNextDueDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="os_prem"/></th>
								<td><%=policy.getPremium() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="count_prem_missed"/></th>
								<td><%=numberFormat.format(policy.getCountPremMissed()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="next_ren_date"/></th>
								<td><%=(policy.getNextRenwalDate()!=null)?dateFormatter.format(policy.getNextRenwalDate()):"" %></td>
							</tr>
						</tbody>
					</table>
					<h4><liferay-ui:message key="policy_holder_dets"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th class="bg-gray" width="40%"><liferay-ui:message key="id_number"/></th>
								<td><%=policy.getIqamaId() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="id_exp_date"/></th>
								<td><%=(policy.getExpiryDate()!=null)?dateFormatter.format(policy.getExpiryDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_name"/></th>
								<td><%=policy.getCustName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_dob"/></th>
								<td><%=(policy.getCustBirthDate()!=null)?dateFormatter.format(policy.getCustBirthDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_mob"/></th>
								<td><%=policy.getInsuredMobile() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_email"/></th>
								<td><%=policy.getInsuredEmail()%></td>
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
		<%
			List ridersList = policy.getPolicyRiders();
			if(ridersList != null && !ridersList.isEmpty())
			{
		%>
					<h4>Rider Details</h4>
		<%		for(int rCount=0; rCount<ridersList.size();rCount++)
				{
					PolicyVehicleCover rider = (PolicyVehicleCover)ridersList.get(rCount);
		%>			
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="description"/></th>
								<td><%=rider.getDescription() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="ben_term"/></th>
								<td><%=rider.getBenefitTerm() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="prem_term"/></th>
								<td><%=rider.getPremiumTerm() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="sum_coverd"/></th>
								<td><%=numberFormat.format(rider.getSumCovered()) %></td>
							</tr>
						</tbody>
					</table>
		<%
				}
			}
			List fundsList = policy.getPolicyFunds();
			if(fundsList != null && !fundsList.isEmpty())
			{
		%>
					<h4><liferay-ui:message key="funds_dets"/></h4>
		<%		for(int fCount=0; fCount<fundsList.size();fCount++)
				{
					PolicyFund fund = (PolicyFund)fundsList.get(fCount);
		%>			
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="fund_name"/></th>
								<td><%=fund.getFundName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="desc"/></th>
								<td><%=fund.getFundDesc() %></td>
							</tr>
							<tr>
								<th class="bg-gray">%<liferay-ui:message key="age"/></th>
								<td><%=fund.getFundPctg() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="units_sum"/></th>
								<td><%=numberFormat.format(fund.getUnitsSum()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="unit_price"/></th>
								<td><%=numberFormat.format(fund.getUnitPrice()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="funds_val"/></th>
								<td><%=numberFormat.format(fund.getFundsValue()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="risk_charg"/></th>
								<td><%=numberFormat.format(fund.getRiskChg()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="part_fees"/></th>
								<td><%=numberFormat.format(fund.getPartFees()) %></td>
							</tr>
						</tbody>
					</table>
		<%
				}
			}
			List benfsList = policy.getPolicyBenfs();
			if(benfsList != null && !benfsList.isEmpty())
			{
		%>
					<h4>Beneficiary Details View</h4>
		<%		for(int bCount=0; bCount<benfsList.size();bCount++)
				{
					PolicyBeneficiary benf = (PolicyBeneficiary)benfsList.get(bCount);
		%>			
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="ben_name"/></th>
								<td><%=benf.getBenfName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="ben_percent"/></th>
								<td><%=benf.getBenfPct() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="rel"/></th>
								<td><%=(currLocale.equals("en_US"))?benf.getBenfRelEn():benf.getBenfRelAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="id_number"/></th>
								<td><%=benf.getBenfId() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="age_dob"/></th>
								<td><%=benf.getBenfAge() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="ben_type"/></th>
								<td><%=benf.getBenfType() %></td>
							</tr>
						</tbody>
					</table>
		<%
				}
			}
			PolicyPayment pmnt = policy.getPolicyPayment();
			if(pmnt!=null)
			{
		%>			
					<h4><liferay-ui:message key="last_pay_det"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="paid_date"/></th>
								<td><%=(pmnt.getDocDate()!=null)?dateFormatter.format(pmnt.getDocDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="mode_pmnt"/></th>
								<td><%=(currLocale.equals("en_US"))?policy.getModeOfPaymentEn():policy.getModeOfPaymentAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="due_date"/></th>
								<td><%=(pmnt.getDueDate()!=null)?dateFormatter.format(pmnt.getDueDate()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="amount"/></th>
								<td><%=numberFormat.format(pmnt.getAmount()) %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="ref"/></th>
								<td><%=pmnt.getReference() %></td>
							</tr>
						</tbody>
					</table>
		<%
			}
		%>			
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 text-right no-pad">
				<ul class="list-btns">
					<li class="pull-left"><a
						class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="#">
							<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
					</a></li>
					<li>
						<button class="btn btn-lg btn-xs-block btn-default" type="button" onclick="window.location='/group/customer/customer_service';"><liferay-ui:message key="service_req"/></button>

					</li>
				</ul>
			</div>
		</div>
</div>
</div>