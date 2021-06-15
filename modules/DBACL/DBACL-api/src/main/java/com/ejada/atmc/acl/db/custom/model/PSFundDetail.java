package com.ejada.atmc.acl.db.custom.model;

public class PSFundDetail {

	private long proposal_no;
	
	private String investment_strategy;
	
	private String currency;
	
	private double no_units;
	
	private double current_unit_value;
	
	private double total_saving_value;
	
	private double peremium_invested;

	private int installments_paid;
	
	public double getNo_units() {
		return no_units;
	}

	public void setNo_units(double no_units) {
		this.no_units = no_units;
	}

	public long getProposal_no() {
		return proposal_no;
	}

	public void setProposal_no(long proposal_no) {
		this.proposal_no = proposal_no;
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

	public double getPeremium_invested() {
		return peremium_invested;
	}

	public void setPeremium_invested(double peremium_invested) {
		this.peremium_invested = peremium_invested;
	}

	public int getInstallments_paid() {
		return installments_paid;
	}

	public void setInstallments_paid(int installments_paid) {
		this.installments_paid = installments_paid;
	}

	@Override
	public String toString() {
		return "PSFundDetail [proposal_no=" + proposal_no + ", investment_strategy=" + investment_strategy
				+ ", currency=" + currency + ", no_units=" + no_units + ", current_unit_value=" + current_unit_value
				+ ", total_saving_value=" + total_saving_value + ", peremium_invested=" + peremium_invested
				+ ", installments_paid=" + installments_paid + "]";
	}

}
