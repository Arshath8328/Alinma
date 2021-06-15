package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyVEHFinder;
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
		service = PolicyVEHFinder.class
)
public class PolicyVEHFinderImpl extends PolicyVEHFinderBaseImpl implements PolicyVEHFinder {
	private static final Log _log = LogFactoryUtil.getLog(PolicyVEHFinderImpl.class);

	public List<PolicyVEH> findByPolicyNumber(String PolicyNo) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyVEH.class, PolicyVEHFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("primaryKey.PolicyNo", PolicyNo));

			List<PolicyVEH> entries = PolicyVEHLocalServiceUtil.dynamicQuery(entryQuery);

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
