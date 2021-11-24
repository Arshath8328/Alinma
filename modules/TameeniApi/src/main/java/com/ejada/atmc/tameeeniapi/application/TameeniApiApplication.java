package com.ejada.atmc.tameeeniapi.application;

import com.atmc.bsl.db.service.QuotationLocalServiceUtil;
import com.atmc.bsl.db.service.impl.CustomerVehicleDetailsLocalServiceImpl;
import com.ejada.atmc.acl.db.exception.NoSuchQuotationsException;
import com.ejada.atmc.acl.db.model.CodeMasterMap;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil;
import com.ejada.atmc.acl.db.service.QuotationsLocalServiceUtil;
import com.ejada.atmc.bsl.db.domain.quotation.Quotation;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationNajmDetails;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails;
import com.ejada.atmc.bsl.db.domain.quotation.QuotationVehicleImage;
import com.ejada.atmc.rest.tameeniapi.domain.DraftPolicyRequest;
import com.ejada.atmc.rest.tameeniapi.domain.DraftPolicyResponse;
import com.ejada.atmc.rest.tameeniapi.domain.DraftPolicyResponseDetails;
import com.ejada.atmc.rest.tameeniapi.domain.DriverDetails;
import com.ejada.atmc.rest.tameeniapi.domain.Error;
import com.ejada.atmc.rest.tameeniapi.domain.NajmCaseDetails;
import com.ejada.atmc.rest.tameeniapi.domain.ODVehicleIdUpdateRequest;
import com.ejada.atmc.rest.tameeniapi.domain.OdPurchaseNotificationsRequest;
import com.ejada.atmc.rest.tameeniapi.domain.OdQuoteResponseDetails;
import com.ejada.atmc.rest.tameeniapi.domain.OdQuotesRequest;
import com.ejada.atmc.rest.tameeniapi.domain.OdQuotesResponse;
import com.ejada.atmc.rest.tameeniapi.domain.TPQuotesResponse;
import com.ejada.atmc.rest.tameeniapi.domain.TPVehicleIdUpdateRequest;
import com.ejada.atmc.rest.tameeniapi.domain.TpPurchaseNotificationsRequest;
import com.ejada.atmc.rest.tameeniapi.domain.TpQuoteDetails;
import com.ejada.atmc.rest.tameeniapi.domain.TpQuotesRequest;
import com.ejada.atmc.rest.tameeniapi.domain.TriggerVehicleIdUpdateRequest;
import com.ejada.atmc.rest.tameeniapi.domain.UpdatePolicyNumberRequest;
import com.ejada.atmc.rest.tameeniapi.domain.VehicleIdUpdateResponse;
import com.ejada.atmc.rest.tameeniapi.domain.VehicleImage;
import com.ejada.atmc.rest.tameeniapi.domain.VehicleImagesUploadRequest;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PropsUtil;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.osgi.service.component.annotations.Component;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * @author ghada
 */
@ApplicationPath("/invokeapi")
@Component(immediate = true, service = Application.class)
public class TameeniApiApplication extends Application {
	
	public static final int PURCHASE_STATUS_FINAL = 1;
	public static final int PURCHASE_STATUS_AWAITING_APP_INSPECTION = 2;
	public static final int PURCHASE_STATUS_AWAITING_PHYSICAL_INSPECTION = 3;
	public static final String POLICY_STATUS_EXPIRED = "EX";
	public static final String QUOTE_STATUS_REJECTED = "RJ";
	public static final String POLICY_STATUS_AWAITNG_INSPECTION = "AI";
	public static final String PRODUCT_CODE_THIRD_PARTY = "TP";
	public static final String PRODUCT_CODE_COMPREHENSIVE = "OD";
	public static int IDENTITY_TYPE_NATIONAL_ID = 1;
	public static int IDENTITY_TYPE_IQAMA_ID = 2;
	public static int IDENTITY_TYPE_COMPUTER_CAR_NO = 3;
	public static int[] policyFeaturesArr = {1,2,3,4,5,6,7,8};
	public static final String ODS_SRC_TYPE_VEH_MAKE = "VEH_MAKE";
	public static final String ODS_SRC_TYPE_INS_ID_TYP = "INS_ID_TYP";
	public static final String ODS_SRC_TYPE_MOT_VEHI_USE = "MOT_VEHI_USE";
	public static final String ODS_SRC_TYPE_SOURCE = "SOURCE";
	public static final String ODS_SRC_TYPE_OCCUPATION = "OCCUPATION";
	public static final String ODS_SRC_TYPE_NATIONALITY = "NATIONALITY";
	public static final String ODS_SRC_TYPE_VEH_ID_TYP = "VEH_ID_TYP";
	public static final String ODS_SRC_TYPE_GENDER = "GENDER";
	public static final String ODS_SRC_TYPE_MAKE_NAT = "MAKE_NATIONALITY";
	public static final String ODS_SRC_TYPE_CITY = "CITY";
	public static final String ODS_SRC_TYPE_PLATE_TYPE = "PLATE_TYPE";
	public static final String ODS_SRC_TYPE_PLATE_LETTER = "PLATE_LETTER";
	public static final String ODS_SRC_TYPE_COLOR = "COLOR";
	
	
	private static final String DEFAULT_VEHICLE_NATIONALITY = "01";
	
	private static final Log _log = LogFactoryUtil.getLog(TameeniApiApplication.class);
	private SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy");
	private SimpleDateFormat dateFormatter2 = new SimpleDateFormat("yyyy-MM-dd");
	

	public Set<Object> getSingletons() {
		return Collections.<Object>singleton(this);
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/triggerVehicleIdUpdate/tp")
	public String triggerVehicleIdUpdateTp(TriggerVehicleIdUpdateRequest req) {
		
		String vehicleIdUpdateUrl = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.tp.url");
		String vehicleIdUpdateUsername = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.tp.username");
		String vehicleIdUpdatePassword = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.tp.password");
		
		RestTemplate restTempl =  new RestTemplate();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization" , "Basic " + generationBasicAuthString(vehicleIdUpdateUsername,vehicleIdUpdatePassword));
		
		TPVehicleIdUpdateRequest vehIdUpdateReq = new TPVehicleIdUpdateRequest();
		vehIdUpdateReq.setCustomizedParameterList(req.getCustomizedParameterList());
		vehIdUpdateReq.setInsuranceCompanyCode((int)req.getInsuranceCompanyCode());
		vehIdUpdateReq.setNajmVehicleId(req.getNajmVehicleId());
		vehIdUpdateReq.setPolicyUploadedDateTime(req.getPolicyUploadedDateTime());
		vehIdUpdateReq.setQuoteReferenceNo(req.getQuoteReferenceNo());
		vehIdUpdateReq.setRequestReferenceNo(""+req.getRequestReferenceNo());
		
		HttpEntity<TPVehicleIdUpdateRequest> vehicleIdUpdateRequest = new HttpEntity<TPVehicleIdUpdateRequest>(vehIdUpdateReq, headers);

		ResponseEntity<String> response = restTempl.exchange(vehicleIdUpdateUrl, HttpMethod.POST, vehicleIdUpdateRequest, String.class);

		return response.getBody();
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/triggerVehicleIdUpdate/od")
	public String triggerVehicleIdUpdateOd(TriggerVehicleIdUpdateRequest req) {
		
		String vehicleIdUpdateUrl = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.od.url");
		String vehicleIdUpdateUsername = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.od.username");
		String vehicleIdUpdatePassword = PropsUtil.get("com.ejada.atmc.tameeni.vehicleidupdate.od.password");
		
		RestTemplate restTempl =  new RestTemplate();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization" , "Basic " + generationBasicAuthString(vehicleIdUpdateUsername,vehicleIdUpdatePassword));
		
		ODVehicleIdUpdateRequest vehIdUpdateReq = new ODVehicleIdUpdateRequest();
		vehIdUpdateReq.setCustomizedParameterList(req.getCustomizedParameterList());
		vehIdUpdateReq.setInsuranceCompanyCode((int)req.getInsuranceCompanyCode());
		vehIdUpdateReq.setNajmVehicleId(req.getNajmVehicleId());
		vehIdUpdateReq.setPolicyUploadedDateTime(""+req.getPolicyUploadedDateTime());
		vehIdUpdateReq.setPolicyReferenceNo(req.getQuoteReferenceNo());
		vehIdUpdateReq.setPolicyRequestReferenceNo(""+req.getRequestReferenceNo());
		
		HttpEntity<ODVehicleIdUpdateRequest> vehicleIdUpdateRequest = new HttpEntity<ODVehicleIdUpdateRequest>(vehIdUpdateReq, headers);

		ResponseEntity<String> response = restTempl.exchange(vehicleIdUpdateUrl, HttpMethod.POST, vehicleIdUpdateRequest, String.class);
		//_log.info(response.getBody().isStatus());
		ObjectMapper mapper = new ObjectMapper();
		try
		{
			VehicleIdUpdateResponse res = mapper.readValue(response.getBody(), VehicleIdUpdateResponse.class);
			_log.info(res.isStatus());
		}
		catch (JsonParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (JsonMappingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response.getBody();
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Quotes/tp")
	public String quotes(TpQuotesRequest req)
	{
		TPQuotesResponse response = new TPQuotesResponse();
		QuotationTameeniExtraDetails extras = new QuotationTameeniExtraDetails();
		ArrayList<QuotationNajmDetails> najmDetailsList = null;
		String requestString = null;
		String responseString = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try 
		{
			requestString = mapper.writeValueAsString(req);
			
			logRequestResponse(requestString,"REQUEST", "/Quotes/tp");
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			Quotation quote = mapTpQuoteRequestToDomainObject(req);
			
			if(req.getDetails().getArabicFirstName() == null || req.getDetails().getArabicFirstName().equals(""))
			{
				extras.setInsuredFirstName(req.getDetails().getEnglishFirstName());
				extras.setInsuredMiddleName(req.getDetails().getEnglishMiddleName());
				extras.setInsuredLastName(req.getDetails().getEnglishLastName());
				extras.setInsuredNameLang("EN");
				quote.setInsuredName(req.getDetails().getEnglishFirstName() + " " + req.getDetails().getEnglishMiddleName() + " " + req.getDetails().getEnglishLastName());
			}
			else
			{
				extras.setInsuredFirstName(req.getDetails().getArabicFirstName());
				extras.setInsuredMiddleName(req.getDetails().getArabicMiddleName());
				extras.setInsuredLastName(req.getDetails().getArabicLastName());
				extras.setInsuredNameLang("AR");
				quote.setInsuredName(req.getDetails().getArabicFirstName() + " " + req.getDetails().getArabicMiddleName() + " " + req.getDetails().getArabicLastName());
			}
			
			extras.setDriverDisabled(req.getDetails().isDriverDisabled());
			extras.setCoverAgeLimit(req.getDetails().getCoverAgeLimitID());
			extras.setVehicleMakeCodeTameeni(req.getDetails().getVehicleMakeCodeTameeni());
			extras.setRenewal(req.getDetails().isRenewal());
			
			if(req.getDetails().getNajmCaseDetails()!=null && req.getDetails().getNajmCaseDetails().size()>0)
			{
				najmDetailsList = new ArrayList<QuotationNajmDetails>();
				
				for(NajmCaseDetails ncd:req.getDetails().getNajmCaseDetails())
				{
					QuotationNajmDetails najmDetails = new QuotationNajmDetails();
					najmDetails.setCaseNumber(ncd.getCaseNumber());
					najmDetails.setAccidentDate(ncd.getAccidentDate());
					najmDetails.setLiability(ncd.getLiability());
					najmDetails.setDriverAge(ncd.getDriverAge());
					najmDetails.setCarModel(ncd.getCarModel());
					najmDetails.setCarType(ncd.getCarType());
					najmDetails.setDriverID(ncd.getDriverID());
					najmDetails.setSequenceNumber(ncd.getSequenceNumber());
					najmDetails.setOwnerID(ncd.getOwnerID());
					najmDetails.setEstimatedAmount(ncd.getEstimatedAmount());
					najmDetails.setDamageParts(ncd.getDamageParts());
					najmDetails.setCauseOfAccident(ncd.getCauseOfAccident());
					
					najmDetailsList.add(najmDetails);
				}
			}
						
			//Get Vehicle Nationality to pass to tariff
			int makeCodeNIC = req.getDetails().getVehicleMakeCodeNIC();
			String vehicleMakeNationality = getVehicleNationality(makeCodeNIC);
			
			quote.setVehicleNationality(vehicleMakeNationality);
			
			if(req.getDetails().isScheme() && req.getDetails().getSchemeDetails()!=null && req.getDetails().getSchemeDetails().size()>0)
			{
				quote.setSchemeCode(req.getDetails().getSchemeDetails().get(0).getSchemeRef());
			}
			
			//Calling Tariff
			quote = QuotationLocalServiceUtil.getTariffDets(quote,false);
			
			//Saving Quotation then related data in DB
			quote = QuotationLocalServiceUtil.submitQuotation(quote, String.valueOf(quote.getInsuredId()));
			
			if(quote.getQuotationId()!=0)
			{
				extras.setQuotationId(quote.getQuotationId());
				QuotationLocalServiceUtil.updateQuotationTameeniExtras(extras);
				
				if(najmDetailsList!=null)
					QuotationLocalServiceUtil.saveNajmCaseDetails(najmDetailsList,quote.getQuotationId());
			}
				
			String quoteReferenceNumber = quote.getReferenceNo().substring(1);
			
			response.setRequestReferenceNo(req.getRequestReferenceNo());
			response.setQuoteReferenceNo(Long.valueOf(quoteReferenceNumber));
			response.setInsuranceCompanyCode(req.getInsuranceCompanyCode());
			
			TpQuoteDetails respDetails = req.getDetails();
			
			respDetails.setPolicyAmount(quote.getNetPrem());
			respDetails.setPolicyTaxableAmount(quote.getNetPrem());
			respDetails.setMaxLiability(10000000);
			respDetails.setPolicyNumber(quoteReferenceNumber);
			respDetails.setPolicyFeatures(policyFeaturesArr);
			
			Calendar c = Calendar.getInstance();
			c.setTime(quote.getPolicyEffDate());
			c.add(Calendar.YEAR, 1);
			respDetails.setPolicyExpiryDate(c.getTimeInMillis());
			
			if(quote.getQuoteSubmissionDate()!=null)
				respDetails.setPolicyIssueDate(quote.getQuoteSubmissionDate().getTime());
			
			response.setDetails(respDetails);
			
			response.setStatus(true);
			response.setErrors(null);
			
			responseString = mapper.writeValueAsString(response);
			
		}
		catch(Exception e)
		{
			_log.info("Failed to submit quotation");
			e.printStackTrace();
			
			response.setStatus(false);
			Error err = new Error();
			ArrayList<Error> errors = new ArrayList<Error>();
			errors.add(err);
			err.setMessage("General Failure in Quotation TP service");
			response.setErrors(errors);
		}
		

		ResponseEntity<String> resp = new ResponseEntity<String>(responseString, HttpStatus.OK);

		logRequestResponse(resp.getBody(),"RESPONSE", "/Quotes/tp");
		
		return resp.getBody();

	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/Quotes/od")
	public String quotes(OdQuotesRequest req)
	{
		OdQuotesResponse response = new OdQuotesResponse();
		
		String responseString = null;
		String requestString = null;
		ObjectMapper mapper = new ObjectMapper();
		OdQuoteResponseDetails respDetails = new OdQuoteResponseDetails();
		QuotationTameeniExtraDetails extras = new QuotationTameeniExtraDetails();
		ArrayList<QuotationNajmDetails> najmDetailsList = null;
		
		try 
		{
			requestString = mapper.writeValueAsString(req);
			
			logRequestResponse(requestString,"REQUEST", "/Quotes/od");
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try
		{
			Quotation quote = mapOdQuoteRequestToDomainObject(req);
			
			if(req.getDetails().getArabicFirstName() == null || req.getDetails().getArabicFirstName().equals(""))
			{
				extras.setInsuredFirstName(req.getDetails().getEnglishFirstName());
				extras.setInsuredMiddleName(req.getDetails().getEnglishMiddleName());
				extras.setInsuredLastName(req.getDetails().getEnglishLastName());
				extras.setInsuredNameLang("EN");
				quote.setInsuredName(req.getDetails().getEnglishFirstName() + " " + req.getDetails().getEnglishMiddleName() + " " + req.getDetails().getEnglishLastName());
			}
			else
			{
				extras.setInsuredFirstName(req.getDetails().getArabicFirstName());
				extras.setInsuredMiddleName(req.getDetails().getArabicMiddleName());
				extras.setInsuredLastName(req.getDetails().getArabicLastName());
				extras.setInsuredNameLang("AR");
				quote.setInsuredName(req.getDetails().getArabicFirstName() + " " + req.getDetails().getArabicMiddleName() + " " + req.getDetails().getArabicLastName());
			}
			
			extras.setDriverDisabled(req.getDetails().isDriverDisabled());
			extras.setCoverAgeLimit(req.getDetails().getCoverAgeLimitID());
			extras.setVehicleMakeCodeTameeni(req.getDetails().getVehicleMakeCodeTameeni());
			extras.setPolicyTitleID(req.getDetails().getPolicyTitleID());
			extras.setRenewal(req.getDetails().isRenewal());
			
			if(req.getDetails().getNajmCaseDetails()!=null && req.getDetails().getNajmCaseDetails().size()>0)
			{
				najmDetailsList = new ArrayList<QuotationNajmDetails>();
				
				for(NajmCaseDetails ncd:req.getDetails().getNajmCaseDetails())
				{
					QuotationNajmDetails najmDetails = new QuotationNajmDetails();
					najmDetails.setCaseNumber(ncd.getCaseNumber());
					najmDetails.setAccidentDate(ncd.getAccidentDate());
					najmDetails.setLiability(ncd.getLiability());
					najmDetails.setDriverAge(ncd.getDriverAge());
					najmDetails.setCarModel(ncd.getCarModel());
					najmDetails.setCarType(ncd.getCarType());
					najmDetails.setDriverID(ncd.getDriverID());
					najmDetails.setSequenceNumber(ncd.getSequenceNumber());
					najmDetails.setOwnerID(ncd.getOwnerID());
					najmDetails.setEstimatedAmount(ncd.getEstimatedAmount());
					najmDetails.setDamageParts(ncd.getDamageParts());
					najmDetails.setCauseOfAccident(ncd.getCauseOfAccident());
					
					najmDetailsList.add(najmDetails);
				}
			}
			

			
			//Get Vehicle Nationality to pass to tariff
			int makeCodeNIC = req.getDetails().getVehicleMakeCodeNIC();
			String vehicleMakeNationality = getVehicleNationality(makeCodeNIC);
			
			quote.setVehicleNationality(vehicleMakeNationality);
			
			if(req.getDetails().isScheme() && req.getDetails().getSchemeDetails()!=null && req.getDetails().getSchemeDetails().size()>0)
			{
				quote.setSchemeCode(req.getDetails().getSchemeDetails().get(0).getSchemeRef());
			}
			
			//Call Tariff
			quote = QuotationLocalServiceUtil.getTariffDets(quote,false);
			
			//Save Quotation In DB
			quote = QuotationLocalServiceUtil.submitQuotation(quote, String.valueOf(quote.getInsuredId()));
			
			if(quote.getQuotationId()!=0)
			{
				extras.setQuotationId(quote.getQuotationId());
				QuotationLocalServiceUtil.updateQuotationTameeniExtras(extras);
				
				if(najmDetailsList!=null)
					QuotationLocalServiceUtil.saveNajmCaseDetails(najmDetailsList,quote.getQuotationId());
			}
			
			String quoteReferenceNumber = quote.getReferenceNo().substring(1);
			
			response.setQuoteReferenceNo(Long.valueOf(quoteReferenceNumber));
			response.setRequestReferenceNo(req.getRequestReferenceNo());
			response.setInsuranceCompanyCode(req.getInsuranceCompanyCode());
			response.setStatus(true);
			response.setErrors(null);
			
			respDetails.setMaxLiability(10000);  //temp
			respDetails.setPolicyEffectiveDate(dateFormatter.format(quote.getPolicyEffDate()));
			respDetails.setPolicyTitleID(req.getDetails().getPolicyTitleID());
			respDetails.setInspectionTypeID(2);
			
			Date policyEffectiveDate = quote.getPolicyEffDate();
			Calendar c = Calendar.getInstance();
			c.setTime(policyEffectiveDate);
			c.add(Calendar.YEAR, 1);
			
			Date policyExpiryDate = c.getTime();
			respDetails.setPolicyExpiryDate(dateFormatter.format(policyExpiryDate));
			
			response.setDetails(respDetails);
			
			mapper = new ObjectMapper();
			
			responseString = mapper.writeValueAsString(response);
		}
		catch(Exception e)
		{
			_log.info("Failed to submit quotation");
			e.printStackTrace();
			
			response.setStatus(false);
			Error err = new Error();
			ArrayList<Error> errors = new ArrayList<Error>();
			errors.add(err);
			err.setMessage("General Failure in Quotation OD service");
			response.setErrors(errors);
		}
		
		ResponseEntity<String> resp = new ResponseEntity<String>(responseString, HttpStatus.OK);

		logRequestResponse(resp.getBody(),"RESPONSE", "/Quotes/od");
		
		return resp.getBody();
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PurchaseNotifications/tp")
	public String purchaseNotificationsTp(TpPurchaseNotificationsRequest purchaseNotificationReq) 
	{	
		ResponseEntity<String> response = null;
		String responseString = null;
		String requestString = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try 
		{
			requestString = mapper.writeValueAsString(purchaseNotificationReq);
			
			logRequestResponse(requestString,"REQUEST", "/PurchaseNotifications/tp");
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long quoteReferenceNumber = purchaseNotificationReq.getQuoteReferenceNo();
		
		String quoteReferenceNumberStr = "Q" + quoteReferenceNumber;
				
		try
		{
			_log.info("Retrieving quotation with reference no:" + quoteReferenceNumberStr);
			Quotation quotation = QuotationLocalServiceUtil.getQuotationByReferenceNo(quoteReferenceNumberStr);
			
			if(quotation!=null)
			{
				_log.info("Found quotation with reference no:" + quotation.getReferenceNo());
				String tempPolicyNumber = quotation.getPolicyNo();
				
				quotation.setInsuredEmail(purchaseNotificationReq.getDetails().getEmail());
				quotation.setInsuredMobile(""+purchaseNotificationReq.getDetails().getMobileNo());
				quotation.setAddressBuildingNo(purchaseNotificationReq.getDetails().getBuildingNumber());
				quotation.setAddressStreet(purchaseNotificationReq.getDetails().getStreet());
				quotation.setAddressDistrict(purchaseNotificationReq.getDetails().getDistrict());
				quotation.setCity(purchaseNotificationReq.getDetails().getCity());
				quotation.setAddressZipCode(purchaseNotificationReq.getDetails().getZipCode());
				quotation.setAddressAddNo(purchaseNotificationReq.getDetails().getAdditionalNumber());
				quotation.setPaymentRefNo(""+purchaseNotificationReq.getDetails().getCreditNoteNumber());
				long paymentAmount = new Double(purchaseNotificationReq.getDetails().getCreditAmount()).longValue();
				_log.info("payment amount:" + paymentAmount);
				quotation.setPaymemtAmount(paymentAmount);
				quotation.setGrossPrem(purchaseNotificationReq.getDetails().getCreditAmount());
				quotation.setVehicleOwnerIban(purchaseNotificationReq.getDetails().getIbanNumber());
				
				_log.info("Updating quoatation with PurchaseNotifications values");
				
				updateQuotation(quotation);
				
				if(purchaseNotificationReq.isPurchased())
				{
					//Issue Policy
					_log.info("Issuing Policy");
					QuotationLocalServiceUtil.issuePolicy(quotation);
					
					_log.info("Issue policy result:" + quotation.getQuoteStatus());
					
					if(quotation.getPolicyNo()!=null && !quotation.getQuoteStatus().equals(QUOTE_STATUS_REJECTED))
					{
						_log.info("Issue Policy Success. Will update Tameeni Policy Number");
						//Update Policy Number at Tameeni after Policy issuance
						UpdatePolicyNumberRequest updateReq = new UpdatePolicyNumberRequest();
						updateReq.setInsuranceCompanyCode(purchaseNotificationReq.getInsuranceCompanyCode());
						updateReq.setQuoteReferenceNo(quoteReferenceNumber);
						updateReq.setRequestReferenceNo(purchaseNotificationReq.getRequestReferenceNo());
						updateReq.setOldPolicyNumber(tempPolicyNumber);
						updateReq.setNewPolicyNumber(quotation.getPolicyNo());
						updateReq.setInsuranceTypeId(purchaseNotificationReq.getInsuranceTypeID());
						updateReq.setCustomizedParameterList(null);
						
						//Update Policy Number at Tameeni (They have a temp one until policy issuance success)
						_log.info("Updating Policy Number");
						responseString = updatePolicyNumber(updateReq);
					}
					else
					{
						_log.info("Issue Policy Failed.");
						responseString = "{Status:false,errors:[{'field':'','message':'Issue Policy Failed'}]}";
					}
				}
				else
				{
					//Cancel Policy Scenario. Update Quote Status As cancelled/expired
					_log.info("Updating Quote Status as Expired");
					QuotationLocalServiceUtil.updateQuoteStatus(quotation.getQuotationId(), POLICY_STATUS_EXPIRED);
					
					responseString = "{Status:true,errors:null}";
				}
			}
			else
			{
				_log.info("No quotation found with reference number:" + quoteReferenceNumberStr);
				responseString = "{Status:false,errors:[{'field':'quoteReferenceNo','message':'Quotation with provided reference number not found'}]}";
			}
		}
		catch(Exception e)
		{
			_log.info("Exception in Purchase Notifications TP");
			e.printStackTrace();
			
			responseString = "{Status:false,errors:[{'field':'','message':'Generic Error Message'}]}";
		}
		
		response = new ResponseEntity<String>(responseString, HttpStatus.OK);
		
		logRequestResponse(response.getBody(),"RESPONSE", "/PurchaseNotifications/tp");
		
		return response.getBody();
	}

	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/PurchaseNotifications/od")
	public String purchaseNotificationsOd(OdPurchaseNotificationsRequest purchaseNotificationReq) 
	{
		ResponseEntity<String> response = null;
		String requestString = null;
		String responseString = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try 
		{
			requestString = mapper.writeValueAsString(purchaseNotificationReq);
			
			logRequestResponse(requestString,"REQUEST", "/PurchaseNotifications/od");
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		long policyReferenceNumber = purchaseNotificationReq.getPolicyReferenceNo();
		String policyReferenceNumberStr = "Q" + policyReferenceNumber;
		
		try
		{
			_log.info("Retrieving quotation with reference no:" + policyReferenceNumberStr);
			Quotation quotation = QuotationLocalServiceUtil.getQuotationByReferenceNo(policyReferenceNumberStr);
			
			if(quotation!=null)
			{
				String tempPolicyNumber = quotation.getPolicyNo();
				
				quotation.setInsuredEmail(purchaseNotificationReq.getDetails().getEmail());
				quotation.setInsuredMobile(""+purchaseNotificationReq.getDetails().getMobileNo());
				quotation.setAddressBuildingNo(purchaseNotificationReq.getDetails().getBuildingNumber());
				quotation.setAddressStreet(purchaseNotificationReq.getDetails().getStreet());
				quotation.setAddressDistrict(purchaseNotificationReq.getDetails().getDistrict());
				quotation.setCity(purchaseNotificationReq.getDetails().getCity());
				quotation.setAddressZipCode(purchaseNotificationReq.getDetails().getZipCode());
				quotation.setAddressAddNo(purchaseNotificationReq.getDetails().getAdditionalNumber());
				quotation.setPaymentRefNo(""+purchaseNotificationReq.getDetails().getCreditNoteNumber());
				quotation.setPaymemtAmount(Long.valueOf(""+purchaseNotificationReq.getDetails().getCreditAmount()));
				quotation.setVehicleOwnerIban(purchaseNotificationReq.getDetails().getIbanNumber());
				
				updateQuotation(quotation);
				
				if(purchaseNotificationReq.isPurchased())
				{
					if(purchaseNotificationReq.getDetails().getPurchaseStatus() == PURCHASE_STATUS_AWAITING_APP_INSPECTION || purchaseNotificationReq.getDetails().getPurchaseStatus() == PURCHASE_STATUS_AWAITING_PHYSICAL_INSPECTION)
					{
						//Set a Tameeni Transient State For Awaiting App/Physical Inspection (hence AI)
						_log.info("Updating Quote Status as Awaiting Inspection");
						QuotationLocalServiceUtil.updateQuoteStatus(quotation.getQuotationId(), POLICY_STATUS_AWAITNG_INSPECTION);
						
						responseString = "{Status:true,errors:null}";
						
					}
					else if(purchaseNotificationReq.getDetails().getPurchaseStatus() == PURCHASE_STATUS_FINAL)
					{
						
						//Issue Policy
						_log.info("Issuing Policy");
						QuotationLocalServiceUtil.issuePolicy(quotation);
						
						_log.info("Issue policy result:" + quotation.getPolicyStatusCode());
						
						if(quotation.getPolicyNo()!=null && !quotation.getPolicyNo().equals(""))
						{
							_log.info("Issue Policy Success. Will update Tameeni Policy Number");
							
							//Update Policy Number at Tameeni after Policy issuance
							UpdatePolicyNumberRequest updateReq = new UpdatePolicyNumberRequest();
							updateReq.setInsuranceCompanyCode(purchaseNotificationReq.getInsuranceCompanyCode());
							updateReq.setPolicyReferenceNo(policyReferenceNumber);
							updateReq.setPolicyRequestReferenceNo(purchaseNotificationReq.getPolicyRequestReferenceNo());
							updateReq.setOldPolicyNumber(tempPolicyNumber);
							updateReq.setNewPolicyNumber(quotation.getPolicyNo());
							updateReq.setCustomizedParameterList(null);
							
							//Update Policy Number at Tameeni (They have a temp one until policy issuance success)
							_log.info("Updating Policy Number");
							responseString = updatePolicyNumber(updateReq);
						}					
					}
				}
				else
				{
					//Cancel Policy Scenario. Update Quote Status As cancelled/expired
					_log.info("Updating Quote Status as Expired");
					QuotationLocalServiceUtil.updateQuoteStatus(quotation.getQuotationId(), POLICY_STATUS_EXPIRED);
					
					responseString = "{Status:true,errors:null}";
				}
			}
			else
			{
				_log.info("No quotation found with reference number:" + policyReferenceNumberStr);
				responseString = "{Status:false,errors:[{'field':'policyReferenceNo','message':'Quotation with provided reference number not found'}]}";
			}
		}
		catch(Exception e)
		{
			_log.info("Exception in Purchase Notifications OD");
			e.printStackTrace();
			
			responseString = "{Status:false,errors:[{'field':'','message':'Generic Error'}]}";
		}
		response = new ResponseEntity<String>(responseString, HttpStatus.OK);
		
		logRequestResponse(response.getBody(),"RESPONSE", "/PurchaseNotifications/od");
		
		return response.getBody();
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/DraftPolicy/od")
	public String draftPolicy(DraftPolicyRequest draftPolicyReq)
	{
		DraftPolicyResponse resp = new DraftPolicyResponse();
		String responseString = null;
		String requestString = null;
		
		ObjectMapper mapper = new ObjectMapper();
		
		try 
		{
			requestString = mapper.writeValueAsString(draftPolicyReq);
			
			logRequestResponse(requestString,"REQUEST", "/DraftPolicy/od");
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		_log.info("policyReferenceNo:" + draftPolicyReq.getQuoteReferenceNo());
		
		ResponseEntity<String> response = null;
		
		long quoteeferenceNumber = draftPolicyReq.getQuoteReferenceNo();
		String quoteReferenceNumberStr = "Q" + quoteeferenceNumber;
				
		try
		{
			DraftPolicyResponseDetails respDetails = new DraftPolicyResponseDetails();
			
			_log.info("Retrieving quotation with reference no:" + quoteReferenceNumberStr);
			Quotation quotation = QuotationLocalServiceUtil.getQuotationByReferenceNo(quoteReferenceNumberStr);
			
			if(quotation!=null)
			{
				respDetails.setPolicyholderIdentityTypeCode(quotation.getInsuredIdType());
				respDetails.setPolicyHolderID(quotation.getInsuredId());
				respDetails.setPurposeofVehicleUseID(Long.parseLong(quotation.getPurposeOfVehicle()));
				respDetails.setQuoteRequestSourceID(Integer.parseInt(quotation.getSource()));
				respDetails.setFullName(quotation.getInsuredName());
				
				if(quotation.getInsuredIdType() == IDENTITY_TYPE_NATIONAL_ID)
					respDetails.setDateOfBirthH(quotation.getInsuredDobH());
				
				else if(quotation.getInsuredIdType() == IDENTITY_TYPE_IQAMA_ID)
					respDetails.setDateOfBirthG(dateFormatter.format(quotation.getInsuredDob()));
				
				respDetails.setOccupation(quotation.getInsuredOccupationCode());
				respDetails.setCylinders(quotation.getVehicleCylinder());
				respDetails.setVehicleCapacity((int) quotation.getVehicleCapacity());
				respDetails.setPolicyholderNationalityID(Integer.parseInt(quotation.getInsuredNationality()));
				respDetails.setVehicleUniqueTypeID((int) quotation.getVehicleIdType());
				
				if(quotation.getVehicleIdType() == 1)
				{
					respDetails.setVehicleSequenceNumber(quotation.getVehicleId());
					respDetails.setVehiclePlateTypeID(Integer.parseInt(quotation.getVehiclePlateType()));
					respDetails.setVehiclePlateNumber(quotation.getVehiclePlateNo());
					respDetails.setFirstPlateLetterID(quotation.getVehiclePlateL1());
					respDetails.setSecondPlateLetterID(quotation.getVehiclePlateL2());
					respDetails.setThirdPlateLetterID(quotation.getVehiclePlateL3());
					respDetails.setVehicleModelCodeNIC(Integer.parseInt(quotation.getVehicleModel()));
					respDetails.setVehicleRegistrationExpiryDate(dateFormatter.format(quotation.getVehicleEstExpiryDate()));
				}
				else if(quotation.getVehicleIdType() == 2)
				{
					respDetails.setVehicleCustomID((int) quotation.getVehicleId());
				}
				
				respDetails.setPolicyholderGender(Integer.parseInt(quotation.getInsuredGender()));
				respDetails.setVehicleDriveCityID(Integer.parseInt(quotation.getVehicleCity()));
				respDetails.setVehicleMakeCodeNIC(Integer.parseInt(quotation.getVehicleMake()));
				respDetails.setVehicleModelCodeNIC(Integer.parseInt(quotation.getVehicleModel()));
				respDetails.setManufactureYear((int) quotation.getVehicleMfgYear());
				respDetails.setVehicleColorCode(Integer.parseInt(quotation.getVehicleColor()));
				respDetails.setVehicleVIN(quotation.getVehicleChassisNo());
				respDetails.setPolicyNumber(quoteReferenceNumberStr);   //Temp Number to be replace by real on on policy issuance
				respDetails.setMobileNo(quotation.getInsuredMobile());
				respDetails.setBuildingNumber(String.valueOf(quotation.getAddressBuildingNo()));
				respDetails.setStreet(quotation.getAddressStreet());
				respDetails.setDistrict(quotation.getAddressDistrict());
				respDetails.setZipCode((int) quotation.getAddressZipCode());
				respDetails.setAdditionalNumber((int) quotation.getAddressAddNo());
				respDetails.setVehicleWeight((int) quotation.getVehicleWeight());
				respDetails.setVehicleBodyCode(Integer.parseInt(quotation.getVehicleBodyType()));
				respDetails.setVehicleSumInsured((int) quotation.getVehicleValue());
				
				if(quotation.getAgencyRepair()!=null && !quotation.getAgencyRepair().equals(""))
					respDetails.setRepairMethod(Integer.parseInt(quotation.getAgencyRepair()));
				
				respDetails.setDeductibleAmount(draftPolicyReq.getDetails().getDeductibleAmount());
				respDetails.setPolicyPremium(draftPolicyReq.getDetails().getPolicyPremium());
				//respDetails.setPremiumBreakdownList(draftPolicyReq.getDetails().get);
				respDetails.setPolicyPremiumFeaturesList(draftPolicyReq.getDetails().getPolicyPremiumFeatureList());
				//respDetails.setDiscountsList(quotation.getDis);
				//respDetails.setCustomizedParameterList(customizedParameterList);
				
				Date policyEffectiveDate = quotation.getPolicyEffDate();
				
				Calendar c = Calendar.getInstance();
				c.setTime(policyEffectiveDate);
				c.add(Calendar.YEAR, 1);
				
				Date policyExpiryDate = c.getTime();
				
				
				respDetails.setPolicyEffectiveDate(dateFormatter.format(policyEffectiveDate));
				respDetails.setPolicyExpiryDate(dateFormatter.format(policyExpiryDate));
				
				if(quotation.getPolicyIssueDate()!=null &&!quotation.getPolicyIssueDate().equals(""))
					respDetails.setPolicyIssueDate(dateFormatter.format(quotation.getPolicyIssueDate()));
				
				respDetails.setPrimaryDriver(quotation.isMainDriver());
				
				if(!quotation.isMainDriver() && quotation.getQuotationDrivers()!=null && !quotation.getQuotationDrivers().isEmpty())
				{
					QuotationDriver driver = quotation.getQuotationDrivers().get(0);
					respDetails.setPrimaryDriverID((int) driver.getDriverId());
					respDetails.setPrimaryDriverName(driver.getDriverName());
					
					String driverIdStr = String.valueOf(driver.getDriverId());
					
					if(driverIdStr.startsWith("2"))
					{
						respDetails.setPrimaryDriverGender(Integer.parseInt(driver.getDriverGender()));
						respDetails.setPrimaryDriverDateOfBirthG(dateFormatter.format(driver.getDriverDob()));
					}
					else if(driverIdStr.startsWith("1"))
					{
						respDetails.setPrimaryDriverGender(Integer.parseInt(driver.getDriverGender()));
						respDetails.setPrimaryDriverDateOfBirthH(driver.getDriverDobH());
					}
				}
				
				//Retrieve Extra Tameeni Details
				QuotationTameeniExtraDetails details = QuotationLocalServiceUtil.getQuotationTameeniExtras(quotation.getQuotationId());
				
				respDetails.setCoverAgeLimitID((int) details.getCoverAgeLimit());
				respDetails.setVehicleMakeCodeTameeni((int) details.getVehicleMakeCodeTameeni());
				
				if(details.getInsuredNameLang().equalsIgnoreCase("EN"))
				{
					respDetails.setEnglishFirstName(details.getInsuredFirstName());
					respDetails.setEnglishMiddleName(details.getInsuredMiddleName());
					respDetails.setEnglishLastName(details.getInsuredLastName());
				}
				else
				{
					respDetails.setArabicFirstName(details.getInsuredFirstName());
					respDetails.setArabicMiddleName(details.getInsuredMiddleName());
					respDetails.setArabicLastName(details.getInsuredLastName());
				}
				
				
				respDetails.setDriverDisabled(details.isDriverDisabled());
				respDetails.setPolicyTitleID(details.getPolicyTitleID());
				respDetails.setRenewal(details.isRenewal());
				
				if(details.getCoverAgeLimit()>=6)
				{
					if(quotation.getUnder21Drivers()!=null && quotation.getUnder21Drivers().size()>0)
					{
						ArrayList<DriverDetails> underAgeDriversList = new ArrayList<DriverDetails>();
						for(QuotationDriver d:quotation.getUnder21Drivers())
						{
							DriverDetails driver = new DriverDetails();
							driver.setDriverID((int) d.getDriverId());
							driver.setDriverName(d.getDriverName());
							driver.setDriverDateOfBirthG(dateFormatter.format( d.getDriverDob()));
							driver.setDriverDateOfBirthH(d.getDriverDobH());
							
							if(d.getDriverGender()!=null)
								driver.setDriverGender(Integer.parseInt(d.getDriverGender()));
							
							underAgeDriversList.add(driver);
						}
						
						respDetails.setDriverDetailsList(underAgeDriversList);
					}
				}
				
				resp.setDetails(respDetails);
				
				resp.setPolicyRequestReferenceNo(draftPolicyReq.getPolicyRequestReferenceNo());
				resp.setInsuranceCompanyCode(draftPolicyReq.getInsuranceCompanyCode());
				resp.setRequestReferenceNo(draftPolicyReq.getRequestReferenceNo());
				resp.setQuoteReferenceNo(draftPolicyReq.getQuoteReferenceNo());
				
				resp.setStatus(true);
				resp.setErrors(null);
			}
			else
			{
				_log.info("No quotation found with reference number:" + quoteReferenceNumberStr);
				responseString = "{Status:false,errors:[{'field':'quoteReferenceNo','message':'Quotation with provided reference number not found'}]}";
			}
		}
		catch(Exception e)
		{
			_log.info("Exception in Draft Policy OD");
			e.printStackTrace();
			
			resp.setStatus(false);
			Error err = new Error();
			ArrayList<Error> errors = new ArrayList<Error>();
			errors.add(err);
			err.setMessage("General Failure in Draft Policy OD");
			resp.setErrors(errors);
			
		}
		
		try 
		{
			responseString = mapper.writeValueAsString(resp);
		} 
		catch (JsonProcessingException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response = new ResponseEntity<String>(responseString, HttpStatus.OK);
		
		logRequestResponse(response.getBody(),"RESPONSE", "/DraftPolicy/od");

		return responseString;
	}
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/UpdatePolicyNumber")
	public String updatePolicyNumber(UpdatePolicyNumberRequest req) 
	{
		String updatePolicyNumberUrl = PropsUtil.get("com.ejada.atmc.tameeni.updatepolicyNumber.url");
		String updatePolicyNumberUsername = PropsUtil.get("com.ejada.atmc.tameeni.updatepolicyNumber.username");
		String updatePolicyNumberPassword = PropsUtil.get("com.ejada.atmc.tameeni.updatepolicyNumber.password");
		RestTemplate restTempl =  new RestTemplate();

		MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
		headers.add("Content-Type", "application/json");
		headers.add("Authorization" , "Basic " + generationBasicAuthString(updatePolicyNumberUsername,updatePolicyNumberPassword));
		
		
		HttpEntity<UpdatePolicyNumberRequest> updatePolicyNumberRequest = new HttpEntity<UpdatePolicyNumberRequest>(req, headers);
		//updatePolicyNumberRequest.getHeaders().set("Content-Type", "application/json");

		ResponseEntity<String> response = restTempl.exchange(updatePolicyNumberUrl, HttpMethod.POST, updatePolicyNumberRequest, String.class);

		
		logRequestResponse(response.getBody(),"RESPONSE", "/UpdatePolicyNumber");
		
		return response.getBody();
	}
	
	@POST
	@Path("/payfort/directfeedback")
	public Response payfortFeedback(@Context HttpServletRequest request) 
	{
		_log.info("###### Payfort Feedback called ######");
		_log.info("###### Payfort Feedback dumping request parameters:START ######");
		
		Enumeration<String> params = request.getParameterNames(); 
		while(params.hasMoreElements())
		{
		 String paramName = params.nextElement();
		 _log.info("###### Request Param Name: " + paramName + ", Value: " + request.getParameter(paramName));
		}
		
		_log.info("###### Payfort Feedback dumping request parameters:END ######");

		
		return Response.ok().build();
	}
	
	
	@POST
	@Consumes("application/json")
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/VehicleImagesUpload")
	public String vehicleImagesUpload(VehicleImagesUploadRequest imagesUploadReq) 
	{
		long referenceNumber = imagesUploadReq.getPolicyReferenceNo();
		String quoteReferenceNumberStr = "Q" + referenceNumber;
		
		String responseString = null;
		
		try
		{
			Quotation quotation = QuotationLocalServiceUtil.getQuotationByReferenceNo(quoteReferenceNumberStr);
			
			if(quotation!=null)
			{
				long quotationId = quotation.getQuotationId();
				List<VehicleImage> requestImages = imagesUploadReq.getVehicleImagesList();
				
				//Map to BSL Domain Object
				List<QuotationVehicleImage> bslImagesList = new ArrayList<QuotationVehicleImage>();
				
				for(VehicleImage reqImg:requestImages)
				{
					QuotationVehicleImage bslImg = new QuotationVehicleImage();
					bslImg.setImageID(reqImg.getImageID());
					bslImg.setImageTitle(reqImg.getImageTitle());
					bslImg.setImageDateTime(reqImg.getImageDateTime());
					bslImg.setImageMedia(reqImg.getImageMedia());
					bslImg.setImageLat(reqImg.getImageLat());
					bslImg.setImageLong(reqImg.getImageLong());
					
					bslImagesList.add(bslImg);
				}
				
				QuotationLocalServiceUtil.vehicleImagesUpload(quotationId,bslImagesList);
				
				responseString = "{'Status':true,'errors':null}";
			}
			else
			{
				_log.info("No quotation found with reference number:" + quoteReferenceNumberStr);
				responseString = "{Status:false,errors:[{'field':'quoteReferenceNo','message':'Quotation with provided reference number not found'}]}";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
			responseString = "{'Status':false,'errors':[{'field':'','message':'Generic Error Message'}]}";
		}
		
		ResponseEntity<String> response = new ResponseEntity<String>(responseString, HttpStatus.OK);

		return response.getBody();
	}
	
	private Quotation mapTpQuoteRequestToDomainObject(TpQuotesRequest req)
	{
		Quotation quote = new Quotation();
		
		try 
		{
			//perform mapping of fields from request to BSL Domain object
			quote.setProductCode(PRODUCT_CODE_THIRD_PARTY);
			//quote.setReferenceNo(req.getRequestReferenceNo());
			quote.setInsuredIdType(Long.valueOf(fetchFromCodeMasterMap(ODS_SRC_TYPE_INS_ID_TYP, ""+req.getDetails().getPolicyHolderIdentityTypeCode())));
			quote.setInsuredId(req.getDetails().getPolicyHolderID());
			
			quote.setPurposeOfVehicle(fetchFromCodeMasterMap(ODS_SRC_TYPE_MOT_VEHI_USE,""+req.getDetails().getPurposeOfVehicleUseID()));
			
			quote.setSource(fetchFromCodeMasterMap(ODS_SRC_TYPE_SOURCE, ""+req.getDetails().getQuoteRequestSourceID()));
			quote.setInsuredOccupationCode(req.getDetails().getOccupation());
			quote.setVehicleCylinder(req.getDetails().getCylinders());
			quote.setVehicleCapacity(req.getDetails().getVehicleCapacity());
			quote.setInsuredNationality(fetchFromCodeMasterMap(ODS_SRC_TYPE_NATIONALITY, ""+req.getDetails().getPolicyHolderNationalityID()));
			quote.setInsuredGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPolicyHolderGender()));
			
			if(req.getDetails().getDateOfBirthG()!=null)
				quote.setInsuredDob(dateFormatter.parse(req.getDetails().getDateOfBirthG()));
			if(req.getDetails().getDateOfBirthH()!=null)
				quote.setInsuredDobH(req.getDetails().getDateOfBirthH());
		
			quote.setVehicleIdType(Long.valueOf(fetchFromCodeMasterMap(ODS_SRC_TYPE_VEH_ID_TYP, ""+req.getDetails().getVehicleUniqueTypeID())));
			
			if(req.getDetails().getVehicleUniqueTypeID() == 1)
			{
				quote.setVehicleId(req.getDetails().getVehicleSequenceNumber());
				
				quote.setVehiclePlateType(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_TYPE, "" + req.getDetails().getVehiclePlateTypeID()));
				quote.setVehiclePlateNo(req.getDetails().getVehiclePlateNumber());
				
				quote.setVehiclePlateL1(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getFirstPlateLetterID()));
				quote.setVehiclePlateL2(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getSecondPlateLetterID()));
				quote.setVehiclePlateL3(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getThirdPlateLetterID()));
				
				quote.setVehicleModel(String.valueOf(req.getDetails().getVehicleModelCodeNIC()));
				quote.setVehicleEstExpiryDate(dateFormatter.parse(req.getDetails().getVehicleRegistrationExpiryDate()));
			}
			else if(req.getDetails().getVehicleUniqueTypeID() == 2)
			{
				quote.setVehicleId(req.getDetails().getVehicleCustomID());
			}
			
			quote.setVehicleCity(fetchFromCodeMasterMap(ODS_SRC_TYPE_CITY, ""+req.getDetails().getVehicleDriveCityID()));
			quote.setVehicleMake(String.valueOf(req.getDetails().getVehicleMakeCodeNIC()));
			quote.setVehicleMfgYear(req.getDetails().getManufactureYear());
			quote.setVehicleColor(fetchFromCodeMasterMap(ODS_SRC_TYPE_COLOR, ""+req.getDetails().getVehicleColorCode()));
			quote.setVehicleChassisNo(String.valueOf(req.getDetails().getVehicleVIN()));
			
			_log.info("Got Effective date:" + req.getDetails().getPolicyEffectiveDate());
			Date policyEffectiveDate = new Date();
			policyEffectiveDate.setTime(req.getDetails().getPolicyEffectiveDate());
			
			_log.info("New Effective Date:" + policyEffectiveDate);
			
			quote.setPolicyEffDate(policyEffectiveDate);
			
			quote.setInsuredMobile(req.getDetails().getMobileNo());
			quote.setAddressBuildingNo(req.getDetails().getBuildingNumber());
			quote.setAddressStreet(req.getDetails().getStreet());
			quote.setAddressDistrict(req.getDetails().getDistrict());
			quote.setAddressZipCode(req.getDetails().getZipCode());
			quote.setAddressAddNo(req.getDetails().getAdditionalNumber());
			quote.setVehicleWeight(req.getDetails().getVehicleWeight());
			quote.setVehicleBodyType(fetchFromCodeMasterMap(CustomerVehicleDetailsLocalServiceImpl.ODS_SRC_TYPE_BODY_TYPE, ""+req.getDetails().getVehicleBodyCode()));
			quote.setMainDriver(req.getDetails().isPrimaryDriver());
			quote.setDriverAccidents(req.getDetails().getNajmNoOfAccidents());
			
			if(!req.getDetails().isPrimaryDriver())
			{
				_log.info("We have other primary driver");
				QuotationDriver driver  = new QuotationDriver();
				driver.setDriverId(req.getDetails().getPrimaryDriverID());
				driver.setDriverName(req.getDetails().getPrimaryDriverName());
				
				String driverIdStr = String.valueOf(req.getDetails().getPrimaryDriverID());
				
				if(driverIdStr.startsWith("2"))
				{
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPrimaryDriverGender()));
					driver.setDriverDob(dateFormatter.parse(req.getDetails().getPrimaryDriverDateOfBirthG()));
				}
				else if(driverIdStr.startsWith("1"))
				{
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPrimaryDriverGender()));
					driver.setDriverDobH(req.getDetails().getPrimaryDriverDateOfBirthH());
				}
				
				quote.getQuotationDrivers().add(driver);
			}
			
			//Setting under 21 drivers
			if(req.getDetails().getCoverAgeLimitID()>=6 && req.getDetails().getDriverDetails()!=null)
			{	
				_log.info("We have underage drivers");
				List<DriverDetails> driversList = req.getDetails().getDriverDetails();
				ArrayList<QuotationDriver> underAgeDriversList = new ArrayList<QuotationDriver>();
				
				
				for(DriverDetails dd:driversList)
				{
					QuotationDriver driver = new QuotationDriver();
					driver.setDriverId(dd.getDriverID());
					driver.setDriverName(dd.getDriverName());
					driver.setDriverDob(dateFormatter.parse(dd.getDriverDateOfBirthG()));
					driver.setDriverDobH(dd.getDriverDateOfBirthH());
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+dd.getDriverGender()));
					driver.setDriverUnder21(true);
					underAgeDriversList.add(driver);
					
				}
				
				quote.setUnder21Drivers(underAgeDriversList);
			}
			
			if(req.getDetails().getnCDFreeYears()!=null && !req.getDetails().getnCDFreeYears().equals(""))
				quote.setNcdYears(Long.parseLong(req.getDetails().getnCDFreeYears()));
			
			if(req.getDetails().isRenewal())
			{
				quote.setLoyaltyDiscountFlag(1);
				quote.setLoyaltyDiscount("YES");
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return quote;
	}
	
	private Quotation mapOdQuoteRequestToDomainObject(OdQuotesRequest req)
	{
		Quotation quote = new Quotation();
		
		try
		{
			//perform mapping of fields from request to BSL Domain object
			quote.setProductCode(PRODUCT_CODE_COMPREHENSIVE);
			//quote.setReferenceNo(req.getRequestReferenceNo());
			quote.setInsuredIdType(Long.valueOf(fetchFromCodeMasterMap(ODS_SRC_TYPE_INS_ID_TYP, ""+req.getDetails().getPolicyHolderIdentityTypeCode())));
			quote.setInsuredId(req.getDetails().getPolicyHolderID());
			quote.setPurposeOfVehicle(fetchFromCodeMasterMap(ODS_SRC_TYPE_MOT_VEHI_USE,""+req.getDetails().getPurposeOfVehicleUseID()));
			quote.setSource(fetchFromCodeMasterMap(ODS_SRC_TYPE_SOURCE, ""+req.getDetails().getQuoteRequestSourceID()));
			quote.setInsuredName(req.getDetails().getFullName());
			quote.setInsuredOccupationCode(req.getDetails().getOccupation());
			quote.setVehicleCylinder(req.getDetails().getCylinders());
			quote.setInsuredNationality(fetchFromCodeMasterMap(ODS_SRC_TYPE_NATIONALITY, ""+req.getDetails().getPolicyHolderNationalityID()));
			quote.setInsuredGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPolicyHolderGender()));
			
			if(req.getDetails().getDateOfBirthG()!=null)
				quote.setInsuredDob(dateFormatter.parse(req.getDetails().getDateOfBirthG()));
			if(req.getDetails().getDateOfBirthH()!=null)
				quote.setInsuredDobH(req.getDetails().getDateOfBirthH());
		
			quote.setVehicleIdType(Long.valueOf(fetchFromCodeMasterMap(ODS_SRC_TYPE_VEH_ID_TYP, ""+req.getDetails().getVehicleUniqueTypeID())));
		
			if(req.getDetails().getVehicleUniqueTypeID() == 1)
			{
				quote.setVehicleId(req.getDetails().getVehicleSequenceNumber());
				quote.setVehiclePlateType(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_TYPE, "" + req.getDetails().getVehiclePlateTypeID()));
				quote.setVehiclePlateNo(req.getDetails().getVehiclePlateNumber());
				quote.setVehiclePlateL1(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getFirstPlateLetterID()));
				quote.setVehiclePlateL2(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getSecondPlateLetterID()));
				quote.setVehiclePlateL3(fetchFromCodeMasterMap(ODS_SRC_TYPE_PLATE_LETTER, "" + req.getDetails().getThirdPlateLetterID()));
				quote.setVehicleModel(String.valueOf(req.getDetails().getVehicleModelCodeNIC()));
				quote.setVehicleEstExpiryDate(dateFormatter.parse(req.getDetails().getVehicleRegistrationExpiryDate()));
			}
			else if(req.getDetails().getVehicleUniqueTypeID() == 2)
			{
				quote.setVehicleId(req.getDetails().getVehicleCustomID());
			}
		
			quote.setVehicleCity(fetchFromCodeMasterMap(CustomerVehicleDetailsLocalServiceImpl.ODS_SRC_TYPE_CITY, ""+req.getDetails().getVehicleDriveCityID()));
			quote.setVehicleMake(String.valueOf(req.getDetails().getVehicleMakeCodeNIC()));
			quote.setVehicleModel(String.valueOf(req.getDetails().getVehicleModelCodeNIC()));
			quote.setVehicleMfgYear(req.getDetails().getManufactureYear());
			quote.setVehicleColor(fetchFromCodeMasterMap(ODS_SRC_TYPE_COLOR, ""+req.getDetails().getVehicleColorCode()));
			quote.setVehicleChassisNo(String.valueOf(req.getDetails().getVehicleVIN()));
			quote.setVehicleBodyType(fetchFromCodeMasterMap(CustomerVehicleDetailsLocalServiceImpl.ODS_SRC_TYPE_BODY_TYPE, ""+req.getDetails().getVehicleBodyCode()));
			quote.setInsuredMobile(req.getDetails().getMobileNo());
			quote.setAddressBuildingNo(req.getDetails().getBuildingNumber());
			quote.setAddressStreet(req.getDetails().getStreet());
			quote.setAddressDistrict(req.getDetails().getDistrict());
			quote.setAddressZipCode(req.getDetails().getZipCode());
			quote.setAddressAddNo(req.getDetails().getAdditionalNumber());
			quote.setVehicleWeight(req.getDetails().getVehicleWeight());
			
			_log.info("Got date:" + req.getDetails().getPolicyEffectiveDate());
			
			quote.setPolicyEffDate(dateFormatter2.parse(req.getDetails().getPolicyEffectiveDate()));
			quote.setDriverAccidents(req.getDetails().getNajmNoOfAccidents());
			
			quote.setMainDriver(req.getDetails().isPrimaryDriver());
			quote.setDriverAccidents(req.getDetails().getNajmNoOfAccidents());
			
			if(!req.getDetails().isPrimaryDriver())
			{
				QuotationDriver driver  = new QuotationDriver();
				driver.setDriverId(req.getDetails().getPrimaryDriverID());
				driver.setDriverName(req.getDetails().getPrimaryDriverName());
				
				String driverIdStr = String.valueOf(req.getDetails().getPrimaryDriverID());
				
				if(driverIdStr.startsWith("2"))
				{
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPrimaryDriverGender()));
					driver.setDriverDob(dateFormatter.parse(req.getDetails().getPrimaryDriverDateOfBirthG()));
				}
				else if(driverIdStr.startsWith("1"))
				{
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+req.getDetails().getPrimaryDriverGender()));
					driver.setDriverDobH(req.getDetails().getPrimaryDriverDateOfBirthH());
				}
				
				quote.getQuotationDrivers().add(driver);
			}
			
			//Setting under 21 drivers
			if(req.getDetails().getCoverAgeLimitID()>=6 && req.getDetails().getDriverDetails()!=null)
			{	
				List<DriverDetails> driversList = req.getDetails().getDriverDetails();
				ArrayList<QuotationDriver> underAgeDriversList = new ArrayList<QuotationDriver>();
				
				
				for(DriverDetails dd:driversList)
				{
					QuotationDriver driver = new QuotationDriver();
					driver.setDriverId(dd.getDriverID());
					driver.setDriverName(dd.getDriverName());
					driver.setDriverDob(dateFormatter.parse(dd.getDriverDateOfBirthG()));
					driver.setDriverDobH(dd.getDriverDateOfBirthH());
					driver.setDriverGender(fetchFromCodeMasterMap(ODS_SRC_TYPE_GENDER, ""+dd.getDriverGender()));
					driver.setDriverUnder21(true);
					underAgeDriversList.add(driver);
					
				}
				
				quote.setUnder21Drivers(underAgeDriversList);
			}
			
			if(req.getDetails().getnCDFreeYears()!=null && !req.getDetails().getnCDFreeYears().equals(""))
				quote.setNcdYears(Long.parseLong(req.getDetails().getnCDFreeYears()));
		
			quote.setVehicleValue(req.getDetails().getVehicleSumInsured());    // Comp only
			quote.setAgencyRepair(String.valueOf(req.getDetails().getRepairMethod()));   // Comp only
			
			if(req.getDetails().isRenewal())
			{
				quote.setLoyaltyDiscountFlag(1);
				quote.setLoyaltyDiscount("YES");
			}
		}
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return quote;
	}
	
	private void logRequestResponse(String str, String mode, String serviceName)
	{
		_log.info(">>> " + mode + " for service: " + serviceName + ">>>");
		_log.info(str);
	}
	
	private String generationBasicAuthString(String userName, String password)
	{
		_log.info("Generating basic auth string from username:" + userName + ", password:" + password);
		String encodedString = null;
		
		try 
		{
			encodedString = Base64.getEncoder().encodeToString((userName + ":" + password).getBytes("UTF-8"));
			_log.info("Encoded String:" + encodedString);
		} 
		catch (UnsupportedEncodingException e) 
		{
			_log.info("Failed to get ");
			e.printStackTrace();
			encodedString = "";
		}
		
		return encodedString;
	}
	
	private String getVehicleNationality(int makeCodeNIC)
	{
		String vehicleMakeNationality = null;
		
		CodeMasterMap vehMakeMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_VEH_MAKE, ""+makeCodeNIC);
		String transformedMake = (vehMakeMap!=null)?vehMakeMap.getCoreCode():null;
		
		if(transformedMake!=null)
		{
			CodeMasterMap vehMakeNatMap = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(ODS_SRC_TYPE_MAKE_NAT, transformedMake);
			vehicleMakeNationality = (vehMakeNatMap!=null)?vehMakeNatMap.getCoreCode():null;
		}
		
		if(vehicleMakeNationality == null)
			vehicleMakeNationality = DEFAULT_VEHICLE_NATIONALITY;
			
		return vehicleMakeNationality;
	}
	
	private String fetchFromCodeMasterMap(String mdmSourceType, String mdmSource)
	{
		String transformedValue = null;
		_log.info("Fetching from code master map for mdmSourceType:" + mdmSourceType + " and mdmSource:" + mdmSource);
		
		try
		{
			CodeMasterMap map = CodeMasterMapLocalServiceUtil.findBySourceTypeSourceCode(mdmSourceType,mdmSource);
			transformedValue = map.getCoreCode();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		if(transformedValue == null)
		{
			transformedValue = mdmSource;
			_log.info("Failed to get value from Code Master Map. Return original:"  + transformedValue);
		}
		return transformedValue;
	}
	
	private void updateQuotation(Quotation quot) throws NoSuchQuotationsException
	{
		_log.info("Updating quotation with id:" + quot.getQuotationId());
		try 
		{
			Quotations quotation = QuotationsLocalServiceUtil.findByQuotationId(quot.getQuotationId()).get(0);
			
			quotation.setInsuredEmail(quot.getInsuredEmail());
			quotation.setInsuredMobile(Long.valueOf(quot.getInsuredMobile()));
			quotation.setAddressBuildingNo(quot.getAddressBuildingNo());
			quotation.setAddressStreet(quot.getAddressStreet());
			quotation.setAddressDistrict(quot.getAddressDistrict());
			quotation.setCity(quot.getCity());
			quotation.setAddressZipCode(quot.getAddressZipCode());
			quotation.setAddressAddNo(quot.getAddressAddNo());
			quotation.setPaymentRefNo(quot.getPaymentRefNo());
			quotation.setPaymemtAmount(quot.getPaymemtAmount());
			quotation.setInsuredIBAN(quot.getVehicleOwnerIban());
			
			QuotationsLocalServiceUtil.updateQuotations(quotation);
		} 
		catch (Exception e) 
		{
			_log.info("Error fetching quotation with id:" + quot.getQuotationId());
			e.printStackTrace();
			throw new NoSuchQuotationsException();
		}
	}
}