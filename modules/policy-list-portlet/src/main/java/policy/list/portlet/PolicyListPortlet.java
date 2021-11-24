package policy.list.portlet;

import com.atmc.bsl.db.exception.YaqeenException;
import com.atmc.bsl.db.service.CustomerVehicleDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.NotificationsLocalServiceUtil;
import com.atmc.bsl.db.service.PolicyLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.web.common.EnglishNumberToWords;
import com.atmc.web.common.NotificationTypes.Type;
import com.atmc.web.common.UserInfo;
import com.atmc.web.constants.BuyMotorPolicyPortletKeys;
import com.atmc.web.util.SessionUtil;
import com.ejada.atmc.acl.db.exception.NoSuchPolicyHDRException;
import com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel;
import com.ejada.atmc.acl.db.model.PolicyCancelation;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.PolicyVEH;
import com.ejada.atmc.acl.db.model.PolicyVehCvr;
import com.ejada.atmc.acl.db.model.PolicyVehDrv;
import com.ejada.atmc.acl.db.model.QuotationDriverseEndors;
import com.ejada.atmc.acl.db.service.AtmcYakeenMakeModelLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyCancelationLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyHDRLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVEHLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehCvrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.PolicyVehDrvLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationDriverseEndorsLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.policy.Policy;
import com.ejada.atmc.bsl.db.domain.policy.PolicyVehicle;
import com.ejada.atmc.bsl.db.domain.policy.PolicyVehicleCover;
import com.ejada.atmc.bsl.db.domain.policy.PolicyVehicleDriver;
import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationCover;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.ejada.atmc.utils.api.ReportsUtil;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.jdbc.OutputBlob;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import policy.list.portlet.constants.PolicyListPortletKeys;

/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=ATMC Policy List Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/policy_list.jsp",
		"javax.portlet.name=" + PolicyListPortletKeys.POLICYLIST,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class PolicyListPortlet extends MVCPortlet {

	private SimpleDateFormat	dateFormatter		= new SimpleDateFormat("dd/MM/yyyy");
	private SimpleDateFormat	dateFormatternew	= new SimpleDateFormat("dd/MM/yyyy");
	private static final Log	_log				= LogFactoryUtil.getLog(PolicyListPortlet.class);

	public void policyDetails(ActionRequest req, ActionResponse res) {
		String policyDetails = "";
		String vehicleDetails = null;
		Policy policy = null;
		PolicyVehicle pVeh = null;
		_log.info("ActionRequest.getParameterMap  ::::::::::::::::::::: " + req.getParameterMap().toString());

		if (req.getParameter("policyNo") != null) {
			String policyNo = req.getParameter("policyNo");
			try {
				policy = PolicyLocalServiceUtil.getPolicyByPolicyNo(policyNo);
				req.setAttribute("policy", policy);
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
		} else if ((req.getParameter("renewFailure") != null && req.getParameter("renewFailure").equals("true"))
				|| (req.getParameter("buyMotorRedirect") != null && req.getParameter("buyMotorRedirect").equals("true")))
		{
			policy = (Policy) req.getPortletSession().getAttribute("policyDetails", PortletSession.APPLICATION_SCOPE);
			pVeh = (PolicyVehicle) req.getPortletSession().getAttribute("vehicleDetails", PortletSession.APPLICATION_SCOPE);

			req.setAttribute("policy", policy);
			req.setAttribute("pVeh", pVeh);
			_log.info("renderRequest pVeh set ::::::::::::: " + pVeh.toString());
			if (req.getParameter("renewFailure") != null && req.getParameter("renewFailure").equals("true")) {
				req.setAttribute("errorCode", req.getParameter("errorCode"));
				req.setAttribute("errorMsg", req.getParameter("errorMsg"));
			}

			req.getPortletSession().removeAttribute("policyDetails", PortletSession.APPLICATION_SCOPE);
			req.getPortletSession().removeAttribute("policyDetails", PortletSession.APPLICATION_SCOPE);

			return;
		} else {
			policyDetails = req.getParameter("policyDetails");
			vehicleDetails = req.getParameter("vehicleDetails");

			try {
				if (policyDetails != null) {
					_log.info("policyDetails ::::::::::::: " + policyDetails);
					policy = (Policy) GsonUtilsLocalServiceUtil.fromGson(policyDetails, Policy.class);
					Policy policyCustom = PolicyLocalServiceUtil.getPolicyByPolicyNo(policy.getPolicyNo());
					req.setAttribute("policy", policyCustom);
					if (vehicleDetails != null) {
						pVeh = (PolicyVehicle) GsonUtilsLocalServiceUtil.fromGson(vehicleDetails, PolicyVehicle.class);
						PolicyVehicle pVehCustom = PolicyLocalServiceUtil.getCustomVeh(policyCustom.getPolicyNo(), pVeh.getVehId());
						_log.info("request pVeh set ::::::::::::: " + pVeh.toString());
						req.setAttribute("pVeh", pVehCustom);
					}
				} else {
					req.setAttribute("policy", policy);
				}
			} catch (PortalException e) {
				_log.error(e.getMessage(), e);
			}
		}
	}

	public void quotation(ActionRequest req, ActionResponse res) {
		String policyDetails = req.getParameter("policy");

		Policy policy = (Policy) GsonUtilsLocalServiceUtil.fromGson(policyDetails, Policy.class);

		if (policy != null) {

		}

	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String myview = (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "policy_list";
			_log.info("myview :::::::::::::::::::: " + myview);
			HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
			UserInfo userInfo = SessionUtil.getUserInfo(request);
			String iqamaId;
			if (myview.contains("policy_dets") || myview.equals("vehicle_list")) {
				Policy policy = (Policy) renderRequest.getAttribute("policy");
				renderRequest.setAttribute("policy", policy);

				if (myview.equals("motor_policy_dets")) {
					_log.info(" policy.getPolicyVehs().size() ::::::::::::: " + policy.getPolicyVehs().size());
					PolicyVehicle pVeh = null;
					if (policy.getPolicyVehs() != null && policy.getPolicyVehs().size() > 1) {
						int i = 0;
						for (PolicyVehicle pv : policy.getPolicyVehs()) {
							_log.info("vehicle " + i++ + " " + pv.toString());
							if (!pv.toString().equals(policy.getPolicyVehs().get(0).toString())) {
							}
						}
						pVeh = policy.getPolicyVehs().get(0);
					} else if (policy.getPolicyVehs() != null && policy.getPolicyVehs().size() == 1)
						pVeh = policy.getPolicyVehs().get(0);
					_log.info("renderRequest pVeh set ::::::::::::: " + pVeh.getVehId());
					renderRequest.setAttribute("pVeh", pVeh);
				}
			} else if (myview.equals("quotations")) {
				if (!(userInfo.isOrgMode())) {
					iqamaId = PortalUtil.getUser(renderRequest).getScreenName();
					List<Quotation> quotationsList = QuotationLocalServiceUtil.getQuotationsByIqamaIdAndStatus(Long.valueOf(iqamaId));
					renderRequest.setAttribute("quotationsList", quotationsList);
				}
			} else if (myview.equals("policyCnclList")) {
				String insuredId = renderRequest.getParameter("iqamaId");
				_log.info("insuredId " + insuredId);
				String id = renderRequest.getParameter("insuredId");
				_log.info("insuredId id" + id);
				List<PolicyCancelation> cnclPolicyList = PolicyCancelationLocalServiceUtil.findByInsuredId(id);
				renderRequest.setAttribute("cnclPolicyList", cnclPolicyList);
			} else if (myview.equals("canclePolicyDetails")) {
				String policyNumber = renderRequest.getParameter("policyNumber");
				_log.info("insuredId " + policyNumber);
				PolicyCancelation cnclPolicyList = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
				renderRequest.setAttribute("cnclPolicyDetails", cnclPolicyList);
			} else if (myview.equals("cancelPolicy")) {
				String policyNumber = (String) renderRequest.getParameter("polNumber");
				PolicyHDR policyDetails = PolicyHDRLocalServiceUtil.findByPolicyNo(policyNumber);
				PolicyVEH policyVehDetails = PolicyVEHLocalServiceUtil.findByPolicyNo(policyNumber);
				renderRequest.setAttribute("policyDetails", policyDetails);
				renderRequest.setAttribute("policyVehDetails", policyVehDetails);
				AtmcYakeenMakeModel makeModelDetails = AtmcYakeenMakeModelLocalServiceUtil.findByEskaMakeModelDetails(policyVehDetails.getMake(), policyVehDetails.getVehModel());
				renderRequest.setAttribute("makeModelDetails", makeModelDetails);
				_log.info(makeModelDetails.getYakeenMakeDesc());
				_log.info(makeModelDetails.getYakeenModelEnglish());

			} else if (myview.equals("add_covers")) {
				List<QuotationCover> quotationCovers = QuotationLocalServiceUtil.getCoverList("MCC");
				request.setAttribute("quotationCoverList", quotationCovers);

			} else {
				// _log.debug("performance test: view is policy list");
				if (!(userInfo.isOrgMode()))
					iqamaId = PortalUtil.getUser(renderRequest).getScreenName();
				else
					iqamaId = userInfo.getSelectedOrgCRNumber();
				int pageNo = 1;
				int pagesize = 10;
				int start = 0;
				int endNo = pagesize;
				if (renderRequest.getParameter("pageNo") != null && renderRequest.getParameter("pagesize") != null) {
					pageNo = Integer.valueOf(renderRequest.getParameter("pageNo"));
					pagesize = Integer.valueOf(renderRequest.getParameter("pagesize"));
					endNo = pagesize * pageNo;
					start = endNo - pagesize;
				}

				List<Policy> policyList = PolicyLocalServiceUtil.getPoliciesByIqamaId(iqamaId, start, endNo);
				long count = PolicyLocalServiceUtil.getPoliciesCountByIqamaId(iqamaId);
				renderRequest.setAttribute("policyList", policyList);
				renderRequest.setAttribute("count", count);
			}

			String view = "/" + myview + ".jsp";
			_log.info("view ::::::::::::: " + view);
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);

			dispatcher.forward(renderRequest, renderResponse);
			// super.doView(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		try {
			PolicyVehicleDriver pvehdrv1 = null;
			PolicyVehicleDriver pvehdrv2 = null;
			PolicyVehicleCover pvehcrv1 = null;
			PolicyVehicleCover pvehcrv2 = null;
			String policyNo = resourceRequest.getParameter("policyNo");
			Policy policy = PolicyLocalServiceUtil.findPolicyByPolicyNo(policyNo);
			HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			if (policy.getProduct().equals("" + PolicyListPortletKeys.PRODUCT_CODE_TPL_VAL) || policy.getProduct().equals("" + PolicyListPortletKeys.PRODUCT_CODE_COMPREHENSIVE_VAL)) {
				String vehId = resourceRequest.getParameter("vehId");
				String type = resourceRequest.getParameter("type");

				Map<String, Object> paramsMap = new HashMap<>();
				PolicyVehicle pVeh = null;
				if (policy.getPolicyVehs() != null && !policy.getPolicyVehs().isEmpty()) {
					for (PolicyVehicle veh : policy.getPolicyVehs()) {
						if (veh.getVehId() != null && veh.getVehId().equals(vehId)) {
							pVeh = veh;
							break;
						}
					}
				}

				try {
					List<PolicyVehDrv> drvlist = PolicyVehDrvLocalServiceUtil.findBypolNumber(policyNo);
					_log.info("size>>>>>>>>>>>>" + drvlist.size());
					if (drvlist != null && drvlist.size() == 1) {
						if (policy.getPolicyVehs().get(0).getVehicleDrivers().get(0) != null)
							pvehdrv1 = policy.getPolicyVehs().get(0).getVehicleDrivers().get(0);
					} else {
						if (policy.getPolicyVehs().get(0).getVehicleDrivers().get(0) != null)
							pvehdrv1 = policy.getPolicyVehs().get(0).getVehicleDrivers().get(0);

						if (policy.getPolicyVehs().get(0).getVehicleDrivers().get(1) != null)
							pvehdrv2 = policy.getPolicyVehs().get(0).getVehicleDrivers().get(1);
					}
				} catch (Exception e) {
					e.getMessage();
				}
				try {
					List<PolicyVehCvr> policyCoverslist = PolicyVehCvrLocalServiceUtil.findByPolicyNumber(policyNo);
					_log.info("size>>>>>>>>>>>>" + policyCoverslist.size());
					if (policyCoverslist != null && policyCoverslist.size() == 1) {
						if (policy.getPolicyVehs().get(0).getVehicleCovers() != null)
							pvehcrv1 = policy.getPolicyVehs().get(0).getVehicleCovers().get(0);
					} else {
						if (policy.getPolicyVehs().get(0).getVehicleDrivers().get(0) != null)
							pvehcrv1 = policy.getPolicyVehs().get(0).getVehicleCovers().get(0);

						if (policy.getPolicyVehs().get(0).getVehicleDrivers().get(1) != null)
							pvehcrv2 = policy.getPolicyVehs().get(0).getVehicleCovers().get(1);
					}
				} catch (Exception e) {
					e.getMessage();
				}
				List<Object> ds = new ArrayList<>();
				String productType = (policy.getProduct().equals("" + PolicyListPortletKeys.PRODUCT_CODE_TPL_VAL)) ? "TP" : "OD";
				String fileName = "policy_" + type + "_" + productType + ".jasper";

				if (type != null && type.equals("vehicle_fleet_listing")) {
					User user = PortalUtil.getUser(resourceRequest);
					paramsMap.put("sr_no", LanguageUtil.get(httpReq, "sr_no"));
					paramsMap.put("veh_make_model", LanguageUtil.get(httpReq, "veh_make_model"));
					paramsMap.put("year", LanguageUtil.get(httpReq, "year"));
					paramsMap.put("eng_no", LanguageUtil.get(httpReq, "eng_no"));
					paramsMap.put("plate_no", LanguageUtil.get(httpReq, "plate_no"));
					paramsMap.put("chassis_no", LanguageUtil.get(httpReq, "chassis_no"));
					paramsMap.put("seq_num", LanguageUtil.get(httpReq, "seq_num"));
					paramsMap.put("cust_id", LanguageUtil.get(httpReq, "cust_id"));
					paramsMap.put("date_add_del", LanguageUtil.get(httpReq, "date_add_del"));
					paramsMap.put("veh_val_si", LanguageUtil.get(httpReq, "veh_val_si"));
					paramsMap.put("seat_cap", LanguageUtil.get(httpReq, "seat_cap"));
					paramsMap.put("pab_prem", LanguageUtil.get(httpReq, "pab_prem"));
					paramsMap.put("driver_prem", LanguageUtil.get(httpReq, "driver_prem"));
					paramsMap.put("pass_prem", LanguageUtil.get(httpReq, "pass_prem"));
					paramsMap.put("geo_prem", LanguageUtil.get(httpReq, "geo_prem"));
					paramsMap.put("own_dam_prem", LanguageUtil.get(httpReq, "own_dam_prem"));
					paramsMap.put("pab_driv_pass", LanguageUtil.get(httpReq, "pab_driv_pass"));
					paramsMap.put("pab_dri", LanguageUtil.get(httpReq, "pab_dri"));
					paramsMap.put("tot_prem", LanguageUtil.get(httpReq, "tot_prem"));
					paramsMap.put("deductible", LanguageUtil.get(httpReq, "deductible"));
					paramsMap.put("agency_repair", LanguageUtil.get(httpReq, "agency_repair"));
					paramsMap.put("user_id", LanguageUtil.get(httpReq, "user_id"));
					paramsMap.put("run_date", LanguageUtil.get(httpReq, "run_date"));
					paramsMap.put("attach_to_from_pol", LanguageUtil.get(httpReq, "attach_to_from_pol"));
					paramsMap.put("rep_id", LanguageUtil.get(httpReq, "rep_id"));
					paramsMap.put("total", LanguageUtil.get(httpReq, "total"));
					paramsMap.put("insured_name", LanguageUtil.get(httpReq, "insured_name"));
					paramsMap.put("policy_no", LanguageUtil.get(httpReq, "policy_no"));

					paramsMap.put("userId", user.getScreenName());
					paramsMap.put("insuredName", policy.getInsuredName());
					paramsMap.put("inceptionDate", policy.getInceptionDate());
					paramsMap.put("totalPrem", policy.getTotalPremium());
					paramsMap.put("policyNo", policy.getPolicyNo());

					ds.add(pVeh);
				} else if (type != null && type.equals("tax")) {
					paramsMap.put("pType", productType);
					paramsMap.put("inv_no", LanguageUtil.get(httpReq, "inv_no"));
					paramsMap.put("date", LanguageUtil.get(httpReq, "date"));
					paramsMap.put("date", LanguageUtil.get(httpReq, "date"));
					paramsMap.put("vat_no", LanguageUtil.get(httpReq, "vat_no"));
					paramsMap.put("tel_no", LanguageUtil.get(httpReq, "tel_no"));
					paramsMap.put("email", LanguageUtil.get(httpReq, "email"));
					paramsMap.put("to", LanguageUtil.get(httpReq, "to"));
					paramsMap.put("total", LanguageUtil.get(httpReq, "total"));
					paramsMap.put("policy_no", LanguageUtil.get(httpReq, "policy_no"));
					paramsMap.put("insured", LanguageUtil.get(httpReq, "insured"));
					paramsMap.put("policyNo", policy.getPolicyNo());

					fileName = "policy_" + type + ".jasper";
					ds.add(policy);
				} else {
					String totalPremiumS = String.valueOf(policy.getTotalPremium());
					if (totalPremiumS != null && totalPremiumS.contains(".")) {
						String[] splitArray = totalPremiumS.split("\\.");
						String totalPremium = EnglishNumberToWords.convert(Long.valueOf(splitArray[0]));
						String totalPremiumDecim = EnglishNumberToWords.convert(Long.valueOf(splitArray[1]));
						paramsMap.put("totalPremium", totalPremium);
						paramsMap.put("totalPremiumDecim", totalPremiumDecim);
					} else {
						String totalPremium = EnglishNumberToWords.convert(policy.getTotalPremium());
						paramsMap.put("totalPremium", totalPremium);
					}

					paramsMap.put("pVeh", pVeh);
					paramsMap.put("pvehdrv1", pvehdrv1);
					paramsMap.put("pvehdrv2", pvehdrv2);
					paramsMap.put("pvehcrv1", pvehcrv1);
					paramsMap.put("pvehcrv2", pvehcrv2);
					paramsMap.put("pType", productType);
					paramsMap.put("premium", pVeh.getPremium());
					paramsMap.put("discounts", pVeh.getDiscounts());
					if (type != null && type.equals("certificate"))
						fileName = "policy_" + type + ".jasper";
					ds.add(policy);
				}
				paramsMap.put("page_no", LanguageUtil.get(httpReq, "page_no"));

				resourceResponse.setProperty("Content-Disposition", "attachment; filename=\"policy_" + type + "_" + productType + ".pdf" + "\"");
				resourceResponse.setContentType("application/pdf");
				ReportsUtil.fillAndExportPDFReport(fileName, ds, paramsMap, resourceResponse.getPortletOutputStream());
			}

		} catch (Exception e) {
			_log.error(e.getMessage());
			_log.error(e.getMessage(), e);
		}
	}

	public void cancelPolicyDets(ActionRequest request, ActionResponse response) throws FileNotFoundException, PortalException, java.text.ParseException {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		Date policyExpiryDate = ParamUtil.getDate(request, "polExpiryDate", dateFormatter);
		String policyNumber = ParamUtil.getString(request, "policy_no");
		String insuredId = ParamUtil.getString(request, "insuredId");
		String policyHolderName = ParamUtil.getString(request, "policyHolderName");
		String vehMake = ParamUtil.getString(request, "veh_make");
		String vehModel = ParamUtil.getString(request, "veh_model");
		String chassisNumber = ParamUtil.getString(request, "chassis_number");
		String plateNumber = ParamUtil.getString(request, "plate_number");
		/*
		 * String cancEffDateH = ParamUtil.getString(request, "TransDobH"); String cancEffDateG = ParamUtil.getString(request,
		 * "TransDobG");
		 */
		String rejectionReason = ParamUtil.getString(request, "rejectionReason");
		String insuredEmail = ParamUtil.getString(request, "insuredEmail");
		String insuredMobile = ParamUtil.getString(request, "insuredMobile");
		String vehicleSequence = ParamUtil.getString(request, "vehSequence");
		String any_acccident = ParamUtil.getString(request, "any_acccident");
		String lodg_comp = ParamUtil.getString(request, "lodg_comp");
		Date policyStartDate = ParamUtil.getDate(request, "polIssueDate", dateFormatter);
		String policyCancellationEffDate = ParamUtil.getString(request, "TransDobG");
		String policyCancellationEffDateH = ParamUtil.getString(request, "TransDobH");
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

		_log.info("policyCancellationEffDate >>>>>>>>>>>>>>" + policyCancellationEffDate);
		_log.info("policyCancellationEffDateH >>>>>>>>>>>>>>" + policyCancellationEffDateH);
		InputStream inputStream;
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(request);
		// ByteArrayFileInputStream inputStream = null;
		File ibanFile = uploadPortletRequest.getFile("ibanfile");
		File validFile = uploadPortletRequest.getFile("validImageFile");
		_log.info("iban file name " + ibanFile.getName());
		HashSet<String> acceptedTypes = new HashSet<>();
		acceptedTypes.add("application/pdf");
		acceptedTypes.add("image/png");
		acceptedTypes.add("image/jpg");
		acceptedTypes.add("image/jpeg");
		inputStream = new FileInputStream(ibanFile);
		OutputBlob ibanImage = new OutputBlob(inputStream, ibanFile.length());
		inputStream = new FileInputStream(validFile);
		OutputBlob validImage = new OutputBlob(inputStream, validFile.length());
		PolicyCancelation policydetails = null;

		try {
			policydetails = PolicyCancelationLocalServiceUtil.findByPolicyNum(policyNumber);
		} catch (Exception e) {
			e.getMessage();
		}

		if (policydetails != null && !policydetails.getStatus().equals("EX")) {
			request.setAttribute("myview", "policy_list");
			request.setAttribute("policyCancReq", true);
			return;
		}
		PolicyCancelation policyCancelation = PolicyCancelationLocalServiceUtil.createPolicyCancelation(String.valueOf(CounterLocalServiceUtil.increment()));
		policyCancelation.setPolicyNumber(policyNumber);
		policyCancelation.setInsuredName(policyHolderName);
		policyCancelation.setCancllationReqDate(new Date());
		policyCancelation.setCancellationEffdate(dateFormat.parse(policyCancellationEffDate));
		policyCancelation.setIbanImage(ibanImage);
		policyCancelation.setPolicyExpiryDate(policyExpiryDate);
		policyCancelation.setVehMake(vehMake);
		policyCancelation.setVehModel(vehModel);
		policyCancelation.setVehicleChessisNo(chassisNumber);
		policyCancelation.setPlateNumber(plateNumber);
		policyCancelation.setPolicyInceptionDate(policyStartDate);
		policyCancelation.setIbanFileName(ibanFile.getName());
		policyCancelation.setValidFile(validImage);
		policyCancelation.setValidFileName(validFile.getName());
		policyCancelation.setStatus("PU");
		policyCancelation.setInsuredEmail(insuredEmail);
		policyCancelation.setInsuredMobile(insuredMobile);
		policyCancelation.setAnyAccident(any_acccident);
		policyCancelation.setLodgeClaim(lodg_comp);
		policyCancelation.setVehicleChessisNo(chassisNumber);
		policyCancelation.setVehicleSequence(vehicleSequence);
		policyCancelation.setInsuredId(insuredId);
		policyCancelation.setReason(rejectionReason);

		_log.info("before adding ");
		try {
			String currentDate = dateFormatternew.format(new Date());
			PolicyCancelationLocalServiceUtil.addPolicyCancelation(policyCancelation);
			String[] mailParams = { policyCancelation.getInsuredName(), policyCancelation.getPolicyNumber() };
			String[] smsParams = { policyCancelation.getPolicyNumber() };
			String[] mailparamsForserviceportal = { policyCancelation.getPolicyNumber(), currentDate };
			List<File> fileList = new ArrayList<>();
			List<String> fileNames = new ArrayList<>();
			NotificationsLocalServiceUtil.notifyUser(request.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_RECIEVED), insuredEmail, insuredMobile, mailParams, smsParams, fileList, fileNames,
					mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
			NotificationsLocalServiceUtil.notifyUser(request.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL), PropsUtil.get("customerCare"), "",
					mailparamsForserviceportal, null, null, null, null, 0, 0);
			NotificationsLocalServiceUtil.notifyUser(request.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL), PropsUtil.get("retailoperation"), "",
					mailparamsForserviceportal, null, null, null, null, 0, 0);
			_log.info("Policy Cancellation Added Successfully");
			request.setAttribute("result", true);
			request.setAttribute("myview", "policy_list");

		} catch (Exception e) {
			request.setAttribute("result", false);
			request.setAttribute("myview", "policy_list");
		}

	}

	public void addDriverForm(ActionRequest actionRequest, ActionResponse actionResponse) throws FileNotFoundException {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		int driverIdType = ParamUtil.getInteger(actionRequest, "driverIdType");
		String driverId = ParamUtil.getString(actionRequest, "driverId");
		Date dob = ParamUtil.getDate(actionRequest, "driverDob", dateFormatternew);
		Date dobH = ParamUtil.getDate(actionRequest, "driverDobH", dateFormatternew);
		_log.info("dob details " + dob);
		_log.info("dobH details " + dobH);
		String driverEdu = ParamUtil.getString(actionRequest, "driverEdu");
		String driverNoChild = ParamUtil.getString(actionRequest, "driverNoChild");
		String insuredRelative = ParamUtil.getString(actionRequest, "insuredRelative");
		UploadPortletRequest uploadPortletRequest = PortalUtil.getUploadPortletRequest(actionRequest);
		String driverMarStats = ParamUtil.getString(actionRequest, "driverMarStats");
		String driverLicCountry = ParamUtil.getString(actionRequest, "driverLicCountry");
		String policyNumber = actionRequest.getParameter("polNumber");
		/* String policyNumber = ParamUtil.getString(actionRequest, "polNumber"); */
		_log.info("policyNumber>>>>>>>>>>>>>" + policyNumber);
		PolicyHDR poldetails = null;
		try {
			poldetails = PolicyHDRLocalServiceUtil.findByPolicyNo(policyNumber);
		} catch (NoSuchPolicyHDRException e1) {
			e1.printStackTrace();
		}
		/* Address Details */
		String buildNo = ParamUtil.getString(actionRequest, "buildNo");
		String stName = ParamUtil.getString(actionRequest, "stName");
		String district = ParamUtil.getString(actionRequest, "district");
		String city = ParamUtil.getString(actionRequest, "city");
		String zipCode = ParamUtil.getString(actionRequest, "zipCode");
		String addNo = ParamUtil.getString(actionRequest, "addNo");
		boolean relative = false;
		OutputBlob ibanImage = null;
		QuotationDriverseEndors quotationDrivers = QuotationDriverseEndorsLocalServiceUtil.createQuotationDriverseEndors(CounterLocalServiceUtil.increment());
		quotationDrivers.setDriverIdType(driverIdType);
		quotationDrivers.setDriverId(driverId);
		quotationDrivers.setDriverDob(dob);
		quotationDrivers.setDriverDobH(String.valueOf(dobH));
		quotationDrivers.setDriverEdu(driverEdu);
		if (insuredRelative != null && !insuredRelative.equals(BuyMotorPolicyPortletKeys.INSURED_RELATION_0))
			relative = true;
		else
			relative = false;
		quotationDrivers.setInsuredRelation(insuredRelative);
		quotationDrivers.setDriverMaritalStatus(driverMarStats);
		quotationDrivers.setDriverNationality(driverLicCountry);

		try {
			File relationShipfile = uploadPortletRequest.getFile("selectedFile");
			InputStream inputStream = new FileInputStream(relationShipfile);
			ibanImage = new OutputBlob(inputStream, relationShipfile.length());
			quotationDrivers.setInsuredRelationProofFileName(relationShipfile.getName());
			quotationDrivers.setInsuredRelationProof(ibanImage);
		} catch (Exception e) {
			e.getMessage();
		}
		quotationDrivers.setDriverNoChild(driverNoChild);
		quotationDrivers.setStatus("PU");
		if (Pattern.compile("^[0-9]+$").matcher(buildNo).find())
			quotationDrivers.setBuildNo(buildNo);
		quotationDrivers.setStNameEn(stName);
		quotationDrivers.setDistrictEn(district);
		quotationDrivers.setCityEn(city);
		if (Pattern.compile("^[0-9]+$").matcher(zipCode).find() && zipCode.length() == 5)
			quotationDrivers.setZipCode(zipCode);
		if (Pattern.compile("^[0-9]+$").matcher(addNo).find())
			quotationDrivers.setAddNo(addNo);
		quotationDrivers.setRequestedDate(new Date());
		quotationDrivers.setPolicyNumber(policyNumber);
		QuotationDriver quotDriver = new QuotationDriver();
		quotDriver.setDriverId(Long.valueOf(driverId));
		quotDriver.setDriverDob(dob);
		quotDriver.setDriverDobH(dateFormatternew.format(dobH));
		HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(actionRequest);
		try {
			CustomerVehicleDetailsLocalServiceUtil.getDriverVehicleDetails(quotDriver, httpReq, relative);
			quotationDrivers.setDriverName(quotDriver.getDriverName());
			quotationDrivers.setDriverGender(quotDriver.getDriverGender());
			quotationDrivers.setDriverNationality(quotDriver.getDriverNationality());
			quotationDrivers.setNcdYears(quotDriver.getNcdYears());
		} catch (YaqeenException e) {
			_log.error(e.getMessage(), e);
		}

		QuotationDriverseEndorsLocalServiceUtil.addQuotationDriverseEndors(quotationDrivers);
		String[] mailParams = { poldetails.getInsuredName(), poldetails.getPolicyNo() };
		String[] smsParams = { poldetails.getPolicyNo() };
		List<File> fileList = new ArrayList<>();
		List<String> fileNames = new ArrayList<>();
		String currentDate = dateFormatternew.format(new Date());
		String[] mailparamsForserviceportal = { poldetails.getPolicyNo(), currentDate };
		/*
		 * SMSLocalServiceUtil.sendSms(LanguageUtil.get(request.getLocale(), ""), "0567462212");
		 */
		try {
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_ENDORSEMENT_RECIEVED), poldetails.getInsuredEmail(), poldetails.getInsuredMobile(),
					mailParams, smsParams, fileList, fileNames, mailParams, themeDisplay.getUser().getUserId(), themeDisplay.getUser().getCompanyId());
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_OTHER_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL), PropsUtil.get("customerCare"), "",
					mailparamsForserviceportal, null, null, null, null, 0, 0);
			NotificationsLocalServiceUtil.notifyUser(actionRequest.getLocale(), String.valueOf(Type.POILCY_OTHER_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL), PropsUtil.get("retailoperation"), "",
					mailparamsForserviceportal, null, null, null, null, 0, 0);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}
		_log.info("Policy Cancellation Added Successfully");
		actionRequest.setAttribute("result", true);
		actionRequest.setAttribute("myview", "policy_list");
		_log.info("Quotation Driver Endorsement Details Added ");
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}