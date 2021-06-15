
package com.ejada.atmc.acl.ws.proxy.olp.sadadpaymentmanager;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each Java content interface and Java element interface generated in the
 * com.sadad.olp.sadadpaymentmanager package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation for XML content.
 * The Java representation of XML content can consist of schema derived interfaces and classes representing the binding
 * of schema type definitions, element declarations and model groups. Factory methods for each of these are provided in
 * this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

	private final static QName	_Fault_QNAME							= new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "Fault");
	private final static QName	_ConfirmPaymentDetails_QNAME			= new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "ConfirmPaymentDetails");
	private final static QName	_ConfirmPaymentDetailsResponse_QNAME	= new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "ConfirmPaymentDetailsResponse");
	private final static QName	_InitiatePaymentDetails_QNAME			= new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "InitiatePaymentDetails");
	private final static QName	_InitiatePaymentDetailsResponse_QNAME	= new QName("http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1", "InitiatePaymentDetailsResponse");

	/**
	 * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package:
	 * com.sadad.olp.sadadpaymentmanager
	 * 
	 */
	public ObjectFactory() {
	}

	/**
	 * Create an instance of {@link Fault }
	 * 
	 */
	public Fault createFault() {
		return new Fault();
	}

	/**
	 * Create an instance of {@link ConfirmPaymentDetails }
	 * 
	 */
	public ConfirmPaymentDetails createConfirmPaymentDetails() {
		return new ConfirmPaymentDetails();
	}

	/**
	 * Create an instance of {@link ConfirmPaymentDetailsResponse }
	 * 
	 */
	public ConfirmPaymentDetailsResponse createConfirmPaymentDetailsResponse() {
		return new ConfirmPaymentDetailsResponse();
	}

	/**
	 * Create an instance of {@link InitiatePaymentDetails }
	 * 
	 */
	public InitiatePaymentDetails createInitiatePaymentDetails() {
		return new InitiatePaymentDetails();
	}

	/**
	 * Create an instance of {@link InitiatePaymentDetailsResponse }
	 * 
	 */
	public InitiatePaymentDetailsResponse createInitiatePaymentDetailsResponse() {
		return new InitiatePaymentDetailsResponse();
	}

	/**
	 * Create an instance of {@link InitiatePaymentDetailsRequest }
	 * 
	 */
	public InitiatePaymentDetailsRequest createInitiatePaymentDetailsRequest() {
		return new InitiatePaymentDetailsRequest();
	}

	/**
	 * Create an instance of {@link Merchant }
	 * 
	 */
	public Merchant createMerchant() {
		return new Merchant();
	}

	/**
	 * Create an instance of {@link InitiatePaymentDetailsReply }
	 * 
	 */
	public InitiatePaymentDetailsReply createInitiatePaymentDetailsReply() {
		return new InitiatePaymentDetailsReply();
	}

	/**
	 * Create an instance of {@link InitiatePaymentTransactionDetails }
	 * 
	 */
	public InitiatePaymentTransactionDetails createInitiatePaymentTransactionDetails() {
		return new InitiatePaymentTransactionDetails();
	}

	/**
	 * Create an instance of {@link BankBusinessException }
	 * 
	 */
	public BankBusinessException createBankBusinessException() {
		return new BankBusinessException();
	}

	/**
	 * Create an instance of {@link ConfirmPaymentDetailsRequest }
	 * 
	 */
	public ConfirmPaymentDetailsRequest createConfirmPaymentDetailsRequest() {
		return new ConfirmPaymentDetailsRequest();
	}

	/**
	 * Create an instance of {@link ConfirmPaymentDetailsReply }
	 * 
	 */
	public ConfirmPaymentDetailsReply createConfirmPaymentDetailsReply() {
		return new ConfirmPaymentDetailsReply();
	}

	/**
	 * Create an instance of {@link ConfirmPaymentTransactionDetails }
	 * 
	 */
	public ConfirmPaymentTransactionDetails createConfirmPaymentTransactionDetails() {
		return new ConfirmPaymentTransactionDetails();
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link Fault }{@code >}}
	 * 
	 */
	@XmlElementDecl(
			namespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			name = "Fault"
	)
	public JAXBElement<Fault> createFault(Fault value) {
		return new JAXBElement<Fault>(_Fault_QNAME, Fault.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentDetails }{@code >}}
	 * 
	 */
	@XmlElementDecl(
			namespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			name = "ConfirmPaymentDetails"
	)
	public JAXBElement<ConfirmPaymentDetails> createConfirmPaymentDetails(ConfirmPaymentDetails value) {
		return new JAXBElement<ConfirmPaymentDetails>(_ConfirmPaymentDetails_QNAME, ConfirmPaymentDetails.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link ConfirmPaymentDetailsResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(
			namespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			name = "ConfirmPaymentDetailsResponse"
	)
	public JAXBElement<ConfirmPaymentDetailsResponse> createConfirmPaymentDetailsResponse(ConfirmPaymentDetailsResponse value) {
		return new JAXBElement<ConfirmPaymentDetailsResponse>(_ConfirmPaymentDetailsResponse_QNAME, ConfirmPaymentDetailsResponse.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link InitiatePaymentDetails }{@code >}}
	 * 
	 */
	@XmlElementDecl(
			namespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			name = "InitiatePaymentDetails"
	)
	public JAXBElement<InitiatePaymentDetails> createInitiatePaymentDetails(InitiatePaymentDetails value) {
		return new JAXBElement<InitiatePaymentDetails>(_InitiatePaymentDetails_QNAME, InitiatePaymentDetails.class, null, value);
	}

	/**
	 * Create an instance of {@link JAXBElement }{@code <}{@link InitiatePaymentDetailsResponse }{@code >}}
	 * 
	 */
	@XmlElementDecl(
			namespace = "http://olp.sadad.com/sadadpaymentmanagement/service/sadadpaymentmanager/intf/1",
			name = "InitiatePaymentDetailsResponse"
	)
	public JAXBElement<InitiatePaymentDetailsResponse> createInitiatePaymentDetailsResponse(InitiatePaymentDetailsResponse value) {
		return new JAXBElement<InitiatePaymentDetailsResponse>(_InitiatePaymentDetailsResponse_QNAME, InitiatePaymentDetailsResponse.class, null, value);
	}

}
