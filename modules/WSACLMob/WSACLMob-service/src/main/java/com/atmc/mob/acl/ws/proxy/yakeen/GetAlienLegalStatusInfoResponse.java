
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienLegalStatusInfoResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienLegalStatusInfoResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienLegalStatusInfoResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienLegalStatusInfoResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienLegalStatusInfoResponseMob", propOrder = {
    "alienLegalStatusInfoResult"
})
public class GetAlienLegalStatusInfoResponse {

    @XmlElement(name = "AlienLegalStatusInfoResult")
    protected AlienLegalStatusInfoResult alienLegalStatusInfoResult;

    /**
     * Gets the value of the alienLegalStatusInfoResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienLegalStatusInfoResult }
     *     
     */
    public AlienLegalStatusInfoResult getAlienLegalStatusInfoResult() {
        return alienLegalStatusInfoResult;
    }

    /**
     * Sets the value of the alienLegalStatusInfoResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienLegalStatusInfoResult }
     *     
     */
    public void setAlienLegalStatusInfoResult(AlienLegalStatusInfoResult value) {
        this.alienLegalStatusInfoResult = value;
    }

}
