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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ServiceRequestMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ServiceRequestMaster
 * @generated
 */
public class ServiceRequestMasterWrapper
	extends BaseModelWrapper<ServiceRequestMaster>
	implements ModelWrapper<ServiceRequestMaster>, ServiceRequestMaster {

	public ServiceRequestMasterWrapper(
		ServiceRequestMaster serviceRequestMaster) {

		super(serviceRequestMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("REFERENCE_NO", getREFERENCE_NO());
		attributes.put("SOURCE", getSOURCE());
		attributes.put("REQUEST_CATEGORY", getREQUEST_CATEGORY());
		attributes.put("REQUEST_TYPE", getREQUEST_TYPE());
		attributes.put("PRODUCT_TYPE", getPRODUCT_TYPE());
		attributes.put("REQUEST_MESSAGE", getREQUEST_MESSAGE());
		attributes.put("IQAMA_ID", getIQAMA_ID());
		attributes.put("EMAIL", getEMAIL());
		attributes.put("MOBILE", getMOBILE());
		attributes.put("REQUEST_STATUS", getREQUEST_STATUS());
		attributes.put("EMAIL_FLAG", isEMAIL_FLAG());
		attributes.put("CREATOR_USER_ID", getCREATOR_USER_ID());
		attributes.put("CREATION_DATE", getCREATION_DATE());
		attributes.put("CREATOR_USER_TYPE", getCREATOR_USER_TYPE());
		attributes.put("ASSIGNED_TO", getASSIGNED_TO());
		attributes.put("USER_NAME", getUSER_NAME());
		attributes.put("IBAN_NUMBER", getIBAN_NUMBER());
		attributes.put("ESCALATION_FLAG", isESCALATION_FLAG());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String REFERENCE_NO = (String)attributes.get("REFERENCE_NO");

		if (REFERENCE_NO != null) {
			setREFERENCE_NO(REFERENCE_NO);
		}

		String SOURCE = (String)attributes.get("SOURCE");

		if (SOURCE != null) {
			setSOURCE(SOURCE);
		}

		String REQUEST_CATEGORY = (String)attributes.get("REQUEST_CATEGORY");

		if (REQUEST_CATEGORY != null) {
			setREQUEST_CATEGORY(REQUEST_CATEGORY);
		}

		String REQUEST_TYPE = (String)attributes.get("REQUEST_TYPE");

		if (REQUEST_TYPE != null) {
			setREQUEST_TYPE(REQUEST_TYPE);
		}

		String PRODUCT_TYPE = (String)attributes.get("PRODUCT_TYPE");

		if (PRODUCT_TYPE != null) {
			setPRODUCT_TYPE(PRODUCT_TYPE);
		}

		String REQUEST_MESSAGE = (String)attributes.get("REQUEST_MESSAGE");

		if (REQUEST_MESSAGE != null) {
			setREQUEST_MESSAGE(REQUEST_MESSAGE);
		}

		String IQAMA_ID = (String)attributes.get("IQAMA_ID");

		if (IQAMA_ID != null) {
			setIQAMA_ID(IQAMA_ID);
		}

		String EMAIL = (String)attributes.get("EMAIL");

		if (EMAIL != null) {
			setEMAIL(EMAIL);
		}

		String MOBILE = (String)attributes.get("MOBILE");

		if (MOBILE != null) {
			setMOBILE(MOBILE);
		}

		String REQUEST_STATUS = (String)attributes.get("REQUEST_STATUS");

		if (REQUEST_STATUS != null) {
			setREQUEST_STATUS(REQUEST_STATUS);
		}

		Boolean EMAIL_FLAG = (Boolean)attributes.get("EMAIL_FLAG");

		if (EMAIL_FLAG != null) {
			setEMAIL_FLAG(EMAIL_FLAG);
		}

		String CREATOR_USER_ID = (String)attributes.get("CREATOR_USER_ID");

		if (CREATOR_USER_ID != null) {
			setCREATOR_USER_ID(CREATOR_USER_ID);
		}

		Date CREATION_DATE = (Date)attributes.get("CREATION_DATE");

		if (CREATION_DATE != null) {
			setCREATION_DATE(CREATION_DATE);
		}

		String CREATOR_USER_TYPE = (String)attributes.get("CREATOR_USER_TYPE");

		if (CREATOR_USER_TYPE != null) {
			setCREATOR_USER_TYPE(CREATOR_USER_TYPE);
		}

		String ASSIGNED_TO = (String)attributes.get("ASSIGNED_TO");

		if (ASSIGNED_TO != null) {
			setASSIGNED_TO(ASSIGNED_TO);
		}

		String USER_NAME = (String)attributes.get("USER_NAME");

		if (USER_NAME != null) {
			setUSER_NAME(USER_NAME);
		}

		String IBAN_NUMBER = (String)attributes.get("IBAN_NUMBER");

		if (IBAN_NUMBER != null) {
			setIBAN_NUMBER(IBAN_NUMBER);
		}

		Boolean ESCALATION_FLAG = (Boolean)attributes.get("ESCALATION_FLAG");

		if (ESCALATION_FLAG != null) {
			setESCALATION_FLAG(ESCALATION_FLAG);
		}
	}

	/**
	 * Returns the assigned_to of this service request master.
	 *
	 * @return the assigned_to of this service request master
	 */
	@Override
	public String getASSIGNED_TO() {
		return model.getASSIGNED_TO();
	}

	/**
	 * Returns the creation_date of this service request master.
	 *
	 * @return the creation_date of this service request master
	 */
	@Override
	public Date getCREATION_DATE() {
		return model.getCREATION_DATE();
	}

	/**
	 * Returns the creator_user_id of this service request master.
	 *
	 * @return the creator_user_id of this service request master
	 */
	@Override
	public String getCREATOR_USER_ID() {
		return model.getCREATOR_USER_ID();
	}

	/**
	 * Returns the creator_user_type of this service request master.
	 *
	 * @return the creator_user_type of this service request master
	 */
	@Override
	public String getCREATOR_USER_TYPE() {
		return model.getCREATOR_USER_TYPE();
	}

	/**
	 * Returns the email of this service request master.
	 *
	 * @return the email of this service request master
	 */
	@Override
	public String getEMAIL() {
		return model.getEMAIL();
	}

	/**
	 * Returns the email_flag of this service request master.
	 *
	 * @return the email_flag of this service request master
	 */
	@Override
	public boolean getEMAIL_FLAG() {
		return model.getEMAIL_FLAG();
	}

	/**
	 * Returns the escalation_flag of this service request master.
	 *
	 * @return the escalation_flag of this service request master
	 */
	@Override
	public boolean getESCALATION_FLAG() {
		return model.getESCALATION_FLAG();
	}

	/**
	 * Returns the iban_number of this service request master.
	 *
	 * @return the iban_number of this service request master
	 */
	@Override
	public String getIBAN_NUMBER() {
		return model.getIBAN_NUMBER();
	}

	/**
	 * Returns the iqama_id of this service request master.
	 *
	 * @return the iqama_id of this service request master
	 */
	@Override
	public String getIQAMA_ID() {
		return model.getIQAMA_ID();
	}

	/**
	 * Returns the mobile of this service request master.
	 *
	 * @return the mobile of this service request master
	 */
	@Override
	public String getMOBILE() {
		return model.getMOBILE();
	}

	/**
	 * Returns the primary key of this service request master.
	 *
	 * @return the primary key of this service request master
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the product_type of this service request master.
	 *
	 * @return the product_type of this service request master
	 */
	@Override
	public String getPRODUCT_TYPE() {
		return model.getPRODUCT_TYPE();
	}

	/**
	 * Returns the reference_no of this service request master.
	 *
	 * @return the reference_no of this service request master
	 */
	@Override
	public String getREFERENCE_NO() {
		return model.getREFERENCE_NO();
	}

	/**
	 * Returns the request_category of this service request master.
	 *
	 * @return the request_category of this service request master
	 */
	@Override
	public String getREQUEST_CATEGORY() {
		return model.getREQUEST_CATEGORY();
	}

	/**
	 * Returns the request_message of this service request master.
	 *
	 * @return the request_message of this service request master
	 */
	@Override
	public String getREQUEST_MESSAGE() {
		return model.getREQUEST_MESSAGE();
	}

	/**
	 * Returns the request_status of this service request master.
	 *
	 * @return the request_status of this service request master
	 */
	@Override
	public String getREQUEST_STATUS() {
		return model.getREQUEST_STATUS();
	}

	/**
	 * Returns the request_type of this service request master.
	 *
	 * @return the request_type of this service request master
	 */
	@Override
	public String getREQUEST_TYPE() {
		return model.getREQUEST_TYPE();
	}

	/**
	 * Returns the source of this service request master.
	 *
	 * @return the source of this service request master
	 */
	@Override
	public String getSOURCE() {
		return model.getSOURCE();
	}

	/**
	 * Returns the user_name of this service request master.
	 *
	 * @return the user_name of this service request master
	 */
	@Override
	public String getUSER_NAME() {
		return model.getUSER_NAME();
	}

	/**
	 * Returns <code>true</code> if this service request master is email_flag.
	 *
	 * @return <code>true</code> if this service request master is email_flag; <code>false</code> otherwise
	 */
	@Override
	public boolean isEMAIL_FLAG() {
		return model.isEMAIL_FLAG();
	}

	/**
	 * Returns <code>true</code> if this service request master is escalation_flag.
	 *
	 * @return <code>true</code> if this service request master is escalation_flag; <code>false</code> otherwise
	 */
	@Override
	public boolean isESCALATION_FLAG() {
		return model.isESCALATION_FLAG();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the assigned_to of this service request master.
	 *
	 * @param ASSIGNED_TO the assigned_to of this service request master
	 */
	@Override
	public void setASSIGNED_TO(String ASSIGNED_TO) {
		model.setASSIGNED_TO(ASSIGNED_TO);
	}

	/**
	 * Sets the creation_date of this service request master.
	 *
	 * @param CREATION_DATE the creation_date of this service request master
	 */
	@Override
	public void setCREATION_DATE(Date CREATION_DATE) {
		model.setCREATION_DATE(CREATION_DATE);
	}

	/**
	 * Sets the creator_user_id of this service request master.
	 *
	 * @param CREATOR_USER_ID the creator_user_id of this service request master
	 */
	@Override
	public void setCREATOR_USER_ID(String CREATOR_USER_ID) {
		model.setCREATOR_USER_ID(CREATOR_USER_ID);
	}

	/**
	 * Sets the creator_user_type of this service request master.
	 *
	 * @param CREATOR_USER_TYPE the creator_user_type of this service request master
	 */
	@Override
	public void setCREATOR_USER_TYPE(String CREATOR_USER_TYPE) {
		model.setCREATOR_USER_TYPE(CREATOR_USER_TYPE);
	}

	/**
	 * Sets the email of this service request master.
	 *
	 * @param EMAIL the email of this service request master
	 */
	@Override
	public void setEMAIL(String EMAIL) {
		model.setEMAIL(EMAIL);
	}

	/**
	 * Sets whether this service request master is email_flag.
	 *
	 * @param EMAIL_FLAG the email_flag of this service request master
	 */
	@Override
	public void setEMAIL_FLAG(boolean EMAIL_FLAG) {
		model.setEMAIL_FLAG(EMAIL_FLAG);
	}

	/**
	 * Sets whether this service request master is escalation_flag.
	 *
	 * @param ESCALATION_FLAG the escalation_flag of this service request master
	 */
	@Override
	public void setESCALATION_FLAG(boolean ESCALATION_FLAG) {
		model.setESCALATION_FLAG(ESCALATION_FLAG);
	}

	/**
	 * Sets the iban_number of this service request master.
	 *
	 * @param IBAN_NUMBER the iban_number of this service request master
	 */
	@Override
	public void setIBAN_NUMBER(String IBAN_NUMBER) {
		model.setIBAN_NUMBER(IBAN_NUMBER);
	}

	/**
	 * Sets the iqama_id of this service request master.
	 *
	 * @param IQAMA_ID the iqama_id of this service request master
	 */
	@Override
	public void setIQAMA_ID(String IQAMA_ID) {
		model.setIQAMA_ID(IQAMA_ID);
	}

	/**
	 * Sets the mobile of this service request master.
	 *
	 * @param MOBILE the mobile of this service request master
	 */
	@Override
	public void setMOBILE(String MOBILE) {
		model.setMOBILE(MOBILE);
	}

	/**
	 * Sets the primary key of this service request master.
	 *
	 * @param primaryKey the primary key of this service request master
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the product_type of this service request master.
	 *
	 * @param PRODUCT_TYPE the product_type of this service request master
	 */
	@Override
	public void setPRODUCT_TYPE(String PRODUCT_TYPE) {
		model.setPRODUCT_TYPE(PRODUCT_TYPE);
	}

	/**
	 * Sets the reference_no of this service request master.
	 *
	 * @param REFERENCE_NO the reference_no of this service request master
	 */
	@Override
	public void setREFERENCE_NO(String REFERENCE_NO) {
		model.setREFERENCE_NO(REFERENCE_NO);
	}

	/**
	 * Sets the request_category of this service request master.
	 *
	 * @param REQUEST_CATEGORY the request_category of this service request master
	 */
	@Override
	public void setREQUEST_CATEGORY(String REQUEST_CATEGORY) {
		model.setREQUEST_CATEGORY(REQUEST_CATEGORY);
	}

	/**
	 * Sets the request_message of this service request master.
	 *
	 * @param REQUEST_MESSAGE the request_message of this service request master
	 */
	@Override
	public void setREQUEST_MESSAGE(String REQUEST_MESSAGE) {
		model.setREQUEST_MESSAGE(REQUEST_MESSAGE);
	}

	/**
	 * Sets the request_status of this service request master.
	 *
	 * @param REQUEST_STATUS the request_status of this service request master
	 */
	@Override
	public void setREQUEST_STATUS(String REQUEST_STATUS) {
		model.setREQUEST_STATUS(REQUEST_STATUS);
	}

	/**
	 * Sets the request_type of this service request master.
	 *
	 * @param REQUEST_TYPE the request_type of this service request master
	 */
	@Override
	public void setREQUEST_TYPE(String REQUEST_TYPE) {
		model.setREQUEST_TYPE(REQUEST_TYPE);
	}

	/**
	 * Sets the source of this service request master.
	 *
	 * @param SOURCE the source of this service request master
	 */
	@Override
	public void setSOURCE(String SOURCE) {
		model.setSOURCE(SOURCE);
	}

	/**
	 * Sets the user_name of this service request master.
	 *
	 * @param USER_NAME the user_name of this service request master
	 */
	@Override
	public void setUSER_NAME(String USER_NAME) {
		model.setUSER_NAME(USER_NAME);
	}

	@Override
	protected ServiceRequestMasterWrapper wrap(
		ServiceRequestMaster serviceRequestMaster) {

		return new ServiceRequestMasterWrapper(serviceRequestMaster);
	}

}