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

import com.atmc.bsl.db.domain.claim.Claim;
import com.atmc.bsl.db.domain.claim.ClaimIntimation;
import com.atmc.bsl.db.domain.claim.ClaimWorkflow;
import com.atmc.bsl.db.domain.claim.MuroorODUploads;
import com.atmc.bsl.db.domain.claim.NajmClaim;
import com.atmc.bsl.db.domain.claim.NajmClaimIntimation;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;

import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.CLMNajmUploads;
import com.ejada.atmc.acl.db.model.ODMuroorUploads;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Claim. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface ClaimLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.ClaimLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the claim local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link ClaimLocalServiceUtil} if injection and service tracking are not available.
	 */
	public void addWorkflowStatus(String claimRefNo) throws PortalException;

	public byte[] adminUploadFile(int id);

	public int checkIbanValidation(String iban);

	public File downloadClaimReport(
		ODSClaimIntimation odsClaimInt, String claimintName,
		String claimintMobile, String claimintEmail, String claimintId,
		String lang);

	public byte[] findBankIbanFile(int id);

	public int findClaimsCountsPolicyStatusAdmin(
			String status, String Surveyor, String refNo)
		throws PortalException;

	public byte[] findDamageEstQuotFile(int id);

	public byte[] findNajmSlipFile(int id);

	public byte[] findODDriverLicenseFile(int id);

	public byte[] findODPolicyCopyFile(int id);

	public byte[] findODVehRegistFile(int id);

	public byte[] findOwnerIdFile(int id);

	public byte[] findTPBankIbanFile(int id);

	public byte[] findTPDriverLicenseFile(int id);

	public byte[] findTPFrontPhotoFile(int id);

	public byte[] findTPLeftSidePhotoFile(int id);

	public byte[] findTPOwnerIdFile(int id);

	public byte[] findTPRearPhotoFile(int id);

	public byte[] findTPRightSidePhotoFile(int id);

	public byte[] findTPVehRegistFile(int id);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Claim> getAllClaims(
			String status, String surveyor, String refNo, int from, int to)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCityCoreCode(String cityCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCityDescAr(String cityCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getCityDescEn(String cityCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Claim getClaimDetails(String claimNumber, String policyNumber)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Claim getClaimDetailsByClaimNO(String claimNumber)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Claim> getClaimsByIqamaId(String iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public HashMap<String, Object> getClaimsOutline(String iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Claim> getClaimsSummary(String iqamaId) throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Claim> getClaimsSummaryFiter(
			String iqamaId, String status, String policyType)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CustomerMapDetails> getInsuranceCompanies();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public ODMuroorUploads getMuroorODFileUploads(String claimRefNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public MuroorODUploads getMuroorODUploadsData(String refNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.ejada.atmc.acl.db.model.MuroorTPUploads getMuroorTPFileUploads(
		String claimRefNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.atmc.bsl.db.domain.claim.MuroorTPUploads getMuroorTPUploadsData(
		String refNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<NajmClaim> getNajmClaimByCaseNo(String caseNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NajmClaimIntimation getNajmClaimIntimationByCustomId(
			String caseNo, String vehicleCustomId, String language)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public NajmClaimIntimation getNajmClaimIntimationByPlateNumber(
			String caseNo, String plateNumber, String language)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CLMNajmUploads getNajmFileUploads(String claimRefNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PolicyHDR getNajmOtherPartyPolicy(String najmCaseNo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Object[]> getNajmUploadsFilesName(String refNo);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimWorkflow> getRoleWorkflow(String role);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<ClaimWorkflow> getRoleWorkflowByRoleStatus(
		String role, String status);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PolicyHDR getVehiclePolicy(String vehicleSeqCustom)
		throws NoSuchPolicyHDRException, NoSuchPolicyVEHException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public PolicyHDR getVehiclePolicy(
			String plateNo, String plateL1, String plateL2, String plateL3,
			String language)
		throws NoSuchPolicyHDRException, NoSuchPolicyVEHException;

	public ClaimIntimation intimateClaim(
			String claimType, String vehicleIdentType,
			String vehicleIdentNumber, String plateL1, String plateL2,
			String plateL3, String reportMode, String reportNumber,
			String causeOfLoss, String natureOfLoss, Locale locale)
		throws Exception;

	public void removeAdminFiles(int fileId);

	public void saveAdminFiles(String refNo, File adminFile, String fileName);

	public void saveNajmSubmitedDoc(
		String caseNo, String cipiId, File najmSlipFile,
		String najmSlipFileName, File damageEstQuotFile,
		String damageEstQuotFileName, File bankIbanFile,
		String bankIbanFileName, File ownerIdFile, String ownerIdFileName,
		String claimRefNo);

	public void saveNajmSubmitedFiles(
		String caseNo, String cipiId, File najmSlipFile,
		String najmSlipFileName, File damageEstQuotFile,
		String damageEstQuotFileName, File bankIbanFile,
		String bankIbanFileName, File ownerIdFile, String ownerIdFileName,
		String claimRefNo);

	public void saveODMuroorDoc(
		String iqamaId, String clmIntimationNo, File driverLicenseFile,
		String driverLicenseFileName, File vehRegistFile,
		String vehRegistFileName, File policyCopyFile,
		String policyCopyFileName);

	public void saveTPMuroorDoc(
		String iqamaId, String clmIntimationNo, File driverLicenseFile,
		String driverLicenseFileName, File vehRegistFile,
		String vehRegistFileName, File frontPhoto, String frontPhotoName,
		File rarePhoto, String rarePhotoName, File rightSidePhoto,
		String rightSidePhotoName, File leftSidePhoto, String leftSidePhotoName,
		File bankIbanFile, String bankIbanFileName, File ownerIdFile,
		String ownerIdFileName);

	public ODSCIResponse submitClaim(ODSClaimIntimation odsClaimInt)
		throws PortalException;

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
		throws PortalException;

	public void updateMuroorODSubmitedFiles(
		String claimNumber, String username, String reason,
		File driverLicenseFile, String driverLicenseFileName,
		File vehRegistFile, String vehRegistFileName, File policyCopyFile,
		String policyCopyFileName);

	public void updateMuroorTPSubmitedFiles(
		String claimNumber, String username, String reason,
		File driverLicenseFile, String driverLicenseFileName,
		File vehRegistFile, String vehRegistFileName, File frontPhoto,
		String frontPhotoName, File rarePhoto, String rarePhotoName,
		File rightSidePhoto, String rightSidePhotoName, File leftSidePhoto,
		String leftSidePhotoName, File bankIbanFile, String bankIbanFileName,
		File ownerIdFile, String ownerIdFileName);

	public void updateNajmSubmitedFiles(
		String claimNumber, String username, String reason, File najmSlipFile,
		String najmSlipFileName, File damageEstQuotFile,
		String damageEstQuotFileName, File bankIbanFile,
		String bankIbanFileName, File ownerIdFile, String ownerIdFileName);

	public void updateWorkflowStatus(
			String claimRefNo, String username, String newStatus, String reason)
		throws PortalException;

}