package com.atmc.web.notifications;

import com.atmc.web.constants.NotificationsPortletKeys;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

import org.osgi.service.component.annotations.Component;

@Component(
		immediate = true,
		property =
		{ "javax.portlet.name=" + NotificationsPortletKeys.NOTIFICATIONS },
		service = UserNotificationHandler.class
)
public class QuotationExpiredUserNotificationHandler extends BaseUserNotificationHandler {

	/**
	 * AdminLoginUserNotificationHandler: Constructor class.
	 */
	public QuotationExpiredUserNotificationHandler() {
		setPortletId(NotificationsPortletKeys.NOTIFICATIONS);
	}

	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext) throws Exception {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());

		String additionalData = jsonObject.getString("additionalData");

		// fetch our strings via the language bundle.
		String title = "Quotation Expired";
		String body = "Your Quotation has expired " + additionalData;
		// build the html using our template.
		return StringUtil.replace(BODY_TEMPLATE, BODY_REPLACEMENTS, new String[] { title, body });
	}

	private static final String		BODY_TEMPLATE		= "<div class=\"title\">[$TITLE$]</div><div class=\"body\">[$BODY$]</div>";
	private static final String[]	BODY_REPLACEMENTS	= new String[] { "[$TITLE$]", "[$BODY$]" };

}
