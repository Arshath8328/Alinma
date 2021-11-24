package quick.quote.portlet;

import com.atmc.bsl.db.service.CodeMasterDetailsLocalServiceUtil;
import com.atmc.bsl.db.service.GsonUtilsLocalServiceUtil;
import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.ejada.atmc.acl.db.domain.tariff.TariffDetails;
import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.domain.tariff.TariffOutput;
import com.ejada.atmc.acl.db.service.TariffLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import quick.quote.portlet.constants.QuickQuotePortletKeys;
/**
 * @author vidit
 */
@Component(
		immediate = true, 
		property = { 
				"com.liferay.portlet.display-category=ATMC", 
				"com.liferay.portlet.instanceable=false",
				"javax.portlet.display-name=QuickQuote Portlet",
				"javax.portlet.init-param.template-path=/", 
				"javax.portlet.init-param.view-template=/home/quick_quote.jsp",
				"javax.portlet.name=" + QuickQuotePortletKeys.QuickQuotePortlet,
				"javax.portlet.resource-bundle=content.Language",
				"javax.portlet.security-role-ref=power-user,user"
		}, 
		service = Portlet.class
)
public class QuickQuotePortlet extends MVCPortlet {

	private static final String		BODY_CODE		= "MOT_BODY_TYP";
	private static final int		LOYALTY			= 0;
	private static final Integer	REPAIR			= 0;
	private static final Integer	COLOR			= 25244;
	private static final String		TP_PROD_CODE	= "MTP";
	private static final String		OD_PROD_CODE	= "MCC";
	private static final String		SCHEME_CODE		= "SCHEME_011";
	private static final String		CODE_FREEZ_YN	= "N";

	List<CodeMasterDetails> codeMaterList;
	List<CodeMasterDetails> codeMaterDtlsList;
	List<CodeMasterDetails> dedValues;
	List<String> manufactList = new ArrayList<>();
	Map<String, String> manufactMap = new HashMap<>();
	static boolean isDataSet = false;
	
	SimpleDateFormat				dateFormat		= new SimpleDateFormat("dd/MM/yyyy");

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {

		try {
			if(!isDataSet) {
				codeMaterList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez("MOT_VEH_MAKE", CODE_FREEZ_YN);
				_log.info("codeMaterList  >>>>>>>" + codeMaterList.size());
				ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
				String currLocale = themeDisplay.getLocale().toString();
				for (CodeMasterDetails codeMasterDtls : codeMaterList) {
					if (currLocale.equals("en_US")) {
						codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\"", ""));
						codeMasterDtls.setCodeDesc(codeMasterDtls.getCodeDesc().replaceAll("\'", ""));
						manufactList.add(codeMasterDtls.getCodeDesc());
						manufactMap.put(codeMasterDtls.getCodeDesc(), codeMasterDtls.getCodeSub());
					} else {
						codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\"", ""));
						codeMasterDtls.setCodeDescAr(codeMasterDtls.getCodeDescAr().replaceAll("\'", ""));
						manufactList.add(codeMasterDtls.getCodeDescAr());
						manufactMap.put(codeMasterDtls.getCodeDescAr(), codeMasterDtls.getCodeSub());
					}

				}
				dedValues = QuotationLocalServiceUtil.getDeductibleValues();
				codeMaterDtlsList = CodeMasterDetailsLocalServiceUtil.findByCodeCodeFreez(BODY_CODE, CODE_FREEZ_YN);
				isDataSet = true;
			}
			
			String manufactData = GsonUtilsLocalServiceUtil.toGson(manufactList);
			String manufactJson = GsonUtilsLocalServiceUtil.toGson(manufactMap);

			renderRequest.setAttribute("dedVals", dedValues);
			renderRequest.setAttribute("manufactDataJson", manufactData);
			renderRequest.setAttribute("manufactMapJson", manufactJson);
			renderRequest.setAttribute("bodyListData", codeMaterDtlsList);
			renderRequest.setAttribute("manufacturerList", codeMaterList);
		} catch (PortalException e) {
			_log.error(e.getMessage(), e);
		}

		String myview = ParamUtil.getString(renderRequest, "myview", null);
		String view = "/home/" + (myview == null ? "quick_quote" : myview) + ".jsp";
		PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher(view);
		dispatcher.forward(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	public void applyQuickQuote(ActionRequest actionRequest, ActionResponse actionResponse) {
		_log.info("in QQP applyQuickQuote action method");
		String year = null;
		String manufactName = ParamUtil.getString(actionRequest, "manufactName");
		if (!Pattern.matches("^['a-zA-Z\\\\u0600-\\\\u06FF\\s]+$", manufactName)) {
			manufactName = "";
			_log.error("Invalid manufactName");
		}
		String make = ParamUtil.getString(actionRequest, "manufactMap");
		String bodyType = ParamUtil.getString(actionRequest, "bodyType");
		if (!Pattern.matches("^['a-zA-Z\\\\u0600-\\\\u06FF\\s]+$", bodyType)) {
			bodyType = "";
			_log.error("Invalid BodyType");
		}
		year = ParamUtil.getString(actionRequest, "year");
		String driverAgeStr = ParamUtil.getString(actionRequest, "driverAge");
		String region = ParamUtil.getString(actionRequest, "region");
		if (!Pattern.matches("^['a-zA-Z\\\\u0600-\\\\u06FF\\s]+$", region)) {
			region = "";
			_log.error("Invalid Region");
		}
		int vehicleValue = ParamUtil.getInteger(actionRequest, "vehicleValue");
		String najmPlateType = ParamUtil.getString(actionRequest, "najmPlateType");
		String gender = ParamUtil.getString(actionRequest, "gender");
		int ncd = ParamUtil.getInteger(actionRequest, "ncd");
		String dedValue = ParamUtil.getString(actionRequest, "dedValue");
		int maritalStatus = ParamUtil.getInteger(actionRequest, "maritalStatus");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		int vehYear = Integer.parseInt(year);
		Date effFromDate = new Date();
		int userDriverAge = 16; // minimum age by default
		if (Pattern.compile("^[0-9]+$").matcher(driverAgeStr).find() && driverAgeStr.length() == 2)
			userDriverAge = Integer.valueOf(driverAgeStr);
		else
			_log.error("Invalid Driver Age");
		TariffDetails tariffDetails = new TariffDetails();
		TariffInput tariffInput = new TariffInput();
		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.YEAR, -userDriverAge);
		java.sql.Date driverAge = new java.sql.Date(calendar.getTimeInMillis());
		if (vehicleValue == 0)
			tariffInput.setVehicleValue(20000);
		else
			tariffInput.setVehicleValue(vehicleValue);
		tariffInput.setEffFromDate(new java.sql.Date(effFromDate.getTime()));
		tariffInput.setSchemeCode(SCHEME_CODE);
		tariffInput.setRegion(region);
		tariffInput.setGender(Integer.valueOf(gender));
		tariffInput.setProductCode(TP_PROD_CODE);
		tariffInput.setDriverAge(driverAge);
		tariffInput.setMake(Integer.valueOf(make));
		if (vehYear == 2021)
			tariffInput.setMFGYear(2016);
		tariffInput.setMFGYear(vehYear);
		tariffInput.setBodyType(bodyType);
		tariffInput.setColor(COLOR);
		tariffInput.setPurposeVeh(Integer.valueOf(najmPlateType));
		tariffInput.setRepair(REPAIR);
		tariffInput.setLoyalty(LOYALTY);
		tariffInput.setUniqueIdentifier("123456");
		tariffInput.setClmFreeYears(ncd);
		tariffInput.setNcdDrv1(99);
		tariffInput.setNcdDrv2(99);
		tariffInput.setNcdDrv3(99);
		tariffInput.setNcdDrv4(99);
		tariffInput.setNcdDrv5(99);
		tariffInput.setSpecialDiscount(null);
		tariffInput.setInsuredid(1086867494);
		tariffInput.setChassisno("LUCCR2663F4061561");
		tariffInput.setMaritalStatus(maritalStatus);
		tariffDetails.setTariffInput(tariffInput);
		_log.info("Tarrif Procedure for TP");
		_log.info("-------------------------------");
		_log.info("BodyType = " + tariffInput.getBodyType());
		_log.info("EffFromDate = " + tariffInput.getEffFromDate());
		_log.info("ProductCode = " + tariffInput.getProductCode());
		_log.info("Region = " + tariffInput.getRegion());
		_log.info("SchemeCode = " + tariffInput.getSchemeCode());
		_log.info("ClmFreeYears = " + tariffInput.getClmFreeYears());
		_log.info("Color = " + tariffInput.getColor());
		_log.info("DriverAge = " + tariffInput.getDriverAge());
		_log.info("Gender = " + tariffInput.getGender());
		_log.info("Loyalty = " + tariffInput.getLoyalty());
		_log.info("Make = " + tariffInput.getMake());
		_log.info("MFGYear = " + tariffInput.getMFGYear());
		_log.info("PurposeVeh = " + tariffInput.getPurposeVeh());
		_log.info("Repair = " + tariffInput.getRepair());
		_log.info("VehicleValue = " + tariffInput.getVehicleValue());
		_log.info("************************************");

		double ncdPermiumRate = 0;
		double loyaltyDisPremRate = 0;
		double specialDiscountRate = 0;
		double premiumAmount = 0;
		double ncdDiscountAmount = 0;
		double ncdPercentage = 0;
		double specialdiscountdrivesafe = 0;
		ArrayList<TariffOutput> tOut = null;
		try {
			tOut = TariffLocalServiceUtil.getTariffData(tariffInput);
			_log.info("after tariff call ");
			_log.info("TariffOutput for MTP " + tOut.toString());
			if (tariffInput.getProductCode().equals(TP_PROD_CODE)) {
				for (TariffOutput tout : tOut) {
					if ((tout.getCode() != null) && (tout.getCode().equals("2066"))) {
						_log.info("toutput >>>>>>>>>>>>>" + tout.toString());
						premiumAmount = Double.valueOf(tout.getPremiumAmount());
						_log.info(" PremiumAmount " + tout.getPremiumAmount());
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("83"))) {
						loyaltyDisPremRate = tout.getLoyalityPercentage();
						_log.info("loyaltyDisPremRate >>>>>>>>>>" + loyaltyDisPremRate);
						_log.info("loyaltyDisPercentage >>>>>>>>>>" + tout.getLoyalityPercentage());
						_log.info("loyaltyDisPremRate >>>>>>>>>>>>" + loyaltyDisPremRate);
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("85"))) {
						ncdPermiumRate = Double.valueOf(tout.getPremiumRate());
						_log.info("NcdPercentage >>>>>>>>>>" + tout.getNcdPercentage());
						ncdDiscountAmount = (premiumAmount * ncdPermiumRate) / 100;
						ncdPercentage = tout.getNcdPercentage();
						_log.info("ncdDiscountAmount >>>>>>>>>>>>" + ncdDiscountAmount);

					}
					if ((tout.getCode() != null) && (tout.getCode().equals("84"))) {
						if (tout.getPremiumRate() != null)
							specialDiscountRate = 0;
						_log.info("specialDiscountRate >>>>>>>>>>" + specialDiscountRate);

					}
					if ((tout.getCode() != null) && (tout.getCode().equals("289"))) {
						specialdiscountdrivesafe = Double.valueOf(tout.getPremiumRate());
						_log.info("specialdiscountdrivesafe >>>>>>>>>>" + specialdiscountdrivesafe);
					}

				}
			}
			double totalDiscAmount = (premiumAmount * (ncdPercentage + specialdiscountdrivesafe));
			double totalPremPayable = premiumAmount - totalDiscAmount;
			double vatAmount = totalPremPayable * 0.15;
			double tpBasePerm = totalPremPayable + vatAmount;
			actionRequest.setAttribute("TP_BASE_PERM", String.valueOf(Math.round(tpBasePerm)));
		} catch (PortalException | SQLException e) {
			_log.error(e.getMessage(), e);
		}
		TariffInput tariffInput2 = tariffDetails.getTariffInput();
		tariffInput2.setProductCode(OD_PROD_CODE);
		if (vehYear > Calendar.getInstance().get(Calendar.YEAR) + 2) {
			tariffInput.setMFGYear(0);
			_log.info("if condition " + vehYear);
		} else {
			_log.info("else condition " + year);
			tariffInput.setMFGYear(vehYear);
		}

		_log.info("Tariff Procedure for OD");
		_log.info("-------------------------------");
		_log.info("ProductCode = " + tariffInput.getProductCode());
		try {
			_log.info("sgsdgdg" + tariffInput2);
			ArrayList<TariffOutput> tariffOutput2 = TariffLocalServiceUtil.getTariffData(tariffInput2);
			_log.info("after tariff call >>>>>>>>>>>>>>" + tariffInput2.getProductCode());
			_log.info("TariffOutput for MCC " + tariffOutput2.toString());
			if (tariffInput2.getProductCode().equals(OD_PROD_CODE)) {
				for (TariffOutput tout : tariffOutput2) {
					if (tout.getCode().equals("2062") && tout.getExcessAmount().equals(dedValue)) {
						premiumAmount = (Double.valueOf(tout.getPremiumAmount()));
						_log.info("minimum premium Amount >>>>>>>>>>>>>>>>" + premiumAmount);

					}
					if ((tout.getCode() != null) && (tout.getCode().equals("85"))) {
						ncdPermiumRate = Double.valueOf(tout.getPremiumRate());
						ncdPercentage = tout.getNcdPercentage();
						_log.info("NcdPercentage >>>>>>>>>>" + tout.getNcdPercentage());
						ncdDiscountAmount = (premiumAmount * ncdPermiumRate) / 100;
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("83"))) {
						loyaltyDisPremRate = tout.getLoyalityPercentage();
						_log.info("loyaltyDisPercentage >>>>>>>>>>" + tout.getLoyalityPercentage());
					}
					if ((tout.getCode() != null) && (tout.getCode().equals("289"))) {
						specialdiscountdrivesafe = Double.valueOf(tout.getPremiumRate());
						_log.info("specialdiscountdrivesafe >>>>>>>>>>" + specialdiscountdrivesafe);
					}
				}
			}
			double totalDiscAmount = (premiumAmount * (ncdPercentage + specialdiscountdrivesafe));
			double totalPremPayable = premiumAmount - totalDiscAmount;
			double vatAmount = totalPremPayable * 0.15;
			double odBasePerm = totalPremPayable + vatAmount;

			actionRequest.setAttribute("OD_BASE_PERM", String.valueOf(Math.round(odBasePerm)));
		} catch (PortalException | SQLException e) {
			_log.error(e.getMessage(), e);
		}

		actionRequest.setAttribute("MANUFACT_NAME", manufactName);
		actionRequest.setAttribute("MANUFACT_YEAR", year);

	}

	private static final Log _log = LogFactoryUtil.getLog(QuickQuotePortlet.class);
}