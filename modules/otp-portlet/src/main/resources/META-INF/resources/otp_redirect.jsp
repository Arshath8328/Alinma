<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="init.jsp" %>

<% 
	String redirectURL = ParamUtil.getString(request, OtpPortletKeys.REDIRECT_URL);
	String redirectJsMethod = ParamUtil.getString(request, OtpPortletKeys.REDIRECT_JS_METHOD);
	boolean redirectJs = (redirectJsMethod!= null && !redirectJsMethod.isEmpty())?true:false;
%>
<script>
AUI().ready(function() {    
	var redirectJs = <%=redirectJs%>;
	if (redirectJs)
	{
		var fnName = "<%=redirectJsMethod%>";
		var fn = window.parent[fnName];
		if (typeof fn == "function") {
			fn();
			$('button.close', window.parent.document).click().click();
		}
	}
	else
		window.parent.location.href = '<%=redirectURL%>';
});

</script>
