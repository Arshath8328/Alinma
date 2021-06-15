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
 * This class is a wrapper for {@link PolVEHSearch}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolVEHSearch
 * @generated
 */
public class PolVEHSearchWrapper
	extends BaseModelWrapper<PolVEHSearch>
	implements ModelWrapper<PolVEHSearch>, PolVEHSearch {

	public PolVEHSearchWrapper(PolVEHSearch polVEHSearch) {
		super(polVEHSearch);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("vehicleSEQCustom", getVehicleSEQCustom());
		attributes.put("chassisNo", getChassisNo());
		attributes.put("vehicleDevType", getVehicleDevType());
		attributes.put("inceptionDate", getInceptionDate());
		attributes.put("expiryDate", getExpiryDate());
		attributes.put("engPlateNo", getEngPlateNo());
		attributes.put("engPlateL1", getEngPlateL1());
		attributes.put("engPlateL2", getEngPlateL2());
		attributes.put("engPlateL3", getEngPlateL3());
		attributes.put("arbPlateNo", getArbPlateNo());
		attributes.put("arbPlateL1", getArbPlateL1());
		attributes.put("arbPlateL2", getArbPlateL2());
		attributes.put("arbPlateL3", getArbPlateL3());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String vehicleSEQCustom = (String)attributes.get("vehicleSEQCustom");

		if (vehicleSEQCustom != null) {
			setVehicleSEQCustom(vehicleSEQCustom);
		}

		String chassisNo = (String)attributes.get("chassisNo");

		if (chassisNo != null) {
			setChassisNo(chassisNo);
		}

		String vehicleDevType = (String)attributes.get("vehicleDevType");

		if (vehicleDevType != null) {
			setVehicleDevType(vehicleDevType);
		}

		Date inceptionDate = (Date)attributes.get("inceptionDate");

		if (inceptionDate != null) {
			setInceptionDate(inceptionDate);
		}

		Date expiryDate = (Date)attributes.get("expiryDate");

		if (expiryDate != null) {
			setExpiryDate(expiryDate);
		}

		Long engPlateNo = (Long)attributes.get("engPlateNo");

		if (engPlateNo != null) {
			setEngPlateNo(engPlateNo);
		}

		String engPlateL1 = (String)attributes.get("engPlateL1");

		if (engPlateL1 != null) {
			setEngPlateL1(engPlateL1);
		}

		String engPlateL2 = (String)attributes.get("engPlateL2");

		if (engPlateL2 != null) {
			setEngPlateL2(engPlateL2);
		}

		String engPlateL3 = (String)attributes.get("engPlateL3");

		if (engPlateL3 != null) {
			setEngPlateL3(engPlateL3);
		}

		String arbPlateNo = (String)attributes.get("arbPlateNo");

		if (arbPlateNo != null) {
			setArbPlateNo(arbPlateNo);
		}

		String arbPlateL1 = (String)attributes.get("arbPlateL1");

		if (arbPlateL1 != null) {
			setArbPlateL1(arbPlateL1);
		}

		String arbPlateL2 = (String)attributes.get("arbPlateL2");

		if (arbPlateL2 != null) {
			setArbPlateL2(arbPlateL2);
		}

		String arbPlateL3 = (String)attributes.get("arbPlateL3");

		if (arbPlateL3 != null) {
			setArbPlateL3(arbPlateL3);
		}
	}

	/**
	 * Returns the arb plate l1 of this pol veh search.
	 *
	 * @return the arb plate l1 of this pol veh search
	 */
	@Override
	public String getArbPlateL1() {
		return model.getArbPlateL1();
	}

	/**
	 * Returns the arb plate l2 of this pol veh search.
	 *
	 * @return the arb plate l2 of this pol veh search
	 */
	@Override
	public String getArbPlateL2() {
		return model.getArbPlateL2();
	}

	/**
	 * Returns the arb plate l3 of this pol veh search.
	 *
	 * @return the arb plate l3 of this pol veh search
	 */
	@Override
	public String getArbPlateL3() {
		return model.getArbPlateL3();
	}

	/**
	 * Returns the arb plate no of this pol veh search.
	 *
	 * @return the arb plate no of this pol veh search
	 */
	@Override
	public String getArbPlateNo() {
		return model.getArbPlateNo();
	}

	/**
	 * Returns the chassis no of this pol veh search.
	 *
	 * @return the chassis no of this pol veh search
	 */
	@Override
	public String getChassisNo() {
		return model.getChassisNo();
	}

	/**
	 * Returns the eng plate l1 of this pol veh search.
	 *
	 * @return the eng plate l1 of this pol veh search
	 */
	@Override
	public String getEngPlateL1() {
		return model.getEngPlateL1();
	}

	/**
	 * Returns the eng plate l2 of this pol veh search.
	 *
	 * @return the eng plate l2 of this pol veh search
	 */
	@Override
	public String getEngPlateL2() {
		return model.getEngPlateL2();
	}

	/**
	 * Returns the eng plate l3 of this pol veh search.
	 *
	 * @return the eng plate l3 of this pol veh search
	 */
	@Override
	public String getEngPlateL3() {
		return model.getEngPlateL3();
	}

	/**
	 * Returns the eng plate no of this pol veh search.
	 *
	 * @return the eng plate no of this pol veh search
	 */
	@Override
	public long getEngPlateNo() {
		return model.getEngPlateNo();
	}

	/**
	 * Returns the expiry date of this pol veh search.
	 *
	 * @return the expiry date of this pol veh search
	 */
	@Override
	public Date getExpiryDate() {
		return model.getExpiryDate();
	}

	/**
	 * Returns the inception date of this pol veh search.
	 *
	 * @return the inception date of this pol veh search
	 */
	@Override
	public Date getInceptionDate() {
		return model.getInceptionDate();
	}

	/**
	 * Returns the policy no of this pol veh search.
	 *
	 * @return the policy no of this pol veh search
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this pol veh search.
	 *
	 * @return the primary key of this pol veh search
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the vehicle dev type of this pol veh search.
	 *
	 * @return the vehicle dev type of this pol veh search
	 */
	@Override
	public String getVehicleDevType() {
		return model.getVehicleDevType();
	}

	/**
	 * Returns the vehicle seq custom of this pol veh search.
	 *
	 * @return the vehicle seq custom of this pol veh search
	 */
	@Override
	public String getVehicleSEQCustom() {
		return model.getVehicleSEQCustom();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the arb plate l1 of this pol veh search.
	 *
	 * @param arbPlateL1 the arb plate l1 of this pol veh search
	 */
	@Override
	public void setArbPlateL1(String arbPlateL1) {
		model.setArbPlateL1(arbPlateL1);
	}

	/**
	 * Sets the arb plate l2 of this pol veh search.
	 *
	 * @param arbPlateL2 the arb plate l2 of this pol veh search
	 */
	@Override
	public void setArbPlateL2(String arbPlateL2) {
		model.setArbPlateL2(arbPlateL2);
	}

	/**
	 * Sets the arb plate l3 of this pol veh search.
	 *
	 * @param arbPlateL3 the arb plate l3 of this pol veh search
	 */
	@Override
	public void setArbPlateL3(String arbPlateL3) {
		model.setArbPlateL3(arbPlateL3);
	}

	/**
	 * Sets the arb plate no of this pol veh search.
	 *
	 * @param arbPlateNo the arb plate no of this pol veh search
	 */
	@Override
	public void setArbPlateNo(String arbPlateNo) {
		model.setArbPlateNo(arbPlateNo);
	}

	/**
	 * Sets the chassis no of this pol veh search.
	 *
	 * @param chassisNo the chassis no of this pol veh search
	 */
	@Override
	public void setChassisNo(String chassisNo) {
		model.setChassisNo(chassisNo);
	}

	/**
	 * Sets the eng plate l1 of this pol veh search.
	 *
	 * @param engPlateL1 the eng plate l1 of this pol veh search
	 */
	@Override
	public void setEngPlateL1(String engPlateL1) {
		model.setEngPlateL1(engPlateL1);
	}

	/**
	 * Sets the eng plate l2 of this pol veh search.
	 *
	 * @param engPlateL2 the eng plate l2 of this pol veh search
	 */
	@Override
	public void setEngPlateL2(String engPlateL2) {
		model.setEngPlateL2(engPlateL2);
	}

	/**
	 * Sets the eng plate l3 of this pol veh search.
	 *
	 * @param engPlateL3 the eng plate l3 of this pol veh search
	 */
	@Override
	public void setEngPlateL3(String engPlateL3) {
		model.setEngPlateL3(engPlateL3);
	}

	/**
	 * Sets the eng plate no of this pol veh search.
	 *
	 * @param engPlateNo the eng plate no of this pol veh search
	 */
	@Override
	public void setEngPlateNo(long engPlateNo) {
		model.setEngPlateNo(engPlateNo);
	}

	/**
	 * Sets the expiry date of this pol veh search.
	 *
	 * @param expiryDate the expiry date of this pol veh search
	 */
	@Override
	public void setExpiryDate(Date expiryDate) {
		model.setExpiryDate(expiryDate);
	}

	/**
	 * Sets the inception date of this pol veh search.
	 *
	 * @param inceptionDate the inception date of this pol veh search
	 */
	@Override
	public void setInceptionDate(Date inceptionDate) {
		model.setInceptionDate(inceptionDate);
	}

	/**
	 * Sets the policy no of this pol veh search.
	 *
	 * @param policyNo the policy no of this pol veh search
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this pol veh search.
	 *
	 * @param primaryKey the primary key of this pol veh search
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the vehicle dev type of this pol veh search.
	 *
	 * @param vehicleDevType the vehicle dev type of this pol veh search
	 */
	@Override
	public void setVehicleDevType(String vehicleDevType) {
		model.setVehicleDevType(vehicleDevType);
	}

	/**
	 * Sets the vehicle seq custom of this pol veh search.
	 *
	 * @param vehicleSEQCustom the vehicle seq custom of this pol veh search
	 */
	@Override
	public void setVehicleSEQCustom(String vehicleSEQCustom) {
		model.setVehicleSEQCustom(vehicleSEQCustom);
	}

	@Override
	protected PolVEHSearchWrapper wrap(PolVEHSearch polVEHSearch) {
		return new PolVEHSearchWrapper(polVEHSearch);
	}

}