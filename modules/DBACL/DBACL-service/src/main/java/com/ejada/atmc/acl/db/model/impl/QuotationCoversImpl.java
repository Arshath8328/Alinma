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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.ProductCovers;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversPK;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversUtil;

/**
 * The extended model implementation for the QuotationCovers service. Represents
 * a row in the &quot;EJD_ADD_COVERS&quot; database table, with each column
 * mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class.
 * Whenever methods are added, rerun ServiceBuilder to copy their definitions
 * into the <code>com.ejada.atmc.acl.db.model.QuotationCovers</code> interface.
 * </p>
 *
 * @author Brian Wing Shun Chan
 */
public class QuotationCoversImpl extends QuotationCoversBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a quotation
	 * covers model instance should use the {@link
	 * com.ejada.atmc.acl.db.model.QuotationCovers} interface instead.
	 */

	private ProductCovers ProductCoversDets;

	public QuotationCoversImpl() {
	}

	public String getCoverNameEn(long productCode) {
		try {
			if (ProductCoversDets == null && getCoverCode() != null && !getCoverCode().equals("")) {
				ProductCoversPK productCoversPK = new ProductCoversPK();
				productCoversPK.setCoverCode(getCoverCode());
				productCoversPK.setSectionCode(getSectionCode());
				productCoversPK.setProductCode(Long.valueOf(productCode));
				ProductCoversDets = ProductCoversUtil.fetchByPrimaryKey(productCoversPK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ProductCoversDets != null) ? ProductCoversDets.getCoverName() : "";
	}

	public String getCoverNameAr(long productCode) {
		try {
			if (ProductCoversDets == null && getCoverCode() != null && !getCoverCode().equals("")) {
				ProductCoversPK productCoversPK = new ProductCoversPK();
				productCoversPK.setCoverCode(getCoverCode());
				productCoversPK.setSectionCode(getSectionCode());
				productCoversPK.setProductCode(Long.valueOf(productCode));
				ProductCoversDets = ProductCoversUtil.fetchByPrimaryKey(productCoversPK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ProductCoversDets != null) ? ProductCoversDets.getCoverNameAr() : "";
	}

	public String getCoverDescEn(long productCode) {
		try {
			if (ProductCoversDets == null && getCoverCode() != null && !getCoverCode().equals("")) {
				ProductCoversPK productCoversPK = new ProductCoversPK();
				productCoversPK.setCoverCode(getCoverCode());
				productCoversPK.setSectionCode(getSectionCode());
				productCoversPK.setProductCode(Long.valueOf(productCode));
				ProductCoversDets = ProductCoversUtil.fetchByPrimaryKey(productCoversPK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ProductCoversDets != null) ? ProductCoversDets.getCoverDesc() : "";
	}

	public String getCoverDescAr(long productCode) {
		try {
			if (ProductCoversDets == null && getCoverCode() != null && !getCoverCode().equals("")) {
				ProductCoversPK productCoversPK = new ProductCoversPK();
				productCoversPK.setCoverCode(getCoverCode());
				productCoversPK.setSectionCode(getSectionCode());
				productCoversPK.setProductCode(Long.valueOf(productCode));
				ProductCoversDets = ProductCoversUtil.fetchByPrimaryKey(productCoversPK);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (ProductCoversDets != null) ? ProductCoversDets.getCoverDescAr() : "";
	}
}