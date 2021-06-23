
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCarInfoByCustomResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCarInfoByCustomResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CarInfoByCustomResult" type="{http://yakeen4alinmatm.yakeen.elm.com/}carInfoByCustomResult" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCarInfoByCustomResponseMob", propOrder = {
    "carInfoByCustomResult"
})
public class GetCarInfoByCustomResponse {

    @XmlElement(name = "CarInfoByCustomResult")
    protected CarInfoByCustomResult carInfoByCustomResult;

    /**
     * Gets the value of the carInfoByCustomResult property.
     * 
     * @return
     *     possible object is
     *     {@link CarInfoByCustomResult }
     *     
     */
    public CarInfoByCustomResult getCarInfoByCustomResult() {
        return carInfoByCustomResult;
    }

    /**
     * Sets the value of the carInfoByCustomResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link CarInfoByCustomResult }
     *     
     */
    public void setCarInfoByCustomResult(CarInfoByCustomResult value) {
        this.carInfoByCustomResult = value;
    }

}
