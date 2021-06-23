
package com.atmc.mob.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for alienInfoByIqamaResult complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienInfoByIqamaResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateOfBirthG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishSecondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="englishThirdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://yakeen4alinmatm.yakeen.elm.com/}gender" minOccurs="0"/>
 *         &lt;element name="iqamaExpiryDateH" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nationalityCode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="occupationCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="socialStatusCode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "alienInfoByIqamaResult", propOrder = {
    "dateOfBirthG",
    "englishFirstName",
    "englishLastName",
    "englishSecondName",
    "englishThirdName",
    "gender",
    "iqamaExpiryDateH",
    "logId",
    "nationalityCode",
    "occupationCode",
    "socialStatusCode"
})
public class AlienInfoByIqamaResult {

    protected String dateOfBirthG;
    protected String englishFirstName;
    protected String englishLastName;
    protected String englishSecondName;
    protected String englishThirdName;
    @XmlSchemaType(name = "string")
    protected Gender gender;
    protected String iqamaExpiryDateH;
    protected int logId;
    protected short nationalityCode;
    protected int occupationCode;
    protected short socialStatusCode;

    /**
     * Gets the value of the dateOfBirthG property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateOfBirthG() {
        return dateOfBirthG;
    }

    /**
     * Sets the value of the dateOfBirthG property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateOfBirthG(String value) {
        this.dateOfBirthG = value;
    }

    /**
     * Gets the value of the englishFirstName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishFirstName() {
        return englishFirstName;
    }

    /**
     * Sets the value of the englishFirstName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishFirstName(String value) {
        this.englishFirstName = value;
    }

    /**
     * Gets the value of the englishLastName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishLastName() {
        return englishLastName;
    }

    /**
     * Sets the value of the englishLastName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishLastName(String value) {
        this.englishLastName = value;
    }

    /**
     * Gets the value of the englishSecondName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishSecondName() {
        return englishSecondName;
    }

    /**
     * Sets the value of the englishSecondName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishSecondName(String value) {
        this.englishSecondName = value;
    }

    /**
     * Gets the value of the englishThirdName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEnglishThirdName() {
        return englishThirdName;
    }

    /**
     * Sets the value of the englishThirdName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEnglishThirdName(String value) {
        this.englishThirdName = value;
    }

    /**
     * Gets the value of the gender property.
     * 
     * @return
     *     possible object is
     *     {@link Gender }
     *     
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * Sets the value of the gender property.
     * 
     * @param value
     *     allowed object is
     *     {@link Gender }
     *     
     */
    public void setGender(Gender value) {
        this.gender = value;
    }

    /**
     * Gets the value of the iqamaExpiryDateH property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getIqamaExpiryDateH() {
        return iqamaExpiryDateH;
    }

    /**
     * Sets the value of the iqamaExpiryDateH property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setIqamaExpiryDateH(String value) {
        this.iqamaExpiryDateH = value;
    }

    /**
     * Gets the value of the logId property.
     * 
     */
    public int getLogId() {
        return logId;
    }

    /**
     * Sets the value of the logId property.
     * 
     */
    public void setLogId(int value) {
        this.logId = value;
    }

    /**
     * Gets the value of the nationalityCode property.
     * 
     */
    public short getNationalityCode() {
        return nationalityCode;
    }

    /**
     * Sets the value of the nationalityCode property.
     * 
     */
    public void setNationalityCode(short value) {
        this.nationalityCode = value;
    }

    /**
     * Gets the value of the occupationCode property.
     * 
     */
    public int getOccupationCode() {
        return occupationCode;
    }

    /**
     * Sets the value of the occupationCode property.
     * 
     */
    public void setOccupationCode(int value) {
        this.occupationCode = value;
    }

    /**
     * Gets the value of the socialStatusCode property.
     * 
     */
    public short getSocialStatusCode() {
        return socialStatusCode;
    }

    /**
     * Sets the value of the socialStatusCode property.
     * 
     */
    public void setSocialStatusCode(short value) {
        this.socialStatusCode = value;
    }

}
