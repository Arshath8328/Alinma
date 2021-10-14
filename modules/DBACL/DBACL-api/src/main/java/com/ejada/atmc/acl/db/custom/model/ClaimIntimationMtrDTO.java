package com.ejada.atmc.acl.db.custom.model;

import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;

import java.util.Date;

public class ClaimIntimationMtrDTO {
	private ClaimIntimationMtr claimIntimationMtr;
	private String claimStatus;
	private String claimNumber;
	private String policyNumber;
	private String createdBy;
	private Date creationDate;
	
	public ClaimIntimationMtr getClaimIntimationMtr() {
		return claimIntimationMtr;
	}
	public void setClaimIntimationMtr(ClaimIntimationMtr claimIntimationMtr) {
		this.claimIntimationMtr = claimIntimationMtr;
	}
	public String getClaimStatus() {
		return claimStatus;
	}
	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}
	public String getClaimNumber() {
		return claimNumber;
	}
	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}
	public String getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(String policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

}
