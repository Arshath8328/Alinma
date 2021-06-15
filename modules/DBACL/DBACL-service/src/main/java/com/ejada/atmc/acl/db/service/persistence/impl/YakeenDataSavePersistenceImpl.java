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

import com.ejada.atmc.acl.db.exception.NoSuchYakeenDataSaveException;
import com.ejada.atmc.acl.db.model.YakeenDataSave;
import com.ejada.atmc.acl.db.model.impl.YakeenDataSaveImpl;
import com.ejada.atmc.acl.db.model.impl.YakeenDataSaveModelImpl;
import com.ejada.atmc.acl.db.service.persistence.YakeenDataSavePersistence;
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

import java.sql.Timestamp;

import java.util.Collections;
import java.util.Date;
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
 * The persistence implementation for the yakeen data save service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = YakeenDataSavePersistence.class)
public class YakeenDataSavePersistenceImpl
	extends BasePersistenceImpl<YakeenDataSave>
	implements YakeenDataSavePersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>YakeenDataSaveUtil</code> to access the yakeen data save persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		YakeenDataSaveImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByiqamaDobStatusServiceName;
	private FinderPath _finderPathCountByiqamaDobStatusServiceName;

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave findByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = fetchByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);

		if (yakeenDataSave == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("Id=");
			sb.append(Id);

			sb.append(", dob=");
			sb.append(dob);

			sb.append(", status=");
			sb.append(status);

			sb.append(", serviceName=");
			sb.append(serviceName);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchYakeenDataSaveException(sb.toString());
		}

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName) {

		return fetchByiqamaDobStatusServiceName(
			Id, dob, status, serviceName, true);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName,
		boolean useFinderCache) {

		Id = Objects.toString(Id, "");
		status = Objects.toString(status, "");
		serviceName = Objects.toString(serviceName, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {Id, _getTime(dob), status, serviceName};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByiqamaDobStatusServiceName, finderArgs, this);
		}

		if (result instanceof YakeenDataSave) {
			YakeenDataSave yakeenDataSave = (YakeenDataSave)result;

			if (!Objects.equals(Id, yakeenDataSave.getId()) ||
				!Objects.equals(dob, yakeenDataSave.getDob()) ||
				!Objects.equals(status, yakeenDataSave.getStatus()) ||
				!Objects.equals(serviceName, yakeenDataSave.getServiceName())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_YAKEENDATASAVE_WHERE);

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_2);
			}

			boolean bindDob = false;

			if (dob == null) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_1);
			}
			else {
				bindDob = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_2);
			}

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(
					_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(Id);
				}

				if (bindDob) {
					queryPos.add(new Timestamp(dob.getTime()));
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindServiceName) {
					queryPos.add(serviceName);
				}

				List<YakeenDataSave> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByiqamaDobStatusServiceName,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									Id, _getTime(dob), status, serviceName
								};
							}

							_log.warn(
								"YakeenDataSavePersistenceImpl.fetchByiqamaDobStatusServiceName(String, Date, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					YakeenDataSave yakeenDataSave = list.get(0);

					result = yakeenDataSave;

					cacheResult(yakeenDataSave);
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
			return (YakeenDataSave)result;
		}
	}

	/**
	 * Removes the yakeen data save where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the yakeen data save that was removed
	 */
	@Override
	public YakeenDataSave removeByiqamaDobStatusServiceName(
			String Id, Date dob, String status, String serviceName)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = findByiqamaDobStatusServiceName(
			Id, dob, status, serviceName);

		return remove(yakeenDataSave);
	}

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and dob = &#63; and status = &#63; and serviceName = &#63;.
	 *
	 * @param Id the ID
	 * @param dob the dob
	 * @param status the status
	 * @param serviceName the service name
	 * @return the number of matching yakeen data saves
	 */
	@Override
	public int countByiqamaDobStatusServiceName(
		String Id, Date dob, String status, String serviceName) {

		Id = Objects.toString(Id, "");
		status = Objects.toString(status, "");
		serviceName = Objects.toString(serviceName, "");

		FinderPath finderPath = _finderPathCountByiqamaDobStatusServiceName;

		Object[] finderArgs = new Object[] {
			Id, _getTime(dob), status, serviceName
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_YAKEENDATASAVE_WHERE);

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_2);
			}

			boolean bindDob = false;

			if (dob == null) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_1);
			}
			else {
				bindDob = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_2);
			}

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(
					_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(Id);
				}

				if (bindDob) {
					queryPos.add(new Timestamp(dob.getTime()));
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindServiceName) {
					queryPos.add(serviceName);
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

	private static final String _FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_2 =
		"yakeenDataSave.Id = ? AND ";

	private static final String _FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_ID_3 =
		"(yakeenDataSave.Id IS NULL OR yakeenDataSave.Id = '') AND ";

	private static final String _FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_1 =
		"yakeenDataSave.dob IS NULL AND ";

	private static final String _FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_DOB_2 =
		"yakeenDataSave.dob = ? AND ";

	private static final String
		_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_2 =
			"yakeenDataSave.status = ? AND ";

	private static final String
		_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_STATUS_3 =
			"(yakeenDataSave.status IS NULL OR yakeenDataSave.status = '') AND ";

	private static final String
		_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_2 =
			"yakeenDataSave.serviceName = ?";

	private static final String
		_FINDER_COLUMN_IQAMADOBSTATUSSERVICENAME_SERVICENAME_3 =
			"(yakeenDataSave.serviceName IS NULL OR yakeenDataSave.serviceName = '')";

	private FinderPath _finderPathFetchByiqamaStatusServiceName;
	private FinderPath _finderPathCountByiqamaStatusServiceName;

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave findByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = fetchByiqamaStatusServiceName(
			serviceName, status, Id);

		if (yakeenDataSave == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("serviceName=");
			sb.append(serviceName);

			sb.append(", status=");
			sb.append(status);

			sb.append(", Id=");
			sb.append(Id);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchYakeenDataSaveException(sb.toString());
		}

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id) {

		return fetchByiqamaStatusServiceName(serviceName, status, Id, true);
	}

	/**
	 * Returns the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByiqamaStatusServiceName(
		String serviceName, String status, String Id, boolean useFinderCache) {

		serviceName = Objects.toString(serviceName, "");
		status = Objects.toString(status, "");
		Id = Objects.toString(Id, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {serviceName, status, Id};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByiqamaStatusServiceName, finderArgs, this);
		}

		if (result instanceof YakeenDataSave) {
			YakeenDataSave yakeenDataSave = (YakeenDataSave)result;

			if (!Objects.equals(serviceName, yakeenDataSave.getServiceName()) ||
				!Objects.equals(status, yakeenDataSave.getStatus()) ||
				!Objects.equals(Id, yakeenDataSave.getId())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_YAKEENDATASAVE_WHERE);

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_2);
			}

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindServiceName) {
					queryPos.add(serviceName);
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindId) {
					queryPos.add(Id);
				}

				List<YakeenDataSave> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByiqamaStatusServiceName,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									serviceName, status, Id
								};
							}

							_log.warn(
								"YakeenDataSavePersistenceImpl.fetchByiqamaStatusServiceName(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					YakeenDataSave yakeenDataSave = list.get(0);

					result = yakeenDataSave;

					cacheResult(yakeenDataSave);
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
			return (YakeenDataSave)result;
		}
	}

	/**
	 * Removes the yakeen data save where serviceName = &#63; and status = &#63; and Id = &#63; from the database.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the yakeen data save that was removed
	 */
	@Override
	public YakeenDataSave removeByiqamaStatusServiceName(
			String serviceName, String status, String Id)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = findByiqamaStatusServiceName(
			serviceName, status, Id);

		return remove(yakeenDataSave);
	}

	/**
	 * Returns the number of yakeen data saves where serviceName = &#63; and status = &#63; and Id = &#63;.
	 *
	 * @param serviceName the service name
	 * @param status the status
	 * @param Id the ID
	 * @return the number of matching yakeen data saves
	 */
	@Override
	public int countByiqamaStatusServiceName(
		String serviceName, String status, String Id) {

		serviceName = Objects.toString(serviceName, "");
		status = Objects.toString(status, "");
		Id = Objects.toString(Id, "");

		FinderPath finderPath = _finderPathCountByiqamaStatusServiceName;

		Object[] finderArgs = new Object[] {serviceName, status, Id};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_YAKEENDATASAVE_WHERE);

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_2);
			}

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindServiceName) {
					queryPos.add(serviceName);
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				if (bindId) {
					queryPos.add(Id);
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

	private static final String
		_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_2 =
			"yakeenDataSave.serviceName = ? AND ";

	private static final String
		_FINDER_COLUMN_IQAMASTATUSSERVICENAME_SERVICENAME_3 =
			"(yakeenDataSave.serviceName IS NULL OR yakeenDataSave.serviceName = '') AND ";

	private static final String _FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_2 =
		"yakeenDataSave.status = ? AND ";

	private static final String _FINDER_COLUMN_IQAMASTATUSSERVICENAME_STATUS_3 =
		"(yakeenDataSave.status IS NULL OR yakeenDataSave.status = '') AND ";

	private static final String _FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_2 =
		"yakeenDataSave.Id = ?";

	private static final String _FINDER_COLUMN_IQAMASTATUSSERVICENAME_ID_3 =
		"(yakeenDataSave.Id IS NULL OR yakeenDataSave.Id = '')";

	private FinderPath _finderPathFetchBycitIzenCarInfoIdSeq;
	private FinderPath _finderPathCountBycitIzenCarInfoIdSeq;

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave findBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = fetchBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);

		if (yakeenDataSave == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("Id=");
			sb.append(Id);

			sb.append(", sequenceNumber=");
			sb.append(sequenceNumber);

			sb.append(", serviceName=");
			sb.append(serviceName);

			sb.append(", status=");
			sb.append(status);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchYakeenDataSaveException(sb.toString());
		}

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status) {

		return fetchBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status, true);
	}

	/**
	 * Returns the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status,
		boolean useFinderCache) {

		Id = Objects.toString(Id, "");
		sequenceNumber = Objects.toString(sequenceNumber, "");
		serviceName = Objects.toString(serviceName, "");
		status = Objects.toString(status, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {Id, sequenceNumber, serviceName, status};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBycitIzenCarInfoIdSeq, finderArgs, this);
		}

		if (result instanceof YakeenDataSave) {
			YakeenDataSave yakeenDataSave = (YakeenDataSave)result;

			if (!Objects.equals(Id, yakeenDataSave.getId()) ||
				!Objects.equals(
					sequenceNumber, yakeenDataSave.getSequenceNumber()) ||
				!Objects.equals(serviceName, yakeenDataSave.getServiceName()) ||
				!Objects.equals(status, yakeenDataSave.getStatus())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_YAKEENDATASAVE_WHERE);

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_2);
			}

			boolean bindSequenceNumber = false;

			if (sequenceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_3);
			}
			else {
				bindSequenceNumber = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_2);
			}

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(Id);
				}

				if (bindSequenceNumber) {
					queryPos.add(sequenceNumber);
				}

				if (bindServiceName) {
					queryPos.add(serviceName);
				}

				if (bindStatus) {
					queryPos.add(status);
				}

				List<YakeenDataSave> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBycitIzenCarInfoIdSeq, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									Id, sequenceNumber, serviceName, status
								};
							}

							_log.warn(
								"YakeenDataSavePersistenceImpl.fetchBycitIzenCarInfoIdSeq(String, String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					YakeenDataSave yakeenDataSave = list.get(0);

					result = yakeenDataSave;

					cacheResult(yakeenDataSave);
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
			return (YakeenDataSave)result;
		}
	}

	/**
	 * Removes the yakeen data save where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63; from the database.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the yakeen data save that was removed
	 */
	@Override
	public YakeenDataSave removeBycitIzenCarInfoIdSeq(
			String Id, String sequenceNumber, String serviceName, String status)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = findBycitIzenCarInfoIdSeq(
			Id, sequenceNumber, serviceName, status);

		return remove(yakeenDataSave);
	}

	/**
	 * Returns the number of yakeen data saves where Id = &#63; and sequenceNumber = &#63; and serviceName = &#63; and status = &#63;.
	 *
	 * @param Id the ID
	 * @param sequenceNumber the sequence number
	 * @param serviceName the service name
	 * @param status the status
	 * @return the number of matching yakeen data saves
	 */
	@Override
	public int countBycitIzenCarInfoIdSeq(
		String Id, String sequenceNumber, String serviceName, String status) {

		Id = Objects.toString(Id, "");
		sequenceNumber = Objects.toString(sequenceNumber, "");
		serviceName = Objects.toString(serviceName, "");
		status = Objects.toString(status, "");

		FinderPath finderPath = _finderPathCountBycitIzenCarInfoIdSeq;

		Object[] finderArgs = new Object[] {
			Id, sequenceNumber, serviceName, status
		};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_YAKEENDATASAVE_WHERE);

			boolean bindId = false;

			if (Id.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_3);
			}
			else {
				bindId = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_2);
			}

			boolean bindSequenceNumber = false;

			if (sequenceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_3);
			}
			else {
				bindSequenceNumber = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_2);
			}

			boolean bindServiceName = false;

			if (serviceName.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_3);
			}
			else {
				bindServiceName = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_2);
			}

			boolean bindStatus = false;

			if (status.isEmpty()) {
				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_3);
			}
			else {
				bindStatus = true;

				sb.append(_FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindId) {
					queryPos.add(Id);
				}

				if (bindSequenceNumber) {
					queryPos.add(sequenceNumber);
				}

				if (bindServiceName) {
					queryPos.add(serviceName);
				}

				if (bindStatus) {
					queryPos.add(status);
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

	private static final String _FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_2 =
		"yakeenDataSave.Id = ? AND ";

	private static final String _FINDER_COLUMN_CITIZENCARINFOIDSEQ_ID_3 =
		"(yakeenDataSave.Id IS NULL OR yakeenDataSave.Id = '') AND ";

	private static final String
		_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_2 =
			"yakeenDataSave.sequenceNumber = ? AND ";

	private static final String
		_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SEQUENCENUMBER_3 =
			"(yakeenDataSave.sequenceNumber IS NULL OR yakeenDataSave.sequenceNumber = '') AND ";

	private static final String
		_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_2 =
			"yakeenDataSave.serviceName = ? AND ";

	private static final String
		_FINDER_COLUMN_CITIZENCARINFOIDSEQ_SERVICENAME_3 =
			"(yakeenDataSave.serviceName IS NULL OR yakeenDataSave.serviceName = '') AND ";

	private static final String _FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_2 =
		"yakeenDataSave.status = ?";

	private static final String _FINDER_COLUMN_CITIZENCARINFOIDSEQ_STATUS_3 =
		"(yakeenDataSave.status IS NULL OR yakeenDataSave.status = '')";

	private FinderPath _finderPathFetchByVehicleSequence;
	private FinderPath _finderPathCountByVehicleSequence;

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave findByVehicleSequence(String sequenceNumber)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = fetchByVehicleSequence(sequenceNumber);

		if (yakeenDataSave == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sequenceNumber=");
			sb.append(sequenceNumber);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchYakeenDataSaveException(sb.toString());
		}

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByVehicleSequence(String sequenceNumber) {
		return fetchByVehicleSequence(sequenceNumber, true);
	}

	/**
	 * Returns the yakeen data save where sequenceNumber = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sequenceNumber the sequence number
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching yakeen data save, or <code>null</code> if a matching yakeen data save could not be found
	 */
	@Override
	public YakeenDataSave fetchByVehicleSequence(
		String sequenceNumber, boolean useFinderCache) {

		sequenceNumber = Objects.toString(sequenceNumber, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sequenceNumber};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchByVehicleSequence, finderArgs, this);
		}

		if (result instanceof YakeenDataSave) {
			YakeenDataSave yakeenDataSave = (YakeenDataSave)result;

			if (!Objects.equals(
					sequenceNumber, yakeenDataSave.getSequenceNumber())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_YAKEENDATASAVE_WHERE);

			boolean bindSequenceNumber = false;

			if (sequenceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_3);
			}
			else {
				bindSequenceNumber = true;

				sb.append(_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSequenceNumber) {
					queryPos.add(sequenceNumber);
				}

				List<YakeenDataSave> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchByVehicleSequence, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {sequenceNumber};
							}

							_log.warn(
								"YakeenDataSavePersistenceImpl.fetchByVehicleSequence(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					YakeenDataSave yakeenDataSave = list.get(0);

					result = yakeenDataSave;

					cacheResult(yakeenDataSave);
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
			return (YakeenDataSave)result;
		}
	}

	/**
	 * Removes the yakeen data save where sequenceNumber = &#63; from the database.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the yakeen data save that was removed
	 */
	@Override
	public YakeenDataSave removeByVehicleSequence(String sequenceNumber)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = findByVehicleSequence(sequenceNumber);

		return remove(yakeenDataSave);
	}

	/**
	 * Returns the number of yakeen data saves where sequenceNumber = &#63;.
	 *
	 * @param sequenceNumber the sequence number
	 * @return the number of matching yakeen data saves
	 */
	@Override
	public int countByVehicleSequence(String sequenceNumber) {
		sequenceNumber = Objects.toString(sequenceNumber, "");

		FinderPath finderPath = _finderPathCountByVehicleSequence;

		Object[] finderArgs = new Object[] {sequenceNumber};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_YAKEENDATASAVE_WHERE);

			boolean bindSequenceNumber = false;

			if (sequenceNumber.isEmpty()) {
				sb.append(_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_3);
			}
			else {
				bindSequenceNumber = true;

				sb.append(_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSequenceNumber) {
					queryPos.add(sequenceNumber);
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

	private static final String
		_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_2 =
			"yakeenDataSave.sequenceNumber = ?";

	private static final String
		_FINDER_COLUMN_VEHICLESEQUENCE_SEQUENCENUMBER_3 =
			"(yakeenDataSave.sequenceNumber IS NULL OR yakeenDataSave.sequenceNumber = '')";

	public YakeenDataSavePersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("Id", "ID");
		dbColumnNames.put("OldId", "OLD_ID");
		dbColumnNames.put("sequenceNumber", "SEQUENCE_NUMBER");
		dbColumnNames.put("dob", "DOB");
		dbColumnNames.put("serviceName", "SERVICE_NAME");
		dbColumnNames.put("callingDate", "CALLING_DATE");
		dbColumnNames.put("status", "STATUS");
		dbColumnNames.put("serviceOutput", "SERVICE_OUTPUT");
		dbColumnNames.put("serviceCalledDate", "SERVICE_CALLING_DATE");
		dbColumnNames.put("serviceErrorMessage", "SERVICE_MESSAGE");

		setDBColumnNames(dbColumnNames);

		setModelClass(YakeenDataSave.class);

		setModelImplClass(YakeenDataSaveImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the yakeen data save in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSave the yakeen data save
	 */
	@Override
	public void cacheResult(YakeenDataSave yakeenDataSave) {
		dummyEntityCache.putResult(
			YakeenDataSaveImpl.class, yakeenDataSave.getPrimaryKey(),
			yakeenDataSave);

		dummyFinderCache.putResult(
			_finderPathFetchByiqamaDobStatusServiceName,
			new Object[] {
				yakeenDataSave.getId(), yakeenDataSave.getDob(),
				yakeenDataSave.getStatus(), yakeenDataSave.getServiceName()
			},
			yakeenDataSave);

		dummyFinderCache.putResult(
			_finderPathFetchByiqamaStatusServiceName,
			new Object[] {
				yakeenDataSave.getServiceName(), yakeenDataSave.getStatus(),
				yakeenDataSave.getId()
			},
			yakeenDataSave);

		dummyFinderCache.putResult(
			_finderPathFetchBycitIzenCarInfoIdSeq,
			new Object[] {
				yakeenDataSave.getId(), yakeenDataSave.getSequenceNumber(),
				yakeenDataSave.getServiceName(), yakeenDataSave.getStatus()
			},
			yakeenDataSave);

		dummyFinderCache.putResult(
			_finderPathFetchByVehicleSequence,
			new Object[] {yakeenDataSave.getSequenceNumber()}, yakeenDataSave);
	}

	/**
	 * Caches the yakeen data saves in the entity cache if it is enabled.
	 *
	 * @param yakeenDataSaves the yakeen data saves
	 */
	@Override
	public void cacheResult(List<YakeenDataSave> yakeenDataSaves) {
		for (YakeenDataSave yakeenDataSave : yakeenDataSaves) {
			if (dummyEntityCache.getResult(
					YakeenDataSaveImpl.class, yakeenDataSave.getPrimaryKey()) ==
						null) {

				cacheResult(yakeenDataSave);
			}
		}
	}

	/**
	 * Clears the cache for all yakeen data saves.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(YakeenDataSaveImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the yakeen data save.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(YakeenDataSave yakeenDataSave) {
		dummyEntityCache.removeResult(YakeenDataSaveImpl.class, yakeenDataSave);
	}

	@Override
	public void clearCache(List<YakeenDataSave> yakeenDataSaves) {
		for (YakeenDataSave yakeenDataSave : yakeenDataSaves) {
			dummyEntityCache.removeResult(
				YakeenDataSaveImpl.class, yakeenDataSave);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(YakeenDataSaveImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		YakeenDataSaveModelImpl yakeenDataSaveModelImpl) {

		Object[] args = new Object[] {
			yakeenDataSaveModelImpl.getId(),
			_getTime(yakeenDataSaveModelImpl.getDob()),
			yakeenDataSaveModelImpl.getStatus(),
			yakeenDataSaveModelImpl.getServiceName()
		};

		dummyFinderCache.putResult(
			_finderPathCountByiqamaDobStatusServiceName, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByiqamaDobStatusServiceName, args,
			yakeenDataSaveModelImpl, false);

		args = new Object[] {
			yakeenDataSaveModelImpl.getServiceName(),
			yakeenDataSaveModelImpl.getStatus(), yakeenDataSaveModelImpl.getId()
		};

		dummyFinderCache.putResult(
			_finderPathCountByiqamaStatusServiceName, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchByiqamaStatusServiceName, args,
			yakeenDataSaveModelImpl, false);

		args = new Object[] {
			yakeenDataSaveModelImpl.getId(),
			yakeenDataSaveModelImpl.getSequenceNumber(),
			yakeenDataSaveModelImpl.getServiceName(),
			yakeenDataSaveModelImpl.getStatus()
		};

		dummyFinderCache.putResult(
			_finderPathCountBycitIzenCarInfoIdSeq, args, Long.valueOf(1),
			false);
		dummyFinderCache.putResult(
			_finderPathFetchBycitIzenCarInfoIdSeq, args,
			yakeenDataSaveModelImpl, false);

		args = new Object[] {yakeenDataSaveModelImpl.getSequenceNumber()};

		dummyFinderCache.putResult(
			_finderPathCountByVehicleSequence, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchByVehicleSequence, args, yakeenDataSaveModelImpl,
			false);
	}

	/**
	 * Creates a new yakeen data save with the primary key. Does not add the yakeen data save to the database.
	 *
	 * @param Id the primary key for the new yakeen data save
	 * @return the new yakeen data save
	 */
	@Override
	public YakeenDataSave create(String Id) {
		YakeenDataSave yakeenDataSave = new YakeenDataSaveImpl();

		yakeenDataSave.setNew(true);
		yakeenDataSave.setPrimaryKey(Id);

		return yakeenDataSave;
	}

	/**
	 * Removes the yakeen data save with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save that was removed
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	@Override
	public YakeenDataSave remove(String Id)
		throws NoSuchYakeenDataSaveException {

		return remove((Serializable)Id);
	}

	/**
	 * Removes the yakeen data save with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the yakeen data save
	 * @return the yakeen data save that was removed
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	@Override
	public YakeenDataSave remove(Serializable primaryKey)
		throws NoSuchYakeenDataSaveException {

		Session session = null;

		try {
			session = openSession();

			YakeenDataSave yakeenDataSave = (YakeenDataSave)session.get(
				YakeenDataSaveImpl.class, primaryKey);

			if (yakeenDataSave == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchYakeenDataSaveException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(yakeenDataSave);
		}
		catch (NoSuchYakeenDataSaveException noSuchEntityException) {
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
	protected YakeenDataSave removeImpl(YakeenDataSave yakeenDataSave) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(yakeenDataSave)) {
				yakeenDataSave = (YakeenDataSave)session.get(
					YakeenDataSaveImpl.class,
					yakeenDataSave.getPrimaryKeyObj());
			}

			if (yakeenDataSave != null) {
				session.delete(yakeenDataSave);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (yakeenDataSave != null) {
			clearCache(yakeenDataSave);
		}

		return yakeenDataSave;
	}

	@Override
	public YakeenDataSave updateImpl(YakeenDataSave yakeenDataSave) {
		boolean isNew = yakeenDataSave.isNew();

		if (!(yakeenDataSave instanceof YakeenDataSaveModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(yakeenDataSave.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					yakeenDataSave);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in yakeenDataSave proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom YakeenDataSave implementation " +
					yakeenDataSave.getClass());
		}

		YakeenDataSaveModelImpl yakeenDataSaveModelImpl =
			(YakeenDataSaveModelImpl)yakeenDataSave;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(yakeenDataSave);
			}
			else {
				yakeenDataSave = (YakeenDataSave)session.merge(yakeenDataSave);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			YakeenDataSaveImpl.class, yakeenDataSaveModelImpl, false, true);

		cacheUniqueFindersCache(yakeenDataSaveModelImpl);

		if (isNew) {
			yakeenDataSave.setNew(false);
		}

		yakeenDataSave.resetOriginalValues();

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the yakeen data save
	 * @return the yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	@Override
	public YakeenDataSave findByPrimaryKey(Serializable primaryKey)
		throws NoSuchYakeenDataSaveException {

		YakeenDataSave yakeenDataSave = fetchByPrimaryKey(primaryKey);

		if (yakeenDataSave == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchYakeenDataSaveException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return yakeenDataSave;
	}

	/**
	 * Returns the yakeen data save with the primary key or throws a <code>NoSuchYakeenDataSaveException</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save
	 * @throws NoSuchYakeenDataSaveException if a yakeen data save with the primary key could not be found
	 */
	@Override
	public YakeenDataSave findByPrimaryKey(String Id)
		throws NoSuchYakeenDataSaveException {

		return findByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns the yakeen data save with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param Id the primary key of the yakeen data save
	 * @return the yakeen data save, or <code>null</code> if a yakeen data save with the primary key could not be found
	 */
	@Override
	public YakeenDataSave fetchByPrimaryKey(String Id) {
		return fetchByPrimaryKey((Serializable)Id);
	}

	/**
	 * Returns all the yakeen data saves.
	 *
	 * @return the yakeen data saves
	 */
	@Override
	public List<YakeenDataSave> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @return the range of yakeen data saves
	 */
	@Override
	public List<YakeenDataSave> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of yakeen data saves
	 */
	@Override
	public List<YakeenDataSave> findAll(
		int start, int end,
		OrderByComparator<YakeenDataSave> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the yakeen data saves.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>YakeenDataSaveModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of yakeen data saves
	 * @param end the upper bound of the range of yakeen data saves (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of yakeen data saves
	 */
	@Override
	public List<YakeenDataSave> findAll(
		int start, int end, OrderByComparator<YakeenDataSave> orderByComparator,
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

		List<YakeenDataSave> list = null;

		if (useFinderCache) {
			list = (List<YakeenDataSave>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_YAKEENDATASAVE);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_YAKEENDATASAVE;

				sql = sql.concat(YakeenDataSaveModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<YakeenDataSave>)QueryUtil.list(
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
	 * Removes all the yakeen data saves from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (YakeenDataSave yakeenDataSave : findAll()) {
			remove(yakeenDataSave);
		}
	}

	/**
	 * Returns the number of yakeen data saves.
	 *
	 * @return the number of yakeen data saves
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_YAKEENDATASAVE);

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
		return "ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_YAKEENDATASAVE;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return YakeenDataSaveModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the yakeen data save persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new YakeenDataSaveModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", YakeenDataSave.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByiqamaDobStatusServiceName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByiqamaDobStatusServiceName",
			new String[] {
				String.class.getName(), Date.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"ID", "DOB", "STATUS", "SERVICE_NAME"}, true);

		_finderPathCountByiqamaDobStatusServiceName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByiqamaDobStatusServiceName",
			new String[] {
				String.class.getName(), Date.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"ID", "DOB", "STATUS", "SERVICE_NAME"}, false);

		_finderPathFetchByiqamaStatusServiceName = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByiqamaStatusServiceName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"SERVICE_NAME", "STATUS", "ID"}, true);

		_finderPathCountByiqamaStatusServiceName = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByiqamaStatusServiceName",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"SERVICE_NAME", "STATUS", "ID"}, false);

		_finderPathFetchBycitIzenCarInfoIdSeq = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBycitIzenCarInfoIdSeq",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"ID", "SEQUENCE_NUMBER", "SERVICE_NAME", "STATUS"},
			true);

		_finderPathCountBycitIzenCarInfoIdSeq = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBycitIzenCarInfoIdSeq",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {"ID", "SEQUENCE_NUMBER", "SERVICE_NAME", "STATUS"},
			false);

		_finderPathFetchByVehicleSequence = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByVehicleSequence",
			new String[] {String.class.getName()},
			new String[] {"SEQUENCE_NUMBER"}, true);

		_finderPathCountByVehicleSequence = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByVehicleSequence",
			new String[] {String.class.getName()},
			new String[] {"SEQUENCE_NUMBER"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(YakeenDataSaveImpl.class.getName());

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

	private static Long _getTime(Date date) {
		if (date == null) {
			return null;
		}

		return date.getTime();
	}

	private static final String _SQL_SELECT_YAKEENDATASAVE =
		"SELECT yakeenDataSave FROM YakeenDataSave yakeenDataSave";

	private static final String _SQL_SELECT_YAKEENDATASAVE_WHERE =
		"SELECT yakeenDataSave FROM YakeenDataSave yakeenDataSave WHERE ";

	private static final String _SQL_COUNT_YAKEENDATASAVE =
		"SELECT COUNT(yakeenDataSave) FROM YakeenDataSave yakeenDataSave";

	private static final String _SQL_COUNT_YAKEENDATASAVE_WHERE =
		"SELECT COUNT(yakeenDataSave) FROM YakeenDataSave yakeenDataSave WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "yakeenDataSave.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No YakeenDataSave exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No YakeenDataSave exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		YakeenDataSavePersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"Id", "OldId", "sequenceNumber", "dob", "serviceName",
			"callingDate", "status", "serviceOutput", "serviceCalledDate",
			"serviceErrorMessage"
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

	private static class YakeenDataSaveModelArgumentsResolver
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

			YakeenDataSaveModelImpl yakeenDataSaveModelImpl =
				(YakeenDataSaveModelImpl)baseModel;

			long columnBitmask = yakeenDataSaveModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					yakeenDataSaveModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						yakeenDataSaveModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					yakeenDataSaveModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			YakeenDataSaveModelImpl yakeenDataSaveModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						yakeenDataSaveModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = yakeenDataSaveModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}