
package com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for ConfirmPaymentDetailsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="ConfirmPaymentDetailsRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionIdEnc" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="merchantRefNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ConfirmPaymentDetailsRequest", propOrder = {
    "transactionIdEnc",
    "merchantId",
    "merchantRefNum"
})
public class ConfirmPaymentDetailsRequest {

    @XmlElement(required = true)
    protected String transactionIdEnc;
    protected long merchantId;
    @XmlElement(required = true)
    protected String merchantRefNum;

    /**
     * Gets the value of the transactionIdEnc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTransactionIdEnc() {
        return transactionIdEnc;
    }

    /**
     * Sets the value of the transactionIdEnc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTransactionIdEnc(String value) {
        this.transactionIdEnc = value;
    }

    /**
     * Gets the value of the merchantId property.
     * 
     */
    public long getMerchantId() {
        return merchantId;
    }

    /**
     * Sets the value of the merchantId property.
     * 
     */
    public void setMerchantId(long value) {
        this.merchantId = value;
    }

    /**
     * Gets the value of the merchantRefNum property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMerchantRefNum() {
        return merchantRefNum;
    }

    /**
     * Sets the value of the merchantRefNum property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMerchantRefNum(String value) {
        this.merchantRefNum = value;
    }

}
