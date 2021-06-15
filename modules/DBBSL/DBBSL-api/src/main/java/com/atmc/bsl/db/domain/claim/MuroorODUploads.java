package com.atmc.bsl.db.domain.claim;

import java.sql.Blob;

/**
 * @author SarahTaher
 */

public class MuroorODUploads {
	
	private int fileId;
	private String claimIntimationNo;
	private String iqamaId;
	private Blob driverLicense;
	private String driverLicenseName;
	private Blob vehRegist;
	private String vehRegistName;
	private Blob policyCopy;
	private String policyCopyName;
	/**
	 * @return the fileId
	 */
	public int getFileId() {
		return fileId;
	}
	/**
	 * @param fileId the fileId to set
	 */
	public void setFileId(int fileId) {
		this.fileId = fileId;
	}
	/**
	 * @return the claimIntimationNo
	 */
	public String getClaimIntimationNo() {
		return claimIntimationNo;
	}
	/**
	 * @param claimIntimationNo the claimIntimationNo to set
	 */
	public void setClaimIntimationNo(String claimIntimationNo) {
		this.claimIntimationNo = claimIntimationNo;
	}
	/**
	 * @return the iqamaId
	 */
	public String getIqamaId() {
		return iqamaId;
	}
	/**
	 * @param iqamaId the iqamaId to set
	 */
	public void setIqamaId(String iqamaId) {
		this.iqamaId = iqamaId;
	}
	/**
	 * @return the driverLicense
	 */
	public Blob getDriverLicense() {
		return driverLicense;
	}
	/**
	 * @param driverLicense the driverLicense to set
	 */
	public void setDriverLicense(Blob driverLicense) {
		this.driverLicense = driverLicense;
	}
	/**
	 * @return the driverLicenseName
	 */
	public String getDriverLicenseName() {
		return driverLicenseName;
	}
	/**
	 * @param driverLicenseName the driverLicenseName to set
	 */
	public void setDriverLicenseName(String driverLicenseName) {
		this.driverLicenseName = driverLicenseName;
	}
	/**
	 * @return the vehRegist
	 */
	public Blob getVehRegist() {
		return vehRegist;
	}
	/**
	 * @param vehRegist the vehRegist to set
	 */
	public void setVehRegist(Blob vehRegist) {
		this.vehRegist = vehRegist;
	}
	/**
	 * @return the vehRegistName
	 */
	public String getVehRegistName() {
		return vehRegistName;
	}
	/**
	 * @param vehRegistName the vehRegistName to set
	 */
	public void setVehRegistName(String vehRegistName) {
		this.vehRegistName = vehRegistName;
	}
	/**
	 * @return the policyCopy
	 */
	public Blob getPolicyCopy() {
		return policyCopy;
	}
	/**
	 * @param policyCopy the policyCopy to set
	 */
	public void setPolicyCopy(Blob policyCopy) {
		this.policyCopy = policyCopy;
	}
	/**
	 * @return the policyCopyName
	 */
	public String getPolicyCopyName() {
		return policyCopyName;
	}
	/**
	 * @param policyCopyName the policyCopyName to set
	 */
	public void setPolicyCopyName(String policyCopyName) {
		this.policyCopyName = policyCopyName;
	}
}
