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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link CLMNajm}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajm
 * @generated
 */
public class CLMNajmWrapper
	extends BaseModelWrapper<CLMNajm>
	implements CLMNajm, ModelWrapper<CLMNajm> {

	public CLMNajmWrapper(CLMNajm clmNajm) {
		super(clmNajm);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("caseNo", getCaseNo());
		attributes.put("cipiId", getCipiId());
		attributes.put("callDt", getCallDt());
		attributes.put("city", getCity());
		attributes.put("name", getName());
		attributes.put("phoneNo", getPhoneNo());
		attributes.put("age", getAge());
		attributes.put("nationality", getNationality());
		attributes.put("plateNo", getPlateNo());
		attributes.put("liabiltiyPerc", getLiabiltiyPerc());
		attributes.put("liabiltiyAmt", getLiabiltiyAmt());
		attributes.put("customId", getCustomId());
		attributes.put("seqNo", getSeqNo());
		attributes.put("englishName", getEnglishName());
		attributes.put("polNo", getPolNo());
		attributes.put("najmPlateNo", getNajmPlateNo());
		attributes.put("najmChassisNo", getNajmChassisNo());
		attributes.put("najmVEHNo", getNajmVEHNo());
		attributes.put("causeAr", getCauseAr());
		attributes.put("causeEn", getCauseEn());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String caseNo = (String)attributes.get("caseNo");

		if (caseNo != null) {
			setCaseNo(caseNo);
		}

		String cipiId = (String)attributes.get("cipiId");

		if (cipiId != null) {
			setCipiId(cipiId);
		}

		String callDt = (String)attributes.get("callDt");

		if (callDt != null) {
			setCallDt(callDt);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String phoneNo = (String)attributes.get("phoneNo");

		if (phoneNo != null) {
			setPhoneNo(phoneNo);
		}

		String age = (String)attributes.get("age");

		if (age != null) {
			setAge(age);
		}

		String nationality = (String)attributes.get("nationality");

		if (nationality != null) {
			setNationality(nationality);
		}

		String plateNo = (String)attributes.get("plateNo");

		if (plateNo != null) {
			setPlateNo(plateNo);
		}

		String liabiltiyPerc = (String)attributes.get("liabiltiyPerc");

		if (liabiltiyPerc != null) {
			setLiabiltiyPerc(liabiltiyPerc);
		}

		String liabiltiyAmt = (String)attributes.get("liabiltiyAmt");

		if (liabiltiyAmt != null) {
			setLiabiltiyAmt(liabiltiyAmt);
		}

		String customId = (String)attributes.get("customId");

		if (customId != null) {
			setCustomId(customId);
		}

		String seqNo = (String)attributes.get("seqNo");

		if (seqNo != null) {
			setSeqNo(seqNo);
		}

		String englishName = (String)attributes.get("englishName");

		if (englishName != null) {
			setEnglishName(englishName);
		}

		String polNo = (String)attributes.get("polNo");

		if (polNo != null) {
			setPolNo(polNo);
		}

		String najmPlateNo = (String)attributes.get("najmPlateNo");

		if (najmPlateNo != null) {
			setNajmPlateNo(najmPlateNo);
		}

		String najmChassisNo = (String)attributes.get("najmChassisNo");

		if (najmChassisNo != null) {
			setNajmChassisNo(najmChassisNo);
		}

		String najmVEHNo = (String)attributes.get("najmVEHNo");

		if (najmVEHNo != null) {
			setNajmVEHNo(najmVEHNo);
		}

		String causeAr = (String)attributes.get("causeAr");

		if (causeAr != null) {
			setCauseAr(causeAr);
		}

		String causeEn = (String)attributes.get("causeEn");

		if (causeEn != null) {
			setCauseEn(causeEn);
		}
	}

	/**
	 * Returns the age of this clm najm.
	 *
	 * @return the age of this clm najm
	 */
	@Override
	public String getAge() {
		return model.getAge();
	}

	/**
	 * Returns the call dt of this clm najm.
	 *
	 * @return the call dt of this clm najm
	 */
	@Override
	public String getCallDt() {
		return model.getCallDt();
	}

	/**
	 * Returns the case no of this clm najm.
	 *
	 * @return the case no of this clm najm
	 */
	@Override
	public String getCaseNo() {
		return model.getCaseNo();
	}

	/**
	 * Returns the cause ar of this clm najm.
	 *
	 * @return the cause ar of this clm najm
	 */
	@Override
	public String getCauseAr() {
		return model.getCauseAr();
	}

	/**
	 * Returns the cause en of this clm najm.
	 *
	 * @return the cause en of this clm najm
	 */
	@Override
	public String getCauseEn() {
		return model.getCauseEn();
	}

	/**
	 * Returns the cipi ID of this clm najm.
	 *
	 * @return the cipi ID of this clm najm
	 */
	@Override
	public String getCipiId() {
		return model.getCipiId();
	}

	/**
	 * Returns the city of this clm najm.
	 *
	 * @return the city of this clm najm
	 */
	@Override
	public String getCity() {
		return model.getCity();
	}

	/**
	 * Returns the custom ID of this clm najm.
	 *
	 * @return the custom ID of this clm najm
	 */
	@Override
	public String getCustomId() {
		return model.getCustomId();
	}

	/**
	 * Returns the english name of this clm najm.
	 *
	 * @return the english name of this clm najm
	 */
	@Override
	public String getEnglishName() {
		return model.getEnglishName();
	}

	/**
	 * Returns the liabiltiy amt of this clm najm.
	 *
	 * @return the liabiltiy amt of this clm najm
	 */
	@Override
	public String getLiabiltiyAmt() {
		return model.getLiabiltiyAmt();
	}

	/**
	 * Returns the liabiltiy perc of this clm najm.
	 *
	 * @return the liabiltiy perc of this clm najm
	 */
	@Override
	public String getLiabiltiyPerc() {
		return model.getLiabiltiyPerc();
	}

	/**
	 * Returns the najm chassis no of this clm najm.
	 *
	 * @return the najm chassis no of this clm najm
	 */
	@Override
	public String getNajmChassisNo() {
		return model.getNajmChassisNo();
	}

	/**
	 * Returns the najm plate no of this clm najm.
	 *
	 * @return the najm plate no of this clm najm
	 */
	@Override
	public String getNajmPlateNo() {
		return model.getNajmPlateNo();
	}

	/**
	 * Returns the najm veh no of this clm najm.
	 *
	 * @return the najm veh no of this clm najm
	 */
	@Override
	public String getNajmVEHNo() {
		return model.getNajmVEHNo();
	}

	/**
	 * Returns the name of this clm najm.
	 *
	 * @return the name of this clm najm
	 */
	@Override
	public String getName() {
		return model.getName();
	}

	/**
	 * Returns the nationality of this clm najm.
	 *
	 * @return the nationality of this clm najm
	 */
	@Override
	public String getNationality() {
		return model.getNationality();
	}

	/**
	 * Returns the phone no of this clm najm.
	 *
	 * @return the phone no of this clm najm
	 */
	@Override
	public String getPhoneNo() {
		return model.getPhoneNo();
	}

	/**
	 * Returns the plate no of this clm najm.
	 *
	 * @return the plate no of this clm najm
	 */
	@Override
	public String getPlateNo() {
		return model.getPlateNo();
	}

	/**
	 * Returns the pol no of this clm najm.
	 *
	 * @return the pol no of this clm najm
	 */
	@Override
	public String getPolNo() {
		return model.getPolNo();
	}

	/**
	 * Returns the primary key of this clm najm.
	 *
	 * @return the primary key of this clm najm
	 */
	@Override
	public com.ejada.atmc.acl.db.service.persistence.CLMNajmPK getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the seq no of this clm najm.
	 *
	 * @return the seq no of this clm najm
	 */
	@Override
	public String getSeqNo() {
		return model.getSeqNo();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the age of this clm najm.
	 *
	 * @param age the age of this clm najm
	 */
	@Override
	public void setAge(String age) {
		model.setAge(age);
	}

	/**
	 * Sets the call dt of this clm najm.
	 *
	 * @param callDt the call dt of this clm najm
	 */
	@Override
	public void setCallDt(String callDt) {
		model.setCallDt(callDt);
	}

	/**
	 * Sets the case no of this clm najm.
	 *
	 * @param caseNo the case no of this clm najm
	 */
	@Override
	public void setCaseNo(String caseNo) {
		model.setCaseNo(caseNo);
	}

	/**
	 * Sets the cause ar of this clm najm.
	 *
	 * @param causeAr the cause ar of this clm najm
	 */
	@Override
	public void setCauseAr(String causeAr) {
		model.setCauseAr(causeAr);
	}

	/**
	 * Sets the cause en of this clm najm.
	 *
	 * @param causeEn the cause en of this clm najm
	 */
	@Override
	public void setCauseEn(String causeEn) {
		model.setCauseEn(causeEn);
	}

	/**
	 * Sets the cipi ID of this clm najm.
	 *
	 * @param cipiId the cipi ID of this clm najm
	 */
	@Override
	public void setCipiId(String cipiId) {
		model.setCipiId(cipiId);
	}

	/**
	 * Sets the city of this clm najm.
	 *
	 * @param city the city of this clm najm
	 */
	@Override
	public void setCity(String city) {
		model.setCity(city);
	}

	/**
	 * Sets the custom ID of this clm najm.
	 *
	 * @param customId the custom ID of this clm najm
	 */
	@Override
	public void setCustomId(String customId) {
		model.setCustomId(customId);
	}

	/**
	 * Sets the english name of this clm najm.
	 *
	 * @param englishName the english name of this clm najm
	 */
	@Override
	public void setEnglishName(String englishName) {
		model.setEnglishName(englishName);
	}

	/**
	 * Sets the liabiltiy amt of this clm najm.
	 *
	 * @param liabiltiyAmt the liabiltiy amt of this clm najm
	 */
	@Override
	public void setLiabiltiyAmt(String liabiltiyAmt) {
		model.setLiabiltiyAmt(liabiltiyAmt);
	}

	/**
	 * Sets the liabiltiy perc of this clm najm.
	 *
	 * @param liabiltiyPerc the liabiltiy perc of this clm najm
	 */
	@Override
	public void setLiabiltiyPerc(String liabiltiyPerc) {
		model.setLiabiltiyPerc(liabiltiyPerc);
	}

	/**
	 * Sets the najm chassis no of this clm najm.
	 *
	 * @param najmChassisNo the najm chassis no of this clm najm
	 */
	@Override
	public void setNajmChassisNo(String najmChassisNo) {
		model.setNajmChassisNo(najmChassisNo);
	}

	/**
	 * Sets the najm plate no of this clm najm.
	 *
	 * @param najmPlateNo the najm plate no of this clm najm
	 */
	@Override
	public void setNajmPlateNo(String najmPlateNo) {
		model.setNajmPlateNo(najmPlateNo);
	}

	/**
	 * Sets the najm veh no of this clm najm.
	 *
	 * @param najmVEHNo the najm veh no of this clm najm
	 */
	@Override
	public void setNajmVEHNo(String najmVEHNo) {
		model.setNajmVEHNo(najmVEHNo);
	}

	/**
	 * Sets the name of this clm najm.
	 *
	 * @param name the name of this clm najm
	 */
	@Override
	public void setName(String name) {
		model.setName(name);
	}

	/**
	 * Sets the nationality of this clm najm.
	 *
	 * @param nationality the nationality of this clm najm
	 */
	@Override
	public void setNationality(String nationality) {
		model.setNationality(nationality);
	}

	/**
	 * Sets the phone no of this clm najm.
	 *
	 * @param phoneNo the phone no of this clm najm
	 */
	@Override
	public void setPhoneNo(String phoneNo) {
		model.setPhoneNo(phoneNo);
	}

	/**
	 * Sets the plate no of this clm najm.
	 *
	 * @param plateNo the plate no of this clm najm
	 */
	@Override
	public void setPlateNo(String plateNo) {
		model.setPlateNo(plateNo);
	}

	/**
	 * Sets the pol no of this clm najm.
	 *
	 * @param polNo the pol no of this clm najm
	 */
	@Override
	public void setPolNo(String polNo) {
		model.setPolNo(polNo);
	}

	/**
	 * Sets the primary key of this clm najm.
	 *
	 * @param primaryKey the primary key of this clm najm
	 */
	@Override
	public void setPrimaryKey(
		com.ejada.atmc.acl.db.service.persistence.CLMNajmPK primaryKey) {

		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the seq no of this clm najm.
	 *
	 * @param seqNo the seq no of this clm najm
	 */
	@Override
	public void setSeqNo(String seqNo) {
		model.setSeqNo(seqNo);
	}

	@Override
	protected CLMNajmWrapper wrap(CLMNajm clmNajm) {
		return new CLMNajmWrapper(clmNajm);
	}

}