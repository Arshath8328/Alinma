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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the AtmcYakeenMakeModel service. Represents a row in the &quot;ATMC_YAKEEN_MAKEMODEL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AtmcYakeenMakeModel
 * @generated
 */
@ProviderType
public interface AtmcYakeenMakeModelModel
	extends BaseModel<AtmcYakeenMakeModel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a atmc yakeen make model model instance should use the {@link AtmcYakeenMakeModel} interface instead.
	 */

	/**
	 * Returns the primary key of this atmc yakeen make model.
	 *
	 * @return the primary key of this atmc yakeen make model
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this atmc yakeen make model.
	 *
	 * @param primaryKey the primary key of this atmc yakeen make model
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the yakeen make ID of this atmc yakeen make model.
	 *
	 * @return the yakeen make ID of this atmc yakeen make model
	 */
	public long getYakeenMakeId();

	/**
	 * Sets the yakeen make ID of this atmc yakeen make model.
	 *
	 * @param yakeenMakeId the yakeen make ID of this atmc yakeen make model
	 */
	public void setYakeenMakeId(long yakeenMakeId);

	/**
	 * Returns the yakeen make value of this atmc yakeen make model.
	 *
	 * @return the yakeen make value of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenMakeValue();

	/**
	 * Sets the yakeen make value of this atmc yakeen make model.
	 *
	 * @param yakeenMakeValue the yakeen make value of this atmc yakeen make model
	 */
	public void setYakeenMakeValue(String yakeenMakeValue);

	/**
	 * Returns the yakeen make desc of this atmc yakeen make model.
	 *
	 * @return the yakeen make desc of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenMakeDesc();

	/**
	 * Sets the yakeen make desc of this atmc yakeen make model.
	 *
	 * @param yakeenMakeDesc the yakeen make desc of this atmc yakeen make model
	 */
	public void setYakeenMakeDesc(String yakeenMakeDesc);

	/**
	 * Returns the yakeen make map of this atmc yakeen make model.
	 *
	 * @return the yakeen make map of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenMakeMap();

	/**
	 * Sets the yakeen make map of this atmc yakeen make model.
	 *
	 * @param yakeenMakeMap the yakeen make map of this atmc yakeen make model
	 */
	public void setYakeenMakeMap(String yakeenMakeMap);

	/**
	 * Returns the yakeen model ID of this atmc yakeen make model.
	 *
	 * @return the yakeen model ID of this atmc yakeen make model
	 */
	public long getYakeenModelId();

	/**
	 * Sets the yakeen model ID of this atmc yakeen make model.
	 *
	 * @param yakeenModelId the yakeen model ID of this atmc yakeen make model
	 */
	public void setYakeenModelId(long yakeenModelId);

	/**
	 * Returns the yakeen model arabic of this atmc yakeen make model.
	 *
	 * @return the yakeen model arabic of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenModelArabic();

	/**
	 * Sets the yakeen model arabic of this atmc yakeen make model.
	 *
	 * @param yakeenModelArabic the yakeen model arabic of this atmc yakeen make model
	 */
	public void setYakeenModelArabic(String yakeenModelArabic);

	/**
	 * Returns the yakeen model english of this atmc yakeen make model.
	 *
	 * @return the yakeen model english of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenModelEnglish();

	/**
	 * Sets the yakeen model english of this atmc yakeen make model.
	 *
	 * @param yakeenModelEnglish the yakeen model english of this atmc yakeen make model
	 */
	public void setYakeenModelEnglish(String yakeenModelEnglish);

	/**
	 * Returns the yakeen nodel map of this atmc yakeen make model.
	 *
	 * @return the yakeen nodel map of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenNodelMap();

	/**
	 * Sets the yakeen nodel map of this atmc yakeen make model.
	 *
	 * @param yakeenNodelMap the yakeen nodel map of this atmc yakeen make model
	 */
	public void setYakeenNodelMap(String yakeenNodelMap);

	/**
	 * Returns the yakeen model value of this atmc yakeen make model.
	 *
	 * @return the yakeen model value of this atmc yakeen make model
	 */
	@AutoEscape
	public String getYakeenModelValue();

	/**
	 * Sets the yakeen model value of this atmc yakeen make model.
	 *
	 * @param yakeenModelValue the yakeen model value of this atmc yakeen make model
	 */
	public void setYakeenModelValue(String yakeenModelValue);

	/**
	 * Returns the atmc vehicle nationality of this atmc yakeen make model.
	 *
	 * @return the atmc vehicle nationality of this atmc yakeen make model
	 */
	@AutoEscape
	public String getAtmcVehicleNationality();

	/**
	 * Sets the atmc vehicle nationality of this atmc yakeen make model.
	 *
	 * @param atmcVehicleNationality the atmc vehicle nationality of this atmc yakeen make model
	 */
	public void setAtmcVehicleNationality(String atmcVehicleNationality);

	/**
	 * Returns the atmc body type of this atmc yakeen make model.
	 *
	 * @return the atmc body type of this atmc yakeen make model
	 */
	@AutoEscape
	public String getAtmcBodyType();

	/**
	 * Sets the atmc body type of this atmc yakeen make model.
	 *
	 * @param atmcBodyType the atmc body type of this atmc yakeen make model
	 */
	public void setAtmcBodyType(String atmcBodyType);

	/**
	 * Returns the atmc seating capacity of this atmc yakeen make model.
	 *
	 * @return the atmc seating capacity of this atmc yakeen make model
	 */
	@AutoEscape
	public String getAtmcSeatingCapacity();

	/**
	 * Sets the atmc seating capacity of this atmc yakeen make model.
	 *
	 * @param atmcSeatingCapacity the atmc seating capacity of this atmc yakeen make model
	 */
	public void setAtmcSeatingCapacity(String atmcSeatingCapacity);

	/**
	 * Returns the map make model name of this atmc yakeen make model.
	 *
	 * @return the map make model name of this atmc yakeen make model
	 */
	@AutoEscape
	public String getMapMakeModelName();

	/**
	 * Sets the map make model name of this atmc yakeen make model.
	 *
	 * @param mapMakeModelName the map make model name of this atmc yakeen make model
	 */
	public void setMapMakeModelName(String mapMakeModelName);

	/**
	 * Returns the eska make ID of this atmc yakeen make model.
	 *
	 * @return the eska make ID of this atmc yakeen make model
	 */
	@AutoEscape
	public String getEskaMakeId();

	/**
	 * Sets the eska make ID of this atmc yakeen make model.
	 *
	 * @param eskaMakeId the eska make ID of this atmc yakeen make model
	 */
	public void setEskaMakeId(String eskaMakeId);

	/**
	 * Returns the eska model ID of this atmc yakeen make model.
	 *
	 * @return the eska model ID of this atmc yakeen make model
	 */
	@AutoEscape
	public String getEskaModelId();

	/**
	 * Sets the eska model ID of this atmc yakeen make model.
	 *
	 * @param eskaModelId the eska model ID of this atmc yakeen make model
	 */
	public void setEskaModelId(String eskaModelId);

	/**
	 * Returns the map make model ID of this atmc yakeen make model.
	 *
	 * @return the map make model ID of this atmc yakeen make model
	 */
	@AutoEscape
	public String getMapMakeModelId();

	/**
	 * Sets the map make model ID of this atmc yakeen make model.
	 *
	 * @param mapMakeModelId the map make model ID of this atmc yakeen make model
	 */
	public void setMapMakeModelId(String mapMakeModelId);

	/**
	 * Returns the eska body type ID of this atmc yakeen make model.
	 *
	 * @return the eska body type ID of this atmc yakeen make model
	 */
	@AutoEscape
	public String getEskaBodyTypeId();

	/**
	 * Sets the eska body type ID of this atmc yakeen make model.
	 *
	 * @param eskaBodyTypeId the eska body type ID of this atmc yakeen make model
	 */
	public void setEskaBodyTypeId(String eskaBodyTypeId);

	/**
	 * Returns the eska veh nationality ID of this atmc yakeen make model.
	 *
	 * @return the eska veh nationality ID of this atmc yakeen make model
	 */
	@AutoEscape
	public String getEskaVehNationalityId();

	/**
	 * Sets the eska veh nationality ID of this atmc yakeen make model.
	 *
	 * @param eskaVehNationalityId the eska veh nationality ID of this atmc yakeen make model
	 */
	public void setEskaVehNationalityId(String eskaVehNationalityId);

}