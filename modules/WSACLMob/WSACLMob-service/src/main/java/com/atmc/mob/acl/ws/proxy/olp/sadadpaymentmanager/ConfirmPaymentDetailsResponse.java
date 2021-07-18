
package com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				ConfirmPaymentDetails Response Wrapper.
 * 			
 * 
 * <p>Java class for ConfirmPaymentDetailsResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmPaymentDetailsResponse"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="ConfirmPaymentDetailsReply" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}ConfirmPaymentDetailsReply"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmPaymentDetailsResponse", propOrder = {
    "confirmPaymentDetailsReply"
})
public class ConfirmPaymentDetailsResponse {

    @XmlElement(name = "ConfirmPaymentDetailsReply", required = true)
    protected ConfirmPaymentDetailsReply confirmPaymentDetailsReply;

    /**
     * Gets the value of the confirmPaymentDetailsReply property.
     * 
     * @return
     *     possible object is
     *     {@link ConfirmPaymentDetailsReply }
     *     
     */
    public ConfirmPaymentDetailsReply getConfirmPaymentDetailsReply() {
        return confirmPaymentDetailsReply;
    }

    /**
     * Sets the value of the confirmPaymentDetailsReply property.
     * 
     * @param value
     *     allowed object is
     *     {@link ConfirmPaymentDetailsReply }
     *     
     */
    public void setConfirmPaymentDetailsReply(ConfirmPaymentDetailsReply value) {
        this.confirmPaymentDetailsReply = value;
    }

}
