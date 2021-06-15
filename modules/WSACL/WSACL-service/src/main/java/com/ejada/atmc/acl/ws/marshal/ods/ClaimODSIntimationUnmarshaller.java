package com.ejada.atmc.acl.ws.marshal.ods;

import com.ejada.atmc.acl.ws.domain.ods.ODSCIResponse;
import com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult;
import com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE;

public class ClaimODSIntimationUnmarshaller {
	/**
	 * @param  result
	 * @return        ODSCIResponse
	 * @see
	 */
	public static ODSCIResponse unmarshal(ClaimIntimationResult result) {
		ODSCIResponse res = new ODSCIResponse();
		CIRESPONSE ciResponse = result.getCIRESPONSE();

		res.setClaimintimationno(ciResponse.getCLAIMINTIMATIONNO());
		res.setMessage(ciResponse.getMESSAGE());
		res.setStatus(ciResponse.getSTATUS());

		return res;
	}
}
