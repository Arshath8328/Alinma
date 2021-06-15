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

import com.ejada.atmc.acl.db.exception.NoSuchClaimODSearchException;
import com.ejada.atmc.acl.db.model.ClaimODSearch;
import com.ejada.atmc.acl.db.model.impl.ClaimODSearchImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimODSearchModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPK;
import com.ejada.atmc.acl.db.service.persistence.ClaimODSearchPersistence;
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
 * The persistence implementation for the claim od search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ClaimODSearchPersistence.class)
public class ClaimODSearchPersistenceImpl
	extends BasePersistenceImpl<ClaimODSearch>
	implements ClaimODSearchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ClaimODSearchUtil</code> to access the claim od search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ClaimODSearchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public ClaimODSearchPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("reportNo", "ODS_REPORT_NO");
		dbColumnNames.put("vehicleSEQCustom", "ODS_VEHICLE_SEQ_CUSTOM");
		dbColumnNames.put("vehicleDevType", "ODS_VEHICLE_DEF_TYPE");
		dbColumnNames.put("natureofLoss", "ODS_NATUREOF_LOSS");
		dbColumnNames.put("causeCode", "ODS_CAUSE_CODE");
		dbColumnNames.put("typeOfClaim", "ODS_TYPEOF_CLAIM");
		dbColumnNames.put("claimLossDate", "ODS_CLAIM_LOSS_DT");
		dbColumnNames.put("lossRemarks", "ODS_LOSS_REMARKS");
		dbColumnNames.put("faultPercent", "ODS_FAULT_PERCENT");

		setDBColumnNames(dbColumnNames);

		setModelClass(ClaimODSearch.class);

		setModelImplClass(ClaimODSearchImpl.class);
		setModelPKClass(ClaimODSearchPK.class);
	}

	/**
	 * Caches the claim od search in the entity cache if it is enabled.
	 *
	 * @param claimODSearch the claim od search
	 */
	@Override
	public void cacheResult(ClaimODSearch claimODSearch) {
		dummyEntityCache.putResult(
			ClaimODSearchImpl.class, claimODSearch.getPrimaryKey(),
			claimODSearch);
	}

	/**
	 * Caches the claim od searches in the entity cache if it is enabled.
	 *
	 * @param claimODSearches the claim od searches
	 */
	@Override
	public void cacheResult(List<ClaimODSearch> claimODSearches) {
		for (ClaimODSearch claimODSearch : claimODSearches) {
			if (dummyEntityCache.getResult(
					ClaimODSearchImpl.class, claimODSearch.getPrimaryKey()) ==
						null) {

				cacheResult(claimODSearch);
			}
		}
	}

	/**
	 * Clears the cache for all claim od searches.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ClaimODSearchImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the claim od search.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ClaimODSearch claimODSearch) {
		dummyEntityCache.removeResult(ClaimODSearchImpl.class, claimODSearch);
	}

	@Override
	public void clearCache(List<ClaimODSearch> claimODSearches) {
		for (ClaimODSearch claimODSearch : claimODSearches) {
			dummyEntityCache.removeResult(
				ClaimODSearchImpl.class, claimODSearch);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(ClaimODSearchImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new claim od search with the primary key. Does not add the claim od search to the database.
	 *
	 * @param claimODSearchPK the primary key for the new claim od search
	 * @return the new claim od search
	 */
	@Override
	public ClaimODSearch create(ClaimODSearchPK claimODSearchPK) {
		ClaimODSearch claimODSearch = new ClaimODSearchImpl();

		claimODSearch.setNew(true);
		claimODSearch.setPrimaryKey(claimODSearchPK);

		return claimODSearch;
	}

	/**
	 * Removes the claim od search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search that was removed
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	@Override
	public ClaimODSearch remove(ClaimODSearchPK claimODSearchPK)
		throws NoSuchClaimODSearchException {

		return remove((Serializable)claimODSearchPK);
	}

	/**
	 * Removes the claim od search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the claim od search
	 * @return the claim od search that was removed
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	@Override
	public ClaimODSearch remove(Serializable primaryKey)
		throws NoSuchClaimODSearchException {

		Session session = null;

		try {
			session = openSession();

			ClaimODSearch claimODSearch = (ClaimODSearch)session.get(
				ClaimODSearchImpl.class, primaryKey);

			if (claimODSearch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchClaimODSearchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(claimODSearch);
		}
		catch (NoSuchClaimODSearchException noSuchEntityException) {
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
	protected ClaimODSearch removeImpl(ClaimODSearch claimODSearch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(claimODSearch)) {
				claimODSearch = (ClaimODSearch)session.get(
					ClaimODSearchImpl.class, claimODSearch.getPrimaryKeyObj());
			}

			if (claimODSearch != null) {
				session.delete(claimODSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (claimODSearch != null) {
			clearCache(claimODSearch);
		}

		return claimODSearch;
	}

	@Override
	public ClaimODSearch updateImpl(ClaimODSearch claimODSearch) {
		boolean isNew = claimODSearch.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(claimODSearch);
			}
			else {
				claimODSearch = (ClaimODSearch)session.merge(claimODSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ClaimODSearchImpl.class, claimODSearch, false, true);

		if (isNew) {
			claimODSearch.setNew(false);
		}

		claimODSearch.resetOriginalValues();

		return claimODSearch;
	}

	/**
	 * Returns the claim od search with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the claim od search
	 * @return the claim od search
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	@Override
	public ClaimODSearch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchClaimODSearchException {

		ClaimODSearch claimODSearch = fetchByPrimaryKey(primaryKey);

		if (claimODSearch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchClaimODSearchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return claimODSearch;
	}

	/**
	 * Returns the claim od search with the primary key or throws a <code>NoSuchClaimODSearchException</code> if it could not be found.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search
	 * @throws NoSuchClaimODSearchException if a claim od search with the primary key could not be found
	 */
	@Override
	public ClaimODSearch findByPrimaryKey(ClaimODSearchPK claimODSearchPK)
		throws NoSuchClaimODSearchException {

		return findByPrimaryKey((Serializable)claimODSearchPK);
	}

	/**
	 * Returns the claim od search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param claimODSearchPK the primary key of the claim od search
	 * @return the claim od search, or <code>null</code> if a claim od search with the primary key could not be found
	 */
	@Override
	public ClaimODSearch fetchByPrimaryKey(ClaimODSearchPK claimODSearchPK) {
		return fetchByPrimaryKey((Serializable)claimODSearchPK);
	}

	/**
	 * Returns all the claim od searches.
	 *
	 * @return the claim od searches
	 */
	@Override
	public List<ClaimODSearch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @return the range of claim od searches
	 */
	@Override
	public List<ClaimODSearch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of claim od searches
	 */
	@Override
	public List<ClaimODSearch> findAll(
		int start, int end,
		OrderByComparator<ClaimODSearch> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the claim od searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ClaimODSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of claim od searches
	 * @param end the upper bound of the range of claim od searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of claim od searches
	 */
	@Override
	public List<ClaimODSearch> findAll(
		int start, int end, OrderByComparator<ClaimODSearch> orderByComparator,
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

		List<ClaimODSearch> list = null;

		if (useFinderCache) {
			list = (List<ClaimODSearch>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLAIMODSEARCH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLAIMODSEARCH;

				sql = sql.concat(ClaimODSearchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ClaimODSearch>)QueryUtil.list(
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
	 * Removes all the claim od searches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ClaimODSearch claimODSearch : findAll()) {
			remove(claimODSearch);
		}
	}

	/**
	 * Returns the number of claim od searches.
	 *
	 * @return the number of claim od searches
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLAIMODSEARCH);

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
		return "claimODSearchPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLAIMODSEARCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ClaimODSearchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the claim od search persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ClaimODSearchModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ClaimODSearch.class.getName()));

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
		dummyEntityCache.removeCache(ClaimODSearchImpl.class.getName());

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

	private static final String _SQL_SELECT_CLAIMODSEARCH =
		"SELECT claimODSearch FROM ClaimODSearch claimODSearch";

	private static final String _SQL_COUNT_CLAIMODSEARCH =
		"SELECT COUNT(claimODSearch) FROM ClaimODSearch claimODSearch";

	private static final String _ORDER_BY_ENTITY_ALIAS = "claimODSearch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ClaimODSearch exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		ClaimODSearchPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "reportNo", "vehicleSEQCustom", "vehicleDevType",
			"natureofLoss", "causeCode", "typeOfClaim", "claimLossDate",
			"lossRemarks", "faultPercent"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "reportNo", "vehicleSEQCustom"});

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

	private static class ClaimODSearchModelArgumentsResolver
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

			ClaimODSearchModelImpl claimODSearchModelImpl =
				(ClaimODSearchModelImpl)baseModel;

			long columnBitmask = claimODSearchModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(claimODSearchModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						claimODSearchModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(claimODSearchModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ClaimODSearchModelImpl claimODSearchModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						claimODSearchModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = claimODSearchModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}