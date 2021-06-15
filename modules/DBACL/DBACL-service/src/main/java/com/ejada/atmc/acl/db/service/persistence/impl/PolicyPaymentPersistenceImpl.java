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

import com.ejada.atmc.acl.db.exception.NoSuchPolicyPaymentException;
import com.ejada.atmc.acl.db.model.PolicyPayment;
import com.ejada.atmc.acl.db.model.impl.PolicyPaymentImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyPaymentModelImpl;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPK;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentPersistence;
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
 * The persistence implementation for the policy payment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = PolicyPaymentPersistence.class)
public class PolicyPaymentPersistenceImpl
	extends BasePersistenceImpl<PolicyPayment>
	implements PolicyPaymentPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>PolicyPaymentUtil</code> to access the policy payment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		PolicyPaymentImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;

	public PolicyPaymentPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("policyNo", "ODS_POLICY_NO");
		dbColumnNames.put("voucherNo", "ODS_VOUCHER_NO");
		dbColumnNames.put("endtNo", "ODS_ENDT_NO");
		dbColumnNames.put("claimNo", "ODS_CLAIM_NO");
		dbColumnNames.put("dueDate", "ODS_DUE_DT");
		dbColumnNames.put("docDate", "ODS_DOC_DT");
		dbColumnNames.put("amount", "ODS_AMOUNT");
		dbColumnNames.put("reference", "ODS_REFERENCE");

		setDBColumnNames(dbColumnNames);

		setModelClass(PolicyPayment.class);

		setModelImplClass(PolicyPaymentImpl.class);
		setModelPKClass(PolicyPaymentPK.class);
	}

	/**
	 * Caches the policy payment in the entity cache if it is enabled.
	 *
	 * @param policyPayment the policy payment
	 */
	@Override
	public void cacheResult(PolicyPayment policyPayment) {
		dummyEntityCache.putResult(
			PolicyPaymentImpl.class, policyPayment.getPrimaryKey(),
			policyPayment);
	}

	/**
	 * Caches the policy payments in the entity cache if it is enabled.
	 *
	 * @param policyPayments the policy payments
	 */
	@Override
	public void cacheResult(List<PolicyPayment> policyPayments) {
		for (PolicyPayment policyPayment : policyPayments) {
			if (dummyEntityCache.getResult(
					PolicyPaymentImpl.class, policyPayment.getPrimaryKey()) ==
						null) {

				cacheResult(policyPayment);
			}
		}
	}

	/**
	 * Clears the cache for all policy payments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(PolicyPaymentImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the policy payment.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(PolicyPayment policyPayment) {
		dummyEntityCache.removeResult(PolicyPaymentImpl.class, policyPayment);
	}

	@Override
	public void clearCache(List<PolicyPayment> policyPayments) {
		for (PolicyPayment policyPayment : policyPayments) {
			dummyEntityCache.removeResult(
				PolicyPaymentImpl.class, policyPayment);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(PolicyPaymentImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new policy payment with the primary key. Does not add the policy payment to the database.
	 *
	 * @param policyPaymentPK the primary key for the new policy payment
	 * @return the new policy payment
	 */
	@Override
	public PolicyPayment create(PolicyPaymentPK policyPaymentPK) {
		PolicyPayment policyPayment = new PolicyPaymentImpl();

		policyPayment.setNew(true);
		policyPayment.setPrimaryKey(policyPaymentPK);

		return policyPayment;
	}

	/**
	 * Removes the policy payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment that was removed
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	@Override
	public PolicyPayment remove(PolicyPaymentPK policyPaymentPK)
		throws NoSuchPolicyPaymentException {

		return remove((Serializable)policyPaymentPK);
	}

	/**
	 * Removes the policy payment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the policy payment
	 * @return the policy payment that was removed
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	@Override
	public PolicyPayment remove(Serializable primaryKey)
		throws NoSuchPolicyPaymentException {

		Session session = null;

		try {
			session = openSession();

			PolicyPayment policyPayment = (PolicyPayment)session.get(
				PolicyPaymentImpl.class, primaryKey);

			if (policyPayment == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchPolicyPaymentException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(policyPayment);
		}
		catch (NoSuchPolicyPaymentException noSuchEntityException) {
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
	protected PolicyPayment removeImpl(PolicyPayment policyPayment) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(policyPayment)) {
				policyPayment = (PolicyPayment)session.get(
					PolicyPaymentImpl.class, policyPayment.getPrimaryKeyObj());
			}

			if (policyPayment != null) {
				session.delete(policyPayment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (policyPayment != null) {
			clearCache(policyPayment);
		}

		return policyPayment;
	}

	@Override
	public PolicyPayment updateImpl(PolicyPayment policyPayment) {
		boolean isNew = policyPayment.isNew();

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(policyPayment);
			}
			else {
				policyPayment = (PolicyPayment)session.merge(policyPayment);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			PolicyPaymentImpl.class, policyPayment, false, true);

		if (isNew) {
			policyPayment.setNew(false);
		}

		policyPayment.resetOriginalValues();

		return policyPayment;
	}

	/**
	 * Returns the policy payment with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the policy payment
	 * @return the policy payment
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	@Override
	public PolicyPayment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchPolicyPaymentException {

		PolicyPayment policyPayment = fetchByPrimaryKey(primaryKey);

		if (policyPayment == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchPolicyPaymentException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return policyPayment;
	}

	/**
	 * Returns the policy payment with the primary key or throws a <code>NoSuchPolicyPaymentException</code> if it could not be found.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment
	 * @throws NoSuchPolicyPaymentException if a policy payment with the primary key could not be found
	 */
	@Override
	public PolicyPayment findByPrimaryKey(PolicyPaymentPK policyPaymentPK)
		throws NoSuchPolicyPaymentException {

		return findByPrimaryKey((Serializable)policyPaymentPK);
	}

	/**
	 * Returns the policy payment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param policyPaymentPK the primary key of the policy payment
	 * @return the policy payment, or <code>null</code> if a policy payment with the primary key could not be found
	 */
	@Override
	public PolicyPayment fetchByPrimaryKey(PolicyPaymentPK policyPaymentPK) {
		return fetchByPrimaryKey((Serializable)policyPaymentPK);
	}

	/**
	 * Returns all the policy payments.
	 *
	 * @return the policy payments
	 */
	@Override
	public List<PolicyPayment> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @return the range of policy payments
	 */
	@Override
	public List<PolicyPayment> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of policy payments
	 */
	@Override
	public List<PolicyPayment> findAll(
		int start, int end,
		OrderByComparator<PolicyPayment> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the policy payments.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>PolicyPaymentModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of policy payments
	 * @param end the upper bound of the range of policy payments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of policy payments
	 */
	@Override
	public List<PolicyPayment> findAll(
		int start, int end, OrderByComparator<PolicyPayment> orderByComparator,
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

		List<PolicyPayment> list = null;

		if (useFinderCache) {
			list = (List<PolicyPayment>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_POLICYPAYMENT);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_POLICYPAYMENT;

				sql = sql.concat(PolicyPaymentModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<PolicyPayment>)QueryUtil.list(
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
	 * Removes all the policy payments from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (PolicyPayment policyPayment : findAll()) {
			remove(policyPayment);
		}
	}

	/**
	 * Returns the number of policy payments.
	 *
	 * @return the number of policy payments
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_POLICYPAYMENT);

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
		return "policyPaymentPK";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_POLICYPAYMENT;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return PolicyPaymentModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the policy payment persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new PolicyPaymentModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", PolicyPayment.class.getName()));

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
		dummyEntityCache.removeCache(PolicyPaymentImpl.class.getName());

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

	private static final String _SQL_SELECT_POLICYPAYMENT =
		"SELECT policyPayment FROM PolicyPayment policyPayment";

	private static final String _SQL_COUNT_POLICYPAYMENT =
		"SELECT COUNT(policyPayment) FROM PolicyPayment policyPayment";

	private static final String _ORDER_BY_ENTITY_ALIAS = "policyPayment.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No PolicyPayment exists with the primary key ";

	private static final Log _log = LogFactoryUtil.getLog(
		PolicyPaymentPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"policyNo", "voucherNo", "endtNo", "claimNo", "dueDate", "docDate",
			"amount", "reference"
		});
	private static final Set<String> _compoundPKColumnNames = SetUtil.fromArray(
		new String[] {"policyNo", "voucherNo"});

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

	private static class PolicyPaymentModelArgumentsResolver
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

			PolicyPaymentModelImpl policyPaymentModelImpl =
				(PolicyPaymentModelImpl)baseModel;

			long columnBitmask = policyPaymentModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(policyPaymentModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						policyPaymentModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(policyPaymentModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			PolicyPaymentModelImpl policyPaymentModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						policyPaymentModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = policyPaymentModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}