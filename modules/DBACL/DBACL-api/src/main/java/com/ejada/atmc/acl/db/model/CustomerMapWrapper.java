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
 * This class is a wrapper for {@link CustomerMap}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustomerMap
 * @generated
 */
public class CustomerMapWrapper
	extends BaseModelWrapper<CustomerMap>
	implements CustomerMap, ModelWrapper<CustomerMap> {

	public CustomerMapWrapper(CustomerMap customerMap) {
		super(customerMap);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("civilId", getCivilId());
		attributes.put("effFromDate", getEffFromDate());
		attributes.put("crDare", getCrDare());
		attributes.put("crUid", getCrUid());
		attributes.put("updateDt", getUpdateDt());
		attributes.put("updUid", getUpdUid());
		attributes.put("name", getName());
		attributes.put("nameAr", getNameAr());
		attributes.put("custType", getCustType());
		attributes.put("custCatg", getCustCatg());
		attributes.put("custCatgDesc", getCustCatgDesc());
		attributes.put("dob", getDob());
		attributes.put("mobileNo", getMobileNo());
		attributes.put("premiaCode", getPremiaCode());
		attributes.put("medCode", getMedCode());
		attributes.put("ilasCode", getIlasCode());
		attributes.put("glasCode", getGlasCode());
		attributes.put("nationality", getNationality());
		attributes.put("nameShort", getNameShort());
		attributes.put("version", getVersion());
		attributes.put("vip", getVip());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("address", getAddress());
		attributes.put("email", getEmail());
		attributes.put("refCode", getRefCode());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String civilId = (String)attributes.get("civilId");

		if (civilId != null) {
			setCivilId(civilId);
		}

		Date effFromDate = (Date)attributes.get("effFromDate");

		if (effFromDate != null) {
			setEffFromDate(effFromDate);
		}

		Date crDare = (Date)attributes.get("crDare");

		if (crDare != null) {
			setCrDare(crDare);
		}

		String crUid = (String)attributes.get("crUid");

		if (crUid != null) {
			setCrUid(crUid);
		}

		String updateDt = (String)attributes.get("updateDt");

		if (updateDt != null) {
			setUpdateDt(updateDt);
		}

		String updUid = (String)attributes.get("updUid");

		if (updUid != null) {
			setUpdUid(updUid);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String nameAr = (String)attributes.get("nameAr");

		if (nameAr != null) {
			setNameAr(nameAr);
		}

		String custType = (String)attributes.get("custType");

		if (custType != null) {
			setCustType(custType);
		}

		String custCatg = (String)attributes.get("custCatg");

		if (custCatg != null) {
			setCustCatg(custCatg);
		}

		String custCatgDesc = (String)attributes.get("custCatgDesc");

		if (custCatgDesc != null) {
			setCustCatgDesc(custCatgDesc);
		}

		Date dob = (Date)attributes.get("dob");

		if (dob != null) {
			setDob(dob);
		}

		String mobileNo = (String)attributes.get("mobileNo");

		if (mobileNo != null) {
			setMobileNo(mobileNo);
		}

		String premiaCode = (String)attributes.get("premiaCode");

		if (premiaCode != null) {
			setPremiaCode(premiaCode);
		}

		String medCode = (String)attributes.get("medCode");

		if (medCode != null) {
			setMedCode(medCode);
		}

		String ilasCode = (String)attributes.get("ilasCode");

		if (ilasCode != null) {
			setIlasCode(ilasCode);
		}

		String glasCode = (String)attributes.get("glasCode");

		if (glasCode != null) {
			setGlasCode(glasCode);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String nameShort = (String)attributes.get("nameShort");

		if (nameShort != null) {
			setNameShort(nameShort);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}

		String vip = (String)attributes.get("vip");

		if (vip != null) {
			setVip(vip);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String address = (String)attributes.get("address");

		if (address != null) {
			setAddress(address);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		String refCode = (String)attributes.get("refCode");

		if (refCode != null) {
			setRefCode(refCode);
		}
	}

	/**
	 * Returns the address of this customer map.
	 *
	 * @return the address of this customer map
	 */
	@Override
	public String getAddress() {
		return model.getAddress();
	}

	/**
	 * Returns the civil ID of this customer map.
	 *
	 * @return the civil ID of this customer map
	 */
	@Override
	public String getCivilId() {
		return model.getCivilId();
	}

	/**
	 * Returns the cr dare of this customer map.
	 *
	 * @return the cr dare of this customer map
	 */
	@Override
	public Date getCrDare() {
		return model.getCrDare();
	}

	/**
	 * Returns the cr uid of this customer map.
	 *
	 * @return the cr uid of this customer map
	 */
	@Override
	public String getCrUid() {
		return model.getCrUid();
	}

	/**
	 * Returns the cust catg of this customer map.
	 *
	 * @return the cust catg of this customer map
	 */
	@Override
	public String getCustCatg() {
		return model.getCustCatg();
	}

	/**
	 * Returns the cust catg desc of this customer map.
	 *
	 * @return the cust catg desc of this customer map
	 */
	@Override
	public String getCustCatgDesc() {
		return model.getCustCatgDesc();
	}

	/**
	 * Returns the cust type of this customer map.
	 *
	 * @return the cust type of this customer map
	 */
	@Override
	public String getCustType() {
		return model.getCustType();
	}

	/**
	 * Returns the dob of this customer map.
	 *
	 * @return the dob of this customer map
	 */
	@Override
	public Date getDob() {
		return model.getDob();
	}

	/**
	 * Returns the eff from date of this customer map.
	 *
	 * @return the eff from date of this customer map
	 */
	@Override
	public Date getEffFromDate() {
		return model.getEffFromDate();
	}

	/**
	 * Returns the email of this customer map.
	 *
	 * @return the email of this customer map
	 */
	@Override
	public String getEmail() {
		return model.getEmail();
	}

	/**
	 * Returns the glas code of this customer map.
	 *
	 * @return the glas code of this customer map
	 */
	@Override
	public String getGlasCode() {
		return model.getGlasCode();
	}

	/**
	 * Returns the ilas code of this customer map.
	 *
	 * @return the ilas code of this customer map
	 */
	@Override
	public String getIlasCode() {
		return model.getIlasCode();
	}

	/**
	 * Returns the med code of this customer map.
	 *
	 * @return the med code of this customer map
	 */
	@Override
	public String getMedCode() {
		return model.getMedCode();
	}

	/**
	 * Returns the mobile no of this customer map.
	 *
	 * @return the mobile no of this customer map
	 */
	@Override
	public String getMobileNo() {
		return model.getMobileNo();
	}

	/**
	 * Returns the name of this customer map.
	 *
	 * @return the name of this customer map
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the name ar of this customer map.
	 *
	 * @return the name ar of this customer map
	 */
	@Override
	public String getNameAr() {
		return model.getNameAr();
	}

	/**
	 * Returns the name short of this customer map.
	 *
	 * @return the name short of this customer map
	 */
	@Override
	public String getNameShort() {
		return model.getNameShort();
	}

	/**
	 * Returns the nationality of this customer map.
	 *
	 * @return the nationality of this customer map
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the phone no of this customer map.
	 *
	 * @return the phone no of this customer map
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the premia code of this customer map.
	 *
	 * @return the premia code of this customer map
	 */
	@Override
	public String getPremiaCode() {
		return model.getPremiaCode();
	}

	/**
	 * Returns the primary key of this customer map.
	 *
	 * @return the primary key of this customer map
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the ref code of this customer map.
	 *
	 * @return the ref code of this customer map
	 */
	@Override
	public String getRefCode() {
		return model.getRefCode();
	}

	/**
	 * Returns the update dt of this customer map.
	 *
	 * @return the update dt of this customer map
	 */
	@Override
	public String getUpdateDt() {
		return model.getUpdateDt();
	}

	/**
	 * Returns the upd uid of this customer map.
	 *
	 * @return the upd uid of this customer map
	 */
	@Override
	public String getUpdUid() {
		return model.getUpdUid();
	}

	/**
	 * Returns the version of this customer map.
	 *
	 * @return the version of this customer map
	 */
	@Override
	public String getVersion() {
		return model.getVersion();
	}

	/**
	 * Returns the vip of this customer map.
	 *
	 * @return the vip of this customer map
	 */
	@Override
	public String getVip() {
		return model.getVip();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the address of this customer map.
	 *
	 * @param address the address of this customer map
	 */
	@Override
	public void setAddress(String address) {
		model.setAddress(address);
	}

	/**
	 * Sets the civil ID of this customer map.
	 *
	 * @param civilId the civil ID of this customer map
	 */
	@Override
	public void setCivilId(String civilId) {
		model.setCivilId(civilId);
	}

	/**
	 * Sets the cr dare of this customer map.
	 *
	 * @param crDare the cr dare of this customer map
	 */
	@Override
	public void setCrDare(Date crDare) {
		model.setCrDare(crDare);
	}

	/**
	 * Sets the cr uid of this customer map.
	 *
	 * @param crUid the cr uid of this customer map
	 */
	@Override
	public void setCrUid(String crUid) {
		model.setCrUid(crUid);
	}

	/**
	 * Sets the cust catg of this customer map.
	 *
	 * @param custCatg the cust catg of this customer map
	 */
	@Override
	public void setCustCatg(String custCatg) {
		model.setCustCatg(custCatg);
	}

	/**
	 * Sets the cust catg desc of this customer map.
	 *
	 * @param custCatgDesc the cust catg desc of this customer map
	 */
	@Override
	public void setCustCatgDesc(String custCatgDesc) {
		model.setCustCatgDesc(custCatgDesc);
	}

	/**
	 * Sets the cust type of this customer map.
	 *
	 * @param custType the cust type of this customer map
	 */
	@Override
	public void setCustType(String custType) {
		model.setCustType(custType);
	}

	/**
	 * Sets the dob of this customer map.
	 *
	 * @param dob the dob of this customer map
	 */
	@Override
	public void setDob(Date dob) {
		model.setDob(dob);
	}

	/**
	 * Sets the eff from date of this customer map.
	 *
	 * @param effFromDate the eff from date of this customer map
	 */
	@Override
	public void setEffFromDate(Date effFromDate) {
		model.setEffFromDate(effFromDate);
	}

	/**
	 * Sets the email of this customer map.
	 *
	 * @param email the email of this customer map
	 */
	@Override
	public void setEmail(String email) {
		model.setEmail(email);
	}

	/**
	 * Sets the glas code of this customer map.
	 *
	 * @param glasCode the glas code of this customer map
	 */
	@Override
	public void setGlasCode(String glasCode) {
		model.setGlasCode(glasCode);
	}

	/**
	 * Sets the ilas code of this customer map.
	 *
	 * @param ilasCode the ilas code of this customer map
	 */
	@Override
	public void setIlasCode(String ilasCode) {
		model.setIlasCode(ilasCode);
	}

	/**
	 * Sets the med code of this customer map.
	 *
	 * @param medCode the med code of this customer map
	 */
	@Override
	public void setMedCode(String medCode) {
		model.setMedCode(medCode);
	}

	/**
	 * Sets the mobile no of this customer map.
	 *
	 * @param mobileNo the mobile no of this customer map
	 */
	@Override
	public void setMobileNo(String mobileNo) {
		model.setMobileNo(mobileNo);
	}

	/**
	 * Sets the name of this customer map.
	 *
	 * @param name the name of this customer map
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the name ar of this customer map.
	 *
	 * @param nameAr the name ar of this customer map
	 */
	@Override
	public void setNameAr(String nameAr) {
		model.setNameAr(nameAr);
	}

	/**
	 * Sets the name short of this customer map.
	 *
	 * @param nameShort the name short of this customer map
	 */
	@Override
	public void setNameShort(String nameShort) {
		model.setNameShort(nameShort);
	}

	/**
	 * Sets the nationality of this customer map.
	 *
	 * @param nationality the nationality of this customer map
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the phone no of this customer map.
	 *
	 * @param phoneNo the phone no of this customer map
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the premia code of this customer map.
	 *
	 * @param premiaCode the premia code of this customer map
	 */
	@Override
	public void setPremiaCode(String premiaCode) {
		model.setPremiaCode(premiaCode);
	}

	/**
	 * Sets the primary key of this customer map.
	 *
	 * @param primaryKey the primary key of this customer map
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the ref code of this customer map.
	 *
	 * @param refCode the ref code of this customer map
	 */
	@Override
	public void setRefCode(String refCode) {
		model.setRefCode(refCode);
	}

	/**
	 * Sets the update dt of this customer map.
	 *
	 * @param updateDt the update dt of this customer map
	 */
	@Override
	public void setUpdateDt(String updateDt) {
		model.setUpdateDt(updateDt);
	}

	/**
	 * Sets the upd uid of this customer map.
	 *
	 * @param updUid the upd uid of this customer map
	 */
	@Override
	public void setUpdUid(String updUid) {
		model.setUpdUid(updUid);
	}

	/**
	 * Sets the version of this customer map.
	 *
	 * @param version the version of this customer map
	 */
	@Override
	public void setVersion(String version) {
		model.setVersion(version);
	}

	/**
	 * Sets the vip of this customer map.
	 *
	 * @param vip the vip of this customer map
	 */
	@Override
	public void setVip(String vip) {
		model.setVip(vip);
	}

	@Override
	protected CustomerMapWrapper wrap(CustomerMap customerMap) {
		return new CustomerMapWrapper(customerMap);
	}

}