package com.ejada.atmc.acl.ws.domain.ods;

public class ODSPolicy {
	protected String	referenceno;

	protected String	source;

	protected String	transaction;

	protected String	productcode;

	protected String	policyeffdate;

	protected String	paymentmethod;

	protected double	paymentamount;

	protected String	paymentrefno;

	/**
	 * @return the referenceno
	 */
	public String getReferenceno() {
		return referenceno;
	}

	/**
	 * @param referenceno the referenceno to set
	 */
	public void setReferenceno(String referenceno) {
		this.referenceno = referenceno;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the transaction
	 */
	public String getTransaction() {
		return transaction;
	}

	/**
	 * @param transaction the transaction to set
	 */
	public void setTransaction(String transaction) {
		this.transaction = transaction;
	}

	/**
	 * @return the productcode
	 */
	public String getProductcode() {
		return productcode;
	}

	/**
	 * @param productcode the productcode to set
	 */
	public void setProductcode(String productcode) {
		this.productcode = productcode;
	}

	/**
	 * @return the policyeffdate
	 */
	public String getPolicyeffdate() {
		return policyeffdate;
	}

	/**
	 * @param policyeffdate the policyeffdate to set
	 */
	public void setPolicyeffdate(String policyeffdate) {
		this.policyeffdate = policyeffdate;
	}

	/**
	 * @return the paymentmethod
	 */
	public String getPaymentmethod() {
		return paymentmethod;
	}

	/**
	 * @param paymentmethod the paymentmethod to set
	 */
	public void setPaymentmethod(String paymentmethod) {
		this.paymentmethod = paymentmethod;
	}

	/**
	 * @return the paymentamount
	 */
	public double getPaymentamount() {
		return paymentamount;
	}

	/**
	 * @param paymentamount the paymentamount to set
	 */
	public void setPaymentamount(double paymentamount) {
		this.paymentamount = paymentamount;
	}

	/**
	 * @return the paymentrefno
	 */
	public String getPaymentrefno() {
		return paymentrefno;
	}

	/**
	 * @param paymentrefno the paymentrefno to set
	 */
	public void setPaymentrefno(String paymentrefno) {
		this.paymentrefno = paymentrefno;
	}

}
