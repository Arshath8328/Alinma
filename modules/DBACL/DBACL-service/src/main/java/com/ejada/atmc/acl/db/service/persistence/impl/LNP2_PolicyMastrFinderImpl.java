package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.custom.model.PSBeneficiaryDetail;
import com.ejada.atmc.acl.db.custom.model.PSCoverageDetail;
import com.ejada.atmc.acl.db.custom.model.PSFundDetail;
import com.ejada.atmc.acl.db.custom.model.PSPolicy;
import com.ejada.atmc.acl.db.custom.model.PSPolicyDetail;
import com.ejada.atmc.acl.db.custom.model.PSPremiumDetail;
import com.ejada.atmc.acl.db.custom.model.PSStatementAccount;
import com.ejada.atmc.acl.db.custom.model.SOADetail;
import com.ejada.atmc.acl.db.service.persistence.LNP2_PolicyMastrFinder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = LNP2_PolicyMastrFinder.class
)
public class LNP2_PolicyMastrFinderImpl extends LNP2_PolicyMastrFinderBaseImpl implements LNP2_PolicyMastrFinder {

	public static final Log	LOG											= LogFactoryUtil.getLog(LNP2_PolicyMastrFinderImpl.class);
	SimpleDateFormat		dateFormat									= new SimpleDateFormat("dd/MMM/yyyy");
	private final String	FIND_PS_POLICY_BY_ID						= "select lnp1.np1_proposal Proposal_No, lnp1.cst_statuscd Policy_Status, lnph.nph_code Client_Code, lnph.nph_fullname Client_Name, (select lcst.cst_descr from lcst_ppstatus@ILAS lcst where lcst.cst_statuscd = lnp1.cst_statuscd) Status_Description, lnp1.np1_issuedate Issue_Date, lnp2.np2_commendate Policy_Start_Date, lnpr.npr_maturitydate Policy_Expiry_Date  from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnu1_underwriti@ILAS lnu1, lnph_pholder@ILAS lnph,  lnpr_product@ILAS lnpr where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np1_proposal = lnu1.np1_proposal and lnp2.Np2_Setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnpr.np1_proposal and lnp2.np2_setno = lnpr.np2_setno and lnpr.npr_basicflag = 'Y' and lnu1.nph_code = lnph.nph_code and lnu1.nu1_life = 'F' and lnph.NPH_IDNO=?";
//	private final String FIND_PS_POLICY_DETAILS_BY_ID = "select lnp1.np1_proposal, sysdate Statement_Date, (select lnph.nph_fullname from lnph_pholder@ILAS lnph where lnph.nph_code = lnu1.nph_code) Policy_Holder, lnad.nad_email1 Email_Address, (select lppr.ppr_descr from lppr_product@ILAS lppr where lppr.ppr_prodcd = lnpr.ppr_prodcd) Product_Desc, lnad.nad_mobile COntact_No, lnad.nad_address1, lnad.nad_address2, lnad.nad_address3, (select lcst.cst_descr from lcst_ppstatus@ILAS lcst where lcst.cst_statuscd= lnp1.cst_statuscd) Status_Descr, lnp2.np2_commendate Inception_Date, nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0) Installment_Amount, lnpr.npr_premiumter Plan_Duration, lnp1.np1_totreceiv Total_Amount_Received, lnp2.cmo_mode Frequency  from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnpr_product@ILAS lnpr, lnu1_underwriti@ILAS lnu1,lnad_address@ILAS lnad where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np2_setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnpr.np1_proposal and lnp2.np2_setno = lnpr.np2_setno and lnp2.np1_proposal = lnu1.np1_proposal and lnu1.nu1_life = 'F' and lnpr.npr_basicflag = 'Y' and lnu1.nph_code = lnad.nph_code and lnp1.np1_mailtoaddr = lnad.nad_addresstyp and lnp1.np1_proposal = ?";
	private final String	FIND_PS_POLICY_DETAILS_BY_ID				= "  select lnp1.np1_proposal,         sysdate Statement_Date,         (select lnph.nph_fullname            from lnph_pholder@ILAS lnph           where lnph.nph_code = lnu1.nph_code) Policy_Holder,         lnad.nad_email1 Email_Address,         (select lppr.ppr_descr            from lppr_product@ILAS lppr           where lppr.ppr_prodcd = lnpr.ppr_prodcd) Product_Desc,         lnad.nad_mobile COntact_No,         lnad.nad_address1,         lnad.nad_address2,         lnad.nad_address3,         (select lcst.cst_descr            from lcst_ppstatus@ILAS lcst           where lcst.cst_statuscd = lnp1.cst_statuscd) Status_Descr,         lnp2.np2_commendate Inception_Date,         nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) Installment_Amount,         lnpr.npr_premiumter Plan_Duration,         (select sum(d.dueamount) from view_adjusted_premium@ilas d           where d.np1_proposal = lnp1.np1_proposal             and d.np2_setno = lnp2.np2_setno             and d.oal_initiatedate between to_date ('01-01-2015', 'DD-MM-YYYY') and ? )Total_Amount_Received,         lnp2.cmo_mode Frequency    from lnp1_policymastr@ILAS lnp1,         lnp2_policymastr@ILAS lnp2,         lnpr_product@ILAS     lnpr,         lnu1_underwriti@ILAS  lnu1,         lnad_address@ILAS     lnad  where lnp1.np1_proposal = lnp2.np1_proposal     and lnp2.np2_setno = (select max(x.np2_setno)                             from lnp2_policymastr@ILAS x                            where x.np1_proposal = lnp2.np1_proposal                              and x.np2_approved = 'Y')     and lnp2.np1_proposal = lnpr.np1_proposal     and lnp2.np2_setno = lnpr.np2_setno     and lnp2.np1_proposal = lnu1.np1_proposal     and lnu1.nu1_life = 'F'     and lnpr.npr_basicflag = 'Y'     and lnu1.nph_code = lnad.nph_code     and lnp1.np1_mailtoaddr = lnad.nad_addresstyp     and lnp1.np1_proposal = ?  ";
	private final String	FIND_PS_POLICY_PREMIUM_DETAILS_BY_ID		= "select lnp2.np1_proposal, sysdate Statement_Date, case when lnp2.cmo_mode = 'M' then      floor(months_between(sysdate, lnp2.np2_commendate)) * (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'A' then       (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'S' then       (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'Q' then       (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * ((nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0)) * 4)  when lnp2.cmo_mode = 'H' then  (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * ((nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0)) * 2)                       end Total_Premium_Due, rrc.total_received Premium_Paid, (case when lnp2.cmo_mode = 'M' then      floor(months_between(sysdate, lnp2.np2_commendate)) * (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'A' then       (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'S' then       (nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0))  when lnp2.cmo_mode = 'Q' then       (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * ((nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0)) * 4)  when lnp2.cmo_mode = 'H' then  (ceil(months_between(sysdate, lnp2.np2_commendate)/12)+1) * ((nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0)) * 2)                       end )  - rrc.total_received Premium_Not_Paid,  nvl(lnp2.np2_totpremium,0) + nvl(lnp2.np2_totload,0) Premium,  lnp1.np1_adhocpremium Topup_Premium, lnp1.np1_creditbalance Credit_Balance   from lnp2_policymastr@ILAS lnp2,lnp1_policymastr@ILAS lnp1,   (  select  gca_Account, nvl(sum(rrd_rectamount),0) total_received from ( select trim(lrrc.pcm_compcode||'-'||lrrc.pcl_locatcode||'-'||trim(to_char(lrrc.rrc_receiptno,'000000000000'))) Receipt_No, lrrd.gca_account, lrrd.rrd_rectamount from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd where lrrc.pcm_compcode = lrrd.pcm_compcode and lrrc.pcl_locatcode = lrrd.pcl_locatcode and lrrc.rrc_receiptno = lrrd.rrc_receiptno and lrrc.rrc_postdate is not null and lrrc.rrc_canceldat is null  ) group by gca_Account  ) rrc    where lnp2.np1_proposal = rrc.gca_Account   and lnp2.np1_proposal = lnp1.np1_proposal   and lnp2.np2_setno = (select max(y.np2_Setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal   and y.np2_approved = 'Y') and  lnp2.np1_proposal =?";
	private final String	FIND_PS_POLICY_COVERAGE_DETAILS_BY_ID		= "select lnp1.np1_proposal, sysdate Statement_Date, (select lppr.ppr_descr from lppr_product@ILAS lppr where lppr.ppr_prodcd = lnpr.ppr_prodcd) Product_Desc, case when lnpr.npr_basicflag = 'Y' then     'Main Benefit' else     'Rider' end Benefit_Type, lnpr.npr_benefitterm Benefit_term, lnpr.npr_sumassured Sum_Assured       from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnpr_product@ILAS lnpr where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np2_setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnpr.np1_proposal and lnp2.np2_setno = lnpr.np2_setno and lnp1.np1_proposal = ?";
//	private final String FIND_PS_POLICY_FUND_DETAILS_BY_ID = " select nua.np1_proposal proposal_no, (select lcfu.cfu_descr from lcfu_funds@ilas lcfu where lcfu.cfu_fundcode = nua.cfu_fundcode) fund_description, (select pcu.pcu_currdesc from pcu_currency@ilas pcu where pcu.pcu_currcode = np2.pcu_currcode) currency, round(sum(case when nua.nua_unitupdate <= [$uptodt] then nvl(nua.nua_units, 0) end),2) no_of_units, round((select cbd_bidprice rate from lcbd_bidoffer@ilas where cfu_fundcode = nua.cfu_fundcode and cbd_valuedate = (select max(cbd_valuedate) from lcbd_bidoffer@ilas where cfu_fundcode = nua.cfu_fundcode and cbd_valuedate <= [$uptodt])),2) current_unit_rate, nvl((select sum(d.DUEAMOUNT) from view_adjusted_premium@ilas d, last_unitdate b where d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy') and sysdate - 1 and d.np1_proposal = nua.np1_proposal and trunc(OAL_INITIATEDATE) <= pricedate),0) premium_invested, nvl((select sum(d.DUEAMOUNT) from view_adjusted_premium@ilas d, last_unitdate b where d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy') and sysdate - 1 and d.np1_proposal = nua.np1_proposal and trunc(OAL_INITIATEDATE) > pricedate),0) premium_to_be_invested, round(sum(nvl(nua.nua_units, 0)) * (select cbd_bidprice rate from lcbd_bidoffer@ilas where cfu_fundcode = nua.cfu_fundcode and cbd_valuedate = (select max(cbd_valuedate) from lcbd_bidoffer@ilas where cfu_fundcode = nua.cfu_fundcode)),2) total_saving_values from lnua_unitalocate@ilas nua, lcfu_funds@ILAS cfu, lnp2_policymastr@ILAS np2 where nua.np1_proposal = ? and nua.cfu_fundcode = cfu.cfu_fundcode and np2.np1_proposal = nua.np1_proposal and np2.np2_setno = (select max(x.np2_setno) from lnp2_policymastr@ilas x where x.np1_proposal = np2.np1_proposal and x.np2_approved = 'Y') group by nua.np1_proposal, nua.cfu_fundcode, np2.pcu_currcode";
	private final String	FIND_PS_POLICY_FUND_DETAILS_BY_ID			= "select nua.np1_proposal proposal_no,         (select lcfu.cfu_descr            from lcfu_funds@ilas lcfu           where lcfu.cfu_fundcode = nua.cfu_fundcode) fund_description,         (select pcu.pcu_currdesc            from pcu_currency@ilas pcu           where pcu.pcu_currcode = np2.pcu_currcode) currency,         round(sum(case                    when nua.nua_unitupdate <= uptodt then                     nvl(nua.nua_units, 0)                   end),2) no_of_units,         round((select cbd_bidprice rate                  from lcbd_bidoffer@ilas                 where cfu_fundcode = nua.cfu_fundcode                   and cbd_valuedate =                      (select max(cbd_valuedate)                         from lcbd_bidoffer@ilas                        where cfu_fundcode = nua.cfu_fundcode                          and cbd_valuedate <= uptodt)),2) current_unit_rate,         nvl((select sum(d.DUEAMOUNT)               from view_adjusted_premium@ilas d, last_unitdate b              where d.oal_initiatedate between                    to_date('01-01-2015', 'dd-mm-yyyy') and uptodt                and d.np1_proposal = nua.np1_proposal                and trunc(OAL_INITIATEDATE) <= pricedate),0) premium_invested,         nvl((select sum(d.DUEAMOUNT)               from view_adjusted_premium@ilas d, last_unitdate b              where d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy') and uptodt                and d.np1_proposal = nua.np1_proposal                and trunc(oal_initiatedate) > pricedate),0) premium_to_be_invested,         round(sum(case when nua.nua_unitupdate <= uptodt then nvl(nua.nua_units, 0) end),2)       * round((select cbd_bidprice rate                 from lcbd_bidoffer@ilas                where cfu_fundcode = nua.cfu_fundcode                  and cbd_valuedate =                      (select max(cbd_valuedate)                         from lcbd_bidoffer@ilas                        where cfu_fundcode = nua.cfu_fundcode                          and cbd_valuedate <= uptodt)),2)  total_saving_values,         (select count (distinct instno)            from view_adjusted_premium@ilas d,                 policy_master@ilas        p           where d.oal_initiatedate between to_date ('01-01-2015', 'DD-MM-YYYY') and sysdate - 1             and d.np1_proposal = p.np1_proposal             and d.np1_proposal = nua.np1_proposal             and d.oal_initiatedate <= uptodt) Installment_Paid    from lnua_unitalocate@ilas nua,         lcfu_funds@ILAS       cfu,         lnp2_policymastr@ILAS np2  where nua.np1_proposal = ?     and nua.cfu_fundcode = cfu.cfu_fundcode     and np2.np1_proposal = nua.np1_proposal     and np2.np2_setno = (select max(x.np2_setno)                            from lnp2_policymastr@ilas x                           where x.np1_proposal = np2.np1_proposal                             and x.np2_approved = 'Y')  group by nua.np1_proposal, nua.cfu_fundcode, np2.pcu_currcode  ";
	private final String	FIND_PS_POLICY_BENEFICIARY_DETAILS_BY_ID	= "select lnp1.np1_proposal, sysdate Statement_Date, lnbf.nbf_benname, lnbf.nbf_percntage, (select lcrl.crl_descr from lcrl_relation@ILAS lcrl where lcrl.crl_releatiocd =  lnbf.crl_releatiocd) relationship from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnbf_beneficiary@ILAS lnbf where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np2_setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnbf.np1_proposal and lnp1.np1_proposal = ?";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select lnht.np1_proposal, lnp2.cmo_mode, case when lnp2.cmo_mode = 'A' then      ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'M' then      decode(ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12),0,1,ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12))       when lnp2.cmo_mode = 'Q' then        ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'H' then   ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'S' then    1 end Policy_Year,  rownum Installment_No,  lnht.nht_premduedat,  lnht.nht_documno, rrc.rrd_rectamount, lnht.nht_posted Paid_Date  from lnht_history@ILAS lnht, lnp2_policymastr@ILAS lnp2,   (  select Receipt_No, gca_Account, rrd_rectamount from ( select trim(lrrc.pcm_compcode||'-'||lrrc.pcl_locatcode||'-'||trim(to_char(lrrc.rrc_receiptno,'000000000000'))) Receipt_No, lrrd.gca_account, lrrd.rrd_rectamount from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd where lrrc.pcm_compcode = lrrd.pcm_compcode and lrrc.pcl_locatcode = lrrd.pcl_locatcode and lrrc.rrc_receiptno = lrrd.rrc_receiptno and lrrc.rrc_postdate is not null and lrrc.rrc_canceldat is null )  ) rrc    where lnht.np1_proposal = rrc.gca_Account   and lnht.np1_proposal = lnp2.np1_proposal   and lnp2.np2_setno = (select max(y.np2_Setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal   and y.np2_approved = 'Y')   and lnht.nht_documno = rrc.receipt_no and  lnht.np1_proposal =? and lnht.cpr_payrecvcd = '222' and lnht.nht_type = 'RCV' and lnht.nht_premduedat between ? and ? order by lnht.nht_premduedat";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select lnht.np1_proposal, lnp2.cmo_mode, case when lnp2.cmo_mode = 'A' then      ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'M' then      decode(ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12),0,1,ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12))       when lnp2.cmo_mode = 'Q' then        ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'H' then   ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'S' then    1 end Policy_Year,  rownum Installment_No,  lnht.nht_premduedat,   'Paid' Payment_Status, case when ( select   max(lc.cbd_valuedate) from lnfu_funds@ILAS f, lcbd_bidoffer@ILAS lc  where f.cfu_fundcode = lc.cfu_fundcode  and f.np1_proposal = lnht.np1_proposal and f.np2_setno = lnht.np2_setno  and nvl(f.nfu_rate,0) <> 0) >= lnht.nht_premduedat then    'Invested'  else    'to be Invested' end    Invested_tobeinvested,  lnht.nht_documno, rrc.rrd_rectamount, lnht.nht_posted Paid_Date  from lnht_history@ILAS lnht, lnp2_policymastr@ILAS lnp2,   (  select Receipt_No, gca_Account, rrd_rectamount from ( select trim(lrrc.pcm_compcode||'-'||lrrc.pcl_locatcode||'-'||trim(to_char(lrrc.rrc_receiptno,'000000000000'))) Receipt_No, lrrd.gca_account, lrrd.rrd_rectamount from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd where lrrc.pcm_compcode = lrrd.pcm_compcode and lrrc.pcl_locatcode = lrrd.pcl_locatcode and lrrc.rrc_receiptno = lrrd.rrc_receiptno and lrrc.rrc_postdate is not null and lrrc.rrc_canceldat is null )  ) rrc    where lnht.np1_proposal = rrc.gca_Account   and lnht.np1_proposal = lnp2.np1_proposal   and lnp2.np2_setno = (select max(y.np2_Setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal   and y.np2_approved = 'Y')   and lnht.nht_documno = rrc.receipt_no and  lnht.np1_proposal = ? and lnht.cpr_payrecvcd = '222' and lnht.nht_type = 'RCV' and lnht.nht_premduedat between ? and ? order by lnht.nht_premduedat";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select d.np1_proposal,        p.cmo_mode,        d.policyear,        d.instno,        d.premduedat,        'Paid' Payment_Status,        (case when d.oal_initiatedate <= (select x.pricedate from last_unitdate x) then 'Invested' else 'To Be Invested' end) Invested_tobeinvested,        d.oal_alocvchref nht_documno,        d.dueamount,        d.oal_initiatedate paid_date   from view_adjusted_premium@ilas d,        policy_master@ilas         p,        lcct_city@ilas             c,        lnad_address@ilas          a,        lnph_pholder@ilas          h where d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy') and sysdate - 1    and d.np1_proposal = p.np1_proposal    and c.cct_citycd = a.cct_citycd    and a.nph_code = p.nph_code    and c.ccn_ctrycd = '682'    and a.nad_addresstyp = 'C'    and p.nph_phcode = h.nph_code    and d.np1_proposal = ? and d.premduedat between ? and ? order by p.np1_policyno, d.instno";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select  lnht.np1_proposal, lnp2.cmo_mode,  (case    when lnp2.cmo_mode = 'A' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1    when lnp2.cmo_mode = 'M' then decode(ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12), 0, 1, ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12))    when lnp2.cmo_mode = 'Q' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1    when lnp2.cmo_mode = 'H' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1    when lnp2.cmo_mode = 'S' then 1  end) policyear, rownum instno, lnht.nht_premduedat premduedat,  'Paid' Payment_Status,   (case    when (select max(lc.cbd_valuedate) from lnfu_funds@ILAS f, lcbd_bidoffer@ILAS lc where f.cfu_fundcode = lc.cfu_fundcode and f.np1_proposal = lnht.np1_proposal and f.np2_setno = lnht.np2_setno and nvl(f.nfu_rate, 0) <> 0) >= lnht.nht_premduedat then 'Invested'    else 'To Be Invested'  end) Invested_tobeinvested, lnht.nht_documno,  rrc.rrd_rectamount dueamount, lnht.nht_posted Paid_Date from  lnht_history@ILAS lnht, lnp2_policymastr@ILAS lnp2,  (select     Receipt_No, gca_Account, rrd_rectamount   from     (select        trim(lrrc.pcm_compcode || '-' || lrrc.pcl_locatcode || '-' || trim(to_char(lrrc.rrc_receiptno, '000000000000'))) Receipt_No,        lrrd.gca_account, lrrd.rrd_rectamount      from        lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd      where        lrrc.pcm_compcode = lrrd.pcm_compcode and        lrrc.pcl_locatcode = lrrd.pcl_locatcode and        lrrc.rrc_receiptno = lrrd.rrc_receiptno and        lrrc.rrc_postdate is not null and        lrrc.rrc_canceldat is null)) rrc where  lnht.np1_proposal = rrc.gca_Account and  lnht.np1_proposal = lnp2.np1_proposal and  lnp2.np2_setno =    (select max(y.np2_Setno)     from lnp2_policymastr@ILAS y     where       y.np1_proposal = lnp2.np1_proposal and       y.np2_approved = 'Y') and  lnht.nht_documno = rrc.receipt_no and  lnht.np1_proposal = ? and  lnht.cpr_payrecvcd = '222' and  lnht.nht_type = 'RCV'   AND  lnht.nht_posteD <= ? order by lnht.nht_premduedat";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select    lnht.np1_proposal, lnp2.cmo_mode,    (case      when lnp2.cmo_mode = 'A' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1      when lnp2.cmo_mode = 'M' then decode(ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12), 0, 1, ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12))      when lnp2.cmo_mode = 'Q' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1      when lnp2.cmo_mode = 'H' then ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate) / 12) + 1      when lnp2.cmo_mode = 'S' then 1    end) policyear,    row_number() over (order by lnht.nht_premduedat) instno,    lnht.nht_premduedat premduedat, 'Paid' payment_status,    (case      when (select max(lc.cbd_valuedate)              from lnfu_funds@ilas f, lcbd_bidoffer@ilas lc             where f.cfu_fundcode = lc.cfu_fundcode and                   f.np1_proposal = lnht.np1_proposal and                   f.np2_setno = lnht.np2_setno and                   nvl(f.nfu_rate, 0) <> 0) >= lnht.nht_posted then 'Invested'      else 'To Be Invested'     end) invested_tobeinvested, lnht.nht_documno, rrc.rrd_rectamount dueamount, lnht.nht_posted paid_date  from lnht_history@ilas lnht, lnp2_policymastr@ilas lnp2,       (select receipt_no, gca_account, rrd_rectamount          from (select trim(lrrc.pcm_compcode || '-' || lrrc.pcl_locatcode || '-' || trim(to_char(lrrc.rrc_receiptno, '000000000000'))) receipt_no,                       lrrd.gca_account,                       lrrd.rrd_rectamount                  from lrrc_receipt@ilas lrrc, lrrd_rectdetail@ilas lrrd                 where lrrc.pcm_compcode = lrrd.pcm_compcode and                       lrrc.pcl_locatcode = lrrd.pcl_locatcode and                       lrrc.rrc_receiptno = lrrd.rrc_receiptno and                       lrrc.rrc_postdate is not null and                       lrrc.rrc_canceldat is null)) rrc  where lnht.np1_proposal = rrc.gca_account and        lnht.np1_proposal = lnp2.np1_proposal and        lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y') and        lnht.nht_documno = rrc.receipt_no and        lnht.np1_proposal = ? and        lnht.cpr_payrecvcd = '222' and        lnht.nht_type = 'RCV' AND        (lnht.nht_premduedat <= ? OR lnht.nht_posted <= ?)         order by lnht.nht_premduedat";
//	private final String FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID = "select d.np1_proposal,           p.cmo_mode,           d.policyear,           d.instno,           d.premduedat,           'Paid' Payment_Status,           (CASE WHEN (SELECT MAX (lc.cbd_valuedate)                         FROM lnfu_funds@ilas f, lcbd_bidoffer@ilas lc                        WHERE f.cfu_fundcode = lc.cfu_fundcode                          AND f.np1_proposal = d.np1_proposal                          AND f.np2_setno = d.np2_setno                          AND NVL(f.nfu_rate, 0) <> 0) >= d.oal_initiatedate                THEN 'Invested'                ELSE 'To Be Invested' END) invested_tobeinvested,           d.oal_alocvchref nht_documno,           d.dueamount,           d.oal_initiatedate paid_date      from view_adjusted_premium@ilas d,           policy_master@ilas        p,           lcct_city@ilas            c,           lnad_address@ilas         a,           lnph_pholder@ilas         h     where d.oal_initiatedate between to_date ('01-01-2015', 'DD-MM-YYYY') and sysdate - 1           and d.np1_proposal = p.np1_proposal           and c.cct_citycd = a.cct_citycd           and a.nph_code = p.nph_code           and c.ccn_ctrycd = '682'           and a.nad_addresstyp = 'C'           and p.nph_phcode = h.nph_code           and d.np1_proposal = ?           and (d.premduedat <= ? OR d.oal_initiatedate <= ?)  order by p.np1_policyno, d.instno, d.premduedat, d.oal_initiatedate  ";
	private final String	FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID		= "select d.np1_proposal,           p.cmo_mode,           d.policyear,           d.instno,           d.premduedat,           (case when d.oal_initiatedate <= uptodt then 'Paid' else 'Not Paid' end) Payment_Status,           (CASE WHEN (SELECT MAX (lc.cbd_valuedate)                         FROM lnfu_funds@ilas f, lcbd_bidoffer@ilas lc                        WHERE f.cfu_fundcode = lc.cfu_fundcode                          AND f.np1_proposal = d.np1_proposal                          AND f.np2_setno = d.np2_setno                          AND NVL (f.nfu_rate, 0) <> 0) >= d.oal_initiatedate                and d.oal_initiatedate <= uptodt                THEN 'Invested'                ELSE 'To Be Invested' END) invested_tobeinvested,                    d.oal_alocvchref nht_documno,           d.dueamount,           (case when d.oal_initiatedate <= uptodt then d.oal_initiatedate end) paid_date      from view_adjusted_premium@ilas d,           policy_master@ilas        p,           lcct_city@ilas            c,           lnad_address@ilas         a,           lnph_pholder@ilas         h     where d.oal_initiatedate between to_date ('01-01-2015', 'DD-MM-YYYY') and sysdate - 1           and d.np1_proposal = p.np1_proposal           and c.cct_citycd = a.cct_citycd           and a.nph_code = p.nph_code           and c.ccn_ctrycd = '682'           and a.nad_addresstyp = 'C'           and p.nph_phcode = h.nph_code           and d.np1_proposal = ?           and (d.premduedat <= uptodt OR d.oal_initiatedate <= uptodt)  order by p.np1_policyno, d.instno, d.premduedat, d.oal_initiatedate  ";
	private final String	FIND_ALL_PS_POLICY							= "select lnph.NPH_IDNO iqumaId, lnp1.np1_proposal Proposal_No, lnp1.cst_statuscd Policy_Status, lnph.nph_code Client_Code, lnph.nph_fullname Client_Name, (select lcst.cst_descr from lcst_ppstatus@ILAS lcst where lcst.cst_statuscd = lnp1.cst_statuscd) Status_Description, lnp1.np1_issuedate Issue_Date, lnp2.np2_commendate Policy_Start_Date, lnpr.npr_maturitydate Policy_Expiry_Date  from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnu1_underwriti@ILAS lnu1, lnph_pholder@ILAS lnph,  lnpr_product@ILAS lnpr where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np1_proposal = lnu1.np1_proposal and lnp2.Np2_Setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnpr.np1_proposal and lnp2.np2_setno = lnpr.np2_setno and lnpr.npr_basicflag = 'Y' and lnu1.nph_code = lnph.nph_code and lnu1.nu1_life = 'F'";
	private final String	FIND_PS_POLICY_BY_IQUMAID					= "select lnph.NPH_IDNO iqumaId, lnp1.np1_proposal Proposal_No, lnp1.cst_statuscd Policy_Status, lnph.nph_code Client_Code, lnph.nph_fullname Client_Name, (select lcst.cst_descr from lcst_ppstatus@ILAS lcst where lcst.cst_statuscd = lnp1.cst_statuscd) Status_Description, lnp1.np1_issuedate Issue_Date, lnp2.np2_commendate Policy_Start_Date, lnpr.npr_maturitydate Policy_Expiry_Date  from lnp1_policymastr@ILAS lnp1, lnp2_policymastr@ILAS lnp2, lnu1_underwriti@ILAS lnu1, lnph_pholder@ILAS lnph,  lnpr_product@ILAS lnpr where lnp1.np1_proposal = lnp2.np1_proposal and lnp2.np1_proposal = lnu1.np1_proposal and lnp2.Np2_Setno = (select max(x.np2_setno) from lnp2_policymastr@ILAS x where x.np1_proposal = lnp2.np1_proposal and x.np2_approved = 'Y') and lnp2.np1_proposal = lnpr.np1_proposal and lnp2.np2_setno = lnpr.np2_setno and lnpr.npr_basicflag = 'Y' and lnu1.nph_code = lnph.nph_code and lnu1.nu1_life = 'F' and (lnph.NPH_IDNO like ? or lnp1.np1_proposal like ? or lnph.nph_fullname like ?)";
	private final String	FIND_INVESTMENT_DATE						= "select   max(lc.cbd_valuedate) from lnfu_funds@ILAS f, lcbd_bidoffer@ILAS lc, lnht_history@ILAS lnht  where f.cfu_fundcode = lc.cfu_fundcode  and f.np1_proposal = lnht.np1_proposal and f.np2_setno = lnht.np2_setno  and nvl(f.nfu_rate,0) <> 0   and lc.cbd_valuedate <= ?";
//	private final String FIND_WITHDRAWAL_BY_ID="select lnp1.np1_proposal, lsbp.sbp_amount Withdrawal from larq_request@ILAS larq, lnp1_policymastr@ILAS lnp1, lsbp_benefpayment@ILAS lsbp where lnp1.np1_proposal = ? and larq.arq_requestype = 'RSET' and larq.cdc_code = '001' and larq.np1_proposal = lnp1.np1_proposal and larq.pfs_acntyear = lsbp.pfs_acntyear and larq.arq_requestype = lsbp.arq_requestype and larq.arq_requestno = lsbp.arq_requestno";
	private final String	FIND_WITHDRAWAL_BY_ID						= "select    lnp1.np1_proposal, sum(lsbp.sbp_amount) Withdrawal  from    larq_request@ILAS larq, lnp1_policymastr@ILAS lnp1,    lsbp_benefpayment@ILAS lsbp  where    lnp1.np1_proposal = ? and    larq.arq_requestype = 'RSET' and    larq.cdc_code = '001' and    larq.np1_proposal = lnp1.np1_proposal and    larq.pfs_acntyear = lsbp.pfs_acntyear and    larq.arq_requestype = lsbp.arq_requestype and    larq.arq_requestno = lsbp.arq_requestno    group by    lnp1.np1_proposal  ";
	private final String	FIND_POLICY_SUMMARY_BY_ID					= "select np1_proposal,Total_Premium, count(installment_no) Installment_Paid, sum(rrd_rectamount) Premium_paid , Total_Premium - sum(rrd_rectamount) Premium_To_be_Paid, sum(tobeinvested) tobeinvested from ( select lnht.np1_proposal, lnp2.cmo_mode, case when lnp2.cmo_mode = 'A' then      ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'M' then      decode(ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12),0,1,ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12))       when lnp2.cmo_mode = 'Q' then        ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'H' then   ceil(months_between(lnht.nht_premduedat, lnp2.np2_commendate)/12)+1 when lnp2.cmo_mode = 'S' then    1 end Policy_Year,  rownum Installment_No, lnht.nht_premduedat,   'Paid' Payment_Status, case when ( select   max(lc.cbd_valuedate) from lnfu_funds@ILAS f, lcbd_bidoffer@ILAS lc  where f.cfu_fundcode = lc.cfu_fundcode  and f.np1_proposal = lnht.np1_proposal and f.np2_setno = lnht.np2_setno  and nvl(f.nfu_rate,0) <> 0) >= lnht.nht_premduedat then    0  else   (select (nvl(lnp2.np2_totpremium,0)+ nvl(lnp2.np2_totload,0)) from lnp2_policymastr@ILAS lnp2   where lnp2.np1_proposal = lnht.np1_proposal and lnp2.np2_setno = lnht.np2_setno)    end    tobeinvested, (select (nvl(lnp2.np2_totpremium,0)+ nvl(lnp2.np2_totload,0)) * (decode(lnp2.cmo_mode,'M',12,'Q',4,'H',2,'A',1,'S',1)) * lnpr.npr_premiumter from lnpr_product@ILAS lnpr, lnp2_policymastr@ILAS lnp2 where lnpr.np1_proposal = lnp2.np1_proposal and lnpr.np2_setno = lnp2.np2_setno and lnpr.npr_basicflag = 'Y'  and lnpr.np1_proposal = lnht.np1_proposal and lnpr.np2_setno = lnht.np2_setno ) Total_Premium, lnht.nht_documno, rrc.rrd_rectamount, lnht.nht_posted Paid_Date  from lnht_history@ILAS lnht, lnp2_policymastr@ILAS lnp2,   (  select Receipt_No, gca_Account, rrd_rectamount from ( select trim(lrrc.pcm_compcode||'-'||lrrc.pcl_locatcode||'-'||trim(to_char(lrrc.rrc_receiptno,'000000000000'))) Receipt_No, lrrd.gca_account, lrrd.rrd_rectamount from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd where lrrc.pcm_compcode = lrrd.pcm_compcode and lrrc.pcl_locatcode = lrrd.pcl_locatcode and lrrc.rrc_receiptno = lrrd.rrc_receiptno and lrrc.rrc_postdate is not null and lrrc.rrc_canceldat is null )  ) rrc    where lnht.np1_proposal = rrc.gca_Account   and lnht.np1_proposal = lnp2.np1_proposal   and lnp2.np2_setno = (select max(y.np2_Setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal   and y.np2_approved = 'Y')   and lnht.nht_documno = rrc.receipt_no and  lnht.np1_proposal =? and lnht.cpr_payrecvcd = '222' and lnht.nht_type = 'RCV' order by lnht.nht_premduedat ) group by np1_proposal, Total_Premium";
	private final String	FIND_CUSTOMER_ADDRESS						= "SELECT * FROM ILAS_PROPOSAL_ADDRESS WHERE NP1_PROPOSAL=?";
//	private final String FIND_PS_POLICY_PREMIUM = "select lnp2.np1_proposal,        [$uptodt] Statement_Date,             (case          when lnp2.cmo_mode = 'M' then floor(months_between([$uptodt], lnp2.np2_commendate)+1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'A' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'Q' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4)          when lnp2.cmo_mode = 'H' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2)        end) Total_Premium_Due,        rrc.total_received Premium_Paid,        (case          when lnp2.cmo_mode = 'M' then floor(months_between([$uptodt], lnp2.np2_commendate)+1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'A' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))          when lnp2.cmo_mode = 'Q' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4)          when lnp2.cmo_mode = 'H' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2)        end) - rrc.total_received  Premium_Not_Paid,             nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) Premium,        lnp1.np1_adhocpremium Topup_Premium,        lnp1.np1_creditbalance Credit_Balance 	from lnp2_policymastr@ilas lnp2,lnp1_policymastr@ilas lnp1,        (select gca_Account, nvl(sum(rrd_rectamount), 0) total_received           from (select trim(lrrc.pcm_compcode || '-' || lrrc.pcl_locatcode || '-' ||trim(to_char(lrrc.rrc_receiptno, '000000000000'))) Receipt_No,                        lrrd.gca_account,lrrd.rrd_rectamount                   from lrrc_receipt@ilas lrrc, lrrd_rectdetail@ilas lrrd                  where lrrc.pcm_compcode = lrrd.pcm_compcode                    and lrrc.pcl_locatcode = lrrd.pcl_locatcode                    and lrrc.rrc_receiptno = lrrd.rrc_receiptno                    and lrrc.rrc_postdate is not null                    and lrrc.rrc_canceldat is null                    and trunc(lrrc.rrc_rectdate) between [$fromdt] and [$uptodt])          group by gca_Account) rrc 	where lnp2.np1_proposal = rrc.gca_Account 	and lnp2.np1_proposal = lnp1.np1_proposal 	and lnp2.np2_setno = (select max(y.np2_Setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y') 	and lnp2.np1_proposal = ?";
//	private final String FIND_PS_POLICY_PREMIUM = "select lnp1.np1_proposal, [$fromdt] Statement_Date, p.np1_totreceiv Premium_Paid, (select (case when lnp2.cmo_mode = 'M' then floor(months_between([$fromdt], lnp2.np2_commendate) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'A' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'Q' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4) when lnp2.cmo_mode = 'H' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2) end) from lnp2_policymastr@ILAS lnp2 where lnp2.np1_proposal = lnp1.np1_proposal and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) Total_Premium_Due, ((select (case  when lnp2.cmo_mode = 'M' then floor(months_between([$fromdt], lnp2.np2_commendate) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'A' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) when lnp2.cmo_mode = 'Q' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4) when lnp2.cmo_mode = 'H' then (ceil(months_between([$fromdt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2) end) from lnp2_policymastr@ILAS lnp2 where lnp2.np1_proposal = lnp1.np1_proposal and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) - p.np1_totreceiv) Premium_Not_Paid, (select nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) from lnp2_policymastr@ILAS lnp2 where lnp2.np1_proposal = lnp1.np1_proposal and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ILAS y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) Premium, nvl(lnp1.np1_adhocpremium,0) Topup_Premium, nvl(lnp1.np1_creditbalance,0) Credit_Balance from policy_master@Ilas p, lnp1_policymastr@ILAS lnp1 where p.np1_proposal = lnp1.np1_proposal and lnp1.np1_proposal = ? ";
//	private final String FIND_PS_POLICY_PREMIUM = "select lnp1.np1_proposal, [$uptodt] Statement_Date,  p.np1_totreceiv Premium_Paid,  (select (case  when lnp2.cmo_mode = 'M' then floor(months_between([$uptodt], lnp2.np2_commendate) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'A' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'Q' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4)  when lnp2.cmo_mode = 'H' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2) end)  from lnp2_policymastr@ilas lnp2  where lnp2.np1_proposal = lnp1.np1_proposal  and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) Total_Premium_Due,  ((select (case  when lnp2.cmo_mode = 'M' then floor(months_between([$uptodt], lnp2.np2_commendate) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'A' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'S' then (nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0))  when lnp2.cmo_mode = 'Q' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 4)  when lnp2.cmo_mode = 'H' then (ceil(months_between([$uptodt], lnp2.np2_commendate) / 12) + 1) * ((nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)) * 2) end)  from lnp2_policymastr@ilas lnp2 where lnp2.np1_proposal = lnp1.np1_proposal  and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) - p.np1_totreceiv) Premium_Not_Paid,  (select nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)  from lnp2_policymastr@ilas lnp2  where lnp2.np1_proposal = lnp1.np1_proposal and lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y')) Premium,  nvl(lnp1.np1_adhocpremium,0) Topup_Premium,  nvl(lnp1.np1_creditbalance,0) Credit_Balance,  (select lsbp.sbp_amount from lsbp_benefpayment@ILAS lsbp where lsbp.np1_proposal = lnp1.np1_proposal) Withdrawal from policy_master@ilas p, lnp1_policymastr@ilas lnp1  where p.np1_proposal = lnp1.np1_proposal  and lnp1.np1_proposal = ?";
	private final String	FIND_PS_POLICY_PREMIUM						= "select   lnp1.np1_proposal,   [$uptodt] Statement_Date,   p.np1_totreceiv Premium_Paid,   (    select       (        case when lnp2.cmo_mode = 'M' then floor(          months_between(            [$uptodt], lnp2.np2_commendate          ) + 1        ) * (          nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)        ) when lnp2.cmo_mode = 'A' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) * (          nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)        ) when lnp2.cmo_mode = 'S' then (          nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)        ) when lnp2.cmo_mode = 'Q' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) * (          (            nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)          ) * 4        ) when lnp2.cmo_mode = 'H' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) * (          (            nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)          ) * 2        ) end      )     from       lnp2_policymastr@ilas lnp2     where       lnp2.np1_proposal = lnp1.np1_proposal       and lnp2.np2_setno = (        select           max(y.np2_setno)         from           lnp2_policymastr@ilas y         where           y.np1_proposal = lnp2.np1_proposal           and y.np2_approved = 'Y'      )  ) Total_Premium_Due,   (    (      select         (          case when lnp2.cmo_mode = 'M' then floor(            months_between(              [$uptodt], lnp2.np2_commendate            ) + 1          ) * (            nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)          ) when lnp2.cmo_mode = 'A' then (            ceil(              months_between(                [$uptodt], lnp2.np2_commendate              ) / 12            ) + 1          ) * (            nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)          ) when lnp2.cmo_mode = 'S' then (            nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)          ) when lnp2.cmo_mode = 'Q' then (            ceil(              months_between(                [$uptodt], lnp2.np2_commendate              ) / 12            ) + 1          ) * (            (              nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)            ) * 4          ) when lnp2.cmo_mode = 'H' then (            ceil(              months_between(                [$uptodt], lnp2.np2_commendate              ) / 12            ) + 1          ) * (            (              nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)            ) * 2          ) end        )       from         lnp2_policymastr@ilas lnp2       where         lnp2.np1_proposal = lnp1.np1_proposal         and lnp2.np2_setno = (          select             max(y.np2_setno)           from             lnp2_policymastr@ilas y           where             y.np1_proposal = lnp2.np1_proposal             and y.np2_approved = 'Y'        )    ) - p.np1_totreceiv  ) Premium_Not_Paid,   (    select       nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)     from       lnp2_policymastr@ilas lnp2     where       lnp2.np1_proposal = lnp1.np1_proposal       and lnp2.np2_setno = (        select           max(y.np2_setno)         from           lnp2_policymastr@ilas y         where           y.np1_proposal = lnp2.np1_proposal           and y.np2_approved = 'Y'      )  ) Premium,   nvl(lnp1.np1_adhocpremium, 0) Topup_Premium,   nvl(lnp1.np1_creditbalance, 0) Credit_Balance,   (    select       sum(lsbp.sbp_amount)     from       lsbp_benefpayment@ilas lsbp     where       lsbp.np1_proposal = lnp1.np1_proposal  ) Withdrawal,   (    select       (        case when lnp2.cmo_mode = 'M' then floor(          months_between(            [$uptodt], lnp2.np2_commendate          ) + 1        ) when lnp2.cmo_mode = 'A' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) when lnp2.cmo_mode = 'S' then 0 when lnp2.cmo_mode = 'Q' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) when lnp2.cmo_mode = 'H' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) end      )     from       lnp2_policymastr@ilas lnp2     where       lnp2.np1_proposal = lnp1.np1_proposal       and lnp2.np2_setno = (        select           max(y.np2_setno)         from           lnp2_policymastr@ilas y         where           y.np1_proposal = lnp2.np1_proposal           and y.np2_approved = 'Y'      )  ) Total_inst_no,   (    select       (        case when lnp2.cmo_mode = 'M' then floor(          months_between(            [$uptodt], lnp2.np2_commendate          ) + 1        ) when lnp2.cmo_mode = 'A' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) when lnp2.cmo_mode = 'S' then 0 when lnp2.cmo_mode = 'Q' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) when lnp2.cmo_mode = 'H' then (          ceil(            months_between(              [$uptodt], lnp2.np2_commendate            ) / 12          ) + 1        ) end      ) - (        select           max(instno)         from           view_adjusted_premium@ilas d         where           d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy')           and sysdate - 1           and d.np1_proposal = lnp1.np1_proposal      )     from       lnp2_policymastr@ilas lnp2     where       lnp2.np1_proposal = lnp1.np1_proposal       and lnp2.np2_setno = (        select           max(y.np2_setno)         from           lnp2_policymastr@ilas y         where           y.np1_proposal = lnp2.np1_proposal           and y.np2_approved = 'Y'      )  ) installments_remaining from   policy_master@ilas p,   lnp1_policymastr@ilas lnp1 where   p.np1_proposal = lnp1.np1_proposal   and lnp1.np1_proposal = ?";
	private final String	FIND_PS_POLICY_PREMIUM_DETAILS				= "select  lnp1.np1_proposal, uptodt Statement_Date,  (select sum(lrrd.rrd_rectamount)     from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd, lnht_history@ILAS lnht    where lrrc.pcm_compcode = lrrd.pcm_compcode and                                      lrrc.pcl_locatcode = lrrd.pcl_locatcode and                                      lrrc.rrc_receiptno = lrrd.rrc_receiptno and                                      lrrc.rrc_postdate is not null and                                      lrrc.rrc_canceldat is null and                                      lnht.np1_proposal = lrrd.gca_account and                                                                  lnht.np1_proposal = lnp1.np1_proposal and                                                                  lnht.nht_documno = trim(lrrc.pcm_compcode || '-' || lrrc.pcl_locatcode || '-' || trim(to_char(lrrc.rrc_receiptno, '000000000000'))) and                                      lnht.cpr_payrecvcd = '222' and                                      lnht.nht_type = 'RCV'  and                                      lnht.nht_posted <= uptodt) Premium_Paid,  (select (case                                      when lnp2.cmo_mode = 'M' then floor( months_between(uptodt, lnp2.np2_commendate) + 1 ) * ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                      when lnp2.cmo_mode = 'A' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                      when lnp2.cmo_mode = 'S' then ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                      when lnp2.cmo_mode = 'Q' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) ) * 4 )                                      when lnp2.cmo_mode = 'H' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) ) * 2 )                                      end )    from lnp2_policymastr@ilas lnp2   where lnp2.np1_proposal = lnp1.np1_proposal and         lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and          y.np2_approved = 'Y' ) ) Total_Premium_Due,((select                                     (case                                       when lnp2.cmo_mode = 'M' then floor( months_between(uptodt, lnp2.np2_commendate) + 1 ) * ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                       when lnp2.cmo_mode = 'A' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                       when lnp2.cmo_mode = 'S' then ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) )                                       when lnp2.cmo_mode = 'Q' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) ) * 4 )                                       when lnp2.cmo_mode = 'H' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 ) * ( ( nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0) ) * 2 )                                     end)    from lnp2_policymastr@ilas lnp2   where lnp2.np1_proposal = lnp1.np1_proposal and         lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y' ) )      - (select sum(lrrd.rrd_rectamount)     from lrrc_receipt@ILAS lrrc, lrrd_rectdetail@ILAS lrrd, lnht_history@ILAS lnht    where lrrc.pcm_compcode = lrrd.pcm_compcode and                                      lrrc.pcl_locatcode = lrrd.pcl_locatcode and                                      lrrc.rrc_receiptno = lrrd.rrc_receiptno and                                      lrrc.rrc_postdate is not null and                                      lrrc.rrc_canceldat is null and                                      lnht.np1_proposal = lrrd.gca_account and                                                                  lnht.np1_proposal = lnp1.np1_proposal and                                                                  lnht.nht_documno = trim(lrrc.pcm_compcode || '-' || lrrc.pcl_locatcode || '-' || trim(to_char(lrrc.rrc_receiptno, '000000000000'))) and                                      lnht.cpr_payrecvcd = '222' and                                      lnht.nht_type = 'RCV'  and                                      lnht.nht_posted <= uptodt) ) Premium_Not_Paid,  (select nvl(lnp2.np2_totpremium, 0) + nvl(lnp2.np2_totload, 0)   from lnp2_policymastr@ilas lnp2  where lnp2.np1_proposal = lnp1.np1_proposal and        lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y' ) ) Premium,  nvl(lnp1.np1_adhocpremium, 0) Topup_Premium,  nvl(lnp1.np1_creditbalance, 0) Credit_Balance,  (select sum(lsbp.sbp_amount)    from lsbp_benefpayment@ilas lsbp   where lsbp.np1_proposal = lnp1.np1_proposal) Withdrawal,  (select (case                                       when lnp2.cmo_mode = 'M' then floor( months_between(uptodt, lnp2.np2_commendate) + 1 )                                       when lnp2.cmo_mode = 'A' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       when lnp2.cmo_mode = 'S' then 0                                       when lnp2.cmo_mode = 'Q' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       when lnp2.cmo_mode = 'H' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       end)   from lnp2_policymastr@ilas lnp2  where lnp2.np1_proposal = lnp1.np1_proposal and        lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y' ) ) Total_inst_no,  (select (case                                       when lnp2.cmo_mode = 'M' then floor( months_between(uptodt, lnp2.np2_commendate) + 1 )                                       when lnp2.cmo_mode = 'A' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       when lnp2.cmo_mode = 'S' then 0                                       when lnp2.cmo_mode = 'Q' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       when lnp2.cmo_mode = 'H' then ( ceil( months_between(uptodt, lnp2.np2_commendate) / 12 ) + 1 )                                       end) - ( select max(instno) from view_adjusted_premium@ilas d where d.oal_initiatedate between to_date('01-01-2015', 'dd-mm-yyyy') and uptodt and d.np1_proposal = lnp1.np1_proposal )   from lnp2_policymastr@ilas lnp2  where lnp2.np1_proposal = lnp1.np1_proposal and        lnp2.np2_setno = (select max(y.np2_setno) from lnp2_policymastr@ilas y where y.np1_proposal = lnp2.np1_proposal and y.np2_approved = 'Y' ) ) installments_remaining from policy_master@ilas p, lnp1_policymastr@ilas lnp1 where p.np1_proposal = lnp1.np1_proposal and      lnp1.np1_proposal = ?";

	public List<PSPolicy> findPSPolicyByIqamaId(String iqamaId) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(iqamaId);
			List<PSPolicy> psPolicies = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSPolicy psPolicy = new PSPolicy();
					psPolicy.setProposal_no(Long.parseLong((String) objects[i++]));
					psPolicy.setPolicy_status((String) objects[i++]);
					psPolicy.setClient_Code(((BigDecimal) objects[i++]).longValue());
					psPolicy.setClient_name((String) objects[i++]);
					psPolicy.setStatus_description((String) objects[i++]);
					psPolicy.setIssue_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_start_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_expiry_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));

					psPolicies.add(psPolicy);
				}
			}

			return psPolicies;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	@Override
	public Date convert(Object val) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	boolean isPolicySurrendered;

	/**
	 * @param  iqamaId
	 * @return
	 * @throws PortalException
	 */
	public List<PSPolicyDetail> findPSPolicyDetailsById(String id, String toDate) throws PortalException {
		Session session = null;
		try {
			isPolicySurrendered = false;
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_DETAILS_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(toDate);
			pos.add(id);
			List<PSPolicyDetail> psPolicyDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSPolicyDetail psPolicyDetail = new PSPolicyDetail();

					psPolicyDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					psPolicyDetail.setStatement_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicyDetail.setPolicy_holder((String) objects[i++]);
					psPolicyDetail.setEmail_address((String) objects[i++]);
					psPolicyDetail.setProduct_desc((String) objects[i++]);
					psPolicyDetail.setContact_no((String) objects[i++]);
					psPolicyDetail.setNad_address1((String) objects[i++]);
					psPolicyDetail.setNad_address2((String) objects[i++]);
					psPolicyDetail.setNad_address3((String) objects[i++]);
					psPolicyDetail.setStatus_descr((String) objects[i++]);
					psPolicyDetail.setInception_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicyDetail.setInstallment_amount(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPolicyDetail.setPlan_duration(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPolicyDetail.setTotal_amount_received(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPolicyDetail.setFrequency((String) objects[i++]);
					if (psPolicyDetail.getStatus_descr().equals("SURRENDER")) {
						isPolicySurrendered = true;
					}

					SOADetail soaDetail = findCustomerAddressByIqumaId(String.valueOf(psPolicyDetail.getProposal_no()));
					psPolicyDetail.setNad_address1(soaDetail.getNad_address1() == null ? " " : soaDetail.getNad_address1());
					psPolicyDetail.setNad_address2(soaDetail.getNad_address2() == null ? " " : soaDetail.getNad_address2());
					psPolicyDetail.setNad_address3(soaDetail.getNad_address3() == null ? " " : soaDetail.getNad_address3());

					psPolicyDetail.setMailingAddress1(soaDetail.getMailingAddress1() == null ? " " : soaDetail.getMailingAddress1());
					psPolicyDetail.setMailingAddress2(soaDetail.getMailingAddress2() == null ? " " : soaDetail.getMailingAddress2());
					psPolicyDetail.setMailingAddress3(soaDetail.getMailingAddress3() == null ? " " : soaDetail.getMailingAddress3());

					psPolicyDetails.add(psPolicyDetail);
				}
			}
			return psPolicyDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<PSPremiumDetail> findPSPolicyPremiumDetailsById(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_PREMIUM_DETAILS_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<PSPremiumDetail> psPremiumDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSPremiumDetail psPremiumDetail = new PSPremiumDetail();

					psPremiumDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					psPremiumDetail.setStatement_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPremiumDetail.setTotal_premium_due(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPremiumDetail.setPremium_paid(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPremiumDetail.setPremium_not_paid(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPremiumDetail.setPremium(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPremiumDetail.setTopup_premium(objects[i++] != null ? (Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue()))) : 0);
					psPremiumDetail.setCredit_balance(Math.abs(Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					psPremiumDetail.setWithdraw(findWithdrawel(String.valueOf(psPremiumDetail.getProposal_no())));

					psPremiumDetails.add(psPremiumDetail);
				}
			}
			return psPremiumDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<PSCoverageDetail> findPSPolicyCoverageDetailsById(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_COVERAGE_DETAILS_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<PSCoverageDetail> psCoverageDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSCoverageDetail psCoverageDetail = new PSCoverageDetail();

					psCoverageDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					psCoverageDetail.setStatement_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psCoverageDetail.setBenefit_name((String) objects[i++]);
					psCoverageDetail.setBenefit_type((String) objects[i++]);
					psCoverageDetail.setBenefit_term(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psCoverageDetail.setBenefit_term_string(String.format("%.0f", psCoverageDetail.getBenefit_term()));
					psCoverageDetail.setSum_assured(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psCoverageDetail.setSum_assured_string(String.format("%.0f", psCoverageDetail.getSum_assured()));

					psCoverageDetails.add(psCoverageDetail);
				}
			}
			return psCoverageDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	Double	premiumToBeinvested	= new Double(0);
	String	toDate;

	public List<PSFundDetail> findPSPolicyFundDetailsById(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			String termQuery = FIND_PS_POLICY_FUND_DETAILS_BY_ID.replaceAll("uptodt", "'" + this.toDate + "'");
			SQLQuery query = session.createSQLQuery(termQuery);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<PSFundDetail> psFundDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSFundDetail psFundDetail = new PSFundDetail();

					psFundDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					psFundDetail.setInvestment_strategy((String) objects[i++]);
					psFundDetail.setCurrency(((String) objects[i++]).toUpperCase());
					psFundDetail.setNo_units(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psFundDetail.setCurrent_unit_value(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psFundDetail.setPeremium_invested(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					premiumToBeinvested = Math.abs(((BigDecimal) objects[i++]).doubleValue());
					psFundDetail.setTotal_saving_value(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psFundDetail.setInstallments_paid(Math.abs(((BigDecimal) objects[i++]).intValue()));

					psFundDetails.add(psFundDetail);
				}
			}
			return psFundDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<PSBeneficiaryDetail> findPSPolicyBeneficiaryDetailsById(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_BENEFICIARY_DETAILS_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<PSBeneficiaryDetail> psBeneficiaryDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSBeneficiaryDetail psBeneficiaryDetail = new PSBeneficiaryDetail();

					psBeneficiaryDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					psBeneficiaryDetail.setStatement_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psBeneficiaryDetail.setBeneficiary_name(((String) objects[i++]));
					psBeneficiaryDetail.setShare(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psBeneficiaryDetail.setShare_string(String.format("%.0f", psBeneficiaryDetail.getShare()));
					psBeneficiaryDetail.setRelationship(((String) objects[i++]));
					if (psBeneficiaryDetail.getRelationship().equals("Legal hiers")) {
						psBeneficiaryDetail.setBeneficiary_name(psBeneficiaryDetail.getRelationship());
						psBeneficiaryDetail.setRelationship(null);
					}
					psBeneficiaryDetails.add(psBeneficiaryDetail);
				}
			}
			return psBeneficiaryDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<SOADetail> findPSPolicyStatementDetailsByIdAndDate(String id, String fromDate, String toDate) throws PortalException {
		this.toDate = toDate;
		Session session = null;
		try {
			session = openSession();
			String termQuery = FIND_PS_POLICY_STATEMENT_DETAILS_BY_ID.replaceAll("uptodt", "'" + toDate + "'");
			SQLQuery query = session.createSQLQuery(termQuery);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> psStatementDetails = new ArrayList<>();
			List<Object[]> data = query.list();

			SOADetail psStatementDetail = new SOADetail();

//	    	Date date2=new SimpleDateFormat("dd/MMM/yyyy").parse(toDate);
//	    	SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
//	    	String finalToDate = dateFormat.format(date2);

			List<PSPolicyDetail> psPolicyDetails = findPSPolicyDetailsById(id, toDate);
			PSPolicyDetail psPolicyDetail = psPolicyDetails.get(0);
			psStatementDetail.setProposal_no(psPolicyDetail.getProposal_no());
//			psStatementDetail.setStatement_date(psPolicyDetail.getStatement_date());
			psStatementDetail.setPolicy_holder(psPolicyDetail.getPolicy_holder());
			psStatementDetail.setEmail_address(psPolicyDetail.getEmail_address());
			psStatementDetail.setProduct_desc(psPolicyDetail.getProduct_desc());
			psStatementDetail.setContact_no(psPolicyDetail.getContact_no());
			psStatementDetail.setNad_address1(psPolicyDetail.getNad_address1());
			psStatementDetail.setNad_address2(psPolicyDetail.getNad_address2());
			psStatementDetail.setNad_address3(psPolicyDetail.getNad_address3());
			psStatementDetail.setStatus_descr(psPolicyDetail.getStatus_descr());
			psStatementDetail.setInception_date(psPolicyDetail.getInception_date());
			psStatementDetail.setGeneral_installment_amount(String.format("%.0f", psPolicyDetail.getInstallment_amount()));
			psStatementDetail.setPlan_duration(String.format("%.0f", psPolicyDetail.getPlan_duration()));
			psStatementDetail.setTotal_amount_received(String.format("%.0f", psPolicyDetail.getTotal_amount_received()));
			psStatementDetail.setFrequency(psPolicyDetail.getFrequency());

			psStatementDetail.setMailingAddress1(psPolicyDetail.getMailingAddress1());
			psStatementDetail.setMailingAddress2(psPolicyDetail.getMailingAddress2());
			psStatementDetail.setMailingAddress3(psPolicyDetail.getMailingAddress3());

			List<PSPremiumDetail> psPremiumDetails = findPSPolicyPremiumDetailsById(id);
			PSPremiumDetail psPremiumDetail = psPremiumDetails.get(0);
//			psStatementDetail.setTotal_premium_due(String.format("%.0f", psPremiumDetail.getTotal_premium_due()));
//			psStatementDetail.setPremium_paid(String.format("%.0f", psPremiumDetail.getPremium_paid()));
//			psStatementDetail.setPremium_not_paid(String.format("%.0f", psPremiumDetail.getPremium_not_paid()));
//			psStatementDetail.setPremium(String.format("%.0f", psPremiumDetail.getPremium()));
//			psStatementDetail.setTopup_premium(String.format("%.0f", psPremiumDetail.getTopup_premium()));
//			psStatementDetail.setCredit_balance(String.format("%.0f", psPremiumDetail.getCredit_balance()));
			psStatementDetail.setWithdraw(psPremiumDetail.getWithdraw() == null ? "0" : psPremiumDetail.getWithdraw());

			List<PSCoverageDetail> psCoverageDetails = findPSPolicyCoverageDetailsById(id);
			psStatementDetail.setPsCoverageDetails(psCoverageDetails);

			List<PSFundDetail> psFundDetails = findPSPolicyFundDetailsById(id);
			PSFundDetail psFundDetail = psFundDetails.get(0);
			psStatementDetail.setInvestment_strategy(psFundDetail.getInvestment_strategy());
			psStatementDetail.setCurrency(psFundDetail.getCurrency());
			psStatementDetail.setNo_units(isPolicySurrendered ? 0 : psFundDetail.getNo_units());
			psStatementDetail.setCurrent_unit_value(isPolicySurrendered ? 0 : psFundDetail.getCurrent_unit_value());
			psStatementDetail.setPeremium_invested(String.format("%.0f", psFundDetail.getPeremium_invested()));
			psStatementDetail.setTotal_saving_value(isPolicySurrendered ? 0 : psFundDetail.getTotal_saving_value());
			psStatementDetail.setPremium_to_be_invested(isPolicySurrendered ? "0" : premiumToBeinvested.toString());
			psStatementDetail.setInstallment_paid(String.valueOf(psFundDetail.getInstallments_paid()));

			psStatementDetail.setInvestementDate(findInvestmentDate(toDate));

			List<PSBeneficiaryDetail> psBeneficiaryDetails = findPSPolicyBeneficiaryDetailsById(id);
			psStatementDetail.setPsBeneficiaryDetails(psBeneficiaryDetails);

//			SOADetail soaDetail = findPolicySummaryByIqumaId(String.valueOf(psStatementDetail.getProposal_no()));
//			psStatementDetail.setInstallment_paid(soaDetail.getInstallment_paid());
//			psStatementDetail.setPremium_paid(soaDetail.getPremium_paid());
//			psStatementDetail.setPremium_to_be_invested(soaDetail.getPremium_to_be_invested());
//			psStatementDetail.setInstallment_remaining(isPolicySurrendered ? "0" : soaDetail.getInstallment_remaining());

//			SOADetail soaDetail1 = findPolicyPremiumByDate(fromDate,toDate,id);
//			psStatementDetail.setStatement_date(soaDetail1.getStatement_date());
//			psStatementDetail.setTotal_premium_due(soaDetail1.getTotal_premium_due());
//			psStatementDetail.setPremium_paid(soaDetail1.getPremium_paid());
//			psStatementDetail.setPremium_not_paid(isPolicySurrendered ? "0" : soaDetail1.getPremium_not_paid());
//			psStatementDetail.setPremium(soaDetail1.getPremium());
//			psStatementDetail.setTopup_premium(soaDetail1.getTopup_premium());
//			psStatementDetail.setCredit_balance(soaDetail1.getCredit_balance());
//			psStatementDetail.setInstallment_remaining(isPolicySurrendered ? "0" : soaDetail1.getInstallment_remaining());

			SOADetail soaDetail2 = findPolicyPremiumDetailsByDate(fromDate, toDate, id);
			psStatementDetail.setStatement_date(soaDetail2.getStatement_date());
			psStatementDetail.setTotal_premium_due(isPolicySurrendered ? "0" : soaDetail2.getTotal_premium_due());
			psStatementDetail.setPremium_paid(soaDetail2.getPremium_paid());
			psStatementDetail.setPremium_not_paid(isPolicySurrendered ? "0" : soaDetail2.getPremium_not_paid());
			psStatementDetail.setPremium(soaDetail2.getPremium());
			psStatementDetail.setTopup_premium(soaDetail2.getTopup_premium());
			psStatementDetail.setCredit_balance(soaDetail2.getCredit_balance());
			psStatementDetail.setInstallment_remaining(isPolicySurrendered ? "0" : soaDetail2.getInstallment_remaining());
//			psStatementDetail.setInstallment_paid(soaDetail2.getInstallment_paid());

			if (!((psStatementDetail.getStatus_descr() != "ACTIVE  (INFORCE)") || (psStatementDetail.getStatus_descr() != "REINSTATED"))) {
				psStatementDetail.setNo_units(0);
				psStatementDetail.setCurrent_unit_value(0);
				psStatementDetail.setTotal_premium_due("0");
				psStatementDetail.setPremium_not_paid("0");
				psStatementDetail.setInstallment_remaining("0");
				psStatementDetail.setPremium_to_be_invested("0");
			}

			List<PSStatementAccount> psStatementAccounts = new ArrayList<>();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSStatementAccount psStatementAccount = new PSStatementAccount();

					psStatementAccount.setProposal_no(Long.parseLong((String) objects[i++]));
					psStatementAccount.setFrequency((String) objects[i++]);
					psStatementAccount.setPolicy_year(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psStatementAccount.setPolicy_year_string(String.format("%.0f", psStatementAccount.getPolicy_year()));
					psStatementAccount.setInstallment_no(Math.abs(((BigDecimal) objects[i++]).doubleValue()));
					psStatementAccount.setInstallment_no_string(String.format("%.0f", psStatementAccount.getInstallment_no()));
					psStatementAccount.setPremium_due_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psStatementAccount.setPayment_status((String) objects[i++]);
					psStatementAccount.setCurrent_status((String) objects[i++]);
					psStatementAccount.setDocument_no((String) objects[i++]);
					psStatementAccount.setInstallment_amount(((BigDecimal) objects[i++]).doubleValue());
					psStatementAccount.setInstallment_amount_string(String.format("%.0f", psStatementAccount.getInstallment_amount()));
					Timestamp tmp = (Timestamp) objects[i++];
//					String premiumEntryDate = dateFormat.format(new Date(((Timestamp)objects[i++]).getTime()));
					psStatementAccount.setPremium_entry_date(Validator.isNotNull(tmp) ? dateFormat.format(new Date((tmp).getTime())) : "");

					psStatementAccounts.add(psStatementAccount);
				}
			}
			psStatementDetail.setPsStatementAccounts(psStatementAccounts);

			psStatementDetails.add(psStatementDetail);
			return psStatementDetails;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<PSPolicy> findAllPSPolicy() throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_ALL_PS_POLICY);
			query.setCacheable(false);
			List<PSPolicy> psPolicies = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSPolicy psPolicy = new PSPolicy();
					psPolicy.setIqumaId((String) objects[i++]);
					psPolicy.setProposal_no(Long.parseLong((String) objects[i++]));
					psPolicy.setPolicy_status((String) objects[i++]);
					psPolicy.setClient_Code(((BigDecimal) objects[i++]).longValue());
					psPolicy.setClient_name((String) objects[i++]);
					psPolicy.setStatus_description((String) objects[i++]);
					psPolicy.setIssue_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_start_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_expiry_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));

					psPolicies.add(psPolicy);
				}
			}

			return psPolicies;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public List<PSPolicy> searchAllPSPolicybyIqumaId(String keyword) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_PS_POLICY_BY_IQUMAID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(StringUtil.quote(keyword, StringPool.PERCENT));
			pos.add(StringUtil.quote(keyword, StringPool.PERCENT));
			pos.add(StringUtil.quote(keyword, StringPool.PERCENT));
			List<PSPolicy> psPolicies = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					PSPolicy psPolicy = new PSPolicy();
					psPolicy.setIqumaId((String) objects[i++]);
					psPolicy.setProposal_no(Long.parseLong((String) objects[i++]));
					psPolicy.setPolicy_status((String) objects[i++]);
					psPolicy.setClient_Code(((BigDecimal) objects[i++]).longValue());
					psPolicy.setClient_name((String) objects[i++]);
					psPolicy.setStatus_description((String) objects[i++]);
					psPolicy.setIssue_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_start_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));
					psPolicy.setPolicy_expiry_date(dateFormat.format(new Date(((Timestamp) objects[i++]).getTime())));

					psPolicies.add(psPolicy);
				}
			}

			return psPolicies;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public String findInvestmentDate(String toDate) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_INVESTMENT_DATE);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(toDate);
			query.setCacheable(false);
			return dateFormat.format(new Date(((Timestamp) query.list().get(0)).getTime()));
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public String findWithdrawel(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_WITHDRAWAL_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> soaDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 1;
					SOADetail soaDetail = new SOADetail();
					soaDetail.setWithdraw(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetails.add(soaDetail);
				}
			}
			if (soaDetails.size() > 0)
				return soaDetails.get(0).getWithdraw();
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public SOADetail findPolicySummaryByIqumaId(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_POLICY_SUMMARY_BY_ID);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> soaDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;

					SOADetail soaDetail = new SOADetail();
					soaDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					i++;
					soaDetail.setInstallment_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setPremium_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setPremium_to_be_invested(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setInstallment_remaining(soaDetail.getPremium_to_be_invested());

					soaDetails.add(soaDetail);
				}
			}
			if (soaDetails.size() > 0)
				return soaDetails.get(0);
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public SOADetail findCustomerAddressByIqumaId(String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_CUSTOMER_ADDRESS);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> soaDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					SOADetail soaDetail = new SOADetail();
					String type = (String) objects[i++];
					String a = (String) objects[i++];
					soaDetail.setNad_address1((String) objects[i++]);
					soaDetail.setMailingAddress1((String) objects[i++]);
					soaDetails.add(soaDetail);
//					if("P".equals(type)){
//						soaDetail.setNad_address1((String) objects[i++]);
//						soaDetail.setNad_address2((String) objects[i++]);
//						soaDetail.setNad_address3((String) objects[i++]);
//						soaDetails.add(soaDetail);
//					}else if("C".equals(type)){
//						soaDetail.setMailingAddress1((String) objects[i++]);
//						soaDetail.setMailingAddress2((String) objects[i++]);
//						soaDetail.setMailingAddress3((String) objects[i++]);
//						soaDetails.add(soaDetail);
//					}
				}
			}
			if (soaDetails.size() > 0)
				return soaDetails.get(0);
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public SOADetail findPolicyPremiumByDate(String fromDate, String toDate, String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			String tempQuery = FIND_PS_POLICY_PREMIUM.replace("[$fromdt]", "'" + toDate + "'");
			tempQuery = tempQuery.replace("[$uptodt]", "'" + toDate + "'");
			SQLQuery query = session.createSQLQuery(tempQuery);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> soaDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					BigDecimal topUp;
					SOADetail soaDetail = new SOADetail();
					soaDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					soaDetail.setStatement_date((String) objects[i++]);
					soaDetail.setPremium_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setTotal_premium_due(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setPremium_not_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setPremium(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					topUp = (BigDecimal) objects[i++];
					soaDetail.setTopup_premium(Validator.isNotNull(topUp) ? String.format("%.0f", (topUp).doubleValue()) : "0");
					soaDetail.setCredit_balance(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					i++; // withdrawal
					i++; // total_inst_no
					soaDetail.setInstallment_remaining(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
//					soaDetail.setInstallment_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
//					soaDetail.setPremium_to_be_invested(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
//					soaDetail.setInstallment_remaining(soaDetail.getPremium_to_be_invested());

					soaDetails.add(soaDetail);
				}
			}
			if (soaDetails.size() > 0)
				return soaDetails.get(0);
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}

	public SOADetail findPolicyPremiumDetailsByDate(String fromDate, String toDate, String id) throws PortalException {
		Session session = null;
		try {
			session = openSession();
			String tempQuery = FIND_PS_POLICY_PREMIUM_DETAILS.replaceAll("uptodt", "'" + toDate + "'");
//	        tempQuery = tempQuery.replace("[$uptodt]","'"+toDate+"'");
			SQLQuery query = session.createSQLQuery(tempQuery);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(id);
			List<SOADetail> soaDetails = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					BigDecimal topUp;
					SOADetail soaDetail = new SOADetail();
					soaDetail.setProposal_no(Long.parseLong((String) objects[i++]));
					soaDetail.setStatement_date((String) objects[i++]);
					soaDetail.setPremium_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					soaDetail.setTotal_premium_due(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					BigDecimal premiumNotPaid = (BigDecimal) objects[i++];
					soaDetail.setPremium_not_paid(String.valueOf(premiumNotPaid.doubleValue() < 0 ? 0 : premiumNotPaid.intValue()));
					soaDetail.setPremium(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					topUp = (BigDecimal) objects[i++];
					soaDetail.setTopup_premium(Validator.isNotNull(topUp) ? String.format("%.0f", (topUp).doubleValue()) : "0");
					soaDetail.setCredit_balance(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					i++; // withdrawal
					soaDetail.setInstallment_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
					int installmentsRemaining = ((BigDecimal) objects[i++]).intValue();
					soaDetail.setInstallment_remaining(String.valueOf(installmentsRemaining < 0 ? 0 : installmentsRemaining));
//					soaDetail.setInstallment_paid(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
//					soaDetail.setPremium_to_be_invested(String.format("%.0f", Math.abs(((BigDecimal) objects[i++]).doubleValue())));
//					soaDetail.setInstallment_remaining(soaDetail.getPremium_to_be_invested());

					soaDetails.add(soaDetail);
				}
			}
			if (soaDetails.size() > 0)
				return soaDetails.get(0);
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				LOG.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	}
}
