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

import com.ejada.atmc.acl.db.exception.NoSuchCustomerIbanException;
import com.ejada.atmc.acl.db.model.CustomerIban;
import com.ejada.atmc.acl.db.model.impl.CustomerIbanImpl;
import com.ejada.atmc.acl.db.model.impl.CustomerIbanModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CustomerIbanPersistence;
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
 * The persistence implementation for the customer iban service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CustomerIbanPersistence.class)
public class CustomerIbanPersistenceImpl
	extends BasePersistenceImpl<CustomerIban>
	implements CustomerIbanPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CustomerIbanUtil</code> to access the customer iban persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CustomerIbanImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByCustomerIbanById;
	private FinderPath _finderPathWithoutPaginationFindByCustomerIbanById;
	private FinderPath _finderPathCountByCustomerIbanById;

	/**
	 * Returns all the customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the matching customer ibans
	 */
	@Override
	public List<CustomerIban> findByCustomerIbanById(String id) {
		return findByCustomerIbanById(
			id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @return the range of matching customer ibans
	 */
	@Override
	public List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end) {

		return findByCustomerIbanById(id, start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching customer ibans
	 */
	@Override
	public List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		OrderByComparator<CustomerIban> orderByComparator) {

		return findByCustomerIbanById(id, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customer ibans where id = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param id the ID
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching customer ibans
	 */
	@Override
	public List<CustomerIban> findByCustomerIbanById(
		String id, int start, int end,
		OrderByComparator<CustomerIban> orderByComparator,
		boolean useFinderCache) {

		id = Objects.toString(id, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCustomerIbanById;
				finderArgs = new Object[] {id};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCustomerIbanById;
			finderArgs = new Object[] {id, start, end, orderByComparator};
		}

		List<CustomerIban> list = null;

		if (useFinderCache) {
			list = (List<CustomerIban>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CustomerIban customerIban : list) {
					if (!id.equals(customerIban.getId())) {
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

			sb.append(_SQL_SELECT_CUSTOMERIBAN_WHERE);

			boolean bindId = false;

			if (id.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERIBANBYID_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_CUSTOMERIBANBYID_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CustomerIbanModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(id);
				}

				list = (List<CustomerIban>)QueryUtil.list(
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
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	@Override
	public CustomerIban findByCustomerIbanById_First(
			String id, OrderByComparator<CustomerIban> orderByComparator)
		throws NoSuchCustomerIbanException {

		CustomerIban customerIban = fetchByCustomerIbanById_First(
			id, orderByComparator);

		if (customerIban != null) {
			return customerIban;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchCustomerIbanException(sb.toString());
	}

	/**
	 * Returns the first customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	@Override
	public CustomerIban fetchByCustomerIbanById_First(
		String id, OrderByComparator<CustomerIban> orderByComparator) {

		List<CustomerIban> list = findByCustomerIbanById(
			id, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban
	 * @throws NoSuchCustomerIbanException if a matching customer iban could not be found
	 */
	@Override
	public CustomerIban findByCustomerIbanById_Last(
			String id, OrderByComparator<CustomerIban> orderByComparator)
		throws NoSuchCustomerIbanException {

		CustomerIban customerIban = fetchByCustomerIbanById_Last(
			id, orderByComparator);

		if (customerIban != null) {
			return customerIban;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("id=");
		sb.append(id);

		sb.append("}");

		throw new NoSuchCustomerIbanException(sb.toString());
	}

	/**
	 * Returns the last customer iban in the ordered set where id = &#63;.
	 *
	 * @param id the ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching customer iban, or <code>null</code> if a matching customer iban could not be found
	 */
	@Override
	public CustomerIban fetchByCustomerIbanById_Last(
		String id, OrderByComparator<CustomerIban> orderByComparator) {

		int count = countByCustomerIbanById(id);

		if (count == 0) {
			return null;
		}

		List<CustomerIban> list = findByCustomerIbanById(
			id, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the customer ibans where id = &#63; from the database.
	 *
	 * @param id the ID
	 */
	@Override
	public void removeByCustomerIbanById(String id) {
		for (CustomerIban customerIban :
				findByCustomerIbanById(
					id, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(customerIban);
		}
	}

	/**
	 * Returns the number of customer ibans where id = &#63;.
	 *
	 * @param id the ID
	 * @return the number of matching customer ibans
	 */
	@Override
	public int countByCustomerIbanById(String id) {
		id = Objects.toString(id, "");

		FinderPath finderPath = _finderPathCountByCustomerIbanById;

		Object[] finderArgs = new Object[] {id};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CUSTOMERIBAN_WHERE);

			boolean bindId = false;

			if (id.isEmpty()) {
				sb.append(_FINDER_COLUMN_CUSTOMERIBANBYID_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_CUSTOMERIBANBYID_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(id);
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

	private static final String _FINDER_COLUMN_CUSTOMERIBANBYID_ID_2 =
		"customerIban.id = ?";

	private static final String _FINDER_COLUMN_CUSTOMERIBANBYID_ID_3 =
		"(customerIban.id IS NULL OR customerIban.id = '')";

	public CustomerIbanPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("id", "MDM_CUST_CIVIL_ID");
		dbColumnNames.put("refCode", "MDM_CUST_REF_CODE");
		dbColumnNames.put("premiaCCode", "MDM_PREMIA_CODE");
		dbColumnNames.put("iban", "MDM_IBAN");

		setDBColumnNames(dbColumnNames);

		setModelClass(CustomerIban.class);

		setModelImplClass(CustomerIbanImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the customer iban in the entity cache if it is enabled.
	 *
	 * @param customerIban the customer iban
	 */
	@Override
	public void cacheResult(CustomerIban customerIban) {
		dummyEntityCache.putResult(
			CustomerIbanImpl.class, customerIban.getPrimaryKey(), customerIban);
	}

	/**
	 * Caches the customer ibans in the entity cache if it is enabled.
	 *
	 * @param customerIbans the customer ibans
	 */
	@Override
	public void cacheResult(List<CustomerIban> customerIbans) {
		for (CustomerIban customerIban : customerIbans) {
			if (dummyEntityCache.getResult(
					CustomerIbanImpl.class, customerIban.getPrimaryKey()) ==
						null) {

				cacheResult(customerIban);
			}
		}
	}

	/**
	 * Clears the cache for all customer ibans.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CustomerIbanImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the customer iban.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CustomerIban customerIban) {
		dummyEntityCache.removeResult(CustomerIbanImpl.class, customerIban);
	}

	@Override
	public void clearCache(List<CustomerIban> customerIbans) {
		for (CustomerIban customerIban : customerIbans) {
			dummyEntityCache.removeResult(CustomerIbanImpl.class, customerIban);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CustomerIbanImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new customer iban with the primary key. Does not add the customer iban to the database.
	 *
	 * @param id the primary key for the new customer iban
	 * @return the new customer iban
	 */
	@Override
	public CustomerIban create(String id) {
		CustomerIban customerIban = new CustomerIbanImpl();

		customerIban.setNew(true);
		customerIban.setPrimaryKey(id);

		return customerIban;
	}

	/**
	 * Removes the customer iban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban that was removed
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	@Override
	public CustomerIban remove(String id) throws NoSuchCustomerIbanException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the customer iban with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the customer iban
	 * @return the customer iban that was removed
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	@Override
	public CustomerIban remove(Serializable primaryKey)
		throws NoSuchCustomerIbanException {

		Session session = null;

		try {
			session = openSession();

			CustomerIban customerIban = (CustomerIban)session.get(
				CustomerIbanImpl.class, primaryKey);

			if (customerIban == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCustomerIbanException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(customerIban);
		}
		catch (NoSuchCustomerIbanException noSuchEntityException) {
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
	protected CustomerIban removeImpl(CustomerIban customerIban) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(customerIban)) {
				customerIban = (CustomerIban)session.get(
					CustomerIbanImpl.class, customerIban.getPrimaryKeyObj());
			}

			if (customerIban != null) {
				session.delete(customerIban);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (customerIban != null) {
			clearCache(customerIban);
		}

		return customerIban;
	}

	@Override
	public CustomerIban updateImpl(CustomerIban customerIban) {
		boolean isNew = customerIban.isNew();

		if (!(customerIban instanceof CustomerIbanModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(customerIban.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					customerIban);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in customerIban proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CustomerIban implementation " +
					customerIban.getClass());
		}

		CustomerIbanModelImpl customerIbanModelImpl =
			(CustomerIbanModelImpl)customerIban;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(customerIban);
			}
			else {
				customerIban = (CustomerIban)session.merge(customerIban);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			CustomerIbanImpl.class, customerIbanModelImpl, false, true);

		if (isNew) {
			customerIban.setNew(false);
		}

		customerIban.resetOriginalValues();

		return customerIban;
	}

	/**
	 * Returns the customer iban with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the customer iban
	 * @return the customer iban
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	@Override
	public CustomerIban findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCustomerIbanException {

		CustomerIban customerIban = fetchByPrimaryKey(primaryKey);

		if (customerIban == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCustomerIbanException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return customerIban;
	}

	/**
	 * Returns the customer iban with the primary key or throws a <code>NoSuchCustomerIbanException</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban
	 * @throws NoSuchCustomerIbanException if a customer iban with the primary key could not be found
	 */
	@Override
	public CustomerIban findByPrimaryKey(String id)
		throws NoSuchCustomerIbanException {

		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the customer iban with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the customer iban
	 * @return the customer iban, or <code>null</code> if a customer iban with the primary key could not be found
	 */
	@Override
	public CustomerIban fetchByPrimaryKey(String id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns all the customer ibans.
	 *
	 * @return the customer ibans
	 */
	@Override
	public List<CustomerIban> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @return the range of customer ibans
	 */
	@Override
	public List<CustomerIban> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of customer ibans
	 */
	@Override
	public List<CustomerIban> findAll(
		int start, int end, OrderByComparator<CustomerIban> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the customer ibans.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CustomerIbanModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of customer ibans
	 * @param end the upper bound of the range of customer ibans (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of customer ibans
	 */
	@Override
	public List<CustomerIban> findAll(
		int start, int end, OrderByComparator<CustomerIban> orderByComparator,
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

		List<CustomerIban> list = null;

		if (useFinderCache) {
			list = (List<CustomerIban>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CUSTOMERIBAN);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CUSTOMERIBAN;

				sql = sql.concat(CustomerIbanModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CustomerIban>)QueryUtil.list(
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
	 * Removes all the customer ibans from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CustomerIban customerIban : findAll()) {
			remove(customerIban);
		}
	}

	/**
	 * Returns the number of customer ibans.
	 *
	 * @return the number of customer ibans
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CUSTOMERIBAN);

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
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "MDM_CUST_CIVIL_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CUSTOMERIBAN;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CustomerIbanModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the customer iban persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CustomerIbanModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CustomerIban.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByCustomerIbanById = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCustomerIbanById",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"MDM_CUST_CIVIL_ID"}, true);

		_finderPathWithoutPaginationFindByCustomerIbanById = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCustomerIbanById",
			new String[] {String.class.getName()},
			new String[] {"MDM_CUST_CIVIL_ID"}, true);

		_finderPathCountByCustomerIbanById = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCustomerIbanById", new String[] {String.class.getName()},
			new String[] {"MDM_CUST_CIVIL_ID"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CustomerIbanImpl.class.getName());

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

	private static final String _SQL_SELECT_CUSTOMERIBAN =
		"SELECT customerIban FROM CustomerIban customerIban";

	private static final String _SQL_SELECT_CUSTOMERIBAN_WHERE =
		"SELECT customerIban FROM CustomerIban customerIban WHERE ";

	private static final String _SQL_COUNT_CUSTOMERIBAN =
		"SELECT COUNT(customerIban) FROM CustomerIban customerIban";

	private static final String _SQL_COUNT_CUSTOMERIBAN_WHERE =
		"SELECT COUNT(customerIban) FROM CustomerIban customerIban WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "customerIban.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CustomerIban exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CustomerIban exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CustomerIbanPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"id", "refCode", "premiaCCode", "iban"});

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

	private static class CustomerIbanModelArgumentsResolver
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

			CustomerIbanModelImpl customerIbanModelImpl =
				(CustomerIbanModelImpl)baseModel;

			long columnBitmask = customerIbanModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(customerIbanModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						customerIbanModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(customerIbanModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CustomerIbanModelImpl customerIbanModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = customerIbanModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = customerIbanModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}