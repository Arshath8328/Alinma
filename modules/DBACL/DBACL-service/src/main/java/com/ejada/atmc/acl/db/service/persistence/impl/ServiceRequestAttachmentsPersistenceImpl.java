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

import com.ejada.atmc.acl.db.exception.NoSuchServiceRequestAttachmentsException;
import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestAttachmentsImpl;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestAttachmentsModelImpl;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestAttachmentsPersistence;
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

import java.io.Serializable;

import java.lang.reflect.InvocationHandler;

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
 * The persistence implementation for the service request attachments service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@Component(service = ServiceRequestAttachmentsPersistence.class)
public class ServiceRequestAttachmentsPersistenceImpl
	extends BasePersistenceImpl<ServiceRequestAttachments>
	implements ServiceRequestAttachmentsPersistence {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use <code>ServiceRequestAttachmentsUtil</code> to access the service request attachments persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY =
		ServiceRequestAttachmentsImpl.class.getName();

	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List1";

	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION =
		FINDER_CLASS_NAME_ENTITY + ".List2";

	private FinderPath _finderPathWithPaginationFindAll;
	private FinderPath _finderPathWithoutPaginationFindAll;
	private FinderPath _finderPathCountAll;
	private FinderPath _finderPathWithPaginationFindByrefNo;
	private FinderPath _finderPathWithoutPaginationFindByrefNo;
	private FinderPath _finderPathCountByrefNo;

	/**
	 * Returns all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByrefNo(String REFERENCE_NO) {
		return findByrefNo(
			REFERENCE_NO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end) {

		return findByrefNo(REFERENCE_NO, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return findByrefNo(REFERENCE_NO, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByrefNo(
		String REFERENCE_NO, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache) {

		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByrefNo;
				finderArgs = new Object[] {REFERENCE_NO};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByrefNo;
			finderArgs = new Object[] {
				REFERENCE_NO, start, end, orderByComparator
			};
		}

		List<ServiceRequestAttachments> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestAttachments>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestAttachments serviceRequestAttachments :
						list) {

					if (!REFERENCE_NO.equals(
							serviceRequestAttachments.getREFERENCE_NO())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTATTACHMENTS_WHERE);

			boolean bindREFERENCE_NO = false;

			if (REFERENCE_NO.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
			}
			else {
				bindREFERENCE_NO = true;

				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREFERENCE_NO) {
					queryPos.add(REFERENCE_NO);
				}

				list = (List<ServiceRequestAttachments>)QueryUtil.list(
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
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments findByrefNo_First(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		ServiceRequestAttachments serviceRequestAttachments =
			fetchByrefNo_First(REFERENCE_NO, orderByComparator);

		if (serviceRequestAttachments != null) {
			return serviceRequestAttachments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REFERENCE_NO=");
		sb.append(REFERENCE_NO);

		sb.append("}");

		throw new NoSuchServiceRequestAttachmentsException(sb.toString());
	}

	/**
	 * Returns the first service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments fetchByrefNo_First(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		List<ServiceRequestAttachments> list = findByrefNo(
			REFERENCE_NO, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments findByrefNo_Last(
			String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		ServiceRequestAttachments serviceRequestAttachments = fetchByrefNo_Last(
			REFERENCE_NO, orderByComparator);

		if (serviceRequestAttachments != null) {
			return serviceRequestAttachments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("REFERENCE_NO=");
		sb.append(REFERENCE_NO);

		sb.append("}");

		throw new NoSuchServiceRequestAttachmentsException(sb.toString());
	}

	/**
	 * Returns the last service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments fetchByrefNo_Last(
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		int count = countByrefNo(REFERENCE_NO);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestAttachments> list = findByrefNo(
			REFERENCE_NO, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where REFERENCE_NO = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param REFERENCE_NO the reference_no
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments[] findByrefNo_PrevAndNext(
			long FILE_ID, String REFERENCE_NO,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		ServiceRequestAttachments serviceRequestAttachments = findByPrimaryKey(
			FILE_ID);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestAttachments[] array =
				new ServiceRequestAttachmentsImpl[3];

			array[0] = getByrefNo_PrevAndNext(
				session, serviceRequestAttachments, REFERENCE_NO,
				orderByComparator, true);

			array[1] = serviceRequestAttachments;

			array[2] = getByrefNo_PrevAndNext(
				session, serviceRequestAttachments, REFERENCE_NO,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequestAttachments getByrefNo_PrevAndNext(
		Session session, ServiceRequestAttachments serviceRequestAttachments,
		String REFERENCE_NO,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICEREQUESTATTACHMENTS_WHERE);

		boolean bindREFERENCE_NO = false;

		if (REFERENCE_NO.isEmpty()) {
			sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
		}
		else {
			bindREFERENCE_NO = true;

			sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
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
			sb.append(ServiceRequestAttachmentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindREFERENCE_NO) {
			queryPos.add(REFERENCE_NO);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestAttachments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestAttachments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request attachmentses where REFERENCE_NO = &#63; from the database.
	 *
	 * @param REFERENCE_NO the reference_no
	 */
	@Override
	public void removeByrefNo(String REFERENCE_NO) {
		for (ServiceRequestAttachments serviceRequestAttachments :
				findByrefNo(
					REFERENCE_NO, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequestAttachments);
		}
	}

	/**
	 * Returns the number of service request attachmentses where REFERENCE_NO = &#63;.
	 *
	 * @param REFERENCE_NO the reference_no
	 * @return the number of matching service request attachmentses
	 */
	@Override
	public int countByrefNo(String REFERENCE_NO) {
		REFERENCE_NO = Objects.toString(REFERENCE_NO, "");

		FinderPath finderPath = _finderPathCountByrefNo;

		Object[] finderArgs = new Object[] {REFERENCE_NO};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTATTACHMENTS_WHERE);

			boolean bindREFERENCE_NO = false;

			if (REFERENCE_NO.isEmpty()) {
				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_3);
			}
			else {
				bindREFERENCE_NO = true;

				sb.append(_FINDER_COLUMN_REFNO_REFERENCE_NO_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindREFERENCE_NO) {
					queryPos.add(REFERENCE_NO);
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

	private static final String _FINDER_COLUMN_REFNO_REFERENCE_NO_2 =
		"serviceRequestAttachments.REFERENCE_NO = ?";

	private static final String _FINDER_COLUMN_REFNO_REFERENCE_NO_3 =
		"(serviceRequestAttachments.REFERENCE_NO IS NULL OR serviceRequestAttachments.REFERENCE_NO = '')";

	private FinderPath _finderPathWithPaginationFindByactionId;
	private FinderPath _finderPathWithoutPaginationFindByactionId;
	private FinderPath _finderPathCountByactionId;

	/**
	 * Returns all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByactionId(String ACTION_ID) {
		return findByactionId(
			ACTION_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end) {

		return findByactionId(ACTION_ID, start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return findByactionId(ACTION_ID, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses where ACTION_ID = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param ACTION_ID the action_id
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of matching service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findByactionId(
		String ACTION_ID, int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean useFinderCache) {

		ACTION_ID = Objects.toString(ACTION_ID, "");

		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
			(orderByComparator == null)) {

			if (useFinderCache) {
				finderPath = _finderPathWithoutPaginationFindByactionId;
				finderArgs = new Object[] {ACTION_ID};
			}
		}
		else if (useFinderCache) {
			finderPath = _finderPathWithPaginationFindByactionId;
			finderArgs = new Object[] {
				ACTION_ID, start, end, orderByComparator
			};
		}

		List<ServiceRequestAttachments> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestAttachments>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (ServiceRequestAttachments serviceRequestAttachments :
						list) {

					if (!ACTION_ID.equals(
							serviceRequestAttachments.getACTION_ID())) {

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

			sb.append(_SQL_SELECT_SERVICEREQUESTATTACHMENTS_WHERE);

			boolean bindACTION_ID = false;

			if (ACTION_ID.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_3);
			}
			else {
				bindACTION_ID = true;

				sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);
			}
			else {
				sb.append(ServiceRequestAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindACTION_ID) {
					queryPos.add(ACTION_ID);
				}

				list = (List<ServiceRequestAttachments>)QueryUtil.list(
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
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments findByactionId_First(
			String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		ServiceRequestAttachments serviceRequestAttachments =
			fetchByactionId_First(ACTION_ID, orderByComparator);

		if (serviceRequestAttachments != null) {
			return serviceRequestAttachments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ACTION_ID=");
		sb.append(ACTION_ID);

		sb.append("}");

		throw new NoSuchServiceRequestAttachmentsException(sb.toString());
	}

	/**
	 * Returns the first service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments fetchByactionId_First(
		String ACTION_ID,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		List<ServiceRequestAttachments> list = findByactionId(
			ACTION_ID, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments findByactionId_Last(
			String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		ServiceRequestAttachments serviceRequestAttachments =
			fetchByactionId_Last(ACTION_ID, orderByComparator);

		if (serviceRequestAttachments != null) {
			return serviceRequestAttachments;
		}

		StringBundler sb = new StringBundler(4);

		sb.append(_NO_SUCH_ENTITY_WITH_KEY);

		sb.append("ACTION_ID=");
		sb.append(ACTION_ID);

		sb.append("}");

		throw new NoSuchServiceRequestAttachmentsException(sb.toString());
	}

	/**
	 * Returns the last service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching service request attachments, or <code>null</code> if a matching service request attachments could not be found
	 */
	@Override
	public ServiceRequestAttachments fetchByactionId_Last(
		String ACTION_ID,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		int count = countByactionId(ACTION_ID);

		if (count == 0) {
			return null;
		}

		List<ServiceRequestAttachments> list = findByactionId(
			ACTION_ID, count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the service request attachmentses before and after the current service request attachments in the ordered set where ACTION_ID = &#63;.
	 *
	 * @param FILE_ID the primary key of the current service request attachments
	 * @param ACTION_ID the action_id
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments[] findByactionId_PrevAndNext(
			long FILE_ID, String ACTION_ID,
			OrderByComparator<ServiceRequestAttachments> orderByComparator)
		throws NoSuchServiceRequestAttachmentsException {

		ACTION_ID = Objects.toString(ACTION_ID, "");

		ServiceRequestAttachments serviceRequestAttachments = findByPrimaryKey(
			FILE_ID);

		Session session = null;

		try {
			session = openSession();

			ServiceRequestAttachments[] array =
				new ServiceRequestAttachmentsImpl[3];

			array[0] = getByactionId_PrevAndNext(
				session, serviceRequestAttachments, ACTION_ID,
				orderByComparator, true);

			array[1] = serviceRequestAttachments;

			array[2] = getByactionId_PrevAndNext(
				session, serviceRequestAttachments, ACTION_ID,
				orderByComparator, false);

			return array;
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}
	}

	protected ServiceRequestAttachments getByactionId_PrevAndNext(
		Session session, ServiceRequestAttachments serviceRequestAttachments,
		String ACTION_ID,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
		boolean previous) {

		StringBundler sb = null;

		if (orderByComparator != null) {
			sb = new StringBundler(
				4 + (orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			sb = new StringBundler(3);
		}

		sb.append(_SQL_SELECT_SERVICEREQUESTATTACHMENTS_WHERE);

		boolean bindACTION_ID = false;

		if (ACTION_ID.isEmpty()) {
			sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_3);
		}
		else {
			bindACTION_ID = true;

			sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_2);
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
			sb.append(ServiceRequestAttachmentsModelImpl.ORDER_BY_JPQL);
		}

		String sql = sb.toString();

		Query query = session.createQuery(sql);

		query.setFirstResult(0);
		query.setMaxResults(2);

		QueryPos queryPos = QueryPos.getInstance(query);

		if (bindACTION_ID) {
			queryPos.add(ACTION_ID);
		}

		if (orderByComparator != null) {
			for (Object orderByConditionValue :
					orderByComparator.getOrderByConditionValues(
						serviceRequestAttachments)) {

				queryPos.add(orderByConditionValue);
			}
		}

		List<ServiceRequestAttachments> list = query.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the service request attachmentses where ACTION_ID = &#63; from the database.
	 *
	 * @param ACTION_ID the action_id
	 */
	@Override
	public void removeByactionId(String ACTION_ID) {
		for (ServiceRequestAttachments serviceRequestAttachments :
				findByactionId(
					ACTION_ID, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {

			remove(serviceRequestAttachments);
		}
	}

	/**
	 * Returns the number of service request attachmentses where ACTION_ID = &#63;.
	 *
	 * @param ACTION_ID the action_id
	 * @return the number of matching service request attachmentses
	 */
	@Override
	public int countByactionId(String ACTION_ID) {
		ACTION_ID = Objects.toString(ACTION_ID, "");

		FinderPath finderPath = _finderPathCountByactionId;

		Object[] finderArgs = new Object[] {ACTION_ID};

		Long count = (Long)dummyFinderCache.getResult(
			finderPath, finderArgs, this);

		if (count == null) {
			StringBundler sb = new StringBundler(2);

			sb.append(_SQL_COUNT_SERVICEREQUESTATTACHMENTS_WHERE);

			boolean bindACTION_ID = false;

			if (ACTION_ID.isEmpty()) {
				sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_3);
			}
			else {
				bindACTION_ID = true;

				sb.append(_FINDER_COLUMN_ACTIONID_ACTION_ID_2);
			}

			String sql = sb.toString();

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				QueryPos queryPos = QueryPos.getInstance(query);

				if (bindACTION_ID) {
					queryPos.add(ACTION_ID);
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

	private static final String _FINDER_COLUMN_ACTIONID_ACTION_ID_2 =
		"serviceRequestAttachments.ACTION_ID = ?";

	private static final String _FINDER_COLUMN_ACTIONID_ACTION_ID_3 =
		"(serviceRequestAttachments.ACTION_ID IS NULL OR serviceRequestAttachments.ACTION_ID = '')";

	public ServiceRequestAttachmentsPersistenceImpl() {
		setModelClass(ServiceRequestAttachments.class);

		setModelImplClass(ServiceRequestAttachmentsImpl.class);
		setModelPKClass(long.class);
	}

	/**
	 * Caches the service request attachments in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachments the service request attachments
	 */
	@Override
	public void cacheResult(
		ServiceRequestAttachments serviceRequestAttachments) {

		dummyEntityCache.putResult(
			ServiceRequestAttachmentsImpl.class,
			serviceRequestAttachments.getPrimaryKey(),
			serviceRequestAttachments);
	}

	/**
	 * Caches the service request attachmentses in the entity cache if it is enabled.
	 *
	 * @param serviceRequestAttachmentses the service request attachmentses
	 */
	@Override
	public void cacheResult(
		List<ServiceRequestAttachments> serviceRequestAttachmentses) {

		for (ServiceRequestAttachments serviceRequestAttachments :
				serviceRequestAttachmentses) {

			if (dummyEntityCache.getResult(
					ServiceRequestAttachmentsImpl.class,
					serviceRequestAttachments.getPrimaryKey()) == null) {

				cacheResult(serviceRequestAttachments);
			}
		}
	}

	/**
	 * Clears the cache for all service request attachmentses.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		dummyEntityCache.clearCache(ServiceRequestAttachmentsImpl.class);

		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the service request attachments.
	 *
	 * <p>
	 * The <code>EntityCache</code> and <code>com.liferay.portal.kernel.dao.orm.FinderCache</code> are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(
		ServiceRequestAttachments serviceRequestAttachments) {

		dummyEntityCache.removeResult(
			ServiceRequestAttachmentsImpl.class, serviceRequestAttachments);
	}

	@Override
	public void clearCache(
		List<ServiceRequestAttachments> serviceRequestAttachmentses) {

		for (ServiceRequestAttachments serviceRequestAttachments :
				serviceRequestAttachmentses) {

			dummyEntityCache.removeResult(
				ServiceRequestAttachmentsImpl.class, serviceRequestAttachments);
		}
	}

	@Override
	public void clearCache(Set<Serializable> primaryKeys) {
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		dummyFinderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Serializable primaryKey : primaryKeys) {
			dummyEntityCache.removeResult(
				ServiceRequestAttachmentsImpl.class, primaryKey);
		}
	}

	/**
	 * Creates a new service request attachments with the primary key. Does not add the service request attachments to the database.
	 *
	 * @param FILE_ID the primary key for the new service request attachments
	 * @return the new service request attachments
	 */
	@Override
	public ServiceRequestAttachments create(long FILE_ID) {
		ServiceRequestAttachments serviceRequestAttachments =
			new ServiceRequestAttachmentsImpl();

		serviceRequestAttachments.setNew(true);
		serviceRequestAttachments.setPrimaryKey(FILE_ID);

		return serviceRequestAttachments;
	}

	/**
	 * Removes the service request attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments that was removed
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments remove(long FILE_ID)
		throws NoSuchServiceRequestAttachmentsException {

		return remove((Serializable)FILE_ID);
	}

	/**
	 * Removes the service request attachments with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the service request attachments
	 * @return the service request attachments that was removed
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments remove(Serializable primaryKey)
		throws NoSuchServiceRequestAttachmentsException {

		Session session = null;

		try {
			session = openSession();

			ServiceRequestAttachments serviceRequestAttachments =
				(ServiceRequestAttachments)session.get(
					ServiceRequestAttachmentsImpl.class, primaryKey);

			if (serviceRequestAttachments == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchServiceRequestAttachmentsException(
					_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			return remove(serviceRequestAttachments);
		}
		catch (NoSuchServiceRequestAttachmentsException noSuchEntityException) {
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
	protected ServiceRequestAttachments removeImpl(
		ServiceRequestAttachments serviceRequestAttachments) {

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(serviceRequestAttachments)) {
				serviceRequestAttachments =
					(ServiceRequestAttachments)session.get(
						ServiceRequestAttachmentsImpl.class,
						serviceRequestAttachments.getPrimaryKeyObj());
			}

			if (serviceRequestAttachments != null) {
				session.delete(serviceRequestAttachments);
			}
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		if (serviceRequestAttachments != null) {
			clearCache(serviceRequestAttachments);
		}

		return serviceRequestAttachments;
	}

	@Override
	public ServiceRequestAttachments updateImpl(
		ServiceRequestAttachments serviceRequestAttachments) {

		boolean isNew = serviceRequestAttachments.isNew();

		if (!(serviceRequestAttachments instanceof
				ServiceRequestAttachmentsModelImpl)) {

			InvocationHandler invocationHandler = null;

			if (ProxyUtil.isProxyClass(serviceRequestAttachments.getClass())) {
				invocationHandler = ProxyUtil.getInvocationHandler(
					serviceRequestAttachments);

				throw new IllegalArgumentException(
					"Implement ModelWrapper in serviceRequestAttachments proxy " +
						invocationHandler.getClass());
			}

			throw new IllegalArgumentException(
				"Implement ModelWrapper in custom ServiceRequestAttachments implementation " +
					serviceRequestAttachments.getClass());
		}

		ServiceRequestAttachmentsModelImpl serviceRequestAttachmentsModelImpl =
			(ServiceRequestAttachmentsModelImpl)serviceRequestAttachments;

		Session session = null;

		try {
			session = openSession();

			if (isNew) {
				session.save(serviceRequestAttachments);
			}
			else {
				session.evict(
					ServiceRequestAttachmentsImpl.class,
					serviceRequestAttachments.getPrimaryKeyObj());

				session.saveOrUpdate(serviceRequestAttachments);
			}

			session.flush();
			session.clear();
		}
		catch (Exception exception) {
			throw processException(exception);
		}
		finally {
			closeSession(session);
		}

		dummyEntityCache.putResult(
			ServiceRequestAttachmentsImpl.class,
			serviceRequestAttachmentsModelImpl, false, true);

		if (isNew) {
			serviceRequestAttachments.setNew(false);
		}

		serviceRequestAttachments.resetOriginalValues();

		return serviceRequestAttachments;
	}

	/**
	 * Returns the service request attachments with the primary key or throws a <code>com.liferay.portal.kernel.exception.NoSuchModelException</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the service request attachments
	 * @return the service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments findByPrimaryKey(Serializable primaryKey)
		throws NoSuchServiceRequestAttachmentsException {

		ServiceRequestAttachments serviceRequestAttachments = fetchByPrimaryKey(
			primaryKey);

		if (serviceRequestAttachments == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchServiceRequestAttachmentsException(
				_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
		}

		return serviceRequestAttachments;
	}

	/**
	 * Returns the service request attachments with the primary key or throws a <code>NoSuchServiceRequestAttachmentsException</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments
	 * @throws NoSuchServiceRequestAttachmentsException if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments findByPrimaryKey(long FILE_ID)
		throws NoSuchServiceRequestAttachmentsException {

		return findByPrimaryKey((Serializable)FILE_ID);
	}

	/**
	 * Returns the service request attachments with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param FILE_ID the primary key of the service request attachments
	 * @return the service request attachments, or <code>null</code> if a service request attachments with the primary key could not be found
	 */
	@Override
	public ServiceRequestAttachments fetchByPrimaryKey(long FILE_ID) {
		return fetchByPrimaryKey((Serializable)FILE_ID);
	}

	/**
	 * Returns all the service request attachmentses.
	 *
	 * @return the service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @return the range of service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator) {

		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the service request attachmentses.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to <code>QueryUtil#ALL_POS</code> will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent, then the query will include the default ORDER BY logic from <code>ServiceRequestAttachmentsModelImpl</code>.
	 * </p>
	 *
	 * @param start the lower bound of the range of service request attachmentses
	 * @param end the upper bound of the range of service request attachmentses (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param useFinderCache whether to use the finder cache
	 * @return the ordered range of service request attachmentses
	 */
	@Override
	public List<ServiceRequestAttachments> findAll(
		int start, int end,
		OrderByComparator<ServiceRequestAttachments> orderByComparator,
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

		List<ServiceRequestAttachments> list = null;

		if (useFinderCache) {
			list = (List<ServiceRequestAttachments>)dummyFinderCache.getResult(
				finderPath, finderArgs, this);
		}

		if (list == null) {
			StringBundler sb = null;
			String sql = null;

			if (orderByComparator != null) {
				sb = new StringBundler(
					2 + (orderByComparator.getOrderByFields().length * 2));

				sb.append(_SQL_SELECT_SERVICEREQUESTATTACHMENTS);

				appendOrderByComparator(
					sb, _ORDER_BY_ENTITY_ALIAS, orderByComparator);

				sql = sb.toString();
			}
			else {
				sql = _SQL_SELECT_SERVICEREQUESTATTACHMENTS;

				sql = sql.concat(
					ServiceRequestAttachmentsModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query query = session.createQuery(sql);

				list = (List<ServiceRequestAttachments>)QueryUtil.list(
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
	 * Removes all the service request attachmentses from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (ServiceRequestAttachments serviceRequestAttachments : findAll()) {
			remove(serviceRequestAttachments);
		}
	}

	/**
	 * Returns the number of service request attachmentses.
	 *
	 * @return the number of service request attachmentses
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
					_SQL_COUNT_SERVICEREQUESTATTACHMENTS);

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
		return "FILE_ID";
	}

	@Override
	protected String getSelectSQL() {
		return _SQL_SELECT_SERVICEREQUESTATTACHMENTS;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return ServiceRequestAttachmentsModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the service request attachments persistence.
	 */
	@Activate
	public void activate(BundleContext bundleContext) {
		_bundleContext = bundleContext;

		_argumentsResolverServiceRegistration = _bundleContext.registerService(
			ArgumentsResolver.class,
			new ServiceRequestAttachmentsModelArgumentsResolver(),
			MapUtil.singletonDictionary(
				"model.class.name", ServiceRequestAttachments.class.getName()));

		_finderPathWithPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathWithoutPaginationFindAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0],
			new String[0], true);

		_finderPathCountAll = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll",
			new String[0], new String[0], false);

		_finderPathWithPaginationFindByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByrefNo",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathWithoutPaginationFindByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByrefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, true);

		_finderPathCountByrefNo = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByrefNo",
			new String[] {String.class.getName()},
			new String[] {"REFERENCE_NO"}, false);

		_finderPathWithPaginationFindByactionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByactionId",
			new String[] {
				String.class.getName(), Integer.class.getName(),
				Integer.class.getName(), OrderByComparator.class.getName()
			},
			new String[] {"ACTION_ID"}, true);

		_finderPathWithoutPaginationFindByactionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByactionId",
			new String[] {String.class.getName()}, new String[] {"ACTION_ID"},
			true);

		_finderPathCountByactionId = _createFinderPath(
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByactionId",
			new String[] {String.class.getName()}, new String[] {"ACTION_ID"},
			false);
	}

	@Deactivate
	public void deactivate() {
		dummyEntityCache.removeCache(
			ServiceRequestAttachmentsImpl.class.getName());

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

	private static final String _SQL_SELECT_SERVICEREQUESTATTACHMENTS =
		"SELECT serviceRequestAttachments FROM ServiceRequestAttachments serviceRequestAttachments";

	private static final String _SQL_SELECT_SERVICEREQUESTATTACHMENTS_WHERE =
		"SELECT serviceRequestAttachments FROM ServiceRequestAttachments serviceRequestAttachments WHERE ";

	private static final String _SQL_COUNT_SERVICEREQUESTATTACHMENTS =
		"SELECT COUNT(serviceRequestAttachments) FROM ServiceRequestAttachments serviceRequestAttachments";

	private static final String _SQL_COUNT_SERVICEREQUESTATTACHMENTS_WHERE =
		"SELECT COUNT(serviceRequestAttachments) FROM ServiceRequestAttachments serviceRequestAttachments WHERE ";

	private static final String _ORDER_BY_ENTITY_ALIAS =
		"serviceRequestAttachments.";

	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY =
		"No ServiceRequestAttachments exists with the primary key ";

	private static final String _NO_SUCH_ENTITY_WITH_KEY =
		"No ServiceRequestAttachments exists with the key {";

	private static final Log _log = LogFactoryUtil.getLog(
		ServiceRequestAttachmentsPersistenceImpl.class);

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

	private static class ServiceRequestAttachmentsModelArgumentsResolver
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

			ServiceRequestAttachmentsModelImpl
				serviceRequestAttachmentsModelImpl =
					(ServiceRequestAttachmentsModelImpl)baseModel;

			long columnBitmask =
				serviceRequestAttachmentsModelImpl.getColumnBitmask();

			if (!checkColumn || (columnBitmask == 0)) {
				return _getValue(
					serviceRequestAttachmentsModelImpl, columnNames, original);
			}

			Long finderPathColumnBitmask = _finderPathColumnBitmasksCache.get(
				finderPath);

			if (finderPathColumnBitmask == null) {
				finderPathColumnBitmask = 0L;

				for (String columnName : columnNames) {
					finderPathColumnBitmask |=
						serviceRequestAttachmentsModelImpl.getColumnBitmask(
							columnName);
				}

				_finderPathColumnBitmasksCache.put(
					finderPath, finderPathColumnBitmask);
			}

			if ((columnBitmask & finderPathColumnBitmask) != 0) {
				return _getValue(
					serviceRequestAttachmentsModelImpl, columnNames, original);
			}

			return null;
		}

		private Object[] _getValue(
			ServiceRequestAttachmentsModelImpl
				serviceRequestAttachmentsModelImpl,
			String[] columnNames, boolean original) {

			Object[] arguments = new Object[columnNames.length];

			for (int i = 0; i < arguments.length; i++) {
				String columnName = columnNames[i];

				if (original) {
					arguments[i] =
						serviceRequestAttachmentsModelImpl.
							getColumnOriginalValue(columnName);
				}
				else {
					arguments[i] =
						serviceRequestAttachmentsModelImpl.getColumnValue(
							columnName);
				}
			}

			return arguments;
		}

		private static Map<FinderPath, Long> _finderPathColumnBitmasksCache =
			new ConcurrentHashMap<>();

	}

}