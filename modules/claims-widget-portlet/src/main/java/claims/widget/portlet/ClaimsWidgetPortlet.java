package claims.widget.portlet;

import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.claim.Claim;
import com.ejada.atmc.bsl.db.domain.claim.ClaimWorkflow;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import claims.widget.portlet.constants.ClaimsWidgetPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = {
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ClaimsWidget Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/dashboard/claim_widget.jsp", 
		"javax.portlet.name=" + ClaimsWidgetPortletKeys.CLAIMSWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	}, 
	service = Portlet.class
)
public class ClaimsWidgetPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ClaimsWidgetPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		_log.info("Inside doView of ClaimsWidgetPortlet");
		String iqamaId;
		try {
			iqamaId = PortalUtil.getUser(renderRequest).getScreenName();
			_log.info("Retrieving Claims for Iqama:" + iqamaId);
			List<Claim> claims = ClaimLocalServiceUtil.getClaimsByIqamaId(iqamaId);
			_log.info("Retrieved claims count:" + claims.size());

			renderRequest.setAttribute("claimsList", claims);
			renderRequest.setAttribute("viewableStatuses", getViewableStatuses());
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

	private List<String> getViewableStatuses() {
		List<String> viewableStatuses = new ArrayList<String>();

		List<ClaimWorkflow> customerWorkflow = ClaimLocalServiceUtil.getRoleWorkflow("Customer");

		for (ClaimWorkflow claimWorkflow : customerWorkflow) {
			viewableStatuses.add(claimWorkflow.getInitialStatus());
		}
		return viewableStatuses;
	}
}