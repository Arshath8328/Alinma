package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.CLMNajmUploads;
import com.ejada.atmc.acl.db.service.CLMNajmUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.CLMNajmUploadsFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = CLMNajmUploadsFinder.class
)
public class CLMNajmUploadsFinderImpl extends CLMNajmUploadsFinderBaseImpl implements CLMNajmUploadsFinder {
	private static final Log _log = LogFactoryUtil.getLog(CLMNajmUploadsFinderImpl.class);

	public List<Object[]> findFilesNames(String refNo) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CLMNajmUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("claimRefNo", refNo));
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.property("najmSlipName"));
			projectionList.add(ProjectionFactoryUtil.property("damageEstQuotName"));
			projectionList.add(ProjectionFactoryUtil.property("bankIbanName"));
			projectionList.add(ProjectionFactoryUtil.property("ownerIdName"));
			projectionList.add(ProjectionFactoryUtil.property("id"));
			custUploadsQuery.setProjection(projectionList);
			List<Object[]> claimNajm = CLMNajmUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!claimNajm.isEmpty())
				return claimNajm;
			else
				return null;
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
