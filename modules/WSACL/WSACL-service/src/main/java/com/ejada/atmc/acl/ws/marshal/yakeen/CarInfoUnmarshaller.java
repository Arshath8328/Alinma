package com.ejada.atmc.acl.ws.marshal.yakeen;

import com.ejada.atmc.acl.ws.domain.yakeen.BasicCarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.proxy.yakeen.AlienCarInfoBySequenceResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CarInfoByCustomResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CitizenCarInfoBySequenceResult;
import com.ejada.atmc.acl.ws.proxy.yakeen.CompanyCarInfoBySequenceResult;

public class CarInfoUnmarshaller {

	public static BasicCarInfo unmarshalBasicCarInfo(CarInfoByCustomResult svcResponse) {
		BasicCarInfo info = new BasicCarInfo();
		info.setLogId(svcResponse.getLogId());

		info.setChassisNumber(svcResponse.getChassisNumber());
		info.setLkVehBodyType(svcResponse.getLkVehBodyType());
		info.setMajorColor(svcResponse.getMajorColor());
		info.setVehicleLoad(svcResponse.getVehicleLoad());
		info.setVehicleMakerCode(svcResponse.getVehicleMakerCode());
		info.setVehicleModelCode(svcResponse.getVehicleModelCode());
		info.setVehicleWeight(svcResponse.getVehicleWeight());

		return info;

	}

	public static CarInfo unmarshalCarInfo(AlienCarInfoBySequenceResult svcResponse) {
		CarInfo info = new CarInfo();
		info.setLogId(svcResponse.getLogId());

		info.setChassisNumber(svcResponse.getChassisNumber());
		info.setLkVehBodyType(svcResponse.getLkVehBodyType());
		info.setMajorColor(svcResponse.getMajorColor());
		info.setVehicleLoad(svcResponse.getVehicleLoad());
		info.setVehicleMakerCode(svcResponse.getVehicleMakerCode());
		info.setVehicleModelCode(svcResponse.getVehicleModelCode());
		info.setVehicleWeight(svcResponse.getVehicleWeight());

		info.setPlateNumber(svcResponse.getPlateNumber());
		info.setPlateText1(svcResponse.getPlateText1());
		info.setPlateText2(svcResponse.getPlateText2());
		info.setPlateText3(svcResponse.getPlateText3());
		info.setPlateTypeCode(svcResponse.getPlateTypeCode());
		info.setModelYear(svcResponse.getModelYear());
		info.setCylinders(svcResponse.getCylinders());
		info.setRegExpiryDate(svcResponse.getRegExpiryDate());
		info.setOwnerName(svcResponse.getOwnerName());
		info.setRegCityLocationCode(svcResponse.getRegCityLocationCode());
		return info;

	}

	public static CarInfo unmarshalCarInfo(CompanyCarInfoBySequenceResult svcResponse) {
		CarInfo info = new CarInfo();
		info.setLogId(svcResponse.getLogId());

		info.setChassisNumber(svcResponse.getChassisNumber());
		info.setLkVehBodyType(svcResponse.getLkVehBodyType());
		info.setMajorColor(svcResponse.getMajorColor());
		info.setVehicleLoad(svcResponse.getVehicleLoad());
		info.setVehicleMakerCode(svcResponse.getVehicleMakerCode());
		info.setVehicleModelCode(svcResponse.getVehicleModelCode());
		info.setVehicleWeight(svcResponse.getVehicleWeight());

		info.setPlateNumber(svcResponse.getPlateNumber());
		info.setPlateText1(svcResponse.getPlateText1());
		info.setPlateText2(svcResponse.getPlateText2());
		info.setPlateText3(svcResponse.getPlateText3());
		info.setPlateTypeCode(svcResponse.getPlateTypeCode());
		info.setModelYear(svcResponse.getModelYear());
		info.setCylinders(svcResponse.getCylinders());
		info.setRegExpiryDate(svcResponse.getRegExpiryDate());
		info.setOwnerName(svcResponse.getOwnerName());
		info.setRegCityLocationCode(svcResponse.getRegCityLocationCode());
		return info;

	}

	public static CarInfo unmarshalCarInfo(CitizenCarInfoBySequenceResult svcResponse) {
		CarInfo info = new CarInfo();
		info.setLogId(svcResponse.getLogId());

		info.setChassisNumber(svcResponse.getChassisNumber());
		info.setLkVehBodyType(svcResponse.getLkVehBodyType());
		info.setMajorColor(svcResponse.getMajorColor());
		info.setVehicleLoad(svcResponse.getVehicleLoad());
		info.setVehicleMakerCode(svcResponse.getVehicleMakerCode());
		info.setVehicleModelCode(svcResponse.getVehicleModelCode());
		info.setVehicleWeight(svcResponse.getVehicleWeight());

		info.setPlateNumber(svcResponse.getPlateNumber());
		info.setPlateText1(svcResponse.getPlateText1());
		info.setPlateText2(svcResponse.getPlateText2());
		info.setPlateText3(svcResponse.getPlateText3());
		info.setPlateTypeCode(svcResponse.getPlateTypeCode());
		info.setModelYear(svcResponse.getModelYear());
		info.setCylinders(svcResponse.getCylinders());
		info.setRegExpiryDate(svcResponse.getRegExpiryDate());
		info.setOwnerName(svcResponse.getOwnerName());
		info.setRegCityLocationCode(svcResponse.getRegCityLocationCode());
		return info;

	}

}
