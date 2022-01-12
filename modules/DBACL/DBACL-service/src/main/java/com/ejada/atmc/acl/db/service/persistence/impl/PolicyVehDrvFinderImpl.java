package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.service.PolicyVehDrvLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyVehDrvFinder;
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
		service = PolicyVehDrvFinder.class
)
public class PolicyVehDrvFinderImpl extends PolicyVehDrvFinderBaseImpl implements PolicyVehDrvFinder {
	private static final Log _log = LogFactoryUtil.getLog(PolicyVehDrvFinderImpl.class);

	public List<PolicyVehDrv> findByPolicyNumberVehicleId(String PolicyNo, long vehId) {
		Session session = null;
		try {
			session = openSession();
			Criterion PolicyNoCrit = RestrictionsFactoryUtil.eq("primaryKey.policyNo", PolicyNo);
			Criterion vehIdCrit = RestrictionsFactoryUtil.eq("primaryKey.vehId", new Long(vehId));

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyVehDrv.class, PolicyVehDrvFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.and(PolicyNoCrit, vehIdCrit));

			List<PolicyVehDrv> entries = PolicyVehDrvLocalServiceUtil.dynamicQuery(entryQuery);

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
