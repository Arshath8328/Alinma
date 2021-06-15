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
 * The extended model interface for the QuotationDriverseEndors service. Represents a row in the &quot;EJD_ADD_DRIVERS_ENDORS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationDriverseEndorsModel
 * @generated
 */
@ImplementationClassName(
	"com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsImpl"
)
@ProviderType
public interface QuotationDriverseEndors
	extends PersistedModel, QuotationDriverseEndorsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.QuotationDriverseEndorsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<QuotationDriverseEndors, Long>
		ADD_DRIVER_ID_ACCESSOR = new Accessor<QuotationDriverseEndors, Long>() {

			@Override
			public Long get(QuotationDriverseEndors quotationDriverseEndors) {
				return quotationDriverseEndors.getAddDriverId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<QuotationDriverseEndors> getTypeClass() {
				return QuotationDriverseEndors.class;
			}

		};

}