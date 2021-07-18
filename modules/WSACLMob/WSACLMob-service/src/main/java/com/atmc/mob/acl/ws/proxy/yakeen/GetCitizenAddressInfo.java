
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getCitizenAddressInfo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getCitizenAddressInfo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="CitizenAddressInfoRequest" type="{http://yakeen4alinmatm.yakeen.elm.com/}citizenAddressInfoRequest" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getCitizenAddressInfoMob", propOrder = {
    "citizenAddressInfoRequest"
})
public class GetCitizenAddressInfo {

    @XmlElement(name = "CitizenAddressInfoRequest")
    protected CitizenAddressInfoRequest citizenAddressInfoRequest;

    /**
     * Gets the value of the citizenAddressInfoRequest property.
     * 
     * @return
     *     possible object is
     *     {@link CitizenAddressInfoRequest }
     *     
     */
    public CitizenAddressInfoRequest getCitizenAddressInfoRequest() {
        return citizenAddressInfoRequest;
    }

    /**
     * Sets the value of the citizenAddressInfoRequest property.
     * 
     * @param value
     *     allowed object is
     *     {@link CitizenAddressInfoRequest }
     *     
     */
    public void setCitizenAddressInfoRequest(CitizenAddressInfoRequest value) {
        this.citizenAddressInfoRequest = value;
    }

}
