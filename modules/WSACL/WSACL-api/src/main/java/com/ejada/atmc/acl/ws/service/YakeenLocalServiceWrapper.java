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
 * Provides a wrapper for {@link YakeenLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see YakeenLocalService
 * @generated
 */
public class YakeenLocalServiceWrapper
	implements ServiceWrapper<YakeenLocalService>, YakeenLocalService {

	public YakeenLocalServiceWrapper(YakeenLocalService yakeenLocalService) {
		_yakeenLocalService = yakeenLocalService;
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
		getAlienAddressInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String dateOfBirth, String addressLanguage) {

		return _yakeenLocalService.getAlienAddressInfo(
			svcRequest, iqamaNumber, dateOfBirth, addressLanguage);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
		getAlienAllDepInfoByIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String depIqama) {

		return _yakeenLocalService.getAlienAllDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		return _yakeenLocalService.getAlienCarInfoBySequence(
			svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByBorderNumber(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String borderNumber, String sponsorId) {

		return _yakeenLocalService.getAlienInfoByBorderNumber(
			svcRequest, borderNumber, sponsorId);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo getAlienInfoByIqama(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String iqamaNumber, String sponsorId) {

		return _yakeenLocalService.getAlienInfoByIqama(
			svcRequest, iqamaNumber, sponsorId);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqamaAndDOB(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String dateOfBirth) {

		return _yakeenLocalService.getAlienInfoByIqamaAndDOB(
			svcRequest, iqamaNumber, dateOfBirth);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo
		getAlienLegalStatusInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return _yakeenLocalService.getAlienLegalStatusInfo(
			svcRequest, iqamaNumber, sponsorId);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
		getAlienSingleDepInfoByIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String depIqama) {

		return _yakeenLocalService.getAlienSingleDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo getCarInfoByCustom(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String customCardNumber, short modelYear) {

		return _yakeenLocalService.getCarInfoByCustom(
			svcRequest, customCardNumber, modelYear);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
		getCitizenAddressInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String nin, String dateOfBirth, String addressLanguage) {

		return _yakeenLocalService.getCitizenAddressInfo(
			svcRequest, nin, dateOfBirth, addressLanguage);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCitizenCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerNin) {

		return _yakeenLocalService.getCitizenCarInfoBySequence(
			svcRequest, sequenceNumber, ownerNin);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo getCitizenInfo(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String dateOfBirthH, String nin) {

		return _yakeenLocalService.getCitizenInfo(
			svcRequest, dateOfBirthH, nin);
	}

	@Override
	public java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
		getCompanyAddressInfoByCr(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			long crNumber, String addressLanguage) {

		return _yakeenLocalService.getCompanyAddressInfoByCr(
			svcRequest, crNumber, addressLanguage);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCompanyCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long companyMOINumber) {

		return _yakeenLocalService.getCompanyCarInfoBySequence(
			svcRequest, sequenceNumber, companyMOINumber);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo
		getCompanyInfoBySponseredIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorNumber, String depIqama) {

		return _yakeenLocalService.getCompanyInfoBySponseredIqama(
			svcRequest, iqamaNumber, sponsorNumber, depIqama);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _yakeenLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public YakeenLocalService getWrappedService() {
		return _yakeenLocalService;
	}

	@Override
	public void setWrappedService(YakeenLocalService yakeenLocalService) {
		_yakeenLocalService = yakeenLocalService;
	}

	private YakeenLocalService _yakeenLocalService;

}