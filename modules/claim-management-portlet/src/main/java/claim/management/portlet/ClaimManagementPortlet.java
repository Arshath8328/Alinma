package claim.management.portlet;

import com.atmc.bsl.db.domain.claim.Claim;
import com.atmc.bsl.db.domain.claim.ClaimWorkflow;
import com.atmc.bsl.db.domain.claim.MuroorODUploads;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.web.constants.ClaimIntimationPortletKeys;
import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.atmc.bsl.db.domain.claim.MuroorTPUploads;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.springframework.util.FileCopyUtils;

import claim.management.constants.ClaimManagementPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=false", 
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=ATMC Claims Mgmt Portlet",
		"javax.portlet.init-param.template-path=/claimsmgmt/",
		"javax.portlet.init-param.view-template=/claimsmgmt/summary.jsp",
		"javax.portlet.name=" + ClaimManagementPortletKeys.CLAIMMANAGEMENT,
		"javax.portlet.init-param.add-process-action-success-action=false",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user"
	}, service = Portlet.class
)
public class ClaimManagementPortlet extends MVCPortlet {

	public static final String	MISSING_DOCS_STATUS	= "MISSINGDOCUMENTSFROMCUSTOMER";
	private static final Log	_log				= LogFactoryUtil.getLog(ClaimManagementPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			boolean isSummary = (renderRequest.getAttribute("claimDetails") == null);
			String viewName = isSummary ? "summary" : "details";
			String viewPath = "/claimsmgmt/" + viewName + ".jsp";
			// ClaimLocalServiceUtil.getClaimsSummaryFiter("SUBMITTED","13101",null,null);
			if (isSummary) {
				String iqamaId = PortalUtil.getUser(renderRequest).getScreenName();

				List<Claim> claims = ClaimLocalServiceUtil.getClaimsSummary(iqamaId);

				renderRequest.setAttribute("claimsList", claims);
				renderRequest.setAttribute("viewableStatuses", getViewableStatuses());
			}

			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(viewPath);
			dispatcher.forward(renderRequest, renderResponse);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}

	public void getClaimDetails(ActionRequest actionRequest, ActionResponse actionResponse) {
		String claimNumber = ParamUtil.getString(actionRequest, "claimNumber");
		String policyNumber = ParamUtil.getString(actionRequest, "policyNumber");
		String productDescAr = ParamUtil.getString(actionRequest, "productDescAr");
		String productDescEn = ParamUtil.getString(actionRequest, "productDescEn");
		String product = ParamUtil.getString(actionRequest, "product");
		String claimStatusKey = ParamUtil.getString(actionRequest, "claimStatusKey");
		String reportType = ParamUtil.getString(actionRequest, "reportType");

		try {
			Claim claimDetails = ClaimLocalServiceUtil.getClaimDetails(claimNumber, policyNumber);
			actionRequest.getPortletSession().setAttribute("claimDetails", claimDetails);
			actionRequest.setAttribute("claimDetails", claimDetails);
			actionRequest.setAttribute("productDescAr", productDescAr);
			actionRequest.setAttribute("productDescEn", productDescEn);
			actionRequest.setAttribute("product", product);
			actionRequest.setAttribute("claimStatusKey", claimStatusKey);
			actionRequest.setAttribute("reportType", reportType);

			actionRequest.getPortletSession().setAttribute("reportType", claimDetails.getReportType());
			actionRequest.getPortletSession().setAttribute("product", product);

			if (claimDetails.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
				List<Object[]> najmUploadsFileNames = ClaimLocalServiceUtil.getNajmUploadsFilesName(claimDetails.getClaimNo());

				actionRequest.setAttribute("najmUploadsFileNames", najmUploadsFileNames);
				actionRequest.getPortletSession().setAttribute("Najm_Uploads_Names", najmUploadsFileNames);
			} else if (claimDetails.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
				if (product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					MuroorODUploads odMuroorUploads = ClaimLocalServiceUtil.getMuroorODUploadsData(claimDetails.getClaimNo());
					actionRequest.setAttribute("OD_Muroor_Uploads", odMuroorUploads);
					actionRequest.getPortletSession().setAttribute("Muroor_OD_Uploads", odMuroorUploads);
				} else if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
					MuroorTPUploads tpMuroorUploads = ClaimLocalServiceUtil.getMuroorTPUploadsData(claimDetails.getClaimNo());
					actionRequest.setAttribute("TP_Muroor_Uploads", tpMuroorUploads);
					actionRequest.getPortletSession().setAttribute("Muroor_TP_Uploads", tpMuroorUploads);
				}
			}
		} catch (PortalException e) {
			// Auto-generated catch block
			_log.error(e.getMessage(), e);
		}

	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {

		try {
			String type = resourceRequest.getParameter("fileType");
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String lang = themeDisplay.getLocale().toString();
			String download = resourceRequest.getParameter("download");

			String reportType = (String) resourceRequest.getPortletSession().getAttribute("reportType");
			String product = (String) resourceRequest.getPortletSession().getAttribute("product");

			_log.info("reportType:" + reportType + "...product:" + product);

			if (type.equals("mainReport")) {
				_log.info("Main Report");
				Claim claimDetails = (Claim) resourceRequest.getPortletSession().getAttribute("claimDetails");
				_log.info("Claim Details dump");
				_log.info(claimDetails.toString());
				ODSClaimIntimation claimIntm = new ODSClaimIntimation();
				claimIntm.setAmount(Double.valueOf(claimDetails.getClaimAmount()));
				claimIntm.setPolicyno(claimDetails.getPolicyNo());
				claimIntm.setTransaction(claimDetails.getTypeOfClaim());
				claimIntm.setReportmode(claimDetails.getReportType());
				claimIntm.setReportno(claimDetails.getReportNo());
				claimIntm.setTpnationality(claimDetails.getTpNationality());
				claimIntm.setTpdob(claimDetails.getTpAge());
				claimIntm.setTpdrivername(claimDetails.getTpDriverName());
				claimIntm.setTpid(claimDetails.getTpID());
				claimIntm.setTpiban(claimDetails.getTpIban());
				claimIntm.setTpinsco(claimDetails.getTpInsuranceCo());
				claimIntm.setTpmobile(claimDetails.getTpMobileNo());
				claimIntm.setFaultpercent(Integer.valueOf(claimDetails.getFaultPercent()));
				_log.info("Preparing loss date. ClaimLossDate :" + claimDetails.getClaimLossDate());
				if (reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM) && product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy hhmm");
					String lossdate = sdf.format(claimDetails.getClaimLossDate());
					claimIntm.setLossdate(lossdate);
				} else
					claimIntm.setLossdate(claimDetails.getClaimLossDate().toString());

				claimIntm.setLosscause(claimDetails.getCauseCode());
				claimIntm.setLossremarks(claimDetails.getLossRemarks());

				_log.info("Preparing loss locations:" + claimDetails.getLossLocation());
				if (lang.equals("en_US")) {
					claimIntm.setVehidentivalue(claimDetails.getEnPlateL1() + "-" + claimDetails.getEnPlateL2() + "-" + claimDetails.getEnPlateL3() + "-" + claimDetails.getEnPlateNo());
					claimIntm.setLosslocation(claimDetails.getLossLocation());
					claimIntm.setAccidentLocation(claimDetails.getLossLocation());
				} else {
					claimIntm.setVehidentivalue(claimDetails.getArPlateL1() + "-" + claimDetails.getArPlateL2() + "-" + claimDetails.getArPlateL3() + "-" + claimDetails.getArPlateNo());
					claimIntm.setLosslocation(claimDetails.getLossLocationAr());
					claimIntm.setAccidentLocation(claimDetails.getLossLocationAr());
				}

				claimIntm.setTpvehidentivalue(claimDetails.getTpPlateL1() + "-" + claimDetails.getTpPlateL2() + "-" + claimDetails.getTpPlateL3() + "-" + claimDetails.getTpPlateNo());
				claimIntm.setTpplateno(claimDetails.getTpPlateL1() + "-" + claimDetails.getTpPlateL2() + "-" + claimDetails.getTpPlateL3() + "-" + claimDetails.getTpPlateNo());
				claimIntm.setReferenceno(claimDetails.getClaimNo());
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm a");
				claimIntm.setAccidentDate(dateFormatter.format(claimDetails.getClaimLossDate()));
				claimIntm.setAccidentTime(timeFormatter.format(claimDetails.getClaimLossDate()));

				User currentUser;
				String claimantEmail;
				try {
					currentUser = PortalUtil.getUser(resourceRequest);
					claimantEmail = currentUser.getEmailAddress();

					_log.info("Downloading Claim Report");
					File file = ClaimLocalServiceUtil.downloadClaimReport(claimIntm, claimDetails.getClaimAntName(), claimDetails.getClaimAntPhone(), claimantEmail, claimDetails.getIqamaId(), lang);
					_log.info("Downloading Claim Report complete");

					byte[] fileBytes = FileCopyUtils.copyToByteArray(file);

					if (download != null && download.equals("false"))
						resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + file.getName() + "\"");
					else
						resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"");
					resourceResponse.setContentType("application/pdf");

					resourceResponse.setContentLength(fileBytes.length);
					OutputStream out = resourceResponse.getPortletOutputStream();
					out.write(fileBytes);
					out.close();

				} catch (PortalException e) {
					// Auto-generated catch block
					_log.error(e.getMessage(), e);
				}

			} else {
				_log.info("Not main report");

				String fileType = "";
				byte[] pdf = null;

				try {
					if (reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
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

								fileType = tpMuroorUploads.getRightSidePhotoName().substring(tpMuroorUploads.getRightSidePhotoName().indexOf(".") + 1,
										tpMuroorUploads.getRightSidePhotoName().length());
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

					else if (reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
						List<Object[]> najmUploadsFileNames = (List<Object[]>) resourceRequest.getPortletSession().getAttribute("Najm_Uploads_Names");
						if (type.equals("najmSlip")) {
							String fileName = (String) najmUploadsFileNames.get(0)[0];
							fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
							pdf = ClaimLocalServiceUtil.findNajmSlipFile((int) najmUploadsFileNames.get(0)[4]);
							resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

						}
						if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
							if (type.equals("damageEst")) {

								String fileName = (String) najmUploadsFileNames.get(0)[1];
								fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
								pdf = ClaimLocalServiceUtil.findDamageEstQuotFile((int) najmUploadsFileNames.get(0)[4]);
								resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

							} else if (type.equals("bankIban")) {

								String fileName = (String) najmUploadsFileNames.get(0)[2];
								fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
								pdf = ClaimLocalServiceUtil.findBankIbanFile((int) najmUploadsFileNames.get(0)[4]);
								resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

							} else if (type.equals("ownerId")) {
								String fileName = (String) najmUploadsFileNames.get(0)[3];
								fileType = fileName.substring(fileName.indexOf(".") + 1, fileName.length());
								pdf = ClaimLocalServiceUtil.findOwnerIdFile((int) najmUploadsFileNames.get(0)[4]);
								resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + fileName + "\"");

							}
						}
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
		} catch (Exception e) {
			_log.info("ClaimsMgmtPortlet - exception in serveResource");
			_log.error(e.getMessage(), e);
		}

		_log.info("Claims Mgmt Portlet-start");

	}

	private List<String> getViewableStatuses() {
		List<String> viewableStatuses = new ArrayList<>();

		List<ClaimWorkflow> customerWorkflow = ClaimLocalServiceUtil.getRoleWorkflow("Customer");

		for (ClaimWorkflow claimWorkflow : customerWorkflow) {
			viewableStatuses.add(claimWorkflow.getInitialStatus());
		}
		return viewableStatuses;
	}

	public void submitExtraNajmFile(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		String claimNumber = ParamUtil.getString(actionRequest, "claimNumber");
		String policyNumber = ParamUtil.getString(actionRequest, "policyNumber");
		String productDescAr = ParamUtil.getString(actionRequest, "productDescAr");
		String productDescEn = ParamUtil.getString(actionRequest, "productDescEn");
		String product = ParamUtil.getString(actionRequest, "product");
		String reportType = ParamUtil.getString(actionRequest, "reportType");
		Claim claimDetails;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);

		try {

			claimDetails = ClaimLocalServiceUtil.getClaimDetails(claimNumber, policyNumber);

			User user = PortalUtil.getUser(actionRequest);

			if (reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {

				File najmSlipFile = uploadPortletRequest.getFile("najmSlipFile");
				String najmSlipFileName = uploadPortletRequest.getFileName("najmSlipFile");
				File damageEstQuotFile = uploadPortletRequest.getFile("damageEstQuotFile");
				String damageEstQuotFileName = uploadPortletRequest.getFileName("damageEstQuotFile");
				File bankIbanFile = uploadPortletRequest.getFile("bankIbanFile");
				String bankIbanFileName = uploadPortletRequest.getFileName("bankIbanFile");
				File ownerIdFile = uploadPortletRequest.getFile("ownerIdFile");
				String ownerIdFileName = uploadPortletRequest.getFileName("ownerIdFile");

				if (najmSlipFile == null || !najmSlipFile.exists()) {
					najmSlipFile = null;
				}
				if (damageEstQuotFile == null || !damageEstQuotFile.exists()) {
					damageEstQuotFile = null;
				}
				if (bankIbanFile == null || !bankIbanFile.exists()) {
					bankIbanFile = null;
				}
				if (ownerIdFile == null || !ownerIdFile.exists()) {
					ownerIdFile = null;
				}
				// if (najmSlipFile != null && najmSlipFile.exists() && damageEstQuotFile !=
				// null && damageEstQuotFile.exists() && bankIbanFile != null &&
				// bankIbanFile.exists() && ownerIdFile != null && ownerIdFile.exists() ) {

				ClaimLocalServiceUtil.updateNajmSubmitedFiles(claimNumber, user.getFullName(), " update", najmSlipFile, najmSlipFileName, damageEstQuotFile, damageEstQuotFileName, bankIbanFile,
						bankIbanFileName, ownerIdFile, ownerIdFileName);

				if (claimDetails.getReportType().equals(ClaimIntimationPortletKeys.REPORT_MODE_NAJM)) {
					List<Object[]> najmUploadsFileNames = ClaimLocalServiceUtil.getNajmUploadsFilesName(claimDetails.getClaimNo());

					actionRequest.setAttribute("najmUploadsFileNames", najmUploadsFileNames);
					actionRequest.getPortletSession().setAttribute("Najm_Uploads_Names", najmUploadsFileNames);
				}
			} else if (reportType.equals(ClaimIntimationPortletKeys.REPORT_MODE_MUROOR)) {
				if (product.equals(ClaimIntimationPortletKeys.PRODUCT_COMPREHENSIVE)) {
					// flag to check if file is executable file and file type is one of executable
					// files
					boolean driverLicenseAcceptableType = false;
					boolean driverLicenseExecutable = false;
					boolean vehRegAcceptableType = false;
					boolean vehRegExecutable = false;
					boolean policyAcceptableType = false;
					boolean policyExecutable = false;

					File driverLicenseFile = uploadPortletRequest.getFile("driverLicenseFile");
					String driverLicenseFileName = uploadPortletRequest.getFileName("driverLicenseFile");
					File vehRegFile = uploadPortletRequest.getFile("vehRegFile");
					String vehRegFileName = uploadPortletRequest.getFileName("vehRegFile");
					File policyFile = uploadPortletRequest.getFile("policyFile");
					String policyFileName = uploadPortletRequest.getFileName("policyFile");

					if (driverLicenseFile == null || !driverLicenseFile.exists()) {
						driverLicenseFile = null;
						driverLicenseFileName = "";
					} else {
//						driverLicenseAcceptableType = FileUtil.isAcceptedFileType(driverLicenseFile, acceptedTypes);
						driverLicenseAcceptableType = FileUtil.validateFile(driverLicenseFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!driverLicenseAcceptableType) {
							driverLicenseFile = null;
							driverLicenseFileName = "";
						}
						driverLicenseExecutable = FileUtil.isExecutable(driverLicenseFile);
						if (driverLicenseExecutable) {
							driverLicenseFile = null;
							driverLicenseFileName = "";
						}
					}

					if (vehRegFile == null || !vehRegFile.exists()) {
						vehRegFile = null;
						vehRegFileName = "";
					} else {
//						vehRegAcceptableType = FileUtil.isAcceptedFileType(vehRegFile, acceptedTypes);
						vehRegAcceptableType = FileUtil.validateFile(vehRegFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!vehRegAcceptableType) {
							vehRegFile = null;
							vehRegFileName = "";
						}
						vehRegExecutable = FileUtil.isExecutable(vehRegFile);
						if (vehRegExecutable) {
							vehRegFile = null;
							vehRegFileName = "";
						}
					}

					if (policyFile == null || !policyFile.exists()) {
						policyFile = null;
						policyFileName = "";
					} else {
//						policyAcceptableType = FileUtil.isAcceptedFileType(policyFile, acceptedTypes);
						policyAcceptableType = FileUtil.validateFile(policyFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!policyAcceptableType) {
							policyFile = null;
							policyFileName = "";
						}
						policyExecutable = FileUtil.isExecutable(policyFile);
						if (policyExecutable) {
							policyFile = null;
							policyFileName = "";
						}
					}

					ClaimLocalServiceUtil.updateMuroorODSubmitedFiles(claimNumber, user.getFullName(), "update", driverLicenseFile, driverLicenseFileName, vehRegFile, vehRegFileName, policyFile,
							policyFileName);

					MuroorODUploads odMuroorUploads = ClaimLocalServiceUtil.getMuroorODUploadsData(claimNumber);
					actionRequest.setAttribute("OD_Muroor_Uploads", odMuroorUploads);
					actionRequest.getPortletSession().setAttribute("Muroor_OD_Uploads", odMuroorUploads);
				} else if (product.equals(ClaimIntimationPortletKeys.PRODUCT_TPL)) {
					File driverLicFile = uploadPortletRequest.getFile("driverLicFile");
					String driverLicFileName = uploadPortletRequest.getFileName("driverLicFile");
					File vehRegstFile = uploadPortletRequest.getFile("vehRegstFile");
					String vehRegstFileName = uploadPortletRequest.getFileName("vehRegstFile");
					File frontPhotoFile = uploadPortletRequest.getFile("frontPhotoFile");
					String frontPhotoFileName = uploadPortletRequest.getFileName("frontPhotoFile");
					File rearPhotoFile = uploadPortletRequest.getFile("rearPhotoFile");
					String rearPhotoFileName = uploadPortletRequest.getFileName("rearPhotoFile");
					File rightSidePhotoFile = uploadPortletRequest.getFile("rightSidePhotoFile");
					String rightSidePhotoFileName = uploadPortletRequest.getFileName("rightSidePhotoFile");
					File leftSidePhotoFile = uploadPortletRequest.getFile("leftSidePhotoFile");
					String leftSidePhotoFileName = uploadPortletRequest.getFileName("leftSidePhotoFile");
					File ibanFile = uploadPortletRequest.getFile("ibanFile");
					String ibanFileName = uploadPortletRequest.getFileName("ibanFile");
					File ownerIdTPFile = uploadPortletRequest.getFile("ownerIdTPFile");
					String ownerIdTPFileName = uploadPortletRequest.getFileName("ownerIdTPFile");

					// flag to check if file is executable file and file type is one of executable
					// files
					boolean driverLicAcceptableType = false;
					boolean driverLicExecutable = false;
					boolean vehRegstAcceptableType = false;
					boolean vehRegstExecutable = false;
					boolean frontPhotoAcceptableType = false;
					boolean frontPhotoExecutable = false;
					boolean rearPhotoAcceptableType = false;
					boolean rearPhotoExecutable = false;
					boolean rightSidePhotoAcceptableType = false;
					boolean rightSidePhotoExecutable = false;
					boolean leftSidePhotoAcceptableType = false;
					boolean leftSidePhotoExecutable = false;
					boolean bankIbanAcceptableType = false;
					boolean bankIbanExecutable = false;
					boolean ownerIdAcceptableType = false;
					boolean ownerIdExecutable = false;

					if (driverLicFile == null || !driverLicFile.exists()) {
						driverLicFile = null;
						driverLicFileName = "";
					} else {
//						driverLicAcceptableType = FileUtil.isAcceptedFileType(driverLicFile, acceptedTypes);
						driverLicAcceptableType = FileUtil.validateFile(driverLicFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!driverLicAcceptableType) {
							driverLicFile = null;
							driverLicFileName = "";
						}
						driverLicExecutable = FileUtil.isExecutable(driverLicFile);
						if (driverLicExecutable) {
							driverLicFile = null;
							driverLicFileName = "";
						}
					}

					if (vehRegstFile == null || !vehRegstFile.exists()) {
						vehRegstFile = null;
						vehRegstFileName = "";
					} else {
//						vehRegstAcceptableType = FileUtil.isAcceptedFileType(vehRegstFile, acceptedTypes);
						vehRegstAcceptableType = FileUtil.validateFile(vehRegstFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!vehRegstAcceptableType) {
							vehRegstFile = null;
							vehRegstFileName = "";
						}
						vehRegstExecutable = FileUtil.isExecutable(vehRegstFile);
						if (vehRegstExecutable) {
							vehRegstFile = null;
							vehRegstFileName = "";
						}
					}

					if (frontPhotoFile == null || !frontPhotoFile.exists()) {
						frontPhotoFile = null;
						frontPhotoFileName = "";
					} else {
//						frontPhotoAcceptableType = FileUtil.isAcceptedFileType(frontPhotoFile, acceptedTypes);
						frontPhotoAcceptableType = FileUtil.validateFile(frontPhotoFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!frontPhotoAcceptableType) {
							frontPhotoFile = null;
							frontPhotoFileName = "";
						}
						frontPhotoExecutable = FileUtil.isExecutable(frontPhotoFile);
						if (frontPhotoExecutable) {
							frontPhotoFile = null;
							frontPhotoFileName = "";
						}
					}

					if (rearPhotoFile == null || !rearPhotoFile.exists()) {
						rearPhotoFile = null;
						rearPhotoFileName = "";
					} else {
//						rearPhotoAcceptableType = FileUtil.isAcceptedFileType(rearPhotoFile, acceptedTypes);
						rearPhotoAcceptableType = FileUtil.validateFile(rearPhotoFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!rearPhotoAcceptableType) {
							rearPhotoFile = null;
							rearPhotoFileName = "";
						}
						rearPhotoExecutable = FileUtil.isExecutable(rearPhotoFile);
						if (rearPhotoExecutable) {
							rearPhotoFile = null;
							rearPhotoFileName = "";
						}
					}

					if (rightSidePhotoFile == null || !rightSidePhotoFile.exists()) {
						rightSidePhotoFile = null;
						rightSidePhotoFileName = "";
					} else {
//						rightSidePhotoAcceptableType = FileUtil.isAcceptedFileType(rightSidePhotoFile, acceptedTypes);
						rightSidePhotoAcceptableType = FileUtil.validateFile(rightSidePhotoFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!rightSidePhotoAcceptableType) {
							rightSidePhotoFile = null;
							rightSidePhotoFileName = "";
						}
						rightSidePhotoExecutable = FileUtil.isExecutable(rightSidePhotoFile);
						if (rightSidePhotoExecutable) {
							rightSidePhotoFile = null;
							rightSidePhotoFileName = "";
						}
					}

					if (leftSidePhotoFile == null || !leftSidePhotoFile.exists()) {
						leftSidePhotoFile = null;
						leftSidePhotoFileName = "";
					} else {
//						leftSidePhotoAcceptableType = FileUtil.isAcceptedFileType(leftSidePhotoFile, acceptedTypes);
						leftSidePhotoAcceptableType = FileUtil.validateFile(leftSidePhotoFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!leftSidePhotoAcceptableType) {
							leftSidePhotoFile = null;
							leftSidePhotoFileName = "";
						}
						leftSidePhotoExecutable = FileUtil.isExecutable(leftSidePhotoFile);
						if (leftSidePhotoExecutable) {
							leftSidePhotoFile = null;
							leftSidePhotoFileName = "";
						}
					}

					if (ibanFile == null || !ibanFile.exists()) {
						ibanFile = null;
						ibanFileName = "";
					} else {
//						bankIbanAcceptableType = FileUtil.isAcceptedFileType(ibanFile, acceptedTypes);
						bankIbanAcceptableType = FileUtil.validateFile(ibanFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!bankIbanAcceptableType) {
							ibanFile = null;
							ibanFileName = "";
						}
						bankIbanExecutable = FileUtil.isExecutable(ibanFile);
						if (bankIbanExecutable) {
							ibanFile = null;
							ibanFileName = "";
						}
					}

					if (ownerIdTPFile == null || !ownerIdTPFile.exists()) {
						ownerIdTPFile = null;
						ownerIdTPFileName = "";
					} else {
//						ownerIdAcceptableType = FileUtil.isAcceptedFileType(ownerIdTPFile, acceptedTypes);
						ownerIdAcceptableType = FileUtil.validateFile(ownerIdTPFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
						if (!ownerIdAcceptableType) {
							ownerIdTPFile = null;
							ownerIdTPFileName = "";
						}
						ownerIdExecutable = FileUtil.isExecutable(ownerIdTPFile);
						if (ownerIdExecutable) {
							ownerIdTPFile = null;
							ownerIdTPFileName = "";
						}
					}

					ClaimLocalServiceUtil.updateMuroorTPSubmitedFiles(claimNumber, user.getFullName(), "update", driverLicFile, driverLicFileName, vehRegstFile, vehRegstFileName, frontPhotoFile,
							frontPhotoFileName, rearPhotoFile, rearPhotoFileName, rightSidePhotoFile, rightSidePhotoFileName, leftSidePhotoFile, leftSidePhotoFileName, ibanFile, ibanFileName,
							ownerIdTPFile, ownerIdTPFileName);

					MuroorTPUploads tpMuroorUploads = ClaimLocalServiceUtil.getMuroorTPUploadsData(claimDetails.getClaimNo());
					actionRequest.setAttribute("TP_Muroor_Uploads", tpMuroorUploads);
					actionRequest.getPortletSession().setAttribute("Muroor_TP_Uploads", tpMuroorUploads);
				}
			}

			actionRequest.setAttribute("claimDetails", claimDetails);
			actionRequest.setAttribute("productDescAr", productDescAr);
			actionRequest.setAttribute("productDescEn", productDescEn);
			actionRequest.setAttribute("product", product);
			actionRequest.setAttribute("reportType", reportType);
			actionRequest.setAttribute("claimStatusKey", claimDetails.getWorkflowStatus());

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

	}
}