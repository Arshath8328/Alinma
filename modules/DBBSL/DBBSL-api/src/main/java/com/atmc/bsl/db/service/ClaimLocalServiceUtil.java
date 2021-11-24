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
 * Provides the local service utility for Claim. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.ClaimLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalService
 * @generated
 */
public class ClaimLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.ClaimLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static void addWorkflowStatus(String claimRefNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().addWorkflowStatus(claimRefNo);
	}

	public static byte[] adminUploadFile(int id) {
		return getService().adminUploadFile(id);
	}

	public static int checkIbanValidation(String iban) {
		return getService().checkIbanValidation(iban);
	}

	public static java.io.File downloadClaimReport(
		com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt,
		String claimintName, String claimintMobile, String claimintEmail,
		String claimintId, String lang) {

		return getService().downloadClaimReport(
			odsClaimInt, claimintName, claimintMobile, claimintEmail,
			claimintId, lang);
	}

	public static byte[] findBankIbanFile(int id) {
		return getService().findBankIbanFile(id);
	}

	public static int findClaimsCountsPolicyStatusAdmin(
			String status, String Surveyor, String refNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findClaimsCountsPolicyStatusAdmin(
			status, Surveyor, refNo);
	}

	public static byte[] findDamageEstQuotFile(int id) {
		return getService().findDamageEstQuotFile(id);
	}

	public static byte[] findNajmSlipFile(int id) {
		return getService().findNajmSlipFile(id);
	}

	public static byte[] findODDriverLicenseFile(int id) {
		return getService().findODDriverLicenseFile(id);
	}

	public static byte[] findODPolicyCopyFile(int id) {
		return getService().findODPolicyCopyFile(id);
	}

	public static byte[] findODVehRegistFile(int id) {
		return getService().findODVehRegistFile(id);
	}

	public static byte[] findOwnerIdFile(int id) {
		return getService().findOwnerIdFile(id);
	}

	public static byte[] findTPBankIbanFile(int id) {
		return getService().findTPBankIbanFile(id);
	}

	public static byte[] findTPDriverLicenseFile(int id) {
		return getService().findTPDriverLicenseFile(id);
	}

	public static byte[] findTPFrontPhotoFile(int id) {
		return getService().findTPFrontPhotoFile(id);
	}

	public static byte[] findTPLeftSidePhotoFile(int id) {
		return getService().findTPLeftSidePhotoFile(id);
	}

	public static byte[] findTPOwnerIdFile(int id) {
		return getService().findTPOwnerIdFile(id);
	}

	public static byte[] findTPRearPhotoFile(int id) {
		return getService().findTPRearPhotoFile(id);
	}

	public static byte[] findTPRightSidePhotoFile(int id) {
		return getService().findTPRightSidePhotoFile(id);
	}

	public static byte[] findTPVehRegistFile(int id) {
		return getService().findTPVehRegistFile(id);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>
			getAllClaims(
				String status, String surveyor, String refNo, int from, int to)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getAllClaims(status, surveyor, refNo, from, to);
	}

	public static String getCityCoreCode(String cityCode) {
		return getService().getCityCoreCode(cityCode);
	}

	public static String getCityDescAr(String cityCode) {
		return getService().getCityDescAr(cityCode);
	}

	public static String getCityDescEn(String cityCode) {
		return getService().getCityDescEn(cityCode);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.Claim getClaimDetails(
			String claimNumber, String policyNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimDetails(claimNumber, policyNumber);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.Claim getClaimDetailsByClaimNO(
			String claimNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimDetailsByClaimNO(claimNumber);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>
			getClaimsByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsByIqamaId(iqamaId);
	}

	public static java.util.HashMap<String, Object> getClaimsOutline(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsOutline(iqamaId);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>
			getClaimsSummary(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsSummary(iqamaId);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>
			getClaimsSummaryFiter(
				String iqamaId, String status, String policyType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsSummaryFiter(iqamaId, status, policyType);
	}

	public static java.util.List
		<com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails>
			getInsuranceCompanies() {

		return getService().getInsuranceCompanies();
	}

	public static com.ejada.atmc.acl.db.model.ODMuroorUploads
		getMuroorODFileUploads(String claimRefNo) {

		return getService().getMuroorODFileUploads(claimRefNo);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.MuroorODUploads
		getMuroorODUploadsData(String refNo) {

		return getService().getMuroorODUploadsData(refNo);
	}

	public static com.ejada.atmc.acl.db.model.MuroorTPUploads
		getMuroorTPFileUploads(String claimRefNo) {

		return getService().getMuroorTPFileUploads(claimRefNo);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.MuroorTPUploads
		getMuroorTPUploadsData(String refNo) {

		return getService().getMuroorTPUploadsData(refNo);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.NajmClaim>
		getNajmClaimByCaseNo(String caseNo) {

		return getService().getNajmClaimByCaseNo(caseNo);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.NajmClaim>
			getNajmClaimByCustomId(String caseNo, String customId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNajmClaimByCustomId(caseNo, customId);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.NajmClaim>
			getNajmClaimByNajmPlateNumber(String caseNo, String najmPlateNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNajmClaimByNajmPlateNumber(caseNo, najmPlateNo);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.NajmClaimIntimation
			getNajmClaimIntimationByCustomId(
				String caseNo, String vehicleCustomId, String language)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNajmClaimIntimationByCustomId(
			caseNo, vehicleCustomId, language);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.NajmClaimIntimation
			getNajmClaimIntimationByPlateNumber(
				String caseNo, String plateNumber, String language)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getNajmClaimIntimationByPlateNumber(
			caseNo, plateNumber, language);
	}

	public static com.ejada.atmc.acl.db.model.CLMNajmUploads getNajmFileUploads(
		String claimRefNo) {

		return getService().getNajmFileUploads(claimRefNo);
	}

	public static com.ejada.atmc.acl.db.model.PolicyHDR getNajmOtherPartyPolicy(
		String najmCaseNo) {

		return getService().getNajmOtherPartyPolicy(najmCaseNo);
	}

	public static java.util.List<Object[]> getNajmUploadsFilesName(
		String refNo) {

		return getService().getNajmUploadsFilesName(refNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow>
		getRoleWorkflow(String role) {

		return getService().getRoleWorkflow(role);
	}

	public static java.util.List<com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow>
		getRoleWorkflowByRoleStatus(String role, String status) {

		return getService().getRoleWorkflowByRoleStatus(role, status);
	}

	public static com.ejada.atmc.acl.db.model.PolicyHDR getVehiclePolicy(
			String vehicleSeqCustom)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException,
			   com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().getVehiclePolicy(vehicleSeqCustom);
	}

	public static com.ejada.atmc.acl.db.model.PolicyHDR getVehiclePolicy(
			String plateNo, String plateL1, String plateL2, String plateL3,
			String language)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException,
			   com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return getService().getVehiclePolicy(
			plateNo, plateL1, plateL2, plateL3, language);
	}

	public static com.ejada.atmc.bsl.db.domain.claim.ClaimIntimation intimateClaim(
			String claimType, String vehicleIdentType,
			String vehicleIdentNumber, String plateL1, String plateL2,
			String plateL3, String reportMode, String reportNumber,
			String causeOfLoss, String natureOfLoss, java.util.Locale locale)
		throws Exception {

		return getService().intimateClaim(
			claimType, vehicleIdentType, vehicleIdentNumber, plateL1, plateL2,
			plateL3, reportMode, reportNumber, causeOfLoss, natureOfLoss,
			locale);
	}

	public static void removeAdminFiles(int fileId) {
		getService().removeAdminFiles(fileId);
	}

	public static void saveAdminFiles(
		String refNo, java.io.File adminFile, String fileName) {

		getService().saveAdminFiles(refNo, adminFile, fileName);
	}

	public static void saveNajmSubmitedDoc(
		String caseNo, String cipiId, java.io.File najmSlipFile,
		String najmSlipFileName, java.io.File damageEstQuotFile,
		String damageEstQuotFileName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName, String claimRefNo) {

		getService().saveNajmSubmitedDoc(
			caseNo, cipiId, najmSlipFile, najmSlipFileName, damageEstQuotFile,
			damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
			ownerIdFileName, claimRefNo);
	}

	public static void saveNajmSubmitedFiles(
		String caseNo, String cipiId, java.io.File najmSlipFile,
		String najmSlipFileName, java.io.File damageEstQuotFile,
		String damageEstQuotFileName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName, String claimRefNo) {

		getService().saveNajmSubmitedFiles(
			caseNo, cipiId, najmSlipFile, najmSlipFileName, damageEstQuotFile,
			damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
			ownerIdFileName, claimRefNo);
	}

	public static void saveODMuroorDoc(
		String iqamaId, String clmIntimationNo, java.io.File driverLicenseFile,
		String driverLicenseFileName, java.io.File vehRegistFile,
		String vehRegistFileName, java.io.File policyCopyFile,
		String policyCopyFileName) {

		getService().saveODMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, policyCopyFile,
			policyCopyFileName);
	}

	public static void saveTPMuroorDoc(
		String iqamaId, String clmIntimationNo, java.io.File driverLicenseFile,
		String driverLicenseFileName, java.io.File vehRegistFile,
		String vehRegistFileName, java.io.File frontPhoto,
		String frontPhotoName, java.io.File rarePhoto, String rarePhotoName,
		java.io.File rightSidePhoto, String rightSidePhotoName,
		java.io.File leftSidePhoto, String leftSidePhotoName,
		java.io.File bankIbanFile, String bankIbanFileName,
		java.io.File ownerIdFile, String ownerIdFileName) {

		getService().saveTPMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, frontPhoto, frontPhotoName,
			rarePhoto, rarePhotoName, rightSidePhoto, rightSidePhotoName,
			leftSidePhoto, leftSidePhotoName, bankIbanFile, bankIbanFileName,
			ownerIdFile, ownerIdFileName);
	}

	public static com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse submitClaim(
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().submitClaim(odsClaimInt);
	}

	public static String submitClaimFn(
			String referenceno, String source, String transaction,
			String policyno, String reportmode, String reportno,
			String vehidentitype, String vehidentivalue, String lossnature,
			String losscause, String lossdate, String lossremarks,
			int faultpercent, String losslocation, String tpdrivername,
			String tpdob, String tpid, String tpvehidentitype,
			String tpvehidentivalue, String tpplateno, String tpinsco,
			String tpmobile, String tpiban, String tpnationality, double amount,
			String damageflag)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().submitClaimFn(
			referenceno, source, transaction, policyno, reportmode, reportno,
			vehidentitype, vehidentivalue, lossnature, losscause, lossdate,
			lossremarks, faultpercent, losslocation, tpdrivername, tpdob, tpid,
			tpvehidentitype, tpvehidentivalue, tpplateno, tpinsco, tpmobile,
			tpiban, tpnationality, amount, damageflag);
	}

	public static void updateMuroorODSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File driverLicenseFile, String driverLicenseFileName,
		java.io.File vehRegistFile, String vehRegistFileName,
		java.io.File policyCopyFile, String policyCopyFileName) {

		getService().updateMuroorODSubmitedFiles(
			claimNumber, username, reason, driverLicenseFile,
			driverLicenseFileName, vehRegistFile, vehRegistFileName,
			policyCopyFile, policyCopyFileName);
	}

	public static void updateMuroorTPSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File driverLicenseFile, String driverLicenseFileName,
		java.io.File vehRegistFile, String vehRegistFileName,
		java.io.File frontPhoto, String frontPhotoName, java.io.File rarePhoto,
		String rarePhotoName, java.io.File rightSidePhoto,
		String rightSidePhotoName, java.io.File leftSidePhoto,
		String leftSidePhotoName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName) {

		getService().updateMuroorTPSubmitedFiles(
			claimNumber, username, reason, driverLicenseFile,
			driverLicenseFileName, vehRegistFile, vehRegistFileName, frontPhoto,
			frontPhotoName, rarePhoto, rarePhotoName, rightSidePhoto,
			rightSidePhotoName, leftSidePhoto, leftSidePhotoName, bankIbanFile,
			bankIbanFileName, ownerIdFile, ownerIdFileName);
	}

	public static void updateNajmSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File najmSlipFile, String najmSlipFileName,
		java.io.File damageEstQuotFile, String damageEstQuotFileName,
		java.io.File bankIbanFile, String bankIbanFileName,
		java.io.File ownerIdFile, String ownerIdFileName) {

		getService().updateNajmSubmitedFiles(
			claimNumber, username, reason, najmSlipFile, najmSlipFileName,
			damageEstQuotFile, damageEstQuotFileName, bankIbanFile,
			bankIbanFileName, ownerIdFile, ownerIdFileName);
	}

	public static void updateWorkflowStatus(
			String claimRefNo, String username, String newStatus, String reason)
		throws com.liferay.portal.kernel.exception.PortalException {

		getService().updateWorkflowStatus(
			claimRefNo, username, newStatus, reason);
	}

	public static ClaimLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClaimLocalService, ClaimLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimLocalService.class);

		ServiceTracker<ClaimLocalService, ClaimLocalService> serviceTracker =
			new ServiceTracker<ClaimLocalService, ClaimLocalService>(
				bundle.getBundleContext(), ClaimLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}