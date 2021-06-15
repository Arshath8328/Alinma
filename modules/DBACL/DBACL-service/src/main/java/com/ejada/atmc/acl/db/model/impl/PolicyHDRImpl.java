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
import com.ejada.atmc.acl.db.model.BeneficiaryDetails;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.model.FundDetails;
import com.ejada.atmc.acl.db.model.PolicyMemberDetails;
import com.ejada.atmc.acl.db.model.PolicyPayment;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.ProductDetails;
import com.ejada.atmc.acl.db.service.BeneficiaryDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.FundDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyMemberDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyPaymentLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehCvrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.ProductDetailsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;

import java.util.List;

/**
 * The extended model implementation for the PolicyHDR service. Represents a row in the &quot;ODS_POLICY_HDR&quot;
 * database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>com.ejada.atmc.acl.db.model.PolicyHDR</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class PolicyHDRImpl extends PolicyHDRBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a policy hdr model instance should use the {@link com.ejada.atmc.acl.db.model.policyHDR} interface instead.
	 */
	private static final String POLICY_STATUS_CODE = "POL_STS";
	private static final String POLICY_MODE_OF_PMNT_CODE = "MODE_OF_PAY";
	private CodeMaster statusDetails;
	private ProductDetails prodDetails;
	private CodeMaster modeOfPmntDetails;
	
	public PolicyHDRImpl() {
	}
	
	public List<PolicyVEH> getPolicyVEHs() throws PortalException, SystemException{
		return PolicyVEHLocalServiceUtil.findByPolicyNumber(getPolicyNo());
	}
	
	public List<PolicyPayment> getPolicyPayments() throws PortalException, SystemException{
		return PolicyPaymentLocalServiceUtil.findByPolicyNo(getPolicyNo());
	}
	
	
	public List<PolicyMemberDetails> getPolicyMembers() throws PortalException, SystemException{
		return PolicyMemberDetailsLocalServiceUtil.findByPolicyNo(getPolicyNo());
	}
	
	public List<PolicyVehCvr> getPolicyRiders() throws PortalException, SystemException{
		return PolicyVehCvrLocalServiceUtil.findByPolicyNumber(getPolicyNo());
	}
	
	public List<FundDetails> getPolicyFunds() throws PortalException, SystemException{
		return FundDetailsLocalServiceUtil.findByPolicyNumber(getPolicyNo());
	}
	
	public List<BeneficiaryDetails> getPolicyBenfs() throws PortalException, SystemException{
		return BeneficiaryDetailsLocalServiceUtil.findByPolicyNumber(getPolicyNo());
	}
	
	public String getProductDescEn()
	{
		try
		{
			if(prodDetails == null)
				prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(getProduct());
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
				prodDetails = ProductDetailsLocalServiceUtil.findByProductCode(getProduct());
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
	
	public String getStatusDescEn()
	{
		try
		{
			if(statusDetails == null && getPolicyStatus()!=null && !getPolicyStatus().equals(""))
				statusDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_STATUS_CODE, getPolicyStatus());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (statusDetails!=null)?statusDetails.getCodeDesc():"";
	}

	/**
	 * @return the statusDescAr
	 */
	public String getStatusDescAr()
	{
		try
		{
			if(statusDetails == null && getPolicyStatus()!=null && !getPolicyStatus().equals(""))
				statusDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_STATUS_CODE, getPolicyStatus());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (statusDetails!=null)?statusDetails.getCodeDescAr():"";
	}
	
	public String getModeOfPmntDescEn()
	{
		try
		{
			if(modeOfPmntDetails == null && getModeOfPayment()!=null && !getModeOfPayment().equals(""))
				modeOfPmntDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_MODE_OF_PMNT_CODE, getModeOfPayment());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (modeOfPmntDetails!=null)?modeOfPmntDetails.getCodeDesc():"";
	}

	public String getModeOfPmntDescAr()
	{
		try
		{
			if(modeOfPmntDetails == null && getModeOfPayment()!=null && !getModeOfPayment().equals(""))
				modeOfPmntDetails = CodeMasterLocalServiceUtil.findByCodeCodeSub(POLICY_MODE_OF_PMNT_CODE, getModeOfPayment());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (modeOfPmntDetails!=null)?modeOfPmntDetails.getCodeDescAr():"";
	}
}