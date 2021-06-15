package com.atmc.bsl.db.domain.quotation;

import java.util.Date;

public class QuotationHistory {
	private long historyId;
	private long quotationId;
	private Date dateTime;
	private String userName;
	private String status;
	private String reason;
	public long getHistoryId() {
		return historyId;
	}
	public void setHistoryId(long historyId) {
		this.historyId = historyId;
	}
	public long getQuotationId() {
		return quotationId;
	}
	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}
	public Date getDateTime() {
		return dateTime;
	}
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
	
	public String toString()
	{
		String objectStr = "";
		objectStr += "\n\n historyId : " + historyId;
		objectStr += "\n\n userName : " +  userName;
		objectStr += "\n\n dateTime : " + dateTime;
		objectStr += "\n\n reason : " +  reason;
		objectStr += "\n\n addressBuildingNo : " +  userName;
		objectStr += "\n\n quotationId : " +  quotationId;

		return objectStr;
	}
}
