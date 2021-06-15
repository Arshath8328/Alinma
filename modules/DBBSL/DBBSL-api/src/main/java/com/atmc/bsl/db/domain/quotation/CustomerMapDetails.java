/*
 * CustomerMapDetails.java Feb 12, 2018  
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
package com.atmc.bsl.db.domain.quotation;

/**
 * @author Ghada Shawkat
 *
 */
public class CustomerMapDetails
{
	private String code;
	private String name;
	private String nameAr;
	/**
	 * @return the code
	 */
	public String getCode()
	{
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code)
	{
		this.code = code;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the nameAr
	 */
	public String getNameAr()
	{
		return nameAr;
	}
	/**
	 * @param nameAr the nameAr to set
	 */
	public void setNameAr(String nameAr)
	{
		this.nameAr = nameAr;
	}
	
}
