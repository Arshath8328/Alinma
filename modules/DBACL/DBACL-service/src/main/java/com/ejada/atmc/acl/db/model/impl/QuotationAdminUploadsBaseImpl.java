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

import com.ejada.atmc.acl.db.model.QuotationAdminUploads;
import com.ejada.atmc.acl.db.service.QuotationAdminUploadsLocalServiceUtil;

/**
 * The extended model base implementation for the QuotationAdminUploads service. Represents a row in the &quot;EJD_QUOTATIONS_ADMIN_UPLOADS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link QuotationAdminUploadsImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationAdminUploadsImpl
 * @see QuotationAdminUploads
 * @generated
 */
public abstract class QuotationAdminUploadsBaseImpl
	extends QuotationAdminUploadsModelImpl implements QuotationAdminUploads {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a quotation admin uploads model instance should use the <code>QuotationAdminUploads</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			QuotationAdminUploadsLocalServiceUtil.addQuotationAdminUploads(
				this);
		}
		else {
			QuotationAdminUploadsLocalServiceUtil.updateQuotationAdminUploads(
				this);
		}
	}

}