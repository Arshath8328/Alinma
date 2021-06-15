/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ejada.atmc.acl.ws.service.impl;

import com.ejada.atmc.acl.ws.domain.yakeen.AddressInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienDepInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienLegalStatusInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CompanyInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.ServiceRequest;
import com.ejada.atmc.acl.ws.service.base.YakeenServiceBaseImpl;
import com.liferay.portal.aop.AopService;

import java.util.List;

import org.osgi.service.component.annotations.Component;

/**
 * The implementation of the yakeen remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.ws.service.YakeenService</code> interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    YakeenServiceBaseImpl
 */
@Component(
		property = { "json.web.service.context.name=wsacl", "json.web.service.context.path=Yakeen" },
		service = AopService.class
)
public class YakeenServiceImpl extends YakeenServiceBaseImpl {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link com.ejada.atmc.acl.ws.service.YakeenServiceUtil} to access the
	 * yakeen remote service.
	 */

	public AlienInfo getAlienInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {
		return yakeenLocalService.getAlienInfoByIqama(svcRequest, iqamaNumber, sponsorId);
	}

	public AlienInfo getAlienInfoByBorderNumber(ServiceRequest svcRequest, String borderNumber, String sponsorId) {
		return yakeenLocalService.getAlienInfoByBorderNumber(svcRequest, borderNumber, sponsorId);
	}

	public CitizenInfo getCitizenInfo(ServiceRequest svcRequest, String dateOfBirthH, String nin) {
		return yakeenLocalService.getCitizenInfo(svcRequest, dateOfBirthH, nin);
	}

	public List<AlienDepInfo> getAlienAllDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {
		return yakeenLocalService.getAlienAllDepInfoByIqama(svcRequest, iqamaNumber, depIqama);
	}

	public List<AlienDepInfo> getAlienSingleDepInfoByIqama(ServiceRequest svcRequest, String iqamaNumber, String depIqama) {
		return yakeenLocalService.getAlienSingleDepInfoByIqama(svcRequest, iqamaNumber, depIqama);
	}

	public BasicCarInfo getCarInfoByCustom(ServiceRequest svcRequest, String customCardNumber, short modelYear) {
		return yakeenLocalService.getCarInfoByCustom(svcRequest, customCardNumber, modelYear);
	}

	public CarInfo getAlienCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerIqamaNumber) {
		return yakeenLocalService.getAlienCarInfoBySequence(svcRequest, sequenceNumber, ownerIqamaNumber);
	}

	public CarInfo getCompanyCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long companyMOINumber) {
		return yakeenLocalService.getCompanyCarInfoBySequence(svcRequest, sequenceNumber, companyMOINumber);
	}

	public CarInfo getCitizenCarInfoBySequence(ServiceRequest svcRequest, int sequenceNumber, long ownerNin) {
		return yakeenLocalService.getCitizenCarInfoBySequence(svcRequest, sequenceNumber, ownerNin);
	}

	public AlienLegalStatusInfo getAlienLegalStatusInfo(ServiceRequest svcRequest, String iqamaNumber, String sponsorId) {
		return yakeenLocalService.getAlienLegalStatusInfo(svcRequest, iqamaNumber, sponsorId);
	}

	public CompanyInfo getCompanyInfoBySponseredIqama(ServiceRequest svcRequest, String iqamaNumber, String sponsorNumber, String depIqama) {
		return yakeenLocalService.getCompanyInfoBySponseredIqama(svcRequest, iqamaNumber, sponsorNumber, depIqama);
	}

	public List<AddressInfo> getAlienAddressInfo(ServiceRequest svcRequest, String iqamaNumber, String dateOfBirth, String addressLanguage) {
		return yakeenLocalService.getAlienAddressInfo(svcRequest, iqamaNumber, dateOfBirth, addressLanguage);
	}

	public List<AddressInfo> getCitizenAddressInfo(ServiceRequest svcRequest, String nin, String dateOfBirth, String addressLanguage) {
		return yakeenLocalService.getCitizenAddressInfo(svcRequest, nin, dateOfBirth, addressLanguage);
	}

	public List<AddressInfo> getCompanyAddressInfoByCr(ServiceRequest svcRequest, long crNumber, String addressLanguage) {
		return yakeenLocalService.getCompanyAddressInfoByCr(svcRequest, crNumber, addressLanguage);
	}

}