<%@page import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequestMessage"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>

<portlet:renderURL var="listURL" >
	<portlet:param name="myview" value="messages_list"/>
</portlet:renderURL>

<%
	ServiceRequest msg = (ServiceRequest)request.getAttribute("reqMessage");
	List<ServiceRequestMessage> msgList = (List)request.getAttribute("messagesList");
	DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
	String creationDate = simpleDateFormat.format(msg.getCreationDate());
%>
<% if (msg != null)
	{ 
%>
	<div class="row marign-top">
				<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 no-pad">
					<table class="table table-bordered no-margin">
						<tbody>
							<tr>
								<td> 
									<span class="pull-right"> 
										<h3><%=LanguageUtil.get(request,"service_request_status_" + msg.getRequestStatus()) %></h3> 
									</span> 
									<h4><%=LanguageUtil.get(request, "Service_Request_Cat_" + msg.getRequestCategory().toLowerCase())  %>, <%=LanguageUtil.get(request, "Service_Request_Type_" + msg.getRequestType()) %></h4> 
									<small class="text-muted"><i class="material-icons">&#xE192;</i> <%=creationDate %></small> 
								</td>
							</tr>
							<tr>
								<td> 
									<span class="pull-right"> 
										<small class="text-muted"><i class="material-icons">&#xE192;</i> <%=creationDate %></small> 
									</span> 
									<h4><i class="material-icons">&#xE7FF;</i> <%=msg.getCreatorUserName() %></h4> 
									<p><%=msg.getRequestMessage() %></p> 
								</td>
							</tr>	
							<%
								for(ServiceRequestMessage item : msgList)
								{
									DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
									String cDate = simpleDateFormat.format(item.getTimeStamp());
									if(item.getUserType().equals("C"))
									{
							%>
										<tr>
											<td> 
												<span class="pull-right"> 
													<small class="text-muted"><i class="material-icons">&#xE192;</i> <%=cDate %></small> 
												</span> 
												<h4><i class="material-icons">&#xE7FF;</i> <%=item.getUserName() %></h4> 
												<p><%=item.getMessageTxt() %></p> 
											</td>
										</tr>							
							<%
									}
									else
									{
							%>
										<tr>
											<td> 
												<span class="pull-right"> 
													<small class="text-muted"><i class="material-icons">&#xE192;</i> <%=cDate %></small> 
												</span> 
												<h4><i class="material-icons">&#xE0D0;</i> <liferay-ui:message key="cust_serv" /></h4>
												<p><%=item.getMessageTxt() %></p>
											</td>
										</tr>
							<%
									}
								}
							%> 
							
							
						</tbody>
					</table>
					<%
						Boolean isClosed = msg.getRequestStatus().equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED);
					%>
					<aui:form method="post" role="form" id="replyForm" name="replyForm">
						<aui:fieldset>
							<table class="table table-bordered borderless margin-top">
								<tbody>
									<%
										if(!isClosed)
										{
									%>
											<tr>
												<td>
													<aui:input type="hidden" name="refNo" id="refNo" value="<%=msg.getReferenceNo() %>" />
													<aui:input id="myview" name="myview" type="hidden" value="message_details" />
													<aui:input type="textarea" cssClass="form-control" id="replyTxt" name="replyTxt" rows="3" placeholder="enter_ur_msg" label="">
														<aui:validator name="required" errorMessage='Please Insert Message' />
														<e:forHtmlContent value="${param.value}" />
													</aui:input>
												</td>
											</tr>
									<%
										}
									%>
									<tr>
										<td class="text-right">
											<ul class="list-btns">
												<li>
													<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="${listURL}"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back" /></a>
												</li>
												<li class="<%=isClosed ? "hidden" : ""%>">
													<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="replyBtn"><liferay-ui:message key="send" /> 
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
				</div>
			</div>
	
	<div id="aui_popup_content">
	</div>
	<div id="aui_popup_body" style="display:none;">
		<div class="text-center">
			<h4><liferay-ui:message key="message_sent" /></h4>
		</div>
	</div>
<%
	}
%>
<portlet:resourceURL var="resourceURL"/>
<aui:script>

$("#replyBtn").on('click', function(){
	
	var myFormValidator = eval("Liferay.Form._INSTANCES.<portlet:namespace/>replyForm.formValidator");

	myFormValidator.validateField("<portlet:namespace/>replyTxt");
	
	if(!myFormValidator.hasErrors())
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
					console.log('${listURL}');
					window.location = '${listURL}';
					
				}
			});
		});
}

</aui:script>