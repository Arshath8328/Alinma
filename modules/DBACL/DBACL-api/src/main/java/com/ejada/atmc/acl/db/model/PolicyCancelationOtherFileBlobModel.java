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
 * The Blob model class for lazy loading the otherFile column in PolicyCancelation.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelation
 * @generated
 */
public class PolicyCancelationOtherFileBlobModel {

	public PolicyCancelationOtherFileBlobModel() {
	}

	public PolicyCancelationOtherFileBlobModel(String Id) {
		_Id = Id;
	}

	public PolicyCancelationOtherFileBlobModel(String Id, Blob otherFileBlob) {
		_Id = Id;
		_otherFileBlob = otherFileBlob;
	}

	public String getId() {
		return _Id;
	}

	public void setId(String Id) {
		_Id = Id;
	}

	public Blob getOtherFileBlob() {
		return _otherFileBlob;
	}

	public void setOtherFileBlob(Blob otherFileBlob) {
		_otherFileBlob = otherFileBlob;
	}

	private String _Id;
	private Blob _otherFileBlob;

}