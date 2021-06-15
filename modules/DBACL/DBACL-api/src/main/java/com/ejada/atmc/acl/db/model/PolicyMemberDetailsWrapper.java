/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.atmc.acl.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PolicyMemberDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyMemberDetails
 * @generated
 */
public class PolicyMemberDetailsWrapper
	extends BaseModelWrapper<PolicyMemberDetails>
	implements ModelWrapper<PolicyMemberDetails>, PolicyMemberDetails {

	public PolicyMemberDetailsWrapper(PolicyMemberDetails policyMemberDetails) {
		super(policyMemberDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("memberName", getMemberName());
		attributes.put("memberSi", getMemberSi());
		attributes.put("memberId", getMemberId());
		attributes.put("memberGender", getMemberGender());
		attributes.put("memberDob", getMemberDob());
		attributes.put("memberLimit", getMemberLimit());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String memberName = (String)attributes.get("memberName");

		if (memberName != null) {
			setMemberName(memberName);
		}

		Long memberSi = (Long)attributes.get("memberSi");

		if (memberSi != null) {
			setMemberSi(memberSi);
		}

		Long memberId = (Long)attributes.get("memberId");

		if (memberId != null) {
			setMemberId(memberId);
		}

		String memberGender = (String)attributes.get("memberGender");

		if (memberGender != null) {
			setMemberGender(memberGender);
		}

		Date memberDob = (Date)attributes.get("memberDob");

		if (memberDob != null) {
			setMemberDob(memberDob);
		}

		Long memberLimit = (Long)attributes.get("memberLimit");

		if (memberLimit != null) {
			setMemberLimit(memberLimit);
		}
	}

	@Override
	public String getGenderDescAr() {
		return model.getGenderDescAr();
	}

	@Override
	public String getGenderDescEn() {
		return model.getGenderDescEn();
	}

	/**
	 * Returns the member dob of this policy member details.
	 *
	 * @return the member dob of this policy member details
	 */
	@Override
	public Date getMemberDob() {
		return model.getMemberDob();
	}

	/**
	 * Returns the member gender of this policy member details.
	 *
	 * @return the member gender of this policy member details
	 */
	@Override
	public String getMemberGender() {
		return model.getMemberGender();
	}

	/**
	 * Returns the member ID of this policy member details.
	 *
	 * @return the member ID of this policy member details
	 */
	@Override
	public long getMemberId() {
		return model.getMemberId();
	}

	/**
	 * Returns the member limit of this policy member details.
	 *
	 * @return the member limit of this policy member details
	 */
	@Override
	public long getMemberLimit() {
		return model.getMemberLimit();
	}

	/**
	 * Returns the member name of this policy member details.
	 *
	 * @return the member name of this policy member details
	 */
	@Override
	public String getMemberName() {
		return model.getMemberName();
	}

	/**
	 * Returns the member si of this policy member details.
	 *
	 * @return the member si of this policy member details
	 */
	@Override
	public long getMemberSi() {
		return model.getMemberSi();
	}

	/**
	 * Returns the policy no of this policy member details.
	 *
	 * @return the policy no of this policy member details
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this policy member details.
	 *
	 * @return the primary key of this policy member details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the member dob of this policy member details.
	 *
	 * @param memberDob the member dob of this policy member details
	 */
	@Override
	public void setMemberDob(Date memberDob) {
		model.setMemberDob(memberDob);
	}

	/**
	 * Sets the member gender of this policy member details.
	 *
	 * @param memberGender the member gender of this policy member details
	 */
	@Override
	public void setMemberGender(String memberGender) {
		model.setMemberGender(memberGender);
	}

	/**
	 * Sets the member ID of this policy member details.
	 *
	 * @param memberId the member ID of this policy member details
	 */
	@Override
	public void setMemberId(long memberId) {
		model.setMemberId(memberId);
	}

	/**
	 * Sets the member limit of this policy member details.
	 *
	 * @param memberLimit the member limit of this policy member details
	 */
	@Override
	public void setMemberLimit(long memberLimit) {
		model.setMemberLimit(memberLimit);
	}

	/**
	 * Sets the member name of this policy member details.
	 *
	 * @param memberName the member name of this policy member details
	 */
	@Override
	public void setMemberName(String memberName) {
		model.setMemberName(memberName);
	}

	/**
	 * Sets the member si of this policy member details.
	 *
	 * @param memberSi the member si of this policy member details
	 */
	@Override
	public void setMemberSi(long memberSi) {
		model.setMemberSi(memberSi);
	}

	/**
	 * Sets the policy no of this policy member details.
	 *
	 * @param policyNo the policy no of this policy member details
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this policy member details.
	 *
	 * @param primaryKey the primary key of this policy member details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected PolicyMemberDetailsWrapper wrap(
		PolicyMemberDetails policyMemberDetails) {

		return new PolicyMemberDetailsWrapper(policyMemberDetails);
	}

}