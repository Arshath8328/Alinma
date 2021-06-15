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

import com.ejada.atmc.acl.db.service.persistence.CLMNajmPK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the CLMNajm service. Represents a row in the &quot;MDM_CLM_NAJM&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.CLMNajmModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.CLMNajmImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CLMNajm
 * @generated
 */
@ProviderType
public interface CLMNajmModel extends BaseModel<CLMNajm> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a clm najm model instance should use the {@link CLMNajm} interface instead.
	 */

	/**
	 * Returns the primary key of this clm najm.
	 *
	 * @return the primary key of this clm najm
	 */
	public CLMNajmPK getPrimaryKey();

	/**
	 * Sets the primary key of this clm najm.
	 *
	 * @param primaryKey the primary key of this clm najm
	 */
	public void setPrimaryKey(CLMNajmPK primaryKey);

	/**
	 * Returns the case no of this clm najm.
	 *
	 * @return the case no of this clm najm
	 */
	@AutoEscape
	public String getCaseNo();

	/**
	 * Sets the case no of this clm najm.
	 *
	 * @param caseNo the case no of this clm najm
	 */
	public void setCaseNo(String caseNo);

	/**
	 * Returns the cipi ID of this clm najm.
	 *
	 * @return the cipi ID of this clm najm
	 */
	@AutoEscape
	public String getCipiId();

	/**
	 * Sets the cipi ID of this clm najm.
	 *
	 * @param cipiId the cipi ID of this clm najm
	 */
	public void setCipiId(String cipiId);

	/**
	 * Returns the call dt of this clm najm.
	 *
	 * @return the call dt of this clm najm
	 */
	@AutoEscape
	public String getCallDt();

	/**
	 * Sets the call dt of this clm najm.
	 *
	 * @param callDt the call dt of this clm najm
	 */
	public void setCallDt(String callDt);

	/**
	 * Returns the city of this clm najm.
	 *
	 * @return the city of this clm najm
	 */
	@AutoEscape
	public String getCity();

	/**
	 * Sets the city of this clm najm.
	 *
	 * @param city the city of this clm najm
	 */
	public void setCity(String city);

	/**
	 * Returns the name of this clm najm.
	 *
	 * @return the name of this clm najm
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this clm najm.
	 *
	 * @param name the name of this clm najm
	 */
	public void setName(String name);

	/**
	 * Returns the phone no of this clm najm.
	 *
	 * @return the phone no of this clm najm
	 */
	@AutoEscape
	public String getPhoneNo();

	/**
	 * Sets the phone no of this clm najm.
	 *
	 * @param phoneNo the phone no of this clm najm
	 */
	public void setPhoneNo(String phoneNo);

	/**
	 * Returns the age of this clm najm.
	 *
	 * @return the age of this clm najm
	 */
	@AutoEscape
	public String getAge();

	/**
	 * Sets the age of this clm najm.
	 *
	 * @param age the age of this clm najm
	 */
	public void setAge(String age);

	/**
	 * Returns the nationality of this clm najm.
	 *
	 * @return the nationality of this clm najm
	 */
	@AutoEscape
	public String getNationality();

	/**
	 * Sets the nationality of this clm najm.
	 *
	 * @param nationality the nationality of this clm najm
	 */
	public void setNationality(String nationality);

	/**
	 * Returns the plate no of this clm najm.
	 *
	 * @return the plate no of this clm najm
	 */
	@AutoEscape
	public String getPlateNo();

	/**
	 * Sets the plate no of this clm najm.
	 *
	 * @param plateNo the plate no of this clm najm
	 */
	public void setPlateNo(String plateNo);

	/**
	 * Returns the liabiltiy perc of this clm najm.
	 *
	 * @return the liabiltiy perc of this clm najm
	 */
	@AutoEscape
	public String getLiabiltiyPerc();

	/**
	 * Sets the liabiltiy perc of this clm najm.
	 *
	 * @param liabiltiyPerc the liabiltiy perc of this clm najm
	 */
	public void setLiabiltiyPerc(String liabiltiyPerc);

	/**
	 * Returns the liabiltiy amt of this clm najm.
	 *
	 * @return the liabiltiy amt of this clm najm
	 */
	@AutoEscape
	public String getLiabiltiyAmt();

	/**
	 * Sets the liabiltiy amt of this clm najm.
	 *
	 * @param liabiltiyAmt the liabiltiy amt of this clm najm
	 */
	public void setLiabiltiyAmt(String liabiltiyAmt);

	/**
	 * Returns the custom ID of this clm najm.
	 *
	 * @return the custom ID of this clm najm
	 */
	@AutoEscape
	public String getCustomId();

	/**
	 * Sets the custom ID of this clm najm.
	 *
	 * @param customId the custom ID of this clm najm
	 */
	public void setCustomId(String customId);

	/**
	 * Returns the seq no of this clm najm.
	 *
	 * @return the seq no of this clm najm
	 */
	@AutoEscape
	public String getSeqNo();

	/**
	 * Sets the seq no of this clm najm.
	 *
	 * @param seqNo the seq no of this clm najm
	 */
	public void setSeqNo(String seqNo);

	/**
	 * Returns the english name of this clm najm.
	 *
	 * @return the english name of this clm najm
	 */
	@AutoEscape
	public String getEnglishName();

	/**
	 * Sets the english name of this clm najm.
	 *
	 * @param englishName the english name of this clm najm
	 */
	public void setEnglishName(String englishName);

	/**
	 * Returns the pol no of this clm najm.
	 *
	 * @return the pol no of this clm najm
	 */
	@AutoEscape
	public String getPolNo();

	/**
	 * Sets the pol no of this clm najm.
	 *
	 * @param polNo the pol no of this clm najm
	 */
	public void setPolNo(String polNo);

	/**
	 * Returns the najm plate no of this clm najm.
	 *
	 * @return the najm plate no of this clm najm
	 */
	@AutoEscape
	public String getNajmPlateNo();

	/**
	 * Sets the najm plate no of this clm najm.
	 *
	 * @param najmPlateNo the najm plate no of this clm najm
	 */
	public void setNajmPlateNo(String najmPlateNo);

	/**
	 * Returns the najm chassis no of this clm najm.
	 *
	 * @return the najm chassis no of this clm najm
	 */
	@AutoEscape
	public String getNajmChassisNo();

	/**
	 * Sets the najm chassis no of this clm najm.
	 *
	 * @param najmChassisNo the najm chassis no of this clm najm
	 */
	public void setNajmChassisNo(String najmChassisNo);

	/**
	 * Returns the najm veh no of this clm najm.
	 *
	 * @return the najm veh no of this clm najm
	 */
	@AutoEscape
	public String getNajmVEHNo();

	/**
	 * Sets the najm veh no of this clm najm.
	 *
	 * @param najmVEHNo the najm veh no of this clm najm
	 */
	public void setNajmVEHNo(String najmVEHNo);

	/**
	 * Returns the cause ar of this clm najm.
	 *
	 * @return the cause ar of this clm najm
	 */
	@AutoEscape
	public String getCauseAr();

	/**
	 * Sets the cause ar of this clm najm.
	 *
	 * @param causeAr the cause ar of this clm najm
	 */
	public void setCauseAr(String causeAr);

	/**
	 * Returns the cause en of this clm najm.
	 *
	 * @return the cause en of this clm najm
	 */
	@AutoEscape
	public String getCauseEn();

	/**
	 * Sets the cause en of this clm najm.
	 *
	 * @param causeEn the cause en of this clm najm
	 */
	public void setCauseEn(String causeEn);

}