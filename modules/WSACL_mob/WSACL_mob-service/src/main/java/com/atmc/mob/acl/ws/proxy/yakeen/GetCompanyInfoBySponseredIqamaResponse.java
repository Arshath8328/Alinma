
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCompanyInfoBySponseredIqamaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCompanyInfoBySponseredIqamaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CompanyInfoBySponseredIqamaResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}companyInfoBySponseredIqamaResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCompanyInfoBySponseredIqamaResponseMob", propOrder = {
    "companyInfoBySponseredIqamaResult"
})
public class GetCompanyInfoBySponseredIqamaResponse {

    @XmlElement(name = "CompanyInfoBySponseredIqamaResult")
    protected CompanyInfoBySponseredIqamaResult companyInfoBySponseredIqamaResult;

    /**
     * Gets the value of the companyInfoBySponseredIqamaResult property.
     * 
     * @return
     *     possible object is
     *     {@link CompanyInfoBySponseredIqamaResult }
     *     
     */
    public CompanyInfoBySponseredIqamaResult getCompanyInfoBySponseredIqamaResult() {
        return companyInfoBySponseredIqamaResult;
    }

    /**
     * Sets the value of the companyInfoBySponseredIqamaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CompanyInfoBySponseredIqamaResult }
     *     
     */
    public void setCompanyInfoBySponseredIqamaResult(CompanyInfoBySponseredIqamaResult value) {
        this.companyInfoBySponseredIqamaResult = value;
    }

}
