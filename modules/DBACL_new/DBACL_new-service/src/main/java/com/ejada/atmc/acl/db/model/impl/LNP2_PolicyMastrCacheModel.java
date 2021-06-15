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

package com.ejada.atmc.acl.db.model.impl;

import com.ejada.atmc.acl.db.model.LNP2_PolicyMastr;

import com.liferay.petra.lang.HashUtil;
import com.liferay.petra.string.StringBundler;
import com.liferay.portal.kernel.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LNP2_PolicyMastr in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
public class LNP2_PolicyMastrCacheModel
	implements CacheModel<LNP2_PolicyMastr>, Externalizable {

	@Override
	public boolean equals(Object object) {
		if (this == object) {
			return true;
		}

		if (!(object instanceof LNP2_PolicyMastrCacheModel)) {
			return false;
		}

		LNP2_PolicyMastrCacheModel lnp2_PolicyMastrCacheModel =
			(LNP2_PolicyMastrCacheModel)object;

		if (np1_proposal.equals(lnp2_PolicyMastrCacheModel.np1_proposal)) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, np1_proposal);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(99);

		sb.append("{np1_proposal=");
		sb.append(np1_proposal);
		sb.append(", np2_setno=");
		sb.append(np2_setno);
		sb.append(", cfr_forfeitucd=");
		sb.append(cfr_forfeitucd);
		sb.append(", cmo_mode=");
		sb.append(cmo_mode);
		sb.append(", pcu_currcode=");
		sb.append(pcu_currcode);
		sb.append(", aag_agcode=");
		sb.append(aag_agcode);
		sb.append(", ccl_categorycd=");
		sb.append(ccl_categorycd);
		sb.append(", use_userid=");
		sb.append(use_userid);
		sb.append(", use_datetime=");
		sb.append(use_datetime);
		sb.append(", np2_grosprm=");
		sb.append(np2_grosprm);
		sb.append(", np2_ageprem=");
		sb.append(np2_ageprem);
		sb.append(", np2_commendate=");
		sb.append(np2_commendate);
		sb.append(", np2_sumatrisk=");
		sb.append(np2_sumatrisk);
		sb.append(", np2_substandar=");
		sb.append(np2_substandar);
		sb.append(", np2_effectdate=");
		sb.append(np2_effectdate);
		sb.append(", np2_expirydate=");
		sb.append(np2_expirydate);
		sb.append(", np2_endofprmdt=");
		sb.append(np2_endofprmdt);
		sb.append(", np2_paidupamt=");
		sb.append(np2_paidupamt);
		sb.append(", np2_diffinprem=");
		sb.append(np2_diffinprem);
		sb.append(", np2_diffinfyco=");
		sb.append(np2_diffinfyco);
		sb.append(", np2_charges=");
		sb.append(np2_charges);
		sb.append(", np2_totload=");
		sb.append(np2_totload);
		sb.append(", np2_nextduedat=");
		sb.append(np2_nextduedat);
		sb.append(", np2_ageadmitt=");
		sb.append(np2_ageadmitt);
		sb.append(", np2_optimaindex=");
		sb.append(np2_optimaindex);
		sb.append(", np2_ageprem2nd=");
		sb.append(np2_ageprem2nd);
		sb.append(", np2_policyfees=");
		sb.append(np2_policyfees);
		sb.append(", np2_sar=");
		sb.append(np2_sar);
		sb.append(", np2_totpremium=");
		sb.append(np2_totpremium);
		sb.append(", np2_approved=");
		sb.append(np2_approved);
		sb.append(", np2_endorsementno=");
		sb.append(np2_endorsementno);
		sb.append(", pfs_acntyear=");
		sb.append(pfs_acntyear);
		sb.append(", arq_requestype=");
		sb.append(arq_requestype);
		sb.append(", arq_requestno=");
		sb.append(arq_requestno);
		sb.append(", np2_forfeitdat=");
		sb.append(np2_forfeitdat);
		sb.append(", convert=");
		sb.append(convert);
		sb.append(", np2_notionalage=");
		sb.append(np2_notionalage);
		sb.append(", cop_occupaticd=");
		sb.append(cop_occupaticd);
		sb.append(", np2_dob=");
		sb.append(np2_dob);
		sb.append(", np2_accr_proc=");
		sb.append(np2_accr_proc);
		sb.append(", np2_effectiveage=");
		sb.append(np2_effectiveage);
		sb.append(", np2_nom2ndlife=");
		sb.append(np2_nom2ndlife);
		sb.append(", np2_dob_2nd=");
		sb.append(np2_dob_2nd);
		sb.append(", np2_lastrevbonus=");
		sb.append(np2_lastrevbonus);
		sb.append(", np2_reversionary=");
		sb.append(np2_reversionary);
		sb.append(", np2_rider_bonus=");
		sb.append(np2_rider_bonus);
		sb.append(", np2_last_rider_bonus=");
		sb.append(np2_last_rider_bonus);
		sb.append(", np2_ageprem_actual=");
		sb.append(np2_ageprem_actual);
		sb.append(", np2_ageprem2nd_actual=");
		sb.append(np2_ageprem2nd_actual);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LNP2_PolicyMastr toEntityModel() {
		LNP2_PolicyMastrImpl lnp2_PolicyMastrImpl = new LNP2_PolicyMastrImpl();

		if (np1_proposal == null) {
			lnp2_PolicyMastrImpl.setNp1_proposal("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp1_proposal(np1_proposal);
		}

		if (np2_setno == null) {
			lnp2_PolicyMastrImpl.setNp2_setno("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_setno(np2_setno);
		}

		if (cfr_forfeitucd == null) {
			lnp2_PolicyMastrImpl.setCfr_forfeitucd("");
		}
		else {
			lnp2_PolicyMastrImpl.setCfr_forfeitucd(cfr_forfeitucd);
		}

		if (cmo_mode == null) {
			lnp2_PolicyMastrImpl.setCmo_mode("");
		}
		else {
			lnp2_PolicyMastrImpl.setCmo_mode(cmo_mode);
		}

		if (pcu_currcode == null) {
			lnp2_PolicyMastrImpl.setPcu_currcode("");
		}
		else {
			lnp2_PolicyMastrImpl.setPcu_currcode(pcu_currcode);
		}

		lnp2_PolicyMastrImpl.setAag_agcode(aag_agcode);

		if (ccl_categorycd == null) {
			lnp2_PolicyMastrImpl.setCcl_categorycd("");
		}
		else {
			lnp2_PolicyMastrImpl.setCcl_categorycd(ccl_categorycd);
		}

		if (use_userid == null) {
			lnp2_PolicyMastrImpl.setUse_userid("");
		}
		else {
			lnp2_PolicyMastrImpl.setUse_userid(use_userid);
		}

		if (use_datetime == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setUse_datetime(null);
		}
		else {
			lnp2_PolicyMastrImpl.setUse_datetime(new Date(use_datetime));
		}

		lnp2_PolicyMastrImpl.setNp2_grosprm(np2_grosprm);
		lnp2_PolicyMastrImpl.setNp2_ageprem(np2_ageprem);

		if (np2_commendate == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_commendate(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_commendate(new Date(np2_commendate));
		}

		lnp2_PolicyMastrImpl.setNp2_sumatrisk(np2_sumatrisk);

		if (np2_substandar == null) {
			lnp2_PolicyMastrImpl.setNp2_substandar("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_substandar(np2_substandar);
		}

		if (np2_effectdate == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_effectdate(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_effectdate(new Date(np2_effectdate));
		}

		if (np2_expirydate == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_expirydate(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_expirydate(new Date(np2_expirydate));
		}

		if (np2_endofprmdt == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_endofprmdt(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_endofprmdt(new Date(np2_endofprmdt));
		}

		lnp2_PolicyMastrImpl.setNp2_paidupamt(np2_paidupamt);
		lnp2_PolicyMastrImpl.setNp2_diffinprem(np2_diffinprem);
		lnp2_PolicyMastrImpl.setNp2_diffinfyco(np2_diffinfyco);
		lnp2_PolicyMastrImpl.setNp2_charges(np2_charges);
		lnp2_PolicyMastrImpl.setNp2_totload(np2_totload);

		if (np2_nextduedat == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_nextduedat(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_nextduedat(new Date(np2_nextduedat));
		}

		lnp2_PolicyMastrImpl.setNp2_ageadmitt(np2_ageadmitt);
		lnp2_PolicyMastrImpl.setNp2_optimaindex(np2_optimaindex);
		lnp2_PolicyMastrImpl.setNp2_ageprem2nd(np2_ageprem2nd);
		lnp2_PolicyMastrImpl.setNp2_policyfees(np2_policyfees);
		lnp2_PolicyMastrImpl.setNp2_sar(np2_sar);
		lnp2_PolicyMastrImpl.setNp2_totpremium(np2_totpremium);
		lnp2_PolicyMastrImpl.setNp2_approved(np2_approved);

		if (np2_endorsementno == null) {
			lnp2_PolicyMastrImpl.setNp2_endorsementno("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_endorsementno(np2_endorsementno);
		}

		if (pfs_acntyear == null) {
			lnp2_PolicyMastrImpl.setPfs_acntyear("");
		}
		else {
			lnp2_PolicyMastrImpl.setPfs_acntyear(pfs_acntyear);
		}

		if (arq_requestype == null) {
			lnp2_PolicyMastrImpl.setArq_requestype("");
		}
		else {
			lnp2_PolicyMastrImpl.setArq_requestype(arq_requestype);
		}

		lnp2_PolicyMastrImpl.setArq_requestno(arq_requestno);

		if (np2_forfeitdat == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_forfeitdat(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_forfeitdat(new Date(np2_forfeitdat));
		}

		lnp2_PolicyMastrImpl.setConvert(convert);
		lnp2_PolicyMastrImpl.setNp2_notionalage(np2_notionalage);

		if (cop_occupaticd == null) {
			lnp2_PolicyMastrImpl.setCop_occupaticd("");
		}
		else {
			lnp2_PolicyMastrImpl.setCop_occupaticd(cop_occupaticd);
		}

		if (np2_dob == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_dob(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_dob(new Date(np2_dob));
		}

		if (np2_accr_proc == null) {
			lnp2_PolicyMastrImpl.setNp2_accr_proc("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_accr_proc(np2_accr_proc);
		}

		lnp2_PolicyMastrImpl.setNp2_effectiveage(np2_effectiveage);

		if (np2_nom2ndlife == null) {
			lnp2_PolicyMastrImpl.setNp2_nom2ndlife("");
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_nom2ndlife(np2_nom2ndlife);
		}

		if (np2_dob_2nd == Long.MIN_VALUE) {
			lnp2_PolicyMastrImpl.setNp2_dob_2nd(null);
		}
		else {
			lnp2_PolicyMastrImpl.setNp2_dob_2nd(new Date(np2_dob_2nd));
		}

		lnp2_PolicyMastrImpl.setNp2_lastrevbonus(np2_lastrevbonus);
		lnp2_PolicyMastrImpl.setNp2_reversionary(np2_reversionary);
		lnp2_PolicyMastrImpl.setNp2_rider_bonus(np2_rider_bonus);
		lnp2_PolicyMastrImpl.setNp2_last_rider_bonus(np2_last_rider_bonus);
		lnp2_PolicyMastrImpl.setNp2_ageprem_actual(np2_ageprem_actual);
		lnp2_PolicyMastrImpl.setNp2_ageprem2nd_actual(np2_ageprem2nd_actual);

		lnp2_PolicyMastrImpl.resetOriginalValues();

		return lnp2_PolicyMastrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		np1_proposal = objectInput.readUTF();
		np2_setno = objectInput.readUTF();
		cfr_forfeitucd = objectInput.readUTF();
		cmo_mode = objectInput.readUTF();
		pcu_currcode = objectInput.readUTF();

		aag_agcode = objectInput.readLong();
		ccl_categorycd = objectInput.readUTF();
		use_userid = objectInput.readUTF();
		use_datetime = objectInput.readLong();

		np2_grosprm = objectInput.readLong();

		np2_ageprem = objectInput.readLong();
		np2_commendate = objectInput.readLong();

		np2_sumatrisk = objectInput.readLong();
		np2_substandar = objectInput.readUTF();
		np2_effectdate = objectInput.readLong();
		np2_expirydate = objectInput.readLong();
		np2_endofprmdt = objectInput.readLong();

		np2_paidupamt = objectInput.readLong();

		np2_diffinprem = objectInput.readLong();

		np2_diffinfyco = objectInput.readLong();

		np2_charges = objectInput.readLong();

		np2_totload = objectInput.readLong();
		np2_nextduedat = objectInput.readLong();

		np2_ageadmitt = objectInput.readLong();

		np2_optimaindex = objectInput.readLong();

		np2_ageprem2nd = objectInput.readLong();

		np2_policyfees = objectInput.readLong();

		np2_sar = objectInput.readLong();

		np2_totpremium = objectInput.readLong();

		np2_approved = objectInput.readLong();
		np2_endorsementno = objectInput.readUTF();
		pfs_acntyear = objectInput.readUTF();
		arq_requestype = objectInput.readUTF();

		arq_requestno = objectInput.readLong();
		np2_forfeitdat = objectInput.readLong();

		convert = objectInput.readLong();

		np2_notionalage = objectInput.readLong();
		cop_occupaticd = objectInput.readUTF();
		np2_dob = objectInput.readLong();
		np2_accr_proc = objectInput.readUTF();

		np2_effectiveage = objectInput.readLong();
		np2_nom2ndlife = objectInput.readUTF();
		np2_dob_2nd = objectInput.readLong();

		np2_lastrevbonus = objectInput.readLong();

		np2_reversionary = objectInput.readLong();

		np2_rider_bonus = objectInput.readLong();

		np2_last_rider_bonus = objectInput.readLong();

		np2_ageprem_actual = objectInput.readLong();

		np2_ageprem2nd_actual = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput) throws IOException {
		if (np1_proposal == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np1_proposal);
		}

		if (np2_setno == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np2_setno);
		}

		if (cfr_forfeitucd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cfr_forfeitucd);
		}

		if (cmo_mode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cmo_mode);
		}

		if (pcu_currcode == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pcu_currcode);
		}

		objectOutput.writeLong(aag_agcode);

		if (ccl_categorycd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(ccl_categorycd);
		}

		if (use_userid == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(use_userid);
		}

		objectOutput.writeLong(use_datetime);

		objectOutput.writeLong(np2_grosprm);

		objectOutput.writeLong(np2_ageprem);
		objectOutput.writeLong(np2_commendate);

		objectOutput.writeLong(np2_sumatrisk);

		if (np2_substandar == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np2_substandar);
		}

		objectOutput.writeLong(np2_effectdate);
		objectOutput.writeLong(np2_expirydate);
		objectOutput.writeLong(np2_endofprmdt);

		objectOutput.writeLong(np2_paidupamt);

		objectOutput.writeLong(np2_diffinprem);

		objectOutput.writeLong(np2_diffinfyco);

		objectOutput.writeLong(np2_charges);

		objectOutput.writeLong(np2_totload);
		objectOutput.writeLong(np2_nextduedat);

		objectOutput.writeLong(np2_ageadmitt);

		objectOutput.writeLong(np2_optimaindex);

		objectOutput.writeLong(np2_ageprem2nd);

		objectOutput.writeLong(np2_policyfees);

		objectOutput.writeLong(np2_sar);

		objectOutput.writeLong(np2_totpremium);

		objectOutput.writeLong(np2_approved);

		if (np2_endorsementno == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np2_endorsementno);
		}

		if (pfs_acntyear == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(pfs_acntyear);
		}

		if (arq_requestype == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(arq_requestype);
		}

		objectOutput.writeLong(arq_requestno);
		objectOutput.writeLong(np2_forfeitdat);

		objectOutput.writeLong(convert);

		objectOutput.writeLong(np2_notionalage);

		if (cop_occupaticd == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(cop_occupaticd);
		}

		objectOutput.writeLong(np2_dob);

		if (np2_accr_proc == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np2_accr_proc);
		}

		objectOutput.writeLong(np2_effectiveage);

		if (np2_nom2ndlife == null) {
			objectOutput.writeUTF("");
		}
		else {
			objectOutput.writeUTF(np2_nom2ndlife);
		}

		objectOutput.writeLong(np2_dob_2nd);

		objectOutput.writeLong(np2_lastrevbonus);

		objectOutput.writeLong(np2_reversionary);

		objectOutput.writeLong(np2_rider_bonus);

		objectOutput.writeLong(np2_last_rider_bonus);

		objectOutput.writeLong(np2_ageprem_actual);

		objectOutput.writeLong(np2_ageprem2nd_actual);
	}

	public String np1_proposal;
	public String np2_setno;
	public String cfr_forfeitucd;
	public String cmo_mode;
	public String pcu_currcode;
	public long aag_agcode;
	public String ccl_categorycd;
	public String use_userid;
	public long use_datetime;
	public long np2_grosprm;
	public long np2_ageprem;
	public long np2_commendate;
	public long np2_sumatrisk;
	public String np2_substandar;
	public long np2_effectdate;
	public long np2_expirydate;
	public long np2_endofprmdt;
	public long np2_paidupamt;
	public long np2_diffinprem;
	public long np2_diffinfyco;
	public long np2_charges;
	public long np2_totload;
	public long np2_nextduedat;
	public long np2_ageadmitt;
	public long np2_optimaindex;
	public long np2_ageprem2nd;
	public long np2_policyfees;
	public long np2_sar;
	public long np2_totpremium;
	public long np2_approved;
	public String np2_endorsementno;
	public String pfs_acntyear;
	public String arq_requestype;
	public long arq_requestno;
	public long np2_forfeitdat;
	public long convert;
	public long np2_notionalage;
	public String cop_occupaticd;
	public long np2_dob;
	public String np2_accr_proc;
	public long np2_effectiveage;
	public String np2_nom2ndlife;
	public long np2_dob_2nd;
	public long np2_lastrevbonus;
	public long np2_reversionary;
	public long np2_rider_bonus;
	public long np2_last_rider_bonus;
	public long np2_ageprem_actual;
	public long np2_ageprem2nd_actual;

}