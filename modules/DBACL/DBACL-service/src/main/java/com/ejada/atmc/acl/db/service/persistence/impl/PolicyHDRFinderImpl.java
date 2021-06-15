package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyHDRFinder;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = PolicyHDRFinder.class
)
public class PolicyHDRFinderImpl extends PolicyHDRFinderBaseImpl implements PolicyHDRFinder {

	private static final Log _log = LogFactoryUtil.getLog(PolicyHDRFinderImpl.class);

	public List<PolicyHDR> findByIqamaId(String iqamaId, int start, int end) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("iqamaId", iqamaId));
			entryQuery.addOrder(OrderFactoryUtil.desc("expiryDate"));
			if (end != 0) {
				entryQuery.setLimit(start, end);
			}
			List<PolicyHDR> entries = PolicyHDRLocalServiceUtil.dynamicQuery(entryQuery);

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

	public long findCountByIqamaId(String iqamaId) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("iqamaId", iqamaId));
			entryQuery.addOrder(OrderFactoryUtil.desc("expiryDate"));
			long entries = PolicyHDRLocalServiceUtil.dynamicQueryCount(entryQuery);

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
		return 0;
	}

	public Long findUpcomingRenewalsCount(String iqamaId) {
		Session session = null;
		try {
			session = openSession();

			int daysAfterExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysAfterExp"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, -daysAfterExp);
			Date fromdate = cal.getTime();

			int daysTillExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysTillExp"));
			Calendar cal2 = Calendar.getInstance();
			cal2.add(Calendar.DAY_OF_YEAR, +daysTillExp);
			Date todate = cal2.getTime();

			Criterion c1 = RestrictionsFactoryUtil.eq("iqamaId", iqamaId);
			Criterion c2 = RestrictionsFactoryUtil.between("expiryDate", fromdate, todate);

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(c1, c2)).setProjection(ProjectionFactoryUtil.rowCount());

			List<Object> entries = PolicyHDRLocalServiceUtil.dynamicQuery(entryQuery);

			return (Long) entries.get(0);
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

	public List<PolicyHDR> findTopPolicies(String iqamaId) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("iqamaId", iqamaId)).addOrder(OrderFactoryUtil.desc("inceptionDate"));
			entryQuery.setLimit(0, 3);

			List<PolicyHDR> entries = PolicyHDRLocalServiceUtil.dynamicQuery(entryQuery);

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

	public List<PolicyHDR> findUpcomingPolicyRenewals(String iqamaId) {
		Session session = null;
		try {
			session = openSession();

			int daysAfterExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysAfterExp"));
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, -daysAfterExp);
			Date fromdate = cal.getTime();

			int daysTillExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysTillExp"));
			Calendar cal2 = Calendar.getInstance();
			cal2.add(Calendar.DAY_OF_YEAR, +daysTillExp);
			Date todate = cal2.getTime();

			_log.info("findUpcomingPolicyRenewals...Criteria");
			_log.info("Iqama:" + iqamaId);
			_log.info("From date: " + fromdate.toString());
			_log.info("To date: " + todate.toString());

			Criterion c1 = RestrictionsFactoryUtil.eq("iqamaId", iqamaId);
			Criterion c2 = RestrictionsFactoryUtil.between("expiryDate", fromdate, todate);

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(c1, c2));

			List<PolicyHDR> entries = PolicyHDRLocalServiceUtil.dynamicQuery(entryQuery);

			_log.info("Returned upcoming renewals of count:" + entries.size());

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

	public List<PolicyHDR> findPolicyList(String iqamaId, String[] status) {
		Session session = null;
		try {
			session = openSession();

			Criterion c1 = RestrictionsFactoryUtil.eq("iqamaId", iqamaId);
			Criterion c2 = RestrictionsFactoryUtil.in("PolicyStatus", status);

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(c1, c2));

			List<PolicyHDR> entries = PolicyHDRLocalServiceUtil.dynamicQuery(entryQuery);

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

	public boolean findLoyaltyByIqamaIdVehIdExpDate(String iqamaId, String vehId, Date expiryDate) throws PortalException {

		Session session = null;
		boolean isLoyal = false;
		Calendar cal = new GregorianCalendar();
		cal.setTime(expiryDate);
		cal.add(Calendar.DAY_OF_YEAR, -30);
		Date beforeExpiryDt = cal.getTime();
		cal.add(Calendar.DAY_OF_YEAR, 60);
		Date afterExpiryDt = cal.getTime();
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM ODS_POLICY_HDR Policy , ODS_POLICY_VEH  PolicyVeh where Policy.ODS_PRODUCT in ('13101', '13102', '13103', '13104' ) AND Policy.ODS_EXPIRY_DT BETWEEN ? AND ? AND Policy.ODS_POLICY_STATUS = 'A' AND Policy.ODS_IQAMA_ID = ? AND PolicyVeh.ODS_VEHICLE_SEQ_CUSTOM = ? AND Policy.ODS_POLICY_NO = PolicyVeh.ODS_POLICY_NO");
			query.setCacheable(false);
			query.addEntity("Policy", PolicyHDRImpl.class);
//	        query.addEntity("PolicyVeh", PolicyVEHImpl.class);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(new Timestamp(beforeExpiryDt.getTime()));
			pos.add(new Timestamp(afterExpiryDt.getTime()));
			pos.add(iqamaId);
			pos.add(vehId);
			List<Object> results = query.list();
			if (results != null && results.size() > 0)
				isLoyal = true;
			return isLoyal;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(e.getMessage(), e);
			}
		} finally {
			closeSession(session);
		}
		return false;
	}

	public String findPolicyNajmStatus(String PolicyNo) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery PolicyNajmStatus = DynamicQueryFactoryUtil.forClass(PolicyHDR.class, PolicyHDRFinderImpl.class.getClassLoader());
			PolicyNajmStatus.add(RestrictionsFactoryUtil.eq("PolicyNo", PolicyNo));
			PolicyNajmStatus.setProjection(ProjectionFactoryUtil.property("najmStatus"));
			String najmStatus = String.valueOf(PolicyHDRLocalServiceUtil.dynamicQuery(PolicyNajmStatus).get(0));

			return najmStatus;

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
}
