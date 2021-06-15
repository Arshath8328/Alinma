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
import com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException;
import com.ejada.atmc.acl.db.model.CLMSTATUS;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.model.ProductDetails;
import com.ejada.atmc.acl.db.service.CLMSTATUSLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.ProductDetailsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;

/**
 * The extended model implementation for the ClaimHDR service. Represents a row in the &quot;ODS_CLAIM_HDR&quot;
 * database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>com.ejada.atmc.acl.db.model.ClaimHDR</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class ClaimHDRImpl extends ClaimHDRBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a claim hdr model instance should use the {@link com.ejada.atmc.acl.db.model.claimHDR} interface instead.
	 */
	private static final String CITY_CODE = "CITY";
	private CodeMaster lossLocation;
	private CLMSTATUS claimStatus;
	private ProductDetails prodDetails;
	
	public ClaimHDRImpl() {
	}
	
	public String getLossLocationCityEn()
	{
		try
		{
			if(lossLocation == null && getLossLocation()!=null && !getLossLocation().equals(""))
				lossLocation = CodeMasterLocalServiceUtil.findByCodeCodeSub(CITY_CODE, getLossLocation());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
			return "";
		}
		return (lossLocation!=null)?lossLocation.getCodeDesc():"";
	}

	/**
	 * @return the statusDescAr
	 */
	public String getLossLocationCityAr()
	{
		try
		{
			if(lossLocation == null && getLossLocation()!=null && !getLossLocation().equals(""))
				lossLocation = CodeMasterLocalServiceUtil.findByCodeCodeSub(CITY_CODE, getLossLocation());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
			return "";
		}
		return (lossLocation!=null)?lossLocation.getCodeDescAr():"";
	}
	
	public String getWorkflowStatus()
	{
		try
		{
			if(claimStatus == null && getClaimNo()!=null && !getClaimNo().equals(""))
				claimStatus = CLMSTATUSLocalServiceUtil.getCLMSTATUS(getClaimNo());
		}
		catch (PortalException e) {
			e.printStackTrace();
		}
		return (claimStatus!=null)?claimStatus.getClaimStatus():"";

	}
	
	public String getProductDescEn()
	{
		try
		{
			if(prodDetails == null)
				prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(getProdCode());
		}
		catch (NoSuchProductDetailsException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return (prodDetails!=null)?prodDetails.getProductName():"";
	}
	
	public String getProductDescAr()
	{
		try
		{
			if(prodDetails == null)
				prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(getProdCode());
		}
		catch (NoSuchProductDetailsException e)
		{
			e.printStackTrace();
		}
		catch (NumberFormatException e)
		{
			e.printStackTrace();
		}
		return (prodDetails!=null)?prodDetails.getProductNameAr():"";
	}
}