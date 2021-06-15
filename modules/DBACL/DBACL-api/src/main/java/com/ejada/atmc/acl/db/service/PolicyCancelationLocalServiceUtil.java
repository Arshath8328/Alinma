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
 * Provides the local service utility for PolicyCancelation. This utility wraps
 * <code>com.ejada.atmc.acl.db.service.impl.PolicyCancelationLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyCancelationLocalService
 * @generated
 */
public class PolicyCancelationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyCancelationLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * Adds the policy cancelation to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was added
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
		addPolicyCancelation(
			com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return getService().addPolicyCancelation(policyCancelation);
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
	 * Creates a new policy cancelation with the primary key. Does not add the policy cancelation to the database.
	 *
	 * @param Id the primary key for the new policy cancelation
	 * @return the new policy cancelation
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
		createPolicyCancelation(String Id) {

		return getService().createPolicyCancelation(Id);
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
	 * Deletes the policy cancelation from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was removed
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
		deletePolicyCancelation(
			com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return getService().deletePolicyCancelation(policyCancelation);
	}

	/**
	 * Deletes the policy cancelation with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation that was removed
	 * @throws PortalException if a policy cancelation with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
			deletePolicyCancelation(String Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().deletePolicyCancelation(Id);
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
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

	public static com.ejada.atmc.acl.db.model.PolicyCancelation
		fetchPolicyCancelation(String Id) {

		return getService().fetchPolicyCancelation(Id);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
			findByInsuredId(String id)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().findByInsuredId(id);
	}

	public static com.ejada.atmc.acl.db.model.PolicyCancelation findByPolicyNum(
			String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().findByPolicyNum(policyNumber);
	}

	public static byte[] findIbanFile(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().findIbanFile(policyNumber);
	}

	public static byte[] findValidFile(String policyNumber)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().findValidFile(policyNumber);
	}

	public static
		com.ejada.atmc.acl.db.model.PolicyCancelationIbanImageBlobModel
			getIbanImageBlobModel(java.io.Serializable primaryKey) {

		return getService().getIbanImageBlobModel(primaryKey);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static
		com.ejada.atmc.acl.db.model.PolicyCancelationOtherFileBlobModel
			getOtherFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getOtherFileBlobModel(primaryKey);
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
	 * Returns the policy cancelation with the primary key.
	 *
	 * @param Id the primary key of the policy cancelation
	 * @return the policy cancelation
	 * @throws PortalException if a policy cancelation with the primary key could not be found
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
			getPolicyCancelation(String Id)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getPolicyCancelation(Id);
	}

	/**
	 * Returns a range of all the policy cancelations.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyCancelationModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy cancelations
	 * @param end the upper bound of the range of policy cancelations (not inclusive)
	 * @return the range of policy cancelations
	 */
	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
		getPolicyCancelations(int start, int end) {

		return getService().getPolicyCancelations(start, end);
	}

	/**
	 * Returns the number of policy cancelations.
	 *
	 * @return the number of policy cancelations
	 */
	public static int getPolicyCancelationsCount() {
		return getService().getPolicyCancelationsCount();
	}

	public static
		com.ejada.atmc.acl.db.model.PolicyCancelationValidFileBlobModel
			getValidFileBlobModel(java.io.Serializable primaryKey) {

		return getService().getValidFileBlobModel(primaryKey);
	}

	public static java.io.InputStream openIbanImageInputStream(long Id) {
		return getService().openIbanImageInputStream(Id);
	}

	public static java.io.InputStream openOtherFileInputStream(long Id) {
		return getService().openOtherFileInputStream(Id);
	}

	public static java.io.InputStream openValidFileInputStream(long Id) {
		return getService().openValidFileInputStream(Id);
	}

	public static com.ejada.atmc.acl.db.model.PolicyCancelation status(
			String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().status(status);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.PolicyCancelation>
			statusAll(String status)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchPolicyCancelationException {

		return getService().statusAll(status);
	}

	/**
	 * Updates the policy cancelation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyCancelationLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyCancelation the policy cancelation
	 * @return the policy cancelation that was updated
	 */
	public static com.ejada.atmc.acl.db.model.PolicyCancelation
		updatePolicyCancelation(
			com.ejada.atmc.acl.db.model.PolicyCancelation policyCancelation) {

		return getService().updatePolicyCancelation(policyCancelation);
	}

	public static PolicyCancelationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<PolicyCancelationLocalService, PolicyCancelationLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			PolicyCancelationLocalService.class);

		ServiceTracker
			<PolicyCancelationLocalService, PolicyCancelationLocalService>
				serviceTracker =
					new ServiceTracker
						<PolicyCancelationLocalService,
						 PolicyCancelationLocalService>(
							 bundle.getBundleContext(),
							 PolicyCancelationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}