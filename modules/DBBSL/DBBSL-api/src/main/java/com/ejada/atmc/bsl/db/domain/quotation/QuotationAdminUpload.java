/*
 * QuotationCover.java Jan 21, 2018  
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
package com.ejada.atmc.bsl.db.domain.quotation;

import java.sql.Blob;

/**
 * @author Hadeer
 */
public class QuotationAdminUpload {

	private int id;
	private long quotationId;
	private String fileName;
	// private byte[] adminFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
//	public byte[] getAdminFile() {
//		return adminFile;
//	}
//	public void setAdminFile(byte[] adminFile) {
//		this.adminFile = adminFile;
//	}

}
