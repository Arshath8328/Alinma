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

import com.ejada.atmc.acl.db.model.CodeMaster;

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
 * The persistence utility for the code master service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.CodeMasterPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterPersistence
 * @generated
 */
public class CodeMasterUtil {

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
	public static void clearCache(CodeMaster codeMaster) {
		getPersistence().clearCache(codeMaster);
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
	public static Map<Serializable, CodeMaster> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<CodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CodeMaster> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static CodeMaster update(CodeMaster codeMaster) {
		return getPersistence().update(codeMaster);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static CodeMaster update(
		CodeMaster codeMaster, ServiceContext serviceContext) {

		return getPersistence().update(codeMaster, serviceContext);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCodeCodeSub(String code, String codeSub)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCodeCodeSub(code, codeSub);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeSub(String code, String codeSub) {
		return getPersistence().fetchByCodeCodeSub(code, codeSub);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeSub(
		String code, String codeSub, boolean useFinderCache) {

		return getPersistence().fetchByCodeCodeSub(
			code, codeSub, useFinderCache);
	}

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the code master that was removed
	 */
	public static CodeMaster removeByCodeCodeSub(String code, String codeSub)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().removeByCodeCodeSub(code, codeSub);
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the number of matching code masters
	 */
	public static int countByCodeCodeSub(String code, String codeSub) {
		return getPersistence().countByCodeCodeSub(code, codeSub);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN) {

		return getPersistence().fetchByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN,
		boolean useFinderCache) {

		return getPersistence().fetchByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN, useFinderCache);
	}

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the code master that was removed
	 */
	public static CodeMaster removeByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().removeByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	public static int countByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN) {

		return getPersistence().countByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);
	}

	/**
	 * Returns all the code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching code masters
	 */
	public static List<CodeMaster> findByCode(String code) {
		return getPersistence().findByCode(code);
	}

	/**
	 * Returns a range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of matching code masters
	 */
	public static List<CodeMaster> findByCode(String code, int start, int end) {
		return getPersistence().findByCode(code, start, end);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching code masters
	 */
	public static List<CodeMaster> findByCode(
		String code, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().findByCode(code, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching code masters
	 */
	public static List<CodeMaster> findByCode(
		String code, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCode(
			code, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCode_First(
			String code, OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCode_First(
		String code, OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().fetchByCode_First(code, orderByComparator);
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCode_Last(
			String code, OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCode_Last(
		String code, OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().fetchByCode_Last(code, orderByComparator);
	}

	/**
	 * Returns the code masters before and after the current code master in the ordered set where code = &#63;.
	 *
	 * @param systemId the primary key of the current code master
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public static CodeMaster[] findByCode_PrevAndNext(
			long systemId, String code,
			OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCode_PrevAndNext(
			systemId, code, orderByComparator);
	}

	/**
	 * Removes all the code masters where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public static void removeByCode(String code) {
		getPersistence().removeByCode(code);
	}

	/**
	 * Returns the number of code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching code masters
	 */
	public static int countByCode(String code) {
		return getPersistence().countByCode(code);
	}

	/**
	 * Returns all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the matching code masters
	 */
	public static List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN) {

		return getPersistence().findByCodeCodeFreez(code, codeFreezYN);
	}

	/**
	 * Returns a range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of matching code masters
	 */
	public static List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end) {

		return getPersistence().findByCodeCodeFreez(
			code, codeFreezYN, start, end);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching code masters
	 */
	public static List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().findByCodeCodeFreez(
			code, codeFreezYN, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching code masters
	 */
	public static List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByCodeCodeFreez(
			code, codeFreezYN, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCodeCodeFreez_First(
			String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCodeCodeFreez_First(
			code, codeFreezYN, orderByComparator);
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeFreez_First(
		String code, String codeFreezYN,
		OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().fetchByCodeCodeFreez_First(
			code, codeFreezYN, orderByComparator);
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public static CodeMaster findByCodeCodeFreez_Last(
			String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCodeCodeFreez_Last(
			code, codeFreezYN, orderByComparator);
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public static CodeMaster fetchByCodeCodeFreez_Last(
		String code, String codeFreezYN,
		OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().fetchByCodeCodeFreez_Last(
			code, codeFreezYN, orderByComparator);
	}

	/**
	 * Returns the code masters before and after the current code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param systemId the primary key of the current code master
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public static CodeMaster[] findByCodeCodeFreez_PrevAndNext(
			long systemId, String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByCodeCodeFreez_PrevAndNext(
			systemId, code, codeFreezYN, orderByComparator);
	}

	/**
	 * Removes all the code masters where code = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 */
	public static void removeByCodeCodeFreez(String code, String codeFreezYN) {
		getPersistence().removeByCodeCodeFreez(code, codeFreezYN);
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	public static int countByCodeCodeFreez(String code, String codeFreezYN) {
		return getPersistence().countByCodeCodeFreez(code, codeFreezYN);
	}

	/**
	 * Caches the code master in the entity cache if it is enabled.
	 *
	 * @param codeMaster the code master
	 */
	public static void cacheResult(CodeMaster codeMaster) {
		getPersistence().cacheResult(codeMaster);
	}

	/**
	 * Caches the code masters in the entity cache if it is enabled.
	 *
	 * @param codeMasters the code masters
	 */
	public static void cacheResult(List<CodeMaster> codeMasters) {
		getPersistence().cacheResult(codeMasters);
	}

	/**
	 * Creates a new code master with the primary key. Does not add the code master to the database.
	 *
	 * @param systemId the primary key for the new code master
	 * @return the new code master
	 */
	public static CodeMaster create(long systemId) {
		return getPersistence().create(systemId);
	}

	/**
	 * Removes the code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master that was removed
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public static CodeMaster remove(long systemId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().remove(systemId);
	}

	public static CodeMaster updateImpl(CodeMaster codeMaster) {
		return getPersistence().updateImpl(codeMaster);
	}

	/**
	 * Returns the code master with the primary key or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public static CodeMaster findByPrimaryKey(long systemId)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return getPersistence().findByPrimaryKey(systemId);
	}

	/**
	 * Returns the code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master, or <code>null</code> if a code master with the primary key could not be found
	 */
	public static CodeMaster fetchByPrimaryKey(long systemId) {
		return getPersistence().fetchByPrimaryKey(systemId);
	}

	/**
	 * Returns all the code masters.
	 *
	 * @return the code masters
	 */
	public static List<CodeMaster> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of code masters
	 */
	public static List<CodeMaster> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of code masters
	 */
	public static List<CodeMaster> findAll(
		int start, int end, OrderByComparator<CodeMaster> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of code masters
	 */
	public static List<CodeMaster> findAll(
		int start, int end, OrderByComparator<CodeMaster> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the code masters from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of code masters.
	 *
	 * @return the number of code masters
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static CodeMasterPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<CodeMasterPersistence, CodeMasterPersistence>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(CodeMasterPersistence.class);

		ServiceTracker<CodeMasterPersistence, CodeMasterPersistence>
			serviceTracker =
				new ServiceTracker
					<CodeMasterPersistence, CodeMasterPersistence>(
						bundle.getBundleContext(), CodeMasterPersistence.class,
						null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}