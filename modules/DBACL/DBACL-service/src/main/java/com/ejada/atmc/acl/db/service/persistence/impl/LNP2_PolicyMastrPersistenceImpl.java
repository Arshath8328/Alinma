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

import com.ejada.atmc.acl.db.exception.NoSuchLNP2_PolicyMastrException;
import com.ejada.atmc.acl.db.model.LNP2_PolicyMastr;
import com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrImpl;
import com.ejada.atmc.acl.db.model.impl.LNP2_PolicyMastrModelImpl;
import com.ejada.atmc.acl.db.service.persistence.LNP2_PolicyMastrPersistence;
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
 * The persistence implementation for the lnp2_ policy mastr service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = LNP2_PolicyMastrPersistence.class)
public class LNP2_PolicyMastrPersistenceImpl
	extends BasePersistenceImpl<LNP2_PolicyMastr>
	implements LNP2_PolicyMastrPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>LNP2_PolicyMastrUtil</code> to access the lnp2_ policy mastr persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		LNP2_PolicyMastrImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathFetchBynp1_proposal;
	private FinderPath _finderPathCountBynp1_proposal;

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or throws a <code>NoSuchLNP2_PolicyMastrException</code> if it could not be found.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the matching lnp2_ policy mastr
	 * @throws NoSuchLNP2_PolicyMastrException if a matching lnp2_ policy mastr could not be found
	 */
	@Override
	public LNP2_PolicyMastr findBynp1_proposal(String np1_proposal)
		throws NoSuchLNP2_PolicyMastrException {

		LNP2_PolicyMastr lnp2_PolicyMastr = fetchBynp1_proposal(np1_proposal);

		if (lnp2_PolicyMastr == null) {
			StringBundler sb = new StringBundler(4);

			sb.append(_NO_SUCH_ENTITY_WITH_KEY);

			sb.append("np1_proposal=");
			sb.append(np1_proposal);

			sb.append("}");

			if (_log.isDebugEnabled()) {
				_log.debug(sb.toString());
			}

			throw new NoSuchLNP2_PolicyMastrException(sb.toString());
		}

		return lnp2_PolicyMastr;
	}

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the matching lnp2_ policy mastr, or <code>null</code> if a matching lnp2_ policy mastr could not be found
	 */
	@Override
	public LNP2_PolicyMastr fetchBynp1_proposal(String np1_proposal) {
		return fetchBynp1_proposal(np1_proposal, true);
	}

	/**
	 * Returns the lnp2_ policy mastr where np1_proposal = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param np1_proposal the np1_proposal
	 * @param useFinderCache whether to use the finder cache
	 * @return the matching lnp2_ policy mastr, or <code>null</code> if a matching lnp2_ policy mastr could not be found
	 */
	@Override
	public LNP2_PolicyMastr fetchBynp1_proposal(
		String np1_proposal, boolean useFinderCache) {

		np1_proposal = Objects.toString(np1_proposal, "");

		Object[] finderArgs = null;

		if (useFinderCache) {
			finderArgs = new Object[] {np1_proposal};
		}

		Object result = null;

		if (useFinderCache) {
			result = dummyFinderCache.getResult(
				_finderPathFetchBynp1_proposal, finderArgs, this);
		}

		if (result instanceof LNP2_PolicyMastr) {
			LNP2_PolicyMastr lnp2_PolicyMastr = (LNP2_PolicyMastr)result;

			if (!Objects.equals(
					np1_proposal, lnp2_PolicyMastr.getNp1_proposal())) {

				result = null;
			}
		}

		if (result == null) {
			StringBundler sb = new StringBundler(3);

			sb.append(_SQL_SELECT_LNP2_POLICYMASTR_WHERE);

			boolean bindNp1_proposal = false;

			if (np1_proposal.isEmpty()) {
				sb.append(_FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_3);
			}
			else {
				bindNp1_proposal = true;

				sb.append(_FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNp1_proposal) {
					queryPos.add(np1_proposal);
				}

				List<LNP2_PolicyMastr> list = query.list();

				if (list.isEmpty()) {
					if (useFinderCache) {
						dummyFinderCache.putResult(
							_finderPathFetchBynp1_proposal, finderArgs, list);
					}
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							if (!useFinderCache) {
								finderArgs = new Object[] {np1_proposal};
							}

							_log.warn(
								"LNP2_PolicyMastrPersistenceImpl.fetchBynp1_proposal(String, boolean) with parameters (" +
									StringUtil.merge(finderArgs) +
										") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					LNP2_PolicyMastr lnp2_PolicyMastr = list.get(0);

					result = lnp2_PolicyMastr;

					cacheResult(lnp2_PolicyMastr);
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
			return (LNP2_PolicyMastr)result;
		}
	}

	/**
	 * Removes the lnp2_ policy mastr where np1_proposal = &#63; from the database.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the lnp2_ policy mastr that was removed
	 */
	@Override
	public LNP2_PolicyMastr removeBynp1_proposal(String np1_proposal)
		throws NoSuchLNP2_PolicyMastrException {

		LNP2_PolicyMastr lnp2_PolicyMastr = findBynp1_proposal(np1_proposal);

		return remove(lnp2_PolicyMastr);
	}

	/**
	 * Returns the number of lnp2_ policy mastrs where np1_proposal = &#63;.
	 *
	 * @param np1_proposal the np1_proposal
	 * @return the number of matching lnp2_ policy mastrs
	 */
	@Override
	public int countBynp1_proposal(String np1_proposal) {
		np1_proposal = Objects.toString(np1_proposal, "");

		FinderPath finderPath = _finderPathCountBynp1_proposal;

		Object[] finderArgs = new Object[] {np1_proposal};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_LNP2_POLICYMASTR_WHERE);

			boolean bindNp1_proposal = false;

			if (np1_proposal.isEmpty()) {
				sb.append(_FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_3);
			}
			else {
				bindNp1_proposal = true;

				sb.append(_FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindNp1_proposal) {
					queryPos.add(np1_proposal);
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

	private static final String _FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_2 =
		"lnp2_PolicyMastr.np1_proposal = ?";

	private static final String _FINDER_COLUMN_NP1_PROPOSAL_NP1_PROPOSAL_3 =
		"(lnp2_PolicyMastr.np1_proposal IS NULL OR lnp2_PolicyMastr.np1_proposal = '')";

	public LNP2_PolicyMastrPersistenceImpl() {
		Map<String, String> dbColumnNames = new HashMap<String, String>();

		dbColumnNames.put("np1_proposal", "NP1_PROPOSAL");
		dbColumnNames.put("np2_setno", "NP2_SETNO");
		dbColumnNames.put("cfr_forfeitucd", "CFR_FORFEITUCD");
		dbColumnNames.put("cmo_mode", "CMO_MODE");
		dbColumnNames.put("pcu_currcode", "PCU_CURRCODE");
		dbColumnNames.put("aag_agcode", "AAG_AGCODE");
		dbColumnNames.put("ccl_categorycd", "CCL_CATEGORYCD");
		dbColumnNames.put("use_userid", "USE_USERID");
		dbColumnNames.put("use_datetime", "USE_DATETIME");
		dbColumnNames.put("np2_grosprm", "NP2_GROSPRM");
		dbColumnNames.put("np2_ageprem", "NP2_AGEPREM");
		dbColumnNames.put("np2_commendate", "NP2_COMMENDATE");
		dbColumnNames.put("np2_sumatrisk", "NP2_SUMATRISK");
		dbColumnNames.put("np2_substandar", "NP2_SUBSTANDAR");
		dbColumnNames.put("np2_effectdate", "NP2_EFFECTDATE");
		dbColumnNames.put("np2_expirydate", "NP2_EXPIRYDATE");
		dbColumnNames.put("np2_endofprmdt", "NP2_ENDOFPRMDT");
		dbColumnNames.put("np2_paidupamt", "NP2_PAIDUPAMT");
		dbColumnNames.put("np2_diffinprem", "NP2_DIFFINPREM");
		dbColumnNames.put("np2_diffinfyco", "NP2_DIFFINFYCO");
		dbColumnNames.put("np2_charges", "NP2_CHARGES");
		dbColumnNames.put("np2_totload", "NP2_TOTLOAD");
		dbColumnNames.put("np2_nextduedat", "NP2_NEXTDUEDAT");
		dbColumnNames.put("np2_ageadmitt", "NP2_AGEADMITT");
		dbColumnNames.put("np2_optimaindex", "NP2_OPTIMAINDEX");
		dbColumnNames.put("np2_ageprem2nd", "NP2_AGEPREM2ND");
		dbColumnNames.put("np2_policyfees", "NP2_POLICYFEES");
		dbColumnNames.put("np2_sar", "NP2_SAR");
		dbColumnNames.put("np2_totpremium", "NP2_TOTPREMIUM");
		dbColumnNames.put("np2_approved", "NP2_APPROVED");
		dbColumnNames.put("np2_endorsementno", "NP2_ENDORSEMENTNO");
		dbColumnNames.put("pfs_acntyear", "PFS_ACNTYEAR");
		dbColumnNames.put("arq_requestype", "ARQ_REQUESTYPE");
		dbColumnNames.put("arq_requestno", "ARQ_REQUESTNO");
		dbColumnNames.put("np2_forfeitdat", "NP2_FORFEITDAT");
		dbColumnNames.put("convert", "CONVERT");
		dbColumnNames.put("np2_notionalage", "NP2_NOTIONALAGE");
		dbColumnNames.put("cop_occupaticd", "COP_OCCUPATICD");
		dbColumnNames.put("np2_dob", "NP2_DOB");
		dbColumnNames.put("np2_accr_proc", "NP2_ACCR_PROC");
		dbColumnNames.put("np2_effectiveage", "NP2_EFFECTIVEAGE");
		dbColumnNames.put("np2_nom2ndlife", "NP2_NOM2NDLIFE");
		dbColumnNames.put("np2_dob_2nd", "NP2_DOB_2ND");
		dbColumnNames.put("np2_lastrevbonus", "NP2_LASTREVBONUS");
		dbColumnNames.put("np2_reversionary", "NP2_REVERSIONARY");
		dbColumnNames.put("np2_rider_bonus", "NP2_RIDER_BONUS");
		dbColumnNames.put("np2_last_rider_bonus", "NP2_LAST_RIDER_BONUS");
		dbColumnNames.put("np2_ageprem_actual", "NP2_AGEPREM_ACTUAL");
		dbColumnNames.put("np2_ageprem2nd_actual", "NP2_AGEPREM2ND_ACTUAL");

		setDBColumnNames(dbColumnNames);

		setModelClass(LNP2_PolicyMastr.class);

		setModelImplClass(LNP2_PolicyMastrImpl.class);
		setModelPKClass(String.class);
	}

	/**
	 * Caches the lnp2_ policy mastr in the entity cache if it is enabled.
	 *
	 * @param lnp2_PolicyMastr the lnp2_ policy mastr
	 */
	@Override
	public void cacheResult(LNP2_PolicyMastr lnp2_PolicyMastr) {
		dummyEntityCache.putResult(
			LNP2_PolicyMastrImpl.class, lnp2_PolicyMastr.getPrimaryKey(),
			lnp2_PolicyMastr);

		dummyFinderCache.putResult(
			_finderPathFetchBynp1_proposal,
			new Object[] {lnp2_PolicyMastr.getNp1_proposal()},
			lnp2_PolicyMastr);
	}

	/**
	 * Caches the lnp2_ policy mastrs in the entity cache if it is enabled.
	 *
	 * @param lnp2_PolicyMastrs the lnp2_ policy mastrs
	 */
	@Override
	public void cacheResult(List<LNP2_PolicyMastr> lnp2_PolicyMastrs) {
		for (LNP2_PolicyMastr lnp2_PolicyMastr : lnp2_PolicyMastrs) {
			if (dummyEntityCache.getResult(
					LNP2_PolicyMastrImpl.class,
					lnp2_PolicyMastr.getPrimaryKey()) == null) {

				cacheResult(lnp2_PolicyMastr);
			}
		}
	}

	/**
	 * Clears the cache for all lnp2_ policy mastrs.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(LNP2_PolicyMastrImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the lnp2_ policy mastr.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(LNP2_PolicyMastr lnp2_PolicyMastr) {
		dummyEntityCache.removeResult(
			LNP2_PolicyMastrImpl.class, lnp2_PolicyMastr);
	}

	@Override
	public void clearCache(List<LNP2_PolicyMastr> lnp2_PolicyMastrs) {
		for (LNP2_PolicyMastr lnp2_PolicyMastr : lnp2_PolicyMastrs) {
			dummyEntityCache.removeResult(
				LNP2_PolicyMastrImpl.class, lnp2_PolicyMastr);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				LNP2_PolicyMastrImpl.class, primaryKey);
		}
	}

	protected void cacheUniqueFindersCache(
		LNP2_PolicyMastrModelImpl lnp2_PolicyMastrModelImpl) {

		Object[] args = new Object[] {
			lnp2_PolicyMastrModelImpl.getNp1_proposal()
		};

		dummyFinderCache.putResult(
			_finderPathCountBynp1_proposal, args, Long.valueOf(1), false);
		dummyFinderCache.putResult(
			_finderPathFetchBynp1_proposal, args, lnp2_PolicyMastrModelImpl,
			false);
	}

	/**
	 * Creates a new lnp2_ policy mastr with the primary key. Does not add the lnp2_ policy mastr to the database.
	 *
	 * @param np1_proposal the primary key for the new lnp2_ policy mastr
	 * @return the new lnp2_ policy mastr
	 */
	@Override
	public LNP2_PolicyMastr create(String np1_proposal) {
		LNP2_PolicyMastr lnp2_PolicyMastr = new LNP2_PolicyMastrImpl();

		lnp2_PolicyMastr.setNew(true);
		lnp2_PolicyMastr.setPrimaryKey(np1_proposal);

		return lnp2_PolicyMastr;
	}

	/**
	 * Removes the lnp2_ policy mastr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public LNP2_PolicyMastr remove(String np1_proposal)
		throws NoSuchLNP2_PolicyMastrException {

		return remove((Serializable)np1_proposal);
	}

	/**
	 * Removes the lnp2_ policy mastr with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr that was removed
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public LNP2_PolicyMastr remove(Serializable primaryKey)
		throws NoSuchLNP2_PolicyMastrException {

		Session session = null;

		try {
			session = openSession();

			LNP2_PolicyMastr lnp2_PolicyMastr = (LNP2_PolicyMastr)session.get(
				LNP2_PolicyMastrImpl.class, primaryKey);

			if (lnp2_PolicyMastr == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchLNP2_PolicyMastrException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(lnp2_PolicyMastr);
		}
		catch (NoSuchLNP2_PolicyMastrException noSuchEntityException) {
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
	protected LNP2_PolicyMastr removeImpl(LNP2_PolicyMastr lnp2_PolicyMastr) {
		Session session = null;

		try {
			session = openSession();

			if (!session.contains(lnp2_PolicyMastr)) {
				lnp2_PolicyMastr = (LNP2_PolicyMastr)session.get(
					LNP2_PolicyMastrImpl.class,
					lnp2_PolicyMastr.getPrimaryKeyObj());
			}

			if (lnp2_PolicyMastr != null) {
				session.delete(lnp2_PolicyMastr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (lnp2_PolicyMastr != null) {
			clearCache(lnp2_PolicyMastr);
		}

		return lnp2_PolicyMastr;
	}

	@Override
	public LNP2_PolicyMastr updateImpl(LNP2_PolicyMastr lnp2_PolicyMastr) {
		boolean isNew = lnp2_PolicyMastr.isNew();

		if (!(lnp2_PolicyMastr instanceof LNP2_PolicyMastrModelImpl)) {
			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(lnp2_PolicyMastr.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					lnp2_PolicyMastr);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in lnp2_PolicyMastr proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom LNP2_PolicyMastr implementation " +
					lnp2_PolicyMastr.getClass());
		}

		LNP2_PolicyMastrModelImpl lnp2_PolicyMastrModelImpl =
			(LNP2_PolicyMastrModelImpl)lnp2_PolicyMastr;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(lnp2_PolicyMastr);
			}
			else {
				lnp2_PolicyMastr = (LNP2_PolicyMastr)session.merge(
					lnp2_PolicyMastr);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			LNP2_PolicyMastrImpl.class, lnp2_PolicyMastrModelImpl, false, true);

		cacheUniqueFindersCache(lnp2_PolicyMastrModelImpl);

		if (isNew) {
			lnp2_PolicyMastr.setNew(false);
		}

		lnp2_PolicyMastr.resetOriginalValues();

		return lnp2_PolicyMastr;
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public LNP2_PolicyMastr findByPrimaryKey(Serializable primaryKey)
		throws NoSuchLNP2_PolicyMastrException {

		LNP2_PolicyMastr lnp2_PolicyMastr = fetchByPrimaryKey(primaryKey);

		if (lnp2_PolicyMastr == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchLNP2_PolicyMastrException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return lnp2_PolicyMastr;
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key or throws a <code>NoSuchLNP2_PolicyMastrException</code> if it could not be found.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr
	 * @throws NoSuchLNP2_PolicyMastrException if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public LNP2_PolicyMastr findByPrimaryKey(String np1_proposal)
		throws NoSuchLNP2_PolicyMastrException {

		return findByPrimaryKey((Serializable)np1_proposal);
	}

	/**
	 * Returns the lnp2_ policy mastr with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param np1_proposal the primary key of the lnp2_ policy mastr
	 * @return the lnp2_ policy mastr, or <code>null</code> if a lnp2_ policy mastr with the primary key could not be found
	 */
	@Override
	public LNP2_PolicyMastr fetchByPrimaryKey(String np1_proposal) {
		return fetchByPrimaryKey((Serializable)np1_proposal);
	}

	/**
	 * Returns all the lnp2_ policy mastrs.
	 *
	 * @return the lnp2_ policy mastrs
	 */
	@Override
	public List<LNP2_PolicyMastr> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @return the range of lnp2_ policy mastrs
	 */
	@Override
	public List<LNP2_PolicyMastr> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of lnp2_ policy mastrs
	 */
	@Override
	public List<LNP2_PolicyMastr> findAll(
		int start, int end,
		OrderByComparator<LNP2_PolicyMastr> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the lnp2_ policy mastrs.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>LNP2_PolicyMastrModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of lnp2_ policy mastrs
	 * @param end the upper bound of the range of lnp2_ policy mastrs (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of lnp2_ policy mastrs
	 */
	@Override
	public List<LNP2_PolicyMastr> findAll(
		int start, int end,
		OrderByComparator<LNP2_PolicyMastr> orderByComparator,
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

		List<LNP2_PolicyMastr> list = null;

		if (useFinderCache) {
			list = (List<LNP2_PolicyMastr>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_LNP2_POLICYMASTR);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_LNP2_POLICYMASTR;

				sql = sql.concat(LNP2_PolicyMastrModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<LNP2_PolicyMastr>)QueryUtil.list(
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
	 * Removes all the lnp2_ policy mastrs from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (LNP2_PolicyMastr lnp2_PolicyMastr : findAll()) {
			remove(lnp2_PolicyMastr);
		}
	}

	/**
	 * Returns the number of lnp2_ policy mastrs.
	 *
	 * @return the number of lnp2_ policy mastrs
	 */
	@Override
	public int countAll() {
		Long count = (Long)dummyFinderCache.getResult(
			_finderPathCountAll, FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(_SQL_COUNT_LNP2_POLICYMASTR);

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
		return "NP1_PROPOSAL";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_LNP2_POLICYMASTR;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return LNP2_PolicyMastrModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the lnp2_ policy mastr persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new LNP2_PolicyMastrModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", LNP2_PolicyMastr.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathFetchBynp1_proposal = _createFinderPath(
			FINDER_CLASS_NAME_ENTITY, "fetchBynp1_proposal",
			new String[] {String.class.getName()},
			new String[] {"NP1_PROPOSAL"}, true);

		_finderPathCountBynp1_proposal = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countBynp1_proposal",
			new String[] {String.class.getName()},
			new String[] {"NP1_PROPOSAL"}, false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(LNP2_PolicyMastrImpl.class.getName());

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

	private static final String _SQL_SELECT_LNP2_POLICYMASTR =
		"SELECT lnp2_PolicyMastr FROM LNP2_PolicyMastr lnp2_PolicyMastr";

	private static final String _SQL_SELECT_LNP2_POLICYMASTR_WHERE =
		"SELECT lnp2_PolicyMastr FROM LNP2_PolicyMastr lnp2_PolicyMastr WHERE ";

	private static final String _SQL_COUNT_LNP2_POLICYMASTR =
		"SELECT COUNT(lnp2_PolicyMastr) FROM LNP2_PolicyMastr lnp2_PolicyMastr";

	private static final String _SQL_COUNT_LNP2_POLICYMASTR_WHERE =
		"SELECT COUNT(lnp2_PolicyMastr) FROM LNP2_PolicyMastr lnp2_PolicyMastr WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS = "lnp2_PolicyMastr.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No LNP2_PolicyMastr exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No LNP2_PolicyMastr exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		LNP2_PolicyMastrPersistenceImpl.class);

	private static final Set<String> _badColumnNames = SetUtil.fromArray(
		new String[] {
			"np1_proposal", "np2_setno", "cfr_forfeitucd", "cmo_mode",
			"pcu_currcode", "aag_agcode", "ccl_categorycd", "use_userid",
			"use_datetime", "np2_grosprm", "np2_ageprem", "np2_commendate",
			"np2_sumatrisk", "np2_substandar", "np2_effectdate",
			"np2_expirydate", "np2_endofprmdt", "np2_paidupamt",
			"np2_diffinprem", "np2_diffinfyco", "np2_charges", "np2_totload",
			"np2_nextduedat", "np2_ageadmitt", "np2_optimaindex",
			"np2_ageprem2nd", "np2_policyfees", "np2_sar", "np2_totpremium",
			"np2_approved", "np2_endorsementno", "pfs_acntyear",
			"arq_requestype", "arq_requestno", "np2_forfeitdat", "convert",
			"np2_notionalage", "cop_occupaticd", "np2_dob", "np2_accr_proc",
			"np2_effectiveage", "np2_nom2ndlife", "np2_dob_2nd",
			"np2_lastrevbonus", "np2_reversionary", "np2_rider_bonus",
			"np2_last_rider_bonus", "np2_ageprem_actual",
			"np2_ageprem2nd_actual"
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

	private static class LNP2_PolicyMastrModelArgumentsResolver
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

			LNP2_PolicyMastrModelImpl lnp2_PolicyMastrModelImpl =
				(LNP2_PolicyMastrModelImpl)baseModel;

			long columnBitmask = lnp2_PolicyMastrModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					lnp2_PolicyMastrModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						lnp2_PolicyMastrModelImpl.getColumnBitmask(columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					lnp2_PolicyMastrModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			LNP2_PolicyMastrModelImpl lnp2_PolicyMastrModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						lnp2_PolicyMastrModelImpl.getColumnOriginalValue(
							columnName);
				}
				else {
					arguments[i] = lnp2_PolicyMastrModelImpl.getColumnValue(
						columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}