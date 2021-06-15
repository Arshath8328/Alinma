
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for alienAddressInfoRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienAddressInfoRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="addressLanguage" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="dateOfBirth" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="iqamaNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		name = "alienAddressInfoRequest",
		propOrder = { "addressLanguage", "chargeCode", "dateOfBirth", "iqamaNumber", "password", "referenceNumber", "userName" }
)
public class AlienAddressInfoRequest {

	protected String	addressLanguage;
	protected String	chargeCode;
	protected String	dateOfBirth;
	protected String	iqamaNumber;
	protected String	password;
	protected String	referenceNumber;
	protected String	userName;

	/**
	 * Gets the value of the addressLanguage property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAddressLanguage() {
		return addressLanguage;
	}

	/**
	 * Sets the value of the addressLanguage property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAddressLanguage(String value) {
		this.addressLanguage = value;
	}

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
	 * Gets the value of the dateOfBirth property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * Sets the value of the dateOfBirth property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDateOfBirth(String value) {
		this.dateOfBirth = value;
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
