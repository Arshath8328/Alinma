
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for addressList12 complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="addressList12">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="additionalNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="buildingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="city" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="district" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="isPrimaryAddress" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="postCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="streetName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addressList12", propOrder = {
    "additionalNumber",
    "buildingNumber",
    "city",
    "district",
    "isPrimaryAddress",
    "postCode",
    "streetName"
})
public class AddressList12 {

    protected int additionalNumber;
    protected int buildingNumber;
    protected String city;
    protected String district;
    protected boolean isPrimaryAddress;
    protected int postCode;
    protected String streetName;

    /**
     * Gets the value of the additionalNumber property.
     * 
     */
    public int getAdditionalNumber() {
        return additionalNumber;
    }

    /**
     * Sets the value of the additionalNumber property.
     * 
     */
    public void setAdditionalNumber(int value) {
        this.additionalNumber = value;
    }

    /**
     * Gets the value of the buildingNumber property.
     * 
     */
    public int getBuildingNumber() {
        return buildingNumber;
    }

    /**
     * Sets the value of the buildingNumber property.
     * 
     */
    public void setBuildingNumber(int value) {
        this.buildingNumber = value;
    }

    /**
     * Gets the value of the city property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCity() {
        return city;
    }

    /**
     * Sets the value of the city property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCity(String value) {
        this.city = value;
    }

    /**
     * Gets the value of the district property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets the value of the district property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDistrict(String value) {
        this.district = value;
    }

    /**
     * Gets the value of the isPrimaryAddress property.
     * 
     */
    public boolean isIsPrimaryAddress() {
        return isPrimaryAddress;
    }

    /**
     * Sets the value of the isPrimaryAddress property.
     * 
     */
    public void setIsPrimaryAddress(boolean value) {
        this.isPrimaryAddress = value;
    }

    /**
     * Gets the value of the postCode property.
     * 
     */
    public int getPostCode() {
        return postCode;
    }

    /**
     * Sets the value of the postCode property.
     * 
     */
    public void setPostCode(int value) {
        this.postCode = value;
    }

    /**
     * Gets the value of the streetName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStreetName() {
        return streetName;
    }

    /**
     * Sets the value of the streetName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStreetName(String value) {
        this.streetName = value;
    }

}
