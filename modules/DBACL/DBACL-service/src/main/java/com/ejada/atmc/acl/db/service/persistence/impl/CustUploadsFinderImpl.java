package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.CustUploads;
import com.ejada.atmc.acl.db.service.CustUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.CustUploadsFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionList;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.Blob;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = CustUploadsFinder.class
)
public class CustUploadsFinderImpl extends CustUploadsFinderBaseImpl implements CustUploadsFinder {
	private static final Log _log = LogFactoryUtil.getLog(CustUploadsFinderImpl.class);

	public String findidFileNameByQuotationId(String quotationId) {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CustUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("quotId", quotationId));
			custUploadsQuery.setProjection(ProjectionFactoryUtil.property("idFileName"));
			List<String> custUpload = CustUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!custUpload.isEmpty())
				return custUpload.get(0);
			else
				return null;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return null;

	}

	public long findIdByQuotationId(String quotationId) {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CustUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("quotId", quotationId));
			custUploadsQuery.setProjection(ProjectionFactoryUtil.property("id"));
			List<Long> custUpload = CustUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!custUpload.isEmpty())
				return custUpload.get(0);
			else
				return 0;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return 0;

	}

	public String findlicenseByQuotationId(String quotationId) {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CustUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("quotId", quotationId));
			custUploadsQuery.setProjection(ProjectionFactoryUtil.property("licenseFileName"));
			List<String> custUpload = CustUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!custUpload.isEmpty())
				return custUpload.get(0);
			else
				return null;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return null;

	}

	public String findistCardByQuotationId(String quotationId) {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CustUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("quotId", quotationId));
			custUploadsQuery.setProjection(ProjectionFactoryUtil.property("istCardFileName"));
			List<String> custUpload = CustUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!custUpload.isEmpty())
				return custUpload.get(0);
			else
				return null;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return null;

	}

	public Blob findIDFileByFileId(long fileId) {

		Session session = null;
		try {
			session = openSession();
			DynamicQuery custUploadsQuery = DynamicQueryFactoryUtil.forClass(CustUploads.class, CustUploadsFinderImpl.class.getClassLoader());
			custUploadsQuery.add(RestrictionsFactoryUtil.eq("id", fileId));
			// custUploadsQuery.setProjection(PropertyFactoryUtil.forName("idFile"));
			ProjectionList projectionList = ProjectionFactoryUtil.projectionList();

			projectionList.add(ProjectionFactoryUtil.property("idFile"));
			projectionList.add(ProjectionFactoryUtil.property("idFileName"));
			custUploadsQuery.setProjection(projectionList);
			List<Blob> custUpload = CustUploadsLocalServiceUtil.dynamicQuery(custUploadsQuery);
			if (!custUpload.isEmpty())
				return custUpload.get(0);
			else
				return null;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			closeSession(session);
		}
		return null;

	}

}
