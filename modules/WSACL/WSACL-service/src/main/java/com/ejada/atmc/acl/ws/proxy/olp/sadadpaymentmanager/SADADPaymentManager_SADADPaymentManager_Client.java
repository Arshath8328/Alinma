
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Please modify this class to meet your needs
 * This class is not complete
 */

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.BindingProvider;

/**
 * This class was generated by Apache CXF 3.2.1 2017-11-21T13:49:39.728+02:00 Generated source version: 3.2.1
 * 
 */
public final class SADADPaymentManager_SADADPaymentManager_Client {

	private static final QName SERVICE_NAME = new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "SADADPaymentManager");
	public static Log _log = LogFactoryUtil.getLog(SADADPaymentManager_SADADPaymentManager_Client.class);
	
	private SADADPaymentManager_SADADPaymentManager_Client() {
	}

	public static void main(String args[]) throws java.lang.Exception {
		URL wsdlURL = SADADPaymentManager_Service.WSDL_LOCATION;
		if (args.length > 0 && args[0] != null && !"".equals(args[0])) {
			File wsdlFile = new File(args[0]);
			try {
				if (wsdlFile.exists()) {
					wsdlURL = wsdlFile.toURI().toURL();
				} else {
					wsdlURL = new URL(args[0]);
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		}

		SADADPaymentManager_Service ss = new SADADPaymentManager_Service(wsdlURL, SERVICE_NAME);
		SADADPaymentManager port = ss.getSADADPaymentManager();

		BindingProvider bp = (BindingProvider) port;
		bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "http://10.0.0.182:8095/SADADPaymentManagement/01_00/SADADPaymentManager");

		bp.getRequestContext().put("ws-security.signature.properties", "client-crypto.properties");
		bp.getRequestContext().put("ws-security.signature.username", "olpalias");
		bp.getRequestContext().put("ws-security.encryption.properties", "client-crypto.properties");
		bp.getRequestContext().put("ws-security.encryption.username", "olpalias");
		bp.getRequestContext().put("ws-security.callback-handler", "com.ejada.util.UTPasswordCallback");

		{
			_log.info("Invoking initiatePaymentDetails...");
			com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsRequest _initiatePaymentDetails_initiatePaymentDetailsRequest = new com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsRequest();
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setTransactionAmount(0.6223055703326084);
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setOlpIdAlias("OlpIdAlias502579011");
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setMerchantRefNum("MerchantRefNum-1877598790");
			java.util.List<com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.Merchant> _initiatePaymentDetails_initiatePaymentDetailsRequestMerchants = new java.util.ArrayList<com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.Merchant>();
			com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.Merchant _initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1 = new com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.Merchant();
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1.setMerchantId(2554894033651090240l);
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1.setMerchantRefNum("MerchantRefNum-1309417513");
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1.setPaymentAmount(0.43701274421243763);
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1.setPaymentCurrency("PaymentCurrency500474628");
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1.setMerchantType(-1248713247);
			_initiatePaymentDetails_initiatePaymentDetailsRequestMerchants.add(_initiatePaymentDetails_initiatePaymentDetailsRequestMerchantsVal1);
			_initiatePaymentDetails_initiatePaymentDetailsRequest.getMerchants().addAll(_initiatePaymentDetails_initiatePaymentDetailsRequestMerchants);
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setDynamicMerchantLandingURL("DynamicMerchantLandingURL-626348267");
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setDynamicMerchantFailureURL("DynamicMerchantFailureURL318127524");
			_initiatePaymentDetails_initiatePaymentDetailsRequest.setMerchantId(-5977617643139456989l);
			com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.EnterpriseContextType _initiatePaymentDetails_enterpriseHeader = new com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.EnterpriseContextType();
			com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.ContextInfo _initiatePaymentDetails_enterpriseHeaderContextInfo = new com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.ContextInfo();
			_initiatePaymentDetails_enterpriseHeaderContextInfo.setProcessContextId("ProcessContextId57732216");
			_initiatePaymentDetails_enterpriseHeaderContextInfo.setBusinessContextId("BusinessContextId-184208398");
			_initiatePaymentDetails_enterpriseHeaderContextInfo.setApplicationContextId(-297155262);
			_initiatePaymentDetails_enterpriseHeader.setContextInfo(_initiatePaymentDetails_enterpriseHeaderContextInfo);
			com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.RequestOriginator _initiatePaymentDetails_enterpriseHeaderRequestOriginator = new com.ejada.atmc.acl.ws.proxy.olp.enterprisecontext.RequestOriginator();
			_initiatePaymentDetails_enterpriseHeaderRequestOriginator.setRequesterCode("RequesterCode500252745");
			_initiatePaymentDetails_enterpriseHeaderRequestOriginator.setMachineIPAddress("MachineIPAddress-1884945217");
			_initiatePaymentDetails_enterpriseHeaderRequestOriginator.setUserPrincipleName("UserPrincipleName-2054508738");
			_initiatePaymentDetails_enterpriseHeaderRequestOriginator.setRequestedTimestamp(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-11-21T13:49:39.885+02:00"));
			_initiatePaymentDetails_enterpriseHeaderRequestOriginator.setChannelId(-1543949700);
			_initiatePaymentDetails_enterpriseHeader.setRequestOriginator(_initiatePaymentDetails_enterpriseHeaderRequestOriginator);
			try {
				com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager.InitiatePaymentDetailsReply _initiatePaymentDetails__return = port
						.initiatePaymentDetails(_initiatePaymentDetails_initiatePaymentDetailsRequest, _initiatePaymentDetails_enterpriseHeader);
				_log.info("initiatePaymentDetails.result=" + _initiatePaymentDetails__return);

			} catch (Fault_Exception e) {
				_log.info("Expected exception: Fault has occurred.");
				_log.info(e.toString());
			}
		}
//        {
//        _log.info("Invoking confirmPaymentDetails...");
//        com.sadad.olp.sadadpaymentmanager.ConfirmPaymentDetailsRequest _confirmPaymentDetails_confirmPaymentDetailsRequest = new com.sadad.olp.sadadpaymentmanager.ConfirmPaymentDetailsRequest();
//        _confirmPaymentDetails_confirmPaymentDetailsRequest.setTransactionIdEnc("TransactionIdEnc-582731478");
//        _confirmPaymentDetails_confirmPaymentDetailsRequest.setMerchantId(6676503612548543100l);
//        _confirmPaymentDetails_confirmPaymentDetailsRequest.setMerchantRefNum("MerchantRefNum-2106134946");
//        com.sadad.olp.enterprise.infrastructure.enterprisecontext.EnterpriseContextType _confirmPaymentDetails_enterpriseHeader = new com.sadad.olp.enterprise.infrastructure.enterprisecontext.EnterpriseContextType();
//        com.sadad.olp.enterprise.infrastructure.enterprisecontext.ContextInfo _confirmPaymentDetails_enterpriseHeaderContextInfo = new com.sadad.olp.enterprise.infrastructure.enterprisecontext.ContextInfo();
//        _confirmPaymentDetails_enterpriseHeaderContextInfo.setProcessContextId("ProcessContextId508984653");
//        _confirmPaymentDetails_enterpriseHeaderContextInfo.setBusinessContextId("BusinessContextId-1910198142");
//        _confirmPaymentDetails_enterpriseHeaderContextInfo.setApplicationContextId(1659093608);
//        _confirmPaymentDetails_enterpriseHeader.setContextInfo(_confirmPaymentDetails_enterpriseHeaderContextInfo);
//        com.sadad.olp.enterprise.infrastructure.enterprisecontext.RequestOriginator _confirmPaymentDetails_enterpriseHeaderRequestOriginator = new com.sadad.olp.enterprise.infrastructure.enterprisecontext.RequestOriginator();
//        _confirmPaymentDetails_enterpriseHeaderRequestOriginator.setRequesterCode("RequesterCode-63349815");
//        _confirmPaymentDetails_enterpriseHeaderRequestOriginator.setMachineIPAddress("MachineIPAddress1307255213");
//        _confirmPaymentDetails_enterpriseHeaderRequestOriginator.setUserPrincipleName("UserPrincipleName95930773");
//        _confirmPaymentDetails_enterpriseHeaderRequestOriginator.setRequestedTimestamp(javax.xml.datatype.DatatypeFactory.newInstance().newXMLGregorianCalendar("2017-11-21T13:49:39.896+02:00"));
//        _confirmPaymentDetails_enterpriseHeaderRequestOriginator.setChannelId(867209199);
//        _confirmPaymentDetails_enterpriseHeader.setRequestOriginator(_confirmPaymentDetails_enterpriseHeaderRequestOriginator);
//        try {
//            com.sadad.olp.sadadpaymentmanager.ConfirmPaymentDetailsReply _confirmPaymentDetails__return = port.confirmPaymentDetails(_confirmPaymentDetails_confirmPaymentDetailsRequest, _confirmPaymentDetails_enterpriseHeader);
//            _log.info("confirmPaymentDetails.result=" + _confirmPaymentDetails__return);
//
//        } catch (Fault_Exception e) { 
//            _log.info("Expected exception: Fault has occurred.");
//            _log.info(e.toString());
//        }
//            }

		System.exit(0);
	}

}
