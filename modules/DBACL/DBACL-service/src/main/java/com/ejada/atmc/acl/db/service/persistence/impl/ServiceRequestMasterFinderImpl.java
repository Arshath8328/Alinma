package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.ServiceRequestMaster;
import com.ejada.atmc.acl.db.model.impl.ServiceRequestMasterImpl;
import com.ejada.atmc.acl.db.service.ServiceRequestMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestMasterFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = ServiceRequestMasterFinder.class
)
public class ServiceRequestMasterFinderImpl extends ServiceRequestMasterFinderBaseImpl implements ServiceRequestMasterFinder {
	private static final Log _log = LogFactoryUtil.getLog(ServiceRequestMasterFinderImpl.class);

	public List<ServiceRequestMaster> findServiceRequestsByIqamaId(String iqamaId) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil
					.forClass(ServiceRequestMaster.class, ServiceRequestMasterFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("IQAMA_ID", iqamaId)).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));

			List<ServiceRequestMaster> entries = ServiceRequestMasterLocalServiceUtil.dynamicQuery(entryQuery);

			return entries;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ServiceRequestMaster> findServiceRequestsByIdStatus(String iqamaId, String[] lstStatus) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil
					.forClass(ServiceRequestMaster.class, ServiceRequestMasterFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("IQAMA_ID", iqamaId)).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));

			Junction junction = RestrictionsFactoryUtil.disjunction();
			for (String status : lstStatus) {
				junction.add(PropertyFactoryUtil.forName("REQUEST_STATUS").eq(status));
			}
			entryQuery.add(junction).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));

			List<ServiceRequestMaster> entries = ServiceRequestMasterLocalServiceUtil.dynamicQuery(entryQuery);

			return entries;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ServiceRequestMaster> findServiceRequestsByEscalationFlag(String userRole, String closedStatus, boolean isAdmin) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(ServiceRequestMaster.class,
					ServiceRequestMasterFinderImpl.class.getClassLoader());

			Junction junction = RestrictionsFactoryUtil.conjunction();
			junction.add(RestrictionsFactoryUtil.not(PropertyFactoryUtil.forName("REQUEST_STATUS").eq(closedStatus)));
			junction.add(PropertyFactoryUtil.forName("ESCALATION_FLAG").eq(Boolean.TRUE));

			if (!isAdmin) {
				Junction disjunction = RestrictionsFactoryUtil.disjunction();
				disjunction.add(PropertyFactoryUtil.forName("ASSIGNED_TO").eq(userRole));
				entryQuery.add(disjunction);
			}

			entryQuery.add(junction).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));

			List<ServiceRequestMaster> entries = ServiceRequestMasterLocalServiceUtil.dynamicQuery(entryQuery);

			return entries;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ServiceRequestMaster> findServiceRequestsByReqStatus(String[] lstStatus) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(ServiceRequestMaster.class,
					ServiceRequestMasterFinderImpl.class.getClassLoader());

			Junction junction = RestrictionsFactoryUtil.disjunction();
			for (String status : lstStatus) {
				junction.add(PropertyFactoryUtil.forName("REQUEST_STATUS").eq(status));
			}
			entryQuery.add(junction).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));
			if (!lstStatus[0].equals("Closed")) {
				entryQuery.add(PropertyFactoryUtil.forName("ESCALATION_FLAG").eq(Boolean.FALSE));
			}

			List<ServiceRequestMaster> entries = ServiceRequestMasterLocalServiceUtil.dynamicQuery(entryQuery);

			return entries;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<ServiceRequestMaster> findServiceRequestsByReqRoleStatus(String[] lstStatus, String role) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(ServiceRequestMaster.class,
					ServiceRequestMasterFinderImpl.class.getClassLoader());

			Junction junction = RestrictionsFactoryUtil.disjunction();
			for (String status : lstStatus) {
				junction.add(PropertyFactoryUtil.forName("REQUEST_STATUS").eq(status));
			}
			entryQuery.add(junction).add(PropertyFactoryUtil.forName("ASSIGNED_TO").eq(role)).addOrder(OrderFactoryUtil.asc("CREATION_DATE"));
			List<ServiceRequestMaster> entries = ServiceRequestMasterLocalServiceUtil.dynamicQuery(entryQuery);

			return entries;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<Object> findServiceRequestsByStatusRoleAdmin(String role, String[] lstStatus, String customerID, boolean escalationFlag, int from,
			int to, String orderBy, String orderDir) {

		Session session = null;
		try {
			session = openSession();
			String queryS = "SELECT  * FROM " + "( SELECT  q.*, rownum rn FROM " + "( SELECT  * FROM SERVICE_REQUEST_MASTER";
			SQLQuery query = null;
			int first = 1;
			if (lstStatus != null && lstStatus.length > 0) {
				if (first == 1) {
					queryS = queryS + " WHERE (SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					for (int i = 1; i < lstStatus.length; i++) {
						queryS += " OR SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					}
					queryS += ")";
					first++;
				} else {
					queryS = queryS + " AND (SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					for (int i = 1; i < lstStatus.length; i++) {
						queryS += " OR SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					}
					queryS += ")";
				}

			}

			if (customerID != null && !customerID.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.IQAMA_ID = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.IQAMA_ID = ?";
				}
			}

			if (escalationFlag) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.ESCALATION_FLAG = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.ESCALATION_FLAG = ?";
				}
			}

			if (role != null && !role.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.ASSIGNED_TO = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.ASSIGNED_TO = ?";
				}
			}

			queryS = queryS + " ORDER BY " + orderBy + " " + orderDir.toUpperCase() + ") q) WHERE   rn BETWEEN ? AND ?";
			_log.info(" Customer Service Pagination Query : " + queryS);
			query = session.createSQLQuery(queryS);
			query.setCacheable(false);
			query.addEntity("serviceRequest", ServiceRequestMasterImpl.class);
			QueryPos pos = QueryPos.getInstance(query);

			if (lstStatus != null && lstStatus.length > 0) {
				for (int i = 0; i < lstStatus.length; i++)
					pos.add(lstStatus[i]);
			}

			if (customerID != null && !customerID.equals("")) {
				pos.add(customerID);
			}

			if (escalationFlag) {
				pos.add(Boolean.TRUE);
			}

			if (role != null && !role.equals("")) {
				pos.add(role);
			}

			pos.add(from);
			pos.add(to);

			return (List) query.list();
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public int countServiceRequestsByStatusRoleAdmin(String role, String[] lstStatus, String customerID, boolean escalationFlag) {

		Session session = null;
		try {
			session = openSession();
			String queryS = "SELECT  COUNT(*) AS recordsTotalCount FROM SERVICE_REQUEST_MASTER";
			SQLQuery query = null;
			int first = 1;
			if (lstStatus != null && lstStatus.length > 0) {
				if (first == 1) {
					queryS = queryS + " WHERE (SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					for (int i = 1; i < lstStatus.length; i++) {
						queryS += " OR SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					}
					queryS += ")";
					first++;
				} else {
					queryS = queryS + " AND (SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					for (int i = 1; i < lstStatus.length; i++) {
						queryS += " OR SERVICE_REQUEST_MASTER.REQUEST_STATUS = ?";
					}
					queryS += ")";
				}

			}

			if (customerID != null && !customerID.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.IQAMA_ID = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.IQAMA_ID = ?";
				}
			}

			if (escalationFlag) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.ESCALATION_FLAG = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.ESCALATION_FLAG = ?";
				}
			}

			if (role != null && !role.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE SERVICE_REQUEST_MASTER.ASSIGNED_TO = ?";
					first++;
				} else {
					queryS = queryS + " AND SERVICE_REQUEST_MASTER.ASSIGNED_TO = ?";
				}
			}

			// queryS=queryS+" ORDER BY CREATION_DATE ASC";
			_log.info(" Customer Service Pagination Query : " + queryS);
			query = session.createSQLQuery(queryS);
			query.setCacheable(false);
			// query.addEntity("serviceRequest", ServiceRequestMasterImpl.class);
			query.addScalar("recordsTotalCount", Type.INTEGER);
			QueryPos pos = QueryPos.getInstance(query);

			if (lstStatus != null && lstStatus.length > 0) {
				for (int i = 0; i < lstStatus.length; i++)
					pos.add(lstStatus[i]);
			}

			if (customerID != null && !customerID.equals("")) {
				pos.add(customerID);
			}

			if (escalationFlag) {
				pos.add(Boolean.TRUE);
			}

			if (role != null && !role.equals("")) {
				pos.add(role);
			}

			return (int) query.list().get(0);
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return 0;
	}

}
