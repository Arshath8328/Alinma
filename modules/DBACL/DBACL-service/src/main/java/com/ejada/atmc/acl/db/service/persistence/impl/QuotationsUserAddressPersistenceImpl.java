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

import com.ejada.atmc.acl.db.exception.NoSuchQuotationsUserAddressException;
import com.ejada.atmc.acl.db.model.QuotationsUserAddress;
import com.ejada.atmc.acl.db.model.impl.QuotationsUserAddressImpl;
import com.ejada.atmc.acl.db.model.impl.QuotationsUserAddressModelImpl;
import com.ejada.atmc.acl.db.service.persistence.QuotationsUserAddressPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the quotations user address service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = QuotationsUserAddressPersistence.class)
public class QuotationsUserAddressPersistenceImpl
	extends BasePersistenceImpl<QuotationsUserAddress>
	implements QuotationsUserAddressPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>QuotationsUserAddressUtil</code> to access the quotations user address persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		QuotationsUserAddressImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByQuotationIdDriverId;
	private FinderPath _finderPathCountByQuotationIdDriverId;

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a matching quotations user address could not be found
	 */
	@Override
	public QuotationsUserAddress findByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws NoSuchQuotationsUserAddressException {

		QuotationsUserAddress quotationsUserAddress =
			fetchByQuotationIdDriverId(quotationId, driverId, isNatAddress);

		if (quotationsUserAddress == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("quotationId=");
			sb.append(quotationId);

			sb.append(", driverId=");
			sb.append(driverId);

			sb.append(", isNatAddress=");
			sb.append(isNatAddress);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchQuotationsUserAddressException(sb.toString());
		}

		return quotationsUserAddress;
	}

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	@Override
	public QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress) {

		return fetchByQuotationIdDriverId(
			quotationId, driverId, isNatAddress, true);
	}

	/**
	 * Returns the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching quotations user address, or <code>null</code> if a matching quotations user address could not be found
	 */
	@Override
	public QuotationsUserAddress fetchByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress,
		boolean useFinderCache) {

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {quotationId, driverId, isNatAddress};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByQuotationIdDriverId, finderArgs, this);
		}

		if (result instanceof QuotationsUserAddress) {
			QuotationsUserAddress quotationsUserAddress =
				(QuotationsUserAddress)result;

			if ((quotationId != quotationsUserAddress.getQuotationId()) ||
				(driverId != quotationsUserAddress.getDriverId()) ||
				(isNatAddress != quotationsUserAddress.isIsNatAddress())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_QUOTATIONSUSERADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_ISNATADDRESS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				queryPos.add(driverId);

				queryPos.add(isNatAddress);

				List<QuotationsUserAddress> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByQuotationIdDriverId, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									quotationId, driverId, isNatAddress
								};
							}

							_log.warn(
								"QuotationsUserAddressPersistenceImpl.fetchByQuotationIdDriverId(long, long, boolean, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					QuotationsUserAddress quotationsUserAddress = list.get(0);

					result = quotationsUserAddress;

					cacheResult(quotationsUserAddress);
				}
			}
			catch (Exception exception) {
				throw processException(exception);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (QuotationsUserAddress)result;
		}
	}

	/**
	 * Removes the quotations user address where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63; from the database.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the quotations user address that was removed
	 */
	@Override
	public QuotationsUserAddress removeByQuotationIdDriverId(
			long quotationId, long driverId, boolean isNatAddress)
		throws NoSuchQuotationsUserAddressException {

		QuotationsUserAddress quotationsUserAddress = findByQuotationIdDriverId(
			quotationId, driverId, isNatAddress);

		return remove(quotationsUserAddress);
	}

	/**
	 * Returns the number of quotations user addresses where quotationId = &#63; and driverId = &#63; and isNatAddress = &#63;.
	 *
	 * @param quotationId the quotation ID
	 * @param driverId the driver ID
	 * @param isNatAddress the is nat address
	 * @return the number of matching quotations user addresses
	 */
	@Override
	public int countByQuotationIdDriverId(
		long quotationId, long driverId, boolean isNatAddress) {

		FinderPath finderPath = _finderPathCountByQuotationIdDriverId;

		Object[] finderArgs = new Object[] {
			quotationId, driverId, isNatAddress
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_QUOTATIONSUSERADDRESS_WHERE);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2);

			sb.append(_FINDER_COLUMN_QUOTATIONIDDRIVERID_ISNATADDRESS_2);

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				queryPos.add(quotationId);

				queryPos.add(driverId);

				queryPos.add(isNatAddress);

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
		_FINDER_COLUMN_QUOTATIONIDDRIVERID_QUOTATIONID_2 =
			"quotationsUserAddress.quotationId = ? AND ";

	private static final String _FINDER_COLUMN_QUOTATIONIDDRIVERID_DRIVERID_2 =
		"quotationsUserAddress.driverId = ? AND ";

	private static final String
		_FINDER_COLUMN_QUOTATIONIDDRIVERID_ISNATADDRESS_2 =
			"quotationsUserAddress.isNatAddress = ?";

	public QuotationsUserAddressPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("userAddressId", "USER_ADDRESS_ID");
		dbColumnNames.put("driverId", "DRIVER_ID");
		dbColumnNames.put("quotationId", "QUOTATIONS_ID");
		dbColumnNames.put("buildNo", "BUILD_NO");
		dbColumnNames.put("zipCode", "ZIP_CODE");
		dbColumnNames.put("addNo", "ADD_NO");
		dbColumnNames.put("stNameEn", "ST_NAME_EN");
		dbColumnNames.put("stNameAr", "ST_NAME_AR");
		dbColumnNames.put("districtEn", "DISTRICT_EN");
		dbColumnNames.put("districtAr", "DISTRICT_AR");
		dbColumnNames.put("cityEn", "CITY_EN");
		dbColumnNames.put("cityAr", "CITY_AR");
		dbColumnNames.put("isNatAddress", "IS_NAT_ADDRESS");

		setDBColumnNames(dbColumnNames);

		setModelClass(QuotationsUserAddress.class);

		setModelImplClass(QuotationsUserAddressImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the quotations user address in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddress the quotations user address
	 */
	@Override
	public void cacheResult(QuotationsUserAddress quotationsUserAddress) {
		dummyEntityCache.putResult(
			QuotationsUserAddressImpl.class,
			quotationsUserAddress.getPrimaryKey(), quotationsUserAddress);

		dummyFinderCache.putResult(
			_finderPathFetchByQuotationIdDriverId,
			new Object[] {
				quotationsUserAddress.getQuotationId(),
				quotationsUserAddress.getDriverId(),
				quotationsUserAddress.isIsNatAddress()
			},
			quotationsUserAddress);
	}

	/**
	 * Caches the quotations user addresses in the entity cache if it is enabled.
	 *
	 * @param quotationsUserAddresses the quotations user addresses
	 */
	@Override
	public void cacheResult(
		List<QuotationsUserAddress> quotationsUserAddresses) {

		for (QuotationsUserAddress quotationsUserAddress :
				quotationsUserAddresses) {

			if (dummyEntityCache.getResult(
					QuotationsUserAddressImpl.class,
					quotationsUserAddress.getPrimaryKey()) == null) {

				cacheResult(quotationsUserAddress);
			}
		}
	}

	/**
	 * Clears the cache for all quotations user addresses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(QuotationsUserAddressImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the quotations user address.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(QuotationsUserAddress quotationsUserAddress) {
		dummyEntityCache.removeResult(
			QuotationsUserAddressImpl.class, quotationsUserAddress);
	}

	@Override
	public void clearCache(
		List<QuotationsUserAddress> quotationsUserAddresses) {

		for (QuotationsUserAddress quotationsUserAddress :
				quotationsUserAddresses) {

			dummyEntityCache.removeResult(
				QuotationsUserAddressImpl.class, quotationsUserAddress);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				QuotationsUserAddressImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		QuotationsUserAddressModelImpl quotationsUserAddressModelImpl) {

		Object[] args = new Object[] {
			quotationsUserAddressModelImpl.getQuotationId(),
			quotationsUserAddressModelImpl.getDriverId(),
			quotationsUserAddressModelImpl.isIsNatAddress()
		};

		dummyFinderCache.putResult(
			_finderPathCountByQuotationIdDriverId, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByQuotationIdDriverId, args,
			quotationsUserAddressModelImpl, false);
	}

	/**
	 * Creates a new quotations user address with the primary key. Does not add the quotations user address to the database.
	 *
	 * @param userAddressId the primary key for the new quotations user address
	 * @return the new quotations user address
	 */
	@Override
	public QuotationsUserAddress create(long userAddressId) {
		QuotationsUserAddress quotationsUserAddress =
			new QuotationsUserAddressImpl();

		quotationsUserAddress.setNew(true);
		quotationsUserAddress.setPrimaryKey(userAddressId);

		return quotationsUserAddress;
	}

	/**
	 * Removes the quotations user address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address that was removed
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	@Override
	public QuotationsUserAddress remove(long userAddressId)
		throws NoSuchQuotationsUserAddressException {

		return remove((Serializable)userAddressId);
	}

	/**
	 * Removes the quotations user address with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the quotations user address
	 * @return the quotations user address that was removed
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	@Override
	public QuotationsUserAddress remove(Serializable primaryKey)
		throws NoSuchQuotationsUserAddressException {

		Session session = null;

		try {
			session = openSession();

			QuotationsUserAddress quotationsUserAddress =
				(QuotationsUserAddress)session.get(
					QuotationsUserAddressImpl.class, primaryKey);

			if (quotationsUserAddress == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchQuotationsUserAddressException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(quotationsUserAddress);
		}
		catch (NoSuchQuotationsUserAddressException noSuchEntityException) {
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
	protected QuotationsUserAddress removeImpl(
		QuotationsUserAddress quotationsUserAddress) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(quotationsUserAddress)) {
				quotationsUserAddress = (QuotationsUserAddress)session.get(
					QuotationsUserAddressImpl.class,
					quotationsUserAddress.getPrimaryKeyObj());
			}

			if (quotationsUserAddress != null) {
				session.delete(quotationsUserAddress);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (quotationsUserAddress != null) {
			clearCache(quotationsUserAddress);
		}

		return quotationsUserAddress;
	}

	@Override
	public QuotationsUserAddress updateImpl(
		QuotationsUserAddress quotationsUserAddress) {

		boolean isNew = quotationsUserAddress.isNew();

		if (!(quotationsUserAddress instanceof
				QuotationsUserAddressModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(quotationsUserAddress.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					quotationsUserAddress);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in quotationsUserAddress proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom QuotationsUserAddress implementation " +
					quotationsUserAddress.getClass());
		}

		QuotationsUserAddressModelImpl quotationsUserAddressModelImpl =
			(QuotationsUserAddressModelImpl)quotationsUserAddress;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(quotationsUserAddress);
			}
			else {
				quotationsUserAddress = (QuotationsUserAddress)session.merge(
					quotationsUserAddress);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			QuotationsUserAddressImpl.class, quotationsUserAddressModelImpl,
			false, true);

		cacheUniqueFindersCache(quotationsUserAddressModelImpl);

		if (isNew) {
			quotationsUserAddress.setNew(false);
		}

		quotationsUserAddress.resetOriginalValues();

		return quotationsUserAddress;
	}

	/**
	 * Returns the quotations user address with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the quotations user address
	 * @return the quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	@Override
	public QuotationsUserAddress findByPrimaryKey(Serializable primaryKey)
		throws NoSuchQuotationsUserAddressException {

		QuotationsUserAddress quotationsUserAddress = fetchByPrimaryKey(
			primaryKey);

		if (quotationsUserAddress == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchQuotationsUserAddressException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return quotationsUserAddress;
	}

	/**
	 * Returns the quotations user address with the primary key or throws a <code>NoSuchQuotationsUserAddressException</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address
	 * @throws NoSuchQuotationsUserAddressException if a quotations user address with the primary key could not be found
	 */
	@Override
	public QuotationsUserAddress findByPrimaryKey(long userAddressId)
		throws NoSuchQuotationsUserAddressException {

		return findByPrimaryKey((Serializable)userAddressId);
	}

	/**
	 * Returns the quotations user address with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param userAddressId the primary key of the quotations user address
	 * @return the quotations user address, or <code>null</code> if a quotations user address with the primary key could not be found
	 */
	@Override
	public QuotationsUserAddress fetchByPrimaryKey(long userAddressId) {
		return fetchByPrimaryKey((Serializable)userAddressId);
	}

	/**
	 * Returns all the quotations user addresses.
	 *
	 * @return the quotations user addresses
	 */
	@Override
	public List<QuotationsUserAddress> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @return the range of quotations user addresses
	 */
	@Override
	public List<QuotationsUserAddress> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of quotations user addresses
	 */
	@Override
	public List<QuotationsUserAddress> findAll(
		int start, int end,
		OrderByComparator<QuotationsUserAddress> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the quotations user addresses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>QuotationsUserAddressModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of quotations user addresses
	 * @param end the upper bound of the range of quotations user addresses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of quotations user addresses
	 */
	@Override
	public List<QuotationsUserAddress> findAll(
		int start, int end,
		OrderByComparator<QuotationsUserAddress> orderByComparator,
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

		List<QuotationsUserAddress> list = null;

		if (useFinderCache) {
			list = (List<QuotationsUserAddress>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_QUOTATIONSUSERADDRESS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_QUOTATIONSUSERADDRESS;

				sql = sql.concat(QuotationsUserAddressModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<QuotationsUserAddress>)QueryUtil.list(
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
	 * Removes all the quotations user addresses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (QuotationsUserAddress quotationsUserAddress : findAll()) {
			remove(quotationsUserAddress);
		}
	}

	/**
	 * Returns the number of quotations user addresses.
	 *
	 * @return the number of quotations user addresses
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(
					_SQL_COUNT_QUOTATIONSUSERADDRESS);

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
		return "USER_ADDRESS_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_QUOTATIONSUSERADDRESS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return QuotationsUserAddressModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the quotations user address persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new QuotationsUserAddressModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", QuotationsUserAddress.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByQuotationIdDriverId = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByQuotationIdDriverId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"QUOTATIONS_ID", "DRIVER_ID", "IS_NAT_ADDRESS"},
			true);

		_finderPathCountByQuotationIdDriverId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByQuotationIdDriverId",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Boolean.class.getName()
			},
			new String[] {"QUOTATIONS_ID", "DRIVER_ID", "IS_NAT_ADDRESS"},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(QuotationsUserAddressImpl.class.getName());

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

	private static final String _SQL_SELECT_QUOTATIONSUSERADDRESS =
		"SELECT quotationsUserAddress FROM QuotationsUserAddress quotationsUserAddress";

	private static final String _SQL_SELECT_QUOTATIONSUSERADDRESS_WHERE =
		"SELECT quotationsUserAddress FROM QuotationsUserAddress quotationsUserAddress WHERE ";

	private static final String _SQL_COUNT_QUOTATIONSUSERADDRESS =
		"SELECT COUNT(quotationsUserAddress) FROM QuotationsUserAddress quotationsUserAddress";

	private static final String _SQL_COUNT_QUOTATIONSUSERADDRESS_WHERE =
		"SELECT COUNT(quotationsUserAddress) FROM QuotationsUserAddress quotationsUserAddress WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"quotationsUserAddress.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No QuotationsUserAddress exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No QuotationsUserAddress exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		QuotationsUserAddressPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"userAddressId", "driverId", "quotationId", "buildNo", "zipCode",
			"addNo", "stNameEn", "stNameAr", "districtEn", "districtAr",
			"cityEn", "cityAr", "isNatAddress"
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

	private static class QuotationsUserAddressModelArgumentsResolver
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

			QuotationsUserAddressModelImpl quotationsUserAddressModelImpl =
				(QuotationsUserAddressModelImpl)baseModel;

			long columnBitmask =
				quotationsUserAddressModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					quotationsUserAddressModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						quotationsUserAddressModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					quotationsUserAddressModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			QuotationsUserAddressModelImpl quotationsUserAddressModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						quotationsUserAddressModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] =
						quotationsUserAddressModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}