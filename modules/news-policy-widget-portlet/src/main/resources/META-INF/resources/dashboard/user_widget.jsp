<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/dashboard/init.jsp" %>

<%
	Long renCount = (Long)request.getAttribute("renewalCount");
	User currentUser = PortalUtil.getUser(request);
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("hh:mm a 'on' EEEE, MMMMM dd");
%>

<div class="bg-white margin-top">
<div class="pad-10">
	<h3><span class="glyphicon glyphicon-user"></span>&nbsp; <liferay-ui:message key="welcome" /> <%=currentUser.getFirstName()%></h3>
	<p class="text-muted no-margin"><liferay-ui:message key="last_login"/> <%=dateTimeFormat.format(currentUser.getLastLoginDate())%></p><br/>
<%
	if(renCount>0)
	{
%>
	<p> <a href="/group/customer/policies"><span class="round round-link round-sm hollow red text-white"><%=renCount%></span></a>&nbsp; <liferay-ui:message key="upcome_rens"/></p>
<%
	}
%>
</div>
</div>