package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.PolicyPayment;
import com.ejada.atmc.acl.db.service.PolicyPaymentLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.PolicyPaymentFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = PolicyPaymentFinder.class
)
public class PolicyPaymentFinderImpl extends PolicyPaymentFinderBaseImpl implements PolicyPaymentFinder {
	private static final Log _log = LogFactoryUtil.getLog(PolicyPaymentFinderImpl.class);

	public List<PolicyPayment> findByPolicyNo(String PolicyNo) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(PolicyPayment.class, PolicyPaymentFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("primaryKey.policyNo", PolicyNo)).addOrder(OrderFactoryUtil.desc("docDate"));

			List<PolicyPayment> entries = PolicyPaymentLocalServiceUtil.dynamicQuery(entryQuery);

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
