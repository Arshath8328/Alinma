
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienAllDepInfoByIqamaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienAllDepInfoByIqamaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienAllDepInfoByIqamaResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienAllDepInfoByIqamaResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienAllDepInfoByIqamaResponseMob", propOrder = {
    "alienAllDepInfoByIqamaResult"
})
public class GetAlienAllDepInfoByIqamaResponse {

    @XmlElement(name = "AlienAllDepInfoByIqamaResult")
    protected AlienAllDepInfoByIqamaResult alienAllDepInfoByIqamaResult;

    /**
     * Gets the value of the alienAllDepInfoByIqamaResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienAllDepInfoByIqamaResult }
     *     
     */
    public AlienAllDepInfoByIqamaResult getAlienAllDepInfoByIqamaResult() {
        return alienAllDepInfoByIqamaResult;
    }

    /**
     * Sets the value of the alienAllDepInfoByIqamaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienAllDepInfoByIqamaResult }
     *     
     */
    public void setAlienAllDepInfoByIqamaResult(AlienAllDepInfoByIqamaResult value) {
        this.alienAllDepInfoByIqamaResult = value;
    }

}
