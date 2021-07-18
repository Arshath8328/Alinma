package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Ehab
 *
 */
@XmlRootElement
public class DriverDetails {

	private int driverID;
	
	private String driverName;
	
	private String driverDateOfBirthG;
	
	private String driverDateOfBirthH;
	
	private int driverGender;

	@XmlElement(name = "DriverID")
	public int getDriverID() {
		return driverID;
	}

	public void setDriverID(int driverID) {
		this.driverID = driverID;
	}

	@XmlElement(name = "DriverName")
	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	@XmlElement(name = "DriverDateOfBirthG")
	public String getDriverDateOfBirthG() {
		return driverDateOfBirthG;
	}

	public void setDriverDateOfBirthG(String driverDateOfBirthG) {
		this.driverDateOfBirthG = driverDateOfBirthG;
	}

	@XmlElement(name = "DriverDateOfBirthH")
	public String getDriverDateOfBirthH() {
		return driverDateOfBirthH;
	}

	public void setDriverDateOfBirthH(String driverDateOfBirthH) {
		this.driverDateOfBirthH = driverDateOfBirthH;
	}

	@XmlElement(name = "DriverGender")
	public int getDriverGender() {
		return driverGender;
	}

	public void setDriverGender(int driverGender) {
		this.driverGender = driverGender;
	}
}
