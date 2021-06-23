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
 * Provides a wrapper for {@link ClaimService}.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimService
 * @generated
 */
public class ClaimServiceWrapper implements ClaimService, ServiceWrapper<ClaimService> {

	public ClaimServiceWrapper(ClaimService claimService) {
		_claimService = claimService;
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Integer> checkIbanValidation(String ibanParm)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.checkIbanValidation(ibanParm);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> downloadClaimReport(
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt, String claimintName, String claimintMobile,
			String claimintEmail, String claimintId, String lang) {

		return _claimService.downloadClaimReport(odsClaimInt, claimintName, claimintMobile, claimintEmail, claimintId,
				lang);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findBankIbanFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findBankIbanFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findDamageEstQuotFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findDamageEstQuotFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findNajmSlipFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findNajmSlipFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findODDriverLicenseFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findODDriverLicenseFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findODPolicyCopyFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findODPolicyCopyFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findODVehRegistFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findODVehRegistFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findOwnerIdFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findOwnerIdFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPBankIbanFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPBankIbanFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPDriverLicenseFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPDriverLicenseFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPFrontPhotoFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPFrontPhotoFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPLeftSidePhotoFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPLeftSidePhotoFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPOwnerIdFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPOwnerIdFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPRearPhotoFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPRearPhotoFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPRightSidePhotoFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPRightSidePhotoFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> findTPVehRegistFile(String fileId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.findTPVehRegistFile(fileId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<String> getCityCoreCode(String cityCode) {

		return _claimService.getCityCoreCode(cityCode);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.claim.Claim> getClaimDetailsByClaimNO(
			String claimNumber) throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getClaimDetailsByClaimNO(claimNumber);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.HashMap<String, Object>> getClaimsDtls(String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getClaimsDtls(iqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.claim.Claim>> getClaimsSummary(
			String iqamaId) throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getClaimsSummary(iqamaId);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.claim.Claim>> getClaimsSummaryFiter(
			String iqamaId, String claimStatus, String policyType)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getClaimsSummaryFiter(iqamaId, claimStatus, policyType);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>> getInsuranceCompanies()
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getInsuranceCompanies();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.claim.MuroorODUploads> getMuroorODUploadsData(
			String refNo) throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getMuroorODUploadsData(refNo);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.claim.MuroorTPUploads> getMuroorTPUploadsData(
			String refNo) throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getMuroorTPUploadsData(refNo);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<Object[]>> getNajmUploadsFilesName(String refNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.getNajmUploadsFilesName(refNo);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _claimService.getOSGiServiceIdentifier();
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>> getRoleWorkflow(
			String workflowRole) {

		return _claimService.getRoleWorkflow(workflowRole);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.model.PolicyHDR> getVehiclePolicy(String plateNo,
			String plateL1, String plateL2, String plateL3, String language) {

		return _claimService.getVehiclePolicy(plateNo, plateL1, plateL2, plateL3, language);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.claim.ClaimIntimation> intimateClaim(
			String claimType, String vehicleIdentType, String vehicleIdentNumber, String plateL1, String plateL2,
			String plateL3, String reportMode, String reportNumber, String causeOfLoss, String natureOfLoss,
			String language) {

		return _claimService.intimateClaim(claimType, vehicleIdentType, vehicleIdentNumber, plateL1, plateL2, plateL3,
				reportMode, reportNumber, causeOfLoss, natureOfLoss, language);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> saveODMuroorDoc(String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName, java.io.File vehRegistFile,
			String vehRegistFileName, java.io.File policyCopyFile, String policyCopyFileName)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.saveODMuroorDoc(iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
				vehRegistFile, vehRegistFileName, policyCopyFile, policyCopyFileName);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> saveTPMuroorDoc(String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName, java.io.File vehRegistFile,
			String vehRegistFileName, java.io.File frontPhoto, String frontPhotoName, java.io.File rarePhoto,
			String rarePhotoName, java.io.File rightSidePhoto, String rightSidePhotoName, java.io.File leftSidePhoto,
			String leftSidePhotoName, java.io.File bankIbanFile, String bankIbanFileName, java.io.File ownerIdFile,
			String ownerIdFileName) throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.saveTPMuroorDoc(iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
				vehRegistFile, vehRegistFileName, frontPhoto, frontPhotoName, rarePhoto, rarePhotoName, rightSidePhoto,
				rightSidePhotoName, leftSidePhoto, leftSidePhotoName, bankIbanFile, bankIbanFileName, ownerIdFile,
				ownerIdFileName);
	}

	@Override
	public String submitClaim(String referenceno, String source, String transaction, String policyno, String reportmode,
			String reportno, String vehidentitype, String vehidentivalue, String lossnature, String losscause,
			String lossdate, String lossremarks, int faultpercent, String losslocation, String tpdrivername,
			String tpdob, String tpid, String tpvehidentitype, String tpvehidentivalue, String tpplateno,
			String tpinsco, String tpmobile, String tpiban, String tpnationality, double amount, String damageflag)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.submitClaim(referenceno, source, transaction, policyno, reportmode, reportno,
				vehidentitype, vehidentivalue, lossnature, losscause, lossdate, lossremarks, faultpercent, losslocation,
				tpdrivername, tpdob, tpid, tpvehidentitype, tpvehidentivalue, tpplateno, tpinsco, tpmobile, tpiban,
				tpnationality, amount, damageflag);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse> submitClaimByObject(
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _claimService.submitClaimByObject(odsClaimInt);
	}

	@Override
	public com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadNajmFiles(java.io.File najmSlipFile,
			String najmSlipFileName, java.io.File damageEstQuotFile, String damageEstQuotFileName,
			java.io.File bankIbanFile, String bankIbanFileName, java.io.File ownerIdFile, String ownerIdFileName,
			String caseNo, String cipiId, String claimRefNo) {

		return _claimService.uploadNajmFiles(najmSlipFile, najmSlipFileName, damageEstQuotFile, damageEstQuotFileName,
				bankIbanFile, bankIbanFileName, ownerIdFile, ownerIdFileName, caseNo, cipiId, claimRefNo);
	}

	@Override
	public ClaimService getWrappedService() {
		return _claimService;
	}

	@Override
	public void setWrappedService(ClaimService claimService) {
		_claimService = claimService;
	}

	private ClaimService _claimService;

}