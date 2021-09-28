package quotations.widget.portlet.portlet;

import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.web.common.UserInfo;
import com.atmc.web.util.SessionUtil;
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

import quotations.widget.portlet.constants.QuotationsWidgetPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = {
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=QuotationsWidget Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/dashboard/quotations_widget.jsp",
		"javax.portlet.name=" + QuotationsWidgetPortletKeys.QUOTATIONSWIDGET,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class QuotationsWidgetPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(QuotationsWidgetPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		UserInfo userInfo = SessionUtil.getUserInfo(renderRequest);
		List<Quotation> quotsList = new ArrayList<>();

		if (!(userInfo.isOrgMode())) {
			String iqamaId;
			try {
				iqamaId = PortalUtil.getUser(renderRequest).getScreenName();

				quotsList = QuotationLocalServiceUtil.getPendingQuotations(Long.valueOf(iqamaId));

			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
		}
		renderRequest.setAttribute("quotsList", quotsList);
		super.doView(renderRequest, renderResponse);
	}
}