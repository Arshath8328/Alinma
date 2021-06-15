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

import com.ejada.atmc.acl.db.exception.NoSuchSMSException;
import com.ejada.atmc.acl.db.model.SMS;
import com.ejada.atmc.acl.db.model.impl.SMSImpl;
import com.ejada.atmc.acl.db.model.impl.SMSModelImpl;
import com.ejada.atmc.acl.db.service.persistence.SMSPersistence;
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

import java.io.Serializable;

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
 * The persistence implementation for the Sms Table service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = SMSPersistence.class)
public class SMSPersistenceImpl
	extends BasePersistenceImpl<SMS> implements SMSPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>SMSUtil</code> to access the Sms Table persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		SMSImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public SMSPersistenceImpl() {
		setModelClass(SMS.class);

		setModelImplClass(SMSImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the Sms Table in the entity cache if it is enabled.
	 *
	 * @param sms the Sms Table
	 */
	@Override
	public void cacheResult(SMS sms) {
		dummyEntityCache.putResult(SMSImpl.class, sms.getPrimaryKey(), sms);
	}

	/**
	 * Caches the Sms Tables in the entity cache if it is enabled.
	 *
	 * @param smses the Sms Tables
	 */
	@Override
	public void cacheResult(List<SMS> smses) {
		for (SMS sms : smses) {
			if (dummyEntityCache.getResult(
					SMSImpl.class, sms.getPrimaryKey()) == null) {

				cacheResult(sms);
			}
		}
	}

	/**
	 * Clears the cache for all Sms Tables.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(SMSImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the Sms Table.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(SMS sms) {
		dummyEntityCache.removeResult(SMSImpl.class, sms);
	}

	@Override
	public void clearCache(List<SMS> smses) {
		for (SMS sms : smses) {
			dummyEntityCache.removeResult(SMSImpl.class, sms);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(SMSImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new Sms Table with the primary key. Does not add the Sms Table to the database.
	 *
	 * @param ID the primary key for the new Sms Table
	 * @return the new Sms Table
	 */
	@Override
	public SMS create(long ID) {
		SMS sms = new SMSImpl();

		sms.setNew(true);
		sms.setPrimaryKey(ID);

		return sms;
	}

	/**
	 * Removes the Sms Table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table that was removed
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	@Override
	public SMS remove(long ID) throws NoSuchSMSException {
		return remove((Serializable)ID);
	}

	/**
	 * Removes the Sms Table with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the Sms Table
	 * @return the Sms Table that was removed
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	@Override
	public SMS remove(Serializable primaryKey) throws NoSuchSMSException {
		Session session = null;

		try {
			session = openSession();

			SMS sms = (SMS)session.get(SMSImpl.class, primaryKey);

			if (sms == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSMSException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(sms);
		}
		catch (NoSuchSMSException noSuchEntityException) {
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
	protected SMS removeImpl(SMS sms) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(sms)) {
				sms = (SMS)session.get(SMSImpl.class, sms.getPrimaryKeyObj());
			}

			if (sms != null) {
				session.delete(sms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (sms != null) {
			clearCache(sms);
		}

		return sms;
	}

	@Override
	public SMS updateImpl(SMS sms) {
		boolean isNew = sms.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(sms);
			}
			else {
				sms = (SMS)session.merge(sms);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(SMSImpl.class, sms, false, true);

		if (isNew) {
			sms.setNew(false);
		}

		sms.resetOriginalValues();

		return sms;
	}

	/**
	 * Returns the Sms Table with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the Sms Table
	 * @return the Sms Table
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSMSException {

		SMS sms = fetchByPrimaryKey(primaryKey);

		if (sms == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSMSException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return sms;
	}

	/**
	 * Returns the Sms Table with the primary key or throws a <code>NoSuchSMSException</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table
	 * @throws NoSuchSMSException if a Sms Table with the primary key could not be found
	 */
	@Override
	public SMS findByPrimaryKey(long ID) throws NoSuchSMSException {
		return findByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns the Sms Table with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ID the primary key of the Sms Table
	 * @return the Sms Table, or <code>null</code> if a Sms Table with the primary key could not be found
	 */
	@Override
	public SMS fetchByPrimaryKey(long ID) {
		return fetchByPrimaryKey((Serializable)ID);
	}

	/**
	 * Returns all the Sms Tables.
	 *
	 * @return the Sms Tables
	 */
	@Override
	public List<SMS> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @return the range of Sms Tables
	 */
	@Override
	public List<SMS> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of Sms Tables
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the Sms Tables.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>SMSModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of Sms Tables
	 * @param end the upper bound of the range of Sms Tables (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of Sms Tables
	 */
	@Override
	public List<SMS> findAll(
		int start, int end, OrderByComparator<SMS> orderByComparator,
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

		List<SMS> list = null;

		if (useFinderCache) {
			list = (List<SMS>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SMS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SMS;

				sql = sql.concat(SMSModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<SMS>)QueryUtil.list(
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
	 * Removes all the Sms Tables from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (SMS sms : findAll()) {
			remove(sms);
		}
	}

	/**
	 * Returns the number of Sms Tables.
	 *
	 * @return the number of Sms Tables
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_SMS);

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
	protected EntityCache getEntityCache() {
		return dummyEntityCache;
	}

	@Override
	protected String getPKDBName() {
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SMS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SMSModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the Sms Table persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new SMSModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", SMS.class.getName()));

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
		dummyEntityCache.removeCache(SMSImpl.class.getName());

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

	private static final String _SQL_SELECT_SMS = "SELECT sms FROM SMS sms";

	private static final String _SQL_COUNT_SMS =
		"SELECT COUNT(sms) FROM SMS sms";

	private static final String _ORDER_BY_ENTITY_ALIAS = "sms.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No SMS exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		SMSPersistenceImpl.class);

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

	private static class SMSModelArgumentsResolver
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

			SMSModelImpl smsModelImpl = (SMSModelImpl)baseModel;

			long columnBitmask = smsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(smsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |= smsModelImpl.getColumnBitmask(
						columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(smsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			SMSModelImpl smsModelImpl, String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = smsModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = smsModelImpl.getColumnValue(columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}