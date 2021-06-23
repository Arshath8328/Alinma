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
 * Provides the local service utility for Quotation. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.QuotationLocalServiceImpl</code> and is an
 * access point for service operations in application layer code running on the
 * local server. Methods of this service will not have security checks based on
 * the propagated JAAS credentials because this service can only be accessed
 * from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationLocalService
 * @generated
 */
public class QuotationLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to
	 * <code>com.atmc.bsl.db.service.impl.QuotationLocalServiceImpl</code> and rerun
	 * ServiceBuilder to regenerate this class.
	 */
	public static String acceptQuotation(long quotationId, String userName, java.util.Date date, String reason) {

		return getService().acceptQuotation(quotationId, userName, date, reason);
	}

	public static com.ejada.atmc.acl.db.model.PolicyHDR checkActivePolicy(String iqamaId, String vehId) {

		return getService().checkActivePolicy(iqamaId, vehId);
	}

	public static long checkExistingPolicy(String iqamaId, String vehId) {
		return getService().checkExistingPolicy(iqamaId, vehId);
	}

	public static int countQuotationSurveyVideo(String quoteID) {
		return getService().countQuotationSurveyVideo(quoteID);
	}

	public static com.ejada.atmc.acl.db.model.QuotationAdminUploads downloadAdminFiles(int fileId) {

		return getService().downloadAdminFiles(fileId);
	}

	public static com.ejada.atmc.acl.db.model.CustUploads downloadCustFiles(long fileId) {

		return getService().downloadCustFiles(fileId);
	}

	public static java.io.File downloadPolicyReport(String quoteId, String policyNo, String lang) throws Exception {

		return getService().downloadPolicyReport(quoteId, policyNo, lang);
	}

	public static java.io.File downloadQuotDetsReport(String quoteId, String lang) throws Exception {

		return getService().downloadQuotDetsReport(quoteId, lang);
	}

	public static byte[] findCustuploadsChassisNo(long id) {
		return getService().findCustuploadsChassisNo(id);
	}

	public static byte[] findCustuploadsIstCardFile(long id) {
		return getService().findCustuploadsIstCardFile(id);
	}

	public static byte[] findCustuploadsLeaseFile(long id) {
		return getService().findCustuploadsLeaseFile(id);
	}

	public static byte[] findCustuploadsVehBack(long id) {
		return getService().findCustuploadsVehBack(id);
	}

	public static byte[] findCustuploadsVehFront(long id) {
		return getService().findCustuploadsVehFront(id);
	}

	public static byte[] findCustuploadsVehLeft(long id) {
		return getService().findCustuploadsVehLeft(id);
	}

	public static byte[] findCustuploadsVehRight(long id) {
		return getService().findCustuploadsVehRight(id);
	}

	public static byte[] findInsuredRelationProof(long addDriverId) {
		return getService().findInsuredRelationProof(addDriverId);
	}

	public static String findPolicyNajmStatus(String policyNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findPolicyNajmStatus(policyNo);
	}

	public static byte[] findQuotationSurveyFile(long id) {
		return getService().findQuotationSurveyFile(id);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.QuotationSurvey> findQuotationSurveyVideo(String quoteID) {

		return getService().findQuotationSurveyVideo(quoteID);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> geEngineSizes() {

		return getService().geEngineSizes();
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getAdminQuotationByQuotationId(long quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAdminQuotationByQuotationId(quotationId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getAdminQuotations(int start, int end)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAdminQuotations(start, end);
	}

	public static int getAdminQuotationsCount() throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAdminQuotationsCount();
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getAllPendingQuotations(
			java.util.Date expiryDate, String quoteStatus, boolean smsFlag)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllPendingQuotations(expiryDate, quoteStatus, smsFlag);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getCities() {

		return getService().getCities();
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getCountries() {

		return getService().getCountries();
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover> getCoverList(String productCode) {

		return getService().getCoverList(productCode);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover> getCustomCovers(
			java.util.List<com.ejada.atmc.acl.db.model.ProductCovers> pCovers) {

		return getService().getCustomCovers(pCovers);
	}

	public static com.atmc.bsl.db.domain.quotation.QuotationCustUploads getCustomQuotationCustUploads(
			String quotationId) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getCustomQuotationCustUploads(quotationId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getCustomQuotations(
			java.util.List<com.ejada.atmc.acl.db.model.Quotations> quotationsList, boolean isTameeni) {

		return getService().getCustomQuotations(quotationsList, isTameeni);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getDeductibleValues() {

		return getService().getDeductibleValues();
	}

	public static String getDriverNationalityAr(String driverNa) {
		return getService().getDriverNationalityAr(driverNa);
	}

	public static String getDriverNationalityEn(String driverNa) {
		return getService().getDriverNationalityEn(driverNa);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getEducationList() {

		return getService().getEducationList();
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getExpiredQuotsByDate(
			java.util.Date expiryDate, String[] status) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getExpiredQuotsByDate(expiryDate, status);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails> getInsuranceCompanies() {

		return getService().getInsuranceCompanies();
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails> getInsuranceCompany(
			String premiaCode) {

		return getService().getInsuranceCompany(premiaCode);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getLicenseTypes() {

		return getService().getLicenseTypes();
	}

	public static String getNajmStatusByPolicyNo(String policyNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNajmStatusByPolicyNo(policyNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getParkingLocations() {

		return getService().getParkingLocations();
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getPendingPaymentSurveyQuotations(
			long iqamaId) {

		return getService().getPendingPaymentSurveyQuotations(iqamaId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getPendingQuotations(long iqamaId) {

		return getService().getPendingQuotations(iqamaId);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getPolicyQuot(com.atmc.bsl.db.domain.policy.Policy policy)
			throws com.atmc.bsl.db.exception.YaqeenException {

		return getService().getPolicyQuot(policy);
	}

	public static String getProductDescAr(String productCode) {
		return getService().getProductDescAr(productCode);
	}

	public static String getProductDescEn(String productCode) {
		return getService().getProductDescEn(productCode);
	}

	public static java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails> getPurposeOfVehicle() {

		return getService().getPurposeOfVehicle();
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getQuotationByQuotationId(long quotationId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationByQuotationId(quotationId);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getQuotationByReferenceNo(String referenceNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationByReferenceNo(referenceNo);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getQuotationDetails(
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return getService().getQuotationDetails(quot);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotations(String status, long iqamaId,
			boolean andSearch, int start, int end) throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getQuotations(status, iqamaId, andSearch, start, end);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationsByIqamaId(long iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationsByIqamaId(iqamaId);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationsByIqamaIdAndStatus(
			long iqamaId) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationsByIqamaIdAndStatus(iqamaId);
	}

	public static Long getQuotationsCount(String status, long iqamaId, boolean andSearch)
			throws com.liferay.portal.kernel.exception.SystemException {

		return getService().getQuotationsCount(status, iqamaId, andSearch);
	}

	public static com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails getQuotationTameeniExtras(
			long quotationId) throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getQuotationTameeniExtras(quotationId);
	}

	public static java.util.Map<String, Object> getQuoteDetailsReportParams(
			javax.servlet.http.HttpServletRequest httpReq, com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return getService().getQuoteDetailsReportParams(httpReq, quot);
	}

	public static java.util.Map<String, Object> getQuoteDetailsReportParams(String lang,
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		return getService().getQuoteDetailsReportParams(lang, quot);
	}

	public static java.util.List<com.ejada.atmc.acl.db.model.Quotations> getQuotsByQuoteStatus(String quoteStatus) {

		return getService().getQuotsByQuoteStatus(quoteStatus);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation getTariffDets(
			com.atmc.bsl.db.domain.quotation.Quotation quot, boolean isRenewal)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getTariffDets(quot, isRenewal);
	}

	public static java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver> getUnderAgeDriversList(
			long quotationId) {

		return getService().getUnderAgeDriversList(quotationId);
	}

	/**
	 * @return the statusDescAr
	 */
	public static String getVehicleIdDescAr(String vichelIdype) {
		return getService().getVehicleIdDescAr(vichelIdype);
	}

	public static String getVehicleIdDescEn(String vichelIdype) {
		return getService().getVehicleIdDescEn(vichelIdype);
	}

	public static void issuePolicy(com.atmc.bsl.db.domain.quotation.Quotation quot) {

		getService().issuePolicy(quot);
	}

	public static void notifyUser(javax.servlet.http.HttpServletRequest httpRequest,
			com.atmc.bsl.db.domain.quotation.Quotation quot, java.util.Locale local,
			com.liferay.portal.kernel.model.User user) {

		getService().notifyUser(httpRequest, quot, local, user);
	}

	public static String olpInitiatePmnt(String olpAlias, double amount, String currency, String merchantLandingURL,
			String merchantFailureURL) {

		return getService().olpInitiatePmnt(olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
	}

	public static com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse payFortPurchase(double amount, String currency,
			String customerEmail, String language, String merchantReference, String tokenName, String paymentOption,
			String cardSecurityCode, String clientIpAddress, String returnUrl) {

		return getService().payFortPurchase(amount, currency, customerEmail, language, merchantReference, tokenName,
				paymentOption, cardSecurityCode, clientIpAddress, returnUrl);
	}

	public static void rejectQuotation(long quotationId, String userName, java.util.Date date, String reason,
			String status) {

		getService().rejectQuotation(quotationId, userName, date, reason, status);
	}

	public static void removeAdminFiles(int fileId) {
		getService().removeAdminFiles(fileId);
	}

	public static void renewAddressInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot, java.util.Locale locale)
			throws com.atmc.bsl.db.exception.YaqeenException {

		getService().renewAddressInquiry(quot, locale);
	}

	public static void renewNcdInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot)
			throws com.atmc.bsl.db.exception.NajmException {

		getService().renewNcdInquiry(quot);
	}

	public static void renewTariffInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot) {

		getService().renewTariffInquiry(quot);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation reviewQuotation(
			com.atmc.bsl.db.domain.quotation.Quotation quot, boolean isUserSignedIn, String lang)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().reviewQuotation(quot, isUserSignedIn, lang);
	}

	public static void saveAdminFiles(long quotationId, java.io.File adminFile, String fileName) {

		getService().saveAdminFiles(quotationId, adminFile, fileName);
	}

	public static void saveNajmCaseDetails(
			java.util.ArrayList<com.atmc.bsl.db.domain.quotation.QuotationNajmDetails> najmDetailsList,
			long quotationId) {

		getService().saveNajmCaseDetails(najmDetailsList, quotationId);
	}

	public static void saveQuoteUserAddress(com.atmc.bsl.db.domain.quotation.QuotationUserAddress custUserNatAddr,
			long quotationId, long insuredId, boolean isNatAddress) {

		getService().saveQuoteUserAddress(custUserNatAddr, quotationId, insuredId, isNatAddress);
	}

	public static boolean saveQuotSurvey(String quotationId, byte[] surveyVideo, String name, java.util.Date date) {

		return getService().saveQuotSurvey(quotationId, surveyVideo, name, date);
	}

	public static com.atmc.bsl.db.domain.quotation.Quotation submitQuotation(
			com.atmc.bsl.db.domain.quotation.Quotation customQuot, String userId) {

		return getService().submitQuotation(customQuot, userId);
	}

	public static void updateQuotationTameeniExtras(
			com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails details) {

		getService().updateQuotationTameeniExtras(details);
	}

	public static void updateQuoteFlag(long quotId, boolean smsFlag)
			throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateQuoteFlag(quotId, smsFlag);
	}

	public static void updateQuoteStatus(long quotId, String status)
			throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateQuoteStatus(quotId, status);
	}

	public static boolean validatePolicyData(String policyNo) {
		return getService().validatePolicyData(policyNo);
	}

	public static void vehicleImagesUpload(long quotationId,
			java.util.List<com.atmc.bsl.db.domain.quotation.QuotationVehicleImage> vehicleImagesList) {

		getService().vehicleImagesUpload(quotationId, vehicleImagesList);
	}

	public static QuotationLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<QuotationLocalService, QuotationLocalService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(QuotationLocalService.class);

		ServiceTracker<QuotationLocalService, QuotationLocalService> serviceTracker = new ServiceTracker<QuotationLocalService, QuotationLocalService>(
				bundle.getBundleContext(), QuotationLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}