package com.ejada.atmc.bsl.db.domain.workshop;

import java.util.Date;

public class WorkshopList {

	private String workshopName;
	private String workshopLocation;
	private String workshopStatus;
	private Date workfrom;
	private Date workTo;
	private String locationURL;
	private String workshopPhone;
	private int workshopRating;

	public String getWorkshopName() {
		return workshopName;
	}

	public void setWorkshopName(String workshopName) {
		this.workshopName = workshopName;
	}

	public String getWorkshopLocation() {
		return workshopLocation;
	}

	public void setWorkshopLocation(String workshopLocation) {
		this.workshopLocation = workshopLocation;
	}

	public String getWorkshopStatus() {
		return workshopStatus;
	}

	public void setWorkshopStatus(String workshopStatus) {
		this.workshopStatus = workshopStatus;
	}

	public Date getWorkfrom() {
		return workfrom;
	}

	public void setWorkfrom(Date workfrom) {
		this.workfrom = workfrom;
	}

	public Date getWorkTo() {
		return workTo;
	}

	public void setWorkTo(Date workTo) {
		this.workTo = workTo;
	}

	public String getLocationURL() {
		return locationURL;
	}

	public void setLocationURL(String locationURL) {
		this.locationURL = locationURL;
	}

	public String getWorkshopPhone() {
		return workshopPhone;
	}

	public void setWorkshopPhone(String workshopPhone) {
		this.workshopPhone = workshopPhone;
	}

	public int getWorkshopRating() {
		return workshopRating;
	}

	public void setWorkshopRating(int workshopRating) {
		this.workshopRating = workshopRating;
	}

}
