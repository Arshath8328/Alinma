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

package com.ejada.atmc.acl.ws.service.http;

import com.ejada.atmc.acl.ws.service.YakeenServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>YakeenServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class YakeenServiceSoap {

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
			getAlienInfoByIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String sponsorId)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo returnValue =
				YakeenServiceUtil.getAlienInfoByIqama(
					svcRequest, iqamaNumber, sponsorId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
			getAlienInfoByBorderNumber(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String borderNumber, String sponsorId)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo returnValue =
				YakeenServiceUtil.getAlienInfoByBorderNumber(
					svcRequest, borderNumber, sponsorId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo
			getCitizenInfo(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String dateOfBirthH, String nin)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo returnValue =
				YakeenServiceUtil.getCitizenInfo(svcRequest, dateOfBirthH, nin);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo[]
			getAlienAllDepInfoByIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama)
		throws RemoteException {

		try {
			java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
				returnValue = YakeenServiceUtil.getAlienAllDepInfoByIqama(
					svcRequest, iqamaNumber, depIqama);

			return returnValue.toArray(
				new com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo[]
			getAlienSingleDepInfoByIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama)
		throws RemoteException {

		try {
			java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
				returnValue = YakeenServiceUtil.getAlienSingleDepInfoByIqama(
					svcRequest, iqamaNumber, depIqama);

			return returnValue.toArray(
				new com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo
			getCarInfoByCustom(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String customCardNumber, short modelYear)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo returnValue =
				YakeenServiceUtil.getCarInfoByCustom(
					svcRequest, customCardNumber, modelYear);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
			getAlienCarInfoBySequence(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				int sequenceNumber, long ownerIqamaNumber)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.CarInfo returnValue =
				YakeenServiceUtil.getAlienCarInfoBySequence(
					svcRequest, sequenceNumber, ownerIqamaNumber);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
			getCompanyCarInfoBySequence(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				int sequenceNumber, long companyMOINumber)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.CarInfo returnValue =
				YakeenServiceUtil.getCompanyCarInfoBySequence(
					svcRequest, sequenceNumber, companyMOINumber);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
			getCitizenCarInfoBySequence(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				int sequenceNumber, long ownerNin)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.CarInfo returnValue =
				YakeenServiceUtil.getCitizenCarInfoBySequence(
					svcRequest, sequenceNumber, ownerNin);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo
			getAlienLegalStatusInfo(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String sponsorId)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo
				returnValue = YakeenServiceUtil.getAlienLegalStatusInfo(
					svcRequest, iqamaNumber, sponsorId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo
			getCompanyInfoBySponseredIqama(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String sponsorNumber, String depIqama)
		throws RemoteException {

		try {
			com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo returnValue =
				YakeenServiceUtil.getCompanyInfoBySponseredIqama(
					svcRequest, iqamaNumber, sponsorNumber, depIqama);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo[]
			getAlienAddressInfo(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String dateOfBirth, String addressLanguage)
		throws RemoteException {

		try {
			java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
				returnValue = YakeenServiceUtil.getAlienAddressInfo(
					svcRequest, iqamaNumber, dateOfBirth, addressLanguage);

			return returnValue.toArray(
				new com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo[]
			getCitizenAddressInfo(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String nin, String dateOfBirth, String addressLanguage)
		throws RemoteException {

		try {
			java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
				returnValue = YakeenServiceUtil.getCitizenAddressInfo(
					svcRequest, nin, dateOfBirth, addressLanguage);

			return returnValue.toArray(
				new com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo[]
			getCompanyAddressInfoByCr(
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				long crNumber, String addressLanguage)
		throws RemoteException {

		try {
			java.util.List<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
				returnValue = YakeenServiceUtil.getCompanyAddressInfoByCr(
					svcRequest, crNumber, addressLanguage);

			return returnValue.toArray(
				new com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo
					[returnValue.size()]);
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(YakeenServiceSoap.class);

}