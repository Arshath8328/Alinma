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
 * This class is a wrapper for {@link FundDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see FundDetails
 * @generated
 */
public class FundDetailsWrapper
	extends BaseModelWrapper<FundDetails>
	implements FundDetails, ModelWrapper<FundDetails> {

	public FundDetailsWrapper(FundDetails fundDetails) {
		super(fundDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("fundName", getFundName());
		attributes.put("fundDesc", getFundDesc());
		attributes.put("fundPctg", getFundPctg());
		attributes.put("unitsSum", getUnitsSum());
		attributes.put("unitPrice", getUnitPrice());
		attributes.put("fundsValue", getFundsValue());
		attributes.put("riskChg", getRiskChg());
		attributes.put("partFees", getPartFees());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String fundName = (String)attributes.get("fundName");

		if (fundName != null) {
			setFundName(fundName);
		}

		String fundDesc = (String)attributes.get("fundDesc");

		if (fundDesc != null) {
			setFundDesc(fundDesc);
		}

		String fundPctg = (String)attributes.get("fundPctg");

		if (fundPctg != null) {
			setFundPctg(fundPctg);
		}

		Double unitsSum = (Double)attributes.get("unitsSum");

		if (unitsSum != null) {
			setUnitsSum(unitsSum);
		}

		Double unitPrice = (Double)attributes.get("unitPrice");

		if (unitPrice != null) {
			setUnitPrice(unitPrice);
		}

		Double fundsValue = (Double)attributes.get("fundsValue");

		if (fundsValue != null) {
			setFundsValue(fundsValue);
		}

		Double riskChg = (Double)attributes.get("riskChg");

		if (riskChg != null) {
			setRiskChg(riskChg);
		}

		Double partFees = (Double)attributes.get("partFees");

		if (partFees != null) {
			setPartFees(partFees);
		}
	}

	/**
	 * Returns the fund desc of this fund details.
	 *
	 * @return the fund desc of this fund details
	 */
	@Override
	public String getFundDesc() {
		return model.getFundDesc();
	}

	/**
	 * Returns the fund name of this fund details.
	 *
	 * @return the fund name of this fund details
	 */
	@Override
	public String getFundName() {
		return model.getFundName();
	}

	/**
	 * Returns the fund pctg of this fund details.
	 *
	 * @return the fund pctg of this fund details
	 */
	@Override
	public String getFundPctg() {
		return model.getFundPctg();
	}

	/**
	 * Returns the funds value of this fund details.
	 *
	 * @return the funds value of this fund details
	 */
	@Override
	public double getFundsValue() {
		return model.getFundsValue();
	}

	/**
	 * Returns the part fees of this fund details.
	 *
	 * @return the part fees of this fund details
	 */
	@Override
	public double getPartFees() {
		return model.getPartFees();
	}

	/**
	 * Returns the policy no of this fund details.
	 *
	 * @return the policy no of this fund details
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this fund details.
	 *
	 * @return the primary key of this fund details
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the risk chg of this fund details.
	 *
	 * @return the risk chg of this fund details
	 */
	@Override
	public double getRiskChg() {
		return model.getRiskChg();
	}

	/**
	 * Returns the unit price of this fund details.
	 *
	 * @return the unit price of this fund details
	 */
	@Override
	public double getUnitPrice() {
		return model.getUnitPrice();
	}

	/**
	 * Returns the units sum of this fund details.
	 *
	 * @return the units sum of this fund details
	 */
	@Override
	public double getUnitsSum() {
		return model.getUnitsSum();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the fund desc of this fund details.
	 *
	 * @param fundDesc the fund desc of this fund details
	 */
	@Override
	public void setFundDesc(String fundDesc) {
		model.setFundDesc(fundDesc);
	}

	/**
	 * Sets the fund name of this fund details.
	 *
	 * @param fundName the fund name of this fund details
	 */
	@Override
	public void setFundName(String fundName) {
		model.setFundName(fundName);
	}

	/**
	 * Sets the fund pctg of this fund details.
	 *
	 * @param fundPctg the fund pctg of this fund details
	 */
	@Override
	public void setFundPctg(String fundPctg) {
		model.setFundPctg(fundPctg);
	}

	/**
	 * Sets the funds value of this fund details.
	 *
	 * @param fundsValue the funds value of this fund details
	 */
	@Override
	public void setFundsValue(double fundsValue) {
		model.setFundsValue(fundsValue);
	}

	/**
	 * Sets the part fees of this fund details.
	 *
	 * @param partFees the part fees of this fund details
	 */
	@Override
	public void setPartFees(double partFees) {
		model.setPartFees(partFees);
	}

	/**
	 * Sets the policy no of this fund details.
	 *
	 * @param policyNo the policy no of this fund details
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this fund details.
	 *
	 * @param primaryKey the primary key of this fund details
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the risk chg of this fund details.
	 *
	 * @param riskChg the risk chg of this fund details
	 */
	@Override
	public void setRiskChg(double riskChg) {
		model.setRiskChg(riskChg);
	}

	/**
	 * Sets the unit price of this fund details.
	 *
	 * @param unitPrice the unit price of this fund details
	 */
	@Override
	public void setUnitPrice(double unitPrice) {
		model.setUnitPrice(unitPrice);
	}

	/**
	 * Sets the units sum of this fund details.
	 *
	 * @param unitsSum the units sum of this fund details
	 */
	@Override
	public void setUnitsSum(double unitsSum) {
		model.setUnitsSum(unitsSum);
	}

	@Override
	protected FundDetailsWrapper wrap(FundDetails fundDetails) {
		return new FundDetailsWrapper(fundDetails);
	}

}