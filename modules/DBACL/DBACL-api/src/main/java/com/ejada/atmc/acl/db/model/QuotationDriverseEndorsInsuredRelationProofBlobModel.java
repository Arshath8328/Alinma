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
 * The Blob model class for lazy loading the insuredRelationProof column in QuotationDriverseEndors.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndors
 * @generated
 */
public class QuotationDriverseEndorsInsuredRelationProofBlobModel {

	public QuotationDriverseEndorsInsuredRelationProofBlobModel() {
	}

	public QuotationDriverseEndorsInsuredRelationProofBlobModel(
		long addDriverId) {

		_addDriverId = addDriverId;
	}

	public QuotationDriverseEndorsInsuredRelationProofBlobModel(
		long addDriverId, Blob insuredRelationProofBlob) {

		_addDriverId = addDriverId;
		_insuredRelationProofBlob = insuredRelationProofBlob;
	}

	public long getAddDriverId() {
		return _addDriverId;
	}

	public void setAddDriverId(long addDriverId) {
		_addDriverId = addDriverId;
	}

	public Blob getInsuredRelationProofBlob() {
		return _insuredRelationProofBlob;
	}

	public void setInsuredRelationProofBlob(Blob insuredRelationProofBlob) {
		_insuredRelationProofBlob = insuredRelationProofBlob;
	}

	private long _addDriverId;
	private Blob _insuredRelationProofBlob;

}