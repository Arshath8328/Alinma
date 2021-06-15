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

import com.ejada.atmc.acl.db.model.MuroorTPUploads;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing MuroorTPUploads in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class MuroorTPUploadsCacheModel
	implements CacheModel<MuroorTPUploads>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof MuroorTPUploadsCacheModel)) {
			return false;
		}

		MuroorTPUploadsCacheModel muroorTPUploadsCacheModel =
			(MuroorTPUploadsCacheModel)object;

		if (id == muroorTPUploadsCacheModel.id) {
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
		sb.append(", claimIntimationNo=");
		sb.append(claimIntimationNo);
		sb.append(", iqamaId=");
		sb.append(iqamaId);
		sb.append(", driverLicenseName=");
		sb.append(driverLicenseName);
		sb.append(", vehRegistName=");
		sb.append(vehRegistName);
		sb.append(", frontPhotoName=");
		sb.append(frontPhotoName);
		sb.append(", rearPhotoName=");
		sb.append(rearPhotoName);
		sb.append(", rightSidePhotoName=");
		sb.append(rightSidePhotoName);
		sb.append(", leftSidePhotoName=");
		sb.append(leftSidePhotoName);
		sb.append(", bankIbanName=");
		sb.append(bankIbanName);
		sb.append(", ownerIdName=");
		sb.append(ownerIdName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MuroorTPUploads toEntityModel() {
		MuroorTPUploadsImpl muroorTPUploadsImpl = new MuroorTPUploadsImpl();

		muroorTPUploadsImpl.setId(id);

		if (claimIntimationNo == null) {
			muroorTPUploadsImpl.setClaimIntimationNo("");
		}
		else {
			muroorTPUploadsImpl.setClaimIntimationNo(claimIntimationNo);
		}

		if (iqamaId == null) {
			muroorTPUploadsImpl.setIqamaId("");
		}
		else {
			muroorTPUploadsImpl.setIqamaId(iqamaId);
		}

		if (driverLicenseName == null) {
			muroorTPUploadsImpl.setDriverLicenseName("");
		}
		else {
			muroorTPUploadsImpl.setDriverLicenseName(driverLicenseName);
		}

		if (vehRegistName == null) {
			muroorTPUploadsImpl.setVehRegistName("");
		}
		else {
			muroorTPUploadsImpl.setVehRegistName(vehRegistName);
		}

		if (frontPhotoName == null) {
			muroorTPUploadsImpl.setFrontPhotoName("");
		}
		else {
			muroorTPUploadsImpl.setFrontPhotoName(frontPhotoName);
		}

		if (rearPhotoName == null) {
			muroorTPUploadsImpl.setRearPhotoName("");
		}
		else {
			muroorTPUploadsImpl.setRearPhotoName(rearPhotoName);
		}

		if (rightSidePhotoName == null) {
			muroorTPUploadsImpl.setRightSidePhotoName("");
		}
		else {
			muroorTPUploadsImpl.setRightSidePhotoName(rightSidePhotoName);
		}

		if (leftSidePhotoName == null) {
			muroorTPUploadsImpl.setLeftSidePhotoName("");
		}
		else {
			muroorTPUploadsImpl.setLeftSidePhotoName(leftSidePhotoName);
		}

		if (bankIbanName == null) {
			muroorTPUploadsImpl.setBankIbanName("");
		}
		else {
			muroorTPUploadsImpl.setBankIbanName(bankIbanName);
		}

		if (ownerIdName == null) {
			muroorTPUploadsImpl.setOwnerIdName("");
		}
		else {
			muroorTPUploadsImpl.setOwnerIdName(ownerIdName);
		}

		muroorTPUploadsImpl.resetOriginalValues();

		return muroorTPUploadsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		claimIntimationNo = objectInput.readUTF();
		iqamaId = objectInput.readUTF();
		driverLicenseName = objectInput.readUTF();
		vehRegistName = objectInput.readUTF();
		frontPhotoName = objectInput.readUTF();
		rearPhotoName = objectInput.readUTF();
		rightSidePhotoName = objectInput.readUTF();
		leftSidePhotoName = objectInput.readUTF();
		bankIbanName = objectInput.readUTF();
		ownerIdName = objectInput.readUTF();
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

		if (frontPhotoName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(frontPhotoName);
		}

		if (rearPhotoName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rearPhotoName);
		}

		if (rightSidePhotoName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(rightSidePhotoName);
		}

		if (leftSidePhotoName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(leftSidePhotoName);
		}

		if (bankIbanName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(bankIbanName);
		}

		if (ownerIdName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ownerIdName);
		}
	}

	public int id;
	public String claimIntimationNo;
	public String iqamaId;
	public String driverLicenseName;
	public String vehRegistName;
	public String frontPhotoName;
	public String rearPhotoName;
	public String rightSidePhotoName;
	public String leftSidePhotoName;
	public String bankIbanName;
	public String ownerIdName;

}