package com.ejada.atmc.acl.ws.marshal.yakeen;

import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAddressInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByBorderNumberRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienLegalStatusInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CarInfoByCustomRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenAddressInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenInfoRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyAddressInfoByCrRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceRequest;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaRequest;

public class InfoMarshaller {

	public static AlienInfoByIqamaRequest marshalAlienInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {
		AlienInfoByIqamaRequest req = new AlienInfoByIqamaRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setIqamaNumber(iqamaNumber);
		req.setSponsorId(sponsorId);

		return req;
	}

	public static AlienInfoByIqamaAndDOBRequest marshalAlienInfoByIqamaAndDOB(ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth) {
		AlienInfoByIqamaAndDOBRequest req = new AlienInfoByIqamaAndDOBRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setIqamaNumber(iqamaNumber);
		req.setDateOfBirth(dateOfBirth);

		return req;
	}

	public static AlienAddressInfoRequest marshalAlienAddressInfo(ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth, String addressLanguage) {
		AlienAddressInfoRequest req = new AlienAddressInfoRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setIqamaNumber(iqamaNumber);
		req.setDateOfBirth(dateOfBirth);
		req.setAddressLanguage(addressLanguage);
		return req;
	}

	public static CitizenAddressInfoRequest marshalCitizenAddressInfo(ServiceRequest svcRequest, String nin, String dateOfBirth, String addressLanguage) {
		CitizenAddressInfoRequest req = new CitizenAddressInfoRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setNin(nin);
		req.setDateOfBirth(dateOfBirth);
		req.setAddressLanguage(addressLanguage);
		return req;
	}

	public static CompanyAddressInfoByCrRequest marshalCompanyAddressInfoByCr(ServiceRequest svcRequest, long crNumber, String addressLanguage) {
		CompanyAddressInfoByCrRequest req = new CompanyAddressInfoByCrRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setCrNumber(crNumber);
		req.setAddressLanguage(addressLanguage);

		return req;
	}

	public static AlienInfoByBorderNumberRequest marshalAlienInfoByBorderNo(ServiceRequest svcRequest, String borderNumber, String sponsorId) {
		AlienInfoByBorderNumberRequest req = new AlienInfoByBorderNumberRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setBorderNumber(borderNumber);
		req.setSponsorId(sponsorId);

		return req;
	}

	public static CitizenInfoRequest marshalCitizenInfo(ServiceRequest svcRequest, String dateOfBirthH, String nin) {
		CitizenInfoRequest req = new CitizenInfoRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setDateOfBirthH(dateOfBirthH);
		req.setNin(nin);

		return req;
	}

	public static AlienAllDepInfoByIqamaRequest marshalAlienAllDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {
		AlienAllDepInfoByIqamaRequest req = new AlienAllDepInfoByIqamaRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setDepIqama(depIqama);
		req.setIqamaNumber(iqamaNumber);

		return req;
	}

	public static AlienSingleDepInfoByIqamaRequest marshalAlienSingleDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {
		AlienSingleDepInfoByIqamaRequest req = new AlienSingleDepInfoByIqamaRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setDepIqama(depIqama);
		req.setIqamaNumber(iqamaNumber);

		return req;
	}

	public static CarInfoByCustomRequest marshalCarInfoByCustom(ServiceRequest svcRequest, String customCardNumber, short modelYear) {
		CarInfoByCustomRequest req = new CarInfoByCustomRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setCustomCardNumber(customCardNumber);
		req.setModelYear(modelYear);

		return req;
	}

	public static AlienCarInfoBySequenceRequest marshalAlienCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber) {
		AlienCarInfoBySequenceRequest req = new AlienCarInfoBySequenceRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setSequenceNumber(sequenceNumber);
		req.setOwnerIqamaNumber(ownerIqamaNumber);

		return req;
	}

	public static CompanyCarInfoBySequenceRequest marshalCompanyCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long companyMOINumber) {
		CompanyCarInfoBySequenceRequest req = new CompanyCarInfoBySequenceRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setSequenceNumber(sequenceNumber);
		req.setCompanyMOINumber(companyMOINumber);

		return req;
	}

	public static CitizenCarInfoBySequenceRequest marshalCitizenCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerNin) {
		CitizenCarInfoBySequenceRequest req = new CitizenCarInfoBySequenceRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setSequenceNumber(sequenceNumber);
		req.setOwnerNin(ownerNin);

		return req;
	}

	public static CompanyInfoBySponseredIqamaRequest marshalCompanyInfoBySponseredIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorNumber, String depIqama) {
		CompanyInfoBySponseredIqamaRequest req = new CompanyInfoBySponseredIqamaRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setIqamaNumber(iqamaNumber);
		req.setSponsorNumber(sponsorNumber);
		req.setDepIqama(depIqama);

		return req;
	}

	public static AlienLegalStatusInfoRequest marshalAlienLegalStatusInfo(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {
		AlienLegalStatusInfoRequest req = new AlienLegalStatusInfoRequest();

		req.setUserName(svcRequest.getUsername());
		req.setPassword(svcRequest.getPassword());
		req.setChargeCode(svcRequest.getChargeCode());
		req.setReferenceNumber(svcRequest.getReferenceNumber());
		req.setIqamaNumber(iqamaNumber);
		req.setSponsorId(sponsorId);
		return req;
	}

}
