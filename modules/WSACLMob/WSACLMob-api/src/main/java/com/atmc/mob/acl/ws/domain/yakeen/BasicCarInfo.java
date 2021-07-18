/**
 * 
 */
package com.atmc.mob.acl.ws.domain.yakeen;

/**
 * @author Basel
 *
 */
public class BasicCarInfo extends ServiceResponse
{
    private String chassisNumber;
    private short lkVehBodyType;
    private String majorColor;
    private int vehicleLoad;
    private int vehicleMakerCode;
    private int vehicleModelCode;
    private int vehicleWeight;
	/**
	 * @return the chassisNumber
	 */
	public String getChassisNumber() {
		return chassisNumber;
	}
	/**
	 * @param chassisNumber the chassisNumber to set
	 */
	public void setChassisNumber(String chassisNumber) {
		this.chassisNumber = chassisNumber;
	}
	/**
	 * @return the lkVehBodyType
	 */
	public short getLkVehBodyType() {
		return lkVehBodyType;
	}
	/**
	 * @param lkVehBodyType the lkVehBodyType to set
	 */
	public void setLkVehBodyType(short lkVehBodyType) {
		this.lkVehBodyType = lkVehBodyType;
	}
	/**
	 * @return the majorColor
	 */
	public String getMajorColor() {
		return majorColor;
	}
	/**
	 * @param majorColor the majorColor to set
	 */
	public void setMajorColor(String majorColor) {
		this.majorColor = majorColor;
	}
	/**
	 * @return the vehicleLoad
	 */
	public int getVehicleLoad() {
		return vehicleLoad;
	}
	/**
	 * @param vehicleLoad the vehicleLoad to set
	 */
	public void setVehicleLoad(int vehicleLoad) {
		this.vehicleLoad = vehicleLoad;
	}
	/**
	 * @return the vehicleMakerCode
	 */
	public int getVehicleMakerCode() {
		return vehicleMakerCode;
	}
	/**
	 * @param vehicleMakerCode the vehicleMakerCode to set
	 */
	public void setVehicleMakerCode(int vehicleMakerCode) {
		this.vehicleMakerCode = vehicleMakerCode;
	}
	/**
	 * @return the vehicleModelCode
	 */
	public int getVehicleModelCode() {
		return vehicleModelCode;
	}
	/**
	 * @param vehicleModelCode the vehicleModelCode to set
	 */
	public void setVehicleModelCode(int vehicleModelCode) {
		this.vehicleModelCode = vehicleModelCode;
	}
	/**
	 * @return the vehicleWeight
	 */
	public int getVehicleWeight() {
		return vehicleWeight;
	}
	/**
	 * @param vehicleWeight the vehicleWeight to set
	 */
	public void setVehicleWeight(int vehicleWeight) {
		this.vehicleWeight = vehicleWeight;
	}
    
    

}
