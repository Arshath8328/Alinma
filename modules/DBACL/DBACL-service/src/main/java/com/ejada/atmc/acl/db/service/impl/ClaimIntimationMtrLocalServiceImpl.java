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

import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.base.ClaimIntimationMtrLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.text.SimpleDateFormat;
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

	public static Log _log = LogFactoryUtil.getLog(ClaimIntimationMtrLocalServiceImpl.class);
	private int		counter		= 0000;
//	final ScheduledExecutorService	scheduler	= Executors.newSingleThreadScheduledExecutor();

	private static String	currentDate;

	static {
		currentDate = new SimpleDateFormat("MM/dd/yy").format(new Date()).replaceAll("/", "");
		_log.info("Static Block initialized with currenDate set to " + currentDate);
	}
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalService</code>
	 * via injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil</code>.
	 */
	public ClaimIntimationMtr intimateClaim(String claimantType, String policyNumber, String vehicleIdentNumber, String plateL1, String plateL2, String plateL3, long sequenceNumber,
			String chassisNumber, String mobileNumber, String causeOfLoss, Date dateOfLossOrAccident, String accidentCity, String accidentDescription, String sourceOfAccidentReport,
			String accidentReportNumber, String vehicleMake, String vehicleModel, String driverName, String driverNationality, long driverNationalId, Date driverDateOfBirthG, String driverGender) {
//		scheduler.scheduleAtFixedRate(() -> counter++, 0, 1, TimeUnit.DAYS); 
		long cimId = claimIntimationMtrFinder.getClaimIntimationSequence();

		String todaysDate = new SimpleDateFormat("MM/dd/yy").format(new Date()).replaceAll("/", "");
		String intimationRefNo = generateIntimationReferenceNumber(todaysDate);

		ClaimIntimationMtr claimIntimationMtr = ClaimIntimationMtrLocalServiceUtil.createClaimIntimationMtr(cimId);
		claimIntimationMtr.setIntimationReferenceNo(intimationRefNo);
		claimIntimationMtr.setAccidentCity(accidentCity);
		claimIntimationMtr.setClaimantType(claimantType);
		claimIntimationMtr.setPolicyNo(policyNumber);
		claimIntimationMtr.setVehiclePlateNo(vehicleIdentNumber + plateL1 + plateL2 + plateL3);
		claimIntimationMtr.setSequenceNo(sequenceNumber);
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
		ClaimIntimationMtrLocalServiceUtil.updateClaimIntimationMtr(claimIntimationMtr);
		return claimIntimationMtr;
	}

	private String generateIntimationReferenceNumber(String todaysDate) {
		StringBuilder sb = new StringBuilder();
		sb.append("ATMC");
		sb.append(todaysDate);
		if (Validator.isNull(currentDate) || !currentDate.equals(todaysDate)) {
			counter = 0000;
			currentDate = todaysDate;
			sb.append(String.format("%04d", counter));
		} else {
			counter++;
			sb.append(String.format("%04d", counter));
		}
		return sb.toString();
	}

	public List<ClaimIntimationMtr> findClaimIntimationList(String keyword){
		return claimIntimationMtrFinder.findClaimIntimationList(keyword);
	}
}