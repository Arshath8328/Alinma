/**
 * 
 */
package com.ejada.atmc.acl.ws.marshal.ods;

import com.ejada.atmc.acl.ws.domain.ods.ODSClaimIntimation;
import com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimation.XmlRequest;
import com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimation.XmlRequest.CLAIMINTIMATION;
import com.ejada.atmc.acl.ws.proxy.ods.ObjectFactory;
import com.liferay.petra.string.StringPool;

import java.math.BigDecimal;

/**
 * @author ghada
 *
 */
public class ClaimODSIntimationMarshaller extends ODSMarshaller {

	public static XmlRequest marshal(ODSClaimIntimation odsClaimInt) {

		ObjectFactory obj = new ObjectFactory();
		XmlRequest req = obj.createClaimIntimationXmlRequest();
		CLAIMINTIMATION claim = obj.createClaimIntimationXmlRequestCLAIMINTIMATION();

		claim.setREFERENCENO(getString(odsClaimInt.getReferenceno()));
		claim.setSOURCE(getString(odsClaimInt.getSource()));
		claim.setTRANSACTION(getString(odsClaimInt.getTransaction()));
		claim.setPOLICYNO(getString(odsClaimInt.getPolicyno()));
		claim.setREPORTMODE(getString(odsClaimInt.getReportmode()));
		claim.setREPORTNO(getString(odsClaimInt.getReportno()));
		claim.setVEHIDENTITYPE(getString(odsClaimInt.getVehidentitype()));
		claim.setVEHIDENTIVALUE(getString(odsClaimInt.getVehidentivalue()));
		claim.setLOSSNATURE(getString(odsClaimInt.getLossnature()));
		claim.setLOSSCAUSE(getString(odsClaimInt.getLosscause()));
		claim.setLOSSDATE(getFormattedDateTime(odsClaimInt.getLossdate()));
		claim.setLOSSREMARKS(getString(odsClaimInt.getLossremarks()));
		claim.setFAULTPERCENT(odsClaimInt.getFaultpercent());
		claim.setLOSSLOCATION(getString(odsClaimInt.getLosslocation()));
		claim.setTPDRIVERNAME(getString(odsClaimInt.getTpdrivername()));
		if (odsClaimInt.getTpdob() != null)
			claim.setTPDOB(Integer.valueOf(odsClaimInt.getTpdob()));
		else
			claim.setTPDOB(0);
		claim.setTPID(getString(odsClaimInt.getTpid()));
		claim.setTPVEHIDENTITYPE(getString(odsClaimInt.getTpvehidentitype()));
		claim.setTPVEHIDENTIVALUE(getString(odsClaimInt.getTpvehidentivalue()));
		claim.setTPPLATENO(getString(odsClaimInt.getTpplateno()));
		claim.setTPINSCO(getString(odsClaimInt.getTpinsco()));
		claim.setTPMOBILE(getString(odsClaimInt.getTpmobile()));
		claim.setTPIBAN(getString(odsClaimInt.getTpiban()));
		claim.setTPNATIONALITY(getString(odsClaimInt.getTpnationality()));
		claim.setAMOUNT(BigDecimal.valueOf(odsClaimInt.getAmount()));
		claim.setDAMAGEFLAG(getString(odsClaimInt.getDamageflag()));

		// BA setting all unmapped fields to empty strings to be generated in the soap request
		claim.setTPPOLNO("");
		claim.setMOBILENO("");

		req.setCLAIMINTIMATION(claim);
		return req;
	}

	private static String getString(String s) {
		if (s == null)
			return StringPool.BLANK;
		else
			return s;
	}

}
