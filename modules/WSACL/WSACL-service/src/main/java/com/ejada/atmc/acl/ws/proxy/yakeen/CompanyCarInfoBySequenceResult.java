
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for companyCarInfoBySequenceResult complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyCarInfoBySequenceResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chassisNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cylinders" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="lkVehBodyType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="majorColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="modelYear" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="ownerName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateNumber" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="plateText1" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateText2" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateText3" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="plateTypeCode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="regCityLocationCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="regExpiryDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="vehicleLoad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vehicleMakerCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vehicleModelCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="vehicleWeight" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "companyCarInfoBySequenceResult",
		propOrder = { "chassisNumber", "cylinders", "lkVehBodyType", "logId", "majorColor", "modelYear", "ownerName", "plateNumber", "plateText1", "plateText2", "plateText3", "plateTypeCode",
				"regCityLocationCode", "regExpiryDate", "vehicleLoad", "vehicleMakerCode", "vehicleModelCode", "vehicleWeight" }
)
public class CompanyCarInfoBySequenceResult {

	protected String	chassisNumber;
	protected short		cylinders;
	protected short		lkVehBodyType;
	protected int		logId;
	protected String	majorColor;
	protected short		modelYear;
	protected String	ownerName;
	protected short		plateNumber;
	protected String	plateText1;
	protected String	plateText2;
	protected String	plateText3;
	protected short		plateTypeCode;
	protected int		regCityLocationCode;
	protected String	regExpiryDate;
	protected int		vehicleLoad;
	protected int		vehicleMakerCode;
	protected int		vehicleModelCode;
	protected int		vehicleWeight;

	/**
	 * Gets the value of the chassisNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}

	/**
	 * Sets the value of the chassisNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setChassisNumber(String value) {
		this.chassisNumber = value;
	}

	/**
	 * Gets the value of the cylinders property.
	 * 
	 */
	public short getCylinders() {
		return cylinders;
	}

	/**
	 * Sets the value of the cylinders property.
	 * 
	 */
	public void setCylinders(short value) {
		this.cylinders = value;
	}

	/**
	 * Gets the value of the lkVehBodyType property.
	 * 
	 */
	public short getLkVehBodyType() {
		return lkVehBodyType;
	}

	/**
	 * Sets the value of the lkVehBodyType property.
	 * 
	 */
	public void setLkVehBodyType(short value) {
		this.lkVehBodyType = value;
	}

	/**
	 * Gets the value of the logId property.
	 * 
	 */
	public int getLogId() {
		return logId;
	}

	/**
	 * Sets the value of the logId property.
	 * 
	 */
	public void setLogId(int value) {
		this.logId = value;
	}

	/**
	 * Gets the value of the majorColor property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMajorColor() {
		return majorColor;
	}

	/**
	 * Sets the value of the majorColor property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMajorColor(String value) {
		this.majorColor = value;
	}

	/**
	 * Gets the value of the modelYear property.
	 * 
	 */
	public short getModelYear() {
		return modelYear;
	}

	/**
	 * Sets the value of the modelYear property.
	 * 
	 */
	public void setModelYear(short value) {
		this.modelYear = value;
	}

	/**
	 * Gets the value of the ownerName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getOwnerName() {
		return ownerName;
	}

	/**
	 * Sets the value of the ownerName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setOwnerName(String value) {
		this.ownerName = value;
	}

	/**
	 * Gets the value of the plateNumber property.
	 * 
	 */
	public short getPlateNumber() {
		return plateNumber;
	}

	/**
	 * Sets the value of the plateNumber property.
	 * 
	 */
	public void setPlateNumber(short value) {
		this.plateNumber = value;
	}

	/**
	 * Gets the value of the plateText1 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlateText1() {
		return plateText1;
	}

	/**
	 * Sets the value of the plateText1 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPlateText1(String value) {
		this.plateText1 = value;
	}

	/**
	 * Gets the value of the plateText2 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlateText2() {
		return plateText2;
	}

	/**
	 * Sets the value of the plateText2 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPlateText2(String value) {
		this.plateText2 = value;
	}

	/**
	 * Gets the value of the plateText3 property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPlateText3() {
		return plateText3;
	}

	/**
	 * Sets the value of the plateText3 property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPlateText3(String value) {
		this.plateText3 = value;
	}

	/**
	 * Gets the value of the plateTypeCode property.
	 * 
	 */
	public short getPlateTypeCode() {
		return plateTypeCode;
	}

	/**
	 * Sets the value of the plateTypeCode property.
	 * 
	 */
	public void setPlateTypeCode(short value) {
		this.plateTypeCode = value;
	}

	/**
	 * Gets the value of the regCityLocationCode property.
	 * 
	 */
	public int getRegCityLocationCode() {
		return regCityLocationCode;
	}

	/**
	 * Sets the value of the regCityLocationCode property.
	 * 
	 */
	public void setRegCityLocationCode(int value) {
		this.regCityLocationCode = value;
	}

	/**
	 * Gets the value of the regExpiryDate property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getRegExpiryDate() {
		return regExpiryDate;
	}

	/**
	 * Sets the value of the regExpiryDate property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setRegExpiryDate(String value) {
		this.regExpiryDate = value;
	}

	/**
	 * Gets the value of the vehicleLoad property.
	 * 
	 */
	public int getVehicleLoad() {
		return vehicleLoad;
	}

	/**
	 * Sets the value of the vehicleLoad property.
	 * 
	 */
	public void setVehicleLoad(int value) {
		this.vehicleLoad = value;
	}

	/**
	 * Gets the value of the vehicleMakerCode property.
	 * 
	 */
	public int getVehicleMakerCode() {
		return vehicleMakerCode;
	}

	/**
	 * Sets the value of the vehicleMakerCode property.
	 * 
	 */
	public void setVehicleMakerCode(int value) {
		this.vehicleMakerCode = value;
	}

	/**
	 * Gets the value of the vehicleModelCode property.
	 * 
	 */
	public int getVehicleModelCode() {
		return vehicleModelCode;
	}

	/**
	 * Sets the value of the vehicleModelCode property.
	 * 
	 */
	public void setVehicleModelCode(int value) {
		this.vehicleModelCode = value;
	}

	/**
	 * Gets the value of the vehicleWeight property.
	 * 
	 */
	public int getVehicleWeight() {
		return vehicleWeight;
	}

	/**
	 * Sets the value of the vehicleWeight property.
	 * 
	 */
	public void setVehicleWeight(int value) {
		this.vehicleWeight = value;
	}

}
