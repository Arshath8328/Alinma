package settings.portlet.portlet;

import com.atmc.bsl.db.service.SettingsLocalServiceUtil;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import settings.portlet.constants.SettingsPortletKeys;

/**
 * @author vidit
 */
@Component(
		immediate = true, 
		property = { 
			"com.liferay.portlet.display-category=ATMC",
			"com.liferay.portlet.instanceable=false",
			"javax.portlet.display-name=ATMC Settings Portlet",
			"javax.portlet.init-param.template-path=/", 
			"javax.portlet.init-param.view-template=/view.jsp",
			"javax.portlet.name=" + SettingsPortletKeys.SETTINGS,
			"javax.portlet.resource-bundle=content.Language", 
			"javax.portlet.security-role-ref=power-user,user" 
		},
		service = Portlet.class
)
public class SettingsPortlet extends MVCPortlet {
	private static final Log _log = LogFactoryUtil.getLog(SettingsPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview")
				: (ParamUtil.getString(renderRequest, "myview", null) != null) ? ParamUtil.getString(renderRequest, "myview", null) : "view";
		String view = "/" + (myview == null ? "view" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(renderRequest, renderResponse);
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

	public void updateEmail(ActionRequest request, ActionResponse response) throws Exception {
		User user;
		try {
			user = PortalUtil.getUser(request);
			String userEmail = ParamUtil.getString(request, "emailInput");
			if (Pattern.matches("^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$", userEmail))
				SettingsLocalServiceUtil.updateEmail(user, userEmail);
		} catch (PortalException e) {
			if (e instanceof UserEmailAddressException || e instanceof EmailAddressException) {
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, e.getClass(), e);
				request.setAttribute("myview", "update-email");
			} else {
				throw e;
			}
		}

	}

	public void updateMobile(ActionRequest request, ActionResponse response) {
		User user;
		try {
			user = PortalUtil.getUser(request);
			String phone = ParamUtil.getString(request, "userPhone");
			Pattern pattern = Pattern.compile("^[0-9]+$");
			Matcher matcher = pattern.matcher(phone);
			if (matcher.find())
				SettingsLocalServiceUtil.updateMobile(user, phone);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void changePassword(ActionRequest request, ActionResponse response) throws Exception {
		User user;
		try {
			user = PortalUtil.getUser(request);
			String currentPassword = ParamUtil.getString(request, "currentPassword");
			String password1 = ParamUtil.getString(request, "newUserPassword");
			String password2 = ParamUtil.getString(request, "confirmUserPassword");
			SettingsLocalServiceUtil.changePassword(user, currentPassword, password1, password2);

		} catch (Exception e) {
			if (e instanceof UserPasswordException) {
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, e.getClass(), e);
				request.setAttribute("myview", "change-password");
			} else {
				throw e;
			}
		}
	}
}