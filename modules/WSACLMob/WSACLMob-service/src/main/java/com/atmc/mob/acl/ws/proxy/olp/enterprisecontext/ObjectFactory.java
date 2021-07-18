
package com.atmc.mob.acl.ws.proxy.olp.enterprisecontext;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.sadad.olp.enterprise.infrastructure.enterprisecontext package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _EnterpriseContext_QNAME = new QName("http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext", "enterpriseContext");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.sadad.olp.enterprise.infrastructure.enterprisecontext
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link EnterpriseContextType }
     * 
     */
    public EnterpriseContextType createEnterpriseContextType() {
        return new EnterpriseContextType();
    }

    /**
     * Create an instance of {@link ContextInfo }
     * 
     */
    public ContextInfo createContextInfo() {
        return new ContextInfo();
    }

    /**
     * Create an instance of {@link RequestOriginator }
     * 
     */
    public RequestOriginator createRequestOriginator() {
        return new RequestOriginator();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link EnterpriseContextType }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://enterprise.olp.sadad.com/Infrastructure/EnterpriseContext", name = "enterpriseContext")
    public JAXBElement<EnterpriseContextType> createEnterpriseContext(EnterpriseContextType value) {
        return new JAXBElement<EnterpriseContextType>(_EnterpriseContext_QNAME, EnterpriseContextType.class, null, value);
    }

}
