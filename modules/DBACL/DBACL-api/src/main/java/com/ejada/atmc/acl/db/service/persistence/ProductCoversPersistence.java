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

import com.ejada.atmc.acl.db.exception.NoSuchProductCoversException;
import com.ejada.atmc.acl.db.model.ProductCovers;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import java.util.Set;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The persistence interface for the product covers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see ProductCoversUtil
 * @generated
 */
@ProviderType
public interface ProductCoversPersistence
	extends BasePersistence<ProductCovers> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ProductCoversUtil} to access the product covers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	 * Returns all the product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCode(String coverCode);

	/**
	 * Returns a range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end);

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByCoverCode_First(
			String coverCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByCoverCode_First(
		String coverCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByCoverCode_Last(
			String coverCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByCoverCode_Last(
		String coverCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public ProductCovers[] findByCoverCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Removes all the product coverses where coverCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 */
	public void removeByCoverCode(String coverCode);

	/**
	 * Returns the number of product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the number of matching product coverses
	 */
	public int countByCoverCode(String coverCode);

	/**
	 * Returns all the product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	public java.util.List<ProductCovers> findByProductCode(long productCode);

	/**
	 * Returns a range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByProductCode(
		long productCode, int start, int end);

	/**
	 * Returns an ordered range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product coverses where productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByProductCode_First(
			long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByProductCode_First(
		long productCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByProductCode_Last(
			long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByProductCode_Last(
		long productCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public ProductCovers[] findByProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Removes all the product coverses where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 */
	public void removeByProductCode(long productCode);

	/**
	 * Returns the number of product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	public int countByProductCode(long productCode);

	/**
	 * Returns all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode);

	/**
	 * Returns a range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end);

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching product coverses
	 */
	public java.util.List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByCoverCodeProductCode_First(
			String coverCode, long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByCoverCodeProductCode_First(
		String coverCode, long productCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	public ProductCovers findByCoverCodeProductCode_Last(
			String coverCode, long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	public ProductCovers fetchByCoverCodeProductCode_Last(
		String coverCode, long productCode,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public ProductCovers[] findByCoverCodeProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode, long productCode,
			com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
				orderByComparator)
		throws NoSuchProductCoversException;

	/**
	 * Removes all the product coverses where coverCode = &#63; and productCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 */
	public void removeByCoverCodeProductCode(
		String coverCode, long productCode);

	/**
	 * Returns the number of product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	public int countByCoverCodeProductCode(String coverCode, long productCode);

	/**
	 * Caches the product covers in the entity cache if it is enabled.
	 *
	 * @param productCovers the product covers
	 */
	public void cacheResult(ProductCovers productCovers);

	/**
	 * Caches the product coverses in the entity cache if it is enabled.
	 *
	 * @param productCoverses the product coverses
	 */
	public void cacheResult(java.util.List<ProductCovers> productCoverses);

	/**
	 * Creates a new product covers with the primary key. Does not add the product covers to the database.
	 *
	 * @param productCoversPK the primary key for the new product covers
	 * @return the new product covers
	 */
	public ProductCovers create(ProductCoversPK productCoversPK);

	/**
	 * Removes the product covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers that was removed
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public ProductCovers remove(ProductCoversPK productCoversPK)
		throws NoSuchProductCoversException;

	public ProductCovers updateImpl(ProductCovers productCovers);

	/**
	 * Returns the product covers with the primary key or throws a <code>NoSuchProductCoversException</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	public ProductCovers findByPrimaryKey(ProductCoversPK productCoversPK)
		throws NoSuchProductCoversException;

	/**
	 * Returns the product covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers, or <code>null</code> if a product covers with the primary key could not be found
	 */
	public ProductCovers fetchByPrimaryKey(ProductCoversPK productCoversPK);

	/**
	 * Returns all the product coverses.
	 *
	 * @return the product coverses
	 */
	public java.util.List<ProductCovers> findAll();

	/**
	 * Returns a range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @return the range of product coverses
	 */
	public java.util.List<ProductCovers> findAll(int start, int end);

	/**
	 * Returns an ordered range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product coverses
	 */
	public java.util.List<ProductCovers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator);

	/**
	 * Returns an ordered range of all the product coverses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductCoversModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product coverses
	 * @param end the upper bound of the range of product coverses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product coverses
	 */
	public java.util.List<ProductCovers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<ProductCovers>
			orderByComparator,
		boolean useFinderCache);

	/**
	 * Removes all the product coverses from the database.
	 */
	public void removeAll();

	/**
	 * Returns the number of product coverses.
	 *
	 * @return the number of product coverses
	 */
	public int countAll();

	public Set<String> getCompoundPKColumnNames();

}