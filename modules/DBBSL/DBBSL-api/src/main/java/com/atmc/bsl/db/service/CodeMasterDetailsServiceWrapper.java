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
 * Provides a wrapper for {@link CodeMasterDetailsService}.
 *
 * @author Brian Wing Shun Chan
 * @see CodeMasterDetailsService
 * @generated
 */
public class CodeMasterDetailsServiceWrapper
	implements CodeMasterDetailsService,
			   ServiceWrapper<CodeMasterDetailsService> {

	public CodeMasterDetailsServiceWrapper(
		CodeMasterDetailsService codeMasterDetailsService) {

		_codeMasterDetailsService = codeMasterDetailsService;
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getByCodeCodeFreez(String code, String codeFreezYN)
			throws com.liferay.portal.kernel.exception.PortalException {

		return _codeMasterDetailsService.getByCodeCodeFreez(code, codeFreezYN);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getCodeMasterList(String code, String locale) {

		return _codeMasterDetailsService.getCodeMasterList(code, locale);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
			getCustomCodes(String code) {

		return _codeMasterDetailsService.getCustomCodes(code);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _codeMasterDetailsService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.ServiceOutput<java.util.List<String>>
		getQuickQuoteData(String locale) {

		return _codeMasterDetailsService.getQuickQuoteData(locale);
	}

	@Override
	public CodeMasterDetailsService getWrappedService() {
		return _codeMasterDetailsService;
	}

	@Override
	public void setWrappedService(
		CodeMasterDetailsService codeMasterDetailsService) {

		_codeMasterDetailsService = codeMasterDetailsService;
	}

	private CodeMasterDetailsService _codeMasterDetailsService;

}