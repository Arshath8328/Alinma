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
public interface ClaimIntimationMtrFinder {

	public com.ejada.atmc.acl.db.model.ClaimIntimationMtr fetchLastRecord();

	public java.util.List<com.ejada.atmc.acl.db.model.ClaimIntimationMtr>
		getAllClaims();

	public com.ejada.atmc.acl.db.custom.model.ODSPolActiveVehicleDTO
		findOdsVehicleActiveList(String chassisNo, String policyNo);

	public long getClaimIntimationSequence();

	public java.util.List<com.ejada.atmc.acl.db.model.ClaimIntimationMtr>
		findClaimIntimationList(String keyword);

	public java.util.List
		<com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO>
			findClaimIntimationsByCategory(
				String findByCategory, String findByValue);

	public java.util.List
		<com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO>
			findClaimIntimationsStatus(String findByValue);

	public java.util.List
		<com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO>
			findClaimIntimationListByReferenceNoFromView(String referenceNo);

}