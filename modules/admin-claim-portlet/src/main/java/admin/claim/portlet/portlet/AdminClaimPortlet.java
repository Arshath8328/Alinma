package admin.claim.portlet.portlet;

import com.atmc.bsl.db.domain.claim.Claim;
import com.atmc.bsl.db.domain.claim.MuroorODUploads;
import com.atmc.bsl.db.domain.claim.MuroorTPUploads;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.ejada.atmc.acl.db.model.CLMNajmUploads;
import com.ejada.atmc.web.constants.ClaimIntimationPortletKeys;
import com.ejada.atmc.web.util.FileUtil;
import com.liferay.captcha.util.CaptchaUtil;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.captcha.CaptchaException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.PortalUtil;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import admin.claim.portlet.constants.AdminClaimPortletKeys;

/**
 * @author bhavik
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=AdminClaim",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + AdminClaimPortletKeys.ADMINCLAIMLISTPORTLET,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class AdminClaimPortlet extends MVCPortlet {


	private static final Log _log = LogFactoryUtil.getLog(AdminClaimPortlet.class);

	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		List<Claim> claims = null;

		String myview = renderRequest.getParameter("myview");
		String view = "/" + (myview == null ? "view" : myview) + ".jsp";
		_log.info(view);
		if (view.equals("/view.jsp")) {
//				claims =// ClaimLocalServiceUtil.getAllClaims();
//				//_log.info("claims list"+claims);
			renderRequest.setAttribute("claimsList", claims);
		} else if (view.equals("/details.jsp")) {
			claimDetails(renderRequest, renderResponse);
		}
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(renderRequest, renderResponse);
	}

	public void claimDetails(RenderRequest request, RenderResponse response) {

		String claimRefNo = String.valueOf(request.getParameter("claimRefNo"));
		String policyNo = String.valueOf(request.getParameter("policyNo"));
		String policyProduct = String.valueOf(request.getParameter("policyProduct"));
		PortletSession pSession = request.getPortletSession();

		try {
			Claim claim = ClaimLocalServiceUtil.getClaimDetails(claimRefNo, policyNo);
			_log.info("claim details" + claim);
			request.setAttribute("claim", claim);
			request.setAttribute("policyProduct", policyProduct);
			pSession.setAttribute("reportType", claim.getReportType());
			pSession.setAttribute("product", policyProduct);
			if (claim.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
				CLMNajmUploads najmUploads = ClaimLocalServiceUtil.getNajmFileUploads(claim.getClaimNo());
				_log.info("najm uploads" + najmUploads);
				request.setAttribute("najmUploads", najmUploads);
				pSession.setAttribute("Najm_Uploads", najmUploads);
			} else if (claim.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
				if (policyProduct.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					MuroorODUploads odMuroorUploads = ClaimLocalServiceUtil.getMuroorODUploadsData(claim.getClaimNo());
					request.setAttribute("OD_Muroor_Uploads", odMuroorUploads);
					request.getPortletSession().setAttribute("Muroor_OD_Uploads", odMuroorUploads);
				} else if (policyProduct.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
					MuroorTPUploads tpMuroorUploads = ClaimLocalServiceUtil.getMuroorTPUploadsData(claim.getClaimNo());
					request.setAttribute("TP_Muroor_Uploads", tpMuroorUploads);
					request.getPortletSession().setAttribute("Muroor_TP_Uploads", tpMuroorUploads);
				}
			}
		} catch (PortalException e) {
			_log.error(e);
		}

	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		String type = resourceRequest.getParameter("fileType");
		PortletSession pSession = resourceRequest.getPortletSession();

		String fileType = "";
		byte[] pdf = null;

		String reportType = (String) pSession.getAttribute("reportType");
		String product = (String) pSession.getAttribute("product");
		try {
			if (reportType != null && reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
				if (product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					MuroorODUploads odMuroorUploads = (MuroorODUploads) resourceRequest.getPortletSession().getAttribute("Muroor_OD_Uploads");
					if (type.equals("driverLicense")) {
						fileType = odMuroorUploads.getDriverLicenseName().substring(odMuroorUploads.getDriverLicenseName().indexOf(".") + 1, odMuroorUploads.getDriverLicenseName().length());
						pdf = ClaimLocalServiceUtil.findODDriverLicenseFile(odMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + odMuroorUploads.getDriverLicenseName() + "\"");
					} else if (type.equals("vehRegist")) {
						fileType = odMuroorUploads.getVehRegistName().substring(odMuroorUploads.getVehRegistName().indexOf(".") + 1, odMuroorUploads.getVehRegistName().length());
						pdf = ClaimLocalServiceUtil.findODVehRegistFile(odMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + odMuroorUploads.getVehRegistName() + "\"");
					} else if (type.equals("policyCopy")) {
						fileType = odMuroorUploads.getPolicyCopyName().substring(odMuroorUploads.getPolicyCopyName().indexOf(".") + 1, odMuroorUploads.getPolicyCopyName().length());
						pdf = ClaimLocalServiceUtil.findODPolicyCopyFile(odMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + odMuroorUploads.getPolicyCopyName() + "\"");
					}
				} else if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
					MuroorTPUploads tpMuroorUploads = (MuroorTPUploads) resourceRequest.getPortletSession().getAttribute("Muroor_TP_Uploads");
					if (type.equals("driverLic")) {
						fileType = tpMuroorUploads.getDriverLicenseName().substring(tpMuroorUploads.getDriverLicenseName().indexOf(".") + 1, tpMuroorUploads.getDriverLicenseName().length());
						pdf = ClaimLocalServiceUtil.findTPDriverLicenseFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getDriverLicenseName() + "\"");

					} else if (type.equals("vehRegst")) {
						fileType = tpMuroorUploads.getVehRegistName().substring(tpMuroorUploads.getVehRegistName().indexOf(".") + 1, tpMuroorUploads.getVehRegistName().length());
						pdf = ClaimLocalServiceUtil.findTPVehRegistFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getVehRegistName() + "\"");
					}
					if (type.equals("frontPhoto")) {

						fileType = tpMuroorUploads.getFrontPhotoName().substring(tpMuroorUploads.getFrontPhotoName().indexOf(".") + 1, tpMuroorUploads.getFrontPhotoName().length());
						pdf = ClaimLocalServiceUtil.findTPFrontPhotoFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getFrontPhotoName() + "\"");

					} else if (type.equals("rearPhoto")) {
						fileType = tpMuroorUploads.getRearPhotoName().substring(tpMuroorUploads.getRearPhotoName().indexOf(".") + 1, tpMuroorUploads.getRearPhotoName().length());
						pdf = ClaimLocalServiceUtil.findTPRearPhotoFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getRearPhotoName() + "\"");
					}
					if (type.equals("rightSidePhoto")) {

						fileType = tpMuroorUploads.getRightSidePhotoName().substring(tpMuroorUploads.getRightSidePhotoName().indexOf(".") + 1, tpMuroorUploads.getRightSidePhotoName().length());
						pdf = ClaimLocalServiceUtil.findTPRightSidePhotoFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getRightSidePhotoName() + "\"");

					} else if (type.equals("leftSidePhoto")) {
						fileType = tpMuroorUploads.getLeftSidePhotoName().substring(tpMuroorUploads.getLeftSidePhotoName().indexOf(".") + 1, tpMuroorUploads.getLeftSidePhotoName().length());
						pdf = ClaimLocalServiceUtil.findTPLeftSidePhotoFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getLeftSidePhotoName() + "\"");
					}
					if (type.equals("bankIban")) {

						fileType = tpMuroorUploads.getBankIbanName().substring(tpMuroorUploads.getBankIbanName().indexOf(".") + 1, tpMuroorUploads.getBankIbanName().length());
						pdf = ClaimLocalServiceUtil.findTPBankIbanFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getBankIbanName() + "\"");

					} else if (type.equals("ownerId")) {
						fileType = tpMuroorUploads.getOwnerIdName().substring(tpMuroorUploads.getOwnerIdName().indexOf(".") + 1, tpMuroorUploads.getOwnerIdName().length());
						pdf = ClaimLocalServiceUtil.findTPOwnerIdFile(tpMuroorUploads.getFileId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + tpMuroorUploads.getOwnerIdName() + "\"");
					}
				}
			}

			else if (reportType != null && reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
				CLMNajmUploads najmUploads = (CLMNajmUploads) pSession.getAttribute("Najm_Uploads");
				if (type.equals("najmSlip")) {
					String fileName = najmUploads.getNajmSlipName();
					fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
					pdf = ClaimLocalServiceUtil.findNajmSlipFile((int) najmUploads.getId());
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

				}
				if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
					if (type.equals("damageEst")) {

						String fileName = najmUploads.getDamageEstQuotName();
						fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
						pdf = ClaimLocalServiceUtil.findDamageEstQuotFile((int) najmUploads.getId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

					} else if (type.equals("bankIban")) {

						String fileName = najmUploads.getBankIbanName();
						fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
						pdf = ClaimLocalServiceUtil.findBankIbanFile((int) najmUploads.getId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

					} else if (type.equals("ownerId")) {
						String fileName = najmUploads.getOwnerIdName();
						fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
						pdf = ClaimLocalServiceUtil.findOwnerIdFile((int) najmUploads.getId());
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

					}
				}
			} else if (type.equals("admin")) {
				int fileId = Integer.parseInt(resourceRequest.getParameter("fileId"));
				String fileName = resourceRequest.getParameter("fileName");
				fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
				pdf = ClaimLocalServiceUtil.adminUploadFile(fileId);
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");
			}

			if (fileType.trim().equalsIgnoreCase("txt")) {
				resourceResponse.setContentType("text/plain");
			} else if (fileType.trim().equalsIgnoreCase("doc")) {
				resourceResponse.setContentType("application/msword");
			} else if (fileType.trim().equalsIgnoreCase("xls")) {
				resourceResponse.setContentType("application/vnd.ms-excel");
			} else if (fileType.trim().equalsIgnoreCase("pdf")) {
				resourceResponse.setContentType("application/pdf");
			} else if (fileType.trim().equalsIgnoreCase("ppt")) {
				resourceResponse.setContentType("application/ppt");
			} else {
				resourceResponse.setContentType("application/octet-stream");
			}

			resourceResponse.setContentLength(pdf.length);
			OutputStream out = resourceResponse.getPortletOutputStream();
			out.write(pdf);
			out.close();

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void submitFile(ActionRequest request, ActionResponse response) throws IOException {
		String claimRefNo = String.valueOf(request.getParameter("claimRefNo"));
		String policyNo = String.valueOf(request.getParameter("policyNo"));
		String policyProductDescAr = String.valueOf(request.getParameter("policyProductDescAr"));
		String policyProductDescEN = String.valueOf(request.getParameter("policyProductDescEN"));
		String policyProduct = String.valueOf(request.getParameter("policyProduct"));

		try {
			CaptchaUtil.check(request);
			_log.info("CAPTCHA validated successfully");
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE);
			SessionErrors.add(request, "successMessage");
		} catch (CaptchaException e) {
			SessionMessages.add(request, PortalUtil.getPortletId(request) + SessionMessages.KEY_SUFFIX_HIDE_DEFAULT_ERROR_MESSAGE);
			SessionErrors.add(request, "errorMessage");
			_log.info("CAPTCHA not validated");
			request.setAttribute("errorCaptcha", true);
			_log.error(e.getMessage(), e);
			return;
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		ByteArrayFileInputStream inputStream = null;
		try {

			// Policy policy
			// =PolicyLocalServiceUtil.findPolicyByPolicyNo(claim.getPolicyNo());
			// Verify all uploaded files are of accepted types

			File adminFile = uploadPortletRequest.getFile("adminFile");
			String fileName = uploadPortletRequest.getFileName("adminFile");
			if (!adminFile.exists()) {
				_log.info("ID is Empty File");
			}
			if ((adminFile != null) && adminFile.exists()) {
				if (FileUtil.validateFile(adminFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE))
					ClaimLocalServiceUtil.saveAdminFiles(claimRefNo, adminFile, fileName);
				else
					SessionErrors.add(request, "file.failed");

			}
			Claim claim = ClaimLocalServiceUtil.getClaimDetails(claimRefNo, policyNo);
			request.setAttribute("claim", claim);

//			if(pattern.matcher(policyProductDescAr).find())
			request.setAttribute("policyProductDescAr", policyProductDescAr);

//			if(pattern.matcher(policyProductDescEN).find())
			request.setAttribute("policyProductDescEN", policyProductDescEN);

//			if(pattern.matcher(policyProduct).find())
			request.setAttribute("policyProduct", policyProduct);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			StreamUtil.cleanUp(inputStream);
		}

	}

	public void updateStatus(ActionRequest request, ActionResponse response) {
		User user;
		try {
			Pattern pattern = Pattern.compile("^['a-zA-Z_\\u0600-\\u06FF\\s]+$");
			user = PortalUtil.getUser(request);
			String claimRefNo = String.valueOf(request.getParameter("claimRefNo"));
			String status = String.valueOf(request.getParameter("newStatus"));
			String reason = String.valueOf(request.getParameter("reason"));
			reason = Encode.forHtmlContent(reason);
			if (pattern.matcher(status).find())
				ClaimLocalServiceUtil.updateWorkflowStatus(claimRefNo, user.getEmailAddress(), status, reason);
			else
				_log.error("invalid Status or reason");
			// String myView=String.valueOf(request.getParameter("myview"));
//			if(myView.equals("details")){
//				String policyNo=String.valueOf(request.getParameter("claimPolicyNo"));
//				request.setAttribute("claimRefNo", claimRefNo);
//				request.setAttribute("policyNo", policyNo);
//				String policyProduct=String.valueOf(request.getParameter("policyProduct"));
//				request.setAttribute("policyProduct", policyProduct);
//				
//			}
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void deleteFile(ActionRequest request, ActionResponse response) {

		int fileId = Integer.parseInt(request.getParameter("fileId"));
		String claimRefNo = String.valueOf(request.getParameter("claimRefNo"));
		String policyNo = String.valueOf(request.getParameter("policyNo"));
		String policyProductDescAr = String.valueOf(request.getParameter("policyProductDescAr"));
		String policyProductDescEN = String.valueOf(request.getParameter("policyProductDescEN"));
		String policyProduct = String.valueOf(request.getParameter("policyProduct"));

		ClaimLocalServiceUtil.removeAdminFiles(fileId);
		try {
			Claim claim = ClaimLocalServiceUtil.getClaimDetails(claimRefNo, policyNo);
			request.setAttribute("claim", claim);
			request.setAttribute("policyProductDescAr", policyProductDescAr);
			request.setAttribute("policyProductDescEN", policyProductDescEN);
			request.setAttribute("policyProduct", policyProduct);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
	}

}