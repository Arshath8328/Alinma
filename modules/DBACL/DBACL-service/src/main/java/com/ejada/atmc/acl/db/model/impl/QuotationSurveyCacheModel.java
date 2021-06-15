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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.QuotationSurvey;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing QuotationSurvey in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationSurveyCacheModel
	implements CacheModel<QuotationSurvey>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationSurveyCacheModel)) {
			return false;
		}

		QuotationSurveyCacheModel quotationSurveyCacheModel =
			(QuotationSurveyCacheModel)object;

		if (surveyId == quotationSurveyCacheModel.surveyId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, surveyId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{surveyId=");
		sb.append(surveyId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", surveyVideoFileName=");
		sb.append(surveyVideoFileName);
		sb.append(", surveyDate=");
		sb.append(surveyDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationSurvey toEntityModel() {
		QuotationSurveyImpl quotationSurveyImpl = new QuotationSurveyImpl();

		quotationSurveyImpl.setSurveyId(surveyId);

		if (quotationId == null) {
			quotationSurveyImpl.setQuotationId("");
		}
		else {
			quotationSurveyImpl.setQuotationId(quotationId);
		}

		if (surveyVideoFileName == null) {
			quotationSurveyImpl.setSurveyVideoFileName("");
		}
		else {
			quotationSurveyImpl.setSurveyVideoFileName(surveyVideoFileName);
		}

		if (surveyDate == Long.MIN_VALUE) {
			quotationSurveyImpl.setSurveyDate(null);
		}
		else {
			quotationSurveyImpl.setSurveyDate(new Date(surveyDate));
		}

		quotationSurveyImpl.resetOriginalValues();

		return quotationSurveyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		surveyId = objectInput.readLong();
		quotationId = objectInput.readUTF();
		surveyVideoFileName = objectInput.readUTF();
		surveyDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(surveyId);

		if (quotationId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quotationId);
		}

		if (surveyVideoFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(surveyVideoFileName);
		}

		objectOutput.writeLong(surveyDate);
	}

	public long surveyId;
	public String quotationId;
	public String surveyVideoFileName;
	public long surveyDate;

}