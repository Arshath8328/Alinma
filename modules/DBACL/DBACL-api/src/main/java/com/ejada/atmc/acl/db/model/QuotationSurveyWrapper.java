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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link QuotationSurvey}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurvey
 * @generated
 */
public class QuotationSurveyWrapper
	extends BaseModelWrapper<QuotationSurvey>
	implements ModelWrapper<QuotationSurvey>, QuotationSurvey {

	public QuotationSurveyWrapper(QuotationSurvey quotationSurvey) {
		super(quotationSurvey);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("surveyId", getSurveyId());
		attributes.put("quotationId", getQuotationId());
		attributes.put("surveyVideoFile", getSurveyVideoFile());
		attributes.put("surveyVideoFileName", getSurveyVideoFileName());
		attributes.put("surveyDate", getSurveyDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long surveyId = (Long)attributes.get("surveyId");

		if (surveyId != null) {
			setSurveyId(surveyId);
		}

		String quotationId = (String)attributes.get("quotationId");

		if (quotationId != null) {
			setQuotationId(quotationId);
		}

		Blob surveyVideoFile = (Blob)attributes.get("surveyVideoFile");

		if (surveyVideoFile != null) {
			setSurveyVideoFile(surveyVideoFile);
		}

		String surveyVideoFileName = (String)attributes.get(
			"surveyVideoFileName");

		if (surveyVideoFileName != null) {
			setSurveyVideoFileName(surveyVideoFileName);
		}

		Date surveyDate = (Date)attributes.get("surveyDate");

		if (surveyDate != null) {
			setSurveyDate(surveyDate);
		}
	}

	/**
	 * Returns the primary key of this quotation survey.
	 *
	 * @return the primary key of this quotation survey
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quotation ID of this quotation survey.
	 *
	 * @return the quotation ID of this quotation survey
	 */
	@Override
	public String getQuotationId() {
		return model.getQuotationId();
	}

	/**
	 * Returns the survey date of this quotation survey.
	 *
	 * @return the survey date of this quotation survey
	 */
	@Override
	public Date getSurveyDate() {
		return model.getSurveyDate();
	}

	/**
	 * Returns the survey ID of this quotation survey.
	 *
	 * @return the survey ID of this quotation survey
	 */
	@Override
	public long getSurveyId() {
		return model.getSurveyId();
	}

	/**
	 * Returns the survey video file of this quotation survey.
	 *
	 * @return the survey video file of this quotation survey
	 */
	@Override
	public Blob getSurveyVideoFile() {
		return model.getSurveyVideoFile();
	}

	/**
	 * Returns the survey video file name of this quotation survey.
	 *
	 * @return the survey video file name of this quotation survey
	 */
	@Override
	public String getSurveyVideoFileName() {
		return model.getSurveyVideoFileName();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the primary key of this quotation survey.
	 *
	 * @param primaryKey the primary key of this quotation survey
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quotation ID of this quotation survey.
	 *
	 * @param quotationId the quotation ID of this quotation survey
	 */
	@Override
	public void setQuotationId(String quotationId) {
		model.setQuotationId(quotationId);
	}

	/**
	 * Sets the survey date of this quotation survey.
	 *
	 * @param surveyDate the survey date of this quotation survey
	 */
	@Override
	public void setSurveyDate(Date surveyDate) {
		model.setSurveyDate(surveyDate);
	}

	/**
	 * Sets the survey ID of this quotation survey.
	 *
	 * @param surveyId the survey ID of this quotation survey
	 */
	@Override
	public void setSurveyId(long surveyId) {
		model.setSurveyId(surveyId);
	}

	/**
	 * Sets the survey video file of this quotation survey.
	 *
	 * @param surveyVideoFile the survey video file of this quotation survey
	 */
	@Override
	public void setSurveyVideoFile(Blob surveyVideoFile) {
		model.setSurveyVideoFile(surveyVideoFile);
	}

	/**
	 * Sets the survey video file name of this quotation survey.
	 *
	 * @param surveyVideoFileName the survey video file name of this quotation survey
	 */
	@Override
	public void setSurveyVideoFileName(String surveyVideoFileName) {
		model.setSurveyVideoFileName(surveyVideoFileName);
	}

	@Override
	protected QuotationSurveyWrapper wrap(QuotationSurvey quotationSurvey) {
		return new QuotationSurveyWrapper(quotationSurvey);
	}

}