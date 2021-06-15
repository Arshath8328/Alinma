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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.CustUploads;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CustUploads in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CustUploadsCacheModel
	implements CacheModel<CustUploads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CustUploadsCacheModel)) {
			return false;
		}

		CustUploadsCacheModel custUploadsCacheModel =
			(CustUploadsCacheModel)object;

		if (id == custUploadsCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{id=");
		sb.append(id);
		sb.append(", quotId=");
		sb.append(quotId);
		sb.append(", idFileName=");
		sb.append(idFileName);
		sb.append(", licenseFileName=");
		sb.append(licenseFileName);
		sb.append(", istCardFileName=");
		sb.append(istCardFileName);
		sb.append(", carFrontFileName=");
		sb.append(carFrontFileName);
		sb.append(", carBackFileName=");
		sb.append(carBackFileName);
		sb.append(", carLeftFileName=");
		sb.append(carLeftFileName);
		sb.append(", carRightFileName=");
		sb.append(carRightFileName);
		sb.append(", engChassisNoFileName=");
		sb.append(engChassisNoFileName);
		sb.append(", leaseFileName=");
		sb.append(leaseFileName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CustUploads toEntityModel() {
		CustUploadsImpl custUploadsImpl = new CustUploadsImpl();

		custUploadsImpl.setId(id);

		if (quotId == null) {
			custUploadsImpl.setQuotId("");
		}
		else {
			custUploadsImpl.setQuotId(quotId);
		}

		if (idFileName == null) {
			custUploadsImpl.setIdFileName("");
		}
		else {
			custUploadsImpl.setIdFileName(idFileName);
		}

		if (licenseFileName == null) {
			custUploadsImpl.setLicenseFileName("");
		}
		else {
			custUploadsImpl.setLicenseFileName(licenseFileName);
		}

		if (istCardFileName == null) {
			custUploadsImpl.setIstCardFileName("");
		}
		else {
			custUploadsImpl.setIstCardFileName(istCardFileName);
		}

		if (carFrontFileName == null) {
			custUploadsImpl.setCarFrontFileName("");
		}
		else {
			custUploadsImpl.setCarFrontFileName(carFrontFileName);
		}

		if (carBackFileName == null) {
			custUploadsImpl.setCarBackFileName("");
		}
		else {
			custUploadsImpl.setCarBackFileName(carBackFileName);
		}

		if (carLeftFileName == null) {
			custUploadsImpl.setCarLeftFileName("");
		}
		else {
			custUploadsImpl.setCarLeftFileName(carLeftFileName);
		}

		if (carRightFileName == null) {
			custUploadsImpl.setCarRightFileName("");
		}
		else {
			custUploadsImpl.setCarRightFileName(carRightFileName);
		}

		if (engChassisNoFileName == null) {
			custUploadsImpl.setEngChassisNoFileName("");
		}
		else {
			custUploadsImpl.setEngChassisNoFileName(engChassisNoFileName);
		}

		if (leaseFileName == null) {
			custUploadsImpl.setLeaseFileName("");
		}
		else {
			custUploadsImpl.setLeaseFileName(leaseFileName);
		}

		custUploadsImpl.resetOriginalValues();

		return custUploadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();
		quotId = objectInput.readUTF();
		idFileName = objectInput.readUTF();
		licenseFileName = objectInput.readUTF();
		istCardFileName = objectInput.readUTF();
		carFrontFileName = objectInput.readUTF();
		carBackFileName = objectInput.readUTF();
		carLeftFileName = objectInput.readUTF();
		carRightFileName = objectInput.readUTF();
		engChassisNoFileName = objectInput.readUTF();
		leaseFileName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(id);

		if (quotId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(quotId);
		}

		if (idFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(idFileName);
		}

		if (licenseFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(licenseFileName);
		}

		if (istCardFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(istCardFileName);
		}

		if (carFrontFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carFrontFileName);
		}

		if (carBackFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carBackFileName);
		}

		if (carLeftFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carLeftFileName);
		}

		if (carRightFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(carRightFileName);
		}

		if (engChassisNoFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(engChassisNoFileName);
		}

		if (leaseFileName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leaseFileName);
		}
	}

	public long id;
	public String quotId;
	public String idFileName;
	public String licenseFileName;
	public String istCardFileName;
	public String carFrontFileName;
	public String carBackFileName;
	public String carLeftFileName;
	public String carRightFileName;
	public String engChassisNoFileName;
	public String leaseFileName;

}