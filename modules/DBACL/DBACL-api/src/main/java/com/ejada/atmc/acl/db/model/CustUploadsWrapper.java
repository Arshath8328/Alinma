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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.sql.Blob;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CustUploads}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CustUploads
 * @generated
 */
public class CustUploadsWrapper
	extends BaseModelWrapper<CustUploads>
	implements CustUploads, ModelWrapper<CustUploads> {

	public CustUploadsWrapper(CustUploads custUploads) {
		super(custUploads);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("quotId", getQuotId());
		attributes.put("idFile", getIdFile());
		attributes.put("licenseFile", getLicenseFile());
		attributes.put("istCardFile", getIstCardFile());
		attributes.put("carFrontFile", getCarFrontFile());
		attributes.put("carBackFile", getCarBackFile());
		attributes.put("carLeftFile", getCarLeftFile());
		attributes.put("carRightFile", getCarRightFile());
		attributes.put("engChassisNoFile", getEngChassisNoFile());
		attributes.put("leaseFile", getLeaseFile());
		attributes.put("idFileName", getIdFileName());
		attributes.put("licenseFileName", getLicenseFileName());
		attributes.put("istCardFileName", getIstCardFileName());
		attributes.put("carFrontFileName", getCarFrontFileName());
		attributes.put("carBackFileName", getCarBackFileName());
		attributes.put("carLeftFileName", getCarLeftFileName());
		attributes.put("carRightFileName", getCarRightFileName());
		attributes.put("engChassisNoFileName", getEngChassisNoFileName());
		attributes.put("leaseFileName", getLeaseFileName());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		String quotId = (String)attributes.get("quotId");

		if (quotId != null) {
			setQuotId(quotId);
		}

		Blob idFile = (Blob)attributes.get("idFile");

		if (idFile != null) {
			setIdFile(idFile);
		}

		Blob licenseFile = (Blob)attributes.get("licenseFile");

		if (licenseFile != null) {
			setLicenseFile(licenseFile);
		}

		Blob istCardFile = (Blob)attributes.get("istCardFile");

		if (istCardFile != null) {
			setIstCardFile(istCardFile);
		}

		Blob carFrontFile = (Blob)attributes.get("carFrontFile");

		if (carFrontFile != null) {
			setCarFrontFile(carFrontFile);
		}

		Blob carBackFile = (Blob)attributes.get("carBackFile");

		if (carBackFile != null) {
			setCarBackFile(carBackFile);
		}

		Blob carLeftFile = (Blob)attributes.get("carLeftFile");

		if (carLeftFile != null) {
			setCarLeftFile(carLeftFile);
		}

		Blob carRightFile = (Blob)attributes.get("carRightFile");

		if (carRightFile != null) {
			setCarRightFile(carRightFile);
		}

		Blob engChassisNoFile = (Blob)attributes.get("engChassisNoFile");

		if (engChassisNoFile != null) {
			setEngChassisNoFile(engChassisNoFile);
		}

		Blob leaseFile = (Blob)attributes.get("leaseFile");

		if (leaseFile != null) {
			setLeaseFile(leaseFile);
		}

		String idFileName = (String)attributes.get("idFileName");

		if (idFileName != null) {
			setIdFileName(idFileName);
		}

		String licenseFileName = (String)attributes.get("licenseFileName");

		if (licenseFileName != null) {
			setLicenseFileName(licenseFileName);
		}

		String istCardFileName = (String)attributes.get("istCardFileName");

		if (istCardFileName != null) {
			setIstCardFileName(istCardFileName);
		}

		String carFrontFileName = (String)attributes.get("carFrontFileName");

		if (carFrontFileName != null) {
			setCarFrontFileName(carFrontFileName);
		}

		String carBackFileName = (String)attributes.get("carBackFileName");

		if (carBackFileName != null) {
			setCarBackFileName(carBackFileName);
		}

		String carLeftFileName = (String)attributes.get("carLeftFileName");

		if (carLeftFileName != null) {
			setCarLeftFileName(carLeftFileName);
		}

		String carRightFileName = (String)attributes.get("carRightFileName");

		if (carRightFileName != null) {
			setCarRightFileName(carRightFileName);
		}

		String engChassisNoFileName = (String)attributes.get(
			"engChassisNoFileName");

		if (engChassisNoFileName != null) {
			setEngChassisNoFileName(engChassisNoFileName);
		}

		String leaseFileName = (String)attributes.get("leaseFileName");

		if (leaseFileName != null) {
			setLeaseFileName(leaseFileName);
		}
	}

	/**
	 * Returns the car back file of this cust uploads.
	 *
	 * @return the car back file of this cust uploads
	 */
	@Override
	public Blob getCarBackFile() {
		return model.getCarBackFile();
	}

	/**
	 * Returns the car back file name of this cust uploads.
	 *
	 * @return the car back file name of this cust uploads
	 */
	@Override
	public String getCarBackFileName() {
		return model.getCarBackFileName();
	}

	/**
	 * Returns the car front file of this cust uploads.
	 *
	 * @return the car front file of this cust uploads
	 */
	@Override
	public Blob getCarFrontFile() {
		return model.getCarFrontFile();
	}

	/**
	 * Returns the car front file name of this cust uploads.
	 *
	 * @return the car front file name of this cust uploads
	 */
	@Override
	public String getCarFrontFileName() {
		return model.getCarFrontFileName();
	}

	/**
	 * Returns the car left file of this cust uploads.
	 *
	 * @return the car left file of this cust uploads
	 */
	@Override
	public Blob getCarLeftFile() {
		return model.getCarLeftFile();
	}

	/**
	 * Returns the car left file name of this cust uploads.
	 *
	 * @return the car left file name of this cust uploads
	 */
	@Override
	public String getCarLeftFileName() {
		return model.getCarLeftFileName();
	}

	/**
	 * Returns the car right file of this cust uploads.
	 *
	 * @return the car right file of this cust uploads
	 */
	@Override
	public Blob getCarRightFile() {
		return model.getCarRightFile();
	}

	/**
	 * Returns the car right file name of this cust uploads.
	 *
	 * @return the car right file name of this cust uploads
	 */
	@Override
	public String getCarRightFileName() {
		return model.getCarRightFileName();
	}

	/**
	 * Returns the eng chassis no file of this cust uploads.
	 *
	 * @return the eng chassis no file of this cust uploads
	 */
	@Override
	public Blob getEngChassisNoFile() {
		return model.getEngChassisNoFile();
	}

	/**
	 * Returns the eng chassis no file name of this cust uploads.
	 *
	 * @return the eng chassis no file name of this cust uploads
	 */
	@Override
	public String getEngChassisNoFileName() {
		return model.getEngChassisNoFileName();
	}

	/**
	 * Returns the ID of this cust uploads.
	 *
	 * @return the ID of this cust uploads
	 */
	@Override
	public long getId() {
		return model.getId();
	}

	/**
	 * Returns the id file of this cust uploads.
	 *
	 * @return the id file of this cust uploads
	 */
	@Override
	public Blob getIdFile() {
		return model.getIdFile();
	}

	/**
	 * Returns the id file name of this cust uploads.
	 *
	 * @return the id file name of this cust uploads
	 */
	@Override
	public String getIdFileName() {
		return model.getIdFileName();
	}

	/**
	 * Returns the ist card file of this cust uploads.
	 *
	 * @return the ist card file of this cust uploads
	 */
	@Override
	public Blob getIstCardFile() {
		return model.getIstCardFile();
	}

	/**
	 * Returns the ist card file name of this cust uploads.
	 *
	 * @return the ist card file name of this cust uploads
	 */
	@Override
	public String getIstCardFileName() {
		return model.getIstCardFileName();
	}

	/**
	 * Returns the lease file of this cust uploads.
	 *
	 * @return the lease file of this cust uploads
	 */
	@Override
	public Blob getLeaseFile() {
		return model.getLeaseFile();
	}

	/**
	 * Returns the lease file name of this cust uploads.
	 *
	 * @return the lease file name of this cust uploads
	 */
	@Override
	public String getLeaseFileName() {
		return model.getLeaseFileName();
	}

	/**
	 * Returns the license file of this cust uploads.
	 *
	 * @return the license file of this cust uploads
	 */
	@Override
	public Blob getLicenseFile() {
		return model.getLicenseFile();
	}

	/**
	 * Returns the license file name of this cust uploads.
	 *
	 * @return the license file name of this cust uploads
	 */
	@Override
	public String getLicenseFileName() {
		return model.getLicenseFileName();
	}

	/**
	 * Returns the primary key of this cust uploads.
	 *
	 * @return the primary key of this cust uploads
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the quot ID of this cust uploads.
	 *
	 * @return the quot ID of this cust uploads
	 */
	@Override
	public String getQuotId() {
		return model.getQuotId();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the car back file of this cust uploads.
	 *
	 * @param carBackFile the car back file of this cust uploads
	 */
	@Override
	public void setCarBackFile(Blob carBackFile) {
		model.setCarBackFile(carBackFile);
	}

	/**
	 * Sets the car back file name of this cust uploads.
	 *
	 * @param carBackFileName the car back file name of this cust uploads
	 */
	@Override
	public void setCarBackFileName(String carBackFileName) {
		model.setCarBackFileName(carBackFileName);
	}

	/**
	 * Sets the car front file of this cust uploads.
	 *
	 * @param carFrontFile the car front file of this cust uploads
	 */
	@Override
	public void setCarFrontFile(Blob carFrontFile) {
		model.setCarFrontFile(carFrontFile);
	}

	/**
	 * Sets the car front file name of this cust uploads.
	 *
	 * @param carFrontFileName the car front file name of this cust uploads
	 */
	@Override
	public void setCarFrontFileName(String carFrontFileName) {
		model.setCarFrontFileName(carFrontFileName);
	}

	/**
	 * Sets the car left file of this cust uploads.
	 *
	 * @param carLeftFile the car left file of this cust uploads
	 */
	@Override
	public void setCarLeftFile(Blob carLeftFile) {
		model.setCarLeftFile(carLeftFile);
	}

	/**
	 * Sets the car left file name of this cust uploads.
	 *
	 * @param carLeftFileName the car left file name of this cust uploads
	 */
	@Override
	public void setCarLeftFileName(String carLeftFileName) {
		model.setCarLeftFileName(carLeftFileName);
	}

	/**
	 * Sets the car right file of this cust uploads.
	 *
	 * @param carRightFile the car right file of this cust uploads
	 */
	@Override
	public void setCarRightFile(Blob carRightFile) {
		model.setCarRightFile(carRightFile);
	}

	/**
	 * Sets the car right file name of this cust uploads.
	 *
	 * @param carRightFileName the car right file name of this cust uploads
	 */
	@Override
	public void setCarRightFileName(String carRightFileName) {
		model.setCarRightFileName(carRightFileName);
	}

	/**
	 * Sets the eng chassis no file of this cust uploads.
	 *
	 * @param engChassisNoFile the eng chassis no file of this cust uploads
	 */
	@Override
	public void setEngChassisNoFile(Blob engChassisNoFile) {
		model.setEngChassisNoFile(engChassisNoFile);
	}

	/**
	 * Sets the eng chassis no file name of this cust uploads.
	 *
	 * @param engChassisNoFileName the eng chassis no file name of this cust uploads
	 */
	@Override
	public void setEngChassisNoFileName(String engChassisNoFileName) {
		model.setEngChassisNoFileName(engChassisNoFileName);
	}

	/**
	 * Sets the ID of this cust uploads.
	 *
	 * @param id the ID of this cust uploads
	 */
	@Override
	public void setId(long id) {
		model.setId(id);
	}

	/**
	 * Sets the id file of this cust uploads.
	 *
	 * @param idFile the id file of this cust uploads
	 */
	@Override
	public void setIdFile(Blob idFile) {
		model.setIdFile(idFile);
	}

	/**
	 * Sets the id file name of this cust uploads.
	 *
	 * @param idFileName the id file name of this cust uploads
	 */
	@Override
	public void setIdFileName(String idFileName) {
		model.setIdFileName(idFileName);
	}

	/**
	 * Sets the ist card file of this cust uploads.
	 *
	 * @param istCardFile the ist card file of this cust uploads
	 */
	@Override
	public void setIstCardFile(Blob istCardFile) {
		model.setIstCardFile(istCardFile);
	}

	/**
	 * Sets the ist card file name of this cust uploads.
	 *
	 * @param istCardFileName the ist card file name of this cust uploads
	 */
	@Override
	public void setIstCardFileName(String istCardFileName) {
		model.setIstCardFileName(istCardFileName);
	}

	/**
	 * Sets the lease file of this cust uploads.
	 *
	 * @param leaseFile the lease file of this cust uploads
	 */
	@Override
	public void setLeaseFile(Blob leaseFile) {
		model.setLeaseFile(leaseFile);
	}

	/**
	 * Sets the lease file name of this cust uploads.
	 *
	 * @param leaseFileName the lease file name of this cust uploads
	 */
	@Override
	public void setLeaseFileName(String leaseFileName) {
		model.setLeaseFileName(leaseFileName);
	}

	/**
	 * Sets the license file of this cust uploads.
	 *
	 * @param licenseFile the license file of this cust uploads
	 */
	@Override
	public void setLicenseFile(Blob licenseFile) {
		model.setLicenseFile(licenseFile);
	}

	/**
	 * Sets the license file name of this cust uploads.
	 *
	 * @param licenseFileName the license file name of this cust uploads
	 */
	@Override
	public void setLicenseFileName(String licenseFileName) {
		model.setLicenseFileName(licenseFileName);
	}

	/**
	 * Sets the primary key of this cust uploads.
	 *
	 * @param primaryKey the primary key of this cust uploads
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the quot ID of this cust uploads.
	 *
	 * @param quotId the quot ID of this cust uploads
	 */
	@Override
	public void setQuotId(String quotId) {
		model.setQuotId(quotId);
	}

	@Override
	protected CustUploadsWrapper wrap(CustUploads custUploads) {
		return new CustUploadsWrapper(custUploads);
	}

}