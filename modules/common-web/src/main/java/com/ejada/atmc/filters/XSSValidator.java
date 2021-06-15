package com.ejada.atmc.filters;

import org.owasp.encoder.Encode;
import org.owasp.encoder.Encoder;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author Basel A.Aziz
 * @version 1.0
 */
public class XSSValidator
{
	// private static final String SQL_INJECTION_REGEX =
	// "(\\%27)|(\\')|(\\-\\-)|(\\%23)|(#)";

	// Expression 1:
	// \s*+ zero or more times for white space char.
	// \w* - zero or more alphanumeric or underscore characters
	// \s*+ zero or more times for white space char.
	// (\%27)|\' - the ubiquitous single-quote or its hex equivalent
	// \s*+ zero or more times for white space char.
	// (\%6F)|O|(\%4F))((\%72)|R|(\%52) - the word 'OR' with various
	// combinations of its upper and lower case hex equivalents.
	// Examples: "mohamed'or", "mohamed 'or", "mohamed' or", "mohamed ' or" all
	// are sql injections.

	// Expression 2:
	// \s*+ zero or more times for white space char.
	// \w* - zero or more alphanumeric or underscore characters
	// \s*+ zero or more times for white space char.
	// ((\\%3B)|;) - the ubiquitous semi colon or its hex equivalent
	// \s*+ zero or more times for white space char.
	// \w* - zero or more alphanumeric or underscore characters
	// \s*+ zero or more times for white space char.
	// (\\-\\-)*+ to check double dash which cause comment to the rest of the
	// query.
	// combinations of its upper and lower case hex equivalents.
	// Examples: "mohamed';", "mohamed ';", "mohamed' ;", "mohamed ' ;",
	// "mohamed ' ; hussein --" all are sql injections.

	private static final String SQL_INJECTION_REGEX = "((\\s*+)(\\w*+)(\\s*+)((\\%27)|(\\'))(\\s*+)((\\%6F)|O|(\\%4F))((\\%72)|R|(\\%52))(\\s*+))"
	        + "|" + "((\\s*+)(\\w*)(\\s*+)((\\%27)|(\\'))(\\s*+)((\\%3B)|;)(\\s*+)(\\w*+)(\\s*+)((\\-\\-)*+))";

	/*
	 * private static final String SQL_INJECTION_REGEX =
	 * "((\\s*+)(\\w*)(\\s*+)((\\%27)|(\\'))(\\s*+)((\\%6F)|O|(\\%4F))((\\%72)|R|(\\%52))(\\s*+))" +
	 * "|" + "SELECT" + "|" + "INSERT" + "|" + "DELETE" + "|" + "DROP" + "|" +
	 * "UPDATE" + "|" + "EXECUTE" + "|" + "FUNCTION" + "|" + "PRAGMA" + "|" +
	 * "EXEC" + "|" + "PROCEDURE" + "|" + "WHERE" + "|" + "UNION" + "|" +
	 * "GRANT" + "|" + "REPLACE" + "|" + "CREATE" + "|" + "ALTER" + "|" +
	 * "IMMEDIATE" + "|" + "LIKE" + "|" + "BEGIN" + "|" +
	 * "AUTHID(\\s*)CURRENT_USER";
	 */

//	 Expression 1:
	// \s*+ zero or more times for white space char.
	// \S*+ A non-whitespace character: [^\s]
	// ((\%3C)|<) - check for opening angle bracket or hex equivalent
	// \s*+ zero or more times for white space char.
	// \s*+ zero or more times for white space char.
	// ((\%3E)|>) - check for closing angle bracket or hex equivalent
	// \s*+ zero or more times for white space char.
	// \S*+ A non-whitespace character: [^\s]
	// \s*+ zero or more times for white space char.
	// Examples: <script>, </script>,... etc
	
	/** @author hsanad
	 * issue  XSS vulnerabilities on ROL-Corportate
	 * remove (\) from escaping quates as the previous implementation find only escaped quates 
	 * but we should also search for any quates in passed values
	 */
	private static final String CSS_REGEX = "((\\s*+)(\\w*+)(\\s*+)((\\%3C)|<)(\\s*+)[^\\n]+(\\s*+)((\\%3E)|>)(\\s*+)(\\w*+)(\\s*+))" +
			"|" +
			"((\\s*+)(\\w*+)(\\s*+)((\\%3C)|<)((\\%69)|I|(\\%49))((\\%6D)|M|(\\%4D))((\\%67)|G|(\\%47))(\\s*+)(\\w*+)(\\s*+))" + 
			"|" + 
			"((\\s*+)(\\w*)(\\s*+)((%22)|(\"))(\\s*+)((\\%3B)|;)(\\s*+)(\\w*+)(\\s*+)((\\/\\/)*+))";

	private static final Pattern SQL_INJECTION_PATTERN = Pattern.compile(SQL_INJECTION_REGEX);
	
	private static final Pattern CSS_PATTERN= Pattern.compile(CSS_REGEX);
	
	private static final String CSS_REGEX_QUATES = "(%22|\")";
	private static final Pattern CSS_PATTERN_QUATES= Pattern.compile(CSS_REGEX_QUATES);
	
	
	/**
	 * 
	 * @param value
	 *            the values to be checked for the existance of SQL Injection or
	 *            XSS.
	 * @return true if the value dose not contain any SQL Injection or XSS,
	 *         false otherwise.
	 */
	public static boolean isValid(String value)
	{
		if (value != null && !isSQLInjectionDetected(value) && !isXSSDetected(value))
		{
			return true;
			//return !isContainsQuates(value);
		}
		else
		{
			return false;
		}
	}


	/**
	 * 
	 * @param values
	 *            the values to be checked for the existance of SQL Injection or
	 *            XSS.
	 * @return true if the values dose not contain any SQL Injection or XSS,
	 *         false otherwise.
	 */
	public static boolean isValid(List<String> values)
	{
		for (String value : values)
		{
			if (!isValid(value))
			{
				return false;
			}
		}
		return true;
	}

	/**
	 * 
	 * @param value
	 *            the value to be checked for the existance of SQL Injection.
	 * @return true if the value contains SQL Injection, false otherwise.
	 */
	private static boolean isSQLInjectionDetected(String value)
	{
		return  SQL_INJECTION_PATTERN.matcher(value.toUpperCase()).find();
	}

	/**
	 * 
	 * @param value
	 *            the value to be checked for the existance of XSS.
	 * @return true if the value contains XSS, false otherwise.
	 */
	private static boolean isXSSDetected(String value)
	{
		return CSS_PATTERN.matcher(value.toUpperCase()).find();
	}
	
	private static boolean isContainsQuates(String value)
	{
		return CSS_PATTERN_QUATES.matcher(value.toUpperCase()).find();
		
	}
	// For testing references please check the comment above the regular
	// expression.
	
	
	public static void main(String[] args)
	{
		String xssString = "en20e07%22 onload=\"alert(1)\"9464c";
		String sqlInjected ="en20e07" ;			//"mohamed ' ; hussein --";
		//System.out.println("isXSSDetected\t"+XSSValidator.isXSSDetected(xssString));
		//System.out.println("isSQLInjectionDetected\t" + XSSValidator.isSQLInjectionDetected(sqlInjected));
	}
}
