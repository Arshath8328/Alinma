package com.atmc.filters;

import org.owasp.encoder.Encode;
import org.owasp.encoder.Encoder;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author  Basel A.Aziz
 * @version 1.0
 */
public class XSSValidator {

	private static final String		SQL_INJECTION_REGEX		= "((\\s*+)(\\w*+)(\\s*+)((\\%27)|(\\'))(\\s*+)((\\%6F)|O|(\\%4F))((\\%72)|R|(\\%52))(\\s*+))" + "|"
			+ "((\\s*+)(\\w*)(\\s*+)((\\%27)|(\\'))(\\s*+)((\\%3B)|;)(\\s*+)(\\w*+)(\\s*+)((\\-\\-)*+))";

	/**
	 * @author hsanad issue XSS vulnerabilities on ROL-Corportate remove (\) from escaping quates as the previous
	 *         implementation find only escaped quates but we should also search for any quates in passed values
	 */
	private static final String		CSS_REGEX				= "((\\s*+)(\\w*+)(\\s*+)((\\%3C)|<)(\\s*+)[^\\n]+(\\s*+)((\\%3E)|>)(\\s*+)(\\w*+)(\\s*+))" + "|"
			+ "((\\s*+)(\\w*+)(\\s*+)((\\%3C)|<)((\\%69)|I|(\\%49))((\\%6D)|M|(\\%4D))((\\%67)|G|(\\%47))(\\s*+)(\\w*+)(\\s*+))" + "|"
			+ "((\\s*+)(\\w*)(\\s*+)((%22)|(\"))(\\s*+)((\\%3B)|;)(\\s*+)(\\w*+)(\\s*+)((\\/\\/)*+))";

	private static final Pattern	SQL_INJECTION_PATTERN	= Pattern.compile(SQL_INJECTION_REGEX);

	private static final Pattern	CSS_PATTERN				= Pattern.compile(CSS_REGEX);

	private static final String		CSS_REGEX_QUATES		= "(%22|\")";
	private static final Pattern	CSS_PATTERN_QUATES		= Pattern.compile(CSS_REGEX_QUATES);

	/**
	 * 
	 * @param  value the values to be checked for the existance of SQL Injection or XSS.
	 * @return       true if the value dose not contain any SQL Injection or XSS, false otherwise.
	 */
	public static boolean isValid(String value) {
		if (value != null && !isSQLInjectionDetected(value) && !isXSSDetected(value)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 
	 * @param  values the values to be checked for the existance of SQL Injection or XSS.
	 * @return        true if the values dose not contain any SQL Injection or XSS, false otherwise.
	 */
	public static boolean isValid(List<String> values) {
		for (String value : values) {
			if (!isValid(value)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param  value the value to be checked for the existance of SQL Injection.
	 * @return       true if the value contains SQL Injection, false otherwise.
	 */
	private static boolean isSQLInjectionDetected(String value) {
		return SQL_INJECTION_PATTERN.matcher(value.toUpperCase()).find();
	}

	/**
	 * 
	 * @param  value the value to be checked for the existance of XSS.
	 * @return       true if the value contains XSS, false otherwise.
	 */
	private static boolean isXSSDetected(String value) {
		return CSS_PATTERN.matcher(value.toUpperCase()).find();
	}

	private static boolean isContainsQuates(String value) {
		return CSS_PATTERN_QUATES.matcher(value.toUpperCase()).find();

	}
}
