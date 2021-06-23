
package com.atmc.mob.acl.ws.proxy.olp.sadadpaymentmanager;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for InitiatePaymentDetailsRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="InitiatePaymentDetailsRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="transactionAmount" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="olpIdAlias" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchantRefNum" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="merchants" type="{http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1}Merchant" maxOccurs="unbounded"/&gt;
 *         &lt;element name="dynamicMerchantLandingURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="dynamicMerchantFailureURL" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="merchantId" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "InitiatePaymentDetailsRequest", propOrder = {
    "transactionAmount",
    "olpIdAlias",
    "merchantRefNum",
    "merchants",
    "dynamicMerchantLandingURL",
    "dynamicMerchantFailureURL",
    "merchantId"
})
public class InitiatePaymentDetailsRequest {

    protected double transactionAmount;
    @XmlElement(required = true)
    protected String olpIdAlias;
    @XmlElement(required = true)
    protected String merchantRefNum;
    @XmlElement(required = true)
    protected List<Merchant> merchants;
    protected String dynamicMerchantLandingURL;
    protected String dynamicMerchantFailureURL;
    protected long merchantId;

    /**
     * Gets the value of the transactionAmount property.
     * 
     */
    public double getTransactionAmount() {
        return transactionAmount;
    }

    /**
     * Sets the value of the transactionAmount property.
     * 
     */
    public void setTransactionAmount(double value) {
        this.transactionAmount = value;
    }

    /**
     * Gets the value of the olpIdAlias property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOlpIdAlias() {
        return olpIdAlias;
    }

    /**
     * Sets the value of the olpIdAlias property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOlpIdAlias(String value) {
        this.olpIdAlias = value;
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
     * Gets the value of the merchants property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the merchants property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getMerchants().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Merchant }
     * 
     * 
     */
    public List<Merchant> getMerchants() {
        if (merchants == null) {
            merchants = new ArrayList<Merchant>();
        }
        return this.merchants;
    }

    /**
     * Gets the value of the dynamicMerchantLandingURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicMerchantLandingURL() {
        return dynamicMerchantLandingURL;
    }

    /**
     * Sets the value of the dynamicMerchantLandingURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicMerchantLandingURL(String value) {
        this.dynamicMerchantLandingURL = value;
    }

    /**
     * Gets the value of the dynamicMerchantFailureURL property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDynamicMerchantFailureURL() {
        return dynamicMerchantFailureURL;
    }

    /**
     * Sets the value of the dynamicMerchantFailureURL property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDynamicMerchantFailureURL(String value) {
        this.dynamicMerchantFailureURL = value;
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

}
