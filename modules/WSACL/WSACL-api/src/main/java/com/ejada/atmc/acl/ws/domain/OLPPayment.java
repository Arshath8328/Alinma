/**
 * 
 */
package com.ejada.atmc.acl.ws.domain;

/**
 * @author Basel
 *
 */
public class OLPPayment {

	private String	responseCode	= "";
	private String	abRefNum		= "";
	private String	merchantRefNum	= "";
	private String	errorCode		= "";
	private String	errorMessage	= "";

	/**
	 * @return the responseCode
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * @param responseCode the responseCode to set
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * @return the abRefNum
	 */
	public String getAbRefNum() {
		return abRefNum;
	}

	/**
	 * @param abRefNum the abRefNum to set
	 */
	public void setAbRefNum(String abRefNum) {
		this.abRefNum = abRefNum;
	}

	/**
	 * @return the merchantRefNum
	 */
	public String getMerchantRefNum() {
		return merchantRefNum;
	}

	/**
	 * @param merchantRefNum the merchantRefNum to set
	 */
	public void setMerchantRefNum(String merchantRefNum) {
		this.merchantRefNum = merchantRefNum;
	}

	/**
	 * @return the errorCode
	 */
	public String getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorMessage
	 */
	public String getErrorMessage() {
		return errorMessage;
	}

	/**
	 * @param errorMessage the errorMessage to set
	 */
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

}
