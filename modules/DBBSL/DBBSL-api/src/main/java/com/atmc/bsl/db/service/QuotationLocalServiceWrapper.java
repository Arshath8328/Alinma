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
 * Provides a wrapper for {@link QuotationLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationLocalService
 * @generated
 */
public class QuotationLocalServiceWrapper implements QuotationLocalService, ServiceWrapper<QuotationLocalService> {

	public QuotationLocalServiceWrapper(QuotationLocalService quotationLocalService) {

		_quotationLocalService = quotationLocalService;
	}

	@Override
	public String acceptQuotation(long quotationId, String userName, java.util.Date date, String reason) {

		return _quotationLocalService.acceptQuotation(quotationId, userName, date, reason);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR checkActivePolicy(String iqamaId, String vehId) {

		return _quotationLocalService.checkActivePolicy(iqamaId, vehId);
	}

	@Override
	public long checkExistingPolicy(String iqamaId, String vehId) {
		return _quotationLocalService.checkExistingPolicy(iqamaId, vehId);
	}

	@Override
	public int countQuotationSurveyVideo(String quoteID) {
		return _quotationLocalService.countQuotationSurveyVideo(quoteID);
	}

	@Override
	public com.ejada.atmc.acl.db.model.QuotationAdminUploads downloadAdminFiles(int fileId) {

		return _quotationLocalService.downloadAdminFiles(fileId);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CustUploads downloadCustFiles(long fileId) {

		return _quotationLocalService.downloadCustFiles(fileId);
	}

	@Override
	public java.io.File downloadPolicyReport(String quoteId, String policyNo, String lang) throws Exception {

		return _quotationLocalService.downloadPolicyReport(quoteId, policyNo, lang);
	}

	@Override
	public java.io.File downloadQuotDetsReport(String quoteId, String lang) throws Exception {

		return _quotationLocalService.downloadQuotDetsReport(quoteId, lang);
	}

	@Override
	public byte[] findCustuploadsChassisNo(long id) {
		return _quotationLocalService.findCustuploadsChassisNo(id);
	}

	@Override
	public byte[] findCustuploadsIstCardFile(long id) {
		return _quotationLocalService.findCustuploadsIstCardFile(id);
	}

	@Override
	public byte[] findCustuploadsLeaseFile(long id) {
		return _quotationLocalService.findCustuploadsLeaseFile(id);
	}

	@Override
	public byte[] findCustuploadsVehBack(long id) {
		return _quotationLocalService.findCustuploadsVehBack(id);
	}

	@Override
	public byte[] findCustuploadsVehFront(long id) {
		return _quotationLocalService.findCustuploadsVehFront(id);
	}

	@Override
	public byte[] findCustuploadsVehLeft(long id) {
		return _quotationLocalService.findCustuploadsVehLeft(id);
	}

	@Override
	public byte[] findCustuploadsVehRight(long id) {
		return _quotationLocalService.findCustuploadsVehRight(id);
	}

	@Override
	public byte[] findInsuredRelationProof(long addDriverId) {
		return _quotationLocalService.findInsuredRelationProof(addDriverId);
	}

	@Override
	public String findPolicyNajmStatus(String policyNo) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.findPolicyNajmStatus(policyNo);
	}

	@Override
	public byte[] findQuotationSurveyFile(long id) {
		return _quotationLocalService.findQuotationSurveyFile(id);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.QuotationSurvey> findQuotationSurveyVideo(String quoteID) {

		return _quotationLocalService.findQuotationSurveyVideo(quoteID);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> geEngineSizes() {

		return _quotationLocalService.geEngineSizes();
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getAdminQuotationByQuotationId(long quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getAdminQuotationByQuotationId(quotationId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getAdminQuotations(int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getAdminQuotations(start, end);
	}

	@Override
	public int getAdminQuotationsCount() throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getAdminQuotationsCount();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getAllPendingQuotations(java.util.Date expiryDate,
			String quoteStatus, boolean smsFlag) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getAllPendingQuotations(expiryDate, quoteStatus, smsFlag);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getCities() {

		return _quotationLocalService.getCities();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getCountries() {

		return _quotationLocalService.getCountries();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover> getCoverList(String productCode) {

		return _quotationLocalService.getCoverList(productCode);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover> getCustomCovers(
			java.util.List<com.ejada.atmc.acl.db.model.ProductCovers> pCovers) {

		return _quotationLocalService.getCustomCovers(pCovers);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.QuotationCustUploads getCustomQuotationCustUploads(String quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getCustomQuotationCustUploads(quotationId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getCustomQuotations(
			java.util.List<com.ejada.atmc.acl.db.model.Quotations> quotationsList, boolean isTameeni) {

		return _quotationLocalService.getCustomQuotations(quotationsList, isTameeni);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getDeductibleValues() {

		return _quotationLocalService.getDeductibleValues();
	}

	@Override
	public String getDriverNationalityAr(String driverNa) {
		return _quotationLocalService.getDriverNationalityAr(driverNa);
	}

	@Override
	public String getDriverNationalityEn(String driverNa) {
		return _quotationLocalService.getDriverNationalityEn(driverNa);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getEducationList() {

		return _quotationLocalService.getEducationList();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getExpiredQuotsByDate(java.util.Date expiryDate,
			String[] status) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getExpiredQuotsByDate(expiryDate, status);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails> getInsuranceCompanies() {

		return _quotationLocalService.getInsuranceCompanies();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails> getInsuranceCompany(String premiaCode) {

		return _quotationLocalService.getInsuranceCompany(premiaCode);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getLicenseTypes() {

		return _quotationLocalService.getLicenseTypes();
	}

	@Override
	public String getNajmStatusByPolicyNo(String policyNo) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getNajmStatusByPolicyNo(policyNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _quotationLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getParkingLocations() {

		return _quotationLocalService.getParkingLocations();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getPendingPaymentSurveyQuotations(long iqamaId) {

		return _quotationLocalService.getPendingPaymentSurveyQuotations(iqamaId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getPendingQuotations(long iqamaId) {

		return _quotationLocalService.getPendingQuotations(iqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getPolicyQuot(com.atmc.bsl.db.domain.policy.Policy policy)
			throws com.atmc.bsl.db.exception.YaqeenException {

		return _quotationLocalService.getPolicyQuot(policy);
	}

	@Override
	public String getProductDescAr(String productCode) {
		return _quotationLocalService.getProductDescAr(productCode);
	}

	@Override
	public String getProductDescEn(String productCode) {
		return _quotationLocalService.getProductDescEn(productCode);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getPurposeOfVehicle() {

		return _quotationLocalService.getPurposeOfVehicle();
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getQuotationByQuotationId(long quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getQuotationByQuotationId(quotationId);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getQuotationByReferenceNo(String referenceNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getQuotationByReferenceNo(referenceNo);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getQuotationDetails(
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return _quotationLocalService.getQuotationDetails(quot);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotations(String status, long iqamaId,
			boolean andSearch, int start, int end) throws com.liferay.portal.kernel.exception.SystemException {

		return _quotationLocalService.getQuotations(status, iqamaId, andSearch, start, end);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationsByIqamaId(long iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getQuotationsByIqamaId(iqamaId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationsByIqamaIdAndStatus(long iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getQuotationsByIqamaIdAndStatus(iqamaId);
	}

	@Override
	public Long getQuotationsCount(String status, long iqamaId, boolean andSearch)
			throws com.liferay.portal.kernel.exception.SystemException {

		return _quotationLocalService.getQuotationsCount(status, iqamaId, andSearch);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails getQuotationTameeniExtras(long quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getQuotationTameeniExtras(quotationId);
	}

	@Override
	public java.util.Map<String, Object> getQuoteDetailsReportParams(javax.servlet.http.HttpServletRequest httpReq,
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return _quotationLocalService.getQuoteDetailsReportParams(httpReq, quot);
	}

	@Override
	public java.util.Map<String, Object> getQuoteDetailsReportParams(String lang,
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return _quotationLocalService.getQuoteDetailsReportParams(lang, quot);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.db.model.Quotations> getQuotsByQuoteStatus(String quoteStatus) {

		return _quotationLocalService.getQuotsByQuoteStatus(quoteStatus);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation getTariffDets(com.atmc.bsl.db.domain.quotation.Quotation quot,
			boolean isRenewal) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.getTariffDets(quot, isRenewal);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver> getUnderAgeDriversList(long quotationId) {

		return _quotationLocalService.getUnderAgeDriversList(quotationId);
	}

	/**
	 * @return the statusDescAr
	 */
	@Override
	public String getVehicleIdDescAr(String vichelIdype) {
		return _quotationLocalService.getVehicleIdDescAr(vichelIdype);
	}

	@Override
	public String getVehicleIdDescEn(String vichelIdype) {
		return _quotationLocalService.getVehicleIdDescEn(vichelIdype);
	}

	@Override
	public void issuePolicy(com.atmc.bsl.db.domain.quotation.Quotation quot) {

		_quotationLocalService.issuePolicy(quot);
	}

	@Override
	public void notifyUser(javax.servlet.http.HttpServletRequest httpRequest,
			com.atmc.bsl.db.domain.quotation.Quotation quot, java.util.Locale local,
			com.liferay.portal.kernel.model.User user) {

		_quotationLocalService.notifyUser(httpRequest, quot, local, user);
	}

	@Override
	public String olpInitiatePmnt(String olpAlias, double amount, String currency, String merchantLandingURL,
			String merchantFailureURL) {

		return _quotationLocalService.olpInitiatePmnt(olpAlias, amount, currency, merchantLandingURL,
				merchantFailureURL);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse payFortPurchase(double amount, String currency,
			String customerEmail, String language, String merchantReference, String tokenName, String paymentOption,
			String cardSecurityCode, String clientIpAddress, String returnUrl) {

		return _quotationLocalService.payFortPurchase(amount, currency, customerEmail, language, merchantReference,
				tokenName, paymentOption, cardSecurityCode, clientIpAddress, returnUrl);
	}

	@Override
	public void rejectQuotation(long quotationId, String userName, java.util.Date date, String reason, String status) {

		_quotationLocalService.rejectQuotation(quotationId, userName, date, reason, status);
	}

	@Override
	public void removeAdminFiles(int fileId) {
		_quotationLocalService.removeAdminFiles(fileId);
	}

	@Override
	public void renewAddressInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot, java.util.Locale locale)
			throws com.atmc.bsl.db.exception.YaqeenException {

		_quotationLocalService.renewAddressInquiry(quot, locale);
	}

	@Override
	public void renewNcdInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot)
			throws com.atmc.bsl.db.exception.NajmException {

		_quotationLocalService.renewNcdInquiry(quot);
	}

	@Override
	public void renewTariffInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot) {

		_quotationLocalService.renewTariffInquiry(quot);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation reviewQuotation(com.atmc.bsl.db.domain.quotation.Quotation quot,
			boolean isUserSignedIn, String lang) throws com.liferay.portal.kernel.exception.PortalException {

		return _quotationLocalService.reviewQuotation(quot, isUserSignedIn, lang);
	}

	@Override
	public void saveAdminFiles(long quotationId, java.io.File adminFile, String fileName) {

		_quotationLocalService.saveAdminFiles(quotationId, adminFile, fileName);
	}

	@Override
	public void saveNajmCaseDetails(
			java.util.ArrayList<com.atmc.bsl.db.domain.quotation.QuotationNajmDetails> najmDetailsList,
			long quotationId) {

		_quotationLocalService.saveNajmCaseDetails(najmDetailsList, quotationId);
	}

	@Override
	public void saveQuoteUserAddress(com.atmc.bsl.db.domain.quotation.QuotationUserAddress custUserNatAddr,
			long quotationId, long insuredId, boolean isNatAddress) {

		_quotationLocalService.saveQuoteUserAddress(custUserNatAddr, quotationId, insuredId, isNatAddress);
	}

	@Override
	public boolean saveQuotSurvey(String quotationId, byte[] surveyVideo, String name, java.util.Date date) {

		return _quotationLocalService.saveQuotSurvey(quotationId, surveyVideo, name, date);
	}

	@Override
	public com.atmc.bsl.db.domain.quotation.Quotation submitQuotation(
			com.atmc.bsl.db.domain.quotation.Quotation customQuot, String userId) {

		return _quotationLocalService.submitQuotation(customQuot, userId);
	}

	@Override
	public void updateQuotationTameeniExtras(com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails details) {

		_quotationLocalService.updateQuotationTameeniExtras(details);
	}

	@Override
	public void updateQuoteFlag(long quotId, boolean smsFlag)
			throws com.liferay.portal.kernel.exception.PortalException {

		_quotationLocalService.updateQuoteFlag(quotId, smsFlag);
	}

	@Override
	public void updateQuoteStatus(long quotId, String status)
			throws com.liferay.portal.kernel.exception.PortalException {

		_quotationLocalService.updateQuoteStatus(quotId, status);
	}

	@Override
	public boolean validatePolicyData(String policyNo) {
		return _quotationLocalService.validatePolicyData(policyNo);
	}

	@Override
	public void vehicleImagesUpload(long quotationId,
			java.util.List<com.atmc.bsl.db.domain.quotation.QuotationVehicleImage> vehicleImagesList) {

		_quotationLocalService.vehicleImagesUpload(quotationId, vehicleImagesList);
	}

	@Override
	public QuotationLocalService getWrappedService() {
		return _quotationLocalService;
	}

	@Override
	public void setWrappedService(QuotationLocalService quotationLocalService) {
		_quotationLocalService = quotationLocalService;
	}

	private QuotationLocalService _quotationLocalService;

}