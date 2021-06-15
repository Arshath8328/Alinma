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

package com.ejada.atmc.acl.db.model;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link WorkshopVehicle}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see WorkshopVehicle
 * @generated
 */
public class WorkshopVehicleWrapper
	extends BaseModelWrapper<WorkshopVehicle>
	implements ModelWrapper<WorkshopVehicle>, WorkshopVehicle {

	public WorkshopVehicleWrapper(WorkshopVehicle workshopVehicle) {
		super(workshopVehicle);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("customerName", getCustomerName());
		attributes.put("manufacture", getManufacture());
		attributes.put("plateNo", getPlateNo());
		attributes.put("workshopId", getWorkshopId());
		attributes.put("claimRefNo", getClaimRefNo());
		attributes.put("status", getStatus());
		attributes.put("date", getDate());
		attributes.put("serviceType", getServiceType());
		attributes.put("description", getDescription());
		attributes.put("customerMobile", getCustomerMobile());
		attributes.put("vehMakeEn", getVehMakeEn());
		attributes.put("vehMakeAr", getVehMakeAr());
		attributes.put("vehModelEn", getVehModelEn());
		attributes.put("vehModelAr", getVehModelAr());
		attributes.put("customerIqamaId", getCustomerIqamaId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Integer id = (Integer)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String customerName = (String)attributes.get("customerName");

		if (customerName != null) {
			setCustomerName(customerName);
		}

		String manufacture = (String)attributes.get("manufacture");

		if (manufacture != null) {
			setManufacture(manufacture);
		}

		String plateNo = (String)attributes.get("plateNo");

		if (plateNo != null) {
			setPlateNo(plateNo);
		}

		Integer workshopId = (Integer)attributes.get("workshopId");

		if (workshopId != null) {
			setWorkshopId(workshopId);
		}

		String claimRefNo = (String)attributes.get("claimRefNo");

		if (claimRefNo != null) {
			setClaimRefNo(claimRefNo);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Date date = (Date)attributes.get("date");

		if (date != null) {
			setDate(date);
		}

		String serviceType = (String)attributes.get("serviceType");

		if (serviceType != null) {
			setServiceType(serviceType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String customerMobile = (String)attributes.get("customerMobile");

		if (customerMobile != null) {
			setCustomerMobile(customerMobile);
		}

		String vehMakeEn = (String)attributes.get("vehMakeEn");

		if (vehMakeEn != null) {
			setVehMakeEn(vehMakeEn);
		}

		String vehMakeAr = (String)attributes.get("vehMakeAr");

		if (vehMakeAr != null) {
			setVehMakeAr(vehMakeAr);
		}

		String vehModelEn = (String)attributes.get("vehModelEn");

		if (vehModelEn != null) {
			setVehModelEn(vehModelEn);
		}

		String vehModelAr = (String)attributes.get("vehModelAr");

		if (vehModelAr != null) {
			setVehModelAr(vehModelAr);
		}

		String customerIqamaId = (String)attributes.get("customerIqamaId");

		if (customerIqamaId != null) {
			setCustomerIqamaId(customerIqamaId);
		}
	}

	/**
	 * Returns the claim ref no of this workshop vehicle.
	 *
	 * @return the claim ref no of this workshop vehicle
	 */
	@Override
	public String getClaimRefNo() {
		return model.getClaimRefNo();
	}

	/**
	 * Returns the customer iqama ID of this workshop vehicle.
	 *
	 * @return the customer iqama ID of this workshop vehicle
	 */
	@Override
	public String getCustomerIqamaId() {
		return model.getCustomerIqamaId();
	}

	/**
	 * Returns the customer mobile of this workshop vehicle.
	 *
	 * @return the customer mobile of this workshop vehicle
	 */
	@Override
	public String getCustomerMobile() {
		return model.getCustomerMobile();
	}

	/**
	 * Returns the customer name of this workshop vehicle.
	 *
	 * @return the customer name of this workshop vehicle
	 */
	@Override
	public String getCustomerName() {
		return model.getCustomerName();
	}

	/**
	 * Returns the date of this workshop vehicle.
	 *
	 * @return the date of this workshop vehicle
	 */
	@Override
	public Date getDate() {
		return model.getDate();
	}

	/**
	 * Returns the description of this workshop vehicle.
	 *
	 * @return the description of this workshop vehicle
	 */
	@Override
	public String getDescription() {
		return model.getDescription();
	}

	/**
	 * Returns the ID of this workshop vehicle.
	 *
	 * @return the ID of this workshop vehicle
	 */
	@Override
	public int getId() {
		return model.getId();
	}

	/**
	 * Returns the manufacture of this workshop vehicle.
	 *
	 * @return the manufacture of this workshop vehicle
	 */
	@Override
	public String getManufacture() {
		return model.getManufacture();
	}

	/**
	 * Returns the plate no of this workshop vehicle.
	 *
	 * @return the plate no of this workshop vehicle
	 */
	@Override
	public String getPlateNo() {
		return model.getPlateNo();
	}

	/**
	 * Returns the primary key of this workshop vehicle.
	 *
	 * @return the primary key of this workshop vehicle
	 */
	@Override
	public int getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the service type of this workshop vehicle.
	 *
	 * @return the service type of this workshop vehicle
	 */
	@Override
	public String getServiceType() {
		return model.getServiceType();
	}

	/**
	 * Returns the status of this workshop vehicle.
	 *
	 * @return the status of this workshop vehicle
	 */
	@Override
	public String getStatus() {
		return model.getStatus();
	}

	/**
	 * Returns the veh make ar of this workshop vehicle.
	 *
	 * @return the veh make ar of this workshop vehicle
	 */
	@Override
	public String getVehMakeAr() {
		return model.getVehMakeAr();
	}

	/**
	 * Returns the veh make en of this workshop vehicle.
	 *
	 * @return the veh make en of this workshop vehicle
	 */
	@Override
	public String getVehMakeEn() {
		return model.getVehMakeEn();
	}

	/**
	 * Returns the veh model ar of this workshop vehicle.
	 *
	 * @return the veh model ar of this workshop vehicle
	 */
	@Override
	public String getVehModelAr() {
		return model.getVehModelAr();
	}

	/**
	 * Returns the veh model en of this workshop vehicle.
	 *
	 * @return the veh model en of this workshop vehicle
	 */
	@Override
	public String getVehModelEn() {
		return model.getVehModelEn();
	}

	/**
	 * Returns the workshop ID of this workshop vehicle.
	 *
	 * @return the workshop ID of this workshop vehicle
	 */
	@Override
	public int getWorkshopId() {
		return model.getWorkshopId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the claim ref no of this workshop vehicle.
	 *
	 * @param claimRefNo the claim ref no of this workshop vehicle
	 */
	@Override
	public void setClaimRefNo(String claimRefNo) {
		model.setClaimRefNo(claimRefNo);
	}

	/**
	 * Sets the customer iqama ID of this workshop vehicle.
	 *
	 * @param customerIqamaId the customer iqama ID of this workshop vehicle
	 */
	@Override
	public void setCustomerIqamaId(String customerIqamaId) {
		model.setCustomerIqamaId(customerIqamaId);
	}

	/**
	 * Sets the customer mobile of this workshop vehicle.
	 *
	 * @param customerMobile the customer mobile of this workshop vehicle
	 */
	@Override
	public void setCustomerMobile(String customerMobile) {
		model.setCustomerMobile(customerMobile);
	}

	/**
	 * Sets the customer name of this workshop vehicle.
	 *
	 * @param customerName the customer name of this workshop vehicle
	 */
	@Override
	public void setCustomerName(String customerName) {
		model.setCustomerName(customerName);
	}

	/**
	 * Sets the date of this workshop vehicle.
	 *
	 * @param date the date of this workshop vehicle
	 */
	@Override
	public void setDate(Date date) {
		model.setDate(date);
	}

	/**
	 * Sets the description of this workshop vehicle.
	 *
	 * @param description the description of this workshop vehicle
	 */
	@Override
	public void setDescription(String description) {
		model.setDescription(description);
	}

	/**
	 * Sets the ID of this workshop vehicle.
	 *
	 * @param id the ID of this workshop vehicle
	 */
	@Override
	public void setId(int id) {
		model.setId(id);
	}

	/**
	 * Sets the manufacture of this workshop vehicle.
	 *
	 * @param manufacture the manufacture of this workshop vehicle
	 */
	@Override
	public void setManufacture(String manufacture) {
		model.setManufacture(manufacture);
	}

	/**
	 * Sets the plate no of this workshop vehicle.
	 *
	 * @param plateNo the plate no of this workshop vehicle
	 */
	@Override
	public void setPlateNo(String plateNo) {
		model.setPlateNo(plateNo);
	}

	/**
	 * Sets the primary key of this workshop vehicle.
	 *
	 * @param primaryKey the primary key of this workshop vehicle
	 */
	@Override
	public void setPrimaryKey(int primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the service type of this workshop vehicle.
	 *
	 * @param serviceType the service type of this workshop vehicle
	 */
	@Override
	public void setServiceType(String serviceType) {
		model.setServiceType(serviceType);
	}

	/**
	 * Sets the status of this workshop vehicle.
	 *
	 * @param status the status of this workshop vehicle
	 */
	@Override
	public void setStatus(String status) {
		model.setStatus(status);
	}

	/**
	 * Sets the veh make ar of this workshop vehicle.
	 *
	 * @param vehMakeAr the veh make ar of this workshop vehicle
	 */
	@Override
	public void setVehMakeAr(String vehMakeAr) {
		model.setVehMakeAr(vehMakeAr);
	}

	/**
	 * Sets the veh make en of this workshop vehicle.
	 *
	 * @param vehMakeEn the veh make en of this workshop vehicle
	 */
	@Override
	public void setVehMakeEn(String vehMakeEn) {
		model.setVehMakeEn(vehMakeEn);
	}

	/**
	 * Sets the veh model ar of this workshop vehicle.
	 *
	 * @param vehModelAr the veh model ar of this workshop vehicle
	 */
	@Override
	public void setVehModelAr(String vehModelAr) {
		model.setVehModelAr(vehModelAr);
	}

	/**
	 * Sets the veh model en of this workshop vehicle.
	 *
	 * @param vehModelEn the veh model en of this workshop vehicle
	 */
	@Override
	public void setVehModelEn(String vehModelEn) {
		model.setVehModelEn(vehModelEn);
	}

	/**
	 * Sets the workshop ID of this workshop vehicle.
	 *
	 * @param workshopId the workshop ID of this workshop vehicle
	 */
	@Override
	public void setWorkshopId(int workshopId) {
		model.setWorkshopId(workshopId);
	}

	@Override
	protected WorkshopVehicleWrapper wrap(WorkshopVehicle workshopVehicle) {
		return new WorkshopVehicleWrapper(workshopVehicle);
	}

}