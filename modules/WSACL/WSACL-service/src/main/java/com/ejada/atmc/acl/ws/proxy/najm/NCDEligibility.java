
package com.ejada.atmc.acl.ws.proxy.najm;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="personId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="vehicleIdentifier" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="vehicleId" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
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
		name = "",
		propOrder = { "personId", "vehicleIdentifier", "vehicleId" }
)
@XmlRootElement(
		name = "NCDEligibility"
)
public class NCDEligibility {

	protected Long				personId;
	protected Integer			vehicleIdentifier;
	@XmlElementRef(
			name = "vehicleId",
			namespace = "http://tempuri.org/",
			type = JAXBElement.class,
			required = false
	)
	protected JAXBElement<Long>	vehicleId;

	/**
	 * Gets the value of the personId property.
	 * 
	 * @return possible object is {@link Long }
	 * 
	 */
	public Long getPersonId() {
		return personId;
	}

	/**
	 * Sets the value of the personId property.
	 * 
	 * @param value allowed object is {@link Long }
	 * 
	 */
	public void setPersonId(Long value) {
		this.personId = value;
	}

	/**
	 * Gets the value of the vehicleIdentifier property.
	 * 
	 * @return possible object is {@link Integer }
	 * 
	 */
	public Integer getVehicleIdentifier() {
		return vehicleIdentifier;
	}

	/**
	 * Sets the value of the vehicleIdentifier property.
	 * 
	 * @param value allowed object is {@link Integer }
	 * 
	 */
	public void setVehicleIdentifier(Integer value) {
		this.vehicleIdentifier = value;
	}

	/**
	 * Gets the value of the vehicleId property.
	 * 
	 * @return possible object is {@link JAXBElement }{@code <}{@link Long }{@code >}
	 * 
	 */
	public JAXBElement<Long> getVehicleId() {
		return vehicleId;
	}

	/**
	 * Sets the value of the vehicleId property.
	 * 
	 * @param value allowed object is {@link JAXBElement }{@code <}{@link Long }{@code >}
	 * 
	 */
	public void setVehicleId(JAXBElement<Long> value) {
		this.vehicleId = value;
	}

}
