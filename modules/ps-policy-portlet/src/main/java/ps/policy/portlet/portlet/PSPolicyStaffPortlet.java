//package ps.policy.portlet.portlet;
//
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//import java.util.ResourceBundle;
//
//import javax.portlet.Portlet;
//import javax.portlet.PortletException;
//import javax.portlet.RenderRequest;
//import javax.portlet.RenderResponse;
//import javax.portlet.ResourceRequest;
//import javax.portlet.ResourceResponse;
//
//import org.osgi.service.component.annotations.Component;
//
//import com.atmc.acl.db.model.PSPolicyDetail;
//import com.atmc.acl.db.model.SOADetail;
//import com.ejada.atmc.acl.db.service.lnp2_policymastrLocalServiceUtil;
//import com.ejada.atmc.constants.PSPolicyPortletKeys;
//import com.ejada.atmc.utils.api.ReportsUtil;
//import com.liferay.portal.kernel.exception.PortalException;
//import com.liferay.portal.kernel.language.LanguageUtil;
//import com.liferay.portal.kernel.log.Log;
//import com.liferay.portal.kernel.log.LogFactoryUtil;
//import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
//import com.liferay.portal.kernel.service.UserLocalServiceUtil;
//import com.liferay.portal.kernel.theme.ThemeDisplay;
//import com.liferay.portal.kernel.util.ParamUtil;
//import com.liferay.portal.kernel.util.ResourceBundleUtil;
//import com.liferay.portal.kernel.util.Validator;
//import com.liferay.portal.kernel.util.WebKeys;
//
///**
// * @author bhavik
// */
//@Component(
//	immediate = true,
//	property = {
//		"com.liferay.portlet.display-category=category.sample",
//		"com.liferay.portlet.instanceable=true",
//		"javax.portlet.display-name=PSPolicy Staff Portlet",
//		"javax.portlet.init-param.template-path=/",
//		"javax.portlet.init-param.view-template=/Staff/view.jsp",
//		"javax.portlet.name=" + PSPolicyPortletKeys.PSPolicyStaff,
//		"javax.portlet.resource-bundle=content.Language",
//		"javax.portlet.security-role-ref=power-user,user"
//	},
//	service = Portlet.class
//)
//public class PSPolicyStaffPortlet extends MVCPortlet{
//	
//	public static final Log LOG = LogFactoryUtil.getLog(PSPolicyStaffPortlet.class);
//	ResourceBundle resourceBundle;
//	Map<String, String> englishArabicNamesMap = new HashMap<>();
//	
//	@Override
//	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
//			throws IOException, PortletException {
//		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		resourceBundle = ResourceBundleUtil.getBundle("content.Language", themeDisplay.getLocale() , getClass());
//		englishArabicNamesMap = setArabicText();
//		
//		String proposalNo = (String)renderRequest.getParameter("proposalNo");
//		if(!Validator.isBlank(proposalNo)){
//			try {
//				SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
//		    	String finalToDate = dateFormat.format(new Date());
//		    	
//				List<PSPolicyDetail> psPolicyDetails = lnp2_policymastrLocalServiceUtil.findPSPolicyDetailsById(proposalNo, finalToDate);
//				PSPolicyDetail psPolicyDetail = psPolicyDetails.get(0);
//				psPolicyDetail.setStatus_descr(englishArabicNamesMap.get(psPolicyDetail.getStatus_descr()));
//				psPolicyDetail.setFrequency(englishArabicNamesMap.get(psPolicyDetail.getFrequency()));
//				psPolicyDetail.setProduct_desc(englishArabicNamesMap.get(psPolicyDetail.getProduct_desc().toLowerCase()));
//				LOG.info("PSPolicyDetail: "+psPolicyDetail);
//				renderRequest.getPortletSession().removeAttribute("proposalNo");
//				renderRequest.setAttribute("psPolicyDetail", psPolicyDetail);
//			} catch (PortalException e) {
//				LOG.error(e.getMessage(), e);
//			}
//		}
//		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
//		String cmd = (String)renderRequest.getParameter("cmd");
//		if("details".equals(cmd)){
//			try {
//				String fromDate = (String)renderRequest.getParameter("fromDate");
//				String toDate = (String)renderRequest.getParameter("toDate");
//				Date date1=new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);
//				Date date2=new SimpleDateFormat("MM/dd/yyyy").parse(toDate);
//				List<SOADetail> soaDetails = lnp2_policymastrLocalServiceUtil.findPSPolicyStatementDetailsById(proposalNo,dateFormat.format(date1), dateFormat.format(date2));
//				SOADetail soaDetail = soaDetails.get(0);
//				LOG.info("Before ----------------PSStatementDetail: "+ soaDetail);
//				
//				soaDetail.setStatus_descr(englishArabicNamesMap.get(soaDetail.getStatus_descr()));
//				soaDetail.setFrequency(englishArabicNamesMap.get(soaDetail.getFrequency()));
//				soaDetail.setProduct_desc(englishArabicNamesMap.get(soaDetail.getProduct_desc().toLowerCase()));
//				soaDetail.getPsCoverageDetails().stream().forEach(cd -> cd.setBenefit_name((englishArabicNamesMap.get(cd.getBenefit_name().toLowerCase())) == null ?   cd.getBenefit_name() : englishArabicNamesMap.get(cd.getBenefit_name().toLowerCase())));
//				soaDetail.getPsCoverageDetails().stream().forEach(cd -> cd.setBenefit_type(englishArabicNamesMap.get(cd.getBenefit_type().toLowerCase())));
//				soaDetail.setInvestment_strategy(englishArabicNamesMap.get(soaDetail.getInvestment_strategy().toLowerCase()) == null ? soaDetail.getInvestment_strategy() : englishArabicNamesMap.get(soaDetail.getInvestment_strategy().toLowerCase()));
//				soaDetail.setCurrency(englishArabicNamesMap.get(soaDetail.getCurrency().toLowerCase()));
//				soaDetail.getPsStatementAccounts().stream().forEach(soa -> soa.setCurrent_status(soa.getCurrent_status().isEmpty() ? "" : englishArabicNamesMap.get(soa.getCurrent_status())));
//				soaDetail.getPsStatementAccounts().stream().forEach(soa -> soa.setPayment_status(englishArabicNamesMap.get(soa.getPayment_status())));
//				soaDetail.getPsBeneficiaryDetails().stream().forEach(bd -> {
//					if(bd.getRelationship()==null) {
//						bd.setBeneficiary_name(englishArabicNamesMap.get("Legal Heirs"));
//						bd.setRelationship("");
////						bd.setRelationship(englishArabicNamesMap.get(bd.getRelationship()));
//					}else{
//						bd.setRelationship(englishArabicNamesMap.get(bd.getRelationship()));
//					}
//				});
//				
//				LOG.info("----------------PSStatementDetail: "+ soaDetail);
//				renderRequest.setAttribute("psStatementDetail", soaDetail);
//				renderRequest.setAttribute("fromDate", dateFormat.format(date1));
//				renderRequest.setAttribute("toDate", dateFormat.format(date2));
//				LOG.info("render method: "+ proposalNo +" fromDate: "+ fromDate +" toDate: "+ toDate);
//			} catch (ParseException | PortalException e) {
//				LOG.error(e.getMessage(), e);
//			}  
//			
//		}
//		super.render(renderRequest, renderResponse);
//	}
//	
//	@Override
//	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
//			throws IOException, PortletException {
//		try {
//			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
//			resourceBundle = ResourceBundleUtil.getBundle("content.Language", themeDisplay.getLocale() , getClass());
//			englishArabicNamesMap = setArabicText();
//			
//			String proposalNo = ParamUtil.getString(resourceRequest, "proposalNo");
//			String fromDate = (String)resourceRequest.getParameter("fromDate");
//			String toDate = (String)resourceRequest.getParameter("toDate");
//			List<SOADetail> soaDetails = lnp2_policymastrLocalServiceUtil.findPSPolicyStatementDetailsById(proposalNo,fromDate, toDate);
//			SOADetail soaDetail = soaDetails.get(0);
//			soaDetail.setFromDate(fromDate);
//			soaDetail.setToDate(toDate);
//			soaDetail.setStatus_descr(englishArabicNamesMap.get(soaDetail.getStatus_descr()));
//			soaDetail.setFrequency(englishArabicNamesMap.get(soaDetail.getFrequency()));
//			soaDetail.setProduct_desc(englishArabicNamesMap.get(soaDetail.getProduct_desc().toLowerCase()));
//			soaDetail.getPsCoverageDetails().stream().forEach(cd -> cd.setBenefit_name((englishArabicNamesMap.get(cd.getBenefit_name().toLowerCase())) == null ?   cd.getBenefit_name() : englishArabicNamesMap.get(cd.getBenefit_name().toLowerCase())));
//			soaDetail.getPsCoverageDetails().stream().forEach(cd -> cd.setBenefit_type(englishArabicNamesMap.get(cd.getBenefit_type().toLowerCase())));
//			soaDetail.setInvestment_strategy(englishArabicNamesMap.get(soaDetail.getInvestment_strategy().toLowerCase()) == null ? soaDetail.getInvestment_strategy() : englishArabicNamesMap.get(soaDetail.getInvestment_strategy().toLowerCase()));
//			soaDetail.setCurrency(englishArabicNamesMap.get(soaDetail.getCurrency().toLowerCase()));
//			soaDetail.getPsStatementAccounts().stream().forEach(soa -> soa.setCurrent_status(soa.getCurrent_status().isEmpty() ? "" : englishArabicNamesMap.get(soa.getCurrent_status())));
//			soaDetail.getPsStatementAccounts().stream().forEach(soa -> soa.setPayment_status(englishArabicNamesMap.get(soa.getPayment_status())));
//			soaDetail.getPsBeneficiaryDetails().stream().forEach(bd -> {
//				if(bd.getRelationship()==null){
//					bd.setBeneficiary_name(englishArabicNamesMap.get("Legal Heirs"));
//					bd.setRelationship("");
//				}else{
//					bd.setRelationship(englishArabicNamesMap.get(bd.getRelationship()));
//				}
//			});
//			
//			resourceResponse.setProperty("Content-Disposition", "attachment; filename=\""+ soaDetail.getProposal_no() + ".pdf\"");
//			resourceResponse.setContentType( "application/pdf" );
//			ReportsUtil.downloadFundPDF(soaDetails,resourceResponse.getPortletOutputStream());
//		} catch (Exception e) {
//			LOG.error(e.getMessage(), e);
//		}
//	}
//	
//	public Map setArabicText(){
//		Map<String, String> map = new HashMap<>();
//		
//		map.put("M", LanguageUtil.get(resourceBundle,"monthly"));
//	    map.put("S", LanguageUtil.get(resourceBundle,"single.premium"));
//	    map.put("A", LanguageUtil.get(resourceBundle,"annual"));
//	    map.put("Q", LanguageUtil.get(resourceBundle,"quarterly"));
//	    map.put("H", LanguageUtil.get(resourceBundle,"half.year"));
//	    
//	    map.put("platinum savings program", LanguageUtil.get(resourceBundle,"platinum.savings.program"));
//	    map.put("istithmar program", LanguageUtil.get(resourceBundle,"istithmar.program"));
//	    map.put("ta'alem program", LanguageUtil.get(resourceBundle,"t.program"));
//	    map.put("gold savings program", LanguageUtil.get(resourceBundle,"gold.savings.program"));
//	    map.put("zawaaj program", LanguageUtil.get(resourceBundle,"zawaaj.program"));
//	    map.put("accidental death benefit", LanguageUtil.get(resourceBundle,"accidental.death.benefit"));
//	    map.put("waiver of premium", LanguageUtil.get(resourceBundle,"waiver.of.premium"));
//	    map.put("permanent total disability-additional", LanguageUtil.get(resourceBundle,"permanent.total.disability.additional"));
//	    map.put("critical illness - accelerated", LanguageUtil.get(resourceBundle,"critical.illness.accelerated"));
//	    map.put("main benefit", LanguageUtil.get(resourceBundle,"main.benefit"));
//	    map.put("rider", LanguageUtil.get(resourceBundle,"rider"));
//	    map.put("aggressive strategy", LanguageUtil.get(resourceBundle,"aggressive.strategy"));
//	    map.put("aggressive strategy - sar", LanguageUtil.get(resourceBundle,"aggressive.strategy"));
//	    map.put("balanced strategy", LanguageUtil.get(resourceBundle,"balanced.strategy"));
//	    map.put("secured strategy", LanguageUtil.get(resourceBundle,"secured.strategy"));
//	    map.put("secured strategy - sar", LanguageUtil.get(resourceBundle,"secured.strategy"));
//	    map.put("balanced strategy - sar", LanguageUtil.get(resourceBundle,"balanced.strategy"));
//	    
//	    map.put("Brother", LanguageUtil.get(resourceBundle,"brother"));
//	    map.put("Daughter", LanguageUtil.get(resourceBundle,"daughter"));
//	    map.put("Father", LanguageUtil.get(resourceBundle,"father"));
//	    map.put("Granddaughter", LanguageUtil.get(resourceBundle,"granddaughter"));
//	    map.put("Grandson", LanguageUtil.get(resourceBundle,"grandson"));
//	    map.put("Husband", LanguageUtil.get(resourceBundle,"husband"));
//	    map.put("Mother", LanguageUtil.get(resourceBundle,"mother"));
//	    map.put("Other", LanguageUtil.get(resourceBundle,"other"));
//	    map.put("Representative - As per Shariah Law", LanguageUtil.get(resourceBundle,"representative"));
//	    map.put("Sister", LanguageUtil.get(resourceBundle,"sister"));
//	    map.put("Son", LanguageUtil.get(resourceBundle,"son"));
//		map.put("Wife ", LanguageUtil.get(resourceBundle,"wife"));
//		map.put("Brother of Covered Member", LanguageUtil.get(resourceBundle,"brother"));
//	    map.put("Daughter of Covered Member", LanguageUtil.get(resourceBundle,"daughter"));
//	    map.put("Father of Covered Member", LanguageUtil.get(resourceBundle,"father"));
//	    map.put("Granddaughter of Covered Member", LanguageUtil.get(resourceBundle,"granddaughter"));
//	    map.put("Grandson of Covered Member", LanguageUtil.get(resourceBundle,"grandson"));
//	    map.put("Husband of Covered Member", LanguageUtil.get(resourceBundle,"husband"));
//	    map.put("Mother of Covered Member", LanguageUtil.get(resourceBundle,"mother"));
//	    map.put("Sister of Covered Member", LanguageUtil.get(resourceBundle,"sister"));
//	    map.put("Son of Covered Member", LanguageUtil.get(resourceBundle,"son"));
//		map.put("Wife of Covered Member", LanguageUtil.get(resourceBundle,"wife"));
//		map.put("Legal Heirs", LanguageUtil.get(resourceBundle,"legal.heirs"));
//		map.put("Legal heirs", LanguageUtil.get(resourceBundle,"legal.heirs"));
//		map.put("Legal hiers", LanguageUtil.get(resourceBundle,"legal.heirs"));
//
//		map.put("Paid", LanguageUtil.get(resourceBundle,"paid"));
//		map.put("Not Paid", LanguageUtil.get(resourceBundle,"not.paid"));
//		map.put("Reversed", LanguageUtil.get(resourceBundle,"reversed"));
//
//		map.put("Invested", LanguageUtil.get(resourceBundle,"invested"));
//		map.put("To be Invested", LanguageUtil.get(resourceBundle,"to.be.invested"));
//		map.put("To Be Invested", LanguageUtil.get(resourceBundle,"to.be.invested"));
//		
//		map.put("january", LanguageUtil.get(resourceBundle,"january"));
//		map.put("february", LanguageUtil.get(resourceBundle,"february"));
//		map.put("march", LanguageUtil.get(resourceBundle,"march"));
//		map.put("april", LanguageUtil.get(resourceBundle,"april"));
//		map.put("may", LanguageUtil.get(resourceBundle,"may"));
//		map.put("june", LanguageUtil.get(resourceBundle,"june"));
//		map.put("july", LanguageUtil.get(resourceBundle,"july"));
//		map.put("august", LanguageUtil.get(resourceBundle,"august"));
//		map.put("september", LanguageUtil.get(resourceBundle,"september"));
//		map.put("october", LanguageUtil.get(resourceBundle,"october"));
//		map.put("november", LanguageUtil.get(resourceBundle,"november"));
//		map.put("december", LanguageUtil.get(resourceBundle,"december"));
//
//		map.put("sar", LanguageUtil.get(resourceBundle,"sar"));
//		map.put("saudi riyal", LanguageUtil.get(resourceBundle,"sar"));
//		map.put("saudi riyals (sar)", LanguageUtil.get(resourceBundle,"sar"));
//		
//		map.put("SURRENDER", LanguageUtil.get(resourceBundle,"surrender"));
//		map.put("ACTIVE  (INFORCE)", LanguageUtil.get(resourceBundle,"active"));
//		map.put("LAPSED - NON PAYMENT", LanguageUtil.get(resourceBundle,"lapsed"));
//		map.put("NTU - FIRST PREMIUM REVERSED", LanguageUtil.get(resourceBundle,"ntu"));
//		map.put("CANCELLED - CLIENT REQUEST", LanguageUtil.get(resourceBundle,"cancelled.client.request"));
//		map.put("CANCELLED - COMPANY INITIATED", LanguageUtil.get(resourceBundle,"cancelled.company.initiated"));
//		map.put("PENDING - SURRENDER", LanguageUtil.get(resourceBundle,"pending"));
//		map.put("REINSTATED", LanguageUtil.get(resourceBundle,"reinstated"));
//		
//	    return map;
//	}
//}
