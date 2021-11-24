package admin.customer.service.actions;

import com.atmc.bsl.db.service.SrvReqActionLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqAttachmentLocalServiceUtil;
import com.atmc.bsl.db.service.SrvReqLocalServiceUtil;
import com.atmc.web.constants.AdminCustomerServiceListPortletKeys;
import com.atmc.web.constants.CustomerServiceRequestListPortletKeys;
import com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.portlet.LiferayWindowState;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

@Component(
		property =
		{ "javax.portlet.name=" + AdminCustomerServiceListPortletKeys.ASSIGN,
				"mvc.command.name=/adminCustomerServiceList/assign_to" },
		service = MVCActionCommand.class
)
public class AdminAssignRequestActionCmd extends BaseMVCActionCommand {

	@Override
	protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		try {

			String cmd = ParamUtil.getString(actionRequest, AdminCustomerServiceListPortletKeys.CMD);
			if (cmd.equals(AdminCustomerServiceListPortletKeys.CMD_ASSIGN))
				assignServiceRequest(actionRequest, actionResponse);

		} catch (Exception e) {

		}
	}

	protected void assignServiceRequest(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		String refNo = actionRequest.getParameter("refNo");
		Pattern pattern = Pattern.compile("^['a-zA-Z\\u0600-\\u06FF\\s]+$");
		Matcher matcher = pattern.matcher(refNo);
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		ByteArrayFileInputStream inputStream = null;
		try {
			_log.debug(refNo);
			File[] uploadedFiles = uploadPortletRequest.getFiles("uploadFile");
			String[] names = uploadPortletRequest.getFileNames("uploadFile");

			/************************* Add new Action record in Service Request History ****************************/
			ServiceRequestAction action = new ServiceRequestAction();
			action.setActionDate(new Date());

			String details = AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue() + " " + LanguageUtil.get(uploadPortletRequest, "assigned") + " " + refNo + " "
					+ LanguageUtil.get(uploadPortletRequest, "to") + " " + actionRequest.getParameter("roleDD");
			action.setActionDetails(details);
			action.setActionRemarks(actionRequest.getParameter("addNote"));
			action.setActionType(String.valueOf(AdminCustomerServiceListPortletKeys.ACTION_TYPES.ASSIGNED_TO.getValue()));
			action.setReferenceNo(refNo);
			String actionID = SrvReqActionLocalServiceUtil.addNewServiceRequestAction(action);

			/********************** Save Uploaded Attachments in Service Request Attachments ************************/
			for (int i = 0; i < uploadedFiles.length; i++) {
				File file = uploadedFiles[i];
				if (file != null) {
					String fileName = names[i];
					SrvReqAttachmentLocalServiceUtil.saveServiceRequestFiles(refNo, file, fileName, actionID);
				}
			}

			SrvReqLocalServiceUtil.updateServiceRequestAssignedRole(refNo, actionRequest.getParameter("roleDD"), CustomerServiceRequestListPortletKeys.REQUEST_STATUS_ASSIGNED);

			SessionMessages.add(actionRequest, "close_success");
			actionRequest.setAttribute("result", true);

			_log.debug(actionRequest.getParameter("portletInstanceID"));

			Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);
			PortletURL portletURL = PortletURLFactoryUtil.create(actionRequest, AdminCustomerServiceListPortletKeys.AdminListPortlet + actionRequest.getParameter("portletInstanceID"), layout,
					PortletRequest.RENDER_PHASE);

			portletURL.setWindowState(LiferayWindowState.NORMAL);
			portletURL.setParameter("result", "true");
			actionRequest.setAttribute("resultURL", portletURL.toString());

		} catch (Exception e) {
			e.printStackTrace();
			SessionMessages.add(actionRequest, "close_error");
			actionRequest.setAttribute("result", false);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}
	}

	private static final Log	_log	= LogFactoryUtil.getLog(AdminAssignRequestActionCmd.class);

	@Reference
	private Portal				portal;
}
