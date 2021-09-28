package notifications.portlet;

import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import notifications.portlet.constants.NotificationsPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false", 
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ATMC Notifications Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user"
	},
	service = Portlet.class
)
public class NotificationsPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(NotificationsPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {

			long userId = PortalUtil.getUserId(renderRequest);
			List<UserNotificationEvent> notifications = NotificationsLocalServiceUtil.getAllNotifications(userId, false);
			List<Long> unreadNotificationsIds = new ArrayList<>();
			for (UserNotificationEvent userNotificationEvent : notifications) {
				if (!userNotificationEvent.isArchived())
					unreadNotificationsIds.add(userNotificationEvent.getUserNotificationEventId());
			}

			NotificationsLocalServiceUtil.markAllNotificationsAsRead(userId);
			renderRequest.setAttribute("notifications", notifications);
			renderRequest.setAttribute("unreadNotificationsIds", unreadNotificationsIds);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		super.doView(renderRequest, renderResponse);

	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

}