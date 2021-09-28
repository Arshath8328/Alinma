<%@page import="com.atmc.web.util.SessionUtil"%>
<%@page import="com.atmc.web.common.UserInfo"%>
<%@ include file="/dashboard/init.jsp" %>

<%
	UserInfo userInfo = SessionUtil.getUserInfo(request);
	boolean isCorp = false;
	if(userInfo.isOrgMode())
	{
		isCorp = true;
	}
%>
<div class="new-vehicle margin-top">
	<div class="pad-10">
		<h2 class="no-margin"><liferay-ui:message key="get_new_veh_pol"/></h2>
		<h4><liferay-ui:message key="sub_head"/></h4>
		<a href="/web/customer/buy_motor_policy" class="btn btn-lg btn-primary <%=isCorp ? "disabled" : ""%>"><liferay-ui:message key="get_now"/></a>
	</div>
</div>