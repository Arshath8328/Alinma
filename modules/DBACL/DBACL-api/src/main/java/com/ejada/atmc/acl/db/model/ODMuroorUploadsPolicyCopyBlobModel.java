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
 * The Blob model class for lazy loading the policyCopy column in ODMuroorUploads.
 *
 * @author Brian Wing Shun Chan
 * @see ODMuroorUploads
 * @generated
 */
public class ODMuroorUploadsPolicyCopyBlobModel {

	public ODMuroorUploadsPolicyCopyBlobModel() {
	}

	public ODMuroorUploadsPolicyCopyBlobModel(int id) {
		_id = id;
	}

	public ODMuroorUploadsPolicyCopyBlobModel(int id, Blob policyCopyBlob) {
		_id = id;
		_policyCopyBlob = policyCopyBlob;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Blob getPolicyCopyBlob() {
		return _policyCopyBlob;
	}

	public void setPolicyCopyBlob(Blob policyCopyBlob) {
		_policyCopyBlob = policyCopyBlob;
	}

	private int _id;
	private Blob _policyCopyBlob;

}