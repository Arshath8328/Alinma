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
 * This class is a wrapper for {@link PolicyPayment}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyPayment
 * @generated
 */
public class PolicyPaymentWrapper
	extends BaseModelWrapper<PolicyPayment>
	implements ModelWrapper<PolicyPayment>, PolicyPayment {

	public PolicyPaymentWrapper(PolicyPayment policyPayment) {
		super(policyPayment);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("policyNo", getPolicyNo());
		attributes.put("voucherNo", getVoucherNo());
		attributes.put("endtNo", getEndtNo());
		attributes.put("claimNo", getClaimNo());
		attributes.put("dueDate", getDueDate());
		attributes.put("docDate", getDocDate());
		attributes.put("amount", getAmount());
		attributes.put("reference", getReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String policyNo = (String)attributes.get("policyNo");

		if (policyNo != null) {
			setPolicyNo(policyNo);
		}

		String voucherNo = (String)attributes.get("voucherNo");

		if (voucherNo != null) {
			setVoucherNo(voucherNo);
		}

		String endtNo = (String)attributes.get("endtNo");

		if (endtNo != null) {
			setEndtNo(endtNo);
		}

		String claimNo = (String)attributes.get("claimNo");

		if (claimNo != null) {
			setClaimNo(claimNo);
		}

		Date dueDate = (Date)attributes.get("dueDate");

		if (dueDate != null) {
			setDueDate(dueDate);
		}

		Date docDate = (Date)attributes.get("docDate");

		if (docDate != null) {
			setDocDate(docDate);
		}

		Double amount = (Double)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		String reference = (String)attributes.get("reference");

		if (reference != null) {
			setReference(reference);
		}
	}

	/**
	 * Returns the amount of this policy payment.
	 *
	 * @return the amount of this policy payment
	 */
	@Override
	public double getAmount() {
		return model.getAmount();
	}

	/**
	 * Returns the claim no of this policy payment.
	 *
	 * @return the claim no of this policy payment
	 */
	@Override
	public String getClaimNo() {
		return model.getClaimNo();
	}

	/**
	 * Returns the doc date of this policy payment.
	 *
	 * @return the doc date of this policy payment
	 */
	@Override
	public Date getDocDate() {
		return model.getDocDate();
	}

	/**
	 * Returns the due date of this policy payment.
	 *
	 * @return the due date of this policy payment
	 */
	@Override
	public Date getDueDate() {
		return model.getDueDate();
	}

	/**
	 * Returns the endt no of this policy payment.
	 *
	 * @return the endt no of this policy payment
	 */
	@Override
	public String getEndtNo() {
		return model.getEndtNo();
	}

	/**
	 * Returns the policy no of this policy payment.
	 *
	 * @return the policy no of this policy payment
	 */
	@Override
	public String getPolicyNo() {
		return model.getPolicyNo();
	}

	/**
	 * Returns the primary key of this policy payment.
	 *
	 * @return the primary key of this policy payment
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the reference of this policy payment.
	 *
	 * @return the reference of this policy payment
	 */
	@Override
	public String getReference() {
		return model.getReference();
	}

	/**
	 * Returns the voucher no of this policy payment.
	 *
	 * @return the voucher no of this policy payment
	 */
	@Override
	public String getVoucherNo() {
		return model.getVoucherNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the amount of this policy payment.
	 *
	 * @param amount the amount of this policy payment
	 */
	@Override
	public void setAmount(double amount) {
		model.setAmount(amount);
	}

	/**
	 * Sets the claim no of this policy payment.
	 *
	 * @param claimNo the claim no of this policy payment
	 */
	@Override
	public void setClaimNo(String claimNo) {
		model.setClaimNo(claimNo);
	}

	/**
	 * Sets the doc date of this policy payment.
	 *
	 * @param docDate the doc date of this policy payment
	 */
	@Override
	public void setDocDate(Date docDate) {
		model.setDocDate(docDate);
	}

	/**
	 * Sets the due date of this policy payment.
	 *
	 * @param dueDate the due date of this policy payment
	 */
	@Override
	public void setDueDate(Date dueDate) {
		model.setDueDate(dueDate);
	}

	/**
	 * Sets the endt no of this policy payment.
	 *
	 * @param endtNo the endt no of this policy payment
	 */
	@Override
	public void setEndtNo(String endtNo) {
		model.setEndtNo(endtNo);
	}

	/**
	 * Sets the policy no of this policy payment.
	 *
	 * @param policyNo the policy no of this policy payment
	 */
	@Override
	public void setPolicyNo(String policyNo) {
		model.setPolicyNo(policyNo);
	}

	/**
	 * Sets the primary key of this policy payment.
	 *
	 * @param primaryKey the primary key of this policy payment
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the reference of this policy payment.
	 *
	 * @param reference the reference of this policy payment
	 */
	@Override
	public void setReference(String reference) {
		model.setReference(reference);
	}

	/**
	 * Sets the voucher no of this policy payment.
	 *
	 * @param voucherNo the voucher no of this policy payment
	 */
	@Override
	public void setVoucherNo(String voucherNo) {
		model.setVoucherNo(voucherNo);
	}

	@Override
	protected PolicyPaymentWrapper wrap(PolicyPayment policyPayment) {
		return new PolicyPaymentWrapper(policyPayment);
	}

}