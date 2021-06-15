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
 * The extended model implementation for the BeneficiaryDetails service. Represents a row in the
 * &quot;ODS_BENF_DETAILS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun
 * ServiceBuilder to copy their definitions into the <code>com.ejada.atmc.acl.db.model.BeneficiaryDetails</code>
 * interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class BeneficiaryDetailsImpl extends BeneficiaryDetailsBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a beneficiary details model instance should use the {@link com.ejada.atmc.acl.db.model.BeneficiaryDetails} interface instead.
	 */
	private static final String BENEFICIARY_RELATIONSHIP_CODE = "RELATION";
	private CodeMaster benfRelDets;

	public BeneficiaryDetailsImpl() {
	}
	
	public String getBenfRelDescEn()
	{
		try
		{
			if(benfRelDets == null && getBenfRel()!=null && !getBenfRel().equals(""))
				benfRelDets = CodeMasterLocalServiceUtil.findByCodeCodeSub(BENEFICIARY_RELATIONSHIP_CODE, getBenfRel());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (benfRelDets!=null)?benfRelDets.getCodeDesc():"";
	}

	public String getBenfRelDescAr()
	{
		try
		{
			if(benfRelDets == null && getBenfRel()!=null && !getBenfRel().equals(""))
				benfRelDets = CodeMasterLocalServiceUtil.findByCodeCodeSub(BENEFICIARY_RELATIONSHIP_CODE, getBenfRel());
		}
		catch (NoSuchCodeMasterException e)
		{
			e.printStackTrace();
		}
		return (benfRelDets!=null)?benfRelDets.getCodeDescAr():"";
	}

}