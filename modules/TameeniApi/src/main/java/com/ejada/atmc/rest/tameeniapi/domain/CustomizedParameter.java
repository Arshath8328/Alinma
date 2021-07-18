/*
 * CustomizedParameter.java Apr 18, 2018  
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

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ghada Shawkat
 *
 */
@XmlRootElement
public class CustomizedParameter
{
	private String key;
	
	private String value1;

	private String value2;

	private String value3;

	private String value4;

	/**
	 * @return the key
	 */
	@XmlElement(name = "Key")
	public String getKey()
	{
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

	/**
	 * @return the value1
	 */
	@XmlElement(name = "Value1")
	public String getValue1()
	{
		return value1;
	}

	/**
	 * @param value1 the value1 to set
	 */
	public void setValue1(String value1)
	{
		this.value1 = value1;
	}

	/**
	 * @return the value2
	 */
	@XmlElement(name = "Value2")
	public String getValue2()
	{
		return value2;
	}

	/**
	 * @param value2 the value2 to set
	 */
	public void setValue2(String value2)
	{
		this.value2 = value2;
	}

	/**
	 * @return the value3
	 */
	@XmlElement(name = "Value3")
	public String getValue3()
	{
		return value3;
	}

	/**
	 * @param value3 the value3 to set
	 */
	public void setValue3(String value3)
	{
		this.value3 = value3;
	}

	/**
	 * @return the value4
	 */
	@XmlElement(name = "Value4")
	public String getValue4()
	{
		return value4;
	}

	/**
	 * @param value4 the value4 to set
	 */
	public void setValue4(String value4)
	{
		this.value4 = value4;
	}
	
}
