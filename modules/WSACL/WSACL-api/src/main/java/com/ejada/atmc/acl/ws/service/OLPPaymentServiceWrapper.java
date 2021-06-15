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
 * Provides a wrapper for {@link OLPPaymentService}.
 *
 * @author Brian Wing Shun Chan
 * @see OLPPaymentService
 * @generated
 */
public class OLPPaymentServiceWrapper
	implements OLPPaymentService, ServiceWrapper<OLPPaymentService> {

	public OLPPaymentServiceWrapper(OLPPaymentService olpPaymentService) {
		_olpPaymentService = olpPaymentService;
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment confirmPayment(
		String transactionIdEnc) {

		return _olpPaymentService.confirmPayment(transactionIdEnc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _olpPaymentService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.InitiateOLPPayment initiatePayment(
		String olpAlias, double amount, String currency,
		String merchantLandingURL, String merchantFailureURL) {

		return _olpPaymentService.initiatePayment(
			olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
	}

	@Override
	public OLPPaymentService getWrappedService() {
		return _olpPaymentService;
	}

	@Override
	public void setWrappedService(OLPPaymentService olpPaymentService) {
		_olpPaymentService = olpPaymentService;
	}

	private OLPPaymentService _olpPaymentService;

}