package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.ClaimHDR;
import com.ejada.atmc.acl.db.model.impl.CLMSTATUSImpl;
import com.ejada.atmc.acl.db.model.impl.ClaimHDRImpl;
import com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl;
import com.ejada.atmc.acl.db.service.ClaimHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRFinder;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = ClaimHDRFinder.class
)
public class ClaimHDRFinderImpl extends ClaimHDRFinderBaseImpl implements ClaimHDRFinder {

	private static final Log _log = LogFactoryUtil.getLog(ClaimHDRFinderImpl.class);

	public List<ClaimHDR> findClaimsByIqamaId(String iqamaId) throws PortalException {
		_log.info("findClaimsByIqamaId for:" + iqamaId);
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(ClaimHDR.class, ClaimHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("iqamaId", iqamaId)).addOrder(OrderFactoryUtil.desc("ClaimIntmDate"));
			entryQuery.setLimit(0, 3);

			List<ClaimHDR> entries = ClaimHDRLocalServiceUtil.dynamicQuery(entryQuery);
			_log.info("Retrieved entries count:" + entries.size());

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

	public List<Object[]> findClaimsPolicyByIqamaId(String iqamaId) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(
					"SELECT * FROM ODS_CLAIM_HDR Claim , ODS_POLICY_HDR  policy where Claim.ODS_POLICY_NO = policy.ODS_POLICY_NO AND Claim.ODS_IQAMA_ID = ?");
			query.setCacheable(false);
			query.addEntity("Claim", ClaimHDRImpl.class);
			query.addEntity("policy", PolicyHDRImpl.class);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(iqamaId);

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

	public List<Object[]> findClaimsPolicyBy() throws PortalException {

		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session
					.createSQLQuery("SELECT * FROM ODS_CLAIM_HDR Claim , ODS_POLICY_HDR  policy where Claim.ODS_POLICY_NO = policy.ODS_POLICY_NO");
			query.setCacheable(false);
			query.addEntity("Claim", ClaimHDRImpl.class);
			query.addEntity("policy", PolicyHDRImpl.class);

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

	public List<ClaimHDR> findClaimsByExcludeStatus(String iqamaId, String status) throws PortalException {
		_log.info("findClaimsByExcludeStatus for iqama:" + iqamaId + " and status:" + status);

		Session session = null;
		try {
			session = openSession();

			Criterion c1 = RestrictionsFactoryUtil.eq("iqamaId", iqamaId);
			Criterion c2 = RestrictionsFactoryUtil.ne("ClaimStatus", status);

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(ClaimHDR.class, ClaimHDRFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(c1, c2)).addOrder(OrderFactoryUtil.desc("ClaimIntmDate"));

			List<ClaimHDR> entries = ClaimHDRLocalServiceUtil.dynamicQuery(entryQuery);
			_log.info("Retrieved entries count:" + entries.size());

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

	public List<Object[]> findClaimsPolicyStatus(String iqamaId, String status, String policyType, Date fromDate, Date toDate)
			throws PortalException {

		Session session = null;
		try {
			session = openSession();
			String queryS = "SELECT * FROM ODS_CLAIM_HDR Claim , EJD_CLAIMS_STATUS CLMSTATUS where Claim.ODS_CLAIM_NO = CLMSTATUS.REFERENCE_NO AND Claim.ODS_IQAMA_ID = ? ";
			SQLQuery query = null;
			if (status != null && !status.equals("")) {
				queryS = queryS + "AND CLMSTATUS.STATUS = ? ";

			}
			if (fromDate != null && !fromDate.equals("") && toDate != null && !toDate.equals("")) {
				queryS = queryS + "AND Claim.ODS_CLAIM_LOSS_DT  BETWEEN ? AND ? ";

			}
			if (policyType != null && !policyType.equals("")) {
				queryS = queryS + "AND Claim.ODS_PROD_CODE = ? ";

			}
			query = session.createSQLQuery(queryS);
			query.setCacheable(false);
			query.addEntity("Claim", ClaimHDRImpl.class);
			query.addEntity("CLMSTATUS", CLMSTATUSImpl.class);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(iqamaId);
			if (status != null && !status.equals("")) {
				pos.add(status);

			}
			if (fromDate != null && !fromDate.equals("") && toDate != null && !toDate.equals("")) {
				pos.add(fromDate);
				pos.add(toDate);

			}
			if (policyType != null && !policyType.equals("")) {
				pos.add(policyType);
			}

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

	public List<Object[]> findClaimsPolicyStatusAdmin(String status, String Surveyor, String iqamaId, int from, int to) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			String queryS = "SELECT  * FROM ( SELECT  q.*, rownum rn FROM ( SELECT  * FROM ODS_CLAIM_HDR LEFT JOIN  EJD_CLAIMS_STATUS ON ODS_CLAIM_HDR.ODS_CLAIM_NO = EJD_CLAIMS_STATUS.REFERENCE_NO";
			SQLQuery query = null;
			int first = 1;
			if (status != null && !status.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE EJD_CLAIMS_STATUS.STATUS = ?";
					first++;
				} else {
					queryS = queryS + " AND EJD_CLAIMS_STATUS.STATUS = ?";
				}

			}
			if (Surveyor != null && !Surveyor.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE ODS_CLAIM_HDR.ODS_REPORT_TYPE = ?";
					first++;
				} else {
					queryS = queryS + " AND ODS_CLAIM_HDR.ODS_REPORT_TYPE = ?";
				}

			}
			if (iqamaId != null && !iqamaId.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE ODS_CLAIM_HDR.ODS_IQAMA_ID = ?";
					first++;
				} else {
					queryS = queryS + " AND ODS_CLAIM_HDR.ODS_IQAMA_ID = ?";
				}

			}
			queryS = queryS + " ) q) WHERE   rn BETWEEN ? AND ?";
			query = session.createSQLQuery(queryS);
			query.setCacheable(false);
			query.addEntity("Claim", ClaimHDRImpl.class);
			query.addEntity("CLMSTATUS", CLMSTATUSImpl.class);
			QueryPos pos = QueryPos.getInstance(query);

			if (status != null && !status.equals("")) {
				pos.add(status);

			}
			if (Surveyor != null && !Surveyor.equals("")) {
				pos.add(Surveyor);

			}
			if (iqamaId != null && !iqamaId.equals("")) {
				pos.add(iqamaId);
			}

			pos.add(from);
			pos.add(to);

			_log.info("Claims SQL Query : " + queryS);

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

	public int findClaimsCountsPolicyStatusAdmin(String status, String Surveyor, String iqamaId) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			String queryS = "SELECT COUNT(*) AS recordsTotalCount FROM ODS_CLAIM_HDR LEFT JOIN EJD_CLAIMS_STATUS ON ODS_CLAIM_HDR.ODS_CLAIM_NO = EJD_CLAIMS_STATUS.REFERENCE_NO";
			SQLQuery query = null;
			int first = 1;
			if (status != null && !status.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE EJD_CLAIMS_STATUS.STATUS = ?";
					first++;
				} else {
					queryS = queryS + " AND EJD_CLAIMS_STATUS.STATUS = ?";
				}

			}
			if (Surveyor != null && !Surveyor.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE ODS_CLAIM_HDR.ODS_REPORT_TYPE = ?";
					first++;
				} else {
					queryS = queryS + " AND ODS_CLAIM_HDR.ODS_REPORT_TYPE = ?";
				}

			}
			if (iqamaId != null && !iqamaId.equals("")) {
				if (first == 1) {
					queryS = queryS + " WHERE ODS_CLAIM_HDR.ODS_IQAMA_ID = ?";
					first++;
				} else {
					queryS = queryS + " AND ODS_CLAIM_HDR.ODS_IQAMA_ID = ?";
				}

			}
			query = session.createSQLQuery(queryS);
			query.setCacheable(false);
			// query.addEntity("Claim", ClaimHDRImpl.class);
			// query.addEntity("CLMSTATUS", CLMSTATUSImpl.class);
			query.addScalar("recordsTotalCount", Type.INTEGER);
			QueryPos pos = QueryPos.getInstance(query);

			if (status != null && !status.equals("")) {
				pos.add(status);

			}
			if (Surveyor != null && !Surveyor.equals("")) {
				pos.add(Surveyor);

			}
			if (iqamaId != null && !iqamaId.equals("")) {
				pos.add(iqamaId);
			}
			_log.info("Claims SQL Query - Count : " + queryS);
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
