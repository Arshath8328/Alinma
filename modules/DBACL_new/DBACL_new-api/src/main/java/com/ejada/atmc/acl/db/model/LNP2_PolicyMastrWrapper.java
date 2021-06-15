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

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.model.wrapper.BaseModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LNP2_PolicyMastr}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see LNP2_PolicyMastr
 * @generated
 */
public class LNP2_PolicyMastrWrapper
	extends BaseModelWrapper<LNP2_PolicyMastr>
	implements LNP2_PolicyMastr, ModelWrapper<LNP2_PolicyMastr> {

	public LNP2_PolicyMastrWrapper(LNP2_PolicyMastr lnp2_PolicyMastr) {
		super(lnp2_PolicyMastr);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("np1_proposal", getNp1_proposal());
		attributes.put("np2_setno", getNp2_setno());
		attributes.put("cfr_forfeitucd", getCfr_forfeitucd());
		attributes.put("cmo_mode", getCmo_mode());
		attributes.put("pcu_currcode", getPcu_currcode());
		attributes.put("aag_agcode", getAag_agcode());
		attributes.put("ccl_categorycd", getCcl_categorycd());
		attributes.put("use_userid", getUse_userid());
		attributes.put("use_datetime", getUse_datetime());
		attributes.put("np2_grosprm", getNp2_grosprm());
		attributes.put("np2_ageprem", getNp2_ageprem());
		attributes.put("np2_commendate", getNp2_commendate());
		attributes.put("np2_sumatrisk", getNp2_sumatrisk());
		attributes.put("np2_substandar", getNp2_substandar());
		attributes.put("np2_effectdate", getNp2_effectdate());
		attributes.put("np2_expirydate", getNp2_expirydate());
		attributes.put("np2_endofprmdt", getNp2_endofprmdt());
		attributes.put("np2_paidupamt", getNp2_paidupamt());
		attributes.put("np2_diffinprem", getNp2_diffinprem());
		attributes.put("np2_diffinfyco", getNp2_diffinfyco());
		attributes.put("np2_charges", getNp2_charges());
		attributes.put("np2_totload", getNp2_totload());
		attributes.put("np2_nextduedat", getNp2_nextduedat());
		attributes.put("np2_ageadmitt", getNp2_ageadmitt());
		attributes.put("np2_optimaindex", getNp2_optimaindex());
		attributes.put("np2_ageprem2nd", getNp2_ageprem2nd());
		attributes.put("np2_policyfees", getNp2_policyfees());
		attributes.put("np2_sar", getNp2_sar());
		attributes.put("np2_totpremium", getNp2_totpremium());
		attributes.put("np2_approved", getNp2_approved());
		attributes.put("np2_endorsementno", getNp2_endorsementno());
		attributes.put("pfs_acntyear", getPfs_acntyear());
		attributes.put("arq_requestype", getArq_requestype());
		attributes.put("arq_requestno", getArq_requestno());
		attributes.put("np2_forfeitdat", getNp2_forfeitdat());
		attributes.put("convert", getConvert());
		attributes.put("np2_notionalage", getNp2_notionalage());
		attributes.put("cop_occupaticd", getCop_occupaticd());
		attributes.put("np2_dob", getNp2_dob());
		attributes.put("np2_accr_proc", getNp2_accr_proc());
		attributes.put("np2_effectiveage", getNp2_effectiveage());
		attributes.put("np2_nom2ndlife", getNp2_nom2ndlife());
		attributes.put("np2_dob_2nd", getNp2_dob_2nd());
		attributes.put("np2_lastrevbonus", getNp2_lastrevbonus());
		attributes.put("np2_reversionary", getNp2_reversionary());
		attributes.put("np2_rider_bonus", getNp2_rider_bonus());
		attributes.put("np2_last_rider_bonus", getNp2_last_rider_bonus());
		attributes.put("np2_ageprem_actual", getNp2_ageprem_actual());
		attributes.put("np2_ageprem2nd_actual", getNp2_ageprem2nd_actual());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String np1_proposal = (String)attributes.get("np1_proposal");

		if (np1_proposal != null) {
			setNp1_proposal(np1_proposal);
		}

		String np2_setno = (String)attributes.get("np2_setno");

		if (np2_setno != null) {
			setNp2_setno(np2_setno);
		}

		String cfr_forfeitucd = (String)attributes.get("cfr_forfeitucd");

		if (cfr_forfeitucd != null) {
			setCfr_forfeitucd(cfr_forfeitucd);
		}

		String cmo_mode = (String)attributes.get("cmo_mode");

		if (cmo_mode != null) {
			setCmo_mode(cmo_mode);
		}

		String pcu_currcode = (String)attributes.get("pcu_currcode");

		if (pcu_currcode != null) {
			setPcu_currcode(pcu_currcode);
		}

		Long aag_agcode = (Long)attributes.get("aag_agcode");

		if (aag_agcode != null) {
			setAag_agcode(aag_agcode);
		}

		String ccl_categorycd = (String)attributes.get("ccl_categorycd");

		if (ccl_categorycd != null) {
			setCcl_categorycd(ccl_categorycd);
		}

		String use_userid = (String)attributes.get("use_userid");

		if (use_userid != null) {
			setUse_userid(use_userid);
		}

		Date use_datetime = (Date)attributes.get("use_datetime");

		if (use_datetime != null) {
			setUse_datetime(use_datetime);
		}

		Long np2_grosprm = (Long)attributes.get("np2_grosprm");

		if (np2_grosprm != null) {
			setNp2_grosprm(np2_grosprm);
		}

		Long np2_ageprem = (Long)attributes.get("np2_ageprem");

		if (np2_ageprem != null) {
			setNp2_ageprem(np2_ageprem);
		}

		Date np2_commendate = (Date)attributes.get("np2_commendate");

		if (np2_commendate != null) {
			setNp2_commendate(np2_commendate);
		}

		Long np2_sumatrisk = (Long)attributes.get("np2_sumatrisk");

		if (np2_sumatrisk != null) {
			setNp2_sumatrisk(np2_sumatrisk);
		}

		String np2_substandar = (String)attributes.get("np2_substandar");

		if (np2_substandar != null) {
			setNp2_substandar(np2_substandar);
		}

		Date np2_effectdate = (Date)attributes.get("np2_effectdate");

		if (np2_effectdate != null) {
			setNp2_effectdate(np2_effectdate);
		}

		Date np2_expirydate = (Date)attributes.get("np2_expirydate");

		if (np2_expirydate != null) {
			setNp2_expirydate(np2_expirydate);
		}

		Date np2_endofprmdt = (Date)attributes.get("np2_endofprmdt");

		if (np2_endofprmdt != null) {
			setNp2_endofprmdt(np2_endofprmdt);
		}

		Long np2_paidupamt = (Long)attributes.get("np2_paidupamt");

		if (np2_paidupamt != null) {
			setNp2_paidupamt(np2_paidupamt);
		}

		Long np2_diffinprem = (Long)attributes.get("np2_diffinprem");

		if (np2_diffinprem != null) {
			setNp2_diffinprem(np2_diffinprem);
		}

		Long np2_diffinfyco = (Long)attributes.get("np2_diffinfyco");

		if (np2_diffinfyco != null) {
			setNp2_diffinfyco(np2_diffinfyco);
		}

		Long np2_charges = (Long)attributes.get("np2_charges");

		if (np2_charges != null) {
			setNp2_charges(np2_charges);
		}

		Long np2_totload = (Long)attributes.get("np2_totload");

		if (np2_totload != null) {
			setNp2_totload(np2_totload);
		}

		Date np2_nextduedat = (Date)attributes.get("np2_nextduedat");

		if (np2_nextduedat != null) {
			setNp2_nextduedat(np2_nextduedat);
		}

		Long np2_ageadmitt = (Long)attributes.get("np2_ageadmitt");

		if (np2_ageadmitt != null) {
			setNp2_ageadmitt(np2_ageadmitt);
		}

		Long np2_optimaindex = (Long)attributes.get("np2_optimaindex");

		if (np2_optimaindex != null) {
			setNp2_optimaindex(np2_optimaindex);
		}

		Long np2_ageprem2nd = (Long)attributes.get("np2_ageprem2nd");

		if (np2_ageprem2nd != null) {
			setNp2_ageprem2nd(np2_ageprem2nd);
		}

		Long np2_policyfees = (Long)attributes.get("np2_policyfees");

		if (np2_policyfees != null) {
			setNp2_policyfees(np2_policyfees);
		}

		Long np2_sar = (Long)attributes.get("np2_sar");

		if (np2_sar != null) {
			setNp2_sar(np2_sar);
		}

		Long np2_totpremium = (Long)attributes.get("np2_totpremium");

		if (np2_totpremium != null) {
			setNp2_totpremium(np2_totpremium);
		}

		Long np2_approved = (Long)attributes.get("np2_approved");

		if (np2_approved != null) {
			setNp2_approved(np2_approved);
		}

		String np2_endorsementno = (String)attributes.get("np2_endorsementno");

		if (np2_endorsementno != null) {
			setNp2_endorsementno(np2_endorsementno);
		}

		String pfs_acntyear = (String)attributes.get("pfs_acntyear");

		if (pfs_acntyear != null) {
			setPfs_acntyear(pfs_acntyear);
		}

		String arq_requestype = (String)attributes.get("arq_requestype");

		if (arq_requestype != null) {
			setArq_requestype(arq_requestype);
		}

		Long arq_requestno = (Long)attributes.get("arq_requestno");

		if (arq_requestno != null) {
			setArq_requestno(arq_requestno);
		}

		Date np2_forfeitdat = (Date)attributes.get("np2_forfeitdat");

		if (np2_forfeitdat != null) {
			setNp2_forfeitdat(np2_forfeitdat);
		}

		Long convert = (Long)attributes.get("convert");

		if (convert != null) {
			setConvert(convert);
		}

		Long np2_notionalage = (Long)attributes.get("np2_notionalage");

		if (np2_notionalage != null) {
			setNp2_notionalage(np2_notionalage);
		}

		String cop_occupaticd = (String)attributes.get("cop_occupaticd");

		if (cop_occupaticd != null) {
			setCop_occupaticd(cop_occupaticd);
		}

		Date np2_dob = (Date)attributes.get("np2_dob");

		if (np2_dob != null) {
			setNp2_dob(np2_dob);
		}

		String np2_accr_proc = (String)attributes.get("np2_accr_proc");

		if (np2_accr_proc != null) {
			setNp2_accr_proc(np2_accr_proc);
		}

		Long np2_effectiveage = (Long)attributes.get("np2_effectiveage");

		if (np2_effectiveage != null) {
			setNp2_effectiveage(np2_effectiveage);
		}

		String np2_nom2ndlife = (String)attributes.get("np2_nom2ndlife");

		if (np2_nom2ndlife != null) {
			setNp2_nom2ndlife(np2_nom2ndlife);
		}

		Date np2_dob_2nd = (Date)attributes.get("np2_dob_2nd");

		if (np2_dob_2nd != null) {
			setNp2_dob_2nd(np2_dob_2nd);
		}

		Long np2_lastrevbonus = (Long)attributes.get("np2_lastrevbonus");

		if (np2_lastrevbonus != null) {
			setNp2_lastrevbonus(np2_lastrevbonus);
		}

		Long np2_reversionary = (Long)attributes.get("np2_reversionary");

		if (np2_reversionary != null) {
			setNp2_reversionary(np2_reversionary);
		}

		Long np2_rider_bonus = (Long)attributes.get("np2_rider_bonus");

		if (np2_rider_bonus != null) {
			setNp2_rider_bonus(np2_rider_bonus);
		}

		Long np2_last_rider_bonus = (Long)attributes.get(
			"np2_last_rider_bonus");

		if (np2_last_rider_bonus != null) {
			setNp2_last_rider_bonus(np2_last_rider_bonus);
		}

		Long np2_ageprem_actual = (Long)attributes.get("np2_ageprem_actual");

		if (np2_ageprem_actual != null) {
			setNp2_ageprem_actual(np2_ageprem_actual);
		}

		Long np2_ageprem2nd_actual = (Long)attributes.get(
			"np2_ageprem2nd_actual");

		if (np2_ageprem2nd_actual != null) {
			setNp2_ageprem2nd_actual(np2_ageprem2nd_actual);
		}
	}

	/**
	 * Returns the aag_agcode of this lnp2_ policy mastr.
	 *
	 * @return the aag_agcode of this lnp2_ policy mastr
	 */
	@Override
	public long getAag_agcode() {
		return model.getAag_agcode();
	}

	/**
	 * Returns the arq_requestno of this lnp2_ policy mastr.
	 *
	 * @return the arq_requestno of this lnp2_ policy mastr
	 */
	@Override
	public long getArq_requestno() {
		return model.getArq_requestno();
	}

	/**
	 * Returns the arq_requestype of this lnp2_ policy mastr.
	 *
	 * @return the arq_requestype of this lnp2_ policy mastr
	 */
	@Override
	public String getArq_requestype() {
		return model.getArq_requestype();
	}

	/**
	 * Returns the ccl_categorycd of this lnp2_ policy mastr.
	 *
	 * @return the ccl_categorycd of this lnp2_ policy mastr
	 */
	@Override
	public String getCcl_categorycd() {
		return model.getCcl_categorycd();
	}

	/**
	 * Returns the cfr_forfeitucd of this lnp2_ policy mastr.
	 *
	 * @return the cfr_forfeitucd of this lnp2_ policy mastr
	 */
	@Override
	public String getCfr_forfeitucd() {
		return model.getCfr_forfeitucd();
	}

	/**
	 * Returns the cmo_mode of this lnp2_ policy mastr.
	 *
	 * @return the cmo_mode of this lnp2_ policy mastr
	 */
	@Override
	public String getCmo_mode() {
		return model.getCmo_mode();
	}

	/**
	 * Returns the convert of this lnp2_ policy mastr.
	 *
	 * @return the convert of this lnp2_ policy mastr
	 */
	@Override
	public long getConvert() {
		return model.getConvert();
	}

	/**
	 * Returns the cop_occupaticd of this lnp2_ policy mastr.
	 *
	 * @return the cop_occupaticd of this lnp2_ policy mastr
	 */
	@Override
	public String getCop_occupaticd() {
		return model.getCop_occupaticd();
	}

	/**
	 * Returns the np1_proposal of this lnp2_ policy mastr.
	 *
	 * @return the np1_proposal of this lnp2_ policy mastr
	 */
	@Override
	public String getNp1_proposal() {
		return model.getNp1_proposal();
	}

	/**
	 * Returns the np2_accr_proc of this lnp2_ policy mastr.
	 *
	 * @return the np2_accr_proc of this lnp2_ policy mastr
	 */
	@Override
	public String getNp2_accr_proc() {
		return model.getNp2_accr_proc();
	}

	/**
	 * Returns the np2_ageadmitt of this lnp2_ policy mastr.
	 *
	 * @return the np2_ageadmitt of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_ageadmitt() {
		return model.getNp2_ageadmitt();
	}

	/**
	 * Returns the np2_ageprem of this lnp2_ policy mastr.
	 *
	 * @return the np2_ageprem of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_ageprem() {
		return model.getNp2_ageprem();
	}

	/**
	 * Returns the np2_ageprem2nd of this lnp2_ policy mastr.
	 *
	 * @return the np2_ageprem2nd of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_ageprem2nd() {
		return model.getNp2_ageprem2nd();
	}

	/**
	 * Returns the np2_ageprem2nd_actual of this lnp2_ policy mastr.
	 *
	 * @return the np2_ageprem2nd_actual of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_ageprem2nd_actual() {
		return model.getNp2_ageprem2nd_actual();
	}

	/**
	 * Returns the np2_ageprem_actual of this lnp2_ policy mastr.
	 *
	 * @return the np2_ageprem_actual of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_ageprem_actual() {
		return model.getNp2_ageprem_actual();
	}

	/**
	 * Returns the np2_approved of this lnp2_ policy mastr.
	 *
	 * @return the np2_approved of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_approved() {
		return model.getNp2_approved();
	}

	/**
	 * Returns the np2_charges of this lnp2_ policy mastr.
	 *
	 * @return the np2_charges of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_charges() {
		return model.getNp2_charges();
	}

	/**
	 * Returns the np2_commendate of this lnp2_ policy mastr.
	 *
	 * @return the np2_commendate of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_commendate() {
		return model.getNp2_commendate();
	}

	/**
	 * Returns the np2_diffinfyco of this lnp2_ policy mastr.
	 *
	 * @return the np2_diffinfyco of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_diffinfyco() {
		return model.getNp2_diffinfyco();
	}

	/**
	 * Returns the np2_diffinprem of this lnp2_ policy mastr.
	 *
	 * @return the np2_diffinprem of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_diffinprem() {
		return model.getNp2_diffinprem();
	}

	/**
	 * Returns the np2_dob of this lnp2_ policy mastr.
	 *
	 * @return the np2_dob of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_dob() {
		return model.getNp2_dob();
	}

	/**
	 * Returns the np2_dob_2nd of this lnp2_ policy mastr.
	 *
	 * @return the np2_dob_2nd of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_dob_2nd() {
		return model.getNp2_dob_2nd();
	}

	/**
	 * Returns the np2_effectdate of this lnp2_ policy mastr.
	 *
	 * @return the np2_effectdate of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_effectdate() {
		return model.getNp2_effectdate();
	}

	/**
	 * Returns the np2_effectiveage of this lnp2_ policy mastr.
	 *
	 * @return the np2_effectiveage of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_effectiveage() {
		return model.getNp2_effectiveage();
	}

	/**
	 * Returns the np2_endofprmdt of this lnp2_ policy mastr.
	 *
	 * @return the np2_endofprmdt of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_endofprmdt() {
		return model.getNp2_endofprmdt();
	}

	/**
	 * Returns the np2_endorsementno of this lnp2_ policy mastr.
	 *
	 * @return the np2_endorsementno of this lnp2_ policy mastr
	 */
	@Override
	public String getNp2_endorsementno() {
		return model.getNp2_endorsementno();
	}

	/**
	 * Returns the np2_expirydate of this lnp2_ policy mastr.
	 *
	 * @return the np2_expirydate of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_expirydate() {
		return model.getNp2_expirydate();
	}

	/**
	 * Returns the np2_forfeitdat of this lnp2_ policy mastr.
	 *
	 * @return the np2_forfeitdat of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_forfeitdat() {
		return model.getNp2_forfeitdat();
	}

	/**
	 * Returns the np2_grosprm of this lnp2_ policy mastr.
	 *
	 * @return the np2_grosprm of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_grosprm() {
		return model.getNp2_grosprm();
	}

	/**
	 * Returns the np2_last_rider_bonus of this lnp2_ policy mastr.
	 *
	 * @return the np2_last_rider_bonus of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_last_rider_bonus() {
		return model.getNp2_last_rider_bonus();
	}

	/**
	 * Returns the np2_lastrevbonus of this lnp2_ policy mastr.
	 *
	 * @return the np2_lastrevbonus of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_lastrevbonus() {
		return model.getNp2_lastrevbonus();
	}

	/**
	 * Returns the np2_nextduedat of this lnp2_ policy mastr.
	 *
	 * @return the np2_nextduedat of this lnp2_ policy mastr
	 */
	@Override
	public Date getNp2_nextduedat() {
		return model.getNp2_nextduedat();
	}

	/**
	 * Returns the np2_nom2ndlife of this lnp2_ policy mastr.
	 *
	 * @return the np2_nom2ndlife of this lnp2_ policy mastr
	 */
	@Override
	public String getNp2_nom2ndlife() {
		return model.getNp2_nom2ndlife();
	}

	/**
	 * Returns the np2_notionalage of this lnp2_ policy mastr.
	 *
	 * @return the np2_notionalage of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_notionalage() {
		return model.getNp2_notionalage();
	}

	/**
	 * Returns the np2_optimaindex of this lnp2_ policy mastr.
	 *
	 * @return the np2_optimaindex of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_optimaindex() {
		return model.getNp2_optimaindex();
	}

	/**
	 * Returns the np2_paidupamt of this lnp2_ policy mastr.
	 *
	 * @return the np2_paidupamt of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_paidupamt() {
		return model.getNp2_paidupamt();
	}

	/**
	 * Returns the np2_policyfees of this lnp2_ policy mastr.
	 *
	 * @return the np2_policyfees of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_policyfees() {
		return model.getNp2_policyfees();
	}

	/**
	 * Returns the np2_reversionary of this lnp2_ policy mastr.
	 *
	 * @return the np2_reversionary of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_reversionary() {
		return model.getNp2_reversionary();
	}

	/**
	 * Returns the np2_rider_bonus of this lnp2_ policy mastr.
	 *
	 * @return the np2_rider_bonus of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_rider_bonus() {
		return model.getNp2_rider_bonus();
	}

	/**
	 * Returns the np2_sar of this lnp2_ policy mastr.
	 *
	 * @return the np2_sar of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_sar() {
		return model.getNp2_sar();
	}

	/**
	 * Returns the np2_setno of this lnp2_ policy mastr.
	 *
	 * @return the np2_setno of this lnp2_ policy mastr
	 */
	@Override
	public String getNp2_setno() {
		return model.getNp2_setno();
	}

	/**
	 * Returns the np2_substandar of this lnp2_ policy mastr.
	 *
	 * @return the np2_substandar of this lnp2_ policy mastr
	 */
	@Override
	public String getNp2_substandar() {
		return model.getNp2_substandar();
	}

	/**
	 * Returns the np2_sumatrisk of this lnp2_ policy mastr.
	 *
	 * @return the np2_sumatrisk of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_sumatrisk() {
		return model.getNp2_sumatrisk();
	}

	/**
	 * Returns the np2_totload of this lnp2_ policy mastr.
	 *
	 * @return the np2_totload of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_totload() {
		return model.getNp2_totload();
	}

	/**
	 * Returns the np2_totpremium of this lnp2_ policy mastr.
	 *
	 * @return the np2_totpremium of this lnp2_ policy mastr
	 */
	@Override
	public long getNp2_totpremium() {
		return model.getNp2_totpremium();
	}

	/**
	 * Returns the pcu_currcode of this lnp2_ policy mastr.
	 *
	 * @return the pcu_currcode of this lnp2_ policy mastr
	 */
	@Override
	public String getPcu_currcode() {
		return model.getPcu_currcode();
	}

	/**
	 * Returns the pfs_acntyear of this lnp2_ policy mastr.
	 *
	 * @return the pfs_acntyear of this lnp2_ policy mastr
	 */
	@Override
	public String getPfs_acntyear() {
		return model.getPfs_acntyear();
	}

	/**
	 * Returns the primary key of this lnp2_ policy mastr.
	 *
	 * @return the primary key of this lnp2_ policy mastr
	 */
	@Override
	public String getPrimaryKey() {
		return model.getPrimaryKey();
	}

	/**
	 * Returns the use_datetime of this lnp2_ policy mastr.
	 *
	 * @return the use_datetime of this lnp2_ policy mastr
	 */
	@Override
	public Date getUse_datetime() {
		return model.getUse_datetime();
	}

	/**
	 * Returns the use_userid of this lnp2_ policy mastr.
	 *
	 * @return the use_userid of this lnp2_ policy mastr
	 */
	@Override
	public String getUse_userid() {
		return model.getUse_userid();
	}

	@Override
	public void persist() {
		model.persist();
	}

	/**
	 * Sets the aag_agcode of this lnp2_ policy mastr.
	 *
	 * @param aag_agcode the aag_agcode of this lnp2_ policy mastr
	 */
	@Override
	public void setAag_agcode(long aag_agcode) {
		model.setAag_agcode(aag_agcode);
	}

	/**
	 * Sets the arq_requestno of this lnp2_ policy mastr.
	 *
	 * @param arq_requestno the arq_requestno of this lnp2_ policy mastr
	 */
	@Override
	public void setArq_requestno(long arq_requestno) {
		model.setArq_requestno(arq_requestno);
	}

	/**
	 * Sets the arq_requestype of this lnp2_ policy mastr.
	 *
	 * @param arq_requestype the arq_requestype of this lnp2_ policy mastr
	 */
	@Override
	public void setArq_requestype(String arq_requestype) {
		model.setArq_requestype(arq_requestype);
	}

	/**
	 * Sets the ccl_categorycd of this lnp2_ policy mastr.
	 *
	 * @param ccl_categorycd the ccl_categorycd of this lnp2_ policy mastr
	 */
	@Override
	public void setCcl_categorycd(String ccl_categorycd) {
		model.setCcl_categorycd(ccl_categorycd);
	}

	/**
	 * Sets the cfr_forfeitucd of this lnp2_ policy mastr.
	 *
	 * @param cfr_forfeitucd the cfr_forfeitucd of this lnp2_ policy mastr
	 */
	@Override
	public void setCfr_forfeitucd(String cfr_forfeitucd) {
		model.setCfr_forfeitucd(cfr_forfeitucd);
	}

	/**
	 * Sets the cmo_mode of this lnp2_ policy mastr.
	 *
	 * @param cmo_mode the cmo_mode of this lnp2_ policy mastr
	 */
	@Override
	public void setCmo_mode(String cmo_mode) {
		model.setCmo_mode(cmo_mode);
	}

	/**
	 * Sets the convert of this lnp2_ policy mastr.
	 *
	 * @param convert the convert of this lnp2_ policy mastr
	 */
	@Override
	public void setConvert(long convert) {
		model.setConvert(convert);
	}

	/**
	 * Sets the cop_occupaticd of this lnp2_ policy mastr.
	 *
	 * @param cop_occupaticd the cop_occupaticd of this lnp2_ policy mastr
	 */
	@Override
	public void setCop_occupaticd(String cop_occupaticd) {
		model.setCop_occupaticd(cop_occupaticd);
	}

	/**
	 * Sets the np1_proposal of this lnp2_ policy mastr.
	 *
	 * @param np1_proposal the np1_proposal of this lnp2_ policy mastr
	 */
	@Override
	public void setNp1_proposal(String np1_proposal) {
		model.setNp1_proposal(np1_proposal);
	}

	/**
	 * Sets the np2_accr_proc of this lnp2_ policy mastr.
	 *
	 * @param np2_accr_proc the np2_accr_proc of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_accr_proc(String np2_accr_proc) {
		model.setNp2_accr_proc(np2_accr_proc);
	}

	/**
	 * Sets the np2_ageadmitt of this lnp2_ policy mastr.
	 *
	 * @param np2_ageadmitt the np2_ageadmitt of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_ageadmitt(long np2_ageadmitt) {
		model.setNp2_ageadmitt(np2_ageadmitt);
	}

	/**
	 * Sets the np2_ageprem of this lnp2_ policy mastr.
	 *
	 * @param np2_ageprem the np2_ageprem of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_ageprem(long np2_ageprem) {
		model.setNp2_ageprem(np2_ageprem);
	}

	/**
	 * Sets the np2_ageprem2nd of this lnp2_ policy mastr.
	 *
	 * @param np2_ageprem2nd the np2_ageprem2nd of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_ageprem2nd(long np2_ageprem2nd) {
		model.setNp2_ageprem2nd(np2_ageprem2nd);
	}

	/**
	 * Sets the np2_ageprem2nd_actual of this lnp2_ policy mastr.
	 *
	 * @param np2_ageprem2nd_actual the np2_ageprem2nd_actual of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_ageprem2nd_actual(long np2_ageprem2nd_actual) {
		model.setNp2_ageprem2nd_actual(np2_ageprem2nd_actual);
	}

	/**
	 * Sets the np2_ageprem_actual of this lnp2_ policy mastr.
	 *
	 * @param np2_ageprem_actual the np2_ageprem_actual of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_ageprem_actual(long np2_ageprem_actual) {
		model.setNp2_ageprem_actual(np2_ageprem_actual);
	}

	/**
	 * Sets the np2_approved of this lnp2_ policy mastr.
	 *
	 * @param np2_approved the np2_approved of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_approved(long np2_approved) {
		model.setNp2_approved(np2_approved);
	}

	/**
	 * Sets the np2_charges of this lnp2_ policy mastr.
	 *
	 * @param np2_charges the np2_charges of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_charges(long np2_charges) {
		model.setNp2_charges(np2_charges);
	}

	/**
	 * Sets the np2_commendate of this lnp2_ policy mastr.
	 *
	 * @param np2_commendate the np2_commendate of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_commendate(Date np2_commendate) {
		model.setNp2_commendate(np2_commendate);
	}

	/**
	 * Sets the np2_diffinfyco of this lnp2_ policy mastr.
	 *
	 * @param np2_diffinfyco the np2_diffinfyco of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_diffinfyco(long np2_diffinfyco) {
		model.setNp2_diffinfyco(np2_diffinfyco);
	}

	/**
	 * Sets the np2_diffinprem of this lnp2_ policy mastr.
	 *
	 * @param np2_diffinprem the np2_diffinprem of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_diffinprem(long np2_diffinprem) {
		model.setNp2_diffinprem(np2_diffinprem);
	}

	/**
	 * Sets the np2_dob of this lnp2_ policy mastr.
	 *
	 * @param np2_dob the np2_dob of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_dob(Date np2_dob) {
		model.setNp2_dob(np2_dob);
	}

	/**
	 * Sets the np2_dob_2nd of this lnp2_ policy mastr.
	 *
	 * @param np2_dob_2nd the np2_dob_2nd of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_dob_2nd(Date np2_dob_2nd) {
		model.setNp2_dob_2nd(np2_dob_2nd);
	}

	/**
	 * Sets the np2_effectdate of this lnp2_ policy mastr.
	 *
	 * @param np2_effectdate the np2_effectdate of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_effectdate(Date np2_effectdate) {
		model.setNp2_effectdate(np2_effectdate);
	}

	/**
	 * Sets the np2_effectiveage of this lnp2_ policy mastr.
	 *
	 * @param np2_effectiveage the np2_effectiveage of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_effectiveage(long np2_effectiveage) {
		model.setNp2_effectiveage(np2_effectiveage);
	}

	/**
	 * Sets the np2_endofprmdt of this lnp2_ policy mastr.
	 *
	 * @param np2_endofprmdt the np2_endofprmdt of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_endofprmdt(Date np2_endofprmdt) {
		model.setNp2_endofprmdt(np2_endofprmdt);
	}

	/**
	 * Sets the np2_endorsementno of this lnp2_ policy mastr.
	 *
	 * @param np2_endorsementno the np2_endorsementno of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_endorsementno(String np2_endorsementno) {
		model.setNp2_endorsementno(np2_endorsementno);
	}

	/**
	 * Sets the np2_expirydate of this lnp2_ policy mastr.
	 *
	 * @param np2_expirydate the np2_expirydate of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_expirydate(Date np2_expirydate) {
		model.setNp2_expirydate(np2_expirydate);
	}

	/**
	 * Sets the np2_forfeitdat of this lnp2_ policy mastr.
	 *
	 * @param np2_forfeitdat the np2_forfeitdat of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_forfeitdat(Date np2_forfeitdat) {
		model.setNp2_forfeitdat(np2_forfeitdat);
	}

	/**
	 * Sets the np2_grosprm of this lnp2_ policy mastr.
	 *
	 * @param np2_grosprm the np2_grosprm of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_grosprm(long np2_grosprm) {
		model.setNp2_grosprm(np2_grosprm);
	}

	/**
	 * Sets the np2_last_rider_bonus of this lnp2_ policy mastr.
	 *
	 * @param np2_last_rider_bonus the np2_last_rider_bonus of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_last_rider_bonus(long np2_last_rider_bonus) {
		model.setNp2_last_rider_bonus(np2_last_rider_bonus);
	}

	/**
	 * Sets the np2_lastrevbonus of this lnp2_ policy mastr.
	 *
	 * @param np2_lastrevbonus the np2_lastrevbonus of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_lastrevbonus(long np2_lastrevbonus) {
		model.setNp2_lastrevbonus(np2_lastrevbonus);
	}

	/**
	 * Sets the np2_nextduedat of this lnp2_ policy mastr.
	 *
	 * @param np2_nextduedat the np2_nextduedat of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_nextduedat(Date np2_nextduedat) {
		model.setNp2_nextduedat(np2_nextduedat);
	}

	/**
	 * Sets the np2_nom2ndlife of this lnp2_ policy mastr.
	 *
	 * @param np2_nom2ndlife the np2_nom2ndlife of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_nom2ndlife(String np2_nom2ndlife) {
		model.setNp2_nom2ndlife(np2_nom2ndlife);
	}

	/**
	 * Sets the np2_notionalage of this lnp2_ policy mastr.
	 *
	 * @param np2_notionalage the np2_notionalage of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_notionalage(long np2_notionalage) {
		model.setNp2_notionalage(np2_notionalage);
	}

	/**
	 * Sets the np2_optimaindex of this lnp2_ policy mastr.
	 *
	 * @param np2_optimaindex the np2_optimaindex of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_optimaindex(long np2_optimaindex) {
		model.setNp2_optimaindex(np2_optimaindex);
	}

	/**
	 * Sets the np2_paidupamt of this lnp2_ policy mastr.
	 *
	 * @param np2_paidupamt the np2_paidupamt of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_paidupamt(long np2_paidupamt) {
		model.setNp2_paidupamt(np2_paidupamt);
	}

	/**
	 * Sets the np2_policyfees of this lnp2_ policy mastr.
	 *
	 * @param np2_policyfees the np2_policyfees of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_policyfees(long np2_policyfees) {
		model.setNp2_policyfees(np2_policyfees);
	}

	/**
	 * Sets the np2_reversionary of this lnp2_ policy mastr.
	 *
	 * @param np2_reversionary the np2_reversionary of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_reversionary(long np2_reversionary) {
		model.setNp2_reversionary(np2_reversionary);
	}

	/**
	 * Sets the np2_rider_bonus of this lnp2_ policy mastr.
	 *
	 * @param np2_rider_bonus the np2_rider_bonus of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_rider_bonus(long np2_rider_bonus) {
		model.setNp2_rider_bonus(np2_rider_bonus);
	}

	/**
	 * Sets the np2_sar of this lnp2_ policy mastr.
	 *
	 * @param np2_sar the np2_sar of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_sar(long np2_sar) {
		model.setNp2_sar(np2_sar);
	}

	/**
	 * Sets the np2_setno of this lnp2_ policy mastr.
	 *
	 * @param np2_setno the np2_setno of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_setno(String np2_setno) {
		model.setNp2_setno(np2_setno);
	}

	/**
	 * Sets the np2_substandar of this lnp2_ policy mastr.
	 *
	 * @param np2_substandar the np2_substandar of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_substandar(String np2_substandar) {
		model.setNp2_substandar(np2_substandar);
	}

	/**
	 * Sets the np2_sumatrisk of this lnp2_ policy mastr.
	 *
	 * @param np2_sumatrisk the np2_sumatrisk of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_sumatrisk(long np2_sumatrisk) {
		model.setNp2_sumatrisk(np2_sumatrisk);
	}

	/**
	 * Sets the np2_totload of this lnp2_ policy mastr.
	 *
	 * @param np2_totload the np2_totload of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_totload(long np2_totload) {
		model.setNp2_totload(np2_totload);
	}

	/**
	 * Sets the np2_totpremium of this lnp2_ policy mastr.
	 *
	 * @param np2_totpremium the np2_totpremium of this lnp2_ policy mastr
	 */
	@Override
	public void setNp2_totpremium(long np2_totpremium) {
		model.setNp2_totpremium(np2_totpremium);
	}

	/**
	 * Sets the pcu_currcode of this lnp2_ policy mastr.
	 *
	 * @param pcu_currcode the pcu_currcode of this lnp2_ policy mastr
	 */
	@Override
	public void setPcu_currcode(String pcu_currcode) {
		model.setPcu_currcode(pcu_currcode);
	}

	/**
	 * Sets the pfs_acntyear of this lnp2_ policy mastr.
	 *
	 * @param pfs_acntyear the pfs_acntyear of this lnp2_ policy mastr
	 */
	@Override
	public void setPfs_acntyear(String pfs_acntyear) {
		model.setPfs_acntyear(pfs_acntyear);
	}

	/**
	 * Sets the primary key of this lnp2_ policy mastr.
	 *
	 * @param primaryKey the primary key of this lnp2_ policy mastr
	 */
	@Override
	public void setPrimaryKey(String primaryKey) {
		model.setPrimaryKey(primaryKey);
	}

	/**
	 * Sets the use_datetime of this lnp2_ policy mastr.
	 *
	 * @param use_datetime the use_datetime of this lnp2_ policy mastr
	 */
	@Override
	public void setUse_datetime(Date use_datetime) {
		model.setUse_datetime(use_datetime);
	}

	/**
	 * Sets the use_userid of this lnp2_ policy mastr.
	 *
	 * @param use_userid the use_userid of this lnp2_ policy mastr
	 */
	@Override
	public void setUse_userid(String use_userid) {
		model.setUse_userid(use_userid);
	}

	@Override
	protected LNP2_PolicyMastrWrapper wrap(LNP2_PolicyMastr lnp2_PolicyMastr) {
		return new LNP2_PolicyMastrWrapper(lnp2_PolicyMastr);
	}

}