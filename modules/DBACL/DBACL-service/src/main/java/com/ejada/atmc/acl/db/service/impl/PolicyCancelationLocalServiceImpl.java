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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyCancelationException;
import com.ejada.atmc.acl.db.model.PolicyCancelation;
import com.ejada.atmc.acl.db.service.PolicyCancelationLocalServiceUtil;
import com.ejada.atmc.acl.db.service.base.PolicyCancelationLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.sql.SQLException;
import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the policy cancelation local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.PolicyCancelationLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    PolicyCancelationLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.PolicyCancelation",
		service = AopService.class
)
public class PolicyCancelationLocalServiceImpl extends PolicyCancelationLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * com.ejada.atmc.acl.db.service.PolicyCancelationLocalServiceUtil} to access the policy cancelation local service.
	 */
	public PolicyCancelation findByPolicyNum(String policyNumber) throws NoSuchPolicyCancelationException {
		return policyCancelationPersistence.findBypolicyNum(policyNumber);

	}

	/* cancle Policy Changes */
	public byte[] findIbanFile(String policyNumber) throws NoSuchPolicyCancelationException {
		PolicyCancelation ibanFile = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
		byte[] ibanFilebyt;
		try {
			ibanFilebyt = ibanFile.getIbanImage().getBytes(1, (int) ibanFile.getIbanImage().length());
			return ibanFilebyt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public byte[] findValidFile(String policyNumber) throws NoSuchPolicyCancelationException {
		PolicyCancelation validFile = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
		byte[] validFilebyt;
		try {
			validFilebyt = validFile.getValidFile().getBytes(1, (int) validFile.getValidFile().length());
			return validFilebyt;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}

	}

	public List<PolicyCancelation> statusAll(String status) throws NoSuchPolicyCancelationException {
		return policyCancelationPersistence.findBystatusAll(status);

	}

	public PolicyCancelation status(String status) throws NoSuchPolicyCancelationException {
		return policyCancelationPersistence.findBystatus(status);

	}

	public List<PolicyCancelation> findByInsuredId(String id) throws NoSuchPolicyCancelationException {
		return policyCancelationPersistence.findByinsuredId(id);
	}

}