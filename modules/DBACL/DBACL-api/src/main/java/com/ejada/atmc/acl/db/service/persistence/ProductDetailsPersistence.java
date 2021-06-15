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

import com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException;
import com.ejada.atmc.acl.db.model.ProductDetails;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductDetailsUtil
 * @generated
 */
@ProviderType
public interface ProductDetailsPersistence
	extends BasePersistence<ProductDetails> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductDetailsUtil} to access the product details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns the product details where productCode = &#63; or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product details
	 * @throws NoSuchProductDetailsException if a matching product details could not be found
	 */
	public ProductDetails findByProductCode(String productCode)
		throws NoSuchProductDetailsException;

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	public ProductDetails fetchByProductCode(String productCode);

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	public ProductDetails fetchByProductCode(
		String productCode, boolean useFinderCache);

	/**
	 * Removes the product details where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product details that was removed
	 */
	public ProductDetails removeByProductCode(String productCode)
		throws NoSuchProductDetailsException;

	/**
	 * Returns the number of product detailses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product detailses
	 */
	public int countByProductCode(String productCode);

	/**
	 * Caches the product details in the entity cache if it is enabled.
	 *
	 * @param productDetails the product details
	 */
	public void cacheResult(ProductDetails productDetails);

	/**
	 * Caches the product detailses in the entity cache if it is enabled.
	 *
	 * @param productDetailses the product detailses
	 */
	public void cacheResult(java.util.List<ProductDetails> productDetailses);

	/**
	 * Creates a new product details with the primary key. Does not add the product details to the database.
	 *
	 * @param sysId the primary key for the new product details
	 * @return the new product details
	 */
	public ProductDetails create(long sysId);

	/**
	 * Removes the product details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details that was removed
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	public ProductDetails remove(long sysId)
		throws NoSuchProductDetailsException;

	public ProductDetails updateImpl(ProductDetails productDetails);

	/**
	 * Returns the product details with the primary key or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	public ProductDetails findByPrimaryKey(long sysId)
		throws NoSuchProductDetailsException;

	/**
	 * Returns the product details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details, or <code>null</code> if a product details with the primary key could not be found
	 */
	public ProductDetails fetchByPrimaryKey(long sysId);

	/**
	 * Returns all the product detailses.
	 *
	 * @return the product detailses
	 */
	public java.util.List<ProductDetails> findAll();

	/**
	 * Returns a range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @return the range of product detailses
	 */
	public java.util.List<ProductDetails> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product detailses
	 */
	public java.util.List<ProductDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductDetails>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product detailses
	 */
	public java.util.List<ProductDetails> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductDetails>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product detailses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product detailses.
	 *
	 * @return the number of product detailses
	 */
	public int countAll();

}