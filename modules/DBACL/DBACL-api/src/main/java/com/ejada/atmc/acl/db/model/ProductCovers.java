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
 * The extended model interface for the ProductCovers service. Represents a row in the &quot;MDM_PRODUCT_COVERS&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see ProductCoversModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.ProductCoversImpl")
@ProviderType
public interface ProductCovers extends PersistedModel, ProductCoversModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.ProductCoversImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<ProductCovers, Long> PRODUCT_CODE_ACCESSOR =
		new Accessor<ProductCovers, Long>() {

			@Override
			public Long get(ProductCovers productCovers) {
				return productCovers.getProductCode();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProductCovers> getTypeClass() {
				return ProductCovers.class;
			}

		};
	public static final Accessor<ProductCovers, Long> SECTION_CODE_ACCESSOR =
		new Accessor<ProductCovers, Long>() {

			@Override
			public Long get(ProductCovers productCovers) {
				return productCovers.getSectionCode();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<ProductCovers> getTypeClass() {
				return ProductCovers.class;
			}

		};
	public static final Accessor<ProductCovers, String> COVER_CODE_ACCESSOR =
		new Accessor<ProductCovers, String>() {

			@Override
			public String get(ProductCovers productCovers) {
				return productCovers.getCoverCode();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<ProductCovers> getTypeClass() {
				return ProductCovers.class;
			}

		};

}