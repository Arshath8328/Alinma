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

package com.ejada.atmc.acl.db.service.base;

import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.model.QuotationDriversInsuredRelationProofBlobModel;
import com.ejada.atmc.acl.db.service.QuotationDriversLocalService;
import com.ejada.atmc.acl.db.service.persistence.AtmcYakeenMakeModelPersistence;
import com.ejada.atmc.acl.db.service.persistence.BeneficiaryDetailsPersistence;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmPersistence;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmUploadsFinder;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.CLMSTATUSHISTORYPersistence;
import com.ejada.atmc.acl.db.service.persistence.CLMSTATUSPersistence;
import com.ejada.atmc.acl.db.service.persistence.CLMWORKFLOWPersistence;
import com.ejada.atmc.acl.db.service.persistence.ClaimAdminUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRFinder;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRPersistence;
import com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPersistence;
import com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPersistence;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterFinder;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterMapPersistence;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterPersistence;
import com.ejada.atmc.acl.db.service.persistence.CompDiscountPersistence;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsFinder;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.CustomerIbanPersistence;
import com.ejada.atmc.acl.db.service.persistence.CustomerMapPersistence;
import com.ejada.atmc.acl.db.service.persistence.CustomerPersistence;
import com.ejada.atmc.acl.db.service.persistence.FundDetailsPersistence;
import com.ejada.atmc.acl.db.service.persistence.LNP2_PolicyMastrFinder;
import com.ejada.atmc.acl.db.service.persistence.LNP2_PolicyMastrPersistence;
import com.ejada.atmc.acl.db.service.persistence.MuroorTPUploadsFinder;
import com.ejada.atmc.acl.db.service.persistence.MuroorTPUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.ODMuroorUploadsFinder;
import com.ejada.atmc.acl.db.service.persistence.ODMuroorUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.PayFortRefPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyCancelationPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyHDRFinder;
import com.ejada.atmc.acl.db.service.persistence.PolicyHDRPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyMemberDetailsPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentFinder;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHFinder;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrFinder;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrPersistence;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvFinder;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvPersistence;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversPersistence;
import com.ejada.atmc.acl.db.service.persistence.ProductDetailsPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationAdminUploadsPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationDriversPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationDriverseEndorsPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationExtraTameeniInfoPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationStatusHistoryPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationSurveyPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationsDriverLicensePersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationsNajmDetailsPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationsPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationsSeqPersistence;
import com.ejada.atmc.acl.db.service.persistence.QuotationsUserAddressPersistence;
import com.ejada.atmc.acl.db.service.persistence.SMSPersistence;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestAttachmentsFinder;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestAttachmentsPersistence;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestHistoryFinder;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestHistoryPersistence;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMasterFinder;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMasterPersistence;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMessagesFinder;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMessagesPersistence;
import com.ejada.atmc.acl.db.service.persistence.WorkshopVehiclePersistence;
import com.ejada.atmc.acl.db.service.persistence.YakeenDataSavePersistence;

import com.liferay.petra.io.AutoDeleteFileInputStream;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.db.DBType;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.File;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.InputStream;
import java.io.Serializable;

import java.sql.Blob;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the quotation drivers local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ejada.atmc.acl.db.service.impl.QuotationDriversLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ejada.atmc.acl.db.service.impl.QuotationDriversLocalServiceImpl
 * @generated
 */
public abstract class QuotationDriversLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   QuotationDriversLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>QuotationDriversLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ejada.atmc.acl.db.service.QuotationDriversLocalServiceUtil</code>.
	 */

	/**
	 * Adds the quotation drivers to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QuotationDrivers addQuotationDrivers(
		QuotationDrivers quotationDrivers) {

		quotationDrivers.setNew(true);

		return quotationDriversPersistence.update(quotationDrivers);
	}

	/**
	 * Creates a new quotation drivers with the primary key. Does not add the quotation drivers to the database.
	 *
	 * @param addDriverId the primary key for the new quotation drivers
	 * @return the new quotation drivers
	 */
	@Override
	@Transactional(enabled = false)
	public QuotationDrivers createQuotationDrivers(long addDriverId) {
		return quotationDriversPersistence.create(addDriverId);
	}

	/**
	 * Deletes the quotation drivers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers that was removed
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QuotationDrivers deleteQuotationDrivers(long addDriverId)
		throws PortalException {

		return quotationDriversPersistence.remove(addDriverId);
	}

	/**
	 * Deletes the quotation drivers from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QuotationDrivers deleteQuotationDrivers(
		QuotationDrivers quotationDrivers) {

		return quotationDriversPersistence.remove(quotationDrivers);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			QuotationDrivers.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return quotationDriversPersistence.findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @return the range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {

		return quotationDriversPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param dynamicQuery the dynamic query
	 * @param start the lower bound of the range of model instances
	 * @param end the upper bound of the range of model instances (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<T> orderByComparator) {

		return quotationDriversPersistence.findWithDynamicQuery(
			dynamicQuery, start, end, orderByComparator);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(DynamicQuery dynamicQuery) {
		return quotationDriversPersistence.countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * Returns the number of rows matching the dynamic query.
	 *
	 * @param dynamicQuery the dynamic query
	 * @param projection the projection to apply to the query
	 * @return the number of rows matching the dynamic query
	 */
	@Override
	public long dynamicQueryCount(
		DynamicQuery dynamicQuery, Projection projection) {

		return quotationDriversPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public QuotationDrivers fetchQuotationDrivers(long addDriverId) {
		return quotationDriversPersistence.fetchByPrimaryKey(addDriverId);
	}

	/**
	 * Returns the quotation drivers with the primary key.
	 *
	 * @param addDriverId the primary key of the quotation drivers
	 * @return the quotation drivers
	 * @throws PortalException if a quotation drivers with the primary key could not be found
	 */
	@Override
	public QuotationDrivers getQuotationDrivers(long addDriverId)
		throws PortalException {

		return quotationDriversPersistence.findByPrimaryKey(addDriverId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			quotationDriversLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(QuotationDrivers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("addDriverId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			quotationDriversLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(QuotationDrivers.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"addDriverId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			quotationDriversLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(QuotationDrivers.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("addDriverId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return quotationDriversPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return quotationDriversLocalService.deleteQuotationDrivers(
			(QuotationDrivers)persistedModel);
	}

	public BasePersistence<QuotationDrivers> getBasePersistence() {
		return quotationDriversPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return quotationDriversPersistence.findByPrimaryKey(primaryKeyObj);
	}

	/**
	 * Returns a range of all the quotation driverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationDriversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation driverses
	 * @param end the upper bound of the range of quotation driverses (not inclusive)
	 * @return the range of quotation driverses
	 */
	@Override
	public List<QuotationDrivers> getQuotationDriverses(int start, int end) {
		return quotationDriversPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of quotation driverses.
	 *
	 * @return the number of quotation driverses
	 */
	@Override
	public int getQuotationDriversesCount() {
		return quotationDriversPersistence.countAll();
	}

	/**
	 * Updates the quotation drivers in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationDriversLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationDrivers the quotation drivers
	 * @return the quotation drivers that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QuotationDrivers updateQuotationDrivers(
		QuotationDrivers quotationDrivers) {

		return quotationDriversPersistence.update(quotationDrivers);
	}

	@Override
	public QuotationDriversInsuredRelationProofBlobModel
		getInsuredRelationProofBlobModel(Serializable primaryKey) {

		Session session = null;

		try {
			session = quotationDriversPersistence.openSession();

			return (QuotationDriversInsuredRelationProofBlobModel)session.get(
				QuotationDriversInsuredRelationProofBlobModel.class,
				primaryKey);
		}
		catch (Exception exception) {
			throw quotationDriversPersistence.processException(exception);
		}
		finally {
			quotationDriversPersistence.closeSession(session);
		}
	}

	@Override
	@Transactional(readOnly = true)
	public InputStream openInsuredRelationProofInputStream(long addDriverId) {
		try {
			QuotationDriversInsuredRelationProofBlobModel
				QuotationDriversInsuredRelationProofBlobModel =
					getInsuredRelationProofBlobModel(addDriverId);

			Blob blob =
				QuotationDriversInsuredRelationProofBlobModel.
					getInsuredRelationProofBlob();

			if (blob == null) {
				return _EMPTY_INPUT_STREAM;
			}

			InputStream inputStream = blob.getBinaryStream();

			if (_useTempFile) {
				inputStream = new AutoDeleteFileInputStream(
					_file.createTempFile(inputStream));
			}

			return inputStream;
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Activate
	protected void activate() {
		DB db = DBManagerUtil.getDB();

		if ((db.getDBType() != DBType.DB2) &&
			(db.getDBType() != DBType.MYSQL) &&
			(db.getDBType() != DBType.MARIADB) &&
			(db.getDBType() != DBType.SYBASE)) {

			_useTempFile = true;
		}
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			QuotationDriversLocalService.class, IdentifiableOSGiService.class,
			PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		quotationDriversLocalService = (QuotationDriversLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return QuotationDriversLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return QuotationDrivers.class;
	}

	protected String getModelClassName() {
		return QuotationDrivers.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource = quotationDriversPersistence.getDataSource();

			DB db = DBManagerUtil.getDB();

			sql = db.buildSQL(sql);
			sql = PortalUtil.transformSQL(sql);

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(
				dataSource, sql);

			sqlUpdate.update();
		}
		catch (Exception exception) {
			throw new SystemException(exception);
		}
	}

	@Reference
	protected AtmcYakeenMakeModelPersistence atmcYakeenMakeModelPersistence;

	@Reference
	protected BeneficiaryDetailsPersistence beneficiaryDetailsPersistence;

	@Reference
	protected ClaimAdminUploadsPersistence claimAdminUploadsPersistence;

	@Reference
	protected ClaimHDRPersistence claimHDRPersistence;

	@Reference
	protected ClaimHDRFinder claimHDRFinder;

	@Reference
	protected ClaimODSearchPersistence claimODSearchPersistence;

	@Reference
	protected ClaimTPSearchPersistence claimTPSearchPersistence;

	@Reference
	protected CLMNajmPersistence clmNajmPersistence;

	@Reference
	protected CLMNajmUploadsPersistence clmNajmUploadsPersistence;

	@Reference
	protected CLMNajmUploadsFinder clmNajmUploadsFinder;

	@Reference
	protected CLMSTATUSPersistence clmstatusPersistence;

	@Reference
	protected CLMSTATUSHISTORYPersistence clmstatushistoryPersistence;

	@Reference
	protected CLMWORKFLOWPersistence clmworkflowPersistence;

	@Reference
	protected CodeMasterPersistence codeMasterPersistence;

	@Reference
	protected CodeMasterFinder codeMasterFinder;

	@Reference
	protected CodeMasterMapPersistence codeMasterMapPersistence;

	@Reference
	protected CompDiscountPersistence compDiscountPersistence;

	@Reference
	protected CustomerPersistence customerPersistence;

	@Reference
	protected CustomerIbanPersistence customerIbanPersistence;

	@Reference
	protected CustomerMapPersistence customerMapPersistence;

	@Reference
	protected CustUploadsPersistence custUploadsPersistence;

	@Reference
	protected CustUploadsFinder custUploadsFinder;

	@Reference
	protected FundDetailsPersistence fundDetailsPersistence;

	@Reference
	protected LNP2_PolicyMastrPersistence lnp2_PolicyMastrPersistence;

	@Reference
	protected LNP2_PolicyMastrFinder lnp2_PolicyMastrFinder;

	@Reference
	protected MuroorTPUploadsPersistence muroorTPUploadsPersistence;

	@Reference
	protected MuroorTPUploadsFinder muroorTPUploadsFinder;

	@Reference
	protected ODMuroorUploadsPersistence odMuroorUploadsPersistence;

	@Reference
	protected ODMuroorUploadsFinder odMuroorUploadsFinder;

	@Reference
	protected PayFortRefPersistence payFortRefPersistence;

	@Reference
	protected PolicyCancelationPersistence policyCancelationPersistence;

	@Reference
	protected PolicyHDRPersistence policyHDRPersistence;

	@Reference
	protected PolicyHDRFinder policyHDRFinder;

	@Reference
	protected PolicyMemberDetailsPersistence policyMemberDetailsPersistence;

	@Reference
	protected PolicyPaymentPersistence policyPaymentPersistence;

	@Reference
	protected PolicyPaymentFinder policyPaymentFinder;

	@Reference
	protected PolicyVEHPersistence policyVEHPersistence;

	@Reference
	protected PolicyVEHFinder policyVEHFinder;

	@Reference
	protected PolicyVehCvrPersistence policyVehCvrPersistence;

	@Reference
	protected PolicyVehCvrFinder policyVehCvrFinder;

	@Reference
	protected PolicyVehDrvPersistence policyVehDrvPersistence;

	@Reference
	protected PolicyVehDrvFinder policyVehDrvFinder;

	@Reference
	protected PolVEHSearchPersistence polVEHSearchPersistence;

	@Reference
	protected ProductCoversPersistence productCoversPersistence;

	@Reference
	protected ProductDetailsPersistence productDetailsPersistence;

	@Reference
	protected QuotationAdminUploadsPersistence quotationAdminUploadsPersistence;

	@Reference
	protected QuotationCoversPersistence quotationCoversPersistence;

	protected QuotationDriversLocalService quotationDriversLocalService;

	@Reference
	protected QuotationDriversPersistence quotationDriversPersistence;

	@Reference
	protected QuotationDriverseEndorsPersistence
		quotationDriverseEndorsPersistence;

	@Reference
	protected QuotationExtraTameeniInfoPersistence
		quotationExtraTameeniInfoPersistence;

	@Reference
	protected QuotationsPersistence quotationsPersistence;

	@Reference
	protected QuotationsDriverLicensePersistence
		quotationsDriverLicensePersistence;

	@Reference
	protected QuotationsNajmDetailsPersistence quotationsNajmDetailsPersistence;

	@Reference
	protected QuotationsSeqPersistence quotationsSeqPersistence;

	@Reference
	protected QuotationStatusHistoryPersistence
		quotationStatusHistoryPersistence;

	@Reference
	protected QuotationSurveyPersistence quotationSurveyPersistence;

	@Reference
	protected QuotationsUserAddressPersistence quotationsUserAddressPersistence;

	@Reference
	protected ServiceRequestAttachmentsPersistence
		serviceRequestAttachmentsPersistence;

	@Reference
	protected ServiceRequestAttachmentsFinder serviceRequestAttachmentsFinder;

	@Reference
	protected ServiceRequestHistoryPersistence serviceRequestHistoryPersistence;

	@Reference
	protected ServiceRequestHistoryFinder serviceRequestHistoryFinder;

	@Reference
	protected ServiceRequestMasterPersistence serviceRequestMasterPersistence;

	@Reference
	protected ServiceRequestMasterFinder serviceRequestMasterFinder;

	@Reference
	protected ServiceRequestMessagesPersistence
		serviceRequestMessagesPersistence;

	@Reference
	protected ServiceRequestMessagesFinder serviceRequestMessagesFinder;

	@Reference
	protected SMSPersistence smsPersistence;

	@Reference
	protected WorkshopVehiclePersistence workshopVehiclePersistence;

	@Reference
	protected YakeenDataSavePersistence yakeenDataSavePersistence;

	@Reference
	protected com.liferay.counter.kernel.service.CounterLocalService
		counterLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ClassNameLocalService
		classNameLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.ResourceLocalService
		resourceLocalService;

	@Reference
	protected com.liferay.portal.kernel.service.UserLocalService
		userLocalService;

	@Reference
	protected File _file;

	private static final InputStream _EMPTY_INPUT_STREAM =
		new UnsyncByteArrayInputStream(new byte[0]);

	private boolean _useTempFile;

}