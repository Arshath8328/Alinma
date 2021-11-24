package claim.muroor.portlet;

import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.web.constants.ClaimIntimationPortletKeys;
import com.atmc.web.util.FileUtil;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyVEHException;
import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.bsl.db.domain.claim.ClaimODReportObj;
import com.ejada.atmc.bsl.db.domain.claim.NajmClaimReportObj;
import com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.ejada.atmc.utils.api.ReportsUtil;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.exception.EmailAddressException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.exception.UserPasswordException;
import com.liferay.portal.kernel.exception.UserScreenNameException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.atmc.web.common.NotificationTypes.Type;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
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

import claim.muroor.constants.ClaimMuroorPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=true",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=Claim Muroor Portlet",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/step2.jsp",
		"javax.portlet.name=" + ClaimMuroorPortletKeys.CLAIMMUROOR,
		"javax.portlet.init-param.add-process-action-success-action=false", 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class ClaimMuroorPortlet extends MVCPortlet {

	private static final String	NATIONALITY_CODE	= "NATIONALITY";
	private static final String	CITY_CODE			= "CITY";
	private static final String	SUCCESS_CODE		= "S";
	boolean						tpFlag				= false;
	private static final Log	_log				= LogFactoryUtil.getLog(ClaimMuroorPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String currLocale = themeDisplay.getLocale().toString();

			PortletSession pSession = renderRequest.getPortletSession();
			ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) pSession.getAttribute(ClaimIntimationPortletKeys.CLAIM_INTIMATION_OBJ, PortletSession.APPLICATION_SCOPE);
			if (odsClaimIntimation != null) {
				renderRequest.getPortletSession().setAttribute("CLAIM_INTIMATION_DATA", odsClaimIntimation);
				renderRequest.getPortletSession().removeAttribute(ClaimIntimationPortletKeys.CLAIM_INTIMATION_OBJ, PortletSession.APPLICATION_SCOPE);
			}
			String trasactionType = "";
			String damageFlag = "";
			if (odsClaimIntimation != null) {
				trasactionType = odsClaimIntimation.getTransaction();
				damageFlag = odsClaimIntimation.getDamageflag();
			}

			String myview = (String) renderRequest.getAttribute("myview");
			if (myview == null && renderRequest.getParameter("myview") != null) {
				myview = renderRequest.getParameter("myview");
			}
			if (SessionErrors.contains(renderRequest, "claims_error_nopolicy") || SessionErrors.contains(renderRequest, "claims_error_nopolicyveh")) {
				myview = "step3";
			} else if (myview == null) {
				if (damageFlag.equals(ClaimIntimationPortletKeys.CLAIM_TYPE_PROPERTY)) {
					myview = "step3";
					tpFlag = false;
				} else {
					if (trasactionType.equals(ClaimIntimationPortletKeys.TRX_COMPREHENSIVE)) {
						myview = "step3";
						tpFlag = false;
					} else if (trasactionType.equals(ClaimIntimationPortletKeys.TRX_TPL)) {
						myview = "step2";
						tpFlag = true;
					}
				}
			}

			String view = "/" + (myview == null ? "step2" : myview) + ".jsp";

			if (myview.equals("step3")) {
				List<CodeMasterDetails> citiesList = CodeMasterDetailsLocalServiceUtil.findCodeMasterDesc(CITY_CODE, currLocale);

				renderRequest.setAttribute("citiesList", citiesList);

				List<CustomerMapDetails> insCompanies = ClaimLocalServiceUtil.getInsuranceCompanies();
				renderRequest.setAttribute("insCompanies", insCompanies);
			} else if (myview.equals("step2")) {
				List<CodeMasterDetails> nationalitiesList = CodeMasterDetailsLocalServiceUtil.findCodeMasterDesc(NATIONALITY_CODE, currLocale);

				renderRequest.setAttribute("nationalitiesList", nationalitiesList);
			}

			renderRequest.setAttribute("TP_TYPE_FLAG", tpFlag);
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.forward(renderRequest, renderResponse);

		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		// Auto-generated method stub
		// super.doView(renderRequest, renderResponse);
	}

	public void applyDriverInfo(ActionRequest actionRequest, ActionResponse actionResponse) {
		boolean isBack = ParamUtil.getBoolean(actionRequest, "isBack");
		if (isBack) {
			ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) actionRequest.getPortletSession().getAttribute("CLAIM_INTIMATION_DATA");
			String driverId = odsClaimIntimation.getTpid();
			String driverName = odsClaimIntimation.getTpdrivername();
			String mobile = odsClaimIntimation.getTpmobile();
			String email = (String) actionRequest.getPortletSession().getAttribute("CLAIM_MAIL");
			double amount = odsClaimIntimation.getAmount();
			String age = odsClaimIntimation.getTpdob();
			String nationality = odsClaimIntimation.getTpnationality();

			actionRequest.setAttribute("Id", driverId);
			actionRequest.setAttribute("Name", driverName);
			actionRequest.setAttribute("Mobile", mobile);
			actionRequest.setAttribute("Email", email);
			actionRequest.setAttribute("Amount", amount + "");
			actionRequest.setAttribute("Age", age);
			actionRequest.setAttribute("Nationality", nationality);
			actionRequest.setAttribute("IS_BACK", isBack);
		} else {
			String tpId = actionRequest.getParameter("applicantId");
			String tpDriverName = actionRequest.getParameter("applicantName");
			String tpMobile = actionRequest.getParameter("mobile");
			String tpNationality = actionRequest.getParameter("nationality");
			String tpMail = actionRequest.getParameter("mail");
			String tpDOB = actionRequest.getParameter("age");
			String amount = actionRequest.getParameter("compAmount");

			PortletSession pSession = actionRequest.getPortletSession();

			ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) pSession.getAttribute("CLAIM_INTIMATION_DATA");
			if (Pattern.compile("^[0-9]+$").matcher(tpId).find() && tpId.length() == 10)
				odsClaimIntimation.setTpid(tpId);
			else
				_log.error("Invalid tpId");
			odsClaimIntimation.setTpdrivername(tpDriverName);
			if (Pattern.compile("(^05)([0-9]{8})").matcher(tpMobile).find())
				odsClaimIntimation.setTpmobile(tpMobile);
			else
				_log.error("Invalid tpMobile");
			odsClaimIntimation.setTpnationality(tpNationality);
			if (Pattern.compile("^[0-9]+$").matcher(tpDOB).find())
				odsClaimIntimation.setTpdob(tpDOB);
			else
				_log.error("Invalid tpDOB");
			if (Pattern.compile("^[0-9]+$").matcher(amount).find())
				odsClaimIntimation.setAmount(Double.valueOf(amount));
			else
				_log.error("Invalid amount");

			pSession.setAttribute("CLAIM_INTIMATION_DATA", odsClaimIntimation);
			pSession.setAttribute("CLAIM_MAIL", tpMail);

			odsClaimIntimation.setTpMail(tpMail);

			actionRequest.setAttribute("ClaimIntimationData", odsClaimIntimation);
		}
	}

	public void applyAccidentInfo(ActionRequest actionRequest, ActionResponse actionResponse) {

		boolean isBack = ParamUtil.getBoolean(actionRequest, "isBack");
		if (isBack) {
			ODSClaimIntimation odsClaim = (ODSClaimIntimation) actionRequest.getPortletSession().getAttribute("CLAIM_INTIMATION_DATA");

			String selectedCity = odsClaim.getLosslocation();
			String description = odsClaim.getLossremarks();
			int selectedFaultPercent = odsClaim.getFaultpercent();
			String insComp = odsClaim.getTpinsco();
			String accidentTime = odsClaim.getAccidentTime(); // actionRequest.getParameter("accidentTime");
			String accidentDate = odsClaim.getAccidentDate();// actionRequest.getParameter("accidentDate");
			String timeGroup = odsClaim.getTimeGroup();// actionRequest.getParameter("timeGroup");

			if (tpFlag) {
				String vehIdent = odsClaim.getVehidentivalue();
				actionRequest.setAttribute("VehIdentification", vehIdent);
			}

			actionRequest.setAttribute("AccidentDate", accidentDate);
			actionRequest.setAttribute("AccidentTime", accidentTime);
			actionRequest.setAttribute("TimeGroup", timeGroup);
			actionRequest.setAttribute("SelectedCity", selectedCity);
			actionRequest.setAttribute("Description", description);
			actionRequest.setAttribute("FaultPercent", selectedFaultPercent);
			actionRequest.setAttribute("InsuranceCompany", insComp);
			actionRequest.setAttribute("IS_BACK", isBack);
		} else {
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);

				String city = actionRequest.getParameter("city");
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
				String accDate = actionRequest.getParameter("accidentDate");
				String cityName = actionRequest.getParameter("cityName");
				String companyName = actionRequest.getParameter("companyName");
				Date accFormatDate;

				if (accDate != null)
					accFormatDate = dateFormatter.parse(accDate);
				else
					accFormatDate = dateFormatter.parse(new Date().toString());

				String accidentDate = dateFormat.format(accFormatDate);

				String accidentTime = actionRequest.getParameter("accidentTime");
				String timeGroup = actionRequest.getParameter("group");
				if (timeGroup == null)
					timeGroup = "AM";
				String accTime = accidentTime;

				String[] timeStr = accidentTime.split(":");
				int hours = Integer.valueOf(timeStr[0]);
				if (timeGroup != null) {
					if (hours < 11 && timeGroup.equals("PM")) {
						hours += 12;
						accTime = hours + ":" + timeStr[1];
					}
				}

				String faultpercent = actionRequest.getParameter("faultpercent");
				String plateNo = actionRequest.getParameter("plateNo");
				String l1 = actionRequest.getParameter("plateL1");
				String l2 = actionRequest.getParameter("plateL2");
				String l3 = actionRequest.getParameter("plateL3");
				String insuranceCompany = actionRequest.getParameter("insuranceCompany");
				String accidentDesc = Encode.forHtmlContent(actionRequest.getParameter("accidentDesc"));

				PortletSession pSession = actionRequest.getPortletSession();
				ODSClaimIntimation odsClaim = (ODSClaimIntimation) pSession.getAttribute("CLAIM_INTIMATION_DATA");

				odsClaim.setLosslocation(city);
				odsClaim.setLossdate(accidentDate + " " + accTime);
				if (tpFlag)
					odsClaim.setVehidentivalue(l1 + "-" + l2 + "-" + l3 + "-" + plateNo);
				odsClaim.setFaultpercent(Integer.valueOf(faultpercent));
				odsClaim.setTpinsco(insuranceCompany);
				odsClaim.setLossremarks(accidentDesc);

				String trasactionType = odsClaim.getTransaction();
				String damageFlag = odsClaim.getDamageflag();

				if (trasactionType.equals(ClaimIntimationPortletKeys.TRX_COMPREHENSIVE) || damageFlag.equals(ClaimIntimationPortletKeys.CLAIM_TYPE_PROPERTY)) {
					String policyNo = odsClaim.getPolicyno();

					Policy policyData = PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);

					String mobile = policyData.getInsuredMobile();
					String OD_Id = policyData.getInsuredId();
					String OD_Name = policyData.getInsuredName();

					actionRequest.setAttribute("OD_MOBILE", mobile);
					actionRequest.setAttribute("OD_ID", OD_Id);
					actionRequest.setAttribute("OD_NAME", OD_Name);
				}
				// third party case- get the ATMC policy
				else {
					PolicyHDR policy = ClaimLocalServiceUtil.getVehiclePolicy(plateNo, l1, l2, l3, themeDisplay.getLocale().toString());
					odsClaim.setPolicyno(policy.getPolicyNo());

					String mobile = policy.getInsuredMobile();
					String OD_Id = policy.getInsuredId();
					String OD_Name = policy.getInsuredName();

					actionRequest.setAttribute("OD_MOBILE", mobile);
					actionRequest.setAttribute("OD_ID", OD_Id);
					actionRequest.setAttribute("OD_NAME", OD_Name);

					actionRequest.setAttribute("TP_MAIL", actionRequest.getPortletSession().getAttribute("CLAIM_MAIL"));
				}
				odsClaim.setAccidentDate(dateFormatter.format(accFormatDate));
				odsClaim.setAccidentTime(accidentTime);
				odsClaim.setTimeGroup(timeGroup);
				odsClaim.setAccidentLocation(cityName);
				pSession.setAttribute("CLAIM_INTIMATION_DATA", odsClaim);

				actionRequest.setAttribute("ClaimIntimationData", odsClaim);
				actionRequest.setAttribute("AccidentDate", dateFormatter.format(accFormatDate));
				actionRequest.setAttribute("AccidentTime", accidentTime);
				actionRequest.setAttribute("TimeGroup", timeGroup);
				actionRequest.setAttribute("AccidentLocation", cityName);
				actionRequest.setAttribute("InsurrCompany", companyName);

			} catch (ParseException e) {
				_log.error(e.getMessage(), e);
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
				if (e instanceof NoSuchPolicyHDRException) {
					SessionErrors.add(actionRequest, "claims_error_nopolicy");
				} else if (e instanceof NoSuchPolicyVEHException) {
					SessionErrors.add(actionRequest, "claims_error_nopolicyveh");
				}
			}
		}
	}

	public void submitFile(ActionRequest request, ActionResponse response, String claimRefNo, String id) {

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		ByteArrayFileInputStream inputStream = null;
		try {

			// flag to check if file is executable file and file type is one of executable
			// files
			boolean driverLicenseAcceptableType = false;
			boolean driverLicenseExecutable = false;

			boolean vehRegAcceptableType = false;
			boolean vehRegExecutable = false;

			boolean policyAcceptableType = false;
			boolean policyExecutable = false;

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

			File driverLicenseFile = uploadPortletRequest.getFile("driverLicenseFile");
			String driverLicenseFileName = uploadPortletRequest.getFileName("driverLicenseFile");
			File vehRegFile = uploadPortletRequest.getFile("vehRegFile");
			String vehRegFileName = uploadPortletRequest.getFileName("vehRegFile");
			File frontPhotoFile = uploadPortletRequest.getFile("frontPhotoFile");
			String frontPhotoFileName = uploadPortletRequest.getFileName("frontPhotoFile");
			File rearPhotoFile = uploadPortletRequest.getFile("rearPhotoFile");
			String rearPhotoFileName = uploadPortletRequest.getFileName("rearPhotoFile");
			File rightSidePhotoFile = uploadPortletRequest.getFile("rightSidePhotoFile");
			String rightSidePhotoFileName = uploadPortletRequest.getFileName("rightSidePhotoFile");
			File leftSidePhotoFile = uploadPortletRequest.getFile("leftSidePhotoFile");
			String leftSidePhotoFileName = uploadPortletRequest.getFileName("leftSidePhotoFile");
			File bankIbanFile = uploadPortletRequest.getFile("ibanFile");
			String bankIbanFileName = uploadPortletRequest.getFileName("ibanFile");
			File ownerIdFile = uploadPortletRequest.getFile("ownerIdFile");
			String ownerIdFileName = uploadPortletRequest.getFileName("ownerIdFile");
			File policyFile = uploadPortletRequest.getFile("policyFile");
			String policyFileName = uploadPortletRequest.getFileName("policyFile");
			if (!driverLicenseFile.exists()) {
				_log.info("ID is Empty driverLicenseFile");
				driverLicenseFile = null;
				driverLicenseFileName = "";
			} else {
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
			if (!vehRegFile.exists()) {
				_log.info("ID is Empty vehicleRegistrationFile");
				vehRegFile = null;
				vehRegFileName = "";
			} else {
//				vehRegAcceptableType = FileUtil.isAcceptedFileType(vehRegFile, acceptedTypes);
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
			if (tpFlag) {
				if (!frontPhotoFile.exists()) {
					_log.info("ID is Empty frontPhotoFile");
					frontPhotoFile = null;
					frontPhotoFileName = "";
				} else {
//					frontPhotoAcceptableType = FileUtil.isAcceptedFileType(frontPhotoFile, acceptedTypes);
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

				if (!rearPhotoFile.exists()) {
					_log.info("ID is Empty rearPhotoFile");
					rearPhotoFile = null;
					rearPhotoFileName = "";
				} else {
//					rearPhotoAcceptableType = FileUtil.isAcceptedFileType(rearPhotoFile, acceptedTypes);
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

				if (!rightSidePhotoFile.exists()) {
					_log.info("ID is Empty rightSidePhotoFile");
					rightSidePhotoFile = null;
					rightSidePhotoFileName = "";
				} else {
//					rightSidePhotoAcceptableType = FileUtil.isAcceptedFileType(rightSidePhotoFile, acceptedTypes);
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

				if (!leftSidePhotoFile.exists()) {
					_log.info("ID is Empty leftSidePhotoFile");
					leftSidePhotoFile = null;
					leftSidePhotoFileName = "";
				} else {
//					leftSidePhotoAcceptableType = FileUtil.isAcceptedFileType(leftSidePhotoFile, acceptedTypes);
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

				if (!bankIbanFile.exists()) {
					_log.info("ID is Empty bankIbanFile");
					bankIbanFile = null;
					bankIbanFileName = "";
				} else {
//					bankIbanAcceptableType = FileUtil.isAcceptedFileType(bankIbanFile, acceptedTypes);
					bankIbanAcceptableType = FileUtil.validateFile(bankIbanFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
					if (!bankIbanAcceptableType) {
						bankIbanFile = null;
						bankIbanFileName = "";
					}
					bankIbanExecutable = FileUtil.isExecutable(bankIbanFile);
					if (bankIbanExecutable) {
						bankIbanFile = null;
						bankIbanFileName = "";
					}
				}

				if (!ownerIdFile.exists()) {
					_log.info("ID is Empty ownerIdFile");
					ownerIdFile = null;
					ownerIdFileName = "";
				} else {
//					ownerIdAcceptableType = FileUtil.isAcceptedFileType(ownerIdFile, acceptedTypes);
					ownerIdAcceptableType = FileUtil.validateFile(ownerIdFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
					if (!ownerIdAcceptableType) {
						ownerIdFile = null;
						ownerIdFileName = "";
					}
					ownerIdExecutable = FileUtil.isExecutable(ownerIdFile);
					if (ownerIdExecutable) {
						ownerIdFile = null;
						ownerIdFileName = "";
					}
				}

				ClaimLocalServiceUtil.saveTPMuroorDoc(id, claimRefNo, driverLicenseFile, driverLicenseFileName, vehRegFile, vehRegFileName, frontPhotoFile, frontPhotoFileName, rearPhotoFile,
						rearPhotoFileName, rightSidePhotoFile, rightSidePhotoFileName, leftSidePhotoFile, leftSidePhotoFileName, bankIbanFile, bankIbanFileName, ownerIdFile, ownerIdFileName);
			} else {
				if (!policyFile.exists()) {
					_log.info("ID is Empty policyFile");
					policyFile = null;
					policyFileName = "";
				} else {
//					policyAcceptableType = FileUtil.isAcceptedFileType(policyFile, acceptedTypes);
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

				ClaimLocalServiceUtil.saveODMuroorDoc(id, claimRefNo, driverLicenseFile, driverLicenseFileName, vehRegFile, vehRegFileName, policyFile, policyFileName);
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			try {
				StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void submitMuroorClaim(ActionRequest actionRequest, ActionResponse actionResponse) {
		String iban = actionRequest.getParameter("iban");
		String email = actionRequest.getParameter("email");

		String accidentTime = actionRequest.getParameter("accidentTime");
		String accidentDate = actionRequest.getParameter("accidentDate");
		String timeGroup = actionRequest.getParameter("timeGroup");
		String accidentLocation = actionRequest.getParameter("accidentLocation");
		String mobile = actionRequest.getParameter("mobile");
		String insurrCompany = "";
		String name = actionRequest.getParameter("name");
		String id = actionRequest.getParameter("id");
		if (tpFlag) {
			insurrCompany = actionRequest.getParameter("insurrCompany");
		}

		PortletSession pSession = actionRequest.getPortletSession();
		ODSClaimIntimation odsClaimInt = (ODSClaimIntimation) pSession.getAttribute("CLAIM_INTIMATION_DATA");
		try {
			int flag = ClaimLocalServiceUtil.checkIbanValidation(iban);
			if (flag == 0) {

				actionRequest.setAttribute("myview", "review");
				actionRequest.setAttribute("ClaimIntimationData", odsClaimInt);
				actionRequest.setAttribute("AccidentDate", accidentDate);
				actionRequest.setAttribute("AccidentTime", accidentTime);
				actionRequest.setAttribute("TimeGroup", timeGroup);
				actionRequest.setAttribute("AccidentLocation", accidentLocation);
				actionRequest.setAttribute("OD_NAME", name);
				actionRequest.setAttribute("OD_ID", id);
				if (Pattern.compile("(^05)([0-9]{8})").matcher(mobile).find())
					actionRequest.setAttribute("OD_MOBILE", mobile);
				if (tpFlag) {
					actionRequest.setAttribute("TP_MAIL", email);
					actionRequest.setAttribute("InsurrCompany", insurrCompany);

				}
				SessionErrors.add(actionRequest, "invalid_iban");
				return;
			}
			_log.error("Submit Murror Claim - Flag >>>>>>>>>>> " + flag);
			_log.error("Submit Murror Claim - iban >>>>>>>>>>> " + iban);
			odsClaimInt.setTpiban(iban);
			actionRequest.setAttribute("Amount", odsClaimInt.getAmount());
			_log.error("Step >>>>>>>>>>>." + 1);
			ODSCIResponse odsCIResponse = ClaimLocalServiceUtil.submitClaim(odsClaimInt);

			_log.info(odsCIResponse.getStatus());

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Company company = PortalUtil.getCompany(actionRequest);

			if (odsCIResponse.getStatus().equals(SUCCESS_CODE)) {
				odsClaimInt.setReferenceno(odsCIResponse.getClaimintimationno());
				actionRequest.setAttribute("referenceNo", odsCIResponse.getClaimintimationno());

				if (tpFlag) {
					submitFile(actionRequest, actionResponse, odsCIResponse.getClaimintimationno(), odsClaimInt.getTpid());
					boolean isUserSignedIn = themeDisplay.isSignedIn();
					User user = null;
					user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), "" + odsClaimInt.getTpid());
					if (!isUserSignedIn) {
						if (user == null) {
							long companyId = company.getCompanyId();

							ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
							user = UserMgmtLocalServiceUtil.createUser(companyId, "" + odsClaimInt.getTpid(), null, odsClaimInt.getTpdrivername(), odsClaimInt.getTpdrivername(),
									themeDisplay.getLocale(), "" + odsClaimInt.getTpmobile(), email, serviceContext);
						}
					}

					String[] mailArgs = { odsClaimInt.getTpdrivername(), odsCIResponse.getClaimintimationno(), PropsUtil.get("dashboardURL"), PropsUtil.get("branchLocatorURL") };
					NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), Type.POST_CLAIM_INTIMATION.val(), email, odsClaimInt.getTpmobile(), mailArgs, mailArgs, new ArrayList<File>(),
							new ArrayList<String>(), mailArgs, user.getUserId(), user.getCompanyId());

				} else {
					submitFile(actionRequest, actionResponse, odsCIResponse.getClaimintimationno(), id);
					boolean isUserSignedIn = themeDisplay.isSignedIn();
					User user = null;
					user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), id);
					if (!isUserSignedIn) {
						if (user == null) {
							long companyId = company.getCompanyId();

							ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), actionRequest);
							if (Pattern.compile("(^05)([0-9]{8})").matcher(mobile).find() && mobile.length() == 10)
								user = UserMgmtLocalServiceUtil.createUser(companyId, id, null, name, name, themeDisplay.getLocale(), mobile, email, serviceContext);
						}
					}

					String[] parameters = { name, odsCIResponse.getClaimintimationno(), PropsUtil.get("dashboardURL"), PropsUtil.get("branchLocatorURL") };
					if (Pattern.compile("(^05)([0-9]{8})").matcher(mobile).find() && mobile.length() == 10)
						NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), Type.POST_CLAIM_INTIMATION.val(), email, mobile, parameters, parameters, new ArrayList<File>(),
								new ArrayList<String>(), parameters, user.getUserId(), user.getCompanyId());

				}

				actionRequest.setAttribute("AccidentDate", accidentDate);
				actionRequest.setAttribute("AccidentTime", accidentTime);
				actionRequest.setAttribute("TimeGroup", timeGroup);
				actionRequest.setAttribute("AccidentLocation", accidentLocation);
				if (tpFlag) {
					if (Pattern.compile("(^05)([0-9]{8})").matcher(mobile).find() && mobile.length() == 10)
						actionRequest.setAttribute("OD_MOBILE", mobile);
					actionRequest.setAttribute("TP_MAIL", email);
					actionRequest.setAttribute("InsurrCompany", insurrCompany);
				}

			} else if (odsCIResponse.getStatus().equals("F")) {
				actionRequest.setAttribute("myview", "review");
				SessionErrors.add(actionRequest, "failed_submit");

				actionRequest.setAttribute("ClaimIntimationData", odsClaimInt);
				actionRequest.setAttribute("AccidentDate", accidentDate);
				actionRequest.setAttribute("AccidentTime", accidentTime);
				actionRequest.setAttribute("TimeGroup", timeGroup);
				actionRequest.setAttribute("AccidentLocation", accidentLocation);
				if (tpFlag) {
					if (Pattern.compile("(^05)([0-9]{8})").matcher(mobile).find() && mobile.length() == 10)
						actionRequest.setAttribute("OD_MOBILE", mobile);
					actionRequest.setAttribute("TP_MAIL", email);
					actionRequest.setAttribute("InsurrCompany", insurrCompany);
				}

				return;
			}
		} catch (PortalException e) {
			if (e instanceof UserEmailAddressException.MustNotBeDuplicate || e instanceof UserScreenNameException.MustNotBeDuplicate || e instanceof EmailAddressException
					|| e instanceof UserEmailAddressException || e instanceof UserPasswordException || e instanceof UserScreenNameException)
			{

				hideDefaultErrorMessage(actionRequest);
				SessionErrors.add(actionRequest, e.getClass(), e);
			}
		}
	}

	public void backToLanding(ActionRequest actionRequest, ActionResponse actionResponse) {
		try {
			actionResponse.sendRedirect("/web/customer/claim_intimation");
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void backToClaim(ActionRequest actionRequest, ActionResponse actionResponse) {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			boolean isUserSignedIn = themeDisplay.isSignedIn();
			if (!isUserSignedIn) {
				actionResponse.sendRedirect("/web/customer/home");
			} else {
				actionResponse.sendRedirect("/web/customer/claims");
			}
		} catch (IOException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PortletSession pSession = resourceRequest.getPortletSession();
		ODSClaimIntimation odsClaimInt = (ODSClaimIntimation) pSession.getAttribute("CLAIM_INTIMATION_DATA");
		String trasactionType = odsClaimInt.getTransaction();
		String damageFlag = odsClaimInt.getDamageflag();
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		Policy policyData = null;
		String download = resourceRequest.getParameter("download");

		if (trasactionType.equals(ClaimIntimationPortletKeys.TRX_COMPREHENSIVE) || damageFlag.equals(ClaimIntimationPortletKeys.CLAIM_TYPE_PROPERTY)) {
			String policyNo = odsClaimInt.getPolicyno();

			try {

				policyData = PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
				String[] plateData = odsClaimInt.getVehidentivalue().split("-");
				String plateNo = plateData[3];
				String l1 = plateData[0];
				String l2 = plateData[1];
				String l3 = plateData[2];

				String lang = themeDisplay.getLocale().toString();
				List<PolicyVEH> policyVehs = null;
				if (lang.equals("en_US")) {
					policyVehs = PolicyVEHLocalServiceUtil.findByEnPlateNo(Long.valueOf(plateNo), l1, l2, l3);
				} else {
					policyVehs = PolicyVEHLocalServiceUtil.findByArPlateNo(plateNo, l1, l2, l3);
				}

				PolicyVEH policyVeh = policyVehs.get(0);

				ClaimODReportObj odReportObj = new ClaimODReportObj();
				odReportObj.setPolicyNo(odsClaimInt.getPolicyno());
				odReportObj.setInsuredName(policyData.getInsuredName());
				odReportObj.setInsuredMobNo(policyData.getInsuredMobile());
				odReportObj.setInsuredEmail(policyData.getInsuredEmail());
				if (lang.equals("en_US")) {
					odReportObj.setMake(policyVeh.getMakeDescEn());
				} else {
					odReportObj.setMake(policyVeh.getMakeDescAr());
				}
				odReportObj.setMfgYr(policyVeh.getMfgYear());
				odReportObj.setPlateNo(odsClaimInt.getVehidentivalue());
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				odReportObj.setExpiryDate(dateFormatter.format(policyData.getExpiryDate()));

				odReportObj.setAccidentDate(odsClaimInt.getAccidentDate());
				odReportObj.setAccidentTime(odsClaimInt.getAccidentTime());
				odReportObj.setAccidentCity(odsClaimInt.getAccidentLocation());
				odReportObj.setTimeGroup(odsClaimInt.getTimeGroup());

				odReportObj.setDamageFlag(odsClaimInt.getDamageflag());
				odReportObj.setTransaction(odsClaimInt.getTransaction());

				Customer cust = CustomerLocalServiceUtil.fetchCustomer(policyData.getInsuredId());
				odReportObj.setInsuredZIPCode(cust.getZipCode());
				try {
					String city = CodeMasterDetailsLocalServiceUtil.getCodeMasterDesc(CITY_CODE, cust.getCity(), lang);
					odReportObj.setInsuredCity(city);
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				}

				odReportObj.setDescription(odsClaimInt.getLossremarks());

				List<ClaimODReportObj> claimReportObjList = new ArrayList<ClaimODReportObj>();
				claimReportObjList.add(odReportObj);

				if (download != null && download.equals("false"))
					resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + "MuroorClaim.pdf" + "\"");
				else
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + "MuroorClaim.pdf" + "\"");

				resourceResponse.setContentType("application/pdf");

				ReportsUtil.fillAndExportPDFReport("ClaimODReport.jasper", claimReportObjList, null, resourceResponse.getPortletOutputStream());

			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		} else {
			Locale locale = new Locale("ar", "SA");
			HashMap<String, Object> claimParams = new HashMap<String, Object>();

			claimParams.put("reportTitle", LanguageUtil.get(locale, "report_title"));
			claimParams.put("claimNo", LanguageUtil.get(locale, "claim_no"));
			claimParams.put("firstReportHeader", LanguageUtil.get(locale, "first_report_header"));
			claimParams.put("firstReportTip", LanguageUtil.get(locale, "first_report_tip"));
			claimParams.put("policyNo", LanguageUtil.get(locale, "policy_no"));
			claimParams.put("compensationAmount", LanguageUtil.get(locale, "compensation_amount"));
			claimParams.put("currency", LanguageUtil.get(locale, "currency"));
			claimParams.put("claimType", LanguageUtil.get(locale, "claim_type"));
			claimParams.put("car", LanguageUtil.get(locale, "car"));
			claimParams.put("injuries", LanguageUtil.get(locale, "injuries"));
			claimParams.put("fire", LanguageUtil.get(locale, "fire"));
			claimParams.put("poperties", LanguageUtil.get(locale, "poperties"));
			claimParams.put("deaths", LanguageUtil.get(locale, "deaths"));
			claimParams.put("others", LanguageUtil.get(locale, "others"));
			claimParams.put("ownerName", LanguageUtil.get(locale, "owner_name"));
			claimParams.put("ownerIqamaId", LanguageUtil.get(locale, "owner_iqama_id"));
			claimParams.put("ownerEmail", LanguageUtil.get(locale, "owner_email"));
			claimParams.put("ownerPhone", LanguageUtil.get(locale, "owner_phone"));
			claimParams.put("postalCode", LanguageUtil.get(locale, "postal_code"));
			claimParams.put("driverIqamaId", LanguageUtil.get(locale, "driver_iqama_id"));
			claimParams.put("driverName", LanguageUtil.get(locale, "driver_name"));
			claimParams.put("driverDob", LanguageUtil.get(locale, "drivers_age"));
			claimParams.put("driverCarOwner", LanguageUtil.get(locale, "driver_car_owner"));
			claimParams.put("yes", LanguageUtil.get(locale, "yes"));
			claimParams.put("no", LanguageUtil.get(locale, "no"));
			claimParams.put("secReportHeader", LanguageUtil.get(locale, "sec_report_header"));
			claimParams.put("accLocation", LanguageUtil.get(locale, "acc_location"));
			claimParams.put("accTime", LanguageUtil.get(locale, "acc_time"));
			claimParams.put("pm", LanguageUtil.get(locale, "pm"));
			claimParams.put("am", LanguageUtil.get(locale, "am"));
			claimParams.put("reportMode", LanguageUtil.get(locale, "report_mode"));
			claimParams.put("reportNo", LanguageUtil.get(locale, "report_no"));
			claimParams.put("faultPercent", LanguageUtil.get(locale, "fault_percent"));
			claimParams.put("plateNo", LanguageUtil.get(locale, "third_party_plate_no"));
			claimParams.put("secReportTip", LanguageUtil.get(locale, "sec_report_tip"));
			claimParams.put("reportIban", LanguageUtil.get(locale, "report_iban"));
			claimParams.put("claimantPresented", LanguageUtil.get(locale, "claimant_presented"));
			claimParams.put("carOwner", LanguageUtil.get(locale, "car_owner"));
			claimParams.put("anotherPerson", LanguageUtil.get(locale, "another_person"));
			claimParams.put("claimantIqamaId", LanguageUtil.get(locale, "claimant_iqama_id"));
			claimParams.put("claimantMobile", LanguageUtil.get(locale, "claimant_mobile"));
			claimParams.put("date", LanguageUtil.get(locale, "date"));
			claimParams.put("signature", LanguageUtil.get(locale, "signature"));
			claimParams.put("phoneNo", LanguageUtil.get(locale, "phone_no"));
			claimParams.put("claimantName", LanguageUtil.get(locale, "claimant_name"));
			claimParams.put("thirdReportHeader", LanguageUtil.get(locale, "third_report_header"));
			claimParams.put("thirdReportTip", LanguageUtil.get(locale, "third_report_tip"));
			claimParams.put("fourthReportTip", LanguageUtil.get(locale, "fourth_report_tip"));
			claimParams.put("najm", LanguageUtil.get(locale, "najm_status_3"));

			// claimParams.put("claimantEmail", odsClaimInt.ClaimantEmail());
			claimParams.put("claimantPhoneNo", odsClaimInt.getTpmobile());
			claimParams.put("iban", odsClaimInt.getTpiban());

			NajmClaimReportObj claimReportObj = new NajmClaimReportObj();
			claimReportObj.setClaimantName(odsClaimInt.getTpdrivername());
			claimReportObj.setClaimNo(odsClaimInt.getReferenceno());
			claimReportObj.setClaimAmount(odsClaimInt.getAmount());
			claimReportObj.setDamageFlag(odsClaimInt.getDamageflag());

			claimReportObj.setClaimantEmail(odsClaimInt.getTpMail());
			claimReportObj.setClaimantPhoneNo(odsClaimInt.getTpmobile());
			claimReportObj.setInsuredDOb(odsClaimInt.getTpdob());
			claimReportObj.setLossLocation(odsClaimInt.getAccidentLocation());
			claimReportObj.setLossDate(odsClaimInt.getLossdate());
			claimReportObj.setReportType(LanguageUtil.get(locale, "claim_status_" + odsClaimInt.getReportmode()));
			claimReportObj.setReportNo(odsClaimInt.getReportno());
			claimReportObj.setFaultPercent(odsClaimInt.getFaultpercent());
			claimReportObj.setLossRemarks(odsClaimInt.getLossremarks());
			claimReportObj.setIban(odsClaimInt.getTpiban());
			claimReportObj.setClaimDate((new Date()).toString());
			claimReportObj.setClaimantIqamaId(odsClaimInt.getTpid());
			claimReportObj.setPlateNoAr(odsClaimInt.getTpplateno());

			String[] plateData = odsClaimInt.getTpplateno().split("-");
			String plateNo = plateData[3];
			String l1 = plateData[0];
			String l2 = plateData[1];
			String l3 = plateData[2];

			try {
				policyData = PolicyLocalServiceUtil.getVehiclePolicyData(plateNo, l1, l2, l3, themeDisplay.getLocale().toString());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			if (policyData != null)
				claimReportObj.setPolicyNo(odsClaimInt.getPolicyno());
			else
				claimReportObj.setPolicyNo("");

			List<NajmClaimReportObj> claimReportObjList = new ArrayList<>();
			claimReportObjList.add(claimReportObj);

			if (download != null && download.equals("false"))
				resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + "MuroorClaim.pdf" + "\"");
			else
				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + "MuroorClaim.pdf" + "\"");
			try {
				ReportsUtil.fillAndExportPDFReport("claimTPL.jasper", claimReportObjList, claimParams, resourceResponse.getPortletOutputStream());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

		}
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}