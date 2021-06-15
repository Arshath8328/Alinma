/**
 * 
 */
package com.ejada.atmc.web.common;

import java.io.Serializable;

/**
 * @author Basel
 *
 */
public class UserInfo implements Serializable{
	
	private String id;
	private long userId;
	private String englishName;
	private String arabicName;
	private String mobile;
	private String email;
	private String nationality;
	private String otpSecret;
	private String selectedOrgCRNumber;
	private String selectedOrgName;
	private long selectedOrgId;
	private boolean orgMode;
	
	
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the englishName
	 */
	public String getEnglishName() {
		return englishName;
	}
	/**
	 * @param englishName the englishName to set
	 */
	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}
	/**
	 * @return the arabicName
	 */
	public String getArabicName() {
		return arabicName;
	}
	/**
	 * @param arabicName the arabicName to set
	 */
	public void setArabicName(String arabicName) {
		this.arabicName = arabicName;
	}
	/**
	 * @return the mobile
	 */
	public String getMobile() {
		return mobile;
	}
	/**
	 * @param mobile the mobile to set
	 */
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the nationality
	 */
	public String getNationality() {
		return nationality;
	}
	/**
	 * @param nationality the nationality to set
	 */
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	/**
	 * @return the otpSecret
	 */
	public String getOtpSecret() {
		return otpSecret;
	}
	/**
	 * @param otpSecret the otpSecret to set
	 */
	public void setOtpSecret(String otpSecret) {
		this.otpSecret = otpSecret;
	}
	/**
	 * @return the userId
	 */
	public long getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(long userId) {
		this.userId = userId;
	}
	/**
	 * @return the selectedOrgCRNumber
	 */
	public String getSelectedOrgCRNumber() {
		return selectedOrgCRNumber;
	}
	/**
	 * @param selectedOrgCRNumber the selectedOrgCRNumber to set
	 */
	public void setSelectedOrgCRNumber(String selectedOrgCRNumber) {
		this.selectedOrgCRNumber = selectedOrgCRNumber;
	}
	/**
	 * @return the orgMode
	 */
	public boolean isOrgMode() {
		return orgMode;
	}
	/**
	 * @param orgMode the orgMode to set
	 */
	public void setOrgMode(boolean orgMode) {
		this.orgMode = orgMode;
	}
	/**
	 * @return the selectedOrgName
	 */
	public String getSelectedOrgName() {
		return selectedOrgName;
	}
	/**
	 * @param selectedOrgName the selectedOrgName to set
	 */
	public void setSelectedOrgName(String selectedOrgName) {
		this.selectedOrgName = selectedOrgName;
	}
	/**
	 * @return the selectedOrgId
	 */
	public long getSelectedOrgId() {
		return selectedOrgId;
	}
	/**
	 * @param selectedOrgId the selectedOrgId to set
	 */
	public void setSelectedOrgId(long selectedOrgId) {
		this.selectedOrgId = selectedOrgId;
	}
	
	
	
}
