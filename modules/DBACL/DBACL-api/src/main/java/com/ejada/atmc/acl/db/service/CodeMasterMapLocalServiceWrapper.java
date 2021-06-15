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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CodeMasterMapLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMapLocalService
 * @generated
 */
public class CodeMasterMapLocalServiceWrapper
	implements CodeMasterMapLocalService,
			   ServiceWrapper<CodeMasterMapLocalService> {

	public CodeMasterMapLocalServiceWrapper(
		CodeMasterMapLocalService codeMasterMapLocalService) {

		_codeMasterMapLocalService = codeMasterMapLocalService;
	}

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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap addCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return _codeMasterMapLocalService.addCodeMasterMap(codeMasterMap);
	}

	/**
	 * Creates a new code master map with the primary key. Does not add the code master map to the database.
	 *
	 * @param source the primary key for the new code master map
	 * @return the new code master map
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap createCodeMasterMap(
		String source) {

		return _codeMasterMapLocalService.createCodeMasterMap(source);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterMapLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap deleteCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return _codeMasterMapLocalService.deleteCodeMasterMap(codeMasterMap);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap deleteCodeMasterMap(
			String source)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterMapLocalService.deleteCodeMasterMap(source);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterMapLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _codeMasterMapLocalService.dynamicQuery();
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _codeMasterMapLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _codeMasterMapLocalService.dynamicQuery(
			dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _codeMasterMapLocalService.dynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {

		return _codeMasterMapLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {

		return _codeMasterMapLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap fetchCodeMasterMap(
		String source) {

		return _codeMasterMapLocalService.fetchCodeMasterMap(source);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap findBySourceTypeCoreCode(
		String sourceType, String coreCode) {

		return _codeMasterMapLocalService.findBySourceTypeCoreCode(
			sourceType, coreCode);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap findBySourceTypeSourceCode(
		String sourceType, String sourceCode) {

		return _codeMasterMapLocalService.findBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap
		findBySourceTypeSourceCodeLevel1Code(
			String sourceType, String sourceCode, String lvl1Code) {

		return _codeMasterMapLocalService.findBySourceTypeSourceCodeLevel1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Returns the code master map with the primary key.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map
	 * @throws PortalException if a code master map with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap getCodeMasterMap(
			String source)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterMapLocalService.getCodeMasterMap(source);
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
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CodeMasterMap>
		getCodeMasterMaps(int start, int end) {

		return _codeMasterMapLocalService.getCodeMasterMaps(start, end);
	}

	/**
	 * Returns the number of code master maps.
	 *
	 * @return the number of code master maps
	 */
	@Override
	public int getCodeMasterMapsCount() {
		return _codeMasterMapLocalService.getCodeMasterMapsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _codeMasterMapLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterMapLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMasterMap updateCodeMasterMap(
		com.ejada.atmc.acl.db.model.CodeMasterMap codeMasterMap) {

		return _codeMasterMapLocalService.updateCodeMasterMap(codeMasterMap);
	}

	@Override
	public CodeMasterMapLocalService getWrappedService() {
		return _codeMasterMapLocalService;
	}

	@Override
	public void setWrappedService(
		CodeMasterMapLocalService codeMasterMapLocalService) {

		_codeMasterMapLocalService = codeMasterMapLocalService;
	}

	private CodeMasterMapLocalService _codeMasterMapLocalService;

}