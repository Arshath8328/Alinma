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

import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing AtmcYakeenMakeModel in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class AtmcYakeenMakeModelCacheModel
	implements CacheModel<AtmcYakeenMakeModel>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof AtmcYakeenMakeModelCacheModel)) {
			return false;
		}

		AtmcYakeenMakeModelCacheModel atmcYakeenMakeModelCacheModel =
			(AtmcYakeenMakeModelCacheModel)object;

		if (yakeenMakeId == atmcYakeenMakeModelCacheModel.yakeenMakeId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, yakeenMakeId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{yakeenMakeId=");
		sb.append(yakeenMakeId);
		sb.append(", yakeenMakeValue=");
		sb.append(yakeenMakeValue);
		sb.append(", yakeenMakeDesc=");
		sb.append(yakeenMakeDesc);
		sb.append(", yakeenMakeMap=");
		sb.append(yakeenMakeMap);
		sb.append(", yakeenModelId=");
		sb.append(yakeenModelId);
		sb.append(", yakeenModelArabic=");
		sb.append(yakeenModelArabic);
		sb.append(", yakeenModelEnglish=");
		sb.append(yakeenModelEnglish);
		sb.append(", yakeenNodelMap=");
		sb.append(yakeenNodelMap);
		sb.append(", yakeenModelValue=");
		sb.append(yakeenModelValue);
		sb.append(", atmcVehicleNationality=");
		sb.append(atmcVehicleNationality);
		sb.append(", atmcBodyType=");
		sb.append(atmcBodyType);
		sb.append(", atmcSeatingCapacity=");
		sb.append(atmcSeatingCapacity);
		sb.append(", mapMakeModelName=");
		sb.append(mapMakeModelName);
		sb.append(", eskaMakeId=");
		sb.append(eskaMakeId);
		sb.append(", eskaModelId=");
		sb.append(eskaModelId);
		sb.append(", mapMakeModelId=");
		sb.append(mapMakeModelId);
		sb.append(", eskaBodyTypeId=");
		sb.append(eskaBodyTypeId);
		sb.append(", eskaVehNationalityId=");
		sb.append(eskaVehNationalityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AtmcYakeenMakeModel toEntityModel() {
		AtmcYakeenMakeModelImpl atmcYakeenMakeModelImpl =
			new AtmcYakeenMakeModelImpl();

		atmcYakeenMakeModelImpl.setYakeenMakeId(yakeenMakeId);

		if (yakeenMakeValue == null) {
			atmcYakeenMakeModelImpl.setYakeenMakeValue("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenMakeValue(yakeenMakeValue);
		}

		if (yakeenMakeDesc == null) {
			atmcYakeenMakeModelImpl.setYakeenMakeDesc("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenMakeDesc(yakeenMakeDesc);
		}

		if (yakeenMakeMap == null) {
			atmcYakeenMakeModelImpl.setYakeenMakeMap("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenMakeMap(yakeenMakeMap);
		}

		atmcYakeenMakeModelImpl.setYakeenModelId(yakeenModelId);

		if (yakeenModelArabic == null) {
			atmcYakeenMakeModelImpl.setYakeenModelArabic("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenModelArabic(yakeenModelArabic);
		}

		if (yakeenModelEnglish == null) {
			atmcYakeenMakeModelImpl.setYakeenModelEnglish("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenModelEnglish(yakeenModelEnglish);
		}

		if (yakeenNodelMap == null) {
			atmcYakeenMakeModelImpl.setYakeenNodelMap("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenNodelMap(yakeenNodelMap);
		}

		if (yakeenModelValue == null) {
			atmcYakeenMakeModelImpl.setYakeenModelValue("");
		}
		else {
			atmcYakeenMakeModelImpl.setYakeenModelValue(yakeenModelValue);
		}

		if (atmcVehicleNationality == null) {
			atmcYakeenMakeModelImpl.setAtmcVehicleNationality("");
		}
		else {
			atmcYakeenMakeModelImpl.setAtmcVehicleNationality(
				atmcVehicleNationality);
		}

		if (atmcBodyType == null) {
			atmcYakeenMakeModelImpl.setAtmcBodyType("");
		}
		else {
			atmcYakeenMakeModelImpl.setAtmcBodyType(atmcBodyType);
		}

		if (atmcSeatingCapacity == null) {
			atmcYakeenMakeModelImpl.setAtmcSeatingCapacity("");
		}
		else {
			atmcYakeenMakeModelImpl.setAtmcSeatingCapacity(atmcSeatingCapacity);
		}

		if (mapMakeModelName == null) {
			atmcYakeenMakeModelImpl.setMapMakeModelName("");
		}
		else {
			atmcYakeenMakeModelImpl.setMapMakeModelName(mapMakeModelName);
		}

		if (eskaMakeId == null) {
			atmcYakeenMakeModelImpl.setEskaMakeId("");
		}
		else {
			atmcYakeenMakeModelImpl.setEskaMakeId(eskaMakeId);
		}

		if (eskaModelId == null) {
			atmcYakeenMakeModelImpl.setEskaModelId("");
		}
		else {
			atmcYakeenMakeModelImpl.setEskaModelId(eskaModelId);
		}

		if (mapMakeModelId == null) {
			atmcYakeenMakeModelImpl.setMapMakeModelId("");
		}
		else {
			atmcYakeenMakeModelImpl.setMapMakeModelId(mapMakeModelId);
		}

		if (eskaBodyTypeId == null) {
			atmcYakeenMakeModelImpl.setEskaBodyTypeId("");
		}
		else {
			atmcYakeenMakeModelImpl.setEskaBodyTypeId(eskaBodyTypeId);
		}

		if (eskaVehNationalityId == null) {
			atmcYakeenMakeModelImpl.setEskaVehNationalityId("");
		}
		else {
			atmcYakeenMakeModelImpl.setEskaVehNationalityId(
				eskaVehNationalityId);
		}

		atmcYakeenMakeModelImpl.resetOriginalValues();

		return atmcYakeenMakeModelImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		yakeenMakeId = objectInput.readLong();
		yakeenMakeValue = objectInput.readUTF();
		yakeenMakeDesc = objectInput.readUTF();
		yakeenMakeMap = objectInput.readUTF();

		yakeenModelId = objectInput.readLong();
		yakeenModelArabic = objectInput.readUTF();
		yakeenModelEnglish = objectInput.readUTF();
		yakeenNodelMap = objectInput.readUTF();
		yakeenModelValue = objectInput.readUTF();
		atmcVehicleNationality = objectInput.readUTF();
		atmcBodyType = objectInput.readUTF();
		atmcSeatingCapacity = objectInput.readUTF();
		mapMakeModelName = objectInput.readUTF();
		eskaMakeId = objectInput.readUTF();
		eskaModelId = objectInput.readUTF();
		mapMakeModelId = objectInput.readUTF();
		eskaBodyTypeId = objectInput.readUTF();
		eskaVehNationalityId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(yakeenMakeId);

		if (yakeenMakeValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenMakeValue);
		}

		if (yakeenMakeDesc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenMakeDesc);
		}

		if (yakeenMakeMap == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenMakeMap);
		}

		objectOutput.writeLong(yakeenModelId);

		if (yakeenModelArabic == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenModelArabic);
		}

		if (yakeenModelEnglish == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenModelEnglish);
		}

		if (yakeenNodelMap == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenNodelMap);
		}

		if (yakeenModelValue == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(yakeenModelValue);
		}

		if (atmcVehicleNationality == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(atmcVehicleNationality);
		}

		if (atmcBodyType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(atmcBodyType);
		}

		if (atmcSeatingCapacity == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(atmcSeatingCapacity);
		}

		if (mapMakeModelName == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mapMakeModelName);
		}

		if (eskaMakeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eskaMakeId);
		}

		if (eskaModelId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eskaModelId);
		}

		if (mapMakeModelId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(mapMakeModelId);
		}

		if (eskaBodyTypeId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eskaBodyTypeId);
		}

		if (eskaVehNationalityId == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(eskaVehNationalityId);
		}
	}

	public long yakeenMakeId;
	public String yakeenMakeValue;
	public String yakeenMakeDesc;
	public String yakeenMakeMap;
	public long yakeenModelId;
	public String yakeenModelArabic;
	public String yakeenModelEnglish;
	public String yakeenNodelMap;
	public String yakeenModelValue;
	public String atmcVehicleNationality;
	public String atmcBodyType;
	public String atmcSeatingCapacity;
	public String mapMakeModelName;
	public String eskaMakeId;
	public String eskaModelId;
	public String mapMakeModelId;
	public String eskaBodyTypeId;
	public String eskaVehNationalityId;

}