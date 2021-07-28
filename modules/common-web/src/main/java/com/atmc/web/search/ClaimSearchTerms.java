package com.atmc.web.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class ClaimSearchTerms extends DisplayTerms {

	private String refNo;

	public ClaimSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		refNo = ParamUtil.getString(portletRequest, "iqamaId");
	}

	public String getStatus() {
		return refNo;
	}

	public void setStatus(String status) {
		this.refNo = status;
	}

}
