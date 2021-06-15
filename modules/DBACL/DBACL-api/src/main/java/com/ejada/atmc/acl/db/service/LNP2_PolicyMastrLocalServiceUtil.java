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
 * Provides the local service utility for LNP2_PolicyMastr. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.LNP2_PolicyMastrLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrLocalService
 * @generated
 */
public class LNP2_PolicyMastrLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.LNP2_PolicyMastrLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the lnp2_ policy mastr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was added
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
		addLNP2_PolicyMastr(
			com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return getService().addLNP2_PolicyMastr(lnp2_PolicyMastr);
	}

	/**
	 * Creates a new lnp2_ policy mastr with the primary key. Does not add the lnp2_ policy mastr to the database.
	 *
	 * @param np1_proposal the primary key for the new lnp2_ policy mastr
	 * @return the new lnp2_ policy mastr
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
		createLNP2_PolicyMastr(String np1_proposal) {

		return getService().createLNP2_PolicyMastr(np1_proposal);
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
	 * Deletes the lnp2_ policy mastr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
		deleteLNP2_PolicyMastr(
			com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return getService().deleteLNP2_PolicyMastr(lnp2_PolicyMastr);
	}

	/**
	 * Deletes the lnp2_ policy mastr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 * @throws PortalException if a lnp2_ policy mastr with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
			deleteLNP2_PolicyMastr(String np1_proposal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteLNP2_PolicyMastr(np1_proposal);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
		fetchLNP2_PolicyMastr(String np1_proposal) {

		return getService().fetchLNP2_PolicyMastr(np1_proposal);
	}

	public static java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			findAllPSPolicy()
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findAllPSPolicy();
	}

	public static java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			findAllPSPolicyByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findAllPSPolicyByIqamaId(iqamaId);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.custom.model.PSBeneficiaryDetail>
				findPSPolicyBeneficiaryDetailsById(String id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyBeneficiaryDetailsById(id);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.custom.model.PSCoverageDetail>
				findPSPolicyCoverageDetailsById(String id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyCoverageDetailsById(id);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.custom.model.PSPolicyDetail>
				findPSPolicyDetailsById(String id, String toDate)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyDetailsById(id, toDate);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.custom.model.PSFundDetail>
				findPSPolicyFundDetailsById(String id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyFundDetailsById(id);
	}

	public static java.util.List
		<com.ejada.atmc.acl.db.custom.model.PSPremiumDetail>
				findPSPolicyPremiumDetailsById(String id)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyPremiumDetailsById(id);
	}

	public static java.util.List<com.ejada.atmc.acl.db.custom.model.SOADetail>
			findPSPolicyStatementDetailsById(
				String id, String fromDate, String toDate)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPSPolicyStatementDetailsById(
			id, fromDate, toDate);
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr
	 * @throws PortalException if a lnp2_ policy mastr with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
			getLNP2_PolicyMastr(String np1_proposal)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getLNP2_PolicyMastr(np1_proposal);
	}

	/**
	 * Returns a range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @return the range of lnp2_ policy mastrs
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.LNP2_PolicyMastr>
		getLNP2_PolicyMastrs(int start, int end) {

		return getService().getLNP2_PolicyMastrs(start, end);
	}

	/**
	 * Returns the number of lnp2_ policy mastrs.
	 *
	 * @return the number of lnp2_ policy mastrs
	 */
	public static int getLNP2_PolicyMastrsCount() {
		return getService().getLNP2_PolicyMastrsCount();
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

	public static java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			searchPSPolicyByIqamaId(String keyword)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().searchPSPolicyByIqamaId(keyword);
	}

	/**
	 * Updates the lnp2_ policy mastr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect LNP2_PolicyMastrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was updated
	 */
	public static com.ejada.atmc.acl.db.model.LNP2_PolicyMastr
		updateLNP2_PolicyMastr(
			com.ejada.atmc.acl.db.model.LNP2_PolicyMastr lnp2_PolicyMastr) {

		return getService().updateLNP2_PolicyMastr(lnp2_PolicyMastr);
	}

	public static LNP2_PolicyMastrLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<LNP2_PolicyMastrLocalService, LNP2_PolicyMastrLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			LNP2_PolicyMastrLocalService.class);

		ServiceTracker
			<LNP2_PolicyMastrLocalService, LNP2_PolicyMastrLocalService>
				serviceTracker =
					new ServiceTracker
						<LNP2_PolicyMastrLocalService,
						 LNP2_PolicyMastrLocalService>(
							 bundle.getBundleContext(),
							 LNP2_PolicyMastrLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}