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
 * Provides a wrapper for {@link TariffLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see TariffLocalService
 * @generated
 */
public class TariffLocalServiceWrapper
	implements ServiceWrapper<TariffLocalService>, TariffLocalService {

	public TariffLocalServiceWrapper(TariffLocalService tariffLocalService) {
		_tariffLocalService = tariffLocalService;
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _tariffLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.ArrayList<com.ejada.atmc.acl.db.domain.tariff.TariffOutput>
			getTariffData(
				com.ejada.atmc.acl.db.domain.tariff.TariffInput tariffInput)
		throws com.liferay.portal.kernel.exception.PortalException,
			   java.sql.SQLException {

		return _tariffLocalService.getTariffData(tariffInput);
	}

	@Override
	public TariffLocalService getWrappedService() {
		return _tariffLocalService;
	}

	@Override
	public void setWrappedService(TariffLocalService tariffLocalService) {
		_tariffLocalService = tariffLocalService;
	}

	private TariffLocalService _tariffLocalService;

}