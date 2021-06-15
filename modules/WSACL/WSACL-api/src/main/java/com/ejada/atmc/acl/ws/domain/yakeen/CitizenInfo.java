/**
 * 
 */
package com.ejada.atmc.acl.ws.domain.yakeen;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Basel
 *
 */
@XmlRootElement
public class CitizenInfo extends ServiceResponse {

	private String	englishFirstName;
	private String	englishSecondName;
	private String	englishThirdName;
	private String	englishLastName;
	private String	dateOfBirthG;
	private String	gender;
	private String	occupationCode;

	/**
	 * @return the englishFirstName
	 */
	public String getEnglishFirstName() {
		return englishFirstName;
	}

	/**
	 * @param englishFirstName the englishFirstName to set
	 */
	@XmlElement
	public void setEnglishFirstName(String englishFirstName) {
		this.englishFirstName = englishFirstName;
	}

	/**
	 * @return the englishSecondName
	 */
	public String getEnglishSecondName() {
		return englishSecondName;
	}

	/**
	 * @param englishSecondName the englishSecondName to set
	 */
	@XmlElement
	public void setEnglishSecondName(String englishSecondName) {
		this.englishSecondName = englishSecondName;
	}

	/**
	 * @return the englishThirdName
	 */
	public String getEnglishThirdName() {
		return englishThirdName;
	}

	/**
	 * @param englishThirdName the englishThirdName to set
	 */
	@XmlElement
	public void setEnglishThirdName(String englishThirdName) {
		this.englishThirdName = englishThirdName;
	}

	/**
	 * @return the englishLastName
	 */
	public String getEnglishLastName() {
		return englishLastName;
	}

	/**
	 * @param englishLastName the englishLastName to set
	 */
	@XmlElement
	public void setEnglishLastName(String englishLastName) {
		this.englishLastName = englishLastName;
	}

	/**
	 * @return the dateOfBirthG
	 */
	public String getDateOfBirthG() {
		return dateOfBirthG;
	}

	/**
	 * @param dateOfBirthG the dateOfBirthG to set
	 */
	@XmlElement
	public void setDateOfBirthG(String dateOfBirthG) {
		this.dateOfBirthG = dateOfBirthG;
	}

	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * @param gender the gender to set
	 */
	@XmlElement
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * @return the occupationCode
	 */
	public String getOccupationCode() {
		return occupationCode;
	}

	/**
	 * @param occupationCode the occupationCode to set
	 */
	@XmlElement
	public void setOccupationCode(String occupationCode) {
		this.occupationCode = occupationCode;
	}

}
