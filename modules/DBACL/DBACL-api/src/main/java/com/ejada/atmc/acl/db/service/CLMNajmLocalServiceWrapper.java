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
 * Provides a wrapper for {@link CLMNajmLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmLocalService
 * @generated
 */
public class CLMNajmLocalServiceWrapper
	implements CLMNajmLocalService, ServiceWrapper<CLMNajmLocalService> {

	public CLMNajmLocalServiceWrapper(CLMNajmLocalService clmNajmLocalService) {
		_clmNajmLocalService = clmNajmLocalService;
	}

	/**
	 * Adds the clm najm to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajm the clm najm
	 * @return the clm najm that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm addCLMNajm(
		com.ejada.atmc.acl.db.model.CLMNajm clmNajm) {

		return _clmNajmLocalService.addCLMNajm(clmNajm);
	}

	/**
	 * Creates a new clm najm with the primary key. Does not add the clm najm to the database.
	 *
	 * @param clmNajmPK the primary key for the new clm najm
	 * @return the new clm najm
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm createCLMNajm(
		com.ejada.atmc.acl.db.service.persistence.CLMNajmPK clmNajmPK) {

		return _clmNajmLocalService.createCLMNajm(clmNajmPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmNajmLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the clm najm from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajm the clm najm
	 * @return the clm najm that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm deleteCLMNajm(
		com.ejada.atmc.acl.db.model.CLMNajm clmNajm) {

		return _clmNajmLocalService.deleteCLMNajm(clmNajm);
	}

	/**
	 * Deletes the clm najm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm that was removed
	 * @throws PortalException if a clm najm with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm deleteCLMNajm(
			com.ejada.atmc.acl.db.service.persistence.CLMNajmPK clmNajmPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmNajmLocalService.deleteCLMNajm(clmNajmPK);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmNajmLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _clmNajmLocalService.dynamicQuery();
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

		return _clmNajmLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmModelImpl</code>.
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

		return _clmNajmLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmModelImpl</code>.
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

		return _clmNajmLocalService.dynamicQuery(
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

		return _clmNajmLocalService.dynamicQueryCount(dynamicQuery);
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

		return _clmNajmLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm fetchCLMNajm(
		com.ejada.atmc.acl.db.service.persistence.CLMNajmPK clmNajmPK) {

		return _clmNajmLocalService.fetchCLMNajm(clmNajmPK);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm findByCaseNoEnglishName(
			String caseNo, String englishName)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return _clmNajmLocalService.findByCaseNoEnglishName(
			caseNo, englishName);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMNajm> findByCustomId(
		String customId) {

		return _clmNajmLocalService.findByCustomId(customId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMNajm>
		findByPlateNumber(String najmPlateNo) {

		return _clmNajmLocalService.findByPlateNumber(najmPlateNo);
	}

	/**
	 * Returns the clm najm with the primary key.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm
	 * @throws PortalException if a clm najm with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm getCLMNajm(
			com.ejada.atmc.acl.db.service.persistence.CLMNajmPK clmNajmPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmNajmLocalService.getCLMNajm(clmNajmPK);
	}

	/**
	 * Returns a range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of clm najms
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.CLMNajm> getCLMNajms(
		int start, int end) {

		return _clmNajmLocalService.getCLMNajms(start, end);
	}

	/**
	 * Returns the number of clm najms.
	 *
	 * @return the number of clm najms
	 */
	@Override
	public int getCLMNajmsCount() {
		return _clmNajmLocalService.getCLMNajmsCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _clmNajmLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _clmNajmLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the clm najm in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect CLMNajmLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param clmNajm the clm najm
	 * @return the clm najm that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.CLMNajm updateCLMNajm(
		com.ejada.atmc.acl.db.model.CLMNajm clmNajm) {

		return _clmNajmLocalService.updateCLMNajm(clmNajm);
	}

	@Override
	public CLMNajmLocalService getWrappedService() {
		return _clmNajmLocalService;
	}

	@Override
	public void setWrappedService(CLMNajmLocalService clmNajmLocalService) {
		_clmNajmLocalService = clmNajmLocalService;
	}

	private CLMNajmLocalService _clmNajmLocalService;

}