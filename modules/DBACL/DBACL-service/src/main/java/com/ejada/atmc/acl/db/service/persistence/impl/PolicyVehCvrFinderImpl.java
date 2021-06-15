package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.service.PolicyVehCvrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehCvrFinder;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = PolicyVehCvrFinder.class
)
public class PolicyVehCvrFinderImpl extends PolicyVehCvrFinderBaseImpl implements PolicyVehCvrFinder {
	private static final Log _log = LogFactoryUtil.getLog(PolicyVehCvrFinderImpl.class);

	public List<PolicyVehCvr> findByPolicyNumberVehicleId(String PolicyNo, long vehId) {
		Session session = null;
		try {
			session = openSession();
			Criterion PolicyNoCrit = RestrictionsFactoryUtil.eq("primaryKey.PolicyNo", PolicyNo);
			Criterion vehIdCrit = RestrictionsFactoryUtil.eq("primaryKey.vehId", "" + vehId);

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyVehCvr.class, PolicyVehCvrFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(PolicyNoCrit, vehIdCrit));

			List<PolicyVehCvr> entries = PolicyVehCvrLocalServiceUtil.dynamicQuery(entryQuery);

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

}
