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

import java.sql.Blob;

/**
 * The Blob model class for lazy loading the surveyVideoFile column in QuotationSurvey.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurvey
 * @generated
 */
public class QuotationSurveySurveyVideoFileBlobModel {

	public QuotationSurveySurveyVideoFileBlobModel() {
	}

	public QuotationSurveySurveyVideoFileBlobModel(long surveyId) {
		_surveyId = surveyId;
	}

	public QuotationSurveySurveyVideoFileBlobModel(
		long surveyId, Blob surveyVideoFileBlob) {

		_surveyId = surveyId;
		_surveyVideoFileBlob = surveyVideoFileBlob;
	}

	public long getSurveyId() {
		return _surveyId;
	}

	public void setSurveyId(long surveyId) {
		_surveyId = surveyId;
	}

	public Blob getSurveyVideoFileBlob() {
		return _surveyVideoFileBlob;
	}

	public void setSurveyVideoFileBlob(Blob surveyVideoFileBlob) {
		_surveyVideoFileBlob = surveyVideoFileBlob;
	}

	private long _surveyId;
	private Blob _surveyVideoFileBlob;

}