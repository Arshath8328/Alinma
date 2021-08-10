<%@page import="admin.customer.service.constants.AdminCustomerServiceListPortletKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@ include file="/adminCustomerServiceList/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>

<%
ServiceRequest srvReq = (ServiceRequest) request.getAttribute("view.jsp-srvReq");

ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW );
if (row != null) {
	srvReq = (ServiceRequest)row.getObject();
}

%>
<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
 
	<portlet:renderURL var="details">
		<portlet:param name="myview" value="message_details"/>
		<portlet:param name="refNo" value="<%=srvReq.getReferenceNo()+""%>"/>
	</portlet:renderURL>
  	<liferay-ui:icon  message="details" url="<%=details.toString() %>" />
  
    <%
    	
    		if(!srvReq.getRequestStatus().equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED))
    		{
    %>

				<liferay-portlet:renderURL portletName="<%=AdminCustomerServiceListPortletKeys.ASSIGN%>" var="assignToURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
					<liferay-portlet:param name="mvcRenderCommandName" value="/adminCustomerServiceList/assign_to" />
					<liferay-portlet:param name="refNo" value="<%=srvReq.getReferenceNo()+""%>" />
					<liferay-portlet:param name="portletInstanceID" value="<%="_INSTANCE_" + themeDisplay.getPortletDisplay().getInstanceId()%>" />
				</liferay-portlet:renderURL>
				<li  id="assignTo_<%=srvReq.getReferenceNo() %>" >
					<a href="javascript:void(0)"><liferay-ui:message key="assign_to" /></a>
				</li>
				<aui:script use="liferay-util-window,liferay-portlet-url">
					$('#assignTo_<%=srvReq.getReferenceNo() %>').on('click', function(event) {
						Liferay.Util.openWindow(
								{
									cache: false,
									dialog: {
										destroyOnHide: true,
										cssClass: 'atmc-popup',
										align: Liferay.Util.Window.ALIGN_CENTER,
										modal:true,
										resizable: false,
										width: 900,
										height: 500
									},
									dialogIframe: {
										id: '<portlet:namespace />dialog',
										uri: '<%=assignToURL.toString()%>'
									},
									uri: '<%=assignToURL.toString()%>'
								});
					    
					}); 
					$('#closeRequest_<%=srvReq.getReferenceNo() %>').on('click', function(event) {
						//openModal();
						var url = $(this).attr('url');
						//alert(url);
						openModal();
						$("#confirmBtn").attr('href', url);
					});
					function openModal()
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
									$("#confirmBtn").attr('href', '');
								}
							});
						});
					}
				</aui:script>
			  	
			  	<%
				  	if(userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue()))
			    	{
			  	%>
			  	<li>
			  		<portlet:actionURL var="closeURL" name="srvReqClose" >
						<portlet:param name="myview" value="closed_requests"/>
						<portlet:param name="refNo"  value="<%=srvReq.getReferenceNo()%>"/>
					</portlet:actionURL>
					<a href="javascript:void(0)" id="closeRequest_<%=srvReq.getReferenceNo() %>" url="${closeURL}"><liferay-ui:message key="change_to_close" /></a>
					
				</li>
				
			  	<%
			    	}
			    	if(!srvReq.isEscalatedFlag())
			    	{
			    %>
					  	<portlet:actionURL var="escalateURL" name="srvReqEscalate" >
							<portlet:param name="myview" value="escalated_requests"/>
							<portlet:param name="refNo"  value="<%=srvReq.getReferenceNo()%>"/>
						</portlet:actionURL>
						<li>
					  		<a href="${escalateURL}"><liferay-ui:message key="escalated" /></a>
					  	</li>
				<%
			    	}
				%>
			  	
    <%
    		}
    	
    %>

  
  </liferay-ui:icon-menu>
	
  
    
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
							<a role="button" class="btn btn-primary btn-lg" href="" id="confirmBtn"><liferay-ui:message key="yes" /></a>
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