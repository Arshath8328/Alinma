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
package com.atmc.bsl.db.domain.quotation;

import java.util.Date;

/**
 * @author Ghada Shawkat
 */
public class QuotationCover {
	private long addCoverId;

	private long quotationId;

	private String coverCode;

	private String coverName;

	private String coverNameAr;

	private String coverDesc;

	private String coverDescAr;

	private String field1;

	private String field2;

	private String field3;

	private String field4;

	private Date coverEffFromDate;

	private Date coverEffToDate;

	private long coverPrem;

	private long coverRate;

	private long coverSi;

	private long sectionCode;

	private String benfTerm;

	private String months;

	/**
	 * @return the addCoverId
	 */
	public long getAddCoverId() {
		return addCoverId;
	}

	/**
	 * @param addCoverId the addCoverId to set
	 */
	public void setAddCoverId(long addCoverId) {
		this.addCoverId = addCoverId;
	}

	/**
	 * @return the quotationId
	 */
	public long getQuotationId() {
		return quotationId;
	}

	/**
	 * @param quotationId the quotationId to set
	 */
	public void setQuotationId(long quotationId) {
		this.quotationId = quotationId;
	}

	/**
	 * @return the coverCode
	 */
	public String getCoverCode() {
		return coverCode;
	}

	/**
	 * @param coverCode the coverCode to set
	 */
	public void setCoverCode(String coverCode) {
		this.coverCode = coverCode;
	}

	/**
	 * @return the coverEffFromDate
	 */
	public Date getCoverEffFromDate() {
		return coverEffFromDate;
	}

	/**
	 * @param coverEffFromDate the coverEffFromDate to set
	 */
	public void setCoverEffFromDate(Date coverEffFromDate) {
		this.coverEffFromDate = coverEffFromDate;
	}

	/**
	 * @return the coverEffToDate
	 */
	public Date getCoverEffToDate() {
		return coverEffToDate;
	}

	/**
	 * @param coverEffToDate the coverEffToDate to set
	 */
	public void setCoverEffToDate(Date coverEffToDate) {
		this.coverEffToDate = coverEffToDate;
	}

	/**
	 * @return the coverPrem
	 */
	public long getCoverPrem() {
		return coverPrem;
	}

	/**
	 * @param coverPrem the coverPrem to set
	 */
	public void setCoverPrem(long coverPrem) {
		this.coverPrem = coverPrem;
	}

	/**
	 * @return the coverRate
	 */
	public long getCoverRate() {
		return coverRate;
	}

	/**
	 * @param coverRate the coverRate to set
	 */
	public void setCoverRate(long coverRate) {
		this.coverRate = coverRate;
	}

	/**
	 * @return the coverSi
	 */
	public long getCoverSi() {
		return coverSi;
	}

	/**
	 * @param coverSi the coverSi to set
	 */
	public void setCoverSi(long coverSi) {
		this.coverSi = coverSi;
	}

	/**
	 * @return the coverName
	 */
	public String getCoverName() {
		return coverName;
	}

	/**
	 * @param coverName the coverName to set
	 */
	public void setCoverName(String coverName) {
		this.coverName = coverName;
	}

	/**
	 * @return the coverNameAr
	 */
	public String getCoverNameAr() {
		return coverNameAr;
	}

	/**
	 * @param coverNameAr the coverNameAr to set
	 */
	public void setCoverNameAr(String coverNameAr) {
		this.coverNameAr = coverNameAr;
	}

	/**
	 * @return the coverDesc
	 */
	public String getCoverDesc() {
		return coverDesc;
	}

	/**
	 * @param coverDesc the coverDesc to set
	 */
	public void setCoverDesc(String coverDesc) {
		this.coverDesc = coverDesc;
	}

	/**
	 * @return the coverDescAr
	 */
	public String getCoverDescAr() {
		return coverDescAr;
	}

	/**
	 * @param coverDescAr the coverDescAr to set
	 */
	public void setCoverDescAr(String coverDescAr) {
		this.coverDescAr = coverDescAr;
	}

	/**
	 * @return the field1
	 */
	public String getField1() {
		return field1;
	}

	/**
	 * @param field1 the field1 to set
	 */
	public void setField1(String field1) {
		this.field1 = field1;
	}

	/**
	 * @return the field2
	 */
	public String getField2() {
		return field2;
	}

	/**
	 * @param field2 the field2 to set
	 */
	public void setField2(String field2) {
		this.field2 = field2;
	}

	/**
	 * @return the field3
	 */
	public String getField3() {
		return field3;
	}

	/**
	 * @param field3 the field3 to set
	 */
	public void setField3(String field3) {
		this.field3 = field3;
	}

	/**
	 * @return the field4
	 */
	public String getField4() {
		return field4;
	}

	/**
	 * @param field4 the field4 to set
	 */
	public void setField4(String field4) {
		this.field4 = field4;
	}

	/**
	 * @return the sectionCode
	 */
	public long getSectionCode() {
		return sectionCode;
	}

	/**
	 * @param sectionCode the sectionCode to set
	 */
	public void setSectionCode(long sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String toString() {
		String result = "";
		result += "\n\n" + this.addCoverId;
		result += "\n\n" + this.quotationId;
		result += "\n\n" + this.coverCode;
		result += "\n\n" + this.coverName;
		result += "\n\n" + this.coverNameAr;
		result += "\n\n" + this.coverDesc;
		result += "\n\n" + this.coverDescAr;
		result += "\n\n" + this.field1;
		result += "\n\n" + this.field2;
		result += "\n\n" + this.field3;
		result += "\n\n" + this.field4;
		result += "\n\n" + this.coverEffFromDate;
		result += "\n\n" + this.coverEffToDate;
		result += "\n\n" + this.coverPrem;
		result += "\n\n" + this.coverRate;
		result += "\n\n" + this.coverSi;
		result += "\n\n" + this.sectionCode;
		result += "\n\n" + this.months;
		return result;
	}

	public String getBenfTerm() {
		return benfTerm;
	}

	public void setBenfTerm(String benfTerm) {
		this.benfTerm = benfTerm;
	}

	public String getMonths() {
		return months;
	}

	public void setMonths(String months) {
		this.months = months;
	}

}
