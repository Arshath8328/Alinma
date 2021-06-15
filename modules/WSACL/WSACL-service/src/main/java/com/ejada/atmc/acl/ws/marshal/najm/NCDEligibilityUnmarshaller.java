package com.ejada.atmc.acl.ws.marshal.najm;

import com.ejada.atmc.acl.ws.domain.NCDEligibility;
import com.ejada.atmc.acl.ws.utils.SOAPUtils;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class NCDEligibilityUnmarshaller {

	public static final String	STATUS_CODE			= "StatusCode";
	public static final String	NCD_REFERENCE		= "NCDReference";
	public static final String	NCD_FREE_YEARS		= "NCDFreeYears";
	public static final String	ERROR_CODE			= "ErrorCode";
	public static final String	ERROR_MSG			= "ErrorMsg";

	public static final String	STATUS_CODE_SUCCESS	= "1";
	public static final String	STATUS_CODE_FAIL	= "2";

	public static final String	ERROR_CODE_GEN		= "9999";
	public static final String	ERROR_MSG_GEN		= "Generic Error";

	public static NCDEligibility unmarshal(String response) throws Exception {

		NCDEligibility ncdEligibility = new NCDEligibility();

		Document doc = SOAPUtils.toDocument(response);
		Element root = doc.getDocumentElement();

		String statusCode = SOAPUtils.getDirectChildElement(root, STATUS_CODE).getTextContent();
		String ncdReference = SOAPUtils.getDirectChildElement(root, NCD_REFERENCE).getTextContent();
		String ncdFreeYears = SOAPUtils.getDirectChildElement(root, NCD_FREE_YEARS).getTextContent();
		String errorCode = SOAPUtils.getDirectChildElement(root, ERROR_CODE).getTextContent();
		String errorMsg = SOAPUtils.getDirectChildElement(root, ERROR_MSG).getTextContent();

		ncdEligibility.setStatusCode(statusCode);
		ncdEligibility.setNCDReference(ncdReference);
		ncdEligibility.setNCDFreeYears(ncdFreeYears);
		ncdEligibility.setErrorCode(errorCode);
		ncdEligibility.setErrorMsg(errorMsg);

		return ncdEligibility;
	}

}
