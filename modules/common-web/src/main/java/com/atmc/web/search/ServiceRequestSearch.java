package com.atmc.web.search;

import com.atmc.bsl.db.domain.serviceRequest.ServiceRequest;
import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class ServiceRequestSearch extends SearchContainer<ServiceRequest> {
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int		DEFAULT_DELTA			= 10;
	static List<String>			headerNames				= new ArrayList<String>();
	static {
		headerNames.add("From");
	}

	public ServiceRequestSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new ServiceRequestSearchTerms(portletRequest), new ServiceRequestSearchTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames,
				EMPTY_RESULTS_MESSAGE);
		ServiceRequestSearchTerms displayTerms = (ServiceRequestSearchTerms) getDisplayTerms();
		iteratorURL.setParameter("From", displayTerms.getIqamaId());
	}

}
