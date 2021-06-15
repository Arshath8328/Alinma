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
 * The Blob model class for lazy loading the driverLicense column in MuroorTPUploads.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploads
 * @generated
 */
public class MuroorTPUploadsDriverLicenseBlobModel {

	public MuroorTPUploadsDriverLicenseBlobModel() {
	}

	public MuroorTPUploadsDriverLicenseBlobModel(int id) {
		_id = id;
	}

	public MuroorTPUploadsDriverLicenseBlobModel(
		int id, Blob driverLicenseBlob) {

		_id = id;
		_driverLicenseBlob = driverLicenseBlob;
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public Blob getDriverLicenseBlob() {
		return _driverLicenseBlob;
	}

	public void setDriverLicenseBlob(Blob driverLicenseBlob) {
		_driverLicenseBlob = driverLicenseBlob;
	}

	private int _id;
	private Blob _driverLicenseBlob;

}