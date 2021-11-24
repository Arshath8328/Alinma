package policies.widget.portlet;

import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import policies.widget.portlet.constants.PoliciesWidgetPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=PoliciesWidget Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/policies_widget.jsp",
		"javax.portlet.name=" + PoliciesWidgetPortletKeys.POLICIESWIDGET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class PoliciesWidgetPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(PoliciesWidgetPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Policy> policyList;
		String iqamaId;
		try {
			iqamaId = PortalUtil.getUser(renderRequest).getScreenName();

			policyList = PolicyLocalServiceUtil.getTopPolicies(iqamaId);

			renderRequest.setAttribute("policyList", policyList);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}

}