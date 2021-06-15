package com.ejada.atmc.acl.db.custom.model;

public class PSPolicy {

	private long proposal_no;

	private String policy_status;

	private long Client_Code;

	private String client_name;

	private String status_description;

	private String issue_date;

	private String policy_start_date;

	private String policy_expiry_date;

	private double Total_Saving_Values;

	private String iqumaId;

	public String getIqumaId() {
		return iqumaId;
	}

	public void setIqumaId(String iqumaId) {
		this.iqumaId = iqumaId;
	}

	public long getProposal_no() {
		return proposal_no;
	}

	public void setProposal_no(long proposal_no) {
		this.proposal_no = proposal_no;
	}

	public String getPolicy_status() {
		return policy_status;
	}

	public void setPolicy_status(String policy_status) {
		this.policy_status = policy_status;
	}

	public String getClient_name() {
		return client_name;
	}

	public void setClient_name(String client_name) {
		this.client_name = client_name;
	}

	public String getStatus_description() {
		return status_description;
	}

	public void setStatus_description(String status_description) {
		this.status_description = status_description;
	}

	public String getIssue_date() {
		return issue_date;
	}

	public void setIssue_date(String issue_date) {
		this.issue_date = issue_date;
	}

	public String getPolicy_start_date() {
		return policy_start_date;
	}

	public void setPolicy_start_date(String policy_start_date) {
		this.policy_start_date = policy_start_date;
	}

	public String getPolicy_expiry_date() {
		return policy_expiry_date;
	}

	public void setPolicy_expiry_date(String policy_expiry_date) {
		this.policy_expiry_date = policy_expiry_date;
	}

	public long getClient_Code() {
		return Client_Code;
	}

	public void setClient_Code(long client_Code) {
		Client_Code = client_Code;
	}

	public double getTotal_Saving_Values() {
		return Total_Saving_Values;
	}

	public void setTotal_Saving_Values(double total_Saving_Values) {
		Total_Saving_Values = total_Saving_Values;
	}

	@Override
	public String toString() {
		return "PSPolicy [proposal_no=" + proposal_no + ", policy_status=" + policy_status + ", Client_Code="
				+ Client_Code + ", client_name=" + client_name + ", status_description=" + status_description
				+ ", issue_date=" + issue_date + ", policy_start_date=" + policy_start_date + ", policy_expiry_date="
				+ policy_expiry_date + ", Total_Saving_Values=" + Total_Saving_Values + ", iqumaId=" + iqumaId + "]";
	}

}
