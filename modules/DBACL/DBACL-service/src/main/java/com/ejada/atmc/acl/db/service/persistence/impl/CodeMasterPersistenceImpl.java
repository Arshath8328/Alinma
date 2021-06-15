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

import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.model.impl.CodeMasterImpl;
import com.ejada.atmc.acl.db.model.impl.CodeMasterModelImpl;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterPersistence;
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
 * The persistence implementation for the code master service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = CodeMasterPersistence.class)
public class CodeMasterPersistenceImpl
	extends BasePersistenceImpl<CodeMaster> implements CodeMasterPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>CodeMasterUtil</code> to access the code master persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		CodeMasterImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchByCodeCodeSub;
	private FinderPath _finderPathCountByCodeCodeSub;

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCodeCodeSub(String code, String codeSub)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCodeCodeSub(code, codeSub);

		if (codeMaster == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append(", codeSub=");
			sb.append(codeSub);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCodeMasterException(sb.toString());
		}

		return codeMaster;
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeSub(String code, String codeSub) {
		return fetchByCodeCodeSub(code, codeSub, true);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeSub(
		String code, String codeSub, boolean useFinderCache) {

		code = Objects.toString(code, "");
		codeSub = Objects.toString(codeSub, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code, codeSub};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodeCodeSub, finderArgs, this);
		}

		if (result instanceof CodeMaster) {
			CodeMaster codeMaster = (CodeMaster)result;

			if (!Objects.equals(code, codeMaster.getCode()) ||
				!Objects.equals(codeSub, codeMaster.getCodeSub())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_SQL_SELECT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUB_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODESUB_CODE_2);
			}

			boolean bindCodeSub = false;

			if (codeSub.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUB_CODESUB_3);
			}
			else {
				bindCodeSub = true;

				sb.append(_FINDER_COLUMN_CODECODESUB_CODESUB_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeSub) {
					queryPos.add(codeSub);
				}

				List<CodeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodeCodeSub, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {code, codeSub};
							}

							_log.warn(
								"CodeMasterPersistenceImpl.fetchByCodeCodeSub(String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CodeMaster codeMaster = list.get(0);

					result = codeMaster;

					cacheResult(codeMaster);
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
			return (CodeMaster)result;
		}
	}

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the code master that was removed
	 */
	@Override
	public CodeMaster removeByCodeCodeSub(String code, String codeSub)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = findByCodeCodeSub(code, codeSub);

		return remove(codeMaster);
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @return the number of matching code masters
	 */
	@Override
	public int countByCodeCodeSub(String code, String codeSub) {
		code = Objects.toString(code, "");
		codeSub = Objects.toString(codeSub, "");

		FinderPath finderPath = _finderPathCountByCodeCodeSub;

		Object[] finderArgs = new Object[] {code, codeSub};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUB_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODESUB_CODE_2);
			}

			boolean bindCodeSub = false;

			if (codeSub.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUB_CODESUB_3);
			}
			else {
				bindCodeSub = true;

				sb.append(_FINDER_COLUMN_CODECODESUB_CODESUB_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeSub) {
					queryPos.add(codeSub);
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

	private static final String _FINDER_COLUMN_CODECODESUB_CODE_2 =
		"codeMaster.code = ? AND ";

	private static final String _FINDER_COLUMN_CODECODESUB_CODE_3 =
		"(codeMaster.code IS NULL OR codeMaster.code = '') AND ";

	private static final String _FINDER_COLUMN_CODECODESUB_CODESUB_2 =
		"codeMaster.codeSub = ?";

	private static final String _FINDER_COLUMN_CODECODESUB_CODESUB_3 =
		"(codeMaster.codeSub IS NULL OR codeMaster.codeSub = '')";

	private FinderPath _finderPathFetchByCodeCodeSubCodeSubRef;
	private FinderPath _finderPathCountByCodeCodeSubCodeSubRef;

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);

		if (codeMaster == null) {
			StringBundler sb = new StringBundler(10);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("code=");
			sb.append(code);

			sb.append(", codeSub=");
			sb.append(codeSub);

			sb.append(", codeSubRef=");
			sb.append(codeSubRef);

			sb.append(", codeFreezYN=");
			sb.append(codeFreezYN);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchCodeMasterException(sb.toString());
		}

		return codeMaster;
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN) {

		return fetchByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN, true);
	}

	/**
	 * Returns the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN,
		boolean useFinderCache) {

		code = Objects.toString(code, "");
		codeSub = Objects.toString(codeSub, "");
		codeSubRef = Objects.toString(codeSubRef, "");
		codeFreezYN = Objects.toString(codeFreezYN, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {code, codeSub, codeSubRef, codeFreezYN};
		}

		Object result = null;

		if (useFinderCache) {
			result = finderCache.getResult(
				_finderPathFetchByCodeCodeSubCodeSubRef, finderArgs, this);
		}

		if (result instanceof CodeMaster) {
			CodeMaster codeMaster = (CodeMaster)result;

			if (!Objects.equals(code, codeMaster.getCode()) ||
				!Objects.equals(codeSub, codeMaster.getCodeSub()) ||
				!Objects.equals(codeSubRef, codeMaster.getCodeSubRef()) ||
				!Objects.equals(codeFreezYN, codeMaster.getCodeFreezYN())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(6);

			sb.append(_SQL_SELECT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_2);
			}

			boolean bindCodeSub = false;

			if (codeSub.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_3);
			}
			else {
				bindCodeSub = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_2);
			}

			boolean bindCodeSubRef = false;

			if (codeSubRef.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_3);
			}
			else {
				bindCodeSubRef = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_2);
			}

			boolean bindCodeFreezYN = false;

			if (codeFreezYN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_3);
			}
			else {
				bindCodeFreezYN = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeSub) {
					queryPos.add(codeSub);
				}

				if (bindCodeSubRef) {
					queryPos.add(codeSubRef);
				}

				if (bindCodeFreezYN) {
					queryPos.add(codeFreezYN);
				}

				List<CodeMaster> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						finderCache.putResult(
							_finderPathFetchByCodeCodeSubCodeSubRef, finderArgs,
							list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {
									code, codeSub, codeSubRef, codeFreezYN
								};
							}

							_log.warn(
								"CodeMasterPersistenceImpl.fetchByCodeCodeSubCodeSubRef(String, String, String, String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					CodeMaster codeMaster = list.get(0);

					result = codeMaster;

					cacheResult(codeMaster);
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
			return (CodeMaster)result;
		}
	}

	/**
	 * Removes the code master where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the code master that was removed
	 */
	@Override
	public CodeMaster removeByCodeCodeSubCodeSubRef(
			String code, String codeSub, String codeSubRef, String codeFreezYN)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = findByCodeCodeSubCodeSubRef(
			code, codeSub, codeSubRef, codeFreezYN);

		return remove(codeMaster);
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeSub = &#63; and codeSubRef = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeSub the code sub
	 * @param codeSubRef the code sub ref
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	@Override
	public int countByCodeCodeSubCodeSubRef(
		String code, String codeSub, String codeSubRef, String codeFreezYN) {

		code = Objects.toString(code, "");
		codeSub = Objects.toString(codeSub, "");
		codeSubRef = Objects.toString(codeSubRef, "");
		codeFreezYN = Objects.toString(codeFreezYN, "");

		FinderPath finderPath = _finderPathCountByCodeCodeSubCodeSubRef;

		Object[] finderArgs = new Object[] {
			code, codeSub, codeSubRef, codeFreezYN
		};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(5);

			sb.append(_SQL_COUNT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_2);
			}

			boolean bindCodeSub = false;

			if (codeSub.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_3);
			}
			else {
				bindCodeSub = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_2);
			}

			boolean bindCodeSubRef = false;

			if (codeSubRef.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_3);
			}
			else {
				bindCodeSubRef = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_2);
			}

			boolean bindCodeFreezYN = false;

			if (codeFreezYN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_3);
			}
			else {
				bindCodeFreezYN = true;

				sb.append(_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeSub) {
					queryPos.add(codeSub);
				}

				if (bindCodeSubRef) {
					queryPos.add(codeSubRef);
				}

				if (bindCodeFreezYN) {
					queryPos.add(codeFreezYN);
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

	private static final String _FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_2 =
		"codeMaster.code = ? AND ";

	private static final String _FINDER_COLUMN_CODECODESUBCODESUBREF_CODE_3 =
		"(codeMaster.code IS NULL OR codeMaster.code = '') AND ";

	private static final String _FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_2 =
		"codeMaster.codeSub = ? AND ";

	private static final String _FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUB_3 =
		"(codeMaster.codeSub IS NULL OR codeMaster.codeSub = '') AND ";

	private static final String
		_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_2 =
			"codeMaster.codeSubRef = ? AND ";

	private static final String
		_FINDER_COLUMN_CODECODESUBCODESUBREF_CODESUBREF_3 =
			"(codeMaster.codeSubRef IS NULL OR codeMaster.codeSubRef = '') AND ";

	private static final String
		_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_2 =
			"codeMaster.codeFreezYN = ?";

	private static final String
		_FINDER_COLUMN_CODECODESUBCODESUBREF_CODEFREEZYN_3 =
			"(codeMaster.codeFreezYN IS NULL OR codeMaster.codeFreezYN = '')";

	private FinderPath _finderPathWithPaginationFindByCode;
	private FinderPath _finderPathWithoutPaginationFindByCode;
	private FinderPath _finderPathCountByCode;

	/**
	 * Returns all the code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the matching code masters
	 */
	@Override
	public List<CodeMaster> findByCode(String code) {
		return findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCode(String code, int start, int end) {
		return findByCode(code, start, end, null);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCode(
		String code, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator) {

		return findByCode(code, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCode(
		String code, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCode;
				finderArgs = new Object[] {code};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCode;
			finderArgs = new Object[] {code, start, end, orderByComparator};
		}

		List<CodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CodeMaster codeMaster : list) {
					if (!code.equals(codeMaster.getCode())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					3 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(3);
			}

			sb.append(_SQL_SELECT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CodeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				list = (List<CodeMaster>)QueryUtil.list(
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
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCode_First(
			String code, OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCode_First(code, orderByComparator);

		if (codeMaster != null) {
			return codeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchCodeMasterException(sb.toString());
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCode_First(
		String code, OrderByComparator<CodeMaster> orderByComparator) {

		List<CodeMaster> list = findByCode(code, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCode_Last(
			String code, OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCode_Last(code, orderByComparator);

		if (codeMaster != null) {
			return codeMaster;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append("}");

		throw new NoSuchCodeMasterException(sb.toString());
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63;.
	 *
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCode_Last(
		String code, OrderByComparator<CodeMaster> orderByComparator) {

		int count = countByCode(code);

		if (count == 0) {
			return null;
		}

		List<CodeMaster> list = findByCode(
			code, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the code masters before and after the current code master in the ordered set where code = &#63;.
	 *
	 * @param systemId the primary key of the current code master
	 * @param code the code
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster[] findByCode_PrevAndNext(
			long systemId, String code,
			OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		code = Objects.toString(code, "");

		CodeMaster codeMaster = findByPrimaryKey(systemId);

		Session session = null;

		try {
			session = openSession();

			CodeMaster[] array = new CodeMasterImpl[3];

			array[0] = getByCode_PrevAndNext(
				session, codeMaster, code, orderByComparator, true);

			array[1] = codeMaster;

			array[2] = getByCode_PrevAndNext(
				session, codeMaster, code, orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CodeMaster getByCode_PrevAndNext(
		Session session, CodeMaster codeMaster, String code,
		OrderByComparator<CodeMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_CODEMASTER_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODE_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODE_CODE_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CodeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(codeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CodeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the code masters where code = &#63; from the database.
	 *
	 * @param code the code
	 */
	@Override
	public void removeByCode(String code) {
		for (CodeMaster codeMaster :
				findByCode(code, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(codeMaster);
		}
	}

	/**
	 * Returns the number of code masters where code = &#63;.
	 *
	 * @param code the code
	 * @return the number of matching code masters
	 */
	@Override
	public int countByCode(String code) {
		code = Objects.toString(code, "");

		FinderPath finderPath = _finderPathCountByCode;

		Object[] finderArgs = new Object[] {code};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODE_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODE_CODE_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
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

	private static final String _FINDER_COLUMN_CODE_CODE_2 =
		"codeMaster.code = ?";

	private static final String _FINDER_COLUMN_CODE_CODE_3 =
		"(codeMaster.code IS NULL OR codeMaster.code = '')";

	private FinderPath _finderPathWithPaginationFindByCodeCodeFreez;
	private FinderPath _finderPathWithoutPaginationFindByCodeCodeFreez;
	private FinderPath _finderPathCountByCodeCodeFreez;

	/**
	 * Returns all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the matching code masters
	 */
	@Override
	public List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN) {

		return findByCodeCodeFreez(
			code, codeFreezYN, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end) {

		return findByCodeCodeFreez(code, codeFreezYN, start, end, null);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator) {

		return findByCodeCodeFreez(
			code, codeFreezYN, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching code masters
	 */
	@Override
	public List<CodeMaster> findByCodeCodeFreez(
		String code, String codeFreezYN, int start, int end,
		OrderByComparator<CodeMaster> orderByComparator,
		boolean useFinderCache) {

		code = Objects.toString(code, "");
		codeFreezYN = Objects.toString(codeFreezYN, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByCodeCodeFreez;
				finderArgs = new Object[] {code, codeFreezYN};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByCodeCodeFreez;
			finderArgs = new Object[] {
				code, codeFreezYN, start, end, orderByComparator
			};
		}

		List<CodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (CodeMaster codeMaster : list) {
					if (!code.equals(codeMaster.getCode()) ||
						!codeFreezYN.equals(codeMaster.getCodeFreezYN())) {

						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler sb = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					4 + (orderByComparator.getOrderByFields().length * 2));
			}
			else {
				sb = new StringBundler(4);
			}

			sb.append(_SQL_SELECT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_2);
			}

			boolean bindCodeFreezYN = false;

			if (codeFreezYN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_3);
			}
			else {
				bindCodeFreezYN = true;

				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(CodeMasterModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeFreezYN) {
					queryPos.add(codeFreezYN);
				}

				list = (List<CodeMaster>)QueryUtil.list(
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
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCodeCodeFreez_First(
			String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCodeCodeFreez_First(
			code, codeFreezYN, orderByComparator);

		if (codeMaster != null) {
			return codeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append(", codeFreezYN=");
		sb.append(codeFreezYN);

		sb.append("}");

		throw new NoSuchCodeMasterException(sb.toString());
	}

	/**
	 * Returns the first code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeFreez_First(
		String code, String codeFreezYN,
		OrderByComparator<CodeMaster> orderByComparator) {

		List<CodeMaster> list = findByCodeCodeFreez(
			code, codeFreezYN, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master
	 * @throws NoSuchCodeMasterException if a matching code master could not be found
	 */
	@Override
	public CodeMaster findByCodeCodeFreez_Last(
			String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByCodeCodeFreez_Last(
			code, codeFreezYN, orderByComparator);

		if (codeMaster != null) {
			return codeMaster;
		}

		StringBundler sb = new StringBundler(6);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("code=");
		sb.append(code);

		sb.append(", codeFreezYN=");
		sb.append(codeFreezYN);

		sb.append("}");

		throw new NoSuchCodeMasterException(sb.toString());
	}

	/**
	 * Returns the last code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching code master, or <code>null</code> if a matching code master could not be found
	 */
	@Override
	public CodeMaster fetchByCodeCodeFreez_Last(
		String code, String codeFreezYN,
		OrderByComparator<CodeMaster> orderByComparator) {

		int count = countByCodeCodeFreez(code, codeFreezYN);

		if (count == 0) {
			return null;
		}

		List<CodeMaster> list = findByCodeCodeFreez(
			code, codeFreezYN, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the code masters before and after the current code master in the ordered set where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param systemId the primary key of the current code master
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster[] findByCodeCodeFreez_PrevAndNext(
			long systemId, String code, String codeFreezYN,
			OrderByComparator<CodeMaster> orderByComparator)
		throws NoSuchCodeMasterException {

		code = Objects.toString(code, "");
		codeFreezYN = Objects.toString(codeFreezYN, "");

		CodeMaster codeMaster = findByPrimaryKey(systemId);

		Session session = null;

		try {
			session = openSession();

			CodeMaster[] array = new CodeMasterImpl[3];

			array[0] = getByCodeCodeFreez_PrevAndNext(
				session, codeMaster, code, codeFreezYN, orderByComparator,
				true);

			array[1] = codeMaster;

			array[2] = getByCodeCodeFreez_PrevAndNext(
				session, codeMaster, code, codeFreezYN, orderByComparator,
				false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected CodeMaster getByCodeCodeFreez_PrevAndNext(
		Session session, CodeMaster codeMaster, String code, String codeFreezYN,
		OrderByComparator<CodeMaster> orderByComparator, boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				5 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(4);
		}

		sb.append(_SQL_SELECT_CODEMASTER_WHERE);

		boolean bindCode = false;

		if (code.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_3);
		}
		else {
			bindCode = true;

			sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_2);
		}

		boolean bindCodeFreezYN = false;

		if (codeFreezYN.isEmpty()) {
			sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_3);
		}
		else {
			bindCodeFreezYN = true;

			sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields =
				orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				sb.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						sb.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(WHERE_GREATER_THAN);
					}
					else {
						sb.append(WHERE_LESSER_THAN);
					}
				}
			}

			sb.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				sb.append(_ORDER_BY_ENTITY_ALIAS);
				sb.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						sb.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						sb.append(ORDER_BY_ASC);
					}
					else {
						sb.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			sb.append(CodeMasterModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindCode) {
			queryPos.add(code);
		}

		if (bindCodeFreezYN) {
			queryPos.add(codeFreezYN);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(codeMaster)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<CodeMaster> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the code masters where code = &#63; and codeFreezYN = &#63; from the database.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 */
	@Override
	public void removeByCodeCodeFreez(String code, String codeFreezYN) {
		for (CodeMaster codeMaster :
				findByCodeCodeFreez(
					code, codeFreezYN, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
					null)) {

			remove(codeMaster);
		}
	}

	/**
	 * Returns the number of code masters where code = &#63; and codeFreezYN = &#63;.
	 *
	 * @param code the code
	 * @param codeFreezYN the code freez yn
	 * @return the number of matching code masters
	 */
	@Override
	public int countByCodeCodeFreez(String code, String codeFreezYN) {
		code = Objects.toString(code, "");
		codeFreezYN = Objects.toString(codeFreezYN, "");

		FinderPath finderPath = _finderPathCountByCodeCodeFreez;

		Object[] finderArgs = new Object[] {code, codeFreezYN};

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_COUNT_CODEMASTER_WHERE);

			boolean bindCode = false;

			if (code.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_3);
			}
			else {
				bindCode = true;

				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODE_2);
			}

			boolean bindCodeFreezYN = false;

			if (codeFreezYN.isEmpty()) {
				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_3);
			}
			else {
				bindCodeFreezYN = true;

				sb.append(_FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindCode) {
					queryPos.add(code);
				}

				if (bindCodeFreezYN) {
					queryPos.add(codeFreezYN);
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

	private static final String _FINDER_COLUMN_CODECODEFREEZ_CODE_2 =
		"codeMaster.code = ? AND ";

	private static final String _FINDER_COLUMN_CODECODEFREEZ_CODE_3 =
		"(codeMaster.code IS NULL OR codeMaster.code = '') AND ";

	private static final String _FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_2 =
		"codeMaster.codeFreezYN = ?";

	private static final String _FINDER_COLUMN_CODECODEFREEZ_CODEFREEZYN_3 =
		"(codeMaster.codeFreezYN IS NULL OR codeMaster.codeFreezYN = '')";

	public CodeMasterPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("systemId", "MDM_CODE_SYS_ID");
		dbColumnNames.put("effFromDate", "MDM_CODE_EFF_FM_DT");
		dbColumnNames.put("effToDate", "MDM_CODE_EFF_TO_DT");
		dbColumnNames.put("creationDate", "MDM_CODE_CR_DT");
		dbColumnNames.put("crUid", "MDM_CODE_CR_UID");
		dbColumnNames.put("updateDate", "MDM_CODE_UPD_DT");
		dbColumnNames.put("updateUid", "MDM_CODE_UPD_UID");
		dbColumnNames.put("code", "MDM_CODE");
		dbColumnNames.put("codeSub", "MDM_CODE_SUB");
		dbColumnNames.put("codeDesc", "MDM_CODE_DESC");
		dbColumnNames.put("codeDescAr", "MDM_CODE_DESC_AR");
		dbColumnNames.put("codeValue0", "MDM_CODE_VALUE_0");
		dbColumnNames.put("codeValue1", "MDM_CODE_VALUE_1");
		dbColumnNames.put("codeValue2", "MDM_CODE_VALUE_2");
		dbColumnNames.put("codeRef", "MDM_CODE_REF");
		dbColumnNames.put("codeSubRef", "MDM_CODE_SUB_REF");
		dbColumnNames.put("codeFreezYN", "MDM_CODE_FREEZ_YN");

		setDBColumnNames(dbColumnNames);

		setModelClass(CodeMaster.class);

		setModelImplClass(CodeMasterImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the code master in the entity cache if it is enabled.
	 *
	 * @param codeMaster the code master
	 */
	@Override
	public void cacheResult(CodeMaster codeMaster) {
		entityCache.putResult(
			CodeMasterImpl.class, codeMaster.getPrimaryKey(), codeMaster);

		finderCache.putResult(
			_finderPathFetchByCodeCodeSub,
			new Object[] {codeMaster.getCode(), codeMaster.getCodeSub()},
			codeMaster);

		finderCache.putResult(
			_finderPathFetchByCodeCodeSubCodeSubRef,
			new Object[] {
				codeMaster.getCode(), codeMaster.getCodeSub(),
				codeMaster.getCodeSubRef(), codeMaster.getCodeFreezYN()
			},
			codeMaster);
	}

	/**
	 * Caches the code masters in the entity cache if it is enabled.
	 *
	 * @param codeMasters the code masters
	 */
	@Override
	public void cacheResult(List<CodeMaster> codeMasters) {
		for (CodeMaster codeMaster : codeMasters) {
			if (entityCache.getResult(
					CodeMasterImpl.class, codeMaster.getPrimaryKey()) == null) {

				cacheResult(codeMaster);
			}
		}
	}

	/**
	 * Clears the cache for all code masters.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(CodeMasterImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the code master.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(CodeMaster codeMaster) {
		entityCache.removeResult(CodeMasterImpl.class, codeMaster);
	}

	@Override
	public void clearCache(List<CodeMaster> codeMasters) {
		for (CodeMaster codeMaster : codeMasters) {
			entityCache.removeResult(CodeMasterImpl.class, codeMaster);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			entityCache.removeResult(CodeMasterImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		CodeMasterModelImpl codeMasterModelImpl) {

		Object[] args = new Object[] {
			codeMasterModelImpl.getCode(), codeMasterModelImpl.getCodeSub()
		};

		finderCache.putResult(
			_finderPathCountByCodeCodeSub, args, Long.valueOf(1), false);
		finderCache.putResult(
			_finderPathFetchByCodeCodeSub, args, codeMasterModelImpl, false);

		args = new Object[] {
			codeMasterModelImpl.getCode(), codeMasterModelImpl.getCodeSub(),
			codeMasterModelImpl.getCodeSubRef(),
			codeMasterModelImpl.getCodeFreezYN()
		};

		finderCache.putResult(
			_finderPathCountByCodeCodeSubCodeSubRef, args, Long.valueOf(1),
			false);
		finderCache.putResult(
			_finderPathFetchByCodeCodeSubCodeSubRef, args, codeMasterModelImpl,
			false);
	}

	/**
	 * Creates a new code master with the primary key. Does not add the code master to the database.
	 *
	 * @param systemId the primary key for the new code master
	 * @return the new code master
	 */
	@Override
	public CodeMaster create(long systemId) {
		CodeMaster codeMaster = new CodeMasterImpl();

		codeMaster.setNew(true);
		codeMaster.setPrimaryKey(systemId);

		return codeMaster;
	}

	/**
	 * Removes the code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master that was removed
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster remove(long systemId) throws NoSuchCodeMasterException {
		return remove((Serializable)systemId);
	}

	/**
	 * Removes the code master with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the code master
	 * @return the code master that was removed
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster remove(Serializable primaryKey)
		throws NoSuchCodeMasterException {

		Session session = null;

		try {
			session = openSession();

			CodeMaster codeMaster = (CodeMaster)session.get(
				CodeMasterImpl.class, primaryKey);

			if (codeMaster == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchCodeMasterException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(codeMaster);
		}
		catch (NoSuchCodeMasterException noSuchEntityException) {
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
	protected CodeMaster removeImpl(CodeMaster codeMaster) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(codeMaster)) {
				codeMaster = (CodeMaster)session.get(
					CodeMasterImpl.class, codeMaster.getPrimaryKeyObj());
			}

			if (codeMaster != null) {
				session.delete(codeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (codeMaster != null) {
			clearCache(codeMaster);
		}

		return codeMaster;
	}

	@Override
	public CodeMaster updateImpl(CodeMaster codeMaster) {
		boolean isNew = codeMaster.isNew();

		if (!(codeMaster instanceof CodeMasterModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(codeMaster.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(codeMaster);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in codeMaster proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom CodeMaster implementation " +
					codeMaster.getClass());
		}

		CodeMasterModelImpl codeMasterModelImpl =
			(CodeMasterModelImpl)codeMaster;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(codeMaster);
			}
			else {
				codeMaster = (CodeMaster)session.merge(codeMaster);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		entityCache.putResult(
			CodeMasterImpl.class, codeMasterModelImpl, false, true);

		cacheUniqueFindersCache(codeMasterModelImpl);

		if (isNew) {
			codeMaster.setNew(false);
		}

		codeMaster.resetOriginalValues();

		return codeMaster;
	}

	/**
	 * Returns the code master with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the code master
	 * @return the code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster findByPrimaryKey(Serializable primaryKey)
		throws NoSuchCodeMasterException {

		CodeMaster codeMaster = fetchByPrimaryKey(primaryKey);

		if (codeMaster == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchCodeMasterException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return codeMaster;
	}

	/**
	 * Returns the code master with the primary key or throws a <code>NoSuchCodeMasterException</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master
	 * @throws NoSuchCodeMasterException if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster findByPrimaryKey(long systemId)
		throws NoSuchCodeMasterException {

		return findByPrimaryKey((Serializable)systemId);
	}

	/**
	 * Returns the code master with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param systemId the primary key of the code master
	 * @return the code master, or <code>null</code> if a code master with the primary key could not be found
	 */
	@Override
	public CodeMaster fetchByPrimaryKey(long systemId) {
		return fetchByPrimaryKey((Serializable)systemId);
	}

	/**
	 * Returns all the code masters.
	 *
	 * @return the code masters
	 */
	@Override
	public List<CodeMaster> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @return the range of code masters
	 */
	@Override
	public List<CodeMaster> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of code masters
	 */
	@Override
	public List<CodeMaster> findAll(
		int start, int end, OrderByComparator<CodeMaster> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the code masters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>CodeMasterModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of code masters
	 * @param end the upper bound of the range of code masters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of code masters
	 */
	@Override
	public List<CodeMaster> findAll(
		int start, int end, OrderByComparator<CodeMaster> orderByComparator,
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

		List<CodeMaster> list = null;

		if (useFinderCache) {
			list = (List<CodeMaster>)finderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_CODEMASTER);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_CODEMASTER;

				sql = sql.concat(CodeMasterModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<CodeMaster>)QueryUtil.list(
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
	 * Removes all the code masters from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (CodeMaster codeMaster : findAll()) {
			remove(codeMaster);
		}
	}

	/**
	 * Returns the number of code masters.
	 *
	 * @return the number of code masters
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_CODEMASTER);

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
		return "MDM_CODE_SYS_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_CODEMASTER;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return CodeMasterModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the code master persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class, new CodeMasterModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", CodeMaster.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchByCodeCodeSub = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeCodeSub",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CODE", "MDM_CODE_SUB"}, true);

		_finderPathCountByCodeCodeSub = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeCodeSub",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CODE", "MDM_CODE_SUB"}, false);

		_finderPathFetchByCodeCodeSubCodeSubRef = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchByCodeCodeSubCodeSubRef",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"MDM_CODE", "MDM_CODE_SUB", "MDM_CODE_SUB_REF",
				"MDM_CODE_FREEZ_YN"
			},
			true);

		_finderPathCountByCodeCodeSubCodeSubRef = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByCodeCodeSubCodeSubRef",
			new String[] {
				String.class.getName(), String.class.getName(),
				String.class.getName(), String.class.getName()
			},
			new String[] {
				"MDM_CODE", "MDM_CODE_SUB", "MDM_CODE_SUB_REF",
				"MDM_CODE_FREEZ_YN"
			},
			false);

		_finderPathWithPaginationFindByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCode",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"MDM_CODE"}, true);

		_finderPathWithoutPaginationFindByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCode",
			new String[] {String.class.getName()}, new String[] {"MDM_CODE"},
			true);

		_finderPathCountByCode = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCode",
			new String[] {String.class.getName()}, new String[] {"MDM_CODE"},
			false);

		_finderPathWithPaginationFindByCodeCodeFreez = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCodeCodeFreez",
			new String[] {
				String.class.getName(), String.class.getName(),
				Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			},
			new String[] {"MDM_CODE", "MDM_CODE_FREEZ_YN"}, true);

		_finderPathWithoutPaginationFindByCodeCodeFreez = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCodeCodeFreez",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CODE", "MDM_CODE_FREEZ_YN"}, true);

		_finderPathCountByCodeCodeFreez = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCodeCodeFreez",
			new String[] {String.class.getName(), String.class.getName()},
			new String[] {"MDM_CODE", "MDM_CODE_FREEZ_YN"}, false);
	}

	@Deactivate
	public void deactivate() {
		entityCache.removeCache(CodeMasterImpl.class.getName());

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

	private static final String _SQL_SELECT_CODEMASTER =
		"SELECT codeMaster FROM CodeMaster codeMaster";

	private static final String _SQL_SELECT_CODEMASTER_WHERE =
		"SELECT codeMaster FROM CodeMaster codeMaster WHERE ";

	private static final String _SQL_COUNT_CODEMASTER =
		"SELECT COUNT(codeMaster) FROM CodeMaster codeMaster";

	private static final String _SQL_COUNT_CODEMASTER_WHERE =
		"SELECT COUNT(codeMaster) FROM CodeMaster codeMaster WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "codeMaster.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No CodeMaster exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No CodeMaster exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		CodeMasterPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"systemId", "effFromDate", "effToDate", "creationDate", "crUid",
			"updateDate", "updateUid", "code", "codeSub", "codeDesc",
			"codeDescAr", "codeValue0", "codeValue1", "codeValue2", "codeRef",
			"codeSubRef", "codeFreezYN"
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

	private static class CodeMasterModelArgumentsResolver
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

			CodeMasterModelImpl codeMasterModelImpl =
				(CodeMasterModelImpl)baseModel;

			long columnBitmask = codeMasterModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(codeMasterModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						codeMasterModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(codeMasterModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			CodeMasterModelImpl codeMasterModelImpl, String[] columnNames,
			boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] = codeMasterModelImpl.getColumnOriginalValue(
						columnName);
				}
				else {
					arguments[i] = codeMasterModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}