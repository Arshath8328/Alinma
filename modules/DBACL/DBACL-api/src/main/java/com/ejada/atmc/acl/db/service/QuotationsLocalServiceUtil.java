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
 * Provides the local service utility for Quotations. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.QuotationsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsLocalService
 * @generated
 */
public class QuotationsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.QuotationsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quotations to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotations the quotations
	 * @return the quotations that was added
	 */
	public static com.ejada.atmc.acl.db.model.Quotations addQuotations(
		com.ejada.atmc.acl.db.model.Quotations quotations) {

		return getService().addQuotations(quotations);
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
	 * Creates a new quotations with the primary key. Does not add the quotations to the database.
	 *
	 * @param quotationId the primary key for the new quotations
	 * @return the new quotations
	 */
	public static com.ejada.atmc.acl.db.model.Quotations createQuotations(
		long quotationId) {

		return getService().createQuotations(quotationId);
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
	 * Deletes the quotations with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations that was removed
	 * @throws PortalException if a quotations with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.Quotations deleteQuotations(
			long quotationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuotations(quotationId);
	}

	/**
	 * Deletes the quotations from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotations the quotations
	 * @return the quotations that was removed
	 */
	public static com.ejada.atmc.acl.db.model.Quotations deleteQuotations(
		com.ejada.atmc.acl.db.model.Quotations quotations) {

		return getService().deleteQuotations(quotations);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.Quotations fetchQuotations(
		long quotationId) {

		return getService().fetchQuotations(quotationId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
			findByinsuredMobile(long insuredMobile)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getService().findByinsuredMobile(insuredMobile);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
		findByIqamaId(long iqamaId) {

		return getService().findByIqamaId(iqamaId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
		findByIqamaIdAndStatus(long iqamaId, String[] status) {

		return getService().findByIqamaIdAndStatus(iqamaId, status);
	}

	public static com.ejada.atmc.acl.db.model.Quotations findByPolicyNo(
			String policyNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getService().findByPolicyNo(policyNo);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
			findByQuotationId(long quotationIdId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getService().findByQuotationId(quotationIdId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
			findByQuoteStatus(String quoteStatus)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getService().findByQuoteStatus(quoteStatus);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
			findByReferenceNo(String referenceNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsException {

		return getService().findByReferenceNo(referenceNo);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
		getDateExpiredQuots(java.util.Date expiryDate, String[] status) {

		return getService().getDateExpiredQuots(expiryDate, status);
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

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
			getPendingPayment(
				java.util.Date expiryDate, String quoteStatus, boolean smsFlag)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPendingPayment(expiryDate, quoteStatus, smsFlag);
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
	 * Returns the quotations with the primary key.
	 *
	 * @param quotationId the primary key of the quotations
	 * @return the quotations
	 * @throws PortalException if a quotations with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.Quotations getQuotations(
			long quotationId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotations(quotationId);
	}

	/**
	 * Returns a range of all the quotationses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotationses
	 * @param end the upper bound of the range of quotationses (not inclusive)
	 * @return the range of quotationses
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations>
		getQuotationses(int start, int end) {

		return getService().getQuotationses(start, end);
	}

	/**
	 * Returns the number of quotationses.
	 *
	 * @return the number of quotationses
	 */
	public static int getQuotationsesCount() {
		return getService().getQuotationsesCount();
	}

	/**
	 * Updates the quotations in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotations the quotations
	 * @return the quotations that was updated
	 */
	public static com.ejada.atmc.acl.db.model.Quotations updateQuotations(
		com.ejada.atmc.acl.db.model.Quotations quotations) {

		return getService().updateQuotations(quotations);
	}

	public static QuotationsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsLocalService, QuotationsLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuotationsLocalService.class);

		ServiceTracker<QuotationsLocalService, QuotationsLocalService>
			serviceTracker =
				new ServiceTracker
					<QuotationsLocalService, QuotationsLocalService>(
						bundle.getBundleContext(), QuotationsLocalService.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}