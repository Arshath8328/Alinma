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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the
 * <code>YakeenServiceUtil</code> service
 * utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it requires an additional
 * <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see YakeenServiceSoap
 * @generated
 */
public class YakeenServiceHttp {

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByIqama(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienInfoByIqama",
				_getAlienInfoByIqamaParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, sponsorId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo
		getAlienInfoByBorderNumber(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String borderNumber, String sponsorId) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienInfoByBorderNumber",
				_getAlienInfoByBorderNumberParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, borderNumber, sponsorId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo
		getCitizenInfo(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String dateOfBirthH, String nin) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCitizenInfo",
				_getCitizenInfoParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, dateOfBirthH, nin);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienAllDepInfoByIqama(
				HttpPrincipal httpPrincipal,
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienAllDepInfoByIqama",
				_getAlienAllDepInfoByIqamaParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, depIqama);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>
			getAlienSingleDepInfoByIqama(
				HttpPrincipal httpPrincipal,
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				String iqamaNumber, String depIqama) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienSingleDepInfoByIqama",
				_getAlienSingleDepInfoByIqamaParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, depIqama);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo
		getCarInfoByCustom(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String customCardNumber, short modelYear) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCarInfoByCustom",
				_getCarInfoByCustomParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, customCardNumber, modelYear);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getAlienCarInfoBySequence(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerIqamaNumber) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienCarInfoBySequence",
				_getAlienCarInfoBySequenceParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, sequenceNumber, ownerIqamaNumber);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.CarInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCompanyCarInfoBySequence(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long companyMOINumber) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCompanyCarInfoBySequence",
				_getCompanyCarInfoBySequenceParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, sequenceNumber, companyMOINumber);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.CarInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CarInfo
		getCitizenCarInfoBySequence(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			int sequenceNumber, long ownerNin) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCitizenCarInfoBySequence",
				_getCitizenCarInfoBySequenceParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, sequenceNumber, ownerNin);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.CarInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo
		getAlienLegalStatusInfo(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorId) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienLegalStatusInfo",
				_getAlienLegalStatusInfoParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, sponsorId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo)
				returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo
		getCompanyInfoBySponseredIqama(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String sponsorNumber, String depIqama) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCompanyInfoBySponseredIqama",
				_getCompanyInfoBySponseredIqamaParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, sponsorNumber, depIqama);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo> getAlienAddressInfo(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String iqamaNumber, String dateOfBirth, String addressLanguage) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getAlienAddressInfo",
				_getAlienAddressInfoParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, iqamaNumber, dateOfBirth,
				addressLanguage);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo> getCitizenAddressInfo(
			HttpPrincipal httpPrincipal,
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
			String nin, String dateOfBirth, String addressLanguage) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCitizenAddressInfo",
				_getCitizenAddressInfoParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, nin, dateOfBirth, addressLanguage);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static java.util.List
		<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>
			getCompanyAddressInfoByCr(
				HttpPrincipal httpPrincipal,
				com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest svcRequest,
				long crNumber, String addressLanguage) {

		try {
			MethodKey methodKey = new MethodKey(
				YakeenServiceUtil.class, "getCompanyAddressInfoByCr",
				_getCompanyAddressInfoByCrParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(
				methodKey, svcRequest, crNumber, addressLanguage);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			}
			catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(
					exception);
			}

			return (java.util.List
				<com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo>)returnObj;
		}
		catch (com.liferay.portal.kernel.exception.SystemException
					systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(YakeenServiceHttp.class);

	private static final Class<?>[] _getAlienInfoByIqamaParameterTypes0 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[] _getAlienInfoByBorderNumberParameterTypes1 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[] _getCitizenInfoParameterTypes2 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[] _getAlienAllDepInfoByIqamaParameterTypes3 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[]
		_getAlienSingleDepInfoByIqamaParameterTypes4 = new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[] _getCarInfoByCustomParameterTypes5 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, short.class
		};
	private static final Class<?>[] _getAlienCarInfoBySequenceParameterTypes6 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class, int.class,
			long.class
		};
	private static final Class<?>[]
		_getCompanyCarInfoBySequenceParameterTypes7 = new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class, int.class,
			long.class
		};
	private static final Class<?>[]
		_getCitizenCarInfoBySequenceParameterTypes8 = new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class, int.class,
			long.class
		};
	private static final Class<?>[] _getAlienLegalStatusInfoParameterTypes9 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class
		};
	private static final Class<?>[]
		_getCompanyInfoBySponseredIqamaParameterTypes10 = new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getAlienAddressInfoParameterTypes11 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getCitizenAddressInfoParameterTypes12 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			String.class, String.class, String.class
		};
	private static final Class<?>[] _getCompanyAddressInfoByCrParameterTypes13 =
		new Class[] {
			com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest.class,
			long.class, String.class
		};

}