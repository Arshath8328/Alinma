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
public class AlienInfo extends CitizenInfo {

	private String	iqamaExpiryDateH;
	private String	iqamaExpiryDateG;
	private short	nationalityCode;
	private short	socialStatusCode;
	private String	dateOfBirthH;

	/**
	 * @return the iqamaExpiryDateH
	 */
	public String getIqamaExpiryDateH() {
		return iqamaExpiryDateH;
	}

	/**
	 * @param iqamaExpiryDateH the iqamaExpiryDateH to set
	 */
	@XmlElement
	public void setIqamaExpiryDateH(String iqamaExpiryDateH) {
		this.iqamaExpiryDateH = iqamaExpiryDateH;
	}

	/**
	 * @return the nationalityCode
	 */
	public short getNationalityCode() {
		return nationalityCode;
	}

	/**
	 * @param nationalityCode the nationalityCode to set
	 */
	@XmlElement
	public void setNationalityCode(short nationalityCode) {
		this.nationalityCode = nationalityCode;
	}

	/**
	 * @return the socialStatusCode
	 */
	public short getSocialStatusCode() {
		return socialStatusCode;
	}

	/**
	 * @param socialStatusCode the socialStatusCode to set
	 */
	@XmlElement
	public void setSocialStatusCode(short socialStatusCode) {
		this.socialStatusCode = socialStatusCode;
	}

	/**
	 * @return the iqamaExpiryDateG
	 */
	public String getIqamaExpiryDateG() {
		return iqamaExpiryDateG;
	}

	/**
	 * @param iqamaExpiryDateG the iqamaExpiryDateG to set
	 */
	@XmlElement
	public void setIqamaExpiryDateG(String iqamaExpiryDateG) {
		this.iqamaExpiryDateG = iqamaExpiryDateG;
	}

	/**
	 * @return the dateOfBirthH
	 */
	public String getDateOfBirthH() {
		return dateOfBirthH;
	}

	/**
	 * @param dateOfBirthH the dateOfBirthH to set
	 */
	@XmlElement
	public void setDateOfBirthH(String dateOfBirthH) {
		this.dateOfBirthH = dateOfBirthH;
	}

}
