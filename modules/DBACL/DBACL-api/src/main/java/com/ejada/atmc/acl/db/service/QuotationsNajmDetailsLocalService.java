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

package com.ejada.atmc.acl.db.service;

import com.ejada.atmc.acl.db.model.QuotationsNajmDetails;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPK;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;

import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for QuotationsNajmDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsNajmDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface QuotationsNajmDetailsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.QuotationsNajmDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the quotations najm details local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link QuotationsNajmDetailsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the quotations najm details to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public QuotationsNajmDetails addQuotationsNajmDetails(
		QuotationsNajmDetails quotationsNajmDetails);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new quotations najm details with the primary key. Does not add the quotations najm details to the database.
	 *
	 * @param quotationsNajmDetailsPK the primary key for the new quotations najm details
	 * @return the new quotations najm details
	 */
	@Transactional(enabled = false)
	public QuotationsNajmDetails createQuotationsNajmDetails(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the quotations najm details from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public QuotationsNajmDetails deleteQuotationsNajmDetails(
		QuotationsNajmDetails quotationsNajmDetails);

	/**
	 * Deletes the quotations najm details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details that was removed
	 * @throws PortalException if a quotations najm details with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public QuotationsNajmDetails deleteQuotationsNajmDetails(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public DynamicQuery dynamicQuery();

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery);

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end);

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(DynamicQuery dynamicQuery);

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public QuotationsNajmDetails fetchQuotationsNajmDetails(
		QuotationsNajmDetailsPK quotationsNajmDetailsPK);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Returns the quotations najm details with the primary key.
	 *
	 * @param quotationsNajmDetailsPK the primary key of the quotations najm details
	 * @return the quotations najm details
	 * @throws PortalException if a quotations najm details with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public QuotationsNajmDetails getQuotationsNajmDetails(
			QuotationsNajmDetailsPK quotationsNajmDetailsPK)
		throws PortalException;

	/**
	 * Returns a range of all the quotations najm detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationsNajmDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations najm detailses
	 * @param end the upper bound of the range of quotations najm detailses (not inclusive)
	 * @return the range of quotations najm detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<QuotationsNajmDetails> getQuotationsNajmDetailses(
		int start, int end);

	/**
	 * Returns the number of quotations najm detailses.
	 *
	 * @return the number of quotations najm detailses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getQuotationsNajmDetailsesCount();

	/**
	 * Updates the quotations najm details in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationsNajmDetailsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationsNajmDetails the quotations najm details
	 * @return the quotations najm details that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public QuotationsNajmDetails updateQuotationsNajmDetails(
		QuotationsNajmDetails quotationsNajmDetails);

}