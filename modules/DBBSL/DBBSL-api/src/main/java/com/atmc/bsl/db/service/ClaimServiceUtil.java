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
 * Provides the remote service utility for Claim. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.ClaimServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimService
 * @generated
 */
public class ClaimServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.ClaimServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.atmc.bsl.db.domain.ServiceOutput<Integer>
			checkIbanValidation(String ibanParm)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().checkIbanValidation(ibanParm);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
		downloadClaimReport(
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt,
			String claimintName, String claimintMobile, String claimintEmail,
			String claimintId, String lang) {

		return getService().downloadClaimReport(
			odsClaimInt, claimintName, claimintMobile, claimintEmail,
			claimintId, lang);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findBankIbanFile(
			String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findBankIbanFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findDamageEstQuotFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findDamageEstQuotFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findNajmSlipFile(
			String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findNajmSlipFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODDriverLicenseFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findODDriverLicenseFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODPolicyCopyFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findODPolicyCopyFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODVehRegistFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findODVehRegistFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findOwnerIdFile(
			String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findOwnerIdFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPBankIbanFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPBankIbanFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPDriverLicenseFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPDriverLicenseFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPFrontPhotoFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPFrontPhotoFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPLeftSidePhotoFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPLeftSidePhotoFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPOwnerIdFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPOwnerIdFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRearPhotoFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPRearPhotoFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRightSidePhotoFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPRightSidePhotoFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPVehRegistFile(String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().findTPVehRegistFile(fileId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> getCityCoreCode(
		String cityCode) {

		return getService().getCityCoreCode(cityCode);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.Claim> getClaimDetailsByClaimNO(
				String claimNumber)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimDetailsByClaimNO(claimNumber);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.HashMap<String, Object>> getClaimsDtls(String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsDtls(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.Claim>> getClaimsSummary(
				String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsSummary(iqamaId);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.Claim>>
				getClaimsSummaryFiter(
					String iqamaId, String claimStatus, String policyType)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getClaimsSummaryFiter(
			iqamaId, claimStatus, policyType);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
				getInsuranceCompanies()
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getInsuranceCompanies();
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.MuroorODUploads> getMuroorODUploadsData(
				String refNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMuroorODUploadsData(refNo);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.MuroorTPUploads> getMuroorTPUploadsData(
				String refNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().getMuroorTPUploadsData(refNo);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<Object[]>>
			getNajmUploadsFilesName(String refNo)
		throws com.liferay.portal.kernel.exception.PortalException {

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

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>>
			getRoleWorkflow(String workflowRole) {

		return getService().getRoleWorkflow(workflowRole);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.model.PolicyHDR> getVehiclePolicy(
			String plateNo, String plateL1, String plateL2, String plateL3,
			String language) {

		return getService().getVehiclePolicy(
			plateNo, plateL1, plateL2, plateL3, language);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.ClaimIntimation> intimateClaim(
			String claimType, String vehicleIdentType,
			String vehicleIdentNumber, String plateL1, String plateL2,
			String plateL3, String reportMode, String reportNumber,
			String causeOfLoss, String natureOfLoss, String language) {

		return getService().intimateClaim(
			claimType, vehicleIdentType, vehicleIdentNumber, plateL1, plateL2,
			plateL3, reportMode, reportNumber, causeOfLoss, natureOfLoss,
			language);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> saveODMuroorDoc(
			String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName,
			java.io.File vehRegistFile, String vehRegistFileName,
			java.io.File policyCopyFile, String policyCopyFileName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveODMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, policyCopyFile,
			policyCopyFileName);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> saveTPMuroorDoc(
			String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName,
			java.io.File vehRegistFile, String vehRegistFileName,
			java.io.File frontPhoto, String frontPhotoName,
			java.io.File rarePhoto, String rarePhotoName,
			java.io.File rightSidePhoto, String rightSidePhotoName,
			java.io.File leftSidePhoto, String leftSidePhotoName,
			java.io.File bankIbanFile, String bankIbanFileName,
			java.io.File ownerIdFile, String ownerIdFileName)
		throws com.liferay.portal.kernel.exception.PortalException {

		return getService().saveTPMuroorDoc(
			iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
			vehRegistFile, vehRegistFileName, frontPhoto, frontPhotoName,
			rarePhoto, rarePhotoName, rightSidePhoto, rightSidePhotoName,
			leftSidePhoto, leftSidePhotoName, bankIbanFile, bankIbanFileName,
			ownerIdFile, ownerIdFileName);
	}

	public static String submitClaim(
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

		return getService().submitClaim(
			referenceno, source, transaction, policyno, reportmode, reportno,
			vehidentitype, vehidentivalue, lossnature, losscause, lossdate,
			lossremarks, faultpercent, losslocation, tpdrivername, tpdob, tpid,
			tpvehidentitype, tpvehidentivalue, tpplateno, tpinsco, tpmobile,
			tpiban, tpnationality, amount, damageflag);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse> submitClaimByObject(
				com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
			throws com.liferay.portal.kernel.exception.PortalException {

		return getService().submitClaimByObject(odsClaimInt);
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadNajmFiles(
		java.io.File najmSlipFile, String najmSlipFileName,
		java.io.File damageEstQuotFile, String damageEstQuotFileName,
		java.io.File bankIbanFile, String bankIbanFileName,
		java.io.File ownerIdFile, String ownerIdFileName, String caseNo,
		String cipiId, String claimRefNo) {

		return getService().uploadNajmFiles(
			najmSlipFile, najmSlipFileName, damageEstQuotFile,
			damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
			ownerIdFileName, caseNo, cipiId, claimRefNo);
	}

	public static ClaimService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<ClaimService, ClaimService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(ClaimService.class);

		ServiceTracker<ClaimService, ClaimService> serviceTracker =
			new ServiceTracker<ClaimService, ClaimService>(
				bundle.getBundleContext(), ClaimService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}