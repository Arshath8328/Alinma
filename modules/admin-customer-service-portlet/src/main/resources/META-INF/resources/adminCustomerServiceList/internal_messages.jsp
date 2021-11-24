<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAction"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestAttachment"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
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
<%@page import="com.liferay.portal.kernel.model.RoleConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<%
	String refNo = request.getParameter("refNo");
	List<ServiceRequestAction> actionList = (List)request.getAttribute("actionList");
%>
<portlet:renderURL var="listURL" >
	<portlet:param name="myview" value="message_details"/>
	<portlet:param name="refNo" value="<%=request.getParameter("refNo") %>"/>
</portlet:renderURL>

<ul class="nav nav-tabs clearfix">
	<li ><a href="${listURL}" ><liferay-ui:message key="cust_req"/></a></li>
	<li class="active"><a href="javascript:void(0)" role="tab" data-toggle="tab"><liferay-ui:message key="internal_msg"/></a></li>
</ul>
<div class="tab-pane" role="tabpanel" id="tab-2">
		<div class="panel-group cover-type-group" id="accordion">
			<%
				int count= 0;
				for(ServiceRequestAction action : actionList)
				{
					DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
					String actionDate = simpleDateFormat.format(action.getActionDate());
			%>
					<div class="panel panel-default">
					   <div class="panel-heading" role="tab">
					      	<h4 class="panel-title">
								<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="false" href="#accordion-<%=count %>" class="accordion-toggle collapsed"> 
						  			<%=action.getActionDetails() %> <br>
						  			<span class="text-muted"><%=actionDate %></span> 
						  		</a>
						  	</h4>
					   </div>
					   <div class="panel-collapse collapse" id="accordion-<%=count%>" role="tabpanel" aria-expanded="false" style="height: 0px;">
					      <div class="panel-body">
					         <p><%=action.getActionRemarks() %></p>
					      </div>
					   </div>
					</div>
			<%
					count++;
				}
			%>
		</div>
	</div>
	
<aui:form method="post" role="form" id="commentForm" name="commentForm">
	<aui:fieldset>
		<table class="table table-bordered borderless margin-top">
			<tbody>
				<tr>
					<td>
						<aui:input type="hidden" name="refNo" id="refNo" value="<%=refNo %>" />
						<aui:input id="myview" name="myview" type="hidden" value="internal_messages" />
						<aui:input type="textarea" cssClass="form-control" id="replyTxt" name="replyTxt" rows="3" placeholder="enter_ur_msg" label="">
							<aui:validator name="required" errorMessage='Please Insert Message' />
							<e:forHtmlContent value="${param.value}" />
						</aui:input>
					</td>
				</tr>
				<tr>
					<td class="text-left">
						<ul class="list-btns">
							<li>
								<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn"><liferay-ui:message key="send" /> 
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


<div id="aui_popup_content">
	</div>
	<div id="aui_popup_body" style="display:none;">
	<div class="text-center">
		<h4><liferay-ui:message key="message_sent" /></h4>
	</div>
</div>

<portlet:resourceURL var="resourceURL">
	<portlet:param name="actionName" value="comment"/>
	<portlet:param name="refNo" value="<%=refNo %>"/>
</portlet:resourceURL>
<aui:script use="liferay-util-window,liferay-portlet-url">

$("#submitBtn").on('click', function(){
	if($.trim($("#<portlet:namespace/>replyTxt").val()) != '')
	{
		AUI().use('aui-io-request', function(A){
	        A.io.request('<%=resourceURL.toString()%>', {
	               method: 'post',
	               dataType: 'json',
	               form: {
	                   id: '<portlet:namespace/>commentForm'
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
				bodyContent: $('#aui_popup_body').html(),
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

</aui:script>