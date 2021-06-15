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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.service.base.CodeMasterMapLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the code master map local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.CodeMasterMapLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    CodeMasterMapLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.CodeMasterMap",
		service = AopService.class
)
public class CodeMasterMapLocalServiceImpl extends CodeMasterMapLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil}
	 * to access the code master map local service.
	 */
	public CodeMasterMap findBySourceTypeSourceCode(String sourceType, String sourceCode) {
		_log.info("findBySourceTypeSourceCode  sourceType >>>>>> " + sourceType);
		_log.info("findBySourceTypeSourceCode  sourceCode >>>>>> " + sourceCode);
		CodeMasterMap map = null;
		try {
			map = this.codeMasterMapPersistence.findBySourceTypeSourceCode(sourceType, sourceCode);
			_log.info("findBySourceTypeSourceCode map  >>>>>>> " + map.getCoreCode());
			_log.info("findBySourceTypeSourceCode map  >>>>>>> " + map.toString());
			_log.info("findBySourceTypeSourceCode map  >>>>>>> " + map.toXmlString());
		} catch (NoSuchCodeMasterMapException e) {
			_log.error("Failed to get CodeMasterMap data by sourceType= " + sourceType + " & sourceCode= " + sourceCode, e);
		}
		return map;
	}

	public CodeMasterMap findBySourceTypeSourceCodeLevel1Code(String sourceType, String sourceCode, String lvl1Code) {
		CodeMasterMap map = null;
		try {
			map = this.codeMasterMapPersistence.findBySourceTypeSourceCodeLvl1Code(sourceType, sourceCode, lvl1Code);
		} catch (NoSuchCodeMasterMapException e) {
			_log.error("Failed to get CodeMasterMap data by sourceType= " + sourceType + " & sourceCode= " + sourceCode + " & lvl1Code = " + lvl1Code,
					e);
		}
		return map;
	}

	public CodeMasterMap findBySourceTypeCoreCode(String sourceType, String coreCode) {
		CodeMasterMap map = null;
		try {
			map = this.codeMasterMapPersistence.findBySourceTypeCoreCode(sourceType, coreCode);
		} catch (NoSuchCodeMasterMapException e) {
			_log.error("Failed to get CodeMasterMap data by sourceType= " + sourceType + " & coreCode= " + coreCode, e);
		}
		return map;
	}

	private static final Log _log = LogFactoryUtil.getLog(CodeMasterMapLocalServiceImpl.class);

}