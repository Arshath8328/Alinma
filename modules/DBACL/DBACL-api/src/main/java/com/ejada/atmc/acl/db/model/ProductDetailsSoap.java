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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ProductDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProductDetailsSoap implements Serializable {

	public static ProductDetailsSoap toSoapModel(ProductDetails model) {
		ProductDetailsSoap soapModel = new ProductDetailsSoap();

		soapModel.setSysId(model.getSysId());
		soapModel.setLobSysId(model.getLobSysId());
		soapModel.setEffFmDate(model.getEffFmDate());
		soapModel.setEffToDate(model.getEffToDate());
		soapModel.setCrDate(model.getCrDate());
		soapModel.setCrUid(model.getCrUid());
		soapModel.setUpdDate(model.getUpdDate());
		soapModel.setUpdUid(model.getUpdUid());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setProductName(model.getProductName());
		soapModel.setProductNameAr(model.getProductNameAr());

		return soapModel;
	}

	public static ProductDetailsSoap[] toSoapModels(ProductDetails[] models) {
		ProductDetailsSoap[] soapModels = new ProductDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductDetailsSoap[][] toSoapModels(
		ProductDetails[][] models) {

		ProductDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new ProductDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductDetailsSoap[] toSoapModels(
		List<ProductDetails> models) {

		List<ProductDetailsSoap> soapModels = new ArrayList<ProductDetailsSoap>(
			models.size());

		for (ProductDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductDetailsSoap[soapModels.size()]);
	}

	public ProductDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _sysId;
	}

	public void setPrimaryKey(long pk) {
		setSysId(pk);
	}

	public long getSysId() {
		return _sysId;
	}

	public void setSysId(long sysId) {
		_sysId = sysId;
	}

	public double getLobSysId() {
		return _lobSysId;
	}

	public void setLobSysId(double lobSysId) {
		_lobSysId = lobSysId;
	}

	public Date getEffFmDate() {
		return _effFmDate;
	}

	public void setEffFmDate(Date effFmDate) {
		_effFmDate = effFmDate;
	}

	public Date getEffToDate() {
		return _effToDate;
	}

	public void setEffToDate(Date effToDate) {
		_effToDate = effToDate;
	}

	public Date getCrDate() {
		return _crDate;
	}

	public void setCrDate(Date crDate) {
		_crDate = crDate;
	}

	public String getCrUid() {
		return _crUid;
	}

	public void setCrUid(String crUid) {
		_crUid = crUid;
	}

	public String getUpdDate() {
		return _updDate;
	}

	public void setUpdDate(String updDate) {
		_updDate = updDate;
	}

	public String getUpdUid() {
		return _updUid;
	}

	public void setUpdUid(String updUid) {
		_updUid = updUid;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getProductNameAr() {
		return _productNameAr;
	}

	public void setProductNameAr(String productNameAr) {
		_productNameAr = productNameAr;
	}

	private long _sysId;
	private double _lobSysId;
	private Date _effFmDate;
	private Date _effToDate;
	private Date _crDate;
	private String _crUid;
	private String _updDate;
	private String _updUid;
	private String _productCode;
	private String _productName;
	private String _productNameAr;

}