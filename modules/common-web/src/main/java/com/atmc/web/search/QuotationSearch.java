package com.atmc.web.search;

import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.liferay.portal.kernel.dao.search.SearchContainer;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

public class QuotationSearch extends SearchContainer<Quotation> {
	public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
	public static final int		DEFAULT_DELTA			= 10;
	static List<String>			headerNames				= new ArrayList<>();
	static {
		headerNames.add("insuredId");
	}

	public QuotationSearch(PortletRequest portletRequest, PortletURL iteratorURL) {
		super(portletRequest, new QuotationSearchTerms(portletRequest), new QuotationSearchTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL, headerNames, EMPTY_RESULTS_MESSAGE);
		QuotationSearchTerms displayTerms = (QuotationSearchTerms) getDisplayTerms();
		iteratorURL.setParameter("insuredId", displayTerms.getInsuredID().toString());
	}
}