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
 * The Blob model class for lazy loading the idFile column in CustUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsIdFileBlobModel {

	public CustUploadsIdFileBlobModel() {
	}

	public CustUploadsIdFileBlobModel(long id) {
		_id = id;
	}

	public CustUploadsIdFileBlobModel(long id, Blob idFileBlob) {
		_id = id;
		_idFileBlob = idFileBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getIdFileBlob() {
		return _idFileBlob;
	}

	public void setIdFileBlob(Blob idFileBlob) {
		_idFileBlob = idFileBlob;
	}

	private long _id;
	private Blob _idFileBlob;

}