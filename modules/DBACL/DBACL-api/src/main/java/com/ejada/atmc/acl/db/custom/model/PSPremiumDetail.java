package com.ejada.atmc.acl.db.custom.model;

public class PSPremiumDetail {

	private long proposal_no;

	private String statement_date;

	private double total_premium_due;

	private double premium_paid;

	private double premium_not_paid;

	private double premium;

	private double topup_premium;

	private double credit_balance;

	private String withdraw;

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

	public double getTotal_premium_due() {
		return total_premium_due;
	}

	public void setTotal_premium_due(double total_premium_due) {
		this.total_premium_due = total_premium_due;
	}

	public double getPremium_paid() {
		return premium_paid;
	}

	public void setPremium_paid(double premium_paid) {
		this.premium_paid = premium_paid;
	}

	public double getPremium_not_paid() {
		return premium_not_paid;
	}

	public void setPremium_not_paid(double premium_not_paid) {
		this.premium_not_paid = premium_not_paid;
	}

	public double getPremium() {
		return premium;
	}

	public void setPremium(double premium) {
		this.premium = premium;
	}

	public double getTopup_premium() {
		return topup_premium;
	}

	public void setTopup_premium(double topup_premium) {
		this.topup_premium = topup_premium;
	}

	public double getCredit_balance() {
		return credit_balance;
	}

	public void setCredit_balance(double credit_balance) {
		this.credit_balance = credit_balance;
	}

	public String getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(String withdraw) {
		this.withdraw = withdraw;
	}

	@Override
	public String toString() {
		return "PSPremiumDetail [proposal_no=" + proposal_no + ", statement_date=" + statement_date
				+ ", total_premium_due=" + total_premium_due + ", premium_paid=" + premium_paid + ", premium_not_paid="
				+ premium_not_paid + ", premium=" + premium + ", topup_premium=" + topup_premium + ", credit_balance="
				+ credit_balance + ", withdraw=" + withdraw + "]";
	}

}
