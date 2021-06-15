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
 * This class is a wrapper for {@link PolicyVEH}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEH
 * @generated
 */
public class PolicyVEHWrapper
	extends BaseModelWrapper<PolicyVEH>
	implements ModelWrapper<PolicyVEH>, PolicyVEH {

	public PolicyVEHWrapper(PolicyVEH policyVEH) {
		super(policyVEH);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("vehId", getVehId());
		attributes.put("vehicleDefType", getVehicleDefType());
		attributes.put("vehicleSeqCustom", getVehicleSeqCustom());
		attributes.put("chassisNo", getChassisNo());
		attributes.put("bodyType", getBodyType());
		attributes.put("make", getMake());
		attributes.put("vehModel", getVehModel());
		attributes.put("mfgYear", getMfgYear());
		attributes.put("color", getColor());
		attributes.put("agencyRepair", getAgencyRepair());
		attributes.put("noofPassengers", getNoofPassengers());
		attributes.put("enPlateNo", getEnPlateNo());
		attributes.put("enPlateL1", getEnPlateL1());
		attributes.put("enPlateL2", getEnPlateL2());
		attributes.put("enPlateL3", getEnPlateL3());
		attributes.put("arPlateNo", getArPlateNo());
		attributes.put("arPlateL1", getArPlateL1());
		attributes.put("arPlateL2", getArPlateL2());
		attributes.put("arPlateL3", getArPlateL3());
		attributes.put("deductible", getDeductible());
		attributes.put("vehicleValue", getVehicleValue());
		attributes.put("premium", getPremium());
		attributes.put("discounts", getDiscounts());
		attributes.put("loading", getLoading());
		attributes.put("totalPremium", getTotalPremium());
		attributes.put("noofClaimFreeYears", getNoofClaimFreeYears());
		attributes.put("useOfCehicle", getUseOfCehicle());
		attributes.put("najmPlateType", getNajmPlateType());
		attributes.put("najmStatus", getNajmStatus());
		attributes.put("estemaraExpiryDate", getEstemaraExpiryDate());
		attributes.put("geoLocation", getGeoLocation());

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

		String vehicleDefType = (String)attributes.get("vehicleDefType");

		if (vehicleDefType != null) {
			setVehicleDefType(vehicleDefType);
		}

		String vehicleSeqCustom = (String)attributes.get("vehicleSeqCustom");

		if (vehicleSeqCustom != null) {
			setVehicleSeqCustom(vehicleSeqCustom);
		}

		String chassisNo = (String)attributes.get("chassisNo");

		if (chassisNo != null) {
			setChassisNo(chassisNo);
		}

		String bodyType = (String)attributes.get("bodyType");

		if (bodyType != null) {
			setBodyType(bodyType);
		}

		String make = (String)attributes.get("make");

		if (make != null) {
			setMake(make);
		}

		String vehModel = (String)attributes.get("vehModel");

		if (vehModel != null) {
			setVehModel(vehModel);
		}

		Long mfgYear = (Long)attributes.get("mfgYear");

		if (mfgYear != null) {
			setMfgYear(mfgYear);
		}

		String color = (String)attributes.get("color");

		if (color != null) {
			setColor(color);
		}

		String agencyRepair = (String)attributes.get("agencyRepair");

		if (agencyRepair != null) {
			setAgencyRepair(agencyRepair);
		}

		Long noofPassengers = (Long)attributes.get("noofPassengers");

		if (noofPassengers != null) {
			setNoofPassengers(noofPassengers);
		}

		Long enPlateNo = (Long)attributes.get("enPlateNo");

		if (enPlateNo != null) {
			setEnPlateNo(enPlateNo);
		}

		String enPlateL1 = (String)attributes.get("enPlateL1");

		if (enPlateL1 != null) {
			setEnPlateL1(enPlateL1);
		}

		String enPlateL2 = (String)attributes.get("enPlateL2");

		if (enPlateL2 != null) {
			setEnPlateL2(enPlateL2);
		}

		String enPlateL3 = (String)attributes.get("enPlateL3");

		if (enPlateL3 != null) {
			setEnPlateL3(enPlateL3);
		}

		String arPlateNo = (String)attributes.get("arPlateNo");

		if (arPlateNo != null) {
			setArPlateNo(arPlateNo);
		}

		String arPlateL1 = (String)attributes.get("arPlateL1");

		if (arPlateL1 != null) {
			setArPlateL1(arPlateL1);
		}

		String arPlateL2 = (String)attributes.get("arPlateL2");

		if (arPlateL2 != null) {
			setArPlateL2(arPlateL2);
		}

		String arPlateL3 = (String)attributes.get("arPlateL3");

		if (arPlateL3 != null) {
			setArPlateL3(arPlateL3);
		}

		Long deductible = (Long)attributes.get("deductible");

		if (deductible != null) {
			setDeductible(deductible);
		}

		Long vehicleValue = (Long)attributes.get("vehicleValue");

		if (vehicleValue != null) {
			setVehicleValue(vehicleValue);
		}

		Long premium = (Long)attributes.get("premium");

		if (premium != null) {
			setPremium(premium);
		}

		Long discounts = (Long)attributes.get("discounts");

		if (discounts != null) {
			setDiscounts(discounts);
		}

		Long loading = (Long)attributes.get("loading");

		if (loading != null) {
			setLoading(loading);
		}

		Long totalPremium = (Long)attributes.get("totalPremium");

		if (totalPremium != null) {
			setTotalPremium(totalPremium);
		}

		Long noofClaimFreeYears = (Long)attributes.get("noofClaimFreeYears");

		if (noofClaimFreeYears != null) {
			setNoofClaimFreeYears(noofClaimFreeYears);
		}

		String useOfCehicle = (String)attributes.get("useOfCehicle");

		if (useOfCehicle != null) {
			setUseOfCehicle(useOfCehicle);
		}

		String najmPlateType = (String)attributes.get("najmPlateType");

		if (najmPlateType != null) {
			setNajmPlateType(najmPlateType);
		}

		String najmStatus = (String)attributes.get("najmStatus");

		if (najmStatus != null) {
			setNajmStatus(najmStatus);
		}

		String estemaraExpiryDate = (String)attributes.get(
			"estemaraExpiryDate");

		if (estemaraExpiryDate != null) {
			setEstemaraExpiryDate(estemaraExpiryDate);
		}

		String geoLocation = (String)attributes.get("geoLocation");

		if (geoLocation != null) {
			setGeoLocation(geoLocation);
		}
	}

	/**
	 * Returns the agency repair of this policy veh.
	 *
	 * @return the agency repair of this policy veh
	 */
	@Override
	public String getAgencyRepair() {
		return model.getAgencyRepair();
	}

	/**
	 * Returns the ar plate l1 of this policy veh.
	 *
	 * @return the ar plate l1 of this policy veh
	 */
	@Override
	public String getArPlateL1() {
		return model.getArPlateL1();
	}

	/**
	 * Returns the ar plate l2 of this policy veh.
	 *
	 * @return the ar plate l2 of this policy veh
	 */
	@Override
	public String getArPlateL2() {
		return model.getArPlateL2();
	}

	/**
	 * Returns the ar plate l3 of this policy veh.
	 *
	 * @return the ar plate l3 of this policy veh
	 */
	@Override
	public String getArPlateL3() {
		return model.getArPlateL3();
	}

	/**
	 * Returns the ar plate no of this policy veh.
	 *
	 * @return the ar plate no of this policy veh
	 */
	@Override
	public String getArPlateNo() {
		return model.getArPlateNo();
	}

	/**
	 * Returns the body type of this policy veh.
	 *
	 * @return the body type of this policy veh
	 */
	@Override
	public String getBodyType() {
		return model.getBodyType();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getBodyTypeDescAr() {
		return model.getBodyTypeDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getBodyTypeDescEn() {
		return model.getBodyTypeDescEn();
	}

	/**
	 * Returns the chassis no of this policy veh.
	 *
	 * @return the chassis no of this policy veh
	 */
	@Override
	public String getChassisNo() {
		return model.getChassisNo();
	}

	/**
	 * Returns the color of this policy veh.
	 *
	 * @return the color of this policy veh
	 */
	@Override
	public String getColor() {
		return model.getColor();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getColorDescAr() {
		return model.getColorDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getColorDescEn() {
		return model.getColorDescEn();
	}

	/**
	 * Returns the deductible of this policy veh.
	 *
	 * @return the deductible of this policy veh
	 */
	@Override
	public long getDeductible() {
		return model.getDeductible();
	}

	/**
	 * Returns the discounts of this policy veh.
	 *
	 * @return the discounts of this policy veh
	 */
	@Override
	public long getDiscounts() {
		return model.getDiscounts();
	}

	/**
	 * Returns the en plate l1 of this policy veh.
	 *
	 * @return the en plate l1 of this policy veh
	 */
	@Override
	public String getEnPlateL1() {
		return model.getEnPlateL1();
	}

	/**
	 * Returns the en plate l2 of this policy veh.
	 *
	 * @return the en plate l2 of this policy veh
	 */
	@Override
	public String getEnPlateL2() {
		return model.getEnPlateL2();
	}

	/**
	 * Returns the en plate l3 of this policy veh.
	 *
	 * @return the en plate l3 of this policy veh
	 */
	@Override
	public String getEnPlateL3() {
		return model.getEnPlateL3();
	}

	/**
	 * Returns the en plate no of this policy veh.
	 *
	 * @return the en plate no of this policy veh
	 */
	@Override
	public long getEnPlateNo() {
		return model.getEnPlateNo();
	}

	/**
	 * Returns the estemara expiry date of this policy veh.
	 *
	 * @return the estemara expiry date of this policy veh
	 */
	@Override
	public String getEstemaraExpiryDate() {
		return model.getEstemaraExpiryDate();
	}

	/**
	 * Returns the geo location of this policy veh.
	 *
	 * @return the geo location of this policy veh
	 */
	@Override
	public String getGeoLocation() {
		return model.getGeoLocation();
	}

	/**
	 * Returns the loading of this policy veh.
	 *
	 * @return the loading of this policy veh
	 */
	@Override
	public long getLoading() {
		return model.getLoading();
	}

	/**
	 * Returns the make of this policy veh.
	 *
	 * @return the make of this policy veh
	 */
	@Override
	public String getMake() {
		return model.getMake();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getMakeDescAr() {
		return model.getMakeDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getMakeDescEn() {
		return model.getMakeDescEn();
	}

	/**
	 * Returns the mfg year of this policy veh.
	 *
	 * @return the mfg year of this policy veh
	 */
	@Override
	public long getMfgYear() {
		return model.getMfgYear();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getModelDescAr() {
		return model.getModelDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getModelDescEn() {
		return model.getModelDescEn();
	}

	/**
	 * Returns the najm plate type of this policy veh.
	 *
	 * @return the najm plate type of this policy veh
	 */
	@Override
	public String getNajmPlateType() {
		return model.getNajmPlateType();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getNajmPlateTypeDescAr() {
		return model.getNajmPlateTypeDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getNajmPlateTypeDescEn() {
		return model.getNajmPlateTypeDescEn();
	}

	/**
	 * Returns the najm status of this policy veh.
	 *
	 * @return the najm status of this policy veh
	 */
	@Override
	public String getNajmStatus() {
		return model.getNajmStatus();
	}

	/**
	 * Returns the noof claim free years of this policy veh.
	 *
	 * @return the noof claim free years of this policy veh
	 */
	@Override
	public long getNoofClaimFreeYears() {
		return model.getNoofClaimFreeYears();
	}

	/**
	 * Returns the noof passengers of this policy veh.
	 *
	 * @return the noof passengers of this policy veh
	 */
	@Override
	public long getNoofPassengers() {
		return model.getNoofPassengers();
	}

	/**
	 * Returns the policy no of this policy veh.
	 *
	 * @return the policy no of this policy veh
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	@Override
	public java.util.List<PolicyVEH> getPolicyVEHs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getPolicyVEHs();
	}

	/**
	 * Returns the premium of this policy veh.
	 *
	 * @return the premium of this policy veh
	 */
	@Override
	public long getPremium() {
		return model.getPremium();
	}

	/**
	 * Returns the primary key of this policy veh.
	 *
	 * @return the primary key of this policy veh
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the total premium of this policy veh.
	 *
	 * @return the total premium of this policy veh
	 */
	@Override
	public long getTotalPremium() {
		return model.getTotalPremium();
	}

	/**
	 * Returns the use of cehicle of this policy veh.
	 *
	 * @return the use of cehicle of this policy veh
	 */
	@Override
	public String getUseOfCehicle() {
		return model.getUseOfCehicle();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getUseOfVehicleDescAr() {
		return model.getUseOfVehicleDescAr();
	}

	/**
	 * @return String
	 * @see
	 */
	@Override
	public String getUseOfVehicleDescEn() {
		return model.getUseOfVehicleDescEn();
	}

	@Override
	public java.util.List<PolicyVehCvr> getVehCvrs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getVehCvrs();
	}

	@Override
	public java.util.List<PolicyVehDrv> getVehDrivs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException {

		return model.getVehDrivs();
	}

	/**
	 * Returns the vehicle def type of this policy veh.
	 *
	 * @return the vehicle def type of this policy veh
	 */
	@Override
	public String getVehicleDefType() {
		return model.getVehicleDefType();
	}

	@Override
	public String getVehicleDefTypeDescAr() {
		return model.getVehicleDefTypeDescAr();
	}

	@Override
	public String getVehicleDefTypeDescEn() {
		return model.getVehicleDefTypeDescEn();
	}

	/**
	 * Returns the vehicle seq custom of this policy veh.
	 *
	 * @return the vehicle seq custom of this policy veh
	 */
	@Override
	public String getVehicleSeqCustom() {
		return model.getVehicleSeqCustom();
	}

	/**
	 * Returns the vehicle value of this policy veh.
	 *
	 * @return the vehicle value of this policy veh
	 */
	@Override
	public long getVehicleValue() {
		return model.getVehicleValue();
	}

	/**
	 * Returns the veh ID of this policy veh.
	 *
	 * @return the veh ID of this policy veh
	 */
	@Override
	public String getVehId() {
		return model.getVehId();
	}

	/**
	 * Returns the veh model of this policy veh.
	 *
	 * @return the veh model of this policy veh
	 */
	@Override
	public String getVehModel() {
		return model.getVehModel();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the agency repair of this policy veh.
	 *
	 * @param agencyRepair the agency repair of this policy veh
	 */
	@Override
	public void setAgencyRepair(String agencyRepair) {
		model.setAgencyRepair(agencyRepair);
	}

	/**
	 * Sets the ar plate l1 of this policy veh.
	 *
	 * @param arPlateL1 the ar plate l1 of this policy veh
	 */
	@Override
	public void setArPlateL1(String arPlateL1) {
		model.setArPlateL1(arPlateL1);
	}

	/**
	 * Sets the ar plate l2 of this policy veh.
	 *
	 * @param arPlateL2 the ar plate l2 of this policy veh
	 */
	@Override
	public void setArPlateL2(String arPlateL2) {
		model.setArPlateL2(arPlateL2);
	}

	/**
	 * Sets the ar plate l3 of this policy veh.
	 *
	 * @param arPlateL3 the ar plate l3 of this policy veh
	 */
	@Override
	public void setArPlateL3(String arPlateL3) {
		model.setArPlateL3(arPlateL3);
	}

	/**
	 * Sets the ar plate no of this policy veh.
	 *
	 * @param arPlateNo the ar plate no of this policy veh
	 */
	@Override
	public void setArPlateNo(String arPlateNo) {
		model.setArPlateNo(arPlateNo);
	}

	/**
	 * Sets the body type of this policy veh.
	 *
	 * @param bodyType the body type of this policy veh
	 */
	@Override
	public void setBodyType(String bodyType) {
		model.setBodyType(bodyType);
	}

	/**
	 * Sets the chassis no of this policy veh.
	 *
	 * @param chassisNo the chassis no of this policy veh
	 */
	@Override
	public void setChassisNo(String chassisNo) {
		model.setChassisNo(chassisNo);
	}

	/**
	 * Sets the color of this policy veh.
	 *
	 * @param color the color of this policy veh
	 */
	@Override
	public void setColor(String color) {
		model.setColor(color);
	}

	/**
	 * Sets the deductible of this policy veh.
	 *
	 * @param deductible the deductible of this policy veh
	 */
	@Override
	public void setDeductible(long deductible) {
		model.setDeductible(deductible);
	}

	/**
	 * Sets the discounts of this policy veh.
	 *
	 * @param discounts the discounts of this policy veh
	 */
	@Override
	public void setDiscounts(long discounts) {
		model.setDiscounts(discounts);
	}

	/**
	 * Sets the en plate l1 of this policy veh.
	 *
	 * @param enPlateL1 the en plate l1 of this policy veh
	 */
	@Override
	public void setEnPlateL1(String enPlateL1) {
		model.setEnPlateL1(enPlateL1);
	}

	/**
	 * Sets the en plate l2 of this policy veh.
	 *
	 * @param enPlateL2 the en plate l2 of this policy veh
	 */
	@Override
	public void setEnPlateL2(String enPlateL2) {
		model.setEnPlateL2(enPlateL2);
	}

	/**
	 * Sets the en plate l3 of this policy veh.
	 *
	 * @param enPlateL3 the en plate l3 of this policy veh
	 */
	@Override
	public void setEnPlateL3(String enPlateL3) {
		model.setEnPlateL3(enPlateL3);
	}

	/**
	 * Sets the en plate no of this policy veh.
	 *
	 * @param enPlateNo the en plate no of this policy veh
	 */
	@Override
	public void setEnPlateNo(long enPlateNo) {
		model.setEnPlateNo(enPlateNo);
	}

	/**
	 * Sets the estemara expiry date of this policy veh.
	 *
	 * @param estemaraExpiryDate the estemara expiry date of this policy veh
	 */
	@Override
	public void setEstemaraExpiryDate(String estemaraExpiryDate) {
		model.setEstemaraExpiryDate(estemaraExpiryDate);
	}

	/**
	 * Sets the geo location of this policy veh.
	 *
	 * @param geoLocation the geo location of this policy veh
	 */
	@Override
	public void setGeoLocation(String geoLocation) {
		model.setGeoLocation(geoLocation);
	}

	/**
	 * Sets the loading of this policy veh.
	 *
	 * @param loading the loading of this policy veh
	 */
	@Override
	public void setLoading(long loading) {
		model.setLoading(loading);
	}

	/**
	 * Sets the make of this policy veh.
	 *
	 * @param make the make of this policy veh
	 */
	@Override
	public void setMake(String make) {
		model.setMake(make);
	}

	/**
	 * Sets the mfg year of this policy veh.
	 *
	 * @param mfgYear the mfg year of this policy veh
	 */
	@Override
	public void setMfgYear(long mfgYear) {
		model.setMfgYear(mfgYear);
	}

	/**
	 * Sets the najm plate type of this policy veh.
	 *
	 * @param najmPlateType the najm plate type of this policy veh
	 */
	@Override
	public void setNajmPlateType(String najmPlateType) {
		model.setNajmPlateType(najmPlateType);
	}

	/**
	 * Sets the najm status of this policy veh.
	 *
	 * @param najmStatus the najm status of this policy veh
	 */
	@Override
	public void setNajmStatus(String najmStatus) {
		model.setNajmStatus(najmStatus);
	}

	/**
	 * Sets the noof claim free years of this policy veh.
	 *
	 * @param noofClaimFreeYears the noof claim free years of this policy veh
	 */
	@Override
	public void setNoofClaimFreeYears(long noofClaimFreeYears) {
		model.setNoofClaimFreeYears(noofClaimFreeYears);
	}

	/**
	 * Sets the noof passengers of this policy veh.
	 *
	 * @param noofPassengers the noof passengers of this policy veh
	 */
	@Override
	public void setNoofPassengers(long noofPassengers) {
		model.setNoofPassengers(noofPassengers);
	}

	/**
	 * Sets the policy no of this policy veh.
	 *
	 * @param policyNo the policy no of this policy veh
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the premium of this policy veh.
	 *
	 * @param premium the premium of this policy veh
	 */
	@Override
	public void setPremium(long premium) {
		model.setPremium(premium);
	}

	/**
	 * Sets the primary key of this policy veh.
	 *
	 * @param primaryKey the primary key of this policy veh
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.PolicyVEHPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the total premium of this policy veh.
	 *
	 * @param totalPremium the total premium of this policy veh
	 */
	@Override
	public void setTotalPremium(long totalPremium) {
		model.setTotalPremium(totalPremium);
	}

	/**
	 * Sets the use of cehicle of this policy veh.
	 *
	 * @param useOfCehicle the use of cehicle of this policy veh
	 */
	@Override
	public void setUseOfCehicle(String useOfCehicle) {
		model.setUseOfCehicle(useOfCehicle);
	}

	/**
	 * Sets the vehicle def type of this policy veh.
	 *
	 * @param vehicleDefType the vehicle def type of this policy veh
	 */
	@Override
	public void setVehicleDefType(String vehicleDefType) {
		model.setVehicleDefType(vehicleDefType);
	}

	/**
	 * Sets the vehicle seq custom of this policy veh.
	 *
	 * @param vehicleSeqCustom the vehicle seq custom of this policy veh
	 */
	@Override
	public void setVehicleSeqCustom(String vehicleSeqCustom) {
		model.setVehicleSeqCustom(vehicleSeqCustom);
	}

	/**
	 * Sets the vehicle value of this policy veh.
	 *
	 * @param vehicleValue the vehicle value of this policy veh
	 */
	@Override
	public void setVehicleValue(long vehicleValue) {
		model.setVehicleValue(vehicleValue);
	}

	/**
	 * Sets the veh ID of this policy veh.
	 *
	 * @param vehId the veh ID of this policy veh
	 */
	@Override
	public void setVehId(String vehId) {
		model.setVehId(vehId);
	}

	/**
	 * Sets the veh model of this policy veh.
	 *
	 * @param vehModel the veh model of this policy veh
	 */
	@Override
	public void setVehModel(String vehModel) {
		model.setVehModel(vehModel);
	}

	@Override
	protected PolicyVEHWrapper wrap(PolicyVEH policyVEH) {
		return new PolicyVEHWrapper(policyVEH);
	}

}