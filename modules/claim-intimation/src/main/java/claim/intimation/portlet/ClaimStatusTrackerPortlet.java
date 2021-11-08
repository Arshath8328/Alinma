package claim.intimation.portlet;

import com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

import claim.intimation.constants.ClaimIntimationPortletKeys;

@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ATMC Claim Status Tracker", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/claimStatusTracker/view.jsp",
		"javax.portlet.name=" + ClaimIntimationPortletKeys.CLAIMSTATUSTRACKER,
		"javax.portlet.init-param.add-process-action-success-action=false", 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user" 
	}, 
	service = Portlet.class
)
public class ClaimStatusTrackerPortlet extends MVCPortlet {
	static Map<Integer, String>	FIND_CLAIMS_BY_CATEGORY_LIST	= new HashMap<>();

	static {
		FIND_CLAIMS_BY_CATEGORY_LIST.put(1, "claim_no");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(2, "intimation_ref");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(3, "Mobile_No");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(4, "Driver_National_ID");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(5, "ACCIDENT_REPORT_NO");
	}

	public void checkClaimStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		String findByValue = ParamUtil.getString(actionRequest, "findByValue");
		List<ClaimIntimationMtrDTO> claimsList = ClaimIntimationMtrLocalServiceUtil.findClaimIntimationListByAllCategories(new ArrayList<String>(FIND_CLAIMS_BY_CATEGORY_LIST.values()), findByValue);

		if (claimsList != null && !claimsList.isEmpty()) {
			actionRequest.setAttribute("claimsList", claimsList);
		}
	}

}
