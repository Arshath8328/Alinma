<%@page import="com.ejada.atmc.acl.db.custom.model.PSStatementAccount"%>
<%@page import="com.ejada.atmc.acl.db.custom.model.PSBeneficiaryDetail"%>
<%@page import="com.ejada.atmc.acl.db.custom.model.PSCoverageDetail"%>
<%@page import="com.ejada.atmc.acl.db.custom.model.SOADetail"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Date"%>

<%
	SOADetail psStatementDetail = (SOADetail) request.getAttribute("psStatementDetail");
	List<PSCoverageDetail> psCoverageDetails = (List) psStatementDetail.getPsCoverageDetails();
	List<PSBeneficiaryDetail> psBeneficiaryDetails = (List) psStatementDetail.getPsBeneficiaryDetails();
	List<PSStatementAccount> statementAccounts = (List) psStatementDetail.getPsStatementAccounts();
	String redirect = ParamUtil.getString(request, "backURL");
	String fromDate = ParamUtil.getString(request, "fromDate");
	String toDate = ParamUtil.getString(request, "toDate");
	Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);
	Date date2=new SimpleDateFormat("MM/dd/yyyy").parse(toDate);
	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
	String finalFromDate = dateFormat.format(date1);
	String finalToDate = dateFormat.format(date2);
%>
<style>
td{
	text-align:center;
}
</style>
<liferay-portlet:resourceURL var="myResourceURL" >
 	<portlet:param name="proposalNo" value="<%= String.valueOf(psStatementDetail.getProposal_no()) %>"/>
 	<portlet:param name="fromDate" value="<%= finalFromDate %>"/>
 	<portlet:param name="toDate" value="<%= finalToDate %>"/>
</liferay-portlet:resourceURL>

<div class="fund-stmt">
    <div class="container-fluid">
    	<a href="<%=redirect%>">< Back</a>
    	<br><br>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad ">
                <div class="fundStmt-align-center"><%= psStatementDetail.getProposal_no() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy_number_ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy_number"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getStatement_date() %></div>
            </div>
            <div class="col-md-2 cell-border-2 no-pad fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="statement.date.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="statement.date"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row fundStmt-table-head border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="policy.details"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="policy.details.ar"/></div>
            </div>
        </div>
        <div class="row-divider">
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getEmail_address() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="email.address.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="email.address"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= psStatementDetail.getPolicy_holder() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy.holder.name.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy.holder.name"/></div>
            </div>
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getContact_no() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="contact.number.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="contact.number"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getProduct_desc().replaceAll("(\r\n|\n)", "<br />") %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.name.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.name"/></div>
            </div>
        </div>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad">
				<div class="fundStmt-align-center">
					<div class="txt-align-center"><%= psStatementDetail.getMailingAddress1().replaceAll("(\r\n|\n)", "<br />") %> </div>
				</div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="mailing.address.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="mailing.address"/></div>
                </div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center">
                	<div class="txt-align-center"><%= psStatementDetail.getNad_address1() %> </div>
                </div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="home.address.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="home.address"/></div>
                </div>
            </div>
        </div>

        <div class="row-divider"></div>

        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getInception_date() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy.inception.date.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy.inception.date"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= psStatementDetail.getStatus_descr() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.status.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.status"/></div>
            </div>
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getPlan_duration() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.duration.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.duration"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= psStatementDetail.getGeneral_installment_amount() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="installment.amount.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="installment.amount"/></div>
            </div>
        </div>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getFrequency() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="payment.frequency.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="payment.frequency"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= psStatementDetail.getTotal_amount_received() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="total.amount.received.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="total.amount.received"/></div>
            </div>
        </div>
        <div class="row-divider-20"></div>

        <div class="row fundStmt-table-head border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="premium.details"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="premium.details.ar"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row">
            <div class="col-md-5 no-pad">
                <table class="stmt-table pd-table">
                    <thead>
                        <tr>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="total.premium.due.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="total.premium.due"/></div>
                            </t>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="premium.paid.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="premium.paid"/></div>
                            </th>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="premium.not.paid.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="premium.not.paid"/></div>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td data-label="Total Premium Due - مجموع قسط المستحق">
                                <div class="stmt-cell-center"><%= psStatementDetail.getTotal_premium_due() %></div>
                            </td>
                            <td data-label="Premium Paid - قسط غريمدفوع ">
                                <div class="stmt-cell-center"><%= psStatementDetail.getPremium_paid() %></div>
                            </td>
                            <td data-label="Premium Not Paid - قسط غريمدفوع">
                                <div class="stmt-cell-center"><%= psStatementDetail.getPremium_not_paid() %></div>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>
            <div class="col-md-6 col-md-offset-1 no-pad">
                <table class="stmt-table pd-table">
                    <thead>
                        <tr>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="total.premium.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="total.premium"/></div>
                            </th>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="top.up.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="top.up"/></div>
                            </th>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="withdrawal.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="withdrawal"/></div>
                            </th>
                            <th class="fundStmt-table-head ">
                                <div class="txt-align-center"><liferay-ui:message key="credit.balance.ar"/></div>
                                <div class="txt-align-center"><liferay-ui:message key="credit.balance"/></div>
                            </th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td data-label="<liferay-ui:message key="premium"/> - <liferay-ui:message key="premium.ar"/>">
                                <div class="stmt-cell-center"><%= psStatementDetail.getTotal_amount_received() %></div>
                            </td>
                            <td data-label="<liferay-ui:message key="top.up"/> - <liferay-ui:message key="top.up.ar"/>">
                                <div class="stmt-cell-center"><%= psStatementDetail.getTopup_premium() %></div>
                            </td>
                            <td data-label="<liferay-ui:message key="withdrawal"/> - <liferay-ui:message key="withdrawal.ar"/>">
                                <div class="stmt-cell-center"><%= psStatementDetail.getWithdraw() %></div>
                            </td>
                            <td data-label="<liferay-ui:message key="credit.balance"/> - <liferay-ui:message key="credit.balance.ar"/>">
                                <div class="stmt-cell-center"><%= psStatementDetail.getCredit_balance() %></div>
                            </td>
                        </tr>
                    </tbody>

                </table>
            </div>
        </div>
        <div class="row-divider-20"></div>
        <div class="row fundStmt-table-head  border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="coverage.details"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="coverage.details.ar"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row">
            <table class="stmt-table">
                <thead>
                    <tr>
                        <th class="fundStmt-table-head  bn-head">
                            <div class="txt-align-center"><liferay-ui:message key="benefit.name"/> - <liferay-ui:message key="benefit.name.ar"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="benefit.type.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="benefit.type"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="benefit.term.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="benefit.term"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="sum.covered.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="sum.covered"/></div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    	<%
							for (PSCoverageDetail coverageDetail : psCoverageDetails) {
						%>
						<tr>
							<td data-label="<liferay-ui:message key="benefit.name"/> - <liferay-ui:message key="benefit.name.ar"/>">
                            	<div class="stmt-cell-center"><%= coverageDetail.getBenefit_name().replaceAll("(\r\n|\n)", "<br />") %></div>
                        	</td>
                        	<td data-label="<liferay-ui:message key="benefit.type"/> - <liferay-ui:message key="benefit.type.ar"/>">
                            	<div class="stmt-cell-center no-pad"><%= coverageDetail.getBenefit_type().replaceAll("(\r\n|\n)", "<br />")  %></div>
                        	</td>
                        	<td data-label="<liferay-ui:message key="benefit.term"/> - <liferay-ui:message key="benefit.term.ar"/>">
                           		<div class="stmt-cell-center"><%= coverageDetail.getBenefit_term_string() %></div>
                        	</td>
                        	<td data-label="<liferay-ui:message key="sum.covered"/> - <liferay-ui:message key="sum.covered.ar"/>">
                            	<div class="stmt-cell-center"><%= coverageDetail.getSum_assured_string() %></div>
                        	</td>
                        </tr>
						<% 	
							}
						%>
                </tbody>

            </table>
        </div>
        <div class="row-divider-20"></div>
        <div class="row fundStmt-table-head  border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="funds.detail"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="funds.detail.ar"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row">
            <table class="stmt-table">
                <thead>
                    <tr>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="investment.strategy"/> - <liferay-ui:message key="investment.strategy.ar"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="currency.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="currency"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="no.of.units.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="no.of.units"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="current.unit.value.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="current.unit.value"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="total.savings.values.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="total.savings.values"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="premium.to.be.invested.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="premium.to.be.invested"/></div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td data-label="<liferay-ui:message key="investment.strategy"/> - <liferay-ui:message key="investment.strategy.ar"/>">
                            <div class="stmt-cell-center"><%= psStatementDetail.getInvestment_strategy().replaceAll("(\r\n|\n)", "<br />") %></div>
                        </td>
                        <td data-label="<liferay-ui:message key="currency"/> - <liferay-ui:message key="currency.ar"/>">
                            <div class="stmt-cell-center"><%= psStatementDetail.getCurrency() %></div>
                        </td>
                        <td data-label="<liferay-ui:message key="no.of.units"/> - <liferay-ui:message key="no.of.units.ar"/>">
                            <div class="stmt-cell-center"><%= (int) psStatementDetail.getNo_units() %></div>
                        </td>
                        <td data-label="<liferay-ui:message key="current.unit.value"/> - <liferay-ui:message key="current.unit.value.ar"/>">
                            <div class="stmt-cell-center"><%= (int) psStatementDetail.getCurrent_unit_value() %></div>
                        </td>
                        <td data-label="<liferay-ui:message key="total.savings.values"/> - <liferay-ui:message key="total.savings.values.ar"/>">
                            <div class="stmt-cell-center"><%= (int) psStatementDetail.getTotal_saving_value() %></div>
                        </td>
                        <td data-label="<liferay-ui:message key="premium.to.be.invested"/> - <liferay-ui:message key="premium.to.be.invested.ar"/>">
                            <div class="stmt-cell-center"><%= psStatementDetail.getPremium_to_be_invested() %></div>
                        </td>
                    </tr>
                </tbody>

            </table>
        </div>
        <div class="txt-align-right"><liferay-ui:message key="investment.value.as.of"/> <%= psStatementDetail.getInvestementDate() %> <liferay-ui:message key="investment.value.as.of.ar"/></div>
        <div class="row fundStmt-table-head  border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="beneficiary.detail"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="beneficiary.detail.ar"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row">
            <table class="stmt-table">
                <thead>
                    <tr>
                        <th class="fundStmt-table-head  bname-head">
                            <div class="txt-align-center"><liferay-ui:message key="beneficiary.name"/> - <liferay-ui:message key="beneficiary.name.ar"/></div>
                        </th class="fundStmt-table-head ">
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="share.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="share"/></div>
                        </th>
                        <th class="fundStmt-table-head ">
                            <div class="txt-align-center"><liferay-ui:message key="relationship.ar"/></div>
                            <div class="txt-align-center"><liferay-ui:message key="relationship"/></div>
                        </th>
                    </tr>
                </thead>
                <tbody>
                    	<%
							for (PSBeneficiaryDetail beneficiaryDetail : psBeneficiaryDetails) {
						%>
						<tr>
							<td data-label="Beneficiary Name - أسم المستفيد">
                            	<div class="stmt-cell-center"><%= beneficiaryDetail.getBeneficiary_name().replaceAll("(\r\n|\n)", "<br />")  %></div>
                        	</td>
                       		<td data-label="Share - شارك">
                            	<div class="stmt-cell-center"><%= beneficiaryDetail.getShare_string() %>%</div>
                        	</td>
                        	<td data-label="Relationship - صلة">
                            	<div class="stmt-cell-center"><%= beneficiaryDetail.getRelationship() %></div>
                        	</td>
                        </tr>
						<% 	
							}
						%>
                </tbody>
            </table>
        </div>
        <div class="row-divider"></div>
        <div class="row display-flex">
            <div class="col-md-6">
                <h5 class="txt-bold"><liferay-ui:message key="note"/></h5>
                <p>
                    <liferay-ui:message key="message"/>

                </p>
            </div>
            <div class="col-md-6">
                <h5 class="txt-align-right txt-bold"><liferay-ui:message key="note.ar"/></h5>
                <p class="txt-align-right">
                    <liferay-ui:message key="message.ar"/>
                </p>
            </div>
        </div>

        <div class="row-divider"></div>
            <div class="row">
                <div class="col-md-6">
                    <h3 class="txt-bold"><liferay-ui:message key="statement.of.account"/> - <liferay-ui:message key="statement.of.account.ar"/></h3>
                    <span class="txt-bold"><liferay-ui:message key="statement.period"/> <%= finalFromDate %> - <%= finalToDate %>  <liferay-ui:message key="statement.period.ar"/></span>
                </div>
                <div class="col-md-6">

                </div>
            </div>
            <div class="row-divider-20"></div>
            <div class="row display-flex border-2">
                <div class="col-md-2 no-pad ">
                    <div class="fundStmt-align-center"><%= psStatementDetail.getProposal_no() %></div>
                </div>
                <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="policy_number_ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="policy_number"/></div>
                </div>
                <div class="col-md-2 cell-border-2 no-pad">
                    <div class="fundStmt-align-center"><%= psStatementDetail.getFrequency() %></div>
                </div>
                <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="payment.frequency.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="payment.frequency"/></div>
                </div>
                <div class="col-md-2 cell-border-2 no-pad">
                    <div class="fundStmt-align-center"><%= psStatementDetail.getStatement_date() %></div>
                </div>
                <div class="col-md-2 cell-border-2 no-pad fundStmt-table-head fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="statement.date.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="statement.date"/></div>
                </div>
            </div>

            <div class="row-divider">
            </div>
            <div class="acct-stmt">
                <div class="row display-flex b-top b-right b-left">
                    <div class="col-md-2 no-pad">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getPolicy_holder() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="policy.holder.name.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="policy.holder.name"/></div>
                    </div>
                    <div class="col-md-6 cell-border-2 no-pad">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getProduct_desc().replaceAll("(\r\n|\n)", "<br />") %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="plan.name.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="plan.name"/></div>
                    </div>
                </div>
                <div class="row display-flex b-top b-right b-left">
                    <div class="col-md-2 no-pad">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getPeremium_invested() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">

                        <div class="txt-align-center"><liferay-ui:message key="premium.invested.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="premium.invested"/></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getPremium_paid() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">

                        <div class="txt-align-center"><liferay-ui:message key="premium.paid.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="premium.paid"/></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getInstallment_paid() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="installment.paid.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="installment.paid"/></div>
                    </div>
                </div>
                <div class="row display-flex border-2">
                    <div class="col-md-2 no-pad">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getPremium_to_be_invested() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="premium.to.be.invested.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="premium.to.be.invested"/></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getPremium_not_paid() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="premium.not.paid.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="premium.not.paid"/></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2">
                        <div class="fundStmt-align-center"><%= psStatementDetail.getInstallment_remaining() %></div>
                    </div>
                    <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                        <div class="txt-align-center"><liferay-ui:message key="installment.remaining.ar"/></div>
                        <div class="txt-align-center"><liferay-ui:message key="installment.remaining"/></div>
                    </div>
                </div>
                <div class="row-divider">
                </div>
                <div class="row">
                    <table class="stmt-table">
                        <thead>
                            <tr>
                            <tr>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="policy.year.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="policy.year"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="installment.no.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="installment.no"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="premium.due.date.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="premium.due.date"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="installment.amount.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="installment.amount"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="payment.status.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="payment.status"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="premium.entry.date.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="premium.entry.date"/></div>
                                </th>
                                <th class="fundStmt-table-head ">
                                    <div class="txt-align-center"><liferay-ui:message key="invested.to.be.ar"/></div>
                                    <div class="txt-align-center"><liferay-ui:message key="invested.to.be"/></div>
                                </th>
                            </tr>
                        </thead>
                        <tbody>
                        	<%
								for (PSStatementAccount statementAccount : statementAccounts) {
							%>
							<tr>
                                <td data-label="<liferay-ui:message key="policy.year"/> - <liferay-ui:message key="policy.year.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getPolicy_year_string() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="installment.no"/> - <liferay-ui:message key="installment.no.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getInstallment_no_string() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="premium.due.date"/> - <liferay-ui:message key="premium.due.date.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getPremium_due_date() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="installment.amount"/> - <liferay-ui:message key="installment.amount.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getInstallment_amount_string() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="payment.status"/> - <liferay-ui:message key="payment.status.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getPayment_status() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="premium.entry.date"/> - <liferay-ui:message key="premium.entry.date.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getPremium_entry_date() %></div>
                                </td>
                                <td data-label="<liferay-ui:message key="invested.to.be"/> - <liferay-ui:message key="invested.to.be.ar"/>">
                                    <div class="stmt-cell-center"><%= statementAccount.getCurrent_status() %></div>
                                </td>
                            </tr>
							<% 	
								}
							%>
                        </tbody>
                    </table>
                    
                    
                </div>
            </div>
        </div>
    </div>
    <div>
    	<div onclick="window.location='<%=myResourceURL%>'"> PDF
		<i class="material-icons md-36">&#xE415;</i></div>
	</div>
<aui:script>
function callServeResource(){
	$.ajax({
		url:'<%= myResourceURL %>',
		dataType: 'json',
		type : "get",
		async: "false",
		success : function(){
			alert("hi");
		}
	});


}
</aui:script>