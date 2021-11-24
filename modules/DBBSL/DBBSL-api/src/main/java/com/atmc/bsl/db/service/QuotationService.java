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

package com.atmc.bsl.db.service;

import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.domain.tariff.TariffOutput;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.ejada.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationCover;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationUserAddress;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.Date;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Quotation. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface QuotationService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.QuotationServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the quotation remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link QuotationServiceUtil} if injection and service tracking are not available.
	 */
	public ServiceOutput<QuotationDriver> addDriver(
		QuotationDriver driver, QuotationUserAddress driverNatAddress,
		QuotationUserAddress driverOffNatAddress);

	public ServiceOutput<Boolean> clearQuoteFile(
		String fileName, String insuredId);

	public ServiceOutput<Integer> countQuotationSurveyVideo(String quoteID);

	public ServiceOutput<String> downloadPolicyFile(
			String quoteId, String policyNo, String lang)
		throws PortalException;

	public ServiceOutput<String> downloadQuotDetsFile(
			String quoteId, String lang)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<CodeMasterMap> getBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getCities();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<String> getConfigurableValues(List<String> keys);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getCountries();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<QuotationCover>> getCoverList(String productCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getDeductibleValues();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getEducationList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getEngineSizes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CustomerMapDetails>> getInsuranceCompanies();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getLicenseTypes();

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getParkingLocations();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<Quotation>> getPendingQuotations(String iqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CodeMasterDetails>> getPurposeOfVehicle();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<Quotation> getQuotationDetails(String quotId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<TariffOutput> getTariffData(TariffInput tariffInput)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<Quotation> getTariffDetails(
			Quotation quot, List<QuotationDriver> drivers)
		throws PortalException;

	@JSONWebService(method = "POST", value = "personal-info")
	public ServiceOutput<Quotation> personalInfo(
		Quotation quot, boolean isUserSignedIn);

	public ServiceOutput<Double> quickQuoteInquiry(Quotation quot);

	@JSONWebService(method = "POST", value = "renew-policy")
	public ServiceOutput<Quotation> renewPolicy(
		Policy policy, PolicyVehicle pVeh);

	public ServiceOutput<Quotation> tokenizationResult(String status);

	@JSONWebService(method = "POST", value = "upload-quote-file")
	public ServiceOutput<Boolean> uploadQuoteFile(
		File attachFile, String fileName, String insuredId);

	public ServiceOutput<Boolean> uploadVideo(
		String baseArray, String fileName, String quotationId, Date videoDate);

}