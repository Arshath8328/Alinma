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

import com.atmc.bsl.db.service.PolicyServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>PolicyServiceUtil</code> service
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
 * @see PolicyServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyServiceSoap {

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
				getPoliciesByIqamaId(String iqamaId, int startRow, int endRow)
			throws RemoteException {

		try {
			com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
					returnValue = PolicyServiceUtil.getPoliciesByIqamaId(
						iqamaId, startRow, endRow);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput<Long>
			getPoliciesCountByIqamaId(String iqamaId)
		throws RemoteException {

		try {
			com.ejada.atmc.bsl.db.domain.ServiceOutput<Long> returnValue =
				PolicyServiceUtil.getPoliciesCountByIqamaId(iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
				getUpcomingPolicyRenewals(String iqamaId)
			throws RemoteException {

		try {
			com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.ejada.atmc.bsl.db.domain.policy.Policy>>
					returnValue = PolicyServiceUtil.getUpcomingPolicyRenewals(
						iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<java.util.HashMap<String, Object>>> getPolicySummary(
				String iqamaId)
			throws RemoteException {

		try {
			com.ejada.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<java.util.HashMap<String, Object>>>
					returnValue = PolicyServiceUtil.getPolicySummary(iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.ejada.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.bsl.db.domain.policy.Policy> getPolicyByPolicyNo(
				String policyNo)
			throws RemoteException {

		try {
			com.ejada.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.bsl.db.domain.policy.Policy> returnValue =
					PolicyServiceUtil.getPolicyByPolicyNo(policyNo);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(PolicyServiceSoap.class);

}