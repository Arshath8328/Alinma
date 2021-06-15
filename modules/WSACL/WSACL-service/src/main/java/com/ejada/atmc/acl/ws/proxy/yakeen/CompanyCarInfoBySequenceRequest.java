
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for companyCarInfoBySequenceRequest complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="companyCarInfoBySequenceRequest">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="chargeCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="companyMOINumber" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="password" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="referenceNumber" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="sequenceNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
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
		name = "companyCarInfoBySequenceRequest",
		propOrder = { "chargeCode", "companyMOINumber", "password", "referenceNumber", "sequenceNumber", "userName" }
)
public class CompanyCarInfoBySequenceRequest {

	protected String	chargeCode;
	protected long		companyMOINumber;
	protected String	password;
	protected String	referenceNumber;
	protected int		sequenceNumber;
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
	 * Gets the value of the companyMOINumber property.
	 * 
	 */
	public long getCompanyMOINumber() {
		return companyMOINumber;
	}

	/**
	 * Sets the value of the companyMOINumber property.
	 * 
	 */
	public void setCompanyMOINumber(long value) {
		this.companyMOINumber = value;
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
	 * Gets the value of the sequenceNumber property.
	 * 
	 */
	public int getSequenceNumber() {
		return sequenceNumber;
	}

	/**
	 * Sets the value of the sequenceNumber property.
	 * 
	 */
	public void setSequenceNumber(int value) {
		this.sequenceNumber = value;
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
