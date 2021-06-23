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
import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.model.QuotationCovers;
import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationCoversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationDriversLocalServiceUtil;

import java.util.List;

/**
 * The extended model implementation for the Quotations service. Represents a
 * row in the &quot;EJD_QUOTATIONS&quot; database table, with each column mapped
 * to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.ejada.atmc.acl.db.model.Quotations</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class QuotationsImpl extends QuotationsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a quotations
	 * model instance should use the {@link com.ejada.atmc.acl.db.model.Quotations}
	 * interface instead.
	 */
	private CodeMaster makeDetails;
	private CodeMaster modelDetails;
	private CodeMaster colorDetails;
	private CodeMaster bodyTypeDetails;
	private CodeMaster purposeVehicleDetails;
	private CodeMaster najmPlateTypeDetails;
	private final static String VEHICLE_MAKE_CODE = "MOT_VEH_MAKE";
	private final static String VEHICLE_COLOR_CODE = "COLOR";
	private final static String VEHICLE_MODEL_CODE = "MOT_VEH_MOD";
	private final static String VEHICLE_BODY_TYPE_CODE = "MOT_BODY_TYP";
	private final static String PURPOSE_OF_VEHICLE_CODE = "MOT_VEHI_USE";
	private final static String VEHICLE_NAJM_PLATE_TYPE_CODE = "VEH_TYPE";

	public QuotationsImpl() {
	}

	public List<QuotationCovers> getQuotationCovers() {
		return QuotationCoversLocalServiceUtil.findByQuotationId(getQuotationId());
	}

	public QuotationDrivers getQuotationDriver() {
		try {
			return QuotationDriversLocalServiceUtil.findByAddDriverIdQuotationId(getQuotationId(),
					Long.valueOf(getAddDriver()));
		} catch (NoSuchQuotationDriversException | NumberFormatException e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescEn() {
		try {
			if (makeDetails == null && getVehicleMake() != null && !getVehicleMake().equals(""))
				makeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MAKE_CODE, getVehicleMake());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (makeDetails != null) ? makeDetails.getCodeDesc() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescAr() {
		try {
			if (makeDetails == null && getVehicleMake() != null && !getVehicleMake().equals(""))
				makeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MAKE_CODE, getVehicleMake());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (makeDetails != null) ? makeDetails.getCodeDescAr() : "";
	}

	public String getModelEn() {
		try {
			if (modelDetails == null && getVehicleModel() != null && !getVehicleModel().equals(""))
				modelDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MODEL_CODE, getVehicleModel());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (modelDetails != null) ? modelDetails.getCodeDesc() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getModelAr() {
		try {
			if (modelDetails == null && getVehicleModel() != null && !getVehicleModel().equals(""))
				modelDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_MODEL_CODE, getVehicleModel());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (modelDetails != null) ? modelDetails.getCodeDescAr() : "";
	}

	public String getBodyTypeEn() {
		try {
			if (bodyTypeDetails == null && getVehicleBodyType() != null && !getVehicleBodyType().equals(""))
				bodyTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_BODY_TYPE_CODE,
						getVehicleBodyType());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (bodyTypeDetails != null) ? bodyTypeDetails.getCodeDesc() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeAr() {
		try {
			if (bodyTypeDetails == null && getVehicleBodyType() != null && !getVehicleBodyType().equals(""))
				bodyTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_BODY_TYPE_CODE,
						getVehicleBodyType());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (bodyTypeDetails != null) ? bodyTypeDetails.getCodeDescAr() : "";
	}

	public String getPurposeVehicleDesc() {
		try {
			if (purposeVehicleDetails == null && getPurposeOfVehicle() != null && !getPurposeOfVehicle().equals(""))
				purposeVehicleDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(PURPOSE_OF_VEHICLE_CODE,
						getPurposeOfVehicle());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (purposeVehicleDetails != null) ? purposeVehicleDetails.getCodeDesc() : "";
	}

	public String getPurposeVehicleDescAr() {
		try {
			if (purposeVehicleDetails == null && getPurposeOfVehicle() != null && !getPurposeOfVehicle().equals(""))
				purposeVehicleDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(PURPOSE_OF_VEHICLE_CODE,
						getPurposeOfVehicle());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (purposeVehicleDetails != null) ? purposeVehicleDetails.getCodeDescAr() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescEn() {
		try {
			if (colorDetails == null && getVehicleColor() != null && !getVehicleColor().equals(""))
				colorDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_COLOR_CODE, getVehicleColor());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (colorDetails != null) ? colorDetails.getCodeDesc() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescAr() {
		try {
			if (colorDetails == null && getVehicleColor() != null && !getVehicleColor().equals(""))
				colorDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_COLOR_CODE, getVehicleColor());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (colorDetails != null) ? colorDetails.getCodeDescAr() : "";
	}

	public String getVehiclePlateTypeDescEn() {
		try {
			if (najmPlateTypeDetails == null && getVehiclePlateType() != null && !getVehiclePlateType().equals(""))
				najmPlateTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_NAJM_PLATE_TYPE_CODE,
						getVehiclePlateType());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (najmPlateTypeDetails != null) ? najmPlateTypeDetails.getCodeDesc() : "";
	}

	/**
	 * @return String
	 * @see
	 */
	public String getVehiclePlateTypeDescAr() {
		try {
			if (najmPlateTypeDetails == null && getVehiclePlateType() != null && !getVehiclePlateType().equals(""))
				najmPlateTypeDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(VEHICLE_NAJM_PLATE_TYPE_CODE,
						getVehiclePlateType());
		} catch (NoSuchCodeMasterException e) {
			e.printStackTrace();
		}
		return (najmPlateTypeDetails != null) ? najmPlateTypeDetails.getCodeDescAr() : "";
	}
}