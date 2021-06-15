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

import java.sql.Blob;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PolicyCancelation}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelation
 * @generated
 */
public class PolicyCancelationWrapper
	extends BaseModelWrapper<PolicyCancelation>
	implements ModelWrapper<PolicyCancelation>, PolicyCancelation {

	public PolicyCancelationWrapper(PolicyCancelation policyCancelation) {
		super(policyCancelation);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("Id", getId());
		attributes.put("policyNumber", getPolicyNumber());
		attributes.put("policyExpiryDate", getPolicyExpiryDate());
		attributes.put("insuredId", getInsuredId());
		attributes.put("insuredName", getInsuredName());
		attributes.put("vehicleSequence", getVehicleSequence());
		attributes.put("vehicleChessisNo", getVehicleChessisNo());
		attributes.put("status", getStatus());
		attributes.put("cancllationReqDate", getCancllationReqDate());
		attributes.put("reason", getReason());
		attributes.put("servicemessage", getServicemessage());
		attributes.put("cancellationEffdate", getCancellationEffdate());
		attributes.put("ibanImage", getIbanImage());
		attributes.put("validFile", getValidFile());
		attributes.put("otherFile", getOtherFile());
		attributes.put("vehMake", getVehMake());
		attributes.put("vehModel", getVehModel());
		attributes.put("plateNumber", getPlateNumber());
		attributes.put("anyAccident", getAnyAccident());
		attributes.put("lodgeClaim", getLodgeClaim());
		attributes.put("ibanFileName", getIbanFileName());
		attributes.put("validFileName", getValidFileName());
		attributes.put("policyInceptionDate", getPolicyInceptionDate());
		attributes.put("insuredEmail", getInsuredEmail());
		attributes.put("insuredMobile", getInsuredMobile());
		attributes.put("rejReason", getRejReason());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String Id = (String)attributes.get("Id");

		if (Id != null) {
			setId(Id);
		}

		String policyNumber = (String)attributes.get("policyNumber");

		if (policyNumber != null) {
			setPolicyNumber(policyNumber);
		}

		Date policyExpiryDate = (Date)attributes.get("policyExpiryDate");

		if (policyExpiryDate != null) {
			setPolicyExpiryDate(policyExpiryDate);
		}

		String insuredId = (String)attributes.get("insuredId");

		if (insuredId != null) {
			setInsuredId(insuredId);
		}

		String insuredName = (String)attributes.get("insuredName");

		if (insuredName != null) {
			setInsuredName(insuredName);
		}

		String vehicleSequence = (String)attributes.get("vehicleSequence");

		if (vehicleSequence != null) {
			setVehicleSequence(vehicleSequence);
		}

		String vehicleChessisNo = (String)attributes.get("vehicleChessisNo");

		if (vehicleChessisNo != null) {
			setVehicleChessisNo(vehicleChessisNo);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date cancllationReqDate = (Date)attributes.get("cancllationReqDate");

		if (cancllationReqDate != null) {
			setCancllationReqDate(cancllationReqDate);
		}

		String reason = (String)attributes.get("reason");

		if (reason != null) {
			setReason(reason);
		}

		String servicemessage = (String)attributes.get("servicemessage");

		if (servicemessage != null) {
			setServicemessage(servicemessage);
		}

		Date cancellationEffdate = (Date)attributes.get("cancellationEffdate");

		if (cancellationEffdate != null) {
			setCancellationEffdate(cancellationEffdate);
		}

		Blob ibanImage = (Blob)attributes.get("ibanImage");

		if (ibanImage != null) {
			setIbanImage(ibanImage);
		}

		Blob validFile = (Blob)attributes.get("validFile");

		if (validFile != null) {
			setValidFile(validFile);
		}

		Blob otherFile = (Blob)attributes.get("otherFile");

		if (otherFile != null) {
			setOtherFile(otherFile);
		}

		String vehMake = (String)attributes.get("vehMake");

		if (vehMake != null) {
			setVehMake(vehMake);
		}

		String vehModel = (String)attributes.get("vehModel");

		if (vehModel != null) {
			setVehModel(vehModel);
		}

		String plateNumber = (String)attributes.get("plateNumber");

		if (plateNumber != null) {
			setPlateNumber(plateNumber);
		}

		String anyAccident = (String)attributes.get("anyAccident");

		if (anyAccident != null) {
			setAnyAccident(anyAccident);
		}

		String lodgeClaim = (String)attributes.get("lodgeClaim");

		if (lodgeClaim != null) {
			setLodgeClaim(lodgeClaim);
		}

		String ibanFileName = (String)attributes.get("ibanFileName");

		if (ibanFileName != null) {
			setIbanFileName(ibanFileName);
		}

		String validFileName = (String)attributes.get("validFileName");

		if (validFileName != null) {
			setValidFileName(validFileName);
		}

		Date policyInceptionDate = (Date)attributes.get("policyInceptionDate");

		if (policyInceptionDate != null) {
			setPolicyInceptionDate(policyInceptionDate);
		}

		String insuredEmail = (String)attributes.get("insuredEmail");

		if (insuredEmail != null) {
			setInsuredEmail(insuredEmail);
		}

		String insuredMobile = (String)attributes.get("insuredMobile");

		if (insuredMobile != null) {
			setInsuredMobile(insuredMobile);
		}

		String rejReason = (String)attributes.get("rejReason");

		if (rejReason != null) {
			setRejReason(rejReason);
		}
	}

	/**
	 * Returns the any accident of this policy cancelation.
	 *
	 * @return the any accident of this policy cancelation
	 */
	@Override
	public String getAnyAccident() {
		return model.getAnyAccident();
	}

	/**
	 * Returns the cancellation effdate of this policy cancelation.
	 *
	 * @return the cancellation effdate of this policy cancelation
	 */
	@Override
	public Date getCancellationEffdate() {
		return model.getCancellationEffdate();
	}

	/**
	 * Returns the cancllation req date of this policy cancelation.
	 *
	 * @return the cancllation req date of this policy cancelation
	 */
	@Override
	public Date getCancllationReqDate() {
		return model.getCancllationReqDate();
	}

	/**
	 * Returns the iban file name of this policy cancelation.
	 *
	 * @return the iban file name of this policy cancelation
	 */
	@Override
	public String getIbanFileName() {
		return model.getIbanFileName();
	}

	/**
	 * Returns the iban image of this policy cancelation.
	 *
	 * @return the iban image of this policy cancelation
	 */
	@Override
	public Blob getIbanImage() {
		return model.getIbanImage();
	}

	/**
	 * Returns the ID of this policy cancelation.
	 *
	 * @return the ID of this policy cancelation
	 */
	@Override
	public String getId() {
		return model.getId();
	}

	/**
	 * Returns the insured email of this policy cancelation.
	 *
	 * @return the insured email of this policy cancelation
	 */
	@Override
	public String getInsuredEmail() {
		return model.getInsuredEmail();
	}

	/**
	 * Returns the insured ID of this policy cancelation.
	 *
	 * @return the insured ID of this policy cancelation
	 */
	@Override
	public String getInsuredId() {
		return model.getInsuredId();
	}

	/**
	 * Returns the insured mobile of this policy cancelation.
	 *
	 * @return the insured mobile of this policy cancelation
	 */
	@Override
	public String getInsuredMobile() {
		return model.getInsuredMobile();
	}

	/**
	 * Returns the insured name of this policy cancelation.
	 *
	 * @return the insured name of this policy cancelation
	 */
	@Override
	public String getInsuredName() {
		return model.getInsuredName();
	}

	/**
	 * Returns the lodge claim of this policy cancelation.
	 *
	 * @return the lodge claim of this policy cancelation
	 */
	@Override
	public String getLodgeClaim() {
		return model.getLodgeClaim();
	}

	/**
	 * Returns the other file of this policy cancelation.
	 *
	 * @return the other file of this policy cancelation
	 */
	@Override
	public Blob getOtherFile() {
		return model.getOtherFile();
	}

	/**
	 * Returns the plate number of this policy cancelation.
	 *
	 * @return the plate number of this policy cancelation
	 */
	@Override
	public String getPlateNumber() {
		return model.getPlateNumber();
	}

	/**
	 * Returns the policy expiry date of this policy cancelation.
	 *
	 * @return the policy expiry date of this policy cancelation
	 */
	@Override
	public Date getPolicyExpiryDate() {
		return model.getPolicyExpiryDate();
	}

	/**
	 * Returns the policy inception date of this policy cancelation.
	 *
	 * @return the policy inception date of this policy cancelation
	 */
	@Override
	public Date getPolicyInceptionDate() {
		return model.getPolicyInceptionDate();
	}

	/**
	 * Returns the policy number of this policy cancelation.
	 *
	 * @return the policy number of this policy cancelation
	 */
	@Override
	public String getPolicyNumber() {
		return model.getPolicyNumber();
	}

	/**
	 * Returns the primary key of this policy cancelation.
	 *
	 * @return the primary key of this policy cancelation
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the reason of this policy cancelation.
	 *
	 * @return the reason of this policy cancelation
	 */
	@Override
	public String getReason() {
		return model.getReason();
	}

	/**
	 * Returns the rej reason of this policy cancelation.
	 *
	 * @return the rej reason of this policy cancelation
	 */
	@Override
	public String getRejReason() {
		return model.getRejReason();
	}

	/**
	 * Returns the servicemessage of this policy cancelation.
	 *
	 * @return the servicemessage of this policy cancelation
	 */
	@Override
	public String getServicemessage() {
		return model.getServicemessage();
	}

	/**
	 * Returns the status of this policy cancelation.
	 *
	 * @return the status of this policy cancelation
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the valid file of this policy cancelation.
	 *
	 * @return the valid file of this policy cancelation
	 */
	@Override
	public Blob getValidFile() {
		return model.getValidFile();
	}

	/**
	 * Returns the valid file name of this policy cancelation.
	 *
	 * @return the valid file name of this policy cancelation
	 */
	@Override
	public String getValidFileName() {
		return model.getValidFileName();
	}

	/**
	 * Returns the vehicle chessis no of this policy cancelation.
	 *
	 * @return the vehicle chessis no of this policy cancelation
	 */
	@Override
	public String getVehicleChessisNo() {
		return model.getVehicleChessisNo();
	}

	/**
	 * Returns the vehicle sequence of this policy cancelation.
	 *
	 * @return the vehicle sequence of this policy cancelation
	 */
	@Override
	public String getVehicleSequence() {
		return model.getVehicleSequence();
	}

	/**
	 * Returns the veh make of this policy cancelation.
	 *
	 * @return the veh make of this policy cancelation
	 */
	@Override
	public String getVehMake() {
		return model.getVehMake();
	}

	/**
	 * Returns the veh model of this policy cancelation.
	 *
	 * @return the veh model of this policy cancelation
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
	 * Sets the any accident of this policy cancelation.
	 *
	 * @param anyAccident the any accident of this policy cancelation
	 */
	@Override
	public void setAnyAccident(String anyAccident) {
		model.setAnyAccident(anyAccident);
	}

	/**
	 * Sets the cancellation effdate of this policy cancelation.
	 *
	 * @param cancellationEffdate the cancellation effdate of this policy cancelation
	 */
	@Override
	public void setCancellationEffdate(Date cancellationEffdate) {
		model.setCancellationEffdate(cancellationEffdate);
	}

	/**
	 * Sets the cancllation req date of this policy cancelation.
	 *
	 * @param cancllationReqDate the cancllation req date of this policy cancelation
	 */
	@Override
	public void setCancllationReqDate(Date cancllationReqDate) {
		model.setCancllationReqDate(cancllationReqDate);
	}

	/**
	 * Sets the iban file name of this policy cancelation.
	 *
	 * @param ibanFileName the iban file name of this policy cancelation
	 */
	@Override
	public void setIbanFileName(String ibanFileName) {
		model.setIbanFileName(ibanFileName);
	}

	/**
	 * Sets the iban image of this policy cancelation.
	 *
	 * @param ibanImage the iban image of this policy cancelation
	 */
	@Override
	public void setIbanImage(Blob ibanImage) {
		model.setIbanImage(ibanImage);
	}

	/**
	 * Sets the ID of this policy cancelation.
	 *
	 * @param Id the ID of this policy cancelation
	 */
	@Override
	public void setId(String Id) {
		model.setId(Id);
	}

	/**
	 * Sets the insured email of this policy cancelation.
	 *
	 * @param insuredEmail the insured email of this policy cancelation
	 */
	@Override
	public void setInsuredEmail(String insuredEmail) {
		model.setInsuredEmail(insuredEmail);
	}

	/**
	 * Sets the insured ID of this policy cancelation.
	 *
	 * @param insuredId the insured ID of this policy cancelation
	 */
	@Override
	public void setInsuredId(String insuredId) {
		model.setInsuredId(insuredId);
	}

	/**
	 * Sets the insured mobile of this policy cancelation.
	 *
	 * @param insuredMobile the insured mobile of this policy cancelation
	 */
	@Override
	public void setInsuredMobile(String insuredMobile) {
		model.setInsuredMobile(insuredMobile);
	}

	/**
	 * Sets the insured name of this policy cancelation.
	 *
	 * @param insuredName the insured name of this policy cancelation
	 */
	@Override
	public void setInsuredName(String insuredName) {
		model.setInsuredName(insuredName);
	}

	/**
	 * Sets the lodge claim of this policy cancelation.
	 *
	 * @param lodgeClaim the lodge claim of this policy cancelation
	 */
	@Override
	public void setLodgeClaim(String lodgeClaim) {
		model.setLodgeClaim(lodgeClaim);
	}

	/**
	 * Sets the other file of this policy cancelation.
	 *
	 * @param otherFile the other file of this policy cancelation
	 */
	@Override
	public void setOtherFile(Blob otherFile) {
		model.setOtherFile(otherFile);
	}

	/**
	 * Sets the plate number of this policy cancelation.
	 *
	 * @param plateNumber the plate number of this policy cancelation
	 */
	@Override
	public void setPlateNumber(String plateNumber) {
		model.setPlateNumber(plateNumber);
	}

	/**
	 * Sets the policy expiry date of this policy cancelation.
	 *
	 * @param policyExpiryDate the policy expiry date of this policy cancelation
	 */
	@Override
	public void setPolicyExpiryDate(Date policyExpiryDate) {
		model.setPolicyExpiryDate(policyExpiryDate);
	}

	/**
	 * Sets the policy inception date of this policy cancelation.
	 *
	 * @param policyInceptionDate the policy inception date of this policy cancelation
	 */
	@Override
	public void setPolicyInceptionDate(Date policyInceptionDate) {
		model.setPolicyInceptionDate(policyInceptionDate);
	}

	/**
	 * Sets the policy number of this policy cancelation.
	 *
	 * @param policyNumber the policy number of this policy cancelation
	 */
	@Override
	public void setPolicyNumber(String policyNumber) {
		model.setPolicyNumber(policyNumber);
	}

	/**
	 * Sets the primary key of this policy cancelation.
	 *
	 * @param primaryKey the primary key of this policy cancelation
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reason of this policy cancelation.
	 *
	 * @param reason the reason of this policy cancelation
	 */
	@Override
	public void setReason(String reason) {
		model.setReason(reason);
	}

	/**
	 * Sets the rej reason of this policy cancelation.
	 *
	 * @param rejReason the rej reason of this policy cancelation
	 */
	@Override
	public void setRejReason(String rejReason) {
		model.setRejReason(rejReason);
	}

	/**
	 * Sets the servicemessage of this policy cancelation.
	 *
	 * @param servicemessage the servicemessage of this policy cancelation
	 */
	@Override
	public void setServicemessage(String servicemessage) {
		model.setServicemessage(servicemessage);
	}

	/**
	 * Sets the status of this policy cancelation.
	 *
	 * @param status the status of this policy cancelation
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the valid file of this policy cancelation.
	 *
	 * @param validFile the valid file of this policy cancelation
	 */
	@Override
	public void setValidFile(Blob validFile) {
		model.setValidFile(validFile);
	}

	/**
	 * Sets the valid file name of this policy cancelation.
	 *
	 * @param validFileName the valid file name of this policy cancelation
	 */
	@Override
	public void setValidFileName(String validFileName) {
		model.setValidFileName(validFileName);
	}

	/**
	 * Sets the vehicle chessis no of this policy cancelation.
	 *
	 * @param vehicleChessisNo the vehicle chessis no of this policy cancelation
	 */
	@Override
	public void setVehicleChessisNo(String vehicleChessisNo) {
		model.setVehicleChessisNo(vehicleChessisNo);
	}

	/**
	 * Sets the vehicle sequence of this policy cancelation.
	 *
	 * @param vehicleSequence the vehicle sequence of this policy cancelation
	 */
	@Override
	public void setVehicleSequence(String vehicleSequence) {
		model.setVehicleSequence(vehicleSequence);
	}

	/**
	 * Sets the veh make of this policy cancelation.
	 *
	 * @param vehMake the veh make of this policy cancelation
	 */
	@Override
	public void setVehMake(String vehMake) {
		model.setVehMake(vehMake);
	}

	/**
	 * Sets the veh model of this policy cancelation.
	 *
	 * @param vehModel the veh model of this policy cancelation
	 */
	@Override
	public void setVehModel(String vehModel) {
		model.setVehModel(vehModel);
	}

	@Override
	protected PolicyCancelationWrapper wrap(
		PolicyCancelation policyCancelation) {

		return new PolicyCancelationWrapper(policyCancelation);
	}

}