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

package com.atmc.bsl.db.service.http;

import com.atmc.bsl.db.service.ClaimServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>ClaimServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ClaimServiceSoap {

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
		throws RemoteException {

		try {
			String returnValue = ClaimServiceUtil.submitClaim(
				referenceno, source, transaction, policyno, reportmode,
				reportno, vehidentitype, vehidentivalue, lossnature, losscause,
				lossdate, lossremarks, faultpercent, losslocation, tpdrivername,
				tpdob, tpid, tpvehidentitype, tpvehidentivalue, tpplateno,
				tpinsco, tpmobile, tpiban, tpnationality, amount, damageflag);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.Claim> getClaimDetailsByClaimNO(
				String claimNumber)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.claim.Claim> returnValue =
					ClaimServiceUtil.getClaimDetailsByClaimNO(claimNumber);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.Claim>> getClaimsSummary(
				String iqamaId)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.atmc.bsl.db.domain.claim.Claim>>
					returnValue = ClaimServiceUtil.getClaimsSummary(iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<Object[]>>
			getNajmUploadsFilesName(String refNo)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<java.util.List<Object[]>>
				returnValue = ClaimServiceUtil.getNajmUploadsFilesName(refNo);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findNajmSlipFile(
			String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findNajmSlipFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findDamageEstQuotFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findDamageEstQuotFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findBankIbanFile(
			String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findBankIbanFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> findOwnerIdFile(
			String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findOwnerIdFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.HashMap<String, Object>> getClaimsDtls(String iqamaId)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.HashMap<String, Object>> returnValue =
					ClaimServiceUtil.getClaimsDtls(iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.ClaimIntimation> intimateClaim(
				String claimType, String vehicleIdentType,
				String vehicleIdentNumber, String plateL1, String plateL2,
				String plateL3, String reportMode, String reportNumber,
				String causeOfLoss, String natureOfLoss, String language)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.claim.ClaimIntimation> returnValue =
					ClaimServiceUtil.intimateClaim(
						claimType, vehicleIdentType, vehicleIdentNumber,
						plateL1, plateL2, plateL3, reportMode, reportNumber,
						causeOfLoss, natureOfLoss, language);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.Claim>>
				getClaimsSummaryFiter(
					String iqamaId, String claimStatus, String policyType)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.atmc.bsl.db.domain.claim.Claim>>
					returnValue = ClaimServiceUtil.getClaimsSummaryFiter(
						iqamaId, claimStatus, policyType);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Integer>
			checkIbanValidation(String ibanParm)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<Integer> returnValue =
				ClaimServiceUtil.checkIbanValidation(ibanParm);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
				getInsuranceCompanies()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
						returnValue = ClaimServiceUtil.getInsuranceCompanies();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse> submitClaimByObject(
				com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse> returnValue =
					ClaimServiceUtil.submitClaimByObject(odsClaimInt);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			downloadClaimReport(
				com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt,
				String claimintName, String claimintMobile,
				String claimintEmail, String claimintId, String lang)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.downloadClaimReport(
					odsClaimInt, claimintName, claimintMobile, claimintEmail,
					claimintId, lang);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>>
				getRoleWorkflow(String workflowRole)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.atmc.bsl.db.domain.claim.ClaimWorkflow>>
					returnValue = ClaimServiceUtil.getRoleWorkflow(
						workflowRole);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.model.PolicyHDR> getVehiclePolicy(
				String plateNo, String plateL1, String plateL2, String plateL3,
				String language)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.db.model.PolicyHDR> returnValue =
					ClaimServiceUtil.getVehiclePolicy(
						plateNo, plateL1, plateL2, plateL3, language);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> getCityCoreCode(
			String cityCode)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.getCityCoreCode(cityCode);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODDriverLicenseFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findODDriverLicenseFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODVehRegistFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findODVehRegistFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findODPolicyCopyFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findODPolicyCopyFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPDriverLicenseFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPDriverLicenseFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPVehRegistFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPVehRegistFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPFrontPhotoFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPFrontPhotoFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRearPhotoFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPRearPhotoFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRightSidePhotoFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPRightSidePhotoFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPLeftSidePhotoFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPLeftSidePhotoFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPBankIbanFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPBankIbanFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			findTPOwnerIdFile(String fileId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				ClaimServiceUtil.findTPOwnerIdFile(fileId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.MuroorTPUploads> getMuroorTPUploadsData(
				String refNo)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.claim.MuroorTPUploads> returnValue =
					ClaimServiceUtil.getMuroorTPUploadsData(refNo);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.claim.MuroorODUploads> getMuroorODUploadsData(
				String refNo)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.claim.MuroorODUploads> returnValue =
					ClaimServiceUtil.getMuroorODUploadsData(refNo);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClaimServiceSoap.class);

}