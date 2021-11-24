<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="javax.portlet.*"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>

<%@ include file="init.jsp" %>

<%
	List<ServiceRequest> msgList = (List)request.getAttribute("msgsList");
%>
<portlet:actionURL name="messageDetails" var="detailsURL"/>
<div class="row">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 no-pad">
		<div class="row bg-body pad-10">
			<div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
				<h3 class="text-primary"><liferay-ui:message key="cust_srv_title" /></h3>
			</div>
			<div class="col-xs-12 col-sm-12 col-md-4 col-lg-4 text-right no-pad">
				<a href="/group/customer/compose_new_service_request" class="btn btn-primary btn-lg btn-xs-block" ><liferay-ui:message key="compose_msg" /></a>
			</div>
		</div>
		<aui:form  id="detailsForm" name="detailsForm" method="post">
			<table class="table ej-table table-striped"> 
				<thead> 
					<tr> 
						<th><liferay-ui:message key="req_ref" /></th> 
						<th><liferay-ui:message key="category" /></th> 
						<th><liferay-ui:message key="date" /></th> 
						<th><liferay-ui:message key="status" /></th>
					</tr>							 
				</thead>						 
				<tbody>
				<%
					if(msgList != null)
					{
						for(int i = msgList.size()-1 ; i >= 0 ; i--)
						{
							ServiceRequest msg = (ServiceRequest)msgList.get(i);
							DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
							String creationDate = simpleDateFormat.format(msg.getCreationDate());
							String status = msg.getRequestStatus();
							String dets = "";
							try{
								Gson gson = new Gson();
								dets = gson.toJson(msg);
								dets = dets.replaceAll("\"", "'");
							}
							catch(Exception e)
							{
								
							}
				%> 
							<tr class="<%= status.equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW) ? "bg-info" : "" %>"> 
								<td data-label='<liferay-ui:message key="req_ref" />'>
									<div class="btn btn-link no-pad" onclick="openDetails('<%=i %>');"><%=msg.getReferenceNo() %></div>
									
									<input id="myview_<%=i %>" name="myview_<%=i %>" type="hidden" value="message_details" />
									<input id="msgDetails_<%=i %>" name="msgDetails_<%=i %>" type="hidden" value="<%=dets %>"/>
								</td>
								<td data-label='<liferay-ui:message key="category" />'><%=LanguageUtil.get(request, "Service_Request_Cat_" + msg.getRequestCategory().toLowerCase()) %>, <%=LanguageUtil.get(request, "Service_Request_Type_" + msg.getRequestType())%></td>
								<td data-label='<liferay-ui:message key="date" />'><%=creationDate %></td> 
								<td data-label='<liferay-ui:message key="status" />'><%=LanguageUtil.get(request,"service_request_status_" + status) %></td>
							</tr>
				<%
						}
					}
				%>
				</tbody>
			</table>
		</aui:form>
	</div>
</div>
<script>
	function openDetails(count)
	{
		//alert(12);
		//alert("<%=detailsURL%>");
		var inputTemplate = "<input type='hidden' name='' value=''/>";
		var dets = $("#msgDetails_"+count).val();
		var myview = $("#myview_"+count).val();
		$('#<portlet:namespace/>detailsForm').find("input[type=hidden]").remove();
		$("#<portlet:namespace/>detailsForm").attr("action","<%=detailsURL%>");
		$(inputTemplate).attr('name','<portlet:namespace/>myview').val(myview).appendTo('#<portlet:namespace/>detailsForm');
		$(inputTemplate).attr('name','<portlet:namespace/>msgDetails').val(dets).appendTo('#<portlet:namespace/>detailsForm');
		$("#<portlet:namespace/>detailsForm").submit();
	}
</script>