package com.ejada.atmc.acl.db.custom.model;

import java.util.List;

public class SOADetail {

	private long proposal_no;

	private String statement_date;

	private String email_address;

	private String contact_no;

	private String nad_address1;

	private String nad_address2;

	private String nad_address3;

	private String mailingAddress1;

	private String mailingAddress2;

	private String mailingAddress3;

	private String status_descr;

	private String inception_date;

	private String general_installment_amount;

	private String plan_duration;

	private String total_amount_received;

	private String total_premium_due;

	private String premium;

	private String topup_premium;

	private String credit_balance;

	private String withdraw;

	private String investment_strategy;

	private String currency;

	private double no_units;

	private double current_unit_value;

	private double total_saving_value;

	private String peremium_invested;

	private String frequency;

	private String policy_holder;

	private String product_desc;

	private String premium_invested;

	private String premium_paid;

	private String premium_not_paid;

	private String installment_paid;

	private String installment_remaining;

	private String premium_to_be_invested;

	private List<PSCoverageDetail> psCoverageDetails;

	private List<PSBeneficiaryDetail> psBeneficiaryDetails;

	private List<PSStatementAccount> psStatementAccounts;

	private String fromDate;

	private String toDate;

	private String investementDate;

	public String getMailingAddress1() {
		return mailingAddress1;
	}

	public void setMailingAddress1(String mailingAddress1) {
		this.mailingAddress1 = mailingAddress1;
	}

	public String getMailingAddress2() {
		return mailingAddress2;
	}

	public void setMailingAddress2(String mailingAddress2) {
		this.mailingAddress2 = mailingAddress2;
	}

	public String getMailingAddress3() {
		return mailingAddress3;
	}

	public void setMailingAddress3(String mailingAddress3) {
		this.mailingAddress3 = mailingAddress3;
	}

	public long getProposal_no() {
		return proposal_no;
	}

	public void setProposal_no(long proposal_no) {
		this.proposal_no = proposal_no;
	}

	public String getStatement_date() {
		return statement_date;
	}

	public void setStatement_date(String statement_date) {
		this.statement_date = statement_date;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getContact_no() {
		return contact_no;
	}

	public void setContact_no(String contact_no) {
		this.contact_no = contact_no;
	}

	public String getNad_address1() {
		return nad_address1;
	}

	public void setNad_address1(String nad_address1) {
		this.nad_address1 = nad_address1;
	}

	public String getNad_address2() {
		return nad_address2;
	}

	public void setNad_address2(String nad_address2) {
		this.nad_address2 = nad_address2;
	}

	public String getNad_address3() {
		return nad_address3;
	}

	public void setNad_address3(String nad_address3) {
		this.nad_address3 = nad_address3;
	}

	public String getStatus_descr() {
		return status_descr;
	}

	public void setStatus_descr(String status_descr) {
		this.status_descr = status_descr;
	}

	public String getInception_date() {
		return inception_date;
	}

	public void setInception_date(String inception_date) {
		this.inception_date = inception_date;
	}

	public String getGeneral_installment_amount() {
		return general_installment_amount;
	}

	public void setGeneral_installment_amount(String general_installment_amount) {
		this.general_installment_amount = general_installment_amount;
	}

	public String getPlan_duration() {
		return plan_duration;
	}

	public void setPlan_duration(String plan_duration) {
		this.plan_duration = plan_duration;
	}

	public String getTotal_amount_received() {
		return total_amount_received;
	}

	public void setTotal_amount_received(String total_amount_received) {
		this.total_amount_received = total_amount_received;
	}

	public String getTotal_premium_due() {
		return total_premium_due;
	}

	public void setTotal_premium_due(String total_premium_due) {
		this.total_premium_due = total_premium_due;
	}

	public String getPremium() {
		return premium;
	}

	public void setPremium(String premium) {
		this.premium = premium;
	}

	public String getTopup_premium() {
		return topup_premium;
	}

	public void setTopup_premium(String topup_premium) {
		this.topup_premium = topup_premium;
	}

	public String getCredit_balance() {
		return credit_balance;
	}

	public void setCredit_balance(String credit_balance) {
		this.credit_balance = credit_balance;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	public String getInvestment_strategy() {
		return investment_strategy;
	}

	public void setInvestment_strategy(String investment_strategy) {
		this.investment_strategy = investment_strategy;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getNo_units() {
		return no_units;
	}

	public void setNo_units(double no_units) {
		this.no_units = no_units;
	}

	public double getCurrent_unit_value() {
		return current_unit_value;
	}

	public void setCurrent_unit_value(double current_unit_value) {
		this.current_unit_value = current_unit_value;
	}

	public double getTotal_saving_value() {
		return total_saving_value;
	}

	public void setTotal_saving_value(double total_saving_value) {
		this.total_saving_value = total_saving_value;
	}

	public String getPeremium_invested() {
		return peremium_invested;
	}

	public void setPeremium_invested(String peremium_invested) {
		this.peremium_invested = peremium_invested;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public String getPolicy_holder() {
		return policy_holder;
	}

	public void setPolicy_holder(String policy_holder) {
		this.policy_holder = policy_holder;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
	}

	public String getPremium_invested() {
		return premium_invested;
	}

	public void setPremium_invested(String premium_invested) {
		this.premium_invested = premium_invested;
	}

	public String getPremium_paid() {
		return premium_paid;
	}

	public void setPremium_paid(String premium_paid) {
		this.premium_paid = premium_paid;
	}

	public String getPremium_not_paid() {
		return premium_not_paid;
	}

	public void setPremium_not_paid(String premium_not_paid) {
		this.premium_not_paid = premium_not_paid;
	}

	public String getInstallment_paid() {
		return installment_paid;
	}

	public void setInstallment_paid(String installment_paid) {
		this.installment_paid = installment_paid;
	}

	public String getInstallment_remaining() {
		return installment_remaining;
	}

	public void setInstallment_remaining(String installment_remaining) {
		this.installment_remaining = installment_remaining;
	}

	public String getPremium_to_be_invested() {
		return premium_to_be_invested;
	}

	public void setPremium_to_be_invested(String premium_to_be_invested) {
		this.premium_to_be_invested = premium_to_be_invested;
	}

	public List<PSCoverageDetail> getPsCoverageDetails() {
		return psCoverageDetails;
	}

	public void setPsCoverageDetails(List<PSCoverageDetail> psCoverageDetails) {
		this.psCoverageDetails = psCoverageDetails;
	}

	public List<PSBeneficiaryDetail> getPsBeneficiaryDetails() {
		return psBeneficiaryDetails;
	}

	public void setPsBeneficiaryDetails(List<PSBeneficiaryDetail> psBeneficiaryDetails) {
		this.psBeneficiaryDetails = psBeneficiaryDetails;
	}

	public List<PSStatementAccount> getPsStatementAccounts() {
		return psStatementAccounts;
	}

	public void setPsStatementAccounts(List<PSStatementAccount> psStatementAccounts) {
		this.psStatementAccounts = psStatementAccounts;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getInvestementDate() {
		return investementDate;
	}

	public void setInvestementDate(String investementDate) {
		this.investementDate = investementDate;
	}

	@Override
	public String toString() {
		return "SOADetail [proposal_no=" + proposal_no + ", statement_date=" + statement_date + ", email_address="
				+ email_address + ", contact_no=" + contact_no + ", nad_address1=" + nad_address1 + ", nad_address2="
				+ nad_address2 + ", nad_address3=" + nad_address3 + ", mailingAddress1=" + mailingAddress1
				+ ", mailingAddress2=" + mailingAddress2 + ", mailingAddress3=" + mailingAddress3 + ", status_descr="
				+ status_descr + ", inception_date=" + inception_date + ", general_installment_amount="
				+ general_installment_amount + ", plan_duration=" + plan_duration + ", total_amount_received="
				+ total_amount_received + ", total_premium_due=" + total_premium_due + ", premium=" + premium
				+ ", topup_premium=" + topup_premium + ", credit_balance=" + credit_balance + ", withdraw=" + withdraw
				+ ", investment_strategy=" + investment_strategy + ", currency=" + currency + ", no_units=" + no_units
				+ ", current_unit_value=" + current_unit_value + ", total_saving_value=" + total_saving_value
				+ ", peremium_invested=" + peremium_invested + ", frequency=" + frequency + ", policy_holder="
				+ policy_holder + ", product_desc=" + product_desc + ", premium_invested=" + premium_invested
				+ ", premium_paid=" + premium_paid + ", premium_not_paid=" + premium_not_paid + ", installment_paid="
				+ installment_paid + ", installment_remaining=" + installment_remaining + ", premium_to_be_invested="
				+ premium_to_be_invested + ", psCoverageDetails=" + psCoverageDetails + ", psBeneficiaryDetails="
				+ psBeneficiaryDetails + ", psStatementAccounts=" + psStatementAccounts + ", fromDate=" + fromDate
				+ ", toDate=" + toDate + ", investementDate=" + investementDate + "]";
	}

}
