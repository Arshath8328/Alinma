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

import com.atmc.bsl.db.domain.workshop.WorkshopVehicles;
import com.atmc.bsl.db.service.base.WorkshopLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.model.WorkshopVehicle;
import com.ejada.atmc.acl.db.service.persistence.WorkshopVehicleUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.aop.AopService;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the workshop local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.WorkshopLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopLocalServiceBaseImpl
 */
@Component(property = "model.class.name=com.atmc.bsl.db.model.Workshop", service = AopService.class)
public class WorkshopLocalServiceImpl extends WorkshopLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.WorkshopLocalServiceUtil} to access the
	 * workshop local service.
	 * 
	 * 
	 */
	public void checkInVehicle(String customerName, String customerMobile, String manufacture, String plateNo,
			int workshopId, String claimRefNo, String status, String date, String serviceType, String desc,
			String vehMakeEn, String vehMakeAr, String vehModelEn, String vehModelAr, String customerIqamaId) {
		WorkshopVehicle WorkshopVehicle = WorkshopVehicleUtil.create((int) CounterLocalServiceUtil.increment());
		WorkshopVehicle.setCustomerName(customerName);
		WorkshopVehicle.setCustomerMobile(customerMobile);
		WorkshopVehicle.setManufacture(manufacture);
		WorkshopVehicle.setPlateNo(plateNo);
		WorkshopVehicle.setClaimRefNo(claimRefNo);
		WorkshopVehicle.setWorkshopId(workshopId);
		WorkshopVehicle.setStatus(status);
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		Date dateCon = null;
		try {
			dateCon = format.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WorkshopVehicle.setDate(dateCon);
		WorkshopVehicle.setServiceType(serviceType);
		WorkshopVehicle.setDescription(desc);
		WorkshopVehicle.setVehMakeEn(vehMakeEn);
		WorkshopVehicle.setVehMakeAr(vehMakeAr);
		WorkshopVehicle.setVehModelEn(vehModelEn);
		WorkshopVehicle.setVehModelAr(vehModelAr);
		WorkshopVehicle.setCustomerIqamaId(customerIqamaId);
		WorkshopVehicleUtil.update(WorkshopVehicle);
	}

	public List<WorkshopVehicles> getcheckedInVehicleByStatus(String status, int workShopId) {
		List<WorkshopVehicle> WorkshopVehicleList = WorkshopVehicleUtil.findByStatusWorkshopId(status, workShopId);
		List<WorkshopVehicles> WorkshopVehiclesList = getCustomWorkshopVehiclesList(WorkshopVehicleList);
		return WorkshopVehiclesList;
	}

	public WorkshopVehicles getcheckedInVehicleById(int id) {
		WorkshopVehicle WorkshopVehicle = WorkshopVehicleUtil.fetchByPrimaryKey(id);
		WorkshopVehicles WorkshopVehicles = getCustomWorkshopVehicles(WorkshopVehicle);
		return WorkshopVehicles;
	}

	public List<WorkshopVehicles> getcheckedInVehicleByIqmaId(String iqamaId) {
		List<WorkshopVehicle> WorkshopVehicle = WorkshopVehicleUtil.findBycustomerIqamaId(iqamaId);
		List<WorkshopVehicles> WorkshopVehicles = getCustomWorkshopVehiclesList(WorkshopVehicle);
		return WorkshopVehicles;
	}

	private List<WorkshopVehicles> getCustomWorkshopVehiclesList(List<WorkshopVehicle> workshopVehicleList) {
		List<WorkshopVehicles> WorkshopVehiclesList = new ArrayList<WorkshopVehicles>();

		for (WorkshopVehicle workshopVehicle : workshopVehicleList) {
			WorkshopVehicles WorkshopVehicles = getCustomWorkshopVehicles(workshopVehicle);

			WorkshopVehiclesList.add(WorkshopVehicles);
		}
		return WorkshopVehiclesList;
	}

	private WorkshopVehicles getCustomWorkshopVehicles(WorkshopVehicle workshopVehicle) {
		WorkshopVehicles WorkshopVehicles = new WorkshopVehicles();

		WorkshopVehicles.setId(workshopVehicle.getId());
		WorkshopVehicles.setCustomerName(workshopVehicle.getCustomerName());
		WorkshopVehicles.setCustomerMobile(workshopVehicle.getCustomerMobile());
		WorkshopVehicles.setManufacture(workshopVehicle.getManufacture());
		WorkshopVehicles.setPlateNo(workshopVehicle.getPlateNo());
		WorkshopVehicles.setWorkshopId(workshopVehicle.getWorkshopId());
		WorkshopVehicles.setClaimRefNo(workshopVehicle.getClaimRefNo());
		WorkshopVehicles.setStatus(workshopVehicle.getStatus());
		WorkshopVehicles.setDate(workshopVehicle.getDate());
		WorkshopVehicles.setServiceType(workshopVehicle.getServiceType());
		WorkshopVehicles.setDescription(workshopVehicle.getDescription());
		WorkshopVehicles.setVehMakeEn(workshopVehicle.getVehMakeEn());
		WorkshopVehicles.setVehMakeAr(workshopVehicle.getVehMakeAr());
		WorkshopVehicles.setVehModeleEn(workshopVehicle.getVehModelEn());
		WorkshopVehicles.setVehModelAr(workshopVehicle.getVehModelAr());
		WorkshopVehicles.setCustomerIqamaId(workshopVehicle.getCustomerIqamaId());
		return WorkshopVehicles;
	}

	public void updateVehicleStatus(int id, String status) {
		WorkshopVehicle WorkshopVehicle = WorkshopVehicleUtil.fetchByPrimaryKey(id);
		WorkshopVehicle.setStatus(status);
		WorkshopVehicleUtil.update(WorkshopVehicle);
	}
}