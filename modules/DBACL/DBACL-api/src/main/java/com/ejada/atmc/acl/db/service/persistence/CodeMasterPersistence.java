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

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.model.CodeMaster;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the code master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterUtil
 * @generated
 */
@ProviderType
public interface CodeMasterPersistence extends BasePersistence<CodeMaster> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CodeMasterUtil} to access the code master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public CodeMaster findByCodeCodeSub(String code, String codeSub)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCodeCodeSub(String code, String codeSub);

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCodeCodeSub(
		String code, String codeSub, boolean useFinderCache);

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the code master that was removed
	 */
	public CodeMaster removeByCodeCodeSub(String code, String codeSub)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the number of matching code masters
	 */
	public int countByCodeCodeSub(String code, String codeSub);

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
	public CodeMaster findByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN);

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
	public CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN,
		boolean useFinderCache);

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the code master that was removed
	 */
	public CodeMaster removeByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	public int countByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN);

	/**
	 * Returns all the code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching code masters
	 */
	public java.util.List<CodeMaster> findByCode(String code);

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
	public java.util.List<CodeMaster> findByCode(
		String code, int start, int end);

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
	public java.util.List<CodeMaster> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

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
	public java.util.List<CodeMaster> findByCode(
		String code, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public CodeMaster findByCode_First(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCode_First(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public CodeMaster findByCode_Last(
			String code,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCode_Last(
		String code,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

	/**
	 * Returns the code masters before and after the current code master in the ordered set where code = &#63;.
	 *
	 * @param systemId the primary key of the current code master
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public CodeMaster[] findByCode_PrevAndNext(
			long systemId, String code,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Removes all the code masters where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	public void removeByCode(String code);

	/**
	 * Returns the number of code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching code masters
	 */
	public int countByCode(String code);

	/**
	 * Returns all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the matching code masters
	 */
	public java.util.List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN);

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
	public java.util.List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end);

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
	public java.util.List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

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
	public java.util.List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public CodeMaster findByCodeCodeFreez_First(
			String code, String codeFreezYN,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCodeCodeFreez_First(
		String code, String codeFreezYN,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	public CodeMaster findByCodeCodeFreez_Last(
			String code, String codeFreezYN,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	public CodeMaster fetchByCodeCodeFreez_Last(
		String code, String codeFreezYN,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

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
	public CodeMaster[] findByCodeCodeFreez_PrevAndNext(
			long systemId, String code, String codeFreezYN,
			com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
				orderByComparator)
		throws NoSuchCodeMasterException;

	/**
	 * Removes all the code masters where code = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 */
	public void removeByCodeCodeFreez(String code, String codeFreezYN);

	/**
	 * Returns the number of code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	public int countByCodeCodeFreez(String code, String codeFreezYN);

	/**
	 * Caches the code master in the entity cache if it is enabled.
	 *
	 * @param codeMaster the code master
	 */
	public void cacheResult(CodeMaster codeMaster);

	/**
	 * Caches the code masters in the entity cache if it is enabled.
	 *
	 * @param codeMasters the code masters
	 */
	public void cacheResult(java.util.List<CodeMaster> codeMasters);

	/**
	 * Creates a new code master with the primary key. Does not add the code master to the database.
	 *
	 * @param systemId the primary key for the new code master
	 * @return the new code master
	 */
	public CodeMaster create(long systemId);

	/**
	 * Removes the code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master that was removed
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public CodeMaster remove(long systemId) throws NoSuchCodeMasterException;

	public CodeMaster updateImpl(CodeMaster codeMaster);

	/**
	 * Returns the code master with the primary key or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	public CodeMaster findByPrimaryKey(long systemId)
		throws NoSuchCodeMasterException;

	/**
	 * Returns the code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master, or <code>null</code> if a code master with the primary key could not be found
	 */
	public CodeMaster fetchByPrimaryKey(long systemId);

	/**
	 * Returns all the code masters.
	 *
	 * @return the code masters
	 */
	public java.util.List<CodeMaster> findAll();

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
	public java.util.List<CodeMaster> findAll(int start, int end);

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
	public java.util.List<CodeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator);

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
	public java.util.List<CodeMaster> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMaster>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the code masters from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of code masters.
	 *
	 * @return the number of code masters
	 */
	public int countAll();

}