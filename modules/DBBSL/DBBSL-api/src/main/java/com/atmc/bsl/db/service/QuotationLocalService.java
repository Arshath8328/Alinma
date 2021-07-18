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

package com.atmc.bsl.db.service;

import com.atmc.bsl.db.domain.codemaster.CodeMasterDetails;
import com.atmc.bsl.db.domain.policy.Policy;
import com.atmc.bsl.db.domain.quotation.CustomerMapDetails;
import com.atmc.bsl.db.domain.quotation.Quotation;
import com.atmc.bsl.db.domain.quotation.QuotationCover;
import com.atmc.bsl.db.domain.quotation.QuotationCustUploads;
import com.atmc.bsl.db.domain.quotation.QuotationDriver;
import com.atmc.bsl.db.domain.quotation.QuotationNajmDetails;
import com.atmc.bsl.db.domain.quotation.QuotationTameeniExtraDetails;
import com.atmc.bsl.db.domain.quotation.QuotationUserAddress;
import com.atmc.bsl.db.domain.quotation.QuotationVehicleImage;
import com.atmc.bsl.db.exception.NajmException;
import com.atmc.bsl.db.exception.YaqeenException;

import com.ejada.atmc.acl.db.model.CustUploads;
import com.ejada.atmc.acl.db.model.PolicyHDR;
import com.ejada.atmc.acl.db.model.ProductCovers;
import com.ejada.atmc.acl.db.model.QuotationAdminUploads;
import com.ejada.atmc.acl.db.model.QuotationSurvey;
import com.ejada.atmc.acl.db.model.Quotations;
import com.ejada.atmc.acl.ws.domain.payFort.PurchaseResponse;

import com.liferay.portal.kernel.exception.ModelListenerException;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.BaseLocalService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;

import java.io.File;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.annotation.versioning.ProviderType;

/**
 * Provides the local service interface for Quotation. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author Brian Wing Shun Chan
 * @see QuotationLocalServiceUtil
 * @generated
 */
@ProviderType
@Transactional(
	isolation = Isolation.PORTAL,
	rollbackFor = {PortalException.class, SystemException.class}
)
public interface QuotationLocalService extends BaseLocalService {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add custom service methods to <code>com.atmc.bsl.db.service.impl.QuotationLocalServiceImpl</code> and rerun ServiceBuilder to automatically copy the method declarations to this interface. Consume the quotation local service via injection or a <code>org.osgi.util.tracker.ServiceTracker</code>. Use {@link QuotationLocalServiceUtil} if injection and service tracking are not available.
	 */
	public String acceptQuotation(
		long quotationId, String userName, Date date, String reason);

	public PolicyHDR checkActivePolicy(String iqamaId, String vehId);

	public long checkExistingPolicy(String iqamaId, String vehId);

	public int countQuotationSurveyVideo(String quoteID);

	public QuotationAdminUploads downloadAdminFiles(int fileId);

	public CustUploads downloadCustFiles(long fileId);

	public File downloadPolicyReport(
			String quoteId, String policyNo, String lang)
		throws Exception;

	public File downloadQuotDetsReport(String quoteId, String lang)
		throws Exception;

	public byte[] findCustuploadsChassisNo(long id);

	public byte[] findCustuploadsIstCardFile(long id);

	public byte[] findCustuploadsLeaseFile(long id);

	public byte[] findCustuploadsVehBack(long id);

	public byte[] findCustuploadsVehFront(long id);

	public byte[] findCustuploadsVehLeft(long id);

	public byte[] findCustuploadsVehRight(long id);

	public byte[] findInsuredRelationProof(long addDriverId);

	public String findPolicyNajmStatus(String policyNo) throws PortalException;

	public byte[] findQuotationSurveyFile(long id);

	public List<QuotationSurvey> findQuotationSurveyVideo(String quoteID);

	public List<CodeMasterDetails> geEngineSizes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getAdminQuotationByQuotationId(long quotationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getAdminQuotations(int start, int end)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public int getAdminQuotationsCount() throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getAllPendingQuotations(
			Date expiryDate, String quoteStatus, boolean smsFlag)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getCities();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getCountries();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<QuotationCover> getCoverList(String productCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<QuotationCover> getCustomCovers(List<ProductCovers> pCovers);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public QuotationCustUploads getCustomQuotationCustUploads(
			String quotationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getCustomQuotations(
		List<Quotations> quotationsList, boolean isTameeni);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getDeductibleValues();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDriverNationalityAr(String driverNa);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getDriverNationalityEn(String driverNa);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getEducationList();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getExpiredQuotsByDate(
			Date expiryDate, String[] status)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CustomerMapDetails> getInsuranceCompanies();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CustomerMapDetails> getInsuranceCompany(String premiaCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getLicenseTypes();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getNajmStatusByPolicyNo(String policyNo)
		throws PortalException;

	/**
	 * Returns the OSGi service identifier.
	 *
	 * @return the OSGi service identifier
	 */
	public String getOSGiServiceIdentifier();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getParkingLocations();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getPendingPaymentSurveyQuotations(long iqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getPendingQuotations(long iqamaId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getPolicyQuot(Policy policy) throws YaqeenException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getProductDescAr(String productCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getProductDescEn(String productCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<CodeMasterDetails> getPurposeOfVehicle();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getQuotationByQuotationId(long quotationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getQuotationByReferenceNo(String referenceNo)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getQuotationDetails(Quotation quot);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getQuotations(
			String status, long iqamaId, boolean andSearch, int start, int end)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getQuotationsByIqamaId(long iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotation> getQuotationsByIqamaIdAndStatus(long iqamaId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Long getQuotationsCount(
			String status, long iqamaId, boolean andSearch)
		throws SystemException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public QuotationTameeniExtraDetails getQuotationTameeniExtras(
			long quotationId)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getQuoteDetailsReportParams(
		HttpServletRequest httpReq, Quotation quot);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Map<String, Object> getQuoteDetailsReportParams(
		String lang, Quotation quot);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<Quotations> getQuotsByQuoteStatus(String quoteStatus);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public Quotation getTariffDets(Quotation quot, boolean isRenewal)
		throws PortalException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public List<QuotationDriver> getUnderAgeDriversList(long quotationId);

	/**
	 * @return the statusDescAr
	 */
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getVehicleIdDescAr(String vichelIdype);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public String getVehicleIdDescEn(String vichelIdype);

	@Transactional(
		propagation = Propagation.REQUIRED, readOnly = false,
		rollbackFor = {
			PortalException.class, SystemException.class,
			ModelListenerException.class
		}
	)
	public void issuePolicy(Quotation quot);

	public void notifyUser(
		HttpServletRequest httpRequest, Quotation quot, Locale local,
		User user);

	public String olpInitiatePmnt(
		String olpAlias, double amount, String currency,
		String merchantLandingURL, String merchantFailureURL);

	public PurchaseResponse payFortPurchase(
		double amount, String currency, String customerEmail, String language,
		String merchantReference, String tokenName, String paymentOption,
		String cardSecurityCode, String clientIpAddress, String returnUrl);

	public void rejectQuotation(
		long quotationId, String userName, Date date, String reason,
		String status);

	public void removeAdminFiles(int fileId);

	public void renewAddressInquiry(Quotation quot, Locale locale)
		throws YaqeenException;

	public void renewNcdInquiry(Quotation quot) throws NajmException;

	public void renewTariffInquiry(Quotation quot);

	public Quotation reviewQuotation(
			Quotation quot, boolean isUserSignedIn, String lang)
		throws PortalException;

	public void saveAdminFiles(
		long quotationId, File adminFile, String fileName);

	public void saveNajmCaseDetails(
		ArrayList<QuotationNajmDetails> najmDetailsList, long quotationId);

	public void saveQuoteUserAddress(
		QuotationUserAddress custUserNatAddr, long quotationId, long insuredId,
		boolean isNatAddress);

	public boolean saveQuotSurvey(
		String quotationId, byte[] surveyVideo, String name, Date date);

	@Transactional(
		propagation = Propagation.REQUIRED, readOnly = false,
		rollbackFor = {
			PortalException.class, SystemException.class,
			ModelListenerException.class
		}
	)
	public Quotation submitQuotation(Quotation customQuot, String userId);

	public void updateQuotationTameeniExtras(
		QuotationTameeniExtraDetails details);

	public void updateQuoteFlag(long quotId, boolean smsFlag)
		throws PortalException;

	public void updateQuoteStatus(long quotId, String status)
		throws PortalException;

	public boolean validatePolicyData(String policyNo);

	public void vehicleImagesUpload(
		long quotationId, List<QuotationVehicleImage> vehicleImagesList);

}