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

import com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException;
import com.ejada.atmc.acl.db.model.CLMNajm;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the clm najm service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajmUtil
 * @generated
 */
@ProviderType
public interface CLMNajmPersistence extends BasePersistence<CLMNajm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CLMNajmUtil} to access the clm najm persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByCASE_PLATE(String caseNo, String najmPlateNo)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_PLATE(String caseNo, String najmPlateNo);

	/**
	 * Returns the clm najm where caseNo = &#63; and najmPlateNo = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_PLATE(
		String caseNo, String najmPlateNo, boolean useFinderCache);

	/**
	 * Removes the clm najm where caseNo = &#63; and najmPlateNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the clm najm that was removed
	 */
	public CLMNajm removeByCASE_PLATE(String caseNo, String najmPlateNo)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the number of clm najms where caseNo = &#63; and najmPlateNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	public int countByCASE_PLATE(String caseNo, String najmPlateNo);

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByCASE_CUSTOM(String caseNo, String customId)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_CUSTOM(String caseNo, String customId);

	/**
	 * Returns the clm najm where caseNo = &#63; and customId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_CUSTOM(
		String caseNo, String customId, boolean useFinderCache);

	/**
	 * Removes the clm najm where caseNo = &#63; and customId = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the clm najm that was removed
	 */
	public CLMNajm removeByCASE_CUSTOM(String caseNo, String customId)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the number of clm najms where caseNo = &#63; and customId = &#63;.
	 *
	 * @param caseNo the case no
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	public int countByCASE_CUSTOM(String caseNo, String customId);

	/**
	 * Returns all the clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the matching clm najms
	 */
	public java.util.List<CLMNajm> findByNajmPlateNo(String najmPlateNo);

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
	public java.util.List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end);

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
	public java.util.List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

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
	public java.util.List<CLMNajm> findByNajmPlateNo(
		String najmPlateNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByNajmPlateNo_First(
			String najmPlateNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the first clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByNajmPlateNo_First(
		String najmPlateNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByNajmPlateNo_Last(
			String najmPlateNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the last clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByNajmPlateNo_Last(
		String najmPlateNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where najmPlateNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param najmPlateNo the najm plate no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public CLMNajm[] findByNajmPlateNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String najmPlateNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Removes all the clm najms where najmPlateNo = &#63; from the database.
	 *
	 * @param najmPlateNo the najm plate no
	 */
	public void removeByNajmPlateNo(String najmPlateNo);

	/**
	 * Returns the number of clm najms where najmPlateNo = &#63;.
	 *
	 * @param najmPlateNo the najm plate no
	 * @return the number of matching clm najms
	 */
	public int countByNajmPlateNo(String najmPlateNo);

	/**
	 * Returns all the clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the matching clm najms
	 */
	public java.util.List<CLMNajm> findByCustomId(String customId);

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
	public java.util.List<CLMNajm> findByCustomId(
		String customId, int start, int end);

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
	public java.util.List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

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
	public java.util.List<CLMNajm> findByCustomId(
		String customId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByCustomId_First(
			String customId,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the first clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCustomId_First(
		String customId,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByCustomId_Last(
			String customId,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the last clm najm in the ordered set where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCustomId_Last(
		String customId,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where customId = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param customId the custom ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public CLMNajm[] findByCustomId_PrevAndNext(
			CLMNajmPK clmNajmPK, String customId,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Removes all the clm najms where customId = &#63; from the database.
	 *
	 * @param customId the custom ID
	 */
	public void removeByCustomId(String customId);

	/**
	 * Returns the number of clm najms where customId = &#63;.
	 *
	 * @param customId the custom ID
	 * @return the number of matching clm najms
	 */
	public int countByCustomId(String customId);

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findByCASE_NAMEEN(String caseNo, String englishName)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_NAMEEN(String caseNo, String englishName);

	/**
	 * Returns the clm najm where caseNo = &#63; and englishName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchByCASE_NAMEEN(
		String caseNo, String englishName, boolean useFinderCache);

	/**
	 * Removes the clm najm where caseNo = &#63; and englishName = &#63; from the database.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the clm najm that was removed
	 */
	public CLMNajm removeByCASE_NAMEEN(String caseNo, String englishName)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the number of clm najms where caseNo = &#63; and englishName = &#63;.
	 *
	 * @param caseNo the case no
	 * @param englishName the english name
	 * @return the number of matching clm najms
	 */
	public int countByCASE_NAMEEN(String caseNo, String englishName);

	/**
	 * Returns all the clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the matching clm najms
	 */
	public java.util.List<CLMNajm> findBycaseNo(String caseNo);

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
	public java.util.List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end);

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
	public java.util.List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

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
	public java.util.List<CLMNajm> findBycaseNo(
		String caseNo, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findBycaseNo_First(
			String caseNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the first clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchBycaseNo_First(
		String caseNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm
	 * @throws NoSuchCLMNajmException if a matching clm najm could not be found
	 */
	public CLMNajm findBycaseNo_Last(
			String caseNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the last clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching clm najm, or <code>null</code> if a matching clm najm could not be found
	 */
	public CLMNajm fetchBycaseNo_Last(
		String caseNo,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

	/**
	 * Returns the clm najms before and after the current clm najm in the ordered set where caseNo = &#63;.
	 *
	 * @param clmNajmPK the primary key of the current clm najm
	 * @param caseNo the case no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public CLMNajm[] findBycaseNo_PrevAndNext(
			CLMNajmPK clmNajmPK, String caseNo,
			com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
				orderByComparator)
		throws NoSuchCLMNajmException;

	/**
	 * Removes all the clm najms where caseNo = &#63; from the database.
	 *
	 * @param caseNo the case no
	 */
	public void removeBycaseNo(String caseNo);

	/**
	 * Returns the number of clm najms where caseNo = &#63;.
	 *
	 * @param caseNo the case no
	 * @return the number of matching clm najms
	 */
	public int countBycaseNo(String caseNo);

	/**
	 * Caches the clm najm in the entity cache if it is enabled.
	 *
	 * @param clmNajm the clm najm
	 */
	public void cacheResult(CLMNajm clmNajm);

	/**
	 * Caches the clm najms in the entity cache if it is enabled.
	 *
	 * @param clmNajms the clm najms
	 */
	public void cacheResult(java.util.List<CLMNajm> clmNajms);

	/**
	 * Creates a new clm najm with the primary key. Does not add the clm najm to the database.
	 *
	 * @param clmNajmPK the primary key for the new clm najm
	 * @return the new clm najm
	 */
	public CLMNajm create(CLMNajmPK clmNajmPK);

	/**
	 * Removes the clm najm with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm that was removed
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public CLMNajm remove(CLMNajmPK clmNajmPK) throws NoSuchCLMNajmException;

	public CLMNajm updateImpl(CLMNajm clmNajm);

	/**
	 * Returns the clm najm with the primary key or throws a <code>NoSuchCLMNajmException</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm
	 * @throws NoSuchCLMNajmException if a clm najm with the primary key could not be found
	 */
	public CLMNajm findByPrimaryKey(CLMNajmPK clmNajmPK)
		throws NoSuchCLMNajmException;

	/**
	 * Returns the clm najm with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param clmNajmPK the primary key of the clm najm
	 * @return the clm najm, or <code>null</code> if a clm najm with the primary key could not be found
	 */
	public CLMNajm fetchByPrimaryKey(CLMNajmPK clmNajmPK);

	/**
	 * Returns all the clm najms.
	 *
	 * @return the clm najms
	 */
	public java.util.List<CLMNajm> findAll();

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
	public java.util.List<CLMNajm> findAll(int start, int end);

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
	public java.util.List<CLMNajm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator);

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
	public java.util.List<CLMNajm> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CLMNajm>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the clm najms from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of clm najms.
	 *
	 * @return the number of clm najms
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}