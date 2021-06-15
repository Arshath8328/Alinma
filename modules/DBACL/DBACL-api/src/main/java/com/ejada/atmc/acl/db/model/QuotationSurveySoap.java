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

import java.io.Serializable;

import java.sql.Blob;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.QuotationSurveyServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationSurveySoap implements Serializable {

	public static QuotationSurveySoap toSoapModel(QuotationSurvey model) {
		QuotationSurveySoap soapModel = new QuotationSurveySoap();

		soapModel.setSurveyId(model.getSurveyId());
		soapModel.setQuotationId(model.getQuotationId());
		soapModel.setSurveyVideoFile(model.getSurveyVideoFile());
		soapModel.setSurveyVideoFileName(model.getSurveyVideoFileName());
		soapModel.setSurveyDate(model.getSurveyDate());

		return soapModel;
	}

	public static QuotationSurveySoap[] toSoapModels(QuotationSurvey[] models) {
		QuotationSurveySoap[] soapModels =
			new QuotationSurveySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static QuotationSurveySoap[][] toSoapModels(
		QuotationSurvey[][] models) {

		QuotationSurveySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new QuotationSurveySoap[models.length][models[0].length];
		}
		else {
			soapModels = new QuotationSurveySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static QuotationSurveySoap[] toSoapModels(
		List<QuotationSurvey> models) {

		List<QuotationSurveySoap> soapModels =
			new ArrayList<QuotationSurveySoap>(models.size());

		for (QuotationSurvey model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new QuotationSurveySoap[soapModels.size()]);
	}

	public QuotationSurveySoap() {
	}

	public long getPrimaryKey() {
		return _surveyId;
	}

	public void setPrimaryKey(long pk) {
		setSurveyId(pk);
	}

	public long getSurveyId() {
		return _surveyId;
	}

	public void setSurveyId(long surveyId) {
		_surveyId = surveyId;
	}

	public String getQuotationId() {
		return _quotationId;
	}

	public void setQuotationId(String quotationId) {
		_quotationId = quotationId;
	}

	public Blob getSurveyVideoFile() {
		return _surveyVideoFile;
	}

	public void setSurveyVideoFile(Blob surveyVideoFile) {
		_surveyVideoFile = surveyVideoFile;
	}

	public String getSurveyVideoFileName() {
		return _surveyVideoFileName;
	}

	public void setSurveyVideoFileName(String surveyVideoFileName) {
		_surveyVideoFileName = surveyVideoFileName;
	}

	public Date getSurveyDate() {
		return _surveyDate;
	}

	public void setSurveyDate(Date surveyDate) {
		_surveyDate = surveyDate;
	}

	private long _surveyId;
	private String _quotationId;
	private Blob _surveyVideoFile;
	private String _surveyVideoFileName;
	private Date _surveyDate;

}