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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Yakeen. This utility wraps
 * <code>com.atmc.mob.acl.ws.service.impl.YakeenLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see YakeenLocalService
 * @generated
 */
public class YakeenLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.mob.acl.ws.service.impl.YakeenLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List
		<com.atmc.mob.acl.ws.domain.yakeen.AddressInfo>
			getAlienAddressInfo(
				com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest
					svcRequest,
				String iqamaNumber, String dateOfBirth,
				String addressLanguage) {

		return getService().getAlienAddressInfo(
			svcRequest, iqamaNumber, dateOfBirth, addressLanguage);
	}

	public static java.util.List
		<com.atmc.mob.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienAllDepInfoByIqama(
				com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest
					svcRequest,
				String iqamaNumber, String depIqama) {

		return getService().getAlienAllDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		return getService().getAlienCarInfoBySequence(
			svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByBorderNumber(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String borderNumber, String sponsorId) {

		return getService().getAlienInfoByBorderNumber(
			svcRequest, borderNumber, sponsorId);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqama(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return getService().getAlienInfoByIqama(
			svcRequest, iqamaNumber, sponsorId);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqamaAndDOB(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String dateOfBirth) {

		return getService().getAlienInfoByIqamaAndDOB(
			svcRequest, iqamaNumber, dateOfBirth);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.AlienLegalStatusInfo
		getAlienLegalStatusInfo(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return getService().getAlienLegalStatusInfo(
			svcRequest, iqamaNumber, sponsorId);
	}

	public static java.util.List
		<com.atmc.mob.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienSingleDepInfoByIqama(
				com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest
					svcRequest,
				String iqamaNumber, String depIqama) {

		return getService().getAlienSingleDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.BasicCarInfo
		getCarInfoByCustom(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String customCardNumber, short modelYear) {

		return getService().getCarInfoByCustom(
			svcRequest, customCardNumber, modelYear);
	}

	public static java.util.List
		<com.atmc.mob.acl.ws.domain.yakeen.AddressInfo>
			getCitizenAddressInfo(
				com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest
					svcRequest,
				String nin, String dateOfBirth, String addressLanguage) {

		return getService().getCitizenAddressInfo(
			svcRequest, nin, dateOfBirth, addressLanguage);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.CarInfo
		getCitizenCarInfoBySequence(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerNin) {

		return getService().getCitizenCarInfoBySequence(
			svcRequest, sequenceNumber, ownerNin);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.CitizenInfo
		getCitizenInfo(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String dateOfBirthH, String nin) {

		return getService().getCitizenInfo(svcRequest, dateOfBirthH, nin);
	}

	public static java.util.List
		<com.atmc.mob.acl.ws.domain.yakeen.AddressInfo>
			getCompanyAddressInfoByCr(
				com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest
					svcRequest,
				long crNumber, String addressLanguage) {

		return getService().getCompanyAddressInfoByCr(
			svcRequest, crNumber, addressLanguage);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.CarInfo
		getCompanyCarInfoBySequence(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long companyMOINumber) {

		return getService().getCompanyCarInfoBySequence(
			svcRequest, sequenceNumber, companyMOINumber);
	}

	public static com.atmc.mob.acl.ws.domain.yakeen.CompanyInfo
		getCompanyInfoBySponseredIqama(
			com.atmc.mob.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorNumber, String depIqama) {

		return getService().getCompanyInfoBySponseredIqama(
			svcRequest, iqamaNumber, sponsorNumber, depIqama);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static YakeenLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<YakeenLocalService, YakeenLocalService>
		_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(YakeenLocalService.class);

		ServiceTracker<YakeenLocalService, YakeenLocalService> serviceTracker =
			new ServiceTracker<YakeenLocalService, YakeenLocalService>(
				bundle.getBundleContext(), YakeenLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}