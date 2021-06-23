package com.atmc.mob.acl.ws.marshal.yakeen;

import com.atmc.mob.acl.ws.domain.yakeen.AlienLegalStatusInfo;
import com.atmc.mob.acl.ws.domain.yakeen.CompanyInfo;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienLegalStatusInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyInfoBySponseredIqamaResult;

public class InfoUnmarshaller {
	
	public static AlienLegalStatusInfo unmarshalAlienLegalStatusInfo(AlienLegalStatusInfoResult svcResponse)
	{
		AlienLegalStatusInfo info = new AlienLegalStatusInfo();
		info.setLogId(svcResponse.getLogId());
		info.setLegalStatus(svcResponse.isLegalStatus());
		return info;
		
	}
	
	public static CompanyInfo unmarshalCompanyInfo(CompanyInfoBySponseredIqamaResult svcResponse)
	{
		CompanyInfo info = new CompanyInfo();
		info.setLogId(svcResponse.getLogId());
		info.setTotalNumberOfSponsoredDependents(svcResponse.getTotalNumberOfSponsoredDependents());
		info.setTotalNumberOfSponsoreds(svcResponse.getTotalNumberOfSponsoreds());
		return info;
		
	}
	
	
}
