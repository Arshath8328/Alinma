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

package com.ejada.atmc.acl.db.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link LNP2_PolicyMastrService}.
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrService
 * @generated
 */
public class LNP2_PolicyMastrServiceWrapper
	implements LNP2_PolicyMastrService,
			   ServiceWrapper<LNP2_PolicyMastrService> {

	public LNP2_PolicyMastrServiceWrapper(
		LNP2_PolicyMastrService lnp2_PolicyMastrService) {

		_lnp2_PolicyMastrService = lnp2_PolicyMastrService;
	}

	@Override
	public Object findAllPSPolicyByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException {

		return _lnp2_PolicyMastrService.findAllPSPolicyByIqamaId(iqamaId);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _lnp2_PolicyMastrService.getOSGiServiceIdentifier();
	}

	@Override
	public LNP2_PolicyMastrService getWrappedService() {
		return _lnp2_PolicyMastrService;
	}

	@Override
	public void setWrappedService(
		LNP2_PolicyMastrService lnp2_PolicyMastrService) {

		_lnp2_PolicyMastrService = lnp2_PolicyMastrService;
	}

	private LNP2_PolicyMastrService _lnp2_PolicyMastrService;

}