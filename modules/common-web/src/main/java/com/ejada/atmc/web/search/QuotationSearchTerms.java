package com.ejada.atmc.web.search;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

import javax.portlet.PortletRequest;

public class QuotationSearchTerms extends DisplayTerms {

	private Long insuredID;
	
	public QuotationSearchTerms(PortletRequest portletRequest) {
		super(portletRequest);
		insuredID = ParamUtil.getLong(portletRequest, "insuredId");
	}

	/**
	 * @return the insuredID
	 */
	public Long getInsuredID() {
		return insuredID;
	}

	/**
	 * @param insuredID the insuredID to set
	 */
	public void setInsuredID(Long insuredID) {
		this.insuredID = insuredID;
	}
}

