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

package com.ejada.atmc.acl.db.service.persistence;

import com.ejada.atmc.acl.db.exception.NoSuchAtmcYakeenMakeModelException;
import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the atmc yakeen make model service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AtmcYakeenMakeModelUtil
 * @generated
 */
@ProviderType
public interface AtmcYakeenMakeModelPersistence
	extends BasePersistence<AtmcYakeenMakeModel> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link AtmcYakeenMakeModelUtil} to access the atmc yakeen make model persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel findByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws NoSuchAtmcYakeenMakeModelException;

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue);

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue,
		boolean useFinderCache);

	/**
	 * Removes the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; from the database.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the atmc yakeen make model that was removed
	 */
	public AtmcYakeenMakeModel removeByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws NoSuchAtmcYakeenMakeModelException;

	/**
	 * Returns the number of atmc yakeen make models where yakeenMakeValue = &#63; and yakeenModelValue = &#63;.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the number of matching atmc yakeen make models
	 */
	public int countByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue);

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel findByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws NoSuchAtmcYakeenMakeModelException;

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId);

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId, boolean useFinderCache);

	/**
	 * Removes the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; from the database.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the atmc yakeen make model that was removed
	 */
	public AtmcYakeenMakeModel removeByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws NoSuchAtmcYakeenMakeModelException;

	/**
	 * Returns the number of atmc yakeen make models where eskaMakeId = &#63; and eskaModelId = &#63;.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the number of matching atmc yakeen make models
	 */
	public int countByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId);

	/**
	 * Caches the atmc yakeen make model in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 */
	public void cacheResult(AtmcYakeenMakeModel atmcYakeenMakeModel);

	/**
	 * Caches the atmc yakeen make models in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModels the atmc yakeen make models
	 */
	public void cacheResult(
		java.util.List<AtmcYakeenMakeModel> atmcYakeenMakeModels);

	/**
	 * Creates a new atmc yakeen make model with the primary key. Does not add the atmc yakeen make model to the database.
	 *
	 * @param yakeenMakeId the primary key for the new atmc yakeen make model
	 * @return the new atmc yakeen make model
	 */
	public AtmcYakeenMakeModel create(long yakeenMakeId);

	/**
	 * Removes the atmc yakeen make model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	public AtmcYakeenMakeModel remove(long yakeenMakeId)
		throws NoSuchAtmcYakeenMakeModelException;

	public AtmcYakeenMakeModel updateImpl(
		AtmcYakeenMakeModel atmcYakeenMakeModel);

	/**
	 * Returns the atmc yakeen make model with the primary key or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	public AtmcYakeenMakeModel findByPrimaryKey(long yakeenMakeId)
		throws NoSuchAtmcYakeenMakeModelException;

	/**
	 * Returns the atmc yakeen make model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model, or <code>null</code> if a atmc yakeen make model with the primary key could not be found
	 */
	public AtmcYakeenMakeModel fetchByPrimaryKey(long yakeenMakeId);

	/**
	 * Returns all the atmc yakeen make models.
	 *
	 * @return the atmc yakeen make models
	 */
	public java.util.List<AtmcYakeenMakeModel> findAll();

	/**
	 * Returns a range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @return the range of atmc yakeen make models
	 */
	public java.util.List<AtmcYakeenMakeModel> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of atmc yakeen make models
	 */
	public java.util.List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AtmcYakeenMakeModel>
			orderByComparator);

	/**
	 * Returns an ordered range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of atmc yakeen make models
	 */
	public java.util.List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<AtmcYakeenMakeModel>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the atmc yakeen make models from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of atmc yakeen make models.
	 *
	 * @return the number of atmc yakeen make models
	 */
	public int countAll();

}