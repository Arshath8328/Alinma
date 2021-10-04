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

import com.atmc.bsl.db.domain.ReturnCodes;
import com.atmc.bsl.db.domain.ServiceOutput;
import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.base.CodeMasterDetailsServiceBaseImpl;
import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the code master details remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * <code>com.atmc.bsl.db.service.CodeMasterDetailsService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsServiceBaseImpl
 */
@Component(property = { "json.web.service.context.name=dbbsl",
		"json.web.service.context.path=CodeMasterDetails" }, service = AopService.class)
public class CodeMasterDetailsServiceImpl extends CodeMasterDetailsServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.atmc.bsl.db.service.CodeMasterDetailsServiceUtil} to access the
	 * code master details remote service.
	 */

	private static final Log _log = LogFactoryUtil.getLog(CodeMasterDetailsServiceImpl.class);
	private static final String MANUFACTURER_CODE = "MOT_VEH_MAKE";
	private static final String CODE_FREEZ_YN = "N";

	public ServiceOutput<List<CodeMasterDetails>> getCustomCodes(String code) {
		ServiceOutput<List<CodeMasterDetails>> svcOutput = new ServiceOutput<List<CodeMasterDetails>>();
		try {
			List<CodeMasterDetails> codes = CodeMasterDetailsLocalServiceUtil.getCustomCodes(code);
			svcOutput.setOutputCode(ReturnCodes.SUCCESS);
			svcOutput.setOutputObject(codes);
		} catch (Exception e) {
			_log.error(e);
			svcOutput.setOutputCode(ReturnCodes.FAIL);
		}

		return svcOutput;
	}

	public ServiceOutput<List<CodeMasterDetails>> getCodeMasterList(String code, String locale) {
		ServiceOutput<List<CodeMasterDetails>> srvOutput = new ServiceOutput<List<CodeMasterDetails>>();
		try {
			List<CodeMasterDetails> codeMasterList = CodeMasterDetailsLocalServiceUtil.findCodeMasterDesc(code, locale);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(codeMasterList);
		} catch (Exception e) {
			// TODO: handle exception
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;

	}

	public ServiceOutput<List<CodeMasterDetails>> getByCodeCodeFreez(String code, String codeFreezYN)
			throws PortalException {
		ServiceOutput<List<CodeMasterDetails>> srvOutput = new ServiceOutput<List<CodeMasterDetails>>();
		try {
			List<CodeMasterDetails> codeMasterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez(code,
					codeFreezYN);
			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(codeMasterList);
		} catch (Exception e) {
			// TODO: handle exception
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}

	public ServiceOutput<List<String>> getQuickQuoteData(String locale) {

		ServiceOutput<List<String>> srvOutput = new ServiceOutput<List<String>>();
		List<CodeMasterDetails> codeMaterList;
		try {
			codeMaterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez(MANUFACTURER_CODE, CODE_FREEZ_YN);

			List<String> manufactList = new ArrayList<String>();
			Map<String, String> manufactMap = new HashMap<String, String>();
			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				if (locale.equals("en_US") || locale.equals("en")) {
					codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
					codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
					manufactList.add(codeMasterDtls.getCodeDesc());
					manufactMap.put(codeMasterDtls.getCodeDesc(), codeMasterDtls.getCodeSub());
				} else {
					codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
					codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
					manufactList.add(codeMasterDtls.getCodeDescAr());
					manufactMap.put(codeMasterDtls.getCodeDescAr(), codeMasterDtls.getCodeSub());
				}

			}

			String manufactData = GsonUtilsLocalServiceUtil.toGson(manufactList);
			String manufactJson = GsonUtilsLocalServiceUtil.toGson(manufactMap);

			List<String> dataList = new ArrayList<String>();
			dataList.add(manufactData);
			dataList.add(manufactJson);

			srvOutput.setOutputCode(ReturnCodes.SUCCESS);
			srvOutput.setOutputObject(dataList);

		} catch (NoSuchCodeMasterException e) {
			// TODO Auto-generated catch block
			srvOutput.setOutputCode(ReturnCodes.FAIL);
		}
		return srvOutput;
	}
}