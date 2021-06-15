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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationDriversException;
import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.service.base.QuotationDriversLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quotation drivers local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.QuotationDriversLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    QuotationDriversLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.QuotationDrivers",
		service = AopService.class
)
public class QuotationDriversLocalServiceImpl extends QuotationDriversLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.db.service.QuotationDriversLocalServiceUtil} to access the quotation drivers local service.
	 */
	public QuotationDrivers findByAddDriverIdQuotationId(long quotationId, long addDriverId) throws NoSuchQuotationDriversException {
		return this.quotationDriversPersistence.findByAddDriverIdQuotationId(addDriverId, quotationId);
	}

	// Kareem Kahil: Changed this finder since now EJD_ADD_DRIVERS table hosts 2
	// types of Drivers. Underage drivers (can be multiple) and normal (only one for
	// now)
	// This finder method has been changed so that it keeps returning the normal
	// kind (ie underage flag = false)
	public List<QuotationDrivers> findByQuotationId(long quotationId) {
		return this.quotationDriversPersistence.findByQuotationIdIsDriverUnder21(false, quotationId);
	}

	public List<QuotationDrivers> findUnderAgeDriversByQuotationId(long quotationId) {
		return this.quotationDriversPersistence.findByQuotationIdIsDriverUnder21(true, quotationId);
	}
}