package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * 
 * @author Ehab
 *
 */
public class PurchaseNotificationsResponse {

	@JsonProperty("Status")
	private boolean status;
	
	private List<Error> errors;

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}
}
