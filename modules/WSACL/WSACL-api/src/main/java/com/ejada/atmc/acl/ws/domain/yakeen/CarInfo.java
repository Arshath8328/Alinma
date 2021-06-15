/**
 * 
 */
package com.ejada.atmc.acl.ws.domain.yakeen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Basel
 *
 */
@XmlRootElement
public class CarInfo extends BasicCarInfo {
	private short	cylinders;
	private short	modelYear;
	private String	ownerName;
	private short	plateNumber;
	private String	plateText1;
	private String	plateText2;
	private String	plateText3;
	private short	plateTypeCode;
	private int		regCityLocationCode;
	private String	regExpiryDate;

	/**
	 * @return the cylinders
	 */
	public short getCylinders() {
		return cylinders;
	}

	/**
	 * @param cylinders the cylinders to set
	 */
	@XmlElement
	public void setCylinders(short cylinders) {
		this.cylinders = cylinders;
	}

	/**
	 * @return the modelYear
	 */
	public short getModelYear() {
		return modelYear;
	}

	/**
	 * @param modelYear the modelYear to set
	 */
	@XmlElement
	public void setModelYear(short modelYear) {
		this.modelYear = modelYear;
	}

	/**
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * @param ownerName the ownerName to set
	 */
	@XmlElement
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	/**
	 * @return the plateNumber
	 */
	public short getPlateNumber() {
		return plateNumber;
	}

	/**
	 * @param plateNumber the plateNumber to set
	 */
	@XmlElement
	public void setPlateNumber(short plateNumber) {
		this.plateNumber = plateNumber;
	}

	/**
	 * @return the plateText1
	 */
	public String getPlateText1() {
		return plateText1;
	}

	/**
	 * @param plateText1 the plateText1 to set
	 */
	@XmlElement
	public void setPlateText1(String plateText1) {
		this.plateText1 = plateText1;
	}

	/**
	 * @return the plateText2
	 */
	public String getPlateText2() {
		return plateText2;
	}

	/**
	 * @param plateText2 the plateText2 to set
	 */
	@XmlElement
	public void setPlateText2(String plateText2) {
		this.plateText2 = plateText2;
	}

	/**
	 * @return the plateText3
	 */
	public String getPlateText3() {
		return plateText3;
	}

	/**
	 * @param plateText3 the plateText3 to set
	 */
	@XmlElement
	public void setPlateText3(String plateText3) {
		this.plateText3 = plateText3;
	}

	/**
	 * @return the plateTypeCode
	 */
	public short getPlateTypeCode() {
		return plateTypeCode;
	}

	/**
	 * @param plateTypeCode the plateTypeCode to set
	 */
	@XmlElement
	public void setPlateTypeCode(short plateTypeCode) {
		this.plateTypeCode = plateTypeCode;
	}

	/**
	 * @return the regCityLocationCode
	 */
	public int getRegCityLocationCode() {
		return regCityLocationCode;
	}

	/**
	 * @param regCityLocationCode the regCityLocationCode to set
	 */
	@XmlElement
	public void setRegCityLocationCode(int regCityLocationCode) {
		this.regCityLocationCode = regCityLocationCode;
	}

	/**
	 * @return the regExpiryDate
	 */
	public String getRegExpiryDate() {
		return regExpiryDate;
	}

	/**
	 * @param regExpiryDate the regExpiryDate to set
	 */
	@XmlElement
	public void setRegExpiryDate(String regExpiryDate) {
		this.regExpiryDate = regExpiryDate;
	}

	@Override
	public String toString() {
		return "CarInfo{" + "cylinders=" + cylinders + ", modelYear=" + modelYear + ", ownerName='" + ownerName + '\'' + ", plateNumber=" + plateNumber + ", plateText1='" + plateText1 + '\''
				+ ", plateText2='" + plateText2 + '\'' + ", plateText3='" + plateText3 + '\'' + ", plateTypeCode=" + plateTypeCode + ", regCityLocationCode=" + regCityLocationCode
				+ ", regExpiryDate='" + regExpiryDate + '\'' + '}';
	}

}
