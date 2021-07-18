
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for Yakeen4AlinmaTMFault complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Yakeen4AlinmaTMFault">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="commonErrorObject" type="{http://yakeen4alinmatm.yakeen.elm.com/}CommonErrorObject"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Yakeen4AlinmaTMFault", propOrder = {
    "commonErrorObject"
})
public class Yakeen4AlinmaTMFault {

    @XmlElement(required = true, nillable = true)
    protected CommonErrorObject commonErrorObject;

    /**
     * Gets the value of the commonErrorObject property.
     * 
     * @return
     *     possible object is
     *     {@link CommonErrorObject }
     *     
     */
    public CommonErrorObject getCommonErrorObject() {
        return commonErrorObject;
    }

    /**
     * Sets the value of the commonErrorObject property.
     * 
     * @param value
     *     allowed object is
     *     {@link CommonErrorObject }
     *     
     */
    public void setCommonErrorObject(CommonErrorObject value) {
        this.commonErrorObject = value;
    }

}
