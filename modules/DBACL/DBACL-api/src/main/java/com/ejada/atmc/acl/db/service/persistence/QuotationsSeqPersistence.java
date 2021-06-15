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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException;
import com.ejada.atmc.acl.db.model.QuotationsSeq;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotations seq service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeqUtil
 * @generated
 */
@ProviderType
public interface QuotationsSeqPersistence
	extends BasePersistence<QuotationsSeq> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationsSeqUtil} to access the quotations seq persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the quotations seq where key = &#63; or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quotations seq
	 * @throws NoSuchQuotationsSeqException if a matching quotations seq could not be found
	 */
	public QuotationsSeq findByKey(String key)
		throws NoSuchQuotationsSeqException;

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	public QuotationsSeq fetchByKey(String key);

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	public QuotationsSeq fetchByKey(String key, boolean useFinderCache);

	/**
	 * Removes the quotations seq where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quotations seq that was removed
	 */
	public QuotationsSeq removeByKey(String key)
		throws NoSuchQuotationsSeqException;

	/**
	 * Returns the number of quotations seqs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quotations seqs
	 */
	public int countByKey(String key);

	/**
	 * Caches the quotations seq in the entity cache if it is enabled.
	 *
	 * @param quotationsSeq the quotations seq
	 */
	public void cacheResult(QuotationsSeq quotationsSeq);

	/**
	 * Caches the quotations seqs in the entity cache if it is enabled.
	 *
	 * @param quotationsSeqs the quotations seqs
	 */
	public void cacheResult(java.util.List<QuotationsSeq> quotationsSeqs);

	/**
	 * Creates a new quotations seq with the primary key. Does not add the quotations seq to the database.
	 *
	 * @param key the primary key for the new quotations seq
	 * @return the new quotations seq
	 */
	public QuotationsSeq create(String key);

	/**
	 * Removes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	public QuotationsSeq remove(String key) throws NoSuchQuotationsSeqException;

	public QuotationsSeq updateImpl(QuotationsSeq quotationsSeq);

	/**
	 * Returns the quotations seq with the primary key or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	public QuotationsSeq findByPrimaryKey(String key)
		throws NoSuchQuotationsSeqException;

	/**
	 * Returns the quotations seq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq, or <code>null</code> if a quotations seq with the primary key could not be found
	 */
	public QuotationsSeq fetchByPrimaryKey(String key);

	/**
	 * Returns all the quotations seqs.
	 *
	 * @return the quotations seqs
	 */
	public java.util.List<QuotationsSeq> findAll();

	/**
	 * Returns a range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @return the range of quotations seqs
	 */
	public java.util.List<QuotationsSeq> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations seqs
	 */
	public java.util.List<QuotationsSeq> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsSeq>
			orderByComparator);

	/**
	 * Returns an ordered range of all the quotations seqs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsSeqModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations seqs
	 * @param end the upper bound of the range of quotations seqs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations seqs
	 */
	public java.util.List<QuotationsSeq> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationsSeq>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotations seqs from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotations seqs.
	 *
	 * @return the number of quotations seqs
	 */
	public int countAll();

}