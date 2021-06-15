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

import com.ejada.atmc.acl.db.exception.NoSuchCompDiscountException;
import com.ejada.atmc.acl.db.model.CompDiscount;
import com.ejada.atmc.acl.db.model.impl.CompDiscountImpl;
import com.ejada.atmc.acl.db.model.impl.CompDiscountModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CompDiscountPersistence;
import com.ejada.atmc.acl.db.service.persistence.impl.constants.DBACLPersistenceConstants;

import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.configuration.Configuration;
import com.liferay.portal.kernel.dao.orm.ArgumentsResolver;
import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.MapUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;

import java.io.Serializable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
 * The persistence implementation for the comp discount service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CompDiscountPersistence.class)
public class CompDiscountPersistenceImpl
	extends BasePersistenceImpl<CompDiscount>
	implements CompDiscountPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CompDiscountUtil</code> to access the comp discount persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CompDiscountImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CompDiscountPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("iqamaId", "IQAMA_ID");
		dbColumnNames.put("schemeCode", "SCHEME_CODE");
		dbColumnNames.put("companyCode", "COMPANY_NAME");
		dbColumnNames.put("startDate", "START_DATE");
		dbColumnNames.put("endDate", "END_DATE");

		setDBColumnNames(dbColumnNames);

		setModelClass(CompDiscount.class);

		setModelImplClass(CompDiscountImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the comp discount in the entity cache if it is enabled.
	 *
	 * @param compDiscount the comp discount
	 */
	@Override
	public void cacheResult(CompDiscount compDiscount) {
		dummyEntityCache.putResult(
			CompDiscountImpl.class, compDiscount.getPrimaryKey(), compDiscount);
	}

	/**
	 * Caches the comp discounts in the entity cache if it is enabled.
	 *
	 * @param compDiscounts the comp discounts
	 */
	@Override
	public void cacheResult(List<CompDiscount> compDiscounts) {
		for (CompDiscount compDiscount : compDiscounts) {
			if (dummyEntityCache.getResult(
					CompDiscountImpl.class, compDiscount.getPrimaryKey()) ==
						null) {

				cacheResult(compDiscount);
			}
		}
	}

	/**
	 * Clears the cache for all comp discounts.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CompDiscountImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the comp discount.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CompDiscount compDiscount) {
		dummyEntityCache.removeResult(CompDiscountImpl.class, compDiscount);
	}

	@Override
	public void clearCache(List<CompDiscount> compDiscounts) {
		for (CompDiscount compDiscount : compDiscounts) {
			dummyEntityCache.removeResult(CompDiscountImpl.class, compDiscount);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CompDiscountImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new comp discount with the primary key. Does not add the comp discount to the database.
	 *
	 * @param iqamaId the primary key for the new comp discount
	 * @return the new comp discount
	 */
	@Override
	public CompDiscount create(String iqamaId) {
		CompDiscount compDiscount = new CompDiscountImpl();

		compDiscount.setNew(true);
		compDiscount.setPrimaryKey(iqamaId);

		return compDiscount;
	}

	/**
	 * Removes the comp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount that was removed
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	@Override
	public CompDiscount remove(String iqamaId)
		throws NoSuchCompDiscountException {

		return remove((Serializable)iqamaId);
	}

	/**
	 * Removes the comp discount with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the comp discount
	 * @return the comp discount that was removed
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	@Override
	public CompDiscount remove(Serializable primaryKey)
		throws NoSuchCompDiscountException {

		Session session = null;

		try {
			session = openSession();

			CompDiscount compDiscount = (CompDiscount)session.get(
				CompDiscountImpl.class, primaryKey);

			if (compDiscount == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCompDiscountException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(compDiscount);
		}
		catch (NoSuchCompDiscountException noSuchEntityException) {
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
	protected CompDiscount removeImpl(CompDiscount compDiscount) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(compDiscount)) {
				compDiscount = (CompDiscount)session.get(
					CompDiscountImpl.class, compDiscount.getPrimaryKeyObj());
			}

			if (compDiscount != null) {
				session.delete(compDiscount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (compDiscount != null) {
			clearCache(compDiscount);
		}

		return compDiscount;
	}

	@Override
	public CompDiscount updateImpl(CompDiscount compDiscount) {
		boolean isNew = compDiscount.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(compDiscount);
			}
			else {
				compDiscount = (CompDiscount)session.merge(compDiscount);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			CompDiscountImpl.class, compDiscount, false, true);

		if (isNew) {
			compDiscount.setNew(false);
		}

		compDiscount.resetOriginalValues();

		return compDiscount;
	}

	/**
	 * Returns the comp discount with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the comp discount
	 * @return the comp discount
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	@Override
	public CompDiscount findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCompDiscountException {

		CompDiscount compDiscount = fetchByPrimaryKey(primaryKey);

		if (compDiscount == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCompDiscountException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return compDiscount;
	}

	/**
	 * Returns the comp discount with the primary key or throws a <code>NoSuchCompDiscountException</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount
	 * @throws NoSuchCompDiscountException if a comp discount with the primary key could not be found
	 */
	@Override
	public CompDiscount findByPrimaryKey(String iqamaId)
		throws NoSuchCompDiscountException {

		return findByPrimaryKey((Serializable)iqamaId);
	}

	/**
	 * Returns the comp discount with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param iqamaId the primary key of the comp discount
	 * @return the comp discount, or <code>null</code> if a comp discount with the primary key could not be found
	 */
	@Override
	public CompDiscount fetchByPrimaryKey(String iqamaId) {
		return fetchByPrimaryKey((Serializable)iqamaId);
	}

	/**
	 * Returns all the comp discounts.
	 *
	 * @return the comp discounts
	 */
	@Override
	public List<CompDiscount> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @return the range of comp discounts
	 */
	@Override
	public List<CompDiscount> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of comp discounts
	 */
	@Override
	public List<CompDiscount> findAll(
		int start, int end, OrderByComparator<CompDiscount> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the comp discounts.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CompDiscountModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of comp discounts
	 * @param end the upper bound of the range of comp discounts (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of comp discounts
	 */
	@Override
	public List<CompDiscount> findAll(
		int start, int end, OrderByComparator<CompDiscount> orderByComparator,
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

		List<CompDiscount> list = null;

		if (useFinderCache) {
			list = (List<CompDiscount>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_COMPDISCOUNT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_COMPDISCOUNT;

				sql = sql.concat(CompDiscountModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CompDiscount>)QueryUtil.list(
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
	 * Removes all the comp discounts from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CompDiscount compDiscount : findAll()) {
			remove(compDiscount);
		}
	}

	/**
	 * Returns the number of comp discounts.
	 *
	 * @return the number of comp discounts
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_COMPDISCOUNT);

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
		return "IQAMA_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_COMPDISCOUNT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CompDiscountModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the comp discount persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CompDiscountModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CompDiscount.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(CompDiscountImpl.class.getName());

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

	private static final String _SQL_SELECT_COMPDISCOUNT =
		"SELECT compDiscount FROM CompDiscount compDiscount";

	private static final String _SQL_COUNT_COMPDISCOUNT =
		"SELECT COUNT(compDiscount) FROM CompDiscount compDiscount";

	private static final String _ORDER_BY_ENTITY_ALIAS = "compDiscount.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CompDiscount exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CompDiscountPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"iqamaId", "schemeCode", "companyCode", "startDate", "endDate"
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

	private static class CompDiscountModelArgumentsResolver
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

			CompDiscountModelImpl compDiscountModelImpl =
				(CompDiscountModelImpl)baseModel;

			long columnBitmask = compDiscountModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(compDiscountModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						compDiscountModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(compDiscountModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CompDiscountModelImpl compDiscountModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = compDiscountModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = compDiscountModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}