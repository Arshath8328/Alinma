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
 * The Blob model class for lazy loading the najmSlip column in CLMNajmUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUploads
 * @generated
 */
public class CLMNajmUploadsNajmSlipBlobModel {

	public CLMNajmUploadsNajmSlipBlobModel() {
	}

	public CLMNajmUploadsNajmSlipBlobModel(int id) {
		_id = id;
	}

	public CLMNajmUploadsNajmSlipBlobModel(int id, Blob najmSlipBlob) {
		_id = id;
		_najmSlipBlob = najmSlipBlob;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Blob getNajmSlipBlob() {
		return _najmSlipBlob;
	}

	public void setNajmSlipBlob(Blob najmSlipBlob) {
		_najmSlipBlob = najmSlipBlob;
	}

	private int _id;
	private Blob _najmSlipBlob;

}