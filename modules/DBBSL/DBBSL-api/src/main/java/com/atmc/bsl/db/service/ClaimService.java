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

import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.ejada.atmc.bsl.db.domain.claim.Claim;
import com.ejada.atmc.bsl.db.domain.claim.ClaimIntimation;
import com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow;
import com.ejada.atmc.bsl.db.domain.claim.MuroorODUploads;
import com.ejada.atmc.bsl.db.domain.claim.MuroorTPUploads;
import com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.security.access.control.AccessControlled;
import com.liferay.portal.kernel.service.BaseService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.HashMap;
import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the remote service interface for Claim. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimServiceUtil
 * @generated
 */
@AccessControlled
@JSONWebService
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClaimService extends BaseService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.ClaimServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the claim remote service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ClaimServiceUtil} if injection and service tracking are not available.
	 */
	public ServiceOutput<Integer> checkIbanValidation(String ibanParm)
		throws PortalException;

	public ServiceOutput<String> downloadClaimReport(
		ODSClaimIntimation odsClaimInt, String claimintName,
		String claimintMobile, String claimintEmail, String claimintId,
		String lang);

	public ServiceOutput<String> findBankIbanFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findDamageEstQuotFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findNajmSlipFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findODDriverLicenseFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findODPolicyCopyFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findODVehRegistFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findOwnerIdFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPBankIbanFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPDriverLicenseFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPFrontPhotoFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPLeftSidePhotoFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPOwnerIdFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPRearPhotoFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPRightSidePhotoFile(String fileId)
		throws PortalException;

	public ServiceOutput<String> findTPVehRegistFile(String fileId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<String> getCityCoreCode(String cityCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<Claim> getClaimDetailsByClaimNO(String claimNumber)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<HashMap<String, Object>> getClaimsDtls(String iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<Claim>> getClaimsSummary(String iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<Claim>> getClaimsSummaryFiter(
			String iqamaId, String claimStatus, String policyType)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<CustomerMapDetails>> getInsuranceCompanies()
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<MuroorODUploads> getMuroorODUploadsData(String refNo)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<MuroorTPUploads> getMuroorTPUploadsData(String refNo)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<Object[]>> getNajmUploadsFilesName(String refNo)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<List<ClaimWorkflow>> getRoleWorkflow(
		String workflowRole);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ServiceOutput<PolicyHDR> getVehiclePolicy(
		String plateNo, String plateL1, String plateL2, String plateL3,
		String language);

	public ServiceOutput<ClaimIntimation> intimateClaim(
		String claimType, String vehicleIdentType, String vehicleIdentNumber,
		String plateL1, String plateL2, String plateL3, String reportMode,
		String reportNumber, String causeOfLoss, String natureOfLoss,
		String language);

	public ServiceOutput<Boolean> saveODMuroorDoc(
			String iqamaId, String clmIntimationNo, File driverLicenseFile,
			String driverLicenseFileName, File vehRegistFile,
			String vehRegistFileName, File policyCopyFile,
			String policyCopyFileName)
		throws PortalException;

	public ServiceOutput<Boolean> saveTPMuroorDoc(
			String iqamaId, String clmIntimationNo, File driverLicenseFile,
			String driverLicenseFileName, File vehRegistFile,
			String vehRegistFileName, File frontPhoto, String frontPhotoName,
			File rarePhoto, String rarePhotoName, File rightSidePhoto,
			String rightSidePhotoName, File leftSidePhoto,
			String leftSidePhotoName, File bankIbanFile,
			String bankIbanFileName, File ownerIdFile, String ownerIdFileName)
		throws PortalException;

	public String submitClaim(
			String referenceno, String source, String transaction,
			String policyno, String reportmode, String reportno,
			String vehidentitype, String vehidentivalue, String lossnature,
			String losscause, String lossdate, String lossremarks,
			int faultpercent, String losslocation, String tpdrivername,
			String tpdob, String tpid, String tpvehidentitype,
			String tpvehidentivalue, String tpplateno, String tpinsco,
			String tpmobile, String tpiban, String tpnationality, double amount,
			String damageflag)
		throws PortalException;

	@JSONWebService(method = "POST", value = "submit-claim-by-object")
	public ServiceOutput<ODSCIResponse> submitClaimByObject(
			ODSClaimIntimation odsClaimInt)
		throws PortalException;

	public ServiceOutput<Boolean> uploadNajmFiles(
		File najmSlipFile, String najmSlipFileName, File damageEstQuotFile,
		String damageEstQuotFileName, File bankIbanFile,
		String bankIbanFileName, File ownerIdFile, String ownerIdFileName,
		String caseNo, String cipiId, String claimRefNo);

}