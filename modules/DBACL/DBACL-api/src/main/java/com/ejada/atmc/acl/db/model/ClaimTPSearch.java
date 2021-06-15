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

package com.ejada.atmc.acl.db.model;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the ClaimTPSearch service. Represents a row in the &quot;ODS_CLAIM_TP_SEARCH&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ClaimTPSearchModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.ClaimTPSearchImpl")
@ProviderType
public interface ClaimTPSearch extends ClaimTPSearchModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.ClaimTPSearchImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ClaimTPSearch, String> REPORT_NO_ACCESSOR =
		new Accessor<ClaimTPSearch, String>() {

			@Override
			public String get(ClaimTPSearch claimTPSearch) {
				return claimTPSearch.getReportNo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<ClaimTPSearch> getTypeClass() {
				return ClaimTPSearch.class;
			}

		};
	public static final Accessor<ClaimTPSearch, String> TP_ID_ACCESSOR =
		new Accessor<ClaimTPSearch, String>() {

			@Override
			public String get(ClaimTPSearch claimTPSearch) {
				return claimTPSearch.getTpId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<ClaimTPSearch> getTypeClass() {
				return ClaimTPSearch.class;
			}

		};

}