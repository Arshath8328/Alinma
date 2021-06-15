package com.ejada.atmc.acl.db.custom.model;

public class PSPolicyDetail {

	private long proposal_no;

	private String statement_date;

	private String policy_holder;

	private String email_address;

	private String product_desc;

	private String contact_no;

	private String nad_address1;

	private String nad_address2;

	private String nad_address3;

	private String mailingAddress1;

	private String mailingAddress2;

	private String mailingAddress3;

	private String status_descr;

	private String inception_date;

	private double installment_amount;

	private double plan_duration;

	private double total_amount_received;

	private String frequency;

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

	public String getInception_date() {
		return inception_date;
	}

	public void setInception_date(String inception_date) {
		this.inception_date = inception_date;
	}

	public String getPolicy_holder() {
		return policy_holder;
	}

	public void setPolicy_holder(String policy_holder) {
		this.policy_holder = policy_holder;
	}

	public String getEmail_address() {
		return email_address;
	}

	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}

	public String getProduct_desc() {
		return product_desc;
	}

	public void setProduct_desc(String product_desc) {
		this.product_desc = product_desc;
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

	public double getInstallment_amount() {
		return installment_amount;
	}

	public void setInstallment_amount(double installment_amount) {
		this.installment_amount = installment_amount;
	}

	public double getPlan_duration() {
		return plan_duration;
	}

	public void setPlan_duration(double plan_duration) {
		this.plan_duration = plan_duration;
	}

	public double getTotal_amount_received() {
		return total_amount_received;
	}

	public void setTotal_amount_received(double total_amount_received) {
		this.total_amount_received = total_amount_received;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

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

	@Override
	public String toString() {
		return "PSPolicyDetail [proposal_no=" + proposal_no + ", statement_date=" + statement_date + ", policy_holder="
				+ policy_holder + ", email_address=" + email_address + ", product_desc=" + product_desc
				+ ", contact_no=" + contact_no + ", nad_address1=" + nad_address1 + ", nad_address2=" + nad_address2
				+ ", nad_address3=" + nad_address3 + ", mailingAddress1=" + mailingAddress1 + ", mailingAddress2="
				+ mailingAddress2 + ", mailingAddress3=" + mailingAddress3 + ", status_descr=" + status_descr
				+ ", inception_date=" + inception_date + ", installment_amount=" + installment_amount
				+ ", plan_duration=" + plan_duration + ", total_amount_received=" + total_amount_received
				+ ", frequency=" + frequency + "]";
	}

}
