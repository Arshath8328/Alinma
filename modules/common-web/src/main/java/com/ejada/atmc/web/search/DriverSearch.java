package com.ejada.atmc.web.search;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;
import com.liferay.portal.kernel.dao.search.SearchContainer;

public class DriverSearch extends SearchContainer<QuotationDriverseEndors> {
    public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
    public static final int DEFAULT_DELTA = 10;
    static List<String>	headerNames	= new ArrayList<String>();
    static {
	headerNames.add("driverId");
    }
	public DriverSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new DriverSearchTerms(portletRequest), new DriverSearchTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
				headerNames, EMPTY_RESULTS_MESSAGE);
		DriverSearchTerms displayTerms = (DriverSearchTerms) getDisplayTerms();
		iteratorURL.setParameter("", displayTerms.getDriverId() .toString());
	}

}
