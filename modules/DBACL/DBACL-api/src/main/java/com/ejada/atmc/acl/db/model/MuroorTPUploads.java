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
 * The extended model interface for the MuroorTPUploads service. Represents a row in the &quot;CLM_MUROOR_TP_UPLOADS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MuroorTPUploadsModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsImpl")
@ProviderType
public interface MuroorTPUploads extends MuroorTPUploadsModel, PersistedModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.MuroorTPUploadsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MuroorTPUploads, Integer> ID_ACCESSOR =
		new Accessor<MuroorTPUploads, Integer>() {

			@Override
			public Integer get(MuroorTPUploads muroorTPUploads) {
				return muroorTPUploads.getId();
			}

			@Override
			public Class<Integer> getAttributeClass() {
				return Integer.class;
			}

			@Override
			public Class<MuroorTPUploads> getTypeClass() {
				return MuroorTPUploads.class;
			}

		};

}