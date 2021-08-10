<%@page import="com.google.gson.Gson"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@page import="com.atmc.bsl.db.service.SrvReqMsgsLocalServiceUtil"%>
<%@page import="com.atmc.bsl.db.service.SrvReqLocalServiceUtil"%>
<%@page import="com.atmc.bsl.db.service.SrvReqAttachmentLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.search.ServiceRequestSearchTerms"%>
<%@page import="com.atmc.web.search.ServiceRequestSearch"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<liferay-ui:success key="delete_success" message="file_delete_success"/>
<liferay-ui:error key="delete_error" message="file_delete_error" /> 
<%
	String refNo = request.getParameter("refNo");
	
	String[] statusList = new String[]{CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW, CustomerServiceRequestListPortletKeys.REQUEST_STATUS_ASSIGNED, CustomerServiceRequestListPortletKeys.REQUEST_STATUS_OPEN};
	List<ServiceRequest> serviceRequests = SrvReqLocalServiceUtil.getServiceRequestsListByStatus(statusList, userRole);
	
	/** Get Message Details **/
	ServiceRequest msg = SrvReqLocalServiceUtil.getServiceRequestbyRefNo(refNo);
	
	/** Get List of Message Replies **/
	List<ServiceRequestMessage> msgList = SrvReqMsgsLocalServiceUtil.getServiceRequestMessageListbyRefNo(msg.getReferenceNo());

	/** Get All Attachments **/
	List<ServiceRequestAttachment> attachList = SrvReqAttachmentLocalServiceUtil.getServiceRequestAttachmentListbyRefNo(refNo);

	String srvReqString = "";
	try{
		Gson gson = new Gson();
		srvReqString = gson.toJson(msg);
		srvReqString = srvReqString.replaceAll("\"", "'");
	}
	catch(Exception e)
	{
		
	}
	DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String creationDate = simpleDateFormat.format(msg.getCreationDate());
	
	Boolean isUserRoleAdmin = Boolean.FALSE; 
	if(userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue()))
	{
		isUserRoleAdmin = Boolean.TRUE;
	}
	
	
	/** History **/
	User loggedInUser = themeDisplay.getUser();
	loggedInUser.getRoles();
	ServiceRequest serviceRequest = SrvReqLocalServiceUtil.getServiceRequestbyRefNo(refNo);
	//** Boolean isMatch = serviceRequests.stream().anyMatch(serReq -> serReq.getReferenceNo().equals(refNo)); **/
	Boolean isMatch;
	if(loggedInUser.getRoles().stream().anyMatch(role -> role.getName().equals("Customer Service"))){
		isMatch=true;
	}else{
		isMatch = loggedInUser.getRoles().stream().anyMatch(role -> role.getName().equals(serviceRequest.getAssignedTo()));
	}
	System.out.println("isMatch : " + isMatch);
%>
<portlet:renderURL var="internalMsgURL" >
	<portlet:param name="refNo" value="<%=msg.getReferenceNo() %>"/>
	<portlet:param name="myview" value="internal_messages"/>
</portlet:renderURL>
<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="cust_serv_details"/></h1>



<div class="container-fluid-1280">

<c:choose>
    <c:when test = "<%= !isMatch %>" >
		<div style="color:red">Sorry, you do not have permission to view this service</div>
    </c:when>
    <c:otherwise>
        
    

<ul class="nav nav-tabs clearfix">
	<li class="active"><a href="javascript:void(0)" role="tab" data-toggle="tab"><liferay-ui:message key="cust_req"/></a></li>
	<li><a href="${internalMsgURL}"><liferay-ui:message key="internal_msg"/></a></li>
</ul>

<div class="tab-content bg-white pad-10">


	<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
		<table class="table table-bordered">
			<tr> 
				<td>
					<liferay-ui:message key="req_ref" /><br /> <h3 class="text-primary"><%=msg.getReferenceNo() %></h3> </td> 
				<td>
					<liferay-ui:message key="requested_by" /><br /> <h3><%=msg.getCreatorUserName() %></h3> </td> 
				<td>
					<liferay-ui:message key="type" /><br /> <h3><%=LanguageUtil.get(request, "Service_Request_Type_" + msg.getRequestType()) %></h3> </td> 
				<td>
					<liferay-ui:message key="date_received" /><br /> <h3><%=creationDate %></h3> </td> 
			</tr>
		</table>
		<h4 class="text-primary"><liferay-ui:message key="customer_info" /></h4>
		<table class="table table-bordered"> 
			<tr> 
				<td width="40%"><liferay-ui:message key="name" /></td> 
				<td width="60%"><%=msg.getCreatorUserName() %></td>
			</tr>
			<tr> 
				<td><liferay-ui:message key="id_number" /></td> 
				<td><%=msg.getIqamaId() %></td> 
			</tr>						 
			<tr> 
				<td><liferay-ui:message key="email" /></td> 
				<td><%=msg.getEmail() %></td>
			</tr>
			<tr> 
				<td><liferay-ui:message key="mobile_number" /></td> 
				<td><%=msg.getMobile() %></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="service_req" /></td>
				<td><%=msg.getRequestCategory()%></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="type" /></td>
				<td><%=LanguageUtil.get(request, "Service_Request_Type_" + msg.getRequestType()) %></td>
			</tr>
			<tr>
				<td><liferay-ui:message key="product" /></td>
				<td><%=LanguageUtil.get(request, "Service_Request_Product_" + msg.getProductType()) %></td>
			</tr>
		</table>
		<h4 class="text-primary"><liferay-ui:message key="attachs" /></h4>
		<table class="table table-bordered">
			<%
				for(int i = 0 ; attachList != null && i < attachList.size() ; i++)
				{
					ServiceRequestAttachment file = attachList.get(i);
			%>
					 <portlet:resourceURL var="downloadURL">
					 	<portlet:param name="fileID" value="<%=file.getFileId()+"" %>"/>
					 	<portlet:param name="refNo" value="<%=msg.getReferenceNo() %>"/>
					 	<portlet:param name="actionName" value="download"/>
					 </portlet:resourceURL>
					 <%if(isUserRoleAdmin){%>
					 <portlet:actionURL var="deleteFileAction" name="deleteFile">
						<portlet:param name="myview" value="message_details"/>
						<portlet:param name="fileID" value="<%=file.getFileId()+"" %>"/>
						<portlet:param name="refNo" value="<%=msg.getReferenceNo() %>"/>
						<portlet:param name="msgDetails" value="<%=srvReqString %>"/>
					 </portlet:actionURL>
					 <%} %>
					<tr>
						<td width="70%"><%=file.getFileName() %></td>
						<td width="30%">
							<table width="50%">
								<tr>
									<td width="50%"><a href="${downloadURL}"><i class="	glyphicon glyphicon-download-alt"></i></a></td>
									<%if(isUserRoleAdmin) {%><td width="50%"><a href="${deleteFileAction}"><i class="glyphicon glyphicon-trash"></i></a></td><%} %>
								</tr>
							</table>
						</td>
					</tr>
			<%
				}
			%>
		</table>
		<h4 class="text-primary"><liferay-ui:message key="conv" /></h4>
		<table class="table table-bordered">
			<tr>
				<td> <i class="material-icons">&#xE8A6;</i> <%=msg.getCreatorUserName() %> <span class="pull-right text-muted"><i class="material-icons">&#xE192;</i><%=creationDate %></span> </td>
			</tr>
			<tr>
				<td><%=msg.getRequestMessage() %></td>
			</tr>
			<%
				for(int i = 0 ; msgList != null && i < msgList.size() ; i++)
				{
					ServiceRequestMessage reply = msgList.get(i);
					String replyDate = simpleDateFormat.format(reply.getTimeStamp());
					if(reply.getUserType().equals("C"))
					{
			%>
						<tr>
							<td> <i class="material-icons">&#xE8A6;</i> <%=reply.getUserName() %> <span class="pull-right text-muted"><i class="material-icons">&#xE192;</i> <%=replyDate %></span> </td>
						</tr>
						<tr>
							<td><%=reply.getMessageTxt()%> </td>
						</tr>
			<%
					}
					else
					{
			%>
						<tr>
							<td> <i class="material-icons">&#xE8A6;</i> <liferay-ui:message key="cust_serv" /> <span class="pull-right text-muted"><i class="material-icons">&#xE192;</i> <%=replyDate %></span> </td>
						</tr>
						<tr>
							<td><%=reply.getMessageTxt()%></td>
						</tr>
			<%
					}
				}
			%>
		</table>
		<%
			if(isUserRoleAdmin)
			{
		%>
				<aui:form method="post" role="form" id="replyForm" name="replyForm">
					<aui:fieldset>
						<table class="table table-bordered borderless margin-top">
							<tbody>
								<tr>
									<td>
										<aui:input type="hidden" name="refNo" id="refNo" value="<%=msg.getReferenceNo() %>" />
										<aui:input id="myview" name="myview" type="hidden" value="message_details" />
										<aui:input type="textarea" cssClass="form-control" id="replyTxt" name="replyTxt" rows="3" placeholder="enter_ur_msg" label="" maxlength="700">
											<aui:validator name="required" errorMessage='Please Insert Message' />
											<e:forHtmlContent value="${param.value}" />
										</aui:input>
									</td>
								</tr>
								<tr>
									<td class="text-left">
										<ul class="list-btns">
											<li>
												<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="sendBtn"><liferay-ui:message key="send" /> 
													<i class="material-icons md-24">&#xE163;</i>
												</button>
											</li>
										</ul>
									</td>
								</tr>
							</tbody>
						</table>
					</aui:fieldset>
				</aui:form>
		<%
			}
		%>	
		<% 
			if(isUserRoleAdmin)
			{
				if (!msg.getRequestStatus().equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED))
				{
		%>
				<div class="row">
					<div class="col-md-12 text-right no-pad">
						<ul class="list-btns">
							<li class="pull-left">
								<a class="btn btn-lg btn-xs-block btn-link text-muted" role="button" onclick="window.history.go(-1); return false;">
									<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
								</a>
							</li>
							<%
								if (!msg.isEscalatedFlag())
								{
							%>
									<li>
										<portlet:actionURL var="escalateURL" name="srvReqEscalate" >
											<portlet:param name="myview" value="escalated_requests"/>
											<portlet:param name="refNo"  value="<%=msg.getReferenceNo()%>"/>
										</portlet:actionURL>
										<a class="btn btn-danger btn-outline btn-lg btn-xs-block" role="button"  href="${escalateURL}" id="escalateBtn" name="escalateBtn"><liferay-ui:message key="escalated" /></a>
									</li>
							<%
								}
							%>
							<li>
								<a class="btn btn-primery btn-outline btn-lg btn-xs-block" id="assignBtn" name="assignBtn" role="button" href="javascript:;"><liferay-ui:message key="assign_to" /></a>
							</li>
							<li>
								
								<a class="btn btn-primary btn-lg btn-xs-block" role="button" id="closeBtn" name="closeBtn"><liferay-ui:message key="change_to_close" /></a>
							</li>
						</ul>
					</div>
				</div>
		<%
				}
			}
		%>
	</div>
	
	
</div>

</c:otherwise>
</c:choose>

<liferay-portlet:renderURL portletName="<%=AdminCustomerServiceListPortletKeys.ASSIGN%>" var="assignToURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<liferay-portlet:param name="mvcRenderCommandName" value="/adminCustomerServiceList/assign_to" />
	<liferay-portlet:param name="refNo" value="<%=msg.getReferenceNo()+""%>" />
	<liferay-portlet:param name="portletInstanceID" value="<%="_INSTANCE_" + themeDisplay.getPortletDisplay().getInstanceId()%>" />
</liferay-portlet:renderURL>


    

</div>

<div id="aui_popup_content">
	</div>
	<div id="aui_popup_body" style="display:none;">
	<div class="text-center">
		<h4><liferay-ui:message key="message_sent" /></h4>
	</div>
</div>
<div id="close_popup_content"></div>
<div id="close_popup_body" style="display:none;">
	<form method="post" name="closeForm">
		<div class="text-center">
			<div class="row">
				<div class="col-md-12">
					<h3 class="text-primary">
						<liferay-ui:message key="sure_to_close" />
					</h3>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<portlet:actionURL var="closeURL" name="srvReqClose" >
								<portlet:param name="myview" value="closed_requests"/>
								<portlet:param name="refNo"  value="<%=msg.getReferenceNo()%>"/>
							</portlet:actionURL>
							<a role="button" class="btn btn-primary btn-lg" href="${closeURL}"><liferay-ui:message key="yes" /></a>
						</li>
						<li>
							<button class="btn btn-link text-muted btn-lg" type="button" onClick="$('.close').click().click();"><liferay-ui:message key="cancel" /></button>
						</li>
						
					</ul>
				</div>
			</div>
		</div>
	</form>
</div>
<portlet:resourceURL var="resourceURL" >
	<portlet:param name="actionName" value="reply"/>
</portlet:resourceURL>
<aui:script use="liferay-util-window,liferay-portlet-url">
$('#assignBtn').on('click', function(event) {
	Liferay.Util.openWindow(
			{
				cache: false,
				dialog: {
					destroyOnHide: true,
					cssClass: 'atmc-popup',
					align: Liferay.Util.Window.ALIGN_CENTER,
					modal:true,
					resizable: false,
					width: 845,
					height: 421
				},
				dialogIframe: {
					id: '<portlet:namespace />dialog',
					uri: '<%=assignToURL.toString()%>'
				},
				uri: '<%=assignToURL.toString()%>'
			});
    
}); 
$("#closeBtn").on('click', function(){
	closeModal();
});
$("#sendBtn").on('click', function(){
	if($.trim($("#<portlet:namespace/>replyTxt").val()) != '')
	{
		AUI().use('aui-io-request', function(A){
	        A.io.request('<%=resourceURL.toString()%>', {
	               method: 'post',
	               dataType: 'json',
	               form: {
	                   id: '<portlet:namespace/>replyForm'
	               },
	               on: {
	                    success: function()
	                    {
	                    	successFn();
	                    }
	               }
	            });
	    });
	}
});
function successFn()
{
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '<h3><liferay-ui:message key="cust_serv" /></h3>',
				centered: true,
				modal: true,
				width: 500,
				height: 300,
				render: '#aui_popup_content'
			});
			dialog.render();
			dialog.addToolbar(
			      [
			        {
			          label: 'Done',
			          cssClass: 'btn-primary',
			          
			          on: {
			            click: function() {
			            	dialog.hide();
			            }
			          }
			        }
			      ]
			    );
			dialog.on('visibleChange', function(event) {
				if (!event.newVal) {
					window.location = '/group/staff/manage_customer_service';
					
				}
			});
		});
}
function closeModal()
{
	AUI().use('aui-modal', function(A) {
		var dialog = new A.Modal({
			title: "",
			bodyContent: $('#close_popup_body').html(),
			headerContent: '',
			centered: true,
			modal: true,
			width: 500,
			height: 300,
			render: '#close_popup_content'
		});						
		dialog.on('visibleChange', function(event) {
			if (!event.newVal) {
				//window.location = '/group/staff/manage_customer_service';
			}
		});
	});
}
</aui:script>