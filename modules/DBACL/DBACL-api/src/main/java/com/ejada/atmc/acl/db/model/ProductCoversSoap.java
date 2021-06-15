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

import com.ejada.atmc.acl.db.service.persistence.ProductCoversPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.ProductCoversServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class ProductCoversSoap implements Serializable {

	public static ProductCoversSoap toSoapModel(ProductCovers model) {
		ProductCoversSoap soapModel = new ProductCoversSoap();

		soapModel.setProductCode(model.getProductCode());
		soapModel.setSectionCode(model.getSectionCode());
		soapModel.setCoverCode(model.getCoverCode());
		soapModel.setCoverName(model.getCoverName());
		soapModel.setCoverNameAr(model.getCoverNameAr());
		soapModel.setCoverDesc(model.getCoverDesc());
		soapModel.setCoverDescAr(model.getCoverDescAr());
		soapModel.setCoverPremium(model.getCoverPremium());
		soapModel.setCoverFld1(model.getCoverFld1());
		soapModel.setCoverFld2(model.getCoverFld2());
		soapModel.setCoverFld3(model.getCoverFld3());
		soapModel.setCoverFld4(model.getCoverFld4());

		return soapModel;
	}

	public static ProductCoversSoap[] toSoapModels(ProductCovers[] models) {
		ProductCoversSoap[] soapModels = new ProductCoversSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductCoversSoap[][] toSoapModels(ProductCovers[][] models) {
		ProductCoversSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductCoversSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductCoversSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductCoversSoap[] toSoapModels(List<ProductCovers> models) {
		List<ProductCoversSoap> soapModels = new ArrayList<ProductCoversSoap>(
			models.size());

		for (ProductCovers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductCoversSoap[soapModels.size()]);
	}

	public ProductCoversSoap() {
	}

	public ProductCoversPK getPrimaryKey() {
		return new ProductCoversPK(_productCode, _sectionCode, _coverCode);
	}

	public void setPrimaryKey(ProductCoversPK pk) {
		setProductCode(pk.productCode);
		setSectionCode(pk.sectionCode);
		setCoverCode(pk.coverCode);
	}

	public long getProductCode() {
		return _productCode;
	}

	public void setProductCode(long productCode) {
		_productCode = productCode;
	}

	public long getSectionCode() {
		return _sectionCode;
	}

	public void setSectionCode(long sectionCode) {
		_sectionCode = sectionCode;
	}

	public String getCoverCode() {
		return _coverCode;
	}

	public void setCoverCode(String coverCode) {
		_coverCode = coverCode;
	}

	public String getCoverName() {
		return _coverName;
	}

	public void setCoverName(String coverName) {
		_coverName = coverName;
	}

	public String getCoverNameAr() {
		return _coverNameAr;
	}

	public void setCoverNameAr(String coverNameAr) {
		_coverNameAr = coverNameAr;
	}

	public String getCoverDesc() {
		return _coverDesc;
	}

	public void setCoverDesc(String coverDesc) {
		_coverDesc = coverDesc;
	}

	public String getCoverDescAr() {
		return _coverDescAr;
	}

	public void setCoverDescAr(String coverDescAr) {
		_coverDescAr = coverDescAr;
	}

	public String getCoverPremium() {
		return _coverPremium;
	}

	public void setCoverPremium(String coverPremium) {
		_coverPremium = coverPremium;
	}

	public String getCoverFld1() {
		return _coverFld1;
	}

	public void setCoverFld1(String coverFld1) {
		_coverFld1 = coverFld1;
	}

	public String getCoverFld2() {
		return _coverFld2;
	}

	public void setCoverFld2(String coverFld2) {
		_coverFld2 = coverFld2;
	}

	public String getCoverFld3() {
		return _coverFld3;
	}

	public void setCoverFld3(String coverFld3) {
		_coverFld3 = coverFld3;
	}

	public String getCoverFld4() {
		return _coverFld4;
	}

	public void setCoverFld4(String coverFld4) {
		_coverFld4 = coverFld4;
	}

	private long _productCode;
	private long _sectionCode;
	private String _coverCode;
	private String _coverName;
	private String _coverNameAr;
	private String _coverDesc;
	private String _coverDescAr;
	private String _coverPremium;
	private String _coverFld1;
	private String _coverFld2;
	private String _coverFld3;
	private String _coverFld4;

}