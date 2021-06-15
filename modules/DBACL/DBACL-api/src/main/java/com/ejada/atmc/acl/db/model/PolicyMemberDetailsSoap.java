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
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.PolicyMemberDetailsServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class PolicyMemberDetailsSoap implements Serializable {

	public static PolicyMemberDetailsSoap toSoapModel(
		PolicyMemberDetails model) {

		PolicyMemberDetailsSoap soapModel = new PolicyMemberDetailsSoap();

		soapModel.setPolicyNo(model.getPolicyNo());
		soapModel.setMemberName(model.getMemberName());
		soapModel.setMemberSi(model.getMemberSi());
		soapModel.setMemberId(model.getMemberId());
		soapModel.setMemberGender(model.getMemberGender());
		soapModel.setMemberDob(model.getMemberDob());
		soapModel.setMemberLimit(model.getMemberLimit());

		return soapModel;
	}

	public static PolicyMemberDetailsSoap[] toSoapModels(
		PolicyMemberDetails[] models) {

		PolicyMemberDetailsSoap[] soapModels =
			new PolicyMemberDetailsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PolicyMemberDetailsSoap[][] toSoapModels(
		PolicyMemberDetails[][] models) {

		PolicyMemberDetailsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new PolicyMemberDetailsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PolicyMemberDetailsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PolicyMemberDetailsSoap[] toSoapModels(
		List<PolicyMemberDetails> models) {

		List<PolicyMemberDetailsSoap> soapModels =
			new ArrayList<PolicyMemberDetailsSoap>(models.size());

		for (PolicyMemberDetails model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(
			new PolicyMemberDetailsSoap[soapModels.size()]);
	}

	public PolicyMemberDetailsSoap() {
	}

	public long getPrimaryKey() {
		return _memberId;
	}

	public void setPrimaryKey(long pk) {
		setMemberId(pk);
	}

	public String getPolicyNo() {
		return _policyNo;
	}

	public void setPolicyNo(String policyNo) {
		_policyNo = policyNo;
	}

	public String getMemberName() {
		return _memberName;
	}

	public void setMemberName(String memberName) {
		_memberName = memberName;
	}

	public long getMemberSi() {
		return _memberSi;
	}

	public void setMemberSi(long memberSi) {
		_memberSi = memberSi;
	}

	public long getMemberId() {
		return _memberId;
	}

	public void setMemberId(long memberId) {
		_memberId = memberId;
	}

	public String getMemberGender() {
		return _memberGender;
	}

	public void setMemberGender(String memberGender) {
		_memberGender = memberGender;
	}

	public Date getMemberDob() {
		return _memberDob;
	}

	public void setMemberDob(Date memberDob) {
		_memberDob = memberDob;
	}

	public long getMemberLimit() {
		return _memberLimit;
	}

	public void setMemberLimit(long memberLimit) {
		_memberLimit = memberLimit;
	}

	private String _policyNo;
	private String _memberName;
	private long _memberSi;
	private long _memberId;
	private String _memberGender;
	private Date _memberDob;
	private long _memberLimit;

}