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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The extended model interface for the PolicyHDR service. Represents a row in the &quot;ODS_POLICY_HDR&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDRModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl")
@ProviderType
public interface PolicyHDR extends PersistedModel, PolicyHDRModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PolicyHDR, String> POLICY_NO_ACCESSOR =
		new Accessor<PolicyHDR, String>() {

			@Override
			public String get(PolicyHDR policyHDR) {
				return policyHDR.getPolicyNo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PolicyHDR> getTypeClass() {
				return PolicyHDR.class;
			}

		};

	public java.util.List<PolicyVEH> getPolicyVEHs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<PolicyPayment> getPolicyPayments()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<PolicyMemberDetails> getPolicyMembers()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<PolicyVehCvr> getPolicyRiders()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<FundDetails> getPolicyFunds()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<BeneficiaryDetails> getPolicyBenfs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public String getProductDescEn();

	public String getProductDescAr();

	public String getStatusDescEn();

	/**
	 * @return the statusDescAr
	 */
	public String getStatusDescAr();

	public String getModeOfPmntDescEn();

	public String getModeOfPmntDescAr();

}