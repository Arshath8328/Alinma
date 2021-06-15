
package com.ejada.atmc.acl.ws.proxy.yakeen;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for dependentsList6 complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dependentsList6">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="depBirthDateG" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depEnglishFirstName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depEnglishLastName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depEnglishSecondName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depEnglishThirdName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depGender" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="depIqamaNo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depNationalityNICCode" type="{http://www.w3.org/2001/XMLSchema}short"/>
 *         &lt;element name="depOccupationCode" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="depRelationship" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="depSocialStatusCode" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
		name = "dependentsList6",
		propOrder = { "depBirthDateG", "depEnglishFirstName", "depEnglishLastName", "depEnglishSecondName", "depEnglishThirdName", "depGender", "depIqamaNo", "depNationalityNICCode",
				"depOccupationCode", "depRelationship", "depSocialStatusCode" }
)
public class DependentsList6 {

	protected String	depBirthDateG;
	protected String	depEnglishFirstName;
	protected String	depEnglishLastName;
	protected String	depEnglishSecondName;
	protected String	depEnglishThirdName;
	protected short		depGender;
	protected String	depIqamaNo;
	protected short		depNationalityNICCode;
	protected int		depOccupationCode;
	protected String	depRelationship;
	protected String	depSocialStatusCode;

	/**
	 * Gets the value of the depBirthDateG property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepBirthDateG() {
		return depBirthDateG;
	}

	/**
	 * Sets the value of the depBirthDateG property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepBirthDateG(String value) {
		this.depBirthDateG = value;
	}

	/**
	 * Gets the value of the depEnglishFirstName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepEnglishFirstName() {
		return depEnglishFirstName;
	}

	/**
	 * Sets the value of the depEnglishFirstName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepEnglishFirstName(String value) {
		this.depEnglishFirstName = value;
	}

	/**
	 * Gets the value of the depEnglishLastName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepEnglishLastName() {
		return depEnglishLastName;
	}

	/**
	 * Sets the value of the depEnglishLastName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepEnglishLastName(String value) {
		this.depEnglishLastName = value;
	}

	/**
	 * Gets the value of the depEnglishSecondName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepEnglishSecondName() {
		return depEnglishSecondName;
	}

	/**
	 * Sets the value of the depEnglishSecondName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepEnglishSecondName(String value) {
		this.depEnglishSecondName = value;
	}

	/**
	 * Gets the value of the depEnglishThirdName property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepEnglishThirdName() {
		return depEnglishThirdName;
	}

	/**
	 * Sets the value of the depEnglishThirdName property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepEnglishThirdName(String value) {
		this.depEnglishThirdName = value;
	}

	/**
	 * Gets the value of the depGender property.
	 * 
	 */
	public short getDepGender() {
		return depGender;
	}

	/**
	 * Sets the value of the depGender property.
	 * 
	 */
	public void setDepGender(short value) {
		this.depGender = value;
	}

	/**
	 * Gets the value of the depIqamaNo property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepIqamaNo() {
		return depIqamaNo;
	}

	/**
	 * Sets the value of the depIqamaNo property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepIqamaNo(String value) {
		this.depIqamaNo = value;
	}

	/**
	 * Gets the value of the depNationalityNICCode property.
	 * 
	 */
	public short getDepNationalityNICCode() {
		return depNationalityNICCode;
	}

	/**
	 * Sets the value of the depNationalityNICCode property.
	 * 
	 */
	public void setDepNationalityNICCode(short value) {
		this.depNationalityNICCode = value;
	}

	/**
	 * Gets the value of the depOccupationCode property.
	 * 
	 */
	public int getDepOccupationCode() {
		return depOccupationCode;
	}

	/**
	 * Sets the value of the depOccupationCode property.
	 * 
	 */
	public void setDepOccupationCode(int value) {
		this.depOccupationCode = value;
	}

	/**
	 * Gets the value of the depRelationship property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepRelationship() {
		return depRelationship;
	}

	/**
	 * Sets the value of the depRelationship property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepRelationship(String value) {
		this.depRelationship = value;
	}

	/**
	 * Gets the value of the depSocialStatusCode property.
	 * 
	 * @return possible object is {@link String }
	 * 
	 */
	public String getDepSocialStatusCode() {
		return depSocialStatusCode;
	}

	/**
	 * Sets the value of the depSocialStatusCode property.
	 * 
	 * @param value allowed object is {@link String }
	 * 
	 */
	public void setDepSocialStatusCode(String value) {
		this.depSocialStatusCode = value;
	}

}
