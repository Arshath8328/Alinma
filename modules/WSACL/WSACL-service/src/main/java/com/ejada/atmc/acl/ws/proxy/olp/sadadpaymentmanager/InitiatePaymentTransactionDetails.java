
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InitiatePaymentTransactionDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiatePaymentTransactionDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="abRefNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchantRefNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="ibURL" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "InitiatePaymentTransactionDetails",
		propOrder = { "abRefNum", "merchantRefNum", "ibURL" }
)
public class InitiatePaymentTransactionDetails {

	@XmlElement(
			required = true
	)
	protected String	abRefNum;
	@XmlElement(
			required = true
	)
	protected String	merchantRefNum;
	@XmlElement(
			required = true
	)
	protected String	ibURL;

	/**
	 * Gets the value of the abRefNum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getAbRefNum() {
		return abRefNum;
	}

	/**
	 * Sets the value of the abRefNum property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setAbRefNum(String value) {
		this.abRefNum = value;
	}

	/**
	 * Gets the value of the merchantRefNum property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	/**
	 * Sets the value of the merchantRefNum property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setMerchantRefNum(String value) {
		this.merchantRefNum = value;
	}

	/**
	 * Gets the value of the ibURL property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getIbURL() {
		return ibURL;
	}

	/**
	 * Sets the value of the ibURL property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setIbURL(String value) {
		this.ibURL = value;
	}

}
