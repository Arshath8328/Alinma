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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.sql.Blob;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PolicyCancelation service. Represents a row in the &quot;EJD_POLICY_CANCELLATION &quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelation
 * @generated
 */
@ProviderType
public interface PolicyCancelationModel extends BaseModel<PolicyCancelation> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a policy cancelation model instance should use the {@link PolicyCancelation} interface instead.
	 */

	/**
	 * Returns the primary key of this policy cancelation.
	 *
	 * @return the primary key of this policy cancelation
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this policy cancelation.
	 *
	 * @param primaryKey the primary key of this policy cancelation
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the ID of this policy cancelation.
	 *
	 * @return the ID of this policy cancelation
	 */
	@AutoEscape
	public String getId();

	/**
	 * Sets the ID of this policy cancelation.
	 *
	 * @param Id the ID of this policy cancelation
	 */
	public void setId(String Id);

	/**
	 * Returns the policy number of this policy cancelation.
	 *
	 * @return the policy number of this policy cancelation
	 */
	@AutoEscape
	public String getPolicyNumber();

	/**
	 * Sets the policy number of this policy cancelation.
	 *
	 * @param policyNumber the policy number of this policy cancelation
	 */
	public void setPolicyNumber(String policyNumber);

	/**
	 * Returns the policy expiry date of this policy cancelation.
	 *
	 * @return the policy expiry date of this policy cancelation
	 */
	public Date getPolicyExpiryDate();

	/**
	 * Sets the policy expiry date of this policy cancelation.
	 *
	 * @param policyExpiryDate the policy expiry date of this policy cancelation
	 */
	public void setPolicyExpiryDate(Date policyExpiryDate);

	/**
	 * Returns the insured ID of this policy cancelation.
	 *
	 * @return the insured ID of this policy cancelation
	 */
	@AutoEscape
	public String getInsuredId();

	/**
	 * Sets the insured ID of this policy cancelation.
	 *
	 * @param insuredId the insured ID of this policy cancelation
	 */
	public void setInsuredId(String insuredId);

	/**
	 * Returns the insured name of this policy cancelation.
	 *
	 * @return the insured name of this policy cancelation
	 */
	@AutoEscape
	public String getInsuredName();

	/**
	 * Sets the insured name of this policy cancelation.
	 *
	 * @param insuredName the insured name of this policy cancelation
	 */
	public void setInsuredName(String insuredName);

	/**
	 * Returns the vehicle sequence of this policy cancelation.
	 *
	 * @return the vehicle sequence of this policy cancelation
	 */
	@AutoEscape
	public String getVehicleSequence();

	/**
	 * Sets the vehicle sequence of this policy cancelation.
	 *
	 * @param vehicleSequence the vehicle sequence of this policy cancelation
	 */
	public void setVehicleSequence(String vehicleSequence);

	/**
	 * Returns the vehicle chessis no of this policy cancelation.
	 *
	 * @return the vehicle chessis no of this policy cancelation
	 */
	@AutoEscape
	public String getVehicleChessisNo();

	/**
	 * Sets the vehicle chessis no of this policy cancelation.
	 *
	 * @param vehicleChessisNo the vehicle chessis no of this policy cancelation
	 */
	public void setVehicleChessisNo(String vehicleChessisNo);

	/**
	 * Returns the status of this policy cancelation.
	 *
	 * @return the status of this policy cancelation
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this policy cancelation.
	 *
	 * @param status the status of this policy cancelation
	 */
	public void setStatus(String status);

	/**
	 * Returns the cancllation req date of this policy cancelation.
	 *
	 * @return the cancllation req date of this policy cancelation
	 */
	public Date getCancllationReqDate();

	/**
	 * Sets the cancllation req date of this policy cancelation.
	 *
	 * @param cancllationReqDate the cancllation req date of this policy cancelation
	 */
	public void setCancllationReqDate(Date cancllationReqDate);

	/**
	 * Returns the reason of this policy cancelation.
	 *
	 * @return the reason of this policy cancelation
	 */
	@AutoEscape
	public String getReason();

	/**
	 * Sets the reason of this policy cancelation.
	 *
	 * @param reason the reason of this policy cancelation
	 */
	public void setReason(String reason);

	/**
	 * Returns the servicemessage of this policy cancelation.
	 *
	 * @return the servicemessage of this policy cancelation
	 */
	@AutoEscape
	public String getServicemessage();

	/**
	 * Sets the servicemessage of this policy cancelation.
	 *
	 * @param servicemessage the servicemessage of this policy cancelation
	 */
	public void setServicemessage(String servicemessage);

	/**
	 * Returns the cancellation effdate of this policy cancelation.
	 *
	 * @return the cancellation effdate of this policy cancelation
	 */
	public Date getCancellationEffdate();

	/**
	 * Sets the cancellation effdate of this policy cancelation.
	 *
	 * @param cancellationEffdate the cancellation effdate of this policy cancelation
	 */
	public void setCancellationEffdate(Date cancellationEffdate);

	/**
	 * Returns the iban image of this policy cancelation.
	 *
	 * @return the iban image of this policy cancelation
	 */
	public Blob getIbanImage();

	/**
	 * Sets the iban image of this policy cancelation.
	 *
	 * @param ibanImage the iban image of this policy cancelation
	 */
	public void setIbanImage(Blob ibanImage);

	/**
	 * Returns the valid file of this policy cancelation.
	 *
	 * @return the valid file of this policy cancelation
	 */
	public Blob getValidFile();

	/**
	 * Sets the valid file of this policy cancelation.
	 *
	 * @param validFile the valid file of this policy cancelation
	 */
	public void setValidFile(Blob validFile);

	/**
	 * Returns the other file of this policy cancelation.
	 *
	 * @return the other file of this policy cancelation
	 */
	public Blob getOtherFile();

	/**
	 * Sets the other file of this policy cancelation.
	 *
	 * @param otherFile the other file of this policy cancelation
	 */
	public void setOtherFile(Blob otherFile);

	/**
	 * Returns the veh make of this policy cancelation.
	 *
	 * @return the veh make of this policy cancelation
	 */
	@AutoEscape
	public String getVehMake();

	/**
	 * Sets the veh make of this policy cancelation.
	 *
	 * @param vehMake the veh make of this policy cancelation
	 */
	public void setVehMake(String vehMake);

	/**
	 * Returns the veh model of this policy cancelation.
	 *
	 * @return the veh model of this policy cancelation
	 */
	@AutoEscape
	public String getVehModel();

	/**
	 * Sets the veh model of this policy cancelation.
	 *
	 * @param vehModel the veh model of this policy cancelation
	 */
	public void setVehModel(String vehModel);

	/**
	 * Returns the plate number of this policy cancelation.
	 *
	 * @return the plate number of this policy cancelation
	 */
	@AutoEscape
	public String getPlateNumber();

	/**
	 * Sets the plate number of this policy cancelation.
	 *
	 * @param plateNumber the plate number of this policy cancelation
	 */
	public void setPlateNumber(String plateNumber);

	/**
	 * Returns the any accident of this policy cancelation.
	 *
	 * @return the any accident of this policy cancelation
	 */
	@AutoEscape
	public String getAnyAccident();

	/**
	 * Sets the any accident of this policy cancelation.
	 *
	 * @param anyAccident the any accident of this policy cancelation
	 */
	public void setAnyAccident(String anyAccident);

	/**
	 * Returns the lodge claim of this policy cancelation.
	 *
	 * @return the lodge claim of this policy cancelation
	 */
	@AutoEscape
	public String getLodgeClaim();

	/**
	 * Sets the lodge claim of this policy cancelation.
	 *
	 * @param lodgeClaim the lodge claim of this policy cancelation
	 */
	public void setLodgeClaim(String lodgeClaim);

	/**
	 * Returns the iban file name of this policy cancelation.
	 *
	 * @return the iban file name of this policy cancelation
	 */
	@AutoEscape
	public String getIbanFileName();

	/**
	 * Sets the iban file name of this policy cancelation.
	 *
	 * @param ibanFileName the iban file name of this policy cancelation
	 */
	public void setIbanFileName(String ibanFileName);

	/**
	 * Returns the valid file name of this policy cancelation.
	 *
	 * @return the valid file name of this policy cancelation
	 */
	@AutoEscape
	public String getValidFileName();

	/**
	 * Sets the valid file name of this policy cancelation.
	 *
	 * @param validFileName the valid file name of this policy cancelation
	 */
	public void setValidFileName(String validFileName);

	/**
	 * Returns the policy inception date of this policy cancelation.
	 *
	 * @return the policy inception date of this policy cancelation
	 */
	public Date getPolicyInceptionDate();

	/**
	 * Sets the policy inception date of this policy cancelation.
	 *
	 * @param policyInceptionDate the policy inception date of this policy cancelation
	 */
	public void setPolicyInceptionDate(Date policyInceptionDate);

	/**
	 * Returns the insured email of this policy cancelation.
	 *
	 * @return the insured email of this policy cancelation
	 */
	@AutoEscape
	public String getInsuredEmail();

	/**
	 * Sets the insured email of this policy cancelation.
	 *
	 * @param insuredEmail the insured email of this policy cancelation
	 */
	public void setInsuredEmail(String insuredEmail);

	/**
	 * Returns the insured mobile of this policy cancelation.
	 *
	 * @return the insured mobile of this policy cancelation
	 */
	@AutoEscape
	public String getInsuredMobile();

	/**
	 * Sets the insured mobile of this policy cancelation.
	 *
	 * @param insuredMobile the insured mobile of this policy cancelation
	 */
	public void setInsuredMobile(String insuredMobile);

	/**
	 * Returns the rej reason of this policy cancelation.
	 *
	 * @return the rej reason of this policy cancelation
	 */
	@AutoEscape
	public String getRejReason();

	/**
	 * Sets the rej reason of this policy cancelation.
	 *
	 * @param rejReason the rej reason of this policy cancelation
	 */
	public void setRejReason(String rejReason);

}