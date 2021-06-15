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

import com.ejada.atmc.acl.db.exception.NoSuchClaimTPSearchException;
import com.ejada.atmc.acl.db.model.ClaimTPSearch;
import com.ejada.atmc.acl.db.model.impl.ClaimTPSearchImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimTPSearchModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPK;
import com.ejada.atmc.acl.db.service.persistence.ClaimTPSearchPersistence;
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
 * The persistence implementation for the claim tp search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimTPSearchPersistence.class)
public class ClaimTPSearchPersistenceImpl
	extends BasePersistenceImpl<ClaimTPSearch>
	implements ClaimTPSearchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimTPSearchUtil</code> to access the claim tp search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimTPSearchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ClaimTPSearchPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("reportNo", "ODS_REPORT_NO");
		dbColumnNames.put("tpId", "ODS_TP_ID");
		dbColumnNames.put("tpDriverName", "ODS_TP_DRIVER_NAME");
		dbColumnNames.put("tpAge", "ODS_TP_AGE");
		dbColumnNames.put("vehicleSEQCustom", "ODS_VEHICLE_SEQ_CUSTOM");
		dbColumnNames.put("tpMobileNo", "ODS_TP_MOBILE_NO");
		dbColumnNames.put("tpNationality", "ODS_TP_NATIONALITY");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClaimTPSearch.class);

		setModelImplClass(ClaimTPSearchImpl.class);
		setModelPKClass(ClaimTPSearchPK.class);
	}

	/**
	 * Caches the claim tp search in the entity cache if it is enabled.
	 *
	 * @param claimTPSearch the claim tp search
	 */
	@Override
	public void cacheResult(ClaimTPSearch claimTPSearch) {
		dummyEntityCache.putResult(
			ClaimTPSearchImpl.class, claimTPSearch.getPrimaryKey(),
			claimTPSearch);
	}

	/**
	 * Caches the claim tp searches in the entity cache if it is enabled.
	 *
	 * @param claimTPSearches the claim tp searches
	 */
	@Override
	public void cacheResult(List<ClaimTPSearch> claimTPSearches) {
		for (ClaimTPSearch claimTPSearch : claimTPSearches) {
			if (dummyEntityCache.getResult(
					ClaimTPSearchImpl.class, claimTPSearch.getPrimaryKey()) ==
						null) {

				cacheResult(claimTPSearch);
			}
		}
	}

	/**
	 * Clears the cache for all claim tp searches.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ClaimTPSearchImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim tp search.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimTPSearch claimTPSearch) {
		dummyEntityCache.removeResult(ClaimTPSearchImpl.class, claimTPSearch);
	}

	@Override
	public void clearCache(List<ClaimTPSearch> claimTPSearches) {
		for (ClaimTPSearch claimTPSearch : claimTPSearches) {
			dummyEntityCache.removeResult(
				ClaimTPSearchImpl.class, claimTPSearch);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ClaimTPSearchImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim tp search with the primary key. Does not add the claim tp search to the database.
	 *
	 * @param claimTPSearchPK the primary key for the new claim tp search
	 * @return the new claim tp search
	 */
	@Override
	public ClaimTPSearch create(ClaimTPSearchPK claimTPSearchPK) {
		ClaimTPSearch claimTPSearch = new ClaimTPSearchImpl();

		claimTPSearch.setNew(true);
		claimTPSearch.setPrimaryKey(claimTPSearchPK);

		return claimTPSearch;
	}

	/**
	 * Removes the claim tp search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search that was removed
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	@Override
	public ClaimTPSearch remove(ClaimTPSearchPK claimTPSearchPK)
		throws NoSuchClaimTPSearchException {

		return remove((Serializable)claimTPSearchPK);
	}

	/**
	 * Removes the claim tp search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim tp search
	 * @return the claim tp search that was removed
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	@Override
	public ClaimTPSearch remove(Serializable primaryKey)
		throws NoSuchClaimTPSearchException {

		Session session = null;

		try {
			session = openSession();

			ClaimTPSearch claimTPSearch = (ClaimTPSearch)session.get(
				ClaimTPSearchImpl.class, primaryKey);

			if (claimTPSearch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimTPSearchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimTPSearch);
		}
		catch (NoSuchClaimTPSearchException noSuchEntityException) {
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
	protected ClaimTPSearch removeImpl(ClaimTPSearch claimTPSearch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimTPSearch)) {
				claimTPSearch = (ClaimTPSearch)session.get(
					ClaimTPSearchImpl.class, claimTPSearch.getPrimaryKeyObj());
			}

			if (claimTPSearch != null) {
				session.delete(claimTPSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimTPSearch != null) {
			clearCache(claimTPSearch);
		}

		return claimTPSearch;
	}

	@Override
	public ClaimTPSearch updateImpl(ClaimTPSearch claimTPSearch) {
		boolean isNew = claimTPSearch.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimTPSearch);
			}
			else {
				claimTPSearch = (ClaimTPSearch)session.merge(claimTPSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ClaimTPSearchImpl.class, claimTPSearch, false, true);

		if (isNew) {
			claimTPSearch.setNew(false);
		}

		claimTPSearch.resetOriginalValues();

		return claimTPSearch;
	}

	/**
	 * Returns the claim tp search with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim tp search
	 * @return the claim tp search
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	@Override
	public ClaimTPSearch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimTPSearchException {

		ClaimTPSearch claimTPSearch = fetchByPrimaryKey(primaryKey);

		if (claimTPSearch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimTPSearchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimTPSearch;
	}

	/**
	 * Returns the claim tp search with the primary key or throws a <code>NoSuchClaimTPSearchException</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search
	 * @throws NoSuchClaimTPSearchException if a claim tp search with the primary key could not be found
	 */
	@Override
	public ClaimTPSearch findByPrimaryKey(ClaimTPSearchPK claimTPSearchPK)
		throws NoSuchClaimTPSearchException {

		return findByPrimaryKey((Serializable)claimTPSearchPK);
	}

	/**
	 * Returns the claim tp search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimTPSearchPK the primary key of the claim tp search
	 * @return the claim tp search, or <code>null</code> if a claim tp search with the primary key could not be found
	 */
	@Override
	public ClaimTPSearch fetchByPrimaryKey(ClaimTPSearchPK claimTPSearchPK) {
		return fetchByPrimaryKey((Serializable)claimTPSearchPK);
	}

	/**
	 * Returns all the claim tp searches.
	 *
	 * @return the claim tp searches
	 */
	@Override
	public List<ClaimTPSearch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @return the range of claim tp searches
	 */
	@Override
	public List<ClaimTPSearch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim tp searches
	 */
	@Override
	public List<ClaimTPSearch> findAll(
		int start, int end,
		OrderByComparator<ClaimTPSearch> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim tp searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimTPSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim tp searches
	 * @param end the upper bound of the range of claim tp searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim tp searches
	 */
	@Override
	public List<ClaimTPSearch> findAll(
		int start, int end, OrderByComparator<ClaimTPSearch> orderByComparator,
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

		List<ClaimTPSearch> list = null;

		if (useFinderCache) {
			list = (List<ClaimTPSearch>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMTPSEARCH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMTPSEARCH;

				sql = sql.concat(ClaimTPSearchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimTPSearch>)QueryUtil.list(
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
	 * Removes all the claim tp searches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimTPSearch claimTPSearch : findAll()) {
			remove(claimTPSearch);
		}
	}

	/**
	 * Returns the number of claim tp searches.
	 *
	 * @return the number of claim tp searches
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMTPSEARCH);

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
		return "claimTPSearchPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMTPSEARCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimTPSearchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim tp search persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ClaimTPSearchModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClaimTPSearch.class.getName()));

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
		dummyEntityCache.removeCache(ClaimTPSearchImpl.class.getName());

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

	private static final String _SQL_SELECT_CLAIMTPSEARCH =
		"SELECT claimTPSearch FROM ClaimTPSearch claimTPSearch";

	private static final String _SQL_COUNT_CLAIMTPSEARCH =
		"SELECT COUNT(claimTPSearch) FROM ClaimTPSearch claimTPSearch";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimTPSearch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimTPSearch exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimTPSearchPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"reportNo", "tpId", "tpDriverName", "tpAge", "vehicleSEQCustom",
			"tpMobileNo", "tpNationality"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"reportNo", "tpId"});

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

	private static class ClaimTPSearchModelArgumentsResolver
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

			ClaimTPSearchModelImpl claimTPSearchModelImpl =
				(ClaimTPSearchModelImpl)baseModel;

			long columnBitmask = claimTPSearchModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(claimTPSearchModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						claimTPSearchModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(claimTPSearchModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ClaimTPSearchModelImpl claimTPSearchModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						claimTPSearchModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = claimTPSearchModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}