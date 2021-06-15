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

import com.ejada.atmc.acl.db.exception.NoSuchPolVEHSearchException;
import com.ejada.atmc.acl.db.model.PolVEHSearch;
import com.ejada.atmc.acl.db.model.impl.PolVEHSearchImpl;
import com.ejada.atmc.acl.db.model.impl.PolVEHSearchModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPK;
import com.ejada.atmc.acl.db.service.persistence.PolVEHSearchPersistence;
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
 * The persistence implementation for the pol veh search service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolVEHSearchPersistence.class)
public class PolVEHSearchPersistenceImpl
	extends BasePersistenceImpl<PolVEHSearch>
	implements PolVEHSearchPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolVEHSearchUtil</code> to access the pol veh search persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolVEHSearchImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PolVEHSearchPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("vehicleSEQCustom", "ODS_VEHICLE_SEQ_CUSTOM");
		dbColumnNames.put("chassisNo", "ODS_CHASSIS_NO");
		dbColumnNames.put("vehicleDevType", "ODS_VEHICLE_DEF_TYPE");
		dbColumnNames.put("inceptionDate", "ODS_INCEPTION_DT");
		dbColumnNames.put("expiryDate", "ODS_EXPIRY_DT");
		dbColumnNames.put("engPlateNo", "ODS_ENG_PLATE_NO");
		dbColumnNames.put("engPlateL1", "ODS_ENG_PLATE_L1");
		dbColumnNames.put("engPlateL2", "ODS_ENG_PLATE_L2");
		dbColumnNames.put("engPlateL3", "ODS_ENG_PLATE_L3");
		dbColumnNames.put("arbPlateNo", "ODS_ARB_PLATE_NO");
		dbColumnNames.put("arbPlateL1", "ODS_ARB_PLATE_L1");
		dbColumnNames.put("arbPlateL2", "ODS_ARB_PLATE_L2");
		dbColumnNames.put("arbPlateL3", "ODS_ARB_PLATE_L3");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolVEHSearch.class);

		setModelImplClass(PolVEHSearchImpl.class);
		setModelPKClass(PolVEHSearchPK.class);
	}

	/**
	 * Caches the pol veh search in the entity cache if it is enabled.
	 *
	 * @param polVEHSearch the pol veh search
	 */
	@Override
	public void cacheResult(PolVEHSearch polVEHSearch) {
		dummyEntityCache.putResult(
			PolVEHSearchImpl.class, polVEHSearch.getPrimaryKey(), polVEHSearch);
	}

	/**
	 * Caches the pol veh searches in the entity cache if it is enabled.
	 *
	 * @param polVEHSearches the pol veh searches
	 */
	@Override
	public void cacheResult(List<PolVEHSearch> polVEHSearches) {
		for (PolVEHSearch polVEHSearch : polVEHSearches) {
			if (dummyEntityCache.getResult(
					PolVEHSearchImpl.class, polVEHSearch.getPrimaryKey()) ==
						null) {

				cacheResult(polVEHSearch);
			}
		}
	}

	/**
	 * Clears the cache for all pol veh searches.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolVEHSearchImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the pol veh search.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolVEHSearch polVEHSearch) {
		dummyEntityCache.removeResult(PolVEHSearchImpl.class, polVEHSearch);
	}

	@Override
	public void clearCache(List<PolVEHSearch> polVEHSearches) {
		for (PolVEHSearch polVEHSearch : polVEHSearches) {
			dummyEntityCache.removeResult(PolVEHSearchImpl.class, polVEHSearch);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolVEHSearchImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new pol veh search with the primary key. Does not add the pol veh search to the database.
	 *
	 * @param polVEHSearchPK the primary key for the new pol veh search
	 * @return the new pol veh search
	 */
	@Override
	public PolVEHSearch create(PolVEHSearchPK polVEHSearchPK) {
		PolVEHSearch polVEHSearch = new PolVEHSearchImpl();

		polVEHSearch.setNew(true);
		polVEHSearch.setPrimaryKey(polVEHSearchPK);

		return polVEHSearch;
	}

	/**
	 * Removes the pol veh search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search that was removed
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	@Override
	public PolVEHSearch remove(PolVEHSearchPK polVEHSearchPK)
		throws NoSuchPolVEHSearchException {

		return remove((Serializable)polVEHSearchPK);
	}

	/**
	 * Removes the pol veh search with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the pol veh search
	 * @return the pol veh search that was removed
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	@Override
	public PolVEHSearch remove(Serializable primaryKey)
		throws NoSuchPolVEHSearchException {

		Session session = null;

		try {
			session = openSession();

			PolVEHSearch polVEHSearch = (PolVEHSearch)session.get(
				PolVEHSearchImpl.class, primaryKey);

			if (polVEHSearch == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolVEHSearchException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(polVEHSearch);
		}
		catch (NoSuchPolVEHSearchException noSuchEntityException) {
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
	protected PolVEHSearch removeImpl(PolVEHSearch polVEHSearch) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(polVEHSearch)) {
				polVEHSearch = (PolVEHSearch)session.get(
					PolVEHSearchImpl.class, polVEHSearch.getPrimaryKeyObj());
			}

			if (polVEHSearch != null) {
				session.delete(polVEHSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (polVEHSearch != null) {
			clearCache(polVEHSearch);
		}

		return polVEHSearch;
	}

	@Override
	public PolVEHSearch updateImpl(PolVEHSearch polVEHSearch) {
		boolean isNew = polVEHSearch.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(polVEHSearch);
			}
			else {
				polVEHSearch = (PolVEHSearch)session.merge(polVEHSearch);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolVEHSearchImpl.class, polVEHSearch, false, true);

		if (isNew) {
			polVEHSearch.setNew(false);
		}

		polVEHSearch.resetOriginalValues();

		return polVEHSearch;
	}

	/**
	 * Returns the pol veh search with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the pol veh search
	 * @return the pol veh search
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	@Override
	public PolVEHSearch findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolVEHSearchException {

		PolVEHSearch polVEHSearch = fetchByPrimaryKey(primaryKey);

		if (polVEHSearch == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolVEHSearchException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return polVEHSearch;
	}

	/**
	 * Returns the pol veh search with the primary key or throws a <code>NoSuchPolVEHSearchException</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search
	 * @throws NoSuchPolVEHSearchException if a pol veh search with the primary key could not be found
	 */
	@Override
	public PolVEHSearch findByPrimaryKey(PolVEHSearchPK polVEHSearchPK)
		throws NoSuchPolVEHSearchException {

		return findByPrimaryKey((Serializable)polVEHSearchPK);
	}

	/**
	 * Returns the pol veh search with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param polVEHSearchPK the primary key of the pol veh search
	 * @return the pol veh search, or <code>null</code> if a pol veh search with the primary key could not be found
	 */
	@Override
	public PolVEHSearch fetchByPrimaryKey(PolVEHSearchPK polVEHSearchPK) {
		return fetchByPrimaryKey((Serializable)polVEHSearchPK);
	}

	/**
	 * Returns all the pol veh searches.
	 *
	 * @return the pol veh searches
	 */
	@Override
	public List<PolVEHSearch> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @return the range of pol veh searches
	 */
	@Override
	public List<PolVEHSearch> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of pol veh searches
	 */
	@Override
	public List<PolVEHSearch> findAll(
		int start, int end, OrderByComparator<PolVEHSearch> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the pol veh searches.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolVEHSearchModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of pol veh searches
	 * @param end the upper bound of the range of pol veh searches (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of pol veh searches
	 */
	@Override
	public List<PolVEHSearch> findAll(
		int start, int end, OrderByComparator<PolVEHSearch> orderByComparator,
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

		List<PolVEHSearch> list = null;

		if (useFinderCache) {
			list = (List<PolVEHSearch>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLVEHSEARCH);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLVEHSEARCH;

				sql = sql.concat(PolVEHSearchModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolVEHSearch>)QueryUtil.list(
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
	 * Removes all the pol veh searches from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolVEHSearch polVEHSearch : findAll()) {
			remove(polVEHSearch);
		}
	}

	/**
	 * Returns the number of pol veh searches.
	 *
	 * @return the number of pol veh searches
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLVEHSEARCH);

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
		return "polVEHSearchPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLVEHSEARCH;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolVEHSearchModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the pol veh search persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolVEHSearchModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolVEHSearch.class.getName()));

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
		dummyEntityCache.removeCache(PolVEHSearchImpl.class.getName());

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

	private static final String _SQL_SELECT_POLVEHSEARCH =
		"SELECT polVEHSearch FROM PolVEHSearch polVEHSearch";

	private static final String _SQL_COUNT_POLVEHSEARCH =
		"SELECT COUNT(polVEHSearch) FROM PolVEHSearch polVEHSearch";

	private static final String _ORDER_BY_ENTITY_ALIAS = "polVEHSearch.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolVEHSearch exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PolVEHSearchPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "vehicleSEQCustom", "chassisNo", "vehicleDevType",
			"inceptionDate", "expiryDate", "engPlateNo", "engPlateL1",
			"engPlateL2", "engPlateL3", "arbPlateNo", "arbPlateL1",
			"arbPlateL2", "arbPlateL3"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "vehicleSEQCustom"});

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

	private static class PolVEHSearchModelArgumentsResolver
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

			PolVEHSearchModelImpl polVEHSearchModelImpl =
				(PolVEHSearchModelImpl)baseModel;

			long columnBitmask = polVEHSearchModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(polVEHSearchModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						polVEHSearchModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(polVEHSearchModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolVEHSearchModelImpl polVEHSearchModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = polVEHSearchModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = polVEHSearchModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}