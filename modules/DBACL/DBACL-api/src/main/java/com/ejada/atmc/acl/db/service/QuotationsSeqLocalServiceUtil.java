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
 * Provides the local service utility for QuotationsSeq. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.QuotationsSeqLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeqLocalService
 * @generated
 */
public class QuotationsSeqLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.QuotationsSeqLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the quotations seq to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was added
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq addQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return getService().addQuotationsSeq(quotationsSeq);
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
	 * Creates a new quotations seq with the primary key. Does not add the quotations seq to the database.
	 *
	 * @param key the primary key for the new quotations seq
	 * @return the new quotations seq
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq createQuotationsSeq(
		String key) {

		return getService().createQuotationsSeq(key);
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
	 * Deletes the quotations seq from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was removed
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq deleteQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return getService().deleteQuotationsSeq(quotationsSeq);
	}

	/**
	 * Deletes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws PortalException if a quotations seq with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq deleteQuotationsSeq(
			String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteQuotationsSeq(key);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.QuotationsSeq fetchQuotationsSeq(
		String key) {

		return getService().fetchQuotationsSeq(key);
	}

	public static com.ejada.atmc.acl.db.model.QuotationsSeq findByKey(
			String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return getService().findByKey(key);
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
	 * Returns the quotations seq with the primary key.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws PortalException if a quotations seq with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq getQuotationsSeq(
			String key)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationsSeq(key);
	}

	/**
	 * Returns a range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @return the range of quotations seqs
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationsSeq>
		getQuotationsSeqs(int start, int end) {

		return getService().getQuotationsSeqs(start, end);
	}

	/**
	 * Returns the number of quotations seqs.
	 *
	 * @return the number of quotations seqs
	 */
	public static int getQuotationsSeqsCount() {
		return getService().getQuotationsSeqsCount();
	}

	/**
	 * Updates the quotations seq in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsSeqLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsSeq the quotations seq
	 * @return the quotations seq that was updated
	 */
	public static com.ejada.atmc.acl.db.model.QuotationsSeq updateQuotationsSeq(
		com.ejada.atmc.acl.db.model.QuotationsSeq quotationsSeq) {

		return getService().updateQuotationsSeq(quotationsSeq);
	}

	public static QuotationsSeqLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsSeqLocalService, QuotationsSeqLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationsSeqLocalService.class);

		ServiceTracker<QuotationsSeqLocalService, QuotationsSeqLocalService>
			serviceTracker =
				new ServiceTracker
					<QuotationsSeqLocalService, QuotationsSeqLocalService>(
						bundle.getBundleContext(),
						QuotationsSeqLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}