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
 * This class is a wrapper for {@link ProductDetails}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductDetails
 * @generated
 */
public class ProductDetailsWrapper
	extends BaseModelWrapper<ProductDetails>
	implements ModelWrapper<ProductDetails>, ProductDetails {

	public ProductDetailsWrapper(ProductDetails productDetails) {
		super(productDetails);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("sysId", getSysId());
		attributes.put("lobSysId", getLobSysId());
		attributes.put("effFmDate", getEffFmDate());
		attributes.put("effToDate", getEffToDate());
		attributes.put("crDate", getCrDate());
		attributes.put("crUid", getCrUid());
		attributes.put("updDate", getUpdDate());
		attributes.put("updUid", getUpdUid());
		attributes.put("productCode", getProductCode());
		attributes.put("productName", getProductName());
		attributes.put("productNameAr", getProductNameAr());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long sysId = (Long)attributes.get("sysId");

		if (sysId != null) {
			setSysId(sysId);
		}

		Double lobSysId = (Double)attributes.get("lobSysId");

		if (lobSysId != null) {
			setLobSysId(lobSysId);
		}

		Date effFmDate = (Date)attributes.get("effFmDate");

		if (effFmDate != null) {
			setEffFmDate(effFmDate);
		}

		Date effToDate = (Date)attributes.get("effToDate");

		if (effToDate != null) {
			setEffToDate(effToDate);
		}

		Date crDate = (Date)attributes.get("crDate");

		if (crDate != null) {
			setCrDate(crDate);
		}

		String crUid = (String)attributes.get("crUid");

		if (crUid != null) {
			setCrUid(crUid);
		}

		String updDate = (String)attributes.get("updDate");

		if (updDate != null) {
			setUpdDate(updDate);
		}

		String updUid = (String)attributes.get("updUid");

		if (updUid != null) {
			setUpdUid(updUid);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String productNameAr = (String)attributes.get("productNameAr");

		if (productNameAr != null) {
			setProductNameAr(productNameAr);
		}
	}

	/**
	 * Returns the cr date of this product details.
	 *
	 * @return the cr date of this product details
	 */
	@Override
	public Date getCrDate() {
		return model.getCrDate();
	}

	/**
	 * Returns the cr uid of this product details.
	 *
	 * @return the cr uid of this product details
	 */
	@Override
	public String getCrUid() {
		return model.getCrUid();
	}

	/**
	 * Returns the eff fm date of this product details.
	 *
	 * @return the eff fm date of this product details
	 */
	@Override
	public Date getEffFmDate() {
		return model.getEffFmDate();
	}

	/**
	 * Returns the eff to date of this product details.
	 *
	 * @return the eff to date of this product details
	 */
	@Override
	public Date getEffToDate() {
		return model.getEffToDate();
	}

	/**
	 * Returns the lob sys ID of this product details.
	 *
	 * @return the lob sys ID of this product details
	 */
	@Override
	public double getLobSysId() {
		return model.getLobSysId();
	}

	/**
	 * Returns the primary key of this product details.
	 *
	 * @return the primary key of this product details
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this product details.
	 *
	 * @return the product code of this product details
	 */
	@Override
	public String getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the product name of this product details.
	 *
	 * @return the product name of this product details
	 */
	@Override
	public String getProductName() {
		return model.getProductName();
	}

	/**
	 * Returns the product name ar of this product details.
	 *
	 * @return the product name ar of this product details
	 */
	@Override
	public String getProductNameAr() {
		return model.getProductNameAr();
	}

	/**
	 * Returns the sys ID of this product details.
	 *
	 * @return the sys ID of this product details
	 */
	@Override
	public long getSysId() {
		return model.getSysId();
	}

	/**
	 * Returns the upd date of this product details.
	 *
	 * @return the upd date of this product details
	 */
	@Override
	public String getUpdDate() {
		return model.getUpdDate();
	}

	/**
	 * Returns the upd uid of this product details.
	 *
	 * @return the upd uid of this product details
	 */
	@Override
	public String getUpdUid() {
		return model.getUpdUid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cr date of this product details.
	 *
	 * @param crDate the cr date of this product details
	 */
	@Override
	public void setCrDate(Date crDate) {
		model.setCrDate(crDate);
	}

	/**
	 * Sets the cr uid of this product details.
	 *
	 * @param crUid the cr uid of this product details
	 */
	@Override
	public void setCrUid(String crUid) {
		model.setCrUid(crUid);
	}

	/**
	 * Sets the eff fm date of this product details.
	 *
	 * @param effFmDate the eff fm date of this product details
	 */
	@Override
	public void setEffFmDate(Date effFmDate) {
		model.setEffFmDate(effFmDate);
	}

	/**
	 * Sets the eff to date of this product details.
	 *
	 * @param effToDate the eff to date of this product details
	 */
	@Override
	public void setEffToDate(Date effToDate) {
		model.setEffToDate(effToDate);
	}

	/**
	 * Sets the lob sys ID of this product details.
	 *
	 * @param lobSysId the lob sys ID of this product details
	 */
	@Override
	public void setLobSysId(double lobSysId) {
		model.setLobSysId(lobSysId);
	}

	/**
	 * Sets the primary key of this product details.
	 *
	 * @param primaryKey the primary key of this product details
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this product details.
	 *
	 * @param productCode the product code of this product details
	 */
	@Override
	public void setProductCode(String productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the product name of this product details.
	 *
	 * @param productName the product name of this product details
	 */
	@Override
	public void setProductName(String productName) {
		model.setProductName(productName);
	}

	/**
	 * Sets the product name ar of this product details.
	 *
	 * @param productNameAr the product name ar of this product details
	 */
	@Override
	public void setProductNameAr(String productNameAr) {
		model.setProductNameAr(productNameAr);
	}

	/**
	 * Sets the sys ID of this product details.
	 *
	 * @param sysId the sys ID of this product details
	 */
	@Override
	public void setSysId(long sysId) {
		model.setSysId(sysId);
	}

	/**
	 * Sets the upd date of this product details.
	 *
	 * @param updDate the upd date of this product details
	 */
	@Override
	public void setUpdDate(String updDate) {
		model.setUpdDate(updDate);
	}

	/**
	 * Sets the upd uid of this product details.
	 *
	 * @param updUid the upd uid of this product details
	 */
	@Override
	public void setUpdUid(String updUid) {
		model.setUpdUid(updUid);
	}

	@Override
	protected ProductDetailsWrapper wrap(ProductDetails productDetails) {
		return new ProductDetailsWrapper(productDetails);
	}

}