package com.ejada.atmc.acl.ws.utils;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPMessage;

import org.apache.xml.security.c14n.Canonicalizer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ejada.atmc.acl.db.model.YakeenDataSave;
import com.ejada.atmc.acl.db.service.YakeenDataSaveLocalServiceUtil;
import com.ejada.atmc.acl.ws.domain.yakeen.AlienInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CarInfo;
import com.ejada.atmc.acl.ws.domain.yakeen.CitizenInfo;
import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.search.ParseException;

public class SOAPUtils {

	/**
	 * Convert a DOM Document into a soap message.
	 * <p/>
	 *
	 * @param  doc
	 * @return
	 * @throws Exception
	 */
	public static SOAPMessage toSOAPMessage(Document doc) throws Exception {
		Canonicalizer c14n = Canonicalizer.getInstance(Canonicalizer.ALGO_ID_C14N_WITH_COMMENTS);
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
			DocumentBuilder builder = factory.newDocumentBuilder();
			return builder.parse(in);
		}
	}

	/**
	 * 
	 * This function is used to get the first child element(which is Element Node type) for the passed node
	 * 
	 * @param  node
	 * @return      First Child Element Or Null if not exist
	 * @see
	 */
	public static Node getDirectChildElement(Node parentNode, String childName) {
		Node firstChildElement = null;
		if (parentNode != null && parentNode.hasChildNodes()) {
			NodeList nodeChilds = parentNode.getChildNodes();
			for (int childIndex = 0; childIndex < nodeChilds.getLength(); childIndex++) {
				Node child = nodeChilds.item(childIndex);
				if (child instanceof Element && child.getNodeType() == Node.ELEMENT_NODE) {
					Element childElement = (Element) child;
					if (childElement.getNodeName().equals(childName)) {
						firstChildElement = childElement;
						break;
					}

				}
			}
		}
		return firstChildElement;
	}

	public static YakeenDataSave updateOrSaveYakeenData(CitizenInfo citizenInfo, String nin, String outputXml) {

		YakeenDataSave yakeenDataSave = YakeenDataSaveLocalServiceUtil.createYakeenDataSave(String.valueOf(CounterLocalServiceUtil.increment()));
		yakeenDataSave.setId(nin);
		yakeenDataSave.setServiceName("CitizenInfo");
		yakeenDataSave.setCallingDate(new Date());
		yakeenDataSave.setServiceOutput(outputXml);
		yakeenDataSave.setStatus(String.valueOf(citizenInfo.getErrorCode()));
		yakeenDataSave.setServiceErrorMessage(citizenInfo.getErrorMessage());
		return YakeenDataSaveLocalServiceUtil.updateYakeenDataSave(yakeenDataSave);

	}

	public static void updateCitizenAddInfo(String iqamaId, String dob, String outputXml) throws ParseException {
		// Date dateqq = new SimpleDateFormat("dd/MM/yyyy").parse(dob);
		YakeenDataSave yakeenAddressDetails = YakeenDataSaveLocalServiceUtil.createYakeenDataSave(String.valueOf(CounterLocalServiceUtil.increment()));
		yakeenAddressDetails.setId(iqamaId);
		yakeenAddressDetails.setServiceName("CitizenAddressInfo");
		yakeenAddressDetails.setCallingDate(new Date());
		yakeenAddressDetails.setServiceOutput(outputXml);
		yakeenAddressDetails.setStatus("o");
		// yakeenAddressDetails.setDob( dob);
		YakeenDataSaveLocalServiceUtil.addYakeenDataSave(yakeenAddressDetails);
	}

	public static YakeenDataSave updateOrSaveYakeenDataAlienInfo(AlienInfo alienInfo, String nin, String outputXml) {

		YakeenDataSave yakeenDataSave = YakeenDataSaveLocalServiceUtil.createYakeenDataSave(String.valueOf(CounterLocalServiceUtil.increment()));
		yakeenDataSave.setId(nin);
		yakeenDataSave.setServiceName("AlienInfo");
		yakeenDataSave.setCallingDate(new Date());
		yakeenDataSave.setServiceOutput(outputXml);
		yakeenDataSave.setStatus(String.valueOf(alienInfo.getErrorCode()));
		yakeenDataSave.setServiceErrorMessage(alienInfo.getErrorMessage());
		return YakeenDataSaveLocalServiceUtil.updateYakeenDataSave(yakeenDataSave);

	}

	public static YakeenDataSave updateCitizenCarInfo(CarInfo carInfo, String nin, String outputXml, String Sequence) {

		YakeenDataSave yakeenDataSave = YakeenDataSaveLocalServiceUtil.createYakeenDataSave(String.valueOf(CounterLocalServiceUtil.increment()));
		yakeenDataSave.setId(nin);
		yakeenDataSave.setServiceName("CitizenCarInfoBySequence");
		yakeenDataSave.setCallingDate(new Date());
		yakeenDataSave.setServiceOutput(outputXml);
		yakeenDataSave.setStatus(String.valueOf(carInfo.getErrorCode()));
		yakeenDataSave.setServiceErrorMessage(carInfo.getErrorMessage());
		yakeenDataSave.setSequenceNumber(Sequence);
		return YakeenDataSaveLocalServiceUtil.updateYakeenDataSave(yakeenDataSave);

	}

	public static YakeenDataSave updateAlienCarInfo(CarInfo carInfo, String nin, String outputXml, String Sequence) {

		YakeenDataSave yakeenDataSave = YakeenDataSaveLocalServiceUtil.createYakeenDataSave(String.valueOf(CounterLocalServiceUtil.increment()));
		yakeenDataSave.setId(nin);
		yakeenDataSave.setServiceName("AlienCarInfoBySequence");
		yakeenDataSave.setCallingDate(new Date());
		yakeenDataSave.setServiceOutput(outputXml);
		yakeenDataSave.setStatus(String.valueOf(carInfo.getErrorCode()));
		yakeenDataSave.setServiceErrorMessage(carInfo.getErrorMessage());
		yakeenDataSave.setSequenceNumber(Sequence);
		return YakeenDataSaveLocalServiceUtil.updateYakeenDataSave(yakeenDataSave);

	}

}
