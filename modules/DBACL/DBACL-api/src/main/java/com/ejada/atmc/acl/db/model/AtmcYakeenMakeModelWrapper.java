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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link AtmcYakeenMakeModel}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AtmcYakeenMakeModel
 * @generated
 */
public class AtmcYakeenMakeModelWrapper
	extends BaseModelWrapper<AtmcYakeenMakeModel>
	implements AtmcYakeenMakeModel, ModelWrapper<AtmcYakeenMakeModel> {

	public AtmcYakeenMakeModelWrapper(AtmcYakeenMakeModel atmcYakeenMakeModel) {
		super(atmcYakeenMakeModel);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("yakeenMakeId", getYakeenMakeId());
		attributes.put("yakeenMakeValue", getYakeenMakeValue());
		attributes.put("yakeenMakeDesc", getYakeenMakeDesc());
		attributes.put("yakeenMakeMap", getYakeenMakeMap());
		attributes.put("yakeenModelId", getYakeenModelId());
		attributes.put("yakeenModelArabic", getYakeenModelArabic());
		attributes.put("yakeenModelEnglish", getYakeenModelEnglish());
		attributes.put("yakeenNodelMap", getYakeenNodelMap());
		attributes.put("yakeenModelValue", getYakeenModelValue());
		attributes.put("atmcVehicleNationality", getAtmcVehicleNationality());
		attributes.put("atmcBodyType", getAtmcBodyType());
		attributes.put("atmcSeatingCapacity", getAtmcSeatingCapacity());
		attributes.put("mapMakeModelName", getMapMakeModelName());
		attributes.put("eskaMakeId", getEskaMakeId());
		attributes.put("eskaModelId", getEskaModelId());
		attributes.put("mapMakeModelId", getMapMakeModelId());
		attributes.put("eskaBodyTypeId", getEskaBodyTypeId());
		attributes.put("eskaVehNationalityId", getEskaVehNationalityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long yakeenMakeId = (Long)attributes.get("yakeenMakeId");

		if (yakeenMakeId != null) {
			setYakeenMakeId(yakeenMakeId);
		}

		String yakeenMakeValue = (String)attributes.get("yakeenMakeValue");

		if (yakeenMakeValue != null) {
			setYakeenMakeValue(yakeenMakeValue);
		}

		String yakeenMakeDesc = (String)attributes.get("yakeenMakeDesc");

		if (yakeenMakeDesc != null) {
			setYakeenMakeDesc(yakeenMakeDesc);
		}

		String yakeenMakeMap = (String)attributes.get("yakeenMakeMap");

		if (yakeenMakeMap != null) {
			setYakeenMakeMap(yakeenMakeMap);
		}

		Long yakeenModelId = (Long)attributes.get("yakeenModelId");

		if (yakeenModelId != null) {
			setYakeenModelId(yakeenModelId);
		}

		String yakeenModelArabic = (String)attributes.get("yakeenModelArabic");

		if (yakeenModelArabic != null) {
			setYakeenModelArabic(yakeenModelArabic);
		}

		String yakeenModelEnglish = (String)attributes.get(
			"yakeenModelEnglish");

		if (yakeenModelEnglish != null) {
			setYakeenModelEnglish(yakeenModelEnglish);
		}

		String yakeenNodelMap = (String)attributes.get("yakeenNodelMap");

		if (yakeenNodelMap != null) {
			setYakeenNodelMap(yakeenNodelMap);
		}

		String yakeenModelValue = (String)attributes.get("yakeenModelValue");

		if (yakeenModelValue != null) {
			setYakeenModelValue(yakeenModelValue);
		}

		String atmcVehicleNationality = (String)attributes.get(
			"atmcVehicleNationality");

		if (atmcVehicleNationality != null) {
			setAtmcVehicleNationality(atmcVehicleNationality);
		}

		String atmcBodyType = (String)attributes.get("atmcBodyType");

		if (atmcBodyType != null) {
			setAtmcBodyType(atmcBodyType);
		}

		String atmcSeatingCapacity = (String)attributes.get(
			"atmcSeatingCapacity");

		if (atmcSeatingCapacity != null) {
			setAtmcSeatingCapacity(atmcSeatingCapacity);
		}

		String mapMakeModelName = (String)attributes.get("mapMakeModelName");

		if (mapMakeModelName != null) {
			setMapMakeModelName(mapMakeModelName);
		}

		String eskaMakeId = (String)attributes.get("eskaMakeId");

		if (eskaMakeId != null) {
			setEskaMakeId(eskaMakeId);
		}

		String eskaModelId = (String)attributes.get("eskaModelId");

		if (eskaModelId != null) {
			setEskaModelId(eskaModelId);
		}

		String mapMakeModelId = (String)attributes.get("mapMakeModelId");

		if (mapMakeModelId != null) {
			setMapMakeModelId(mapMakeModelId);
		}

		String eskaBodyTypeId = (String)attributes.get("eskaBodyTypeId");

		if (eskaBodyTypeId != null) {
			setEskaBodyTypeId(eskaBodyTypeId);
		}

		String eskaVehNationalityId = (String)attributes.get(
			"eskaVehNationalityId");

		if (eskaVehNationalityId != null) {
			setEskaVehNationalityId(eskaVehNationalityId);
		}
	}

	/**
	 * Returns the atmc body type of this atmc yakeen make model.
	 *
	 * @return the atmc body type of this atmc yakeen make model
	 */
	@Override
	public String getAtmcBodyType() {
		return model.getAtmcBodyType();
	}

	/**
	 * Returns the atmc seating capacity of this atmc yakeen make model.
	 *
	 * @return the atmc seating capacity of this atmc yakeen make model
	 */
	@Override
	public String getAtmcSeatingCapacity() {
		return model.getAtmcSeatingCapacity();
	}

	/**
	 * Returns the atmc vehicle nationality of this atmc yakeen make model.
	 *
	 * @return the atmc vehicle nationality of this atmc yakeen make model
	 */
	@Override
	public String getAtmcVehicleNationality() {
		return model.getAtmcVehicleNationality();
	}

	/**
	 * Returns the eska body type ID of this atmc yakeen make model.
	 *
	 * @return the eska body type ID of this atmc yakeen make model
	 */
	@Override
	public String getEskaBodyTypeId() {
		return model.getEskaBodyTypeId();
	}

	/**
	 * Returns the eska make ID of this atmc yakeen make model.
	 *
	 * @return the eska make ID of this atmc yakeen make model
	 */
	@Override
	public String getEskaMakeId() {
		return model.getEskaMakeId();
	}

	/**
	 * Returns the eska model ID of this atmc yakeen make model.
	 *
	 * @return the eska model ID of this atmc yakeen make model
	 */
	@Override
	public String getEskaModelId() {
		return model.getEskaModelId();
	}

	/**
	 * Returns the eska veh nationality ID of this atmc yakeen make model.
	 *
	 * @return the eska veh nationality ID of this atmc yakeen make model
	 */
	@Override
	public String getEskaVehNationalityId() {
		return model.getEskaVehNationalityId();
	}

	/**
	 * Returns the map make model ID of this atmc yakeen make model.
	 *
	 * @return the map make model ID of this atmc yakeen make model
	 */
	@Override
	public String getMapMakeModelId() {
		return model.getMapMakeModelId();
	}

	/**
	 * Returns the map make model name of this atmc yakeen make model.
	 *
	 * @return the map make model name of this atmc yakeen make model
	 */
	@Override
	public String getMapMakeModelName() {
		return model.getMapMakeModelName();
	}

	/**
	 * Returns the primary key of this atmc yakeen make model.
	 *
	 * @return the primary key of this atmc yakeen make model
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the yakeen make desc of this atmc yakeen make model.
	 *
	 * @return the yakeen make desc of this atmc yakeen make model
	 */
	@Override
	public String getYakeenMakeDesc() {
		return model.getYakeenMakeDesc();
	}

	/**
	 * Returns the yakeen make ID of this atmc yakeen make model.
	 *
	 * @return the yakeen make ID of this atmc yakeen make model
	 */
	@Override
	public long getYakeenMakeId() {
		return model.getYakeenMakeId();
	}

	/**
	 * Returns the yakeen make map of this atmc yakeen make model.
	 *
	 * @return the yakeen make map of this atmc yakeen make model
	 */
	@Override
	public String getYakeenMakeMap() {
		return model.getYakeenMakeMap();
	}

	/**
	 * Returns the yakeen make value of this atmc yakeen make model.
	 *
	 * @return the yakeen make value of this atmc yakeen make model
	 */
	@Override
	public String getYakeenMakeValue() {
		return model.getYakeenMakeValue();
	}

	/**
	 * Returns the yakeen model arabic of this atmc yakeen make model.
	 *
	 * @return the yakeen model arabic of this atmc yakeen make model
	 */
	@Override
	public String getYakeenModelArabic() {
		return model.getYakeenModelArabic();
	}

	/**
	 * Returns the yakeen model english of this atmc yakeen make model.
	 *
	 * @return the yakeen model english of this atmc yakeen make model
	 */
	@Override
	public String getYakeenModelEnglish() {
		return model.getYakeenModelEnglish();
	}

	/**
	 * Returns the yakeen model ID of this atmc yakeen make model.
	 *
	 * @return the yakeen model ID of this atmc yakeen make model
	 */
	@Override
	public long getYakeenModelId() {
		return model.getYakeenModelId();
	}

	/**
	 * Returns the yakeen model value of this atmc yakeen make model.
	 *
	 * @return the yakeen model value of this atmc yakeen make model
	 */
	@Override
	public String getYakeenModelValue() {
		return model.getYakeenModelValue();
	}

	/**
	 * Returns the yakeen nodel map of this atmc yakeen make model.
	 *
	 * @return the yakeen nodel map of this atmc yakeen make model
	 */
	@Override
	public String getYakeenNodelMap() {
		return model.getYakeenNodelMap();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the atmc body type of this atmc yakeen make model.
	 *
	 * @param atmcBodyType the atmc body type of this atmc yakeen make model
	 */
	@Override
	public void setAtmcBodyType(String atmcBodyType) {
		model.setAtmcBodyType(atmcBodyType);
	}

	/**
	 * Sets the atmc seating capacity of this atmc yakeen make model.
	 *
	 * @param atmcSeatingCapacity the atmc seating capacity of this atmc yakeen make model
	 */
	@Override
	public void setAtmcSeatingCapacity(String atmcSeatingCapacity) {
		model.setAtmcSeatingCapacity(atmcSeatingCapacity);
	}

	/**
	 * Sets the atmc vehicle nationality of this atmc yakeen make model.
	 *
	 * @param atmcVehicleNationality the atmc vehicle nationality of this atmc yakeen make model
	 */
	@Override
	public void setAtmcVehicleNationality(String atmcVehicleNationality) {
		model.setAtmcVehicleNationality(atmcVehicleNationality);
	}

	/**
	 * Sets the eska body type ID of this atmc yakeen make model.
	 *
	 * @param eskaBodyTypeId the eska body type ID of this atmc yakeen make model
	 */
	@Override
	public void setEskaBodyTypeId(String eskaBodyTypeId) {
		model.setEskaBodyTypeId(eskaBodyTypeId);
	}

	/**
	 * Sets the eska make ID of this atmc yakeen make model.
	 *
	 * @param eskaMakeId the eska make ID of this atmc yakeen make model
	 */
	@Override
	public void setEskaMakeId(String eskaMakeId) {
		model.setEskaMakeId(eskaMakeId);
	}

	/**
	 * Sets the eska model ID of this atmc yakeen make model.
	 *
	 * @param eskaModelId the eska model ID of this atmc yakeen make model
	 */
	@Override
	public void setEskaModelId(String eskaModelId) {
		model.setEskaModelId(eskaModelId);
	}

	/**
	 * Sets the eska veh nationality ID of this atmc yakeen make model.
	 *
	 * @param eskaVehNationalityId the eska veh nationality ID of this atmc yakeen make model
	 */
	@Override
	public void setEskaVehNationalityId(String eskaVehNationalityId) {
		model.setEskaVehNationalityId(eskaVehNationalityId);
	}

	/**
	 * Sets the map make model ID of this atmc yakeen make model.
	 *
	 * @param mapMakeModelId the map make model ID of this atmc yakeen make model
	 */
	@Override
	public void setMapMakeModelId(String mapMakeModelId) {
		model.setMapMakeModelId(mapMakeModelId);
	}

	/**
	 * Sets the map make model name of this atmc yakeen make model.
	 *
	 * @param mapMakeModelName the map make model name of this atmc yakeen make model
	 */
	@Override
	public void setMapMakeModelName(String mapMakeModelName) {
		model.setMapMakeModelName(mapMakeModelName);
	}

	/**
	 * Sets the primary key of this atmc yakeen make model.
	 *
	 * @param primaryKey the primary key of this atmc yakeen make model
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the yakeen make desc of this atmc yakeen make model.
	 *
	 * @param yakeenMakeDesc the yakeen make desc of this atmc yakeen make model
	 */
	@Override
	public void setYakeenMakeDesc(String yakeenMakeDesc) {
		model.setYakeenMakeDesc(yakeenMakeDesc);
	}

	/**
	 * Sets the yakeen make ID of this atmc yakeen make model.
	 *
	 * @param yakeenMakeId the yakeen make ID of this atmc yakeen make model
	 */
	@Override
	public void setYakeenMakeId(long yakeenMakeId) {
		model.setYakeenMakeId(yakeenMakeId);
	}

	/**
	 * Sets the yakeen make map of this atmc yakeen make model.
	 *
	 * @param yakeenMakeMap the yakeen make map of this atmc yakeen make model
	 */
	@Override
	public void setYakeenMakeMap(String yakeenMakeMap) {
		model.setYakeenMakeMap(yakeenMakeMap);
	}

	/**
	 * Sets the yakeen make value of this atmc yakeen make model.
	 *
	 * @param yakeenMakeValue the yakeen make value of this atmc yakeen make model
	 */
	@Override
	public void setYakeenMakeValue(String yakeenMakeValue) {
		model.setYakeenMakeValue(yakeenMakeValue);
	}

	/**
	 * Sets the yakeen model arabic of this atmc yakeen make model.
	 *
	 * @param yakeenModelArabic the yakeen model arabic of this atmc yakeen make model
	 */
	@Override
	public void setYakeenModelArabic(String yakeenModelArabic) {
		model.setYakeenModelArabic(yakeenModelArabic);
	}

	/**
	 * Sets the yakeen model english of this atmc yakeen make model.
	 *
	 * @param yakeenModelEnglish the yakeen model english of this atmc yakeen make model
	 */
	@Override
	public void setYakeenModelEnglish(String yakeenModelEnglish) {
		model.setYakeenModelEnglish(yakeenModelEnglish);
	}

	/**
	 * Sets the yakeen model ID of this atmc yakeen make model.
	 *
	 * @param yakeenModelId the yakeen model ID of this atmc yakeen make model
	 */
	@Override
	public void setYakeenModelId(long yakeenModelId) {
		model.setYakeenModelId(yakeenModelId);
	}

	/**
	 * Sets the yakeen model value of this atmc yakeen make model.
	 *
	 * @param yakeenModelValue the yakeen model value of this atmc yakeen make model
	 */
	@Override
	public void setYakeenModelValue(String yakeenModelValue) {
		model.setYakeenModelValue(yakeenModelValue);
	}

	/**
	 * Sets the yakeen nodel map of this atmc yakeen make model.
	 *
	 * @param yakeenNodelMap the yakeen nodel map of this atmc yakeen make model
	 */
	@Override
	public void setYakeenNodelMap(String yakeenNodelMap) {
		model.setYakeenNodelMap(yakeenNodelMap);
	}

	@Override
	protected AtmcYakeenMakeModelWrapper wrap(
		AtmcYakeenMakeModel atmcYakeenMakeModel) {

		return new AtmcYakeenMakeModelWrapper(atmcYakeenMakeModel);
	}

}