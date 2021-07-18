package com.atmc.mob.acl.ws.marshal.ods;

import com.atmc.mob.acl.ws.domain.ods.ODSAddDriver;
import com.atmc.mob.acl.ws.domain.ods.ODSCover;
import com.atmc.mob.acl.ws.domain.ods.ODSInsured;
import com.atmc.mob.acl.ws.domain.ods.ODSPolicy;
import com.atmc.mob.acl.ws.domain.ods.ODSVehicleInfo;
import com.atmc.mob.acl.ws.proxy.ods.ObjectFactory;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.INSURED;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.POLICY;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO.ADDDRIVER;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuance.XmlRequest.POLICYISSUANCE.VEHICLE.VEHICLEINFO.COVER;

import java.math.BigDecimal;
import java.util.List;

public class IssueODSPolicyMarshaller extends ODSMarshaller
{
	public static XmlRequest marshal(ODSInsured odsInsured, ODSPolicy odsPolicy, List<ODSVehicleInfo> odsVehicleInfoList)
	{

		ObjectFactory obj = new ObjectFactory();
		XmlRequest req = obj.createPolicyIssuanceXmlRequest();
		
		POLICYISSUANCE pI = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCE();
		
		INSURED insured = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEINSURED();
		POLICY policy = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEPOLICY();
		VEHICLE vehicle = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLE();

		policy.setTRANSACTION(odsPolicy.getTransaction());
		policy.setSOURCE(odsPolicy.getSource());
		policy.setREFERENCENO(odsPolicy.getReferenceno());
		policy.setPRODUCTCODE(odsPolicy.getProductcode());
		policy.setPOLICYEFFDATE(odsPolicy.getPolicyeffdate());
		policy.setPAYMENTREFNO(odsPolicy.getPaymentrefno());
		policy.setPAYMENTMETHOD(odsPolicy.getPaymentmethod());
		policy.setPAYMENTAMOUNT(BigDecimal.valueOf(odsPolicy.getPaymentamount()));
		
		insured.setADDRESSADDNUMBER(odsInsured.getAddressaddnumber());
		insured.setADDRESSBLDGNO(odsInsured.getAddressbldgno());
		insured.setADDRESSCITY((odsInsured.getAddresscity() == null) ? "88888"  :  odsInsured.getAddresscity());
		insured.setADDRESSDISTRICT(odsInsured.getAddressdistrict());
		insured.setADDRESSSTREET(odsInsured.getAddressstreet());
		insured.setADDRESSUNITNO(odsInsured.getAddressunitno());
		insured.setADDRESSZIPCODE(odsInsured.getAddresszipcode());
		insured.setINSUREDDOB((odsInsured.getInsureddob() == null) ? "" : odsInsured.getInsureddob());
		insured.setINSUREDEMAIL((odsInsured.getInsuredemail() == null) ? "" : odsInsured.getInsuredemail());
		insured.setINSUREDFIRSTNAME(odsInsured.getInsuredfirstname());
		insured.setINSUREDGENDER(odsInsured.getInsuredgender());
		insured.setINSUREDIBAN((odsInsured.getInsurediban() == null) ? "" : odsInsured.getInsurediban());
		insured.setINSUREDID(odsInsured.getInsuredid());
		insured.setINSUREDIDTYPE(odsInsured.getInsuredidtype());
		insured.setINSUREDLASTNAME(odsInsured.getInsuredlastname());
		insured.setINSUREDMIDDLENAME(odsInsured.getInsuredmiddlename());
		insured.setINSUREDMOBILE((odsInsured.getInsuredmobile() == null) ? "" : odsInsured.getInsuredmobile());
		// Send Empty Tag if no data passed in field - As per Khatib's request 
		insured.setINSUREDNATIONALITY((odsInsured.getInsurednationality() == null) ? "" : odsInsured.getInsurednationality());
		// Send Empty Tag if no data passed in field - As per Khatib's request
		insured.setINSUREDOCCUP((odsInsured.getInsuredOccupation() == null) ? "" : odsInsured.getInsuredOccupation());
		
		for(ODSVehicleInfo odsVInfo:odsVehicleInfoList)
		{
			VEHICLEINFO vInfo = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFO();
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOCITY((odsVInfo.getCity()!=null)?odsVInfo.getCity():""));
			vInfo.getContent().add((odsVInfo.getPostCity()== null) ? "" : odsVInfo.getPostCity());
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEIDTYPE(odsVInfo.getVehicleIdType()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEID(odsVInfo.getVehicleId()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEPLATETYPE((odsVInfo.getVehiclePlateType()!=null)?odsVInfo.getVehiclePlateType():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEPLATENO(odsVInfo.getVehiclePlateNo()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEPLATEL1((odsVInfo.getVehiclePlateL1()!=null)?odsVInfo.getVehiclePlateL1():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEPLATEL2((odsVInfo.getVehiclePlateL2()!=null)?odsVInfo.getVehiclePlateL2():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEPLATEL3((odsVInfo.getVehiclePlateL3()!=null)?odsVInfo.getVehiclePlateL3():""));
			
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOPURPOSEOFVEHICLE((odsVInfo.getPurposeOfVehicle()!=null)?odsVInfo.getPurposeOfVehicle():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEMAKE((odsVInfo.getVehicleMake()!=null)?odsVInfo.getVehicleMake():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEMODEL((odsVInfo.getVehicleModel()!=null)?odsVInfo.getVehicleModel():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEMFGYEAR(odsVInfo.getVehicleMfgYear()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLECOLOR((odsVInfo.getVehicleColor()!=null)?odsVInfo.getVehicleColor():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEBODYTYPE((odsVInfo.getVehicleBodyType()!=null)?odsVInfo.getVehicleBodyType():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLECHASSISNO((odsVInfo.getVehicleChassisNo()!=null)?odsVInfo.getVehicleChassisNo():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEESTEXPDATE((odsVInfo.getVehicleEstExpDate()!=null)?odsVInfo.getVehicleEstExpDate():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFODEDUCTIBLEVALUE((odsVInfo.getDeductibleValue()!=null)?odsVInfo.getDeductibleValue():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEVALUE(odsVInfo.getVehicleValue()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOAGENCYREPAIR((odsVInfo.getAgencyRepair()!=null)?odsVInfo.getAgencyRepair():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLECAPACITY(odsVInfo.getVehicleCapacity()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLECYLINDER(odsVInfo.getVehicleCylinder()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOVEHICLEWEIGHT(odsVInfo.getVehicleWeight()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFONCDYEARS(odsVInfo.getNcdYears()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOLOYALTYDISCOUNTFLAG((odsVInfo.getLoyaltyDiscount()!=null)?odsVInfo.getLoyaltyDiscount():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFONETPREMIUM(BigDecimal.valueOf(odsVInfo.getNetPremium())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFONCDDISCOUNTAMOUNT(BigDecimal.valueOf(odsVInfo.getNcdDiscountAmount())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOLOYALTYDISCOUNTAMOUNT(BigDecimal.valueOf(odsVInfo.getLoyaltyDiscountAmount())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFONCDDISCOUNTPER(BigDecimal.valueOf(odsVInfo.getNcdDiscountPer())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOLOYALTYDISCOUNTPER(BigDecimal.valueOf(odsVInfo.getLoyaltyDiscountPer())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOLOADINGAMOUNT(BigDecimal.valueOf(odsVInfo.getLoadingAmount())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOPOLICYTAXES(BigDecimal.valueOf(odsVInfo.getPolicyTaxes())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOPOLICYFEES(BigDecimal.valueOf(odsVInfo.getPolicyFees())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOTOTALCOVERPREMIUM(BigDecimal.valueOf(odsVInfo.getTotalCoverPremium())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOGROSSPREMIUM(BigDecimal.valueOf(odsVInfo.getGrossPremium())));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOADDDRIVERCOUNT(odsVInfo.getAddDriverCount()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOADDCOVERCOUNT(odsVInfo.getAddCoverCount()));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOEXISTPOLNO((odsVInfo.getExistingPolicyNo()!=null)?odsVInfo.getExistingPolicyNo():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOEXISTCOMPNAME((odsVInfo.getExistingCompanyName()!=null)?odsVInfo.getExistingCompanyName():""));
			vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOEXISTEXPDATE((odsVInfo.getExisitingExpiryDate()!=null)?odsVInfo.getExisitingExpiryDate():""));
			
			if(odsVInfo.getAddDriverList()!=null && !odsVInfo.getAddDriverList().isEmpty())
			for(ODSAddDriver odsAddDriver:odsVInfo.getAddDriverList())
			{
				ADDDRIVER addDriver = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOADDDRIVER();
				
				addDriver.setDRIVERDOB(odsAddDriver.getDriverdob() == null ? "" : odsAddDriver.getDriverdob());
				addDriver.setDRIVERGENDER(odsAddDriver.getDrivergender() == null ? "" : odsAddDriver.getDrivergender());
				addDriver.setDRIVERID(odsAddDriver.getDriverid());
				addDriver.setDRIVERIDTYPE(odsAddDriver.getDriveridtype());
				addDriver.setDRIVERNAME(odsAddDriver.getDrivername() == null ? "" : odsAddDriver.getDrivername());
				addDriver.setDRIVERNATIONALITY(odsAddDriver.getDrivernationality() == null ? "" : odsAddDriver.getDrivernationality());
				addDriver.setDRIVERNCD(odsAddDriver.getDriverNcd());
				vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOADDDRIVER(addDriver));
			}
			
			if(odsVInfo.getCoverList()!=null && !odsVInfo.getCoverList().isEmpty())
			for(ODSCover odsCover:odsVInfo.getCoverList())
			{
				COVER cover = obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOCOVER();
				cover.setCOVERCODE(odsCover.getCovercode());
				cover.setCOVEREFFFRMDATE(odsCover.getCoverefffrmdate());
				cover.setCOVEREFFTODATE(odsCover.getCoverefftodate());
				cover.setCOVERPREM(BigDecimal.valueOf(odsCover.getCoverprem()));
				cover.setCOVERRATE(BigDecimal.valueOf(odsCover.getCoverrate()));
				cover.setCOVERSI(odsCover.getCoversi());

				vInfo.getContent().add(obj.createPolicyIssuanceXmlRequestPOLICYISSUANCEVEHICLEVEHICLEINFOCOVER(cover));
			}
			
			vehicle.getVEHICLEINFO().add(vInfo);
		}
		
		pI.setINSURED(insured);
		pI.setPOLICY(policy);
		pI.setVEHICLE(vehicle);
		
		req.setPOLICYISSUANCE(pI);
		return req;
	}

}
