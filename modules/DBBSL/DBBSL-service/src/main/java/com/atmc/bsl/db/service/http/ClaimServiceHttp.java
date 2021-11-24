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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>ClaimServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimServiceSoap
 * @generated
 */
public class ClaimServiceHttp {

	public static String submitClaim(
			HttpPrincipal httpPrincipal, String referenceno, String source,
			String transaction, String policyno, String reportmode,
			String reportno, String vehidentitype, String vehidentivalue,
			String lossnature, String losscause, String lossdate,
			String lossremarks, int faultpercent, String losslocation,
			String tpdrivername, String tpdob, String tpid,
			String tpvehidentitype, String tpvehidentivalue, String tpplateno,
			String tpinsco, String tpmobile, String tpiban,
			String tpnationality, double amount, String damageflag)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "submitClaim",
				_submitClaimParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, referenceno, source, transaction, policyno,
				reportmode, reportno, vehidentitype, vehidentivalue, lossnature,
				losscause, lossdate, lossremarks, faultpercent, losslocation,
				tpdrivername, tpdob, tpid, tpvehidentitype, tpvehidentivalue,
				tpplateno, tpinsco, tpmobile, tpiban, tpnationality, amount,
				damageflag);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (String)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.claim.Claim> getClaimDetailsByClaimNO(
				HttpPrincipal httpPrincipal, String claimNumber)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getClaimDetailsByClaimNO",
				_getClaimDetailsByClaimNOParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, claimNumber);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.claim.Claim>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>> getClaimsSummary(
				HttpPrincipal httpPrincipal, String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getClaimsSummary",
				_getClaimsSummaryParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<java.util.List<Object[]>>
			getNajmUploadsFilesName(HttpPrincipal httpPrincipal, String refNo)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getNajmUploadsFilesName",
				_getNajmUploadsFilesNameParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey, refNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<Object[]>>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> findNajmSlipFile(
			HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findNajmSlipFile",
				_findNajmSlipFileParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findDamageEstQuotFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findDamageEstQuotFile",
				_findDamageEstQuotFileParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> findBankIbanFile(
			HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findBankIbanFile",
				_findBankIbanFileParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> findOwnerIdFile(
			HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findOwnerIdFile",
				_findOwnerIdFileParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.HashMap<String, Object>> getClaimsDtls(
				HttpPrincipal httpPrincipal, String iqamaId)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getClaimsDtls",
				_getClaimsDtlsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.HashMap<String, Object>>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.claim.ClaimIntimation> intimateClaim(
			HttpPrincipal httpPrincipal, String claimType,
			String vehicleIdentType, String vehicleIdentNumber, String plateL1,
			String plateL2, String plateL3, String reportMode,
			String reportNumber, String causeOfLoss, String natureOfLoss,
			String language) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "intimateClaim",
				_intimateClaimParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, claimType, vehicleIdentType, vehicleIdentNumber,
				plateL1, plateL2, plateL3, reportMode, reportNumber,
				causeOfLoss, natureOfLoss, language);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.claim.ClaimIntimation>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>>
				getClaimsSummaryFiter(
					HttpPrincipal httpPrincipal, String iqamaId,
					String claimStatus, String policyType)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getClaimsSummaryFiter",
				_getClaimsSummaryFiterParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, iqamaId, claimStatus, policyType);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.ejada.atmc.bsl.db.domain.claim.Claim>>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<Integer>
			checkIbanValidation(HttpPrincipal httpPrincipal, String ibanParm)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "checkIbanValidation",
				_checkIbanValidationParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, ibanParm);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<Integer>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
				getInsuranceCompanies(HttpPrincipal httpPrincipal)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getInsuranceCompanies",
				_getInsuranceCompaniesParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails>>)
						returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse> submitClaimByObject(
				HttpPrincipal httpPrincipal,
				com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "submitClaimByObject",
				_submitClaimByObjectParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, odsClaimInt);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadNajmFiles(
		HttpPrincipal httpPrincipal, java.io.File najmSlipFile,
		String najmSlipFileName, java.io.File damageEstQuotFile,
		String damageEstQuotFileName, java.io.File bankIbanFile,
		String bankIbanFileName, java.io.File ownerIdFile,
		String ownerIdFileName, String caseNo, String cipiId,
		String claimRefNo) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "uploadNajmFiles",
				_uploadNajmFilesParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, najmSlipFile, najmSlipFileName, damageEstQuotFile,
				damageEstQuotFileName, bankIbanFile, bankIbanFileName,
				ownerIdFile, ownerIdFileName, caseNo, cipiId, claimRefNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean> saveODMuroorDoc(
			HttpPrincipal httpPrincipal, String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName,
			java.io.File vehRegistFile, String vehRegistFileName,
			java.io.File policyCopyFile, String policyCopyFileName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "saveODMuroorDoc",
				_saveODMuroorDocParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, iqamaId, clmIntimationNo, driverLicenseFile,
				driverLicenseFileName, vehRegistFile, vehRegistFileName,
				policyCopyFile, policyCopyFileName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean> saveTPMuroorDoc(
			HttpPrincipal httpPrincipal, String iqamaId, String clmIntimationNo,
			java.io.File driverLicenseFile, String driverLicenseFileName,
			java.io.File vehRegistFile, String vehRegistFileName,
			java.io.File frontPhoto, String frontPhotoName,
			java.io.File rarePhoto, String rarePhotoName,
			java.io.File rightSidePhoto, String rightSidePhotoName,
			java.io.File leftSidePhoto, String leftSidePhotoName,
			java.io.File bankIbanFile, String bankIbanFileName,
			java.io.File ownerIdFile, String ownerIdFileName)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "saveTPMuroorDoc",
				_saveTPMuroorDocParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, iqamaId, clmIntimationNo, driverLicenseFile,
				driverLicenseFileName, vehRegistFile, vehRegistFileName,
				frontPhoto, frontPhotoName, rarePhoto, rarePhotoName,
				rightSidePhoto, rightSidePhotoName, leftSidePhoto,
				leftSidePhotoName, bankIbanFile, bankIbanFileName, ownerIdFile,
				ownerIdFileName);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<Boolean>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
		downloadClaimReport(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation odsClaimInt,
			String claimintName, String claimintMobile, String claimintEmail,
			String claimintId, String lang) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "downloadClaimReport",
				_downloadClaimReportParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, odsClaimInt, claimintName, claimintMobile,
				claimintEmail, claimintId, lang);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow>>
			getRoleWorkflow(HttpPrincipal httpPrincipal, String workflowRole) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getRoleWorkflow",
				_getRoleWorkflowParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, workflowRole);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow>>)
					returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.model.PolicyHDR> getVehiclePolicy(
			HttpPrincipal httpPrincipal, String plateNo, String plateL1,
			String plateL2, String plateL3, String language) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getVehiclePolicy",
				_getVehiclePolicyParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, plateNo, plateL1, plateL2, plateL3, language);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.db.model.PolicyHDR>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String> getCityCoreCode(
		HttpPrincipal httpPrincipal, String cityCode) {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getCityCoreCode",
				_getCityCoreCodeParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, cityCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findODDriverLicenseFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findODDriverLicenseFile",
				_findODDriverLicenseFileParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findODVehRegistFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findODVehRegistFile",
				_findODVehRegistFileParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findODPolicyCopyFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findODPolicyCopyFile",
				_findODPolicyCopyFileParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPDriverLicenseFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPDriverLicenseFile",
				_findTPDriverLicenseFileParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPVehRegistFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPVehRegistFile",
				_findTPVehRegistFileParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPFrontPhotoFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPFrontPhotoFile",
				_findTPFrontPhotoFileParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRearPhotoFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPRearPhotoFile",
				_findTPRearPhotoFileParameterTypes27);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPRightSidePhotoFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPRightSidePhotoFile",
				_findTPRightSidePhotoFileParameterTypes28);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPLeftSidePhotoFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPLeftSidePhotoFile",
				_findTPLeftSidePhotoFileParameterTypes29);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPBankIbanFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPBankIbanFile",
				_findTPBankIbanFileParameterTypes30);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<String>
			findTPOwnerIdFile(HttpPrincipal httpPrincipal, String fileId)
		throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "findTPOwnerIdFile",
				_findTPOwnerIdFileParameterTypes31);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput<String>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.claim.MuroorTPUploads> getMuroorTPUploadsData(
				HttpPrincipal httpPrincipal, String refNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getMuroorTPUploadsData",
				_getMuroorTPUploadsDataParameterTypes32);

			MethodHandler methodHandler = new MethodHandler(methodKey, refNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.claim.MuroorTPUploads>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.claim.MuroorODUploads> getMuroorODUploadsData(
				HttpPrincipal httpPrincipal, String refNo)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(
				ClaimServiceUtil.class, "getMuroorODUploadsData",
				_getMuroorODUploadsDataParameterTypes33);

			MethodHandler methodHandler = new MethodHandler(methodKey, refNo);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				if (exception instanceof
						com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException)
						exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.claim.MuroorODUploads>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(ClaimServiceHttp.class);

	private static final Class<?>[] _submitClaimParameterTypes0 = new Class[] {
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, int.class, String.class, String.class,
		String.class, String.class, String.class, String.class, String.class,
		String.class, String.class, String.class, String.class, double.class,
		String.class
	};
	private static final Class<?>[] _getClaimDetailsByClaimNOParameterTypes1 =
		new Class[] {String.class};
	private static final Class<?>[] _getClaimsSummaryParameterTypes2 =
		new Class[] {String.class};
	private static final Class<?>[] _getNajmUploadsFilesNameParameterTypes3 =
		new Class[] {String.class};
	private static final Class<?>[] _findNajmSlipFileParameterTypes4 =
		new Class[] {String.class};
	private static final Class<?>[] _findDamageEstQuotFileParameterTypes5 =
		new Class[] {String.class};
	private static final Class<?>[] _findBankIbanFileParameterTypes6 =
		new Class[] {String.class};
	private static final Class<?>[] _findOwnerIdFileParameterTypes7 =
		new Class[] {String.class};
	private static final Class<?>[] _getClaimsDtlsParameterTypes8 =
		new Class[] {String.class};
	private static final Class<?>[] _intimateClaimParameterTypes9 =
		new Class[] {
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class, String.class,
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getClaimsSummaryFiterParameterTypes10 =
		new Class[] {String.class, String.class, String.class};
	private static final Class<?>[] _checkIbanValidationParameterTypes11 =
		new Class[] {String.class};
	private static final Class<?>[] _getInsuranceCompaniesParameterTypes12 =
		new Class[] {};
	private static final Class<?>[] _submitClaimByObjectParameterTypes13 =
		new Class[] {com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation.class};
	private static final Class<?>[] _uploadNajmFilesParameterTypes14 =
		new Class[] {
			java.io.File.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class, java.io.File.class, String.class,
			String.class, String.class, String.class
		};
	private static final Class<?>[] _saveODMuroorDocParameterTypes15 =
		new Class[] {
			String.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class, java.io.File.class, String.class
		};
	private static final Class<?>[] _saveTPMuroorDocParameterTypes16 =
		new Class[] {
			String.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class, java.io.File.class, String.class,
			java.io.File.class, String.class
		};
	private static final Class<?>[] _downloadClaimReportParameterTypes17 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation.class,
			String.class, String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _getRoleWorkflowParameterTypes18 =
		new Class[] {String.class};
	private static final Class<?>[] _getVehiclePolicyParameterTypes19 =
		new Class[] {
			String.class, String.class, String.class, String.class, String.class
		};
	private static final Class<?>[] _getCityCoreCodeParameterTypes20 =
		new Class[] {String.class};
	private static final Class<?>[] _findODDriverLicenseFileParameterTypes21 =
		new Class[] {String.class};
	private static final Class<?>[] _findODVehRegistFileParameterTypes22 =
		new Class[] {String.class};
	private static final Class<?>[] _findODPolicyCopyFileParameterTypes23 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPDriverLicenseFileParameterTypes24 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPVehRegistFileParameterTypes25 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPFrontPhotoFileParameterTypes26 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPRearPhotoFileParameterTypes27 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPRightSidePhotoFileParameterTypes28 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPLeftSidePhotoFileParameterTypes29 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPBankIbanFileParameterTypes30 =
		new Class[] {String.class};
	private static final Class<?>[] _findTPOwnerIdFileParameterTypes31 =
		new Class[] {String.class};
	private static final Class<?>[] _getMuroorTPUploadsDataParameterTypes32 =
		new Class[] {String.class};
	private static final Class<?>[] _getMuroorODUploadsDataParameterTypes33 =
		new Class[] {String.class};

}