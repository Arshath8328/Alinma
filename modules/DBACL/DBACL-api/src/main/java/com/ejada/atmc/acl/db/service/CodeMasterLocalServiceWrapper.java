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
 * Provides a wrapper for {@link CodeMasterLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterLocalService
 * @generated
 */
public class CodeMasterLocalServiceWrapper
	implements CodeMasterLocalService, ServiceWrapper<CodeMasterLocalService> {

	public CodeMasterLocalServiceWrapper(
		CodeMasterLocalService codeMasterLocalService) {

		_codeMasterLocalService = codeMasterLocalService;
	}

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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster addCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return _codeMasterLocalService.addCodeMaster(codeMaster);
	}

	/**
	 * Creates a new code master with the primary key. Does not add the code master to the database.
	 *
	 * @param systemId the primary key for the new code master
	 * @return the new code master
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster createCodeMaster(
		long systemId) {

		return _codeMasterLocalService.createCodeMaster(systemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.createPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster deleteCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return _codeMasterLocalService.deleteCodeMaster(codeMaster);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster deleteCodeMaster(
			long systemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.deleteCodeMaster(systemId);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _codeMasterLocalService.dynamicQuery();
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

		return _codeMasterLocalService.dynamicQuery(dynamicQuery);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {

		return _codeMasterLocalService.dynamicQuery(dynamicQuery, start, end);
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
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {

		return _codeMasterLocalService.dynamicQuery(
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

		return _codeMasterLocalService.dynamicQueryCount(dynamicQuery);
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

		return _codeMasterLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster fetchCodeMaster(
		long systemId) {

		return _codeMasterLocalService.fetchCodeMaster(systemId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CodeMaster> findByCode(
			String code)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterLocalService.findByCode(code);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
			findByCodeCodeFreez(String code, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterLocalService.findByCodeCodeFreez(code, codeFreezYN);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster findByCodeCodeSub(
			String code, String codeSub)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterLocalService.findByCodeCodeSub(code, codeSub);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster findByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterLocalService.findByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
			findCodeMasterByCode(String code, String locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.findCodeMasterByCode(code, locale);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _codeMasterLocalService.getActionableDynamicQuery();
	}

	/**
	 * Returns the code master with the primary key.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master
	 * @throws PortalException if a code master with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster getCodeMaster(long systemId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.getCodeMaster(systemId);
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
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CodeMaster>
		getCodeMasters(int start, int end) {

		return _codeMasterLocalService.getCodeMasters(start, end);
	}

	/**
	 * Returns the number of code masters.
	 *
	 * @return the number of code masters
	 */
	@Override
	public int getCodeMastersCount() {
		return _codeMasterLocalService.getCodeMastersCount();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _codeMasterLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _codeMasterLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public com.ejada.atmc.acl.db.model.CodeMaster updateCodeMaster(
		com.ejada.atmc.acl.db.model.CodeMaster codeMaster) {

		return _codeMasterLocalService.updateCodeMaster(codeMaster);
	}

	@Override
	public CodeMasterLocalService getWrappedService() {
		return _codeMasterLocalService;
	}

	@Override
	public void setWrappedService(
		CodeMasterLocalService codeMasterLocalService) {

		_codeMasterLocalService = codeMasterLocalService;
	}

	private CodeMasterLocalService _codeMasterLocalService;

}