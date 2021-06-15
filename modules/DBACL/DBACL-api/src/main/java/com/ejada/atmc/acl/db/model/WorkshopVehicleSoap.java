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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.WorkshopVehicleServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class WorkshopVehicleSoap implements Serializable {

	public static WorkshopVehicleSoap toSoapModel(WorkshopVehicle model) {
		WorkshopVehicleSoap soapModel = new WorkshopVehicleSoap();

		soapModel.setId(model.getId());
		soapModel.setCustomerName(model.getCustomerName());
		soapModel.setManufacture(model.getManufacture());
		soapModel.setPlateNo(model.getPlateNo());
		soapModel.setWorkshopId(model.getWorkshopId());
		soapModel.setClaimRefNo(model.getClaimRefNo());
		soapModel.setStatus(model.getStatus());
		soapModel.setDate(model.getDate());
		soapModel.setServiceType(model.getServiceType());
		soapModel.setDescription(model.getDescription());
		soapModel.setCustomerMobile(model.getCustomerMobile());
		soapModel.setVehMakeEn(model.getVehMakeEn());
		soapModel.setVehMakeAr(model.getVehMakeAr());
		soapModel.setVehModelEn(model.getVehModelEn());
		soapModel.setVehModelAr(model.getVehModelAr());
		soapModel.setCustomerIqamaId(model.getCustomerIqamaId());

		return soapModel;
	}

	public static WorkshopVehicleSoap[] toSoapModels(WorkshopVehicle[] models) {
		WorkshopVehicleSoap[] soapModels =
			new WorkshopVehicleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static WorkshopVehicleSoap[][] toSoapModels(
		WorkshopVehicle[][] models) {

		WorkshopVehicleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new WorkshopVehicleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new WorkshopVehicleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static WorkshopVehicleSoap[] toSoapModels(
		List<WorkshopVehicle> models) {

		List<WorkshopVehicleSoap> soapModels =
			new ArrayList<WorkshopVehicleSoap>(models.size());

		for (WorkshopVehicle model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new WorkshopVehicleSoap[soapModels.size()]);
	}

	public WorkshopVehicleSoap() {
	}

	public int getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(int pk) {
		setId(pk);
	}

	public int getId() {
		return _id;
	}

	public void setId(int id) {
		_id = id;
	}

	public String getCustomerName() {
		return _customerName;
	}

	public void setCustomerName(String customerName) {
		_customerName = customerName;
	}

	public String getManufacture() {
		return _manufacture;
	}

	public void setManufacture(String manufacture) {
		_manufacture = manufacture;
	}

	public String getPlateNo() {
		return _plateNo;
	}

	public void setPlateNo(String plateNo) {
		_plateNo = plateNo;
	}

	public int getWorkshopId() {
		return _workshopId;
	}

	public void setWorkshopId(int workshopId) {
		_workshopId = workshopId;
	}

	public String getClaimRefNo() {
		return _claimRefNo;
	}

	public void setClaimRefNo(String claimRefNo) {
		_claimRefNo = claimRefNo;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public Date getDate() {
		return _date;
	}

	public void setDate(Date date) {
		_date = date;
	}

	public String getServiceType() {
		return _serviceType;
	}

	public void setServiceType(String serviceType) {
		_serviceType = serviceType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getCustomerMobile() {
		return _customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		_customerMobile = customerMobile;
	}

	public String getVehMakeEn() {
		return _vehMakeEn;
	}

	public void setVehMakeEn(String vehMakeEn) {
		_vehMakeEn = vehMakeEn;
	}

	public String getVehMakeAr() {
		return _vehMakeAr;
	}

	public void setVehMakeAr(String vehMakeAr) {
		_vehMakeAr = vehMakeAr;
	}

	public String getVehModelEn() {
		return _vehModelEn;
	}

	public void setVehModelEn(String vehModelEn) {
		_vehModelEn = vehModelEn;
	}

	public String getVehModelAr() {
		return _vehModelAr;
	}

	public void setVehModelAr(String vehModelAr) {
		_vehModelAr = vehModelAr;
	}

	public String getCustomerIqamaId() {
		return _customerIqamaId;
	}

	public void setCustomerIqamaId(String customerIqamaId) {
		_customerIqamaId = customerIqamaId;
	}

	private int _id;
	private String _customerName;
	private String _manufacture;
	private String _plateNo;
	private int _workshopId;
	private String _claimRefNo;
	private String _status;
	private Date _date;
	private String _serviceType;
	private String _description;
	private String _customerMobile;
	private String _vehMakeEn;
	private String _vehMakeAr;
	private String _vehModelEn;
	private String _vehModelAr;
	private String _customerIqamaId;

}