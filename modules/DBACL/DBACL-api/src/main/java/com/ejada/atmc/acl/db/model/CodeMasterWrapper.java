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
 * This class is a wrapper for {@link CodeMaster}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see CodeMaster
 * @generated
 */
public class CodeMasterWrapper
	extends BaseModelWrapper<CodeMaster>
	implements CodeMaster, ModelWrapper<CodeMaster> {

	public CodeMasterWrapper(CodeMaster codeMaster) {
		super(codeMaster);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("systemId", getSystemId());
		attributes.put("effFromDate", getEffFromDate());
		attributes.put("effToDate", getEffToDate());
		attributes.put("creationDate", getCreationDate());
		attributes.put("crUid", getCrUid());
		attributes.put("updateDate", getUpdateDate());
		attributes.put("updateUid", getUpdateUid());
		attributes.put("code", getCode());
		attributes.put("codeSub", getCodeSub());
		attributes.put("codeDesc", getCodeDesc());
		attributes.put("codeDescAr", getCodeDescAr());
		attributes.put("codeValue0", getCodeValue0());
		attributes.put("codeValue1", getCodeValue1());
		attributes.put("codeValue2", getCodeValue2());
		attributes.put("codeRef", getCodeRef());
		attributes.put("codeSubRef", getCodeSubRef());
		attributes.put("codeFreezYN", getCodeFreezYN());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long systemId = (Long)attributes.get("systemId");

		if (systemId != null) {
			setSystemId(systemId);
		}

		Date effFromDate = (Date)attributes.get("effFromDate");

		if (effFromDate != null) {
			setEffFromDate(effFromDate);
		}

		Date effToDate = (Date)attributes.get("effToDate");

		if (effToDate != null) {
			setEffToDate(effToDate);
		}

		Date creationDate = (Date)attributes.get("creationDate");

		if (creationDate != null) {
			setCreationDate(creationDate);
		}

		String crUid = (String)attributes.get("crUid");

		if (crUid != null) {
			setCrUid(crUid);
		}

		String updateDate = (String)attributes.get("updateDate");

		if (updateDate != null) {
			setUpdateDate(updateDate);
		}

		Long updateUid = (Long)attributes.get("updateUid");

		if (updateUid != null) {
			setUpdateUid(updateUid);
		}

		String code = (String)attributes.get("code");

		if (code != null) {
			setCode(code);
		}

		String codeSub = (String)attributes.get("codeSub");

		if (codeSub != null) {
			setCodeSub(codeSub);
		}

		String codeDesc = (String)attributes.get("codeDesc");

		if (codeDesc != null) {
			setCodeDesc(codeDesc);
		}

		String codeDescAr = (String)attributes.get("codeDescAr");

		if (codeDescAr != null) {
			setCodeDescAr(codeDescAr);
		}

		String codeValue0 = (String)attributes.get("codeValue0");

		if (codeValue0 != null) {
			setCodeValue0(codeValue0);
		}

		String codeValue1 = (String)attributes.get("codeValue1");

		if (codeValue1 != null) {
			setCodeValue1(codeValue1);
		}

		String codeValue2 = (String)attributes.get("codeValue2");

		if (codeValue2 != null) {
			setCodeValue2(codeValue2);
		}

		String codeRef = (String)attributes.get("codeRef");

		if (codeRef != null) {
			setCodeRef(codeRef);
		}

		String codeSubRef = (String)attributes.get("codeSubRef");

		if (codeSubRef != null) {
			setCodeSubRef(codeSubRef);
		}

		String codeFreezYN = (String)attributes.get("codeFreezYN");

		if (codeFreezYN != null) {
			setCodeFreezYN(codeFreezYN);
		}
	}

	/**
	 * Returns the code of this code master.
	 *
	 * @return the code of this code master
	 */
	@Override
	public String getCode() {
		return model.getCode();
	}

	/**
	 * Returns the code desc of this code master.
	 *
	 * @return the code desc of this code master
	 */
	@Override
	public String getCodeDesc() {
		return model.getCodeDesc();
	}

	/**
	 * Returns the code desc ar of this code master.
	 *
	 * @return the code desc ar of this code master
	 */
	@Override
	public String getCodeDescAr() {
		return model.getCodeDescAr();
	}

	/**
	 * Returns the code freez yn of this code master.
	 *
	 * @return the code freez yn of this code master
	 */
	@Override
	public String getCodeFreezYN() {
		return model.getCodeFreezYN();
	}

	/**
	 * Returns the code ref of this code master.
	 *
	 * @return the code ref of this code master
	 */
	@Override
	public String getCodeRef() {
		return model.getCodeRef();
	}

	/**
	 * Returns the code sub of this code master.
	 *
	 * @return the code sub of this code master
	 */
	@Override
	public String getCodeSub() {
		return model.getCodeSub();
	}

	/**
	 * Returns the code sub ref of this code master.
	 *
	 * @return the code sub ref of this code master
	 */
	@Override
	public String getCodeSubRef() {
		return model.getCodeSubRef();
	}

	/**
	 * Returns the code value0 of this code master.
	 *
	 * @return the code value0 of this code master
	 */
	@Override
	public String getCodeValue0() {
		return model.getCodeValue0();
	}

	/**
	 * Returns the code value1 of this code master.
	 *
	 * @return the code value1 of this code master
	 */
	@Override
	public String getCodeValue1() {
		return model.getCodeValue1();
	}

	/**
	 * Returns the code value2 of this code master.
	 *
	 * @return the code value2 of this code master
	 */
	@Override
	public String getCodeValue2() {
		return model.getCodeValue2();
	}

	/**
	 * Returns the creation date of this code master.
	 *
	 * @return the creation date of this code master
	 */
	@Override
	public Date getCreationDate() {
		return model.getCreationDate();
	}

	/**
	 * Returns the cr uid of this code master.
	 *
	 * @return the cr uid of this code master
	 */
	@Override
	public String getCrUid() {
		return model.getCrUid();
	}

	/**
	 * Returns the eff from date of this code master.
	 *
	 * @return the eff from date of this code master
	 */
	@Override
	public Date getEffFromDate() {
		return model.getEffFromDate();
	}

	/**
	 * Returns the eff to date of this code master.
	 *
	 * @return the eff to date of this code master
	 */
	@Override
	public Date getEffToDate() {
		return model.getEffToDate();
	}

	/**
	 * Returns the primary key of this code master.
	 *
	 * @return the primary key of this code master
	 */
	@Override
	public long getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the system ID of this code master.
	 *
	 * @return the system ID of this code master
	 */
	@Override
	public long getSystemId() {
		return model.getSystemId();
	}

	/**
	 * Returns the update date of this code master.
	 *
	 * @return the update date of this code master
	 */
	@Override
	public String getUpdateDate() {
		return model.getUpdateDate();
	}

	/**
	 * Returns the update uid of this code master.
	 *
	 * @return the update uid of this code master
	 */
	@Override
	public long getUpdateUid() {
		return model.getUpdateUid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the code of this code master.
	 *
	 * @param code the code of this code master
	 */
	@Override
	public void setCode(String code) {
		model.setCode(code);
	}

	/**
	 * Sets the code desc of this code master.
	 *
	 * @param codeDesc the code desc of this code master
	 */
	@Override
	public void setCodeDesc(String codeDesc) {
		model.setCodeDesc(codeDesc);
	}

	/**
	 * Sets the code desc ar of this code master.
	 *
	 * @param codeDescAr the code desc ar of this code master
	 */
	@Override
	public void setCodeDescAr(String codeDescAr) {
		model.setCodeDescAr(codeDescAr);
	}

	/**
	 * Sets the code freez yn of this code master.
	 *
	 * @param codeFreezYN the code freez yn of this code master
	 */
	@Override
	public void setCodeFreezYN(String codeFreezYN) {
		model.setCodeFreezYN(codeFreezYN);
	}

	/**
	 * Sets the code ref of this code master.
	 *
	 * @param codeRef the code ref of this code master
	 */
	@Override
	public void setCodeRef(String codeRef) {
		model.setCodeRef(codeRef);
	}

	/**
	 * Sets the code sub of this code master.
	 *
	 * @param codeSub the code sub of this code master
	 */
	@Override
	public void setCodeSub(String codeSub) {
		model.setCodeSub(codeSub);
	}

	/**
	 * Sets the code sub ref of this code master.
	 *
	 * @param codeSubRef the code sub ref of this code master
	 */
	@Override
	public void setCodeSubRef(String codeSubRef) {
		model.setCodeSubRef(codeSubRef);
	}

	/**
	 * Sets the code value0 of this code master.
	 *
	 * @param codeValue0 the code value0 of this code master
	 */
	@Override
	public void setCodeValue0(String codeValue0) {
		model.setCodeValue0(codeValue0);
	}

	/**
	 * Sets the code value1 of this code master.
	 *
	 * @param codeValue1 the code value1 of this code master
	 */
	@Override
	public void setCodeValue1(String codeValue1) {
		model.setCodeValue1(codeValue1);
	}

	/**
	 * Sets the code value2 of this code master.
	 *
	 * @param codeValue2 the code value2 of this code master
	 */
	@Override
	public void setCodeValue2(String codeValue2) {
		model.setCodeValue2(codeValue2);
	}

	/**
	 * Sets the creation date of this code master.
	 *
	 * @param creationDate the creation date of this code master
	 */
	@Override
	public void setCreationDate(Date creationDate) {
		model.setCreationDate(creationDate);
	}

	/**
	 * Sets the cr uid of this code master.
	 *
	 * @param crUid the cr uid of this code master
	 */
	@Override
	public void setCrUid(String crUid) {
		model.setCrUid(crUid);
	}

	/**
	 * Sets the eff from date of this code master.
	 *
	 * @param effFromDate the eff from date of this code master
	 */
	@Override
	public void setEffFromDate(Date effFromDate) {
		model.setEffFromDate(effFromDate);
	}

	/**
	 * Sets the eff to date of this code master.
	 *
	 * @param effToDate the eff to date of this code master
	 */
	@Override
	public void setEffToDate(Date effToDate) {
		model.setEffToDate(effToDate);
	}

	/**
	 * Sets the primary key of this code master.
	 *
	 * @param primaryKey the primary key of this code master
	 */
	@Override
	public void setPrimaryKey(long primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the system ID of this code master.
	 *
	 * @param systemId the system ID of this code master
	 */
	@Override
	public void setSystemId(long systemId) {
		model.setSystemId(systemId);
	}

	/**
	 * Sets the update date of this code master.
	 *
	 * @param updateDate the update date of this code master
	 */
	@Override
	public void setUpdateDate(String updateDate) {
		model.setUpdateDate(updateDate);
	}

	/**
	 * Sets the update uid of this code master.
	 *
	 * @param updateUid the update uid of this code master
	 */
	@Override
	public void setUpdateUid(long updateUid) {
		model.setUpdateUid(updateUid);
	}

	@Override
	protected CodeMasterWrapper wrap(CodeMaster codeMaster) {
		return new CodeMasterWrapper(codeMaster);
	}

}