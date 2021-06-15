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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.service.base.GsonUtilsLocalServiceBaseImpl;
import com.google.gson.*;
import com.liferay.portal.aop.AopService;
import org.osgi.service.component.annotations.Component;

import java.lang.reflect.Type;
import java.util.Date;

/**
 * The implementation of the gson utils local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.GsonUtilsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see GsonUtilsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.bsl.db.model.GsonUtils",
	service = AopService.class
)
public class GsonUtilsLocalServiceImpl extends GsonUtilsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.bsl.db.service.GsonUtilsLocalServiceUtil} to access the gson utils local service.
	 */
	public Object fromGson(String gsonString, Class c)
	{
		Gson gson = new Gson();
		Object obj = gson.fromJson(gsonString, c);

		return obj;
	}

	public Object fromMobileGson(String gsonString, Class c)
	{
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer()).create();

		Object obj = gson.fromJson(gsonString, c);
		return obj;
	}

	public String toGson(Object gsonObject)
	{
		Gson gson = new Gson();
		String gsonString = gson.toJson(gsonObject);

		return gsonString;
	}

	private class DateDeserializer implements JsonDeserializer<Date>
	{
		@Override
		public Date deserialize(JsonElement element, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
		{
			try
			{
				if(element != null)
				{
					long date = element.getAsLong();
					return new Date(date);
				}
				else
					return null;
			}
			catch (Exception e)
			{
				System.out.println("Failed to parse Date due to: "+ e.getMessage());
				return null;
			}
		}
	}
}