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

import com.ejada.atmc.acl.db.model.CLMWORKFLOW;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing CLMWORKFLOW in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class CLMWORKFLOWCacheModel
	implements CacheModel<CLMWORKFLOW>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof CLMWORKFLOWCacheModel)) {
			return false;
		}

		CLMWORKFLOWCacheModel clmworkflowCacheModel =
			(CLMWORKFLOWCacheModel)object;

		if (id == clmworkflowCacheModel.id) {
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
		StringBundler sb = new StringBundler(11);

		sb.append("{id=");
		sb.append(id);
		sb.append(", role=");
		sb.append(role);
		sb.append(", initialStatus=");
		sb.append(initialStatus);
		sb.append(", action=");
		sb.append(action);
		sb.append(", newStatus=");
		sb.append(newStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CLMWORKFLOW toEntityModel() {
		CLMWORKFLOWImpl clmworkflowImpl = new CLMWORKFLOWImpl();

		clmworkflowImpl.setId(id);

		if (role == null) {
			clmworkflowImpl.setRole("");
		}
		else {
			clmworkflowImpl.setRole(role);
		}

		if (initialStatus == null) {
			clmworkflowImpl.setInitialStatus("");
		}
		else {
			clmworkflowImpl.setInitialStatus(initialStatus);
		}

		if (action == null) {
			clmworkflowImpl.setAction("");
		}
		else {
			clmworkflowImpl.setAction(action);
		}

		if (newStatus == null) {
			clmworkflowImpl.setNewStatus("");
		}
		else {
			clmworkflowImpl.setNewStatus(newStatus);
		}

		clmworkflowImpl.resetOriginalValues();

		return clmworkflowImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		role = objectInput.readUTF();
		initialStatus = objectInput.readUTF();
		action = objectInput.readUTF();
		newStatus = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (role == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(role);
		}

		if (initialStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(initialStatus);
		}

		if (action == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (newStatus == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(newStatus);
		}
	}

	public int id;
	public String role;
	public String initialStatus;
	public String action;
	public String newStatus;

}