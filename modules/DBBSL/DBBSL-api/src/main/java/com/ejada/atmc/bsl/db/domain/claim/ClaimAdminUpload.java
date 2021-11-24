package com.ejada.atmc.bsl.db.domain.claim;

public class ClaimAdminUpload {

	private int id;
	private String refNo;
	private String fileName;
	// private byte[] adminFile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getRefNo() {
		return refNo;
	}

	public void setRefNo(String refNo) {
		this.refNo = refNo;
	}

}
