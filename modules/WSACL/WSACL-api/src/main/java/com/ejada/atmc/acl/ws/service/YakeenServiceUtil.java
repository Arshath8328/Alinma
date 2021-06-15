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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for Yakeen. This utility wraps
 * <code>com.ejada.atmc.acl.ws.service.impl.YakeenServiceImpl</code> and is an
 * access point for service operations in application layer code running on a
 * remote server. Methods of this service are expected to have security checks
 * based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see YakeenService
 * @generated
 */
public class YakeenServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.ejada.atmc.acl.ws.service.impl.YakeenServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo> getAlienAddressInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String dateOfBirth, String addressLanguage) {

		return getService().getAlienAddressInfo(
			svcRequest, iqamaNumber, dateOfBirth, addressLanguage);
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienAllDepInfoByIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama) {

		return getService().getAlienAllDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		return getService().getAlienCarInfoBySequence(
			svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByBorderNumber(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String borderNumber, String sponsorId) {

		return getService().getAlienInfoByBorderNumber(
			svcRequest, borderNumber, sponsorId);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return getService().getAlienInfoByIqama(
			svcRequest, iqamaNumber, sponsorId);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo
		getAlienLegalStatusInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return getService().getAlienLegalStatusInfo(
			svcRequest, iqamaNumber, sponsorId);
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienSingleDepInfoByIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama) {

		return getService().getAlienSingleDepInfoByIqama(
			svcRequest, iqamaNumber, depIqama);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo
		getCarInfoByCustom(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String customCardNumber, short modelYear) {

		return getService().getCarInfoByCustom(
			svcRequest, customCardNumber, modelYear);
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo> getCitizenAddressInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String nin, String dateOfBirth, String addressLanguage) {

		return getService().getCitizenAddressInfo(
			svcRequest, nin, dateOfBirth, addressLanguage);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCitizenCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerNin) {

		return getService().getCitizenCarInfoBySequence(
			svcRequest, sequenceNumber, ownerNin);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo
		getCitizenInfo(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String dateOfBirthH, String nin) {

		return getService().getCitizenInfo(svcRequest, dateOfBirthH, nin);
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
			getCompanyAddressInfoByCr(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				long crNumber, String addressLanguage) {

		return getService().getCompanyAddressInfoByCr(
			svcRequest, crNumber, addressLanguage);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCompanyCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long companyMOINumber) {

		return getService().getCompanyCarInfoBySequence(
			svcRequest, sequenceNumber, companyMOINumber);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo
		getCompanyInfoBySponseredIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
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

	public static YakeenService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<YakeenService, YakeenService> _serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(YakeenService.class);

		ServiceTracker<YakeenService, YakeenService> serviceTracker =
			new ServiceTracker<YakeenService, YakeenService>(
				bundle.getBundleContext(), YakeenService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}