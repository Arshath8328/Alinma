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

package com.ejada.atmc.acl.db.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.ejada.atmc.acl.db.service.http.LNP2_PolicyMastrServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class LNP2_PolicyMastrSoap implements Serializable {

	public static LNP2_PolicyMastrSoap toSoapModel(LNP2_PolicyMastr model) {
		LNP2_PolicyMastrSoap soapModel = new LNP2_PolicyMastrSoap();

		soapModel.setNp1_proposal(model.getNp1_proposal());
		soapModel.setNp2_setno(model.getNp2_setno());
		soapModel.setCfr_forfeitucd(model.getCfr_forfeitucd());
		soapModel.setCmo_mode(model.getCmo_mode());
		soapModel.setPcu_currcode(model.getPcu_currcode());
		soapModel.setAag_agcode(model.getAag_agcode());
		soapModel.setCcl_categorycd(model.getCcl_categorycd());
		soapModel.setUse_userid(model.getUse_userid());
		soapModel.setUse_datetime(model.getUse_datetime());
		soapModel.setNp2_grosprm(model.getNp2_grosprm());
		soapModel.setNp2_ageprem(model.getNp2_ageprem());
		soapModel.setNp2_commendate(model.getNp2_commendate());
		soapModel.setNp2_sumatrisk(model.getNp2_sumatrisk());
		soapModel.setNp2_substandar(model.getNp2_substandar());
		soapModel.setNp2_effectdate(model.getNp2_effectdate());
		soapModel.setNp2_expirydate(model.getNp2_expirydate());
		soapModel.setNp2_endofprmdt(model.getNp2_endofprmdt());
		soapModel.setNp2_paidupamt(model.getNp2_paidupamt());
		soapModel.setNp2_diffinprem(model.getNp2_diffinprem());
		soapModel.setNp2_diffinfyco(model.getNp2_diffinfyco());
		soapModel.setNp2_charges(model.getNp2_charges());
		soapModel.setNp2_totload(model.getNp2_totload());
		soapModel.setNp2_nextduedat(model.getNp2_nextduedat());
		soapModel.setNp2_ageadmitt(model.getNp2_ageadmitt());
		soapModel.setNp2_optimaindex(model.getNp2_optimaindex());
		soapModel.setNp2_ageprem2nd(model.getNp2_ageprem2nd());
		soapModel.setNp2_policyfees(model.getNp2_policyfees());
		soapModel.setNp2_sar(model.getNp2_sar());
		soapModel.setNp2_totpremium(model.getNp2_totpremium());
		soapModel.setNp2_approved(model.getNp2_approved());
		soapModel.setNp2_endorsementno(model.getNp2_endorsementno());
		soapModel.setPfs_acntyear(model.getPfs_acntyear());
		soapModel.setArq_requestype(model.getArq_requestype());
		soapModel.setArq_requestno(model.getArq_requestno());
		soapModel.setNp2_forfeitdat(model.getNp2_forfeitdat());
		soapModel.setConvert(model.getConvert());
		soapModel.setNp2_notionalage(model.getNp2_notionalage());
		soapModel.setCop_occupaticd(model.getCop_occupaticd());
		soapModel.setNp2_dob(model.getNp2_dob());
		soapModel.setNp2_accr_proc(model.getNp2_accr_proc());
		soapModel.setNp2_effectiveage(model.getNp2_effectiveage());
		soapModel.setNp2_nom2ndlife(model.getNp2_nom2ndlife());
		soapModel.setNp2_dob_2nd(model.getNp2_dob_2nd());
		soapModel.setNp2_lastrevbonus(model.getNp2_lastrevbonus());
		soapModel.setNp2_reversionary(model.getNp2_reversionary());
		soapModel.setNp2_rider_bonus(model.getNp2_rider_bonus());
		soapModel.setNp2_last_rider_bonus(model.getNp2_last_rider_bonus());
		soapModel.setNp2_ageprem_actual(model.getNp2_ageprem_actual());
		soapModel.setNp2_ageprem2nd_actual(model.getNp2_ageprem2nd_actual());

		return soapModel;
	}

	public static LNP2_PolicyMastrSoap[] toSoapModels(
		LNP2_PolicyMastr[] models) {

		LNP2_PolicyMastrSoap[] soapModels =
			new LNP2_PolicyMastrSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LNP2_PolicyMastrSoap[][] toSoapModels(
		LNP2_PolicyMastr[][] models) {

		LNP2_PolicyMastrSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels =
				new LNP2_PolicyMastrSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LNP2_PolicyMastrSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LNP2_PolicyMastrSoap[] toSoapModels(
		List<LNP2_PolicyMastr> models) {

		List<LNP2_PolicyMastrSoap> soapModels =
			new ArrayList<LNP2_PolicyMastrSoap>(models.size());

		for (LNP2_PolicyMastr model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LNP2_PolicyMastrSoap[soapModels.size()]);
	}

	public LNP2_PolicyMastrSoap() {
	}

	public String getPrimaryKey() {
		return _np1_proposal;
	}

	public void setPrimaryKey(String pk) {
		setNp1_proposal(pk);
	}

	public String getNp1_proposal() {
		return _np1_proposal;
	}

	public void setNp1_proposal(String np1_proposal) {
		_np1_proposal = np1_proposal;
	}

	public String getNp2_setno() {
		return _np2_setno;
	}

	public void setNp2_setno(String np2_setno) {
		_np2_setno = np2_setno;
	}

	public String getCfr_forfeitucd() {
		return _cfr_forfeitucd;
	}

	public void setCfr_forfeitucd(String cfr_forfeitucd) {
		_cfr_forfeitucd = cfr_forfeitucd;
	}

	public String getCmo_mode() {
		return _cmo_mode;
	}

	public void setCmo_mode(String cmo_mode) {
		_cmo_mode = cmo_mode;
	}

	public String getPcu_currcode() {
		return _pcu_currcode;
	}

	public void setPcu_currcode(String pcu_currcode) {
		_pcu_currcode = pcu_currcode;
	}

	public long getAag_agcode() {
		return _aag_agcode;
	}

	public void setAag_agcode(long aag_agcode) {
		_aag_agcode = aag_agcode;
	}

	public String getCcl_categorycd() {
		return _ccl_categorycd;
	}

	public void setCcl_categorycd(String ccl_categorycd) {
		_ccl_categorycd = ccl_categorycd;
	}

	public String getUse_userid() {
		return _use_userid;
	}

	public void setUse_userid(String use_userid) {
		_use_userid = use_userid;
	}

	public Date getUse_datetime() {
		return _use_datetime;
	}

	public void setUse_datetime(Date use_datetime) {
		_use_datetime = use_datetime;
	}

	public long getNp2_grosprm() {
		return _np2_grosprm;
	}

	public void setNp2_grosprm(long np2_grosprm) {
		_np2_grosprm = np2_grosprm;
	}

	public long getNp2_ageprem() {
		return _np2_ageprem;
	}

	public void setNp2_ageprem(long np2_ageprem) {
		_np2_ageprem = np2_ageprem;
	}

	public Date getNp2_commendate() {
		return _np2_commendate;
	}

	public void setNp2_commendate(Date np2_commendate) {
		_np2_commendate = np2_commendate;
	}

	public long getNp2_sumatrisk() {
		return _np2_sumatrisk;
	}

	public void setNp2_sumatrisk(long np2_sumatrisk) {
		_np2_sumatrisk = np2_sumatrisk;
	}

	public String getNp2_substandar() {
		return _np2_substandar;
	}

	public void setNp2_substandar(String np2_substandar) {
		_np2_substandar = np2_substandar;
	}

	public Date getNp2_effectdate() {
		return _np2_effectdate;
	}

	public void setNp2_effectdate(Date np2_effectdate) {
		_np2_effectdate = np2_effectdate;
	}

	public Date getNp2_expirydate() {
		return _np2_expirydate;
	}

	public void setNp2_expirydate(Date np2_expirydate) {
		_np2_expirydate = np2_expirydate;
	}

	public Date getNp2_endofprmdt() {
		return _np2_endofprmdt;
	}

	public void setNp2_endofprmdt(Date np2_endofprmdt) {
		_np2_endofprmdt = np2_endofprmdt;
	}

	public long getNp2_paidupamt() {
		return _np2_paidupamt;
	}

	public void setNp2_paidupamt(long np2_paidupamt) {
		_np2_paidupamt = np2_paidupamt;
	}

	public long getNp2_diffinprem() {
		return _np2_diffinprem;
	}

	public void setNp2_diffinprem(long np2_diffinprem) {
		_np2_diffinprem = np2_diffinprem;
	}

	public long getNp2_diffinfyco() {
		return _np2_diffinfyco;
	}

	public void setNp2_diffinfyco(long np2_diffinfyco) {
		_np2_diffinfyco = np2_diffinfyco;
	}

	public long getNp2_charges() {
		return _np2_charges;
	}

	public void setNp2_charges(long np2_charges) {
		_np2_charges = np2_charges;
	}

	public long getNp2_totload() {
		return _np2_totload;
	}

	public void setNp2_totload(long np2_totload) {
		_np2_totload = np2_totload;
	}

	public Date getNp2_nextduedat() {
		return _np2_nextduedat;
	}

	public void setNp2_nextduedat(Date np2_nextduedat) {
		_np2_nextduedat = np2_nextduedat;
	}

	public long getNp2_ageadmitt() {
		return _np2_ageadmitt;
	}

	public void setNp2_ageadmitt(long np2_ageadmitt) {
		_np2_ageadmitt = np2_ageadmitt;
	}

	public long getNp2_optimaindex() {
		return _np2_optimaindex;
	}

	public void setNp2_optimaindex(long np2_optimaindex) {
		_np2_optimaindex = np2_optimaindex;
	}

	public long getNp2_ageprem2nd() {
		return _np2_ageprem2nd;
	}

	public void setNp2_ageprem2nd(long np2_ageprem2nd) {
		_np2_ageprem2nd = np2_ageprem2nd;
	}

	public long getNp2_policyfees() {
		return _np2_policyfees;
	}

	public void setNp2_policyfees(long np2_policyfees) {
		_np2_policyfees = np2_policyfees;
	}

	public long getNp2_sar() {
		return _np2_sar;
	}

	public void setNp2_sar(long np2_sar) {
		_np2_sar = np2_sar;
	}

	public long getNp2_totpremium() {
		return _np2_totpremium;
	}

	public void setNp2_totpremium(long np2_totpremium) {
		_np2_totpremium = np2_totpremium;
	}

	public long getNp2_approved() {
		return _np2_approved;
	}

	public void setNp2_approved(long np2_approved) {
		_np2_approved = np2_approved;
	}

	public String getNp2_endorsementno() {
		return _np2_endorsementno;
	}

	public void setNp2_endorsementno(String np2_endorsementno) {
		_np2_endorsementno = np2_endorsementno;
	}

	public String getPfs_acntyear() {
		return _pfs_acntyear;
	}

	public void setPfs_acntyear(String pfs_acntyear) {
		_pfs_acntyear = pfs_acntyear;
	}

	public String getArq_requestype() {
		return _arq_requestype;
	}

	public void setArq_requestype(String arq_requestype) {
		_arq_requestype = arq_requestype;
	}

	public long getArq_requestno() {
		return _arq_requestno;
	}

	public void setArq_requestno(long arq_requestno) {
		_arq_requestno = arq_requestno;
	}

	public Date getNp2_forfeitdat() {
		return _np2_forfeitdat;
	}

	public void setNp2_forfeitdat(Date np2_forfeitdat) {
		_np2_forfeitdat = np2_forfeitdat;
	}

	public long getConvert() {
		return _convert;
	}

	public void setConvert(long convert) {
		_convert = convert;
	}

	public long getNp2_notionalage() {
		return _np2_notionalage;
	}

	public void setNp2_notionalage(long np2_notionalage) {
		_np2_notionalage = np2_notionalage;
	}

	public String getCop_occupaticd() {
		return _cop_occupaticd;
	}

	public void setCop_occupaticd(String cop_occupaticd) {
		_cop_occupaticd = cop_occupaticd;
	}

	public Date getNp2_dob() {
		return _np2_dob;
	}

	public void setNp2_dob(Date np2_dob) {
		_np2_dob = np2_dob;
	}

	public String getNp2_accr_proc() {
		return _np2_accr_proc;
	}

	public void setNp2_accr_proc(String np2_accr_proc) {
		_np2_accr_proc = np2_accr_proc;
	}

	public long getNp2_effectiveage() {
		return _np2_effectiveage;
	}

	public void setNp2_effectiveage(long np2_effectiveage) {
		_np2_effectiveage = np2_effectiveage;
	}

	public String getNp2_nom2ndlife() {
		return _np2_nom2ndlife;
	}

	public void setNp2_nom2ndlife(String np2_nom2ndlife) {
		_np2_nom2ndlife = np2_nom2ndlife;
	}

	public Date getNp2_dob_2nd() {
		return _np2_dob_2nd;
	}

	public void setNp2_dob_2nd(Date np2_dob_2nd) {
		_np2_dob_2nd = np2_dob_2nd;
	}

	public long getNp2_lastrevbonus() {
		return _np2_lastrevbonus;
	}

	public void setNp2_lastrevbonus(long np2_lastrevbonus) {
		_np2_lastrevbonus = np2_lastrevbonus;
	}

	public long getNp2_reversionary() {
		return _np2_reversionary;
	}

	public void setNp2_reversionary(long np2_reversionary) {
		_np2_reversionary = np2_reversionary;
	}

	public long getNp2_rider_bonus() {
		return _np2_rider_bonus;
	}

	public void setNp2_rider_bonus(long np2_rider_bonus) {
		_np2_rider_bonus = np2_rider_bonus;
	}

	public long getNp2_last_rider_bonus() {
		return _np2_last_rider_bonus;
	}

	public void setNp2_last_rider_bonus(long np2_last_rider_bonus) {
		_np2_last_rider_bonus = np2_last_rider_bonus;
	}

	public long getNp2_ageprem_actual() {
		return _np2_ageprem_actual;
	}

	public void setNp2_ageprem_actual(long np2_ageprem_actual) {
		_np2_ageprem_actual = np2_ageprem_actual;
	}

	public long getNp2_ageprem2nd_actual() {
		return _np2_ageprem2nd_actual;
	}

	public void setNp2_ageprem2nd_actual(long np2_ageprem2nd_actual) {
		_np2_ageprem2nd_actual = np2_ageprem2nd_actual;
	}

	private String _np1_proposal;
	private String _np2_setno;
	private String _cfr_forfeitucd;
	private String _cmo_mode;
	private String _pcu_currcode;
	private long _aag_agcode;
	private String _ccl_categorycd;
	private String _use_userid;
	private Date _use_datetime;
	private long _np2_grosprm;
	private long _np2_ageprem;
	private Date _np2_commendate;
	private long _np2_sumatrisk;
	private String _np2_substandar;
	private Date _np2_effectdate;
	private Date _np2_expirydate;
	private Date _np2_endofprmdt;
	private long _np2_paidupamt;
	private long _np2_diffinprem;
	private long _np2_diffinfyco;
	private long _np2_charges;
	private long _np2_totload;
	private Date _np2_nextduedat;
	private long _np2_ageadmitt;
	private long _np2_optimaindex;
	private long _np2_ageprem2nd;
	private long _np2_policyfees;
	private long _np2_sar;
	private long _np2_totpremium;
	private long _np2_approved;
	private String _np2_endorsementno;
	private String _pfs_acntyear;
	private String _arq_requestype;
	private long _arq_requestno;
	private Date _np2_forfeitdat;
	private long _convert;
	private long _np2_notionalage;
	private String _cop_occupaticd;
	private Date _np2_dob;
	private String _np2_accr_proc;
	private long _np2_effectiveage;
	private String _np2_nom2ndlife;
	private Date _np2_dob_2nd;
	private long _np2_lastrevbonus;
	private long _np2_reversionary;
	private long _np2_rider_bonus;
	private long _np2_last_rider_bonus;
	private long _np2_ageprem_actual;
	private long _np2_ageprem2nd_actual;

}