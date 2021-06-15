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

import java.sql.Blob;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CustUploads service. Represents a row in the &quot;EJD_QUOTATIONS_CUST_UPLOADS&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.CustUploadsModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.CustUploadsImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
@ProviderType
public interface CustUploadsModel extends BaseModel<CustUploads> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a cust uploads model instance should use the {@link CustUploads} interface instead.
	 */

	/**
	 * Returns the primary key of this cust uploads.
	 *
	 * @return the primary key of this cust uploads
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this cust uploads.
	 *
	 * @param primaryKey the primary key of this cust uploads
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the ID of this cust uploads.
	 *
	 * @return the ID of this cust uploads
	 */
	public long getId();

	/**
	 * Sets the ID of this cust uploads.
	 *
	 * @param id the ID of this cust uploads
	 */
	public void setId(long id);

	/**
	 * Returns the quot ID of this cust uploads.
	 *
	 * @return the quot ID of this cust uploads
	 */
	@AutoEscape
	public String getQuotId();

	/**
	 * Sets the quot ID of this cust uploads.
	 *
	 * @param quotId the quot ID of this cust uploads
	 */
	public void setQuotId(String quotId);

	/**
	 * Returns the id file of this cust uploads.
	 *
	 * @return the id file of this cust uploads
	 */
	public Blob getIdFile();

	/**
	 * Sets the id file of this cust uploads.
	 *
	 * @param idFile the id file of this cust uploads
	 */
	public void setIdFile(Blob idFile);

	/**
	 * Returns the license file of this cust uploads.
	 *
	 * @return the license file of this cust uploads
	 */
	public Blob getLicenseFile();

	/**
	 * Sets the license file of this cust uploads.
	 *
	 * @param licenseFile the license file of this cust uploads
	 */
	public void setLicenseFile(Blob licenseFile);

	/**
	 * Returns the ist card file of this cust uploads.
	 *
	 * @return the ist card file of this cust uploads
	 */
	public Blob getIstCardFile();

	/**
	 * Sets the ist card file of this cust uploads.
	 *
	 * @param istCardFile the ist card file of this cust uploads
	 */
	public void setIstCardFile(Blob istCardFile);

	/**
	 * Returns the car front file of this cust uploads.
	 *
	 * @return the car front file of this cust uploads
	 */
	public Blob getCarFrontFile();

	/**
	 * Sets the car front file of this cust uploads.
	 *
	 * @param carFrontFile the car front file of this cust uploads
	 */
	public void setCarFrontFile(Blob carFrontFile);

	/**
	 * Returns the car back file of this cust uploads.
	 *
	 * @return the car back file of this cust uploads
	 */
	public Blob getCarBackFile();

	/**
	 * Sets the car back file of this cust uploads.
	 *
	 * @param carBackFile the car back file of this cust uploads
	 */
	public void setCarBackFile(Blob carBackFile);

	/**
	 * Returns the car left file of this cust uploads.
	 *
	 * @return the car left file of this cust uploads
	 */
	public Blob getCarLeftFile();

	/**
	 * Sets the car left file of this cust uploads.
	 *
	 * @param carLeftFile the car left file of this cust uploads
	 */
	public void setCarLeftFile(Blob carLeftFile);

	/**
	 * Returns the car right file of this cust uploads.
	 *
	 * @return the car right file of this cust uploads
	 */
	public Blob getCarRightFile();

	/**
	 * Sets the car right file of this cust uploads.
	 *
	 * @param carRightFile the car right file of this cust uploads
	 */
	public void setCarRightFile(Blob carRightFile);

	/**
	 * Returns the eng chassis no file of this cust uploads.
	 *
	 * @return the eng chassis no file of this cust uploads
	 */
	public Blob getEngChassisNoFile();

	/**
	 * Sets the eng chassis no file of this cust uploads.
	 *
	 * @param engChassisNoFile the eng chassis no file of this cust uploads
	 */
	public void setEngChassisNoFile(Blob engChassisNoFile);

	/**
	 * Returns the lease file of this cust uploads.
	 *
	 * @return the lease file of this cust uploads
	 */
	public Blob getLeaseFile();

	/**
	 * Sets the lease file of this cust uploads.
	 *
	 * @param leaseFile the lease file of this cust uploads
	 */
	public void setLeaseFile(Blob leaseFile);

	/**
	 * Returns the id file name of this cust uploads.
	 *
	 * @return the id file name of this cust uploads
	 */
	@AutoEscape
	public String getIdFileName();

	/**
	 * Sets the id file name of this cust uploads.
	 *
	 * @param idFileName the id file name of this cust uploads
	 */
	public void setIdFileName(String idFileName);

	/**
	 * Returns the license file name of this cust uploads.
	 *
	 * @return the license file name of this cust uploads
	 */
	@AutoEscape
	public String getLicenseFileName();

	/**
	 * Sets the license file name of this cust uploads.
	 *
	 * @param licenseFileName the license file name of this cust uploads
	 */
	public void setLicenseFileName(String licenseFileName);

	/**
	 * Returns the ist card file name of this cust uploads.
	 *
	 * @return the ist card file name of this cust uploads
	 */
	@AutoEscape
	public String getIstCardFileName();

	/**
	 * Sets the ist card file name of this cust uploads.
	 *
	 * @param istCardFileName the ist card file name of this cust uploads
	 */
	public void setIstCardFileName(String istCardFileName);

	/**
	 * Returns the car front file name of this cust uploads.
	 *
	 * @return the car front file name of this cust uploads
	 */
	@AutoEscape
	public String getCarFrontFileName();

	/**
	 * Sets the car front file name of this cust uploads.
	 *
	 * @param carFrontFileName the car front file name of this cust uploads
	 */
	public void setCarFrontFileName(String carFrontFileName);

	/**
	 * Returns the car back file name of this cust uploads.
	 *
	 * @return the car back file name of this cust uploads
	 */
	@AutoEscape
	public String getCarBackFileName();

	/**
	 * Sets the car back file name of this cust uploads.
	 *
	 * @param carBackFileName the car back file name of this cust uploads
	 */
	public void setCarBackFileName(String carBackFileName);

	/**
	 * Returns the car left file name of this cust uploads.
	 *
	 * @return the car left file name of this cust uploads
	 */
	@AutoEscape
	public String getCarLeftFileName();

	/**
	 * Sets the car left file name of this cust uploads.
	 *
	 * @param carLeftFileName the car left file name of this cust uploads
	 */
	public void setCarLeftFileName(String carLeftFileName);

	/**
	 * Returns the car right file name of this cust uploads.
	 *
	 * @return the car right file name of this cust uploads
	 */
	@AutoEscape
	public String getCarRightFileName();

	/**
	 * Sets the car right file name of this cust uploads.
	 *
	 * @param carRightFileName the car right file name of this cust uploads
	 */
	public void setCarRightFileName(String carRightFileName);

	/**
	 * Returns the eng chassis no file name of this cust uploads.
	 *
	 * @return the eng chassis no file name of this cust uploads
	 */
	@AutoEscape
	public String getEngChassisNoFileName();

	/**
	 * Sets the eng chassis no file name of this cust uploads.
	 *
	 * @param engChassisNoFileName the eng chassis no file name of this cust uploads
	 */
	public void setEngChassisNoFileName(String engChassisNoFileName);

	/**
	 * Returns the lease file name of this cust uploads.
	 *
	 * @return the lease file name of this cust uploads
	 */
	@AutoEscape
	public String getLeaseFileName();

	/**
	 * Sets the lease file name of this cust uploads.
	 *
	 * @param leaseFileName the lease file name of this cust uploads
	 */
	public void setLeaseFileName(String leaseFileName);

}