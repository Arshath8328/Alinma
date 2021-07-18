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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ghada Shawkat
 *
 */
@XmlRootElement
public class TriggerVehicleIdUpdateResponse
{
	private boolean status;
	
	private List<Error> errors;

	/**
	 * @return the status
	 */
	@XmlElement(name = "Status")
	public boolean isStatus()
	{
		return status;
	}

	/**
	 * @param status the status to set
	 */
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
