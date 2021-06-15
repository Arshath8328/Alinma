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

import com.ejada.atmc.acl.db.service.base.CustUploadsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.sql.Blob;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the cust uploads local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.CustUploadsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    CustUploadsLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.CustUploads",
		service = AopService.class
)
public class CustUploadsLocalServiceImpl extends CustUploadsLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.atmc.acl.db.service.CustUploadsLocalService</code> via
	 * injection or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.atmc.acl.db.service.CustUploadsLocalServiceUtil</code>.
	 */
	public String findidFileNameByQuotationId(String quotationId) {
		String data = custUploadsFinder.findidFileNameByQuotationId(quotationId);
		return data;
	}

	public long findIdByQuotationId(String quotationId) {
		long data = custUploadsFinder.findIdByQuotationId(quotationId);
		return data;
	}

	public String findlicenseByQuotationId(String quotationId) {
		String data = custUploadsFinder.findlicenseByQuotationId(quotationId);
		return data;
	}

	public String findistCardByQuotationId(String quotationId) {
		String data = custUploadsFinder.findistCardByQuotationId(quotationId);
		return data;
	}

	public Blob findIDFileByFileId(long fileId) {
		Blob data = custUploadsFinder.findIDFileByFileId(fileId);
		return data;
	}
}