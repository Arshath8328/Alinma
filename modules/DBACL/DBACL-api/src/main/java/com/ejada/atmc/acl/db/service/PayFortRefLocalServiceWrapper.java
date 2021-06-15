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
 * Provides a wrapper for {@link PayFortRefLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayFortRefLocalService
 * @generated
 */
public class PayFortRefLocalServiceWrapper
	implements PayFortRefLocalService, ServiceWrapper<PayFortRefLocalService> {

	public PayFortRefLocalServiceWrapper(
		PayFortRefLocalService payFortRefLocalService) {

		_payFortRefLocalService = payFortRefLocalService;
	}

	/**
	 * Adds the pay fort ref to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayFortRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payFortRef the pay fort ref
	 * @return the pay fort ref that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef addPayFortRef(
		com.ejada.atmc.acl.db.model.PayFortRef payFortRef) {

		return _payFortRefLocalService.addPayFortRef(payFortRef);
	}

	/**
	 * Creates a new pay fort ref with the primary key. Does not add the pay fort ref to the database.
	 *
	 * @param id the primary key for the new pay fort ref
	 * @return the new pay fort ref
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef createPayFortRef(int id) {
		return _payFortRefLocalService.createPayFortRef(id);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payFortRefLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Deletes the pay fort ref with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayFortRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref that was removed
	 * @throws PortalException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef deletePayFortRef(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payFortRefLocalService.deletePayFortRef(id);
	}

	/**
	 * Deletes the pay fort ref from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayFortRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payFortRef the pay fort ref
	 * @return the pay fort ref that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef deletePayFortRef(
		com.ejada.atmc.acl.db.model.PayFortRef payFortRef) {

		return _payFortRefLocalService.deletePayFortRef(payFortRef);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payFortRefLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _payFortRefLocalService.dynamicQuery();
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

		return _payFortRefLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PayFortRefModelImpl</code>.
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

		return _payFortRefLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PayFortRefModelImpl</code>.
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

		return _payFortRefLocalService.dynamicQuery(
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

		return _payFortRefLocalService.dynamicQueryCount(dynamicQuery);
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

		return _payFortRefLocalService.dynamicQueryCount(
			dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef fetchPayFortRef(int id) {
		return _payFortRefLocalService.fetchPayFortRef(id);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef findByIqamaId(
			String pRefNo, String status)
		throws com.liferay.portal.kernel.exception.SystemException {

		return _payFortRefLocalService.findByIqamaId(pRefNo, status);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _payFortRefLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _payFortRefLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payFortRefLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * Returns the pay fort ref with the primary key.
	 *
	 * @param id the primary key of the pay fort ref
	 * @return the pay fort ref
	 * @throws PortalException if a pay fort ref with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef getPayFortRef(int id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payFortRefLocalService.getPayFortRef(id);
	}

	/**
	 * Returns a range of all the pay fort refs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PayFortRefModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pay fort refs
	 * @param end the upper bound of the range of pay fort refs (not inclusive)
	 * @return the range of pay fort refs
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.PayFortRef>
		getPayFortRefs(int start, int end) {

		return _payFortRefLocalService.getPayFortRefs(start, end);
	}

	/**
	 * Returns the number of pay fort refs.
	 *
	 * @return the number of pay fort refs
	 */
	@Override
	public int getPayFortRefsCount() {
		return _payFortRefLocalService.getPayFortRefsCount();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _payFortRefLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Updates the pay fort ref in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PayFortRefLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param payFortRef the pay fort ref
	 * @return the pay fort ref that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.PayFortRef updatePayFortRef(
		com.ejada.atmc.acl.db.model.PayFortRef payFortRef) {

		return _payFortRefLocalService.updatePayFortRef(payFortRef);
	}

	@Override
	public PayFortRefLocalService getWrappedService() {
		return _payFortRefLocalService;
	}

	@Override
	public void setWrappedService(
		PayFortRefLocalService payFortRefLocalService) {

		_payFortRefLocalService = payFortRefLocalService;
	}

	private PayFortRefLocalService _payFortRefLocalService;

}