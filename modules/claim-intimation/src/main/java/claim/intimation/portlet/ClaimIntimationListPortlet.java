package claim.intimation.portlet;

import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.document.library.kernel.service.DLAppLocalServiceUtil;
import com.liferay.document.library.kernel.service.DLAppService;
import com.liferay.document.library.kernel.service.DLFileEntryLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ResourceBundleUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import claim.intimation.constants.ClaimIntimationPortletKeys;

@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=false",
		"com.liferay.portlet.private-session-attributes=false",
		"javax.portlet.display-name=Admin Claim Intimation List Portlet", 
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/claimIntimationList/view.jsp",
		"javax.portlet.name=" + ClaimIntimationPortletKeys.CLAIMINTIMATIONList,
		"javax.portlet.init-param.add-process-action-success-action=false", 
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=guest,power-user,user" 
	}, 
	service = Portlet.class
)
public class ClaimIntimationListPortlet extends MVCPortlet {
	public static Log _log = LogFactoryUtil.getLog(ClaimIntimationListPortlet.class);

	private static final String CODE_FREEZ_YN = "N";
	private static boolean isDataSetEN;
	private static boolean isDataSetAR;
	public static Map<String, String> manufactMap = new HashMap<>();
	public static Map<String, String> manufactMapAR = new HashMap<>();
	List<CodeMasterDetails> vehicleModelList = new ArrayList<>();
	List<CodeMasterDetails> codeMaterList = new ArrayList<>();
	List<CodeMasterDetails> natureOfLossList;
	List<CodeMasterDetails> cityList;
	List<CodeMasterDetails> nationalityList;
	List<CodeMasterDetails> causeOfLossList;
	List<CodeMasterDetails> claimTypeList;
	List<CodeMasterDetails> bankList;
	public static List<CodeMasterDetails> statusList = new ArrayList<>();
	
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

	public static Map<String, Set<Map<String, String>>> requiredDocumentsMap = new HashMap<>();
	
	public static List<CodeMasterDetails> phoneCodes = new ArrayList<>();
	public static List<CodeMasterDetails> plateLetters = new ArrayList<>();

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
			String myview = (renderRequest.getAttribute("myview") != null) ? (String) renderRequest.getAttribute("myview")
					: (renderRequest.getParameter("myview") != null) ? renderRequest.getParameter("myview") : "view2";
			ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String currLocale = themeDisplay.getLocale().toString();
			
			if (currLocale.equals("en_US")) {
				setEnglishData(renderRequest, renderResponse);
			} else {
				setArabicData(renderRequest, renderResponse);
			}

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

			ClaimIntimationMtr claimIntimationMtr = (ClaimIntimationMtr) renderRequest.getPortletSession().getAttribute("intimateClaimInitiated");
			if (Validator.isNotNull(claimIntimationMtr)) {
				myview = (String) renderRequest.getPortletSession().getAttribute("redirectToIntimationSuccessScreen");
				renderRequest.setAttribute("claimIntimationMtr", claimIntimationMtr);
				renderRequest.getPortletSession().removeAttribute("redirectToIntimationSuccessScreen");
				renderRequest.getPortletSession().removeAttribute("intimateClaimInitiated");
			}

			String view = "/claimIntimationList/" + myview + ".jsp";
			PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
			dispatcher.include(renderRequest, renderResponse);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	private void setArabicData(RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {
		if (!isDataSetAR) {
			statusList = CodeMasterDetailsLocalServiceUtil.getCustomCodes("CLM_INTM_STS");
			phoneCodes = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PHONE_CODE);
			plateLetters = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PLATE_LETTER);
			codeMaterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
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

			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				manufactMapAR.put(codeMasterDtls.getCodeDescAr(), codeMasterDtls.getCodeSub());
			}
			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
				vehicleMakeMapAR.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDescAr());
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
			statusList = CodeMasterDetailsLocalServiceUtil.getCustomCodes("CLM_INTM_STS");
			phoneCodes = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PHONE_CODE);
			plateLetters = CodeMasterDetailsLocalServiceUtil.getCustomCodes(ClaimIntimationPortletKeys.PLATE_LETTER);
			codeMaterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
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

			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				manufactMap.put(codeMasterDtls.getCodeDesc(), codeMasterDtls.getCodeSub());
			}
			for (CodeMasterDetails codeMasterDtls : codeMaterList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				vehicleMakeMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			for (CodeMasterDetails codeMasterDtls : nationalityList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				nationalityMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
			}
			for (CodeMasterDetails codeMasterDtls : vehicleModelList) {
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
				codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
				vehicleModelMap.put(codeMasterDtls.getCodeSub(), codeMasterDtls.getCodeDesc());
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

	public void updateStatus(ActionRequest actionRequest, ActionResponse actionResponse) {
		long claimIntimationMtrId =  Long.parseLong( (String) actionRequest.getParameter("claimIntimationMtr"));
		_log.info("update status for claim-id : " + claimIntimationMtrId);
		
		try {
			ClaimIntimationMtr claimIntimationMtr = ClaimIntimationMtrLocalServiceUtil.getClaimIntimationMtr(claimIntimationMtrId);
			claimIntimationMtr.setClaimStatus(Integer.parseInt(actionRequest.getParameter("claimStatus")));
			ClaimIntimationMtrLocalServiceUtil.updateClaimIntimationMtr(claimIntimationMtr);
		} catch (PortalException e) {
			e.printStackTrace();
		}
		
	}

	public static Map<String, List<String>> getDownloadLinksOfdocuments(String intimationReferenceNo, ThemeDisplay themeDisplay) {
		Map<String, List<String>> documentURLs = new HashMap<>();
		List<String> files = new ArrayList<>();
		try {
			long repositoryId = 33670;
			Folder claimsIntimationFolder = DLAppLocalServiceUtil.getFolder(repositoryId, 0L, "Claims Intimation");
			Folder uploadedFolder = DLAppLocalServiceUtil.getFolder(repositoryId, claimsIntimationFolder.getFolderId(), intimationReferenceNo);
			long uploadedFolderId = uploadedFolder.getFolderId();
			_log.info("uploadedFolderId : " + uploadedFolderId + "& claimsIntimationFolder: " + claimsIntimationFolder.getFolderId() + " & repositoryId : " + repositoryId);
			List<DLFileEntry> uploadedFileEntries = new ArrayList<>();
			try {
				uploadedFileEntries = DLFileEntryLocalServiceUtil.getFileEntries(33670,uploadedFolderId);
			} catch (Exception e) {
				_log.error("skipping folder : " + uploadedFolderId + " Because..... " + e.getCause());
			}
			for (DLFileEntry file : uploadedFileEntries) {
				String fileURL = themeDisplay.getPortalURL() + "/documents/" + file.getGroupId() + "/" + file.getFolderId() + "/" + file.getTitle() + "/" + file.getUuid();
				files.add(fileURL);
			}
			documentURLs.put(intimationReferenceNo, files);
			return documentURLs;
		} catch (PortalException e) {
			_log.error("error occurred " + e.getMessage());
		}
		return documentURLs;
	}
	

	@Reference
	private static DLAppService _dlAppService;
}
