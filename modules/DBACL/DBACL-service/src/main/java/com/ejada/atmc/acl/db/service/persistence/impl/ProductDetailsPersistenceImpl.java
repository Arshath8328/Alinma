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

import com.ejada.atmc.acl.db.exception.NoSuchProductDetailsException;
import com.ejada.atmc.acl.db.model.ProductDetails;
import com.ejada.atmc.acl.db.model.impl.ProductDetailsImpl;
import com.ejada.atmc.acl.db.model.impl.ProductDetailsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ProductDetailsPersistence;
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
import com.liferay.portal.kernel.util.StringUtil;

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

import java.util.Collections;
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
 * The persistence implementation for the product details service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ProductDetailsPersistence.class)
public class ProductDetailsPersistenceImpl
	extends BasePersistenceImpl<ProductDetails>
	implements ProductDetailsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ProductDetailsUtil</code> to access the product details persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ProductDetailsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByProductCode;
	private FinderPath _finderPathCountByProductCode;

	/**
	 * Returns the product details where productCode = &#63; or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param productCode the product code
	 * @return the matching product details
	 * @throws NoSuchProductDetailsException if a matching product details could not be found
	 */
	@Override
	public ProductDetails findByProductCode(String productCode)
		throws NoSuchProductDetailsException {

		ProductDetails productDetails = fetchByProductCode(productCode);

		if (productDetails == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("productCode=");
			sb.append(productCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchProductDetailsException(sb.toString());
		}

		return productDetails;
	}

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param productCode the product code
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	@Override
	public ProductDetails fetchByProductCode(String productCode) {
		return fetchByProductCode(productCode, true);
	}

	/**
	 * Returns the product details where productCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param productCode the product code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching product details, or <code>null</code> if a matching product details could not be found
	 */
	@Override
	public ProductDetails fetchByProductCode(
		String productCode, boolean useFinderCache) {

		productCode = Objects.toString(productCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {productCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByProductCode, finderArgs, this);
		}

		if (result instanceof ProductDetails) {
			ProductDetails productDetails = (ProductDetails)result;

			if (!Objects.equals(productCode, productDetails.getProductCode())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_PRODUCTDETAILS_WHERE);

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductCode) {
					queryPos.add(productCode);
				}

				List<ProductDetails> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByProductCode, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {productCode};
							}

							_log.warn(
								"ProductDetailsPersistenceImpl.fetchByProductCode(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					ProductDetails productDetails = list.get(0);

					result = productDetails;

					cacheResult(productDetails);
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
			return (ProductDetails)result;
		}
	}

	/**
	 * Removes the product details where productCode = &#63; from the database.
	 *
	 * @param productCode the product code
	 * @return the product details that was removed
	 */
	@Override
	public ProductDetails removeByProductCode(String productCode)
		throws NoSuchProductDetailsException {

		ProductDetails productDetails = findByProductCode(productCode);

		return remove(productDetails);
	}

	/**
	 * Returns the number of product detailses where productCode = &#63;.
	 *
	 * @param productCode the product code
	 * @return the number of matching product detailses
	 */
	@Override
	public int countByProductCode(String productCode) {
		productCode = Objects.toString(productCode, "");

		FinderPath finderPath = _finderPathCountByProductCode;

		Object[] finderArgs = new Object[] {productCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_PRODUCTDETAILS_WHERE);

			boolean bindProductCode = false;

			if (productCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3);
			}
			else {
				bindProductCode = true;

				sb.append(_FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindProductCode) {
					queryPos.add(productCode);
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

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_2 =
		"productDetails.productCode = ?";

	private static final String _FINDER_COLUMN_PRODUCTCODE_PRODUCTCODE_3 =
		"(productDetails.productCode IS NULL OR productDetails.productCode = '')";

	public ProductDetailsPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("sysId", "MDM_PROD_SYS_ID");
		dbColumnNames.put("lobSysId", "MDM_PROD_LOB_SYS_ID");
		dbColumnNames.put("effFmDate", "MDM_PROD_EFF_FM_DT");
		dbColumnNames.put("effToDate", "MDM_PROD_EFF_TO_DT");
		dbColumnNames.put("crDate", "MDM_PROD_CR_DT");
		dbColumnNames.put("crUid", "MDM_PROD_CR_UID");
		dbColumnNames.put("updDate", "MDM_PROD_UPD_DT");
		dbColumnNames.put("updUid", "MDM_PROD_UPD_UID");
		dbColumnNames.put("productCode", "MDM_PROD_CODE");
		dbColumnNames.put("productName", "MDM_PROD_NAME");
		dbColumnNames.put("productNameAr", "MDM_PROD_NAME_AR");

		setDBColumnNames(dbColumnNames);

		setModelClass(ProductDetails.class);

		setModelImplClass(ProductDetailsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the product details in the entity cache if it is enabled.
	 *
	 * @param productDetails the product details
	 */
	@Override
	public void cacheResult(ProductDetails productDetails) {
		entityCache.putResult(
			ProductDetailsImpl.class, productDetails.getPrimaryKey(),
			productDetails);

		finderCache.putResult(
			_finderPathFetchByProductCode,
			new Object[] {productDetails.getProductCode()}, productDetails);
	}

	/**
	 * Caches the product detailses in the entity cache if it is enabled.
	 *
	 * @param productDetailses the product detailses
	 */
	@Override
	public void cacheResult(List<ProductDetails> productDetailses) {
		for (ProductDetails productDetails : productDetailses) {
			if (entityCache.getResult(
					ProductDetailsImpl.class, productDetails.getPrimaryKey()) ==
						null) {

				cacheResult(productDetails);
			}
		}
	}

	/**
	 * Clears the cache for all product detailses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(ProductDetailsImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the product details.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ProductDetails productDetails) {
		entityCache.removeResult(ProductDetailsImpl.class, productDetails);
	}

	@Override
	public void clearCache(List<ProductDetails> productDetailses) {
		for (ProductDetails productDetails : productDetailses) {
			entityCache.removeResult(ProductDetailsImpl.class, productDetails);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(ProductDetailsImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		ProductDetailsModelImpl productDetailsModelImpl) {

		Object[] args = new Object[] {productDetailsModelImpl.getProductCode()};

		finderCache.putResult(
			_finderPathCountByProductCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByProductCode, args, productDetailsModelImpl,
			false);
	}

	/**
	 * Creates a new product details with the primary key. Does not add the product details to the database.
	 *
	 * @param sysId the primary key for the new product details
	 * @return the new product details
	 */
	@Override
	public ProductDetails create(long sysId) {
		ProductDetails productDetails = new ProductDetailsImpl();

		productDetails.setNew(true);
		productDetails.setPrimaryKey(sysId);

		return productDetails;
	}

	/**
	 * Removes the product details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details that was removed
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	@Override
	public ProductDetails remove(long sysId)
		throws NoSuchProductDetailsException {

		return remove((Serializable)sysId);
	}

	/**
	 * Removes the product details with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the product details
	 * @return the product details that was removed
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	@Override
	public ProductDetails remove(Serializable primaryKey)
		throws NoSuchProductDetailsException {

		Session session = null;

		try {
			session = openSession();

			ProductDetails productDetails = (ProductDetails)session.get(
				ProductDetailsImpl.class, primaryKey);

			if (productDetails == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchProductDetailsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(productDetails);
		}
		catch (NoSuchProductDetailsException noSuchEntityException) {
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
	protected ProductDetails removeImpl(ProductDetails productDetails) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(productDetails)) {
				productDetails = (ProductDetails)session.get(
					ProductDetailsImpl.class,
					productDetails.getPrimaryKeyObj());
			}

			if (productDetails != null) {
				session.delete(productDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (productDetails != null) {
			clearCache(productDetails);
		}

		return productDetails;
	}

	@Override
	public ProductDetails updateImpl(ProductDetails productDetails) {
		boolean isNew = productDetails.isNew();

		if (!(productDetails instanceof ProductDetailsModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(productDetails.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					productDetails);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in productDetails proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ProductDetails implementation " +
					productDetails.getClass());
		}

		ProductDetailsModelImpl productDetailsModelImpl =
			(ProductDetailsModelImpl)productDetails;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(productDetails);
			}
			else {
				productDetails = (ProductDetails)session.merge(productDetails);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			ProductDetailsImpl.class, productDetailsModelImpl, false, true);

		cacheUniqueFindersCache(productDetailsModelImpl);

		if (isNew) {
			productDetails.setNew(false);
		}

		productDetails.resetOriginalValues();

		return productDetails;
	}

	/**
	 * Returns the product details with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the product details
	 * @return the product details
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	@Override
	public ProductDetails findByPrimaryKey(Serializable primaryKey)
		throws NoSuchProductDetailsException {

		ProductDetails productDetails = fetchByPrimaryKey(primaryKey);

		if (productDetails == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchProductDetailsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return productDetails;
	}

	/**
	 * Returns the product details with the primary key or throws a <code>NoSuchProductDetailsException</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details
	 * @throws NoSuchProductDetailsException if a product details with the primary key could not be found
	 */
	@Override
	public ProductDetails findByPrimaryKey(long sysId)
		throws NoSuchProductDetailsException {

		return findByPrimaryKey((Serializable)sysId);
	}

	/**
	 * Returns the product details with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param sysId the primary key of the product details
	 * @return the product details, or <code>null</code> if a product details with the primary key could not be found
	 */
	@Override
	public ProductDetails fetchByPrimaryKey(long sysId) {
		return fetchByPrimaryKey((Serializable)sysId);
	}

	/**
	 * Returns all the product detailses.
	 *
	 * @return the product detailses
	 */
	@Override
	public List<ProductDetails> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @return the range of product detailses
	 */
	@Override
	public List<ProductDetails> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of product detailses
	 */
	@Override
	public List<ProductDetails> findAll(
		int start, int end,
		OrderByComparator<ProductDetails> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the product detailses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ProductDetailsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of product detailses
	 * @param end the upper bound of the range of product detailses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of product detailses
	 */
	@Override
	public List<ProductDetails> findAll(
		int start, int end, OrderByComparator<ProductDetails> orderByComparator,
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

		List<ProductDetails> list = null;

		if (useFinderCache) {
			list = (List<ProductDetails>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_PRODUCTDETAILS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_PRODUCTDETAILS;

				sql = sql.concat(ProductDetailsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ProductDetails>)QueryUtil.list(
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
	 * Removes all the product detailses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ProductDetails productDetails : findAll()) {
			remove(productDetails);
		}
	}

	/**
	 * Returns the number of product detailses.
	 *
	 * @return the number of product detailses
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_PRODUCTDETAILS);

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
		return "MDM_PROD_SYS_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_PRODUCTDETAILS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ProductDetailsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the product details persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new ProductDetailsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ProductDetails.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByProductCode",
			new String[] {String.class.getName()},
			new String[] {"MDM_PROD_CODE"}, true);

		_finderPathCountByProductCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByProductCode",
			new String[] {String.class.getName()},
			new String[] {"MDM_PROD_CODE"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(ProductDetailsImpl.class.getName());

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

	private static final String _SQL_SELECT_PRODUCTDETAILS =
		"SELECT productDetails FROM ProductDetails productDetails";

	private static final String _SQL_SELECT_PRODUCTDETAILS_WHERE =
		"SELECT productDetails FROM ProductDetails productDetails WHERE ";

	private static final String _SQL_COUNT_PRODUCTDETAILS =
		"SELECT COUNT(productDetails) FROM ProductDetails productDetails";

	private static final String _SQL_COUNT_PRODUCTDETAILS_WHERE =
		"SELECT COUNT(productDetails) FROM ProductDetails productDetails WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "productDetails.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ProductDetails exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ProductDetails exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ProductDetailsPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"sysId", "lobSysId", "effFmDate", "effToDate", "crDate", "crUid",
			"updDate", "updUid", "productCode", "productName", "productNameAr"
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

	private static class ProductDetailsModelArgumentsResolver
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

			ProductDetailsModelImpl productDetailsModelImpl =
				(ProductDetailsModelImpl)baseModel;

			long columnBitmask = productDetailsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					productDetailsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						productDetailsModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					productDetailsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ProductDetailsModelImpl productDetailsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						productDetailsModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = productDetailsModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}