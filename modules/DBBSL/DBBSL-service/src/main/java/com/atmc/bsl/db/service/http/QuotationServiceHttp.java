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
import com.liferay.portal.kernel.security.auth.HttpPrincipal;
import com.liferay.portal.kernel.service.http.TunnelUtil;
import com.liferay.portal.kernel.util.MethodHandler;
import com.liferay.portal.kernel.util.MethodKey;

/**
 * Provides the HTTP utility for the <code>QuotationServiceUtil</code> service
 * utility. The static methods of this class calls the same methods of the
 * service utility. However, the signatures are different because it requires an
 * additional <code>HttpPrincipal</code> parameter.
 *
 * <p>
 * The benefits of using the HTTP utility is that it is fast and allows for
 * tunneling without the cost of serializing to text. The drawback is that it
 * only works with Java.
 * </p>
 *
 * <p>
 * Set the property <b>tunnel.servlet.hosts.allowed</b> in portal.properties to
 * configure security.
 * </p>
 *
 * <p>
 * The HTTP utility is only generated for remote services.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see QuotationServiceSoap
 * @generated
 */
public class QuotationServiceHttp {

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCountries(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getCountries",
					_getCountriesParameterTypes0);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getCities(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getCities", _getCitiesParameterTypes1);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getParkingLocations(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getParkingLocations",
					_getParkingLocationsParameterTypes2);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getEngineSizes(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getEngineSizes",
					_getEngineSizesParameterTypes3);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getDeductibleValues(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getDeductibleValues",
					_getDeductibleValuesParameterTypes4);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getPurposeOfVehicle(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getPurposeOfVehicle",
					_getPurposeOfVehicleParameterTypes5);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>> getInsuranceCompanies(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getInsuranceCompanies",
					_getInsuranceCompaniesParameterTypes6);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.CustomerMapDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> personalInfo(
			HttpPrincipal httpPrincipal, com.atmc.bsl.db.domain.quotation.Quotation quot, boolean isUserSignedIn) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "personalInfo",
					_personalInfoParameterTypes7);

			MethodHandler methodHandler = new MethodHandler(methodKey, quot, isUserSignedIn);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>> getPendingQuotations(
			HttpPrincipal httpPrincipal, String iqamaId) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getPendingQuotations",
					_getPendingQuotationsParameterTypes8);

			MethodHandler methodHandler = new MethodHandler(methodKey, iqamaId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.Quotation>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadQuoteFile(HttpPrincipal httpPrincipal,
			java.io.File attachFile, String fileName, String insuredId) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "uploadQuoteFile",
					_uploadQuoteFileParameterTypes9);

			MethodHandler methodHandler = new MethodHandler(methodKey, attachFile, fileName, insuredId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Boolean>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> uploadVideo(HttpPrincipal httpPrincipal,
			String baseArray, String fileName, String quotationId, java.util.Date videoDate) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "uploadVideo",
					_uploadVideoParameterTypes10);

			MethodHandler methodHandler = new MethodHandler(methodKey, baseArray, fileName, quotationId, videoDate);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Boolean>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Boolean> clearQuoteFile(HttpPrincipal httpPrincipal,
			String fileName, String insuredId) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "clearQuoteFile",
					_clearQuoteFileParameterTypes11);

			MethodHandler methodHandler = new MethodHandler(methodKey, fileName, insuredId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Boolean>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.domain.tariff.TariffOutput> getTariffData(
			HttpPrincipal httpPrincipal, com.ejada.atmc.acl.db.domain.tariff.TariffInput tariffInput)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getTariffData",
					_getTariffDataParameterTypes12);

			MethodHandler methodHandler = new MethodHandler(methodKey, tariffInput);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.domain.tariff.TariffOutput>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.model.CodeMasterMap> getBySourceTypeSourceCode(
			HttpPrincipal httpPrincipal, String sourceType, String sourceCode)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getBySourceTypeSourceCode",
					_getBySourceTypeSourceCodeParameterTypes13);

			MethodHandler methodHandler = new MethodHandler(methodKey, sourceType, sourceCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.ejada.atmc.acl.db.model.CodeMasterMap>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover>> getCoverList(
			HttpPrincipal httpPrincipal, String productCode) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getCoverList",
					_getCoverListParameterTypes14);

			MethodHandler methodHandler = new MethodHandler(methodKey, productCode);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.quotation.QuotationCover>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> tokenizationResult(
			HttpPrincipal httpPrincipal, String status) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "tokenizationResult",
					_tokenizationResultParameterTypes15);

			MethodHandler methodHandler = new MethodHandler(methodKey, status);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.QuotationDriver> addDriver(
			HttpPrincipal httpPrincipal, com.atmc.bsl.db.domain.quotation.QuotationDriver driver,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress driverNatAddress,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress driverOffNatAddress) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "addDriver", _addDriverParameterTypes16);

			MethodHandler methodHandler = new MethodHandler(methodKey, driver, driverNatAddress, driverOffNatAddress);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.QuotationDriver>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getEducationList(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getEducationList",
					_getEducationListParameterTypes17);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>> getLicenseTypes(
			HttpPrincipal httpPrincipal) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getLicenseTypes",
					_getLicenseTypesParameterTypes18);

			MethodHandler methodHandler = new MethodHandler(methodKey);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<java.util.List<com.atmc.bsl.db.domain.codemaster.CodeMasterDetails>>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> renewPolicy(
			HttpPrincipal httpPrincipal, com.atmc.bsl.db.domain.policy.Policy policy,
			com.atmc.bsl.db.domain.policy.PolicyVehicle pVeh) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "renewPolicy",
					_renewPolicyParameterTypes19);

			MethodHandler methodHandler = new MethodHandler(methodKey, policy, pVeh);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> getConfigurableValues(HttpPrincipal httpPrincipal,
			java.util.List<String> keys) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getConfigurableValues",
					_getConfigurableValuesParameterTypes20);

			MethodHandler methodHandler = new MethodHandler(methodKey, keys);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Double> quickQuoteInquiry(HttpPrincipal httpPrincipal,
			com.atmc.bsl.db.domain.quotation.Quotation quot) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "quickQuoteInquiry",
					_quickQuoteInquiryParameterTypes21);

			MethodHandler methodHandler = new MethodHandler(methodKey, quot);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Double>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<Integer> countQuotationSurveyVideo(HttpPrincipal httpPrincipal,
			String quoteID) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "countQuotationSurveyVideo",
					_countQuotationSurveyVideoParameterTypes22);

			MethodHandler methodHandler = new MethodHandler(methodKey, quoteID);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<Integer>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> downloadQuotDetsFile(HttpPrincipal httpPrincipal,
			String quoteId, String lang) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "downloadQuotDetsFile",
					_downloadQuotDetsFileParameterTypes23);

			MethodHandler methodHandler = new MethodHandler(methodKey, quoteId, lang);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<String> downloadPolicyFile(HttpPrincipal httpPrincipal,
			String quoteId, String policyNo, String lang) throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "downloadPolicyFile",
					_downloadPolicyFileParameterTypes24);

			MethodHandler methodHandler = new MethodHandler(methodKey, quoteId, policyNo, lang);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<String>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> getQuotationDetails(
			HttpPrincipal httpPrincipal, String quotId) {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getQuotationDetails",
					_getQuotationDetailsParameterTypes25);

			MethodHandler methodHandler = new MethodHandler(methodKey, quotId);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	public static com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation> getTariffDetails(
			HttpPrincipal httpPrincipal, com.atmc.bsl.db.domain.quotation.Quotation quot,
			java.util.List<com.atmc.bsl.db.domain.quotation.QuotationDriver> drivers)
			throws com.liferay.portal.kernel.exception.PortalException {

		try {
			MethodKey methodKey = new MethodKey(QuotationServiceUtil.class, "getTariffDetails",
					_getTariffDetailsParameterTypes26);

			MethodHandler methodHandler = new MethodHandler(methodKey, quot, drivers);

			Object returnObj = null;

			try {
				returnObj = TunnelUtil.invoke(httpPrincipal, methodHandler);
			} catch (Exception exception) {
				if (exception instanceof com.liferay.portal.kernel.exception.PortalException) {

					throw (com.liferay.portal.kernel.exception.PortalException) exception;
				}

				throw new com.liferay.portal.kernel.exception.SystemException(exception);
			}

			return (com.atmc.bsl.db.domain.ServiceOutput<com.atmc.bsl.db.domain.quotation.Quotation>) returnObj;
		} catch (com.liferay.portal.kernel.exception.SystemException systemException) {

			_log.error(systemException, systemException);

			throw systemException;
		}
	}

	private static Log _log = LogFactoryUtil.getLog(QuotationServiceHttp.class);

	private static final Class<?>[] _getCountriesParameterTypes0 = new Class[] {};
	private static final Class<?>[] _getCitiesParameterTypes1 = new Class[] {};
	private static final Class<?>[] _getParkingLocationsParameterTypes2 = new Class[] {};
	private static final Class<?>[] _getEngineSizesParameterTypes3 = new Class[] {};
	private static final Class<?>[] _getDeductibleValuesParameterTypes4 = new Class[] {};
	private static final Class<?>[] _getPurposeOfVehicleParameterTypes5 = new Class[] {};
	private static final Class<?>[] _getInsuranceCompaniesParameterTypes6 = new Class[] {};
	private static final Class<?>[] _personalInfoParameterTypes7 = new Class[] {
			com.atmc.bsl.db.domain.quotation.Quotation.class, boolean.class };
	private static final Class<?>[] _getPendingQuotationsParameterTypes8 = new Class[] { String.class };
	private static final Class<?>[] _uploadQuoteFileParameterTypes9 = new Class[] { java.io.File.class, String.class,
			String.class };
	private static final Class<?>[] _uploadVideoParameterTypes10 = new Class[] { String.class, String.class,
			String.class, java.util.Date.class };
	private static final Class<?>[] _clearQuoteFileParameterTypes11 = new Class[] { String.class, String.class };
	private static final Class<?>[] _getTariffDataParameterTypes12 = new Class[] {
			com.ejada.atmc.acl.db.domain.tariff.TariffInput.class };
	private static final Class<?>[] _getBySourceTypeSourceCodeParameterTypes13 = new Class[] { String.class,
			String.class };
	private static final Class<?>[] _getCoverListParameterTypes14 = new Class[] { String.class };
	private static final Class<?>[] _tokenizationResultParameterTypes15 = new Class[] { String.class };
	private static final Class<?>[] _addDriverParameterTypes16 = new Class[] {
			com.atmc.bsl.db.domain.quotation.QuotationDriver.class,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress.class,
			com.atmc.bsl.db.domain.quotation.QuotationUserAddress.class };
	private static final Class<?>[] _getEducationListParameterTypes17 = new Class[] {};
	private static final Class<?>[] _getLicenseTypesParameterTypes18 = new Class[] {};
	private static final Class<?>[] _renewPolicyParameterTypes19 = new Class[] {
			com.atmc.bsl.db.domain.policy.Policy.class, com.atmc.bsl.db.domain.policy.PolicyVehicle.class };
	private static final Class<?>[] _getConfigurableValuesParameterTypes20 = new Class[] { java.util.List.class };
	private static final Class<?>[] _quickQuoteInquiryParameterTypes21 = new Class[] {
			com.atmc.bsl.db.domain.quotation.Quotation.class };
	private static final Class<?>[] _countQuotationSurveyVideoParameterTypes22 = new Class[] { String.class };
	private static final Class<?>[] _downloadQuotDetsFileParameterTypes23 = new Class[] { String.class, String.class };
	private static final Class<?>[] _downloadPolicyFileParameterTypes24 = new Class[] { String.class, String.class,
			String.class };
	private static final Class<?>[] _getQuotationDetailsParameterTypes25 = new Class[] { String.class };
	private static final Class<?>[] _getTariffDetailsParameterTypes26 = new Class[] {
			com.atmc.bsl.db.domain.quotation.Quotation.class, java.util.List.class };

}