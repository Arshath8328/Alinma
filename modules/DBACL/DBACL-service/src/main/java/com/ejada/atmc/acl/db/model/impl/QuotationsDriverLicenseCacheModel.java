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

import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing QuotationsDriverLicense in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class QuotationsDriverLicenseCacheModel
	implements CacheModel<QuotationsDriverLicense>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof QuotationsDriverLicenseCacheModel)) {
			return false;
		}

		QuotationsDriverLicenseCacheModel quotationsDriverLicenseCacheModel =
			(QuotationsDriverLicenseCacheModel)object;

		if (licenseId == quotationsDriverLicenseCacheModel.licenseId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, licenseId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{licenseId=");
		sb.append(licenseId);
		sb.append(", driverId=");
		sb.append(driverId);
		sb.append(", quotationId=");
		sb.append(quotationId);
		sb.append(", LicCountry=");
		sb.append(LicCountry);
		sb.append(", LicType=");
		sb.append(LicType);
		sb.append(", LicYrs=");
		sb.append(LicYrs);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public QuotationsDriverLicense toEntityModel() {
		QuotationsDriverLicenseImpl quotationsDriverLicenseImpl =
			new QuotationsDriverLicenseImpl();

		quotationsDriverLicenseImpl.setLicenseId(licenseId);
		quotationsDriverLicenseImpl.setDriverId(driverId);
		quotationsDriverLicenseImpl.setQuotationId(quotationId);

		if (LicCountry == null) {
			quotationsDriverLicenseImpl.setLicCountry("");
		}
		else {
			quotationsDriverLicenseImpl.setLicCountry(LicCountry);
		}

		if (LicType == null) {
			quotationsDriverLicenseImpl.setLicType("");
		}
		else {
			quotationsDriverLicenseImpl.setLicType(LicType);
		}

		quotationsDriverLicenseImpl.setLicYrs(LicYrs);

		quotationsDriverLicenseImpl.resetOriginalValues();

		return quotationsDriverLicenseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		licenseId = objectInput.readLong();

		driverId = objectInput.readLong();

		quotationId = objectInput.readLong();
		LicCountry = objectInput.readUTF();
		LicType = objectInput.readUTF();

		LicYrs = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		objectOutput.writeLong(licenseId);

		objectOutput.writeLong(driverId);

		objectOutput.writeLong(quotationId);

		if (LicCountry == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LicCountry);
		}

		if (LicType == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(LicType);
		}

		objectOutput.writeInt(LicYrs);
	}

	public long licenseId;
	public long driverId;
	public long quotationId;
	public String LicCountry;
	public String LicType;
	public int LicYrs;

}