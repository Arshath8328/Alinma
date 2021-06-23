
package com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Merchant complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Merchant"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="merchantRefNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="paymentAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="paymentCurrency" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchantType" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Merchant", propOrder = {
    "merchantId",
    "merchantRefNum",
    "paymentAmount",
    "paymentCurrency",
    "merchantType"
})
public class Merchant {

    protected long merchantId;
    @XmlElement(required = true)
    protected String merchantRefNum;
    protected double paymentAmount;
    @XmlElement(required = true)
    protected String paymentCurrency;
    protected int merchantType;

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

    /**
     * Gets the value of the paymentAmount property.
     * 
     */
    public double getPaymentAmount() {
        return paymentAmount;
    }

    /**
     * Sets the value of the paymentAmount property.
     * 
     */
    public void setPaymentAmount(double value) {
        this.paymentAmount = value;
    }

    /**
     * Gets the value of the paymentCurrency property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPaymentCurrency() {
        return paymentCurrency;
    }

    /**
     * Sets the value of the paymentCurrency property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPaymentCurrency(String value) {
        this.paymentCurrency = value;
    }

    /**
     * Gets the value of the merchantType property.
     * 
     */
    public int getMerchantType() {
        return merchantType;
    }

    /**
     * Sets the value of the merchantType property.
     * 
     */
    public void setMerchantType(int value) {
        this.merchantType = value;
    }

}
