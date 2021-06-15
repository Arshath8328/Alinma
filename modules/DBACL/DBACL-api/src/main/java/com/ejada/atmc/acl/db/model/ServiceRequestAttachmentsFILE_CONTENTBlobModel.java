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
 * The Blob model class for lazy loading the FILE_CONTENT column in ServiceRequestAttachments.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestAttachments
 * @generated
 */
public class ServiceRequestAttachmentsFILE_CONTENTBlobModel {

	public ServiceRequestAttachmentsFILE_CONTENTBlobModel() {
	}

	public ServiceRequestAttachmentsFILE_CONTENTBlobModel(long FILE_ID) {
		_FILE_ID = FILE_ID;
	}

	public ServiceRequestAttachmentsFILE_CONTENTBlobModel(
		long FILE_ID, Blob FILE_CONTENTBlob) {

		_FILE_ID = FILE_ID;
		_FILE_CONTENTBlob = FILE_CONTENTBlob;
	}

	public long getFILE_ID() {
		return _FILE_ID;
	}

	public void setFILE_ID(long FILE_ID) {
		_FILE_ID = FILE_ID;
	}

	public Blob getFILE_CONTENTBlob() {
		return _FILE_CONTENTBlob;
	}

	public void setFILE_CONTENTBlob(Blob FILE_CONTENTBlob) {
		_FILE_CONTENTBlob = FILE_CONTENTBlob;
	}

	private long _FILE_ID;

	private Blob _FILE_CONTENTBlob;

}