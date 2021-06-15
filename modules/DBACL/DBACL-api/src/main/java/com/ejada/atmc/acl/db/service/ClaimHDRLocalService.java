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

import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPK;

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

import java.sql.Date;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for ClaimHDR. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimHDRLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClaimHDRLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.ClaimHDRLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the claim hdr local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ClaimHDRLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the claim hdr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClaimHDR addClaimHDR(ClaimHDR claimHDR);

	/**
	 * Creates a new claim hdr with the primary key. Does not add the claim hdr to the database.
	 *
	 * @param claimHDRPK the primary key for the new claim hdr
	 * @return the new claim hdr
	 */
	@Transactional(enabled = false)
	public ClaimHDR createClaimHDR(ClaimHDRPK claimHDRPK);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the claim hdr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClaimHDR deleteClaimHDR(ClaimHDR claimHDR);

	/**
	 * Deletes the claim hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr that was removed
	 * @throws PortalException if a claim hdr with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public ClaimHDR deleteClaimHDR(ClaimHDRPK claimHDRPK)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
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
	public ClaimHDR fetchClaimHDR(ClaimHDRPK claimHDRPK);

	public List<Object[]> findAllClaimsPolicyByIqamaId(String iqamaId)
		throws PortalException;

	public List<ClaimHDR> findClaimsByExcludeStatus(
			String iqamaId, String status)
		throws PortalException;

	public List<ClaimHDR> findClaimsByIqamaId(String iqamaId)
		throws PortalException;

	public int findClaimsCountsPolicyStatusAdmin(
			String status, String Surveyor, String refNo)
		throws PortalException;

	public List<Object[]> findClaimsPolicyBy() throws PortalException;

	public List<Object[]> findClaimsPolicyStatus(
			String iqamaId, String status, String policyType, Date fromDate,
			Date toDate)
		throws PortalException;

	public List<Object[]> findClaimsPolicyStatusAdmin(
			String status, String Surveyor, String refNo, int from, int to)
		throws PortalException;

	/**
	 * Returns the claim hdr with the primary key.
	 *
	 * @param claimHDRPK the primary key of the claim hdr
	 * @return the claim hdr
	 * @throws PortalException if a claim hdr with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ClaimHDR getClaimHDR(ClaimHDRPK claimHDRPK) throws PortalException;

	/**
	 * Returns a range of all the claim hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.ClaimHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim hdrs
	 * @param end the upper bound of the range of claim hdrs (not inclusive)
	 * @return the range of claim hdrs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimHDR> getClaimHDRs(int start, int end);

	/**
	 * Returns the number of claim hdrs.
	 *
	 * @return the number of claim hdrs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getClaimHDRsCount();

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
	 * Updates the claim hdr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect ClaimHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param claimHDR the claim hdr
	 * @return the claim hdr that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public ClaimHDR updateClaimHDR(ClaimHDR claimHDR);

}