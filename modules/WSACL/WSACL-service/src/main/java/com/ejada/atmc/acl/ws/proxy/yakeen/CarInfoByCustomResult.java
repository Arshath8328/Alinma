
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for carInfoByCustomResult complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="carInfoByCustomResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chassisNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="lkVehBodyType" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="majorColor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		name = "carInfoByCustomResult",
		propOrder = { "chassisNumber", "lkVehBodyType", "logId", "majorColor", "vehicleLoad", "vehicleMakerCode", "vehicleModelCode", "vehicleWeight" }
)
public class CarInfoByCustomResult {

	protected String	chassisNumber;
	protected short		lkVehBodyType;
	protected int		logId;
	protected String	majorColor;
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
