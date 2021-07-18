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

package com.atmc.bsl.db.service.http;

import com.atmc.bsl.db.service.QuotationServiceUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * <code>QuotationServiceUtil</code> service
 * utility. The static methods of this class call the same methods of the
 * service utility. However, the signatures are different because it is
 * difficult for SOAP to support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationServiceHttp
 * @deprecated As of Athanasius (7.3.x), with no direct replacement
 * @generated
 */
@Deprecated
public class QuotationServiceSoap {

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getCountries()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue = QuotationServiceUtil.getCountries();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getCities()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue = QuotationServiceUtil.getCities();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getParkingLocations()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue =
							QuotationServiceUtil.getParkingLocations();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getEngineSizes()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue = QuotationServiceUtil.getEngineSizes();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getDeductibleValues()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue =
							QuotationServiceUtil.getDeductibleValues();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getPurposeOfVehicle()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue =
							QuotationServiceUtil.getPurposeOfVehicle();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
				getInsuranceCompanies()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>
						returnValue =
							QuotationServiceUtil.getInsuranceCompanies();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> personalInfo(
				com.atmc.bsl.db.domain.quotation.Quotation quot,
				boolean isUserSignedIn)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.Quotation> returnValue =
					QuotationServiceUtil.personalInfo(quot, isUserSignedIn);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>>
				getPendingQuotations(String iqamaId)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>>
					returnValue = QuotationServiceUtil.getPendingQuotations(
						iqamaId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadVideo(
			String baseArray, String fileName, String quotationId,
			java.util.Date videoDate)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<Boolean> returnValue =
				QuotationServiceUtil.uploadVideo(
					baseArray, fileName, quotationId, videoDate);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> clearQuoteFile(
			String fileName, String insuredId)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<Boolean> returnValue =
				QuotationServiceUtil.clearQuoteFile(fileName, insuredId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.domain.tariff.TariffOutput> getTariffData(
				com.ejada.atmc.acl.db.domain.tariff.TariffInput tariffInput)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.db.domain.tariff.TariffOutput> returnValue =
					QuotationServiceUtil.getTariffData(tariffInput);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.ejada.atmc.acl.db.model.CodeMasterMap> getBySourceTypeSourceCode(
				String sourceType, String sourceCode)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.ejada.atmc.acl.db.model.CodeMasterMap> returnValue =
					QuotationServiceUtil.getBySourceTypeSourceCode(
						sourceType, sourceCode);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover>>
				getCoverList(String productCode)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.quotation.QuotationCover>>
						returnValue = QuotationServiceUtil.getCoverList(
							productCode);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> tokenizationResult(
				String status)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.Quotation> returnValue =
					QuotationServiceUtil.tokenizationResult(status);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.QuotationDriver> addDriver(
				com.atmc.bsl.db.domain.quotation.QuotationDriver driver,
				com.atmc.bsl.db.domain.quotation.QuotationUserAddress
					driverNatAddress,
				com.atmc.bsl.db.domain.quotation.QuotationUserAddress
					driverOffNatAddress)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.QuotationDriver> returnValue =
					QuotationServiceUtil.addDriver(
						driver, driverNatAddress, driverOffNatAddress);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getEducationList()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue = QuotationServiceUtil.getEducationList();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
				getLicenseTypes()
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<java.util.List
					<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>
						returnValue = QuotationServiceUtil.getLicenseTypes();

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> renewPolicy(
				com.atmc.bsl.db.domain.policy.Policy policy,
				com.atmc.bsl.db.domain.policy.PolicyVehicle pVeh)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.Quotation> returnValue =
					QuotationServiceUtil.renewPolicy(policy, pVeh);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			getConfigurableValues(java.util.List<String> keys)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				QuotationServiceUtil.getConfigurableValues(keys);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Double>
			quickQuoteInquiry(com.atmc.bsl.db.domain.quotation.Quotation quot)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<Double> returnValue =
				QuotationServiceUtil.quickQuoteInquiry(quot);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Integer>
			countQuotationSurveyVideo(String quoteID)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<Integer> returnValue =
				QuotationServiceUtil.countQuotationSurveyVideo(quoteID);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			downloadQuotDetsFile(String quoteId, String lang)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				QuotationServiceUtil.downloadQuotDetsFile(quoteId, lang);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String>
			downloadPolicyFile(String quoteId, String policyNo, String lang)
		throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput<String> returnValue =
				QuotationServiceUtil.downloadPolicyFile(
					quoteId, policyNo, lang);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationDetails(
				String quotId)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.Quotation> returnValue =
					QuotationServiceUtil.getQuotationDetails(quotId);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput
		<com.atmc.bsl.db.domain.quotation.Quotation> getTariffDetails(
				com.atmc.bsl.db.domain.quotation.Quotation quot,
				java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver>
					drivers)
			throws RemoteException {

		try {
			com.atmc.bsl.db.domain.ServiceOutput
				<com.atmc.bsl.db.domain.quotation.Quotation> returnValue =
					QuotationServiceUtil.getTariffDetails(quot, drivers);

			return returnValue;
		}
		catch (Exception exception) {
			_log.error(exception, exception);

			throw new RemoteException(exception.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(QuotationServiceSoap.class);

}