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

package com.ejada.atmc.acl.db.service.persistence;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;

import java.io.Serializable;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class ProductCoversPK
	implements Comparable<ProductCoversPK>, Serializable {

	public long productCode;
	public long sectionCode;
	public String coverCode;

	public ProductCoversPK() {
	}

	public ProductCoversPK(
		long productCode, long sectionCode, String coverCode) {

		this.productCode = productCode;
		this.sectionCode = sectionCode;
		this.coverCode = coverCode;
	}

	public long getProductCode() {
		return productCode;
	}

	public void setProductCode(long productCode) {
		this.productCode = productCode;
	}

	public long getSectionCode() {
		return sectionCode;
	}

	public void setSectionCode(long sectionCode) {
		this.sectionCode = sectionCode;
	}

	public String getCoverCode() {
		return coverCode;
	}

	public void setCoverCode(String coverCode) {
		this.coverCode = coverCode;
	}

	@Override
	public int compareTo(ProductCoversPK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		if (productCode < pk.productCode) {
			value = -1;
		}
		else if (productCode > pk.productCode) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		if (sectionCode < pk.sectionCode) {
			value = -1;
		}
		else if (sectionCode > pk.sectionCode) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		value = coverCode.compareTo(pk.coverCode);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof ProductCoversPK)) {
			return false;
		}

		ProductCoversPK pk = (ProductCoversPK)object;

		if ((productCode == pk.productCode) &&
			(sectionCode == pk.sectionCode) && coverCode.equals(pk.coverCode)) {

			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		int hashCode = 0;

		hashCode = HashUtil.hash(hashCode, productCode);
		hashCode = HashUtil.hash(hashCode, sectionCode);
		hashCode = HashUtil.hash(hashCode, coverCode);

		return hashCode;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(8);

		sb.append("{");

		sb.append("productCode=");

		sb.append(productCode);
		sb.append(", sectionCode=");

		sb.append(sectionCode);
		sb.append(", coverCode=");

		sb.append(coverCode);

		sb.append("}");

		return sb.toString();
	}

}