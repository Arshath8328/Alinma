/**
 * 
 */
package com.atmc.bsl.db.domain;

import java.util.Date;

/**
 * @author Basel
 *
 */
public class AuthUser {
	
	private String userId;
	private String iqamaId;
	private String email;
	private String companyId;
	private String authToken;
	private String mobile;
	private String otpSecret;
	private String englishName;
	private String arabicName;
	private Date lastLoginDate;
	private String workshopId;
	private boolean firstTimeLogin;
	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/**
	 * @return the iqamaId
	 */
	public String getIqamaId() {
		return iqamaId;
	}
	/**
	 * @param iqamaId the iqamaId to set
	 */
	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
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
	 * @return the companyId
	 */
	public String getCompanyId() {
		return companyId;
	}
	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(String companyId) {
		this.companyId = companyId;
	}
	/**
	 * @return the authToken
	 */
	public String getAuthToken() {
		return authToken;
	}
	/**
	 * @param authToken the authToken to set
	 */
	public void setAuthToken(String authToken) {
		this.authToken = authToken;
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
	 * @return the lastLoginDate
	 */
	public Date getLastLoginDate() {
		return lastLoginDate;
	}
	/**
	 * @param lastLoginDate the lastLoginDate to set
	 */
	public void setLastLoginDate(Date lastLoginDate) {
		this.lastLoginDate = lastLoginDate;
	}
	/**
	 * @return the workshopId
	 */
	public String getWorkshopId() {
		return workshopId;
	}
	/**
	 * @param workshopId the workshopId to set
	 */
	public void setWorkshopId(String workshopId) {
		this.workshopId = workshopId;
	}
	/**
	 * @return the firstTimeLogin
	 */
	public boolean isFirstTimeLogin() {
		return firstTimeLogin;
	}
	/**
	 * @param firstTimeLogin the firstTimeLogin to set
	 */
	public void setFirstTimeLogin(boolean firstTimeLogin) {
		this.firstTimeLogin = firstTimeLogin;
	}
	
	
}
