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
 * Provides a wrapper for {@link FundDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see FundDetailsLocalService
 * @generated
 */
public class FundDetailsLocalServiceWrapper
	implements FundDetailsLocalService,
			   ServiceWrapper<FundDetailsLocalService> {

	public FundDetailsLocalServiceWrapper(
		FundDetailsLocalService fundDetailsLocalService) {

		_fundDetailsLocalService = fundDetailsLocalService;
	}

	/**
	 * Adds the fund details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FundDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fundDetails the fund details
	 * @return the fund details that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails addFundDetails(
		com.ejada.atmc.acl.db.model.FundDetails fundDetails) {

		return _fundDetailsLocalService.addFundDetails(fundDetails);
	}

	/**
	 * Creates a new fund details with the primary key. Does not add the fund details to the database.
	 *
	 * @param fundName the primary key for the new fund details
	 * @return the new fund details
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails createFundDetails(
		String fundName) {

		return _fundDetailsLocalService.createFundDetails(fundName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fundDetailsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the fund details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FundDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fundDetails the fund details
	 * @return the fund details that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails deleteFundDetails(
		com.ejada.atmc.acl.db.model.FundDetails fundDetails) {

		return _fundDetailsLocalService.deleteFundDetails(fundDetails);
	}

	/**
	 * Deletes the fund details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FundDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details that was removed
	 * @throws PortalException if a fund details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails deleteFundDetails(
			String fundName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fundDetailsLocalService.deleteFundDetails(fundName);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fundDetailsLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _fundDetailsLocalService.dynamicQuery();
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

		return _fundDetailsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.FundDetailsModelImpl</code>.
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

		return _fundDetailsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.FundDetailsModelImpl</code>.
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

		return _fundDetailsLocalService.dynamicQuery(
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

		return _fundDetailsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _fundDetailsLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.FundDetails fetchFundDetails(
		String fundName) {

		return _fundDetailsLocalService.fetchFundDetails(fundName);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.FundDetails>
		findByPolicyNumber(String policyNo) {

		return _fundDetailsLocalService.findByPolicyNumber(policyNo);
	}

	/**
	 * Returns the fund details with the primary key.
	 *
	 * @param fundName the primary key of the fund details
	 * @return the fund details
	 * @throws PortalException if a fund details with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails getFundDetails(
			String fundName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fundDetailsLocalService.getFundDetails(fundName);
	}

	/**
	 * Returns a range of all the fund detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.FundDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of fund detailses
	 * @param end the upper bound of the range of fund detailses (not inclusive)
	 * @return the range of fund detailses
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.FundDetails>
		getFundDetailses(int start, int end) {

		return _fundDetailsLocalService.getFundDetailses(start, end);
	}

	/**
	 * Returns the number of fund detailses.
	 *
	 * @return the number of fund detailses
	 */
	@Override
	public int getFundDetailsesCount() {
		return _fundDetailsLocalService.getFundDetailsesCount();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _fundDetailsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _fundDetailsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the fund details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect FundDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param fundDetails the fund details
	 * @return the fund details that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.FundDetails updateFundDetails(
		com.ejada.atmc.acl.db.model.FundDetails fundDetails) {

		return _fundDetailsLocalService.updateFundDetails(fundDetails);
	}

	@Override
	public FundDetailsLocalService getWrappedService() {
		return _fundDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		FundDetailsLocalService fundDetailsLocalService) {

		_fundDetailsLocalService = fundDetailsLocalService;
	}

	private FundDetailsLocalService _fundDetailsLocalService;

}