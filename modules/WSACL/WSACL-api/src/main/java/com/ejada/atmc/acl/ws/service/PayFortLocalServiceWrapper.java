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

package com.ejada.atmc.acl.ws.service;

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link PayFortLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see PayFortLocalService
 * @generated
 */
public class PayFortLocalServiceWrapper
	implements PayFortLocalService, ServiceWrapper<PayFortLocalService> {

	public PayFortLocalServiceWrapper(PayFortLocalService payFortLocalService) {
		_payFortLocalService = payFortLocalService;
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse doPurchase(
		com.ejada.atmc.acl.ws.domain.payFort.PurchaseRequest req) {

		return _payFortLocalService.doPurchase(req);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _payFortLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public PayFortLocalService getWrappedService() {
		return _payFortLocalService;
	}

	@Override
	public void setWrappedService(PayFortLocalService payFortLocalService) {
		_payFortLocalService = payFortLocalService;
	}

	private PayFortLocalService _payFortLocalService;

}