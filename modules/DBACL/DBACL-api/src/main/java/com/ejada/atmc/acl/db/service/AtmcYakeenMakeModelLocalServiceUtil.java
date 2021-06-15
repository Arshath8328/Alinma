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

package com.ejada.atmc.acl.db.service;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for AtmcYakeenMakeModel. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.AtmcYakeenMakeModelLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see AtmcYakeenMakeModelLocalService
 * @generated
 */
public class AtmcYakeenMakeModelLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.AtmcYakeenMakeModelLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the atmc yakeen make model to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AtmcYakeenMakeModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 * @return the atmc yakeen make model that was added
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
		addAtmcYakeenMakeModel(
			com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
				atmcYakeenMakeModel) {

		return getService().addAtmcYakeenMakeModel(atmcYakeenMakeModel);
	}

	/**
	 * Creates a new atmc yakeen make model with the primary key. Does not add the atmc yakeen make model to the database.
	 *
	 * @param yakeenMakeId the primary key for the new atmc yakeen make model
	 * @return the new atmc yakeen make model
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
		createAtmcYakeenMakeModel(long yakeenMakeId) {

		return getService().createAtmcYakeenMakeModel(yakeenMakeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			createPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the atmc yakeen make model from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AtmcYakeenMakeModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
		deleteAtmcYakeenMakeModel(
			com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
				atmcYakeenMakeModel) {

		return getService().deleteAtmcYakeenMakeModel(atmcYakeenMakeModel);
	}

	/**
	 * Deletes the atmc yakeen make model with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AtmcYakeenMakeModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model that was removed
	 * @throws PortalException if a atmc yakeen make model with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
			deleteAtmcYakeenMakeModel(long yakeenMakeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteAtmcYakeenMakeModel(yakeenMakeId);
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			deletePersistedModel(
				com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery
		dynamicQuery() {

		return getService().dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return getService().dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
		fetchAtmcYakeenMakeModel(long yakeenMakeId) {

		return getService().fetchAtmcYakeenMakeModel(yakeenMakeId);
	}

	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
			findByEskaMakeModelDetails(String eskaMakeId, String eskaModelId)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getService().findByEskaMakeModelDetails(eskaMakeId, eskaModelId);
	}

	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
			findByYakeenMakeModelDetails(
				String yakeenMakeValue, String yakeenModelValue)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchAtmcYakeenMakeModelException {

		return getService().findByYakeenMakeModelDetails(
			yakeenMakeValue, yakeenModelValue);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the atmc yakeen make model with the primary key.
	 *
	 * @param yakeenMakeId the primary key of the atmc yakeen make model
	 * @return the atmc yakeen make model
	 * @throws PortalException if a atmc yakeen make model with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
			getAtmcYakeenMakeModel(long yakeenMakeId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAtmcYakeenMakeModel(yakeenMakeId);
	}

	/**
	 * Returns a range of all the atmc yakeen make models.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.AtmcYakeenMakeModelModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of atmc yakeen make models
	 * @param end the upper bound of the range of atmc yakeen make models (not inclusive)
	 * @return the range of atmc yakeen make models
	 */
	public static java.util.List
		<com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel>
			getAtmcYakeenMakeModels(int start, int end) {

		return getService().getAtmcYakeenMakeModels(start, end);
	}

	/**
	 * Returns the number of atmc yakeen make models.
	 *
	 * @return the number of atmc yakeen make models
	 */
	public static int getAtmcYakeenMakeModelsCount() {
		return getService().getAtmcYakeenMakeModelsCount();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	public static com.liferay.portal.kernel.model.PersistedModel
			getPersistedModel(java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the atmc yakeen make model in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect AtmcYakeenMakeModelLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param atmcYakeenMakeModel the atmc yakeen make model
	 * @return the atmc yakeen make model that was updated
	 */
	public static com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
		updateAtmcYakeenMakeModel(
			com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel
				atmcYakeenMakeModel) {

		return getService().updateAtmcYakeenMakeModel(atmcYakeenMakeModel);
	}

	public static AtmcYakeenMakeModelLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<AtmcYakeenMakeModelLocalService, AtmcYakeenMakeModelLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			AtmcYakeenMakeModelLocalService.class);

		ServiceTracker
			<AtmcYakeenMakeModelLocalService, AtmcYakeenMakeModelLocalService>
				serviceTracker =
					new ServiceTracker
						<AtmcYakeenMakeModelLocalService,
						 AtmcYakeenMakeModelLocalService>(
							 bundle.getBundleContext(),
							 AtmcYakeenMakeModelLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}