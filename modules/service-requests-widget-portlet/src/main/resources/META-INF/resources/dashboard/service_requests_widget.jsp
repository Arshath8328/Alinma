<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ include file="/dashboard/init.jsp" %>

<%
	List<ServiceRequest> msgList = (List)request.getAttribute("msgsList");

%>
<div class="portlet-content no-pad">
	<ul class="list-group no-margin" style="min-height:311px;"> 
		<li class="list-group-item text-primary"><liferay-ui:message key="service_reqs"/>
			<a href="/group/customer/compose_new_service_request" class="pull-right width-60 text-center"><span class="glyphicon glyphicon-plus"></span></a>
		</li>							 
		<%
			if(msgList == null || msgList.size() <= 0)
			{
		%>
				<li class="list-group-item text-center" style="height:75px">
					<div class="text-muted">
						<liferay-ui:message key="there-are-no-service-requests"/>
					</div>
					<a href="/group/customer/compose_new_service_request" class="btn btn-default">
						<span class="glyphicon glyphicon-plus"></span> <liferay-ui:message key="add_new_request"/>
					</a>
				</li>
		<%
			}
			else
			{
				int loopCounter = ( msgList != null && msgList.size() > 3) ? 3 : msgList.size();  
				for(int i =0 ; i < loopCounter; i++)
				{
					ServiceRequest msg = msgList.get(i);
					DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String creationDate = simpleDateFormat.format(msg.getCreationDate());
					String[] msgArr = msg.getRequestMessage().split(" ");
					String msgTitle = "";
					for(int count = 0 ; count < msgArr.length && count < 6; count++)
					{
						msgTitle += msgArr[count] + " ";
					}
						
		%>
					<li class="list-group-item">
						<div class="pull-right text-center text-primary width-60">
							<%=LanguageUtil.get(request,"service_request_status_" + msg.getRequestStatus())  %>						
						</div>
						<span><%=msgTitle %></span>
						<br />
						<small class="text-muted">
							<%=LanguageUtil.get(request,"Service_Request_Cat_" + msg.getRequestCategory().toLowerCase())   + ", " + LanguageUtil.get(request,"Service_Request_Type_" + msg.getRequestType())  %><br /> <span class="glyphicon glyphicon-time"></span> <%= creationDate%> </small>
					</li>
		<%
				}	
			}
		
		%>
		
		<li class="list-group-item text-center text-muted"> 
			<a href="/group/customer/customer_service"><liferay-ui:message key="view_all"/></a>
		</li>							 
	</ul>
</div>