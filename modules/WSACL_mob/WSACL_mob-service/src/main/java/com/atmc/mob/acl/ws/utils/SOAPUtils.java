package com.atmc.mob.acl.ws.utils;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.xml.security.c14n.Canonicalizer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class SOAPUtils {

	 /**
     * Convert a DOM Document into a soap message.
     * <p/>
     *
     * @param doc
     * @return
     * @throws Exception
     */
    public static SOAPMessage toSOAPMessage(Document doc) throws Exception {
        Canonicalizer c14n =
                Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS);
        byte[] canonicalMessage = c14n.canonicalizeSubtree(doc);
        ByteArrayInputStream in = new ByteArrayInputStream(canonicalMessage);
        MessageFactory factory = MessageFactory.newInstance();
        return factory.createMessage(null, in);
    }

    /**
     * Convert xml as a String to a org.w3c.dom.Document.
     */
    public static org.w3c.dom.Document toDocument(String xml) throws Exception {
        try (InputStream in = new ByteArrayInputStream(xml.getBytes())) {
        	DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        	factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_DTD, "");
        	factory.setAttribute(XMLConstants.ACCESS_EXTERNAL_SCHEMA, "");
        	DocumentBuilder builder = factory.newDocumentBuilder();
            return builder.parse(in);
        }
    }
    
    
	/**
	 * 
	 * This function is used to get the first child element(which is Element Node type) for the passed node
	 * 
	 * @param node
	 * @return First Child Element Or Null if not exist
	 * @see
	 */
	public static Node getDirectChildElement(Node parentNode, String childName) 
	{
		Node firstChildElement = null;
		if (parentNode != null && parentNode.hasChildNodes()) 
		{
			NodeList nodeChilds = parentNode.getChildNodes();
			for (int childIndex = 0; childIndex < nodeChilds.getLength(); childIndex++) 
			{
				Node child = nodeChilds.item(childIndex);
				if (child instanceof Element && child.getNodeType() == Node.ELEMENT_NODE) 
				{
					Element childElement = (Element)child;
					if (childElement.getNodeName().equals(childName))
					{
						firstChildElement = childElement;
						break;
					}
						
				}
			}
		} 
		return firstChildElement;
	}
    

}
