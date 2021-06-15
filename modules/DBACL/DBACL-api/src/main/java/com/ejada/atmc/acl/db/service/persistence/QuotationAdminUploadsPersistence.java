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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationAdminUploadsException;
import com.ejada.atmc.acl.db.model.QuotationAdminUploads;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation admin uploads service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploadsUtil
 * @generated
 */
@ProviderType
public interface QuotationAdminUploadsPersistence
	extends BasePersistence<QuotationAdminUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationAdminUploadsUtil} to access the quotation admin uploads persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findByQuotationId(
		long quotationId);

	/**
	 * Returns a range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @return the range of matching quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end);

	/**
	 * Returns an ordered range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation admin uploadses where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findByQuotationId(
		long quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a matching quotation admin uploads could not be found
	 */
	public QuotationAdminUploads findByQuotationId_First(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationAdminUploads> orderByComparator)
		throws NoSuchQuotationAdminUploadsException;

	/**
	 * Returns the first quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation admin uploads, or <code>null</code> if a matching quotation admin uploads could not be found
	 */
	public QuotationAdminUploads fetchByQuotationId_First(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator);

	/**
	 * Returns the last quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a matching quotation admin uploads could not be found
	 */
	public QuotationAdminUploads findByQuotationId_Last(
			long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationAdminUploads> orderByComparator)
		throws NoSuchQuotationAdminUploadsException;

	/**
	 * Returns the last quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation admin uploads, or <code>null</code> if a matching quotation admin uploads could not be found
	 */
	public QuotationAdminUploads fetchByQuotationId_Last(
		long quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator);

	/**
	 * Returns the quotation admin uploadses before and after the current quotation admin uploads in the ordered set where quotationId = &#63;.
	 *
	 * @param id the primary key of the current quotation admin uploads
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public QuotationAdminUploads[] findByQuotationId_PrevAndNext(
			int id, long quotationId,
			com.liferay.portal.kernel.util.OrderByComparator
				<QuotationAdminUploads> orderByComparator)
		throws NoSuchQuotationAdminUploadsException;

	/**
	 * Removes all the quotation admin uploadses where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByQuotationId(long quotationId);

	/**
	 * Returns the number of quotation admin uploadses where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation admin uploadses
	 */
	public int countByQuotationId(long quotationId);

	/**
	 * Caches the quotation admin uploads in the entity cache if it is enabled.
	 *
	 * @param quotationAdminUploads the quotation admin uploads
	 */
	public void cacheResult(QuotationAdminUploads quotationAdminUploads);

	/**
	 * Caches the quotation admin uploadses in the entity cache if it is enabled.
	 *
	 * @param quotationAdminUploadses the quotation admin uploadses
	 */
	public void cacheResult(
		java.util.List<QuotationAdminUploads> quotationAdminUploadses);

	/**
	 * Creates a new quotation admin uploads with the primary key. Does not add the quotation admin uploads to the database.
	 *
	 * @param id the primary key for the new quotation admin uploads
	 * @return the new quotation admin uploads
	 */
	public QuotationAdminUploads create(int id);

	/**
	 * Removes the quotation admin uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads that was removed
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public QuotationAdminUploads remove(int id)
		throws NoSuchQuotationAdminUploadsException;

	public QuotationAdminUploads updateImpl(
		QuotationAdminUploads quotationAdminUploads);

	/**
	 * Returns the quotation admin uploads with the primary key or throws a <code>NoSuchQuotationAdminUploadsException</code> if it could not be found.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads
	 * @throws NoSuchQuotationAdminUploadsException if a quotation admin uploads with the primary key could not be found
	 */
	public QuotationAdminUploads findByPrimaryKey(int id)
		throws NoSuchQuotationAdminUploadsException;

	/**
	 * Returns the quotation admin uploads with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the quotation admin uploads
	 * @return the quotation admin uploads, or <code>null</code> if a quotation admin uploads with the primary key could not be found
	 */
	public QuotationAdminUploads fetchByPrimaryKey(int id);

	/**
	 * Returns all the quotation admin uploadses.
	 *
	 * @return the quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findAll();

	/**
	 * Returns a range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @return the range of quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotation admin uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationAdminUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation admin uploadses
	 * @param end the upper bound of the range of quotation admin uploadses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation admin uploadses
	 */
	public java.util.List<QuotationAdminUploads> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationAdminUploads>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation admin uploadses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation admin uploadses.
	 *
	 * @return the number of quotation admin uploadses
	 */
	public int countAll();

}