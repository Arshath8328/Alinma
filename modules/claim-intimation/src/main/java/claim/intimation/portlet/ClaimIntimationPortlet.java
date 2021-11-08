package claim.intimation.portlet;

import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.custom.model.ODSPolActiveVehicleDTO;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.ejada.atmc.acl.db.service.SendEmailServiceUtil;
import com.liferay.document.library.kernel.model.DLFolderConstants;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
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
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.PortalUtil;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PropsUtil;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.Part;

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

	@Reference
	private DLAppService _dlAppService;

	@Reference
	private Portal _portal;

	private static final Log _log = LogFactoryUtil.getLog(ClaimIntimationPortlet.class);

	private static final String CODE_FREEZ_YN = "N";
	private static boolean isDataSetEN;
	private static boolean isDataSetAR;
	Map<String, String> manufactMap = new HashMap<>();
	public static Map<String, String> manufactMapAR = new HashMap<>();
	List<CodeMasterDetails> vehicleModelList = new ArrayList<>();
	List<CodeMasterDetails> vehicleMakeList = new ArrayList<>();
	List<CodeMasterDetails> natureOfLossList;
	List<CodeMasterDetails> cityList;
	List<CodeMasterDetails> nationalityList;
	List<CodeMasterDetails> causeOfLossList;
	List<CodeMasterDetails> claimTypeList;
	List<CodeMasterDetails> bankList;
	
	public static Map<String, String> causeOfLossCodeValuePair = new HashMap<>();
	public static Map<String, String> causeOfLossCodeValuePairAR = new HashMap<>();
	
	public static Map<String, String> claimTypeCodeValuePair = new HashMap<>();
	public static Map<String, String> claimTypeCodeValuePairAR = new HashMap<>();
	
	public static Map<String, String> bankNameCodeValuePair = new HashMap<>();
	public static Map<String, String> bankNameCodeValuePairAR = new HashMap<>();
	
	public static Map<String, String> accidentCityCodeValuePair = new HashMap<>();
	public static Map<String, String> accidentCityCodeValuePairAR = new HashMap<>();
	
	public static Map<String, String> genderMap = new HashMap<>();
	public static Map<String, String> sourceOfAccidentReportMap = new HashMap<>();
	public static Map<String, String> sourceOfAccidentReportMapAR = new HashMap<>();
	
	public static Map<String, String> vehicleModelMap = new HashMap<>();
	public static Map<String, String> vehicleModelMapAR = new HashMap<>();
	
	public static Map<String, String> nationalityMap = new HashMap<>();
	public static Map<String, String> nationalityMapAR = new HashMap<>();
	
	public static Map<String, String> vehicleMakeMap = new HashMap<>();
	public static Map<String, String> vehicleMakeMapAR = new HashMap<>();
	public static Map<String, String> ODClaims = new HashMap<>();
	public static Map<String, String> ODClaimsAR = new HashMap<>();
	public static Map<String, String> TheftAccidents = new HashMap<>();
	public static Map<String, String> TheftAccidentsAR = new HashMap<>();
	public static Map<String, String> DeathOrBodilyInjuries = new HashMap<>();
	public static Map<String, String> DeathOrBodilyInjuriesAR = new HashMap<>();
	public static Map<String, String> TPLClaims = new HashMap<>();
	public static Map<String, String> TPLClaimsAR = new HashMap<>();
	public static Map<String, String> FireOrFloodAccidents = new HashMap<>();
	public static Map<String, String> FireOrFloodAccidentsAR = new HashMap<>();
	public static Map<String, List<CodeMasterDetails>>  vehicleMakeModelPair = new HashMap<>();
	public static Map<String, List<CodeMasterDetails>>  vehicleMakeModelPairAR = new HashMap<>();
	public static Map<String, Set<Map<String, String>>> requiredDocumentsMap = new HashMap<>();
	
	public static List<CodeMasterDetails> phoneCodes = new ArrayList<>();
	public static List<CodeMasterDetails> plateLetters = new ArrayList<>();

	//following static Maps will never change
	static {
		_log.info("claim Intimation Portlet initial isDataSet : false");
		isDataSetEN = false;
		isDataSetAR = false;

		genderMap.put("1", "Male");
		genderMap.put("2", "Female");
		genderMap.put("3", "Other");

		sourceOfAccidentReportMap.put("1", "NAJM");
		sourceOfAccidentReportMap.put("2", "MUROOR");
		sourceOfAccidentReportMap.put("3", "CIVIL DEFENCE");
		sourceOfAccidentReportMap.put("4", "POLICE");
	}

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String myViewParameter = (ParamUtil.getString(renderRequest, "myview", null) != null) ? ParamUtil.getString(renderRequest, "myview") : "view2";
			String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview") : myViewParameter;
			
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String currLocale = themeDisplay.getLocale().toString();

			//set English & Arabic data only once while portlet is rendered for the first time.
			if (currLocale.equals("en_US")) {
				setEnglishData(renderRequest, renderResponse);
			} else {
				setArabicData(renderRequest, renderResponse);
			}
			
			
			/*
			 * Based on claim-type selection, required documents are listed in the tooltip message,
			 * LinkedHashSet is set to maintain the order of insertion.
			 */
			requiredDocumentsMap.put("1", new LinkedHashSet<>(Arrays.asList(ODClaims, ODClaimsAR)));
			requiredDocumentsMap.put("2", new LinkedHashSet<>(Arrays.asList(TPLClaims, TPLClaimsAR)));
			requiredDocumentsMap.put("3", new LinkedHashSet<>(Arrays.asList(TheftAccidents, TheftAccidentsAR)));
			requiredDocumentsMap.put("4", new LinkedHashSet<>(Arrays.asList(FireOrFloodAccidents, FireOrFloodAccidentsAR)));
			requiredDocumentsMap.put("5", new LinkedHashSet<>(Arrays.asList(DeathOrBodilyInjuries, DeathOrBodilyInjuriesAR)));

			renderRequest.setAttribute("manufactMap", manufactMap);
			renderRequest.setAttribute("cityList", cityList);
			renderRequest.setAttribute("natureOfLossList", natureOfLossList);
			renderRequest.setAttribute("vehicleModelList", vehicleModelList);
			renderRequest.setAttribute("nationalityList", nationalityList);
			renderRequest.setAttribute("causeOfLossList", causeOfLossList);
			renderRequest.setAttribute("claimTypeList", claimTypeList);
			renderRequest.setAttribute("bankList", bankList);

			// Fetch claimIntimationMtr object created while intimating a claim and redirect to claim_intimated (intimation-successful) screen
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
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	private void setArabicData(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		if (!isDataSetAR) {
			phoneCodes = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PHONE_CODE);
			plateLetters = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PLATE_LETTER);
			vehicleMakeList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
			vehicleModelList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MOD", CODE_FREEZ_YN);
			natureOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CODE_NAT_OF_LOSS);
			cityList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CITY);
			nationalityList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.NATIONALITY);
			claimTypeList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CLM_INTM_TYPE);
			bankList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.BANK_LST);
			causeOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CLM_INTM_CAUSE);

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", themeDisplay.getLocale(), getClass());

			ODClaimsAR.put("original.accident.report", LanguageUtil.get(resourceBundle, "original.accident.report"));
			ODClaimsAR.put("accident.kurooki.for.traffic.police.cases", LanguageUtil.get(resourceBundle, "accident.kurooki.for.traffic.police.cases"));
			ODClaimsAR.put("repair.permission", LanguageUtil.get(resourceBundle, "repair.permission"));
			ODClaimsAR.put("vehicle.registration", LanguageUtil.get(resourceBundle, "vehicle.registration"));
			ODClaimsAR.put("driver.license", LanguageUtil.get(resourceBundle, "driver.license"));
			ODClaimsAR.put("copy.of.tp.recovery", LanguageUtil.get(resourceBundle, "copy.of.tp.recovery"));

			TPLClaimsAR.put("original.accident.report", LanguageUtil.get(resourceBundle, "original.accident.report"));
			TPLClaimsAR.put("vehicle.registration", LanguageUtil.get(resourceBundle, "vehicle.registration"));
			TPLClaimsAR.put("damage.estimation", LanguageUtil.get(resourceBundle, "damage.estimation"));
			TPLClaimsAR.put("photos.of.the.damaged.vehicle", LanguageUtil.get(resourceBundle, "photos.of.the.damaged.vehicle"));
			TPLClaimsAR.put("id.of.vehicle.owner", LanguageUtil.get(resourceBundle, "id.of.vehicle.owner"));
			TPLClaimsAR.put("owner.iban.copy", LanguageUtil.get(resourceBundle, "owner.iban.copy"));

			TheftAccidentsAR.put("theft.reports", LanguageUtil.get(resourceBundle, "theft.reports"));
			
			FireOrFloodAccidentsAR.put("civil.defense.report", LanguageUtil.get(resourceBundle, "civil.defense.report"));
			
			DeathOrBodilyInjuriesAR.put("original.medical.report", LanguageUtil.get(resourceBundle, "original.medical.report"));
			DeathOrBodilyInjuriesAR.put("death.certificate", LanguageUtil.get(resourceBundle, "death.certificate"));
			
			for (CodeMasterDetails codeMasterDtls : causeOfLossList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				causeOfLossCodeValuePairAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}

			for (CodeMasterDetails codeMasterDtls : claimTypeList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				claimTypeCodeValuePairAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}
			for (CodeMasterDetails codeMasterDtls : bankList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				bankNameCodeValuePairAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}
			for (CodeMasterDetails codeMasterDtls : cityList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				accidentCityCodeValuePairAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}

			for (CodeMasterDetails codeMasterDtls : vehicleMakeList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				manufactMapAR.put(codeMasterDtls.getCodeDescAr(), codeMasterDtls.getCodeSub());
				vehicleMakeMapAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
				
				for (CodeMasterDetails vehicleModel : vehicleModelList) {
					List<CodeMasterDetails> vehicleModelsForMake = new ArrayList<>();
					if(codeMasterDtls.getCodeSub().equals(vehicleModel.getCodeSubRef())) {
						if(vehicleMakeModelPair.get(vehicleModel.getCodeSubRef())!=null)
							vehicleModelsForMake.addAll(vehicleMakeModelPair.get(vehicleModel.getCodeSubRef()));
						vehicleModelsForMake.add(vehicleModel);
						vehicleMakeModelPair.put(vehicleModel.getCodeSubRef(), vehicleModelsForMake);
					}
				}
			}
			for (CodeMasterDetails codeMasterDtls : nationalityList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				nationalityMapAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}
			for (CodeMasterDetails codeMasterDtls : vehicleModelList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				vehicleModelMapAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
			}
			Collections.sort(cityList, new Comparator<CodeMasterDetails>() {
				@Override
				public int compare(CodeMasterDetails o1, CodeMasterDetails o2) {
					return o1.getCodeDescAr().compareToIgnoreCase(o2.getCodeDescAr());
				}
			});

			Collections.sort(phoneCodes, new Comparator<CodeMasterDetails>() {
				@Override
				public int compare(CodeMasterDetails o1, CodeMasterDetails o2) {
					return Integer.compare(Integer.parseInt(o1.getCodeSub()), Integer.parseInt(o2.getCodeSub()));
				}
			});

			_log.info("Arabic data set ");
			isDataSetAR = true;			
		}
	}

	private void setEnglishData(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		if (!isDataSetEN) {
			phoneCodes = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PHONE_CODE);
			plateLetters = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PLATE_LETTER);
			vehicleMakeList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
			vehicleModelList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MOD", CODE_FREEZ_YN);
			natureOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CODE_NAT_OF_LOSS);
			cityList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CITY);
			nationalityList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.NATIONALITY);
			claimTypeList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CLM_INTM_TYPE);
			bankList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.BANK_LST);
			causeOfLossList = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.CLM_INTM_CAUSE);

			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			ResourceBundle resourceBundle = ResourceBundleUtil.getBundle("content.Language", themeDisplay.getLocale(), getClass());

			ODClaims.put("original.accident.report", LanguageUtil.get(resourceBundle, "original.accident.report"));
			ODClaims.put("accident.kurooki.for.traffic.police.cases", LanguageUtil.get(resourceBundle, "accident.kurooki.for.traffic.police.cases"));
			ODClaims.put("repair.permission", LanguageUtil.get(resourceBundle, "repair.permission"));
			ODClaims.put("vehicle.registration", LanguageUtil.get(resourceBundle, "vehicle.registration"));
			ODClaims.put("driver.license", LanguageUtil.get(resourceBundle, "driver.license"));
			ODClaims.put("copy.of.tp.recovery", LanguageUtil.get(resourceBundle, "copy.of.tp.recovery"));

			TheftAccidents.put("theft.reports", LanguageUtil.get(resourceBundle, "theft.reports"));
			FireOrFloodAccidents.put("civil.defense.report", LanguageUtil.get(resourceBundle, "civil.defense.report"));
			DeathOrBodilyInjuries.put("original.medical.report", LanguageUtil.get(resourceBundle, "original.medical.report"));
			DeathOrBodilyInjuries.put("death.certificate", LanguageUtil.get(resourceBundle, "death.certificate"));

			TPLClaims.put("original.accident.report", LanguageUtil.get(resourceBundle, "original.accident.report"));
			TPLClaims.put("vehicle.registration", LanguageUtil.get(resourceBundle, "vehicle.registration"));
			TPLClaims.put("damage.estimation", LanguageUtil.get(resourceBundle, "damage.estimation"));
			TPLClaims.put("photos.of.the.damaged.vehicle", LanguageUtil.get(resourceBundle, "photos.of.the.damaged.vehicle"));
			TPLClaims.put("id.of.vehicle.owner", LanguageUtil.get(resourceBundle, "id.of.vehicle.owner"));
			TPLClaims.put("owner.iban.copy", LanguageUtil.get(resourceBundle, "owner.iban.copy"));
			
			for (CodeMasterDetails codeMasterDtls : causeOfLossList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				causeOfLossCodeValuePair.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}

			for (CodeMasterDetails codeMasterDtls : claimTypeList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				claimTypeCodeValuePair.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			for (CodeMasterDetails codeMasterDtls : bankList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				bankNameCodeValuePair.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			for (CodeMasterDetails codeMasterDtls : cityList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				accidentCityCodeValuePair.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}

			for (CodeMasterDetails codeMasterDtls : vehicleModelList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				vehicleModelMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			
			for (CodeMasterDetails codeMasterDtls : vehicleMakeList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				manufactMap.put(codeMasterDtls.getCodeDesc(), codeMasterDtls.getCodeSub());
				vehicleMakeMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
				
				for (CodeMasterDetails vehicleModel : vehicleModelList) {
					List<CodeMasterDetails> vehicleModelsForMake = new ArrayList<>();
					if(codeMasterDtls.getCodeSub().equals(vehicleModel.getCodeSubRef())) {
						if(vehicleMakeModelPair.get(vehicleModel.getCodeSubRef())!=null)
							vehicleModelsForMake.addAll(vehicleMakeModelPair.get(vehicleModel.getCodeSubRef()));
						vehicleModelsForMake.add(vehicleModel);
						vehicleMakeModelPair.put(vehicleModel.getCodeSubRef(), vehicleModelsForMake);
					}
				}
			}
			
			for (CodeMasterDetails codeMasterDtls : nationalityList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				nationalityMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			Collections.sort(cityList, new Comparator<CodeMasterDetails>() {
				@Override
				public int compare(CodeMasterDetails o1, CodeMasterDetails o2) {
					return o1.getCodeDesc().compareToIgnoreCase(o2.getCodeDesc());
				}
			});

			Collections.sort(phoneCodes, new Comparator<CodeMasterDetails>() {
				@Override
				public int compare(CodeMasterDetails o1, CodeMasterDetails o2) {
					return Integer.compare(Integer.parseInt(o1.getCodeSub()), Integer.parseInt(o2.getCodeSub()));
				}
			});
			
			_log.info("English data set");
			isDataSetEN = true;
		}
	}

	public void intimateClaim(ActionRequest request, ActionResponse response) throws IOException {
		String claimantType = ParamUtil.getString(request, "claimantType");
		String policyNumber = ParamUtil.getString(request, "policyNumber");
		String vehicleIdentNumber = ParamUtil.getString(request, "plateNumber");
		String plateL1 = ParamUtil.getString(request, "plateL1");
		String plateL2 = ParamUtil.getString(request, "plateL2");
		String plateL3 = ParamUtil.getString(request, "plateL3");
		String sequenceNumber = ParamUtil.getString(request, "sequenceNumber");
		String chassisNumber = ParamUtil.getString(request, "chassisNumber");
		String causeOfLoss = ParamUtil.getString(request, "causeOfLoss");
		Date dateOfLossOrAccident = ParamUtil.getDate(request, "dateOfLossOrAccident", new SimpleDateFormat("yyyy-MM-dd"));
		String accidentCity = ParamUtil.getString(request, "accidentCity");
		String accidentDescription = ParamUtil.getString(request, "accidentDescription");
		String sourceOfAccidentReport = ParamUtil.getString(request, "sourceOfAccidentReport");
		String accidentReportNumber = ParamUtil.getString(request, "accidentReportNumber");
		String vehicleMake = ParamUtil.getString(request, "vehicleMake");
		String vehicleModel = ParamUtil.getString(request, "vehicleModel");
		String driverName = ParamUtil.getString(request, "driverName");
		String driverNationality = ParamUtil.getString(request, "driverNationality");
		long driverNationalId = Long.parseLong(ParamUtil.getString(request, "driverNationalId"));
		Date driverDateOfBirthG = ParamUtil.getDate(request, "dateOfBirthG", new SimpleDateFormat("yyyy-MM-dd"));
		String driverGender = ParamUtil.getString(request, "driverGender");
		String ibanNumber = ParamUtil.getString(request, "ibanNumber");
		String bankName = ParamUtil.getString(request, "bankName");
		String phoneCode = ParamUtil.getString(request, "phoneCode");
		String contactNumber = ParamUtil.getString(request, "mobileNumber");
		String mobileNumber = phoneCode + contactNumber;
		String emailId = ParamUtil.getString(request, "emailId");
		boolean isClaimTP = claimantType.equals(ClaimIntimationPortletKeys.CLAIM_TYPE_THIRD_PARTY);

		/*
		 * Validation of dateOfLossOrAccident against Policy-Number and Chassis-Number Skip Policy and Chassis number validation
		 * for TP claims
		 */
		if (!isClaimTP) {
			ODSPolActiveVehicleDTO odsPolActiveVehicleDTO = ClaimIntimationMtrLocalServiceUtil.findOdsVehicleActiveList(chassisNumber, policyNumber);
			if (odsPolActiveVehicleDTO != null) {
				_log.info("odsPolicyActiveVehicle returned : expiry date " + odsPolActiveVehicleDTO.getPolicyExpiryDate());
				DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date expiryDate = df.parse(df.format(odsPolActiveVehicleDTO.getPolicyExpiryDate()));
					Date dateOfLossOrAccidentfmt = df.parse(df.format(dateOfLossOrAccident));
					_log.info("Expirty date : " + expiryDate + " & dateOfLoss : " + dateOfLossOrAccidentfmt);
					if (dateOfLossOrAccidentfmt.after(expiryDate)) {
						SessionErrors.add(request, "InvalidClaimDataEntered");
						return;
					}
				} catch (ParseException e) {
					_log.error(e.getMessage(), e);
				}
			} else {
				_log.info("No ODSPolActiveVehicle in DB!");
				SessionErrors.add(request, "InvalidClaimDataEntered");
				return;
			}
		}

		List<String> filesToBeUploaded = new ArrayList<>();
		List<Part> fileParts;
		
		//Get original file names
		try {
			fileParts = new ArrayList<>(request.getParts());
			for (Part filePart : fileParts) {
				String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
				filesToBeUploaded.add(fileName);
			}
		} catch (PortletException e) {
			_log.error(e.getMessage(), e);
		}

		ClaimIntimationMtr claimIntimationMtr = ClaimIntimationMtrLocalServiceUtil.intimateClaim(claimantType, policyNumber, vehicleIdentNumber, plateL1, plateL2, plateL3, sequenceNumber,
				chassisNumber, mobileNumber, causeOfLoss, dateOfLossOrAccident, accidentCity, accidentDescription, sourceOfAccidentReport, accidentReportNumber, vehicleMake, vehicleModel, driverName,
				driverNationality, driverNationalId, driverDateOfBirthG, driverGender, ibanNumber, bankName, emailId);

		if (Validator.isNotNull(claimIntimationMtr)) {
			_log.info("claimIntimationMtr object created successfully : " + claimIntimationMtr.getIntimationReferenceNo());
			List<User> users = new ArrayList<>();
			try {
				users = UserLocalServiceUtil.getRoleUsers(RoleLocalServiceUtil.getRole(20116, "Customer Service").getRoleId());
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
						_log.error(e.getMessage(), e);
					}
					long uploadedFolderId = this.uploadFileEntity(serviceContext, uploadRequest, userId, claimIntimationMtr.getIntimationReferenceNo(), filesToBeUploaded);
					if (uploadedFolderId != -1) {
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
								emailAttachmentNames.add(fileEntry.getFileName());
								emailAttachments.add(targetFile);
							}
						} catch (PortalException e) {
							_log.error(e.getMessage(), e);
						}
						_log.info("EmailAttachments size : " + emailAttachments.size());
						ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
						String currLocale = themeDisplay.getLocale().toString();

						String mailSubject = "Claim Intimation Successful!";
						String mailMessage = "You have successfully intimated a claim. Please find your claim by intimation number "
								+ claimIntimationMtr.getIntimationReferenceNo();
						mailMessage += "\nHere is the details you filled while intimating your claim: \n";

						boolean isCurrentLocaleEnglish = currLocale.equals("en_US");
						Map<String, String> claimTypeCodeValue = isCurrentLocaleEnglish ? claimTypeCodeValuePair : claimTypeCodeValuePairAR;
						Map<String, String> accidentCityCodeValue = isCurrentLocaleEnglish ? accidentCityCodeValuePair : accidentCityCodeValuePairAR;
						Map<String, String> causeOfLossCodeValue = isCurrentLocaleEnglish ? causeOfLossCodeValuePair : causeOfLossCodeValuePairAR;
						Map<String, String> vehicleModelPair = isCurrentLocaleEnglish ? vehicleModelMap : vehicleModelMapAR;
						Map<String, String> nationalityPair = isCurrentLocaleEnglish ? nationalityMap : nationalityMapAR;
						Map<String, String> vehicleMakePair = isCurrentLocaleEnglish ? vehicleMakeMap : vehicleMakeMapAR;

						mailMessage += "claimantType  : " + claimTypeCodeValue.get(claimantType)
								+ (isClaimTP ? "\nIban Number : " + ibanNumber : "\nPolicy Number  : " + policyNumber) + "\nVehicle IdentNumber  : " + vehicleIdentNumber
								+ "	plateL1  : " + plateL1 + "	plateL2  : " + plateL2 + "	plateL3  : " + plateL3 + "\nSequence Number : " + sequenceNumber
								+ (isClaimTP ? "\nBank Name : " + bankNameCodeValuePair.get(bankName) : "\nChassis Number  : " + chassisNumber) + "\nMobile Number  : "
								+ mobileNumber + "\nCause Of Loss  : " + causeOfLossCodeValue.get(causeOfLoss) + "\nDate Of Loss Or Accident: " + dateOfLossOrAccident
								+ "\nAccident City  : " + accidentCityCodeValue.get(accidentCity) + "\nAccident Description  : " + accidentDescription
								+ "\nSource Of Accident Report  : " + sourceOfAccidentReportMap.get(sourceOfAccidentReport) + "\nAccident Report Number  : " + accidentReportNumber
								+ "\nVehicle Make  : " + vehicleMakePair.get(vehicleMake) + "\nVehicle Model  : " + vehicleModelPair.get(vehicleModel) + "\nDriver Name  : "
								+ driverName + "\nDriver Nationality  : " + nationalityPair.get(driverNationality) + "\nDriver NationalId: " + driverNationalId
								+ "\nDriver Date Of BirthG: " + driverDateOfBirthG + "\nDriver Gender  " + genderMap.get(driverGender);
//					SMSLocalServiceUtil.sendSms(mailMessage, mobile);

						SendEmailServiceUtil.sendEmail("vidit@aimdek.in", mailSubject, mailMessage, emailAttachmentNames, emailAttachments);
					} else {
						_log.error("Error in uploadedFolderId : " + -1);
					}
				}
			}
			request.getPortletSession().setAttribute("intimateClaimInitiated", claimIntimationMtr);
			request.getPortletSession().setAttribute("redirectToIntimationSuccessScreen", "claim_intimated");
		}
	}

	private long uploadFileEntity(ServiceContext serviceContext, UploadPortletRequest request, long userId, String claimIntimationReferenceNo, List<String> filesToBeUploaded) {
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

			for (int i = 0; i < claimIntimationAttachments.length; i++) {
				File file = claimIntimationAttachments[i];
				filename = filesToBeUploaded.get(i);
				String mimeType = MimeTypesUtil.getContentType(file);

				FileEntry entry = DLAppLocalServiceUtil.addFileEntry(serviceContext.getUserId(), repositoryId, folderId, filename, mimeType, filename, description, "", file, serviceContext);
				_log.info("File " + entry.getFileName() + " uploaded to " + f.getName());
			}
			return folderId;
		} catch (PortalException | SystemException e) {
			_log.error("An exception occured uploading file: " + e.getMessage());
			return -1;
		}
	}
}