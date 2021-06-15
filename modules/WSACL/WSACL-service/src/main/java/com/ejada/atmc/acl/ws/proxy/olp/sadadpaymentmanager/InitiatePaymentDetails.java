
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * 
 * InitiatePaymentDetails request wrapper.
 * 
 * 
 * <p>
 * Java class for InitiatePaymentDetails complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiatePaymentDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InitiatePaymentDetailsRequest" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}InitiatePaymentDetailsRequest"/&gt;
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
		name = "InitiatePaymentDetails",
		propOrder = { "initiatePaymentDetailsRequest" }
)
public class InitiatePaymentDetails {

	@XmlElement(
			name = "InitiatePaymentDetailsRequest",
			required = true
	)
	protected InitiatePaymentDetailsRequest initiatePaymentDetailsRequest;

	/**
	 * Gets the value of the initiatePaymentDetailsRequest property.
	 * 
	 * @return possible object is {@link InitiatePaymentDetailsRequest }
	 * 
	 */
	public InitiatePaymentDetailsRequest getInitiatePaymentDetailsRequest() {
		return initiatePaymentDetailsRequest;
	}

	/**
	 * Sets the value of the initiatePaymentDetailsRequest property.
	 * 
	 * @param value allowed object is {@link InitiatePaymentDetailsRequest }
	 * 
	 */
	public void setInitiatePaymentDetailsRequest(InitiatePaymentDetailsRequest value) {
		this.initiatePaymentDetailsRequest = value;
	}

}
