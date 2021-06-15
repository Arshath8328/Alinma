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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;

/**
 * The extended model implementation for the PolicyVehDrv service. Represents a row in the
 * &quot;ODS_POLICY_VEH_DRV&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>com.ejada.atmc.acl.db.model.PolicyVehDrv</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PolicyVehDrvImpl extends PolicyVehDrvBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods that expect a policy veh drv model instance
	 * should use the {@link com.ejada.atmc.acl.db.model.policyVehDrv} interface instead.
	 */
	private CodeMaster nationalityDetails;

	private CodeMaster genderDetails;

	private final static String DRIVER_NATIONALITY_CODE = "NATIONALITY";

	private final static String DRIVER_GENDER_CODE = "GENDER";

	public PolicyVehDrvImpl()
	{
	}

	public String getNationalityDescEn()
	{
		try
		{
			if(nationalityDetails == null && getDriverNationality()!=null && !getDriverNationality().equals(""))
				nationalityDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(DRIVER_NATIONALITY_CODE, getDriverNationality());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (nationalityDetails != null) ? nationalityDetails.getCodeDesc() : "";
	}

	public String getNationalityDescAr()
	{
		try
		{
			if(nationalityDetails == null && getDriverNationality()!=null && !getDriverNationality().equals(""))
				nationalityDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(DRIVER_NATIONALITY_CODE, getDriverNationality());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (nationalityDetails != null) ? nationalityDetails.getCodeDescAr() : "";
	}

	public String getGenderDescEn()
	{
		try
		{
			if(genderDetails == null && getDriverGender()!=null && !getDriverGender().equals(""))
				genderDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(DRIVER_GENDER_CODE, getDriverGender());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (genderDetails != null) ? genderDetails.getCodeDesc() : "";
	}

	public String getGenderDescAr()
	{
		try
		{
			if(genderDetails == null && getDriverGender()!=null && !getDriverGender().equals(""))
				genderDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(DRIVER_GENDER_CODE, getDriverGender());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (genderDetails != null) ? genderDetails.getCodeDescAr() : "";
	}
}