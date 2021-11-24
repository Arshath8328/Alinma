package claim.najm.portlet;

import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.web.constants.ClaimIntimationPortletKeys;
import com.ejada.atmc.acl.db.model.Customer;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.service.CustomerLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.bsl.db.domain.claim.ClaimODReportObj;
import com.ejada.atmc.bsl.db.domain.claim.NajmClaim;
import com.ejada.atmc.bsl.db.domain.claim.NajmClaimIntimation;
import com.ejada.atmc.bsl.db.domain.claim.NajmClaimReportObj;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.ejada.atmc.utils.api.ReportsUtil;
import com.atmc.web.util.FileUtil;
import com.liferay.petra.io.StreamUtil;
import com.liferay.portal.kernel.exception.PortalException;
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
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

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

import claim.najm.constants.ClaimNajmPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = {
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=true", 
		"javax.portlet.display-name=ATMC Claim Najm Portlet",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.init-param.template-path=/", 
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + ClaimNajmPortletKeys.CLAIMNAJM,
		"javax.portlet.resource-bundle=content.Language", 
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class ClaimNajmPortlet extends MVCPortlet {

	private static final Log _log = LogFactoryUtil.getLog(ClaimNajmPortlet.class);
	private static final String SUCCESS_CODE = "S";
	private static final String CITY_CODE = "CITY";

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {

			ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) renderRequest.getPortletSession().getAttribute(ClaimIntimationPortletKeys.CLAIM_INTIMATION_OBJ,
					PortletSession.APPLICATION_SCOPE);
			_log.info("get odsClaimIntimation from session");
			renderRequest.getPortletSession().removeAttribute(ClaimIntimationPortletKeys.CLAIM_INTIMATION_OBJ, PortletSession.APPLICATION_SCOPE);

			NajmClaimIntimation najmClaimIntimation = (NajmClaimIntimation) renderRequest.getPortletSession().getAttribute(ClaimIntimationPortletKeys.NAJM_CLAIM_INTIMATION_OBJ,
					PortletSession.APPLICATION_SCOPE);
			_log.info("get najmClaimIntimation from session");
			renderRequest.getPortletSession().removeAttribute(ClaimIntimationPortletKeys.NAJM_CLAIM_INTIMATION_OBJ, PortletSession.APPLICATION_SCOPE);
			if (odsClaimIntimation != null && najmClaimIntimation != null) {
				NajmClaim najmClaimaint = najmClaimIntimation.getClaimant();
				NajmClaim najmClaimOtherParty = null;
				if (odsClaimIntimation.getTransaction() == ClaimIntimationPortletKeys.TRX_TPL) {
					najmClaimOtherParty = najmClaimIntimation.getOtherParty();
				}

				fillODSClaimIntimation(odsClaimIntimation, najmClaimIntimation, najmClaimaint, najmClaimOtherParty);
				PortletSession pSession = renderRequest.getPortletSession();
				pSession.setAttribute("najmClaimObj", najmClaimaint);
				pSession.setAttribute("najmClaimTPObj", najmClaimOtherParty);
				pSession.setAttribute("odsClaimIntObj", odsClaimIntimation);

				renderRequest.setAttribute("najmClaimObj", najmClaimaint);
				renderRequest.setAttribute("najmClaimTPObj", najmClaimOtherParty);
				renderRequest.setAttribute("odsClaimIntObj", odsClaimIntimation);
				renderRequest.setAttribute("policyTypeFlag", odsClaimIntimation.getTransaction());
			} else {
				PortletSession pSession = renderRequest.getPortletSession();
				NajmClaim najmClaimaint = (NajmClaim) pSession.getAttribute("najmClaimObj");
				NajmClaim najmClaimOtherParty = (NajmClaim) pSession.getAttribute("najmClaimTPObj");
				odsClaimIntimation = (ODSClaimIntimation) pSession.getAttribute("odsClaimIntObj");
				renderRequest.setAttribute("najmClaimObj", najmClaimaint);
				renderRequest.setAttribute("najmClaimTPObj", najmClaimOtherParty);
				renderRequest.setAttribute("odsClaimIntObj", odsClaimIntimation);
				renderRequest.setAttribute("policyTypeFlag", odsClaimIntimation.getTransaction());
			}

		} catch (Exception e) {
			_log.error(e);
		}

		String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview")
				: (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "view";
		String view = "/" + (myview == null ? "view" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(renderRequest, renderResponse);

		// super.doView(renderRequest, renderResponse);
	}

	public void submitFile(ActionRequest request, ActionResponse response, String claimRefNo) {

		PortletSession pSession = request.getPortletSession();
		NajmClaim najmClaimaint = (NajmClaim) pSession.getAttribute("najmClaimObj");
		ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) pSession.getAttribute("odsClaimIntObj");
		boolean najmSlipFileAcceptableType = false;
		boolean najmSlipFileExecutable = false;

		boolean damageEstQuotFileAcceptableType = false;
		boolean damageEstQuotFileExecutable = false;

		boolean bankIbanAcceptableType = false;
		boolean bankIbanExecutable = false;

		boolean ownerIdAcceptableType = false;
		boolean ownerIdExecutable = false;

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		ByteArrayFileInputStream inputStream = null;
		try {
			if (odsClaimIntimation.getTransaction() == ClaimIntimationPortletKeys.TRX_TPL) {
				File najmSlipFile = uploadPortletRequest.getFile("najmSlipFile");
				String najmSlipFileName = uploadPortletRequest.getFileName("najmSlipFile");
				File damageEstQuotFile = uploadPortletRequest.getFile("damageEstQuotFile");
				String damageEstQuotFileName = uploadPortletRequest.getFileName("damageEstQuotFile");
				File bankIbanFile = uploadPortletRequest.getFile("bankIbanFile");
				String bankIbanFileName = uploadPortletRequest.getFileName("bankIbanFile");
				File ownerIdFile = uploadPortletRequest.getFile("ownerIdFile");
				String ownerIdFileName = uploadPortletRequest.getFileName("ownerIdFile");

				if (!najmSlipFile.exists()) {
					_log.info("ID is Empty najmSlipFile");
					najmSlipFile = null;
					najmSlipFileName = "";
				} else {
//					najmSlipFileAcceptableType = FileUtil.isAcceptedFileType(najmSlipFile, acceptedTypes);
					najmSlipFileAcceptableType = FileUtil.validateFile(najmSlipFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
					if (!najmSlipFileAcceptableType) {
						najmSlipFile = null;
						najmSlipFileName = "";
					}
					najmSlipFileExecutable = FileUtil.isExecutable(najmSlipFile);
					if (najmSlipFileExecutable) {
						najmSlipFile = null;
						najmSlipFileName = "";
					}
				}
				if (!damageEstQuotFile.exists()) {
					_log.info("ID is Empty damageEstQuotFile");
					damageEstQuotFile = null;
					damageEstQuotFileName = "";
				} else {
//					damageEstQuotFileAcceptableType = FileUtil.isAcceptedFileType(damageEstQuotFile, acceptedTypes);
					damageEstQuotFileAcceptableType = FileUtil.validateFile(damageEstQuotFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
					if (!damageEstQuotFileAcceptableType) {
						damageEstQuotFile = null;
						damageEstQuotFileName = "";
					}
					damageEstQuotFileExecutable = FileUtil.isExecutable(damageEstQuotFile);
					if (damageEstQuotFileExecutable) {
						damageEstQuotFile = null;
						damageEstQuotFileName = "";
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

				ClaimLocalServiceUtil.saveNajmSubmitedFiles(najmClaimaint.getCaseNo(), najmClaimaint.getCipiId(), najmSlipFile, najmSlipFileName, damageEstQuotFile, damageEstQuotFileName,
						bankIbanFile, bankIbanFileName, ownerIdFile, ownerIdFileName, claimRefNo);

			} else {
				File najmSlipFile = uploadPortletRequest.getFile("najmSlipFile");
				String najmSlipFileName = uploadPortletRequest.getFileName("najmSlipFile");

				if (!najmSlipFile.exists()) {
					_log.info("ID is Empty driverLicenseFile");
					najmSlipFile = null;
					najmSlipFileName = "";
				} else {
//					najmSlipFileAcceptableType = FileUtil.isAcceptedFileType(najmSlipFile, acceptedTypes);
					najmSlipFileAcceptableType = FileUtil.validateFile(najmSlipFile, FileUtil.ACCEPTED_FILE_TYPES, FileUtil.MINIMUM_ALLOWED_SIZE);
					if (!najmSlipFileAcceptableType) {
						najmSlipFile = null;
						najmSlipFileName = "";
					}
					najmSlipFileExecutable = FileUtil.isExecutable(najmSlipFile);
					if (najmSlipFileExecutable) {
						najmSlipFile = null;
						najmSlipFileName = "";
					}
				}

				ClaimLocalServiceUtil.saveNajmSubmitedFiles(najmClaimaint.getCaseNo(), najmClaimaint.getCipiId(), najmSlipFile, najmSlipFileName, null, "", null, "", null, "", claimRefNo);

			}

		} catch (Exception e) {
			_log.error(e);
		} finally {
			try {
				StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private void fillODSClaimIntimation(ODSClaimIntimation odsClaimIntimation, NajmClaimIntimation najmClaimIntimation, NajmClaim najmClaimaint, NajmClaim najmClaimOtherParty) {

		double amount = 0;
		try {
			amount = Double.valueOf(najmClaimaint.getLiabiltiyAmt());
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
		;
		odsClaimIntimation.setAmount(amount);
		odsClaimIntimation.setLosslocation(ClaimLocalServiceUtil.getCityCoreCode(najmClaimaint.getCity()));
		odsClaimIntimation.setLossdate(najmClaimaint.getCallDt());
		odsClaimIntimation.setFaultpercent(Integer.valueOf(najmClaimaint.getLiabiltiyPerc()));
		odsClaimIntimation.setLossremarks(najmClaimaint.getCauseEn());
		// in case of TPL claims the claimant is the THIRD PARTY so map the claimant
		// details to the third party details in the ODS claim intimation object
		if (odsClaimIntimation.getTransaction().equals(ClaimIntimationPortletKeys.TRX_TPL)) {
			odsClaimIntimation.setTpid(najmClaimaint.getCipiId());
			odsClaimIntimation.setTpdrivername(najmClaimaint.getName());
			odsClaimIntimation.setTpmobile(najmClaimaint.getPhoneNo());
			odsClaimIntimation.setTpinsco(najmClaimaint.getEnglishName());
			odsClaimIntimation.setTpdob(najmClaimaint.getAge());
			odsClaimIntimation.setTpnationality(najmClaimaint.getNationality());
			odsClaimIntimation.setTpvehidentitype(najmClaimIntimation.getClaimantVehicleType());
			odsClaimIntimation.setTpvehidentivalue(najmClaimIntimation.getClaimantVehicleNumber());

			String najmClaimantEnPlateNumber = getNajmPlateNumber(najmClaimaint.getPlateNo(), "en_US");
			odsClaimIntimation.setTpplateno(getODSPlateNumber(najmClaimantEnPlateNumber));

			String najmOtherPartyEnPlateNumber = getNajmPlateNumber(najmClaimOtherParty.getPlateNo(), "en_US");
			odsClaimIntimation.setVehidentitype(ClaimIntimationPortletKeys.VEHICLE_IDENT_TYPE_PLATE_NUMBER);
			odsClaimIntimation.setVehidentivalue(getODSPlateNumber(najmOtherPartyEnPlateNumber));

		} else {
			odsClaimIntimation.setVehidentitype(najmClaimIntimation.getClaimantVehicleType());
			odsClaimIntimation.setVehidentivalue(najmClaimIntimation.getClaimantVehicleNumber());

		}

	}

	public void submitNajm(ActionRequest request, ActionResponse response) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		String iban = request.getParameter("iban");
		String email = request.getParameter("email");
		PortletSession pSession = request.getPortletSession();
		NajmClaim najmClaimaint = (NajmClaim) pSession.getAttribute("najmClaimObj");
		ODSClaimIntimation odsClaimIntimation = (ODSClaimIntimation) pSession.getAttribute("odsClaimIntObj");
		try {
			int Flag = ClaimLocalServiceUtil.checkIbanValidation(iban);
			if (Flag == 0) {
				request.setAttribute("myview", "view");
				// request.setAttribute("odsClaimIntObj", odsClaimIntimation);
				// request.setAttribute("policyTypeFlag", odsClaimIntimation.getTransaction());
				SessionErrors.add(request, "invalid_iban");
				return;
			}

		} catch (Exception e) {
			_log.error(e);
		}

		odsClaimIntimation.setTpiban(iban);

		ODSCIResponse odsCIResponse;
		try {
			odsCIResponse = ClaimLocalServiceUtil.submitClaim(odsClaimIntimation);
			Company company = PortalUtil.getCompany(request);
			if (odsCIResponse.getStatus().equals(SUCCESS_CODE)) {
				submitFile(request, response, odsCIResponse.getClaimintimationno());
				odsClaimIntimation.setReferenceno(odsCIResponse.getClaimintimationno());
				request.setAttribute("referenceNo", odsCIResponse.getClaimintimationno());
				request.setAttribute("amount", odsClaimIntimation.getAmount());
				if (odsClaimIntimation.getTransaction().equals(ClaimIntimationPortletKeys.TRX_TPL))
					request.setAttribute("tpFlag", true);
				else
					request.setAttribute("tpFlag", false);
				boolean isUserSignedIn = themeDisplay.isSignedIn();
				if (!isUserSignedIn) {
					long companyId = company.getCompanyId();
					pSession.setAttribute("email", email);
					ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);
					// create user if it does not exist in liferay
					User user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), najmClaimaint.getCipiId());
					if (user == null)
						UserMgmtLocalServiceUtil.createUser(companyId, najmClaimaint.getCipiId(), null, najmClaimaint.getName(), najmClaimaint.getName(), themeDisplay.getLocale(),
								najmClaimaint.getPhoneNo(), email, serviceContext);
				}
				pSession.setAttribute("claimInt", odsClaimIntimation);
				pSession.setAttribute("najmClaim", najmClaimaint);

			} else if (odsCIResponse.getStatus().equals("F")) {
				request.setAttribute("myview", "view");
				SessionErrors.add(request, "failed_submit");
				return;
			}

			_log.info(odsCIResponse.getStatus());

		} catch (PortalException e) {
			_log.error(e);
			SessionErrors.add(request, "failed_submit");
		}
	}

	private String getNajmPlateNumber(String najmViewVehiclePlateNumber, String language) {
		if (najmViewVehiclePlateNumber != null && najmViewVehiclePlateNumber.contains(",")) {
			String[] plateNumbersEnAr = najmViewVehiclePlateNumber.split(",");
			if (language.equals("en_US"))
				return (plateNumbersEnAr[0]).trim();
			else
				return (plateNumbersEnAr[1]).trim();
		}

		return "";
	}

	private String getODSPlateNumber(String najmPlateNumber) {
		String odsPlateNumber = "";
		String[] plateNumberSplitted = najmPlateNumber.split(" ");
		if (plateNumberSplitted != null && plateNumberSplitted.length == 4)
			odsPlateNumber = plateNumberSplitted[1] + "-" + plateNumberSplitted[2] + "-" + plateNumberSplitted[3] + "-" + plateNumberSplitted[0];

		return odsPlateNumber;
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException {
		PortletSession pSession = resourceRequest.getPortletSession();
		NajmClaim najmClaimaint = (NajmClaim) pSession.getAttribute("najmClaimObj");
		String download = (String) resourceRequest.getParameter("download");

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);

		try {
			User user = PortalUtil.getUser(resourceRequest);
			Locale locale = new Locale("ar", "SA");// resourceRequest.getLocale()
			NajmClaimReportObj najmClaimReportObj = new NajmClaimReportObj();
			ODSClaimIntimation odsClaimInt = (ODSClaimIntimation) pSession.getAttribute("odsClaimIntObj");
			boolean isUserSignedIn = themeDisplay.isSignedIn();
			if (odsClaimInt.getTransaction().equals(ClaimIntimationPortletKeys.TRX_TPL)) {
				najmClaimReportObj.setClaimantName(najmClaimaint.getName());
				najmClaimReportObj.setClaimNo(odsClaimInt.getReferenceno());
				najmClaimReportObj.setPolicyNo(odsClaimInt.getPolicyno());
				najmClaimReportObj.setClaimAmount(odsClaimInt.getAmount());
				najmClaimReportObj.setDamageFlag(odsClaimInt.getDamageflag());
				String najmClaimantArPlateNumber = getNajmPlateNumber(najmClaimaint.getPlateNo(), "ar_SA");
				najmClaimReportObj.setPlateNoAr(getODSPlateNumber(najmClaimantArPlateNumber));

				if (!isUserSignedIn) {
					String email = (String) pSession.getAttribute("email");
					najmClaimReportObj.setClaimantEmail(email);
					najmClaimReportObj.setClaimantIqamaId(najmClaimaint.getCipiId());

				} else {
					najmClaimReportObj.setClaimantEmail(user.getEmailAddress());
					najmClaimReportObj.setClaimantIqamaId(user.getScreenName());
				}
				najmClaimReportObj.setClaimantPhoneNo(najmClaimaint.getPhoneNo());
				najmClaimReportObj.setInsuredDOb(odsClaimInt.getTpdob());
				najmClaimReportObj.setLossLocation(najmClaimaint.getCityDesAr());
				najmClaimReportObj.setLossDate(odsClaimInt.getLossdate());
				najmClaimReportObj.setReportType(LanguageUtil.get(locale, "claim_status_" + odsClaimInt.getReportmode()));
				najmClaimReportObj.setReportNo(odsClaimInt.getReportno());
				najmClaimReportObj.setFaultPercent(odsClaimInt.getFaultpercent());
				najmClaimReportObj.setLossRemarks(odsClaimInt.getLossremarks());
				najmClaimReportObj.setIban(odsClaimInt.getTpiban());
				najmClaimReportObj.setClaimDate((new Date()).toString());

				List<NajmClaimReportObj> najmClaimReportObjList = new ArrayList<>();
				najmClaimReportObjList.add(najmClaimReportObj);

				HashMap<String, Object> najmClaimParam = new HashMap<String, Object>();

				najmClaimParam.put("reportTitle", LanguageUtil.get(locale, "report_title"));
				najmClaimParam.put("claimNo", LanguageUtil.get(locale, "claim_no"));
				najmClaimParam.put("firstReportHeader", LanguageUtil.get(locale, "first_report_header"));
				najmClaimParam.put("firstReportTip", LanguageUtil.get(locale, "first_report_tip"));
				najmClaimParam.put("policyNo", LanguageUtil.get(locale, "policy_no"));
				najmClaimParam.put("compensationAmount", LanguageUtil.get(locale, "compensation_amount"));
				najmClaimParam.put("currency", LanguageUtil.get(locale, "currency"));
				najmClaimParam.put("claimType", LanguageUtil.get(locale, "claim_type"));
				najmClaimParam.put("car", LanguageUtil.get(locale, "car"));
				najmClaimParam.put("injuries", LanguageUtil.get(locale, "injuries"));
				najmClaimParam.put("fire", LanguageUtil.get(locale, "fire"));
				najmClaimParam.put("poperties", LanguageUtil.get(locale, "poperties"));
				najmClaimParam.put("deaths", LanguageUtil.get(locale, "deaths"));
				najmClaimParam.put("others", LanguageUtil.get(locale, "others"));
				najmClaimParam.put("ownerName", LanguageUtil.get(locale, "owner_name"));
				najmClaimParam.put("ownerIqamaId", LanguageUtil.get(locale, "owner_iqama_id"));
				najmClaimParam.put("ownerEmail", LanguageUtil.get(locale, "owner_email"));
				najmClaimParam.put("ownerPhone", LanguageUtil.get(locale, "owner_phone"));
				najmClaimParam.put("postalCode", LanguageUtil.get(locale, "postal_code"));
				najmClaimParam.put("driverIqamaId", LanguageUtil.get(locale, "driver_iqama_id"));
				najmClaimParam.put("driverName", LanguageUtil.get(locale, "driver_name"));
				najmClaimParam.put("driverDob", LanguageUtil.get(locale, "drivers_age"));
				najmClaimParam.put("driverCarOwner", LanguageUtil.get(locale, "driver_car_owner"));
				najmClaimParam.put("yes", LanguageUtil.get(locale, "yes"));
				najmClaimParam.put("no", LanguageUtil.get(locale, "no"));
				najmClaimParam.put("secReportHeader", LanguageUtil.get(locale, "sec_report_header"));
				najmClaimParam.put("accLocation", LanguageUtil.get(locale, "acc_location"));
				najmClaimParam.put("accTime", LanguageUtil.get(locale, "acc_time"));
				najmClaimParam.put("pm", LanguageUtil.get(locale, "pm"));
				najmClaimParam.put("am", LanguageUtil.get(locale, "am"));
				najmClaimParam.put("reportMode", LanguageUtil.get(locale, "report_mode"));
				najmClaimParam.put("reportNo", LanguageUtil.get(locale, "report_no"));
				najmClaimParam.put("faultPercent", LanguageUtil.get(locale, "fault_percent"));
				najmClaimParam.put("plateNo", LanguageUtil.get(locale, "third_party_plate_no"));
				najmClaimParam.put("secReportTip", LanguageUtil.get(locale, "sec_report_tip"));
				najmClaimParam.put("reportIban", LanguageUtil.get(locale, "report_iban"));
				najmClaimParam.put("claimantPresented", LanguageUtil.get(locale, "claimant_presented"));
				najmClaimParam.put("carOwner", LanguageUtil.get(locale, "car_owner"));
				najmClaimParam.put("anotherPerson", LanguageUtil.get(locale, "another_person"));
				najmClaimParam.put("claimantIqamaId", LanguageUtil.get(locale, "claimant_iqama_id"));
				najmClaimParam.put("claimantMobile", LanguageUtil.get(locale, "claimant_mobile"));
				najmClaimParam.put("date", LanguageUtil.get(locale, "date"));
				najmClaimParam.put("signature", LanguageUtil.get(locale, "signature"));
				najmClaimParam.put("phoneNo", LanguageUtil.get(locale, "phone_no"));
				najmClaimParam.put("claimantName", LanguageUtil.get(locale, "claimant_name"));
				najmClaimParam.put("thirdReportHeader", LanguageUtil.get(locale, "third_report_header"));
				najmClaimParam.put("thirdReportTip", LanguageUtil.get(locale, "third_report_tip"));
				najmClaimParam.put("fourthReportTip", LanguageUtil.get(locale, "fourth_report_tip"));
				najmClaimParam.put("najm", LanguageUtil.get(locale, "najm_status_3"));

				najmClaimParam.put("claimantEmail", najmClaimReportObj.getClaimantEmail());
				najmClaimParam.put("claimantPhoneNo", najmClaimReportObj.getClaimantPhoneNo());
				najmClaimParam.put("iban", najmClaimReportObj.getIban());

				_log.info(najmClaimReportObjList.get(0).getClaimNo());
				_log.info(najmClaimReportObjList.get(0).getPolicyNo());
				resourceResponse.setContentType("application/pdf");
				if (download != null && download.equals("false"))
					resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + "claimTPL.pdf" + "\"");
				else
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + "claimTPL.pdf" + "\"");
				ReportsUtil.fillAndExportPDFReport("claimTPL.jasper", najmClaimReportObjList, najmClaimParam, resourceResponse.getPortletOutputStream());
			} else {

				Policy policyData = PolicyLocalServiceUtil.findPolicyByPolicyNo(najmClaimaint.getPolNo());

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
				ClaimODReportObj odReportObj = new ClaimODReportObj();
				if (policyVehs != null && !policyVehs.isEmpty()) {
					PolicyVEH policyVeh = policyVehs.get(0);
					if (lang.equals("en_US")) {
						odReportObj.setMake(policyVeh.getMakeDescEn());
					} else {
						odReportObj.setMake(policyVeh.getMakeDescAr());
					}
					odReportObj.setMfgYr(policyVeh.getMfgYear());

				} else {
					odReportObj.setMake("");
					odReportObj.setMfgYr(null);
				}
				odReportObj.setPolicyNo(odsClaimInt.getPolicyno());
				if (!isUserSignedIn) {
					String email = (String) pSession.getAttribute("email");
					odReportObj.setInsuredEmail(email);

				} else {
					odReportObj.setInsuredEmail(user.getEmailAddress());
				}
				odReportObj.setInsuredName(najmClaimaint.getName());
				odReportObj.setInsuredMobNo(najmClaimaint.getPhoneNo());

				odReportObj.setPlateNo(odsClaimInt.getVehidentivalue());
				SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
				odReportObj.setExpiryDate(dateFormatter.format(policyData.getExpiryDate()));
				SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yy hhmm");
				Date accDate = sdf.parse(najmClaimaint.getCallDt());
				SimpleDateFormat formate = new SimpleDateFormat("hh:mm a");
				String accTime = formate.format(accDate);
				_log.info(formate.format(accDate));
				odReportObj.setAccidentDate(najmClaimaint.getCallDt().split(" ")[0]);
				odReportObj.setAccidentTime(accTime.split(" ")[0]);
				odReportObj.setAccidentCity(najmClaimaint.getCityDesEN());
				odReportObj.setTimeGroup(accTime.split(" ")[1]);

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
				resourceResponse.setContentType("application/pdf");

				if (download != null && download.equals("false"))
					resourceResponse.addProperty(HttpHeaders.CONTENT_DISPOSITION, "inline; filename=\"" + "NajmODClaim.pdf" + "\"");
				else
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + "NajmODClaim.pdf" + "\"");

				ReportsUtil.fillAndExportPDFReport("ClaimODReport.jasper", claimReportObjList, null, resourceResponse.getPortletOutputStream());
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
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

}