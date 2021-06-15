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
 * Provides a wrapper for {@link SMSLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SMSLocalService
 * @generated
 */
public class SMSLocalServiceWrapper
	implements ServiceWrapper<SMSLocalService>, SMSLocalService {

	public SMSLocalServiceWrapper(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	/**
	 * Adds the Sms Table to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the Sms Table
	 * @return the Sms Table that was added
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS addSMS(
		com.ejada.atmc.acl.db.model.SMS sms) {

		return _smsLocalService.addSMS(sms);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel createPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.createPersistedModel(primaryKeyObj);
	}

	/**
	 * Creates a new Sms Table with the primary key. Does not add the Sms Table to the database.
	 *
	 * @param ID the primary key for the new Sms Table
	 * @return the new Sms Table
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS createSMS(long ID) {
		return _smsLocalService.createSMS(ID);
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
			com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.deletePersistedModel(persistedModel);
	}

	/**
	 * Deletes the Sms Table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table that was removed
	 * @throws PortalException if a Sms Table with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS deleteSMS(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.deleteSMS(ID);
	}

	/**
	 * Deletes the Sms Table from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the Sms Table
	 * @return the Sms Table that was removed
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS deleteSMS(
		com.ejada.atmc.acl.db.model.SMS sms) {

		return _smsLocalService.deleteSMS(sms);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _smsLocalService.dynamicQuery();
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

		return _smsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.SMSModelImpl</code>.
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

		return _smsLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.SMSModelImpl</code>.
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

		return _smsLocalService.dynamicQuery(
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

		return _smsLocalService.dynamicQueryCount(dynamicQuery);
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

		return _smsLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.ejada.atmc.acl.db.model.SMS fetchSMS(long ID) {
		return _smsLocalService.fetchSMS(ID);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return _smsLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		return _smsLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _smsLocalService.getOSGiServiceIdentifier();
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
			java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	 * Returns the Sms Table with the primary key.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table
	 * @throws PortalException if a Sms Table with the primary key could not be found
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS getSMS(long ID)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _smsLocalService.getSMS(ID);
	}

	/**
	 * Returns a range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @return the range of Sms Tables
	 */
	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.SMS> getSMSs(
		int start, int end) {

		return _smsLocalService.getSMSs(start, end);
	}

	/**
	 * Returns the number of Sms Tables.
	 *
	 * @return the number of Sms Tables
	 */
	@Override
	public int getSMSsCount() {
		return _smsLocalService.getSMSsCount();
	}

	@Override
	public void sendSms(String message, String mobile)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.sql.SQLException {

		_smsLocalService.sendSms(message, mobile);
	}

	/**
	 * Updates the Sms Table in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect SMSLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param sms the Sms Table
	 * @return the Sms Table that was updated
	 */
	@Override
	public com.ejada.atmc.acl.db.model.SMS updateSMS(
		com.ejada.atmc.acl.db.model.SMS sms) {

		return _smsLocalService.updateSMS(sms);
	}

	@Override
	public SMSLocalService getWrappedService() {
		return _smsLocalService;
	}

	@Override
	public void setWrappedService(SMSLocalService smsLocalService) {
		_smsLocalService = smsLocalService;
	}

	private SMSLocalService _smsLocalService;

}