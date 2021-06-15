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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CLMNajmUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUploads
 * @generated
 */
public class CLMNajmUploadsWrapper
	extends BaseModelWrapper<CLMNajmUploads>
	implements CLMNajmUploads, ModelWrapper<CLMNajmUploads> {

	public CLMNajmUploadsWrapper(CLMNajmUploads clmNajmUploads) {
		super(clmNajmUploads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("caseNo", getCaseNo());
		attributes.put("cipiId", getCipiId());
		attributes.put("najmSlip", getNajmSlip());
		attributes.put("najmSlipName", getNajmSlipName());
		attributes.put("damageEstQuot", getDamageEstQuot());
		attributes.put("damageEstQuotName", getDamageEstQuotName());
		attributes.put("bankIban", getBankIban());
		attributes.put("bankIbanName", getBankIbanName());
		attributes.put("ownerId", getOwnerId());
		attributes.put("ownerIdName", getOwnerIdName());
		attributes.put("claimRefNo", getClaimRefNo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String caseNo = (String)attributes.get("caseNo");

		if (caseNo != null) {
			setCaseNo(caseNo);
		}

		String cipiId = (String)attributes.get("cipiId");

		if (cipiId != null) {
			setCipiId(cipiId);
		}

		Blob najmSlip = (Blob)attributes.get("najmSlip");

		if (najmSlip != null) {
			setNajmSlip(najmSlip);
		}

		String najmSlipName = (String)attributes.get("najmSlipName");

		if (najmSlipName != null) {
			setNajmSlipName(najmSlipName);
		}

		Blob damageEstQuot = (Blob)attributes.get("damageEstQuot");

		if (damageEstQuot != null) {
			setDamageEstQuot(damageEstQuot);
		}

		String damageEstQuotName = (String)attributes.get("damageEstQuotName");

		if (damageEstQuotName != null) {
			setDamageEstQuotName(damageEstQuotName);
		}

		Blob bankIban = (Blob)attributes.get("bankIban");

		if (bankIban != null) {
			setBankIban(bankIban);
		}

		String bankIbanName = (String)attributes.get("bankIbanName");

		if (bankIbanName != null) {
			setBankIbanName(bankIbanName);
		}

		Blob ownerId = (Blob)attributes.get("ownerId");

		if (ownerId != null) {
			setOwnerId(ownerId);
		}

		String ownerIdName = (String)attributes.get("ownerIdName");

		if (ownerIdName != null) {
			setOwnerIdName(ownerIdName);
		}

		String claimRefNo = (String)attributes.get("claimRefNo");

		if (claimRefNo != null) {
			setClaimRefNo(claimRefNo);
		}
	}

	/**
	 * Returns the bank iban of this clm najm uploads.
	 *
	 * @return the bank iban of this clm najm uploads
	 */
	@Override
	public Blob getBankIban() {
		return model.getBankIban();
	}

	/**
	 * Returns the bank iban name of this clm najm uploads.
	 *
	 * @return the bank iban name of this clm najm uploads
	 */
	@Override
	public String getBankIbanName() {
		return model.getBankIbanName();
	}

	/**
	 * Returns the case no of this clm najm uploads.
	 *
	 * @return the case no of this clm najm uploads
	 */
	@Override
	public String getCaseNo() {
		return model.getCaseNo();
	}

	/**
	 * Returns the cipi ID of this clm najm uploads.
	 *
	 * @return the cipi ID of this clm najm uploads
	 */
	@Override
	public String getCipiId() {
		return model.getCipiId();
	}

	/**
	 * Returns the claim ref no of this clm najm uploads.
	 *
	 * @return the claim ref no of this clm najm uploads
	 */
	@Override
	public String getClaimRefNo() {
		return model.getClaimRefNo();
	}

	/**
	 * Returns the damage est quot of this clm najm uploads.
	 *
	 * @return the damage est quot of this clm najm uploads
	 */
	@Override
	public Blob getDamageEstQuot() {
		return model.getDamageEstQuot();
	}

	/**
	 * Returns the damage est quot name of this clm najm uploads.
	 *
	 * @return the damage est quot name of this clm najm uploads
	 */
	@Override
	public String getDamageEstQuotName() {
		return model.getDamageEstQuotName();
	}

	/**
	 * Returns the ID of this clm najm uploads.
	 *
	 * @return the ID of this clm najm uploads
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the najm slip of this clm najm uploads.
	 *
	 * @return the najm slip of this clm najm uploads
	 */
	@Override
	public Blob getNajmSlip() {
		return model.getNajmSlip();
	}

	/**
	 * Returns the najm slip name of this clm najm uploads.
	 *
	 * @return the najm slip name of this clm najm uploads
	 */
	@Override
	public String getNajmSlipName() {
		return model.getNajmSlipName();
	}

	/**
	 * Returns the owner ID of this clm najm uploads.
	 *
	 * @return the owner ID of this clm najm uploads
	 */
	@Override
	public Blob getOwnerId() {
		return model.getOwnerId();
	}

	/**
	 * Returns the owner ID name of this clm najm uploads.
	 *
	 * @return the owner ID name of this clm najm uploads
	 */
	@Override
	public String getOwnerIdName() {
		return model.getOwnerIdName();
	}

	/**
	 * Returns the primary key of this clm najm uploads.
	 *
	 * @return the primary key of this clm najm uploads
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the bank iban of this clm najm uploads.
	 *
	 * @param bankIban the bank iban of this clm najm uploads
	 */
	@Override
	public void setBankIban(Blob bankIban) {
		model.setBankIban(bankIban);
	}

	/**
	 * Sets the bank iban name of this clm najm uploads.
	 *
	 * @param bankIbanName the bank iban name of this clm najm uploads
	 */
	@Override
	public void setBankIbanName(String bankIbanName) {
		model.setBankIbanName(bankIbanName);
	}

	/**
	 * Sets the case no of this clm najm uploads.
	 *
	 * @param caseNo the case no of this clm najm uploads
	 */
	@Override
	public void setCaseNo(String caseNo) {
		model.setCaseNo(caseNo);
	}

	/**
	 * Sets the cipi ID of this clm najm uploads.
	 *
	 * @param cipiId the cipi ID of this clm najm uploads
	 */
	@Override
	public void setCipiId(String cipiId) {
		model.setCipiId(cipiId);
	}

	/**
	 * Sets the claim ref no of this clm najm uploads.
	 *
	 * @param claimRefNo the claim ref no of this clm najm uploads
	 */
	@Override
	public void setClaimRefNo(String claimRefNo) {
		model.setClaimRefNo(claimRefNo);
	}

	/**
	 * Sets the damage est quot of this clm najm uploads.
	 *
	 * @param damageEstQuot the damage est quot of this clm najm uploads
	 */
	@Override
	public void setDamageEstQuot(Blob damageEstQuot) {
		model.setDamageEstQuot(damageEstQuot);
	}

	/**
	 * Sets the damage est quot name of this clm najm uploads.
	 *
	 * @param damageEstQuotName the damage est quot name of this clm najm uploads
	 */
	@Override
	public void setDamageEstQuotName(String damageEstQuotName) {
		model.setDamageEstQuotName(damageEstQuotName);
	}

	/**
	 * Sets the ID of this clm najm uploads.
	 *
	 * @param id the ID of this clm najm uploads
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the najm slip of this clm najm uploads.
	 *
	 * @param najmSlip the najm slip of this clm najm uploads
	 */
	@Override
	public void setNajmSlip(Blob najmSlip) {
		model.setNajmSlip(najmSlip);
	}

	/**
	 * Sets the najm slip name of this clm najm uploads.
	 *
	 * @param najmSlipName the najm slip name of this clm najm uploads
	 */
	@Override
	public void setNajmSlipName(String najmSlipName) {
		model.setNajmSlipName(najmSlipName);
	}

	/**
	 * Sets the owner ID of this clm najm uploads.
	 *
	 * @param ownerId the owner ID of this clm najm uploads
	 */
	@Override
	public void setOwnerId(Blob ownerId) {
		model.setOwnerId(ownerId);
	}

	/**
	 * Sets the owner ID name of this clm najm uploads.
	 *
	 * @param ownerIdName the owner ID name of this clm najm uploads
	 */
	@Override
	public void setOwnerIdName(String ownerIdName) {
		model.setOwnerIdName(ownerIdName);
	}

	/**
	 * Sets the primary key of this clm najm uploads.
	 *
	 * @param primaryKey the primary key of this clm najm uploads
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	@Override
	protected CLMNajmUploadsWrapper wrap(CLMNajmUploads clmNajmUploads) {
		return new CLMNajmUploadsWrapper(clmNajmUploads);
	}

}