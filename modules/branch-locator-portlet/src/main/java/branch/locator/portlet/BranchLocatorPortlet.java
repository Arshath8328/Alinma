package branch.locator.portlet;

import branch.locator.constants.BranchLocatorPortletKeys;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false", 
		"javax.portlet.display-name=ATMC Branch Locator",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + BranchLocatorPortletKeys.BRANCHLOCATOR,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user" 
	},
	service = Portlet.class
)
public class BranchLocatorPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}
}
