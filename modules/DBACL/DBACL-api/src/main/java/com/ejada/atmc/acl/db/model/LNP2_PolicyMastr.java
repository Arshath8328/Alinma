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
 * The extended model interface for the LNP2_PolicyMastr service. Represents a row in the &quot;LNP2_POLICYMASTR&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrModel
 * @generated
 */
@ImplementationClassName(
	"com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrImpl"
)
@ProviderType
public interface LNP2_PolicyMastr
	extends LNP2_PolicyMastrModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<LNP2_PolicyMastr, String>
		NP1_PROPOSAL_ACCESSOR = new Accessor<LNP2_PolicyMastr, String>() {

			@Override
			public String get(LNP2_PolicyMastr lnp2_PolicyMastr) {
				return lnp2_PolicyMastr.getNp1_proposal();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<LNP2_PolicyMastr> getTypeClass() {
				return LNP2_PolicyMastr.class;
			}

		};

}