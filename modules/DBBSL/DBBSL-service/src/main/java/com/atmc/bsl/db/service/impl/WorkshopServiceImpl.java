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

import com.atmc.bsl.db.service.WorkshopLocalServiceUtil;
import com.atmc.bsl.db.service.base.WorkshopServiceBaseImpl;
import com.ejada.atmc.bsl.db.domain.ReturnCodes;
import com.ejada.atmc.bsl.db.domain.ServiceOutput;
import com.ejada.atmc.bsl.db.domain.workshop.WorkshopList;
import com.ejada.atmc.bsl.db.domain.workshop.WorkshopVehicles;
import com.liferay.portal.aop.AopService;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the workshop remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.WorkshopService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=Workshop" }, service = AopService.class)
public class WorkshopServiceImpl extends WorkshopServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.WorkshopServiceUtil} to access the workshop
	 * remote service.
	 */
	public ServiceOutput<String> checkInVehicle(String customerName, String customerMobile, String manufacture,
			String plateNo, int workshopId, String claimRefNo, String status, String date, String serviceType,
			String desc, String vehMakeEn, String vehMakeAr, String vehModelEn, String vehModelAr,
			String customerIqamaId) {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			WorkshopLocalServiceUtil.checkInVehicle(customerName, customerMobile, manufacture, plateNo, workshopId,
					claimRefNo, status, date, serviceType, desc, vehMakeEn, vehMakeAr, vehModelEn, vehModelAr,
					customerIqamaId);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<List<WorkshopVehicles>> getcheckedInVehicleByStatus(String status, int workShopId) {
		ServiceOutput<List<WorkshopVehicles>> svcOutput = new ServiceOutput<List<WorkshopVehicles>>();
		try {
			List<WorkshopVehicles> WorkshopVehiclesList = WorkshopLocalServiceUtil.getcheckedInVehicleByStatus(status,
					workShopId);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(WorkshopVehiclesList);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<WorkshopVehicles> getcheckedInVehicleById(int id) {
		ServiceOutput<WorkshopVehicles> svcOutput = new ServiceOutput<WorkshopVehicles>();
		try {
			WorkshopVehicles WorkshopVehicles = WorkshopLocalServiceUtil.getcheckedInVehicleById(id);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(WorkshopVehicles);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<String> updateVehicleStatus(int id, String status) {
		ServiceOutput<String> svcOutput = new ServiceOutput<String>();
		try {
			WorkshopLocalServiceUtil.updateVehicleStatus(id, status);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<List<WorkshopVehicles>> getcheckedInVehicleByIqmaId(String iqamaId) {
		ServiceOutput<List<WorkshopVehicles>> svcOutput = new ServiceOutput<List<WorkshopVehicles>>();
		try {
			List<WorkshopVehicles> WorkshopVehiclesList = WorkshopLocalServiceUtil.getcheckedInVehicleByIqmaId(iqamaId);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(WorkshopVehiclesList);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}

	public ServiceOutput<List<WorkshopList>> getWorkShopList() {
		ServiceOutput<List<WorkshopList>> svcOutput = new ServiceOutput<List<WorkshopList>>();
		try {
			List<WorkshopList> myWorkshopList = new ArrayList<WorkshopList>();
			WorkshopList workShop1 = new WorkshopList();
			workShop1.setWorkshopName("Workshop One");
			workShop1.setWorkshopLocation("28 Oraby Street");
			workShop1.setWorkshopStatus("Open");
			String workfromString = "08:00 AM";
			String worktoString = "05:00 PM";
			DateFormat format = new SimpleDateFormat("hh:mm a");
			Date workFrom = format.parse(workfromString);
			Date workTo = format.parse(worktoString);
			workShop1.setWorkfrom(workFrom);
			workShop1.setWorkTo(workTo);
			workShop1.setLocationURL("Almahdani Gas Station, 5761, Malham 15456, SA");
			workShop1.setWorkshopPhone("9661234567891");
			workShop1.setWorkshopRating(3);
			myWorkshopList.add(workShop1);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(myWorkshopList);
		} catch (Exception e) {
			// TODO: handle exception
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return svcOutput;
	}
}