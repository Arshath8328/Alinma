package com.atmc.web.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class DriverSearchTerms extends DisplayTerms {

	private String driverId;

	public DriverSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		driverId = ParamUtil.getString(portletRequest, "driverId");
	}

	public String getDriverId() {
		return driverId;
	}

	public void setDriverId(String driverId) {
		this.driverId = driverId;
	}

}
