package com.ejada.atmc.acl.ws.domain.ods;

public class ODSCIResponse {
	private String	claimintimationno;
	private String	status;
	private String	message;

	/**
	 * @return the claimintimationno
	 */
	public String getClaimintimationno() {
		return claimintimationno;
	}

	/**
	 * @param claimintimationno the claimintimationno to set
	 */
	public void setClaimintimationno(String claimintimationno) {
		this.claimintimationno = claimintimationno;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
