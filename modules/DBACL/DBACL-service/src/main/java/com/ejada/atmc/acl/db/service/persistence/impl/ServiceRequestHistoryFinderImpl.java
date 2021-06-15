package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.ServiceRequestHistory;
import com.ejada.atmc.acl.db.service.ServiceRequestHistoryLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestHistoryFinder;
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
		service = ServiceRequestHistoryFinder.class
)
public class ServiceRequestHistoryFinderImpl extends ServiceRequestHistoryFinderBaseImpl implements ServiceRequestHistoryFinder {
	private static final Log _log = LogFactoryUtil.getLog(ServiceRequestHistoryFinderImpl.class);

	public List<ServiceRequestHistory> findServiceRequestHistoryByRefNo(String refNo) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil
					.forClass(ServiceRequestHistory.class, ServiceRequestHistoryFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("REFERENCE_NO", refNo));

			List<ServiceRequestHistory> entries = ServiceRequestHistoryLocalServiceUtil.dynamicQuery(entryQuery);

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
