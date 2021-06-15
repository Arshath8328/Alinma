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
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehCvrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehDrvLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

import aQute.bnd.annotation.ProviderType;

/**
 * The extended model implementation for the PolicyVEH service. Represents a row in the &quot;ODS_POLICY_VEH&quot;
 * database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>com.ejada.atmc.acl.db.model.PolicyVEH</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PolicyVEHImpl extends PolicyVEHBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS: Never reference this class directly. All methods that expect a policy veh model instance
	 * should use the {@link com.ejada.atmc.acl.db.model.policyVEH} interface instead.
	 */
	private CodeMaster makeDetails;

	private CodeMaster modelDetails;

	private CodeMaster bodyTypeDetails;

	private CodeMaster colorDetails;

	private CodeMaster useOfVehicleDetails;

	private CodeMaster najmPlateTypeDetails;
	
	private CodeMaster vehDefTypeDetails;

	private final static String VEHICLE_MAKE_CODE = "MOT_VEH_MAKE";

	private final static String VEHICLE_MODEL_CODE = "MOT_VEH_MOD";

	private final static String VEHICLE_BODY_TYPE_CODE = "MOT_BODY_TYP";

	private final static String VEHICLE_COLOR_CODE = "COLOR";

	private final static String VEHICLE_USE_OF_VEHICLE_CODE = "MOT_VEHI_USE";

	private final static String VEHICLE_NAJM_PLATE_TYPE_CODE = "VEH_TYPE";
	
	private final static String VEHICLE_DEF_TYPE_CODE = "VEH_DFN_TYPE";
	
	private final static String CODE_FREEZ_YN = "N";

	public PolicyVEHImpl()
	{
	}

	public List<PolicyVehDrv> getVehDrivs() throws PortalException, SystemException
	{
		return PolicyVehDrvLocalServiceUtil.findByPolicyNumberVehicleId(getPolicyNo(), Long.valueOf(getVehId()));
	}

	public List<PolicyVehCvr> getVehCvrs() throws PortalException, SystemException
	{
		return PolicyVehCvrLocalServiceUtil.findByPolicyNumberVehicleId(getPolicyNo(), Long.valueOf(getVehId()));
	}

	public List<PolicyVEH> getPolicyVEHs() throws PortalException, SystemException
	{
		return PolicyVEHLocalServiceUtil.findByPolicyNumber(getPolicyNo());
	}

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescEn()
	{
		try
		{
			if(makeDetails == null && getMake()!=null && !getMake().equals(""))
				makeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MAKE_CODE, getMake());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (makeDetails!=null)?makeDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescAr()
	{
		try
		{
			if(makeDetails == null && getMake()!=null && !getMake().equals(""))
				makeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MAKE_CODE, getMake());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (makeDetails!=null)?makeDetails.getCodeDescAr():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getModelDescEn()
	{
		try
		{
			if(modelDetails == null && getVehModel()!=null && !getVehModel().equals("") && getMake()!=null && !getMake().equals(""))
				modelDetails = CodeMasterLocalServiceUtil.findByCodeCodeSubCodeSubRef(VEHICLE_MODEL_CODE, getVehModel(), getMake(),CODE_FREEZ_YN);
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (modelDetails!=null)?modelDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getModelDescAr()
	{
		try
		{
			if(modelDetails == null && getVehModel()!=null && !getVehModel().equals("") && getMake()!=null && !getMake().equals(""))
				modelDetails = CodeMasterLocalServiceUtil.findByCodeCodeSubCodeSubRef(VEHICLE_MODEL_CODE, getVehModel(), getMake(),CODE_FREEZ_YN);
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		
		return (modelDetails!=null)?modelDetails.getCodeDescAr():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeDescEn()
	{
		try
		{
			if(bodyTypeDetails == null && getBodyType()!=null && !getBodyType().equals(""))
				bodyTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_BODY_TYPE_CODE, getBodyType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (bodyTypeDetails!=null)?bodyTypeDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeDescAr()
	{
		try
		{
			if(bodyTypeDetails == null && getBodyType()!=null && !getBodyType().equals(""))
				bodyTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_BODY_TYPE_CODE, getBodyType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (bodyTypeDetails!=null)?bodyTypeDetails.getCodeDescAr():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescEn()
	{
		try
		{
			if(colorDetails == null && getColor()!=null && !getColor().equals(""))
				colorDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_COLOR_CODE, getColor());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (colorDetails!=null)?colorDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescAr()
	{
		try
		{
			if(colorDetails == null && getColor()!=null && !getColor().equals(""))
				colorDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_COLOR_CODE, getColor());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (colorDetails!=null)?colorDetails.getCodeDescAr():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getUseOfVehicleDescEn()
	{
		try
		{
			if(useOfVehicleDetails == null && getUseOfCehicle()!=null && !getUseOfCehicle().equals(""))
				useOfVehicleDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_USE_OF_VEHICLE_CODE, getUseOfCehicle());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (useOfVehicleDetails!=null)?useOfVehicleDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getUseOfVehicleDescAr()
	{
		try
		{
			if(useOfVehicleDetails == null && getUseOfCehicle()!=null && !getUseOfCehicle().equals(""))
				useOfVehicleDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_USE_OF_VEHICLE_CODE, getUseOfCehicle());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (useOfVehicleDetails!=null)?useOfVehicleDetails.getCodeDescAr():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getNajmPlateTypeDescEn()
	{
		try
		{
			if(najmPlateTypeDetails == null && getNajmPlateType()!=null && !getNajmPlateType().equals(""))
				najmPlateTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_NAJM_PLATE_TYPE_CODE, getNajmPlateType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (najmPlateTypeDetails!=null)?najmPlateTypeDetails.getCodeDesc():"";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getNajmPlateTypeDescAr()
	{
		try
		{
			if(najmPlateTypeDetails == null && getNajmPlateType()!=null && !getNajmPlateType().equals(""))
				najmPlateTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_NAJM_PLATE_TYPE_CODE, getNajmPlateType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (najmPlateTypeDetails!=null)?najmPlateTypeDetails.getCodeDescAr():"";
	}
	
	public String getVehicleDefTypeDescEn()
	{
		try
		{
			if(vehDefTypeDetails == null && getVehicleDefType()!=null && !getVehicleDefType().equals(""))
				vehDefTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_DEF_TYPE_CODE, getVehicleDefType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (vehDefTypeDetails!=null)?vehDefTypeDetails.getCodeDesc():"";
	}
	
	public String getVehicleDefTypeDescAr()
	{
		try
		{
			if(vehDefTypeDetails == null && getVehicleDefType()!=null && !getVehicleDefType().equals(""))
				vehDefTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_DEF_TYPE_CODE, getVehicleDefType());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (vehDefTypeDetails!=null)?vehDefTypeDetails.getCodeDescAr():"";
	}
}