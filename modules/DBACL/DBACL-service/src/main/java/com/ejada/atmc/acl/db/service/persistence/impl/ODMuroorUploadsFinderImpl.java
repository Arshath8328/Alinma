package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.ODMuroorUploads;
import com.ejada.atmc.acl.db.service.ODMuroorUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.ODMuroorUploadsFinder;
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
		service = ODMuroorUploadsFinder.class
)
public class ODMuroorUploadsFinderImpl extends ODMuroorUploadsFinderBaseImpl implements ODMuroorUploadsFinder {
	private static final Log _log = LogFactoryUtil.getLog(ODMuroorUploadsFinderImpl.class);

	public Object[] findFilesNames(String refNo) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(ODMuroorUploads.class, ODMuroorUploadsFinderImpl.class.getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("claimIntimationNo", refNo));
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.property("claimIntimationNo"));
			projectionList.add(ProjectionFactoryUtil.property("driverLicenseName"));
			projectionList.add(ProjectionFactoryUtil.property("vehRegistName"));
			projectionList.add(ProjectionFactoryUtil.property("policyCopyName"));
			projectionList.add(ProjectionFactoryUtil.property("id"));
			query.setProjection(projectionList);
			List<Object[]> muroorODUploadsList = ODMuroorUploadsLocalServiceUtil.dynamicQuery(query);
			if (!muroorODUploadsList.isEmpty()) {
				Object[] uploadsData = (Object[]) muroorODUploadsList.get(0);
				return uploadsData;
			} else
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
