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
 * This class is a wrapper for {@link PolicyVehCvr}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVehCvr
 * @generated
 */
public class PolicyVehCvrWrapper
	extends BaseModelWrapper<PolicyVehCvr>
	implements ModelWrapper<PolicyVehCvr>, PolicyVehCvr {

	public PolicyVehCvrWrapper(PolicyVehCvr policyVehCvr) {
		super(policyVehCvr);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("vehId", getVehId());
		attributes.put("cvrCode", getCvrCode());
		attributes.put("description", getDescription());
		attributes.put("cvrType", getCvrType());
		attributes.put("benefitTerm", getBenefitTerm());
		attributes.put("premiumTerm", getPremiumTerm());
		attributes.put("premium", getPremium());
		attributes.put("sumCovered", getSumCovered());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String vehId = (String)attributes.get("vehId");

		if (vehId != null) {
			setVehId(vehId);
		}

		String cvrCode = (String)attributes.get("cvrCode");

		if (cvrCode != null) {
			setCvrCode(cvrCode);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String cvrType = (String)attributes.get("cvrType");

		if (cvrType != null) {
			setCvrType(cvrType);
		}

		String benefitTerm = (String)attributes.get("benefitTerm");

		if (benefitTerm != null) {
			setBenefitTerm(benefitTerm);
		}

		String premiumTerm = (String)attributes.get("premiumTerm");

		if (premiumTerm != null) {
			setPremiumTerm(premiumTerm);
		}

		Long premium = (Long)attributes.get("premium");

		if (premium != null) {
			setPremium(premium);
		}

		Long sumCovered = (Long)attributes.get("sumCovered");

		if (sumCovered != null) {
			setSumCovered(sumCovered);
		}
	}

	/**
	 * Returns the benefit term of this policy veh cvr.
	 *
	 * @return the benefit term of this policy veh cvr
	 */
	@Override
	public String getBenefitTerm() {
		return model.getBenefitTerm();
	}

	/**
	 * Returns the cvr code of this policy veh cvr.
	 *
	 * @return the cvr code of this policy veh cvr
	 */
	@Override
	public String getCvrCode() {
		return model.getCvrCode();
	}

	/**
	 * Returns the cvr type of this policy veh cvr.
	 *
	 * @return the cvr type of this policy veh cvr
	 */
	@Override
	public String getCvrType() {
		return model.getCvrType();
	}

	/**
	 * Returns the description of this policy veh cvr.
	 *
	 * @return the description of this policy veh cvr
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the policy no of this policy veh cvr.
	 *
	 * @return the policy no of this policy veh cvr
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the premium of this policy veh cvr.
	 *
	 * @return the premium of this policy veh cvr
	 */
	@Override
	public long getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the premium term of this policy veh cvr.
	 *
	 * @return the premium term of this policy veh cvr
	 */
	@Override
	public String getPremiumTerm() {
		return model.getPremiumTerm();
	}

	/**
	 * Returns the primary key of this policy veh cvr.
	 *
	 * @return the primary key of this policy veh cvr
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the sum covered of this policy veh cvr.
	 *
	 * @return the sum covered of this policy veh cvr
	 */
	@Override
	public long getSumCovered() {
		return model.getSumCovered();
	}

	/**
	 * Returns the veh ID of this policy veh cvr.
	 *
	 * @return the veh ID of this policy veh cvr
	 */
	@Override
	public String getVehId() {
		return model.getVehId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the benefit term of this policy veh cvr.
	 *
	 * @param benefitTerm the benefit term of this policy veh cvr
	 */
	@Override
	public void setBenefitTerm(String benefitTerm) {
		model.setBenefitTerm(benefitTerm);
	}

	/**
	 * Sets the cvr code of this policy veh cvr.
	 *
	 * @param cvrCode the cvr code of this policy veh cvr
	 */
	@Override
	public void setCvrCode(String cvrCode) {
		model.setCvrCode(cvrCode);
	}

	/**
	 * Sets the cvr type of this policy veh cvr.
	 *
	 * @param cvrType the cvr type of this policy veh cvr
	 */
	@Override
	public void setCvrType(String cvrType) {
		model.setCvrType(cvrType);
	}

	/**
	 * Sets the description of this policy veh cvr.
	 *
	 * @param description the description of this policy veh cvr
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the policy no of this policy veh cvr.
	 *
	 * @param policyNo the policy no of this policy veh cvr
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the premium of this policy veh cvr.
	 *
	 * @param premium the premium of this policy veh cvr
	 */
	@Override
	public void setPremium(long premium) {
		model.setPremium(premium);
	}

	/**
	 * Sets the premium term of this policy veh cvr.
	 *
	 * @param premiumTerm the premium term of this policy veh cvr
	 */
	@Override
	public void setPremiumTerm(String premiumTerm) {
		model.setPremiumTerm(premiumTerm);
	}

	/**
	 * Sets the primary key of this policy veh cvr.
	 *
	 * @param primaryKey the primary key of this policy veh cvr
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the sum covered of this policy veh cvr.
	 *
	 * @param sumCovered the sum covered of this policy veh cvr
	 */
	@Override
	public void setSumCovered(long sumCovered) {
		model.setSumCovered(sumCovered);
	}

	/**
	 * Sets the veh ID of this policy veh cvr.
	 *
	 * @param vehId the veh ID of this policy veh cvr
	 */
	@Override
	public void setVehId(String vehId) {
		model.setVehId(vehId);
	}

	@Override
	protected PolicyVehCvrWrapper wrap(PolicyVehCvr policyVehCvr) {
		return new PolicyVehCvrWrapper(policyVehCvr);
	}

}