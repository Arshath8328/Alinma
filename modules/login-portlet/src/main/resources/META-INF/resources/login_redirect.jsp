<%@ include file="/init.jsp" %>

<% 
	boolean isRegister = ParamUtil.getBoolean(request, "isRegister");
	String redirectURL = themeDisplay.getPortalURL() + "/group/customer/dashboard";
	if (isRegister)
		redirectURL = themeDisplay.getPortalURL() + "/web/customer/setpassword";
%>
<script>
AUI().ready(function() {    
	
	window.parent.location.href = '<%=redirectURL%>';
});

</script>
