package com.atmc.bsl.db.domain.quotation;

/**
 * @author Hadeer
 */
public class QuotationCustUploads {

	private long id;
	private String quotationId;
	private String idFileName;
	private String licenseFileName;
	private String istFileName;
	private String carFrontFileName;
	private String carBackFileName;
	private String carLeftFileName;
	private String carRightFileName;
	private String engineChassisNoFileName;
	private String leaseFileName;

	public String getIdFileName() {
		return idFileName;
	}

	public void setIdFileName(String idFileName) {
		this.idFileName = idFileName;
	}

	public String getLicenseFileName() {
		return licenseFileName;
	}

	public void setLicenseFileName(String licenseFileName) {
		this.licenseFileName = licenseFileName;
	}

	public String getIstFileName() {
		return istFileName;
	}

	public void setIstFileName(String istFileName) {
		this.istFileName = istFileName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuotationId() {
		return quotationId;
	}

	public void setQuotationId(String quotationId) {
		this.quotationId = quotationId;
	}

	public String getCarFrontFileName() {
		return carFrontFileName;
	}

	public void setCarFrontFileName(String carFrontFileName) {
		this.carFrontFileName = carFrontFileName;
	}

	public String getCarBackFileName() {
		return carBackFileName;
	}

	public void setCarBackFileName(String carBackFileName) {
		this.carBackFileName = carBackFileName;
	}

	public String getCarLeftFileName() {
		return carLeftFileName;
	}

	public void setCarLeftFileName(String carLeftFileName) {
		this.carLeftFileName = carLeftFileName;
	}

	public String getCarRightFileName() {
		return carRightFileName;
	}

	public void setCarRightFileName(String carRightFileName) {
		this.carRightFileName = carRightFileName;
	}

	public String getEngineChassisNoFileName() {
		return engineChassisNoFileName;
	}

	public void setEngineChassisNoFileName(String engineChassisNoFileName) {
		this.engineChassisNoFileName = engineChassisNoFileName;
	}

	public String getLeaseFileName() {
		return leaseFileName;
	}

	public void setLeaseFileName(String leaseFileName) {
		this.leaseFileName = leaseFileName;
	}
}
