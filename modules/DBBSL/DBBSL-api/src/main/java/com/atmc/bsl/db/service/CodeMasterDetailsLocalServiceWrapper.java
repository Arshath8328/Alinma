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

package com.atmc.bsl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CodeMasterDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsLocalService
 * @generated
 */
public class CodeMasterDetailsLocalServiceWrapper
	implements CodeMasterDetailsLocalService,
			   ServiceWrapper<CodeMasterDetailsLocalService> {

	public CodeMasterDetailsLocalServiceWrapper(
		CodeMasterDetailsLocalService codeMasterDetailsLocalService) {

		_codeMasterDetailsLocalService = codeMasterDetailsLocalService;
	}

	@Override
	public java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>
			findByCodeCodeFreez(String code, String codeFreezYN)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterDetailsLocalService.findByCodeCodeFreez(
			code, codeFreezYN);
	}

	@Override
	public java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>
			findCodeMasterDesc(String code, String locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterDetailsLocalService.findCodeMasterDesc(code, locale);
	}

	@Override
	public String getCodeMasterDesc(String code, String codeSub, String locale)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterDetailsLocalService.getCodeMasterDesc(
			code, codeSub, locale);
	}

	@Override
	public java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>
			getCustomCodes(String code)
		throws com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException {

		return _codeMasterDetailsLocalService.getCustomCodes(code);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _codeMasterDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public CodeMasterDetailsLocalService getWrappedService() {
		return _codeMasterDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		CodeMasterDetailsLocalService codeMasterDetailsLocalService) {

		_codeMasterDetailsLocalService = codeMasterDetailsLocalService;
	}

	private CodeMasterDetailsLocalService _codeMasterDetailsLocalService;

}