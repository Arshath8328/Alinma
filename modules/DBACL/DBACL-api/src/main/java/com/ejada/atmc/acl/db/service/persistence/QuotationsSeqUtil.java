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

import com.ejada.atmc.acl.db.model.QuotationsSeq;

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
 * The persistence utility for the quotations seq service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationsSeqPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeqPersistence
 * @generated
 */
public class QuotationsSeqUtil {

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
	public static void clearCache(QuotationsSeq quotationsSeq) {
		getPersistence().clearCache(quotationsSeq);
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
	public static Map<Serializable, QuotationsSeq> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationsSeq> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationsSeq> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationsSeq> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationsSeq> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationsSeq update(QuotationsSeq quotationsSeq) {
		return getPersistence().update(quotationsSeq);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationsSeq update(
		QuotationsSeq quotationsSeq, ServiceContext serviceContext) {

		return getPersistence().update(quotationsSeq, serviceContext);
	}

	/**
	 * Returns the quotations seq where key = &#63; or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the key
	 * @return the matching quotations seq
	 * @throws NoSuchQuotationsSeqException if a matching quotations seq could not be found
	 */
	public static QuotationsSeq findByKey(String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return getPersistence().findByKey(key);
	}

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	public static QuotationsSeq fetchByKey(String key) {
		return getPersistence().fetchByKey(key);
	}

	/**
	 * Returns the quotations seq where key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param key the key
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations seq, or <code>null</code> if a matching quotations seq could not be found
	 */
	public static QuotationsSeq fetchByKey(String key, boolean useFinderCache) {
		return getPersistence().fetchByKey(key, useFinderCache);
	}

	/**
	 * Removes the quotations seq where key = &#63; from the database.
	 *
	 * @param key the key
	 * @return the quotations seq that was removed
	 */
	public static QuotationsSeq removeByKey(String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return getPersistence().removeByKey(key);
	}

	/**
	 * Returns the number of quotations seqs where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching quotations seqs
	 */
	public static int countByKey(String key) {
		return getPersistence().countByKey(key);
	}

	/**
	 * Caches the quotations seq in the entity cache if it is enabled.
	 *
	 * @param quotationsSeq the quotations seq
	 */
	public static void cacheResult(QuotationsSeq quotationsSeq) {
		getPersistence().cacheResult(quotationsSeq);
	}

	/**
	 * Caches the quotations seqs in the entity cache if it is enabled.
	 *
	 * @param quotationsSeqs the quotations seqs
	 */
	public static void cacheResult(List<QuotationsSeq> quotationsSeqs) {
		getPersistence().cacheResult(quotationsSeqs);
	}

	/**
	 * Creates a new quotations seq with the primary key. Does not add the quotations seq to the database.
	 *
	 * @param key the primary key for the new quotations seq
	 * @return the new quotations seq
	 */
	public static QuotationsSeq create(String key) {
		return getPersistence().create(key);
	}

	/**
	 * Removes the quotations seq with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq that was removed
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	public static QuotationsSeq remove(String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return getPersistence().remove(key);
	}

	public static QuotationsSeq updateImpl(QuotationsSeq quotationsSeq) {
		return getPersistence().updateImpl(quotationsSeq);
	}

	/**
	 * Returns the quotations seq with the primary key or throws a <code>NoSuchQuotationsSeqException</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq
	 * @throws NoSuchQuotationsSeqException if a quotations seq with the primary key could not be found
	 */
	public static QuotationsSeq findByPrimaryKey(String key)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationsSeqException {

		return getPersistence().findByPrimaryKey(key);
	}

	/**
	 * Returns the quotations seq with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param key the primary key of the quotations seq
	 * @return the quotations seq, or <code>null</code> if a quotations seq with the primary key could not be found
	 */
	public static QuotationsSeq fetchByPrimaryKey(String key) {
		return getPersistence().fetchByPrimaryKey(key);
	}

	/**
	 * Returns all the quotations seqs.
	 *
	 * @return the quotations seqs
	 */
	public static List<QuotationsSeq> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<QuotationsSeq> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<QuotationsSeq> findAll(
		int start, int end,
		OrderByComparator<QuotationsSeq> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<QuotationsSeq> findAll(
		int start, int end, OrderByComparator<QuotationsSeq> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotations seqs from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotations seqs.
	 *
	 * @return the number of quotations seqs
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationsSeqPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationsSeqPersistence, QuotationsSeqPersistence> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuotationsSeqPersistence.class);

		ServiceTracker<QuotationsSeqPersistence, QuotationsSeqPersistence>
			serviceTracker =
				new ServiceTracker
					<QuotationsSeqPersistence, QuotationsSeqPersistence>(
						bundle.getBundleContext(),
						QuotationsSeqPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}