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
 * The base model interface for the QuotationDriverseEndors service. Represents a row in the &quot;EJD_ADD_DRIVERS_ENDORS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndors
 * @generated
 */
@ProviderType
public interface QuotationDriverseEndorsModel
	extends BaseModel<QuotationDriverseEndors> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a quotation driverse endors model instance should use the {@link QuotationDriverseEndors} interface instead.
	 */

	/**
	 * Returns the primary key of this quotation driverse endors.
	 *
	 * @return the primary key of this quotation driverse endors
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this quotation driverse endors.
	 *
	 * @param primaryKey the primary key of this quotation driverse endors
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the add driver ID of this quotation driverse endors.
	 *
	 * @return the add driver ID of this quotation driverse endors
	 */
	public long getAddDriverId();

	/**
	 * Sets the add driver ID of this quotation driverse endors.
	 *
	 * @param addDriverId the add driver ID of this quotation driverse endors
	 */
	public void setAddDriverId(long addDriverId);

	/**
	 * Returns the quotation ID of this quotation driverse endors.
	 *
	 * @return the quotation ID of this quotation driverse endors
	 */
	public long getQuotationId();

	/**
	 * Sets the quotation ID of this quotation driverse endors.
	 *
	 * @param quotationId the quotation ID of this quotation driverse endors
	 */
	public void setQuotationId(long quotationId);

	/**
	 * Returns the policy number of this quotation driverse endors.
	 *
	 * @return the policy number of this quotation driverse endors
	 */
	@AutoEscape
	public String getPolicyNumber();

	/**
	 * Sets the policy number of this quotation driverse endors.
	 *
	 * @param policyNumber the policy number of this quotation driverse endors
	 */
	public void setPolicyNumber(String policyNumber);

	/**
	 * Returns the driver dob of this quotation driverse endors.
	 *
	 * @return the driver dob of this quotation driverse endors
	 */
	public Date getDriverDob();

	/**
	 * Sets the driver dob of this quotation driverse endors.
	 *
	 * @param driverDob the driver dob of this quotation driverse endors
	 */
	public void setDriverDob(Date driverDob);

	/**
	 * Returns the driver dob h of this quotation driverse endors.
	 *
	 * @return the driver dob h of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverDobH();

	/**
	 * Sets the driver dob h of this quotation driverse endors.
	 *
	 * @param driverDobH the driver dob h of this quotation driverse endors
	 */
	public void setDriverDobH(String driverDobH);

	/**
	 * Returns the driver gender of this quotation driverse endors.
	 *
	 * @return the driver gender of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverGender();

	/**
	 * Sets the driver gender of this quotation driverse endors.
	 *
	 * @param driverGender the driver gender of this quotation driverse endors
	 */
	public void setDriverGender(String driverGender);

	/**
	 * Returns the driver ID of this quotation driverse endors.
	 *
	 * @return the driver ID of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverId();

	/**
	 * Sets the driver ID of this quotation driverse endors.
	 *
	 * @param driverId the driver ID of this quotation driverse endors
	 */
	public void setDriverId(String driverId);

	/**
	 * Returns the driver ID type of this quotation driverse endors.
	 *
	 * @return the driver ID type of this quotation driverse endors
	 */
	public long getDriverIdType();

	/**
	 * Sets the driver ID type of this quotation driverse endors.
	 *
	 * @param driverIdType the driver ID type of this quotation driverse endors
	 */
	public void setDriverIdType(long driverIdType);

	/**
	 * Returns the driver name of this quotation driverse endors.
	 *
	 * @return the driver name of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverName();

	/**
	 * Sets the driver name of this quotation driverse endors.
	 *
	 * @param driverName the driver name of this quotation driverse endors
	 */
	public void setDriverName(String driverName);

	/**
	 * Returns the driver nationality of this quotation driverse endors.
	 *
	 * @return the driver nationality of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverNationality();

	/**
	 * Sets the driver nationality of this quotation driverse endors.
	 *
	 * @param driverNationality the driver nationality of this quotation driverse endors
	 */
	public void setDriverNationality(String driverNationality);

	/**
	 * Returns the driver occup of this quotation driverse endors.
	 *
	 * @return the driver occup of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverOccup();

	/**
	 * Sets the driver occup of this quotation driverse endors.
	 *
	 * @param driverOccup the driver occup of this quotation driverse endors
	 */
	public void setDriverOccup(String driverOccup);

	/**
	 * Returns the is driver under21 of this quotation driverse endors.
	 *
	 * @return the is driver under21 of this quotation driverse endors
	 */
	public boolean getIsDriverUnder21();

	/**
	 * Returns <code>true</code> if this quotation driverse endors is is driver under21.
	 *
	 * @return <code>true</code> if this quotation driverse endors is is driver under21; <code>false</code> otherwise
	 */
	public boolean isIsDriverUnder21();

	/**
	 * Sets whether this quotation driverse endors is is driver under21.
	 *
	 * @param isDriverUnder21 the is driver under21 of this quotation driverse endors
	 */
	public void setIsDriverUnder21(boolean isDriverUnder21);

	/**
	 * Returns the driver edu of this quotation driverse endors.
	 *
	 * @return the driver edu of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverEdu();

	/**
	 * Sets the driver edu of this quotation driverse endors.
	 *
	 * @param driverEdu the driver edu of this quotation driverse endors
	 */
	public void setDriverEdu(String driverEdu);

	/**
	 * Returns the driver no child of this quotation driverse endors.
	 *
	 * @return the driver no child of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverNoChild();

	/**
	 * Sets the driver no child of this quotation driverse endors.
	 *
	 * @param driverNoChild the driver no child of this quotation driverse endors
	 */
	public void setDriverNoChild(String driverNoChild);

	/**
	 * Returns the driver marital status of this quotation driverse endors.
	 *
	 * @return the driver marital status of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverMaritalStatus();

	/**
	 * Sets the driver marital status of this quotation driverse endors.
	 *
	 * @param driverMaritalStatus the driver marital status of this quotation driverse endors
	 */
	public void setDriverMaritalStatus(String driverMaritalStatus);

	/**
	 * Returns the driver no fault of this quotation driverse endors.
	 *
	 * @return the driver no fault of this quotation driverse endors
	 */
	public long getDriverNOFault();

	/**
	 * Sets the driver no fault of this quotation driverse endors.
	 *
	 * @param driverNOFault the driver no fault of this quotation driverse endors
	 */
	public void setDriverNOFault(long driverNOFault);

	/**
	 * Returns the driver no claim of this quotation driverse endors.
	 *
	 * @return the driver no claim of this quotation driverse endors
	 */
	public long getDriverNOClaim();

	/**
	 * Sets the driver no claim of this quotation driverse endors.
	 *
	 * @param driverNOClaim the driver no claim of this quotation driverse endors
	 */
	public void setDriverNOClaim(long driverNOClaim);

	/**
	 * Returns the driver convictions of this quotation driverse endors.
	 *
	 * @return the driver convictions of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverConvictions();

	/**
	 * Sets the driver convictions of this quotation driverse endors.
	 *
	 * @param driverConvictions the driver convictions of this quotation driverse endors
	 */
	public void setDriverConvictions(String driverConvictions);

	/**
	 * Returns the driver med conds of this quotation driverse endors.
	 *
	 * @return the driver med conds of this quotation driverse endors
	 */
	@AutoEscape
	public String getDriverMedConds();

	/**
	 * Sets the driver med conds of this quotation driverse endors.
	 *
	 * @param driverMedConds the driver med conds of this quotation driverse endors
	 */
	public void setDriverMedConds(String driverMedConds);

	/**
	 * Returns the ncd years of this quotation driverse endors.
	 *
	 * @return the ncd years of this quotation driverse endors
	 */
	public int getNcdYears();

	/**
	 * Sets the ncd years of this quotation driverse endors.
	 *
	 * @param ncdYears the ncd years of this quotation driverse endors
	 */
	public void setNcdYears(int ncdYears);

	/**
	 * Returns the insured relation of this quotation driverse endors.
	 *
	 * @return the insured relation of this quotation driverse endors
	 */
	@AutoEscape
	public String getInsuredRelation();

	/**
	 * Sets the insured relation of this quotation driverse endors.
	 *
	 * @param insuredRelation the insured relation of this quotation driverse endors
	 */
	public void setInsuredRelation(String insuredRelation);

	/**
	 * Returns the insured relation proof of this quotation driverse endors.
	 *
	 * @return the insured relation proof of this quotation driverse endors
	 */
	public Blob getInsuredRelationProof();

	/**
	 * Sets the insured relation proof of this quotation driverse endors.
	 *
	 * @param insuredRelationProof the insured relation proof of this quotation driverse endors
	 */
	public void setInsuredRelationProof(Blob insuredRelationProof);

	/**
	 * Returns the insured relation proof file name of this quotation driverse endors.
	 *
	 * @return the insured relation proof file name of this quotation driverse endors
	 */
	@AutoEscape
	public String getInsuredRelationProofFileName();

	/**
	 * Sets the insured relation proof file name of this quotation driverse endors.
	 *
	 * @param insuredRelationProofFileName the insured relation proof file name of this quotation driverse endors
	 */
	public void setInsuredRelationProofFileName(
		String insuredRelationProofFileName);

	/**
	 * Returns the status of this quotation driverse endors.
	 *
	 * @return the status of this quotation driverse endors
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this quotation driverse endors.
	 *
	 * @param status the status of this quotation driverse endors
	 */
	public void setStatus(String status);

	/**
	 * Returns the requested date of this quotation driverse endors.
	 *
	 * @return the requested date of this quotation driverse endors
	 */
	public Date getRequestedDate();

	/**
	 * Sets the requested date of this quotation driverse endors.
	 *
	 * @param requestedDate the requested date of this quotation driverse endors
	 */
	public void setRequestedDate(Date requestedDate);

	/**
	 * Returns the build no of this quotation driverse endors.
	 *
	 * @return the build no of this quotation driverse endors
	 */
	@AutoEscape
	public String getBuildNo();

	/**
	 * Sets the build no of this quotation driverse endors.
	 *
	 * @param buildNo the build no of this quotation driverse endors
	 */
	public void setBuildNo(String buildNo);

	/**
	 * Returns the zip code of this quotation driverse endors.
	 *
	 * @return the zip code of this quotation driverse endors
	 */
	@AutoEscape
	public String getZipCode();

	/**
	 * Sets the zip code of this quotation driverse endors.
	 *
	 * @param zipCode the zip code of this quotation driverse endors
	 */
	public void setZipCode(String zipCode);

	/**
	 * Returns the add no of this quotation driverse endors.
	 *
	 * @return the add no of this quotation driverse endors
	 */
	@AutoEscape
	public String getAddNo();

	/**
	 * Sets the add no of this quotation driverse endors.
	 *
	 * @param addNo the add no of this quotation driverse endors
	 */
	public void setAddNo(String addNo);

	/**
	 * Returns the st name en of this quotation driverse endors.
	 *
	 * @return the st name en of this quotation driverse endors
	 */
	@AutoEscape
	public String getStNameEn();

	/**
	 * Sets the st name en of this quotation driverse endors.
	 *
	 * @param stNameEn the st name en of this quotation driverse endors
	 */
	public void setStNameEn(String stNameEn);

	/**
	 * Returns the st name ar of this quotation driverse endors.
	 *
	 * @return the st name ar of this quotation driverse endors
	 */
	@AutoEscape
	public String getStNameAr();

	/**
	 * Sets the st name ar of this quotation driverse endors.
	 *
	 * @param stNameAr the st name ar of this quotation driverse endors
	 */
	public void setStNameAr(String stNameAr);

	/**
	 * Returns the district en of this quotation driverse endors.
	 *
	 * @return the district en of this quotation driverse endors
	 */
	@AutoEscape
	public String getDistrictEn();

	/**
	 * Sets the district en of this quotation driverse endors.
	 *
	 * @param districtEn the district en of this quotation driverse endors
	 */
	public void setDistrictEn(String districtEn);

	/**
	 * Returns the district ar of this quotation driverse endors.
	 *
	 * @return the district ar of this quotation driverse endors
	 */
	@AutoEscape
	public String getDistrictAr();

	/**
	 * Sets the district ar of this quotation driverse endors.
	 *
	 * @param districtAr the district ar of this quotation driverse endors
	 */
	public void setDistrictAr(String districtAr);

	/**
	 * Returns the city en of this quotation driverse endors.
	 *
	 * @return the city en of this quotation driverse endors
	 */
	@AutoEscape
	public String getCityEn();

	/**
	 * Sets the city en of this quotation driverse endors.
	 *
	 * @param cityEn the city en of this quotation driverse endors
	 */
	public void setCityEn(String cityEn);

	/**
	 * Returns the city ar of this quotation driverse endors.
	 *
	 * @return the city ar of this quotation driverse endors
	 */
	@AutoEscape
	public String getCityAr();

	/**
	 * Sets the city ar of this quotation driverse endors.
	 *
	 * @param cityAr the city ar of this quotation driverse endors
	 */
	public void setCityAr(String cityAr);

	/**
	 * Returns the is nat address of this quotation driverse endors.
	 *
	 * @return the is nat address of this quotation driverse endors
	 */
	public boolean getIsNatAddress();

	/**
	 * Returns <code>true</code> if this quotation driverse endors is is nat address.
	 *
	 * @return <code>true</code> if this quotation driverse endors is is nat address; <code>false</code> otherwise
	 */
	public boolean isIsNatAddress();

	/**
	 * Sets whether this quotation driverse endors is is nat address.
	 *
	 * @param isNatAddress the is nat address of this quotation driverse endors
	 */
	public void setIsNatAddress(boolean isNatAddress);

}