//package com.ejada.atmc.web.search;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.portlet.PortletRequest;
//import javax.portlet.PortletURL;
//
//import com.ejada.atmc.acl.db.model.PolicyCancelation;
//import com.ejada.atmc.bsl.db.domain.claim.Claim;
//import com.liferay.portal.kernel.dao.search.SearchContainer;
//
//public class Policysearch extends SearchContainer<PolicyCancelation> {
//    public static final String	EMPTY_RESULTS_MESSAGE	= "No Record Found";
//    public static final int DEFAULT_DELTA = 10;
//    static List<String>	headerNames	= new ArrayList<String>();
//    static {
//	headerNames.add("policyNo");
//    }
//	public Policysearch(PortletRequest portletRequest, PortletURL iteratorURL) {
//		super(portletRequest, new PolicySearchTerms(portletRequest), new PolicySearchTerms(portletRequest), DEFAULT_CUR_PARAM, DEFAULT_DELTA, iteratorURL,
//				headerNames, EMPTY_RESULTS_MESSAGE);
//		PolicySearchTerms displayTerms = (PolicySearchTerms) getDisplayTerms();
//		iteratorURL.setParameter("policyNo", displayTerms.getPolNo().toString());
//	}
//    }
