package com.ejada.atmc.acl.db.custom.model;

public class PSStatementAccount {

	private long proposal_no;

	private double total_Premium;

	private String total_Premium_string;

	private double installment_paid;

	private String installment_paid_string;

	private double premium_paid;

	private String premium_paid_string;

	private double premium_To_be_Paid;

	private String premium_To_be_Paid_string;

	private double tobeinvested;

	private String tobeinvested_string;

	private String frequency;

	private double policy_year;

	private String policy_year_string;

	private double installment_no;

	private String installment_no_string;

	private String document_no;

	private String premium_entry_date;

	private String premium_due_date;

	private double installment_amount;

	private String installment_amount_string;

	public String getTotal_Premium_string() {
		return total_Premium_string;
	}

	public void setTotal_Premium_string(String total_Premium_string) {
		this.total_Premium_string = total_Premium_string;
	}

	public String getInstallment_paid_string() {
		return installment_paid_string;
	}

	public void setInstallment_paid_string(String installment_paid_string) {
		this.installment_paid_string = installment_paid_string;
	}

	public String getPremium_paid_string() {
		return premium_paid_string;
	}

	public void setPremium_paid_string(String premium_paid_string) {
		this.premium_paid_string = premium_paid_string;
	}

	public String getPremium_To_be_Paid_string() {
		return premium_To_be_Paid_string;
	}

	public void setPremium_To_be_Paid_string(String premium_To_be_Paid_string) {
		this.premium_To_be_Paid_string = premium_To_be_Paid_string;
	}

	public String getTobeinvested_string() {
		return tobeinvested_string;
	}

	public void setTobeinvested_string(String tobeinvested_string) {
		this.tobeinvested_string = tobeinvested_string;
	}

	public double getTobeinvested() {
		return tobeinvested;
	}

	public void setTobeinvested(double tobeinvested) {
		this.tobeinvested = tobeinvested;
	}

	public double getPremium_To_be_Paid() {
		return premium_To_be_Paid;
	}

	public void setPremium_To_be_Paid(double premium_To_be_Paid) {
		this.premium_To_be_Paid = premium_To_be_Paid;
	}

	public double getTotal_Premium() {
		return total_Premium;
	}

	public void setTotal_Premium(double total_Premium) {
		this.total_Premium = total_Premium;
	}

	public double getPremium_paid() {
		return premium_paid;
	}

	public void setPremium_paid(double premium_paid) {
		this.premium_paid = premium_paid;
	}

	public double getInstallment_paid() {
		return installment_paid;
	}

	public void setInstallment_paid(double installment_paid) {
		this.installment_paid = installment_paid;
	}

	public String getPolicy_year_string() {
		return policy_year_string;
	}

	public void setPolicy_year_string(String policy_year_string) {
		this.policy_year_string = policy_year_string;
	}

	public String getInstallment_no_string() {
		return installment_no_string;
	}

	public void setInstallment_no_string(String installment_no_string) {
		this.installment_no_string = installment_no_string;
	}

	public String getInstallment_amount_string() {
		return installment_amount_string;
	}

	public void setInstallment_amount_string(String installment_amount_string) {
		this.installment_amount_string = installment_amount_string;
	}

	private String current_status;

	private String payment_status;

	public long getProposal_no() {
		return proposal_no;
	}

	public void setProposal_no(long proposal_no) {
		this.proposal_no = proposal_no;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public double getPolicy_year() {
		return policy_year;
	}

	public void setPolicy_year(double policy_year) {
		this.policy_year = policy_year;
	}

	public double getInstallment_no() {
		return installment_no;
	}

	public void setInstallment_no(double installment_no) {
		this.installment_no = installment_no;
	}

	public String getDocument_no() {
		return document_no;
	}

	public void setDocument_no(String document_no) {
		this.document_no = document_no;
	}

	public String getPremium_entry_date() {
		return premium_entry_date;
	}

	public void setPremium_entry_date(String premium_entry_date) {
		this.premium_entry_date = premium_entry_date;
	}

	public String getPremium_due_date() {
		return premium_due_date;
	}

	public void setPremium_due_date(String premium_due_date) {
		this.premium_due_date = premium_due_date;
	}

	public double getInstallment_amount() {
		return installment_amount;
	}

	public void setInstallment_amount(double installment_amount) {
		this.installment_amount = installment_amount;
	}

	public String getCurrent_status() {
		return current_status;
	}

	public void setCurrent_status(String current_status) {
		this.current_status = current_status;
	}

	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@Override
	public String toString() {
		return "PSStatementAccount [proposal_no=" + proposal_no + ", total_Premium=" + total_Premium
				+ ", total_Premium_string=" + total_Premium_string + ", installment_paid=" + installment_paid
				+ ", installment_paid_string=" + installment_paid_string + ", premium_paid=" + premium_paid
				+ ", premium_paid_string=" + premium_paid_string + ", premium_To_be_Paid=" + premium_To_be_Paid
				+ ", premium_To_be_Paid_string=" + premium_To_be_Paid_string + ", tobeinvested=" + tobeinvested
				+ ", tobeinvested_string=" + tobeinvested_string + ", frequency=" + frequency + ", policy_year="
				+ policy_year + ", policy_year_string=" + policy_year_string + ", installment_no=" + installment_no
				+ ", installment_no_string=" + installment_no_string + ", document_no=" + document_no
				+ ", premium_entry_date=" + premium_entry_date + ", premium_due_date=" + premium_due_date
				+ ", installment_amount=" + installment_amount + ", installment_amount_string="
				+ installment_amount_string + ", current_status=" + current_status + ", payment_status="
				+ payment_status + "]";
	}

}
