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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the QuotationsSeq service. Represents a row in the &quot;EJD_QUOTATIONS_SEQ&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.QuotationsSeqImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationsSeq
 * @generated
 */
@ProviderType
public interface QuotationsSeqModel extends BaseModel<QuotationsSeq> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a quotations seq model instance should use the {@link QuotationsSeq} interface instead.
	 */

	/**
	 * Returns the primary key of this quotations seq.
	 *
	 * @return the primary key of this quotations seq
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this quotations seq.
	 *
	 * @param primaryKey the primary key of this quotations seq
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the key of this quotations seq.
	 *
	 * @return the key of this quotations seq
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this quotations seq.
	 *
	 * @param key the key of this quotations seq
	 */
	public void setKey(String key);

	/**
	 * Returns the value of this quotations seq.
	 *
	 * @return the value of this quotations seq
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this quotations seq.
	 *
	 * @param value the value of this quotations seq
	 */
	public void setValue(String value);

}