/*
 * PolicyMember.java Jan 28, 2018  
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
package com.atmc.bsl.db.domain.policy;

import java.util.Date;

/**
 * @author Ghada Shawkat
 */
public class PolicyMember {
	private String policyNo;

	private String memberName;

	private long memberSi;

	private long memberId;

	private String memberGender;

	private String memberGenderEn;

	private String memberGenderAr;

	private Date memberDob;

	private long memberLimit;

	/**
	 * @return the policyNo
	 */
	public String getPolicyNo() {
		return policyNo;
	}

	/**
	 * @param policyNo the policyNo to set
	 */
	public void setPolicyNo(String policyNo) {
		this.policyNo = policyNo;
	}

	/**
	 * @return the memberName
	 */
	public String getMemberName() {
		return memberName;
	}

	/**
	 * @param memberName the memberName to set
	 */
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	/**
	 * @return the memberSi
	 */
	public long getMemberSi() {
		return memberSi;
	}

	/**
	 * @param memberSi the memberSi to set
	 */
	public void setMemberSi(long memberSi) {
		this.memberSi = memberSi;
	}

	/**
	 * @return the memberId
	 */
	public long getMemberId() {
		return memberId;
	}

	/**
	 * @param memberId the memberId to set
	 */
	public void setMemberId(long memberId) {
		this.memberId = memberId;
	}

	/**
	 * @return the memberGender
	 */
	public String getMemberGender() {
		return memberGender;
	}

	/**
	 * @param memberGender the memberGender to set
	 */
	public void setMemberGender(String memberGender) {
		this.memberGender = memberGender;
	}

	/**
	 * @return the memberDob
	 */
	public Date getMemberDob() {
		return memberDob;
	}

	/**
	 * @param memberDob the memberDob to set
	 */
	public void setMemberDob(Date memberDob) {
		this.memberDob = memberDob;
	}

	/**
	 * @return the memberLimit
	 */
	public long getMemberLimit() {
		return memberLimit;
	}

	/**
	 * @param memberLimit the memberLimit to set
	 */
	public void setMemberLimit(long memberLimit) {
		this.memberLimit = memberLimit;
	}

	/**
	 * @return the memberGenderEn
	 */
	public String getMemberGenderEn() {
		return memberGenderEn;
	}

	/**
	 * @param memberGenderEn the memberGenderEn to set
	 */
	public void setMemberGenderEn(String memberGenderEn) {
		this.memberGenderEn = memberGenderEn;
	}

	/**
	 * @return the memberGenderAr
	 */
	public String getMemberGenderAr() {
		return memberGenderAr;
	}

	/**
	 * @param memberGenderAr the memberGenderAr to set
	 */
	public void setMemberGenderAr(String memberGenderAr) {
		this.memberGenderAr = memberGenderAr;
	}

}
