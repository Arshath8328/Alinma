/*
 * CustomizedParameter.java Apr 18, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.rest.tameeniapi.domain;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 *
 */
@XmlRootElement
public class VehicleImage
{
	private long imageID;
	
	private int imageTitle;

	private String imageMedia;

	private String imageDateTime;

	private double imageLong;
	
	private double imageLat;

	@XmlElement(name = "ImageID")
	public long getImageID() {
		return imageID;
	}

	public void setImageID(long imageID) {
		this.imageID = imageID;
	}

	@XmlElement(name = "ImageTitle")
	public int getImageTitle() {
		return imageTitle;
	}

	public void setImageTitle(int imageTitle) {
		this.imageTitle = imageTitle;
	}

	@XmlElement(name = "ImageMedia")
	public String getImageMedia() {
		return imageMedia;
	}

	public void setImageMedia(String imageMedia) {
		this.imageMedia = imageMedia;
	}

	@XmlElement(name = "ImageDateTime")
	public String getImageDateTime() {
		return imageDateTime;
	}

	public void setImageDateTime(String imageDateTime) {
		this.imageDateTime = imageDateTime;
	}

	@XmlElement(name = "ImageLong")
	public double getImageLong() {
		return imageLong;
	}

	public void setImageLong(double imageLong) {
		this.imageLong = imageLong;
	}

	@XmlElement(name = "ImageLat")
	public double getImageLat() {
		return imageLat;
	}

	public void setImageLat(double imageLat) {
		this.imageLat = imageLat;
	}

}
