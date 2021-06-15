/**
 * 
 */
package com.ejada.atmc.acl.ws.domain.yakeen;

/**
 * @author Basel
 *
 */
public class CompanyInfo extends ServiceResponse {

	private int	totalNumberOfSponsoredDependents;
	private int	totalNumberOfSponsoreds;

	/**
	 * @return the totalNumberOfSponsoredDependents
	 */
	public int getTotalNumberOfSponsoredDependents() {
		return totalNumberOfSponsoredDependents;
	}

	/**
	 * @param totalNumberOfSponsoredDependents the totalNumberOfSponsoredDependents to set
	 */
	public void setTotalNumberOfSponsoredDependents(int totalNumberOfSponsoredDependents) {
		this.totalNumberOfSponsoredDependents = totalNumberOfSponsoredDependents;
	}

	/**
	 * @return the totalNumberOfSponsoreds
	 */
	public int getTotalNumberOfSponsoreds() {
		return totalNumberOfSponsoreds;
	}

	/**
	 * @param totalNumberOfSponsoreds the totalNumberOfSponsoreds to set
	 */
	public void setTotalNumberOfSponsoreds(int totalNumberOfSponsoreds) {
		this.totalNumberOfSponsoreds = totalNumberOfSponsoreds;
	}

}
