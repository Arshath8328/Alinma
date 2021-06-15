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
 * The Blob model class for lazy loading the carRightFile column in CustUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsCarRightFileBlobModel {

	public CustUploadsCarRightFileBlobModel() {
	}

	public CustUploadsCarRightFileBlobModel(long id) {
		_id = id;
	}

	public CustUploadsCarRightFileBlobModel(long id, Blob carRightFileBlob) {
		_id = id;
		_carRightFileBlob = carRightFileBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getCarRightFileBlob() {
		return _carRightFileBlob;
	}

	public void setCarRightFileBlob(Blob carRightFileBlob) {
		_carRightFileBlob = carRightFileBlob;
	}

	private long _id;
	private Blob _carRightFileBlob;

}