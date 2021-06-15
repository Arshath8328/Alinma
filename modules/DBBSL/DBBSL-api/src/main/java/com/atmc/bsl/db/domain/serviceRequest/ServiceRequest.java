package com.atmc.bsl.db.domain.serviceRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;

public class ServiceRequest {
	private String referenceNo;
	private String source;
	private String RequestCategory;
	private String RequestType;
	private String productType;
	private String requestMessage;
	private String iqamaId;
	private String email;
	private String mobile;
	private String requestStatus;
	private boolean emailFlag;
	private String creatorUserId;
	private Date creationDate;
	private String creatorUserType;
	private String creatorUserName;
	private String assignedTo;
	private String ibanNumber;
	private boolean escalatedFlag;
	private String creationDateString;
	
	public String getReferenceNo() {
		return referenceNo;
	}
	public void setReferenceNo(String referenceNo) {
		this.referenceNo = referenceNo;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRequestCategory() {
		return RequestCategory;
	}
	public void setRequestCategory(String requestCategory) {
		RequestCategory = requestCategory;
	}
	public String getRequestType() {
		return RequestType;
	}
	public void setRequestType(String requestType) {
		RequestType = requestType;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getRequestMessage() {
		return requestMessage;
	}
	public void setRequestMessage(String requestMessage) {
		this.requestMessage = requestMessage;
	}
	public String getIqamaId() {
		return iqamaId;
	}
	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getRequestStatus() {
		return requestStatus;
	}
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	public boolean isEmailFlag() {
		return emailFlag;
	}
	public void setEmailFlag(boolean emailFlag) {
		this.emailFlag = emailFlag;
	}
	public String getCreatorUserId() {
		return creatorUserId;
	}
	public void setCreatorUserId(String creatorUserId) {
		this.creatorUserId = creatorUserId;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public String getAssignedTo() {
		return assignedTo;
	}
	public void setAssignedTo(String assignedTo) {
		this.assignedTo = assignedTo;
	}
	public String getIbanNumber() {
		return ibanNumber;
	}
	public void setIbanNumber(String ibanNumber) {
		this.ibanNumber = ibanNumber;
	}
	public String getCreatorUserType() {
		return creatorUserType;
	}
	public void setCreatorUserType(String creatorUserType) {
		this.creatorUserType = creatorUserType;
	}
	public String getCreatorUserName() {
		return creatorUserName;
	}
	public void setCreatorUserName(String creatorUserName) {
		this.creatorUserName = creatorUserName;
	}
	public boolean isEscalatedFlag() {
		return escalatedFlag;
	}
	public void setEscalatedFlag(boolean escalatedFlag) {
		this.escalatedFlag = escalatedFlag;
	}
	public String getCreationDateString() {
		return creationDateString;
	}

	public void setCreationDateString(String creationDateString) {
		this.creationDateString = creationDateString;
	}

	public void log()
	{
		String result = "";
		result += "\n" + getReferenceNo();
		result += "\n" + getSource();
		result += "\n" + getRequestCategory();
		result += "\n" + getRequestType();
		result += "\n" + getProductType();
		result += "\n" + getRequestMessage();
		result += "\n" + getIqamaId();
		result += "\n" + getEmail();
		result += "\n" + getMobile();
		result += "\n" + getRequestStatus();
		result += "\n" + isEmailFlag();
		result += "\n" + getCreatorUserId();
		result += "\n" + getCreationDate();
		result += "\n" + getCreatorUserType();
		result += "\n" + getCreatorUserName();
		result += "\n" + getAssignedTo();
		result += "\n" + getIbanNumber();
		result += "\n" + isEscalatedFlag();
		_log.info("Service Request Object : " + result);
	}

	@Override
	public String toString() {
		return "ServiceRequest{" +
//				"referenceNo='" + referenceNo + '\'' +
				" source='" + source + '\'' +
				", RequestCategory='" + RequestCategory + '\'' +
				", RequestType='" + RequestType + '\'' +
				", productType='" + productType + '\'' +
				", requestMessage='" + requestMessage + '\'' +
				", iqamaId='" + iqamaId + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", requestStatus='" + requestStatus + '\'' +
				", emailFlag=" + emailFlag +
				", creatorUserId='" + creatorUserId + '\'' +
				", creationDateString=" + creationDateString +
				", creatorUserType='" + creatorUserType + '\'' +
				", creatorUserName='" + creatorUserName + '\'' +
				", assignedTo='" + assignedTo + '\'' +
				", ibanNumber='" + ibanNumber + '\'' +
//				", escalatedFlag=" + escalatedFlag +
				'}';
	}

	private static final Log _log = LogFactoryUtil.getLog(ServiceRequest.class);
}