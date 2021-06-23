package com.atmc.bsl.db.domain.workshop;

import java.util.Date;

public class WorkshopVehicles {

	private int id;
	private String customerName;
	private String manufacture;
	private String plateNo;
	private int workshopId;
	private String claimRefNo;
	private String status;
	private Date date;
	private String serviceType;
	private String description;
	private String customerMobile;
	private String vehMakeEn;
	private String vehMakeAr;
	private String vehModeleEn;
	private String vehModelAr;
	private String customerIqamaId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getManufacture() {
		return manufacture;
	}

	public void setManufacture(String manufacture) {
		this.manufacture = manufacture;
	}

	public String getPlateNo() {
		return plateNo;
	}

	public void setPlateNo(String plateNo) {
		this.plateNo = plateNo;
	}

	public int getWorkshopId() {
		return workshopId;
	}

	public void setWorkshopId(int workshopId) {
		this.workshopId = workshopId;
	}

	public String getClaimRefNo() {
		return claimRefNo;
	}

	public void setClaimRefNo(String claimRefNo) {
		this.claimRefNo = claimRefNo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getServiceType() {
		return serviceType;
	}

	public void setServiceType(String serviceType) {
		this.serviceType = serviceType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getVehMakeEn() {
		return vehMakeEn;
	}

	public void setVehMakeEn(String vehMakeEn) {
		this.vehMakeEn = vehMakeEn;
	}

	public String getVehMakeAr() {
		return vehMakeAr;
	}

	public void setVehMakeAr(String vehMakeAr) {
		this.vehMakeAr = vehMakeAr;
	}

	public String getVehModeleEn() {
		return vehModeleEn;
	}

	public void setVehModeleEn(String vehModeleEn) {
		this.vehModeleEn = vehModeleEn;
	}

	public String getVehModelAr() {
		return vehModelAr;
	}

	public void setVehModelAr(String vehModelAr) {
		this.vehModelAr = vehModelAr;
	}

	public String getCustomerIqamaId() {
		return customerIqamaId;
	}

	public void setCustomerIqamaId(String customerIqamaId) {
		this.customerIqamaId = customerIqamaId;
	}

}
