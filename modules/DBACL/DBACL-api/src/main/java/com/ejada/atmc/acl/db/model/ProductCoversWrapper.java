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
 * This class is a wrapper for {@link ProductCovers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCovers
 * @generated
 */
public class ProductCoversWrapper
	extends BaseModelWrapper<ProductCovers>
	implements ModelWrapper<ProductCovers>, ProductCovers {

	public ProductCoversWrapper(ProductCovers productCovers) {
		super(productCovers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("productCode", getProductCode());
		attributes.put("sectionCode", getSectionCode());
		attributes.put("coverCode", getCoverCode());
		attributes.put("coverName", getCoverName());
		attributes.put("coverNameAr", getCoverNameAr());
		attributes.put("coverDesc", getCoverDesc());
		attributes.put("coverDescAr", getCoverDescAr());
		attributes.put("coverPremium", getCoverPremium());
		attributes.put("coverFld1", getCoverFld1());
		attributes.put("coverFld2", getCoverFld2());
		attributes.put("coverFld3", getCoverFld3());
		attributes.put("coverFld4", getCoverFld4());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long productCode = (Long)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		Long sectionCode = (Long)attributes.get("sectionCode");

		if (sectionCode != null) {
			setSectionCode(sectionCode);
		}

		String coverCode = (String)attributes.get("coverCode");

		if (coverCode != null) {
			setCoverCode(coverCode);
		}

		String coverName = (String)attributes.get("coverName");

		if (coverName != null) {
			setCoverName(coverName);
		}

		String coverNameAr = (String)attributes.get("coverNameAr");

		if (coverNameAr != null) {
			setCoverNameAr(coverNameAr);
		}

		String coverDesc = (String)attributes.get("coverDesc");

		if (coverDesc != null) {
			setCoverDesc(coverDesc);
		}

		String coverDescAr = (String)attributes.get("coverDescAr");

		if (coverDescAr != null) {
			setCoverDescAr(coverDescAr);
		}

		String coverPremium = (String)attributes.get("coverPremium");

		if (coverPremium != null) {
			setCoverPremium(coverPremium);
		}

		String coverFld1 = (String)attributes.get("coverFld1");

		if (coverFld1 != null) {
			setCoverFld1(coverFld1);
		}

		String coverFld2 = (String)attributes.get("coverFld2");

		if (coverFld2 != null) {
			setCoverFld2(coverFld2);
		}

		String coverFld3 = (String)attributes.get("coverFld3");

		if (coverFld3 != null) {
			setCoverFld3(coverFld3);
		}

		String coverFld4 = (String)attributes.get("coverFld4");

		if (coverFld4 != null) {
			setCoverFld4(coverFld4);
		}
	}

	/**
	 * Returns the cover code of this product covers.
	 *
	 * @return the cover code of this product covers
	 */
	@Override
	public String getCoverCode() {
		return model.getCoverCode();
	}

	/**
	 * Returns the cover desc of this product covers.
	 *
	 * @return the cover desc of this product covers
	 */
	@Override
	public String getCoverDesc() {
		return model.getCoverDesc();
	}

	/**
	 * Returns the cover desc ar of this product covers.
	 *
	 * @return the cover desc ar of this product covers
	 */
	@Override
	public String getCoverDescAr() {
		return model.getCoverDescAr();
	}

	/**
	 * Returns the cover fld1 of this product covers.
	 *
	 * @return the cover fld1 of this product covers
	 */
	@Override
	public String getCoverFld1() {
		return model.getCoverFld1();
	}

	/**
	 * Returns the cover fld2 of this product covers.
	 *
	 * @return the cover fld2 of this product covers
	 */
	@Override
	public String getCoverFld2() {
		return model.getCoverFld2();
	}

	/**
	 * Returns the cover fld3 of this product covers.
	 *
	 * @return the cover fld3 of this product covers
	 */
	@Override
	public String getCoverFld3() {
		return model.getCoverFld3();
	}

	/**
	 * Returns the cover fld4 of this product covers.
	 *
	 * @return the cover fld4 of this product covers
	 */
	@Override
	public String getCoverFld4() {
		return model.getCoverFld4();
	}

	/**
	 * Returns the cover name of this product covers.
	 *
	 * @return the cover name of this product covers
	 */
	@Override
	public String getCoverName() {
		return model.getCoverName();
	}

	/**
	 * Returns the cover name ar of this product covers.
	 *
	 * @return the cover name ar of this product covers
	 */
	@Override
	public String getCoverNameAr() {
		return model.getCoverNameAr();
	}

	/**
	 * Returns the cover premium of this product covers.
	 *
	 * @return the cover premium of this product covers
	 */
	@Override
	public String getCoverPremium() {
		return model.getCoverPremium();
	}

	/**
	 * Returns the primary key of this product covers.
	 *
	 * @return the primary key of this product covers
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.ProductCoversPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the product code of this product covers.
	 *
	 * @return the product code of this product covers
	 */
	@Override
	public long getProductCode() {
		return model.getProductCode();
	}

	/**
	 * Returns the section code of this product covers.
	 *
	 * @return the section code of this product covers
	 */
	@Override
	public long getSectionCode() {
		return model.getSectionCode();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the cover code of this product covers.
	 *
	 * @param coverCode the cover code of this product covers
	 */
	@Override
	public void setCoverCode(String coverCode) {
		model.setCoverCode(coverCode);
	}

	/**
	 * Sets the cover desc of this product covers.
	 *
	 * @param coverDesc the cover desc of this product covers
	 */
	@Override
	public void setCoverDesc(String coverDesc) {
		model.setCoverDesc(coverDesc);
	}

	/**
	 * Sets the cover desc ar of this product covers.
	 *
	 * @param coverDescAr the cover desc ar of this product covers
	 */
	@Override
	public void setCoverDescAr(String coverDescAr) {
		model.setCoverDescAr(coverDescAr);
	}

	/**
	 * Sets the cover fld1 of this product covers.
	 *
	 * @param coverFld1 the cover fld1 of this product covers
	 */
	@Override
	public void setCoverFld1(String coverFld1) {
		model.setCoverFld1(coverFld1);
	}

	/**
	 * Sets the cover fld2 of this product covers.
	 *
	 * @param coverFld2 the cover fld2 of this product covers
	 */
	@Override
	public void setCoverFld2(String coverFld2) {
		model.setCoverFld2(coverFld2);
	}

	/**
	 * Sets the cover fld3 of this product covers.
	 *
	 * @param coverFld3 the cover fld3 of this product covers
	 */
	@Override
	public void setCoverFld3(String coverFld3) {
		model.setCoverFld3(coverFld3);
	}

	/**
	 * Sets the cover fld4 of this product covers.
	 *
	 * @param coverFld4 the cover fld4 of this product covers
	 */
	@Override
	public void setCoverFld4(String coverFld4) {
		model.setCoverFld4(coverFld4);
	}

	/**
	 * Sets the cover name of this product covers.
	 *
	 * @param coverName the cover name of this product covers
	 */
	@Override
	public void setCoverName(String coverName) {
		model.setCoverName(coverName);
	}

	/**
	 * Sets the cover name ar of this product covers.
	 *
	 * @param coverNameAr the cover name ar of this product covers
	 */
	@Override
	public void setCoverNameAr(String coverNameAr) {
		model.setCoverNameAr(coverNameAr);
	}

	/**
	 * Sets the cover premium of this product covers.
	 *
	 * @param coverPremium the cover premium of this product covers
	 */
	@Override
	public void setCoverPremium(String coverPremium) {
		model.setCoverPremium(coverPremium);
	}

	/**
	 * Sets the primary key of this product covers.
	 *
	 * @param primaryKey the primary key of this product covers
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.ProductCoversPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product code of this product covers.
	 *
	 * @param productCode the product code of this product covers
	 */
	@Override
	public void setProductCode(long productCode) {
		model.setProductCode(productCode);
	}

	/**
	 * Sets the section code of this product covers.
	 *
	 * @param sectionCode the section code of this product covers
	 */
	@Override
	public void setSectionCode(long sectionCode) {
		model.setSectionCode(sectionCode);
	}

	@Override
	protected ProductCoversWrapper wrap(ProductCovers productCovers) {
		return new ProductCoversWrapper(productCovers);
	}

}