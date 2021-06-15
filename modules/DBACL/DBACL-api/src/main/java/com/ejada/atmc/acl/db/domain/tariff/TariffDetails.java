/*
 * TariffDetails.java Feb 1, 2018  
 *
 * Copyright (c) 2005-2012 Ejada Solutions.
 * All rights reserved.
 *
 * This software is the confidential and proprietary information of Ejada
 * Solutions, Inc. ("Confidential Information").  You shall not
 * disclose such Confidential Information and shall use it only in
 * accordance with the terms of the license agreement you entered into
 * with Ejada.
 */
package com.ejada.atmc.acl.db.domain.tariff;

/**
 * @author Sarah Taher
 *
 */

public class TariffDetails {
	private TariffInput tariffInput;
	private TariffOutput tariffOutput;
	
	public TariffInput getTariffInput() {
		return tariffInput;
	}
	public void setTariffInput(TariffInput tariffInput) {
		this.tariffInput = tariffInput;
	}
	public TariffOutput getTariffOutput() {
		return tariffOutput;
	}
	public void setTariffOutput(TariffOutput tariffOutput) {
		this.tariffOutput = tariffOutput;
	}
}
