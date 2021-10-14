package claim.intimation.portlet;

import com.atmc.web.constants.OTPPortletKeys;
import com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactory;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.WindowStateException;

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
	private Log					_log							= LogFactoryUtil.getLog(this.getClass());
	static Map<Integer, String>	FIND_CLAIMS_BY_CATEGORY_LIST	= new HashMap<>();

	static {
		FIND_CLAIMS_BY_CATEGORY_LIST.put(2, "intimation_ref");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(3, "Mobile_No");
		FIND_CLAIMS_BY_CATEGORY_LIST.put(4, "Driver_National_ID");
	}

	public void checkClaimStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		int findByCategory = Integer.parseInt(ParamUtil.getString(actionRequest, "findByCategory"));
		String findByValue = ParamUtil.getString(actionRequest, "findByValue");
//		List<ClaimIntimationMtr> claimsList = ClaimIntimationMtrLocalServiceUtil.findClaimIntimationList(findByCategory, findByValue);
		List<ClaimIntimationMtrDTO> claimsList = ClaimIntimationMtrLocalServiceUtil.findClaimIntimationList(FIND_CLAIMS_BY_CATEGORY_LIST.get(findByCategory), findByValue);

		if (claimsList != null && !claimsList.isEmpty()) {

			actionRequest.setAttribute("claimsList", claimsList);

			// if (findByCategory == ClaimIntimationPortletKeys.CLAIM_STATUS_TRACKER_FIND_BY_CATEGORY_MOBILE_NO) {
			// PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, OTPPortletKeys.OTP, PortletRequest.ACTION_PHASE);
			//
			// try {
			// portletURL.setWindowState(LiferayWindowState.POP_UP);
			// } catch (WindowStateException e) {
			// _log.error(e.getMessage(), e);
			// }
			// portletURL.setParameter("mvcRenderCommandName", "/auth/otp");
			// portletURL.setParameter(ActionRequest.ACTION_NAME, "/auth/otp");
			// portletURL.setParameter(OTPPortletKeys.CMD, OTPPortletKeys.CMD_SEND);
			// portletURL.setParameter(OTPPortletKeys.MODE_LOGIN, "true");
			// portletURL.setParameter(OTPPortletKeys.MOBILE_NUMBER, findByValue);
			// try {
			// actionResponse.sendRedirect(portletURL.toString());
			// } catch (IOException e) {
			// _log.error(e.getMessage(), e);
			// }
			// }
		}
	}

}
