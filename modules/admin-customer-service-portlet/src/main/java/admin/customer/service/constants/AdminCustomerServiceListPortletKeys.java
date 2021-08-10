package admin.customer.service.constants;

public class AdminCustomerServiceListPortletKeys {
	
	public static final String AdminListPortlet = "ATMCAdminCSListPortlet";
	public static final String AdminSendPortlet = "ATMCAdminCSSendPortlet";
	
	public static final String ASSIGN = "ATMCAssignServiceRequest";
	public static final String CMD = "CMD";
	public static final String CMD_ASSIGN = "CMDASSIGN";
	
	public static final String ASSIGNED_TO = "Assigned To";
//	public static final String CUSTOMER_SERVICE_ROLE = "Customer Service";
//	public static final String FINANCE_ROLE = "Finance";
//	public static final String CLAIM_MANAGER_ROLE = "Claim Manager";
//	public static final String CLAIM_PROCESSOR_ROLE = "Claim Processor";
//	public static final String SURVEYOR_ROLE = "Surveyor";
//	public static final String RECOVERY_ROLE = "Recovery";
	
	
	public enum ACTION_TYPES
	{
		ASSIGNED_TO("A"),
		REPLIED("R"),
		ESCALATED("E");
		
		private String value;  
		private ACTION_TYPES(String value){  
			this.value=value;  
		}  
		public String getValue() {
			return this.value;
		}
	}
	
	public enum USER_ROLES
	{
		CUSTOMER_SERVICE_ROLE("Customer Service"),
		FINANCE_ROLE("Finance"),
		CLAIM_MANAGER_ROLE("Claim Manager"),
		CLAIM_PROCESSOR_ROLE("Claim Processor"),
		SURVEYOR_ROLE("Surveyor"),
		RECOVERY_ROLE("Recovery");
		
		private String value;  
		private USER_ROLES(String value){  
			this.value=value;  
		}  
		public String getValue() {
			return this.value;
		}
		public static boolean isRoleExist(String userRole) {
			Boolean result = Boolean.FALSE;
			for(USER_ROLES role : USER_ROLES.values() )
			{
				if(role.getValue().equals(userRole))
				{
					result = Boolean.TRUE;
					break;
				}
			}
			return result;
		}
	}
}
