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
 * The extended model interface for the Quotations service. Represents a row in the &quot;EJD_QUOTATIONS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.QuotationsImpl")
@ProviderType
public interface Quotations extends PersistedModel, QuotationsModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.QuotationsImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Quotations, Long> QUOTATION_ID_ACCESSOR =
		new Accessor<Quotations, Long>() {

			@Override
			public Long get(Quotations quotations) {
				return quotations.getQuotationId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Quotations> getTypeClass() {
				return Quotations.class;
			}

		};

	public java.util.List<QuotationCovers> getQuotationCovers();

	public QuotationDrivers getQuotationDriver();

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescAr();

	public String getModelEn();

	/**
	 * @return String
	 * @see
	 */
	public String getModelAr();

	public String getBodyTypeEn();

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeAr();

	public String getPurposeVehicleDesc();

	public String getPurposeVehicleDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescAr();

	public String getVehiclePlateTypeDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getVehiclePlateTypeDescAr();

}