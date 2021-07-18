
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienCarInfoBySequenceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienCarInfoBySequenceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienCarInfoBySequenceResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienCarInfoBySequenceResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienCarInfoBySequenceResponseMob", propOrder = {
    "alienCarInfoBySequenceResult"
})
public class GetAlienCarInfoBySequenceResponse {

    @XmlElement(name = "AlienCarInfoBySequenceResult")
    protected AlienCarInfoBySequenceResult alienCarInfoBySequenceResult;

    /**
     * Gets the value of the alienCarInfoBySequenceResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienCarInfoBySequenceResult }
     *     
     */
    public AlienCarInfoBySequenceResult getAlienCarInfoBySequenceResult() {
        return alienCarInfoBySequenceResult;
    }

    /**
     * Sets the value of the alienCarInfoBySequenceResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienCarInfoBySequenceResult }
     *     
     */
    public void setAlienCarInfoBySequenceResult(AlienCarInfoBySequenceResult value) {
        this.alienCarInfoBySequenceResult = value;
    }

}
