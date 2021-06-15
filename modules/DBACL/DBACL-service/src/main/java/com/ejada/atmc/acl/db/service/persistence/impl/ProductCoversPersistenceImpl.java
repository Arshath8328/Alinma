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

package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.exception.NoSuchProductCoversException;
import com.ejada.atmc.acl.db.model.ProductCovers;
import com.ejada.atmc.acl.db.model.impl.ProductCoversImpl;
import com.ejada.atmc.acl.db.model.impl.ProductCoversModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversPK;
import com.ejada.atmc.acl.db.service.persistence.ProductCoversPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACLPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import javax.sql.DataSource;

import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Deactivate;
import org.osgi.service.component.annotations.Reference;

/**
 * The persistence implementation for the product covers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductCoversPersistence.class)
public class ProductCoversPersistenceImpl
	extends BasePersistenceImpl<ProductCovers>
	implements ProductCoversPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductCoversUtil</code> to access the product covers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductCoversImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCoverCode;
	private FinderPath _finderPathWithoutPaginationFindByCoverCode;
	private FinderPath _finderPathCountByCoverCode;

	/**
	 * Returns all the product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the matching product coverses
	 */
	@Override
	public List<ProductCovers> findByCoverCode(String coverCode) {
		return findByCoverCode(
			coverCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end) {

		return findByCoverCode(coverCode, start, end, null);
	}

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
	@Override
	public List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return findByCoverCode(coverCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProductCovers> findByCoverCode(
		String coverCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		coverCode = Objects.toString(coverCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCoverCode;
				finderArgs = new Object[] {coverCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCoverCode;
			finderArgs = new Object[] {
				coverCode, start, end, orderByComparator
			};
		}

		List<ProductCovers> list = null;

		if (useFinderCache) {
			list = (List<ProductCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductCovers productCovers : list) {
					if (!coverCode.equals(productCovers.getCoverCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

			boolean bindCoverCode = false;

			if (coverCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_3);
			}
			else {
				bindCoverCode = true;

				sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCoverCode) {
					queryPos.add(coverCode);
				}

				list = (List<ProductCovers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByCoverCode_First(
			String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByCoverCode_First(
			coverCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("coverCode=");
		sb.append(coverCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByCoverCode_First(
		String coverCode, OrderByComparator<ProductCovers> orderByComparator) {

		List<ProductCovers> list = findByCoverCode(
			coverCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByCoverCode_Last(
			String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByCoverCode_Last(
			coverCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("coverCode=");
		sb.append(coverCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByCoverCode_Last(
		String coverCode, OrderByComparator<ProductCovers> orderByComparator) {

		int count = countByCoverCode(coverCode);

		if (count == 0) {
			return null;
		}

		List<ProductCovers> list = findByCoverCode(
			coverCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where coverCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param coverCode the cover code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers[] findByCoverCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		coverCode = Objects.toString(coverCode, "");

		ProductCovers productCovers = findByPrimaryKey(productCoversPK);

		Session session = null;

		try {
			session = openSession();

			ProductCovers[] array = new ProductCoversImpl[3];

			array[0] = getByCoverCode_PrevAndNext(
				session, productCovers, coverCode, orderByComparator, true);

			array[1] = productCovers;

			array[2] = getByCoverCode_PrevAndNext(
				session, productCovers, coverCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductCovers getByCoverCode_PrevAndNext(
		Session session, ProductCovers productCovers, String coverCode,
		OrderByComparator<ProductCovers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

		boolean bindCoverCode = false;

		if (coverCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_3);
		}
		else {
			bindCoverCode = true;

			sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCoverCode) {
			queryPos.add(coverCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productCovers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductCovers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product coverses where coverCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 */
	@Override
	public void removeByCoverCode(String coverCode) {
		for (ProductCovers productCovers :
				findByCoverCode(
					coverCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productCovers);
		}
	}

	/**
	 * Returns the number of product coverses where coverCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @return the number of matching product coverses
	 */
	@Override
	public int countByCoverCode(String coverCode) {
		coverCode = Objects.toString(coverCode, "");

		FinderPath finderPath = _finderPathCountByCoverCode;

		Object[] finderArgs = new Object[] {coverCode};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTCOVERS_WHERE);

			boolean bindCoverCode = false;

			if (coverCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_3);
			}
			else {
				bindCoverCode = true;

				sb.append(_FINDER_COLUMN_COVERCODE_COVERCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCoverCode) {
					queryPos.add(coverCode);
				}

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_COVERCODE_COVERCODE_2 =
		"productCovers.id.coverCode = ?";

	private static final String _FINDER_COLUMN_COVERCODE_COVERCODE_3 =
		"(productCovers.id.coverCode IS NULL OR productCovers.id.coverCode = '')";

	private FinderPath _finderPathWithPaginationFindByProductCode;
	private FinderPath _finderPathWithoutPaginationFindByProductCode;
	private FinderPath _finderPathCountByProductCode;

	/**
	 * Returns all the product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	@Override
	public List<ProductCovers> findByProductCode(long productCode) {
		return findByProductCode(
			productCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProductCovers> findByProductCode(
		long productCode, int start, int end) {

		return findByProductCode(productCode, start, end, null);
	}

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
	@Override
	public List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return findByProductCode(
			productCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProductCovers> findByProductCode(
		long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByProductCode;
				finderArgs = new Object[] {productCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByProductCode;
			finderArgs = new Object[] {
				productCode, start, end, orderByComparator
			};
		}

		List<ProductCovers> list = null;

		if (useFinderCache) {
			list = (List<ProductCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductCovers productCovers : list) {
					if (productCode != productCovers.getProductCode()) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productCode);

				list = (List<ProductCovers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByProductCode_First(
			long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByProductCode_First(
			productCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productCode=");
		sb.append(productCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the first product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByProductCode_First(
		long productCode, OrderByComparator<ProductCovers> orderByComparator) {

		List<ProductCovers> list = findByProductCode(
			productCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByProductCode_Last(
			long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByProductCode_Last(
			productCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("productCode=");
		sb.append(productCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the last product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByProductCode_Last(
		long productCode, OrderByComparator<ProductCovers> orderByComparator) {

		int count = countByProductCode(productCode);

		if (count == 0) {
			return null;
		}

		List<ProductCovers> list = findByProductCode(
			productCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the product coverses before and after the current product covers in the ordered set where productCode = &#63;.
	 *
	 * @param productCoversPK the primary key of the current product covers
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers[] findByProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = findByPrimaryKey(productCoversPK);

		Session session = null;

		try {
			session = openSession();

			ProductCovers[] array = new ProductCoversImpl[3];

			array[0] = getByProductCode_PrevAndNext(
				session, productCovers, productCode, orderByComparator, true);

			array[1] = productCovers;

			array[2] = getByProductCode_PrevAndNext(
				session, productCovers, productCode, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductCovers getByProductCode_PrevAndNext(
		Session session, ProductCovers productCovers, long productCode,
		OrderByComparator<ProductCovers> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

		sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		queryPos.add(productCode);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productCovers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductCovers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product coverses where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 */
	@Override
	public void removeByProductCode(long productCode) {
		for (ProductCovers productCovers :
				findByProductCode(
					productCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(productCovers);
		}
	}

	/**
	 * Returns the number of product coverses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	@Override
	public int countByProductCode(long productCode) {
		FinderPath finderPath = _finderPathCountByProductCode;

		Object[] finderArgs = new Object[] {productCode};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTCOVERS_WHERE);

			sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(productCode);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2 =
		"productCovers.id.productCode = ?";

	private FinderPath _finderPathWithPaginationFindByCoverCodeProductCode;
	private FinderPath _finderPathWithoutPaginationFindByCoverCodeProductCode;
	private FinderPath _finderPathCountByCoverCodeProductCode;

	/**
	 * Returns all the product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the matching product coverses
	 */
	@Override
	public List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode) {

		return findByCoverCodeProductCode(
			coverCode, productCode, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end) {

		return findByCoverCodeProductCode(
			coverCode, productCode, start, end, null);
	}

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
	@Override
	public List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return findByCoverCodeProductCode(
			coverCode, productCode, start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProductCovers> findByCoverCodeProductCode(
		String coverCode, long productCode, int start, int end,
		OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		coverCode = Objects.toString(coverCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath =
					_finderPathWithoutPaginationFindByCoverCodeProductCode;
				finderArgs = new Object[] {coverCode, productCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCoverCodeProductCode;
			finderArgs = new Object[] {
				coverCode, productCode, start, end, orderByComparator
			};
		}

		List<ProductCovers> list = null;

		if (useFinderCache) {
			list = (List<ProductCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ProductCovers productCovers : list) {
					if (!coverCode.equals(productCovers.getCoverCode()) ||
						(productCode != productCovers.getProductCode())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

			boolean bindCoverCode = false;

			if (coverCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_3);
			}
			else {
				bindCoverCode = true;

				sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_2);
			}

			sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_PRODUCTCODE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCoverCode) {
					queryPos.add(coverCode);
				}

				queryPos.add(productCode);

				list = (List<ProductCovers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByCoverCodeProductCode_First(
			String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByCoverCodeProductCode_First(
			coverCode, productCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("coverCode=");
		sb.append(coverCode);

		sb.append(", productCode=");
		sb.append(productCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the first product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByCoverCodeProductCode_First(
		String coverCode, long productCode,
		OrderByComparator<ProductCovers> orderByComparator) {

		List<ProductCovers> list = findByCoverCodeProductCode(
			coverCode, productCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers
	 * @throws NoSuchProductCoversException if a matching product covers could not be found
	 */
	@Override
	public ProductCovers findByCoverCodeProductCode_Last(
			String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByCoverCodeProductCode_Last(
			coverCode, productCode, orderByComparator);

		if (productCovers != null) {
			return productCovers;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("coverCode=");
		sb.append(coverCode);

		sb.append(", productCode=");
		sb.append(productCode);

		sb.append("}");

		throw new NoSuchProductCoversException(sb.toString());
	}

	/**
	 * Returns the last product covers in the ordered set where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching product covers, or <code>null</code> if a matching product covers could not be found
	 */
	@Override
	public ProductCovers fetchByCoverCodeProductCode_Last(
		String coverCode, long productCode,
		OrderByComparator<ProductCovers> orderByComparator) {

		int count = countByCoverCodeProductCode(coverCode, productCode);

		if (count == 0) {
			return null;
		}

		List<ProductCovers> list = findByCoverCodeProductCode(
			coverCode, productCode, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

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
	@Override
	public ProductCovers[] findByCoverCodeProductCode_PrevAndNext(
			ProductCoversPK productCoversPK, String coverCode, long productCode,
			OrderByComparator<ProductCovers> orderByComparator)
		throws NoSuchProductCoversException {

		coverCode = Objects.toString(coverCode, "");

		ProductCovers productCovers = findByPrimaryKey(productCoversPK);

		Session session = null;

		try {
			session = openSession();

			ProductCovers[] array = new ProductCoversImpl[3];

			array[0] = getByCoverCodeProductCode_PrevAndNext(
				session, productCovers, coverCode, productCode,
				orderByComparator, true);

			array[1] = productCovers;

			array[2] = getByCoverCodeProductCode_PrevAndNext(
				session, productCovers, coverCode, productCode,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ProductCovers getByCoverCodeProductCode_PrevAndNext(
		Session session, ProductCovers productCovers, String coverCode,
		long productCode, OrderByComparator<ProductCovers> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_PRODUCTCOVERS_WHERE);

		boolean bindCoverCode = false;

		if (coverCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_3);
		}
		else {
			bindCoverCode = true;

			sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_2);
		}

		sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_PRODUCTCODE_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(ProductCoversModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCoverCode) {
			queryPos.add(coverCode);
		}

		queryPos.add(productCode);

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						productCovers)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ProductCovers> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the product coverses where coverCode = &#63; and productCode = &#63; from the database.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 */
	@Override
	public void removeByCoverCodeProductCode(
		String coverCode, long productCode) {

		for (ProductCovers productCovers :
				findByCoverCodeProductCode(
					coverCode, productCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(productCovers);
		}
	}

	/**
	 * Returns the number of product coverses where coverCode = &#63; and productCode = &#63;.
	 *
	 * @param coverCode the cover code
	 * @param productCode the product code
	 * @return the number of matching product coverses
	 */
	@Override
	public int countByCoverCodeProductCode(String coverCode, long productCode) {
		coverCode = Objects.toString(coverCode, "");

		FinderPath finderPath = _finderPathCountByCoverCodeProductCode;

		Object[] finderArgs = new Object[] {coverCode, productCode};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_PRODUCTCOVERS_WHERE);

			boolean bindCoverCode = false;

			if (coverCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_3);
			}
			else {
				bindCoverCode = true;

				sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_2);
			}

			sb.append(_FINDER_COLUMN_COVERCODEPRODUCTCODE_PRODUCTCODE_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCoverCode) {
					queryPos.add(coverCode);
				}

				queryPos.add(productCode);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String
		_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_2 =
			"productCovers.id.coverCode = ? AND ";

	private static final String
		_FINDER_COLUMN_COVERCODEPRODUCTCODE_COVERCODE_3 =
			"(productCovers.id.coverCode IS NULL OR productCovers.id.coverCode = '') AND ";

	private static final String
		_FINDER_COLUMN_COVERCODEPRODUCTCODE_PRODUCTCODE_2 =
			"productCovers.id.productCode = ?";

	public ProductCoversPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("productCode", "MDM_PROD_CODE");
		dbColumnNames.put("sectionCode", "MDM_SEC_CODE");
		dbColumnNames.put("coverCode", "MDM_CVR_CODE");
		dbColumnNames.put("coverName", "MDM_CVR_NAME");
		dbColumnNames.put("coverNameAr", "MDM_CVR_NAME_AR");
		dbColumnNames.put("coverDesc", "MDM_CVR_DESC");
		dbColumnNames.put("coverDescAr", "MDM_CVR_DESC_AR");
		dbColumnNames.put("coverPremium", "MDM_PREMIUM");
		dbColumnNames.put("coverFld1", "MDM_FIELD_1");
		dbColumnNames.put("coverFld2", "MDM_FIELD_2");
		dbColumnNames.put("coverFld3", "MDM_FIELD_3");
		dbColumnNames.put("coverFld4", "MDM_FIELD_4");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductCovers.class);

		setModelImplClass(ProductCoversImpl.class);
		setModelPKClass(ProductCoversPK.class);
	}

	/**
	 * Caches the product covers in the entity cache if it is enabled.
	 *
	 * @param productCovers the product covers
	 */
	@Override
	public void cacheResult(ProductCovers productCovers) {
		dummyEntityCache.putResult(
			ProductCoversImpl.class, productCovers.getPrimaryKey(),
			productCovers);
	}

	/**
	 * Caches the product coverses in the entity cache if it is enabled.
	 *
	 * @param productCoverses the product coverses
	 */
	@Override
	public void cacheResult(List<ProductCovers> productCoverses) {
		for (ProductCovers productCovers : productCoverses) {
			if (dummyEntityCache.getResult(
					ProductCoversImpl.class, productCovers.getPrimaryKey()) ==
						null) {

				cacheResult(productCovers);
			}
		}
	}

	/**
	 * Clears the cache for all product coverses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ProductCoversImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product covers.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductCovers productCovers) {
		dummyEntityCache.removeResult(ProductCoversImpl.class, productCovers);
	}

	@Override
	public void clearCache(List<ProductCovers> productCoverses) {
		for (ProductCovers productCovers : productCoverses) {
			dummyEntityCache.removeResult(
				ProductCoversImpl.class, productCovers);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ProductCoversImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new product covers with the primary key. Does not add the product covers to the database.
	 *
	 * @param productCoversPK the primary key for the new product covers
	 * @return the new product covers
	 */
	@Override
	public ProductCovers create(ProductCoversPK productCoversPK) {
		ProductCovers productCovers = new ProductCoversImpl();

		productCovers.setNew(true);
		productCovers.setPrimaryKey(productCoversPK);

		return productCovers;
	}

	/**
	 * Removes the product covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers that was removed
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers remove(ProductCoversPK productCoversPK)
		throws NoSuchProductCoversException {

		return remove((Serializable)productCoversPK);
	}

	/**
	 * Removes the product covers with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product covers
	 * @return the product covers that was removed
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers remove(Serializable primaryKey)
		throws NoSuchProductCoversException {

		Session session = null;

		try {
			session = openSession();

			ProductCovers productCovers = (ProductCovers)session.get(
				ProductCoversImpl.class, primaryKey);

			if (productCovers == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductCoversException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productCovers);
		}
		catch (NoSuchProductCoversException noSuchEntityException) {
			throw noSuchEntityException;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected ProductCovers removeImpl(ProductCovers productCovers) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productCovers)) {
				productCovers = (ProductCovers)session.get(
					ProductCoversImpl.class, productCovers.getPrimaryKeyObj());
			}

			if (productCovers != null) {
				session.delete(productCovers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productCovers != null) {
			clearCache(productCovers);
		}

		return productCovers;
	}

	@Override
	public ProductCovers updateImpl(ProductCovers productCovers) {
		boolean isNew = productCovers.isNew();

		if (!(productCovers instanceof ProductCoversModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productCovers.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productCovers);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productCovers proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductCovers implementation " +
					productCovers.getClass());
		}

		ProductCoversModelImpl productCoversModelImpl =
			(ProductCoversModelImpl)productCovers;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productCovers);
			}
			else {
				productCovers = (ProductCovers)session.merge(productCovers);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ProductCoversImpl.class, productCoversModelImpl, false, true);

		if (isNew) {
			productCovers.setNew(false);
		}

		productCovers.resetOriginalValues();

		return productCovers;
	}

	/**
	 * Returns the product covers with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product covers
	 * @return the product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductCoversException {

		ProductCovers productCovers = fetchByPrimaryKey(primaryKey);

		if (productCovers == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductCoversException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productCovers;
	}

	/**
	 * Returns the product covers with the primary key or throws a <code>NoSuchProductCoversException</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers
	 * @throws NoSuchProductCoversException if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers findByPrimaryKey(ProductCoversPK productCoversPK)
		throws NoSuchProductCoversException {

		return findByPrimaryKey((Serializable)productCoversPK);
	}

	/**
	 * Returns the product covers with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param productCoversPK the primary key of the product covers
	 * @return the product covers, or <code>null</code> if a product covers with the primary key could not be found
	 */
	@Override
	public ProductCovers fetchByPrimaryKey(ProductCoversPK productCoversPK) {
		return fetchByPrimaryKey((Serializable)productCoversPK);
	}

	/**
	 * Returns all the product coverses.
	 *
	 * @return the product coverses
	 */
	@Override
	public List<ProductCovers> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ProductCovers> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ProductCovers> findAll(
		int start, int end,
		OrderByComparator<ProductCovers> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<ProductCovers> findAll(
		int start, int end, OrderByComparator<ProductCovers> orderByComparator,
		boolean useFinderCache) {

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindAll;
				finderArgs = FINDER_ARGS_EMPTY;
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindAll;
			finderArgs = new Object[] {start, end, orderByComparator};
		}

		List<ProductCovers> list = null;

		if (useFinderCache) {
			list = (List<ProductCovers>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTCOVERS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTCOVERS;

				sql = sql.concat(ProductCoversModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductCovers>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					dummyFinderCache.putResult(finderPath, finderArgs, list);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the product coverses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductCovers productCovers : findAll()) {
			remove(productCovers);
		}
	}

	/**
	 * Returns the number of product coverses.
	 *
	 * @return the number of product coverses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTCOVERS);

				count = (Long)query.uniqueResult();

				dummyFinderCache.putResult(
					_finderPathCountAll, FINDER_ARGS_EMPTY, count);
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	public Set<String> getCompoundPKColumnNames() {
		return _compoundPKColumnNames;
	}

	@Override
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "productCoversPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTCOVERS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductCoversModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product covers persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ProductCoversModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ProductCovers.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCoverCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCoverCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"MDM_CVR_CODE"}, true);

		_finderPathWithoutPaginationFindByCoverCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCoverCode",
			new String[] {String.class.getName()},
			new String[] {"MDM_CVR_CODE"}, true);

		_finderPathCountByCoverCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCoverCode",
			new String[] {String.class.getName()},
			new String[] {"MDM_CVR_CODE"}, false);

		_finderPathWithPaginationFindByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByProductCode",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"MDM_PROD_CODE"}, true);

		_finderPathWithoutPaginationFindByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByProductCode",
			new String[] {Long.class.getName()}, new String[] {"MDM_PROD_CODE"},
			true);

		_finderPathCountByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductCode",
			new String[] {Long.class.getName()}, new String[] {"MDM_PROD_CODE"},
			false);

		_finderPathWithPaginationFindByCoverCodeProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByCoverCodeProductCode",
			new String[] {
				String.class.getName(), Long.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"MDM_CVR_CODE", "MDM_PROD_CODE"}, true);

		_finderPathWithoutPaginationFindByCoverCodeProductCode =
			_createFinderPath(
				FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
				"findByCoverCodeProductCode",
				new String[] {String.class.getName(), Long.class.getName()},
				new String[] {"MDM_CVR_CODE", "MDM_PROD_CODE"}, true);

		_finderPathCountByCoverCodeProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCoverCodeProductCode",
			new String[] {String.class.getName(), Long.class.getName()},
			new String[] {"MDM_CVR_CODE", "MDM_PROD_CODE"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(ProductCoversImpl.class.getName());

		_argumentsResolverServiceRegistration.unregister();

		for (ServiceRegistration<FinderPath> serviceRegistration :
				_serviceRegistrations) {

			serviceRegistration.unregister();
		}
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.SERVICE_CONFIGURATION_FILTER,
		unbind = "-"
	)
	public void setConfiguration(Configuration configuration) {
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setDataSource(DataSource dataSource) {
		super.setDataSource(dataSource);
	}

	@Override
	@Reference(
		target = DBACLPersistenceConstants.ORIGIN_BUNDLE_SYMBOLIC_NAME_FILTER,
		unbind = "-"
	)
	public void setSessionFactory(SessionFactory sessionFactory) {
		super.setSessionFactory(sessionFactory);
	}

	private BundleContext _bundleContext;

	private static final String _SQL_SELECT_PRODUCTCOVERS =
		"SELECT productCovers FROM ProductCovers productCovers";

	private static final String _SQL_SELECT_PRODUCTCOVERS_WHERE =
		"SELECT productCovers FROM ProductCovers productCovers WHERE ";

	private static final String _SQL_COUNT_PRODUCTCOVERS =
		"SELECT COUNT(productCovers) FROM ProductCovers productCovers";

	private static final String _SQL_COUNT_PRODUCTCOVERS_WHERE =
		"SELECT COUNT(productCovers) FROM ProductCovers productCovers WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productCovers.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductCovers exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductCovers exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductCoversPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"productCode", "sectionCode", "coverCode", "coverName",
			"coverNameAr", "coverDesc", "coverDescAr", "coverPremium",
			"coverFld1", "coverFld2", "coverFld3", "coverFld4"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"productCode", "sectionCode", "coverCode"});

	private FinderPath _createFinderPath(
		String cacheName, String methodName, String[] params,
		String[] columnNames, boolean baseModelResult) {

		FinderPath finderPath = new FinderPath(
			cacheName, methodName, params, columnNames, baseModelResult);

		if (!cacheName.equals(FINDER_CLASS_NAME_LIST_WITH_PAGINATION)) {
			_serviceRegistrations.add(
				_bundleContext.registerService(
					FinderPath.class, finderPath,
					MapUtil.singletonDictionary("cache.name", cacheName)));
		}

		return finderPath;
	}

	private Set<ServiceRegistration<FinderPath>> _serviceRegistrations =
		new HashSet<>();
	private ServiceRegistration<ArgumentsResolver>
		_argumentsResolverServiceRegistration;

	private static class ProductCoversModelArgumentsResolver
		implements ArgumentsResolver {

		@Override
		public Object[] getArguments(
			FinderPath finderPath, BaseModel<?> baseModel, boolean checkColumn,
			boolean original) {

			String[] columnNames = finderPath.getColumnNames();

			if ((columnNames == null) || (columnNames.length == 0)) {
				if (baseModel.isNew()) {
					return FINDER_ARGS_EMPTY;
				}

				return null;
			}

			ProductCoversModelImpl productCoversModelImpl =
				(ProductCoversModelImpl)baseModel;

			long columnBitmask = productCoversModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(productCoversModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						productCoversModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(productCoversModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ProductCoversModelImpl productCoversModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						productCoversModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = productCoversModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}