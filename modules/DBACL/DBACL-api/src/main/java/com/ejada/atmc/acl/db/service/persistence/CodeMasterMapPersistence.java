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

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException;
import com.ejada.atmc.acl.db.model.CodeMasterMap;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the code master map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterMapUtil
 * @generated
 */
@ProviderType
public interface CodeMasterMapPersistence
	extends BasePersistence<CodeMasterMap> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CodeMasterMapUtil} to access the code master map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public CodeMasterMap findBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode);

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode, boolean useFinderCache);

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the code master map that was removed
	 */
	public CodeMasterMap removeBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the number of matching code master maps
	 */
	public int countBySourceTypeSourceCode(
		String sourceType, String sourceCode);

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public CodeMasterMap findBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode);

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode, boolean useFinderCache);

	/**
	 * Removes the code master map where sourceType = &#63; and coreCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the code master map that was removed
	 */
	public CodeMasterMap removeBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the number of code master maps where sourceType = &#63; and coreCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the number of matching code master maps
	 */
	public int countBySourceTypeCoreCode(String sourceType, String coreCode);

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	public CodeMasterMap findBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code);

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	public CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code,
		boolean useFinderCache);

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the code master map that was removed
	 */
	public CodeMasterMap removeBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the number of matching code master maps
	 */
	public int countBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code);

	/**
	 * Caches the code master map in the entity cache if it is enabled.
	 *
	 * @param codeMasterMap the code master map
	 */
	public void cacheResult(CodeMasterMap codeMasterMap);

	/**
	 * Caches the code master maps in the entity cache if it is enabled.
	 *
	 * @param codeMasterMaps the code master maps
	 */
	public void cacheResult(java.util.List<CodeMasterMap> codeMasterMaps);

	/**
	 * Creates a new code master map with the primary key. Does not add the code master map to the database.
	 *
	 * @param source the primary key for the new code master map
	 * @return the new code master map
	 */
	public CodeMasterMap create(String source);

	/**
	 * Removes the code master map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map that was removed
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	public CodeMasterMap remove(String source)
		throws NoSuchCodeMasterMapException;

	public CodeMasterMap updateImpl(CodeMasterMap codeMasterMap);

	/**
	 * Returns the code master map with the primary key or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	public CodeMasterMap findByPrimaryKey(String source)
		throws NoSuchCodeMasterMapException;

	/**
	 * Returns the code master map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map, or <code>null</code> if a code master map with the primary key could not be found
	 */
	public CodeMasterMap fetchByPrimaryKey(String source);

	/**
	 * Returns all the code master maps.
	 *
	 * @return the code master maps
	 */
	public java.util.List<CodeMasterMap> findAll();

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
	public java.util.List<CodeMasterMap> findAll(int start, int end);

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
	public java.util.List<CodeMasterMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMasterMap>
			orderByComparator);

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
	public java.util.List<CodeMasterMap> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<CodeMasterMap>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the code master maps from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of code master maps.
	 *
	 * @return the number of code master maps
	 */
	public int countAll();

}