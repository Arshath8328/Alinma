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

package com.atmc.bsl.db.service.impl;

import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.service.base.CodeMasterDetailsLocalServiceBaseImpl;
import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import org.osgi.service.component.annotations.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * The implementation of the code master details local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the <code>com.atmc.bsl.db.service.CodeMasterDetailsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsLocalServiceBaseImpl
 */
@Component(
	property = "model.class.name=com.atmc.bsl.db.model.CodeMasterDetails",
	service = AopService.class
)
public class CodeMasterDetailsLocalServiceImpl
	extends CodeMasterDetailsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil} to access the code master details local service.
	 */

	public List<CodeMasterDetails> findCodeMasterDesc(String code, String locale) throws PortalException
	{
		List<CodeMaster> codeListOriginal = CodeMasterLocalServiceUtil.findCodeMasterByCode(code, locale);
		List<CodeMasterDetails> codeList = getCustomCodes(codeListOriginal);

		return codeList;
	}

	public String getCodeMasterDesc(String code, String codeSub, String locale) throws PortalException
	{
		CodeMaster originalDets = CodeMasterLocalServiceUtil.findByCodeCodeSub(code, codeSub);
		if(locale.equals("en_US")||locale.equals("en"))
			return originalDets.getCodeDesc();
		else
			return originalDets.getCodeDescAr();

	}

	public List<CodeMasterDetails> getCustomCodes(String code) throws NoSuchCodeMasterException
	{
		List<CodeMaster> codeListOriginal = CodeMasterLocalServiceUtil.findByCode(code);
		List<CodeMasterDetails> codeList = getCustomCodes(codeListOriginal);

		_log.info("Query by Code = "+code);

		return codeList;
	}

	public List<CodeMasterDetails> findByCodeCodeFreez(String code,String codeFreezYN) throws NoSuchCodeMasterException
	{
		List<CodeMaster> codeListOriginal = CodeMasterLocalServiceUtil.findByCodeCodeFreez(code, codeFreezYN);
		List<CodeMasterDetails> codeList = getCustomCodes(codeListOriginal);

		_log.info("Query by Code = "+code);
		_log.info("Query by Code_Freez = "+codeFreezYN);

		return codeList;
	}

	private List<CodeMasterDetails> getCustomCodes(List<CodeMaster> codesList)
	{
		List<CodeMasterDetails> codeMasterList = new ArrayList<>();

		if(codesList != null && !codesList.isEmpty())
		{
			for(CodeMaster codeMasterObj : codesList)
			{
				CodeMasterDetails codeMasterDetails = new CodeMasterDetails();
				codeMasterDetails.setCode(codeMasterObj.getCode());
				codeMasterDetails.setCodeSub(codeMasterObj.getCodeSub());
				codeMasterDetails.setCodeDesc(codeMasterObj.getCodeDesc());
				codeMasterDetails.setCodeDescAr(codeMasterObj.getCodeDescAr());
/*				codeMasterDetails.setCodeSubRef(codeMasterObj.getCodeSubRef());
				codeMasterDetails.setCodeRef(codeMasterObj.getCodeRef());
				codeMasterDetails.setCodeValue0(codeMasterObj.getCodeValue0());
				codeMasterDetails.setCodeValue1(codeMasterObj.getCodeValue1());
				codeMasterDetails.setCodeValue2(codeMasterObj.getCodeValue2());
				codeMasterDetails.setCreationDate(codeMasterDetails.getCreationDate());
				codeMasterDetails.setCrUid(codeMasterDetails.getCrUid());
				codeMasterDetails.setEffFromDate(codeMasterObj.getEffFromDate());
				codeMasterDetails.setEffToDate(codeMasterObj.getEffToDate());
				codeMasterDetails.setSystemId(codeMasterObj.getSystemId());
				codeMasterDetails.setUpdateDate(codeMasterObj.getUpdateDate());
				codeMasterDetails.setUpdateUid(codeMasterObj.getUpdateUid());
*/
				codeMasterList.add(codeMasterDetails);
			}
		}
		return codeMasterList;
	}

	private static final Log _log = LogFactoryUtil.getLog(CodeMasterDetailsLocalServiceImpl.class);

}