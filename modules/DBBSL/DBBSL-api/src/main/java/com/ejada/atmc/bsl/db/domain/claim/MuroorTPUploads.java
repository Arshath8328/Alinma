package com.ejada.atmc.bsl.db.domain.claim;

import java.sql.Blob;

/**
 * @author SarahTaher
 */

public class MuroorTPUploads {

	private int fileId;
	private String claimIntimationNo;
	private String iqamaId;
	private Blob driverLicense;
	private String driverLicenseName;
	private Blob vehRegist;
	private String vehRegistName;
	private Blob frontPhoto;
	private String frontPhotoName;
	private Blob rearPhoto;
	private String rearPhotoName;
	private Blob rightSidePhoto;
	private String rightSidePhotoName;
	private Blob leftSidePhoto;
	private String leftSidePhotoName;
	private Blob bankIban;
	private String bankIbanName;
	private Blob ownerId;
	private String ownerIdName;

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
	 * @return the frontPhoto
	 */
	public Blob getFrontPhoto() {
		return frontPhoto;
	}

	/**
	 * @param frontPhoto the frontPhoto to set
	 */
	public void setFrontPhoto(Blob frontPhoto) {
		this.frontPhoto = frontPhoto;
	}

	/**
	 * @return the frontPhotoName
	 */
	public String getFrontPhotoName() {
		return frontPhotoName;
	}

	/**
	 * @param frontPhotoName the frontPhotoName to set
	 */
	public void setFrontPhotoName(String frontPhotoName) {
		this.frontPhotoName = frontPhotoName;
	}

	/**
	 * @return the rearPhoto
	 */
	public Blob getRearPhoto() {
		return rearPhoto;
	}

	/**
	 * @param rearPhoto the rearPhoto to set
	 */
	public void setRearPhoto(Blob rearPhoto) {
		this.rearPhoto = rearPhoto;
	}

	/**
	 * @return the rearPhotoName
	 */
	public String getRearPhotoName() {
		return rearPhotoName;
	}

	/**
	 * @param rearPhotoName the rearPhotoName to set
	 */
	public void setRearPhotoName(String rearPhotoName) {
		this.rearPhotoName = rearPhotoName;
	}

	/**
	 * @return the rightSidePhoto
	 */
	public Blob getRightSidePhoto() {
		return rightSidePhoto;
	}

	/**
	 * @param rightSidePhoto the rightSidePhoto to set
	 */
	public void setRightSidePhoto(Blob rightSidePhoto) {
		this.rightSidePhoto = rightSidePhoto;
	}

	/**
	 * @return the rightSidePhotoName
	 */
	public String getRightSidePhotoName() {
		return rightSidePhotoName;
	}

	/**
	 * @param rightSidePhotoName the rightSidePhotoName to set
	 */
	public void setRightSidePhotoName(String rightSidePhotoName) {
		this.rightSidePhotoName = rightSidePhotoName;
	}

	/**
	 * @return the leftSidePhoto
	 */
	public Blob getLeftSidePhoto() {
		return leftSidePhoto;
	}

	/**
	 * @param leftSidePhoto the leftSidePhoto to set
	 */
	public void setLeftSidePhoto(Blob leftSidePhoto) {
		this.leftSidePhoto = leftSidePhoto;
	}

	/**
	 * @return the leftSidePhotoName
	 */
	public String getLeftSidePhotoName() {
		return leftSidePhotoName;
	}

	/**
	 * @param leftSidePhotoName the leftSidePhotoName to set
	 */
	public void setLeftSidePhotoName(String leftSidePhotoName) {
		this.leftSidePhotoName = leftSidePhotoName;
	}

	/**
	 * @return the bankIban
	 */
	public Blob getBankIban() {
		return bankIban;
	}

	/**
	 * @param bankIban the bankIban to set
	 */
	public void setBankIban(Blob bankIban) {
		this.bankIban = bankIban;
	}

	/**
	 * @return the bankIbanName
	 */
	public String getBankIbanName() {
		return bankIbanName;
	}

	/**
	 * @param bankIbanName the bankIbanName to set
	 */
	public void setBankIbanName(String bankIbanName) {
		this.bankIbanName = bankIbanName;
	}

	/**
	 * @return the ownerId
	 */
	public Blob getOwnerId() {
		return ownerId;
	}

	/**
	 * @param ownerId the ownerId to set
	 */
	public void setOwnerId(Blob ownerId) {
		this.ownerId = ownerId;
	}

	/**
	 * @return the ownerIdName
	 */
	public String getOwnerIdName() {
		return ownerIdName;
	}

	/**
	 * @param ownerIdName the ownerIdName to set
	 */
	public void setOwnerIdName(String ownerIdName) {
		this.ownerIdName = ownerIdName;
	}
}
