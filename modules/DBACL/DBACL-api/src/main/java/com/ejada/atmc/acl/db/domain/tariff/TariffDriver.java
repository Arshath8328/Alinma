package com.ejada.atmc.acl.db.domain.tariff;

public class TariffDriver {
	private int serial;
	private String driverID;
	private String driverNCDCode;
	private String driverDateOfBirth;
	private String driverGender;
	private String driverMaritalStatus;

	public int getSerial() {
		return serial;
	}

	public void setSerial(int serial) {
		this.serial = serial;
	}

	public String getDriverID() {
		return driverID;
	}

	public void setDriverID(String driverID) {
		this.driverID = driverID;
	}

	public String getDriverNCDCode() {
		return driverNCDCode;
	}

	public void setDriverNCDCode(String driverNCDCode) {
		this.driverNCDCode = driverNCDCode;
	}

	public String getDriverDateOfBirth() {
		return driverDateOfBirth;
	}

	public void setDriverDateOfBirth(String driverDateOfBirth) {
		this.driverDateOfBirth = driverDateOfBirth;
	}

	public String getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(String driverGender) {
		this.driverGender = driverGender;
	}

	public String getDriverMaritalStatus() {
		return driverMaritalStatus;
	}

	public void setDriverMaritalStatus(String driverMaritalStatus) {
		this.driverMaritalStatus = driverMaritalStatus;
	}
}