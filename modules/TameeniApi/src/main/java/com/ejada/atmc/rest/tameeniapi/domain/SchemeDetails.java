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
 * @author Kareem Kahil
 *
 */
@XmlRootElement
public class SchemeDetails
{
	private String schemeRef;
	
	private String icSchemeRef;

	private int schemeTypeID;

	private int positionNameCode;

	private String value1;
	
	private String value2;
	
	private String value3;
	
	private String value4;

	
	@XmlElement(name = "SchemeRef")
	public String getSchemeRef() {
		return schemeRef;
	}

	public void setSchemeRef(String schemeRef) {
		this.schemeRef = schemeRef;
	}

	@XmlElement(name = "IcSchemeRef")
	public String getIcSchemeRef() {
		return icSchemeRef;
	}

	public void setIcSchemeRef(String icSchemeRef) {
		this.icSchemeRef = icSchemeRef;
	}

	
	@XmlElement(name = "SchemeTypeID")
	public int getSchemeTypeID() {
		return schemeTypeID;
	}

	public void setSchemeTypeID(int schemeTypeID) {
		this.schemeTypeID = schemeTypeID;
	}

	
	@XmlElement(name = "PositionNameCode")
	public int getPositionNameCode() {
		return positionNameCode;
	}

	public void setPositionNameCode(int positionNameCode) {
		this.positionNameCode = positionNameCode;
	}

	@XmlElement(name = "Value1")
	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	@XmlElement(name = "Value2")
	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	@XmlElement(name = "Value3")
	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	@XmlElement(name = "Value4")
	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}
	
}
