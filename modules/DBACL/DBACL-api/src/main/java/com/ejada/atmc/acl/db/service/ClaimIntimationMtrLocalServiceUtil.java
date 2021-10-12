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
 * Provides the local service utility for ClaimIntimationMtr. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.ClaimIntimationMtrLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimIntimationMtrLocalService
 * @generated
 */
public class ClaimIntimationMtrLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ClaimIntimationMtrLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the claim intimation mtr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimIntimationMtrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 * @return the claim intimation mtr that was added
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
		addClaimIntimationMtr(
			com.ejada.atmc.acl.db.model.ClaimIntimationMtr claimIntimationMtr) {

		return getService().addClaimIntimationMtr(claimIntimationMtr);
	}

	/**
	 * Creates a new claim intimation mtr with the primary key. Does not add the claim intimation mtr to the database.
	 *
	 * @param claimIntimationMotorId the primary key for the new claim intimation mtr
	 * @return the new claim intimation mtr
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
		createClaimIntimationMtr(long claimIntimationMotorId) {

		return getService().createClaimIntimationMtr(claimIntimationMotorId);
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
	 * Deletes the claim intimation mtr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimIntimationMtrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
		deleteClaimIntimationMtr(
			com.ejada.atmc.acl.db.model.ClaimIntimationMtr claimIntimationMtr) {

		return getService().deleteClaimIntimationMtr(claimIntimationMtr);
	}

	/**
	 * Deletes the claim intimation mtr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimIntimationMtrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr that was removed
	 * @throws PortalException if a claim intimation mtr with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
			deleteClaimIntimationMtr(long claimIntimationMotorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deleteClaimIntimationMtr(claimIntimationMotorId);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
		fetchClaimIntimationMtr(long claimIntimationMotorId) {

		return getService().fetchClaimIntimationMtr(claimIntimationMotorId);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.ClaimIntimationMtr>
		findClaimIntimationList(String keyword) {

		return getService().findClaimIntimationList(keyword);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery
		getActionableDynamicQuery() {

		return getService().getActionableDynamicQuery();
	}

	/**
	 * Returns the claim intimation mtr with the primary key.
	 *
	 * @param claimIntimationMotorId the primary key of the claim intimation mtr
	 * @return the claim intimation mtr
	 * @throws PortalException if a claim intimation mtr with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
			getClaimIntimationMtr(long claimIntimationMotorId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimIntimationMtr(claimIntimationMotorId);
	}

	/**
	 * Returns a range of all the claim intimation mtrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim intimation mtrs
	 * @param end the upper bound of the range of claim intimation mtrs (not inclusive)
	 * @return the range of claim intimation mtrs
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.ClaimIntimationMtr>
		getClaimIntimationMtrs(int start, int end) {

		return getService().getClaimIntimationMtrs(start, end);
	}

	/**
	 * Returns the number of claim intimation mtrs.
	 *
	 * @return the number of claim intimation mtrs
	 */
	public static int getClaimIntimationMtrsCount() {
		return getService().getClaimIntimationMtrsCount();
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

	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr intimateClaim(
		String claimantType, String policyNumber, String vehicleIdentNumber,
		String plateL1, String plateL2, String plateL3, long sequenceNumber,
		String chassisNumber, String mobileNumber, String causeOfLoss,
		java.util.Date dateOfLossOrAccident, String accidentCity,
		String accidentDescription, String sourceOfAccidentReport,
		String accidentReportNumber, String vehicleMake, String vehicleModel,
		String driverName, String driverNationality, long driverNationalId,
		java.util.Date driverDateOfBirthG, String driverGender) {

		return getService().intimateClaim(
			claimantType, policyNumber, vehicleIdentNumber, plateL1, plateL2,
			plateL3, sequenceNumber, chassisNumber, mobileNumber, causeOfLoss,
			dateOfLossOrAccident, accidentCity, accidentDescription,
			sourceOfAccidentReport, accidentReportNumber, vehicleMake,
			vehicleModel, driverName, driverNationality, driverNationalId,
			driverDateOfBirthG, driverGender);
	}

	/**
	 * Updates the claim intimation mtr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimIntimationMtrLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimIntimationMtr the claim intimation mtr
	 * @return the claim intimation mtr that was updated
	 */
	public static com.ejada.atmc.acl.db.model.ClaimIntimationMtr
		updateClaimIntimationMtr(
			com.ejada.atmc.acl.db.model.ClaimIntimationMtr claimIntimationMtr) {

		return getService().updateClaimIntimationMtr(claimIntimationMtr);
	}

	public static ClaimIntimationMtrLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ClaimIntimationMtrLocalService, ClaimIntimationMtrLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ClaimIntimationMtrLocalService.class);

		ServiceTracker
			<ClaimIntimationMtrLocalService, ClaimIntimationMtrLocalService>
				serviceTracker =
					new ServiceTracker
						<ClaimIntimationMtrLocalService,
						 ClaimIntimationMtrLocalService>(
							 bundle.getBundleContext(),
							 ClaimIntimationMtrLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}