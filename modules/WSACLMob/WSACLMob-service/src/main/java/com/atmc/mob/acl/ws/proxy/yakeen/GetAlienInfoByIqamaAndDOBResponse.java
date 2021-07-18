
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienInfoByIqamaAndDOBResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByIqamaAndDOBResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByIqamaAndDOBResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByIqamaAndDOBResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienInfoByIqamaAndDOBResponseMob", propOrder = {
    "alienInfoByIqamaAndDOBResult"
})
public class GetAlienInfoByIqamaAndDOBResponse {

    @XmlElement(name = "AlienInfoByIqamaAndDOBResult")
    protected AlienInfoByIqamaAndDOBResult alienInfoByIqamaAndDOBResult;

    /**
     * Gets the value of the alienInfoByIqamaAndDOBResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienInfoByIqamaAndDOBResult }
     *     
     */
    public AlienInfoByIqamaAndDOBResult getAlienInfoByIqamaAndDOBResult() {
        return alienInfoByIqamaAndDOBResult;
    }

    /**
     * Sets the value of the alienInfoByIqamaAndDOBResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienInfoByIqamaAndDOBResult }
     *     
     */
    public void setAlienInfoByIqamaAndDOBResult(AlienInfoByIqamaAndDOBResult value) {
        this.alienInfoByIqamaAndDOBResult = value;
    }

}
