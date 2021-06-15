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

package com.ejada.atmc.acl.db.service.persistence;

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestMasterException;
import com.ejada.atmc.acl.db.model.ServiceRequestMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the service request master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMasterUtil
 * @generated
 */
@ProviderType
public interface ServiceRequestMasterPersistence
	extends BasePersistence<ServiceRequestMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ServiceRequestMasterUtil} to access the service request master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByiqamaId(String IQAMA_ID);

	/**
	 * Returns a range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end);

	/**
	 * Returns an ordered range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request masters where IQAMA_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByiqamaId_First(
			String IQAMA_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByiqamaId_First(
		String IQAMA_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByiqamaId_Last(
			String IQAMA_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByiqamaId_Last(
		String IQAMA_ID,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster[] findByiqamaId_PrevAndNext(
			String REFERENCE_NO, String IQAMA_ID,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Removes all the service request masters where IQAMA_ID = &#63; from the database.
	 *
	 * @param IQAMA_ID the iqama_id
	 */
	public void removeByiqamaId(String IQAMA_ID);

	/**
	 * Returns the number of service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the number of matching service request masters
	 */
	public int countByiqamaId(String IQAMA_ID);

	/**
	 * Returns all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG);

	/**
	 * Returns a range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end);

	/**
	 * Returns an ordered range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByescalationFlag_First(
			boolean ESCALATION_FLAG,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByescalationFlag_First(
		boolean ESCALATION_FLAG,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByescalationFlag_Last(
			boolean ESCALATION_FLAG,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByescalationFlag_Last(
		boolean ESCALATION_FLAG,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster[] findByescalationFlag_PrevAndNext(
			String REFERENCE_NO, boolean ESCALATION_FLAG,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Removes all the service request masters where ESCALATION_FLAG = &#63; from the database.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 */
	public void removeByescalationFlag(boolean ESCALATION_FLAG);

	/**
	 * Returns the number of service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the number of matching service request masters
	 */
	public int countByescalationFlag(boolean ESCALATION_FLAG);

	/**
	 * Returns all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS);

	/**
	 * Returns a range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end);

	/**
	 * Returns an ordered range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request masters
	 */
	public java.util.List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByreqStatus_First(
			String REQUEST_STATUS,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByreqStatus_First(
		String REQUEST_STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public ServiceRequestMaster findByreqStatus_Last(
			String REQUEST_STATUS,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public ServiceRequestMaster fetchByreqStatus_Last(
		String REQUEST_STATUS,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster[] findByreqStatus_PrevAndNext(
			String REFERENCE_NO, String REQUEST_STATUS,
			com.liferay.portal.kernel.util.OrderByComparator
				<ServiceRequestMaster> orderByComparator)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Removes all the service request masters where REQUEST_STATUS = &#63; from the database.
	 *
	 * @param REQUEST_STATUS the request_status
	 */
	public void removeByreqStatus(String REQUEST_STATUS);

	/**
	 * Returns the number of service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the number of matching service request masters
	 */
	public int countByreqStatus(String REQUEST_STATUS);

	/**
	 * Caches the service request master in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMaster the service request master
	 */
	public void cacheResult(ServiceRequestMaster serviceRequestMaster);

	/**
	 * Caches the service request masters in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMasters the service request masters
	 */
	public void cacheResult(
		java.util.List<ServiceRequestMaster> serviceRequestMasters);

	/**
	 * Creates a new service request master with the primary key. Does not add the service request master to the database.
	 *
	 * @param REFERENCE_NO the primary key for the new service request master
	 * @return the new service request master
	 */
	public ServiceRequestMaster create(String REFERENCE_NO);

	/**
	 * Removes the service request master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master that was removed
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster remove(String REFERENCE_NO)
		throws NoSuchServiceRequestMasterException;

	public ServiceRequestMaster updateImpl(
		ServiceRequestMaster serviceRequestMaster);

	/**
	 * Returns the service request master with the primary key or throws a <code>NoSuchServiceRequestMasterException</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster findByPrimaryKey(String REFERENCE_NO)
		throws NoSuchServiceRequestMasterException;

	/**
	 * Returns the service request master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master, or <code>null</code> if a service request master with the primary key could not be found
	 */
	public ServiceRequestMaster fetchByPrimaryKey(String REFERENCE_NO);

	/**
	 * Returns all the service request masters.
	 *
	 * @return the service request masters
	 */
	public java.util.List<ServiceRequestMaster> findAll();

	/**
	 * Returns a range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @return the range of service request masters
	 */
	public java.util.List<ServiceRequestMaster> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request masters
	 */
	public java.util.List<ServiceRequestMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator);

	/**
	 * Returns an ordered range of all the service request masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request masters
	 * @param end the upper bound of the range of service request masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request masters
	 */
	public java.util.List<ServiceRequestMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ServiceRequestMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the service request masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of service request masters.
	 *
	 * @return the number of service request masters
	 */
	public int countAll();

}