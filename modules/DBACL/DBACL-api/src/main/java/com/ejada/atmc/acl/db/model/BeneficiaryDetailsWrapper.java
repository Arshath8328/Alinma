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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link BeneficiaryDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see BeneficiaryDetails
 * @generated
 */
public class BeneficiaryDetailsWrapper
	extends BaseModelWrapper<BeneficiaryDetails>
	implements BeneficiaryDetails, ModelWrapper<BeneficiaryDetails> {

	public BeneficiaryDetailsWrapper(BeneficiaryDetails beneficiaryDetails) {
		super(beneficiaryDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("benfName", getBenfName());
		attributes.put("benfPct", getBenfPct());
		attributes.put("benfRel", getBenfRel());
		attributes.put("benfId", getBenfId());
		attributes.put("benfAge", getBenfAge());
		attributes.put("benfType", getBenfType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String benfName = (String)attributes.get("benfName");

		if (benfName != null) {
			setBenfName(benfName);
		}

		String benfPct = (String)attributes.get("benfPct");

		if (benfPct != null) {
			setBenfPct(benfPct);
		}

		String benfRel = (String)attributes.get("benfRel");

		if (benfRel != null) {
			setBenfRel(benfRel);
		}

		Long benfId = (Long)attributes.get("benfId");

		if (benfId != null) {
			setBenfId(benfId);
		}

		String benfAge = (String)attributes.get("benfAge");

		if (benfAge != null) {
			setBenfAge(benfAge);
		}

		String benfType = (String)attributes.get("benfType");

		if (benfType != null) {
			setBenfType(benfType);
		}
	}

	/**
	 * Returns the benf age of this beneficiary details.
	 *
	 * @return the benf age of this beneficiary details
	 */
	@Override
	public String getBenfAge() {
		return model.getBenfAge();
	}

	/**
	 * Returns the benf ID of this beneficiary details.
	 *
	 * @return the benf ID of this beneficiary details
	 */
	@Override
	public long getBenfId() {
		return model.getBenfId();
	}

	/**
	 * Returns the benf name of this beneficiary details.
	 *
	 * @return the benf name of this beneficiary details
	 */
	@Override
	public String getBenfName() {
		return model.getBenfName();
	}

	/**
	 * Returns the benf pct of this beneficiary details.
	 *
	 * @return the benf pct of this beneficiary details
	 */
	@Override
	public String getBenfPct() {
		return model.getBenfPct();
	}

	/**
	 * Returns the benf rel of this beneficiary details.
	 *
	 * @return the benf rel of this beneficiary details
	 */
	@Override
	public String getBenfRel() {
		return model.getBenfRel();
	}

	@Override
	public String getBenfRelDescAr() {
		return model.getBenfRelDescAr();
	}

	@Override
	public String getBenfRelDescEn() {
		return model.getBenfRelDescEn();
	}

	/**
	 * Returns the benf type of this beneficiary details.
	 *
	 * @return the benf type of this beneficiary details
	 */
	@Override
	public String getBenfType() {
		return model.getBenfType();
	}

	/**
	 * Returns the policy no of this beneficiary details.
	 *
	 * @return the policy no of this beneficiary details
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this beneficiary details.
	 *
	 * @return the primary key of this beneficiary details
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
	 * Sets the benf age of this beneficiary details.
	 *
	 * @param benfAge the benf age of this beneficiary details
	 */
	@Override
	public void setBenfAge(String benfAge) {
		model.setBenfAge(benfAge);
	}

	/**
	 * Sets the benf ID of this beneficiary details.
	 *
	 * @param benfId the benf ID of this beneficiary details
	 */
	@Override
	public void setBenfId(long benfId) {
		model.setBenfId(benfId);
	}

	/**
	 * Sets the benf name of this beneficiary details.
	 *
	 * @param benfName the benf name of this beneficiary details
	 */
	@Override
	public void setBenfName(String benfName) {
		model.setBenfName(benfName);
	}

	/**
	 * Sets the benf pct of this beneficiary details.
	 *
	 * @param benfPct the benf pct of this beneficiary details
	 */
	@Override
	public void setBenfPct(String benfPct) {
		model.setBenfPct(benfPct);
	}

	/**
	 * Sets the benf rel of this beneficiary details.
	 *
	 * @param benfRel the benf rel of this beneficiary details
	 */
	@Override
	public void setBenfRel(String benfRel) {
		model.setBenfRel(benfRel);
	}

	/**
	 * Sets the benf type of this beneficiary details.
	 *
	 * @param benfType the benf type of this beneficiary details
	 */
	@Override
	public void setBenfType(String benfType) {
		model.setBenfType(benfType);
	}

	/**
	 * Sets the policy no of this beneficiary details.
	 *
	 * @param policyNo the policy no of this beneficiary details
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this beneficiary details.
	 *
	 * @param primaryKey the primary key of this beneficiary details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected BeneficiaryDetailsWrapper wrap(
		BeneficiaryDetails beneficiaryDetails) {

		return new BeneficiaryDetailsWrapper(beneficiaryDetails);
	}

}