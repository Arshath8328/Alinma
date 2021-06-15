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

import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the atmc yakeen make model service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.AtmcYakeenMakeModelPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see AtmcYakeenMakeModelPersistence
 * @generated
 */
public class AtmcYakeenMakeModelUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(AtmcYakeenMakeModel atmcYakeenMakeModel) {
		getPersistence().clearCache(atmcYakeenMakeModel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, AtmcYakeenMakeModel> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<AtmcYakeenMakeModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<AtmcYakeenMakeModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<AtmcYakeenMakeModel> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<AtmcYakeenMakeModel> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static AtmcYakeenMakeModel update(
		AtmcYakeenMakeModel atmcYakeenMakeModel) {

		return getPersistence().update(atmcYakeenMakeModel);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static AtmcYakeenMakeModel update(
		AtmcYakeenMakeModel atmcYakeenMakeModel,
		ServiceContext serviceContext) {

		return getPersistence().update(atmcYakeenMakeModel, serviceContext);
	}

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel findByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().findByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);
	}

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue) {

		return getPersistence().fetchByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);
	}

	/**
	 * Returns the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel fetchByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue,
		boolean useFinderCache) {

		return getPersistence().fetchByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue, useFinderCache);
	}

	/**
	 * Removes the atmc yakeen make model where yakeenMakeValue = &#63; and yakeenModelValue = &#63; from the database.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the atmc yakeen make model that was removed
	 */
	public static AtmcYakeenMakeModel removeByYakeenMakeModelDetails(
			String yakeenMakeValue, String yakeenModelValue)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().removeByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);
	}

	/**
	 * Returns the number of atmc yakeen make models where yakeenMakeValue = &#63; and yakeenModelValue = &#63;.
	 *
	 * @param yakeenMakeValue the yakeen make value
	 * @param yakeenModelValue the yakeen model value
	 * @return the number of matching atmc yakeen make models
	 */
	public static int countByYakeenMakeModelDetails(
		String yakeenMakeValue, String yakeenModelValue) {

		return getPersistence().countByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);
	}

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel findByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().findByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);
	}

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId) {

		return getPersistence().fetchByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);
	}

	/**
	 * Returns the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching atmc yakeen make model, or <code>null</code> if a matching atmc yakeen make model could not be found
	 */
	public static AtmcYakeenMakeModel fetchByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId, boolean useFinderCache) {

		return getPersistence().fetchByEskaMakeModelDetails(
			eskaMakeId, eskaModelId, useFinderCache);
	}

	/**
	 * Removes the atmc yakeen make model where eskaMakeId = &#63; and eskaModelId = &#63; from the database.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the atmc yakeen make model that was removed
	 */
	public static AtmcYakeenMakeModel removeByEskaMakeModelDetails(
			String eskaMakeId, String eskaModelId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().removeByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);
	}

	/**
	 * Returns the number of atmc yakeen make models where eskaMakeId = &#63; and eskaModelId = &#63;.
	 *
	 * @param eskaMakeId the eska make ID
	 * @param eskaModelId the eska model ID
	 * @return the number of matching atmc yakeen make models
	 */
	public static int countByEskaMakeModelDetails(
		String eskaMakeId, String eskaModelId) {

		return getPersistence().countByEskaMakeModelDetails(
			eskaMakeId, eskaModelId);
	}

	/**
	 * Caches the atmc yakeen make model in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 */
	public static void cacheResult(AtmcYakeenMakeModel atmcYakeenMakeModel) {
		getPersistence().cacheResult(atmcYakeenMakeModel);
	}

	/**
	 * Caches the atmc yakeen make models in the entity cache if it is enabled.
	 *
	 * @param atmcYakeenMakeModels the atmc yakeen make models
	 */
	public static void cacheResult(
		List<AtmcYakeenMakeModel> atmcYakeenMakeModels) {

		getPersistence().cacheResult(atmcYakeenMakeModels);
	}

	/**
	 * Creates a new atmc yakeen make model with the primary key. Does not add the atmc yakeen make model to the database.
	 *
	 * @param yakeenMakeId the primary key for the new atmc yakeen make model
	 * @return the new atmc yakeen make model
	 */
	public static AtmcYakeenMakeModel create(long yakeenMakeId) {
		return getPersistence().create(yakeenMakeId);
	}

	/**
	 * Removes the atmc yakeen make model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	public static AtmcYakeenMakeModel remove(long yakeenMakeId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().remove(yakeenMakeId);
	}

	public static AtmcYakeenMakeModel updateImpl(
		AtmcYakeenMakeModel atmcYakeenMakeModel) {

		return getPersistence().updateImpl(atmcYakeenMakeModel);
	}

	/**
	 * Returns the atmc yakeen make model with the primary key or throws a <code>NoSuchAtmcYakeenMakeModelException</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model
	 * @throws NoSuchAtmcYakeenMakeModelException if a atmc yakeen make model with the primary key could not be found
	 */
	public static AtmcYakeenMakeModel findByPrimaryKey(long yakeenMakeId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getPersistence().findByPrimaryKey(yakeenMakeId);
	}

	/**
	 * Returns the atmc yakeen make model with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model, or <code>null</code> if a atmc yakeen make model with the primary key could not be found
	 */
	public static AtmcYakeenMakeModel fetchByPrimaryKey(long yakeenMakeId) {
		return getPersistence().fetchByPrimaryKey(yakeenMakeId);
	}

	/**
	 * Returns all the atmc yakeen make models.
	 *
	 * @return the atmc yakeen make models
	 */
	public static List<AtmcYakeenMakeModel> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<AtmcYakeenMakeModel> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		OrderByComparator<AtmcYakeenMakeModel> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<AtmcYakeenMakeModel> findAll(
		int start, int end,
		OrderByComparator<AtmcYakeenMakeModel> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the atmc yakeen make models from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of atmc yakeen make models.
	 *
	 * @return the number of atmc yakeen make models
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static AtmcYakeenMakeModelPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AtmcYakeenMakeModelPersistence, AtmcYakeenMakeModelPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AtmcYakeenMakeModelPersistence.class);

		ServiceTracker
			<AtmcYakeenMakeModelPersistence, AtmcYakeenMakeModelPersistence>
				serviceTracker =
					new ServiceTracker
						<AtmcYakeenMakeModelPersistence,
						 AtmcYakeenMakeModelPersistence>(
							 bundle.getBundleContext(),
							 AtmcYakeenMakeModelPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}