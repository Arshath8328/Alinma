package com.ejada.atmc.acl.db.custom.model;

public class PSCoverageDetail {

	private long proposal_no;

	private String statement_date;

	private String benefit_name;

	private String benefit_type;

	private double benefit_term;

	private String benefit_term_string;

	private double sum_assured;

	private String sum_assured_string;

	public String getBenefit_term_string() {
		return benefit_term_string;
	}

	public void setBenefit_term_string(String benefit_term_string) {
		this.benefit_term_string = benefit_term_string;
	}

	public String getSum_assured_string() {
		return sum_assured_string;
	}

	public void setSum_assured_string(String sum_assured_string) {
		this.sum_assured_string = sum_assured_string;
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

	public String getBenefit_name() {
		return benefit_name;
	}

	public void setBenefit_name(String benefit_name) {
		this.benefit_name = benefit_name;
	}

	public String getBenefit_type() {
		return benefit_type;
	}

	public void setBenefit_type(String benefit_type) {
		this.benefit_type = benefit_type;
	}

	public double getBenefit_term() {
		return benefit_term;
	}

	public void setBenefit_term(double benefit_term) {
		this.benefit_term = benefit_term;
	}

	public double getSum_assured() {
		return sum_assured;
	}

	public void setSum_assured(double sum_assured) {
		this.sum_assured = sum_assured;
	}

	@Override
	public String toString() {
		return "PSCoverageDetail [proposal_no=" + proposal_no + ", statement_date=" + statement_date + ", benefit_name="
				+ benefit_name + ", benefit_type=" + benefit_type + ", benefit_term=" + benefit_term
				+ ", benefit_term_string=" + benefit_term_string + ", sum_assured=" + sum_assured
				+ ", sum_assured_string=" + sum_assured_string + "]";
	}

}
