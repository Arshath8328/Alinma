package user.widget.portlet.portlet;

import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import user.widget.portlet.constants.UserWidgetPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=WelcomeCardWidget Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/user_widget.jsp",
		"javax.portlet.name=" + UserWidgetPortletKeys.USERWIDGET,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class UserWidgetPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(UserWidgetPortlet.class);
	
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		Long renewalCount;
		String iqamaId;
		try {
			iqamaId = PortalUtil.getUser(renderRequest).getScreenName();
			renewalCount = PolicyLocalServiceUtil.getUpcomingRenewalsCount(iqamaId);
			renderRequest.setAttribute("renewalCount", renewalCount);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);
	}
}