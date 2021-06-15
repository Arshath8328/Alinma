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

import com.ejada.atmc.acl.db.model.WorkshopVehicle;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing WorkshopVehicle in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class WorkshopVehicleCacheModel
	implements CacheModel<WorkshopVehicle>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof WorkshopVehicleCacheModel)) {
			return false;
		}

		WorkshopVehicleCacheModel workshopVehicleCacheModel =
			(WorkshopVehicleCacheModel)object;

		if (id == workshopVehicleCacheModel.id) {
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
		StringBundler sb = new StringBundler(33);

		sb.append("{id=");
		sb.append(id);
		sb.append(", customerName=");
		sb.append(customerName);
		sb.append(", manufacture=");
		sb.append(manufacture);
		sb.append(", plateNo=");
		sb.append(plateNo);
		sb.append(", workshopId=");
		sb.append(workshopId);
		sb.append(", claimRefNo=");
		sb.append(claimRefNo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", date=");
		sb.append(date);
		sb.append(", serviceType=");
		sb.append(serviceType);
		sb.append(", description=");
		sb.append(description);
		sb.append(", customerMobile=");
		sb.append(customerMobile);
		sb.append(", vehMakeEn=");
		sb.append(vehMakeEn);
		sb.append(", vehMakeAr=");
		sb.append(vehMakeAr);
		sb.append(", vehModelEn=");
		sb.append(vehModelEn);
		sb.append(", vehModelAr=");
		sb.append(vehModelAr);
		sb.append(", customerIqamaId=");
		sb.append(customerIqamaId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public WorkshopVehicle toEntityModel() {
		WorkshopVehicleImpl workshopVehicleImpl = new WorkshopVehicleImpl();

		workshopVehicleImpl.setId(id);

		if (customerName == null) {
			workshopVehicleImpl.setCustomerName("");
		}
		else {
			workshopVehicleImpl.setCustomerName(customerName);
		}

		if (manufacture == null) {
			workshopVehicleImpl.setManufacture("");
		}
		else {
			workshopVehicleImpl.setManufacture(manufacture);
		}

		if (plateNo == null) {
			workshopVehicleImpl.setPlateNo("");
		}
		else {
			workshopVehicleImpl.setPlateNo(plateNo);
		}

		workshopVehicleImpl.setWorkshopId(workshopId);

		if (claimRefNo == null) {
			workshopVehicleImpl.setClaimRefNo("");
		}
		else {
			workshopVehicleImpl.setClaimRefNo(claimRefNo);
		}

		if (status == null) {
			workshopVehicleImpl.setStatus("");
		}
		else {
			workshopVehicleImpl.setStatus(status);
		}

		if (date == Long.MIN_VALUE) {
			workshopVehicleImpl.setDate(null);
		}
		else {
			workshopVehicleImpl.setDate(new Date(date));
		}

		if (serviceType == null) {
			workshopVehicleImpl.setServiceType("");
		}
		else {
			workshopVehicleImpl.setServiceType(serviceType);
		}

		if (description == null) {
			workshopVehicleImpl.setDescription("");
		}
		else {
			workshopVehicleImpl.setDescription(description);
		}

		if (customerMobile == null) {
			workshopVehicleImpl.setCustomerMobile("");
		}
		else {
			workshopVehicleImpl.setCustomerMobile(customerMobile);
		}

		if (vehMakeEn == null) {
			workshopVehicleImpl.setVehMakeEn("");
		}
		else {
			workshopVehicleImpl.setVehMakeEn(vehMakeEn);
		}

		if (vehMakeAr == null) {
			workshopVehicleImpl.setVehMakeAr("");
		}
		else {
			workshopVehicleImpl.setVehMakeAr(vehMakeAr);
		}

		if (vehModelEn == null) {
			workshopVehicleImpl.setVehModelEn("");
		}
		else {
			workshopVehicleImpl.setVehModelEn(vehModelEn);
		}

		if (vehModelAr == null) {
			workshopVehicleImpl.setVehModelAr("");
		}
		else {
			workshopVehicleImpl.setVehModelAr(vehModelAr);
		}

		if (customerIqamaId == null) {
			workshopVehicleImpl.setCustomerIqamaId("");
		}
		else {
			workshopVehicleImpl.setCustomerIqamaId(customerIqamaId);
		}

		workshopVehicleImpl.resetOriginalValues();

		return workshopVehicleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readInt();
		customerName = objectInput.readUTF();
		manufacture = objectInput.readUTF();
		plateNo = objectInput.readUTF();

		workshopId = objectInput.readInt();
		claimRefNo = objectInput.readUTF();
		status = objectInput.readUTF();
		date = objectInput.readLong();
		serviceType = objectInput.readUTF();
		description = objectInput.readUTF();
		customerMobile = objectInput.readUTF();
		vehMakeEn = objectInput.readUTF();
		vehMakeAr = objectInput.readUTF();
		vehModelEn = objectInput.readUTF();
		vehModelAr = objectInput.readUTF();
		customerIqamaId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeInt(id);

		if (customerName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerName);
		}

		if (manufacture == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(manufacture);
		}

		if (plateNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(plateNo);
		}

		objectOutput.writeInt(workshopId);

		if (claimRefNo == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(claimRefNo);
		}

		if (status == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(date);

		if (serviceType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(serviceType);
		}

		if (description == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (customerMobile == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerMobile);
		}

		if (vehMakeEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehMakeEn);
		}

		if (vehMakeAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehMakeAr);
		}

		if (vehModelEn == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehModelEn);
		}

		if (vehModelAr == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(vehModelAr);
		}

		if (customerIqamaId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(customerIqamaId);
		}
	}

	public int id;
	public String customerName;
	public String manufacture;
	public String plateNo;
	public int workshopId;
	public String claimRefNo;
	public String status;
	public long date;
	public String serviceType;
	public String description;
	public String customerMobile;
	public String vehMakeEn;
	public String vehMakeAr;
	public String vehModelEn;
	public String vehModelAr;
	public String customerIqamaId;

}