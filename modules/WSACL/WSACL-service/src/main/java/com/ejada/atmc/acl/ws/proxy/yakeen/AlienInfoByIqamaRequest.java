
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for alienInfoByIqamaRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienInfoByIqamaRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iqamaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sponsorId" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="userName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		name = "alienInfoByIqamaRequest",
		propOrder = { "chargeCode", "iqamaNumber", "password", "referenceNumber", "sponsorId", "userName" }
)
public class AlienInfoByIqamaRequest {

	protected String	chargeCode;
	protected String	iqamaNumber;
	protected String	password;
	protected String	referenceNumber;
	protected String	sponsorId;
	protected String	userName;

	/**
	 * Gets the value of the chargeCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getChargeCode() {
		return chargeCode;
	}

	/**
	 * Sets the value of the chargeCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setChargeCode(String value) {
		this.chargeCode = value;
	}

	/**
	 * Gets the value of the iqamaNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIqamaNumber() {
		return iqamaNumber;
	}

	/**
	 * Sets the value of the iqamaNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIqamaNumber(String value) {
		this.iqamaNumber = value;
	}

	/**
	 * Gets the value of the password property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the value of the password property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setPassword(String value) {
		this.password = value;
	}

	/**
	 * Gets the value of the referenceNumber property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getReferenceNumber() {
		return referenceNumber;
	}

	/**
	 * Sets the value of the referenceNumber property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setReferenceNumber(String value) {
		this.referenceNumber = value;
	}

	/**
	 * Gets the value of the sponsorId property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSponsorId() {
		return sponsorId;
	}

	/**
	 * Sets the value of the sponsorId property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSponsorId(String value) {
		this.sponsorId = value;
	}

	/**
	 * Gets the value of the userName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * Sets the value of the userName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setUserName(String value) {
		this.userName = value;
	}

}
