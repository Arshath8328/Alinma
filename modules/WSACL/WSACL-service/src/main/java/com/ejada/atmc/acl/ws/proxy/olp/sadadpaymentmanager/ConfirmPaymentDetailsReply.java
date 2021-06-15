
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for ConfirmPaymentDetailsReply complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmPaymentDetailsReply"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConfirmPaymentTransactionDetails" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}ConfirmPaymentTransactionDetails" minOccurs="0"/&gt;
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
		name = "ConfirmPaymentDetailsReply",
		propOrder = { "confirmPaymentTransactionDetails", "responseCode", "bankBusinessException" }
)
public class ConfirmPaymentDetailsReply {

	@XmlElement(
			name = "ConfirmPaymentTransactionDetails"
	)
	protected ConfirmPaymentTransactionDetails	confirmPaymentTransactionDetails;
	@XmlElement(
			required = true
	)
	protected String							responseCode;
	protected BankBusinessException				bankBusinessException;

	/**
	 * Gets the value of the confirmPaymentTransactionDetails property.
	 * 
	 * @return possible object is {@link ConfirmPaymentTransactionDetails }
	 * 
	 */
	public ConfirmPaymentTransactionDetails getConfirmPaymentTransactionDetails() {
		return confirmPaymentTransactionDetails;
	}

	/**
	 * Sets the value of the confirmPaymentTransactionDetails property.
	 * 
	 * @param value allowed object is {@link ConfirmPaymentTransactionDetails }
	 * 
	 */
	public void setConfirmPaymentTransactionDetails(ConfirmPaymentTransactionDetails value) {
		this.confirmPaymentTransactionDetails = value;
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
