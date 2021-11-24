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

package com.atmc.bsl.db.service;

import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;

import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for CustomerVehicleDetails. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerVehicleDetailsLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface CustomerVehicleDetailsLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.CustomerVehicleDetailsLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the customer vehicle details local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link CustomerVehicleDetailsLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarInfo getAlienCarInfoBySequence(
		ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlienInfo getAlienInfoByIqama(
		ServiceRequest svcRequest, String iqamaNumber, String sponsorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BasicCarInfo getCarInfoByCustom(
		ServiceRequest svcRequest, String customCardNumber, short modelYear);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarInfo getCitizenCarInfoBySequence(
		ServiceRequest svcRequest, int sequenceNumber, long ownerNin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CitizenInfo getCitizenInfo(
		ServiceRequest svcRequest, String dateOfBirthH, String nin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getCustomerVehicleDetails(
			Quotation quot, String addLang, Locale locale)
		throws NajmException, YaqeenException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getCustomerVehicleDetailsMob(
			Quotation quot, String addLang, Locale locale)
		throws NajmException, YaqeenException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getDriverVehicleDetails(
			QuotationDriver driver, HttpServletRequest request,
			boolean isRelative)
		throws YaqeenException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public void getDriverVehicleDetailsMob(
			QuotationDriver driver, HttpServletRequest request,
			boolean isRelative)
		throws YaqeenException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}