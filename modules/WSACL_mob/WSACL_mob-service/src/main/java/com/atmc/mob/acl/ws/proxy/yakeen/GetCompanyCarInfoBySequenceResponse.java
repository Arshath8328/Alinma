
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCompanyCarInfoBySequenceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyCarInfoBySequenceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyCarInfoBySequenceResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyCarInfoBySequenceResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompanyCarInfoBySequenceResponseMob", propOrder = {
    "companyCarInfoBySequenceResult"
})
public class GetCompanyCarInfoBySequenceResponse {

    @XmlElement(name = "CompanyCarInfoBySequenceResult")
    protected CompanyCarInfoBySequenceResult companyCarInfoBySequenceResult;

    /**
     * Gets the value of the companyCarInfoBySequenceResult property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyCarInfoBySequenceResult }
     *     
     */
    public CompanyCarInfoBySequenceResult getCompanyCarInfoBySequenceResult() {
        return companyCarInfoBySequenceResult;
    }

    /**
     * Sets the value of the companyCarInfoBySequenceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyCarInfoBySequenceResult }
     *     
     */
    public void setCompanyCarInfoBySequenceResult(CompanyCarInfoBySequenceResult value) {
        this.companyCarInfoBySequenceResult = value;
    }

}
