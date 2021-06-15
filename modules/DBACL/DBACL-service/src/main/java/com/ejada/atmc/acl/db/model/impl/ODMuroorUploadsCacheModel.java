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

import com.ejada.atmc.acl.db.model.ODMuroorUploads;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ODMuroorUploads in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ODMuroorUploadsCacheModel
	implements CacheModel<ODMuroorUploads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ODMuroorUploadsCacheModel)) {
			return false;
		}

		ODMuroorUploadsCacheModel odMuroorUploadsCacheModel =
			(ODMuroorUploadsCacheModel)object;

		if (id == odMuroorUploadsCacheModel.id) {
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
		StringBundler sb = new StringBundler(13);

		sb.append("{id=");
		sb.append(id);
		sb.append(", claimIntimationNo=");
		sb.append(claimIntimationNo);
		sb.append(", iqamaId=");
		sb.append(iqamaId);
		sb.append(", driverLicenseName=");
		sb.append(driverLicenseName);
		sb.append(", vehRegistName=");
		sb.append(vehRegistName);
		sb.append(", policyCopyName=");
		sb.append(policyCopyName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ODMuroorUploads toEntityModel() {
		ODMuroorUploadsImpl odMuroorUploadsImpl = new ODMuroorUploadsImpl();

		odMuroorUploadsImpl.setId(id);

		if (claimIntimationNo == null) {
			odMuroorUploadsImpl.setClaimIntimationNo("");
		}
		else {
			odMuroorUploadsImpl.setClaimIntimationNo(claimIntimationNo);
		}

		if (iqamaId == null) {
			odMuroorUploadsImpl.setIqamaId("");
		}
		else {
			odMuroorUploadsImpl.setIqamaId(iqamaId);
		}

		if (driverLicenseName == null) {
			odMuroorUploadsImpl.setDriverLicenseName("");
		}
		else {
			odMuroorUploadsImpl.setDriverLicenseName(driverLicenseName);
		}

		if (vehRegistName == null) {
			odMuroorUploadsImpl.setVehRegistName("");
		}
		else {
			odMuroorUploadsImpl.setVehRegistName(vehRegistName);
		}

		if (policyCopyName == null) {
			odMuroorUploadsImpl.setPolicyCopyName("");
		}
		else {
			odMuroorUploadsImpl.setPolicyCopyName(policyCopyName);
		}

		odMuroorUploadsImpl.resetOriginalValues();

		return odMuroorUploadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		claimIntimationNo = objectInput.readUTF();
		iqamaId = objectInput.readUTF();
		driverLicenseName = objectInput.readUTF();
		vehRegistName = objectInput.readUTF();
		policyCopyName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (claimIntimationNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimIntimationNo);
		}

		if (iqamaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(iqamaId);
		}

		if (driverLicenseName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(driverLicenseName);
		}

		if (vehRegistName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehRegistName);
		}

		if (policyCopyName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(policyCopyName);
		}
	}

	public int id;
	public String claimIntimationNo;
	public String iqamaId;
	public String driverLicenseName;
	public String vehRegistName;
	public String policyCopyName;

}