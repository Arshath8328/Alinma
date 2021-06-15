
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for InitiatePaymentDetailsReply complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiatePaymentDetailsReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="initiatePaymentTransactionDetails" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}InitiatePaymentTransactionDetails" minOccurs="0"/&gt;
 *         &lt;element name="responseCode" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="bankBusinessException" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}BankBusinessException" minOccurs="0"/&gt;
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
		name = "InitiatePaymentDetailsReply",
		propOrder = { "initiatePaymentTransactionDetails", "responseCode", "bankBusinessException" }
)
public class InitiatePaymentDetailsReply {

	protected InitiatePaymentTransactionDetails	initiatePaymentTransactionDetails;
	@XmlElement(
			required = true
	)
	protected String							responseCode;
	protected BankBusinessException				bankBusinessException;

	/**
	 * Gets the value of the initiatePaymentTransactionDetails property.
	 * 
	 * @return possible object is {@link InitiatePaymentTransactionDetails }
	 * 
	 */
	public InitiatePaymentTransactionDetails getInitiatePaymentTransactionDetails() {
		return initiatePaymentTransactionDetails;
	}

	/**
	 * Sets the value of the initiatePaymentTransactionDetails property.
	 * 
	 * @param value allowed object is {@link InitiatePaymentTransactionDetails }
	 * 
	 */
	public void setInitiatePaymentTransactionDetails(InitiatePaymentTransactionDetails value) {
		this.initiatePaymentTransactionDetails = value;
	}

	/**
	 * Gets the value of the responseCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the value of the responseCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setResponseCode(String value) {
		this.responseCode = value;
	}

	/**
	 * Gets the value of the bankBusinessException property.
	 * 
	 * @return possible object is {@link BankBusinessException }
	 * 
	 */
	public BankBusinessException getBankBusinessException() {
		return bankBusinessException;
	}

	/**
	 * Sets the value of the bankBusinessException property.
	 * 
	 * @param value allowed object is {@link BankBusinessException }
	 * 
	 */
	public void setBankBusinessException(BankBusinessException value) {
		this.bankBusinessException = value;
	}

}
