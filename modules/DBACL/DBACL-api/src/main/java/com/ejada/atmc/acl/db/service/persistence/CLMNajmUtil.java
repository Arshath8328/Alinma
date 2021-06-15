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

import com.ejada.atmc.acl.db.model.CLMNajm;

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
 * The persistence utility for the clm najm service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CLMNajmPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmPersistence
 * @generated
 */
public class CLMNajmUtil {

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
	public static void clearCache(CLMNajm clmNajm) {
		getPersistence().clearCache(clmNajm);
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
	public static Map<Serializable, CLMNajm> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CLMNajm> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CLMNajm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CLMNajm> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CLMNajm update(CLMNajm clmNajm) {
		return getPersistence().update(clmNajm);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CLMNajm update(
		CLMNajm clmNajm, ServiceContext serviceContext) {

		return getPersistence().update(clmNajm, serviceContext);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByCASE_PLATE(String caseNo, String najmPlateNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCASE_PLATE(caseNo, najmPlateNo);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_PLATE(String caseNo, String najmPlateNo) {
		return getPersistence().fetchByCASE_PLATE(caseNo, najmPlateNo);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_PLATE(
		String caseNo, String najmPlateNo, boolean useFinderCache) {

		return getPersistence().fetchByCASE_PLATE(
			caseNo, najmPlateNo, useFinderCache);
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and najmPlateNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the clm najm that was removed
	 */
	public static CLMNajm removeByCASE_PLATE(String caseNo, String najmPlateNo)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().removeByCASE_PLATE(caseNo, najmPlateNo);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and najmPlateNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	public static int countByCASE_PLATE(String caseNo, String najmPlateNo) {
		return getPersistence().countByCASE_PLATE(caseNo, najmPlateNo);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByCASE_CUSTOM(String caseNo, String customId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCASE_CUSTOM(caseNo, customId);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_CUSTOM(String caseNo, String customId) {
		return getPersistence().fetchByCASE_CUSTOM(caseNo, customId);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_CUSTOM(
		String caseNo, String customId, boolean useFinderCache) {

		return getPersistence().fetchByCASE_CUSTOM(
			caseNo, customId, useFinderCache);
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and customId = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the clm najm that was removed
	 */
	public static CLMNajm removeByCASE_CUSTOM(String caseNo, String customId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().removeByCASE_CUSTOM(caseNo, customId);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and customId = &#63;.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	public static int countByCASE_CUSTOM(String caseNo, String customId) {
		return getPersistence().countByCASE_CUSTOM(caseNo, customId);
	}

	/**
	 * Returns all the clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najms
	 */
	public static List<CLMNajm> findByNajmPlateNo(String najmPlateNo) {
		return getPersistence().findByNajmPlateNo(najmPlateNo);
	}

	/**
	 * Returns a range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	public static List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end) {

		return getPersistence().findByNajmPlateNo(najmPlateNo, start, end);
	}

	/**
	 * Returns an ordered range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().findByNajmPlateNo(
			najmPlateNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clm najms where najmPlateNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param najmPlateNo the najm plate no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByNajmPlateNo(
			najmPlateNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByNajmPlateNo_First(
			String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByNajmPlateNo_First(
			najmPlateNo, orderByComparator);
	}

	/**
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByNajmPlateNo_First(
		String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchByNajmPlateNo_First(
			najmPlateNo, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByNajmPlateNo_Last(
			String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByNajmPlateNo_Last(
			najmPlateNo, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByNajmPlateNo_Last(
		String najmPlateNo, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchByNajmPlateNo_Last(
			najmPlateNo, orderByComparator);
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public static CLMNajm[] findByNajmPlateNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String najmPlateNo,
			OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByNajmPlateNo_PrevAndNext(
			clmNajmPK, najmPlateNo, orderByComparator);
	}

	/**
	 * Removes all the clm najms where najmPlateNo = &#63; from the database.
	 *
	 * @param najmPlateNo the najm plate no
	 */
	public static void removeByNajmPlateNo(String najmPlateNo) {
		getPersistence().removeByNajmPlateNo(najmPlateNo);
	}

	/**
	 * Returns the number of clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	public static int countByNajmPlateNo(String najmPlateNo) {
		return getPersistence().countByNajmPlateNo(najmPlateNo);
	}

	/**
	 * Returns all the clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the matching clm najms
	 */
	public static List<CLMNajm> findByCustomId(String customId) {
		return getPersistence().findByCustomId(customId);
	}

	/**
	 * Returns a range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	public static List<CLMNajm> findByCustomId(
		String customId, int start, int end) {

		return getPersistence().findByCustomId(customId, start, end);
	}

	/**
	 * Returns an ordered range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().findByCustomId(
			customId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clm najms where customId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param customId the custom ID
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		return getPersistence().findByCustomId(
			customId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByCustomId_First(
			String customId, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCustomId_First(
			customId, orderByComparator);
	}

	/**
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCustomId_First(
		String customId, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchByCustomId_First(
			customId, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByCustomId_Last(
			String customId, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCustomId_Last(
			customId, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCustomId_Last(
		String customId, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchByCustomId_Last(
			customId, orderByComparator);
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where customId = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public static CLMNajm[] findByCustomId_PrevAndNext(
			CLMNajmPK clmNajmPK, String customId,
			OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCustomId_PrevAndNext(
			clmNajmPK, customId, orderByComparator);
	}

	/**
	 * Removes all the clm najms where customId = &#63; from the database.
	 *
	 * @param customId the custom ID
	 */
	public static void removeByCustomId(String customId) {
		getPersistence().removeByCustomId(customId);
	}

	/**
	 * Returns the number of clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	public static int countByCustomId(String customId) {
		return getPersistence().countByCustomId(customId);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findByCASE_NAMEEN(String caseNo, String englishName)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByCASE_NAMEEN(caseNo, englishName);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_NAMEEN(
		String caseNo, String englishName) {

		return getPersistence().fetchByCASE_NAMEEN(caseNo, englishName);
	}

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchByCASE_NAMEEN(
		String caseNo, String englishName, boolean useFinderCache) {

		return getPersistence().fetchByCASE_NAMEEN(
			caseNo, englishName, useFinderCache);
	}

	/**
	 * Removes the clm najm where caseNo = &#63; and englishName = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the clm najm that was removed
	 */
	public static CLMNajm removeByCASE_NAMEEN(String caseNo, String englishName)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().removeByCASE_NAMEEN(caseNo, englishName);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63; and englishName = &#63;.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the number of matching clm najms
	 */
	public static int countByCASE_NAMEEN(String caseNo, String englishName) {
		return getPersistence().countByCASE_NAMEEN(caseNo, englishName);
	}

	/**
	 * Returns all the clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the matching clm najms
	 */
	public static List<CLMNajm> findBycaseNo(String caseNo) {
		return getPersistence().findBycaseNo(caseNo);
	}

	/**
	 * Returns a range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of matching clm najms
	 */
	public static List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end) {

		return getPersistence().findBycaseNo(caseNo, start, end);
	}

	/**
	 * Returns an ordered range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().findBycaseNo(
			caseNo, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clm najms where caseNo = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param caseNo the case no
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching clm najms
	 */
	public static List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		OrderByComparator<CLMNajm> orderByComparator, boolean useFinderCache) {

		return getPersistence().findBycaseNo(
			caseNo, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findBycaseNo_First(
			String caseNo, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findBycaseNo_First(caseNo, orderByComparator);
	}

	/**
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchBycaseNo_First(
		String caseNo, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchBycaseNo_First(caseNo, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public static CLMNajm findBycaseNo_Last(
			String caseNo, OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findBycaseNo_Last(caseNo, orderByComparator);
	}

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public static CLMNajm fetchBycaseNo_Last(
		String caseNo, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().fetchBycaseNo_Last(caseNo, orderByComparator);
	}

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public static CLMNajm[] findBycaseNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String caseNo,
			OrderByComparator<CLMNajm> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findBycaseNo_PrevAndNext(
			clmNajmPK, caseNo, orderByComparator);
	}

	/**
	 * Removes all the clm najms where caseNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 */
	public static void removeBycaseNo(String caseNo) {
		getPersistence().removeBycaseNo(caseNo);
	}

	/**
	 * Returns the number of clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the number of matching clm najms
	 */
	public static int countBycaseNo(String caseNo) {
		return getPersistence().countBycaseNo(caseNo);
	}

	/**
	 * Caches the clm najm in the entity cache if it is enabled.
	 *
	 * @param clmNajm the clm najm
	 */
	public static void cacheResult(CLMNajm clmNajm) {
		getPersistence().cacheResult(clmNajm);
	}

	/**
	 * Caches the clm najms in the entity cache if it is enabled.
	 *
	 * @param clmNajms the clm najms
	 */
	public static void cacheResult(List<CLMNajm> clmNajms) {
		getPersistence().cacheResult(clmNajms);
	}

	/**
	 * Creates a new clm najm with the primary key. Does not add the clm najm to the database.
	 *
	 * @param clmNajmPK the primary key for the new clm najm
	 * @return the new clm najm
	 */
	public static CLMNajm create(CLMNajmPK clmNajmPK) {
		return getPersistence().create(clmNajmPK);
	}

	/**
	 * Removes the clm najm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm that was removed
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public static CLMNajm remove(CLMNajmPK clmNajmPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().remove(clmNajmPK);
	}

	public static CLMNajm updateImpl(CLMNajm clmNajm) {
		return getPersistence().updateImpl(clmNajm);
	}

	/**
	 * Returns the clm najm with the primary key or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public static CLMNajm findByPrimaryKey(CLMNajmPK clmNajmPK)
		throws com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException {

		return getPersistence().findByPrimaryKey(clmNajmPK);
	}

	/**
	 * Returns the clm najm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm, or <code>null</code> if a clm najm with the primary key could not be found
	 */
	public static CLMNajm fetchByPrimaryKey(CLMNajmPK clmNajmPK) {
		return getPersistence().fetchByPrimaryKey(clmNajmPK);
	}

	/**
	 * Returns all the clm najms.
	 *
	 * @return the clm najms
	 */
	public static List<CLMNajm> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @return the range of clm najms
	 */
	public static List<CLMNajm> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clm najms
	 */
	public static List<CLMNajm> findAll(
		int start, int end, OrderByComparator<CLMNajm> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the clm najms.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMNajmModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clm najms
	 * @param end the upper bound of the range of clm najms (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clm najms
	 */
	public static List<CLMNajm> findAll(
		int start, int end, OrderByComparator<CLMNajm> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the clm najms from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of clm najms.
	 *
	 * @return the number of clm najms
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static Set<String> getCompoundPKColumnNames() {
		return getPersistence().getCompoundPKColumnNames();
	}

	public static CLMNajmPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CLMNajmPersistence, CLMNajmPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CLMNajmPersistence.class);

		ServiceTracker<CLMNajmPersistence, CLMNajmPersistence> serviceTracker =
			new ServiceTracker<CLMNajmPersistence, CLMNajmPersistence>(
				bundle.getBundleContext(), CLMNajmPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}