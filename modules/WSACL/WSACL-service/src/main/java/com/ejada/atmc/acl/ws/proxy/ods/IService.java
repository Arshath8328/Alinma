
package com.ejada.atmc.acl.ws.proxy.ods;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

@WebService(
		name = "IService",
		targetNamespace = "http://tempuri.org/"
)
@XmlSeeAlso(
	{ ObjectFactory.class }
)
public interface IService {

	/**
	 * 
	 * @param  xmlRequest
	 * @return            returns com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult
	 */
	@WebMethod(
			operationName = "PolicyIssuance",
			action = "http://tempuri.org/IService/PolicyIssuance"
	)
	@WebResult(
			name = "PolicyIssuanceResult",
			targetNamespace = "http://tempuri.org/"
	)
	@RequestWrapper(
			localName = "PolicyIssuance",
			targetNamespace = "http://tempuri.org/",
			className = "com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuance"
	)
	@ResponseWrapper(
			localName = "PolicyIssuanceResponse",
			targetNamespace = "http://tempuri.org/",
			className = "com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuanceResponse"
	)
	public com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult policyIssuance(@WebParam(
			name = "xmlRequest",
			targetNamespace = "http://tempuri.org/"
	)
	com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuance.XmlRequest xmlRequest);

	/**
	 * 
	 * @param  xmlRequest
	 * @return            returns com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult
	 */
	@WebMethod(
			operationName = "Claim_Intimation",
			action = "http://tempuri.org/IService/Claim_Intimation"
	)
	@WebResult(
			name = "Claim_IntimationResult",
			targetNamespace = "http://tempuri.org/"
	)
	@RequestWrapper(
			localName = "Claim_Intimation",
			targetNamespace = "http://tempuri.org/",
			className = "com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimation"
	)
	@ResponseWrapper(
			localName = "Claim_IntimationResponse",
			targetNamespace = "http://tempuri.org/",
			className = "com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse"
	)
	public com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult claimIntimation(@WebParam(
			name = "xmlRequest",
			targetNamespace = "http://tempuri.org/"
	)
	com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimation.XmlRequest xmlRequest);

}
