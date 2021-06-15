
package com.ejada.atmc.acl.ws.proxy.ods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 * <p>
 * Java class for anonymous complex type.
 * 
 * <p>
 * The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="Claim_IntimationResult" minOccurs="0">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="CI_RESPONSE">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="CLAIM_INTIMATION_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(
	XmlAccessType.FIELD
)
@XmlType(
		name = "",
		propOrder = { "claimIntimationResult" }
)
@XmlRootElement(
		name = "Claim_IntimationResponse"
)
public class ClaimIntimationResponse {

	@XmlElement(
			name = "Claim_IntimationResult"
	)
	protected ClaimIntimationResponse.ClaimIntimationResult claimIntimationResult;

	/**
	 * Gets the value of the claimIntimationResult property.
	 * 
	 * @return possible object is {@link ClaimIntimationResponse.ClaimIntimationResult }
	 * 
	 */
	public ClaimIntimationResponse.ClaimIntimationResult getClaimIntimationResult() {
		return claimIntimationResult;
	}

	/**
	 * Sets the value of the claimIntimationResult property.
	 * 
	 * @param value allowed object is {@link ClaimIntimationResponse.ClaimIntimationResult }
	 * 
	 */
	public void setClaimIntimationResult(ClaimIntimationResponse.ClaimIntimationResult value) {
		this.claimIntimationResult = value;
	}

	/**
	 * <p>
	 * Java class for anonymous complex type.
	 * 
	 * <p>
	 * The following schema fragment specifies the expected content contained within this class.
	 * 
	 * <pre>
	 * &lt;complexType>
	 *   &lt;complexContent>
	 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *       &lt;sequence>
	 *         &lt;element name="CI_RESPONSE">
	 *           &lt;complexType>
	 *             &lt;complexContent>
	 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
	 *                 &lt;sequence>
	 *                   &lt;element name="CLAIM_INTIMATION_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                   &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
	 *                 &lt;/sequence>
	 *               &lt;/restriction>
	 *             &lt;/complexContent>
	 *           &lt;/complexType>
	 *         &lt;/element>
	 *       &lt;/sequence>
	 *     &lt;/restriction>
	 *   &lt;/complexContent>
	 * &lt;/complexType>
	 * </pre>
	 * 
	 * 
	 */
	@XmlAccessorType(
		XmlAccessType.FIELD
	)
	@XmlType(
			name = "",
			propOrder = { "ciresponse" }
	)
	public static class ClaimIntimationResult {

		@XmlElement(
				name = "CI_RESPONSE",
				required = true
		)
		protected ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE ciresponse;

		/**
		 * Gets the value of the ciresponse property.
		 * 
		 * @return possible object is {@link ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE }
		 * 
		 */
		public ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE getCIRESPONSE() {
			return ciresponse;
		}

		/**
		 * Sets the value of the ciresponse property.
		 * 
		 * @param value allowed object is {@link ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE }
		 * 
		 */
		public void setCIRESPONSE(ClaimIntimationResponse.ClaimIntimationResult.CIRESPONSE value) {
			this.ciresponse = value;
		}

		/**
		 * <p>
		 * Java class for anonymous complex type.
		 * 
		 * <p>
		 * The following schema fragment specifies the expected content contained within this class.
		 * 
		 * <pre>
		 * &lt;complexType>
		 *   &lt;complexContent>
		 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
		 *       &lt;sequence>
		 *         &lt;element name="CLAIM_INTIMATION_NO" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="STATUS" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *         &lt;element name="MESSAGE" type="{http://www.w3.org/2001/XMLSchema}string"/>
		 *       &lt;/sequence>
		 *     &lt;/restriction>
		 *   &lt;/complexContent>
		 * &lt;/complexType>
		 * </pre>
		 * 
		 * 
		 */
		@XmlAccessorType(
			XmlAccessType.FIELD
		)
		@XmlType(
				name = "",
				propOrder = { "claimintimationno", "status", "message" }
		)
		public static class CIRESPONSE {

			@XmlElement(
					name = "CLAIM_INTIMATION_NO",
					required = true
			)
			protected String	claimintimationno;
			@XmlElement(
					name = "STATUS",
					required = true
			)
			protected String	status;
			@XmlElement(
					name = "MESSAGE",
					required = true
			)
			protected String	message;

			/**
			 * Gets the value of the claimintimationno property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getCLAIMINTIMATIONNO() {
				return claimintimationno;
			}

			/**
			 * Sets the value of the claimintimationno property.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setCLAIMINTIMATIONNO(String value) {
				this.claimintimationno = value;
			}

			/**
			 * Gets the value of the status property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getSTATUS() {
				return status;
			}

			/**
			 * Sets the value of the status property.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setSTATUS(String value) {
				this.status = value;
			}

			/**
			 * Gets the value of the message property.
			 * 
			 * @return possible object is {@link String }
			 * 
			 */
			public String getMESSAGE() {
				return message;
			}

			/**
			 * Sets the value of the message property.
			 * 
			 * @param value allowed object is {@link String }
			 * 
			 */
			public void setMESSAGE(String value) {
				this.message = value;
			}

		}

	}

}
