package com.atmc.bsl.db.domain.claim;

public class ClaimWorkflow {
	
	private String role;
	private String initialStatus;
	private String action;
	private String newStatus;
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the initialStatus
	 */
	public String getInitialStatus() {
		return initialStatus;
	}
	/**
	 * @param initialStatus the initialStatus to set
	 */
	public void setInitialStatus(String initialStatus) {
		this.initialStatus = initialStatus;
	}
	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}
	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}
	/**
	 * @return the newStatus
	 */
	public String getNewStatus() {
		return newStatus;
	}
	/**
	 * @param newStatus the newStatus to set
	 */
	public void setNewStatus(String newStatus) {
		this.newStatus = newStatus;
	}
	
}
