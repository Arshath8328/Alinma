package com.ejada.atmc.web.search;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.dao.search.DisplayTerms;
import com.liferay.portal.kernel.util.ParamUtil;

public class PolicySearchTerms extends DisplayTerms {
    
    private String polNo;
    
    public PolicySearchTerms(PortletRequest portletRequest) {
	super(portletRequest);
	polNo = ParamUtil.getString(portletRequest, "policyNo");
}

    public String getPolNo() {
        return polNo;
    }

    public void setPolNo(String polNo) {
        this.polNo = polNo;
    }

}
