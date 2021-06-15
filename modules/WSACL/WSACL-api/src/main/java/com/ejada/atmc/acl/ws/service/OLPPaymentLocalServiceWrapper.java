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
 * Provides a wrapper for {@link OLPPaymentLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see OLPPaymentLocalService
 * @generated
 */
public class OLPPaymentLocalServiceWrapper
	implements OLPPaymentLocalService, ServiceWrapper<OLPPaymentLocalService> {

	public OLPPaymentLocalServiceWrapper(
		OLPPaymentLocalService olpPaymentLocalService) {

		_olpPaymentLocalService = olpPaymentLocalService;
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment confirmPayment(
		String transactionIdEnc) {

		return _olpPaymentLocalService.confirmPayment(transactionIdEnc);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _olpPaymentLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.InitiateOLPPayment initiatePayment(
		String olpAlias, double amount, String currency,
		String merchantLandingURL, String merchantFailureURL) {

		return _olpPaymentLocalService.initiatePayment(
			olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
	}

	@Override
	public OLPPaymentLocalService getWrappedService() {
		return _olpPaymentLocalService;
	}

	@Override
	public void setWrappedService(
		OLPPaymentLocalService olpPaymentLocalService) {

		_olpPaymentLocalService = olpPaymentLocalService;
	}

	private OLPPaymentLocalService _olpPaymentLocalService;

}