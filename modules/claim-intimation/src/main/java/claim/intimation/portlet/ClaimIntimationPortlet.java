package claim.intimation.portlet;

import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
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
	private static final String	CODE_FREEZ_YN	= "N";
	private static final String	BODY_CODE		= "MOT_BODY_TYP";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview")
					: (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "view2";
			List<CodeMasterDetails> codeMaterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
			_log.info("codeMaterList  >>>>>>>" + codeMaterList.size());
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String currLocale = themeDisplay.getLocale().toString();
			Map<String, String> manufactMap = new HashMap<>();
			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				if (currLocale.equals("en_US")) {
					codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
					codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
					manufactMap.put(codeMasterDtls.getCodeDesc(), codeMasterDtls.getCodeSub());
				} else {
					codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
					codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
					manufactMap.put(codeMasterDtls.getCodeDescAr(), codeMasterDtls.getCodeSub());
				}

			}
			renderRequest.setAttribute("manufactMap", manufactMap);
			List<CodeMasterDetails> natureOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CODE_NAT_OF_LOSS);
			List<CodeMasterDetails> cityList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CITY);
			renderRequest.setAttribute("cityList", cityList);
			renderRequest.setAttribute("natureOfLossList", natureOfLossList);

			ClaimIntimationMtr claimIntimationMtr = (ClaimIntimationMtr) renderRequest.getPortletSession().getAttribute("intimateClaimInitiated");
			if (Validator.isNotNull(claimIntimationMtr)) {
				myview = (String) renderRequest.getPortletSession().getAttribute("redirectToIntimationSuccessScreen");
				renderRequest.setAttribute("claimIntimationMtr", claimIntimationMtr);
				renderRequest.getPortletSession().removeAttribute("redirectToIntimationSuccessScreen");
				renderRequest.getPortletSession().removeAttribute("intimateClaimInitiated");
			}

			String view = "/" + myview + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

			dispatcher.forward(renderRequest, renderResponse);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void intimateClaim(ActionRequest request, ActionResponse response) throws IOException {
		String claimantType = ParamUtil.getString(request, "claimantType");
		String policyNumber = ParamUtil.getString(request, "policyNumber");
		String vehicleIdentNumber = ParamUtil.getString(request, "plateNumber");
		String plateL1 = ParamUtil.getString(request, "plateL1");
		String plateL2 = ParamUtil.getString(request, "plateL2");
		String plateL3 = ParamUtil.getString(request, "plateL3");
//		String vehicleIdentType = ParamUtil.getString(request, "vehicleIdentType");
		long sequenceNumber = Long.parseLong(ParamUtil.getString(request, "sequenceNumber"));
		String chassisNumber = ParamUtil.getString(request, "chassisNumber");
		String mobileNumber = ParamUtil.getString(request, "mobileNumber");
		String causeOfLoss = ParamUtil.getString(request, "causeOfLoss");
		Date dateOfLossOrAccident = ParamUtil.getDate(request, "dateOfLossOrAccident", new SimpleDateFormat("yyyy-mm-dd"));
		String accidentCity = ParamUtil.getString(request, "accidentCity");
		String accidentDescription = ParamUtil.getString(request, "accidentDescription");
		String sourceOfAccidentReport = ParamUtil.getString(request, "sourceOfAccidentReport");
		String accidentReportNumber = ParamUtil.getString(request, "accidentReportNumber");
		String vehicleMake = ParamUtil.getString(request, "vehicleMake");
		String vehicleModel = ParamUtil.getString(request, "vehicleModel");
		String driverName = ParamUtil.getString(request, "driverName");
		String driverNationality = ParamUtil.getString(request, "driverNationality");
		long driverNationalId = Long.parseLong(ParamUtil.getString(request, "driverNationalId"));
		Date driverDateOfBirthG = ParamUtil.getDate(request, "dateOfBirthG", new SimpleDateFormat("yyyy-mm-dd"));
		String driverGender = ParamUtil.getString(request, "driverGender");

//		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
//		File[] claimIntimationAttachments = uploadPortletRequest.getFiles("claimIntimationAttachments");

		ClaimIntimationMtr claimIntimationMtr = ClaimIntimationMtrLocalServiceUtil.intimateClaim(claimantType, policyNumber, vehicleIdentNumber, plateL1, plateL2, plateL3, sequenceNumber,
				chassisNumber, mobileNumber, causeOfLoss, dateOfLossOrAccident, accidentCity, accidentDescription, sourceOfAccidentReport, accidentReportNumber, vehicleMake, vehicleModel, driverName,
				driverNationality, driverNationalId, driverDateOfBirthG, driverGender);
		if (Validator.isNotNull(claimIntimationMtr)) {
			_log.info("claimIntimationMtr object created successfully : " + claimIntimationMtr.getIntimationReferenceNo());
			List<User> users = new ArrayList<>();
			try {
				users = UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.loadGetRole(20116, "Customer Service").getRoleId());
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
			if (Boolean.parseBoolean(PropsUtil.get("production.env")) && !users.isEmpty()) {
//				for(User user : users) {
				for (int j = 0; j < 1; j++) {
//					String mailTo = user.getEmailAddress();
					long userId;
					User currentUser = (User) request.getAttribute(WebKeys.USER);
					userId = currentUser == null ? Long.parseLong(PropsUtil.get("admin.user.id")) : currentUser.getUserId();
					UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(request);

					ServiceContext serviceContext = null;
					try {
						serviceContext = ServiceContextFactory.getInstance(this.getClass().getName(), uploadRequest);
					} catch (PortalException e) {
						e.printStackTrace();
					}
					long uploadedFolderId = 0L;
					try {
						uploadedFolderId = this.uploadFileEntity(serviceContext, uploadRequest, userId, claimIntimationMtr.getIntimationReferenceNo());
					} catch (SystemException | PortalException e) {
						e.printStackTrace();
					}

					long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

					List<File> emailAttachments = new ArrayList<>();
					List<String> emailAttachmentNames = new ArrayList<>();

					String liferayUploadPath = System.getProperty("catalina.base").split("tomcat")[0] + "data\\document_library\\ClaimsIntimation\\";
					_log.info("Local Storage path : " + liferayUploadPath);
					try {
						List<FileEntry> uploadedFileEntries = _dlAppService.getFileEntries(repositoryId, uploadedFolderId);
						for (FileEntry fileEntry : uploadedFileEntries) {
							InputStream initialStream = DLFileEntryLocalServiceUtil.getFileAsStream(fileEntry.getFileEntryId(), fileEntry.getVersion());
							byte[] buffer = new byte[initialStream.available()];
							initialStream.read(buffer);

							File targetFile = new File(liferayUploadPath + claimIntimationMtr.getIntimationReferenceNo() + fileEntry.getFileName());
							OutputStream outStream = new FileOutputStream(targetFile);
							outStream.write(buffer);
							outStream.close();
							emailAttachments.add(targetFile);
						}
					} catch (PortalException e) {
						e.printStackTrace();
					}
					_log.info("EmailAttachments size : " + emailAttachments.size());
					String mailSubject = "Claim Intimation Successful!";
					String mailMessage = "You have successfully intimated a claim. Please find your claim by intimation number " + claimIntimationMtr.getIntimationReferenceNo();
					mailMessage += "Here is the details you filled while intimating your claim: \n";
					mailMessage += "claimantType : " + claimantType + "\nsequenceNumber : " + sequenceNumber + "\npolicyNumber : " + policyNumber;
//					SMSLocalServiceUtil.sendSms(mailMessage, mobile);

					SendEmailServiceUtil.sendEmail("vidit@aimdek.in", mailSubject, mailMessage, emailAttachmentNames, emailAttachments);
				}
			}
			request.getPortletSession().setAttribute("intimateClaimInitiated", claimIntimationMtr);
			request.getPortletSession().setAttribute("redirectToIntimationSuccessScreen", "claim_intimated");
		}
	}

	private long uploadFileEntity(ServiceContext serviceContext, UploadPortletRequest request, long userId, String claimIntimationReferenceNo) throws PortalException, SystemException {
		String filename = "";
		String description = "Claim Intimation Files for " + claimIntimationReferenceNo;

		try {
			// serviceContext.scopeGroupId is the groupId of a site
			long repositoryId = DLFolderConstants.getDataRepositoryId(serviceContext.getScopeGroupId(), DLFolderConstants.DEFAULT_PARENT_FOLDER_ID);

			Folder claimsIntimationFolder = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "Claims Intimation");
			Folder f = DLAppLocalServiceUtil.addFolder(userId, repositoryId, claimsIntimationFolder.getFolderId(), claimIntimationReferenceNo, description, serviceContext);
			long folderId = f.getFolderId();
			_log.info("Folder Created In the Portal : " + claimIntimationReferenceNo);
			File[] claimIntimationAttachments = request.getFiles("claimIntimationAttachments");

			for (File file : claimIntimationAttachments) {
				filename = file.getName();
				String mimeType = MimeTypesUtil.getContentType(file);

				FileEntry entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId, folderId, filename, mimeType, filename, description, "", file, serviceContext);
				_log.info("File " + entry.getFileName() + " uploaded to " + f.getName());
			}
			return folderId;
		} catch (PortalException e) {
			_log.error("An exception occured uploading file: " + e.getMessage());
			throw e;
		} catch (SystemException e) {
			_log.error("An exception occured uploading file: " + e.getMessage());
			throw e;
		}
	}

	@Reference
	private DLAppService		_dlAppService;

	@Reference
	private Portal				_portal;

	private static final Log	_log	= LogFactoryUtil.getLog(ClaimIntimationPortlet.class);

}