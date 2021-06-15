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

package com.ejada.atmc.acl.db.service.persistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public interface PolicyHDRFinder {

	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR> findByIqamaId(
		String iqamaId, int start, int end);

	public long findCountByIqamaId(String iqamaId);

	public Long findUpcomingRenewalsCount(String iqamaId);

	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
		findTopPolicies(String iqamaId);

	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR>
		findUpcomingPolicyRenewals(String iqamaId);

	public java.util.List<com.ejada.atmc.acl.db.model.PolicyHDR> findPolicyList(
		String iqamaId, String[] status);

	public boolean findLoyaltyByIqamaIdVehIdExpDate(
			String iqamaId, String vehId, java.util.Date expiryDate)
		throws com.liferay.portal.kernel.exception.PortalException;

	public String findPolicyNajmStatus(String PolicyNo)
		throws com.liferay.portal.kernel.exception.PortalException;

}