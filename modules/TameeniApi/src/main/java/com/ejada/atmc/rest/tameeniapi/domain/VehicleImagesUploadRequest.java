/*
 * VehicleIdUpdateRequest.java Apr 18, 2018  
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

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Kareem Kahil
 */

@XmlRootElement
public class VehicleImagesUploadRequest
{
	private long policyRequestReferenceNo;

	private long policyReferenceNo;

	private List<VehicleImage> vehicleImagesList;
	
	private List<CustomizedParameter> customizedParameterList;

	@XmlElement(name = "PolicyRequestReferenceNo")
	public long getPolicyRequestReferenceNo() {
		return policyRequestReferenceNo;
	}

	public void setPolicyRequestReferenceNo(long policyRequestReferenceNo) {
		this.policyRequestReferenceNo = policyRequestReferenceNo;
	}

	@XmlElement(name = "PolicyReferenceNo")
	public long getPolicyReferenceNo() {
		return policyReferenceNo;
	}

	public void setPolicyReferenceNo(long policyReferenceNo) {
		this.policyReferenceNo = policyReferenceNo;
	}

	@XmlElement(name = "VehicleImages")
	public List<VehicleImage> getVehicleImagesList() {
		return vehicleImagesList;
	}

	public void setVehicleImagesList(List<VehicleImage> vehicleImagesList) {
		this.vehicleImagesList = vehicleImagesList;
	}

	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList() {
		return customizedParameterList;
	}

	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList) {
		this.customizedParameterList = customizedParameterList;
	}

}
