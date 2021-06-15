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

import com.ejada.atmc.acl.db.exception.NoSuchCustomerMapException;
import com.ejada.atmc.acl.db.model.CustomerMap;
import com.ejada.atmc.acl.db.model.impl.CustomerMapImpl;
import com.ejada.atmc.acl.db.model.impl.CustomerMapModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CustomerMapPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACLPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
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
 * The persistence implementation for the customer map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomerMapPersistence.class)
public class CustomerMapPersistenceImpl
	extends BasePersistenceImpl<CustomerMap> implements CustomerMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomerMapUtil</code> to access the customer map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomerMapImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCatgAndType;
	private FinderPath _finderPathWithoutPaginationFindByCatgAndType;
	private FinderPath _finderPathCountByCatgAndType;

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgAndType(
		String custCatg, String custType) {

		return findByCatgAndType(
			custCatg, custType, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end) {

		return findByCatgAndType(custCatg, custType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator) {

		return findByCatgAndType(
			custCatg, custType, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgAndType(
		String custCatg, String custType, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator,
		boolean useFinderCache) {

		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCatgAndType;
				finderArgs = new Object[] {custCatg, custType};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCatgAndType;
			finderArgs = new Object[] {
				custCatg, custType, start, end, orderByComparator
			};
		}

		List<CustomerMap> list = null;

		if (useFinderCache) {
			list = (List<CustomerMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomerMap customerMap : list) {
					if (!custCatg.equals(customerMap.getCustCatg()) ||
						!custType.equals(customerMap.getCustType())) {

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

			sb.append(_SQL_SELECT_CUSTOMERMAP_WHERE);

			boolean bindCustCatg = false;

			if (custCatg.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_3);
			}
			else {
				bindCustCatg = true;

				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_2);
			}

			boolean bindCustType = false;

			if (custType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_3);
			}
			else {
				bindCustType = true;

				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustCatg) {
					queryPos.add(custCatg);
				}

				if (bindCustType) {
					queryPos.add(custType);
				}

				list = (List<CustomerMap>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	@Override
	public CustomerMap findByCatgAndType_First(
			String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		CustomerMap customerMap = fetchByCatgAndType_First(
			custCatg, custType, orderByComparator);

		if (customerMap != null) {
			return customerMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("custCatg=");
		sb.append(custCatg);

		sb.append(", custType=");
		sb.append(custType);

		sb.append("}");

		throw new NoSuchCustomerMapException(sb.toString());
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	@Override
	public CustomerMap fetchByCatgAndType_First(
		String custCatg, String custType,
		OrderByComparator<CustomerMap> orderByComparator) {

		List<CustomerMap> list = findByCatgAndType(
			custCatg, custType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	@Override
	public CustomerMap findByCatgAndType_Last(
			String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		CustomerMap customerMap = fetchByCatgAndType_Last(
			custCatg, custType, orderByComparator);

		if (customerMap != null) {
			return customerMap;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("custCatg=");
		sb.append(custCatg);

		sb.append(", custType=");
		sb.append(custType);

		sb.append("}");

		throw new NoSuchCustomerMapException(sb.toString());
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	@Override
	public CustomerMap fetchByCatgAndType_Last(
		String custCatg, String custType,
		OrderByComparator<CustomerMap> orderByComparator) {

		int count = countByCatgAndType(custCatg, custType);

		if (count == 0) {
			return null;
		}

		List<CustomerMap> list = findByCatgAndType(
			custCatg, custType, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customer maps before and after the current customer map in the ordered set where custCatg = &#63; and custType = &#63;.
	 *
	 * @param refCode the primary key of the current customer map
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap[] findByCatgAndType_PrevAndNext(
			String refCode, String custCatg, String custType,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");

		CustomerMap customerMap = findByPrimaryKey(refCode);

		Session session = null;

		try {
			session = openSession();

			CustomerMap[] array = new CustomerMapImpl[3];

			array[0] = getByCatgAndType_PrevAndNext(
				session, customerMap, custCatg, custType, orderByComparator,
				true);

			array[1] = customerMap;

			array[2] = getByCatgAndType_PrevAndNext(
				session, customerMap, custCatg, custType, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CustomerMap getByCatgAndType_PrevAndNext(
		Session session, CustomerMap customerMap, String custCatg,
		String custType, OrderByComparator<CustomerMap> orderByComparator,
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

		sb.append(_SQL_SELECT_CUSTOMERMAP_WHERE);

		boolean bindCustCatg = false;

		if (custCatg.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_3);
		}
		else {
			bindCustCatg = true;

			sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_2);
		}

		boolean bindCustType = false;

		if (custType.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_3);
		}
		else {
			bindCustType = true;

			sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_2);
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
			sb.append(CustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustCatg) {
			queryPos.add(custCatg);
		}

		if (bindCustType) {
			queryPos.add(custType);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customerMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomerMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 */
	@Override
	public void removeByCatgAndType(String custCatg, String custType) {
		for (CustomerMap customerMap :
				findByCatgAndType(
					custCatg, custType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(customerMap);
		}
	}

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @return the number of matching customer maps
	 */
	@Override
	public int countByCatgAndType(String custCatg, String custType) {
		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");

		FinderPath finderPath = _finderPathCountByCatgAndType;

		Object[] finderArgs = new Object[] {custCatg, custType};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CUSTOMERMAP_WHERE);

			boolean bindCustCatg = false;

			if (custCatg.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_3);
			}
			else {
				bindCustCatg = true;

				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTCATG_2);
			}

			boolean bindCustType = false;

			if (custType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_3);
			}
			else {
				bindCustType = true;

				sb.append(_FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustCatg) {
					queryPos.add(custCatg);
				}

				if (bindCustType) {
					queryPos.add(custType);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_CATGANDTYPE_CUSTCATG_2 =
		"customerMap.custCatg = ? AND ";

	private static final String _FINDER_COLUMN_CATGANDTYPE_CUSTCATG_3 =
		"(customerMap.custCatg IS NULL OR customerMap.custCatg = '') AND ";

	private static final String _FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_2 =
		"customerMap.custType = ?";

	private static final String _FINDER_COLUMN_CATGANDTYPE_CUSTTYPE_3 =
		"(customerMap.custType IS NULL OR customerMap.custType = '')";

	private FinderPath _finderPathWithPaginationFindByCatgTypeCode;
	private FinderPath _finderPathWithoutPaginationFindByCatgTypeCode;
	private FinderPath _finderPathCountByCatgTypeCode;

	/**
	 * Returns all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		return findByCatgTypeCode(
			custCatg, custType, premiaCode, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start,
		int end) {

		return findByCatgTypeCode(
			custCatg, custType, premiaCode, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator) {

		return findByCatgTypeCode(
			custCatg, custType, premiaCode, start, end, orderByComparator,
			true);
	}

	/**
	 * Returns an ordered range of all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer maps
	 */
	@Override
	public List<CustomerMap> findByCatgTypeCode(
		String custCatg, String custType, String premiaCode, int start, int end,
		OrderByComparator<CustomerMap> orderByComparator,
		boolean useFinderCache) {

		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");
		premiaCode = Objects.toString(premiaCode, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCatgTypeCode;
				finderArgs = new Object[] {custCatg, custType, premiaCode};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCatgTypeCode;
			finderArgs = new Object[] {
				custCatg, custType, premiaCode, start, end, orderByComparator
			};
		}

		List<CustomerMap> list = null;

		if (useFinderCache) {
			list = (List<CustomerMap>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomerMap customerMap : list) {
					if (!custCatg.equals(customerMap.getCustCatg()) ||
						!custType.equals(customerMap.getCustType()) ||
						!premiaCode.equals(customerMap.getPremiaCode())) {

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
					5 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(5);
			}

			sb.append(_SQL_SELECT_CUSTOMERMAP_WHERE);

			boolean bindCustCatg = false;

			if (custCatg.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_3);
			}
			else {
				bindCustCatg = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_2);
			}

			boolean bindCustType = false;

			if (custType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_3);
			}
			else {
				bindCustType = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_2);
			}

			boolean bindPremiaCode = false;

			if (premiaCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_3);
			}
			else {
				bindPremiaCode = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerMapModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustCatg) {
					queryPos.add(custCatg);
				}

				if (bindCustType) {
					queryPos.add(custType);
				}

				if (bindPremiaCode) {
					queryPos.add(premiaCode);
				}

				list = (List<CustomerMap>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	@Override
	public CustomerMap findByCatgTypeCode_First(
			String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		CustomerMap customerMap = fetchByCatgTypeCode_First(
			custCatg, custType, premiaCode, orderByComparator);

		if (customerMap != null) {
			return customerMap;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("custCatg=");
		sb.append(custCatg);

		sb.append(", custType=");
		sb.append(custType);

		sb.append(", premiaCode=");
		sb.append(premiaCode);

		sb.append("}");

		throw new NoSuchCustomerMapException(sb.toString());
	}

	/**
	 * Returns the first customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	@Override
	public CustomerMap fetchByCatgTypeCode_First(
		String custCatg, String custType, String premiaCode,
		OrderByComparator<CustomerMap> orderByComparator) {

		List<CustomerMap> list = findByCatgTypeCode(
			custCatg, custType, premiaCode, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map
	 * @throws NoSuchCustomerMapException if a matching customer map could not be found
	 */
	@Override
	public CustomerMap findByCatgTypeCode_Last(
			String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		CustomerMap customerMap = fetchByCatgTypeCode_Last(
			custCatg, custType, premiaCode, orderByComparator);

		if (customerMap != null) {
			return customerMap;
		}

		StringBundler sb = new StringBundler(8);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("custCatg=");
		sb.append(custCatg);

		sb.append(", custType=");
		sb.append(custType);

		sb.append(", premiaCode=");
		sb.append(premiaCode);

		sb.append("}");

		throw new NoSuchCustomerMapException(sb.toString());
	}

	/**
	 * Returns the last customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer map, or <code>null</code> if a matching customer map could not be found
	 */
	@Override
	public CustomerMap fetchByCatgTypeCode_Last(
		String custCatg, String custType, String premiaCode,
		OrderByComparator<CustomerMap> orderByComparator) {

		int count = countByCatgTypeCode(custCatg, custType, premiaCode);

		if (count == 0) {
			return null;
		}

		List<CustomerMap> list = findByCatgTypeCode(
			custCatg, custType, premiaCode, count - 1, count,
			orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the customer maps before and after the current customer map in the ordered set where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param refCode the primary key of the current customer map
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap[] findByCatgTypeCode_PrevAndNext(
			String refCode, String custCatg, String custType, String premiaCode,
			OrderByComparator<CustomerMap> orderByComparator)
		throws NoSuchCustomerMapException {

		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");
		premiaCode = Objects.toString(premiaCode, "");

		CustomerMap customerMap = findByPrimaryKey(refCode);

		Session session = null;

		try {
			session = openSession();

			CustomerMap[] array = new CustomerMapImpl[3];

			array[0] = getByCatgTypeCode_PrevAndNext(
				session, customerMap, custCatg, custType, premiaCode,
				orderByComparator, true);

			array[1] = customerMap;

			array[2] = getByCatgTypeCode_PrevAndNext(
				session, customerMap, custCatg, custType, premiaCode,
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

	protected CustomerMap getByCatgTypeCode_PrevAndNext(
		Session session, CustomerMap customerMap, String custCatg,
		String custType, String premiaCode,
		OrderByComparator<CustomerMap> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				6 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(5);
		}

		sb.append(_SQL_SELECT_CUSTOMERMAP_WHERE);

		boolean bindCustCatg = false;

		if (custCatg.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_3);
		}
		else {
			bindCustCatg = true;

			sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_2);
		}

		boolean bindCustType = false;

		if (custType.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_3);
		}
		else {
			bindCustType = true;

			sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_2);
		}

		boolean bindPremiaCode = false;

		if (premiaCode.isEmpty()) {
			sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_3);
		}
		else {
			bindPremiaCode = true;

			sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_2);
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
			sb.append(CustomerMapModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCustCatg) {
			queryPos.add(custCatg);
		}

		if (bindCustType) {
			queryPos.add(custType);
		}

		if (bindPremiaCode) {
			queryPos.add(premiaCode);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(customerMap)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CustomerMap> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63; from the database.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 */
	@Override
	public void removeByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		for (CustomerMap customerMap :
				findByCatgTypeCode(
					custCatg, custType, premiaCode, QueryUtil.ALL_POS,
					QueryUtil.ALL_POS, null)) {

			remove(customerMap);
		}
	}

	/**
	 * Returns the number of customer maps where custCatg = &#63; and custType = &#63; and premiaCode = &#63;.
	 *
	 * @param custCatg the cust catg
	 * @param custType the cust type
	 * @param premiaCode the premia code
	 * @return the number of matching customer maps
	 */
	@Override
	public int countByCatgTypeCode(
		String custCatg, String custType, String premiaCode) {

		custCatg = Objects.toString(custCatg, "");
		custType = Objects.toString(custType, "");
		premiaCode = Objects.toString(premiaCode, "");

		FinderPath finderPath = _finderPathCountByCatgTypeCode;

		Object[] finderArgs = new Object[] {custCatg, custType, premiaCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CUSTOMERMAP_WHERE);

			boolean bindCustCatg = false;

			if (custCatg.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_3);
			}
			else {
				bindCustCatg = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTCATG_2);
			}

			boolean bindCustType = false;

			if (custType.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_3);
			}
			else {
				bindCustType = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_2);
			}

			boolean bindPremiaCode = false;

			if (premiaCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_3);
			}
			else {
				bindPremiaCode = true;

				sb.append(_FINDER_COLUMN_CATGTYPECODE_PREMIACODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCustCatg) {
					queryPos.add(custCatg);
				}

				if (bindCustType) {
					queryPos.add(custType);
				}

				if (bindPremiaCode) {
					queryPos.add(premiaCode);
				}

				count = (Long)query.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
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

	private static final String _FINDER_COLUMN_CATGTYPECODE_CUSTCATG_2 =
		"customerMap.custCatg = ? AND ";

	private static final String _FINDER_COLUMN_CATGTYPECODE_CUSTCATG_3 =
		"(customerMap.custCatg IS NULL OR customerMap.custCatg = '') AND ";

	private static final String _FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_2 =
		"customerMap.custType = ? AND ";

	private static final String _FINDER_COLUMN_CATGTYPECODE_CUSTTYPE_3 =
		"(customerMap.custType IS NULL OR customerMap.custType = '') AND ";

	private static final String _FINDER_COLUMN_CATGTYPECODE_PREMIACODE_2 =
		"customerMap.premiaCode = ?";

	private static final String _FINDER_COLUMN_CATGTYPECODE_PREMIACODE_3 =
		"(customerMap.premiaCode IS NULL OR customerMap.premiaCode = '')";

	public CustomerMapPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("civilId", "MDM_CUST_CIVIL_ID");
		dbColumnNames.put("effFromDate", "MDM_CUST_EFF_FM_DT");
		dbColumnNames.put("crDare", "MDM_CUST_CR_DT");
		dbColumnNames.put("crUid", "MDM_CUST_CR_UID");
		dbColumnNames.put("updateDt", "MDM_CUST_UPD_DT");
		dbColumnNames.put("updUid", "MDM_CUST_UPD_UID");
		dbColumnNames.put("name", "MDM_CUST_NAME");
		dbColumnNames.put("nameAr", "MDM_CUST_NAME_AR");
		dbColumnNames.put("custType", "MDM_CUST_TYPE");
		dbColumnNames.put("custCatg", "MDM_CUST_CATG");
		dbColumnNames.put("custCatgDesc", "MDM_CUST_CATG_DESC");
		dbColumnNames.put("dob", "MDM_CUST_DOB");
		dbColumnNames.put("mobileNo", "MDM_MOBILE_NO");
		dbColumnNames.put("premiaCode", "MDM_PREMIA_CODE");
		dbColumnNames.put("medCode", "MDM_MED_CODE");
		dbColumnNames.put("ilasCode", "MDM_ILAS_CODE");
		dbColumnNames.put("glasCode", "MDM_GLAS_CODE");
		dbColumnNames.put("nationality", "MDM_NATIONALITY");
		dbColumnNames.put("nameShort", "MDM_CUST_NAME_SHORT");
		dbColumnNames.put("version", "MDM_CUST_VERSION");
		dbColumnNames.put("vip", "MDM_CUST_VIP");
		dbColumnNames.put("phoneNo", "MDM_PHONE_NO");
		dbColumnNames.put("address", "MDM_ADDRESS");
		dbColumnNames.put("email", "MDM_EMAIL");
		dbColumnNames.put("refCode", "MDM_CUST_REF_CODE");

		setDBColumnNames(dbColumnNames);

		setModelClass(CustomerMap.class);

		setModelImplClass(CustomerMapImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the customer map in the entity cache if it is enabled.
	 *
	 * @param customerMap the customer map
	 */
	@Override
	public void cacheResult(CustomerMap customerMap) {
		entityCache.putResult(
			CustomerMapImpl.class, customerMap.getPrimaryKey(), customerMap);
	}

	/**
	 * Caches the customer maps in the entity cache if it is enabled.
	 *
	 * @param customerMaps the customer maps
	 */
	@Override
	public void cacheResult(List<CustomerMap> customerMaps) {
		for (CustomerMap customerMap : customerMaps) {
			if (entityCache.getResult(
					CustomerMapImpl.class, customerMap.getPrimaryKey()) ==
						null) {

				cacheResult(customerMap);
			}
		}
	}

	/**
	 * Clears the cache for all customer maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CustomerMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomerMap customerMap) {
		entityCache.removeResult(CustomerMapImpl.class, customerMap);
	}

	@Override
	public void clearCache(List<CustomerMap> customerMaps) {
		for (CustomerMap customerMap : customerMaps) {
			entityCache.removeResult(CustomerMapImpl.class, customerMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CustomerMapImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new customer map with the primary key. Does not add the customer map to the database.
	 *
	 * @param refCode the primary key for the new customer map
	 * @return the new customer map
	 */
	@Override
	public CustomerMap create(String refCode) {
		CustomerMap customerMap = new CustomerMapImpl();

		customerMap.setNew(true);
		customerMap.setPrimaryKey(refCode);

		return customerMap;
	}

	/**
	 * Removes the customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map that was removed
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap remove(String refCode)
		throws NoSuchCustomerMapException {

		return remove((Serializable)refCode);
	}

	/**
	 * Removes the customer map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer map
	 * @return the customer map that was removed
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap remove(Serializable primaryKey)
		throws NoSuchCustomerMapException {

		Session session = null;

		try {
			session = openSession();

			CustomerMap customerMap = (CustomerMap)session.get(
				CustomerMapImpl.class, primaryKey);

			if (customerMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customerMap);
		}
		catch (NoSuchCustomerMapException noSuchEntityException) {
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
	protected CustomerMap removeImpl(CustomerMap customerMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customerMap)) {
				customerMap = (CustomerMap)session.get(
					CustomerMapImpl.class, customerMap.getPrimaryKeyObj());
			}

			if (customerMap != null) {
				session.delete(customerMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customerMap != null) {
			clearCache(customerMap);
		}

		return customerMap;
	}

	@Override
	public CustomerMap updateImpl(CustomerMap customerMap) {
		boolean isNew = customerMap.isNew();

		if (!(customerMap instanceof CustomerMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customerMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(customerMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customerMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomerMap implementation " +
					customerMap.getClass());
		}

		CustomerMapModelImpl customerMapModelImpl =
			(CustomerMapModelImpl)customerMap;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customerMap);
			}
			else {
				customerMap = (CustomerMap)session.merge(customerMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CustomerMapImpl.class, customerMapModelImpl, false, true);

		if (isNew) {
			customerMap.setNew(false);
		}

		customerMap.resetOriginalValues();

		return customerMap;
	}

	/**
	 * Returns the customer map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer map
	 * @return the customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerMapException {

		CustomerMap customerMap = fetchByPrimaryKey(primaryKey);

		if (customerMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customerMap;
	}

	/**
	 * Returns the customer map with the primary key or throws a <code>NoSuchCustomerMapException</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map
	 * @throws NoSuchCustomerMapException if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap findByPrimaryKey(String refCode)
		throws NoSuchCustomerMapException {

		return findByPrimaryKey((Serializable)refCode);
	}

	/**
	 * Returns the customer map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param refCode the primary key of the customer map
	 * @return the customer map, or <code>null</code> if a customer map with the primary key could not be found
	 */
	@Override
	public CustomerMap fetchByPrimaryKey(String refCode) {
		return fetchByPrimaryKey((Serializable)refCode);
	}

	/**
	 * Returns all the customer maps.
	 *
	 * @return the customer maps
	 */
	@Override
	public List<CustomerMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @return the range of customer maps
	 */
	@Override
	public List<CustomerMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer maps
	 */
	@Override
	public List<CustomerMap> findAll(
		int start, int end, OrderByComparator<CustomerMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customer maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer maps
	 * @param end the upper bound of the range of customer maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer maps
	 */
	@Override
	public List<CustomerMap> findAll(
		int start, int end, OrderByComparator<CustomerMap> orderByComparator,
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

		List<CustomerMap> list = null;

		if (useFinderCache) {
			list = (List<CustomerMap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMERMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERMAP;

				sql = sql.concat(CustomerMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomerMap>)QueryUtil.list(
					query, getDialect(), start, end);

				cacheResult(list);

				if (useFinderCache) {
					finderCache.putResult(finderPath, finderArgs, list);
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
	 * Removes all the customer maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomerMap customerMap : findAll()) {
			remove(customerMap);
		}
	}

	/**
	 * Returns the number of customer maps.
	 *
	 * @return the number of customer maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMERMAP);

				count = (Long)query.uniqueResult();

				finderCache.putResult(
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
	protected EntityCache getEntityCache() {
		return entityCache;
	}

	@Override
	protected String getPKDBName() {
		return "MDM_CUST_REF_CODE";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMERMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomerMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer map persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CustomerMapModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CustomerMap.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCatgAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCatgAndType",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE"}, true);

		_finderPathWithoutPaginationFindByCatgAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatgAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE"}, true);

		_finderPathCountByCatgAndType = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatgAndType",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE"}, false);

		_finderPathWithPaginationFindByCatgTypeCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCatgTypeCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE", "MDM_PREMIA_CODE"},
			true);

		_finderPathWithoutPaginationFindByCatgTypeCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCatgTypeCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE", "MDM_PREMIA_CODE"},
			true);

		_finderPathCountByCatgTypeCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCatgTypeCode",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"MDM_CUST_CATG", "MDM_CUST_TYPE", "MDM_PREMIA_CODE"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CustomerMapImpl.class.getName());

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

	@Reference
	protected EntityCache entityCache;

	@Reference
	protected FinderCache finderCache;

	private static final String _SQL_SELECT_CUSTOMERMAP =
		"SELECT customerMap FROM CustomerMap customerMap";

	private static final String _SQL_SELECT_CUSTOMERMAP_WHERE =
		"SELECT customerMap FROM CustomerMap customerMap WHERE ";

	private static final String _SQL_COUNT_CUSTOMERMAP =
		"SELECT COUNT(customerMap) FROM CustomerMap customerMap";

	private static final String _SQL_COUNT_CUSTOMERMAP_WHERE =
		"SELECT COUNT(customerMap) FROM CustomerMap customerMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customerMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomerMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustomerMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomerMapPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"civilId", "effFromDate", "crDare", "crUid", "updateDt", "updUid",
			"name", "nameAr", "custType", "custCatg", "custCatgDesc", "dob",
			"mobileNo", "premiaCode", "medCode", "ilasCode", "glasCode",
			"nationality", "nameShort", "version", "vip", "phoneNo", "address",
			"email", "refCode"
		});

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

	private static class CustomerMapModelArgumentsResolver
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

			CustomerMapModelImpl customerMapModelImpl =
				(CustomerMapModelImpl)baseModel;

			long columnBitmask = customerMapModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(customerMapModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						customerMapModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(customerMapModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CustomerMapModelImpl customerMapModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = customerMapModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = customerMapModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}