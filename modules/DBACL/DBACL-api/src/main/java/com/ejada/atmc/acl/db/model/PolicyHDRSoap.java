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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyHDRServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyHDRSoap implements Serializable {

	public static PolicyHDRSoap toSoapModel(PolicyHDR model) {
		PolicyHDRSoap soapModel = new PolicyHDRSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setIqamaId(model.getIqamaId());
		soapModel.setPolicyStatus(model.getPolicyStatus());
		soapModel.setProduct(model.getProduct());
		soapModel.setInceptionDate(model.getInceptionDate());
		soapModel.setExpiryDate(model.getExpiryDate());
		soapModel.setSumInsured(model.getSumInsured());
		soapModel.setTotalPremium(model.getTotalPremium());
		soapModel.setPolicyFees(model.getPolicyFees());
		soapModel.setPolicyTaxes(model.getPolicyTaxes());
		soapModel.setPolicyTerm(model.getPolicyTerm());
		soapModel.setPremium(model.getPremium());
		soapModel.setNextDueDate(model.getNextDueDate());
		soapModel.setCountPremMissed(model.getCountPremMissed());
		soapModel.setModeOfPayment(model.getModeOfPayment());
		soapModel.setNextRenwalDate(model.getNextRenwalDate());
		soapModel.setCustName(model.getCustName());
		soapModel.setCustBirthDate(model.getCustBirthDate());
		soapModel.setInsuredName(model.getInsuredName());
		soapModel.setInsuredBirthDate(model.getInsuredBirthDate());
		soapModel.setInsuredId(model.getInsuredId());
		soapModel.setInsuredMobile(model.getInsuredMobile());
		soapModel.setInsuredEmail(model.getInsuredEmail());
		soapModel.setInsuredAddr(model.getInsuredAddr());
		soapModel.setInsuredGender(model.getInsuredGender());
		soapModel.setOccuptation(model.getOccuptation());
		soapModel.setEstExpiryDate(model.getEstExpiryDate());
		soapModel.setNajmStatus(model.getNajmStatus());
		soapModel.setSurrenderValue(model.getSurrenderValue());
		soapModel.setNoOfRisk(model.getNoOfRisk());
		soapModel.setMemberScheme(model.getMemberScheme());
		soapModel.setMemberBenefits(model.getMemberBenefits());

		return soapModel;
	}

	public static PolicyHDRSoap[] toSoapModels(PolicyHDR[] models) {
		PolicyHDRSoap[] soapModels = new PolicyHDRSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyHDRSoap[][] toSoapModels(PolicyHDR[][] models) {
		PolicyHDRSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PolicyHDRSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyHDRSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyHDRSoap[] toSoapModels(List<PolicyHDR> models) {
		List<PolicyHDRSoap> soapModels = new ArrayList<PolicyHDRSoap>(
			models.size());

		for (PolicyHDR model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PolicyHDRSoap[soapModels.size()]);
	}

	public PolicyHDRSoap() {
	}

	public String getPrimaryKey() {
		return _policyNo;
	}

	public void setPrimaryKey(String pk) {
		setPolicyNo(pk);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getIqamaId() {
		return _iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		_iqamaId = iqamaId;
	}

	public String getPolicyStatus() {
		return _policyStatus;
	}

	public void setPolicyStatus(String policyStatus) {
		_policyStatus = policyStatus;
	}

	public String getProduct() {
		return _product;
	}

	public void setProduct(String product) {
		_product = product;
	}

	public Date getInceptionDate() {
		return _inceptionDate;
	}

	public void setInceptionDate(Date inceptionDate) {
		_inceptionDate = inceptionDate;
	}

	public Date getExpiryDate() {
		return _expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		_expiryDate = expiryDate;
	}

	public long getSumInsured() {
		return _sumInsured;
	}

	public void setSumInsured(long sumInsured) {
		_sumInsured = sumInsured;
	}

	public long getTotalPremium() {
		return _totalPremium;
	}

	public void setTotalPremium(long totalPremium) {
		_totalPremium = totalPremium;
	}

	public long getPolicyFees() {
		return _policyFees;
	}

	public void setPolicyFees(long policyFees) {
		_policyFees = policyFees;
	}

	public String getPolicyTaxes() {
		return _policyTaxes;
	}

	public void setPolicyTaxes(String policyTaxes) {
		_policyTaxes = policyTaxes;
	}

	public long getPolicyTerm() {
		return _policyTerm;
	}

	public void setPolicyTerm(long policyTerm) {
		_policyTerm = policyTerm;
	}

	public String getPremium() {
		return _premium;
	}

	public void setPremium(String premium) {
		_premium = premium;
	}

	public Date getNextDueDate() {
		return _nextDueDate;
	}

	public void setNextDueDate(Date nextDueDate) {
		_nextDueDate = nextDueDate;
	}

	public long getCountPremMissed() {
		return _countPremMissed;
	}

	public void setCountPremMissed(long countPremMissed) {
		_countPremMissed = countPremMissed;
	}

	public String getModeOfPayment() {
		return _modeOfPayment;
	}

	public void setModeOfPayment(String modeOfPayment) {
		_modeOfPayment = modeOfPayment;
	}

	public Date getNextRenwalDate() {
		return _nextRenwalDate;
	}

	public void setNextRenwalDate(Date nextRenwalDate) {
		_nextRenwalDate = nextRenwalDate;
	}

	public String getCustName() {
		return _custName;
	}

	public void setCustName(String custName) {
		_custName = custName;
	}

	public Date getCustBirthDate() {
		return _custBirthDate;
	}

	public void setCustBirthDate(Date custBirthDate) {
		_custBirthDate = custBirthDate;
	}

	public String getInsuredName() {
		return _insuredName;
	}

	public void setInsuredName(String insuredName) {
		_insuredName = insuredName;
	}

	public Date getInsuredBirthDate() {
		return _insuredBirthDate;
	}

	public void setInsuredBirthDate(Date insuredBirthDate) {
		_insuredBirthDate = insuredBirthDate;
	}

	public String getInsuredId() {
		return _insuredId;
	}

	public void setInsuredId(String insuredId) {
		_insuredId = insuredId;
	}

	public String getInsuredMobile() {
		return _insuredMobile;
	}

	public void setInsuredMobile(String insuredMobile) {
		_insuredMobile = insuredMobile;
	}

	public String getInsuredEmail() {
		return _insuredEmail;
	}

	public void setInsuredEmail(String insuredEmail) {
		_insuredEmail = insuredEmail;
	}

	public String getInsuredAddr() {
		return _insuredAddr;
	}

	public void setInsuredAddr(String insuredAddr) {
		_insuredAddr = insuredAddr;
	}

	public String getInsuredGender() {
		return _insuredGender;
	}

	public void setInsuredGender(String insuredGender) {
		_insuredGender = insuredGender;
	}

	public String getOccuptation() {
		return _occuptation;
	}

	public void setOccuptation(String occuptation) {
		_occuptation = occuptation;
	}

	public Date getEstExpiryDate() {
		return _estExpiryDate;
	}

	public void setEstExpiryDate(Date estExpiryDate) {
		_estExpiryDate = estExpiryDate;
	}

	public String getNajmStatus() {
		return _najmStatus;
	}

	public void setNajmStatus(String najmStatus) {
		_najmStatus = najmStatus;
	}

	public long getSurrenderValue() {
		return _surrenderValue;
	}

	public void setSurrenderValue(long surrenderValue) {
		_surrenderValue = surrenderValue;
	}

	public long getNoOfRisk() {
		return _noOfRisk;
	}

	public void setNoOfRisk(long noOfRisk) {
		_noOfRisk = noOfRisk;
	}

	public String getMemberScheme() {
		return _memberScheme;
	}

	public void setMemberScheme(String memberScheme) {
		_memberScheme = memberScheme;
	}

	public String getMemberBenefits() {
		return _memberBenefits;
	}

	public void setMemberBenefits(String memberBenefits) {
		_memberBenefits = memberBenefits;
	}

	private String _policyNo;
	private String _iqamaId;
	private String _policyStatus;
	private String _product;
	private Date _inceptionDate;
	private Date _expiryDate;
	private long _sumInsured;
	private long _totalPremium;
	private long _policyFees;
	private String _policyTaxes;
	private long _policyTerm;
	private String _premium;
	private Date _nextDueDate;
	private long _countPremMissed;
	private String _modeOfPayment;
	private Date _nextRenwalDate;
	private String _custName;
	private Date _custBirthDate;
	private String _insuredName;
	private Date _insuredBirthDate;
	private String _insuredId;
	private String _insuredMobile;
	private String _insuredEmail;
	private String _insuredAddr;
	private String _insuredGender;
	private String _occuptation;
	private Date _estExpiryDate;
	private String _najmStatus;
	private long _surrenderValue;
	private long _noOfRisk;
	private String _memberScheme;
	private String _memberBenefits;

}