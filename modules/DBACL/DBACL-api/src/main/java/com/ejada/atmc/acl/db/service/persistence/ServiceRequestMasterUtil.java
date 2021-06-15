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

import com.ejada.atmc.acl.db.model.ServiceRequestMaster;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * The persistence utility for the service request master service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.ServiceRequestMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMasterPersistence
 * @generated
 */
public class ServiceRequestMasterUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(ServiceRequestMaster serviceRequestMaster) {
		getPersistence().clearCache(serviceRequestMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#fetchByPrimaryKeys(Set)
	 */
	public static Map<Serializable, ServiceRequestMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<ServiceRequestMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ServiceRequestMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ServiceRequestMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static ServiceRequestMaster update(
		ServiceRequestMaster serviceRequestMaster) {

		return getPersistence().update(serviceRequestMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static ServiceRequestMaster update(
		ServiceRequestMaster serviceRequestMaster,
		ServiceContext serviceContext) {

		return getPersistence().update(serviceRequestMaster, serviceContext);
	}

	/**
	 * Returns all the service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the matching service request masters
	 */
	public static List<ServiceRequestMaster> findByiqamaId(String IQAMA_ID) {
		return getPersistence().findByiqamaId(IQAMA_ID);
	}

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
	public static List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end) {

		return getPersistence().findByiqamaId(IQAMA_ID, start, end);
	}

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
	public static List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().findByiqamaId(
			IQAMA_ID, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMaster> findByiqamaId(
		String IQAMA_ID, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByiqamaId(
			IQAMA_ID, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByiqamaId_First(
			String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByiqamaId_First(
			IQAMA_ID, orderByComparator);
	}

	/**
	 * Returns the first service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByiqamaId_First(
		String IQAMA_ID,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByiqamaId_First(
			IQAMA_ID, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByiqamaId_Last(
			String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByiqamaId_Last(IQAMA_ID, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByiqamaId_Last(
		String IQAMA_ID,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByiqamaId_Last(
			IQAMA_ID, orderByComparator);
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where IQAMA_ID = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param IQAMA_ID the iqama_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster[] findByiqamaId_PrevAndNext(
			String REFERENCE_NO, String IQAMA_ID,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByiqamaId_PrevAndNext(
			REFERENCE_NO, IQAMA_ID, orderByComparator);
	}

	/**
	 * Removes all the service request masters where IQAMA_ID = &#63; from the database.
	 *
	 * @param IQAMA_ID the iqama_id
	 */
	public static void removeByiqamaId(String IQAMA_ID) {
		getPersistence().removeByiqamaId(IQAMA_ID);
	}

	/**
	 * Returns the number of service request masters where IQAMA_ID = &#63;.
	 *
	 * @param IQAMA_ID the iqama_id
	 * @return the number of matching service request masters
	 */
	public static int countByiqamaId(String IQAMA_ID) {
		return getPersistence().countByiqamaId(IQAMA_ID);
	}

	/**
	 * Returns all the service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the matching service request masters
	 */
	public static List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG) {

		return getPersistence().findByescalationFlag(ESCALATION_FLAG);
	}

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
	public static List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end) {

		return getPersistence().findByescalationFlag(
			ESCALATION_FLAG, start, end);
	}

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
	public static List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().findByescalationFlag(
			ESCALATION_FLAG, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMaster> findByescalationFlag(
		boolean ESCALATION_FLAG, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByescalationFlag(
			ESCALATION_FLAG, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByescalationFlag_First(
			boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByescalationFlag_First(
			ESCALATION_FLAG, orderByComparator);
	}

	/**
	 * Returns the first service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByescalationFlag_First(
		boolean ESCALATION_FLAG,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByescalationFlag_First(
			ESCALATION_FLAG, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByescalationFlag_Last(
			boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByescalationFlag_Last(
			ESCALATION_FLAG, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByescalationFlag_Last(
		boolean ESCALATION_FLAG,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByescalationFlag_Last(
			ESCALATION_FLAG, orderByComparator);
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where ESCALATION_FLAG = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param ESCALATION_FLAG the escalation_flag
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster[] findByescalationFlag_PrevAndNext(
			String REFERENCE_NO, boolean ESCALATION_FLAG,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByescalationFlag_PrevAndNext(
			REFERENCE_NO, ESCALATION_FLAG, orderByComparator);
	}

	/**
	 * Removes all the service request masters where ESCALATION_FLAG = &#63; from the database.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 */
	public static void removeByescalationFlag(boolean ESCALATION_FLAG) {
		getPersistence().removeByescalationFlag(ESCALATION_FLAG);
	}

	/**
	 * Returns the number of service request masters where ESCALATION_FLAG = &#63;.
	 *
	 * @param ESCALATION_FLAG the escalation_flag
	 * @return the number of matching service request masters
	 */
	public static int countByescalationFlag(boolean ESCALATION_FLAG) {
		return getPersistence().countByescalationFlag(ESCALATION_FLAG);
	}

	/**
	 * Returns all the service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the matching service request masters
	 */
	public static List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS) {

		return getPersistence().findByreqStatus(REQUEST_STATUS);
	}

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
	public static List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end) {

		return getPersistence().findByreqStatus(REQUEST_STATUS, start, end);
	}

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
	public static List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().findByreqStatus(
			REQUEST_STATUS, start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMaster> findByreqStatus(
		String REQUEST_STATUS, int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByreqStatus(
			REQUEST_STATUS, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByreqStatus_First(
			String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByreqStatus_First(
			REQUEST_STATUS, orderByComparator);
	}

	/**
	 * Returns the first service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByreqStatus_First(
		String REQUEST_STATUS,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByreqStatus_First(
			REQUEST_STATUS, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master
	 * @throws NoSuchServiceRequestMasterException if a matching service request master could not be found
	 */
	public static ServiceRequestMaster findByreqStatus_Last(
			String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByreqStatus_Last(
			REQUEST_STATUS, orderByComparator);
	}

	/**
	 * Returns the last service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request master, or <code>null</code> if a matching service request master could not be found
	 */
	public static ServiceRequestMaster fetchByreqStatus_Last(
		String REQUEST_STATUS,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().fetchByreqStatus_Last(
			REQUEST_STATUS, orderByComparator);
	}

	/**
	 * Returns the service request masters before and after the current service request master in the ordered set where REQUEST_STATUS = &#63;.
	 *
	 * @param REFERENCE_NO the primary key of the current service request master
	 * @param REQUEST_STATUS the request_status
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster[] findByreqStatus_PrevAndNext(
			String REFERENCE_NO, String REQUEST_STATUS,
			OrderByComparator<ServiceRequestMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByreqStatus_PrevAndNext(
			REFERENCE_NO, REQUEST_STATUS, orderByComparator);
	}

	/**
	 * Removes all the service request masters where REQUEST_STATUS = &#63; from the database.
	 *
	 * @param REQUEST_STATUS the request_status
	 */
	public static void removeByreqStatus(String REQUEST_STATUS) {
		getPersistence().removeByreqStatus(REQUEST_STATUS);
	}

	/**
	 * Returns the number of service request masters where REQUEST_STATUS = &#63;.
	 *
	 * @param REQUEST_STATUS the request_status
	 * @return the number of matching service request masters
	 */
	public static int countByreqStatus(String REQUEST_STATUS) {
		return getPersistence().countByreqStatus(REQUEST_STATUS);
	}

	/**
	 * Caches the service request master in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMaster the service request master
	 */
	public static void cacheResult(ServiceRequestMaster serviceRequestMaster) {
		getPersistence().cacheResult(serviceRequestMaster);
	}

	/**
	 * Caches the service request masters in the entity cache if it is enabled.
	 *
	 * @param serviceRequestMasters the service request masters
	 */
	public static void cacheResult(
		List<ServiceRequestMaster> serviceRequestMasters) {

		getPersistence().cacheResult(serviceRequestMasters);
	}

	/**
	 * Creates a new service request master with the primary key. Does not add the service request master to the database.
	 *
	 * @param REFERENCE_NO the primary key for the new service request master
	 * @return the new service request master
	 */
	public static ServiceRequestMaster create(String REFERENCE_NO) {
		return getPersistence().create(REFERENCE_NO);
	}

	/**
	 * Removes the service request master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master that was removed
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster remove(String REFERENCE_NO)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().remove(REFERENCE_NO);
	}

	public static ServiceRequestMaster updateImpl(
		ServiceRequestMaster serviceRequestMaster) {

		return getPersistence().updateImpl(serviceRequestMaster);
	}

	/**
	 * Returns the service request master with the primary key or throws a <code>NoSuchServiceRequestMasterException</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master
	 * @throws NoSuchServiceRequestMasterException if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster findByPrimaryKey(String REFERENCE_NO)
		throws com.ejada.atmc.acl.db.exception.
			NoSuchServiceRequestMasterException {

		return getPersistence().findByPrimaryKey(REFERENCE_NO);
	}

	/**
	 * Returns the service request master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param REFERENCE_NO the primary key of the service request master
	 * @return the service request master, or <code>null</code> if a service request master with the primary key could not be found
	 */
	public static ServiceRequestMaster fetchByPrimaryKey(String REFERENCE_NO) {
		return getPersistence().fetchByPrimaryKey(REFERENCE_NO);
	}

	/**
	 * Returns all the service request masters.
	 *
	 * @return the service request masters
	 */
	public static List<ServiceRequestMaster> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<ServiceRequestMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<ServiceRequestMaster> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<ServiceRequestMaster> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the service request masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of service request masters.
	 *
	 * @return the number of service request masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static ServiceRequestMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<ServiceRequestMasterPersistence, ServiceRequestMasterPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			ServiceRequestMasterPersistence.class);

		ServiceTracker
			<ServiceRequestMasterPersistence, ServiceRequestMasterPersistence>
				serviceTracker =
					new ServiceTracker
						<ServiceRequestMasterPersistence,
						 ServiceRequestMasterPersistence>(
							 bundle.getBundleContext(),
							 ServiceRequestMasterPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}