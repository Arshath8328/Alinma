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
 * Provides the local service utility for CodeMaster. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.CodeMasterLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterLocalService
 * @generated
 */
public class CodeMasterLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.CodeMasterLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the code master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMaster the code master
	 * @return the code master that was added
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster addCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return getService().addCodeMaster(codeMaster);
	}

	/**
	 * Creates a new code master with the primary key. Does not add the code master to the database.
	 *
	 * @param systemId the primary key for the new code master
	 * @return the new code master
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster createCodeMaster(
		long systemId) {

		return getService().createCodeMaster(systemId);
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
	 * Deletes the code master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMaster the code master
	 * @return the code master that was removed
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster deleteCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return getService().deleteCodeMaster(codeMaster);
	}

	/**
	 * Deletes the code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master that was removed
	 * @throws PortalException if a code master with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster deleteCodeMaster(
			long systemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteCodeMaster(systemId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.CodeMaster fetchCodeMaster(
		long systemId) {

		return getService().fetchCodeMaster(systemId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
			findByCode(String code)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().findByCode(code);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
			findByCodeCodeFreez(String code, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().findByCodeCodeFreez(code, codeFreezYN);
	}

	public static com.ejada.atmc.acl.db.model.CodeMaster findByCodeCodeSub(
			String code, String codeSub)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().findByCodeCodeSub(code, codeSub);
	}

	public static com.ejada.atmc.acl.db.model.CodeMaster
			findByCodeCodeSubCodeSubRef(
				String code, String codeSub, String codeSubRef,
				String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getService().findByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
			findCodeMasterByCode(String code, String locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findCodeMasterByCode(code, locale);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the code master with the primary key.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master
	 * @throws PortalException if a code master with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster getCodeMaster(
			long systemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCodeMaster(systemId);
	}

	/**
	 * Returns a range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of code masters
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
		getCodeMasters(int start, int end) {

		return getService().getCodeMasters(start, end);
	}

	/**
	 * Returns the number of code masters.
	 *
	 * @return the number of code masters
	 */
	public static int getCodeMastersCount() {
		return getService().getCodeMastersCount();
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
	 * Updates the code master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CodeMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param codeMaster the code master
	 * @return the code master that was updated
	 */
	public static com.ejada.atmc.acl.db.model.CodeMaster updateCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return getService().updateCodeMaster(codeMaster);
	}

	public static CodeMasterLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CodeMasterLocalService, CodeMasterLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CodeMasterLocalService.class);

		ServiceTracker<CodeMasterLocalService, CodeMasterLocalService>
			serviceTracker =
				new ServiceTracker
					<CodeMasterLocalService, CodeMasterLocalService>(
						bundle.getBundleContext(), CodeMasterLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}