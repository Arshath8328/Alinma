
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienInfoByIqamaResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByIqamaResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByIqamaResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByIqamaResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienInfoByIqamaResponseMob", propOrder = {
    "alienInfoByIqamaResult"
})
public class GetAlienInfoByIqamaResponse {

    @XmlElement(name = "AlienInfoByIqamaResult")
    protected AlienInfoByIqamaResult alienInfoByIqamaResult;

    /**
     * Gets the value of the alienInfoByIqamaResult property.
     * 
     * @return
     *     possible object is
     *     {@link AlienInfoByIqamaResult }
     *     
     */
    public AlienInfoByIqamaResult getAlienInfoByIqamaResult() {
        return alienInfoByIqamaResult;
    }

    /**
     * Sets the value of the alienInfoByIqamaResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienInfoByIqamaResult }
     *     
     */
    public void setAlienInfoByIqamaResult(AlienInfoByIqamaResult value) {
        this.alienInfoByIqamaResult = value;
    }

}
