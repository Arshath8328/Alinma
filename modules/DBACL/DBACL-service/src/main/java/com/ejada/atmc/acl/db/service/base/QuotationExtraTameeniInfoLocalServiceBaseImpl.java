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

import com.ejada.atmc.acl.db.model.QuotationExtraTameeniInfo;
import com.ejada.atmc.acl.db.service.QuotationExtraTameeniInfoLocalService;
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

import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.dao.db.DB;
import com.liferay.portal.kernel.dao.db.DBManagerUtil;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DefaultActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery;
import com.liferay.portal.kernel.dao.orm.Projection;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.module.framework.service.IdentifiableOSGiService;
import com.liferay.portal.kernel.search.Indexable;
import com.liferay.portal.kernel.search.IndexableType;
import com.liferay.portal.kernel.service.BaseLocalServiceImpl;
import com.liferay.portal.kernel.service.PersistedModelLocalService;
import com.liferay.portal.kernel.service.persistence.BasePersistence;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.Serializable;

import java.util.List;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Reference;

/**
 * Provides the base implementation for the quotation extra tameeni info local service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.ejada.atmc.acl.db.service.impl.QuotationExtraTameeniInfoLocalServiceImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see com.ejada.atmc.acl.db.service.impl.QuotationExtraTameeniInfoLocalServiceImpl
 * @generated
 */
public abstract class QuotationExtraTameeniInfoLocalServiceBaseImpl
	extends BaseLocalServiceImpl
	implements AopService, IdentifiableOSGiService,
			   QuotationExtraTameeniInfoLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Use <code>QuotationExtraTameeniInfoLocalService</code> via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use <code>com.ejada.atmc.acl.db.service.QuotationExtraTameeniInfoLocalServiceUtil</code>.
	 */

	/**
	 * Adds the quotation extra tameeni info to the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was added
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QuotationExtraTameeniInfo addQuotationExtraTameeniInfo(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		quotationExtraTameeniInfo.setNew(true);

		return quotationExtraTameeniInfoPersistence.update(
			quotationExtraTameeniInfo);
	}

	/**
	 * Creates a new quotation extra tameeni info with the primary key. Does not add the quotation extra tameeni info to the database.
	 *
	 * @param quotationId the primary key for the new quotation extra tameeni info
	 * @return the new quotation extra tameeni info
	 */
	@Override
	@Transactional(enabled = false)
	public QuotationExtraTameeniInfo createQuotationExtraTameeniInfo(
		long quotationId) {

		return quotationExtraTameeniInfoPersistence.create(quotationId);
	}

	/**
	 * Deletes the quotation extra tameeni info with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 * @throws PortalException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QuotationExtraTameeniInfo deleteQuotationExtraTameeniInfo(
			long quotationId)
		throws PortalException {

		return quotationExtraTameeniInfoPersistence.remove(quotationId);
	}

	/**
	 * Deletes the quotation extra tameeni info from the database. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was removed
	 */
	@Indexable(type = IndexableType.DELETE)
	@Override
	public QuotationExtraTameeniInfo deleteQuotationExtraTameeniInfo(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		return quotationExtraTameeniInfoPersistence.remove(
			quotationExtraTameeniInfo);
	}

	@Override
	public DynamicQuery dynamicQuery() {
		Class<?> clazz = getClass();

		return DynamicQueryFactoryUtil.forClass(
			QuotationExtraTameeniInfo.class, clazz.getClassLoader());
	}

	/**
	 * Performs a dynamic query on the database and returns the matching rows.
	 *
	 * @param dynamicQuery the dynamic query
	 * @return the matching rows
	 */
	@Override
	public <T> List<T> dynamicQuery(DynamicQuery dynamicQuery) {
		return quotationExtraTameeniInfoPersistence.findWithDynamicQuery(
			dynamicQuery);
	}

	/**
	 * Performs a dynamic query on the database and returns a range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
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

		return quotationExtraTameeniInfoPersistence.findWithDynamicQuery(
			dynamicQuery, start, end);
	}

	/**
	 * Performs a dynamic query on the database and returns an ordered range of the matching rows.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
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

		return quotationExtraTameeniInfoPersistence.findWithDynamicQuery(
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
		return quotationExtraTameeniInfoPersistence.countWithDynamicQuery(
			dynamicQuery);
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

		return quotationExtraTameeniInfoPersistence.countWithDynamicQuery(
			dynamicQuery, projection);
	}

	@Override
	public QuotationExtraTameeniInfo fetchQuotationExtraTameeniInfo(
		long quotationId) {

		return quotationExtraTameeniInfoPersistence.fetchByPrimaryKey(
			quotationId);
	}

	/**
	 * Returns the quotation extra tameeni info with the primary key.
	 *
	 * @param quotationId the primary key of the quotation extra tameeni info
	 * @return the quotation extra tameeni info
	 * @throws PortalException if a quotation extra tameeni info with the primary key could not be found
	 */
	@Override
	public QuotationExtraTameeniInfo getQuotationExtraTameeniInfo(
			long quotationId)
		throws PortalException {

		return quotationExtraTameeniInfoPersistence.findByPrimaryKey(
			quotationId);
	}

	@Override
	public ActionableDynamicQuery getActionableDynamicQuery() {
		ActionableDynamicQuery actionableDynamicQuery =
			new DefaultActionableDynamicQuery();

		actionableDynamicQuery.setBaseLocalService(
			quotationExtraTameeniInfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(QuotationExtraTameeniInfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("quotationId");

		return actionableDynamicQuery;
	}

	@Override
	public IndexableActionableDynamicQuery
		getIndexableActionableDynamicQuery() {

		IndexableActionableDynamicQuery indexableActionableDynamicQuery =
			new IndexableActionableDynamicQuery();

		indexableActionableDynamicQuery.setBaseLocalService(
			quotationExtraTameeniInfoLocalService);
		indexableActionableDynamicQuery.setClassLoader(getClassLoader());
		indexableActionableDynamicQuery.setModelClass(
			QuotationExtraTameeniInfo.class);

		indexableActionableDynamicQuery.setPrimaryKeyPropertyName(
			"quotationId");

		return indexableActionableDynamicQuery;
	}

	protected void initActionableDynamicQuery(
		ActionableDynamicQuery actionableDynamicQuery) {

		actionableDynamicQuery.setBaseLocalService(
			quotationExtraTameeniInfoLocalService);
		actionableDynamicQuery.setClassLoader(getClassLoader());
		actionableDynamicQuery.setModelClass(QuotationExtraTameeniInfo.class);

		actionableDynamicQuery.setPrimaryKeyPropertyName("quotationId");
	}

	/**
	 * @throws PortalException
	 */
	public PersistedModel createPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return quotationExtraTameeniInfoPersistence.create(
			((Long)primaryKeyObj).longValue());
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel deletePersistedModel(PersistedModel persistedModel)
		throws PortalException {

		return quotationExtraTameeniInfoLocalService.
			deleteQuotationExtraTameeniInfo(
				(QuotationExtraTameeniInfo)persistedModel);
	}

	public BasePersistence<QuotationExtraTameeniInfo> getBasePersistence() {
		return quotationExtraTameeniInfoPersistence;
	}

	/**
	 * @throws PortalException
	 */
	@Override
	public PersistedModel getPersistedModel(Serializable primaryKeyObj)
		throws PortalException {

		return quotationExtraTameeniInfoPersistence.findByPrimaryKey(
			primaryKeyObj);
	}

	/**
	 * Returns a range of all the quotation extra tameeni infos.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>com.ejada.atmc.acl.db.model.impl.QuotationExtraTameeniInfoModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotation extra tameeni infos
	 * @param end the upper bound of the range of quotation extra tameeni infos (not inclusive)
	 * @return the range of quotation extra tameeni infos
	 */
	@Override
	public List<QuotationExtraTameeniInfo> getQuotationExtraTameeniInfos(
		int start, int end) {

		return quotationExtraTameeniInfoPersistence.findAll(start, end);
	}

	/**
	 * Returns the number of quotation extra tameeni infos.
	 *
	 * @return the number of quotation extra tameeni infos
	 */
	@Override
	public int getQuotationExtraTameeniInfosCount() {
		return quotationExtraTameeniInfoPersistence.countAll();
	}

	/**
	 * Updates the quotation extra tameeni info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	 *
	 * <p>
	 * <strong>Important:</strong> Inspect QuotationExtraTameeniInfoLocalServiceImpl for overloaded versions of the method. If provided, use these entry points to the API, as the implementation logic may require the additional parameters defined there.
	 * </p>
	 *
	 * @param quotationExtraTameeniInfo the quotation extra tameeni info
	 * @return the quotation extra tameeni info that was updated
	 */
	@Indexable(type = IndexableType.REINDEX)
	@Override
	public QuotationExtraTameeniInfo updateQuotationExtraTameeniInfo(
		QuotationExtraTameeniInfo quotationExtraTameeniInfo) {

		return quotationExtraTameeniInfoPersistence.update(
			quotationExtraTameeniInfo);
	}

	@Override
	public Class<?>[] getAopInterfaces() {
		return new Class<?>[] {
			QuotationExtraTameeniInfoLocalService.class,
			IdentifiableOSGiService.class, PersistedModelLocalService.class
		};
	}

	@Override
	public void setAopProxy(Object aopProxy) {
		quotationExtraTameeniInfoLocalService =
			(QuotationExtraTameeniInfoLocalService)aopProxy;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return QuotationExtraTameeniInfoLocalService.class.getName();
	}

	protected Class<?> getModelClass() {
		return QuotationExtraTameeniInfo.class;
	}

	protected String getModelClassName() {
		return QuotationExtraTameeniInfo.class.getName();
	}

	/**
	 * Performs a SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) {
		try {
			DataSource dataSource =
				quotationExtraTameeniInfoPersistence.getDataSource();

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

	@Reference
	protected QuotationDriversPersistence quotationDriversPersistence;

	@Reference
	protected QuotationDriverseEndorsPersistence
		quotationDriverseEndorsPersistence;

	protected QuotationExtraTameeniInfoLocalService
		quotationExtraTameeniInfoLocalService;

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

}