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
 * The Blob model class for lazy loading the carFrontFile column in CustUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsCarFrontFileBlobModel {

	public CustUploadsCarFrontFileBlobModel() {
	}

	public CustUploadsCarFrontFileBlobModel(long id) {
		_id = id;
	}

	public CustUploadsCarFrontFileBlobModel(long id, Blob carFrontFileBlob) {
		_id = id;
		_carFrontFileBlob = carFrontFileBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getCarFrontFileBlob() {
		return _carFrontFileBlob;
	}

	public void setCarFrontFileBlob(Blob carFrontFileBlob) {
		_carFrontFileBlob = carFrontFileBlob;
	}

	private long _id;
	private Blob _carFrontFileBlob;

}