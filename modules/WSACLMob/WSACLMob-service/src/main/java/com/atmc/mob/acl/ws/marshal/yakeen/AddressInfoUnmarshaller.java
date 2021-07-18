package com.atmc.mob.acl.ws.marshal.yakeen;

import com.atmc.mob.acl.ws.domain.yakeen.AddressInfo;
import com.atmc.mob.acl.ws.proxy.yakeen.AddressList12;
import com.atmc.mob.acl.ws.proxy.yakeen.AddressList13;
import com.atmc.mob.acl.ws.proxy.yakeen.AddressList14;
import com.atmc.mob.acl.ws.proxy.yakeen.AlienAddressInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CitizenAddressInfoResult;
import com.atmc.mob.acl.ws.proxy.yakeen.CompanyAddressInfoByCrResult;

import java.util.ArrayList;
import java.util.List;

public class AddressInfoUnmarshaller {

	
	public static List<AddressInfo> unmarshalAlienAddressInfo(AlienAddressInfoResult svcResponse)
	{
		List<AddressInfo> infoList = new ArrayList<AddressInfo>();
		
		
		for (AddressList12 addressInfo : svcResponse.getAddressListList()) {
			AddressInfo info = new AddressInfo();
			info.setLogId(svcResponse.getLogId());
			info.setAdditionalNumber(String.valueOf(addressInfo.getAdditionalNumber()));
			info.setBuildingNumber(String.valueOf(addressInfo.getBuildingNumber()));
			info.setCity(addressInfo.getCity());
			info.setDistrict(addressInfo.getDistrict());
			info.setPostCode(String.valueOf(addressInfo.getPostCode()));
			info.setStreetName(addressInfo.getStreetName());
			info.setIsPrimaryAddress(String.valueOf(addressInfo.isIsPrimaryAddress()));
			infoList.add(info);
		}
		
		return infoList;
		
	}
	
	public static List<AddressInfo> unmarshalCitizenAddressInfo(CitizenAddressInfoResult svcResponse)
	{
		List<AddressInfo> infoList = new ArrayList<AddressInfo>();
		
		
		for (AddressList13 addressInfo : svcResponse.getAddressListList()) {
			AddressInfo info = new AddressInfo();
			info.setLogId(svcResponse.getLogId());
			info.setAdditionalNumber(String.valueOf(addressInfo.getAdditionalNumber()));
			info.setBuildingNumber(String.valueOf(addressInfo.getBuildingNumber()));
			info.setCity(addressInfo.getCity());
			info.setDistrict(addressInfo.getDistrict());
			info.setPostCode(String.valueOf(addressInfo.getPostCode()));
			info.setStreetName(addressInfo.getStreetName());
			info.setIsPrimaryAddress(String.valueOf(addressInfo.isIsPrimaryAddress()));
			infoList.add(info);
		}
		
		return infoList;
		
	}
	
	public static List<AddressInfo> unmarshalCompanyAddressInfoByCr(CompanyAddressInfoByCrResult svcResponse)
	{
		List<AddressInfo> infoList = new ArrayList<AddressInfo>();
		
		
		for (AddressList14 addressInfo : svcResponse.getAddressListList()) {
			AddressInfo info = new AddressInfo();
			info.setLogId(svcResponse.getLogId());
			info.setAdditionalNumber(String.valueOf(addressInfo.getAdditionalNumber()));
			info.setBuildingNumber(String.valueOf(addressInfo.getBuildingNumber()));
			info.setCity(addressInfo.getCity());
			info.setDistrict(addressInfo.getDistrict());
			info.setPostCode(String.valueOf(addressInfo.getPostCode()));
			info.setStreetName(addressInfo.getStreetName());
			info.setIsPrimaryAddress(String.valueOf(addressInfo.isIsPrimaryAddress()));
			infoList.add(info);
		}
		
		return infoList;
		
	}
	
	
	
}
