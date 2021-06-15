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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.PolicyHDR;

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

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for PolicyHDR. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface PolicyHDRLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.PolicyHDRLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the policy hdr local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link PolicyHDRLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the policy hdr to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PolicyHDR addPolicyHDR(PolicyHDR policyHDR);

	public boolean checkLoyalty(String iqamaId, String vehId, Date expiryDate)
		throws PortalException;

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Creates a new policy hdr with the primary key. Does not add the policy hdr to the database.
	 *
	 * @param policyNo the primary key for the new policy hdr
	 * @return the new policy hdr
	 */
	@Transactional(enabled = false)
	public PolicyHDR createPolicyHDR(String policyNo);

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException;

	/**
	 * Deletes the policy hdr from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public PolicyHDR deletePolicyHDR(PolicyHDR policyHDR);

	/**
	 * Deletes the policy hdr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr that was removed
	 * @throws PortalException if a policy hdr with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public PolicyHDR deletePolicyHDR(String policyNo) throws PortalException;

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
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
	public PolicyHDR fetchPolicyHDR(String policyNo);

	public List<PolicyHDR> findByinsuredMobileNo(String insuredMobileNo)
		throws PortalException;

	public List<PolicyHDR> findByIqamaId(String iqamaId, int start, int end)
		throws SystemException;

	public List<PolicyHDR> findByiqamaIdAndStatus(String iqamaId, String status)
		throws PortalException;

	public PolicyHDR findByPolicyNo(String policyNo)
		throws NoSuchPolicyHDRException;

	public long findCountByIqamaId(String iqamaId) throws PortalException;

	public List<PolicyHDR> findMultiPolicies(String[] policyNumbers)
		throws SystemException;

	public List<PolicyHDR> findPolicyList(String iqamaId, String[] status)
		throws SystemException;

	public String findPolicyNajmStatus(String policyNo) throws PortalException;

	public List<PolicyHDR> findTopPolicies(String iqamaId)
		throws SystemException;

	public Long findUpcomingRenewalsCount(String iqamaId)
		throws SystemException;

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
	 * Returns the policy hdr with the primary key.
	 *
	 * @param policyNo the primary key of the policy hdr
	 * @return the policy hdr
	 * @throws PortalException if a policy hdr with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PolicyHDR getPolicyHDR(String policyNo) throws PortalException;

	/**
	 * Returns a range of all the policy hdrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy hdrs
	 * @param end the upper bound of the range of policy hdrs (not inclusive)
	 * @return the range of policy hdrs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PolicyHDR> getPolicyHDRs(int start, int end);

	/**
	 * Returns the number of policy hdrs.
	 *
	 * @return the number of policy hdrs
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getPolicyHDRsCount();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<PolicyHDR> getUpcomingPolicyRenewals(String iqamaId)
		throws SystemException;

	/**
	 * Updates the policy hdr in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect PolicyHDRLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param policyHDR the policy hdr
	 * @return the policy hdr that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public PolicyHDR updatePolicyHDR(PolicyHDR policyHDR);

}