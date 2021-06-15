
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for alienInfoByBorderNumberResult complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="alienInfoByBorderNumberResult">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="dateOfBirthG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="familyName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="firstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="gender" type="{http://yakeen4alinmatm.yakeen.elm.com/}gender" minOccurs="0"/>
 *         &lt;element name="grandFatherName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="logId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nationalityCode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="occupationCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="seconedName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "alienInfoByBorderNumberResult",
		propOrder = { "dateOfBirthG", "familyName", "firstName", "gender", "grandFatherName", "logId", "nationalityCode", "occupationCode", "seconedName" }
)
public class AlienInfoByBorderNumberResult {

	protected String	dateOfBirthG;
	protected String	familyName;
	protected String	firstName;
	@XmlSchemaType(
			name = "string"
	)
	protected Gender	gender;
	protected String	grandFatherName;
	protected int		logId;
	protected short		nationalityCode;
	protected int		occupationCode;
	protected String	seconedName;

	/**
	 * Gets the value of the dateOfBirthG property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDateOfBirthG() {
		return dateOfBirthG;
	}

	/**
	 * Sets the value of the dateOfBirthG property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDateOfBirthG(String value) {
		this.dateOfBirthG = value;
	}

	/**
	 * Gets the value of the familyName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFamilyName() {
		return familyName;
	}

	/**
	 * Sets the value of the familyName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFamilyName(String value) {
		this.familyName = value;
	}

	/**
	 * Gets the value of the firstName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the value of the firstName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setFirstName(String value) {
		this.firstName = value;
	}

	/**
	 * Gets the value of the gender property.
	 * 
	 * @return possible object is {@link Gender }
	 * 
	 */
	public Gender getGender() {
		return gender;
	}

	/**
	 * Sets the value of the gender property.
	 * 
	 * @param value allowed object is {@link Gender }
	 * 
	 */
	public void setGender(Gender value) {
		this.gender = value;
	}

	/**
	 * Gets the value of the grandFatherName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getGrandFatherName() {
		return grandFatherName;
	}

	/**
	 * Sets the value of the grandFatherName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setGrandFatherName(String value) {
		this.grandFatherName = value;
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
	 * Gets the value of the seconedName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getSeconedName() {
		return seconedName;
	}

	/**
	 * Sets the value of the seconedName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setSeconedName(String value) {
		this.seconedName = value;
	}

}
