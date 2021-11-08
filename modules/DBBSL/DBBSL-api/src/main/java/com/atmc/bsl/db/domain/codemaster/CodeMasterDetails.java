/*
 * CodeMaster.java Feb 1, 2018  
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
package com.atmc.bsl.db.domain.codemaster;

/**
 * @author Sarah Taher
 *
 */

public class CodeMasterDetails {

	/*
	 * private double systemId; private Date effFromDate; private Date effToDate;
	 * private Date creationDate; private String crUid; private String updateDate;
	 * private long updateUid;
	 */ private String code;
	private String codeSub;
	private String codeDesc;
	private String codeDescAr;
	private String codeSubRef;
	/*
	 * private String codeValue0; private String codeValue1; private String
	 * codeValue2; private String codeRef; private String codeSubRef; public double
	 * getSystemId() { return systemId; } public void setSystemId(double systemId) {
	 * this.systemId = systemId; } public Date getEffFromDate() { return
	 * effFromDate; } public void setEffFromDate(Date effFromDate) {
	 * this.effFromDate = effFromDate; } public Date getEffToDate() { return
	 * effToDate; } public void setEffToDate(Date effToDate) { this.effToDate =
	 * effToDate; } public Date getCreationDate() { return creationDate; } public
	 * void setCreationDate(Date creationDate) { this.creationDate = creationDate; }
	 * public String getCrUid() { return crUid; } public void setCrUid(String crUid)
	 * { this.crUid = crUid; } public String getUpdateDate() { return updateDate; }
	 * public void setUpdateDate(String updateDate) { this.updateDate = updateDate;
	 * } public long getUpdateUid() { return updateUid; } public void
	 * setUpdateUid(long updateUid) { this.updateUid = updateUid; }
	 */ public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCodeSub() {
		return codeSub;
	}

	public void setCodeSub(String codeSub) {
		this.codeSub = codeSub;
	}

	public String getCodeDesc() {
		return codeDesc;
	}

	public void setCodeDesc(String codeDesc) {
		this.codeDesc = codeDesc;
	}

	public String getCodeDescAr() {
		return codeDescAr;
	}

	public void setCodeDescAr(String codeDescAr) {
		this.codeDescAr = codeDescAr;
	}
	/*
	 * public String getCodeValue0() { return codeValue0; } public void
	 * setCodeValue0(String codeValue0) { this.codeValue0 = codeValue0; } public
	 * String getCodeValue1() { return codeValue1; } public void
	 * setCodeValue1(String codeValue1) { this.codeValue1 = codeValue1; } public
	 * String getCodeValue2() { return codeValue2; } public void
	 * setCodeValue2(String codeValue2) { this.codeValue2 = codeValue2; } public
	 * String getCodeRef() { return codeRef; } public void setCodeRef(String
	 * codeRef) { this.codeRef = codeRef; } public String getCodeSubRef() { return
	 * codeSubRef; } public void setCodeSubRef(String codeSubRef) { this.codeSubRef
	 * = codeSubRef; }
	 */

	public String getCodeSubRef() {
		return codeSubRef;
	}

	public void setCodeSubRef(String codeSubRef) {
		this.codeSubRef = codeSubRef;
	}}
