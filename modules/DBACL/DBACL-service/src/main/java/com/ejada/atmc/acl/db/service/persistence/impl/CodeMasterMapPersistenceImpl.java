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

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterMapException;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.impl.CodeMasterMapImpl;
import com.ejada.atmc.acl.db.model.impl.CodeMasterMapModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterMapPersistence;
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
 * The persistence implementation for the code master map service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CodeMasterMapPersistence.class)
public class CodeMasterMapPersistenceImpl
	extends BasePersistenceImpl<CodeMasterMap>
	implements CodeMasterMapPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CodeMasterMapUtil</code> to access the code master map persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CodeMasterMapImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBySourceTypeSourceCode;
	private FinderPath _finderPathCountBySourceTypeSourceCode;

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap findBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = fetchBySourceTypeSourceCode(
			sourceType, sourceCode);

		if (codeMasterMap == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sourceType=");
			sb.append(sourceType);

			sb.append(", sourceCode=");
			sb.append(sourceCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCodeMasterMapException(sb.toString());
		}

		return codeMasterMap;
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode) {

		return fetchBySourceTypeSourceCode(sourceType, sourceCode, true);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeSourceCode(
		String sourceType, String sourceCode, boolean useFinderCache) {

		sourceType = Objects.toString(sourceType, "");
		sourceCode = Objects.toString(sourceCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sourceType, sourceCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySourceTypeSourceCode, finderArgs, this);
		}

		if (result instanceof CodeMasterMap) {
			CodeMasterMap codeMasterMap = (CodeMasterMap)result;

			if (!Objects.equals(sourceType, codeMasterMap.getSourceType()) ||
				!Objects.equals(sourceCode, codeMasterMap.getSourceCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_2);
			}

			boolean bindSourceCode = false;

			if (sourceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_3);
			}
			else {
				bindSourceCode = true;

				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindSourceCode) {
					queryPos.add(sourceCode);
				}

				List<CodeMasterMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySourceTypeSourceCode, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									sourceType, sourceCode
								};
							}

							_log.warn(
								"CodeMasterMapPersistenceImpl.fetchBySourceTypeSourceCode(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CodeMasterMap codeMasterMap = list.get(0);

					result = codeMasterMap;

					cacheResult(codeMasterMap);
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
			return (CodeMasterMap)result;
		}
	}

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the code master map that was removed
	 */
	@Override
	public CodeMasterMap removeBySourceTypeSourceCode(
			String sourceType, String sourceCode)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = findBySourceTypeSourceCode(
			sourceType, sourceCode);

		return remove(codeMasterMap);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @return the number of matching code master maps
	 */
	@Override
	public int countBySourceTypeSourceCode(
		String sourceType, String sourceCode) {

		sourceType = Objects.toString(sourceType, "");
		sourceCode = Objects.toString(sourceCode, "");

		FinderPath finderPath = _finderPathCountBySourceTypeSourceCode;

		Object[] finderArgs = new Object[] {sourceType, sourceCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_2);
			}

			boolean bindSourceCode = false;

			if (sourceCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_3);
			}
			else {
				bindSourceCode = true;

				sb.append(_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindSourceCode) {
					queryPos.add(sourceCode);
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

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_2 =
			"codeMasterMap.sourceType = ? AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCETYPE_3 =
			"(codeMasterMap.sourceType IS NULL OR codeMasterMap.sourceType = '') AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_2 =
			"codeMasterMap.sourceCode = ?";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODE_SOURCECODE_3 =
			"(codeMasterMap.sourceCode IS NULL OR codeMasterMap.sourceCode = '')";

	private FinderPath _finderPathFetchBySourceTypeCoreCode;
	private FinderPath _finderPathCountBySourceTypeCoreCode;

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap findBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = fetchBySourceTypeCoreCode(
			sourceType, coreCode);

		if (codeMasterMap == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sourceType=");
			sb.append(sourceType);

			sb.append(", coreCode=");
			sb.append(coreCode);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCodeMasterMapException(sb.toString());
		}

		return codeMasterMap;
	}

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode) {

		return fetchBySourceTypeCoreCode(sourceType, coreCode, true);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and coreCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeCoreCode(
		String sourceType, String coreCode, boolean useFinderCache) {

		sourceType = Objects.toString(sourceType, "");
		coreCode = Objects.toString(coreCode, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sourceType, coreCode};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySourceTypeCoreCode, finderArgs, this);
		}

		if (result instanceof CodeMasterMap) {
			CodeMasterMap codeMasterMap = (CodeMasterMap)result;

			if (!Objects.equals(sourceType, codeMasterMap.getSourceType()) ||
				!Objects.equals(coreCode, codeMasterMap.getCoreCode())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_2);
			}

			boolean bindCoreCode = false;

			if (coreCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_3);
			}
			else {
				bindCoreCode = true;

				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindCoreCode) {
					queryPos.add(coreCode);
				}

				List<CodeMasterMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySourceTypeCoreCode, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									sourceType, coreCode
								};
							}

							_log.warn(
								"CodeMasterMapPersistenceImpl.fetchBySourceTypeCoreCode(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CodeMasterMap codeMasterMap = list.get(0);

					result = codeMasterMap;

					cacheResult(codeMasterMap);
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
			return (CodeMasterMap)result;
		}
	}

	/**
	 * Removes the code master map where sourceType = &#63; and coreCode = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the code master map that was removed
	 */
	@Override
	public CodeMasterMap removeBySourceTypeCoreCode(
			String sourceType, String coreCode)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = findBySourceTypeCoreCode(
			sourceType, coreCode);

		return remove(codeMasterMap);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and coreCode = &#63;.
	 *
	 * @param sourceType the source type
	 * @param coreCode the core code
	 * @return the number of matching code master maps
	 */
	@Override
	public int countBySourceTypeCoreCode(String sourceType, String coreCode) {
		sourceType = Objects.toString(sourceType, "");
		coreCode = Objects.toString(coreCode, "");

		FinderPath finderPath = _finderPathCountBySourceTypeCoreCode;

		Object[] finderArgs = new Object[] {sourceType, coreCode};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_2);
			}

			boolean bindCoreCode = false;

			if (coreCode.isEmpty()) {
				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_3);
			}
			else {
				bindCoreCode = true;

				sb.append(_FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindCoreCode) {
					queryPos.add(coreCode);
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

	private static final String _FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_2 =
		"codeMasterMap.sourceType = ? AND ";

	private static final String _FINDER_COLUMN_SOURCETYPECORECODE_SOURCETYPE_3 =
		"(codeMasterMap.sourceType IS NULL OR codeMasterMap.sourceType = '') AND ";

	private static final String _FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_2 =
		"codeMasterMap.coreCode = ?";

	private static final String _FINDER_COLUMN_SOURCETYPECORECODE_CORECODE_3 =
		"(codeMasterMap.coreCode IS NULL OR codeMasterMap.coreCode = '')";

	private FinderPath _finderPathFetchBySourceTypeSourceCodeLvl1Code;
	private FinderPath _finderPathCountBySourceTypeSourceCodeLvl1Code;

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map
	 * @throws NoSuchCodeMasterMapException if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap findBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = fetchBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);

		if (codeMasterMap == null) {
			StringBundler sb = new StringBundler(8);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("sourceType=");
			sb.append(sourceType);

			sb.append(", sourceCode=");
			sb.append(sourceCode);

			sb.append(", lvl1Code=");
			sb.append(lvl1Code);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCodeMasterMapException(sb.toString());
		}

		return codeMasterMap;
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code) {

		return fetchBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code, true);
	}

	/**
	 * Returns the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master map, or <code>null</code> if a matching code master map could not be found
	 */
	@Override
	public CodeMasterMap fetchBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code,
		boolean useFinderCache) {

		sourceType = Objects.toString(sourceType, "");
		sourceCode = Objects.toString(sourceCode, "");
		lvl1Code = Objects.toString(lvl1Code, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {sourceType, sourceCode, lvl1Code};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchBySourceTypeSourceCodeLvl1Code, finderArgs,
				this);
		}

		if (result instanceof CodeMasterMap) {
			CodeMasterMap codeMasterMap = (CodeMasterMap)result;

			if (!Objects.equals(sourceType, codeMasterMap.getSourceType()) ||
				!Objects.equals(sourceCode, codeMasterMap.getSourceCode()) ||
				!Objects.equals(lvl1Code, codeMasterMap.getLvl1Code())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_SELECT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_2);
			}

			boolean bindSourceCode = false;

			if (sourceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_3);
			}
			else {
				bindSourceCode = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_2);
			}

			boolean bindLvl1Code = false;

			if (lvl1Code.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_3);
			}
			else {
				bindLvl1Code = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindSourceCode) {
					queryPos.add(sourceCode);
				}

				if (bindLvl1Code) {
					queryPos.add(lvl1Code);
				}

				List<CodeMasterMap> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchBySourceTypeSourceCodeLvl1Code,
							finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									sourceType, sourceCode, lvl1Code
								};
							}

							_log.warn(
								"CodeMasterMapPersistenceImpl.fetchBySourceTypeSourceCodeLvl1Code(String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CodeMasterMap codeMasterMap = list.get(0);

					result = codeMasterMap;

					cacheResult(codeMasterMap);
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
			return (CodeMasterMap)result;
		}
	}

	/**
	 * Removes the code master map where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63; from the database.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the code master map that was removed
	 */
	@Override
	public CodeMasterMap removeBySourceTypeSourceCodeLvl1Code(
			String sourceType, String sourceCode, String lvl1Code)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = findBySourceTypeSourceCodeLvl1Code(
			sourceType, sourceCode, lvl1Code);

		return remove(codeMasterMap);
	}

	/**
	 * Returns the number of code master maps where sourceType = &#63; and sourceCode = &#63; and lvl1Code = &#63;.
	 *
	 * @param sourceType the source type
	 * @param sourceCode the source code
	 * @param lvl1Code the lvl1 code
	 * @return the number of matching code master maps
	 */
	@Override
	public int countBySourceTypeSourceCodeLvl1Code(
		String sourceType, String sourceCode, String lvl1Code) {

		sourceType = Objects.toString(sourceType, "");
		sourceCode = Objects.toString(sourceCode, "");
		lvl1Code = Objects.toString(lvl1Code, "");

		FinderPath finderPath = _finderPathCountBySourceTypeSourceCodeLvl1Code;

		Object[] finderArgs = new Object[] {sourceType, sourceCode, lvl1Code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_COUNT_CODEMASTERMAP_WHERE);

			boolean bindSourceType = false;

			if (sourceType.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_3);
			}
			else {
				bindSourceType = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_2);
			}

			boolean bindSourceCode = false;

			if (sourceCode.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_3);
			}
			else {
				bindSourceCode = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_2);
			}

			boolean bindLvl1Code = false;

			if (lvl1Code.isEmpty()) {
				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_3);
			}
			else {
				bindLvl1Code = true;

				sb.append(
					_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindSourceType) {
					queryPos.add(sourceType);
				}

				if (bindSourceCode) {
					queryPos.add(sourceCode);
				}

				if (bindLvl1Code) {
					queryPos.add(lvl1Code);
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

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_2 =
			"codeMasterMap.sourceType = ? AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCETYPE_3 =
			"(codeMasterMap.sourceType IS NULL OR codeMasterMap.sourceType = '') AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_2 =
			"codeMasterMap.sourceCode = ? AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_SOURCECODE_3 =
			"(codeMasterMap.sourceCode IS NULL OR codeMasterMap.sourceCode = '') AND ";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_2 =
			"codeMasterMap.lvl1Code = ?";

	private static final String
		_FINDER_COLUMN_SOURCETYPESOURCECODELVL1CODE_LVL1CODE_3 =
			"(codeMasterMap.lvl1Code IS NULL OR codeMasterMap.lvl1Code = '')";

	public CodeMasterMapPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("source", "MDM_SOURCE");
		dbColumnNames.put("type", "MDM_TYPE");
		dbColumnNames.put("sourceType", "MDM_SRC_TYPE");
		dbColumnNames.put("sourceSystemId", "MDM_SRC_SYS_ID");
		dbColumnNames.put("sourceCode", "MDM_SRC_CODE");
		dbColumnNames.put("sourceDesc", "MDM_SRC_DESC");
		dbColumnNames.put("coreType", "MDM_CORE_TYPE");
		dbColumnNames.put("coreSystemId", "MDM_CORE_SYS_ID");
		dbColumnNames.put("coreCode", "MDM_CORE_CODE");
		dbColumnNames.put("coreDesc", "MDM_CORE_DESC");
		dbColumnNames.put("effFromDate", "MDM_EFF_FM_DT");
		dbColumnNames.put("effToDate", "MDM_EFF_TO_DT");
		dbColumnNames.put("freezeFlag", "MDM_FREEZE_FLAG");
		dbColumnNames.put("lvl1Type", "MDM_LVL1_TYPE");
		dbColumnNames.put("lvl1SysId", "MDM_LVL1_SYS_ID");
		dbColumnNames.put("lvl1Code", "MDM_LVL1_CODE");
		dbColumnNames.put("lvl1Desc", "MDM_LVL1_DESC");
		dbColumnNames.put("lvl2Type", "MDM_LVL2_TYPE");
		dbColumnNames.put("lvl2SysId", "MDM_LVL2_SYS_ID");
		dbColumnNames.put("lvl2Code", "MDM_LVL2_CODE");
		dbColumnNames.put("lvl2Desc", "MDM_LVL2_DESC");

		setDBColumnNames(dbColumnNames);

		setModelClass(CodeMasterMap.class);

		setModelImplClass(CodeMasterMapImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the code master map in the entity cache if it is enabled.
	 *
	 * @param codeMasterMap the code master map
	 */
	@Override
	public void cacheResult(CodeMasterMap codeMasterMap) {
		entityCache.putResult(
			CodeMasterMapImpl.class, codeMasterMap.getPrimaryKey(),
			codeMasterMap);

		finderCache.putResult(
			_finderPathFetchBySourceTypeSourceCode,
			new Object[] {
				codeMasterMap.getSourceType(), codeMasterMap.getSourceCode()
			},
			codeMasterMap);

		finderCache.putResult(
			_finderPathFetchBySourceTypeCoreCode,
			new Object[] {
				codeMasterMap.getSourceType(), codeMasterMap.getCoreCode()
			},
			codeMasterMap);

		finderCache.putResult(
			_finderPathFetchBySourceTypeSourceCodeLvl1Code,
			new Object[] {
				codeMasterMap.getSourceType(), codeMasterMap.getSourceCode(),
				codeMasterMap.getLvl1Code()
			},
			codeMasterMap);
	}

	/**
	 * Caches the code master maps in the entity cache if it is enabled.
	 *
	 * @param codeMasterMaps the code master maps
	 */
	@Override
	public void cacheResult(List<CodeMasterMap> codeMasterMaps) {
		for (CodeMasterMap codeMasterMap : codeMasterMaps) {
			if (entityCache.getResult(
					CodeMasterMapImpl.class, codeMasterMap.getPrimaryKey()) ==
						null) {

				cacheResult(codeMasterMap);
			}
		}
	}

	/**
	 * Clears the cache for all code master maps.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CodeMasterMapImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the code master map.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CodeMasterMap codeMasterMap) {
		entityCache.removeResult(CodeMasterMapImpl.class, codeMasterMap);
	}

	@Override
	public void clearCache(List<CodeMasterMap> codeMasterMaps) {
		for (CodeMasterMap codeMasterMap : codeMasterMaps) {
			entityCache.removeResult(CodeMasterMapImpl.class, codeMasterMap);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CodeMasterMapImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CodeMasterMapModelImpl codeMasterMapModelImpl) {

		Object[] args = new Object[] {
			codeMasterMapModelImpl.getSourceType(),
			codeMasterMapModelImpl.getSourceCode()
		};

		finderCache.putResult(
			_finderPathCountBySourceTypeSourceCode, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchBySourceTypeSourceCode, args,
			codeMasterMapModelImpl, false);

		args = new Object[] {
			codeMasterMapModelImpl.getSourceType(),
			codeMasterMapModelImpl.getCoreCode()
		};

		finderCache.putResult(
			_finderPathCountBySourceTypeCoreCode, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySourceTypeCoreCode, args, codeMasterMapModelImpl,
			false);

		args = new Object[] {
			codeMasterMapModelImpl.getSourceType(),
			codeMasterMapModelImpl.getSourceCode(),
			codeMasterMapModelImpl.getLvl1Code()
		};

		finderCache.putResult(
			_finderPathCountBySourceTypeSourceCodeLvl1Code, args,
			Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchBySourceTypeSourceCodeLvl1Code, args,
			codeMasterMapModelImpl, false);
	}

	/**
	 * Creates a new code master map with the primary key. Does not add the code master map to the database.
	 *
	 * @param source the primary key for the new code master map
	 * @return the new code master map
	 */
	@Override
	public CodeMasterMap create(String source) {
		CodeMasterMap codeMasterMap = new CodeMasterMapImpl();

		codeMasterMap.setNew(true);
		codeMasterMap.setPrimaryKey(source);

		return codeMasterMap;
	}

	/**
	 * Removes the code master map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map that was removed
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	@Override
	public CodeMasterMap remove(String source)
		throws NoSuchCodeMasterMapException {

		return remove((Serializable)source);
	}

	/**
	 * Removes the code master map with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the code master map
	 * @return the code master map that was removed
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	@Override
	public CodeMasterMap remove(Serializable primaryKey)
		throws NoSuchCodeMasterMapException {

		Session session = null;

		try {
			session = openSession();

			CodeMasterMap codeMasterMap = (CodeMasterMap)session.get(
				CodeMasterMapImpl.class, primaryKey);

			if (codeMasterMap == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCodeMasterMapException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(codeMasterMap);
		}
		catch (NoSuchCodeMasterMapException noSuchEntityException) {
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
	protected CodeMasterMap removeImpl(CodeMasterMap codeMasterMap) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(codeMasterMap)) {
				codeMasterMap = (CodeMasterMap)session.get(
					CodeMasterMapImpl.class, codeMasterMap.getPrimaryKeyObj());
			}

			if (codeMasterMap != null) {
				session.delete(codeMasterMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (codeMasterMap != null) {
			clearCache(codeMasterMap);
		}

		return codeMasterMap;
	}

	@Override
	public CodeMasterMap updateImpl(CodeMasterMap codeMasterMap) {
		boolean isNew = codeMasterMap.isNew();

		if (!(codeMasterMap instanceof CodeMasterMapModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(codeMasterMap.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					codeMasterMap);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in codeMasterMap proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CodeMasterMap implementation " +
					codeMasterMap.getClass());
		}

		CodeMasterMapModelImpl codeMasterMapModelImpl =
			(CodeMasterMapModelImpl)codeMasterMap;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(codeMasterMap);
			}
			else {
				codeMasterMap = (CodeMasterMap)session.merge(codeMasterMap);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CodeMasterMapImpl.class, codeMasterMapModelImpl, false, true);

		cacheUniqueFindersCache(codeMasterMapModelImpl);

		if (isNew) {
			codeMasterMap.setNew(false);
		}

		codeMasterMap.resetOriginalValues();

		return codeMasterMap;
	}

	/**
	 * Returns the code master map with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the code master map
	 * @return the code master map
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	@Override
	public CodeMasterMap findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCodeMasterMapException {

		CodeMasterMap codeMasterMap = fetchByPrimaryKey(primaryKey);

		if (codeMasterMap == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCodeMasterMapException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return codeMasterMap;
	}

	/**
	 * Returns the code master map with the primary key or throws a <code>NoSuchCodeMasterMapException</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map
	 * @throws NoSuchCodeMasterMapException if a code master map with the primary key could not be found
	 */
	@Override
	public CodeMasterMap findByPrimaryKey(String source)
		throws NoSuchCodeMasterMapException {

		return findByPrimaryKey((Serializable)source);
	}

	/**
	 * Returns the code master map with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param source the primary key of the code master map
	 * @return the code master map, or <code>null</code> if a code master map with the primary key could not be found
	 */
	@Override
	public CodeMasterMap fetchByPrimaryKey(String source) {
		return fetchByPrimaryKey((Serializable)source);
	}

	/**
	 * Returns all the code master maps.
	 *
	 * @return the code master maps
	 */
	@Override
	public List<CodeMasterMap> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @return the range of code master maps
	 */
	@Override
	public List<CodeMasterMap> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of code master maps
	 */
	@Override
	public List<CodeMasterMap> findAll(
		int start, int end,
		OrderByComparator<CodeMasterMap> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the code master maps.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterMapModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code master maps
	 * @param end the upper bound of the range of code master maps (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of code master maps
	 */
	@Override
	public List<CodeMasterMap> findAll(
		int start, int end, OrderByComparator<CodeMasterMap> orderByComparator,
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

		List<CodeMasterMap> list = null;

		if (useFinderCache) {
			list = (List<CodeMasterMap>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CODEMASTERMAP);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CODEMASTERMAP;

				sql = sql.concat(CodeMasterMapModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CodeMasterMap>)QueryUtil.list(
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
	 * Removes all the code master maps from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CodeMasterMap codeMasterMap : findAll()) {
			remove(codeMasterMap);
		}
	}

	/**
	 * Returns the number of code master maps.
	 *
	 * @return the number of code master maps
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CODEMASTERMAP);

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
		return "MDM_SOURCE";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CODEMASTERMAP;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CodeMasterMapModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the code master map persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CodeMasterMapModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CodeMasterMap.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchBySourceTypeSourceCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySourceTypeSourceCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_SRC_TYPE", "MDM_SRC_CODE"}, true);

		_finderPathCountBySourceTypeSourceCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySourceTypeSourceCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_SRC_TYPE", "MDM_SRC_CODE"}, false);

		_finderPathFetchBySourceTypeCoreCode = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySourceTypeCoreCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_SRC_TYPE", "MDM_CORE_CODE"}, true);

		_finderPathCountBySourceTypeCoreCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySourceTypeCoreCode",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_SRC_TYPE", "MDM_CORE_CODE"}, false);

		_finderPathFetchBySourceTypeSourceCodeLvl1Code = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBySourceTypeSourceCodeLvl1Code",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"MDM_SRC_TYPE", "MDM_SRC_CODE", "MDM_LVL1_CODE"},
			true);

		_finderPathCountBySourceTypeSourceCodeLvl1Code = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countBySourceTypeSourceCodeLvl1Code",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName()
			},
			new String[] {"MDM_SRC_TYPE", "MDM_SRC_CODE", "MDM_LVL1_CODE"},
			false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CodeMasterMapImpl.class.getName());

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

	private static final String _SQL_SELECT_CODEMASTERMAP =
		"SELECT codeMasterMap FROM CodeMasterMap codeMasterMap";

	private static final String _SQL_SELECT_CODEMASTERMAP_WHERE =
		"SELECT codeMasterMap FROM CodeMasterMap codeMasterMap WHERE ";

	private static final String _SQL_COUNT_CODEMASTERMAP =
		"SELECT COUNT(codeMasterMap) FROM CodeMasterMap codeMasterMap";

	private static final String _SQL_COUNT_CODEMASTERMAP_WHERE =
		"SELECT COUNT(codeMasterMap) FROM CodeMasterMap codeMasterMap WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "codeMasterMap.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CodeMasterMap exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CodeMasterMap exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CodeMasterMapPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"source", "type", "sourceType", "sourceSystemId", "sourceCode",
			"sourceDesc", "coreType", "coreSystemId", "coreCode", "coreDesc",
			"effFromDate", "effToDate", "freezeFlag", "lvl1Type", "lvl1SysId",
			"lvl1Code", "lvl1Desc", "lvl2Type", "lvl2SysId", "lvl2Code",
			"lvl2Desc"
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

	private static class CodeMasterMapModelArgumentsResolver
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

			CodeMasterMapModelImpl codeMasterMapModelImpl =
				(CodeMasterMapModelImpl)baseModel;

			long columnBitmask = codeMasterMapModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(codeMasterMapModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						codeMasterMapModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(codeMasterMapModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CodeMasterMapModelImpl codeMasterMapModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						codeMasterMapModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = codeMasterMapModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}