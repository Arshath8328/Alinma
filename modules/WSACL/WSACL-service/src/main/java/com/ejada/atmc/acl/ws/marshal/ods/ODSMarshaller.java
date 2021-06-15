package com.ejada.atmc.acl.ws.marshal.ods;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

public class ODSMarshaller {

	public static XMLGregorianCalendar getDateCalendar(String date) {

		try {
			GregorianCalendar cal = new GregorianCalendar();
			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			Date parsedDate = format.parse(date);
			cal.setTime(parsedDate);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static XMLGregorianCalendar getDateTimeCalendar(String date) {

		try {
			GregorianCalendar cal = new GregorianCalendar();
			SimpleDateFormat format = new SimpleDateFormat("dd-MMM-yyyy hhmm");
			Date parsedDate = format.parse(date);
			cal.setTime(parsedDate);
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

	}

	public static String getFormattedDate(XMLGregorianCalendar cal) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(cal.toGregorianCalendar().getTime());

		return dateString;
	}

	public static String getFormattedDateTime(String dateTime) {
		if (dateTime != null && !dateTime.contains(":")) {
			SimpleDateFormat parser = new SimpleDateFormat("dd-MMM-yy hhmm");
			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yy hh:mm");
			Date parsedDate;
			try {
				parsedDate = parser.parse(dateTime);
				return formatter.format(parsedDate);
			} catch (ParseException e) {

				e.printStackTrace();
			}

		}

		return dateTime;

	}
}
