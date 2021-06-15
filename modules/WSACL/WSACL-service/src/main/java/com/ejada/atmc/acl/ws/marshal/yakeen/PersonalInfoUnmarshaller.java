package com.ejada.atmc.acl.ws.marshal.yakeen;

import com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienAllDepInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByBorderNumberResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaAndDOBResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienSingleDepInfoByIqamaResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenInfoResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.DependentsList6;
import com.ejada.atmc.acl.ws.proxy.yakeen.DependentsList7;

import java.util.ArrayList;
import java.util.List;

public class PersonalInfoUnmarshaller {

	public static AlienInfo unmarshalAlienInfoByIqama(AlienInfoByIqamaResult svcResponse) {
		AlienInfo info = new AlienInfo();
		info.setDateOfBirthG(svcResponse.getDateOfBirthG());
		info.setEnglishFirstName(svcResponse.getEnglishFirstName());
		info.setEnglishSecondName(svcResponse.getEnglishSecondName());
		info.setEnglishThirdName(svcResponse.getEnglishThirdName());
		info.setEnglishLastName(svcResponse.getEnglishLastName());
		info.setGender(svcResponse.getGender().value());
		info.setIqamaExpiryDateH(svcResponse.getIqamaExpiryDateH());
		info.setLogId(svcResponse.getLogId());
		info.setNationalityCode(svcResponse.getNationalityCode());
		info.setOccupationCode("" + svcResponse.getOccupationCode());
		info.setSocialStatusCode(svcResponse.getSocialStatusCode());

		return info;

	}

	public static AlienInfo unmarshalAlienInfoByIqamaAndDOB(AlienInfoByIqamaAndDOBResult svcResponse) {
		AlienInfo info = new AlienInfo();
		info.setDateOfBirthG(svcResponse.getDateOfBirthG());
		info.setEnglishFirstName(svcResponse.getEnglishFirstName());
		info.setEnglishSecondName(svcResponse.getEnglishSecondName());
		info.setEnglishThirdName(svcResponse.getEnglishThirdName());
		info.setEnglishLastName(svcResponse.getEnglishLastName());
		info.setGender(svcResponse.getGender().value());
		info.setIqamaExpiryDateH(svcResponse.getIqamaExpiryDateH());
		info.setLogId(svcResponse.getLogId());
		info.setNationalityCode(svcResponse.getNationalityCode());
		info.setOccupationCode("" + svcResponse.getOccupationCode());
		info.setSocialStatusCode(svcResponse.getSocialStatusCode());

		info.setIqamaExpiryDateG(svcResponse.getIqamaExpiryDateG());
		info.setDateOfBirthH(svcResponse.getDateOfBirthH());
		return info;

	}

	public static AlienInfo unmarshalAlienInfoByBorderNumber(AlienInfoByBorderNumberResult svcResponse) {
		AlienInfo info = new AlienInfo();
		info.setDateOfBirthG(svcResponse.getDateOfBirthG());
		info.setEnglishFirstName(svcResponse.getFirstName());
		info.setEnglishSecondName(svcResponse.getSeconedName());
		info.setEnglishThirdName(svcResponse.getGrandFatherName());
		info.setEnglishLastName(svcResponse.getFamilyName());
		info.setGender(svcResponse.getGender().value());
		info.setLogId(svcResponse.getLogId());
		info.setNationalityCode(svcResponse.getNationalityCode());
		info.setOccupationCode("" + svcResponse.getOccupationCode());

		return info;

	}

	public static CitizenInfo unmarshalCitizenInfo(CitizenInfoResult svcResponse) {
		CitizenInfo info = new CitizenInfo();
		info.setDateOfBirthG(svcResponse.getDateOfBirthG());
		info.setEnglishFirstName(svcResponse.getEnglishFirstName());
		info.setEnglishSecondName(svcResponse.getEnglishSecondName());
		info.setEnglishThirdName(svcResponse.getEnglishThirdName());
		info.setEnglishLastName(svcResponse.getEnglishLastName());
		info.setGender(svcResponse.getGender().value());
		info.setLogId(svcResponse.getLogId());
		if (svcResponse.getOccupationCode() != null)
			info.setOccupationCode(svcResponse.getOccupationCode());

		return info;

	}

	public static List<AlienDepInfo> unmarshalAlienAllDepInfoByIqama(AlienAllDepInfoByIqamaResult svcResponse) {
		List<AlienDepInfo> alienList = new ArrayList<>();
		for (DependentsList6 dep : svcResponse.getDependentsListList()) {
			AlienDepInfo info = new AlienDepInfo();
			info.setDateOfBirthG(dep.getDepBirthDateG());
			info.setEnglishFirstName(dep.getDepEnglishFirstName());
			info.setEnglishSecondName(dep.getDepEnglishSecondName());
			info.setEnglishThirdName(dep.getDepEnglishThirdName());
			info.setEnglishLastName(dep.getDepEnglishLastName());
			info.setGender(String.valueOf(dep.getDepGender()));
			info.setIqamaNumber(dep.getDepIqamaNo());
			info.setNationalityCode(dep.getDepNationalityNICCode());
			info.setOccupationCode("" + dep.getDepOccupationCode());
			info.setSocialStatusCode(Short.valueOf(dep.getDepSocialStatusCode()));
			info.setRelationship(dep.getDepRelationship());

			info.setLogId(svcResponse.getLogId());
			alienList.add(info);
		}

		return alienList;

	}

	public static List<AlienDepInfo> unmarshalAlienSingleDepInfoByIqama(AlienSingleDepInfoByIqamaResult svcResponse) {
		List<AlienDepInfo> alienList = new ArrayList<>();
		for (DependentsList7 dep : svcResponse.getDependentsListList()) {
			AlienDepInfo info = new AlienDepInfo();
			info.setDateOfBirthG(dep.getDepDateBirthG());
			info.setEnglishFirstName(dep.getDepEnglishFirstName());
			info.setEnglishSecondName(dep.getDepEnglishSecondName());
			info.setEnglishThirdName(dep.getDepEnglishThirdName());
			info.setEnglishLastName(dep.getDepEnglishLastName());
			info.setGender(String.valueOf(dep.getDepGender()));
			info.setNationalityCode(dep.getDepNationalityNICCode());
			info.setOccupationCode("" + dep.getDepOccupationCode());
			info.setSocialStatusCode(Short.valueOf(dep.getDepSocialStatusCode()));
			info.setRelationship(dep.getDepRelationship());

			info.setLogId(svcResponse.getLogId());
			alienList.add(info);
		}

		return alienList;

	}

}
