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

package com.ejada.atmc.acl.db.service.impl;

import com.ejada.atmc.acl.db.domain.tariff.TariffInput;
import com.ejada.atmc.acl.db.domain.tariff.TariffOutput;
import com.ejada.atmc.acl.db.service.base.TariffLocalServiceBaseImpl;
import com.liferay.portal.aop.AopService;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.sql.DataSource;

import org.osgi.service.component.annotations.Component;

import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;

/**
 * The implementation of the tariff local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy
 * their definitions into the <code>com.ejada.atmc.acl.db.service.TariffLocalService</code> interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see    TariffLocalServiceBaseImpl
 */
@Component(
		property = "model.class.name=com.ejada.atmc.acl.db.model.Tariff",
		service = AopService.class
)
public class TariffLocalServiceImpl extends TariffLocalServiceBaseImpl {
	private static final String PROC_NAME = "pkg_calc_prem.prc_prem_calc_aggr";

	public ArrayList<TariffOutput> getTariffData(TariffInput tariffInput) throws PortalException, SQLException {
		ArrayList<TariffOutput> trfOutput = new ArrayList<TariffOutput>();
		_log.info("Tariffinput data ::::::::::::::::: " + tariffInput.toString());
		Connection connection = null;
		try {
			Calendar cal = Calendar.getInstance();
			cal.setTime(new Date());
			int current = cal.get(1);
			int vehYear = Integer.valueOf(tariffInput.getMFGYear()).intValue();
			System.err.println("vehYear >>>>>>>>>> " + vehYear);
			System.err.println("current >>>>>>>>>> " + current);
			DataSource src = smsPersistence.getDataSource();
			connection = src.getConnection();
			_log.info(
					"====================================================================calling procedure===================================================");
			CallableStatement cs = connection.prepareCall("{Call " + PROC_NAME + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			cs.setString(1, tariffInput.getProductCode());
			cs.setInt(2, tariffInput.getVehicleValue());
			_log.info("-------Procedure Input--------");
			cs.setDate(3, tariffInput.getEffFromDate());
			cs.setString(4, tariffInput.getSchemeCode());
			cs.setString(5, tariffInput.getRegion());
			cs.setInt(6, tariffInput.getGender());
			cs.setDate(7, tariffInput.getDriverAge());
			cs.setInt(8, tariffInput.getMake());
			cs.setInt(9, tariffInput.getVehicleModel());
			cs.setInt(10, tariffInput.getMFGYear());
			cs.setInt(11, Integer.valueOf(tariffInput.getBodyType()));
			// cs.setInt(11, tariffInput.getColor());
			cs.setInt(12, tariffInput.getColor());
			// cs.setInt(12, tariffInput.getPurposeVeh());
			cs.setString(13, String.valueOf(tariffInput.getPurposeVeh()));
			cs.setInt(14, tariffInput.getRepair());
			cs.setDouble(15, tariffInput.getLoyalty());
			cs.setString(16, tariffInput.getUniqueIdentifier());
			cs.setInt(17, tariffInput.getClmFreeYears());
			cs.setInt(18, tariffInput.getNcdDrv1());
			cs.setInt(19, tariffInput.getNcdDrv2());
			cs.setInt(20, tariffInput.getNcdDrv3());
			cs.setInt(21, tariffInput.getNcdDrv4());
			cs.setInt(22, tariffInput.getNcdDrv5());
			cs.setString(23, tariffInput.getSpecialDiscount());
			cs.setLong(24, tariffInput.getInsuredid());
			cs.setString(25, tariffInput.getChassisno());
			cs.setInt(26, tariffInput.getMaritalStatus());
			cs.registerOutParameter(27, Types.VARCHAR);
			_log.info(tariffInput.toString());
			cs.registerOutParameter(28, OracleTypes.CURSOR);
			cs.executeQuery();
			_log.info(
					"======================================================Query successfully executed========================================================");

			ResultSet rset = ((OracleCallableStatement) cs).getCursor(28);
			while (rset.next()) {
				TariffOutput output = new TariffOutput();
				output.setUniqueIdentifier(rset.getString(1));
				output.setSerialNumber(rset.getInt(2));
				output.setCode(rset.getString(3));
				output.setTameeniCode(rset.getString(4));
				output.setProductName(rset.getString(5));
				output.setCoverType(rset.getString(6));
				output.setPremiumRate(rset.getString(7));
				output.setLoadingPercentage(rset.getString(8));
				output.setMinimumPremium(rset.getString(9));
				output.setExcessAmount(rset.getString(10));
				output.setIsAutofill(rset.getString(11));
				output.setPremiumAmount(rset.getString(12));
				output.setApplicableCoverType(rset.getString(13));
				output.setBasicCover(rset.getString(14));
				trfOutput.add(output);

				_log.info("uniqueidentifier " + rset.getString(1));
				_log.info("Serial Number " + rset.getInt(2));
				_log.info("code " + rset.getString(3));
				_log.info("tmind " + rset.getString(4));
				_log.info("product Name " + rset.getString(5));
				_log.info("cover Type" + rset.getString(6));
				_log.info("premium rate" + rset.getString(7));
				_log.info("loading Percentage" + rset.getString(8));
				_log.info("min premium " + rset.getString(9));
				_log.info("excess amt " + rset.getString(10));
				_log.info("is autofill " + rset.getString(11));
				_log.info("premium amount " + rset.getString(12));
				_log.info("applicable cvt yn " + rset.getString(13));
				_log.info("basic cvt yn " + rset.getString(14));

			}
		} catch (Exception e) {
			_log.error(e);
			throw new PortalException(e);
		} finally {
			if (connection != null)
				connection.close();
		}
		return trfOutput;
	}

	private static final Log _log = LogFactoryUtil.getLog(TariffLocalServiceImpl.class);
}