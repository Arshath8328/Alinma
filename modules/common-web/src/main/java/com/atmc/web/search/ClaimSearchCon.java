package com.atmc.web.search;

import com.atmc.bsl.db.domain.claim.Claim;
//import com.atmc.bsl.db.domain.claim.Claim;
import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class ClaimSearchCon extends SearchContainer<Claim> {
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int		DEFAULT_DELTA			= 10;
	static List<String>			headerNames				= new ArrayList<String>();
	static {
		headerNames.add("claimNo");
	}

	public ClaimSearchCon(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new ClaimSearchTerms(portletRequest), new ClaimSearchTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		ClaimSearchTerms displayTerms = (ClaimSearchTerms) getDisplayTerms();
		iteratorURL.setParameter("iqamaId", displayTerms.getStatus());
	}

}
