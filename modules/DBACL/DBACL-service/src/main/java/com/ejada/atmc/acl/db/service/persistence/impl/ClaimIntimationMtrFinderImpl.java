package com.ejada.atmc.acl.db.service.persistence.impl;

import com.ejada.atmc.acl.db.custom.model.PSPolicy;
import com.ejada.atmc.acl.db.model.ClaimIntimationMtr;
import com.ejada.atmc.acl.db.model.impl.ClaimIntimationMtrImpl;
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

	private final static String	GET_SEQUENCE_NUMBER		= "select CIM_SYS_ID_SEQ.Nextval from dual";
	private final static String	FIND_CLAIM_INTIMATIONS	= "select * from CLAIM_INTIMATION_MTR where INTIMATION_REF like ?";
	SimpleDateFormat		dateFormat									= new SimpleDateFormat("MM/dd/yy");

	Log							_log					= LogFactoryUtil.getLog(this.getClass());

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

	public List<ClaimIntimationMtr> findClaimIntimationList(String keyword){
		Session session = null;
		try {
			session = openSession();
			SQLQuery query = session.createSQLQuery(FIND_CLAIM_INTIMATIONS);
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
					claimIntimationList.add(claimIntimationMtr);
				}
			}
			return claimIntimationList;
		} catch (Exception e) {
			try {
				throw new SystemException(e);
			} catch (SystemException se) {
				_log.error(se.getMessage(), se);
			}
		} finally {
			closeSession(session);
		}
		return null;
	
		
	}
}
