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
 * The extended model interface for the PolicyVEH service. Represents a row in the &quot;ODS_POLICY_VEH&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see PolicyVEHModel
 * @generated
 */
@ImplementationClassName("com.ejada.atmc.acl.db.model.impl.PolicyVEHImpl")
@ProviderType
public interface PolicyVEH extends PersistedModel, PolicyVEHModel {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to <code>com.ejada.atmc.acl.db.model.impl.PolicyVEHImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<PolicyVEH, String> POLICY_NO_ACCESSOR =
		new Accessor<PolicyVEH, String>() {

			@Override
			public String get(PolicyVEH policyVEH) {
				return policyVEH.getPolicyNo();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PolicyVEH> getTypeClass() {
				return PolicyVEH.class;
			}

		};
	public static final Accessor<PolicyVEH, String> VEH_ID_ACCESSOR =
		new Accessor<PolicyVEH, String>() {

			@Override
			public String get(PolicyVEH policyVEH) {
				return policyVEH.getVehId();
			}

			@Override
			public Class<String> getAttributeClass() {
				return String.class;
			}

			@Override
			public Class<PolicyVEH> getTypeClass() {
				return PolicyVEH.class;
			}

		};

	public java.util.List<PolicyVehDrv> getVehDrivs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<PolicyVehCvr> getVehCvrs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<PolicyVEH> getPolicyVEHs()
		throws com.liferay.portal.kernel.exception.PortalException,
			   com.liferay.portal.kernel.exception.SystemException;

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getMakeDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getModelDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getModelDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getBodyTypeDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getColorDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getUseOfVehicleDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getUseOfVehicleDescAr();

	/**
	 * @return String
	 * @see
	 */
	public String getNajmPlateTypeDescEn();

	/**
	 * @return String
	 * @see
	 */
	public String getNajmPlateTypeDescAr();

	public String getVehicleDefTypeDescEn();

	public String getVehicleDefTypeDescAr();

}