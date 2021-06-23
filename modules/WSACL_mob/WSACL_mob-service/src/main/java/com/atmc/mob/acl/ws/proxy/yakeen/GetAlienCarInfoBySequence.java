
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienCarInfoBySequence complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienCarInfoBySequence">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienCarInfoBySequenceRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienCarInfoBySequenceRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienCarInfoBySequenceMob", propOrder = {
    "alienCarInfoBySequenceRequest"
})
public class GetAlienCarInfoBySequence {

    @XmlElement(name = "AlienCarInfoBySequenceRequest")
    protected AlienCarInfoBySequenceRequest alienCarInfoBySequenceRequest;

    /**
     * Gets the value of the alienCarInfoBySequenceRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AlienCarInfoBySequenceRequest }
     *     
     */
    public AlienCarInfoBySequenceRequest getAlienCarInfoBySequenceRequest() {
        return alienCarInfoBySequenceRequest;
    }

    /**
     * Sets the value of the alienCarInfoBySequenceRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienCarInfoBySequenceRequest }
     *     
     */
    public void setAlienCarInfoBySequenceRequest(AlienCarInfoBySequenceRequest value) {
        this.alienCarInfoBySequenceRequest = value;
    }

}
