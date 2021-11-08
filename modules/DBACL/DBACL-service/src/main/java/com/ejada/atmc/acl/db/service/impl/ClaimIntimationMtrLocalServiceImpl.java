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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO;
import com.ejada.atmc.acl.db.custom.model.ODSPolActiveVehicleDTO;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.base.ClaimIntimationMtrLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the claim intimation mtr local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    ClaimIntimationMtrLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.ClaimIntimationMtr",
		service = AopService.class
)
public class ClaimIntimationMtrLocalServiceImpl extends ClaimIntimationMtrLocalServiceBaseImpl {

	public static Log		_log	= LogFactoryUtil.getLog(ClaimIntimationMtrLocalServiceImpl.class);
	private static int		counter	= 1;
//	final ScheduledExecutorService	scheduler	= Executors.newSingleThreadScheduledExecutor();

	private static String	currentDate;

	static {
		currentDate = new SimpleDateFormat("dd/MM/yy").format(new Date()).replaceAll("/", "");
		_log.info("Static Block initialized with currenDate set to " + currentDate + " with counter : " + counter);
	}

	private String generateIntimationReferenceNumber(String todaysDate) {
		StringBuilder sb = new StringBuilder();
		currentDate = todaysDate;
		sb.append("ATMC");
		sb.append(todaysDate);
		computeCounter();
		sb.append(counter);
		return sb.toString();
	}

	private void computeCounter() {
		ClaimIntimationMtr claimIntimationMtr = claimIntimationMtrFinder.fetchLastRecord();
		if (claimIntimationMtr != null) {
			String intimationReferenceNo = claimIntimationMtr.getIntimationReferenceNo();
			String lastRecordDate = intimationReferenceNo.substring(4, 10);
			if (lastRecordDate.equals(currentDate)) {
				counter = Integer.parseInt(intimationReferenceNo.substring(10, intimationReferenceNo.length())) + 1;
				_log.info("Counter is reset for currentDate : " + currentDate + " -> counter : " + counter);
			}
		}
	}

	public ClaimIntimationMtr intimateClaim(String claimantType, String policyNumber, String vehicleIdentNumber, String plateL1, String plateL2, String plateL3, String sequenceNumber,
			String chassisNumber, String mobileNumber, String causeOfLoss, Date dateOfLossOrAccident, String accidentCity, String accidentDescription, String sourceOfAccidentReport,
			String accidentReportNumber, String vehicleMake, String vehicleModel, String driverName, String driverNationality, long driverNationalId, Date driverDateOfBirthG, String driverGender,
			String ibanNumber, String bankName, String emailId)
	{
//		scheduler.scheduleAtFixedRate(() -> counter++, 0, 1, TimeUnit.DAYS); 
		long cimId = claimIntimationMtrFinder.getClaimIntimationSequence();
		String todaysDate = new SimpleDateFormat("dd/MM/yy").format(new Date()).replaceAll("/", "");
		String intimationRefNo = generateIntimationReferenceNumber(todaysDate);

		ClaimIntimationMtr claimIntimationMtr = ClaimIntimationMtrLocalServiceUtil.createClaimIntimationMtr(cimId);
		claimIntimationMtr.setIntimationReferenceNo(intimationRefNo);
		claimIntimationMtr.setAccidentCity(accidentCity);
		claimIntimationMtr.setClaimantType(claimantType);
		claimIntimationMtr.setPolicyNo(policyNumber);
		claimIntimationMtr.setVehiclePlateNo(vehicleIdentNumber + plateL1 + plateL2 + plateL3);
		if (sequenceNumber != null && !sequenceNumber.equals(""))
			claimIntimationMtr.setSequenceNo(Long.parseLong(sequenceNumber));
		claimIntimationMtr.setChassisNo(chassisNumber);
		claimIntimationMtr.setMobileNo(mobileNumber);
		claimIntimationMtr.setCauseOfLoss(causeOfLoss);
		claimIntimationMtr.setDateOfLoss(dateOfLossOrAccident);
		claimIntimationMtr.setAccidentCity(accidentCity);
		claimIntimationMtr.setDescOfAccident(accidentDescription);
		claimIntimationMtr.setSrcOfAccidentReport(sourceOfAccidentReport);
		claimIntimationMtr.setAccidentReportNo(accidentReportNumber);
		claimIntimationMtr.setVehicleMake(vehicleMake);
		claimIntimationMtr.setVehicleModel(vehicleModel);
		claimIntimationMtr.setDriverName(driverName);
		claimIntimationMtr.setDriverNationality(driverNationality);
		claimIntimationMtr.setDriverNationalId(driverNationalId);
		claimIntimationMtr.setDriverBirthDate(driverDateOfBirthG);
		claimIntimationMtr.setDriverGender(driverGender);
		claimIntimationMtr.setIbanNumber(ibanNumber);
		claimIntimationMtr.setBankName(bankName);
		claimIntimationMtr.setEmailId(emailId);

		// Initial Claim Status : 1 - Intimated Successully
		claimIntimationMtr.setClaimStatus(1);
		ClaimIntimationMtrLocalServiceUtil.updateClaimIntimationMtr(claimIntimationMtr);
		return claimIntimationMtr;
	}

	public List<ClaimIntimationMtr> getAllClaims() {
		return claimIntimationMtrFinder.getAllClaims();
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationsStatus(String findByValue) {
		return claimIntimationMtrFinder.findClaimIntimationsStatus(findByValue);
	}

	public ODSPolActiveVehicleDTO findOdsVehicleActiveList(String chassisNo, String policyNo) {
		return claimIntimationMtrFinder.findOdsVehicleActiveList(chassisNo, policyNo);
	}

	public List<ClaimIntimationMtr> findClaimIntimationList(String keyword) {
		return claimIntimationMtrFinder.findClaimIntimationList(keyword);
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationList(String findByCategory, String findByValue) {
		return claimIntimationMtrFinder.findClaimIntimationsByCategory(findByCategory, findByValue);
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationListByAllCategories(List<String> findByCategories, String findByValue) {
		List<ClaimIntimationMtrDTO> claimsDTO = new ArrayList<>();
		for (String findByCategory : findByCategories) {
			if (findByCategory.equals("Driver_National_ID") || findByCategory.equalsIgnoreCase("Mobile_No")) {
				try {
					String findNumberValue = String.valueOf(Long.parseLong(findByValue));
					claimsDTO.addAll(claimIntimationMtrFinder.findClaimIntimationsByCategory(findByCategory, findNumberValue));
				} catch (Exception e) {
					_log.error("Skipping field : " + findByCategory);
				}
			} else {
				claimsDTO.addAll(claimIntimationMtrFinder.findClaimIntimationsByCategory(findByCategory, findByValue));
			}
		}
		return claimsDTO;
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationListFromView(String referenceNo) {
		return claimIntimationMtrFinder.findClaimIntimationListByReferenceNoFromView(referenceNo);
	}

	public List<ClaimIntimationMtr> findClaimIntimationList(int findByCategory, String findByValue) {
		List<ClaimIntimationMtr> claimsList = new ArrayList<>();
		switch (findByCategory) {
			case 1:
				ClaimIntimationMtr claim;
				try {
					claim = ClaimIntimationMtrLocalServiceUtil.getClaimIntimationMtr(Long.parseLong(findByValue));
					claimsList.add(claim);
				} catch (NumberFormatException | PortalException e) {
					_log.error(e.getMessage(), e);
				}
				break;
			case 2:
				claimsList = claimIntimationMtrPersistence.findByintimationReferenceNo(findByValue);
				break;
			case 3:
				claimsList = claimIntimationMtrPersistence.findBymobileNo(findByValue);
				break;
			case 4:
				claimsList = claimIntimationMtrPersistence.findBydriverNationalId(Long.parseLong(findByValue));
				break;
			default:
				break;

		}
		return claimsList;
	}
}