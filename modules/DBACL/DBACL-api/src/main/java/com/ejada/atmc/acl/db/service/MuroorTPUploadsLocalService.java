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

import com.ejada.atmc.acl.db.model.MuroorTPUploads;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsBankIbanBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsDriverLicenseBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsFrontPhotoBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsLeftSidePhotoBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsOwnerIdBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsRearPhotoBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsRightSidePhotoBlobModel;
import com.ejada.atmc.acl.db.model.MuroorTPUploadsVehRegistBlobModel;

import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
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

import java.io.InputStream;
import java.io.Serializable;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for MuroorTPUploads. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface MuroorTPUploadsLocalService
	extends BaseLocalService, PersistedModelLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.ejada.atmc.acl.db.service.impl.MuroorTPUploadsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the muroor tp uploads local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link MuroorTPUploadsLocalServiceUtil} if injection and service tracking are not available.
	 */

	/**
	 * Adds the muroor tp uploads to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MuroorTPUploads addMuroorTPUploads(MuroorTPUploads muroorTPUploads);

	/**
	 * Creates a new muroor tp uploads with the primary key. Does not add the muroor tp uploads to the database.
	 *
	 * @param id the primary key for the new muroor tp uploads
	 * @return the new muroor tp uploads
	 */
	@Transactional(enabled = false)
	public MuroorTPUploads createMuroorTPUploads(int id);

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	/**
	 * Deletes the muroor tp uploads with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 * @throws PortalException if a muroor tp uploads with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	public MuroorTPUploads deleteMuroorTPUploads(int id) throws PortalException;

	/**
	 * Deletes the muroor tp uploads from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	public MuroorTPUploads deleteMuroorTPUploads(
		MuroorTPUploads muroorTPUploads);

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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
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
	public MuroorTPUploads fetchMuroorTPUploads(int id);

	public Object[] findUploadsData(String intmNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ActionableDynamicQuery getActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsBankIbanBlobModel getBankIbanBlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsDriverLicenseBlobModel getDriverLicenseBlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsFrontPhotoBlobModel getFrontPhotoBlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public IndexableActionableDynamicQuery getIndexableActionableDynamicQuery();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsLeftSidePhotoBlobModel getLeftSidePhotoBlobModel(
		Serializable primaryKey);

	/**
	 * Returns the muroor tp uploads with the primary key.
	 *
	 * @param id the primary key of the muroor tp uploads
	 * @return the muroor tp uploads
	 * @throws PortalException if a muroor tp uploads with the primary key could not be found
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploads getMuroorTPUploads(int id) throws PortalException;

	/**
	 * Returns a range of all the muroor tp uploadses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of muroor tp uploadses
	 * @param end the upper bound of the range of muroor tp uploadses (not inclusive)
	 * @return the range of muroor tp uploadses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<MuroorTPUploads> getMuroorTPUploadses(int start, int end);

	/**
	 * Returns the number of muroor tp uploadses.
	 *
	 * @return the number of muroor tp uploadses
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getMuroorTPUploadsesCount();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsOwnerIdBlobModel getOwnerIdBlobModel(
		Serializable primaryKey);

	/**
	 * @throws PortalException
	 */
	@Override
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsRearPhotoBlobModel getRearPhotoBlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsRightSidePhotoBlobModel getRightSidePhotoBlobModel(
		Serializable primaryKey);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorTPUploadsVehRegistBlobModel getVehRegistBlobModel(
		Serializable primaryKey);

	@Transactional(readOnly = true)
	public InputStream openBankIbanInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openDriverLicenseInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openFrontPhotoInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openLeftSidePhotoInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openOwnerIdInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openRearPhotoInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openRightSidePhotoInputStream(long id);

	@Transactional(readOnly = true)
	public InputStream openVehRegistInputStream(long id);

	/**
	 * Updates the muroor tp uploads in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect MuroorTPUploadsLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param muroorTPUploads the muroor tp uploads
	 * @return the muroor tp uploads that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	public MuroorTPUploads updateMuroorTPUploads(
		MuroorTPUploads muroorTPUploads);

}