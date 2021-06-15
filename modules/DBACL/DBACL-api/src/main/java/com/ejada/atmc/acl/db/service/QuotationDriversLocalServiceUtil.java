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
 * Provides the local service utility for QuotationDrivers. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.QuotationDriversLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriversLocalService
 * @generated
 */
public class QuotationDriversLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.QuotationDriversLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quotation drivers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was added
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
		addQuotationDrivers(
			com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return getService().addQuotationDrivers(quotationDrivers);
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
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
		createQuotationDrivers(long addDriverId) {

		return getService().createQuotationDrivers(addDriverId);
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

	/**
	 * Deletes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
			deleteQuotationDrivers(long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuotationDrivers(addDriverId);
	}

	/**
	 * Deletes the quotation drivers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was removed
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
		deleteQuotationDrivers(
			com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return getService().deleteQuotationDrivers(quotationDrivers);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.QuotationDrivers
		fetchQuotationDrivers(long addDriverId) {

		return getService().fetchQuotationDrivers(addDriverId);
	}

	public static com.ejada.atmc.acl.db.model.QuotationDrivers
			findByAddDriverIdQuotationId(long quotationId, long addDriverId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException {

		return getService().findByAddDriverIdQuotationId(
			quotationId, addDriverId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		findByQuotationId(long quotationId) {

		return getService().findByQuotationId(quotationId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		findUnderAgeDriversByQuotationId(long quotationId) {

		return getService().findUnderAgeDriversByQuotationId(quotationId);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static
		com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery
			getIndexableActionableDynamicQuery() {

		return getService().getIndexableActionableDynamicQuery();
	}

	public static
		com.ejada.atmc.acl.db.model.
			QuotationDriversInsuredRelationProofBlobModel
				getInsuredRelationProofBlobModel(
					java.io.Serializable primaryKey) {

		return getService().getInsuredRelationProofBlobModel(primaryKey);
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
	 * Returns the quotation drivers with the primary key.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
			getQuotationDrivers(long addDriverId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationDrivers(addDriverId);
	}

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationDrivers>
		getQuotationDriverses(int start, int end) {

		return getService().getQuotationDriverses(start, end);
	}

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	public static int getQuotationDriversesCount() {
		return getService().getQuotationDriversesCount();
	}

	public static java.io.InputStream openInsuredRelationProofInputStream(
		long addDriverId) {

		return getService().openInsuredRelationProofInputStream(addDriverId);
	}

	/**
	 * Updates the quotation drivers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was updated
	 */
	public static com.ejada.atmc.acl.db.model.QuotationDrivers
		updateQuotationDrivers(
			com.ejada.atmc.acl.db.model.QuotationDrivers quotationDrivers) {

		return getService().updateQuotationDrivers(quotationDrivers);
	}

	public static QuotationDriversLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationDriversLocalService, QuotationDriversLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationDriversLocalService.class);

		ServiceTracker
			<QuotationDriversLocalService, QuotationDriversLocalService>
				serviceTracker =
					new ServiceTracker
						<QuotationDriversLocalService,
						 QuotationDriversLocalService>(
							 bundle.getBundleContext(),
							 QuotationDriversLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}