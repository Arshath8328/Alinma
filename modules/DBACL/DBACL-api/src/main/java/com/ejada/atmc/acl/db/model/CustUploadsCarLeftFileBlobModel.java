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
 * The Blob model class for lazy loading the carLeftFile column in CustUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsCarLeftFileBlobModel {

	public CustUploadsCarLeftFileBlobModel() {
	}

	public CustUploadsCarLeftFileBlobModel(long id) {
		_id = id;
	}

	public CustUploadsCarLeftFileBlobModel(long id, Blob carLeftFileBlob) {
		_id = id;
		_carLeftFileBlob = carLeftFileBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getCarLeftFileBlob() {
		return _carLeftFileBlob;
	}

	public void setCarLeftFileBlob(Blob carLeftFileBlob) {
		_carLeftFileBlob = carLeftFileBlob;
	}

	private long _id;
	private Blob _carLeftFileBlob;

}