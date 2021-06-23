package com.atmc.bsl.db.domain.claim;

public class NajmClaimIntimation {
	private NajmClaim claimant;
	private NajmClaim otherParty;
	private String claimantPolicyType;
	private String otherPartyPolicyType;
	private boolean claimantATMC;
	private boolean otherPartyATMC;
	private String claimantVehicleType;
	private String claimantVehicleNumber;

	/**
	 * @return the claimantPolicyType
	 */
	public String getClaimantPolicyType() {
		return claimantPolicyType;
	}

	/**
	 * @param claimantPolicyType the claimantPolicyType to set
	 */
	public void setClaimantPolicyType(String claimantPolicyType) {
		this.claimantPolicyType = claimantPolicyType;
	}

	/**
	 * @return the otherPartyPolicyType
	 */
	public String getOtherPartyPolicyType() {
		return otherPartyPolicyType;
	}

	/**
	 * @param otherPartyPolicyType the otherPartyPolicyType to set
	 */
	public void setOtherPartyPolicyType(String otherPartyPolicyType) {
		this.otherPartyPolicyType = otherPartyPolicyType;
	}

	/**
	 * @return the claimantATMC
	 */
	public boolean isClaimantATMC() {
		return claimantATMC;
	}

	/**
	 * @param claimantATMC the claimantATMC to set
	 */
	public void setClaimantATMC(boolean claimantATMC) {
		this.claimantATMC = claimantATMC;
	}

	/**
	 * @return the otherPartyATMC
	 */
	public boolean isOtherPartyATMC() {
		return otherPartyATMC;
	}

	/**
	 * @param otherPartyATMC the otherPartyATMC to set
	 */
	public void setOtherPartyATMC(boolean otherPartyATMC) {
		this.otherPartyATMC = otherPartyATMC;
	}

	/**
	 * @return the claimant
	 */
	public NajmClaim getClaimant() {
		return claimant;
	}

	/**
	 * @param claimant the claimant to set
	 */
	public void setClaimant(NajmClaim claimant) {
		this.claimant = claimant;
	}

	/**
	 * @return the otherParty
	 */
	public NajmClaim getOtherParty() {
		return otherParty;
	}

	/**
	 * @param otherParty the otherParty to set
	 */
	public void setOtherParty(NajmClaim otherParty) {
		this.otherParty = otherParty;
	}

	/**
	 * @return the claimantVehicleType
	 */
	public String getClaimantVehicleType() {
		return claimantVehicleType;
	}

	/**
	 * @param claimantVehicleType the claimantVehicleType to set
	 */
	public void setClaimantVehicleType(String claimantVehicleType) {
		this.claimantVehicleType = claimantVehicleType;
	}

	/**
	 * @return the claimantVehicleNumber
	 */
	public String getClaimantVehicleNumber() {
		return claimantVehicleNumber;
	}

	/**
	 * @param claimantVehicleNumber the claimantVehicleNumber to set
	 */
	public void setClaimantVehicleNumber(String claimantVehicleNumber) {
		this.claimantVehicleNumber = claimantVehicleNumber;
	}

}
