package com.ejada.atmc.bsl.db.domain.serviceRequest;

import java.util.Date;

public class ServiceRequestAction {

	private Long actionID;
	private String referenceNo;
	private String actionType;
	private String actionDetails;
	private String actionRemarks;
	private Date actionDate;

	public Long getActionID() {
		return actionID;
	}

	public void setActionID(Long actionID) {
		this.actionID = actionID;
	}

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public String getActionType() {
		return actionType;
	}

	public void setActionType(String actionType) {
		this.actionType = actionType;
	}

	public String getActionDetails() {
		return actionDetails;
	}

	public void setActionDetails(String actionDetails) {
		this.actionDetails = actionDetails;
	}

	public String getActionRemarks() {
		return actionRemarks;
	}

	public void setActionRemarks(String actionRemarks) {
		this.actionRemarks = actionRemarks;
	}

	public Date getActionDate() {
		return actionDate;
	}

	public void setActionDate(Date actionDate) {
		this.actionDate = actionDate;
	}
}
