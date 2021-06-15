package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.MuroorTPUploads;
import com.ejada.atmc.acl.db.service.MuroorTPUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.MuroorTPUploadsFinder;
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
		service = MuroorTPUploadsFinder.class
)
public class MuroorTPUploadsFinderImpl extends MuroorTPUploadsFinderBaseImpl implements MuroorTPUploadsFinder {
	private static final Log _log = LogFactoryUtil.getLog(MuroorTPUploadsFinderImpl.class);

	public Object[] findFilesNames(String refNo) throws PortalException {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery query = DynamicQueryFactoryUtil.forClass(MuroorTPUploads.class, MuroorTPUploadsFinderImpl.class.getClassLoader());
			query.add(RestrictionsFactoryUtil.eq("claimIntimationNo", refNo));
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();
			projectionList.add(ProjectionFactoryUtil.property("claimIntimationNo"));
			projectionList.add(ProjectionFactoryUtil.property("driverLicenseName"));
			projectionList.add(ProjectionFactoryUtil.property("vehRegistName"));
			projectionList.add(ProjectionFactoryUtil.property("frontPhotoName"));
			projectionList.add(ProjectionFactoryUtil.property("rearPhotoName"));
			projectionList.add(ProjectionFactoryUtil.property("rightSidePhotoName"));
			projectionList.add(ProjectionFactoryUtil.property("leftSidePhotoName"));
			projectionList.add(ProjectionFactoryUtil.property("bankIbanName"));
			projectionList.add(ProjectionFactoryUtil.property("ownerIdName"));
			projectionList.add(ProjectionFactoryUtil.property("id"));
			query.setProjection(projectionList);
			List<Object> muroorTPUploadsList = MuroorTPUploadsLocalServiceUtil.dynamicQuery(query);
			if (!muroorTPUploadsList.isEmpty()) {
				Object[] uploadsData = (Object[]) muroorTPUploadsList.get(0);
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
