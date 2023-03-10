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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;

import java.util.Date;

import org.osgi.annotation.versioning.ProviderType;

/**
 * The base model interface for the PolicyHDR service. Represents a row in the &quot;ODS_POLICY_HDR&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRModelImpl</code> exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in <code>com.ejada.atmc.acl.db.model.impl.PolicyHDRImpl</code>.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see PolicyHDR
 * @generated
 */
@ProviderType
public interface PolicyHDRModel extends BaseModel<PolicyHDR> {

	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a policy hdr model instance should use the {@link PolicyHDR} interface instead.
	 */

	/**
	 * Returns the primary key of this policy hdr.
	 *
	 * @return the primary key of this policy hdr
	 */
	public String getPrimaryKey();

	/**
	 * Sets the primary key of this policy hdr.
	 *
	 * @param primaryKey the primary key of this policy hdr
	 */
	public void setPrimaryKey(String primaryKey);

	/**
	 * Returns the policy no of this policy hdr.
	 *
	 * @return the policy no of this policy hdr
	 */
	@AutoEscape
	public String getPolicyNo();

	/**
	 * Sets the policy no of this policy hdr.
	 *
	 * @param policyNo the policy no of this policy hdr
	 */
	public void setPolicyNo(String policyNo);

	/**
	 * Returns the iqama ID of this policy hdr.
	 *
	 * @return the iqama ID of this policy hdr
	 */
	@AutoEscape
	public String getIqamaId();

	/**
	 * Sets the iqama ID of this policy hdr.
	 *
	 * @param iqamaId the iqama ID of this policy hdr
	 */
	public void setIqamaId(String iqamaId);

	/**
	 * Returns the policy status of this policy hdr.
	 *
	 * @return the policy status of this policy hdr
	 */
	@AutoEscape
	public String getPolicyStatus();

	/**
	 * Sets the policy status of this policy hdr.
	 *
	 * @param policyStatus the policy status of this policy hdr
	 */
	public void setPolicyStatus(String policyStatus);

	/**
	 * Returns the product of this policy hdr.
	 *
	 * @return the product of this policy hdr
	 */
	@AutoEscape
	public String getProduct();

	/**
	 * Sets the product of this policy hdr.
	 *
	 * @param product the product of this policy hdr
	 */
	public void setProduct(String product);

	/**
	 * Returns the inception date of this policy hdr.
	 *
	 * @return the inception date of this policy hdr
	 */
	public Date getInceptionDate();

	/**
	 * Sets the inception date of this policy hdr.
	 *
	 * @param inceptionDate the inception date of this policy hdr
	 */
	public void setInceptionDate(Date inceptionDate);

	/**
	 * Returns the expiry date of this policy hdr.
	 *
	 * @return the expiry date of this policy hdr
	 */
	public Date getExpiryDate();

	/**
	 * Sets the expiry date of this policy hdr.
	 *
	 * @param expiryDate the expiry date of this policy hdr
	 */
	public void setExpiryDate(Date expiryDate);

	/**
	 * Returns the sum insured of this policy hdr.
	 *
	 * @return the sum insured of this policy hdr
	 */
	public long getSumInsured();

	/**
	 * Sets the sum insured of this policy hdr.
	 *
	 * @param sumInsured the sum insured of this policy hdr
	 */
	public void setSumInsured(long sumInsured);

	/**
	 * Returns the total premium of this policy hdr.
	 *
	 * @return the total premium of this policy hdr
	 */
	public long getTotalPremium();

	/**
	 * Sets the total premium of this policy hdr.
	 *
	 * @param totalPremium the total premium of this policy hdr
	 */
	public void setTotalPremium(long totalPremium);

	/**
	 * Returns the policy fees of this policy hdr.
	 *
	 * @return the policy fees of this policy hdr
	 */
	public long getPolicyFees();

	/**
	 * Sets the policy fees of this policy hdr.
	 *
	 * @param policyFees the policy fees of this policy hdr
	 */
	public void setPolicyFees(long policyFees);

	/**
	 * Returns the policy taxes of this policy hdr.
	 *
	 * @return the policy taxes of this policy hdr
	 */
	@AutoEscape
	public String getPolicyTaxes();

	/**
	 * Sets the policy taxes of this policy hdr.
	 *
	 * @param policyTaxes the policy taxes of this policy hdr
	 */
	public void setPolicyTaxes(String policyTaxes);

	/**
	 * Returns the policy term of this policy hdr.
	 *
	 * @return the policy term of this policy hdr
	 */
	public long getPolicyTerm();

	/**
	 * Sets the policy term of this policy hdr.
	 *
	 * @param policyTerm the policy term of this policy hdr
	 */
	public void setPolicyTerm(long policyTerm);

	/**
	 * Returns the premium of this policy hdr.
	 *
	 * @return the premium of this policy hdr
	 */
	@AutoEscape
	public String getPremium();

	/**
	 * Sets the premium of this policy hdr.
	 *
	 * @param premium the premium of this policy hdr
	 */
	public void setPremium(String premium);

	/**
	 * Returns the next due date of this policy hdr.
	 *
	 * @return the next due date of this policy hdr
	 */
	public Date getNextDueDate();

	/**
	 * Sets the next due date of this policy hdr.
	 *
	 * @param nextDueDate the next due date of this policy hdr
	 */
	public void setNextDueDate(Date nextDueDate);

	/**
	 * Returns the count prem missed of this policy hdr.
	 *
	 * @return the count prem missed of this policy hdr
	 */
	public long getCountPremMissed();

	/**
	 * Sets the count prem missed of this policy hdr.
	 *
	 * @param countPremMissed the count prem missed of this policy hdr
	 */
	public void setCountPremMissed(long countPremMissed);

	/**
	 * Returns the mode of payment of this policy hdr.
	 *
	 * @return the mode of payment of this policy hdr
	 */
	@AutoEscape
	public String getModeOfPayment();

	/**
	 * Sets the mode of payment of this policy hdr.
	 *
	 * @param modeOfPayment the mode of payment of this policy hdr
	 */
	public void setModeOfPayment(String modeOfPayment);

	/**
	 * Returns the next renwal date of this policy hdr.
	 *
	 * @return the next renwal date of this policy hdr
	 */
	public Date getNextRenwalDate();

	/**
	 * Sets the next renwal date of this policy hdr.
	 *
	 * @param nextRenwalDate the next renwal date of this policy hdr
	 */
	public void setNextRenwalDate(Date nextRenwalDate);

	/**
	 * Returns the cust name of this policy hdr.
	 *
	 * @return the cust name of this policy hdr
	 */
	@AutoEscape
	public String getCustName();

	/**
	 * Sets the cust name of this policy hdr.
	 *
	 * @param custName the cust name of this policy hdr
	 */
	public void setCustName(String custName);

	/**
	 * Returns the cust birth date of this policy hdr.
	 *
	 * @return the cust birth date of this policy hdr
	 */
	public Date getCustBirthDate();

	/**
	 * Sets the cust birth date of this policy hdr.
	 *
	 * @param custBirthDate the cust birth date of this policy hdr
	 */
	public void setCustBirthDate(Date custBirthDate);

	/**
	 * Returns the insured name of this policy hdr.
	 *
	 * @return the insured name of this policy hdr
	 */
	@AutoEscape
	public String getInsuredName();

	/**
	 * Sets the insured name of this policy hdr.
	 *
	 * @param insuredName the insured name of this policy hdr
	 */
	public void setInsuredName(String insuredName);

	/**
	 * Returns the insured birth date of this policy hdr.
	 *
	 * @return the insured birth date of this policy hdr
	 */
	public Date getInsuredBirthDate();

	/**
	 * Sets the insured birth date of this policy hdr.
	 *
	 * @param insuredBirthDate the insured birth date of this policy hdr
	 */
	public void setInsuredBirthDate(Date insuredBirthDate);

	/**
	 * Returns the insured ID of this policy hdr.
	 *
	 * @return the insured ID of this policy hdr
	 */
	@AutoEscape
	public String getInsuredId();

	/**
	 * Sets the insured ID of this policy hdr.
	 *
	 * @param insuredId the insured ID of this policy hdr
	 */
	public void setInsuredId(String insuredId);

	/**
	 * Returns the insured mobile of this policy hdr.
	 *
	 * @return the insured mobile of this policy hdr
	 */
	@AutoEscape
	public String getInsuredMobile();

	/**
	 * Sets the insured mobile of this policy hdr.
	 *
	 * @param insuredMobile the insured mobile of this policy hdr
	 */
	public void setInsuredMobile(String insuredMobile);

	/**
	 * Returns the insured email of this policy hdr.
	 *
	 * @return the insured email of this policy hdr
	 */
	@AutoEscape
	public String getInsuredEmail();

	/**
	 * Sets the insured email of this policy hdr.
	 *
	 * @param insuredEmail the insured email of this policy hdr
	 */
	public void setInsuredEmail(String insuredEmail);

	/**
	 * Returns the insured addr of this policy hdr.
	 *
	 * @return the insured addr of this policy hdr
	 */
	@AutoEscape
	public String getInsuredAddr();

	/**
	 * Sets the insured addr of this policy hdr.
	 *
	 * @param insuredAddr the insured addr of this policy hdr
	 */
	public void setInsuredAddr(String insuredAddr);

	/**
	 * Returns the insured gender of this policy hdr.
	 *
	 * @return the insured gender of this policy hdr
	 */
	@AutoEscape
	public String getInsuredGender();

	/**
	 * Sets the insured gender of this policy hdr.
	 *
	 * @param insuredGender the insured gender of this policy hdr
	 */
	public void setInsuredGender(String insuredGender);

	/**
	 * Returns the occuptation of this policy hdr.
	 *
	 * @return the occuptation of this policy hdr
	 */
	@AutoEscape
	public String getOccuptation();

	/**
	 * Sets the occuptation of this policy hdr.
	 *
	 * @param occuptation the occuptation of this policy hdr
	 */
	public void setOccuptation(String occuptation);

	/**
	 * Returns the est expiry date of this policy hdr.
	 *
	 * @return the est expiry date of this policy hdr
	 */
	public Date getEstExpiryDate();

	/**
	 * Sets the est expiry date of this policy hdr.
	 *
	 * @param estExpiryDate the est expiry date of this policy hdr
	 */
	public void setEstExpiryDate(Date estExpiryDate);

	/**
	 * Returns the najm status of this policy hdr.
	 *
	 * @return the najm status of this policy hdr
	 */
	@AutoEscape
	public String getNajmStatus();

	/**
	 * Sets the najm status of this policy hdr.
	 *
	 * @param najmStatus the najm status of this policy hdr
	 */
	public void setNajmStatus(String najmStatus);

	/**
	 * Returns the surrender value of this policy hdr.
	 *
	 * @return the surrender value of this policy hdr
	 */
	public long getSurrenderValue();

	/**
	 * Sets the surrender value of this policy hdr.
	 *
	 * @param surrenderValue the surrender value of this policy hdr
	 */
	public void setSurrenderValue(long surrenderValue);

	/**
	 * Returns the no of risk of this policy hdr.
	 *
	 * @return the no of risk of this policy hdr
	 */
	public long getNoOfRisk();

	/**
	 * Sets the no of risk of this policy hdr.
	 *
	 * @param noOfRisk the no of risk of this policy hdr
	 */
	public void setNoOfRisk(long noOfRisk);

	/**
	 * Returns the member scheme of this policy hdr.
	 *
	 * @return the member scheme of this policy hdr
	 */
	@AutoEscape
	public String getMemberScheme();

	/**
	 * Sets the member scheme of this policy hdr.
	 *
	 * @param memberScheme the member scheme of this policy hdr
	 */
	public void setMemberScheme(String memberScheme);

	/**
	 * Returns the member benefits of this policy hdr.
	 *
	 * @return the member benefits of this policy hdr
	 */
	@AutoEscape
	public String getMemberBenefits();

	/**
	 * Sets the member benefits of this policy hdr.
	 *
	 * @param memberBenefits the member benefits of this policy hdr
	 */
	public void setMemberBenefits(String memberBenefits);

}