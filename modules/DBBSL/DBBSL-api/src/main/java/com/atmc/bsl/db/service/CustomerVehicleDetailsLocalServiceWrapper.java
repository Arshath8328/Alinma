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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CustomerVehicleDetailsLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see CustomerVehicleDetailsLocalService
 * @generated
 */
public class CustomerVehicleDetailsLocalServiceWrapper
	implements CustomerVehicleDetailsLocalService,
			   ServiceWrapper<CustomerVehicleDetailsLocalService> {

	public CustomerVehicleDetailsLocalServiceWrapper(
		CustomerVehicleDetailsLocalService customerVehicleDetailsLocalService) {

		_customerVehicleDetailsLocalService =
			customerVehicleDetailsLocalService;
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		return _customerVehicleDetailsLocalService.getAlienCarInfoBySequence(
			svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo getAlienInfoByIqama(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String iqamaNumber, String sponsorId) {

		return _customerVehicleDetailsLocalService.getAlienInfoByIqama(
			svcRequest, iqamaNumber, sponsorId);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo getCarInfoByCustom(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String customCardNumber, short modelYear) {

		return _customerVehicleDetailsLocalService.getCarInfoByCustom(
			svcRequest, customCardNumber, modelYear);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCitizenCarInfoBySequence(
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerNin) {

		return _customerVehicleDetailsLocalService.getCitizenCarInfoBySequence(
			svcRequest, sequenceNumber, ownerNin);
	}

	@Override
	public com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo getCitizenInfo(
		com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
		String dateOfBirthH, String nin) {

		return _customerVehicleDetailsLocalService.getCitizenInfo(
			svcRequest, dateOfBirthH, nin);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.quotation.Quotation getCustomerVehicleDetails(
			com.ejada.atmc.bsl.db.domain.quotation.Quotation quot, String addLang,
			java.util.Locale locale)
		throws com.atmc.bsl.db.exception.NajmException,
			   com.atmc.bsl.db.exception.YaqeenException {

		return _customerVehicleDetailsLocalService.getCustomerVehicleDetails(
			quot, addLang, locale);
	}

	@Override
	public com.ejada.atmc.bsl.db.domain.quotation.Quotation
			getCustomerVehicleDetailsMob(
				com.ejada.atmc.bsl.db.domain.quotation.Quotation quot, String addLang,
				java.util.Locale locale)
		throws com.atmc.bsl.db.exception.NajmException,
			   com.atmc.bsl.db.exception.YaqeenException {

		return _customerVehicleDetailsLocalService.getCustomerVehicleDetailsMob(
			quot, addLang, locale);
	}

	@Override
	public void getDriverVehicleDetails(
			com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			javax.servlet.http.HttpServletRequest request, boolean isRelative)
		throws com.atmc.bsl.db.exception.YaqeenException {

		_customerVehicleDetailsLocalService.getDriverVehicleDetails(
			driver, request, isRelative);
	}

	@Override
	public void getDriverVehicleDetailsMob(
			com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			javax.servlet.http.HttpServletRequest request, boolean isRelative)
		throws com.atmc.bsl.db.exception.YaqeenException {

		_customerVehicleDetailsLocalService.getDriverVehicleDetailsMob(
			driver, request, isRelative);
	}

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	@Override
	public String getOSGiServiceIdentifier() {
		return _customerVehicleDetailsLocalService.getOSGiServiceIdentifier();
	}

	@Override
	public CustomerVehicleDetailsLocalService getWrappedService() {
		return _customerVehicleDetailsLocalService;
	}

	@Override
	public void setWrappedService(
		CustomerVehicleDetailsLocalService customerVehicleDetailsLocalService) {

		_customerVehicleDetailsLocalService =
			customerVehicleDetailsLocalService;
	}

	private CustomerVehicleDetailsLocalService
		_customerVehicleDetailsLocalService;

}