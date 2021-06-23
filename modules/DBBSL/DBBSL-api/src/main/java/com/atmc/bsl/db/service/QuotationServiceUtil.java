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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Quotation. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.QuotationServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be accessed
 * remotely.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationService
 * @generated
 */
public class QuotationServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.QuotationServiceImpl</code> and rerun
	 * ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.QuotationDriver> addDriver(
			com.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress driverNatAddress,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress driverOffNatAddress) {

		return getService().addDriver(driver, driverNatAddress, driverOffNatAddress);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> clearQuoteFile(String fileName, String insuredId) {

		return getService().clearQuoteFile(fileName, insuredId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Integer> countQuotationSurveyVideo(String quoteID) {

		return getService().countQuotationSurveyVideo(quoteID);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> downloadPolicyFile(String quoteId, String policyNo,
			String lang) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().downloadPolicyFile(quoteId, policyNo, lang);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> downloadQuotDetsFile(String quoteId, String lang)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().downloadQuotDetsFile(quoteId, lang);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.model.CodeMasterMap> getBySourceTypeSourceCode(
			String sourceType, String sourceCode) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getBySourceTypeSourceCode(sourceType, sourceCode);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCities() {

		return getService().getCities();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> getConfigurableValues(java.util.List<String> keys) {

		return getService().getConfigurableValues(keys);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCountries() {

		return getService().getCountries();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover>> getCoverList(
			String productCode) {

		return getService().getCoverList(productCode);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getDeductibleValues() {

		return getService().getDeductibleValues();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getEducationList() {

		return getService().getEducationList();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getEngineSizes() {

		return getService().getEngineSizes();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>> getInsuranceCompanies() {

		return getService().getInsuranceCompanies();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getLicenseTypes() {

		return getService().getLicenseTypes();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getParkingLocations() {

		return getService().getParkingLocations();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>> getPendingQuotations(
			String iqamaId) {

		return getService().getPendingQuotations(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getPurposeOfVehicle() {

		return getService().getPurposeOfVehicle();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationDetails(
			String quotId) {

		return getService().getQuotationDetails(quotId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.domain.tariff.TariffOutput> getTariffData(
			com.ejada.atmc.acl.db.domain.tariff.TariffInput tariffInput)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTariffData(tariffInput);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> getTariffDetails(
			com.atmc.bsl.db.domain.quotation.Quotation quot,
			java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver> drivers)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTariffDetails(quot, drivers);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> personalInfo(
			com.atmc.bsl.db.domain.quotation.Quotation quot, boolean isUserSignedIn) {

		return getService().personalInfo(quot, isUserSignedIn);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Double> quickQuoteInquiry(
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return getService().quickQuoteInquiry(quot);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> renewPolicy(
			com.atmc.bsl.db.domain.policy.Policy policy, com.atmc.bsl.db.domain.policy.PolicyVehicle pVeh) {

		return getService().renewPolicy(policy, pVeh);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> tokenizationResult(
			String status) {

		return getService().tokenizationResult(status);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadQuoteFile(java.io.File attachFile,
			String fileName, String insuredId) {

		return getService().uploadQuoteFile(attachFile, fileName, insuredId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadVideo(String baseArray, String fileName,
			String quotationId, java.util.Date videoDate) {

		return getService().uploadVideo(baseArray, fileName, quotationId, videoDate);
	}

	public static QuotationService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuotationService, QuotationService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuotationService.class);

		ServiceTracker<QuotationService, QuotationService> serviceTracker = new ServiceTracker<QuotationService, QuotationService>(
				bundle.getBundleContext(), QuotationService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}