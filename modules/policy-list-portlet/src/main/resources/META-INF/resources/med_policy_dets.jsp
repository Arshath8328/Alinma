<%@page import="java.util.Date"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyMember"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.atmc.bsl.db.domain.policy.Policy"%>
<%@ include file="/init.jsp"%>
<%
	Policy policy = (Policy) request.getAttribute("policy");

	long currDateTime =new Date().getTime();
	long toDateTime = policy.getExpiryDate().getTime();
	long daysDiff = (currDateTime < toDateTime)?(toDateTime - currDateTime)/ (1000 * 60 * 60 * 24):0;
%>
<portlet:renderURL var="policyListURL">
	<portlet:param name="myview" value="policy_list"/>
</portlet:renderURL>
<div class="row bg-body">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12 no-pad">
		<div class="headerBanner">
			<img class="img-responsive"	src="/o/atmc-theme/images/review_quotation_image.png" width="100%" /> 
			<h3 class="text-primary pageTitle"><liferay-ui:message key="med_policy_dets"/></h3>
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
		<div class="row maegin-top">
			<div class="col-xs-12 col-sm-12 col-md-10 col-lg-10 col-lg-offset-1 col-md-offset-1">
				<table class="table table-bordered">
					<tbody>
						<tr>
							<td class="text-primary"><liferay-ui:message key="sum_insured"/><br />
							<small class="text-muted"><%=policy.getSumInsured() %></small></td>
							<td class="text-primary"><%=policy.getInsuredName() %></td>
							<td class="text-primary"><liferay-ui:message key="member_limit"/><br />
							<small class="text-muted">1,500.00</small></td>
							<td class="<%=(daysDiff >45)?"bg-primary":"bg-danger"%>"><liferay-ui:message key="from"/> <%=(policy.getInceptionDate()!=null)?dateFormatter.format(policy.getInceptionDate()):"" %><br><liferay-ui:message key="to"/> <%=(policy.getExpiryDate()!=null)?dateFormatter.format(policy.getExpiryDate()):"" %>
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
								<th class="bg-gray"><liferay-ui:message key="tot_prem"/></th>
								<td><%=policy.getTotalPremium() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_fees"/></th>
								<td><%=policy.getPolicyFees() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_tax"/></th>
								<td><%=policy.getPolicyTaxes() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="sum_insured"/></th>
								<td><%=policy.getSumInsured() %></td>
							</tr>
						</tbody>
					</table>
					<h4><liferay-ui:message key="policy_holder_dets"/></h4>
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="policy_holder_name"/></th>
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
								<td><%=policy.getInsuredEmail() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="policy_holder_address"/></th>
								<td><%=policy.getInsuredAddr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="no_mems"/></th>
								<td><%=policy.getNoOfRisk() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_scheme"/></th>
								<td><%=policy.getMemberScheme() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_benefits"/></th>
								<td><%=policy.getMemberBenefits() %></td>
							</tr>
						</tbody>
					</table>
		<%
			List membersList = policy.getPolicyMembers();
			if(membersList!=null && !membersList.isEmpty())
			{
		%>
					<h4><liferay-ui:message key="member_dets_view"/></h4>
		
		<%
				for(int mCount=0;mCount<membersList.size();mCount++)
				{
					PolicyMember member = (PolicyMember)membersList.get(mCount);
		%>			
					<table class="table table-bordered">
						<tbody>
							<tr>
								<th width="40%" class="bg-gray"><liferay-ui:message key="member_name"/></th>
								<td><%=member.getMemberName() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_si"/></th>
								<td><%=member.getMemberSi() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_id"/></th>
								<td><%=member.getMemberId() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_gender"/></th>
								<td><%=(currLocale.equals("en_US"))?member.getMemberGenderEn():member.getMemberGenderAr() %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_dob"/></th>
								<td><%=(member.getMemberDob()!=null)?dateFormatter.format(member.getMemberDob()):"" %></td>
							</tr>
							<tr>
								<th class="bg-gray"><liferay-ui:message key="member_limit"/></th>
								<td><%=numberFormat.format(member.getMemberLimit()) %></td>
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
					<li class="pull-left">
						<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="${policyListURL}">
							<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
						</a>
					</li>
					<li>
						<button class="btn btn-lg btn-xs-block btn-default" type="button" onclick="window.location='/group/customer/customer_service';"><liferay-ui:message key="service_req"/></button>
					</li>
				</ul>
			</div>
		</div>
	</div>
</div>