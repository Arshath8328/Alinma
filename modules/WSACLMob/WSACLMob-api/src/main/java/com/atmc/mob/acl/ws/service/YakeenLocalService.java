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

package com.atmc.mob.acl.ws.service;

import com.atmc.mob.acl.ws.domain.yakeen.AddressInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienDepInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienInfo;
import com.atmc.mob.acl.ws.domain.yakeen.AlienLegalStatusInfo;
import com.atmc.mob.acl.ws.domain.yakeen.BasicCarInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CarInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CitizenInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CompanyInfo;
import com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.util.List;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Yakeen. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see YakeenLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface YakeenLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.mob.acl.ws.service.impl.YakeenLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the yakeen local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link YakeenLocalServiceUtil} if injection and service tracking are not available.
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AddressInfo> getAlienAddressInfo(
		ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth,
		String addressLanguage);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AlienDepInfo> getAlienAllDepInfoByIqama(
		ServiceRequest svcRequest, String iqamaNumber, String depIqama);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarInfo getAlienCarInfoBySequence(
		ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlienInfo getAlienInfoByBorderNumber(
		ServiceRequest svcRequest, String borderNumber, String sponsorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlienInfo getAlienInfoByIqama(
		ServiceRequest svcRequest, String iqamaNumber, String sponsorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlienInfo getAlienInfoByIqamaAndDOB(
		ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public AlienLegalStatusInfo getAlienLegalStatusInfo(
		ServiceRequest svcRequest, String iqamaNumber, String sponsorId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AlienDepInfo> getAlienSingleDepInfoByIqama(
		ServiceRequest svcRequest, String iqamaNumber, String depIqama);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public BasicCarInfo getCarInfoByCustom(
		ServiceRequest svcRequest, String customCardNumber, short modelYear);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AddressInfo> getCitizenAddressInfo(
		ServiceRequest svcRequest, String nin, String dateOfBirth,
		String addressLanguage);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarInfo getCitizenCarInfoBySequence(
		ServiceRequest svcRequest, int sequenceNumber, long ownerNin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CitizenInfo getCitizenInfo(
		ServiceRequest svcRequest, String dateOfBirthH, String nin);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<AddressInfo> getCompanyAddressInfoByCr(
		ServiceRequest svcRequest, long crNumber, String addressLanguage);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CarInfo getCompanyCarInfoBySequence(
		ServiceRequest svcRequest, int sequenceNumber, long companyMOINumber);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public CompanyInfo getCompanyInfoBySponseredIqama(
		ServiceRequest svcRequest, String iqamaNumber, String sponsorNumber,
		String depIqama);

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

}