package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.model.CodeMaster;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.CodeMasterFinder;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = CodeMasterFinder.class
)
public class CodeMasterFinderImpl extends CodeMasterFinderBaseImpl implements CodeMasterFinder {
	private static final Log _log = LogFactoryUtil.getLog(CodeMasterFinderImpl.class);

	public List<CodeMaster> findCodeMasterByCode(String code, String locale) throws PortalException {

		Session session = null;
		try {
			session = openSession();

			DynamicQuery entryQuery = DynamicQueryFactoryUtil.forClass(CodeMaster.class, CodeMasterFinderImpl.class.getClassLoader())
					.add(RestrictionsFactoryUtil.eq("code", code));
			if (locale.equals("en_US") || locale.equals("en"))
				entryQuery.addOrder(OrderFactoryUtil.asc("codeDesc"));
			else if (locale.equals("ar_SA") || locale.equals("ar"))
				entryQuery.addOrder(OrderFactoryUtil.asc("codeDescAr"));

			List<CodeMaster> entries = CodeMasterLocalServiceUtil.dynamicQuery(entryQuery);

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
