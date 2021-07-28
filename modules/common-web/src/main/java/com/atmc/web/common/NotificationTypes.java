package com.atmc.web.common;

public class NotificationTypes {

	public enum Type {
		QUOTATION_EXPIRY_AND_NOT_PAID {
			public String val() {
				return "QUOTATION_EXPIRY_AND_NOT_PAID";
			}
		},
		QUOTATION_PAYMENT_FAILED
		{
			public String val() {
				return "QUOTATION_PAYMENT_FAILED";
			}
		},
		QUOTATION_GENERATION_OD_PENDING_SURVEY
		{
			public String val() {
				return "QUOTATION_GENERATION_OD_PENDING_SURVEY";
			}
		},
		QUOTATION_GENERATION_OD_PENDING_PAYMENT
		{
			public String val() {
				return "QUOTATION_GENERATION_OD_PENDING_PAYMENT";
			}
		},
		QUOTATION_GENERATION_TPL
		{
			public String val() {
				return "QUOTATION_GENERATION_TPL";
			}
		},
		TEMP_PASSWORD_QUOTATION_FLOW
		{
			public String val() {
				return "TEMP_PASSWORD_QUOTATION_FLOW";
			}
		},
		POLICY_ISSUANCE_EMAIL
		{
			public String val() {
				return "POLICY_ISSUANCE_EMAIL";
			}
		},
		POST_CLAIM_INTIMATION
		{
			public String val() {
				return "POST_CLAIM_INTIMATION";
			}
		},
		SERVICE_REQUEST_COMPLAINT
		{
			public String val() {
				return "SERVICE_REQUEST_COMPLAINT";
			}
		},
		SERVICE_REQUEST_INQUIRY
		{
			public String val() {
				return "SERVICE_REQUEST_INQUIRY";
			}
		},
		SERVICE_REQUEST_SUGGESTION
		{
			public String val() {
				return "SERVICE_REQUEST_SUGGESTION";
			}
		},
		CLOSURE_SERVICE_REQUEST_COMPLAINT
		{
			public String val() {
				return "CLOSURE_SERVICE_REQUEST_COMPLAINT";
			}
		},
		CLOSURE_SERVICE_REQUEST_INQUIRY
		{
			public String val() {
				return "CLOSURE_SERVICE_REQUEST_INQUIRY";
			}
		},
		POILCY_ENDORSEMENT_RECIEVED
		{
			public String val() {
				return "POILCY_ENDORSEMENT_RECIEVED";
			}
		},
		POILCY_ENDORSEMENT_REJECTED
		{
			public String val() {
				return "POILCY_ENDORSEMENT_REJECTED";
			}
		},
		POILCY_REJECTED_EMAIL
		{
			public String val() {
				return "POILCY_REJECTED_EMAIL";
			}
		},
		POILCY_ENDORSEMENT_WP
		{
			public String val() {
				return "POILCY_ENDORSEMENT_WP";
			}
		},
		POILCY_ENDORSEMENT_SUCCESS
		{
			public String val() {
				return "POILCY_ENDORSEMENT_SUCCESS";
			}
		},
		POILCY_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL
		{
			public String val() {
				return "POILCY_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL";
			}
		},
		POILCY_OTHER_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL
		{
			public String val() {
				return "POILCY_OTHER_ENDORSEMENT_REQ_RCVD_SRVC_PORTAL_EMAIL";
			}
		},
		CLAIM_REQUEST_MISSING_DOCUMENTS
		{
			public String val() {
				return "CLAIM_REQUEST_MISSING_DOCUMENTS";
			}
		},
		QUOTATION_PRE_EXPIRY
		{
			public String val() {
				return "QUOTATION_PRE_EXPIRY";
			}
		},
		QUOTATION_POST_EXPIRY
		{
			public String val() {
				return "QUOTATION_POST_EXPIRY";
			}
		};

		abstract public String val();
	}

}
