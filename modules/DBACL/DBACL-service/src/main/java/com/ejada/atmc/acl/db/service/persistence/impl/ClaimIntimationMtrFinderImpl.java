package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO;
import com.ejada.atmc.acl.db.custom.model.ODSPolActiveVehicleDTO;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrImpl;
import com.ejada.atmc.acl.db.service.persistence.ClaimHDRFinder;
import com.ejada.atmc.acl.db.service.persistence.ClaimIntimationMtrFinder;
import com.liferay.petra.string.StringPool;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.osgi.service.component.annotations.Component;

@Component(
		service = ClaimIntimationMtrFinder.class
)
public class ClaimIntimationMtrFinderImpl extends ClaimIntimationMtrFinderBaseImpl implements ClaimIntimationMtrFinder {

	private final static String	GET_SEQUENCE_NUMBER					= "select CIM_SYS_ID_SEQ.Nextval from dual";
	private final static String	FIND_CLAIM_INTIMATION_LIST			= "select * from CLAIM_INTIMATION_MTR where INTIMATION_REF like ?";
//	private final static String FIND_CLAIM_STATUS_FROM_VIEW = "Select b.*, a.claim_no, a.policy_no, nvl(a.clm_status, 'intimation successful') claim_status, a.created_by, a.creation_date   from  claim_intimation_mtr b,  ods_clm_intm_list a    where b.intimation_ref=a.intimation_ref(+) and b.intimation_ref in ('REFERENCE_NO')  ";
	private final static String	FIND_CLAIM_STATUS_FROM_VIEW			= "Select b.*, a.claim_no clm_number, a.policy_no pol_number,         (select cd.mdm_code_desc from pm_code_master cd where cd.mdm_code = 'CLM_INTM_STS' and cd.mdm_code_sub = nvl(NVL(a.clm_status,b.Claim_Status),1)) clm_status,                 a.created_by,         a.creation_date  from claim_intimation_mtr b,  ods_clm_intm_list a  where b.intimation_ref=a.intimation_ref(+)  and b.intimation_ref in ('REFERENCE_NO')  ";
//	private final static String FIND_CLAIM_INTIMATIONS_BY_CATEGORY = "Select b.*, nvl(a.clm_status, 'Intimation Successful') claim_status  from  claim_intimation_mtr b,  ods_clm_intm_list a   where b.intimation_ref=a.intimation_ref(+) and";
//	private final static String FIND_CLAIM_INTIMATIONS_BY_CATEGORY = "Select b.* from  claim_intimation_mtr b where ";
	private final static String	FIND_CLAIM_INTIMATIONS_BY_CATEGORY	= "Select b.*, a.claim_no clm_number, a.policy_no pol_number,    (select cd.mdm_code_desc from pm_code_master cd where cd.mdm_code = 'CLM_INTM_STS' and cd.mdm_code_sub = nvl(NVL(a.clm_status,b.Claim_Status),1)) clm_status,  a.created_by,  a.creation_date from claim_intimation_mtr b,  ods_clm_intm_list a where b.intimation_ref=a.intimation_ref(+)  and ";
	private final static String	GET_ALL_CLAIMS						= "select * from claim_intimation_mtr";
	private final static String	FIND_ODS_VEHICLE_ACTIVE_LIST		= "Select POLICYNUMBER, VEH_CHASSIS_NUMBER, EXPIRY_DT from  ODS_POL_VEH_ACTIVE_LIST where veh_chassis_number='CHASSIS_NUM_DATA'  and policynumber ='POLICY_NUM_DATA' and rownum = 1";
	private final static String	FIND_CLAIM_STATUS					= "Select b.*, a.claim_no clm_number, a.policy_no pol_number, (select cd.mdm_code_desc from pm_code_master cd where cd.mdm_code = 'CLM_INTM_STS' and cd.mdm_code_sub = nvl(NVL(a.clm_status,b.Claim_Status),1)) clm_status, a.created_by,  a.creation_date from claim_intimation_mtr b,  ods_clm_intm_list a where b.intimation_ref=a.intimation_ref(+) and b.intimation_ref='FIND_BY_VALUE' or b.mobile_nO='FIND_BY_VALUE' or a.claim_no='FIND_BY_VALUE' or b.driver_national_id='FIND_BY_VALUE' or b.ACCIDENT_REPORT_NO='FIND_BY_VALUE'";
	private final static String	FETCH_LAST_RECORD					= "select intimation_ref from claim_intimation_mtr where rowid=(select max(rowid) from claim_intimation_mtr)";

	SimpleDateFormat			dateFormat							= new SimpleDateFormat("MM/dd/yy");

	Log							_log								= LogFactoryUtil.getLog(this.getClass());

	public ClaimIntimationMtr fetchLastRecord() {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FETCH_LAST_RECORD);
			query.setCacheable(false);
			List<ClaimIntimationMtr> claimIntimationList = new ArrayList<>();
			List<String> data = query.list();
			if (data != null) {
				String refNumber = (String) data.get(0);
				ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();
				claimIntimationMtr.setIntimationReferenceNo(refNumber);
				return claimIntimationMtr;
			}
			return null;
		} catch (Exception e) {
			_log.error("No Database Record found! Error-message ::::" + e.getMessage() + " caused by ::::" + e.getCause());
			return null;
		} finally {
			closeSession(session);
		}
	}

	public List<ClaimIntimationMtr> getAllClaims() {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(GET_ALL_CLAIMS);
			query.setCacheable(false);
			List<ClaimIntimationMtr> claimIntimationList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();
					claimIntimationMtr.setClaimIntimationMotorId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setIntimationReferenceNo((String) objects[i++]);
					claimIntimationMtr.setClaimantType((String) objects[i++]);
					claimIntimationMtr.setPolicyNo((String) objects[i++]);
					claimIntimationMtr.setVehiclePlateNo((String) objects[i++]);
					claimIntimationMtr.setSequenceNo(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setChassisNo((String) objects[i++]);
					claimIntimationMtr.setMobileNo((String) objects[i++]);
					claimIntimationMtr.setCauseOfLoss((String) objects[i++]);
					claimIntimationMtr.setDateOfLoss(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setAccidentCity((String) objects[i++]);
					claimIntimationMtr.setDescOfAccident((String) objects[i++]);
					claimIntimationMtr.setSrcOfAccidentReport((String) objects[i++]);
					claimIntimationMtr.setAccidentReportNo((String) objects[i++]);
					claimIntimationMtr.setVehicleMake((String) objects[i++]);
					claimIntimationMtr.setVehicleModel((String) objects[i++]);
					claimIntimationMtr.setDriverName((String) objects[i++]);
					claimIntimationMtr.setDriverNationality((String) objects[i++]);
					claimIntimationMtr.setDriverNationalId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setDriverBirthDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setDriverGender((String) objects[i++]);
					i++;
					BigDecimal status = ((BigDecimal) objects[i++]);
					claimIntimationMtr.setClaimStatus(status != null ? status.intValue() : 1);
					claimIntimationMtr.setIbanNumber((String) objects[i++]);
					claimIntimationMtr.setBankName((String) objects[i++]);
					claimIntimationMtr.setEmailId((String) objects[i++]);
					claimIntimationList.add(claimIntimationMtr);
				}
			}
			return claimIntimationList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return new ArrayList<>();
			}
		} finally {
			closeSession(session);
		}
	}

	public ODSPolActiveVehicleDTO findOdsVehicleActiveList(String chassisNo, String policyNo) {
		Session session = null;
		try {
			session = openSession();
			String queryBuilder = FIND_ODS_VEHICLE_ACTIVE_LIST.replace("CHASSIS_NUM_DATA", chassisNo).replace("POLICY_NUM_DATA", policyNo);
			SQLQuery query = session.createSQLQuery(queryBuilder);
			query.setCacheable(false);
			/*
			 * QueryPos pos = QueryPos.getInstance(query); pos.add(StringUtil.quote(chassisNo, "'"));
			 * pos.add(StringUtil.quote(policyNo, "'"));
			 */

			List<ODSPolActiveVehicleDTO> claimIntimationList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ODSPolActiveVehicleDTO odsPolActiveVehicleDTO = new ODSPolActiveVehicleDTO();
					odsPolActiveVehicleDTO.setPolicyNo((String) objects[i++]);
					odsPolActiveVehicleDTO.setVehChassisNo((String) objects[i++]);
					odsPolActiveVehicleDTO.setPolicyExpiryDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationList.add(odsPolActiveVehicleDTO);
				}
			}
			if (claimIntimationList.size() > 0)
				return claimIntimationList.get(0);
			return null;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return null;
			}
		} finally {
			closeSession(session);
		}

	}

	public long getClaimIntimationSequence() {
		Session session = null;
		long sequenceNumber = 0;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(GET_SEQUENCE_NUMBER);
			List<BigDecimal> data = query.list();
			sequenceNumber = ((BigDecimal) data.get(0)).longValue();
			return sequenceNumber;
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			return 0;
		}
	}

	public List<ClaimIntimationMtr> findClaimIntimationList(String keyword) {
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_CLAIM_INTIMATION_LIST);
			query.setCacheable(false);
			QueryPos pos = QueryPos.getInstance(query);
			pos.add(StringUtil.quote(keyword, StringPool.PERCENT));
			List<ClaimIntimationMtr> claimIntimationList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();
					claimIntimationMtr.setClaimIntimationMotorId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setIntimationReferenceNo((String) objects[i++]);
					claimIntimationMtr.setClaimantType((String) objects[i++]);
					claimIntimationMtr.setPolicyNo((String) objects[i++]);
					claimIntimationMtr.setVehiclePlateNo((String) objects[i++]);
					claimIntimationMtr.setSequenceNo(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setChassisNo((String) objects[i++]);
					claimIntimationMtr.setMobileNo((String) objects[i++]);
					claimIntimationMtr.setCauseOfLoss((String) objects[i++]);
					claimIntimationMtr.setDateOfLoss(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setAccidentCity((String) objects[i++]);
					claimIntimationMtr.setDescOfAccident((String) objects[i++]);
					claimIntimationMtr.setSrcOfAccidentReport((String) objects[i++]);
					claimIntimationMtr.setAccidentReportNo((String) objects[i++]);
					claimIntimationMtr.setVehicleMake((String) objects[i++]);
					claimIntimationMtr.setVehicleModel((String) objects[i++]);
					claimIntimationMtr.setDriverName((String) objects[i++]);
					claimIntimationMtr.setDriverNationality((String) objects[i++]);
					claimIntimationMtr.setDriverNationalId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setDriverBirthDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setDriverGender((String) objects[i++]);
					i++;
					BigDecimal status = ((BigDecimal) objects[i++]);
					claimIntimationMtr.setClaimStatus(status != null ? status.intValue() : 1); // claim status
					claimIntimationMtr.setIbanNumber((String) objects[i++]);
					claimIntimationMtr.setBankName((String) objects[i++]);
					claimIntimationMtr.setEmailId((String) objects[i++]);
					claimIntimationList.add(claimIntimationMtr);
				}
			}
			return claimIntimationList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return new ArrayList<>();
			}
		} finally {
			closeSession(session);
		}
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationsByCategory(String findByCategory, String findByValue) {
		Session session = null;
		try {
			session = openSession();
			String queryBuilder = FIND_CLAIM_INTIMATIONS_BY_CATEGORY;
			queryBuilder += findByCategory.equals("claim_no") ? "a." : " b.";
			queryBuilder += findByCategory + "=" + (findByCategory.equalsIgnoreCase("Mobile_No") ? "" : "'") + findByValue + (findByCategory.equalsIgnoreCase("Mobile_No") ? "" : "'");
			SQLQuery query = session.createSQLQuery(queryBuilder);
			query.setCacheable(false);
			List<ClaimIntimationMtrDTO> claimIntimationDTOList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ClaimIntimationMtrDTO claimIntimationMtrDTO = new ClaimIntimationMtrDTO();
					ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();
					claimIntimationMtr.setClaimIntimationMotorId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setIntimationReferenceNo((String) objects[i++]);
					claimIntimationMtr.setClaimantType((String) objects[i++]);
					claimIntimationMtr.setPolicyNo((String) objects[i++]);
					claimIntimationMtr.setVehiclePlateNo((String) objects[i++]);
					claimIntimationMtr.setSequenceNo(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setChassisNo((String) objects[i++]);
					claimIntimationMtr.setMobileNo((String) objects[i++]);
					claimIntimationMtr.setCauseOfLoss((String) objects[i++]);
					claimIntimationMtr.setDateOfLoss(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setAccidentCity((String) objects[i++]);
					claimIntimationMtr.setDescOfAccident((String) objects[i++]);
					claimIntimationMtr.setSrcOfAccidentReport((String) objects[i++]);
					claimIntimationMtr.setAccidentReportNo((String) objects[i++]);
					claimIntimationMtr.setVehicleMake((String) objects[i++]);
					claimIntimationMtr.setVehicleModel((String) objects[i++]);
					claimIntimationMtr.setDriverName((String) objects[i++]);
					claimIntimationMtr.setDriverNationality((String) objects[i++]);
					claimIntimationMtr.setDriverNationalId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setDriverBirthDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setDriverGender((String) objects[i++]);
					i++;
					BigDecimal status = ((BigDecimal) objects[i++]);
					claimIntimationMtr.setClaimStatus(status != null ? status.intValue() : 1); // claim status
					claimIntimationMtr.setIbanNumber((String) objects[i++]);
					claimIntimationMtr.setBankName((String) objects[i++]);
					claimIntimationMtr.setEmailId((String) objects[i++]);
					claimIntimationMtrDTO.setClaimNumber((String) objects[i++]);
					claimIntimationMtrDTO.setPolicyNumber((String) objects[i++]);
					claimIntimationMtrDTO.setClaimStatus((String) objects[i++]);
					claimIntimationMtrDTO.setCreatedBy((String) objects[i++]);
					Timestamp ts = (Timestamp) objects[i++];
					claimIntimationMtrDTO.setCreationDate(ts != null ? new Date((ts).getTime()) : null);
					claimIntimationMtrDTO.setClaimIntimationMtr(claimIntimationMtr);
					claimIntimationDTOList.add(claimIntimationMtrDTO);
				}
			}
			return claimIntimationDTOList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return new ArrayList<>();
			}
		} finally {
			closeSession(session);
		}
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationsStatus(String findByValue) {
		Session session = null;
		try {
			session = openSession();
			String queryBuilder = FIND_CLAIM_STATUS.replaceAll("FIND_BY_VALUE", findByValue);
			SQLQuery query = session.createSQLQuery(queryBuilder);
			query.setCacheable(false);
			List<ClaimIntimationMtrDTO> claimIntimationDTOList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ClaimIntimationMtrDTO claimIntimationMtrDTO = new ClaimIntimationMtrDTO();
					ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();
					claimIntimationMtr.setClaimIntimationMotorId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setIntimationReferenceNo((String) objects[i++]);
					claimIntimationMtr.setClaimantType((String) objects[i++]);
					claimIntimationMtr.setPolicyNo((String) objects[i++]);
					claimIntimationMtr.setVehiclePlateNo((String) objects[i++]);
					claimIntimationMtr.setSequenceNo(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setChassisNo((String) objects[i++]);
					claimIntimationMtr.setMobileNo((String) objects[i++]);
					claimIntimationMtr.setCauseOfLoss((String) objects[i++]);
					claimIntimationMtr.setDateOfLoss(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setAccidentCity((String) objects[i++]);
					claimIntimationMtr.setDescOfAccident((String) objects[i++]);
					claimIntimationMtr.setSrcOfAccidentReport((String) objects[i++]);
					claimIntimationMtr.setAccidentReportNo((String) objects[i++]);
					claimIntimationMtr.setVehicleMake((String) objects[i++]);
					claimIntimationMtr.setVehicleModel((String) objects[i++]);
					claimIntimationMtr.setDriverName((String) objects[i++]);
					claimIntimationMtr.setDriverNationality((String) objects[i++]);
					claimIntimationMtr.setDriverNationalId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setDriverBirthDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setDriverGender((String) objects[i++]);
					i++;
					BigDecimal status = ((BigDecimal) objects[i++]);
					claimIntimationMtr.setClaimStatus(status != null ? status.intValue() : 1); // claim status
					claimIntimationMtr.setIbanNumber((String) objects[i++]);
					claimIntimationMtr.setBankName((String) objects[i++]);
					claimIntimationMtr.setEmailId((String) objects[i++]);
					claimIntimationMtrDTO.setClaimNumber((String) objects[i++]);
					claimIntimationMtrDTO.setPolicyNumber((String) objects[i++]);
					claimIntimationMtrDTO.setClaimStatus((String) objects[i++]);
					claimIntimationMtrDTO.setCreatedBy((String) objects[i++]);
					Timestamp ts = (Timestamp) objects[i++];
					claimIntimationMtrDTO.setCreationDate(ts != null ? new Date((ts).getTime()) : null);
					claimIntimationMtrDTO.setClaimIntimationMtr(claimIntimationMtr);
					claimIntimationDTOList.add(claimIntimationMtrDTO);
				}
			}
			return claimIntimationDTOList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return new ArrayList<>();
			}
		} finally {
			closeSession(session);
		}
	}

	public List<ClaimIntimationMtrDTO> findClaimIntimationListByReferenceNoFromView(String referenceNo) {
		Session session = null;
		try {
			session = openSession();
			String queryBuilder = FIND_CLAIM_STATUS_FROM_VIEW.replace("REFERENCE_NO", referenceNo);
			SQLQuery query = session.createSQLQuery(queryBuilder);
			query.setCacheable(false);
			List<ClaimIntimationMtrDTO> claimIntimationDTOList = new ArrayList<>();
			List<Object[]> data = query.list();
			if (Validator.isNotNull(data)) {
				for (Object[] objects : data) {
					int i = 0;
					ClaimIntimationMtrDTO claimIntimationMtrDTO = new ClaimIntimationMtrDTO();
					ClaimIntimationMtr claimIntimationMtr = new ClaimIntimationMtrImpl();

					claimIntimationMtr.setClaimIntimationMotorId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setIntimationReferenceNo((String) objects[i++]);
					claimIntimationMtr.setClaimantType((String) objects[i++]);
					claimIntimationMtr.setPolicyNo((String) objects[i++]);
					claimIntimationMtr.setVehiclePlateNo((String) objects[i++]);
					claimIntimationMtr.setSequenceNo(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setChassisNo((String) objects[i++]);
					claimIntimationMtr.setMobileNo((String) objects[i++]);
					claimIntimationMtr.setCauseOfLoss((String) objects[i++]);
					claimIntimationMtr.setDateOfLoss(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setAccidentCity((String) objects[i++]);
					claimIntimationMtr.setDescOfAccident((String) objects[i++]);
					claimIntimationMtr.setSrcOfAccidentReport((String) objects[i++]);
					claimIntimationMtr.setAccidentReportNo((String) objects[i++]);
					claimIntimationMtr.setVehicleMake((String) objects[i++]);
					claimIntimationMtr.setVehicleModel((String) objects[i++]);
					claimIntimationMtr.setDriverName((String) objects[i++]);
					claimIntimationMtr.setDriverNationality((String) objects[i++]);
					claimIntimationMtr.setDriverNationalId(((BigDecimal) objects[i++]).longValue());
					claimIntimationMtr.setDriverBirthDate(new Date(((Timestamp) objects[i++]).getTime()));
					claimIntimationMtr.setDriverGender((String) objects[i++]);
					i++; // attachment reference
					BigDecimal status = ((BigDecimal) objects[i++]);
					claimIntimationMtr.setClaimStatus(status != null ? status.intValue() : 1); // claim status
					claimIntimationMtr.setIbanNumber((String) objects[i++]);
					claimIntimationMtr.setBankName((String) objects[i++]);
					claimIntimationMtr.setEmailId((String) objects[i++]);
					claimIntimationMtrDTO.setClaimNumber((String) objects[i++]);
					claimIntimationMtrDTO.setPolicyNumber((String) objects[i++]);
					claimIntimationMtrDTO.setClaimStatus((String) objects[i++]);
					claimIntimationMtrDTO.setCreatedBy((String) objects[i++]);
					Timestamp ts = (Timestamp) objects[i++];

					claimIntimationMtrDTO.setCreationDate(ts != null ? new Date((ts).getTime()) : null);
					claimIntimationMtrDTO.setClaimIntimationMtr(claimIntimationMtr);
					claimIntimationDTOList.add(claimIntimationMtrDTO);
				}
			}
			return claimIntimationDTOList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
				return new ArrayList<>();
			}
		} finally {
			closeSession(session);
		}
	}
}
