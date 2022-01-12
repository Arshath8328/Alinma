/*
 * PolicyVehicle.java Jan 4, 2018  
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
package com.ejada.atmc.bsl.db.domain.policy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Ghada Shawkat
 *
 */
public class PolicyVehicle implements Serializable {
	String policyNo;
	String vehId;
	String vehicleDefType;
	String vehicleDefTypeDesc;
	String vehicleDefTypeDescAr;
	String vehicleSeqCustom;
	String chassisNo;
	String bodyType;
	String bodyTypeEn;
	String bodyTypeAr;
	String make;
	String makeEn;
	String makeAr;
	String model;
	String modelEn;
	String modelAr;
	long mfgYear;
	String color;
	String colorEn;
	String colorAr;
	String agencyRepair;
	long noofPassengers;
	long enPlateNo;
	String enPlateL1;
	String enPlateL2;
	String enPlateL3;
	String arPlateNo;
	String arPlateL1;
	String arPlateL2;
	String arPlateL3;
	long deductible;
	long vehicleValue;
	long premium;
	long discounts;
	long loading;
	long totalPremium;
	long noofClaimFreeYears;
	String useOfCehicle;
	String useOfCehicleEn;
	String useOfCehicleAr;
	String najmPlateType;
	String najmPlateTypeEn;
	String najmPlateTypeAr;
	String najmStatus;
	List<PolicyVehicleDriver> vehicleDrivers;
	List<PolicyVehicleCover> vehicleCovers;
	String estemaraExpiryDate;
	String geoLocation;

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
	 * @return the vehId
	 */
	public String getVehId() {
		return vehId;
	}

	/**
	 * @param vehId the vehId to set
	 */
	public void setVehId(String vehId) {
		this.vehId = vehId;
	}

	/**
	 * @return the vehicleDefType
	 */
	public String getVehicleDefType() {
		return vehicleDefType;
	}

	/**
	 * @param vehicleDefType the vehicleDefType to set
	 */
	public void setVehicleDefType(String vehicleDefType) {
		this.vehicleDefType = vehicleDefType;
	}

	/**
	 * @return the vehicleSeqCustom
	 */
	public String getVehicleSeqCustom() {
		return vehicleSeqCustom;
	}

	/**
	 * @param vehicleSeqCustom the vehicleSeqCustom to set
	 */
	public void setVehicleSeqCustom(String vehicleSeqCustom) {
		this.vehicleSeqCustom = vehicleSeqCustom;
	}

	/**
	 * @return the chassisNo
	 */
	public String getChassisNo() {
		return chassisNo;
	}

	/**
	 * @param chassisNo the chassisNo to set
	 */
	public void setChassisNo(String chassisNo) {
		this.chassisNo = chassisNo;
	}

	/**
	 * @return the bodyType
	 */
	public String getBodyType() {
		return bodyType;
	}

	/**
	 * @param bodyType the bodyType to set
	 */
	public void setBodyType(String bodyType) {
		this.bodyType = bodyType;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the mfgYear
	 */
	public long getMfgYear() {
		return mfgYear;
	}

	/**
	 * @param mfgYear the mfgYear to set
	 */
	public void setMfgYear(long mfgYear) {
		this.mfgYear = mfgYear;
	}

	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * @return the agencyRepair
	 */
	public String getAgencyRepair() {
		return agencyRepair;
	}

	/**
	 * @param agencyRepair the agencyRepair to set
	 */
	public void setAgencyRepair(String agencyRepair) {
		this.agencyRepair = agencyRepair;
	}

	/**
	 * @return the noofPassengers
	 */
	public long getNoofPassengers() {
		return noofPassengers;
	}

	/**
	 * @param noofPassengers the noofPassengers to set
	 */
	public void setNoofPassengers(long noofPassengers) {
		this.noofPassengers = noofPassengers;
	}

	/**
	 * @return the enPlateNo
	 */
	public long getEnPlateNo() {
		return enPlateNo;
	}

	/**
	 * @param enPlateNo the enPlateNo to set
	 */
	public void setEnPlateNo(long enPlateNo) {
		this.enPlateNo = enPlateNo;
	}

	/**
	 * @return the enPlateL1
	 */
	public String getEnPlateL1() {
		return enPlateL1;
	}

	/**
	 * @param enPlateL1 the enPlateL1 to set
	 */
	public void setEnPlateL1(String enPlateL1) {
		this.enPlateL1 = enPlateL1;
	}

	/**
	 * @return the enPlateL2
	 */
	public String getEnPlateL2() {
		return enPlateL2;
	}

	/**
	 * @param enPlateL2 the enPlateL2 to set
	 */
	public void setEnPlateL2(String enPlateL2) {
		this.enPlateL2 = enPlateL2;
	}

	/**
	 * @return the enPlateL3
	 */
	public String getEnPlateL3() {
		return enPlateL3;
	}

	/**
	 * @param enPlateL3 the enPlateL3 to set
	 */
	public void setEnPlateL3(String enPlateL3) {
		this.enPlateL3 = enPlateL3;
	}

	/**
	 * @return the arPlateNo
	 */
	public String getArPlateNo() {
		return arPlateNo;
	}

	/**
	 * @param arPlateNo the arPlateNo to set
	 */
	public void setArPlateNo(String arPlateNo) {
		this.arPlateNo = arPlateNo;
	}

	/**
	 * @return the arPlateL1
	 */
	public String getArPlateL1() {
		return arPlateL1;
	}

	/**
	 * @param arPlateL1 the arPlateL1 to set
	 */
	public void setArPlateL1(String arPlateL1) {
		this.arPlateL1 = arPlateL1;
	}

	/**
	 * @return the arPlateL2
	 */
	public String getArPlateL2() {
		return arPlateL2;
	}

	/**
	 * @param arPlateL2 the arPlateL2 to set
	 */
	public void setArPlateL2(String arPlateL2) {
		this.arPlateL2 = arPlateL2;
	}

	/**
	 * @return the arPlateL3
	 */
	public String getArPlateL3() {
		return arPlateL3;
	}

	/**
	 * @param arPlateL3 the arPlateL3 to set
	 */
	public void setArPlateL3(String arPlateL3) {
		this.arPlateL3 = arPlateL3;
	}

	/**
	 * @return the deductible
	 */
	public long getDeductible() {
		return deductible;
	}

	/**
	 * @param deductible the deductible to set
	 */
	public void setDeductible(long deductible) {
		this.deductible = deductible;
	}

	/**
	 * @return the vehicleValue
	 */
	public long getVehicleValue() {
		return vehicleValue;
	}

	/**
	 * @param vehicleValue the vehicleValue to set
	 */
	public void setVehicleValue(long vehicleValue) {
		this.vehicleValue = vehicleValue;
	}

	/**
	 * @return the premium
	 */
	public long getPremium() {
		return premium;
	}

	/**
	 * @param premium the premium to set
	 */
	public void setPremium(long premium) {
		this.premium = premium;
	}

	/**
	 * @return the discounts
	 */
	public long getDiscounts() {
		return discounts;
	}

	/**
	 * @param discounts the discounts to set
	 */
	public void setDiscounts(long discounts) {
		this.discounts = discounts;
	}

	/**
	 * @return the loading
	 */
	public long getLoading() {
		return loading;
	}

	/**
	 * @param loading the loading to set
	 */
	public void setLoading(long loading) {
		this.loading = loading;
	}

	/**
	 * @return the totalPremium
	 */
	public long getTotalPremium() {
		return totalPremium;
	}

	/**
	 * @param totalPremium the totalPremium to set
	 */
	public void setTotalPremium(long totalPremium) {
		this.totalPremium = totalPremium;
	}

	/**
	 * @return the noofClaimFreeYears
	 */
	public long getNoofClaimFreeYears() {
		return noofClaimFreeYears;
	}

	/**
	 * @param noofClaimFreeYears the noofClaimFreeYears to set
	 */
	public void setNoofClaimFreeYears(long noofClaimFreeYears) {
		this.noofClaimFreeYears = noofClaimFreeYears;
	}

	/**
	 * @return the useOfCehicle
	 */
	public String getUseOfCehicle() {
		return useOfCehicle;
	}

	/**
	 * @param useOfCehicle the useOfCehicle to set
	 */
	public void setUseOfCehicle(String useOfCehicle) {
		this.useOfCehicle = useOfCehicle;
	}

	/**
	 * @return the najmPlateType
	 */
	public String getNajmPlateType() {
		return najmPlateType;
	}

	/**
	 * @param najmPlateType the najmPlateType to set
	 */
	public void setNajmPlateType(String najmPlateType) {
		this.najmPlateType = najmPlateType;
	}

	/**
	 * @return the najmStatus
	 */
	public String getNajmStatus() {
		return najmStatus;
	}

	/**
	 * @param najmStatus the najmStatus to set
	 */
	public void setNajmStatus(String najmStatus) {
		this.najmStatus = najmStatus;
	}

	/**
	 * @return the vehicleDrivers
	 */
	public List<PolicyVehicleDriver> getVehicleDrivers() {
		if (vehicleDrivers == null)
			vehicleDrivers = new ArrayList<>();

		return vehicleDrivers;
	}

	/**
	 * @param vehicleDrivers the vehicleDrivers to set
	 */
	public void setVehicleDrivers(List<PolicyVehicleDriver> vehicleDrivers) {
		this.vehicleDrivers = vehicleDrivers;
	}

	/**
	 * @return the vehicleCovers
	 */
	public List<PolicyVehicleCover> getVehicleCovers() {
		if (vehicleCovers == null)
			vehicleCovers = new ArrayList<>();

		return vehicleCovers;
	}

	/**
	 * @param vehicleCovers the vehicleCovers to set
	 */
	public void setVehicleCovers(List<PolicyVehicleCover> vehicleCovers) {
		this.vehicleCovers = vehicleCovers;
	}

	/**
	 * @return the makeEn
	 */
	public String getMakeEn() {
		return makeEn;
	}

	/**
	 * @param makeEn the makeEn to set
	 */
	public void setMakeEn(String makeEn) {
		this.makeEn = makeEn;
	}

	/**
	 * @return the makeAr
	 */
	public String getMakeAr() {
		return makeAr;
	}

	/**
	 * @param makeAr the makeAr to set
	 */
	public void setMakeAr(String makeAr) {
		this.makeAr = makeAr;
	}

	/**
	 * @return the bodyTypeEn
	 */
	public String getBodyTypeEn() {
		return bodyTypeEn;
	}

	/**
	 * @param bodyTypeEn the bodyTypeEn to set
	 */
	public void setBodyTypeEn(String bodyTypeEn) {
		this.bodyTypeEn = bodyTypeEn;
	}

	/**
	 * @return the bodyTypeAr
	 */
	public String getBodyTypeAr() {
		return bodyTypeAr;
	}

	/**
	 * @param bodyTypeAr the bodyTypeAr to set
	 */
	public void setBodyTypeAr(String bodyTypeAr) {
		this.bodyTypeAr = bodyTypeAr;
	}

	/**
	 * @return the modelEn
	 */
	public String getModelEn() {
		return modelEn;
	}

	/**
	 * @param modelEn the modelEn to set
	 */
	public void setModelEn(String modelEn) {
		this.modelEn = modelEn;
	}

	/**
	 * @return the modelAr
	 */
	public String getModelAr() {
		return modelAr;
	}

	/**
	 * @param modelAr the modelAr to set
	 */
	public void setModelAr(String modelAr) {
		this.modelAr = modelAr;
	}

	/**
	 * @return the colorEn
	 */
	public String getColorEn() {
		return colorEn;
	}

	/**
	 * @param colorEn the colorEn to set
	 */
	public void setColorEn(String colorEn) {
		this.colorEn = colorEn;
	}

	/**
	 * @return the colorAr
	 */
	public String getColorAr() {
		return colorAr;
	}

	/**
	 * @param colorAr the colorAr to set
	 */
	public void setColorAr(String colorAr) {
		this.colorAr = colorAr;
	}

	/**
	 * @return the useOfCehicleEn
	 */
	public String getUseOfCehicleEn() {
		return useOfCehicleEn;
	}

	/**
	 * @param useOfCehicleEn the useOfCehicleEn to set
	 */
	public void setUseOfCehicleEn(String useOfCehicleEn) {
		this.useOfCehicleEn = useOfCehicleEn;
	}

	/**
	 * @return the useOfCehicleAr
	 */
	public String getUseOfCehicleAr() {
		return useOfCehicleAr;
	}

	/**
	 * @param useOfCehicleAr the useOfCehicleAr to set
	 */
	public void setUseOfCehicleAr(String useOfCehicleAr) {
		this.useOfCehicleAr = useOfCehicleAr;
	}

	/**
	 * @return the najmPlateTypeEn
	 */
	public String getNajmPlateTypeEn() {
		return najmPlateTypeEn;
	}

	/**
	 * @param najmPlateTypeEn the najmPlateTypeEn to set
	 */
	public void setNajmPlateTypeEn(String najmPlateTypeEn) {
		this.najmPlateTypeEn = najmPlateTypeEn;
	}

	/**
	 * @return the najmPlateTypeAr
	 */
	public String getNajmPlateTypeAr() {
		return najmPlateTypeAr;
	}

	/**
	 * @param najmPlateTypeAr the najmPlateTypeAr to set
	 */
	public void setNajmPlateTypeAr(String najmPlateTypeAr) {
		this.najmPlateTypeAr = najmPlateTypeAr;
	}

	/**
	 * @return the vehicleDefTypeDesc
	 */
	public String getVehicleDefTypeDesc() {
		return vehicleDefTypeDesc;
	}

	/**
	 * @param vehicleDefTypeDesc the vehicleDefTypeDesc to set
	 */
	public void setVehicleDefTypeDesc(String vehicleDefTypeDesc) {
		this.vehicleDefTypeDesc = vehicleDefTypeDesc;
	}

	/**
	 * @return the vehicleDefTypeDescAr
	 */
	public String getVehicleDefTypeDescAr() {
		return vehicleDefTypeDescAr;
	}

	/**
	 * @param vehicleDefTypeDescAr the vehicleDefTypeDescAr to set
	 */
	public void setVehicleDefTypeDescAr(String vehicleDefTypeDescAr) {
		this.vehicleDefTypeDescAr = vehicleDefTypeDescAr;
	}

	/**
	 * @return the estemaraExpiryDate
	 */
	public String getEstemaraExpiryDate() {
		return estemaraExpiryDate;
	}

	/**
	 * @param estemaraExpiryDate the estemaraExpiryDate to set
	 */
	public void setEstemaraExpiryDate(String estemaraExpiryDate) {
		this.estemaraExpiryDate = estemaraExpiryDate;
	}

	/**
	 * @return the geoLocation
	 */
	public String getGeoLocation() {
		return geoLocation;
	}

	/**
	 * @param geoLocation the geoLocation to set
	 */
	public void setGeoLocation(String geoLocation) {
		this.geoLocation = geoLocation;
	}

	@Override
	public String toString() {
		return "PolicyVehicle [policyNo=" + policyNo + ", vehId=" + vehId + ", vehicleDefType=" + vehicleDefType
				+ ", vehicleDefTypeDesc=" + vehicleDefTypeDesc + ", vehicleDefTypeDescAr=" + vehicleDefTypeDescAr
				+ ", vehicleSeqCustom=" + vehicleSeqCustom + ", chassisNo=" + chassisNo + ", bodyType=" + bodyType
				+ ", bodyTypeEn=" + bodyTypeEn + ", bodyTypeAr=" + bodyTypeAr + ", make=" + make + ", makeEn=" + makeEn
				+ ", makeAr=" + makeAr + ", model=" + model + ", modelEn=" + modelEn + ", modelAr=" + modelAr
				+ ", mfgYear=" + mfgYear + ", color=" + color + ", colorEn=" + colorEn + ", colorAr=" + colorAr
				+ ", agencyRepair=" + agencyRepair + ", noofPassengers=" + noofPassengers + ", enPlateNo=" + enPlateNo
				+ ", enPlateL1=" + enPlateL1 + ", enPlateL2=" + enPlateL2 + ", enPlateL3=" + enPlateL3 + ", arPlateNo="
				+ arPlateNo + ", arPlateL1=" + arPlateL1 + ", arPlateL2=" + arPlateL2 + ", arPlateL3=" + arPlateL3
				+ ", deductible=" + deductible + ", vehicleValue=" + vehicleValue + ", premium=" + premium
				+ ", discounts=" + discounts + ", loading=" + loading + ", totalPremium=" + totalPremium
				+ ", noofClaimFreeYears=" + noofClaimFreeYears + ", useOfCehicle=" + useOfCehicle + ", useOfCehicleEn="
				+ useOfCehicleEn + ", useOfCehicleAr=" + useOfCehicleAr + ", najmPlateType=" + najmPlateType
				+ ", najmPlateTypeEn=" + najmPlateTypeEn + ", najmPlateTypeAr=" + najmPlateTypeAr + ", najmStatus="
				+ najmStatus + ", vehicleDrivers=" + vehicleDrivers + ", vehicleCovers=" + vehicleCovers
				+ ", estemaraExpiryDate=" + estemaraExpiryDate + ", geoLocation=" + geoLocation + "]";
	}

}
