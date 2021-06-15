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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriverseEndorsException;
import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;
import com.ejada.atmc.acl.db.service.base.QuotationDriverseEndorsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quotation driverse endors local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.QuotationDriverseEndorsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    QuotationDriverseEndorsLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.QuotationDriverseEndors",
		service = AopService.class
)
public class QuotationDriverseEndorsLocalServiceImpl extends QuotationDriverseEndorsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.db.service.QuotationDriverseEndorsLocalServiceUtil} to access the quotation driverse endors local
	 * service.
	 */
	public List<QuotationDriverseEndors> findAllDrivEndorsByStatus(String status) {
		return quotationDriverseEndorsPersistence.findByStatus(status);
	}

	public QuotationDriverseEndors findByPolicyNumber(String policyNumber) throws NoSuchQuotationDriverseEndorsException {
		return quotationDriverseEndorsPersistence.findBypolicyNumber(policyNumber);
	}

	public QuotationDriverseEndors findEachDrivEndorsByStatus(String status) throws NoSuchQuotationDriverseEndorsException {
		return quotationDriverseEndorsPersistence.findByeachStatus(status);
	}

	public QuotationDriverseEndors driverId(String driverId) throws NoSuchQuotationDriverseEndorsException {
		return quotationDriverseEndorsPersistence.findByDriverId(driverId);
	}
}