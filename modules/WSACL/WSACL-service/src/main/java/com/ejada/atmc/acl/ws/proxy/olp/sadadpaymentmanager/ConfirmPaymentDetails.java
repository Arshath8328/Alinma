
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * ConfirmPaymentDetails Request Wrapper.
 * 
 * 
 * <p>
 * Java class for ConfirmPaymentDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmPaymentDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConfirmPaymentDetailsRequest" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}ConfirmPaymentDetailsRequest"/&gt;
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
		name = "ConfirmPaymentDetails",
		propOrder = { "confirmPaymentDetailsRequest" }
)
public class ConfirmPaymentDetails {

	@XmlElement(
			name = "ConfirmPaymentDetailsRequest",
			required = true
	)
	protected ConfirmPaymentDetailsRequest confirmPaymentDetailsRequest;

	/**
	 * Gets the value of the confirmPaymentDetailsRequest property.
	 * 
	 * @return possible object is {@link ConfirmPaymentDetailsRequest }
	 * 
	 */
	public ConfirmPaymentDetailsRequest getConfirmPaymentDetailsRequest() {
		return confirmPaymentDetailsRequest;
	}

	/**
	 * Sets the value of the confirmPaymentDetailsRequest property.
	 * 
	 * @param value allowed object is {@link ConfirmPaymentDetailsRequest }
	 * 
	 */
	public void setConfirmPaymentDetailsRequest(ConfirmPaymentDetailsRequest value) {
		this.confirmPaymentDetailsRequest = value;
	}

}
