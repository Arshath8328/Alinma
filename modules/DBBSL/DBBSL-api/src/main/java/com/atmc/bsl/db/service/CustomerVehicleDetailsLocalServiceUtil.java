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

import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;
import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for CustomerVehicleDetails. This utility wraps
 * <code>com.atmc.bsl.db.service.impl.CustomerVehicleDetailsLocalServiceImpl</code> and
 * is an access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerVehicleDetailsLocalService
 * @generated
 */
public class CustomerVehicleDetailsLocalServiceUtil {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.CustomerVehicleDetailsLocalServiceImpl</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		return getService().getAlienCarInfoBySequence(
			svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqama(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		return getService().getAlienInfoByIqama(
			svcRequest, iqamaNumber, sponsorId);
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo
		getCarInfoByCustom(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String customCardNumber, short modelYear) {

		return getService().getCarInfoByCustom(
			svcRequest, customCardNumber, modelYear);
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

	public static com.ejada.atmc.bsl.db.domain.quotation.Quotation
			getCustomerVehicleDetails(
				com.ejada.atmc.bsl.db.domain.quotation.Quotation quot, String addLang,
				java.util.Locale locale)
		throws com.atmc.bsl.db.exception.NajmException,
			   com.atmc.bsl.db.exception.YaqeenException {

		return getService().getCustomerVehicleDetails(quot, addLang, locale);
	}

	public static com.ejada.atmc.bsl.db.domain.quotation.Quotation
			getCustomerVehicleDetailsMob(
				com.ejada.atmc.bsl.db.domain.quotation.Quotation quot, String addLang,
				java.util.Locale locale)
		throws com.atmc.bsl.db.exception.NajmException,
			   com.atmc.bsl.db.exception.YaqeenException {

		return getService().getCustomerVehicleDetailsMob(quot, addLang, locale);
	}

	public static void getDriverVehicleDetails(
			com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			javax.servlet.http.HttpServletRequest request, boolean isRelative)
		throws com.atmc.bsl.db.exception.YaqeenException {

		getService().getDriverVehicleDetails(driver, request, isRelative);
	}

	public static void getDriverVehicleDetailsMob(
			com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			javax.servlet.http.HttpServletRequest request, boolean isRelative)
		throws com.atmc.bsl.db.exception.YaqeenException {

		getService().getDriverVehicleDetailsMob(driver, request, isRelative);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public static String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static CustomerVehicleDetailsLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker
		<CustomerVehicleDetailsLocalService, CustomerVehicleDetailsLocalService>
			_serviceTracker;

	static {
		Bundle bundle = FrameworkUtil.getBundle(
			CustomerVehicleDetailsLocalService.class);

		ServiceTracker
			<CustomerVehicleDetailsLocalService,
			 CustomerVehicleDetailsLocalService> serviceTracker =
				new ServiceTracker
					<CustomerVehicleDetailsLocalService,
					 CustomerVehicleDetailsLocalService>(
						 bundle.getBundleContext(),
						 CustomerVehicleDetailsLocalService.class, null);

		serviceTracker.open();

		_serviceTracker = serviceTracker;
	}

}