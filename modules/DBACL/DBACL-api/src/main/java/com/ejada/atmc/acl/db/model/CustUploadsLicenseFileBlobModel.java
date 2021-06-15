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
 * The Blob model class for lazy loading the licenseFile column in CustUploads.
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsLicenseFileBlobModel {

	public CustUploadsLicenseFileBlobModel() {
	}

	public CustUploadsLicenseFileBlobModel(long id) {
		_id = id;
	}

	public CustUploadsLicenseFileBlobModel(long id, Blob licenseFileBlob) {
		_id = id;
		_licenseFileBlob = licenseFileBlob;
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public Blob getLicenseFileBlob() {
		return _licenseFileBlob;
	}

	public void setLicenseFileBlob(Blob licenseFileBlob) {
		_licenseFileBlob = licenseFileBlob;
	}

	private long _id;
	private Blob _licenseFileBlob;

}