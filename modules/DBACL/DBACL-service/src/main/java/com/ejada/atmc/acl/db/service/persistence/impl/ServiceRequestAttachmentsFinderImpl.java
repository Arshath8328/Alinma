package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.ServiceRequestAttachments;
import com.ejada.atmc.acl.db.service.ServiceRequestAttachmentsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ServiceRequestAttachmentsFinder;
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
		service = ServiceRequestAttachmentsFinder.class
)
public class ServiceRequestAttachmentsFinderImpl extends ServiceRequestAttachmentsFinderBaseImpl implements ServiceRequestAttachmentsFinder {
	private static final Log _log = LogFactoryUtil.getLog(ServiceRequestAttachmentsFinderImpl.class);

	public List<ServiceRequestAttachments> findServiceRequestAttachmentByActionId(String actionId) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil
					.forClass(ServiceRequestAttachments.class, ServiceRequestAttachmentsFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("ACTION_ID", actionId));

			List<ServiceRequestAttachments> entries = ServiceRequestAttachmentsLocalServiceUtil.dynamicQuery(entryQuery);

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

	public List<ServiceRequestAttachments> findServiceRequestAttachmentByRefNo(String refNo) {
		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil
					.forClass(ServiceRequestAttachments.class, ServiceRequestAttachmentsFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("REFERENCE_NO", refNo));

			List<ServiceRequestAttachments> entries = ServiceRequestAttachmentsLocalServiceUtil.dynamicQuery(entryQuery);

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
