/**
 * 
 */
package com.ejada.atmc.acl.ws.domain.yakeen;

/**
 * @author Basel
 *
 */
public class ServiceResponse {

	private int		errorCode;
	private String	errorMessage;
	private String	errorType;

	private int		logId;

	/**
	 * @return the logId
	 */
	public int getLogId() {
		return logId;
	}

	/**
	 * @param logId the logId to set
	 */
	public void setLogId(int logId) {
		this.logId = logId;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
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

	/**
	 * @return the errorType
	 */
	public String getErrorType() {
		return errorType;
	}

	/**
	 * @param errorType the errorType to set
	 */
	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
