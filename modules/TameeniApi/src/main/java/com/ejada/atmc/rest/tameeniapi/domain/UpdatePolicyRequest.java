/*
 * UpdatePolicyRequest.java Apr 18, 2018  
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

/**
 * @author Ghada Shawkat
 *
 */
public class UpdatePolicyRequest
{
	private long requestReferenceNo;
	
	private int insuranceCompanyCode;
	
	private long responseReferenceNo;
	
	private int insuranceTypeID;
	
	private String mobileNo;
	
	private int vehiclePlateTypeID;
	
	private int vehiclePlateNumber;
	
	private int firstPlateLetterID;
	
	private int secondPlateLetterID;
	
	private int thirdPlateLetterID;
	
	private boolean passedPhysicalInspection;
	
	private int physicalInspectionRejectionID;
	
	private List<CustomizedParameter> customizedParameterList;

	/**
	 * @return the requestReferenceNo
	 */
	@XmlElement(name = "RequestReferenceNo")
	public long getRequestReferenceNo()
	{
		return requestReferenceNo;
	}

	/**
	 * @param requestReferenceNo the requestReferenceNo to set
	 */
	public void setRequestReferenceNo(long requestReferenceNo)
	{
		this.requestReferenceNo = requestReferenceNo;
	}

	/**
	 * @return the insuranceCompanyCode
	 */
	@XmlElement(name = "InsuranceCompanyCode")
	public int getInsuranceCompanyCode()
	{
		return insuranceCompanyCode;
	}

	/**
	 * @param insuranceCompanyCode the insuranceCompanyCode to set
	 */
	public void setInsuranceCompanyCode(int insuranceCompanyCode)
	{
		this.insuranceCompanyCode = insuranceCompanyCode;
	}

	/**
	 * @return the responseReferenceNo
	 */
	@XmlElement(name = "ResponseReferenceNo")
	public long getResponseReferenceNo()
	{
		return responseReferenceNo;
	}

	/**
	 * @param responseReferenceNo the responseReferenceNo to set
	 */
	public void setResponseReferenceNo(long responseReferenceNo)
	{
		this.responseReferenceNo = responseReferenceNo;
	}

	/**
	 * @return the insuranceTypeID
	 */
	@XmlElement(name = "InsuranceTypeID")
	public int getInsuranceTypeID()
	{
		return insuranceTypeID;
	}

	/**
	 * @param insuranceTypeID the insuranceTypeID to set
	 */
	public void setInsuranceTypeID(int insuranceTypeID)
	{
		this.insuranceTypeID = insuranceTypeID;
	}

	/**
	 * @return the mobileNo
	 */
	@XmlElement(name = "MobileNo")
	public String getMobileNo()
	{
		return mobileNo;
	}

	/**
	 * @param mobileNo the mobileNo to set
	 */
	public void setMobileNo(String mobileNo)
	{
		this.mobileNo = mobileNo;
	}

	/**
	 * @return the vehiclePlateTypeID
	 */
	@XmlElement(name = "VehiclePlateTypeID")
	public int getVehiclePlateTypeID()
	{
		return vehiclePlateTypeID;
	}

	/**
	 * @param vehiclePlateTypeID the vehiclePlateTypeID to set
	 */
	public void setVehiclePlateTypeID(int vehiclePlateTypeID)
	{
		this.vehiclePlateTypeID = vehiclePlateTypeID;
	}

	/**
	 * @return the vehiclePlateNumber
	 */
	@XmlElement(name = "VehiclePlateNumber")
	public int getVehiclePlateNumber()
	{
		return vehiclePlateNumber;
	}

	/**
	 * @param vehiclePlateNumber the vehiclePlateNumber to set
	 */
	public void setVehiclePlateNumber(int vehiclePlateNumber)
	{
		this.vehiclePlateNumber = vehiclePlateNumber;
	}

	/**
	 * @return the firstPlateLetterID
	 */
	@XmlElement(name = "FirstPlateLetterID")
	public int getFirstPlateLetterID()
	{
		return firstPlateLetterID;
	}

	/**
	 * @param firstPlateLetterID the firstPlateLetterID to set
	 */
	public void setFirstPlateLetterID(int firstPlateLetterID)
	{
		this.firstPlateLetterID = firstPlateLetterID;
	}

	/**
	 * @return the secondPlateLetterID
	 */
	@XmlElement(name = "SecondPlateLetterID")
	public int getSecondPlateLetterID()
	{
		return secondPlateLetterID;
	}

	/**
	 * @param secondPlateLetterID the secondPlateLetterID to set
	 */
	public void setSecondPlateLetterID(int secondPlateLetterID)
	{
		this.secondPlateLetterID = secondPlateLetterID;
	}

	/**
	 * @return the thirdPlateLetterID
	 */
	@XmlElement(name = "ThirdPlateLetterID")
	public int getThirdPlateLetterID()
	{
		return thirdPlateLetterID;
	}

	/**
	 * @param thirdPlateLetterID the thirdPlateLetterID to set
	 */
	public void setThirdPlateLetterID(int thirdPlateLetterID)
	{
		this.thirdPlateLetterID = thirdPlateLetterID;
	}

	/**
	 * @return the passedPhysicalInspection
	 */
	@XmlElement(name = "PassedPhysicalInspection")
	public boolean isPassedPhysicalInspection()
	{
		return passedPhysicalInspection;
	}

	/**
	 * @param passedPhysicalInspection the passedPhysicalInspection to set
	 */
	public void setPassedPhysicalInspection(boolean passedPhysicalInspection)
	{
		this.passedPhysicalInspection = passedPhysicalInspection;
	}

	/**
	 * @return the physicalInspectionRejectionID
	 */
	@XmlElement(name = "PhysicalInspectionRejectionID")
	public int getPhysicalInspectionRejectionID()
	{
		return physicalInspectionRejectionID;
	}

	/**
	 * @param physicalInspectionRejectionID the physicalInspectionRejectionID to set
	 */
	public void setPhysicalInspectionRejectionID(int physicalInspectionRejectionID)
	{
		this.physicalInspectionRejectionID = physicalInspectionRejectionID;
	}

	/**
	 * @return the customizedParameterList
	 */
	@XmlElement(name = "CustomizedParameter")
	public List<CustomizedParameter> getCustomizedParameterList()
	{
		return customizedParameterList;
	}

	/**
	 * @param customizedParameterList the customizedParameterList to set
	 */
	public void setCustomizedParameterList(List<CustomizedParameter> customizedParameterList)
	{
		this.customizedParameterList = customizedParameterList;
	}

}
