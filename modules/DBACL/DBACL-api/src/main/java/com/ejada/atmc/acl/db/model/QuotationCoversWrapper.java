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
 * This class is a wrapper for {@link QuotationCovers}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationCovers
 * @generated
 */
public class QuotationCoversWrapper
	extends BaseModelWrapper<QuotationCovers>
	implements ModelWrapper<QuotationCovers>, QuotationCovers {

	public QuotationCoversWrapper(QuotationCovers quotationCovers) {
		super(quotationCovers);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("addCoverId", getAddCoverId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("coverCode", getCoverCode());
		attributes.put("sectionCode", getSectionCode());
		attributes.put("coverEffFromDate", getCoverEffFromDate());
		attributes.put("coverEffToDate", getCoverEffToDate());
		attributes.put("coverPrem", getCoverPrem());
		attributes.put("coverRate", getCoverRate());
		attributes.put("coverSi", getCoverSi());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long addCoverId = (Long)attributes.get("addCoverId");

		if (addCoverId != null) {
			setAddCoverId(addCoverId);
		}

		Long quotationId = (Long)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		String coverCode = (String)attributes.get("coverCode");

		if (coverCode != null) {
			setCoverCode(coverCode);
		}

		Long sectionCode = (Long)attributes.get("sectionCode");

		if (sectionCode != null) {
			setSectionCode(sectionCode);
		}

		Date coverEffFromDate = (Date)attributes.get("coverEffFromDate");

		if (coverEffFromDate != null) {
			setCoverEffFromDate(coverEffFromDate);
		}

		Date coverEffToDate = (Date)attributes.get("coverEffToDate");

		if (coverEffToDate != null) {
			setCoverEffToDate(coverEffToDate);
		}

		Long coverPrem = (Long)attributes.get("coverPrem");

		if (coverPrem != null) {
			setCoverPrem(coverPrem);
		}

		Long coverRate = (Long)attributes.get("coverRate");

		if (coverRate != null) {
			setCoverRate(coverRate);
		}

		Long coverSi = (Long)attributes.get("coverSi");

		if (coverSi != null) {
			setCoverSi(coverSi);
		}
	}

	/**
	 * Returns the add cover ID of this quotation covers.
	 *
	 * @return the add cover ID of this quotation covers
	 */
	@Override
	public long getAddCoverId() {
		return model.getAddCoverId();
	}

	/**
	 * Returns the cover code of this quotation covers.
	 *
	 * @return the cover code of this quotation covers
	 */
	@Override
	public String getCoverCode() {
		return model.getCoverCode();
	}

	@Override
	public String getCoverDescAr(long productCode) {
		return model.getCoverDescAr(productCode);
	}

	@Override
	public String getCoverDescEn(long productCode) {
		return model.getCoverDescEn(productCode);
	}

	/**
	 * Returns the cover eff from date of this quotation covers.
	 *
	 * @return the cover eff from date of this quotation covers
	 */
	@Override
	public Date getCoverEffFromDate() {
		return model.getCoverEffFromDate();
	}

	/**
	 * Returns the cover eff to date of this quotation covers.
	 *
	 * @return the cover eff to date of this quotation covers
	 */
	@Override
	public Date getCoverEffToDate() {
		return model.getCoverEffToDate();
	}

	@Override
	public String getCoverNameAr(long productCode) {
		return model.getCoverNameAr(productCode);
	}

	@Override
	public String getCoverNameEn(long productCode) {
		return model.getCoverNameEn(productCode);
	}

	/**
	 * Returns the cover prem of this quotation covers.
	 *
	 * @return the cover prem of this quotation covers
	 */
	@Override
	public long getCoverPrem() {
		return model.getCoverPrem();
	}

	/**
	 * Returns the cover rate of this quotation covers.
	 *
	 * @return the cover rate of this quotation covers
	 */
	@Override
	public long getCoverRate() {
		return model.getCoverRate();
	}

	/**
	 * Returns the cover si of this quotation covers.
	 *
	 * @return the cover si of this quotation covers
	 */
	@Override
	public long getCoverSi() {
		return model.getCoverSi();
	}

	/**
	 * Returns the primary key of this quotation covers.
	 *
	 * @return the primary key of this quotation covers
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
		getPrimaryKey() {

		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation covers.
	 *
	 * @return the quotation ID of this quotation covers
	 */
	@Override
	public long getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the section code of this quotation covers.
	 *
	 * @return the section code of this quotation covers
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
	 * Sets the add cover ID of this quotation covers.
	 *
	 * @param addCoverId the add cover ID of this quotation covers
	 */
	@Override
	public void setAddCoverId(long addCoverId) {
		model.setAddCoverId(addCoverId);
	}

	/**
	 * Sets the cover code of this quotation covers.
	 *
	 * @param coverCode the cover code of this quotation covers
	 */
	@Override
	public void setCoverCode(String coverCode) {
		model.setCoverCode(coverCode);
	}

	/**
	 * Sets the cover eff from date of this quotation covers.
	 *
	 * @param coverEffFromDate the cover eff from date of this quotation covers
	 */
	@Override
	public void setCoverEffFromDate(Date coverEffFromDate) {
		model.setCoverEffFromDate(coverEffFromDate);
	}

	/**
	 * Sets the cover eff to date of this quotation covers.
	 *
	 * @param coverEffToDate the cover eff to date of this quotation covers
	 */
	@Override
	public void setCoverEffToDate(Date coverEffToDate) {
		model.setCoverEffToDate(coverEffToDate);
	}

	/**
	 * Sets the cover prem of this quotation covers.
	 *
	 * @param coverPrem the cover prem of this quotation covers
	 */
	@Override
	public void setCoverPrem(long coverPrem) {
		model.setCoverPrem(coverPrem);
	}

	/**
	 * Sets the cover rate of this quotation covers.
	 *
	 * @param coverRate the cover rate of this quotation covers
	 */
	@Override
	public void setCoverRate(long coverRate) {
		model.setCoverRate(coverRate);
	}

	/**
	 * Sets the cover si of this quotation covers.
	 *
	 * @param coverSi the cover si of this quotation covers
	 */
	@Override
	public void setCoverSi(long coverSi) {
		model.setCoverSi(coverSi);
	}

	/**
	 * Sets the primary key of this quotation covers.
	 *
	 * @param primaryKey the primary key of this quotation covers
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
			primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation covers.
	 *
	 * @param quotationId the quotation ID of this quotation covers
	 */
	@Override
	public void setQuotationId(long quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the section code of this quotation covers.
	 *
	 * @param sectionCode the section code of this quotation covers
	 */
	@Override
	public void setSectionCode(long sectionCode) {
		model.setSectionCode(sectionCode);
	}

	@Override
	protected QuotationCoversWrapper wrap(QuotationCovers quotationCovers) {
		return new QuotationCoversWrapper(quotationCovers);
	}

}