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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsException;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.db.service.base.QuotationsLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the quotations local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.QuotationsLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    QuotationsLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.Quotations",
		service = AopService.class
)
public class QuotationsLocalServiceImpl extends QuotationsLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.db.service.QuotationsLocalServiceUtil} to
	 * access the quotations local service.
	 */
	public List<Quotations> findByIqamaId(long iqamaId) {
		return this.quotationsPersistence.findByInsuredId(iqamaId);
	}

	public List<Quotations> findByQuotationId(long quotationIdId) throws NoSuchQuotationsException {
		return this.quotationsPersistence.findByQuotationId(quotationIdId);
	}

	public List<Quotations> findByIqamaIdAndStatus(long iqamaId, String[] status) {
		return this.quotationsPersistence.findByInsuredIdAndStatus(iqamaId, status);
	}

	public List<Quotations> getDateExpiredQuots(Date expiryDate, String[] status) {
		return quotationsPersistence.findByDateExpiredQuots(expiryDate, status);
	}

	public List<Quotations> getPendingPayment(Date expiryDate, String quoteStatus, boolean smsFlag) throws PortalException {
		return quotationsPersistence.findByPendingQuots(expiryDate, quoteStatus, smsFlag);
	}

	public List<Quotations> findByReferenceNo(String referenceNo) throws NoSuchQuotationsException {
		return this.quotationsPersistence.findByReferenceNo(referenceNo);
	}

	public Quotations findByPolicyNo(String policyNo) throws NoSuchQuotationsException {
		return this.quotationsPersistence.findByPolicyNo(policyNo);
	}

	public List<Quotations> findByinsuredMobile(long insuredMobile) throws NoSuchQuotationsException {
		return this.quotationsPersistence.findByinsuredMobile(insuredMobile);
	}

	public List<Quotations> findByQuoteStatus(String quoteStatus) throws NoSuchQuotationsException {
		return this.quotationsPersistence.findByQuotsStatus(quoteStatus);
	}

}