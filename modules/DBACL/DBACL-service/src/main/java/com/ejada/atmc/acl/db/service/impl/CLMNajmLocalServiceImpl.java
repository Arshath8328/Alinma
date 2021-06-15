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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.exception.NoSuchCLMNajmException;
import com.ejada.atmc.acl.db.model.CLMNajm;
import com.ejada.atmc.acl.db.service.base.CLMNajmLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the clm najm local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.CLMNajmLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    CLMNajmLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.CLMNajm",
		service = AopService.class
)
public class CLMNajmLocalServiceImpl extends CLMNajmLocalServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Use <code>com.ejada.atmc.acl.db.service.CLMNajmLocalService</code> via injection
	 * or a <code>org.osgi.util.tracker.ServiceTracker</code> or use
	 * <code>com.ejada.atmc.acl.db.service.CLMNajmLocalServiceUtil</code>.
	 */
	public CLMNajm findByCaseNoEnglishName(String caseNo, String englishName) throws NoSuchCLMNajmException {
		return clmNajmPersistence.findByCASE_NAMEEN(caseNo, englishName);
	}

	public List<CLMNajm> findByCustomId(String customId) {
		return clmNajmPersistence.findByCustomId(customId);
	}

	public List<CLMNajm> findByPlateNumber(String najmPlateNo) {
		return clmNajmPersistence.findByNajmPlateNo(najmPlateNo);
	}
}