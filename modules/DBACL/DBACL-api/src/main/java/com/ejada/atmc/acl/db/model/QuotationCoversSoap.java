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

import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationCoversServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationCoversSoap implements Serializable {

	public static QuotationCoversSoap toSoapModel(QuotationCovers model) {
		QuotationCoversSoap soapModel = new QuotationCoversSoap();

		soapModel.setAddCoverId(model.getAddCoverId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setCoverCode(model.getCoverCode());
		soapModel.setSectionCode(model.getSectionCode());
		soapModel.setCoverEffFromDate(model.getCoverEffFromDate());
		soapModel.setCoverEffToDate(model.getCoverEffToDate());
		soapModel.setCoverPrem(model.getCoverPrem());
		soapModel.setCoverRate(model.getCoverRate());
		soapModel.setCoverSi(model.getCoverSi());

		return soapModel;
	}

	public static QuotationCoversSoap[] toSoapModels(QuotationCovers[] models) {
		QuotationCoversSoap[] soapModels =
			new QuotationCoversSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationCoversSoap[][] toSoapModels(
		QuotationCovers[][] models) {

		QuotationCoversSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationCoversSoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationCoversSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationCoversSoap[] toSoapModels(
		List<QuotationCovers> models) {

		List<QuotationCoversSoap> soapModels =
			new ArrayList<QuotationCoversSoap>(models.size());

		for (QuotationCovers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuotationCoversSoap[soapModels.size()]);
	}

	public QuotationCoversSoap() {
	}

	public QuotationCoversPK getPrimaryKey() {
		return new QuotationCoversPK(_addCoverId, _quotationId);
	}

	public void setPrimaryKey(QuotationCoversPK pk) {
		setAddCoverId(pk.addCoverId);
		setQuotationId(pk.quotationId);
	}

	public long getAddCoverId() {
		return _addCoverId;
	}

	public void setAddCoverId(long addCoverId) {
		_addCoverId = addCoverId;
	}

	public long getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(long quotationId) {
		_quotationId = quotationId;
	}

	public String getCoverCode() {
		return _coverCode;
	}

	public void setCoverCode(String coverCode) {
		_coverCode = coverCode;
	}

	public long getSectionCode() {
		return _sectionCode;
	}

	public void setSectionCode(long sectionCode) {
		_sectionCode = sectionCode;
	}

	public Date getCoverEffFromDate() {
		return _coverEffFromDate;
	}

	public void setCoverEffFromDate(Date coverEffFromDate) {
		_coverEffFromDate = coverEffFromDate;
	}

	public Date getCoverEffToDate() {
		return _coverEffToDate;
	}

	public void setCoverEffToDate(Date coverEffToDate) {
		_coverEffToDate = coverEffToDate;
	}

	public long getCoverPrem() {
		return _coverPrem;
	}

	public void setCoverPrem(long coverPrem) {
		_coverPrem = coverPrem;
	}

	public long getCoverRate() {
		return _coverRate;
	}

	public void setCoverRate(long coverRate) {
		_coverRate = coverRate;
	}

	public long getCoverSi() {
		return _coverSi;
	}

	public void setCoverSi(long coverSi) {
		_coverSi = coverSi;
	}

	private long _addCoverId;
	private long _quotationId;
	private String _coverCode;
	private long _sectionCode;
	private Date _coverEffFromDate;
	private Date _coverEffToDate;
	private long _coverPrem;
	private long _coverRate;
	private long _coverSi;

}