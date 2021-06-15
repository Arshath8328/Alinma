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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ServiceRequestMasterServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ServiceRequestMasterSoap implements Serializable {

	public static ServiceRequestMasterSoap toSoapModel(
		ServiceRequestMaster model) {

		ServiceRequestMasterSoap soapModel = new ServiceRequestMasterSoap();

		soapModel.setREFERENCE_NO(model.getREFERENCE_NO());
		soapModel.setSOURCE(model.getSOURCE());
		soapModel.setREQUEST_CATEGORY(model.getREQUEST_CATEGORY());
		soapModel.setREQUEST_TYPE(model.getREQUEST_TYPE());
		soapModel.setPRODUCT_TYPE(model.getPRODUCT_TYPE());
		soapModel.setREQUEST_MESSAGE(model.getREQUEST_MESSAGE());
		soapModel.setIQAMA_ID(model.getIQAMA_ID());
		soapModel.setEMAIL(model.getEMAIL());
		soapModel.setMOBILE(model.getMOBILE());
		soapModel.setREQUEST_STATUS(model.getREQUEST_STATUS());
		soapModel.setEMAIL_FLAG(model.isEMAIL_FLAG());
		soapModel.setCREATOR_USER_ID(model.getCREATOR_USER_ID());
		soapModel.setCREATION_DATE(model.getCREATION_DATE());
		soapModel.setCREATOR_USER_TYPE(model.getCREATOR_USER_TYPE());
		soapModel.setASSIGNED_TO(model.getASSIGNED_TO());
		soapModel.setUSER_NAME(model.getUSER_NAME());
		soapModel.setIBAN_NUMBER(model.getIBAN_NUMBER());
		soapModel.setESCALATION_FLAG(model.isESCALATION_FLAG());

		return soapModel;
	}

	public static ServiceRequestMasterSoap[] toSoapModels(
		ServiceRequestMaster[] models) {

		ServiceRequestMasterSoap[] soapModels =
			new ServiceRequestMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestMasterSoap[][] toSoapModels(
		ServiceRequestMaster[][] models) {

		ServiceRequestMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ServiceRequestMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ServiceRequestMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ServiceRequestMasterSoap[] toSoapModels(
		List<ServiceRequestMaster> models) {

		List<ServiceRequestMasterSoap> soapModels =
			new ArrayList<ServiceRequestMasterSoap>(models.size());

		for (ServiceRequestMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new ServiceRequestMasterSoap[soapModels.size()]);
	}

	public ServiceRequestMasterSoap() {
	}

	public String getPrimaryKey() {
		return _REFERENCE_NO;
	}

	public void setPrimaryKey(String pk) {
		setREFERENCE_NO(pk);
	}

	public String getREFERENCE_NO() {
		return _REFERENCE_NO;
	}

	public void setREFERENCE_NO(String REFERENCE_NO) {
		_REFERENCE_NO = REFERENCE_NO;
	}

	public String getSOURCE() {
		return _SOURCE;
	}

	public void setSOURCE(String SOURCE) {
		_SOURCE = SOURCE;
	}

	public String getREQUEST_CATEGORY() {
		return _REQUEST_CATEGORY;
	}

	public void setREQUEST_CATEGORY(String REQUEST_CATEGORY) {
		_REQUEST_CATEGORY = REQUEST_CATEGORY;
	}

	public String getREQUEST_TYPE() {
		return _REQUEST_TYPE;
	}

	public void setREQUEST_TYPE(String REQUEST_TYPE) {
		_REQUEST_TYPE = REQUEST_TYPE;
	}

	public String getPRODUCT_TYPE() {
		return _PRODUCT_TYPE;
	}

	public void setPRODUCT_TYPE(String PRODUCT_TYPE) {
		_PRODUCT_TYPE = PRODUCT_TYPE;
	}

	public String getREQUEST_MESSAGE() {
		return _REQUEST_MESSAGE;
	}

	public void setREQUEST_MESSAGE(String REQUEST_MESSAGE) {
		_REQUEST_MESSAGE = REQUEST_MESSAGE;
	}

	public String getIQAMA_ID() {
		return _IQAMA_ID;
	}

	public void setIQAMA_ID(String IQAMA_ID) {
		_IQAMA_ID = IQAMA_ID;
	}

	public String getEMAIL() {
		return _EMAIL;
	}

	public void setEMAIL(String EMAIL) {
		_EMAIL = EMAIL;
	}

	public String getMOBILE() {
		return _MOBILE;
	}

	public void setMOBILE(String MOBILE) {
		_MOBILE = MOBILE;
	}

	public String getREQUEST_STATUS() {
		return _REQUEST_STATUS;
	}

	public void setREQUEST_STATUS(String REQUEST_STATUS) {
		_REQUEST_STATUS = REQUEST_STATUS;
	}

	public boolean getEMAIL_FLAG() {
		return _EMAIL_FLAG;
	}

	public boolean isEMAIL_FLAG() {
		return _EMAIL_FLAG;
	}

	public void setEMAIL_FLAG(boolean EMAIL_FLAG) {
		_EMAIL_FLAG = EMAIL_FLAG;
	}

	public String getCREATOR_USER_ID() {
		return _CREATOR_USER_ID;
	}

	public void setCREATOR_USER_ID(String CREATOR_USER_ID) {
		_CREATOR_USER_ID = CREATOR_USER_ID;
	}

	public Date getCREATION_DATE() {
		return _CREATION_DATE;
	}

	public void setCREATION_DATE(Date CREATION_DATE) {
		_CREATION_DATE = CREATION_DATE;
	}

	public String getCREATOR_USER_TYPE() {
		return _CREATOR_USER_TYPE;
	}

	public void setCREATOR_USER_TYPE(String CREATOR_USER_TYPE) {
		_CREATOR_USER_TYPE = CREATOR_USER_TYPE;
	}

	public String getASSIGNED_TO() {
		return _ASSIGNED_TO;
	}

	public void setASSIGNED_TO(String ASSIGNED_TO) {
		_ASSIGNED_TO = ASSIGNED_TO;
	}

	public String getUSER_NAME() {
		return _USER_NAME;
	}

	public void setUSER_NAME(String USER_NAME) {
		_USER_NAME = USER_NAME;
	}

	public String getIBAN_NUMBER() {
		return _IBAN_NUMBER;
	}

	public void setIBAN_NUMBER(String IBAN_NUMBER) {
		_IBAN_NUMBER = IBAN_NUMBER;
	}

	public boolean getESCALATION_FLAG() {
		return _ESCALATION_FLAG;
	}

	public boolean isESCALATION_FLAG() {
		return _ESCALATION_FLAG;
	}

	public void setESCALATION_FLAG(boolean ESCALATION_FLAG) {
		_ESCALATION_FLAG = ESCALATION_FLAG;
	}

	private String _REFERENCE_NO;

	private String _SOURCE;

	private String _REQUEST_CATEGORY;

	private String _REQUEST_TYPE;

	private String _PRODUCT_TYPE;

	private String _REQUEST_MESSAGE;

	private String _IQAMA_ID;

	private String _EMAIL;

	private String _MOBILE;

	private String _REQUEST_STATUS;

	private boolean _EMAIL_FLAG;

	private String _CREATOR_USER_ID;

	private Date _CREATION_DATE;

	private String _CREATOR_USER_TYPE;

	private String _ASSIGNED_TO;

	private String _USER_NAME;

	private String _IBAN_NUMBER;

	private boolean _ESCALATION_FLAG;

}