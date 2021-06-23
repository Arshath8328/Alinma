package com.atmc.bsl.db.domain.claim;

import java.util.Date;

public class ClaimHistory {
	private int historyId;
	private String referenceNo;
	private Date hisoryDate;
	private String userName;
	private String status;
	private String reason;

	public String getReferenceNo() {
		return referenceNo;
	}

	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}

	public Date getHisoryDate() {
		return hisoryDate;
	}

	public void setHisoryDate(Date hisoryDate) {
		this.hisoryDate = hisoryDate;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getHistoryId() {
		return historyId;
	}

	public void setHistoryId(int historyId) {
		this.historyId = historyId;
	}

}
