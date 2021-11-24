package buy.motor.policy.portlet;

import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;
import com.atmc.bsl.db.service.ClaimLocalServiceUtil;
import com.atmc.bsl.db.service.CustomerVehicleDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.bsl.db.service.UserMgmtLocalServiceUtil;
import com.atmc.bsl.db.service.impl.QuotationLocalServiceImpl;
import com.atmc.web.common.NotificationTypes.Type;
import com.atmc.web.constants.PolicyListPortletKeys;
import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.exception.NoSuchCodeMasterException;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.QuotationCovers;
import com.ejada.atmc.acl.db.model.QuotationDrivers;
import com.ejada.atmc.acl.db.model.QuotationStatusHistory;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.db.model.QuotationsDriverLicense;
import com.ejada.atmc.acl.db.model.QuotationsUserAddress;
import com.ejada.atmc.acl.db.service.CodeMasterLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.CustUploadsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationCoversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationDriversLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationStatusHistoryLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsDriverLicenseLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsUserAddressLocalServiceUtil;
import com.ejada.atmc.acl.db.service.persistence.QuotationCoversPK;
import com.ejada.atmc.acl.ws.domain.ConfirmOLPPayment;
import com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse;
import com.ejada.atmc.acl.ws.service.OLPPaymentLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.ejada.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationCover;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriverLicense;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationUserAddress;
import com.ejada.atmc.utils.api.ReportsUtil;
import com.google.gson.Gson;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.UserEmailAddressException;
import com.liferay.portal.kernel.io.ByteArrayFileInputStream;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.PortletURLFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.LayoutLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Hex;
import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

import buy.motor.policy.constants.BuyMotorPolicyPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=true", 
		"javax.portlet.display-name=ATMC Buy Motor Policy Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/landing.jsp",
		"javax.portlet.name=" + BuyMotorPolicyPortletKeys.BUYMOTORPOLICY,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	}, 
	service = Portlet.class
)
public class BuyMotorPolicyPortlet extends MVCPortlet {

	private SimpleDateFormat	dateFormatter							= new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat	dateFormat								= new SimpleDateFormat("yyyy-MM-dd");
	private SimpleDateFormat	dateFormattimestamp						= new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
	private static final Log	_log									= LogFactoryUtil.getLog(BuyMotorPolicyPortlet.class);
	public static final int		YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED	= 999999;
	public static final String	YAKEEN_INSURED_GENDER_MALE				= "M";
	public static final String	YAKEEN_INSURED_GENDER_FEMALE			= "F";
	public static final int		INSURED_GENDER_MALE						= 1;
	public static final int		INSURED_GENDER_FEMALE					= 2;
	public static final int		TARIFF_QUICKQUOTE_COLOR					= 25244;
	public static final String	PAYFORT_REF_STATUS						= "I";
	public static final String	PAYFORT_REF_STATUS_COMP					= "C";
	public static final int		VEH_VALUE								= 20000;

	public void personalInfo(ActionRequest request, ActionResponse response) throws PortalException, ParseException {
		String myview = request.getParameter("myview");
		if (myview == null)
			return;
		request.setAttribute("countries", QuotationLocalServiceUtil.getCountries());
		request.setAttribute("educationList", QuotationLocalServiceUtil.getEducationList());
		boolean isBack = ParamUtil.getBoolean(request, "isBack");
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isUserSignedIn = themeDisplay.isSignedIn();
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		PortletSession pSession = request.getPortletSession();
		if (ParamUtil.getBoolean(request, "missingRenewParams")) {
			Quotation quot = (Quotation) request.getPortletSession().getAttribute("quot");
			request.setAttribute("quot", quot);
			String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
			quotDets = quotDets.replaceAll("\"", "'");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			pSession.setAttribute("quotHash", quotHash);
			request.getPortletSession().removeAttribute("quot");
			return;
		}

		if (isBack) {
			String quotDets = ParamUtil.getString(request, "quot");

			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}

			Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
			request.setAttribute("quot", quot);
			pSession.setAttribute("quotHash", quotHash);
			return;
		} else if (isUserSignedIn) {
			try {
				int maxQuoteSize = (PropsUtil.get("user.max.quote.limit") != null) ? Integer.parseInt(PropsUtil.get("user.max.quote.limit")) : 10;
				long iqamaId = Long.parseLong(PortalUtil.getUser(request).getScreenName());
				List<Quotation> quotsList = QuotationLocalServiceUtil.getQuotationsByIqamaId(iqamaId);
				if (quotsList != null && quotsList.size() >= maxQuoteSize) {
					request.setAttribute(BuyMotorPolicyPortletKeys.MAX_QUOTE_ERROR, true);
					request.setAttribute(BuyMotorPolicyPortletKeys.MAX_QUOTE_ERROR_MESSAGE, LanguageUtil.get(httpRequest, "max_quote_limit"));
					request.setAttribute("myview", "landing");

					return;
				}
			} catch (NumberFormatException | PortalException e) {
				_log.error(e.getMessage());
				_log.error(e.getMessage(), e);
			}
		}

		String vehicleIdentifier = request.getParameter("vehType");
		String iqamaId = "";
		String oldIqamaId = "";
		String mobileNo = "";
		String email = "";
		String dobG = "";
		String dobH = "";
		boolean isMainDriver = true;
		String mfgYear = "";
		String vehSeqNo = "";

		_log.info("submit personal");
		_log.info("Vehicle Identifier " + vehicleIdentifier);
		if (vehicleIdentifier.equals(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)) {
			iqamaId = request.getParameter("IstIqamaId");
			isMainDriver = Boolean.parseBoolean(request.getParameter("IstMainDriver"));
			vehSeqNo = request.getParameter("IstVehSeqNo");
			dobG = request.getParameter("IstDobG");
			dobH = request.getParameter("IstDobH");
			email = request.getParameter("IstEmail");
			mobileNo = request.getParameter("IstMobileNo");
		} else if (vehicleIdentifier.equals(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD)) {
			iqamaId = request.getParameter("CustIqamaId");
			isMainDriver = Boolean.parseBoolean(request.getParameter("CustMainDriver"));
			vehSeqNo = request.getParameter("CustCardNo");
			mfgYear = request.getParameter("CustMfgYear");
			dobG = request.getParameter("CustDobG");
			dobH = request.getParameter("CustDobH");
			email = request.getParameter("CustEmail");
			mobileNo = request.getParameter("CustMobileNo");
		} else if (vehicleIdentifier.equals(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD)) {
			iqamaId = request.getParameter("newIqamaId");
			oldIqamaId = request.getParameter("oldIqamaId");
			isMainDriver = Boolean.parseBoolean(request.getParameter("TransMainDriver"));
			vehSeqNo = request.getParameter("TransVehSeqNo");
			dobG = request.getParameter("TransDobG");
			dobH = request.getParameter("TransDobH");
			email = request.getParameter("TransEmail");
			mobileNo = request.getParameter("TransMobileNo");
		}
		Pattern numberPattern = Pattern.compile("^[0-9]+$");
		Pattern emailPattern = Pattern.compile("^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@" + "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$");
		Pattern mobilePattern = Pattern.compile("(^05)([0-9]{8})");

		if (numberPattern.matcher(iqamaId).find() && iqamaId.length() == 10 && numberPattern.matcher(vehSeqNo).find() && mobilePattern.matcher(mobileNo).find() && emailPattern.matcher(email).find()) {

			List<PolicyHDR> odsPolicyList;
			List<Quotations> quotationMbl;

			_log.info("Insured Mobile No: " + mobileNo);
			String currLocale = themeDisplay.getLocale().toString();

			Quotation quot = new Quotation();
			quot.setSource("01");
			quot.setVehicleIdType(Long.parseLong(vehicleIdentifier));

			quot.setInsuredId(Long.parseLong(iqamaId));

			odsPolicyList = PolicyHDRLocalServiceUtil.findByinsuredMobileNo(mobileNo);
			quotationMbl = QuotationsLocalServiceUtil.findByinsuredMobile(Long.parseLong(mobileNo));
			quot.setInsuredMobile(mobileNo);

			quot.setInsuredDobH(dobH);
//			quot.setProductCode(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE);
			quot.setProductCode(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL);
			quot.setMainDriver(isMainDriver);
			/*
			 * SimpleDateFormat fmt = new SimpleDateFormat("dd-M-yyyy"); Date date = fmt.parse("11-06-2019");
			 */
			quot.setVehicleId(Long.parseLong(vehSeqNo));

			if (vehicleIdentifier.equals(BuyMotorPolicyPortletKeys.VEHICLE_TRANSFER_OWNERSHIP_CARD))
				quot.setOldIqamaId(oldIqamaId);
			if (vehicleIdentifier.equals(BuyMotorPolicyPortletKeys.VEHICLE_CUSTOM_CARD))
				quot.setVehicleMfgYear(Integer.parseInt(mfgYear));
			quot.setInsuredDob(dateFormat.parse(dobG));

			quot.setInsuredEmail(email);
			/*-------------------------Change Start ----------------------*/
			if (quotationMbl != null)
				for (Quotations q : quotationMbl) {
					if (!String.valueOf(q.getInsuredId()).equals(iqamaId)) {
						_log.info("mobile number already exists ");
						request.setAttribute("myview", "landing");
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
								LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "mobile_number_already_exists"));
						request.setAttribute("quot", quot);
						return;
					}
				}

			if (odsPolicyList != null)
				for (PolicyHDR odsPolicylist : odsPolicyList) {
					if (!String.valueOf(odsPolicylist.getInsuredMobile()).equals(mobileNo)) {
						_log.info("mobile number already exists with policy ");
						request.setAttribute("myview", "landing");
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
								LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "mobile_number_already_exists"));
						request.setAttribute("quot", quot);
						return;
					}
				}

			/*-------------------------Change END ----------------------*/
			Calendar ageCal = new GregorianCalendar();
			ageCal.setTime(quot.getInsuredDob());
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			int currentYear = cal.get(Calendar.YEAR);
			int birthYear = ageCal.get(Calendar.YEAR);
			if (currentYear - birthYear < 16 || currentYear - birthYear > 99) {
				request.setAttribute("myview", "landing");
				request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
				request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
						LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "age_limit_err"));
				request.setAttribute("quot", quot);
				String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);

				return;
			}

			if (isUserSignedIn) {
				User user = themeDisplay.getUser();
				Company company = PortalUtil.getCompany(request);
				if (!quot.getInsuredEmail().equals(user.getEmailAddress())) {
					request.setAttribute("myview", "landing");
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
							LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "email_not_match_eprofile"));
					request.setAttribute("quot", quot);
					String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
					quotDets = quotDets.replaceAll("\"", "'");
					String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					pSession.setAttribute("quotHash", quotHash);

					return;
				}
				/*-------------------------Change Start ----------------------*/
				if (quot.getVehicleIdType() == Long.parseLong(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)) {
					long sTime = System.currentTimeMillis();
					long checkPolicyResult = QuotationLocalServiceUtil.checkExistingPolicy("" + quot.getInsuredId(), "" + quot.getVehicleId());
					long period = System.currentTimeMillis() - sTime;
					_log.info("checkExistingPolicy took " + period + " ms");
					_log.info("checkPolicyResult:" + checkPolicyResult);
					if (checkPolicyResult == QuotationLocalServiceImpl.RENEWABLE_POLICY_EXISTS) {
						_log.info("checkPolicyResult = RENEWABLE_POLICY_EXISTS");
						user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), "" + quot.getInsuredId());
						if (user != null) {
							_log.info("userRegistered true");
							request.setAttribute("myview", "landing");
							request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
							request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
									LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "renewal_policy_exists_msg"));
							request.setAttribute("quot", quot);
							return;
						}

					}
					if (checkPolicyResult == 0) {
						_log.info("checkPolicyResult = 0");
						long s2Time = System.currentTimeMillis();
						PolicyHDR activePolicy = QuotationLocalServiceUtil.checkActivePolicy("" + quot.getInsuredId(), "" + quot.getVehicleId());
						long period2 = System.currentTimeMillis() - s2Time;
						_log.info("checkActivePolicy took " + period2 + " ms");

						if (activePolicy != null) {
							request.setAttribute("myview", "landing");
							Calendar expCal = new GregorianCalendar();
							expCal.setTime(activePolicy.getExpiryDate());
							expCal.add(Calendar.DAY_OF_YEAR, -30);
							SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");
							request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
							request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
									LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "non_exp_policy_err") + " <b>"
											+ dateFormatter.format(expCal.getTime()) + "</b>.");
							request.setAttribute("quot", quot);
							return;
						}
					}

				}
			} else {
				_log.info("isUserSignedIn false");
				Company company = PortalUtil.getCompany(request);
				User user = UserLocalServiceUtil.fetchUserByEmailAddress(company.getCompanyId(), quot.getInsuredEmail());
				if (user != null && !user.getScreenName().equals("" + quot.getInsuredId())) {
					request.setAttribute("myview", "landing");
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE,
							LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "email_already_reg"));
					request.setAttribute("quot", quot);
					String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
					quotDets = quotDets.replaceAll("\"", "'");
					String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					pSession.setAttribute("quotHash", quotHash);

					return;
				}

				_log.info("Quot vehicle" + quot.getVehicleIdType());
				if (quot.getVehicleIdType() == Long.parseLong(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)) {
					long sTime = System.currentTimeMillis();
					long checkPolicyResult = QuotationLocalServiceUtil.checkExistingPolicy("" + quot.getInsuredId(), "" + quot.getVehicleId());
					long period = System.currentTimeMillis() - sTime;
					_log.info("checkExistingPolicy took " + period + " ms");
					_log.info("checkPolicyResult:" + checkPolicyResult);
					if (checkPolicyResult == QuotationLocalServiceImpl.RENEWABLE_POLICY_EXISTS) {
						_log.info("checkPolicyResult = RENEWABLE_POLICY_EXISTS");
						user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), "" + quot.getInsuredId());
						if (user != null) {
							_log.info("userRegistered true");
							request.setAttribute("myview", "landing");
							request.setAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR, true);
							request.setAttribute("userRegistered", true);
							request.setAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR_MESSAGE,
									LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "email_already_reg"));
							request.setAttribute("quot", quot);
							String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
							quotDets = quotDets.replaceAll("\"", "'");
							String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
							pSession.setAttribute("quotHash", quotHash);

							return;
						} else {
							_log.info("userRegistered false");
							request.setAttribute("myview", "landing");
							request.setAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR, true);
							request.setAttribute("userRegistered", false);
							request.setAttribute(BuyMotorPolicyPortletKeys.RENEWABLE_POLICY_EXISTS_ERROR_MESSAGE,
									LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "email_already_reg"));
							request.setAttribute("quot", quot);
							String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
							quotDets = quotDets.replaceAll("\"", "'");
							String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
							pSession.setAttribute("quotHash", quotHash);

							return;
						}
					} else if (checkPolicyResult == 0) {
						_log.info("checkPolicyResult = 0");
						long s2Time = System.currentTimeMillis();
						PolicyHDR activePolicy = QuotationLocalServiceUtil.checkActivePolicy("" + quot.getInsuredId(), "" + quot.getVehicleId());
						long period2 = System.currentTimeMillis() - s2Time;
						_log.info("checkActivePolicy took " + period2 + " ms");

						if (activePolicy != null) {
							request.setAttribute("myview", "landing");
							request.setAttribute(BuyMotorPolicyPortletKeys.POLICY_EXISTS_ERROR, true);

							Calendar expCal = new GregorianCalendar();
							expCal.setTime(activePolicy.getExpiryDate());
							expCal.add(Calendar.DAY_OF_YEAR, -30);
							SimpleDateFormat dateFormatter = new SimpleDateFormat("MMMM dd, yyyy");

							request.setAttribute(BuyMotorPolicyPortletKeys.POLICY_EXISTS_ERROR_MESSAGE,
									LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request)), "non_exp_policy_err") + " <b>"
											+ dateFormatter.format(expCal.getTime()) + "</b>.");
							request.setAttribute("quot", quot);
							String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
							quotDets = quotDets.replaceAll("\"", "'");
							String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
							pSession.setAttribute("quotHash", quotHash);

							return;
						}
					}
				}

			}

			try {
				Locale local = themeDisplay.getLocale();
				long startTime = System.currentTimeMillis();
				_log.info("Yakeen service called from BuyMotorPolicyPortlet  ::::::: " + quot.toString());
				quot = CustomerVehicleDetailsLocalServiceUtil.getCustomerVehicleDetails(quot, currLocale.toString().equals("en_US") ? "E" : "E", local);
				long allYakeenPeriod = System.currentTimeMillis() - startTime;
				_log.info("getCustomerVehicleDetails took " + allYakeenPeriod + " ms");
				if (!isUserSignedIn) {
					long sTime = System.currentTimeMillis();
					boolean isLoyalty = PolicyHDRLocalServiceUtil.checkLoyalty(iqamaId, vehSeqNo, new Date());
					long period = System.currentTimeMillis() - sTime;
					_log.info("checkLoyalty took " + period + " ms");
					if (isLoyalty)
						quot.setLoyaltyDiscountFlag(1);
				} else
					quot.setLoyaltyDiscountFlag(0);

				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
				File leaseFile = uploadPortletRequest.getFile("leaseFile");

				/*
				 * HashSet<String> acceptedTypes = new HashSet<>(); acceptedTypes.add("application/pdf");
				 * acceptedTypes.add("image/png"); acceptedTypes.add("image/jpg"); acceptedTypes.add("image/jpeg"); acceptedTypes.add(
				 * "application/vnd.openxmlformats-officedocument.wordprocessingml.document"); //docx
				 * acceptedTypes.add("application/msword"); //doc
				 */

				String uploadDir = PropsUtil.get("policy.upload.dir");
				_log.info("Upload Dir:" + uploadDir);

				String userId = (themeDisplay.isSignedIn()) ? PortalUtil.getUser(request).getScreenName() : iqamaId;
				if (leaseFile == null || !leaseFile.exists()) {
					_log.info("Lease File is Empty");
				} else if ((leaseFile != null) && leaseFile.exists()) {
					_log.info("We have lease file");
					_log.info("Lease File:" + leaseFile.getName());
					_log.info("Lease File Length:" + leaseFile.length());

//					boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.isAcceptedFileType(leaseFile, acceptedTypes);
					boolean isFileTypeAccepted;
					try {
						isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(leaseFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
					} catch (Exception e1) {
						// Auto-generated catch block
						SessionErrors.add(request, "invalid_file_name");
						return;
					}
					boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(leaseFile);

					if (isFileTypeAccepted && !isFileExecutable) {
						try {
							_log.info("Lease file is accepted");
							String originalFileName = uploadPortletRequest.getFileName("leaseFile");
							_log.info("originalFileName:" + originalFileName);
							ByteArrayFileInputStream inputStream = new ByteArrayFileInputStream(leaseFile, 1024);
							byte[] idData = FileUtil.getBytes(inputStream);

							_log.info("Lease file size bytes:" + idData.length);

							File destFolder = new File(uploadDir + "/" + userId);
							if (!destFolder.exists())
								destFolder.mkdirs();

							_log.info("Dest Folder:" + destFolder.getAbsolutePath());
							_log.info(uploadDir + "/" + userId + "/" + originalFileName);

							FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
							out.write(idData);
							out.close();

							quot.setLeaseFileName(originalFileName);

							_log.info(" End Lease");
						} catch (IOException e) {
							_log.error(e.getMessage());
							_log.error(e.getMessage(), e);
						}
					}
				}

				request.setAttribute("quot", quot);
				String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);

				// long vehMfgYear = quot.getVehicleMfgYear();
				/*
				 * if(quot.getProductCode().equals(BuyMotorPolicyPortletKeys. PRODUCT_CODE_COMPREHENSIVE) && currentYear > vehMfgYear &&
				 * (currentYear - vehMfgYear >= 10)) { request.setAttribute("myview", "landing"); //SessionErrors.add(request,
				 * BuyMotorPolicyPortletKeys.ERROR_OLD_VEHICLE_YEAR); request.setAttribute(BuyMotorPolicyPortletKeys.YAQEEN_ERROR,true);
				 * request.setAttribute(BuyMotorPolicyPortletKeys.YAQEEN_MESSAGE,
				 * LanguageUtil.get(PortalUtil.getOriginalServletRequest(PortalUtil. getHttpServletRequest(request)), "old_veh_mfg")); }
				 */
				// request.setAttribute("countries", QuotationLocalServiceUtil.getCountries());
			} catch (YaqeenException e) {
				request.setAttribute("quot", quot);
				String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);

				// SessionErrors.add(request, e.getClass());
				request.setAttribute("myview", "landing");
				// SessionErrors.add(request, BuyMotorPolicyPortletKeys.ERROR_OLD_VEHICLE_YEAR);
				request.setAttribute(BuyMotorPolicyPortletKeys.YAQEEN_ERROR, true);
				String msg = e.getMessage();
				if (e.getErrorCode() == YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED)
					msg = LanguageUtil.get(httpRequest, "yakeen_error_" + YAKEEN_ERROR_CODE_NO_ADDRESS_RETURNDED);
				request.setAttribute(BuyMotorPolicyPortletKeys.YAQEEN_MESSAGE, msg);

				_log.error(e.getMessage(), e);
			} catch (NajmException e) {
				request.setAttribute("quot", quot);
				String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);

				request.setAttribute("myview", "landing");
				request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
				String msg = e.getMessage();
				request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE, msg);

				_log.error(e.getMessage(), e);
			}
		} else
			_log.error("One or some of the parameters are invalid");
	}

	public void addDiver(ActionRequest request, ActionResponse response) {
		String myview = request.getParameter("myview");
		if (myview == null)
			return;
		PortletSession pSession = request.getPortletSession();
		request.setAttribute("educationList", QuotationLocalServiceUtil.getEducationList());
		request.setAttribute("countries", QuotationLocalServiceUtil.getCountries());
		request.setAttribute("licTypes", QuotationLocalServiceUtil.getLicenseTypes());
		request.setAttribute("cities", QuotationLocalServiceUtil.getCities());
		String quotDets = ParamUtil.getString(request, "quot");

		String quotHashChk = (String) pSession.getAttribute("quotHash");
		String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
		if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
			// request.getPortletSession().invalidate();
			request.setAttribute("myview", "landing");
			return;
		}

		Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
		request.setAttribute("quot", quot);
		pSession.setAttribute("quotHash", quotHash);

		String drvDets = ParamUtil.getString(request, "driver", null);
		if (drvDets != null && !drvDets.equals("")) {
			drvDets = drvDets.replaceAll("#", ",");
			QuotationDriver driver = (QuotationDriver) GsonUtilsLocalServiceUtil.fromGson(drvDets, QuotationDriver.class);
			request.setAttribute("driver", driver);
		}

	}

	public void landing(ActionRequest request, ActionResponse response) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		boolean isUserSignedIn = themeDisplay.isSignedIn();
		boolean isBack = ParamUtil.getBoolean(request, "isBack");
		PortletSession pSession = request.getPortletSession();
		if (isBack) {
			String quotDets = (String) ParamUtil.getString(request, "quot");

			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}

			Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
			if (quot.isRenew() && quot.getExistingCompanyName() != null && quot.getExistingCompanyName().equals("0240000036") && quot.getExistingPolicyNo() != null) {
				try {
					Policy policy = PolicyLocalServiceUtil.findPolicyByPolicyNo(quot.getExistingPolicyNo());
					PolicyVehicle customVeh = null;
					if (policy.getPolicyVehs() != null && !policy.getPolicyVehs().isEmpty()) {
						for (PolicyVehicle pVeh : policy.getPolicyVehs()) {
							if (pVeh.getVehicleSeqCustom() != null && pVeh.getVehicleSeqCustom().equals("" + quot.getVehicleId()))
								customVeh = pVeh;
						}
					}
					if (policy != null && customVeh != null) {
						String policiesPortletId = PolicyListPortletKeys.POLICYLIST;
						long policiesPlid = 0L;
						try {
							String pageName = "/policies";
							Layout policiesPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName);
							LayoutTypePortlet policiesLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(policiesPortletLayout);
							policiesPortletId = policiesLayoutTypePortlet.getPortletIds().get(0);
							policiesPlid = policiesPortletLayout.getPlid();

							request.getPortletSession().setAttribute("policyDetails", policy, PortletSession.APPLICATION_SCOPE);
							request.getPortletSession().setAttribute("vehicleDetails", customVeh, PortletSession.APPLICATION_SCOPE);

							PortletURL detailsUrl = PortletURLFactoryUtil.create(request, policiesPortletId, policiesPlid, PortletRequest.ACTION_PHASE);
							detailsUrl.setWindowState(WindowState.NORMAL);
							detailsUrl.setPortletMode(PortletMode.VIEW);
							detailsUrl.setParameter(ActionRequest.ACTION_NAME, "policyDetails");
							detailsUrl.setParameter("buyMotorRedirect", "true");
							detailsUrl.setParameter("myview", "motor_policy_dets");
							response.sendRedirect(detailsUrl.toString());
							return;
						} catch (Exception ex) {
							ex.printStackTrace();
						}
					}
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				}
			}
			request.setAttribute("quot", quot);
			quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
			quotDets = quotDets.replaceAll("\"", "'");
			quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			pSession.setAttribute("quotHash", quotHash);
		} else if (isUserSignedIn) {
			try {
				int maxQuoteSize = (PropsUtil.get("user.max.quote.limit") != null) ? Integer.parseInt(PropsUtil.get("user.max.quote.limit")) : 10;
				long iqamaId = Long.parseLong(PortalUtil.getUser(request).getScreenName());
				List<Quotation> quotsList = QuotationLocalServiceUtil.getQuotationsByIqamaId(iqamaId);
				if (quotsList != null && quotsList.size() > maxQuoteSize) {
					hideDefaultErrorMessage(request);
					SessionErrors.add(request, BuyMotorPolicyPortletKeys.ERROR_USER_MAX_QUOTE_LIMIT_EXCEEDED);
				}
			} catch (NumberFormatException | PortalException e) {
				_log.error(e.getMessage());
				_log.error(e.getMessage(), e);
			}
		}
	}

	public void vehicleInfo(ActionRequest request, ActionResponse response) throws NoSuchCodeMasterException {
		String myview = request.getParameter("myview");
		if (myview == null)
			return;
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		httpRequest.getSession().removeAttribute("QUOTE_SAVED");
		PortletSession pSession = request.getPortletSession();

		request.setAttribute("insCompanies", CodeMasterLocalServiceUtil.findByCode("INS_CO"));
		request.setAttribute("cities", QuotationLocalServiceUtil.getCities());
		request.setAttribute("purposeList", QuotationLocalServiceUtil.getPurposeOfVehicle());
		request.setAttribute("dedVals", QuotationLocalServiceUtil.getDeductibleValues());
		request.setAttribute("parkLocs", QuotationLocalServiceUtil.getParkingLocations());
		request.setAttribute("engineSizes", QuotationLocalServiceUtil.geEngineSizes());
		boolean isBack = ParamUtil.getBoolean(request, "isBack");
		if (isBack) {
			String quotDets = (String) ParamUtil.getString(request, "quot");

			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}

			Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
			request.setAttribute("quot", quot);
			pSession.setAttribute("quotHash", quotHash);
			return;
		}

		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		ByteArrayFileInputStream inputStream = null;
		String quotDets = (String) ParamUtil.getString(request, "quot");

		String quotHashChk = (String) pSession.getAttribute("quotHash");
		String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
		if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
			// request.getPoserrtletSession().invalidate();
			request.setAttribute("myview", "landing");
			return;
		}

		Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
		try {
			String reason = Encode.forHtmlContent(ParamUtil.getString(request, "reason"));
			String education = ParamUtil.getString(request, "education");
			String maritalStatus = ParamUtil.getString(request, "maritalStatus");
			int childUnder16 = ParamUtil.getInteger(request, "childUnder16");
			String[] quotDrivers = ParamUtil.getStringValues(request, "quotDrivers");
			boolean underAgeDriver = Boolean.parseBoolean(request.getParameter("underAgeDriver"));
			quot.setInsuredEducation(education);
			quot.setInsuredMaritalStatus(maritalStatus);
			quot.setInsuredNoChildUnder16(childUnder16);
			quot.setUnderAgeDriver(underAgeDriver);
			if (reason != null)
				quot.setDriverAdditionReason(reason);

			if (quotDrivers != null) {
				quot.getQuotationDrivers().clear();
				for (int dCount = 0; dCount < quotDrivers.length; dCount++) {
					String drvDets = quotDrivers[dCount].replaceAll("#", ",");
					QuotationDriver quotDriver = (QuotationDriver) GsonUtilsLocalServiceUtil.fromGson(drvDets, QuotationDriver.class);
					quot.getQuotationDrivers().add(quotDriver);
				}
			}
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			File copyIdFile = uploadPortletRequest.getFile("idFile");
			File copyLicenseFile = uploadPortletRequest.getFile("licenseFile");

			String uploadDir = PropsUtil.get("policy.upload.dir");
			String userId = ((themeDisplay.isSignedIn())) ? PortalUtil.getUser(request).getScreenName() : ("" + quot.getInsuredId());
			if (copyIdFile == null || !copyIdFile.exists()) {
				_log.info("ID is Empty File");
			} else if ((copyIdFile != null) && copyIdFile.exists()) {
//					boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(copyIdFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(copyIdFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(copyIdFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("idFile");

					inputStream = new ByteArrayFileInputStream(copyIdFile, 1024);
					byte[] idData;
					idData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(idData);
					out.close();

					quot.setIdFileName(originalFileName);
				}
			}

			if (copyLicenseFile == null || !copyLicenseFile.exists()) {
				_log.info("License is Empty File");
			} else if ((copyLicenseFile != null) && copyLicenseFile.exists()) {
//					boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(copyLicenseFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(copyLicenseFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(copyLicenseFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("licenseFile");

					inputStream = new ByteArrayFileInputStream(copyLicenseFile, 1024);
					byte[] licData;
					licData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(licData);
					out.close();

					quot.setLicenseFileName(originalFileName);
				}
			}
			request.setAttribute("quot", quot);
			quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
			quotDets = quotDets.replaceAll("\"", "'");
			quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			pSession.setAttribute("quotHash", quotHash);
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		} finally {
			try {
				com.liferay.petra.io.StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		_log.info("Submitting Vehicle Info");
	}

	public void insuranceOptions(ActionRequest request, ActionResponse response) {
		String myview = request.getParameter("myview");
		if (myview == null)
			return;
		boolean isBack = ParamUtil.getBoolean(request, "isBack");
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		PortletSession pSession = request.getPortletSession();
		if (isBack) {
			String quotDets = (String) ParamUtil.getString(request, "quot");
			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}
			Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
			request.setAttribute("quot", quot);
			pSession.setAttribute("quotHash", quotHash);
			request.setAttribute("coverList", QuotationLocalServiceUtil.getCoverList(quot.getProductCode()));
			request.setAttribute("dedVals", QuotationLocalServiceUtil.getDeductibleValues());
			httpRequest.getSession().removeAttribute("QUOTE_SAVED");
			return;
		}
		ByteArrayFileInputStream inputStream = null;
		try {
			UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
			String quotDets = (String) ParamUtil.getString(request, "quot");

			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}
			Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
			String vPurpose = ParamUtil.getString(request, "vPurpose");
			boolean accDeath = Boolean.parseBoolean(request.getParameter("accDeath"));
			boolean vehMotorAcc = Boolean.parseBoolean(request.getParameter("vehMotorAcc"));
			boolean convTraffViols = Boolean.parseBoolean(request.getParameter("convTraffViols"));
			String insCo = ParamUtil.getString(request, "InsCo");
			String insPolicyNo = ParamUtil.getString(request, "InsPolicyNo");
			String insExp = ParamUtil.getString(request, "InsExp");
			String vehVal = ParamUtil.getString(request, "vValue");
			String repairOptions = ParamUtil.getString(request, "repairOptions");
			String dedValue = ParamUtil.getString(request, "dedValue", null);
			Pattern pattern = Pattern.compile("^[0-9]+$");

			if (quot.getVehicleIdType() != Long.parseLong(BuyMotorPolicyPortletKeys.VEHICLE_ISTIMARA_CARD)) {
				String vehicleCity = ParamUtil.getString(request, "city");
				if (vehicleCity != null)
					quot.setVehicleCity(vehicleCity);
			}
			String addressCityCode = ParamUtil.getString(request, "addressCityCode");
			if ((quot.getCity() == null || quot.getCity().equals("")) && addressCityCode != null && !addressCityCode.equals(""))
				quot.setCity(addressCityCode);

			if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE)) {
				if (pattern.matcher(vehVal).find()) {
					if (Integer.parseInt(vehVal) < VEH_VALUE) {
						quot.setVehicleValue(VEH_VALUE);
					} else {
						quot.setVehicleValue(Integer.parseInt(vehVal));
					}
				} else
					_log.error("Invalid vehVal");

				if (pattern.matcher(dedValue).find())
					quot.setDeductibleValue(dedValue);
				else
					_log.error("Invalid dedValue");

				quot.setAgencyRepair(repairOptions);
			}

			if (!quot.isRenew()) {
				Calendar cal = new GregorianCalendar();
				cal.setTime(new Date());
				// cal.add(Calendar.DAY_OF_YEAR, 1);
				cal.add(Calendar.DAY_OF_YEAR, 1);
				Date effDate = cal.getTime();
				quot.setPolicyEffDate(effDate);
			}
			// set policy expiry date
			Calendar calTO = new GregorianCalendar();
			calTO.setTime(quot.getPolicyEffDate());
			calTO.add(Calendar.YEAR, 1);
			calTO.add(Calendar.YEAR, 1);
			calTO.add(Calendar.DAY_OF_YEAR, -1);
			Date policyExpDate = calTO.getTime();
			quot.setPolicyEffTo(policyExpDate);

			File custCardFile = uploadPortletRequest.getFile("custCardFile");
			File carFrontFile = uploadPortletRequest.getFile("carFrontFile");
			File carBackFile = uploadPortletRequest.getFile("carBackFile");
			File carLeftFile = uploadPortletRequest.getFile("carLeftFile");
			File carRightFile = uploadPortletRequest.getFile("carRightFile");
			File engChassisNoFile = uploadPortletRequest.getFile("engChassNoFile");

			quot.setAccDeath(accDeath);
			quot.setVehMotorAcc(vehMotorAcc);
			quot.setConvTraffViols(convTraffViols);
			quot.setPurposeOfVehicle(vPurpose.split(";")[0]);
			/*
			 * quot.setVehicleCurrentMileage(currMile); quot.setVehicleUpperExpectedMileagePerYear(expUpperMile);
			 * quot.setVehicleLowerExpectedMileagePerYear(expLowerMile); quot.setVehicleNightLocation(nightLocation);
			 * quot.setVehicleEngineSize(engSize); quot.setVehicleTransType(transType); quot.setVehicleSpecs(vehSpecs);
			 * quot.setVehAxleWeight(vehAxle); quot.setVehCarMods(carMods);
			 */
			quot.setPurposeOfVehicleDesc(vPurpose.split(";")[1]);
			if (insCo != null && !insCo.equals("-1")) {
				quot.setExistingCompanyName(insCo);
				quot.setExistingExpDate(insExp);
				quot.setExistingPolicyNo(insPolicyNo);
			}

			String uploadDir = PropsUtil.get("policy.upload.dir");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String userId = (themeDisplay.isSignedIn()) ? PortalUtil.getUser(request).getScreenName() : ("" + quot.getInsuredId());

			if ((custCardFile != null) && custCardFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(custCardFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(custCardFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(custCardFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("custCardFile");
					inputStream = new ByteArrayFileInputStream(custCardFile, 1024);
					byte[] custCardData;
					custCardData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(custCardData);
					out.close();

					quot.setCustCardFileName(originalFileName);
				}
			}

			if ((carFrontFile != null) && carFrontFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(carFrontFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(carFrontFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(carFrontFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("carFrontFile");
					inputStream = new ByteArrayFileInputStream(carFrontFile, 1024);
					byte[] carFrontData;
					carFrontData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(carFrontData);
					out.close();

					quot.setCarFrontFileName(originalFileName);
				}
			}

			if ((carBackFile != null) && carBackFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(carBackFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(carBackFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(carBackFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("carBackFile");
					inputStream = new ByteArrayFileInputStream(carBackFile, 1024);
					byte[] carBackData;
					carBackData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(carBackData);
					out.close();

					quot.setCarBackFileName(originalFileName);
				}
			}

			if ((carLeftFile != null) && carLeftFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(carLeftFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(carLeftFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(carLeftFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("carLeftFile");
					inputStream = new ByteArrayFileInputStream(carLeftFile, 1024);
					byte[] carLeftData;
					carLeftData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(carLeftData);
					out.close();

					quot.setCarLeftFileName(originalFileName);
				}
			}

			if ((carRightFile != null) && carRightFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(carRightFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(carRightFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(carRightFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("carRightFile");
					inputStream = new ByteArrayFileInputStream(carRightFile, 1024);
					byte[] carRightData;
					carRightData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(carRightData);
					out.close();

					quot.setCarRightFileName(originalFileName);
				}
			}

			if ((engChassisNoFile != null) && engChassisNoFile.exists()) {
//				boolean isFileTypeAccepted =  com.atmc.web.util.FileUtil.isAcceptedFileType(engChassisNoFile, acceptedTypes);
				boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(engChassisNoFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES, com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
				boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(engChassisNoFile);

				if (isFileTypeAccepted && !isFileExecutable) {
					String originalFileName = uploadPortletRequest.getFileName("engChassNoFile");
					inputStream = new ByteArrayFileInputStream(engChassisNoFile, 1024);
					byte[] engChassNoData;
					engChassNoData = FileUtil.getBytes(inputStream);

					File destFolder = new File(uploadDir + "/" + userId);
					if (!destFolder.exists())
						destFolder.mkdirs();

					FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
					out.write(engChassNoData);
					out.close();

					quot.setEngChassisNoFileName(originalFileName);
				}
			}

			long vehMfg = quot.getVehicleMfgYear();
			Calendar cal = new GregorianCalendar();
			cal.setTime(new Date());
			int currentYear = cal.get(Calendar.YEAR);

			if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) && currentYear - vehMfg >= 11) {
				// quot.setNetPrem(Integer.parseInt("-"));
				quot.setNetPrem(0);
				quot.setLoyaltyDiscount("0");
				quot.setDiscountPrem(0);
				quot.setLoyaltyDiscountPer(0);
				quot.setLoadingAmount(0);
				quot.setPolicyTaxes(0);
				quot.setPolicyFees(0);
				quot.setAgencyRepairOut(0);
				quot.setDriverAgeLess21(0);
				// quot.setTotalCoverPrem(tOut.getNetPrem());
				quot.setDiscountAmount(0);
				quot.setGrossPrem(0);
				// quot.setGrossPrem(Integer.parseInt("-"));
				request.setAttribute("coverList", QuotationLocalServiceUtil.getCoverList(quot.getProductCode()));
				_log.info("submit insurance options");
			} else {
				_log.info("quotation Data : " + quot.toString());
				quot = QuotationLocalServiceUtil.getTariffDets(quot, false);
				if (Validator.isNotNull(quot)) {
					if (!quot.getPurposeOfVehicle().equals("438") && !quot.getPurposeOfVehicle().equals("439")) {
						_log.info("Purpose of vehicle " + quot.getPurposeOfVehicle());
						request.setAttribute("myview", "vehicle_info");
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE, LanguageUtil.get(httpRequest, "tariff_err_1"));
						request.setAttribute("quot", quot);
						return;
					}
					if (quot.getNetPrem() == 0) {
						_log.info("inside condition 1");
						request.setAttribute("myview", "vehicle_info");
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
						request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE, LanguageUtil.get(httpRequest, "tariff_err"));
						request.setAttribute("insCompanies", CodeMasterLocalServiceUtil.findByCode("INS_CO"));
						request.setAttribute("cities", QuotationLocalServiceUtil.getCities());
						request.setAttribute("purposeList", QuotationLocalServiceUtil.getPurposeOfVehicle());
						request.setAttribute("dedVals", QuotationLocalServiceUtil.getDeductibleValues());
						request.setAttribute("parkLocs", QuotationLocalServiceUtil.getParkingLocations());
						request.setAttribute("engineSizes", QuotationLocalServiceUtil.geEngineSizes());
						request.setAttribute("quot", quot);
						quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
						quotDets = quotDets.replaceAll("\"", "'");
						quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
						pSession.setAttribute("quotHash", quotHash);
						return;
					}
					double loyaltyDiscountAmount = 0.0;
					if (quot.getLoyaltyDiscount() != null)
						loyaltyDiscountAmount = Double.valueOf(quot.getLoyaltyDiscount());
					double finalNetPrem = quot.getNetPrem() + quot.getAgencyRepairOut() + quot.getDriverAgeLess21() - quot.getDiscountAmount() - loyaltyDiscountAmount + quot.getLoadingAmount()
							+ quot.getPolicyFees();// + quot.getPolicyTaxes();
					double vat = (quot.getPolicyTaxes() * finalNetPrem);
					finalNetPrem += vat;
					quot.setGrossPrem(finalNetPrem);

					request.setAttribute("coverList", QuotationLocalServiceUtil.getCoverList(quot.getProductCode()));
					_log.info("submit insurance options");
				}
			}
			if (Validator.isNotNull(quot)) {
				if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)) {
					/*
					 * String buyPortletId = (String)request.getAttribute(WebKeys.PORTLET_ID); Layout layout = themeDisplay.getLayout();
					 * 
					 * PortletURL quotationUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(),
					 * PortletRequest.ACTION_PHASE); personalInfoUrl.setWindowState(WindowState.NORMAL);
					 * personalInfoUrl.setPortletMode(PortletMode.VIEW); personalInfoUrl.setParameter(ActionRequest.ACTION_NAME,
					 * "personalInfo"); personalInfoUrl.setParameter("myview", "personal_info");
					 * personalInfoUrl.setParameter("missingRenewParams", "true"); response.sendRedirect(personalInfoUrl.toString());
					 */
					request.setAttribute("myview", "quotation");
					request.setAttribute("quot", quot);
					/*
					 * quotDets = GsonUtilsLocalServiceUtil.toGson(quot); quotDets = quotDets.replaceAll("\"", "'"); quotHash =
					 * generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS+quotDets+ BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					 * pSession.setAttribute("quotHash", quotHash);
					 */
					quotation(request, response);
				} else {
					request.setAttribute("quot", quot);
					quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
					quotDets = quotDets.replaceAll("\"", "'");
					quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					pSession.setAttribute("quotHash", quotHash);
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		} finally {
			try {
				com.liferay.petra.io.StreamUtil.cleanUp(inputStream);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		_log.info("Submitting Insurance Options");
	}

	public void quotation(ActionRequest request, ActionResponse response) {
		String myview = (String) request.getParameter("myview");
		if (myview == null)
			return;
		PortletSession pSession = request.getPortletSession();
		try {
			request.setAttribute("cities", QuotationLocalServiceUtil.getCities());
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			boolean quoteAlreadySaved = (httpRequest.getSession().getAttribute("QUOTE_SAVED") != null) ? true : false;
			if (quoteAlreadySaved) {
				httpRequest.getSession().removeAttribute("QUOTE_SAVED");
				response.sendRedirect("/Web/Customer/buy_motor_policy");
				return;
			}
			String quotDets = (String) ParamUtil.getString(request, "quot");

			String quotHashChk = (String) pSession.getAttribute("quotHash");
			String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			if (quotHashChk == null || !quotHashChk.equals(quotHash)) {
				// request.getPortletSession().invalidate();
				request.setAttribute("myview", "landing");
				return;
			}

			Quotation quot = (request.getAttribute("quot") != null) ? (Quotation) request.getAttribute("quot") : (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);

			if (quot.getQuotationId() != 0 && quot.isRenew()) {
				// quot = QuotationLocalServiceUtil.getTariffDets(quot);

				long qID = quot.getQuotationId();
				if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
					for (QuotationCover qCover : quot.getCoversList()) {
						QuotationCoversPK covPk = new QuotationCoversPK(qCover.getAddCoverId(), qID);
						QuotationCovers qCvr = QuotationCoversLocalServiceUtil.fetchQuotationCovers(covPk);
						if (qCvr != null)
							QuotationCoversLocalServiceUtil.deleteQuotationCovers(covPk);
					}

					if (quot.isProductChanged() && quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)) {
						quot.setCoversList(null);
						quot.setTotalCoverPrem(0);
					}
				}
				if (quot.getQuotationDrivers() != null && !quot.getQuotationDrivers().isEmpty()) {
					for (QuotationDriver drv : quot.getQuotationDrivers()) {
						QuotationDrivers qDrv = QuotationDriversLocalServiceUtil.fetchQuotationDrivers(drv.getAddDriverId());
						if (qDrv != null) {
							List<QuotationDriverLicense> driverLicenseList = drv.getDriverLicences();
							if (driverLicenseList != null && !driverLicenseList.isEmpty()) {
								for (QuotationDriverLicense drvLic : driverLicenseList) {
									QuotationsDriverLicense lic = QuotationsDriverLicenseLocalServiceUtil.fetchQuotationsDriverLicense(drvLic.getLicenseId());
									if (lic != null)
										QuotationsDriverLicenseLocalServiceUtil.deleteQuotationsDriverLicense(lic);
								}
							}
							if (drv.getDriverNatAddress() != null) {
								QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil.fetchQuotationsUserAddress(drv.getDriverNatAddress().getUserAddressId());
								if (addr != null)
									QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
							}
							if (drv.getDriverOffNatAddress() != null) {
								QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil.fetchQuotationsUserAddress(drv.getDriverOffNatAddress().getUserAddressId());
								if (addr != null)
									QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
							}
							QuotationDriversLocalServiceUtil.deleteQuotationDrivers(drv.getAddDriverId());
						}
					}
				}
				if (quot.getNatAddress() != null) {
					QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil.fetchQuotationsUserAddress(quot.getNatAddress().getUserAddressId());
					if (addr != null)
						QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
				}
				if (quot.getOffAddress() != null) {
					QuotationsUserAddress addr = QuotationsUserAddressLocalServiceUtil.fetchQuotationsUserAddress(quot.getOffAddress().getUserAddressId());
					if (addr != null)
						QuotationsUserAddressLocalServiceUtil.deleteQuotationsUserAddress(addr);
				}
				long qUploadsID = CustUploadsLocalServiceUtil.findIdByQuotationId("" + qID);
				if (qUploadsID != 0)
					CustUploadsLocalServiceUtil.deleteCustUploads(qUploadsID);

				List<QuotationStatusHistory> qHistList = QuotationStatusHistoryLocalServiceUtil.findByQuotationId(qID);

				if (qHistList != null && !qHistList.isEmpty()) {
					for (QuotationStatusHistory qHist : qHistList) {
						QuotationStatusHistoryLocalServiceUtil.deleteQuotationStatusHistory(qHist);
					}
				}

				Quotations dbQuot = QuotationsLocalServiceUtil.fetchQuotations(qID);

				// Th product code has been changed, should generate a new refernce no.
				if (dbQuot != null && !dbQuot.getProductCode().equals(quot.getProductCode()))
					quot.setReferenceNo(null);

				if (dbQuot != null)
					QuotationsLocalServiceUtil.deleteQuotations(qID);
				// quot.setReferenceNo(null);
			}

			String effDate = ParamUtil.getString(request, "effDate", null);
			if (effDate != null) {
				quot.setPolicyEffDate(dateFormatter.parse(effDate));
				_log.debug(" ----- Policy Eff Date is: " + dateFormatter.format(quot.getPolicyEffDate()) + " ----- ");
			}
			String[] coverPrems = ParamUtil.getStringValues(request, "coverPrem", null);

			double totalCoverPrem = 0.0;
			if (coverPrems != null) {
				List<QuotationCover> coversList = new ArrayList<QuotationCover>();
				for (int cCount = 0; cCount < coverPrems.length; cCount++) {
					String cPrem = coverPrems[cCount];
					long coverPrem = Long.parseLong(cPrem.split(";")[1]);
					String coverCode = cPrem.split(";")[0];
					QuotationCover qCover = new QuotationCover();
					qCover.setCoverCode(coverCode);
					qCover.setCoverPrem(coverPrem);
					qCover.setCoverName(cPrem.split(";")[2]);
					qCover.setSectionCode(Long.parseLong(cPrem.split(";")[3]));
					if (cPrem.split(";").length > 4) {
						int coverMonths = Integer.parseInt(cPrem.split(";")[4]);
						Date policyEffDate = quot.getPolicyEffDate();
						Calendar coverCal = new GregorianCalendar();
						coverCal.setTime(policyEffDate);
						coverCal.add(Calendar.MONTH, coverMonths);
						qCover.setCoverPrem(coverPrem * coverMonths);
						if (quot.getPolicyEffDate() != null)
							qCover.setCoverEffFromDate(quot.getPolicyEffDate());
						// Incase of GEO extension covers '31051' or '31052', cover eff to date is
						// policy eff date plus selected months
						if (coverCode != null && (coverCode.equals("31051") || coverCode.equals("31052")))
							qCover.setCoverEffToDate(coverCal.getTime());
						else
							qCover.setCoverEffToDate(quot.getPolicyEffTo());

						// GS: TT defect #382 - COVER_RATE in case of PAB (Driver + Passenger) should
						// contain the no of passengers
						if (coverCode != null && coverCode.equals("131004"))
							qCover.setCoverRate(coverMonths);
					}
					totalCoverPrem += qCover.getCoverPrem();

					coversList.add(qCover);
				}
				quot.setTotalCoverPrem(totalCoverPrem);
				double grossPrem = quot.getGrossPrem() + totalCoverPrem + (quot.getPolicyTaxes() * totalCoverPrem);
				quot.setGrossPrem(grossPrem);
				quot.setCoversList(coversList);
			} else
				quot.getCoversList().clear();

			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			User user = null;
			try {
				boolean isUserSignedIn = themeDisplay.isSignedIn();
				if (!isUserSignedIn) {
					// Customer customer =
					// CustomerLocalServiceUtil.fetchCustomer(""+quot.getInsuredId());
					Company company = PortalUtil.getCompany(request);
					user = UserLocalServiceUtil.fetchUserByScreenName(company.getCompanyId(), "" + quot.getInsuredId());
					if (user == null) {
						long companyId = company.getCompanyId();

						ServiceContext serviceContext = ServiceContextFactory.getInstance(User.class.getName(), request);
						user = UserMgmtLocalServiceUtil.createUser(companyId, "" + quot.getInsuredId(), null, quot.getInsuredName(), quot.getInsuredName(), themeDisplay.getLocale(),
								"" + quot.getInsuredMobile(), quot.getInsuredEmail(), serviceContext);
					}

				} else {
					user = themeDisplay.getUser();
				}

			} catch (UserEmailAddressException e) {
				_log.error(e.getMessage());
				_log.error(e.getMessage(), e);
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, e.getClass(), e);
				request.setAttribute("quot", quot);
				quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);
				request.setAttribute("dedVals", QuotationLocalServiceUtil.getDeductibleValues());
				request.setAttribute("coverList", QuotationLocalServiceUtil.getCoverList(quot.getProductCode()));
				request.setAttribute("myview", "insurance_options");
				return;
			} catch (PortalException e) {
				_log.error(e.getMessage());
				_log.error(e.getMessage(), e);
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, e.getClass(), e);
				request.setAttribute("quot", quot);
				quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);
				request.setAttribute("dedVals", QuotationLocalServiceUtil.getDeductibleValues());
				request.setAttribute("coverList", QuotationLocalServiceUtil.getCoverList(quot.getProductCode()));
				request.setAttribute("myview", "insurance_options");
				return;
			}

			if (quot.getNetPrem() != 0) {
				if (quot.isRenew() || quot.getReferenceNo() == null) {
					quot = QuotationLocalServiceUtil.submitQuotation(quot, (themeDisplay.isSignedIn()) ? (PortalUtil.getUser(request).getScreenName()) : ("" + quot.getInsuredId()));
					httpRequest.getSession().setAttribute("QUOTE_SAVED", "true");
				}

				notifyUser(httpRequest, quot, themeDisplay.getLocale(), user);
			}

			/* changes for dual quote start */

			Gson gson = new Gson();
			String jsonString = gson.toJson(quot);
			Quotation quote = gson.fromJson(jsonString, Quotation.class);
			quote.setProductCode(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE);
			quote.setReferenceNo(null);
			quote.setQuotationId(0);
			quote.setCoversList(null);
			quote.setTotalCoverPrem(0);
			quote = QuotationLocalServiceUtil.getTariffDets(quote, false);
			double loyaltyDiscount = 0.0;
			// double loyaltyDiscountAmount = 0.0;
			if (Validator.isNotNull(quote)) {
				if (quote.getLoyaltyDiscount() != null)
					loyaltyDiscount = Double.valueOf(quote.getLoyaltyDiscount());
				double finalNetPremAmount = quote.getNetPrem() + quote.getDriverAgeLess21() - quote.getDiscountAmount() - loyaltyDiscount + quote.getLoadingAmount() + quote.getPolicyFees();// +
																																																// quot.getPolicyTaxes();
				double vatAmnt = (quote.getPolicyTaxes() * finalNetPremAmount);
				finalNetPremAmount += vatAmnt;
				quote.setGrossPrem(finalNetPremAmount);

				if (quote.getNetPrem() != 0) {
					if (quote.isRenew() || quote.getReferenceNo() == null) {
						quote = QuotationLocalServiceUtil.submitQuotation(quote, (themeDisplay.isSignedIn()) ? (PortalUtil.getUser(request).getScreenName()) : ("" + quote.getInsuredId()));
						httpRequest.getSession().setAttribute("QUOTE_SAVED", "true");
					}
					notifyUser(httpRequest, quote, themeDisplay.getLocale(), user);
				} else {
					_log.info("Purpose of vehicle " + quot.getPurposeOfVehicle());
					request.setAttribute("myview", "vehicle_info");
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE, LanguageUtil.get(httpRequest, "tariff_err_1"));
					request.setAttribute("quot", quote);
					return;
				}
			}
			request.setAttribute("quote", quote);

			/* changes for dual quote End */

			/*
			 * if(quot.getQuoteStatus().equals(BuyMotorPolicyPortletKeys. QUOTE_STATUS_PENDING_PAYMENT)) {
			 * httpRequest.getSession().setAttribute("quotDets", quot); } else {
			 */
			request.setAttribute("quot", quot);
			request.setAttribute("quotDetsTpe", quote);
			quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
			quotDets = quotDets.replaceAll("\"", "'");
			quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
			pSession.setAttribute("quotHash", quotHash);
			// }
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}
	}

	public void payPolicy(ActionRequest request, ActionResponse response) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			PortletSession pSession = request.getPortletSession();
			String quotId = ParamUtil.getString(request, "quotId");
			if (Pattern.compile("^[0-9]+$").matcher(quotId).find()) {
				Quotations quotation = QuotationsLocalServiceUtil.findByQuotationId(Long.parseLong(quotId)).get(0);
				List<Quotations> quotsList = new ArrayList<>();
				quotsList.add(quotation);
				Quotation quot = QuotationLocalServiceUtil.getCustomQuotations(quotsList, false).get(0);
				quot = QuotationLocalServiceUtil.getQuotationDetails(quot);
				_log.error("Pay Policy quot >>>>> " + quot.toString());
				_log.error("Pay Policy IBAN >>>>> " + quot.getVehicleOwnerIban());
				_log.error("Pay Policy Occupation >>>>> " + quot.getInsuredOccupationCode());

				// quot = QuotationLocalServiceUtil.getTariffDets(quot);

				// quot = QuotationLocalServiceUtil.submitQuotation(quot,
				// PortalUtil.getUser(request).getScreenName());
				if (quot.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTE_STATUS_PENDING_PAYMENT)) {
					httpRequest.getSession().setAttribute("quotDets", quot);
				} else {
					request.setAttribute("quot", quot);
					String quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
					quotDets = quotDets.replaceAll("\"", "'");
					String quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					pSession.setAttribute("quotHash", quotHash);
				}

				request.setAttribute("payPolicy", true);
			} else
				_log.error("Invalid QuoteId");
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}

	}

	public void renewPolicy(ActionRequest request, ActionResponse response) {
		Policy policy = null;
		PolicyVehicle pVeh = null;
		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);

		try {
//			String policyDets =  (String)ParamUtil.getString(httpRequest, "policy");
//			String policyVeh =  (String)ParamUtil.getString(httpRequest, "policyVeh");
			String policyNo = ParamUtil.getString(httpRequest, "policyNo");
			String policyVehId = ParamUtil.getString(httpRequest, "policyVehId");
			boolean oldVehMfg = ParamUtil.getBoolean(httpRequest, "oldVehMfg", false);

			policy = PolicyLocalServiceUtil.getPolicyByPolicyNo(policyNo);
			pVeh = PolicyLocalServiceUtil.getCustomVeh(policyNo, policyVehId);
			if (oldVehMfg) {
				policy.setProduct("" + PolicyListPortletKeys.PRODUCT_CODE_TPL_VAL);
				pVeh.getVehicleCovers().clear();
			}
			policy.getPolicyVehs().clear();
			policy.getPolicyVehs().add(pVeh);

			Quotation quot = QuotationLocalServiceUtil.getPolicyQuot(policy);
			quot.setSource("01");

			_log.info("Renew inquiry calls start");
			QuotationLocalServiceUtil.renewNcdInquiry(quot);

			QuotationLocalServiceUtil.renewAddressInquiry(quot, themeDisplay.getLocale());

			if (QuotationLocalServiceUtil.validatePolicyData(policy.getPolicyNo())) {
				QuotationLocalServiceUtil.renewTariffInquiry(quot);

				if (quot.getNetPrem() == 0) {
					_log.info("Zero Net prem from tariff");
					request.setAttribute("errorCode", BuyMotorPolicyPortletKeys.GENERIC_ERROR);
					request.setAttribute("errorMsg", LanguageUtil.get(httpRequest, "tariff_err"));
					renewFailureRedirect(request, response, policy);
					return;
				} else {
					quot = QuotationLocalServiceUtil.submitQuotation(quot, PortalUtil.getUser(request).getScreenName());
					notifyUser(httpRequest, quot, themeDisplay.getLocale(), PortalUtil.getUser(request));
					httpRequest.getSession().setAttribute("quotDets", quot);
				}
			} else {
				/*
				 * String errorCode = BuyMotorPolicyPortletKeys.GENERIC_ERROR; String errorMsg = LanguageUtil.get(httpRequest,
				 * "renew_data_error"); request.setAttribute("errorCode", errorCode); request.setAttribute("errorMsg", errorMsg);
				 * renewFailureRedirect(request, response, policy);
				 */

				try {
					request.getPortletSession().setAttribute("quot", quot);

					String buyPortletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
					Layout layout = themeDisplay.getLayout();

					PortletURL personalInfoUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.ACTION_PHASE);
					personalInfoUrl.setWindowState(WindowState.NORMAL);
					personalInfoUrl.setPortletMode(PortletMode.VIEW);
					personalInfoUrl.setParameter(ActionRequest.ACTION_NAME, "personalInfo");
					personalInfoUrl.setParameter("myview", "personal_info");
					personalInfoUrl.setParameter("missingRenewParams", "true");
					response.sendRedirect(personalInfoUrl.toString());
				} catch (Exception e) {
					_log.error(e.getMessage(), e);
				}

			}
		} catch (YaqeenException | NajmException e) {
			_log.info("Exception in Renew Policy");
			String errorCode = (e instanceof YaqeenException) ? ("" + ((YaqeenException) e).getErrorCode()) : ("" + ((NajmException) e).getErrorCode());
			String errorMsg = (e instanceof YaqeenException) ? ("" + ((YaqeenException) e).getMessage()) : ("" + ((NajmException) e).getMessage());
			request.setAttribute("errorCode", errorCode);
			request.setAttribute("errorMsg", errorMsg);
			renewFailureRedirect(request, response, policy);
		} catch (PortalException e) {
			String errorCode = BuyMotorPolicyPortletKeys.GENERIC_ERROR;
			String errorMsg = LanguageUtil.get(httpRequest, "renew_data_error");
			request.setAttribute("errorCode", errorCode);
			request.setAttribute("errorMsg", errorMsg);
			renewFailureRedirect(request, response, policy);
		}

	}

	public void purchaseResult(ActionRequest request, ActionResponse response) {
		_log.info("-----purchaseResult start");
		Quotation quotDets = null;
		List<String> purchasedQuotes = null;

		HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
		boolean mobileView = ParamUtil.getBoolean(httpRequest, "mobileView", false);
		_log.info("mobile view val:" + mobileView);

		if (mobileView == true) {

			try {

				_log.info("In mobile view. Get quotation from DB");
				String refNo = httpRequest.getParameter("merchant_reference").split("_")[0];
				quotDets = QuotationLocalServiceUtil.getQuotationByReferenceNo(refNo);
				quotDets = QuotationLocalServiceUtil.getQuotationDetails(quotDets);
				_log.info("Fetched QuoteDets:" + quotDets.toString());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		} else {
			/* changed */
			try {

				_log.info("In mobile view. Get quotation from DB");
				String refNo = httpRequest.getParameter("merchant_reference").split("_")[0];
				quotDets = QuotationLocalServiceUtil.getQuotationByReferenceNo(refNo);
				quotDets = QuotationLocalServiceUtil.getQuotationDetails(quotDets);
				_log.info("Fetched QuoteDets:" + quotDets.toString());
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
			/* changed end */
			// quotDets = (Quotation)httpRequest.getSession().getAttribute("quotDets");
		}

		if (httpRequest.getSession().getAttribute("purchasedQuotes") != null)
			purchasedQuotes = (List<String>) httpRequest.getSession().getAttribute("purchasedQuotes");

		String WebrefNo = httpRequest.getParameter("merchant_reference");
		_log.info("WebrefNo is " + WebrefNo);
		String purchaseStatus = httpRequest.getParameter("status");
		String purchaseErrorCode = httpRequest.getParameter("response_code");
		String purchaseErrorMsg = httpRequest.getParameter("response_message");
		_log.info("2- Pay Policy quot >>>>> " + quotDets.toString());
		_log.info("2- Pay Policy IBAN >>>>> " + quotDets.getVehicleOwnerIban());
		_log.info("2- Pay Policy Occupation >>>>> " + quotDets.getInsuredOccupationCode());

		if (purchasedQuotes != null && !purchasedQuotes.isEmpty() && quotDets != null && purchasedQuotes.contains(quotDets.getReferenceNo())) {
			_log.info("Purchased quotes return");
			request.setAttribute("quotePurchased", true);
			request.setAttribute("myview", "results");
			return;
		}

		_log.info("Will check payment status");

		if (purchaseStatus != null && purchaseStatus.equals(BuyMotorPolicyPortletKeys.PAYMENT_STATUS_PURCHASE_SUCCESS)) {
			_log.info(">>>Invoking Issue Policy");
			quotDets.setPaymentRefNo(quotDets.getReferenceNo());
			QuotationLocalServiceUtil.issuePolicy(quotDets);
			_log.info("Policy Issuance Status >>>>> " + quotDets.getQuoteStatus());
			_log.info("Policy Issuance >>>>> " + quotDets);
			if (quotDets.getQuoteStatus() != null && quotDets.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_REJECTED)) {
				try {
					String[] mailparamsForserviceportal = { String.valueOf(quotDets.getQuotationId()), dateFormattimestamp.format(new Date()) };
					NotificationsLocalServiceUtil.notifyUser(request.getLocale(), String.valueOf(Type.POILCY_REJECTED_EMAIL), PropsUtil.get("retailoperation"), "", mailparamsForserviceportal, null,
							null, null, null, 0, 0);
					NotificationsLocalServiceUtil.notifyUser(request.getLocale(), String.valueOf(Type.POILCY_REJECTED_EMAIL), PropsUtil.get("customerCare"), "", mailparamsForserviceportal, null, null,
							null, null, 0, 0);
				} catch (PortalException e) {
					// Auto-generated catch block
					_log.error(e.getMessage(), e);
				}
				request.setAttribute("myview", (mobileView) ? "payment" : "landing");
				request.setAttribute("paymentFail", "true");
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL);
				request.setAttribute("quot", quotDets);
			} else {
				if (purchasedQuotes == null)
					purchasedQuotes = new ArrayList<>();
				purchasedQuotes.add(quotDets.getReferenceNo());
				httpRequest.getSession().setAttribute("purchasedQuotes", purchasedQuotes);
				_log.info("Policy Details >>>>> " + quotDets.toString());
				request.setAttribute("quot", quotDets);
				request.setAttribute("mobileView", mobileView);
				request.setAttribute("myview", "results");

				try {

					// Prepare policy certificate report data
					_log.info("Preparing policy certificate report data");
					Map<String, Object> paramsMap = new HashMap<>();
					List ds = new ArrayList<>();

					String policyNo = quotDets.getPolicyNo();
					Policy policy = new Policy();// PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
					policy.setPolicyNo(policyNo);
					policy.setInsuredName(quotDets.getInsuredName());
					policy.setInsuredId("" + quotDets.getInsuredId());
					policy.setInceptionDate(quotDets.getPolicyEffDate());
					policy.setExpiryDate(quotDets.getPolicyEffTo());

					PolicyVehicle pVeh = new PolicyVehicle();
					pVeh.setBodyTypeAr(quotDets.getVehicleBodyTypeAr());
					pVeh.setBodyTypeEn(quotDets.getVehicleBodyTypeEn());
					pVeh.setArPlateNo("" + quotDets.getVehiclePlateNo());
					pVeh.setArPlateL1(quotDets.getVehiclePlateL1());
					pVeh.setArPlateL2(quotDets.getVehiclePlateL2());
					pVeh.setArPlateL3(quotDets.getVehiclePlateL3());
					pVeh.setEnPlateL1(quotDets.getVehiclePlateL1());
					pVeh.setEnPlateL2(quotDets.getVehiclePlateL2());
					pVeh.setEnPlateL3(quotDets.getVehiclePlateL3());
					pVeh.setVehId("" + quotDets.getVehicleId());
					pVeh.setMfgYear(quotDets.getVehicleMfgYear());
					pVeh.setChassisNo(quotDets.getVehicleChassisNo());

					List<PolicyVehicle> pVehs = new ArrayList<>();
					pVehs.add(pVeh);
					policy.setPolicyVehs(pVehs);

					String productType = quotDets.getProductCode();

					paramsMap.put("pVeh", pVeh);
					paramsMap.put("pType", productType);
					paramsMap.put("page_no", LanguageUtil.get(httpRequest, "page_no"));

					ds.add(policy);

					File directory = new File(PropsUtil.get("com.ejada.atmc.quote.report.path"));
					if (!directory.exists()) {
						directory.mkdirs();
					}

					File qFile = new File(PropsUtil.get("com.ejada.atmc.quote.report.path") + "/policy_certificate.pdf");
					if (!qFile.exists())
						qFile.createNewFile();
					FileOutputStream fos = new FileOutputStream(qFile);
					ReportsUtil.fillAndExportPDFReport("policy_certificate.jasper", ds, paramsMap, fos);
					List<File> fileList = new ArrayList<>();
					fileList.add(qFile);
					List<String> fileNames = new ArrayList<String>();
					fileNames.add("policy_certificate.pdf");

					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					String notifType = Type.POLICY_ISSUANCE_EMAIL.val();
					String[] mailParams = { quotDets.getInsuredName(), PropsUtil.get("dashboardURL") };
					String[] smsParams = { quotDets.getPolicyNo(), dateFormatter.format(quotDets.getPolicyEffDate()) };

					_log.info("Preparing to notify user for policy issuance");
					NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), notifType, quotDets.getInsuredEmail(), quotDets.getInsuredMobile(), mailParams, smsParams, fileList, fileNames,
							mailParams, themeDisplay.getUserId(), themeDisplay.getCompanyId());

					if (qFile.exists())
						qFile.delete();
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				} catch (IOException e) {
					// Auto-generated catch block
					_log.error(e.getMessage(), e);
				} catch (Exception e) {
					// Auto-generated catch block
					_log.error(e.getMessage(), e);
				}
			}
		} else {
			request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
			request.setAttribute("paymentFail", "true");
			request.setAttribute("purchaseErrorCode", purchaseErrorCode);
			request.setAttribute("purchaseErrorMsg", purchaseErrorMsg);
			hideDefaultErrorMessage(request);
			SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
			request.setAttribute("quot", quotDets);
			try {
				ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
				List<File> fileList = new ArrayList<>();
				List<String> fileNames = new ArrayList<String>();
				String notifType = Type.QUOTATION_PAYMENT_FAILED.val();
				String[] mailParams = { quotDets.getInsuredName(), PropsUtil.get("dashboardURL") };
				String[] smsParams = {};
				NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), notifType, quotDets.getInsuredEmail(), quotDets.getInsuredMobile(), mailParams, smsParams, fileList, fileNames,
						mailParams, themeDisplay.getUserId(), themeDisplay.getCompanyId());
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}

		}
	}

	public void tokenizationResult(ActionRequest request, ActionResponse response) {
		Quotation quotDets = null;
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			_log.info("---------------------- tokenizationResult. Portlet Session ID = " + httpRequest.getSession().getId());
			boolean mobileView = ParamUtil.getBoolean(httpRequest, "mobileView", false);
			if (mobileView) {
				String refNo = httpRequest.getParameter("merchant_reference");
				quotDets = QuotationLocalServiceUtil.getQuotationByReferenceNo(refNo.split("_")[0]);
				quotDets = QuotationLocalServiceUtil.getQuotationDetails(quotDets);
			} else
			// quotDets = (Quotation)httpRequest.getSession().getAttribute("quotDets");
			{
				String merRefNo = httpRequest.getParameter("merchant_reference");
				quotDets = QuotationLocalServiceUtil.getQuotationByReferenceNo(merRefNo.split("_")[0]);
				quotDets = QuotationLocalServiceUtil.getQuotationDetails(quotDets);
			}
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			String buyPortletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
			themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Layout layout = themeDisplay.getLayout();
			String merRefNo = httpRequest.getParameter("merchant_reference");
			_log.info("merRefNo>>>>>>>>>>>>>>" + merRefNo);

			/*
			 * if(!mobileView) { payfortRef payfortRer = payfortRefLocalServiceUtil.createpayfortRef((int)CounterLocalServiceUtil.
			 * increment()); payfortRer.setIqama_id(quotDets.getOldIqamaId()); payfortRer.setPayFortRefNo(merRefNo);
			 * payfortRer.setStatus(PAYFORT_REF_STATUS); payfortRefLocalServiceUtil.addpayfortRef(payfortRer); }
			 */
			/*--------------------------------------------------------------Change Start--------------------------------------------------------*/

			try {
				int maxPolicySize = (PropsUtil.get("user.max.policy.limit") != null) ? Integer.parseInt(PropsUtil.get("user.max.policy.limit")) : 5;
				_log.info("maxPolicySize :::" + maxPolicySize);
				List<PolicyHDR> policyList = PolicyHDRLocalServiceUtil.findByiqamaIdAndStatus(String.valueOf(quotDets.getInsuredId()), "A");
				_log.info("policyList size :::" + policyList.size());
				if (policyList != null && policyList.size() >= maxPolicySize) {
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR, true);
					request.setAttribute(BuyMotorPolicyPortletKeys.GENERIC_ERROR_MESSAGE, LanguageUtil.get(httpRequest, "max_policy_limit"));
					request.setAttribute("myview", "landing");
					return;
				}
			} catch (NumberFormatException | PortalException e) {
				_log.error(e.getMessage());
				_log.error(e.getMessage(), e);
			}

			/*-----------------------------------------------------------Change End -----------------------------------------------------------*/
			String tokenizationStatus = httpRequest.getParameter("status");
			String tokenizationErrorCode = httpRequest.getParameter("response_code");
			String tokenizationErrorMsg = httpRequest.getParameter("response_message");

			String tokenizationSignature = httpRequest.getParameter("signature");

			String lang = request.getLocale().getLanguage();

			boolean isValidSignature = verifyPayFortSignature(tokenizationSignature, lang, httpRequest, BuyMotorPolicyPortletKeys.FORT_COMMAND_TOKENIZATION);

			if (isValidSignature && tokenizationStatus != null && tokenizationStatus.equals(BuyMotorPolicyPortletKeys.PAYMENT_STATUS_TOKENIZATION_SUCCESS)) {
				String token = httpRequest.getParameter("token_name");
				String csc = httpRequest.getParameter("csc");
				String merchRef = httpRequest.getParameter("merchant_reference");
				byte[] bytes = Hex.decodeHex(csc.toCharArray());
				csc = new String(bytes, "UTF-8");
				String paymentOption = httpRequest.getParameter("payment_option");
				quotDets.setPaymentMethod(paymentOption);

				String clientIpAddress = httpRequest.getHeader("X-FORWARDED-FOR");
				if (clientIpAddress == null) {
					clientIpAddress = httpRequest.getRemoteAddr();
				}

				PortletURL purchaseReturnUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.ACTION_PHASE);
				purchaseReturnUrl.setWindowState(WindowState.NORMAL);
				purchaseReturnUrl.setPortletMode(PortletMode.VIEW);
				purchaseReturnUrl.setParameter(ActionRequest.ACTION_NAME, "purchaseResult");
				String purchaseReturnUrlVal = purchaseReturnUrl.toString();
				if (mobileView)
					purchaseReturnUrlVal += "&mobileView=true";

				// response.sendRedirect(purchaseReturnUrl.toString()+"&status=14");

				// Kareem Kahil: As per ATMC's request, in case email address in ODS_POLICY_HDR
				// is null,retrieving email address passed to payfort from 1)Liferay 2)dummy
				// email in case Liferay email is null
				String insuredEmail = quotDets.getInsuredEmail();
				_log.info("Current payfort email:" + insuredEmail);

				if (insuredEmail == null || insuredEmail.equals("")) {
					_log.info("ODS insured email is null.");

					if (themeDisplay.isSignedIn()) {
						_log.info("Logged in user. Get email from Liferay.");
						insuredEmail = themeDisplay.getUser().getEmailAddress();
						_log.info("Liferay email:" + insuredEmail);

						if (insuredEmail == null || insuredEmail.equals("")) {
							_log.info("Liferay email is null. Passing a dummy");
							insuredEmail = "test@liferay.com";
						}
					} else {
						insuredEmail = "test@liferay.com";
					}

				}

				_log.info("Passing payfort email:" + insuredEmail);

				PurchaseResponse purchaseResponse = QuotationLocalServiceUtil.payFortPurchase(quotDets.getGrossPrem(), "SAR", insuredEmail, themeDisplay.getLocale().toString(), merchRef, token,
						paymentOption, csc, clientIpAddress, purchaseReturnUrlVal);
				if (purchaseResponse != null)
					_log.info("Purchase Response: " + purchaseResponse.log());

				boolean isValidPurchaseSignature = verifyPayfortPurrchaseSignature(purchaseResponse);

				if (purchaseResponse != null && isValidPurchaseSignature) {
					String purchaseStatus = purchaseResponse.getStatus();
					String threeDsUrl = purchaseResponse.getThreeDsUrl();

					if (purchaseStatus != null && purchaseStatus.equals(BuyMotorPolicyPortletKeys.PAYMENT_STATUS_PURCHASE_SUCCESS)) {
						_log.info("Successful Purchase");

						// do policy Issuance
						if (threeDsUrl != null && !threeDsUrl.equals("")) {
							_log.info("We have 3ds redirection");
							response.sendRedirect(threeDsUrl);
						} else {
							quotDets.setPaymentRefNo(purchaseResponse.getMerchantReference());
							// quotDets.setPaymentRefNo(""+System.currentTimeMillis());
							QuotationLocalServiceUtil.issuePolicy(quotDets);
							_log.error("Policy Issuance Status >>>>> " + quotDets.getQuoteStatus());
							_log.error("Policy Issuance >>>>> " + quotDets);
							if (quotDets.getQuoteStatus() != null && quotDets.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_REJECTED)) {
								request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
								request.setAttribute("paymentFail", "true");
								hideDefaultErrorMessage(request);
								SessionErrors.add(request, BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL);
								request.setAttribute("quot", quotDets);
							} else {
								_log.error("Policy Details >>>>> " + quotDets.toString());
								request.setAttribute("quot", quotDets);
								request.setAttribute("mobileView", mobileView);
								request.setAttribute("myview", "results");
							}
						}
					} else if (purchaseStatus != null && purchaseStatus.equals(BuyMotorPolicyPortletKeys.PAYMENT_STATUS_ON_HOLD) && purchaseResponse.getResponseCode().equals("20064")) {
						if (threeDsUrl != null)
							response.sendRedirect(threeDsUrl);
					} else {
						request.setAttribute("myview", (mobileView) ? "payment" : "landing");
						request.setAttribute("paymentFail", "true");
						request.setAttribute("purchaseErrorCode", purchaseResponse.getResponseCode());
						request.setAttribute("purchaseErrorMsg", purchaseResponse.getResponseMessage());
						hideDefaultErrorMessage(request);
						SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
						request.setAttribute("quot", quotDets);
					}
				} else {
					if (!isValidPurchaseSignature) {
						_log.info("Not a valid purchase signature");
						// Might do extra handling here later
					}

					request.setAttribute("paymentFail", "true");
					request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
					request.setAttribute("purchaseErrorCode", "9999");
					request.setAttribute("purchaseErrorMsg", "Invalid Payment Request");
					hideDefaultErrorMessage(request);
					SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
					request.setAttribute("quot", quotDets);
				}
			} else {
				if (!isValidSignature) {
					tokenizationErrorCode = "9999";
					tokenizationErrorMsg = "Invalid Payment Request";
				}
				request.setAttribute("paymentFail", "true");
				request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
				request.setAttribute("purchaseErrorCode", tokenizationErrorCode);
				request.setAttribute("purchaseErrorMsg", tokenizationErrorMsg);
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
				request.setAttribute("quot", quotDets);

				try {
					List<File> fileList = new ArrayList<>();
					List<String> fileNames = new ArrayList<String>();
					String notifType = Type.QUOTATION_PAYMENT_FAILED.val();
					String[] mailParams = { quotDets.getInsuredName(), PropsUtil.get("dashboardURL") };
					String[] smsParams = {};
					NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), notifType, quotDets.getInsuredEmail(), quotDets.getInsuredMobile(), mailParams, smsParams, fileList, fileNames,
							mailParams, themeDisplay.getUserId(), themeDisplay.getCompanyId());
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				}
			}
			_log.info("tokenizationResult redirected hereeeeeeeeee");
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
			hideDefaultErrorMessage(request);
			SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
			request.setAttribute("quot", quotDets);
		}

	}

	public void olpInitiateFail(ActionRequest request, ActionResponse response) {
		hideDefaultErrorMessage(request);
		SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
		boolean mobileView = ParamUtil.getBoolean(request, "mobileView", false);
		request.setAttribute("paymentFail", "true");
		request.setAttribute("myview", (mobileView) ? "payment" : "quotation");

		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			Quotation quotDets = (Quotation) httpRequest.getSession().getAttribute("quotDets");
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			List<File> fileList = new ArrayList<>();
			List<String> fileNames = new ArrayList<>();
			String notifType = Type.QUOTATION_PAYMENT_FAILED.val();
			String[] mailParams = { quotDets.getInsuredName(), PropsUtil.get("dashboardURL") };
			String[] smsParams = {};
			NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), notifType, quotDets.getInsuredEmail(), quotDets.getInsuredMobile(), mailParams, smsParams, fileList, fileNames,
					mailParams, themeDisplay.getUserId(), themeDisplay.getCompanyId());
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void olpInitiateSuccess(ActionRequest request, ActionResponse response) {
		try {
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
			Quotation quotDets = (Quotation) httpRequest.getSession().getAttribute("quotDets");
			ConfirmOLPPayment confirmPmnt = OLPPaymentLocalServiceUtil.confirmPayment(quotDets.getOlpEstn());
			boolean mobileView = ParamUtil.getBoolean(request, "mobileView", false);

			if (confirmPmnt != null && confirmPmnt.getResponseCode().equals("00")) {
				quotDets.setPaymentMethod("OLP");
				quotDets.setPaymentRefNo(confirmPmnt.getAbRefNum());
				QuotationLocalServiceUtil.issuePolicy(quotDets);
				if (quotDets.getQuoteStatus() != null && quotDets.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.QUOTATION_STATUS_REJECTED)) {
					hideDefaultErrorMessage(request);
					SessionErrors.add(request, BuyMotorPolicyPortletKeys.POLICY_ISSUANCE_FAIL);
					request.setAttribute("paymentFail", "true");
					request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
				} else if (quotDets.getQuoteStatus() != null && quotDets.getQuoteStatus().equals(BuyMotorPolicyPortletKeys.POLICY_STATUS_ACTIVE)) {
					request.setAttribute("myview", "results");
					// request.setAttribute("mobileView", mobileView);
					request.setAttribute("quot", quotDets);
				}
				// request.setAttribute("myview", "results");

			} else {
				hideDefaultErrorMessage(request);
				SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
				request.setAttribute("paymentFail", "true");
				request.setAttribute("myview", (mobileView) ? "payment" : "quotation");

				try {
					ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
					List<File> fileList = new ArrayList<>();
					List<String> fileNames = new ArrayList<String>();
					String notifType = Type.QUOTATION_PAYMENT_FAILED.val();
					String[] mailParams = { quotDets.getInsuredName(), PropsUtil.get("dashboardURL") };
					String[] smsParams = {};
					NotificationsLocalServiceUtil.notifyUser(themeDisplay.getLocale(), notifType, quotDets.getInsuredEmail(), quotDets.getInsuredMobile(), mailParams, smsParams, fileList, fileNames,
							mailParams, themeDisplay.getUserId(), themeDisplay.getCompanyId());
				} catch (PortalException e) {
					_log.error(e.getMessage(), e);
				}
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}
	}

	public void results(ActionRequest request, ActionResponse response) {

		String myview = request.getParameter("myview");
		if (myview == null)
			return;
		PortletSession pSession = request.getPortletSession();
		String olpCode = null;
		boolean mobileView = ParamUtil.getBoolean(request, "mobileView", false);
		String quotDets = (String) ParamUtil.getString(request, "quot");
		String quotHash = (String) pSession.getAttribute("quotHash");
		if (quotHash == null || !quotHash.equals(generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS))) {
			// request.getPortletSession().invalidate();
			request.setAttribute("myview", "landing");
			return;
		}
		Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDets, Quotation.class);
		try {
			String buyPortletId = (String) request.getAttribute(WebKeys.PORTLET_ID);
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Layout layout = themeDisplay.getLayout();

			PortletURL successUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.ACTION_PHASE);
			successUrl.setWindowState(WindowState.NORMAL);
			successUrl.setPortletMode(PortletMode.VIEW);
			successUrl.setParameter(ActionRequest.ACTION_NAME, "olpInitiateSuccess");
			successUrl.setParameter("mobileView", "" + mobileView);

			PortletURL failUrl = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.ACTION_PHASE);
			failUrl.setWindowState(WindowState.NORMAL);
			failUrl.setPortletMode(PortletMode.VIEW);
			failUrl.setParameter(ActionRequest.ACTION_NAME, "olpInitiateFail");
			failUrl.setParameter("mobileView", "" + mobileView);

			olpCode = ParamUtil.getString(request, "olpID");
			double totalAmount = ParamUtil.getDouble(request, "totalAmount");

			String ibURL = null;
			if (Pattern.compile("^[a-zA-Z0-9_@.]*[a-zA-Z]+[a-zA-Z0-9_@.]*$").matcher(olpCode).find())
				ibURL = QuotationLocalServiceUtil.olpInitiatePmnt(olpCode, totalAmount, "SAR", successUrl.toString(), failUrl.toString());
			else
				_log.error("Invalid olpCode : pattern didn't match");
			String estn = (ibURL != null && !ibURL.equals("")) ? ibURL.substring(ibURL.lastIndexOf("estn=") + 5, ibURL.lastIndexOf("&mfu")) : null;
			_log.info("OLP success URL ---------------------> " + successUrl.toString());
			if (estn != null) {
				quot.setOlpEstn(estn);

				HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
				httpRequest.getSession().setAttribute("quotDets", quot);

				response.sendRedirect(ibURL);
			} else {
				/*
				 * PortletURL url = PortletURLFactoryUtil.create(request, buyPortletId, layout.getPlid(), PortletRequest.RENDER_PHASE);
				 * url.setWindowState(WindowState.NORMAL); url.setPortletMode(PortletMode.VIEW); url.setParameter("myview",
				 * "quotation"); SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
				 */
				request.setAttribute("quot", quot);
				quotDets = GsonUtilsLocalServiceUtil.toGson(quot);
				quotDets = quotDets.replaceAll("\"", "'");
				quotHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + quotDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
				pSession.setAttribute("quotHash", quotHash);
				SessionErrors.add(request, BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL);
				request.setAttribute("paymentFail", "true");
				request.setAttribute("myview", (mobileView) ? "payment" : "quotation");
				// response.sendRedirect(url.toString());
			}
		} catch (IOException | WindowStateException | PortletModeException e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}

	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview")
					: (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "landing";
			boolean paramTampered = false;
			_log.info(">>>In doview BuyMotor. view:" + myview);

			if (renderRequest.getAttribute("quot") == null) {
				HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
				myview = (httpRequest.getParameter("myview") != null) ? (String) httpRequest.getParameter("myview") : myview;
				Quotation quotDets = (Quotation) httpRequest.getSession().getAttribute("quotDets");

				if (quotDets == null) {
					String qDets = httpRequest.getParameter("quot");
					String qDetsHash = httpRequest.getParameter("chkVal");
					String verifyHash = generateHash(BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS + qDets + BuyMotorPolicyPortletKeys.QUOT_HASH_CONCATS);
					if (qDetsHash != null && !qDetsHash.equals(verifyHash)) {
						paramTampered = true;
					}

					if (qDets != null) {
						quotDets = (Quotation) GsonUtilsLocalServiceUtil.fromMobileGson(qDets, Quotation.class);
					}
				}

				if (quotDets != null)
					renderRequest.setAttribute("quot", quotDets);
			}

			if (paramTampered) {
				_log.info("PARAM Tampered error");
				renderRequest.setAttribute("MOBILE_SESSION_ERROR", true);
			}

			String view = "/" + myview + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

			dispatcher.forward(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		ByteArrayFileInputStream inputStream = null;
		try {
			HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(resourceRequest);
			String resourceType = resourceRequest.getParameter("resourceType");
			if (resourceType != null && resourceType.equals("addriver")) {
				String driverDets = resourceRequest.getParameter("driver");

				QuotationDriver quotDriver = (QuotationDriver) GsonUtilsLocalServiceUtil.fromGson(driverDets, QuotationDriver.class);

				// Ahmed AE Fattah : NCD CR - Requested By Gasser
				// Add Driver Relation to insured id - Upload Proof of relation
				UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
				File[] uploadedFiles = uploadPortletRequest.getFiles("uploadFile");
				_log.info("Uploaded File : " + uploadedFiles.length);
				_log.info("Uploaded File : " + uploadedFiles);
				_log.info("quotDriver  : " + quotDriver);
				_log.info("quotDriver  : " + quotDriver.toString());
				_log.info("quotDriver.getInsuredRelative()  : " + quotDriver.getInsuredRelative());
				if ((quotDriver.getInsuredRelative() != null && !quotDriver.getInsuredRelative().equals(BuyMotorPolicyPortletKeys.INSURED_RELATION_0) && !quotDriver.getInsuredRelative().equals("-1"))
						&& (uploadedFiles != null && uploadedFiles.length > 0))
				{

					File evidenceFile = uploadedFiles[0];

					if (evidenceFile == null || !evidenceFile.exists()) {
						_log.info("Evidence file empty");
					} else {
						_log.info("We have evidence file to upload");

						boolean isFileTypeAccepted = com.atmc.web.util.FileUtil.validateFile(evidenceFile, com.atmc.web.util.FileUtil.ACCEPTED_FILE_TYPES,
								com.atmc.web.util.FileUtil.MINIMUM_ALLOWED_SIZE);
						boolean isFileExecutable = com.atmc.web.util.FileUtil.isExecutable(evidenceFile);

						if (isFileTypeAccepted && !isFileExecutable) {
							String uploadDir = PropsUtil.get("policy.upload.dir");
							String userId = String.valueOf(quotDriver.getDriverId());
							String originalFileName = uploadPortletRequest.getFileName("uploadFile");
							inputStream = new ByteArrayFileInputStream(uploadedFiles[0], 1024);
							byte[] idData = FileUtil.getBytes(inputStream);

							File destFolder = new File(uploadDir + "/" + userId);
							if (!destFolder.exists())
								destFolder.mkdirs();

							FileOutputStream out = new FileOutputStream(uploadDir + "/" + userId + "/" + originalFileName);
							out.write(idData);
							out.close();
							inputStream.close();

							quotDriver.setRelationProofFileName(uploadPortletRequest.getFileName("uploadFile"));
						}
					}
				} else {
					quotDriver.setRelationProofFileName(quotDriver.getRelationProofFileName());
				}
				// End
				PrintWriter writer = resourceResponse.getWriter();
				try {
					// Ahmed AE Fattah : NCD CR - Requested By Gasser
					// If the driver is not relevant to the insured ID no NCD call established
					if (quotDriver.getInsuredRelative() != null && !quotDriver.getInsuredRelative().equals(BuyMotorPolicyPortletKeys.INSURED_RELATION_0))
						CustomerVehicleDetailsLocalServiceUtil.getDriverVehicleDetails(quotDriver, httpReq, true);
					else
						CustomerVehicleDetailsLocalServiceUtil.getDriverVehicleDetails(quotDriver, httpReq, false);
					writer.print("success#" + GsonUtilsLocalServiceUtil.toGson(quotDriver));
				} catch (YaqeenException e) {
					_log.error(e.getMessage());
					_log.error(e.getMessage(), e);
					writer.print("error#" + e.getErrorCode() + " " + e.getMessage());
				}
			} else if (resourceType != null && resourceType.equals("quickQuote")) {
				PrintWriter writer = resourceResponse.getWriter();
				try {
					String quotData = resourceRequest.getParameter("quotDets");
					Quotation quot = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotData, Quotation.class);

					Calendar ageCal = new GregorianCalendar();
					ageCal.setTime(quot.getInsuredDob());
					Calendar cal = new GregorianCalendar();
					cal.setTime(new Date());

					int currentYear = cal.get(Calendar.YEAR);
					int birthYear = ageCal.get(Calendar.YEAR);
					int userDriverAge = currentYear - birthYear;
					int m = cal.get(Calendar.MONTH) - ageCal.get(Calendar.MONTH);
					if (m < 0 || (m == 0 && cal.getTimeInMillis() < ageCal.getTimeInMillis())) {
						userDriverAge--;
					}

					int driverAge;
					if (userDriverAge <= 25)
						driverAge = 24;
					else if (userDriverAge > 25 && userDriverAge <= 35)
						driverAge = 30;
					else if (userDriverAge > 35)
						driverAge = 40;

					TariffInput tariffInput = new TariffInput();
					tariffInput.setBodyType(quot.getVehicleBodyType());
					tariffInput.setClmFreeYears(1);
					tariffInput.setColor(TARIFF_QUICKQUOTE_COLOR);
					tariffInput.setEffFromDate(new java.sql.Date(quot.getPolicyEffDate().getTime()));

					// Kareem Kahil: Mapping Insured Gender as per SAMA CR design document
					String insuredGender = quot.getInsuredGender();

					if (insuredGender != null && !insuredGender.equals("")) {
						if (insuredGender.equalsIgnoreCase(YAKEEN_INSURED_GENDER_MALE))
							tariffInput.setGender(INSURED_GENDER_MALE);
						else
							tariffInput.setGender(INSURED_GENDER_FEMALE);
					} else
						tariffInput.setGender(0);

					tariffInput.setLoyalty(0);
					tariffInput.setMake((quot.getVehicleMake() != null && !quot.getVehicleMake().equals("")) ? Integer.parseInt(quot.getVehicleMake()) : 0);
					tariffInput.setMFGYear((int) quot.getVehicleMfgYear());
					tariffInput.setProductCode("13102");

					try {
						if (quot.getVehiclePlateType() != null)
							tariffInput.setPurposeVeh(Integer.parseInt(quot.getVehiclePlateType()));
						else
							tariffInput.setPurposeVeh(414);
					} catch (Exception e) {
						_log.error(e.getMessage(), e);
						_log.info("Vehicle Plate Type is not a valid number.Setting as 1");
						tariffInput.setPurposeVeh(414);
					}

					if (quot.getCity() != null) {
						CodeMasterMap cityMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode("CITY_REGION", quot.getCity());
						String transformedCityCode = (cityMap != null) ? cityMap.getCoreCode() : null;
						tariffInput.setRegion(transformedCityCode);
					}
					tariffInput.setRepair(0);
					tariffInput.setSchemeCode("SCHEME_000");
					tariffInput.setVehicleValue((int) quot.getVehicleValue());
					if (quot.getVehicleNationality() != null && !quot.getVehicleNationality().equals(""))

						if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)) {
							tariffInput.setProductCode("13101");
						}

				} catch (Exception e) {
					_log.error(e.getMessage());
					_log.error(e.getMessage(), e);
					writer.print("error");
				}
			}

			if (resourceType != null && resourceType.equals("saveAddress")) {
				PrintWriter writer = resourceResponse.getWriter();
				try {
					String addrDets = resourceRequest.getParameter("natAddress");
					String offAddrDets = resourceRequest.getParameter("offAddress");
					String quotData = resourceRequest.getParameter("quotDets");
					String iban = resourceRequest.getParameter("iban");
					String currMile = resourceRequest.getParameter("currMile");
					String quotdetslogin = resourceRequest.getParameter("quotdetslogin");
					String nightLocation = resourceRequest.getParameter("nightLocation");
					String engSize = resourceRequest.getParameter("engSize");
					String transType = resourceRequest.getParameter("transType");
					String expMileRange = resourceRequest.getParameter("expMileRange");
					long expLowerMile = Long.parseLong(expMileRange.split(" - ")[0]);
					long expUpperMile = Long.parseLong(expMileRange.split(" - ")[1]);
					String vehAxle = resourceRequest.getParameter("vehAxle");
					String carMods = Encode.forHtmlContent(resourceRequest.getParameter("carMods"));
					String vehSpecs = resourceRequest.getParameter("vehSpecs");
					String quotDetTp = resourceRequest.getParameter("quotDetTp");
					String selectedProduct = resourceRequest.getParameter("selectedProduct");

					_log.info("quotDetTp >>>>>>>>>>>>>>>>>>>>" + quotDetTp);
					_log.info("selectedProduct>>>>>>>>>>>>>>>>>>>>>>>" + selectedProduct);
					Quotation quotDetsforoneQuote = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDetTp, Quotation.class);

					Quotation quotDets = null;

					int flag = 1;
					if (iban != null && !iban.equals(""))
						flag = ClaimLocalServiceUtil.checkIbanValidation(iban);

					flag = Validator.isNotNull(PropsUtil.get("dummy.iban.value")) ? 1 : 0;
					_log.info("----------- Saving Address ------------");
					_log.info("----------- addrDets = " + addrDets);
					_log.info("----------- offAddrDets = " + offAddrDets);
					_log.info("----------- quotData = " + quotData);
					_log.info("----------- quotDetTp = " + quotDetTp);
					_log.info("----------- End Saving Address ------------");

					if (quotdetslogin != null) {
						quotDets = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotdetslogin, Quotation.class);
					} else if (selectedProduct.equals("TP")) {
						quotDets = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotDetTp, Quotation.class);
					} else {
						quotDets = (Quotation) GsonUtilsLocalServiceUtil.fromGson(quotData, Quotation.class);
					}

					_log.info("quotDets>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + quotDets);

					if (addrDets != null && !addrDets.equals("")) {
						QuotationUserAddress custUserNatAddr = (QuotationUserAddress) GsonUtilsLocalServiceUtil.fromGson(addrDets, QuotationUserAddress.class);
						quotDets.setNatAddress(custUserNatAddr);
						QuotationLocalServiceUtil.saveQuoteUserAddress(custUserNatAddr, quotDets.getQuotationId(), quotDets.getInsuredId(), true);
					}
					if (offAddrDets != null && !offAddrDets.equals("")) {
						QuotationUserAddress offAddress = (QuotationUserAddress) GsonUtilsLocalServiceUtil.fromGson(offAddrDets, QuotationUserAddress.class);
						quotDets.setOffAddress(offAddress);
						QuotationLocalServiceUtil.saveQuoteUserAddress(offAddress, quotDets.getQuotationId(), quotDets.getInsuredId(), false);
					}
					if (iban != null && !iban.equals("") && flag == 1) {
						_log.info("iban number " + iban);
						Quotations addDetails = null;
						_log.info("before call " + quotDets.getQuotationId());
						if (quotDets.getQuotationId() != 0) {
							addDetails = QuotationsLocalServiceUtil.getQuotations(quotDets.getQuotationId());
						} else {
							addDetails = QuotationsLocalServiceUtil.getQuotations(quotDetsforoneQuote.getQuotationId());
						}
						_log.info("after call ");
						addDetails.setInsuredIBAN(iban);
						if (Pattern.compile("^[0-9]+$").matcher(currMile).find())
							addDetails.setVehicleCurrentMileage(Long.parseLong(currMile));
						else
							_log.error("Invalid currMile");
						addDetails.setVehicleNightLocation(nightLocation);
						addDetails.setVehicleUpperExpectedMileagePerYear(expUpperMile);
						addDetails.setVehicleLowerExpectedMileagePerYear(expLowerMile);
						addDetails.setVehicleEngineSize(engSize);
						addDetails.setVehicleTransType(transType);
						if (vehAxle != null && vehAxle != "" && Pattern.compile("^[0-9]+$").matcher(currMile).find())
							addDetails.setVehAxleWeight(Long.parseLong(vehAxle));
						else
							_log.error("Invalid vehAxle");
						addDetails.setVehSpecs(vehSpecs);
						addDetails.setVehCarMods(carMods);
						_log.info("updating additional Details ");
						QuotationsLocalServiceUtil.updateQuotations(addDetails);
						_log.info("additional Details updated successfully ");

					}
					if (flag == 0)
						writer.print("ibanError");
					else
						writer.print("success");
				} catch (Exception e) {
					_log.error(e.getMessage());
					_log.error(e.getMessage(), e);
					writer.print("error");
				}
			} else {

				String type = resourceRequest.getParameter("type");
				_log.info("scr type" + type);
				List<Object> ds = new ArrayList<>();
				Map<String, Object> paramsMap = new HashMap<>();
				String fileName = "";
				String reportName = "";

				String quoteId = resourceRequest.getParameter("quotId");
				String insuredId = resourceRequest.getParameter("insuredId");
				_log.info("quoteId>>>>>" + quoteId);
				Quotation quot = QuotationLocalServiceUtil.getQuotationByQuotationId(Long.parseLong(quoteId));
				if (type != null && type.equals("policy")) {
					String policyNo = resourceRequest.getParameter("policyNo");
					Policy policy = new Policy();// PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
					policy.setPolicyNo(policyNo);
					policy.setInsuredName(quot.getInsuredName());
					policy.setInsuredId("" + quot.getInsuredId());
					policy.setInceptionDate(quot.getPolicyEffDate());
					policy.setExpiryDate(quot.getPolicyEffTo());

					PolicyVehicle pVeh = new PolicyVehicle();
					pVeh.setMakeEn(quot.getVehicleMakeEn());
					pVeh.setModelEn(quot.getVehicleModelEn());
					pVeh.setBodyTypeAr(quot.getVehicleBodyTypeAr());
					pVeh.setBodyTypeEn(quot.getVehicleBodyTypeEn());
					pVeh.setArPlateNo("" + quot.getVehiclePlateNo());
					pVeh.setArPlateL1(quot.getVehiclePlateL1());
					pVeh.setArPlateL2(quot.getVehiclePlateL2());
					pVeh.setArPlateL3(quot.getVehiclePlateL3());
					pVeh.setEnPlateL1(quot.getVehiclePlateL1());
					pVeh.setEnPlateL2(quot.getVehiclePlateL2());
					pVeh.setEnPlateL3(quot.getVehiclePlateL3());
					pVeh.setVehId("" + quot.getVehicleId());
					pVeh.setMfgYear(quot.getVehicleMfgYear());
					pVeh.setChassisNo(quot.getVehicleChassisNo());
					if (quot.getLoadingAmount() != 0) {
						long loadingAmount = (new Double(quot.getLoadingAmount())).longValue();
						pVeh.setLoading(loadingAmount);
					}
					List<PolicyVehicle> pVehs = new ArrayList<>();
					pVehs.add(pVeh);
					policy.setPolicyVehs(pVehs);

					String productType = quot.getProductCode();

					paramsMap.put("pVeh", pVeh);
					paramsMap.put("pType", productType);
					paramsMap.put("page_no", LanguageUtil.get(httpReq, "page_no"));
					fileName = "policy_certificate";
					reportName = fileName + "_" + productType;
					ds.add(policy);

				} else {
					ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
					String currLocale = themeDisplay.getLocale().toString();
					if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL) && currLocale.equals("en_US")) {
						fileName = "quote_dets";
					}
					if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL) && currLocale.equals("ar_SA")) {
						fileName = "quote_dets_ar";
					}
					if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) && currLocale.equals("en_US")) {
						fileName = "quote_dets_od";
					}
					if (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE) && currLocale.equals("ar_SA")) {
						fileName = "quote_dets_od_ar";
					}
					reportName = fileName;
					paramsMap = QuotationLocalServiceUtil.getQuoteDetailsReportParams(httpReq, quot);
					_log.info("reportName >>>>>>>>>>>>" + reportName);
					if (quot.getExistingCompanyName() != null) {
						List<CustomerMapDetails> existComps = QuotationLocalServiceUtil.getInsuranceCompany(quot.getExistingCompanyName());
						String existCoNameVal = "";
						if (existComps != null && !existComps.isEmpty())
							existCoNameVal = existComps.get(0).getName();

						paramsMap.put("existCoNameVal", existCoNameVal);
					}
					ds.add(quot);
				}

				if (quot.getInsuredId() == Long.parseLong(insuredId)) {
					resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"" + reportName + ".pdf\"");
					resourceResponse.setContentType("application/pdf");
					ReportsUtil.fillAndExportPDFReport(fileName + ".jasper", ds, paramsMap, resourceResponse.getPortletOutputStream());
				} else {
					SessionMessages.add(resourceRequest, "cannot download pdf");
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		} finally {
			com.liferay.petra.io.StreamUtil.cleanUp(inputStream);
		}
	}

	private void notifyUser(HttpServletRequest httpRequest, Quotation quot, Locale local, User user) {
		try {
			Map<String, Object> paramsMap = QuotationLocalServiceUtil.getQuoteDetailsReportParams(httpRequest, quot);
			double driverAccids = 0.0;
			double passAccids = 0.0;
			if (quot.getCoversList() != null && !quot.getCoversList().isEmpty()) {
				for (QuotationCover qCover : quot.getCoversList()) {
					if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131002"))
						driverAccids = qCover.getCoverPrem();
					else if (qCover.getCoverCode() != null && qCover.getCoverCode().equals("131004"))
						passAccids = qCover.getCoverPrem();
				}
			}
			paramsMap.put("driverAccids", driverAccids);
			paramsMap.put("passAccids", passAccids);
			List<Quotation> ds = new ArrayList<>();
			ds.add(quot);

			File directory = new File(PropsUtil.get("com.ejada.atmc.quote.report.path"));
			if (!directory.exists()) {
				directory.mkdirs();
			}

			File qFile = new File(PropsUtil.get("com.ejada.atmc.quote.report.path") + "/quotation_" + quot.getReferenceNo() + ".pdf");
			if (!qFile.exists())
				qFile.createNewFile();
			FileOutputStream fos = new FileOutputStream(qFile);
			String fileName = "";
			if (local.toString().equals("en_US")) {
				fileName = "quote_dets";
			} else {
				fileName = "quote_dets_ar";
			}
			ReportsUtil.fillAndExportPDFReport(fileName + ".jasper", ds, paramsMap, fos);
			List<File> fileList = new ArrayList<>();
			fileList.add(qFile);
			List<String> fileNames = new ArrayList<String>();
			fileNames.add("quotation_" + quot.getReferenceNo() + ".pdf");

			String notifType = (quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)) ? Type.QUOTATION_GENERATION_TPL.val() : Type.QUOTATION_GENERATION_TPL.val();
			String[] mailParams = { quot.getInsuredName(), PropsUtil.get("dashboardURL") };
			String[] smsParams = { PropsUtil.get("dashboardURL") };
			NotificationsLocalServiceUtil.notifyUser(local, notifType, quot.getInsuredEmail(), quot.getInsuredMobile(), mailParams, smsParams, fileList, fileNames, mailParams, user.getUserId(),
					user.getCompanyId());

			if (qFile.exists())
				qFile.delete();
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	private void renewFailureRedirect(ActionRequest request, ActionResponse response, Policy policy) {
		String policiesPortletId = PolicyListPortletKeys.POLICYLIST;
		long policiesPlid = 0L;
		try {
			String pageName = "/policies";
			ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			Layout policiesPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName);
			LayoutTypePortlet policiesLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(policiesPortletLayout);
			policiesPortletId = policiesLayoutTypePortlet.getPortletIds().get(0);
			policiesPlid = policiesPortletLayout.getPlid();
			_log.info("Pliid==>" + policiesPlid);

			request.getPortletSession().setAttribute("policyDetails", policy, PortletSession.APPLICATION_SCOPE);
			request.getPortletSession().setAttribute("vehicleDetails", policy.getPolicyVehs().get(0), PortletSession.APPLICATION_SCOPE);

			PortletURL detailsUrl = PortletURLFactoryUtil.create(request, policiesPortletId, policiesPlid, PortletRequest.ACTION_PHASE);
			detailsUrl.setWindowState(WindowState.NORMAL);
			detailsUrl.setPortletMode(PortletMode.VIEW);
			detailsUrl.setParameter(ActionRequest.ACTION_NAME, "policyDetails");
			detailsUrl.setParameter("myview", "motor_policy_dets");
			detailsUrl.setParameter("errorCode", (String) request.getAttribute("errorCode"));
			detailsUrl.setParameter("errorMsg", (String) request.getAttribute("errorMsg"));
			detailsUrl.setParameter("renewFailure", "true");
			response.sendRedirect(detailsUrl.toString());
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	private boolean verifyPayFortSignature(String passedSignature, String lang, HttpServletRequest request, String srvCommand) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		boolean signaturesMatching = true;
		// _log.debug("--------------------------------Verify
		// Signature--------------------------------------------------");
		// _log.debug("Passed Signature : " + passedSignature);
		_log.info("verifyPayFortSignature tokenization start");
		String newSignature = "";
		String responsePhrase = PropsUtil.get("com.ejada.atmc.payfort.sha.responsePhrase");
		_log.info("Phrase:" + responsePhrase);
		_log.info("Received signature in response:" + passedSignature);

		newSignature += responsePhrase;

		if (request.getParameter("access_code") != null && !request.getParameter("access_code").equals(""))
			newSignature += "access_code=" + request.getParameter("access_code");
		if (request.getParameter("card_bin") != null && !request.getParameter("card_bin").equals(""))
			newSignature += "card_bin=" + request.getParameter("card_bin");
		if (request.getParameter("card_number") != null && !request.getParameter("card_number").equals(""))
			newSignature += "card_number=" + request.getParameter("card_number");
		if (request.getParameter("expiry_date") != null && !request.getParameter("expiry_date").equals(""))
			newSignature += "expiry_date=" + request.getParameter("expiry_date");
		if (request.getParameter("language") != null && !request.getParameter("language").equals(""))
			newSignature += "language=" + request.getParameter("language");
		if (request.getParameter("merchant_identifier") != null && !request.getParameter("merchant_identifier").equals(""))
			newSignature += "merchant_identifier=" + request.getParameter("merchant_identifier");
		if (request.getParameter("merchant_reference") != null && !request.getParameter("merchant_reference").equals(""))
			newSignature += "merchant_reference=" + request.getParameter("merchant_reference");
		if (request.getParameter("response_code") != null && !request.getParameter("response_code").equals(""))
			newSignature += "response_code=" + request.getParameter("response_code");
		if (request.getParameter("response_message") != null && !request.getParameter("response_message").equals(""))
			newSignature += "response_message=" + request.getParameter("response_message");
		if (request.getParameter("return_url") != null && !request.getParameter("return_url").equals(""))
			newSignature += "return_url=" + request.getParameter("return_url");
		if (request.getParameter("service_command") != null && !request.getParameter("service_command").equals(""))
			newSignature += "service_command=" + request.getParameter("service_command");
		if (request.getParameter("status") != null && !request.getParameter("status").equals(""))
			newSignature += "status=" + request.getParameter("status");
		if (request.getParameter("token_name") != null && !request.getParameter("token_name").equals(""))
			newSignature += "token_name=" + request.getParameter("token_name");

		newSignature += responsePhrase;

		_log.info("New Signature Before Hashing : " + newSignature);

		MessageDigest sha25 = MessageDigest.getInstance("SHA-256");
		sha25.update(newSignature.getBytes("UTF-8"));
		newSignature = new String(Hex.encodeHex(sha25.digest()));

		_log.info("New Signature After Hashing : " + newSignature);
		// _log.debug("--------------------------------End Verify
		// Signature----------------------------------------------");

		if (!newSignature.equalsIgnoreCase(passedSignature)) {
			_log.info("Tokenization Signatures Mismatch. Response compromised");
			signaturesMatching = false;
		}

		_log.info("Tokenization Verification Result:" + signaturesMatching);
		return signaturesMatching;
		// return false;
	}

	private boolean verifyPayfortPurrchaseSignature(PurchaseResponse response) {
		_log.info("verifyPayfortPurrchaseSignature start");
		String newSignature = "";
		boolean signaturesMatching = true;

		try {
			String incomingSignature = response.getSignature();
			String responsePhrase = PropsUtil.get("com.ejada.atmc.payfort.sha.responsePhrase");
			String amountStr = String.valueOf(response.getAmount());

			if (amountStr.indexOf(".") > -1) {
				amountStr = amountStr.substring(0, amountStr.indexOf("."));
				_log.info("Amount final:" + amountStr);
			}

			_log.info("Phrase:" + responsePhrase);
			_log.info("Received signature in response:" + incomingSignature);

			newSignature += responsePhrase;

			if (response.getThreeDsUrl() != null && !response.getThreeDsUrl().equals(""))
				newSignature += "3ds_url=" + response.getThreeDsUrl();
			if (response.getAccessCode() != null && !response.getAccessCode().equals(""))
				newSignature += "access_code=" + response.getAccessCode();
			if (!amountStr.equals("0"))
				newSignature += "amount=" + amountStr;
			if (response.getAuthorizationCode() != null && !response.getAuthorizationCode().equals(""))
				newSignature += "authorization_code=" + response.getAuthorizationCode();
			if (response.getCardNumber() != null && !response.getCardNumber().equals(""))
				newSignature += "card_number=" + response.getCardNumber();
			if (response.getCommand() != null && !response.getCommand().equals(""))
				newSignature += "command=" + response.getCommand();
			if (response.getCurrency() != null && !response.getCurrency().equals(""))
				newSignature += "currency=" + response.getCurrency();
			if (response.getCustomerEmail() != null && !response.getCustomerEmail().equals(""))
				newSignature += "customer_email=" + response.getCustomerEmail();
			if (response.getCustomerIP() != null && !response.getCustomerIP().equals(""))
				newSignature += "customer_ip=" + response.getCustomerIP();
			if (response.getEci() != null && !response.getEci().equals(""))
				newSignature += "eci=" + response.getEci();
			if (response.getExpiryDate() != null && !response.getExpiryDate().equals(""))
				newSignature += "expiry_date=" + response.getExpiryDate();
			if (response.getFortId() != null && !response.getFortId().equals(""))
				newSignature += "fort_id=" + response.getFortId();
			if (response.getLanguage() != null && !response.getLanguage().equals(""))
				newSignature += "language=" + response.getLanguage();
			if (response.getMerchantIdentifier() != null && !response.getMerchantIdentifier().equals(""))
				newSignature += "merchant_identifier=" + response.getMerchantIdentifier();
			if (response.getMerchantReference() != null && !response.getMerchantReference().equals(""))
				newSignature += "merchant_reference=" + response.getMerchantReference();
			if (response.getPaymentOption() != null && !response.getPaymentOption().equals(""))
				newSignature += "payment_option=" + response.getPaymentOption();
			if (response.getResponseCode() != null && !response.getResponseCode().equals(""))
				newSignature += "response_code=" + response.getResponseCode();
			if (response.getResponseMessage() != null && !response.getResponseMessage().equals(""))
				newSignature += "response_message=" + response.getResponseMessage();
			if (response.getStatus() != null && !response.getStatus().equals(""))
				newSignature += "status=" + response.getStatus();
			if (response.getTokenName() != null && !response.getTokenName().equals(""))
				newSignature += "token_name=" + response.getTokenName();

			newSignature += responsePhrase;

			_log.info("New Signature Before Hashing:" + newSignature);

			MessageDigest sha25;

			try {
				sha25 = MessageDigest.getInstance("SHA-256");
				sha25.update(newSignature.getBytes("UTF-8"));
				newSignature = new String(Hex.encodeHex(sha25.digest()));
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}

			_log.info("New Signature After Hashing:" + newSignature);

			if (!newSignature.equalsIgnoreCase(incomingSignature)) {
				_log.info("Purchase Signatures Mismatch. Response compromised");
				signaturesMatching = false;
			}
		} catch (Exception e) {
			_log.info("Exception in verifyPayfortPurrchaseSignature");
			_log.error(e.getMessage(), e);
			signaturesMatching = false;
		}

		_log.info("Purchase Verification Result:" + signaturesMatching);
		return signaturesMatching;
	}

	private static String generateHash(String data) {
		try {
			MessageDigest sha1 = MessageDigest.getInstance("SHA-256");
			sha1.update(data.getBytes("UTF-8"));
			return new String(Hex.encodeHex(sha1.digest()));

		} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
			_log.error("Error Generating quot Hash" + data);

			_log.error(e.getMessage(), e);
		}
		return null;
	}
}
