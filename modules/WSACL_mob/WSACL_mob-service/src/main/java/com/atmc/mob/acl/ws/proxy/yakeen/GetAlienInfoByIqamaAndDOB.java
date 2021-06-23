
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getAlienInfoByIqamaAndDOB complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getAlienInfoByIqamaAndDOB">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="AlienInfoByIqamaAndDOBRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}alienInfoByIqamaAndDOBRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getAlienInfoByIqamaAndDOBMob", propOrder = {
    "alienInfoByIqamaAndDOBRequest"
})
public class GetAlienInfoByIqamaAndDOB {

    @XmlElement(name = "AlienInfoByIqamaAndDOBRequest")
    protected AlienInfoByIqamaAndDOBRequest alienInfoByIqamaAndDOBRequest;

    /**
     * Gets the value of the alienInfoByIqamaAndDOBRequest property.
     * 
     * @return
     *     possible object is
     *     {@link AlienInfoByIqamaAndDOBRequest }
     *     
     */
    public AlienInfoByIqamaAndDOBRequest getAlienInfoByIqamaAndDOBRequest() {
        return alienInfoByIqamaAndDOBRequest;
    }

    /**
     * Sets the value of the alienInfoByIqamaAndDOBRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link AlienInfoByIqamaAndDOBRequest }
     *     
     */
    public void setAlienInfoByIqamaAndDOBRequest(AlienInfoByIqamaAndDOBRequest value) {
        this.alienInfoByIqamaAndDOBRequest = value;
    }

}
