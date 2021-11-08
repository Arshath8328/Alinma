package com.ejada.atmc.acl.db.custom.model;

import java.util.Date;

public class ODSPolActiveVehicleDTO {
	private String policyNo;
	private String vehChassisNo;
	private Date policyExpiryDate;
	public String getPolicyNo() {
		return policyNo;
	}
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}
	public String getVehChassisNo() {
		return vehChassisNo;
	}
	public void setVehChassisNo(String vehChassisNo) {
		this.vehChassisNo = vehChassisNo;
	}
	public Date getPolicyExpiryDate() {
		return policyExpiryDate;
	}
	public void setPolicyExpiryDate(Date policyExpiryDate) {
		this.policyExpiryDate = policyExpiryDate;
	}

	
}
