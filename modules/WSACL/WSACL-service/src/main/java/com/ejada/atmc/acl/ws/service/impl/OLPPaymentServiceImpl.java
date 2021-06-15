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

package com.ejada.atmc.acl.ws.service.impl;

import com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment;
import com.ejada.atmc.acl.ws.domain.InitiateOLPPayment;
import com.ejada.atmc.acl.ws.service.base.OLPPaymentServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the olp payment remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.OLPPaymentService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    OLPPaymentServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=wsacl", "json.web.service.context.path=OLPPayment" },
		service = AopService.class
)
public class OLPPaymentServiceImpl extends OLPPaymentServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.ws.service.OLPPaymentServiceUtil} to access
	 * the olp payment remote service.
	 */

	public InitiateOLPPayment initiatePayment(String olpAlias, double amount, String currency, String merchantLandingURL, String merchantFailureURL) {
		return olpPaymentLocalService.initiatePayment(olpAlias, amount, currency, merchantLandingURL, merchantFailureURL);
	}

	public ConfirmOLPPayment confirmPayment(String transactionIdEnc) {
		return olpPaymentLocalService.confirmPayment(transactionIdEnc);
	}

}