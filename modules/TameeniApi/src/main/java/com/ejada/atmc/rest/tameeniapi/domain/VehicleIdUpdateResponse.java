/*
 * VehicleIdUpdateResponse.java Apr 18, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.rest.tameeniapi.domain;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * @author Ghada Shawkat
 *
 */
public class VehicleIdUpdateResponse
{
	private boolean status;
	
	private List<Error> errors;

	/**
	 * @return the status
	 */
	@JsonGetter("Status")
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
	@JsonSetter("Status")
	public void setStatus(boolean status)
	{
		this.status = status;
	}

	/**
	 * @return the errors
	 */
	public List<Error> getErrors()
	{
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(List<Error> errors)
	{
		this.errors = errors;
	}
	
}
