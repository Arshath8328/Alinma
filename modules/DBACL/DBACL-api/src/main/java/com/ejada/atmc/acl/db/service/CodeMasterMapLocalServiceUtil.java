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
 * Provides the local service utility for CodeMasterMap. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.CodeMasterMapLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMapLocalService
 * @generated
 */
public class CodeMasterMapLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.CodeMasterMapLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the code master map to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMasterMap the code master map
	 * @return the code master map that was added
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap addCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return getService().addCodeMasterMap(codeMasterMap);
	}

	/**
	 * Creates a new code master map with the primary key. Does not add the code master map to the database.
	 *
	 * @param source the primary key for the new code master map
	 * @return the new code master map
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap createCodeMasterMap(
		String source) {

		return getService().createCodeMasterMap(source);
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
	 * Deletes the code master map from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMasterMap the code master map
	 * @return the code master map that was removed
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap deleteCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return getService().deleteCodeMasterMap(codeMasterMap);
	}

	/**
	 * Deletes the code master map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map that was removed
	 * @throws PortalException if a code master map with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap deleteCodeMasterMap(
			String source)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCodeMasterMap(source);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterMapModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterMapModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.CodeMasterMap fetchCodeMasterMap(
		String source) {

		return getService().fetchCodeMasterMap(source);
	}

	public static com.ejada.atmc.acl.db.model.CodeMasterMap
		findBySourceTypeCoreCode(String sourceType, String coreCode) {

		return getService().findBySourceTypeCoreCode(sourceType, coreCode);
	}

	public static com.ejada.atmc.acl.db.model.CodeMasterMap
		findBySourceTypeSourceCode(String sourceType, String sourceCode) {

		return getService().findBySourceTypeSourceCode(sourceType, sourceCode);
	}

	public static com.ejada.atmc.acl.db.model.CodeMasterMap
		findBySourceTypeSourceCodeLevel1Code(
			String sourceType, String sourceCode, String lvl1Code) {

		return getService().findBySourceTypeSourceCodeLevel1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Returns the code master map with the primary key.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map
	 * @throws PortalException if a code master map with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap getCodeMasterMap(
			String source)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCodeMasterMap(source);
	}

	/**
	 * Returns a range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @return the range of code master maps
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.CodeMasterMap>
		getCodeMasterMaps(int start, int end) {

		return getService().getCodeMasterMaps(start, end);
	}

	/**
	 * Returns the number of code master maps.
	 *
	 * @return the number of code master maps
	 */
	public static int getCodeMasterMapsCount() {
		return getService().getCodeMasterMapsCount();
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
	 * Updates the code master map in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterMapLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMasterMap the code master map
	 * @return the code master map that was updated
	 */
	public static com.ejada.atmc.acl.db.model.CodeMasterMap updateCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return getService().updateCodeMasterMap(codeMasterMap);
	}

	public static CodeMasterMapLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CodeMasterMapLocalService, CodeMasterMapLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CodeMasterMapLocalService.class);

		ServiceTracker<CodeMasterMapLocalService, CodeMasterMapLocalService>
			serviceTracker =
				new ServiceTracker
					<CodeMasterMapLocalService, CodeMasterMapLocalService>(
						bundle.getBundleContext(),
						CodeMasterMapLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}