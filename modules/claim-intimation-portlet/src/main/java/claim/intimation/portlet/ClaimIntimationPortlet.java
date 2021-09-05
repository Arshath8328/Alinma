package claim.intimation.portlet;

import com.atmc.bsl.db.domain.claim.ClaimIntimation;
import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.exception.NoSuchNajmCaseNoException;
import com.ejada.atmc.acl.db.exception.NoSuchNajmOtherPartyException;
import com.ejada.atmc.acl.db.exception.NoSuchNajmVehicleNoException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import claim.intimation.constants.ClaimIntimationPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ATMC Claim Intimation Portlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClaimIntimationPortletKeys.CLAIMINTIMATION,
		"javax.portlet.init-param.add-process-action-success-action=false", 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user" 
	}, 
	service = Portlet.class
)
public class ClaimIntimationPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			List<CodeMasterDetails> causeOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CODE_CAUSE_LOSS);
			List<CodeMasterDetails> natureOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CODE_NAT_OF_LOSS);
			
			renderRequest.setAttribute("causeOfLossList", causeOfLossList);
			renderRequest.setAttribute("natureOfLossList", natureOfLossList);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		super.doView(renderRequest, renderResponse);
	}

	public void intimateClaim(ActionRequest request, ActionResponse response) throws IOException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String claimType = ParamUtil.getString(request, "claimType");
		String vehicleIdentType = ParamUtil.getString(request, "vehicleIdentType");
		String reportMode = ParamUtil.getString(request, "reportMode");
		String reportNumber = ParamUtil.getString(request, "reportNumber");
		String causeOfLoss = ParamUtil.getString(request, "causeOfLoss");
		String natureOfLoss = ParamUtil.getString(request, "natureOfLoss");

		String vehicleIdentNumber = ParamUtil.getString(request, "plateNumber");
		String plateL1 = ParamUtil.getString(request, "plateL1");
		String plateL2 = ParamUtil.getString(request, "plateL2");
		String plateL3 = ParamUtil.getString(request, "plateL3");

		try {
			ClaimIntimation claimIntimation = ClaimLocalServiceUtil.intimateClaim(claimType, vehicleIdentType, vehicleIdentNumber, plateL1, plateL2, plateL3, reportMode, reportNumber, causeOfLoss,
					natureOfLoss, themeDisplay.getLocale());

			request.getPortletSession().setAttribute(ClaimIntimationPortletKeys.CLAIM_INTIMATION_OBJ, claimIntimation.getOdsClaimIntimation(), PortletSession.APPLICATION_SCOPE);

			// property claims will be handled as comprehensive muroor claims so redirect to
			// muroor portlet
			if (claimType.equals(ClaimIntimationPortletKeys.CLAIM_TYPE_PROPERTY)) {
				response.sendRedirect("/web/customer/muroor-claim");
			} else {
				if (reportMode.equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
					if (claimIntimation.getNajmClaimIntimation() != null)
						request.getPortletSession().setAttribute(ClaimIntimationPortletKeys.NAJM_CLAIM_INTIMATION_OBJ, claimIntimation.getNajmClaimIntimation(), PortletSession.APPLICATION_SCOPE);
					response.sendRedirect("/web/customer/najm_claim");
				} else
					response.sendRedirect("/web/customer/muroor-claim");
			}
		} catch (Exception e) {
			if (e instanceof NoSuchNajmCaseNoException || e instanceof NoSuchNajmVehicleNoException || e instanceof NoSuchNajmOtherPartyException || e instanceof NoSuchPolicyHDRException
					|| e instanceof NoSuchPolicyVEHException)
			{
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, e.getClass(), e);
			} else {
				_log.error(e.getMessage(), e);
				_portal.sendError(e, request, response);
			}
		}
	}

	@Reference
	private Portal				_portal;

	private static final Log	_log	= LogFactoryUtil.getLog(ClaimIntimationPortlet.class);

}