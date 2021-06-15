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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.AtmcYakeenMakeModelServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class AtmcYakeenMakeModelSoap implements Serializable {

	public static AtmcYakeenMakeModelSoap toSoapModel(
		AtmcYakeenMakeModel model) {

		AtmcYakeenMakeModelSoap soapModel = new AtmcYakeenMakeModelSoap();

		soapModel.setYakeenMakeId(model.getYakeenMakeId());
		soapModel.setYakeenMakeValue(model.getYakeenMakeValue());
		soapModel.setYakeenMakeDesc(model.getYakeenMakeDesc());
		soapModel.setYakeenMakeMap(model.getYakeenMakeMap());
		soapModel.setYakeenModelId(model.getYakeenModelId());
		soapModel.setYakeenModelArabic(model.getYakeenModelArabic());
		soapModel.setYakeenModelEnglish(model.getYakeenModelEnglish());
		soapModel.setYakeenNodelMap(model.getYakeenNodelMap());
		soapModel.setYakeenModelValue(model.getYakeenModelValue());
		soapModel.setAtmcVehicleNationality(model.getAtmcVehicleNationality());
		soapModel.setAtmcBodyType(model.getAtmcBodyType());
		soapModel.setAtmcSeatingCapacity(model.getAtmcSeatingCapacity());
		soapModel.setMapMakeModelName(model.getMapMakeModelName());
		soapModel.setEskaMakeId(model.getEskaMakeId());
		soapModel.setEskaModelId(model.getEskaModelId());
		soapModel.setMapMakeModelId(model.getMapMakeModelId());
		soapModel.setEskaBodyTypeId(model.getEskaBodyTypeId());
		soapModel.setEskaVehNationalityId(model.getEskaVehNationalityId());

		return soapModel;
	}

	public static AtmcYakeenMakeModelSoap[] toSoapModels(
		AtmcYakeenMakeModel[] models) {

		AtmcYakeenMakeModelSoap[] soapModels =
			new AtmcYakeenMakeModelSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AtmcYakeenMakeModelSoap[][] toSoapModels(
		AtmcYakeenMakeModel[][] models) {

		AtmcYakeenMakeModelSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new AtmcYakeenMakeModelSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AtmcYakeenMakeModelSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AtmcYakeenMakeModelSoap[] toSoapModels(
		List<AtmcYakeenMakeModel> models) {

		List<AtmcYakeenMakeModelSoap> soapModels =
			new ArrayList<AtmcYakeenMakeModelSoap>(models.size());

		for (AtmcYakeenMakeModel model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new AtmcYakeenMakeModelSoap[soapModels.size()]);
	}

	public AtmcYakeenMakeModelSoap() {
	}

	public long getPrimaryKey() {
		return _yakeenMakeId;
	}

	public void setPrimaryKey(long pk) {
		setYakeenMakeId(pk);
	}

	public long getYakeenMakeId() {
		return _yakeenMakeId;
	}

	public void setYakeenMakeId(long yakeenMakeId) {
		_yakeenMakeId = yakeenMakeId;
	}

	public String getYakeenMakeValue() {
		return _yakeenMakeValue;
	}

	public void setYakeenMakeValue(String yakeenMakeValue) {
		_yakeenMakeValue = yakeenMakeValue;
	}

	public String getYakeenMakeDesc() {
		return _yakeenMakeDesc;
	}

	public void setYakeenMakeDesc(String yakeenMakeDesc) {
		_yakeenMakeDesc = yakeenMakeDesc;
	}

	public String getYakeenMakeMap() {
		return _yakeenMakeMap;
	}

	public void setYakeenMakeMap(String yakeenMakeMap) {
		_yakeenMakeMap = yakeenMakeMap;
	}

	public long getYakeenModelId() {
		return _yakeenModelId;
	}

	public void setYakeenModelId(long yakeenModelId) {
		_yakeenModelId = yakeenModelId;
	}

	public String getYakeenModelArabic() {
		return _yakeenModelArabic;
	}

	public void setYakeenModelArabic(String yakeenModelArabic) {
		_yakeenModelArabic = yakeenModelArabic;
	}

	public String getYakeenModelEnglish() {
		return _yakeenModelEnglish;
	}

	public void setYakeenModelEnglish(String yakeenModelEnglish) {
		_yakeenModelEnglish = yakeenModelEnglish;
	}

	public String getYakeenNodelMap() {
		return _yakeenNodelMap;
	}

	public void setYakeenNodelMap(String yakeenNodelMap) {
		_yakeenNodelMap = yakeenNodelMap;
	}

	public String getYakeenModelValue() {
		return _yakeenModelValue;
	}

	public void setYakeenModelValue(String yakeenModelValue) {
		_yakeenModelValue = yakeenModelValue;
	}

	public String getAtmcVehicleNationality() {
		return _atmcVehicleNationality;
	}

	public void setAtmcVehicleNationality(String atmcVehicleNationality) {
		_atmcVehicleNationality = atmcVehicleNationality;
	}

	public String getAtmcBodyType() {
		return _atmcBodyType;
	}

	public void setAtmcBodyType(String atmcBodyType) {
		_atmcBodyType = atmcBodyType;
	}

	public String getAtmcSeatingCapacity() {
		return _atmcSeatingCapacity;
	}

	public void setAtmcSeatingCapacity(String atmcSeatingCapacity) {
		_atmcSeatingCapacity = atmcSeatingCapacity;
	}

	public String getMapMakeModelName() {
		return _mapMakeModelName;
	}

	public void setMapMakeModelName(String mapMakeModelName) {
		_mapMakeModelName = mapMakeModelName;
	}

	public String getEskaMakeId() {
		return _eskaMakeId;
	}

	public void setEskaMakeId(String eskaMakeId) {
		_eskaMakeId = eskaMakeId;
	}

	public String getEskaModelId() {
		return _eskaModelId;
	}

	public void setEskaModelId(String eskaModelId) {
		_eskaModelId = eskaModelId;
	}

	public String getMapMakeModelId() {
		return _mapMakeModelId;
	}

	public void setMapMakeModelId(String mapMakeModelId) {
		_mapMakeModelId = mapMakeModelId;
	}

	public String getEskaBodyTypeId() {
		return _eskaBodyTypeId;
	}

	public void setEskaBodyTypeId(String eskaBodyTypeId) {
		_eskaBodyTypeId = eskaBodyTypeId;
	}

	public String getEskaVehNationalityId() {
		return _eskaVehNationalityId;
	}

	public void setEskaVehNationalityId(String eskaVehNationalityId) {
		_eskaVehNationalityId = eskaVehNationalityId;
	}

	private long _yakeenMakeId;
	private String _yakeenMakeValue;
	private String _yakeenMakeDesc;
	private String _yakeenMakeMap;
	private long _yakeenModelId;
	private String _yakeenModelArabic;
	private String _yakeenModelEnglish;
	private String _yakeenNodelMap;
	private String _yakeenModelValue;
	private String _atmcVehicleNationality;
	private String _atmcBodyType;
	private String _atmcSeatingCapacity;
	private String _mapMakeModelName;
	private String _eskaMakeId;
	private String _eskaModelId;
	private String _mapMakeModelId;
	private String _eskaBodyTypeId;
	private String _eskaVehNationalityId;

}