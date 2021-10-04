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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.claim.Claim;
import com.atmc.bsl.db.domain.claim.ClaimIntimation;
import com.atmc.bsl.db.domain.claim.ClaimWorkflow;
import com.atmc.bsl.db.domain.claim.MuroorODUploads;
import com.atmc.bsl.db.domain.claim.MuroorTPUploads;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.bsl.db.service.base.ClaimServiceBaseImpl;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Base64;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;

import org.osgi.service.component.annotations.Component;
import org.springframework.util.FileCopyUtils;

/**
 * The implementation of the claim remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.ClaimService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ClaimServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Claim" }, service = AopService.class)
public class ClaimServiceImpl extends ClaimServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.ClaimServiceUtil} to access the claim remote
	 * service.
	 */
	private static final String NAJM_CITY = "NAJM_CITY";
	private static final Log _log = LogFactoryUtil.getLog(ClaimServiceImpl.class);

	public String submitClaim(String referenceno, String source, String transaction, String policyno, String reportmode,
			String reportno, String vehidentitype, String vehidentivalue, String lossnature, String losscause,
			String lossdate, String lossremarks, int faultpercent, String losslocation, String tpdrivername,
			String tpdob, String tpid, String tpvehidentitype, String tpvehidentivalue, String tpplateno,
			String tpinsco, String tpmobile, String tpiban, String tpnationality, double amount, String damageflag)
			throws PortalException {
		return ClaimLocalServiceUtil.submitClaimFn(referenceno, source, transaction, policyno, reportmode, reportno,
				vehidentitype, vehidentivalue, lossnature, losscause, lossdate, lossremarks, faultpercent, losslocation,
				tpdrivername, tpdob, tpid, tpvehidentitype, tpvehidentivalue, tpplateno, tpinsco, tpmobile, tpiban,
				tpnationality, amount, damageflag);
	}

	public ServiceOutput<Claim> getClaimDetailsByClaimNO(String claimNumber) throws PortalException {
		ServiceOutput<Claim> svcOutput = new ServiceOutput<Claim>();
		try {
			Claim claimDetails = ClaimLocalServiceUtil.getClaimDetailsByClaimNO(claimNumber);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(claimDetails);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<List<Claim>> getClaimsSummary(String iqamaId) throws PortalException {
		ServiceOutput<List<Claim>> svcOutput = new ServiceOutput<List<Claim>>();
		try {
			List<Claim> claimList = ClaimLocalServiceUtil.getClaimsSummary(iqamaId);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(claimList);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<List<Object[]>> getNajmUploadsFilesName(String refNo) throws PortalException {
		ServiceOutput<List<Object[]>> svcOutput = new ServiceOutput<List<Object[]>>();
		try {
			List<Object[]> najmUolodasFilesName = ClaimLocalServiceUtil.getNajmUploadsFilesName(refNo);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(najmUolodasFilesName);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findNajmSlipFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] najmSlipFileByArr = ClaimLocalServiceUtil.findNajmSlipFile(Integer.valueOf(fileId));
			String najmSlipFile = Base64.encode(najmSlipFileByArr);
//			for(byte bayte:najmSlipFile){
//			}
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(najmSlipFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;

	}

	public ServiceOutput<String> findDamageEstQuotFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] damageEstQuotFileArr = ClaimLocalServiceUtil.findDamageEstQuotFile(Integer.valueOf(fileId));
			String damageEstQuotFile = Base64.encode(damageEstQuotFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(damageEstQuotFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findBankIbanFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] bankIbanFileArr = ClaimLocalServiceUtil.findBankIbanFile(Integer.valueOf(fileId));
			String bankIbanFile = Base64.encode(bankIbanFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(bankIbanFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findOwnerIdFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] ownerIdFileArr = ClaimLocalServiceUtil.findOwnerIdFile(Integer.valueOf(fileId));
			String ownerIdFile = Base64.encode(ownerIdFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(ownerIdFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<HashMap<String, Object>> getClaimsDtls(String iqamaId) throws PortalException {
		ServiceOutput<HashMap<String, Object>> srvOutput = new ServiceOutput<HashMap<String, Object>>();
		try {
			HashMap<String, Object> claimsDtls = ClaimLocalServiceUtil.getClaimsOutline(iqamaId);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(claimsDtls);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<ClaimIntimation> intimateClaim(String claimType, String vehicleIdentType,
			String vehicleIdentNumber, String plateL1, String plateL2, String plateL3, String reportMode,
			String reportNumber, String causeOfLoss, String natureOfLoss, String language) {
		ServiceOutput<ClaimIntimation> svcOutput = new ServiceOutput<ClaimIntimation>();

		Locale locale;
		if (language.equals("en"))
			locale = new Locale("en", "US");
		else
			locale = new Locale("ar", "SA");

		try {
			ClaimIntimation claimIntimation = claimLocalService.intimateClaim(claimType, vehicleIdentType,
					vehicleIdentNumber, plateL1, plateL2, plateL3, reportMode, reportNumber, causeOfLoss, natureOfLoss,
					locale);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(claimIntimation);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.getErrorCode(e.getClass()));
		}

		return svcOutput;

	}

	public ServiceOutput<List<Claim>> getClaimsSummaryFiter(String iqamaId, String claimStatus, String policyType)
			throws PortalException {
		ServiceOutput<List<Claim>> svcOutput = new ServiceOutput<List<Claim>>();
		try {
			List<Claim> claimList = ClaimLocalServiceUtil.getClaimsSummaryFiter(iqamaId, claimStatus, policyType);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(claimList);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<Integer> checkIbanValidation(String ibanParm) throws PortalException {
		ServiceOutput<Integer> svcOutput = new ServiceOutput<Integer>();
		try {
			int ibanValidFlag = ClaimLocalServiceUtil.checkIbanValidation(ibanParm);
			if (ibanValidFlag == 0) {
				svcOutput.setOutputCode(ReturnCodes.INVALID_IBAN);
			} else {
				svcOutput.setOutputCode(ReturnCodes.SUCCESS);
				svcOutput.setOutputObject(ibanValidFlag);
			}
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<List<CustomerMapDetails>> getInsuranceCompanies() throws PortalException {
		ServiceOutput<List<CustomerMapDetails>> svcOutput = new ServiceOutput<List<CustomerMapDetails>>();
		try {
			List<CustomerMapDetails> customerMapList = ClaimLocalServiceUtil.getInsuranceCompanies();
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(customerMapList);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	@JSONWebService(value = "submit-claim-by-object", method = "POST")
	public ServiceOutput<ODSCIResponse> submitClaimByObject(ODSClaimIntimation odsClaimInt) throws PortalException {
		ServiceOutput<ODSCIResponse> svcOutput = new ServiceOutput<ODSCIResponse>();
		try {
			ODSCIResponse submitClaimRes = ClaimLocalServiceUtil.submitClaim(odsClaimInt);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(submitClaimRes);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<Boolean> uploadNajmFiles(File najmSlipFile, String najmSlipFileName, File damageEstQuotFile,
			String damageEstQuotFileName, File bankIbanFile, String bankIbanFileName, File ownerIdFile,
			String ownerIdFileName, String caseNo, String cipiId, String claimRefNo) {
		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("image/png");
		acceptedTypes.add("image/jpg");
		acceptedTypes.add("image/jpeg");

		try {
			if (najmSlipFile == null || !najmSlipFile.exists()) {
				_log.info("najmSlipFile is Empty");
				najmSlipFile = null;
				najmSlipFileName = "";
			} else {
				_log.info("We have najmSlipFile to upload");
				_log.info("File Name:" + najmSlipFile.getName());
				_log.info("File Length:" + najmSlipFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(najmSlipFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(najmSlipFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("driverLicenseFile is rejected");
					najmSlipFile = null;
					najmSlipFileName = "";
				}
			}

			if (damageEstQuotFile == null || !damageEstQuotFile.exists()) {
				_log.info("damageEstQuotFile is Empty");
				damageEstQuotFile = null;
				damageEstQuotFileName = "";
			} else {
				_log.info("We have damageEstQuotFile to upload");
				_log.info("File Name:" + damageEstQuotFile.getName());
				_log.info("File Length:" + damageEstQuotFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(damageEstQuotFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(damageEstQuotFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("damageEstQuotFile is rejected");
					damageEstQuotFile = null;
					damageEstQuotFileName = "";
				}
			}

			if (bankIbanFile == null || !bankIbanFile.exists()) {
				_log.info("bankIbanFile is Empty");
				bankIbanFile = null;
				bankIbanFileName = "";
			} else {
				_log.info("We have bankIbanFile to upload");
				_log.info("File Name:" + bankIbanFile.getName());
				_log.info("File Length:" + bankIbanFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(bankIbanFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(bankIbanFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("bankIbanFile is rejected");
					bankIbanFile = null;
					bankIbanFileName = "";
				}
			}

			if (ownerIdFile == null || !ownerIdFile.exists()) {
				_log.info("ownerIdFile is Empty");
				ownerIdFile = null;
				ownerIdFileName = "";
			} else {
				_log.info("We have ownerIdFile to upload");
				_log.info("File Name:" + ownerIdFile.getName());
				_log.info("File Length:" + ownerIdFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(ownerIdFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(ownerIdFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("ownerIdFile is rejected");
					ownerIdFile = null;
					ownerIdFileName = "";
				}
			}
			ClaimLocalServiceUtil.saveNajmSubmitedFiles(caseNo, cipiId, najmSlipFile, najmSlipFileName,
					damageEstQuotFile, damageEstQuotFileName, bankIbanFile, bankIbanFileName, ownerIdFile,
					ownerIdFileName, claimRefNo);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<Boolean> saveODMuroorDoc(String iqamaId, String clmIntimationNo, File driverLicenseFile,
			String driverLicenseFileName, File vehRegistFile, String vehRegistFileName, File policyCopyFile,
			String policyCopyFileName) throws PortalException {
		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("image/png");
		acceptedTypes.add("image/jpg");
		acceptedTypes.add("image/jpeg");

		try {
			if (driverLicenseFile == null || !driverLicenseFile.exists()) {
				_log.info("driverLicenseFile is Empty");
				driverLicenseFile = null;
				driverLicenseFileName = "";
			} else {
				_log.info("We have driverLicenseFile to upload");
				_log.info("File Name:" + driverLicenseFile.getName());
				_log.info("File Length:" + driverLicenseFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(driverLicenseFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(driverLicenseFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("driverLicenseFile is rejected");
					driverLicenseFile = null;
					driverLicenseFileName = "";
				}
			}

			if (vehRegistFile == null || !vehRegistFile.exists()) {
				_log.info("vehRegistFile is Empty");
				vehRegistFile = null;
				vehRegistFileName = "";
			} else {
				_log.info("We have vehRegistFile to upload");
				_log.info("File Name:" + vehRegistFile.getName());
				_log.info("File Length:" + vehRegistFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(vehRegistFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(vehRegistFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("vehRegistFile is rejected");
					vehRegistFile = null;
					vehRegistFileName = "";
				}
			}

			if (policyCopyFile == null || !policyCopyFile.exists()) {
				_log.info("driverLicenseFile is Empty");
				policyCopyFile = null;
				policyCopyFileName = "";
			} else {
				_log.info("We have policyCopyFile to upload");
				_log.info("File Name:" + policyCopyFile.getName());
				_log.info("File Length:" + policyCopyFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(policyCopyFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(policyCopyFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("driverLicenseFile is rejected");
					policyCopyFile = null;
					policyCopyFileName = "";
				}
			}

			ClaimLocalServiceUtil.saveODMuroorDoc(iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
					vehRegistFile, vehRegistFileName, policyCopyFile, policyCopyFileName);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<Boolean> saveTPMuroorDoc(String iqamaId, String clmIntimationNo, File driverLicenseFile,
			String driverLicenseFileName, File vehRegistFile, String vehRegistFileName, File frontPhoto,
			String frontPhotoName, File rarePhoto, String rarePhotoName, File rightSidePhoto, String rightSidePhotoName,
			File leftSidePhoto, String leftSidePhotoName, File bankIbanFile, String bankIbanFileName, File ownerIdFile,
			String ownerIdFileName) throws PortalException {
		ServiceOutput<Boolean> srvOutput = new ServiceOutput<Boolean>();

		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("image/png");
		acceptedTypes.add("image/jpg");
		acceptedTypes.add("image/jpeg");

		try {
			if (driverLicenseFile == null || !driverLicenseFile.exists()) {
				_log.info("driverLicenseFile is Empty");
				driverLicenseFile = null;
				driverLicenseFileName = "";
			} else {
				_log.info("We have driverLicenseFile to upload");
				_log.info("File Name:" + driverLicenseFile.getName());
				_log.info("File Length:" + driverLicenseFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(driverLicenseFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(driverLicenseFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("driverLicenseFile is rejected");
					driverLicenseFile = null;
					driverLicenseFileName = "";
				}
			}

			if (vehRegistFile == null || !vehRegistFile.exists()) {
				_log.info("vehRegistFile is Empty");
				vehRegistFile = null;
				vehRegistFileName = "";
			} else {
				_log.info("We have vehRegistFile to upload");
				_log.info("File Name:" + vehRegistFile.getName());
				_log.info("File Length:" + vehRegistFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(vehRegistFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(vehRegistFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("vehRegistFile is rejected");
					vehRegistFile = null;
					vehRegistFileName = "";
				}
			}

			if (frontPhoto == null || !frontPhoto.exists()) {
				_log.info("frontPhoto is Empty");
				frontPhoto = null;
				frontPhotoName = "";
			} else {
				_log.info("We have frontPhoto to upload");
				_log.info("File Name:" + frontPhoto.getName());
				_log.info("File Length:" + frontPhoto.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(frontPhoto,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(frontPhoto);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("driverLicenseFile is rejected");
					frontPhoto = null;
					frontPhotoName = "";
				}
			}

			if (rarePhoto == null || !rarePhoto.exists()) {
				_log.info("rarePhoto is Empty");
				rarePhoto = null;
				rarePhotoName = "";
			} else {
				_log.info("We have rarePhoto to upload");
				_log.info("File Name:" + rarePhoto.getName());
				_log.info("File Length:" + rarePhoto.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(rarePhoto,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(rarePhoto);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("rarePhoto is rejected");
					rarePhoto = null;
					rarePhotoName = "";
				}
			}

			if (rightSidePhoto == null || !rightSidePhoto.exists()) {
				_log.info("rightSidePhoto is Empty");
				rightSidePhoto = null;
				rightSidePhotoName = "";
			} else {
				_log.info("We have rightSidePhoto to upload");
				_log.info("File Name:" + rightSidePhoto.getName());
				_log.info("File Length:" + rightSidePhoto.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(rightSidePhoto,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(rightSidePhoto);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("rightSidePhoto is rejected");
					rightSidePhoto = null;
					rightSidePhotoName = "";
				}
			}

			if (leftSidePhoto == null || !leftSidePhoto.exists()) {
				_log.info("leftSidePhoto is Empty");
				leftSidePhoto = null;
				leftSidePhotoName = "";
			} else {
				_log.info("We have leftSidePhoto to upload");
				_log.info("File Name:" + leftSidePhoto.getName());
				_log.info("File Length:" + leftSidePhoto.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(leftSidePhoto,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(leftSidePhoto);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("leftSidePhoto is rejected");
					leftSidePhoto = null;
					leftSidePhotoName = "";
				}
			}

			if (bankIbanFile == null || !bankIbanFile.exists()) {
				_log.info("bankIbanFile is Empty");
				bankIbanFile = null;
				bankIbanFileName = "";
			} else {
				_log.info("We have bankIbanFile to upload");
				_log.info("File Name:" + bankIbanFile.getName());
				_log.info("File Length:" + bankIbanFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(bankIbanFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(bankIbanFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("bankIbanFile is rejected");
					bankIbanFile = null;
					bankIbanFileName = "";
				}
			}

			if (ownerIdFile == null || !ownerIdFile.exists()) {
				_log.info("ownerIdFile is Empty");
				ownerIdFile = null;
				ownerIdFileName = "";
			} else {
				_log.info("We have ownerIdFile to upload");
				_log.info("File Name:" + ownerIdFile.getName());
				_log.info("File Length:" + ownerIdFile.length());

				boolean isFileTypeAccepted = com.ejada.atmc.utils.api.FileUtil.isAcceptedFileType(ownerIdFile,
						acceptedTypes);
				boolean isFileExecutable = com.ejada.atmc.utils.api.FileUtil.isExecutable(ownerIdFile);

				if (!isFileTypeAccepted || isFileExecutable) {
					_log.info("ownerIdFile is rejected");
					ownerIdFile = null;
					ownerIdFileName = "";
				}
			}

			ClaimLocalServiceUtil.saveTPMuroorDoc(iqamaId, clmIntimationNo, driverLicenseFile, driverLicenseFileName,
					vehRegistFile, vehRegistFileName, frontPhoto, frontPhotoName, rarePhoto, rarePhotoName,
					rightSidePhoto, rightSidePhotoName, leftSidePhoto, leftSidePhotoName, bankIbanFile,
					bankIbanFileName, ownerIdFile, ownerIdFileName);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<String> downloadClaimReport(ODSClaimIntimation odsClaimInt, String claimintName,
			String claimintMobile, String claimintEmail, String claimintId, String lang) {
		ServiceOutput<String> srvOutput = new ServiceOutput<String>();
		try {
			File claimFile = ClaimLocalServiceUtil.downloadClaimReport(odsClaimInt, claimintName, claimintMobile,
					claimintEmail, claimintId, lang);
			String base64 = Base64.encode(FileCopyUtils.copyToByteArray(claimFile));
			srvOutput.setOutputObject(base64);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<List<ClaimWorkflow>> getRoleWorkflow(String workflowRole) {
		ServiceOutput<List<ClaimWorkflow>> srvOutput = new ServiceOutput<List<ClaimWorkflow>>();
		try {
			List<ClaimWorkflow> workFlowList = ClaimLocalServiceUtil.getRoleWorkflow(workflowRole);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(workFlowList);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<PolicyHDR> getVehiclePolicy(String plateNo, String plateL1, String plateL2, String plateL3,
			String language) {
		ServiceOutput<PolicyHDR> srvOutput = new ServiceOutput<PolicyHDR>();
		try {
			PolicyHDR policy = ClaimLocalServiceUtil.getVehiclePolicy(plateNo, plateL1, plateL2, plateL3, language);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(policy);
		} catch (Exception e) {
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<String> getCityCoreCode(String cityCode) {
		ServiceOutput<String> srvOutput = new ServiceOutput<String>();
		CodeMasterMap codeMasterMap = null;
		try {

			codeMasterMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(NAJM_CITY, cityCode);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			if (codeMasterMap != null) {
				srvOutput.setOutputObject(codeMasterMap.getCoreCode());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			srvOutput.setOutputCode(ReturnCodes.FAIL);

		}
		return srvOutput;

	}

	public ServiceOutput<String> findODDriverLicenseFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] driverLicenseFileArr = ClaimLocalServiceUtil.findODDriverLicenseFile(Integer.valueOf(fileId));
			String driverLicenseFile = Base64.encode(driverLicenseFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(driverLicenseFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findODVehRegistFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] vehRegistFileArr = ClaimLocalServiceUtil.findODVehRegistFile(Integer.valueOf(fileId));
			String vehRegistFile = Base64.encode(vehRegistFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(vehRegistFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findODPolicyCopyFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] policyCopyFileArr = ClaimLocalServiceUtil.findODPolicyCopyFile(Integer.valueOf(fileId));
			String policyCopyFile = Base64.encode(policyCopyFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(policyCopyFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPDriverLicenseFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] driverLicenseFileArr = ClaimLocalServiceUtil.findTPDriverLicenseFile(Integer.valueOf(fileId));
			String driverLicenseFile = Base64.encode(driverLicenseFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(driverLicenseFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPVehRegistFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] vehRegistFileArr = ClaimLocalServiceUtil.findTPVehRegistFile(Integer.valueOf(fileId));
			String vehRegistFile = Base64.encode(vehRegistFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(vehRegistFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPFrontPhotoFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] frontPhotoFileArr = ClaimLocalServiceUtil.findTPFrontPhotoFile(Integer.valueOf(fileId));
			String frontPhotoFile = Base64.encode(frontPhotoFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(frontPhotoFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPRearPhotoFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] rearPhotoFileArr = ClaimLocalServiceUtil.findTPRearPhotoFile(Integer.valueOf(fileId));
			String rearPhotoFile = Base64.encode(rearPhotoFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(rearPhotoFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPRightSidePhotoFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] rightSidePhotoFileArr = ClaimLocalServiceUtil.findTPRightSidePhotoFile(Integer.valueOf(fileId));
			String rightSidePhotoFile = Base64.encode(rightSidePhotoFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(rightSidePhotoFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPLeftSidePhotoFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] leftSidePhotoFileArr = ClaimLocalServiceUtil.findTPLeftSidePhotoFile(Integer.valueOf(fileId));
			String leftSidePhotoFile = Base64.encode(leftSidePhotoFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(leftSidePhotoFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPBankIbanFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] bankIbanFileArr = ClaimLocalServiceUtil.findTPBankIbanFile(Integer.valueOf(fileId));
			String bankIbanFile = Base64.encode(bankIbanFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(bankIbanFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;

	}

	public ServiceOutput<String> findTPOwnerIdFile(String fileId) throws PortalException {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			byte[] ownerIdFileArr = ClaimLocalServiceUtil.findTPOwnerIdFile(Integer.valueOf(fileId));
			String ownerIdFile = Base64.encode(ownerIdFileArr);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(ownerIdFile);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<MuroorTPUploads> getMuroorTPUploadsData(String refNo) throws PortalException {
		ServiceOutput<MuroorTPUploads> svcOutput = new ServiceOutput<MuroorTPUploads>();
		try {
			MuroorTPUploads muroorTPUploadData = ClaimLocalServiceUtil.getMuroorTPUploadsData(refNo);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(muroorTPUploadData);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<MuroorODUploads> getMuroorODUploadsData(String refNo) throws PortalException {
		ServiceOutput<MuroorODUploads> svcOutput = new ServiceOutput<MuroorODUploads>();
		try {
			MuroorODUploads muroorODUploadData = ClaimLocalServiceUtil.getMuroorODUploadsData(refNo);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(muroorODUploadData);
		} catch (Exception e) {
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}
}