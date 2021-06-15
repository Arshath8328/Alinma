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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the QuotationsDriverLicense service. Represents a row in the &quot;EJD_QUOTATIONS_DRIVER_LICENSE&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.QuotationsDriverLicenseImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsDriverLicense
 * @generated
 */
@ProviderType
public interface QuotationsDriverLicenseModel
	extends BaseModel<QuotationsDriverLicense> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a quotations driver license model instance should use the {@link QuotationsDriverLicense} interface instead.
	 */

	/**
	 * Returns the primary key of this quotations driver license.
	 *
	 * @return the primary key of this quotations driver license
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this quotations driver license.
	 *
	 * @param primaryKey the primary key of this quotations driver license
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the license ID of this quotations driver license.
	 *
	 * @return the license ID of this quotations driver license
	 */
	public long getLicenseId();

	/**
	 * Sets the license ID of this quotations driver license.
	 *
	 * @param licenseId the license ID of this quotations driver license
	 */
	public void setLicenseId(long licenseId);

	/**
	 * Returns the driver ID of this quotations driver license.
	 *
	 * @return the driver ID of this quotations driver license
	 */
	public long getDriverId();

	/**
	 * Sets the driver ID of this quotations driver license.
	 *
	 * @param driverId the driver ID of this quotations driver license
	 */
	public void setDriverId(long driverId);

	/**
	 * Returns the quotation ID of this quotations driver license.
	 *
	 * @return the quotation ID of this quotations driver license
	 */
	public long getQuotationId();

	/**
	 * Sets the quotation ID of this quotations driver license.
	 *
	 * @param quotationId the quotation ID of this quotations driver license
	 */
	public void setQuotationId(long quotationId);

	/**
	 * Returns the lic country of this quotations driver license.
	 *
	 * @return the lic country of this quotations driver license
	 */
	@AutoEscape
	public String getLicCountry();

	/**
	 * Sets the lic country of this quotations driver license.
	 *
	 * @param LicCountry the lic country of this quotations driver license
	 */
	public void setLicCountry(String LicCountry);

	/**
	 * Returns the lic type of this quotations driver license.
	 *
	 * @return the lic type of this quotations driver license
	 */
	@AutoEscape
	public String getLicType();

	/**
	 * Sets the lic type of this quotations driver license.
	 *
	 * @param LicType the lic type of this quotations driver license
	 */
	public void setLicType(String LicType);

	/**
	 * Returns the lic yrs of this quotations driver license.
	 *
	 * @return the lic yrs of this quotations driver license
	 */
	public int getLicYrs();

	/**
	 * Sets the lic yrs of this quotations driver license.
	 *
	 * @param LicYrs the lic yrs of this quotations driver license
	 */
	public void setLicYrs(int LicYrs);

}