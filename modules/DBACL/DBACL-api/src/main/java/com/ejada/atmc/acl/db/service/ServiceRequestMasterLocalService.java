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

import com.ejada.atmc.acl.db.model.ServiceRequestMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ServiceRequestMaster. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMasterLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ServiceRequestMasterLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ServiceRequestMasterLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the service request master local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ServiceRequestMasterLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the service request master to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMaster the service request master
	 * @return the service request master that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ServiceRequestMaster addServiceRequestMaster(
		ServiceRequestMaster serviceRequestMaster);

	public int countServiceRequestsByStatusRoleAdmin(
		String role, String[] lstStatus, String customerID,
		boolean escalationFlag);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new service request master with the primary key. Does not add the service request master to the database.
	 *
	 * @param REFERENCE_NO the primary key for the new service request master
	 * @return the new service request master
	 */
	@Transactional(enabled = false)
	public ServiceRequestMaster createServiceRequestMaster(String REFERENCE_NO);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the service request master from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMaster the service request master
	 * @return the service request master that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ServiceRequestMaster deleteServiceRequestMaster(
		ServiceRequestMaster serviceRequestMaster);

	/**
	 * Deletes the service request master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master that was removed
	 * @throws PortalException if a service request master with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ServiceRequestMaster deleteServiceRequestMaster(String REFERENCE_NO)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceRequestMaster fetchServiceRequestMaster(String REFERENCE_NO);

	public List<Object> findServiceRequestsByStatusRoleAdmin(
		String role, String[] lstStatus, String customerID,
		boolean escalationFlag, int from, int to, String orderBy,
		String orderDir);

	public List<ServiceRequestMaster> findSrvsReqsByEsclationFlag(
		String userRole, String closedStatus, boolean isAdmin);

	public List<ServiceRequestMaster> findSrvsReqsByIdStatus(
		String iqamaId, String[] lstStatus);

	public List<ServiceRequestMaster> findSrvsReqsByIqamaId(String iqamaId);

	public List<ServiceRequestMaster> findSrvsReqsByReqRoleStatus(
		String[] status, String role);

	public List<ServiceRequestMaster> findSrvsReqsByReqStatus(String[] status);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the service request master with the primary key.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master
	 * @throws PortalException if a service request master with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceRequestMaster getServiceRequestMaster(String REFERENCE_NO)
		throws PortalException;

	/**
	 * Returns a range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of service request masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ServiceRequestMaster> getServiceRequestMasters(
		int start, int end);

	/**
	 * Returns the number of service request masters.
	 *
	 * @return the number of service request masters
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getServiceRequestMastersCount();

	/**
	 * Updates the service request master in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ServiceRequestMasterLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param serviceRequestMaster the service request master
	 * @return the service request master that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ServiceRequestMaster updateServiceRequestMaster(
		ServiceRequestMaster serviceRequestMaster);

}