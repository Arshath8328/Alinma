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

import com.ejada.atmc.acl.db.exception.NoSuchCLMSTATUSException;
import com.ejada.atmc.acl.db.model.CLMSTATUS;
import com.ejada.atmc.acl.db.model.impl.CLMSTATUSImpl;
import com.ejada.atmc.acl.db.model.impl.CLMSTATUSModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CLMSTATUSPersistence;
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
 * The persistence implementation for the clmstatus service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CLMSTATUSPersistence.class)
public class CLMSTATUSPersistenceImpl
	extends BasePersistenceImpl<CLMSTATUS> implements CLMSTATUSPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CLMSTATUSUtil</code> to access the clmstatus persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CLMSTATUSImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public CLMSTATUSPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("RefNo", "REFERENCE_NO");
		dbColumnNames.put("claimStatus", "STATUS");

		setDBColumnNames(dbColumnNames);

		setModelClass(CLMSTATUS.class);

		setModelImplClass(CLMSTATUSImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the clmstatus in the entity cache if it is enabled.
	 *
	 * @param clmstatus the clmstatus
	 */
	@Override
	public void cacheResult(CLMSTATUS clmstatus) {
		dummyEntityCache.putResult(
			CLMSTATUSImpl.class, clmstatus.getPrimaryKey(), clmstatus);
	}

	/**
	 * Caches the clmstatuses in the entity cache if it is enabled.
	 *
	 * @param clmstatuses the clmstatuses
	 */
	@Override
	public void cacheResult(List<CLMSTATUS> clmstatuses) {
		for (CLMSTATUS clmstatus : clmstatuses) {
			if (dummyEntityCache.getResult(
					CLMSTATUSImpl.class, clmstatus.getPrimaryKey()) == null) {

				cacheResult(clmstatus);
			}
		}
	}

	/**
	 * Clears the cache for all clmstatuses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(CLMSTATUSImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the clmstatus.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CLMSTATUS clmstatus) {
		dummyEntityCache.removeResult(CLMSTATUSImpl.class, clmstatus);
	}

	@Override
	public void clearCache(List<CLMSTATUS> clmstatuses) {
		for (CLMSTATUS clmstatus : clmstatuses) {
			dummyEntityCache.removeResult(CLMSTATUSImpl.class, clmstatus);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(CLMSTATUSImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new clmstatus with the primary key. Does not add the clmstatus to the database.
	 *
	 * @param RefNo the primary key for the new clmstatus
	 * @return the new clmstatus
	 */
	@Override
	public CLMSTATUS create(String RefNo) {
		CLMSTATUS clmstatus = new CLMSTATUSImpl();

		clmstatus.setNew(true);
		clmstatus.setPrimaryKey(RefNo);

		return clmstatus;
	}

	/**
	 * Removes the clmstatus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus that was removed
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	@Override
	public CLMSTATUS remove(String RefNo) throws NoSuchCLMSTATUSException {
		return remove((Serializable)RefNo);
	}

	/**
	 * Removes the clmstatus with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the clmstatus
	 * @return the clmstatus that was removed
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	@Override
	public CLMSTATUS remove(Serializable primaryKey)
		throws NoSuchCLMSTATUSException {

		Session session = null;

		try {
			session = openSession();

			CLMSTATUS clmstatus = (CLMSTATUS)session.get(
				CLMSTATUSImpl.class, primaryKey);

			if (clmstatus == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCLMSTATUSException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(clmstatus);
		}
		catch (NoSuchCLMSTATUSException noSuchEntityException) {
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
	protected CLMSTATUS removeImpl(CLMSTATUS clmstatus) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(clmstatus)) {
				clmstatus = (CLMSTATUS)session.get(
					CLMSTATUSImpl.class, clmstatus.getPrimaryKeyObj());
			}

			if (clmstatus != null) {
				session.delete(clmstatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (clmstatus != null) {
			clearCache(clmstatus);
		}

		return clmstatus;
	}

	@Override
	public CLMSTATUS updateImpl(CLMSTATUS clmstatus) {
		boolean isNew = clmstatus.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(clmstatus);
			}
			else {
				clmstatus = (CLMSTATUS)session.merge(clmstatus);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(CLMSTATUSImpl.class, clmstatus, false, true);

		if (isNew) {
			clmstatus.setNew(false);
		}

		clmstatus.resetOriginalValues();

		return clmstatus;
	}

	/**
	 * Returns the clmstatus with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the clmstatus
	 * @return the clmstatus
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	@Override
	public CLMSTATUS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCLMSTATUSException {

		CLMSTATUS clmstatus = fetchByPrimaryKey(primaryKey);

		if (clmstatus == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCLMSTATUSException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return clmstatus;
	}

	/**
	 * Returns the clmstatus with the primary key or throws a <code>NoSuchCLMSTATUSException</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus
	 * @throws NoSuchCLMSTATUSException if a clmstatus with the primary key could not be found
	 */
	@Override
	public CLMSTATUS findByPrimaryKey(String RefNo)
		throws NoSuchCLMSTATUSException {

		return findByPrimaryKey((Serializable)RefNo);
	}

	/**
	 * Returns the clmstatus with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param RefNo the primary key of the clmstatus
	 * @return the clmstatus, or <code>null</code> if a clmstatus with the primary key could not be found
	 */
	@Override
	public CLMSTATUS fetchByPrimaryKey(String RefNo) {
		return fetchByPrimaryKey((Serializable)RefNo);
	}

	/**
	 * Returns all the clmstatuses.
	 *
	 * @return the clmstatuses
	 */
	@Override
	public List<CLMSTATUS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @return the range of clmstatuses
	 */
	@Override
	public List<CLMSTATUS> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of clmstatuses
	 */
	@Override
	public List<CLMSTATUS> findAll(
		int start, int end, OrderByComparator<CLMSTATUS> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the clmstatuses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CLMSTATUSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of clmstatuses
	 * @param end the upper bound of the range of clmstatuses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of clmstatuses
	 */
	@Override
	public List<CLMSTATUS> findAll(
		int start, int end, OrderByComparator<CLMSTATUS> orderByComparator,
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

		List<CLMSTATUS> list = null;

		if (useFinderCache) {
			list = (List<CLMSTATUS>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CLMSTATUS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CLMSTATUS;

				sql = sql.concat(CLMSTATUSModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CLMSTATUS>)QueryUtil.list(
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
	 * Removes all the clmstatuses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CLMSTATUS clmstatus : findAll()) {
			remove(clmstatus);
		}
	}

	/**
	 * Returns the number of clmstatuses.
	 *
	 * @return the number of clmstatuses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CLMSTATUS);

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
		return "REFERENCE_NO";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CLMSTATUS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CLMSTATUSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the clmstatus persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CLMSTATUSModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CLMSTATUS.class.getName()));

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
		dummyEntityCache.removeCache(CLMSTATUSImpl.class.getName());

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

	private static final String _SQL_SELECT_CLMSTATUS =
		"SELECT clmstatus FROM CLMSTATUS clmstatus";

	private static final String _SQL_COUNT_CLMSTATUS =
		"SELECT COUNT(clmstatus) FROM CLMSTATUS clmstatus";

	private static final String _ORDER_BY_ENTITY_ALIAS = "clmstatus.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CLMSTATUS exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		CLMSTATUSPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {"RefNo", "claimStatus"});

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

	private static class CLMSTATUSModelArgumentsResolver
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

			CLMSTATUSModelImpl clmstatusModelImpl =
				(CLMSTATUSModelImpl)baseModel;

			long columnBitmask = clmstatusModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(clmstatusModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						clmstatusModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(clmstatusModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CLMSTATUSModelImpl clmstatusModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = clmstatusModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = clmstatusModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}