/*
 * YaqeenException.java Apr 4, 2018  
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
package com.atmc.bsl.db.exception;

/**
 * @author Ghada Shawkat
 *
 */
public class YaqeenException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -954739090433741456L;

	private int errorCode;

	public YaqeenException(int errorCode) {
		super();
		this.errorCode = errorCode;
	}

	public YaqeenException(int errorCode, String message, Throwable cause) {
		super(message, cause);
		this.errorCode = errorCode;
	}

	public YaqeenException(int errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}

	public YaqeenException(int errorCode, Throwable cause) {
		super(cause);
		this.errorCode = errorCode;
	}

	/**
	 * @return the errorCode
	 */
	public int getErrorCode() {
		return errorCode;
	}

	/**
	 * @param errorCode the errorCode to set
	 */
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}
