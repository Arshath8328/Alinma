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
 * Provides the local service utility for QuotationCovers. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.QuotationCoversLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationCoversLocalService
 * @generated
 */
public class QuotationCoversLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.QuotationCoversLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quotation covers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationCovers the quotation covers
	 * @return the quotation covers that was added
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
		addQuotationCovers(
			com.ejada.atmc.acl.db.model.QuotationCovers quotationCovers) {

		return getService().addQuotationCovers(quotationCovers);
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
	 * Creates a new quotation covers with the primary key. Does not add the quotation covers to the database.
	 *
	 * @param quotationCoversPK the primary key for the new quotation covers
	 * @return the new quotation covers
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
		createQuotationCovers(
			com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
				quotationCoversPK) {

		return getService().createQuotationCovers(quotationCoversPK);
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
	 * Deletes the quotation covers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationCovers the quotation covers
	 * @return the quotation covers that was removed
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
		deleteQuotationCovers(
			com.ejada.atmc.acl.db.model.QuotationCovers quotationCovers) {

		return getService().deleteQuotationCovers(quotationCovers);
	}

	/**
	 * Deletes the quotation covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers that was removed
	 * @throws PortalException if a quotation covers with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
			deleteQuotationCovers(
				com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
					quotationCoversPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuotationCovers(quotationCoversPK);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationCoversModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationCoversModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.QuotationCovers
		fetchQuotationCovers(
			com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
				quotationCoversPK) {

		return getService().fetchQuotationCovers(quotationCoversPK);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationCovers>
		findByQuotationId(long quotationId) {

		return getService().findByQuotationId(quotationId);
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
	 * Returns the quotation covers with the primary key.
	 *
	 * @param quotationCoversPK the primary key of the quotation covers
	 * @return the quotation covers
	 * @throws PortalException if a quotation covers with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
			getQuotationCovers(
				com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK
					quotationCoversPK)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationCovers(quotationCoversPK);
	}

	/**
	 * Returns a range of all the quotation coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation coverses
	 * @param end the upper bound of the range of quotation coverses (not inclusive)
	 * @return the range of quotation coverses
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationCovers>
		getQuotationCoverses(int start, int end) {

		return getService().getQuotationCoverses(start, end);
	}

	/**
	 * Returns the number of quotation coverses.
	 *
	 * @return the number of quotation coverses
	 */
	public static int getQuotationCoversesCount() {
		return getService().getQuotationCoversesCount();
	}

	/**
	 * Updates the quotation covers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationCoversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationCovers the quotation covers
	 * @return the quotation covers that was updated
	 */
	public static com.ejada.atmc.acl.db.model.QuotationCovers
		updateQuotationCovers(
			com.ejada.atmc.acl.db.model.QuotationCovers quotationCovers) {

		return getService().updateQuotationCovers(quotationCovers);
	}

	public static QuotationCoversLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationCoversLocalService, QuotationCoversLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationCoversLocalService.class);

		ServiceTracker<QuotationCoversLocalService, QuotationCoversLocalService>
			serviceTracker =
				new ServiceTracker
					<QuotationCoversLocalService, QuotationCoversLocalService>(
						bundle.getBundleContext(),
						QuotationCoversLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}