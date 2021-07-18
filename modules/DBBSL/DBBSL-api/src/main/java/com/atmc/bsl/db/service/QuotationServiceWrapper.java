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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link QuotationService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationService
 * @generated
 */
public class QuotationServiceWrapper
	implements QuotationService, ServiceWrapper<QuotationService> {

	public QuotationServiceWrapper(QuotationService quotationService) {
		_quotationService = quotationService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.QuotationDriver> addDriver(
			com.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress
				driverNatAddress,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress
				driverOffNatAddress) {

		return _quotationService.addDriver(
			driver, driverNatAddress, driverOffNatAddress);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> clearQuoteFile(
		String fileName, String insuredId) {

		return _quotationService.clearQuoteFile(fileName, insuredId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Integer>
		countQuotationSurveyVideo(String quoteID) {

		return _quotationService.countQuotationSurveyVideo(quoteID);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> downloadPolicyFile(
			String quoteId, String policyNo, String lang)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationService.downloadPolicyFile(quoteId, policyNo, lang);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> downloadQuotDetsFile(
			String quoteId, String lang)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationService.downloadQuotDetsFile(quoteId, lang);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.model.CodeMasterMap> getBySourceTypeSourceCode(
				String sourceType, String sourceCode)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationService.getBySourceTypeSourceCode(
			sourceType, sourceCode);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getCities() {

		return _quotationService.getCities();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> getConfigurableValues(
		java.util.List<String> keys) {

		return _quotationService.getConfigurableValues(keys);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getCountries() {

		return _quotationService.getCountries();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover>>
			getCoverList(String productCode) {

		return _quotationService.getCoverList(productCode);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getDeductibleValues() {

		return _quotationService.getDeductibleValues();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getEducationList() {

		return _quotationService.getEducationList();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getEngineSizes() {

		return _quotationService.getEngineSizes();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
			getInsuranceCompanies() {

		return _quotationService.getInsuranceCompanies();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getLicenseTypes() {

		return _quotationService.getLicenseTypes();
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getParkingLocations() {

		return _quotationService.getParkingLocations();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>>
			getPendingQuotations(String iqamaId) {

		return _quotationService.getPendingQuotations(iqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getPurposeOfVehicle() {

		return _quotationService.getPurposeOfVehicle();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationDetails(
			String quotId) {

		return _quotationService.getQuotationDetails(quotId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.domain.tariff.TariffOutput> getTariffData(
				com.ejada.atmc.acl.db.domain.tariff.TariffInput tariffInput)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationService.getTariffData(tariffInput);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> getTariffDetails(
				com.atmc.bsl.db.domain.quotation.Quotation quot,
				java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver>
					drivers)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationService.getTariffDetails(quot, drivers);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> personalInfo(
			com.atmc.bsl.db.domain.quotation.Quotation quot,
			boolean isUserSignedIn) {

		return _quotationService.personalInfo(quot, isUserSignedIn);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Double> quickQuoteInquiry(
		com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return _quotationService.quickQuoteInquiry(quot);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> renewPolicy(
			com.atmc.bsl.db.domain.policy.Policy policy,
			com.atmc.bsl.db.domain.policy.PolicyVehicle pVeh) {

		return _quotationService.renewPolicy(policy, pVeh);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> tokenizationResult(
			String status) {

		return _quotationService.tokenizationResult(status);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadQuoteFile(
		java.io.File attachFile, String fileName, String insuredId) {

		return _quotationService.uploadQuoteFile(
			attachFile, fileName, insuredId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadVideo(
		String baseArray, String fileName, String quotationId,
		java.util.Date videoDate) {

		return _quotationService.uploadVideo(
			baseArray, fileName, quotationId, videoDate);
	}

	@Override
	public QuotationService getWrappedService() {
		return _quotationService;
	}

	@Override
	public void setWrappedService(QuotationService quotationService) {
		_quotationService = quotationService;
	}

	private QuotationService _quotationService;

}