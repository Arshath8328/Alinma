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
public interface LNP2_PolicyMastrFinder {

	public java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			findAllPSPolicy()
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicyDetail>
			findPSPolicyDetailsById(String id, String toDate)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			searchAllPSPolicybyIqumaId(String keyword)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.ejada.atmc.acl.db.custom.model.PSPolicy>
			findPSPolicyByIqamaId(String iqamaId)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.util.List<com.ejada.atmc.acl.db.custom.model.SOADetail>
			findPSPolicyStatementDetailsByIdAndDate(
				String id, String fromDate, String toDate)
		throws com.liferay.portal.kernel.exception.PortalException;

}