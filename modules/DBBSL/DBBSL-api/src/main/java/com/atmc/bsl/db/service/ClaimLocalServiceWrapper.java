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
 * Provides a wrapper for {@link ClaimLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalService
 * @generated
 */
public class ClaimLocalServiceWrapper
	implements ClaimLocalService, ServiceWrapper<ClaimLocalService> {

	public ClaimLocalServiceWrapper(ClaimLocalService claimLocalService) {
		_claimLocalService = claimLocalService;
	}

	@Override
	public void addWorkflowStatus(String claimRefNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		_claimLocalService.addWorkflowStatus(claimRefNo);
	}

	@Override
	public byte[] adminUploadFile(int id) {
		return _claimLocalService.adminUploadFile(id);
	}

	@Override
	public int checkIbanValidation(String iban) {
		return _claimLocalService.checkIbanValidation(iban);
	}

	@Override
	public java.io.File downloadClaimReport(
		com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt,
		String claimintName, String claimintMobile, String claimintEmail,
		String claimintId, String lang) {

		return _claimLocalService.downloadClaimReport(
			odsClaimInt, claimintName, claimintMobile, claimintEmail,
			claimintId, lang);
	}

	@Override
	public byte[] findBankIbanFile(int id) {
		return _claimLocalService.findBankIbanFile(id);
	}

	@Override
	public int findClaimsCountsPolicyStatusAdmin(
			String status, String Surveyor, String refNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.findClaimsCountsPolicyStatusAdmin(
			status, Surveyor, refNo);
	}

	@Override
	public byte[] findDamageEstQuotFile(int id) {
		return _claimLocalService.findDamageEstQuotFile(id);
	}

	@Override
	public byte[] findNajmSlipFile(int id) {
		return _claimLocalService.findNajmSlipFile(id);
	}

	@Override
	public byte[] findODDriverLicenseFile(int id) {
		return _claimLocalService.findODDriverLicenseFile(id);
	}

	@Override
	public byte[] findODPolicyCopyFile(int id) {
		return _claimLocalService.findODPolicyCopyFile(id);
	}

	@Override
	public byte[] findODVehRegistFile(int id) {
		return _claimLocalService.findODVehRegistFile(id);
	}

	@Override
	public byte[] findOwnerIdFile(int id) {
		return _claimLocalService.findOwnerIdFile(id);
	}

	@Override
	public byte[] findTPBankIbanFile(int id) {
		return _claimLocalService.findTPBankIbanFile(id);
	}

	@Override
	public byte[] findTPDriverLicenseFile(int id) {
		return _claimLocalService.findTPDriverLicenseFile(id);
	}

	@Override
	public byte[] findTPFrontPhotoFile(int id) {
		return _claimLocalService.findTPFrontPhotoFile(id);
	}

	@Override
	public byte[] findTPLeftSidePhotoFile(int id) {
		return _claimLocalService.findTPLeftSidePhotoFile(id);
	}

	@Override
	public byte[] findTPOwnerIdFile(int id) {
		return _claimLocalService.findTPOwnerIdFile(id);
	}

	@Override
	public byte[] findTPRearPhotoFile(int id) {
		return _claimLocalService.findTPRearPhotoFile(id);
	}

	@Override
	public byte[] findTPRightSidePhotoFile(int id) {
		return _claimLocalService.findTPRightSidePhotoFile(id);
	}

	@Override
	public byte[] findTPVehRegistFile(int id) {
		return _claimLocalService.findTPVehRegistFile(id);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.Claim> getAllClaims(
			String status, String surveyor, String refNo, int from, int to)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getAllClaims(
			status, surveyor, refNo, from, to);
	}

	@Override
	public String getCityCoreCode(String cityCode) {
		return _claimLocalService.getCityCoreCode(cityCode);
	}

	@Override
	public String getCityDescAr(String cityCode) {
		return _claimLocalService.getCityDescAr(cityCode);
	}

	@Override
	public String getCityDescEn(String cityCode) {
		return _claimLocalService.getCityDescEn(cityCode);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.Claim getClaimDetails(
			String claimNumber, String policyNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimDetails(claimNumber, policyNumber);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.Claim getClaimDetailsByClaimNO(
			String claimNumber)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimDetailsByClaimNO(claimNumber);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.Claim>
			getClaimsByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimsByIqamaId(iqamaId);
	}

	@Override
	public java.util.HashMap<String, Object> getClaimsOutline(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimsOutline(iqamaId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.Claim> getClaimsSummary(
			String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimsSummary(iqamaId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.Claim>
			getClaimsSummaryFiter(
				String iqamaId, String status, String policyType)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getClaimsSummaryFiter(
			iqamaId, status, policyType);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>
		getInsuranceCompanies() {

		return _claimLocalService.getInsuranceCompanies();
	}

	@Override
	public com.ejada.atmc.acl.db.model.ODMuroorUploads getMuroorODFileUploads(
		String claimRefNo) {

		return _claimLocalService.getMuroorODFileUploads(claimRefNo);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.MuroorODUploads getMuroorODUploadsData(
		String refNo) {

		return _claimLocalService.getMuroorODUploadsData(refNo);
	}

	@Override
	public com.ejada.atmc.acl.db.model.MuroorTPUploads getMuroorTPFileUploads(
		String claimRefNo) {

		return _claimLocalService.getMuroorTPFileUploads(claimRefNo);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.MuroorTPUploads getMuroorTPUploadsData(
		String refNo) {

		return _claimLocalService.getMuroorTPUploadsData(refNo);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.NajmClaim>
		getNajmClaimByCaseNo(String caseNo) {

		return _claimLocalService.getNajmClaimByCaseNo(caseNo);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.NajmClaim>
			getNajmClaimByCustomId(String caseNo, String customId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getNajmClaimByCustomId(caseNo, customId);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.NajmClaim>
			getNajmClaimByNajmPlateNumber(String caseNo, String najmPlateNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getNajmClaimByNajmPlateNumber(
			caseNo, najmPlateNo);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.NajmClaimIntimation
			getNajmClaimIntimationByCustomId(
				String caseNo, String vehicleCustomId, String language)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getNajmClaimIntimationByCustomId(
			caseNo, vehicleCustomId, language);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.NajmClaimIntimation
			getNajmClaimIntimationByPlateNumber(
				String caseNo, String plateNumber, String language)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.getNajmClaimIntimationByPlateNumber(
			caseNo, plateNumber, language);
	}

	@Override
	public com.ejada.atmc.acl.db.model.CLMNajmUploads getNajmFileUploads(
		String claimRefNo) {

		return _claimLocalService.getNajmFileUploads(claimRefNo);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR getNajmOtherPartyPolicy(
		String najmCaseNo) {

		return _claimLocalService.getNajmOtherPartyPolicy(najmCaseNo);
	}

	@Override
	public java.util.List<Object[]> getNajmUploadsFilesName(String refNo) {
		return _claimLocalService.getNajmUploadsFilesName(refNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>
		getRoleWorkflow(String role) {

		return _claimLocalService.getRoleWorkflow(role);
	}

	@Override
	public java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>
		getRoleWorkflowByRoleStatus(String role, String status) {

		return _claimLocalService.getRoleWorkflowByRoleStatus(role, status);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR getVehiclePolicy(
			String vehicleSeqCustom)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException,
			   com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _claimLocalService.getVehiclePolicy(vehicleSeqCustom);
	}

	@Override
	public com.ejada.atmc.acl.db.model.PolicyHDR getVehiclePolicy(
			String plateNo, String plateL1, String plateL2, String plateL3,
			String language)
		throws com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException,
			   com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException {

		return _claimLocalService.getVehiclePolicy(
			plateNo, plateL1, plateL2, plateL3, language);
	}

	@Override
	public com.atmc.bsl.db.domain.claim.ClaimIntimation intimateClaim(
			String claimType, String vehicleIdentType,
			String vehicleIdentNumber, String plateL1, String plateL2,
			String plateL3, String reportMode, String reportNumber,
			String causeOfLoss, String natureOfLoss, java.util.Locale locale)
		throws Exception {

		return _claimLocalService.intimateClaim(
			claimType, vehicleIdentType, vehicleIdentNumber, plateL1, plateL2,
			plateL3, reportMode, reportNumber, causeOfLoss, natureOfLoss,
			locale);
	}

	@Override
	public void removeAdminFiles(int fileId) {
		_claimLocalService.removeAdminFiles(fileId);
	}

	@Override
	public void saveAdminFiles(
		String refNo, java.io.File adminFile, String fileName) {

		_claimLocalService.saveAdminFiles(refNo, adminFile, fileName);
	}

	@Override
	public void saveNajmSubmitedDoc(
		String caseNo, String cipiId, java.io.File najmSlipFile,
		String najmSlipFileName, java.io.File damageEstQuotFile,
		String damageEstQuotFileName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName, String claimRefNo) {

		_claimLocalService.saveNajmSubmitedDoc(
			caseNo, cipiId, najmSlipFile, najmSlipFileName, damageEstQuotFile,
			damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
			ownerIdFileName, claimRefNo);
	}

	@Override
	public void saveNajmSubmitedFiles(
		String caseNo, String cipiId, java.io.File najmSlipFile,
		String najmSlipFileName, java.io.File damageEstQuotFile,
		String damageEstQuotFileName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName, String claimRefNo) {

		_claimLocalService.saveNajmSubmitedFiles(
			caseNo, cipiId, najmSlipFile, najmSlipFileName, damageEstQuotFile,
			damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
			ownerIdFileName, claimRefNo);
	}

	@Override
	public void saveODMuroorDoc(
		String iqamaId, String clmIntimationNo, java.io.File driverLicenseFile,
		String driverLicenseFileName, java.io.File vehRegistFile,
		String vehRegistFileName, java.io.File policyCopyFile,
		String policyCopyFileName) {

		_claimLocalService.saveODMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, policyCopyFile,
			policyCopyFileName);
	}

	@Override
	public void saveTPMuroorDoc(
		String iqamaId, String clmIntimationNo, java.io.File driverLicenseFile,
		String driverLicenseFileName, java.io.File vehRegistFile,
		String vehRegistFileName, java.io.File frontPhoto,
		String frontPhotoName, java.io.File rarePhoto, String rarePhotoName,
		java.io.File rightSidePhoto, String rightSidePhotoName,
		java.io.File leftSidePhoto, String leftSidePhotoName,
		java.io.File bankIbanFile, String bankIbanFileName,
		java.io.File ownerIdFile, String ownerIdFileName) {

		_claimLocalService.saveTPMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, frontPhoto, frontPhotoName,
			rarePhoto, rarePhotoName, rightSidePhoto, rightSidePhotoName,
			leftSidePhoto, leftSidePhotoName, bankIbanFile, bankIbanFileName,
			ownerIdFile, ownerIdFileName);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse submitClaim(
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _claimLocalService.submitClaim(odsClaimInt);
	}

	@Override
	public String submitClaimFn(
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

		return _claimLocalService.submitClaimFn(
			referenceno, source, transaction, policyno, reportmode, reportno,
			vehidentitype, vehidentivalue, lossnature, losscause, lossdate,
			lossremarks, faultpercent, losslocation, tpdrivername, tpdob, tpid,
			tpvehidentitype, tpvehidentivalue, tpplateno, tpinsco, tpmobile,
			tpiban, tpnationality, amount, damageflag);
	}

	@Override
	public void updateMuroorODSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File driverLicenseFile, String driverLicenseFileName,
		java.io.File vehRegistFile, String vehRegistFileName,
		java.io.File policyCopyFile, String policyCopyFileName) {

		_claimLocalService.updateMuroorODSubmitedFiles(
			claimNumber, username, reason, driverLicenseFile,
			driverLicenseFileName, vehRegistFile, vehRegistFileName,
			policyCopyFile, policyCopyFileName);
	}

	@Override
	public void updateMuroorTPSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File driverLicenseFile, String driverLicenseFileName,
		java.io.File vehRegistFile, String vehRegistFileName,
		java.io.File frontPhoto, String frontPhotoName, java.io.File rarePhoto,
		String rarePhotoName, java.io.File rightSidePhoto,
		String rightSidePhotoName, java.io.File leftSidePhoto,
		String leftSidePhotoName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName) {

		_claimLocalService.updateMuroorTPSubmitedFiles(
			claimNumber, username, reason, driverLicenseFile,
			driverLicenseFileName, vehRegistFile, vehRegistFileName, frontPhoto,
			frontPhotoName, rarePhoto, rarePhotoName, rightSidePhoto,
			rightSidePhotoName, leftSidePhoto, leftSidePhotoName, bankIbanFile,
			bankIbanFileName, ownerIdFile, ownerIdFileName);
	}

	@Override
	public void updateNajmSubmitedFiles(
		String claimNumber, String username, String reason,
		java.io.File najmSlipFile, String najmSlipFileName,
		java.io.File damageEstQuotFile, String damageEstQuotFileName,
		java.io.File bankIbanFile, String bankIbanFileName,
		java.io.File ownerIdFile, String ownerIdFileName) {

		_claimLocalService.updateNajmSubmitedFiles(
			claimNumber, username, reason, najmSlipFile, najmSlipFileName,
			damageEstQuotFile, damageEstQuotFileName, bankIbanFile,
			bankIbanFileName, ownerIdFile, ownerIdFileName);
	}

	@Override
	public void updateWorkflowStatus(
			String claimRefNo, String username, String newStatus, String reason)
		throws com.liferay.portal.kernel.exception.PortalException {

		_claimLocalService.updateWorkflowStatus(
			claimRefNo, username, newStatus, reason);
	}

	@Override
	public ClaimLocalService getWrappedService() {
		return _claimLocalService;
	}

	@Override
	public void setWrappedService(ClaimLocalService claimLocalService) {
		_claimLocalService = claimLocalService;
	}

	private ClaimLocalService _claimLocalService;

}