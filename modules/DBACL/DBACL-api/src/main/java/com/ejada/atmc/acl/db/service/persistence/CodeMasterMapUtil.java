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

import com.ejada.atmc.acl.db.model.CodeMasterMap;

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
 * The persistence utility for the code master map service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CodeMasterMapPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMapPersistence
 * @generated
 */
public class CodeMasterMapUtil {

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
	public static void clearCache(CodeMasterMap codeMasterMap) {
		getPersistence().clearCache(codeMasterMap);
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
	public static Map<Serializable, CodeMasterMap> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CodeMasterMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CodeMasterMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CodeMasterMap> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CodeMasterMap> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CodeMasterMap update(CodeMasterMap codeMasterMap) {
		return getPersistence().update(codeMasterMap);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CodeMasterMap update(
		CodeMasterMap codeMasterMap, ServiceContext serviceContext) {

		return getPersistence().update(codeMasterMap, serviceContext);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public static CodeMasterMap findBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().findBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode) {

		return getPersistence().fetchBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode, boolean useFinderCache) {

		return getPersistence().fetchBySourceTypeSourceCode(
			sourceType, sourceCode, useFinderCache);
	}

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the code master map that was removed
	 */
	public static CodeMasterMap removeBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().removeBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the number of matching code master maps
	 */
	public static int countBySourceTypeSourceCode(
		String sourceType, String sourceCode) {

		return getPersistence().countBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public static CodeMasterMap findBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().findBySourceTypeCoreCode(sourceType, coreCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode) {

		return getPersistence().fetchBySourceTypeCoreCode(sourceType, coreCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode, boolean useFinderCache) {

		return getPersistence().fetchBySourceTypeCoreCode(
			sourceType, coreCode, useFinderCache);
	}

	/**
	 * Removes the code master map where sourceType = &#63; and coreCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the code master map that was removed
	 */
	public static CodeMasterMap removeBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().removeBySourceTypeCoreCode(
			sourceType, coreCode);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and coreCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the number of matching code master maps
	 */
	public static int countBySourceTypeCoreCode(
		String sourceType, String coreCode) {

		return getPersistence().countBySourceTypeCoreCode(sourceType, coreCode);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public static CodeMasterMap findBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().findBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code) {

		return getPersistence().fetchBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public static CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code,
		boolean useFinderCache) {

		return getPersistence().fetchBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code, useFinderCache);
	}

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the code master map that was removed
	 */
	public static CodeMasterMap removeBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().removeBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the number of matching code master maps
	 */
	public static int countBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code) {

		return getPersistence().countBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);
	}

	/**
	 * Caches the code master map in the entity cache if it is enabled.
	 *
	 * @param codeMasterMap the code master map
	 */
	public static void cacheResult(CodeMasterMap codeMasterMap) {
		getPersistence().cacheResult(codeMasterMap);
	}

	/**
	 * Caches the code master maps in the entity cache if it is enabled.
	 *
	 * @param codeMasterMaps the code master maps
	 */
	public static void cacheResult(List<CodeMasterMap> codeMasterMaps) {
		getPersistence().cacheResult(codeMasterMaps);
	}

	/**
	 * Creates a new code master map with the primary key. Does not add the code master map to the database.
	 *
	 * @param source the primary key for the new code master map
	 * @return the new code master map
	 */
	public static CodeMasterMap create(String source) {
		return getPersistence().create(source);
	}

	/**
	 * Removes the code master map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map that was removed
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	public static CodeMasterMap remove(String source)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().remove(source);
	}

	public static CodeMasterMap updateImpl(CodeMasterMap codeMasterMap) {
		return getPersistence().updateImpl(codeMasterMap);
	}

	/**
	 * Returns the code master map with the primary key or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	public static CodeMasterMap findByPrimaryKey(String source)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException {

		return getPersistence().findByPrimaryKey(source);
	}

	/**
	 * Returns the code master map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map, or <code>null</code> if a code master map with the primary key could not be found
	 */
	public static CodeMasterMap fetchByPrimaryKey(String source) {
		return getPersistence().fetchByPrimaryKey(source);
	}

	/**
	 * Returns all the code master maps.
	 *
	 * @return the code master maps
	 */
	public static List<CodeMasterMap> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @return the range of code master maps
	 */
	public static List<CodeMasterMap> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of code master maps
	 */
	public static List<CodeMasterMap> findAll(
		int start, int end,
		OrderByComparator<CodeMasterMap> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of code master maps
	 */
	public static List<CodeMasterMap> findAll(
		int start, int end, OrderByComparator<CodeMasterMap> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the code master maps from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of code master maps.
	 *
	 * @return the number of code master maps
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CodeMasterMapPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CodeMasterMapPersistence, CodeMasterMapPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CodeMasterMapPersistence.class);

		ServiceTracker<CodeMasterMapPersistence, CodeMasterMapPersistence>
			serviceTracker =
				new ServiceTracker
					<CodeMasterMapPersistence, CodeMasterMapPersistence>(
						bundle.getBundleContext(),
						CodeMasterMapPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}