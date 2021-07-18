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

package com.atmc.bsl.db.service.http;

import com.atmc.bsl.db.service.SrvReqMsgsServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>SrvReqMsgsServiceUtil</code> service
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
 * @see SrvReqMsgsServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class SrvReqMsgsServiceSoap {

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List
			<com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage>>
					getServiceRequestMessageListbyRefNo(String referenceNo)
				throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.serviceRequest.
						ServiceRequestMessage>> returnValue =
							SrvReqMsgsServiceUtil.
								getServiceRequestMessageListbyRefNo(
									referenceNo);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> addReplyMessage(
			com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage msg)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				SrvReqMsgsServiceUtil.addReplyMessage(msg);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(
		SrvReqMsgsServiceSoap.class);

}