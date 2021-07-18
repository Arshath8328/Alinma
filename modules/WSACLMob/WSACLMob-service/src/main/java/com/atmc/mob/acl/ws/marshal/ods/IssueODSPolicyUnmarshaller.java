package com.atmc.mob.acl.ws.marshal.ods;

import com.atmc.mob.acl.ws.domain.ods.ODSPIResponse;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult;
import com.atmc.mob.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult.PIRESPONSE;

public class IssueODSPolicyUnmarshaller extends ODSMarshaller
{

	public static ODSPIResponse unmarshal(PolicyIssuanceResult result)
	{
		ODSPIResponse res = new ODSPIResponse();
		PIRESPONSE piResponse = result.getPIRESPONSE();

		if(piResponse.getADDITIONALDETAILSIFANY() != null)
			res.setAdditionaldetailsifany(piResponse.getADDITIONALDETAILSIFANY());
		
		if(piResponse.getMESSAGE() != null)
			res.setMessage(piResponse.getMESSAGE());
		
		if(piResponse.getMAXLIABILITY() != -1)
			res.setMaxliability(piResponse.getMAXLIABILITY());
		
		if(piResponse.getPOLICYAMOUNTORPREMIUM() != null)
			res.setPolicyamountorpremium(piResponse.getPOLICYAMOUNTORPREMIUM().doubleValue());
		if(piResponse.getPOLICYEFFECTIVEFROM()!=null)
			res.setPolicyeffectivefrom(piResponse.getPOLICYEFFECTIVEFROM());
		if(piResponse.getPOLICYEFFECTIVETO() != null)
			res.setPolicyeffectiveto(piResponse.getPOLICYEFFECTIVETO());
		if(piResponse.getPOLICYFEATURES() != null)
			res.setPolicyfeatures(piResponse.getPOLICYFEATURES());
		if(piResponse.getPOLICYISSUEDATE() !=null)
			res.setPolicyissuedate(piResponse.getPOLICYISSUEDATE());
		if(piResponse.getPOLICYNO() != null)
			res.setPolicyno(piResponse.getPOLICYNO());
		if(piResponse.getREFERENCENO() != null)
			res.setReferenceno(piResponse.getREFERENCENO());
		if(piResponse.getSTATUSCODE() != null)
			res.setStatuscode(piResponse.getSTATUSCODE());

		return res;
	}
}
