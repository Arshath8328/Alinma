package com.ejada.atmc.acl.db.custom.model;

public class PSBeneficiaryDetail {

	private long proposal_no;

	private String statement_date;

	private String beneficiary_name;

	private double share;

	private String share_string;

	private String relationship;

	public String getShare_string() {
		return share_string;
	}

	public void setShare_string(String share_string) {
		this.share_string = share_string;
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

	public String getBeneficiary_name() {
		return beneficiary_name;
	}

	public void setBeneficiary_name(String beneficiary_name) {
		this.beneficiary_name = beneficiary_name;
	}

	public double getShare() {
		return share;
	}

	public void setShare(double share) {
		this.share = share;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	@Override
	public String toString() {
		return "PSBeneficiaryDetail [proposal_no=" + proposal_no + ", statement_date=" + statement_date
				+ ", beneficiary_name=" + beneficiary_name + ", share=" + share + ", share_string=" + share_string
				+ ", relationship=" + relationship + "]";
	}

}
