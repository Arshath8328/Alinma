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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationExtraTameeniInfoException;
import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation extra tameeni info service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationExtraTameeniInfoUtil
 * @generated
 */
@ProviderType
public interface QuotationExtraTameeniInfoPersistence
	extends BasePersistence<QuotationExtraTameeniInfo> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationExtraTameeniInfoUtil} to access the quotation extra tameeni info persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a matching quotation extra tameeni info could not be found
	 */
	public QuotationExtraTameeniInfo findByQuotationId(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException;

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	public QuotationExtraTameeniInfo fetchByQuotationId(long quotationId);

	/**
	 * Returns the quotation extra tameeni info where quotationId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotation extra tameeni info, or <code>null</code> if a matching quotation extra tameeni info could not be found
	 */
	public QuotationExtraTameeniInfo fetchByQuotationId(
		long quotationId, boolean useFinderCache);

	/**
	 * Removes the quotation extra tameeni info where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @return the quotation extra tameeni info that was removed
	 */
	public QuotationExtraTameeniInfo removeByQuotationId(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException;

	/**
	 * Returns the number of quotation extra tameeni infos where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation extra tameeni infos
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Caches the quotation extra tameeni info in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 */
	public void cacheResult(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo);

	/**
	 * Caches the quotation extra tameeni infos in the entity cache if it is enabled.
	 *
	 * @param quotationExtraTameeniInfos the quotation extra tameeni infos
	 */
	public void cacheResult(
		java.util.List<QuotationExtraTameeniInfo> quotationExtraTameeniInfos);

	/**
	 * Creates a new quotation extra tameeni info with the primary key. Does not add the quotation extra tameeni info to the database.
	 *
	 * @param quotationId the primary key for the new quotation extra tameeni info
	 * @return the new quotation extra tameeni info
	 */
	public QuotationExtraTameeniInfo create(long quotationId);

	/**
	 * Removes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	public QuotationExtraTameeniInfo remove(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException;

	public QuotationExtraTameeniInfo updateImpl(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo);

	/**
	 * Returns the quotation extra tameeni info with the primary key or throws a <code>NoSuchQuotationExtraTameeniInfoException</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws NoSuchQuotationExtraTameeniInfoException if a quotation extra tameeni info with the primary key could not be found
	 */
	public QuotationExtraTameeniInfo findByPrimaryKey(long quotationId)
		throws NoSuchQuotationExtraTameeniInfoException;

	/**
	 * Returns the quotation extra tameeni info with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info, or <code>null</code> if a quotation extra tameeni info with the primary key could not be found
	 */
	public QuotationExtraTameeniInfo fetchByPrimaryKey(long quotationId);

	/**
	 * Returns all the quotation extra tameeni infos.
	 *
	 * @return the quotation extra tameeni infos
	 */
	public java.util.List<QuotationExtraTameeniInfo> findAll();

	/**
	 * Returns a range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @return the range of quotation extra tameeni infos
	 */
	public java.util.List<QuotationExtraTameeniInfo> findAll(
		int start, int end);

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation extra tameeni infos
	 */
	public java.util.List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationExtraTameeniInfo> orderByComparator);

	/**
	 * Returns an ordered range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation extra tameeni infos
	 */
	public java.util.List<QuotationExtraTameeniInfo> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator
			<QuotationExtraTameeniInfo> orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation extra tameeni infos from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation extra tameeni infos.
	 *
	 * @return the number of quotation extra tameeni infos
	 */
	public int countAll();

}