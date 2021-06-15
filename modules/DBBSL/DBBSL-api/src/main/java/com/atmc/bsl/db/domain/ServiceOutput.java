/**
 * 
 */
package com.atmc.bsl.db.domain;

/**
 * @author Basel
 *
 */
public class ServiceOutput <DOMAIN> implements ReturnCodes
{	
	protected DOMAIN outputObject;
	protected String outputCode;

	/**
	* @return the outputObject
	*/
	public DOMAIN getOutputObject()
	{
		return outputObject;
	}

	/**
	* @param outputObject
	*            the outputObject to set
	*/
	public void setOutputObject(DOMAIN outputObject)
	{
		this.outputObject = outputObject;
	}

	/**
	* @return the outputCode
	*/
	public String getOutputCode()
	{
		return outputCode;
	}

	/**
	* @param outputCode
	*            the outputCode to set
	*/
	public void setOutputCode(String outputCode)
	{
		this.outputCode = outputCode;
	}

}
