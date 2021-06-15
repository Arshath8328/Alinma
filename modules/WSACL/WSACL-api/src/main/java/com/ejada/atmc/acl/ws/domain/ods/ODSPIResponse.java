package com.ejada.atmc.acl.ws.domain.ods;

public class ODSPIResponse {
	private String	referenceno;

	private String	statuscode;

	private String	message;

	private String	policyno;

	private String	policyeffectivefrom;

	private String	policyeffectiveto;

	private String	policyissuedate;

	private double	policyamountorpremium;

	private String	policyfeatures;

	private int		maxliability;

	private String	additionaldetailsifany;

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
	 * @return the statuscode
	 */
	public String getStatuscode() {
		return statuscode;
	}

	/**
	 * @param statuscode the statuscode to set
	 */
	public void setStatuscode(String statuscode) {
		this.statuscode = statuscode;
	}

	/**
	 * @return the errormessage
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param errormessage the errormessage to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/**
	 * @return the policyno
	 */
	public String getPolicyno() {
		return policyno;
	}

	/**
	 * @param policyno the policyno to set
	 */
	public void setPolicyno(String policyno) {
		this.policyno = policyno;
	}

	/**
	 * @return the policyeffectivefrom
	 */
	public String getPolicyeffectivefrom() {
		return policyeffectivefrom;
	}

	/**
	 * @param policyeffectivefrom the policyeffectivefrom to set
	 */
	public void setPolicyeffectivefrom(String policyeffectivefrom) {
		this.policyeffectivefrom = policyeffectivefrom;
	}

	/**
	 * @return the policyeffectiveto
	 */
	public String getPolicyeffectiveto() {
		return policyeffectiveto;
	}

	/**
	 * @param policyeffectiveto the policyeffectiveto to set
	 */
	public void setPolicyeffectiveto(String policyeffectiveto) {
		this.policyeffectiveto = policyeffectiveto;
	}

	/**
	 * @return the policyissuedate
	 */
	public String getPolicyissuedate() {
		return policyissuedate;
	}

	/**
	 * @param policyissuedate the policyissuedate to set
	 */
	public void setPolicyissuedate(String policyissuedate) {
		this.policyissuedate = policyissuedate;
	}

	/**
	 * @return the policyamountorpremium
	 */
	public double getPolicyamountorpremium() {
		return policyamountorpremium;
	}

	/**
	 * @param policyamountorpremium the policyamountorpremium to set
	 */
	public void setPolicyamountorpremium(double policyamountorpremium) {
		this.policyamountorpremium = policyamountorpremium;
	}

	/**
	 * @return the policyfeatures
	 */
	public String getPolicyfeatures() {
		return policyfeatures;
	}

	/**
	 * @param policyfeatures the policyfeatures to set
	 */
	public void setPolicyfeatures(String policyfeatures) {
		this.policyfeatures = policyfeatures;
	}

	/**
	 * @return the maxliability
	 */
	public int getMaxliability() {
		return maxliability;
	}

	/**
	 * @param maxliability the maxliability to set
	 */
	public void setMaxliability(int maxliability) {
		this.maxliability = maxliability;
	}

	/**
	 * @return the additionaldetailsifany
	 */
	public String getAdditionaldetailsifany() {
		return additionaldetailsifany;
	}

	/**
	 * @param additionaldetailsifany the additionaldetailsifany to set
	 */
	public void setAdditionaldetailsifany(String additionaldetailsifany) {
		this.additionaldetailsifany = additionaldetailsifany;
	}

}
