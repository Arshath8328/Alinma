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

import com.ejada.atmc.acl.db.model.QuotationSurvey;

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
 * The persistence utility for the quotation survey service. This utility wraps <code>com.ejada.atmc.acl.db.service.persistence.impl.QuotationSurveyPersistenceImpl</code> and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurveyPersistence
 * @generated
 */
public class QuotationSurveyUtil {

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
	public static void clearCache(QuotationSurvey quotationSurvey) {
		getPersistence().clearCache(quotationSurvey);
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
	public static Map<Serializable, QuotationSurvey> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {

		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<QuotationSurvey> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {

		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<QuotationSurvey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<QuotationSurvey> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return getPersistence().findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static QuotationSurvey update(QuotationSurvey quotationSurvey) {
		return getPersistence().update(quotationSurvey);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static QuotationSurvey update(
		QuotationSurvey quotationSurvey, ServiceContext serviceContext) {

		return getPersistence().update(quotationSurvey, serviceContext);
	}

	/**
	 * Returns all the quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation surveys
	 */
	public static List<QuotationSurvey> findByquotationId(String quotationId) {
		return getPersistence().findByquotationId(quotationId);
	}

	/**
	 * Returns a range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @return the range of matching quotation surveys
	 */
	public static List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end) {

		return getPersistence().findByquotationId(quotationId, start, end);
	}

	/**
	 * Returns an ordered range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching quotation surveys
	 */
	public static List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return getPersistence().findByquotationId(
			quotationId, start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation surveys where quotationId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param quotationId the quotation ID
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching quotation surveys
	 */
	public static List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findByquotationId(
			quotationId, start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	public static QuotationSurvey findByquotationId_First(
			String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException {

		return getPersistence().findByquotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	public static QuotationSurvey fetchByquotationId_First(
		String quotationId,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return getPersistence().fetchByquotationId_First(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	public static QuotationSurvey findByquotationId_Last(
			String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException {

		return getPersistence().findByquotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	public static QuotationSurvey fetchByquotationId_Last(
		String quotationId,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return getPersistence().fetchByquotationId_Last(
			quotationId, orderByComparator);
	}

	/**
	 * Returns the quotation surveys before and after the current quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param surveyId the primary key of the current quotation survey
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public static QuotationSurvey[] findByquotationId_PrevAndNext(
			long surveyId, String quotationId,
			OrderByComparator<QuotationSurvey> orderByComparator)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException {

		return getPersistence().findByquotationId_PrevAndNext(
			surveyId, quotationId, orderByComparator);
	}

	/**
	 * Removes all the quotation surveys where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public static void removeByquotationId(String quotationId) {
		getPersistence().removeByquotationId(quotationId);
	}

	/**
	 * Returns the number of quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation surveys
	 */
	public static int countByquotationId(String quotationId) {
		return getPersistence().countByquotationId(quotationId);
	}

	/**
	 * Caches the quotation survey in the entity cache if it is enabled.
	 *
	 * @param quotationSurvey the quotation survey
	 */
	public static void cacheResult(QuotationSurvey quotationSurvey) {
		getPersistence().cacheResult(quotationSurvey);
	}

	/**
	 * Caches the quotation surveys in the entity cache if it is enabled.
	 *
	 * @param quotationSurveys the quotation surveys
	 */
	public static void cacheResult(List<QuotationSurvey> quotationSurveys) {
		getPersistence().cacheResult(quotationSurveys);
	}

	/**
	 * Creates a new quotation survey with the primary key. Does not add the quotation survey to the database.
	 *
	 * @param surveyId the primary key for the new quotation survey
	 * @return the new quotation survey
	 */
	public static QuotationSurvey create(long surveyId) {
		return getPersistence().create(surveyId);
	}

	/**
	 * Removes the quotation survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey that was removed
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public static QuotationSurvey remove(long surveyId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException {

		return getPersistence().remove(surveyId);
	}

	public static QuotationSurvey updateImpl(QuotationSurvey quotationSurvey) {
		return getPersistence().updateImpl(quotationSurvey);
	}

	/**
	 * Returns the quotation survey with the primary key or throws a <code>NoSuchQuotationSurveyException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public static QuotationSurvey findByPrimaryKey(long surveyId)
		throws com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException {

		return getPersistence().findByPrimaryKey(surveyId);
	}

	/**
	 * Returns the quotation survey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey, or <code>null</code> if a quotation survey with the primary key could not be found
	 */
	public static QuotationSurvey fetchByPrimaryKey(long surveyId) {
		return getPersistence().fetchByPrimaryKey(surveyId);
	}

	/**
	 * Returns all the quotation surveys.
	 *
	 * @return the quotation surveys
	 */
	public static List<QuotationSurvey> findAll() {
		return getPersistence().findAll();
	}

	/**
	 * Returns a range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @return the range of quotation surveys
	 */
	public static List<QuotationSurvey> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	 * Returns an ordered range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotation surveys
	 */
	public static List<QuotationSurvey> findAll(
		int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator) {

		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	 * Returns an ordered range of all the quotation surveys.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationSurveyModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation surveys
	 * @param end the upper bound of the range of quotation surveys (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotation surveys
	 */
	public static List<QuotationSurvey> findAll(
		int start, int end,
		OrderByComparator<QuotationSurvey> orderByComparator,
		boolean useFinderCache) {

		return getPersistence().findAll(
			start, end, orderByComparator, useFinderCache);
	}

	/**
	 * Removes all the quotation surveys from the database.
	 */
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	 * Returns the number of quotation surveys.
	 *
	 * @return the number of quotation surveys
	 */
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static QuotationSurveyPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<QuotationSurveyPersistence, QuotationSurveyPersistence>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			QuotationSurveyPersistence.class);

		ServiceTracker<QuotationSurveyPersistence, QuotationSurveyPersistence>
			serviceTracker =
				new ServiceTracker
					<QuotationSurveyPersistence, QuotationSurveyPersistence>(
						bundle.getBundleContext(),
						QuotationSurveyPersistence.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}