package com.ejada.atmc.web.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class ServiceRequestSearchTerms extends DisplayTerms{

	private String iqamaId;
	
	public ServiceRequestSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		iqamaId = ParamUtil.getString(portletRequest, "From");
	}

	public String getIqamaId() {
		return iqamaId;
	}

	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
	}
	

}
