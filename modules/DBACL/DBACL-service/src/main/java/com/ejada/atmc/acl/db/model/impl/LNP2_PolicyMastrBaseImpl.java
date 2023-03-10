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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.LNP2_PolicyMastr;
import com.ejada.atmc.acl.db.service.LNP2_PolicyMastrLocalServiceUtil;

/**
 * The extended model base implementation for the LNP2_PolicyMastr service. Represents a row in the &quot;LNP2_POLICYMASTR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This class exists only as a container for the default extended model level methods generated by ServiceBuilder. Helper methods and all application logic should be put in {@link LNP2_PolicyMastrImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastrImpl
 * @see LNP2_PolicyMastr
 * @generated
 */
public abstract class LNP2_PolicyMastrBaseImpl
	extends LNP2_PolicyMastrModelImpl implements LNP2_PolicyMastr {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a lnp2_ policy mastr model instance should use the <code>LNP2_PolicyMastr</code> interface instead.
	 */
	@Override
	public void persist() {
		if (this.isNew()) {
			LNP2_PolicyMastrLocalServiceUtil.addLNP2_PolicyMastr(this);
		}
		else {
			LNP2_PolicyMastrLocalServiceUtil.updateLNP2_PolicyMastr(this);
		}
	}

}