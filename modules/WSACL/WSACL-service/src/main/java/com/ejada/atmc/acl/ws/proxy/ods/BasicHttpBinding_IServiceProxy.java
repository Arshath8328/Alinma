package com.ejada.atmc.acl.ws.proxy.ods;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.net.URL;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.BindingProvider;
import javax.xml.ws.Dispatch;
import javax.xml.ws.Service;
import javax.xml.ws.soap.SOAPBinding;

public class BasicHttpBinding_IServiceProxy {

	protected Descriptor _descriptor;
	Log _log = LogFactoryUtil.getLog(this.getClass());
	
	public class Descriptor {
		private com.ejada.atmc.acl.ws.proxy.ods.Service		_service		= null;
		private com.ejada.atmc.acl.ws.proxy.ods.IService	_proxy			= null;
		private Dispatch<Source>							_dispatch		= null;
		private boolean										_useJNDIOnly	= false;

		public Descriptor() {
			init();
		}

		public Descriptor(URL wsdlLocation, QName serviceName) {
			_service = new com.ejada.atmc.acl.ws.proxy.ods.Service(wsdlLocation, serviceName);
			initCommon();
		}

		public void init() {
			_service = null;
			_proxy = null;
			_dispatch = null;
			try {
				InitialContext ctx = new InitialContext();
				_service = (com.ejada.atmc.acl.ws.proxy.ods.Service) ctx.lookup("java:comp/env/service/Service");
			} catch (NamingException e) {
				if ("true".equalsIgnoreCase(System.getProperty("DEBUG_PROXY"))) {
					_log.info("JNDI lookup failure: javax.naming.NamingException: " + e.getMessage());
					e.printStackTrace(System.out);
				}
			}

			if (_service == null && !_useJNDIOnly)
				_service = new com.ejada.atmc.acl.ws.proxy.ods.Service();
			initCommon();
		}

		private void initCommon() {
			_proxy = _service.getBasicHttpBindingIService();
		}

		public com.ejada.atmc.acl.ws.proxy.ods.IService getProxy() {
			return _proxy;
		}

		public void useJNDIOnly(boolean useJNDIOnly) {
			_useJNDIOnly = useJNDIOnly;
			init();
		}

		public Dispatch<Source> getDispatch() {
			if (_dispatch == null) {
				QName portQName = new QName("http://tempuri.org/", "BasicHttpBinding_IService");
				_dispatch = _service.createDispatch(portQName, Source.class, Service.Mode.MESSAGE);

				String proxyEndpointUrl = getEndpoint();
				BindingProvider bp = (BindingProvider) _dispatch;
				String dispatchEndpointUrl = (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
				if (!dispatchEndpointUrl.equals(proxyEndpointUrl))
					bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, proxyEndpointUrl);
			}
			return _dispatch;
		}

		public String getEndpoint() {
			BindingProvider bp = (BindingProvider) _proxy;
			return (String) bp.getRequestContext().get(BindingProvider.ENDPOINT_ADDRESS_PROPERTY);
		}

		public void setEndpoint(String endpointUrl) {
			BindingProvider bp = (BindingProvider) _proxy;
			bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);

			if (_dispatch != null) {
				bp = (BindingProvider) _dispatch;
				bp.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpointUrl);
			}
		}

		public void setMTOMEnabled(boolean enable) {
			SOAPBinding binding = (SOAPBinding) ((BindingProvider) _proxy).getBinding();
			binding.setMTOMEnabled(enable);
		}
	}

	public BasicHttpBinding_IServiceProxy() {
		_descriptor = new Descriptor();
		_descriptor.setMTOMEnabled(false);
	}

	public BasicHttpBinding_IServiceProxy(URL wsdlLocation, QName serviceName) {
		_descriptor = new Descriptor(wsdlLocation, serviceName);
		_descriptor.setMTOMEnabled(false);
	}

	public Descriptor _getDescriptor() {
		return _descriptor;
	}

	public com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuanceResponse.PolicyIssuanceResult policyIssuance(com.ejada.atmc.acl.ws.proxy.ods.PolicyIssuance.XmlRequest xmlRequest) {
		return _getDescriptor().getProxy().policyIssuance(xmlRequest);
	}

	public com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimationResponse.ClaimIntimationResult claimIntimation(com.ejada.atmc.acl.ws.proxy.ods.ClaimIntimation.XmlRequest xmlRequest) {
		return _getDescriptor().getProxy().claimIntimation(xmlRequest);
	}

}