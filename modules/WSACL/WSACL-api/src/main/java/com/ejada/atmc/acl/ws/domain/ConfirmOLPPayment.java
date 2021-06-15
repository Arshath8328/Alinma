/**
 * 
 */
package com.ejada.atmc.acl.ws.domain;

/**
 * @author Basel
 *
 */
public class ConfirmOLPPayment extends OLPPayment {

	private String	paymentStatus	= "";
	private String	transactionId	= "";

	/**
	 * @return the paymentStatus
	 */
	public String getPaymentStatus() {
		return paymentStatus;
	}

	/**
	 * @param paymentStatus the paymentStatus to set
	 */
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
