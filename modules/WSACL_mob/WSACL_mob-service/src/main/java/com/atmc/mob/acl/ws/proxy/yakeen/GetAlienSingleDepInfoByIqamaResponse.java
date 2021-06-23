
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienSingleDepInfoByIqamaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienSingleDepInfoByIqamaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienSingleDepInfoByIqamaResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienSingleDepInfoByIqamaResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienSingleDepInfoByIqamaResponseMob", propOrder = {
    "alienSingleDepInfoByIqamaResult"
})
public class GetAlienSingleDepInfoByIqamaResponse {

    @XmlElement(name = "AlienSingleDepInfoByIqamaResult")
    protected AlienSingleDepInfoByIqamaResult alienSingleDepInfoByIqamaResult;

    /**
     * Gets the value of the alienSingleDepInfoByIqamaResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienSingleDepInfoByIqamaResult }
     *     
     */
    public AlienSingleDepInfoByIqamaResult getAlienSingleDepInfoByIqamaResult() {
        return alienSingleDepInfoByIqamaResult;
    }

    /**
     * Sets the value of the alienSingleDepInfoByIqamaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienSingleDepInfoByIqamaResult }
     *     
     */
    public void setAlienSingleDepInfoByIqamaResult(AlienSingleDepInfoByIqamaResult value) {
        this.alienSingleDepInfoByIqamaResult = value;
    }

}
