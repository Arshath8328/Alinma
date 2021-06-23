/**
 * 
 */
package com.atmc.bsl.db.domain.claim;

import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;

/**
 * @author Basel
 *
 */
public class ClaimIntimation {
	private ODSClaimIntimation odsClaimIntimation;
	private NajmClaimIntimation najmClaimIntimation;

	/**
	 * @return the odsClaimIntimation
	 */
	public ODSClaimIntimation getOdsClaimIntimation() {
		return odsClaimIntimation;
	}

	/**
	 * @param odsClaimIntimation the odsClaimIntimation to set
	 */
	public void setOdsClaimIntimation(ODSClaimIntimation odsClaimIntimation) {
		this.odsClaimIntimation = odsClaimIntimation;
	}

	/**
	 * @return the najmClaimIntimation
	 */
	public NajmClaimIntimation getNajmClaimIntimation() {
		return najmClaimIntimation;
	}

	/**
	 * @param najmClaimIntimation the najmClaimIntimation to set
	 */
	public void setNajmClaimIntimation(NajmClaimIntimation najmClaimIntimation) {
		this.najmClaimIntimation = najmClaimIntimation;
	}

}
