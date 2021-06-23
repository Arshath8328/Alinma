
package com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				InitiatePaymentDetails response wrapper.
 * 			
 * 
 * <p>Java class for InitiatePaymentDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiatePaymentDetailsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="InitiatePaymentDetailsReply" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}InitiatePaymentDetailsReply"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitiatePaymentDetailsResponse", propOrder = {
    "initiatePaymentDetailsReply"
})
public class InitiatePaymentDetailsResponse {

    @XmlElement(name = "InitiatePaymentDetailsReply", required = true)
    protected InitiatePaymentDetailsReply initiatePaymentDetailsReply;

    /**
     * Gets the value of the initiatePaymentDetailsReply property.
     * 
     * @return
     *     possible object is
     *     {@link InitiatePaymentDetailsReply }
     *     
     */
    public InitiatePaymentDetailsReply getInitiatePaymentDetailsReply() {
        return initiatePaymentDetailsReply;
    }

    /**
     * Sets the value of the initiatePaymentDetailsReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link InitiatePaymentDetailsReply }
     *     
     */
    public void setInitiatePaymentDetailsReply(InitiatePaymentDetailsReply value) {
        this.initiatePaymentDetailsReply = value;
    }

}
