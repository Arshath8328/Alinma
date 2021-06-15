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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationSurveyException;
import com.ejada.atmc.acl.db.model.QuotationSurvey;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the quotation survey service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationSurveyUtil
 * @generated
 */
@ProviderType
public interface QuotationSurveyPersistence
	extends BasePersistence<QuotationSurvey> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link QuotationSurveyUtil} to access the quotation survey persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the matching quotation surveys
	 */
	public java.util.List<QuotationSurvey> findByquotationId(
		String quotationId);

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
	public java.util.List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end);

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
	public java.util.List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator);

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
	public java.util.List<QuotationSurvey> findByquotationId(
		String quotationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	public QuotationSurvey findByquotationId_First(
			String quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
				orderByComparator)
		throws NoSuchQuotationSurveyException;

	/**
	 * Returns the first quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	public QuotationSurvey fetchByquotationId_First(
		String quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator);

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey
	 * @throws NoSuchQuotationSurveyException if a matching quotation survey could not be found
	 */
	public QuotationSurvey findByquotationId_Last(
			String quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
				orderByComparator)
		throws NoSuchQuotationSurveyException;

	/**
	 * Returns the last quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching quotation survey, or <code>null</code> if a matching quotation survey could not be found
	 */
	public QuotationSurvey fetchByquotationId_Last(
		String quotationId,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator);

	/**
	 * Returns the quotation surveys before and after the current quotation survey in the ordered set where quotationId = &#63;.
	 *
	 * @param surveyId the primary key of the current quotation survey
	 * @param quotationId the quotation ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public QuotationSurvey[] findByquotationId_PrevAndNext(
			long surveyId, String quotationId,
			com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
				orderByComparator)
		throws NoSuchQuotationSurveyException;

	/**
	 * Removes all the quotation surveys where quotationId = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 */
	public void removeByquotationId(String quotationId);

	/**
	 * Returns the number of quotation surveys where quotationId = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @return the number of matching quotation surveys
	 */
	public int countByquotationId(String quotationId);

	/**
	 * Caches the quotation survey in the entity cache if it is enabled.
	 *
	 * @param quotationSurvey the quotation survey
	 */
	public void cacheResult(QuotationSurvey quotationSurvey);

	/**
	 * Caches the quotation surveys in the entity cache if it is enabled.
	 *
	 * @param quotationSurveys the quotation surveys
	 */
	public void cacheResult(java.util.List<QuotationSurvey> quotationSurveys);

	/**
	 * Creates a new quotation survey with the primary key. Does not add the quotation survey to the database.
	 *
	 * @param surveyId the primary key for the new quotation survey
	 * @return the new quotation survey
	 */
	public QuotationSurvey create(long surveyId);

	/**
	 * Removes the quotation survey with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey that was removed
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public QuotationSurvey remove(long surveyId)
		throws NoSuchQuotationSurveyException;

	public QuotationSurvey updateImpl(QuotationSurvey quotationSurvey);

	/**
	 * Returns the quotation survey with the primary key or throws a <code>NoSuchQuotationSurveyException</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey
	 * @throws NoSuchQuotationSurveyException if a quotation survey with the primary key could not be found
	 */
	public QuotationSurvey findByPrimaryKey(long surveyId)
		throws NoSuchQuotationSurveyException;

	/**
	 * Returns the quotation survey with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param surveyId the primary key of the quotation survey
	 * @return the quotation survey, or <code>null</code> if a quotation survey with the primary key could not be found
	 */
	public QuotationSurvey fetchByPrimaryKey(long surveyId);

	/**
	 * Returns all the quotation surveys.
	 *
	 * @return the quotation surveys
	 */
	public java.util.List<QuotationSurvey> findAll();

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
	public java.util.List<QuotationSurvey> findAll(int start, int end);

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
	public java.util.List<QuotationSurvey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator);

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
	public java.util.List<QuotationSurvey> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<QuotationSurvey>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the quotation surveys from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of quotation surveys.
	 *
	 * @return the number of quotation surveys
	 */
	public int countAll();

}