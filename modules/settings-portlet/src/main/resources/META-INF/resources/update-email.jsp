<%@page import="com.atmc.otp.constants.OtpPortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp" %>


<portlet:renderURL var="viewCancelURL">
	<portlet:param name="myview" value="view"/>
</portlet:renderURL>
<portlet:actionURL var="viewURL" name="updateEmail">
	<portlet:param name="myview" value="view"/>
</portlet:actionURL>
<% 

User  currentUser = PortalUtil.getUser(request);
String userEmail=currentUser.getEmailAddress();
String userPhone="";
if(!currentUser.getPhones().isEmpty()){
	userPhone=currentUser.getPhones().get(0).getNumber();
}
else{
	userPhone="";
}
%>
<aui:form id="emailForm" name="emailForm" action="<%=viewURL%>" method="post" >

<div class="row margin-top">
	<div class="col-sm-12 col-xs-12 col-md-12 no-pad">
		<form role="form">
			<table class="table table-bordered no-margin"> 
				<thead> 
					<tr> 
						<th><h4 class="text-primary"><liferay-ui:message key="edit_email"/></h4></th> 									 									 									 
					</tr>								 
				</thead>							 

				<tbody> 
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBePOP3User.class %>" message="the-email-address-you-requested-is-reserved" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeReserved.class %>" message="the-email-address-you-requested-is-reserved" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
				<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />								 								 

					<tr> 
						<td>
							<div class="row">
								<div class="col-xs-12 col-lg-offset-1 col-sm-6 col-md-offset-1 col-md-4 col-lg-4">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="email"/></label>
										<aui:input type="Text" id="emailInput" name="emailInput" label="" class="form-control" value="<%=userEmail%>">
											<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="email" errorMessage="pls_enter_valid_email"/>
									</aui:input>
									</div>												 												 
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 col-xs-12 text-right no-pad col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
									<ul class="list-btns">
										<li>
											<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="#" onclick="location.href = '${viewCancelURL}'"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/></a>
										</li>
										<li>
											<button class="btn btn-primary btn-lg btn-xs-block" id="emailButton" type="button"><liferay-ui:message key="update_button"/></button>
										</li>
									</ul>
								</div>
							</div>
						</td>									 									 									 									 
					</tr>								 
				</tbody>
			</table>						 						 						 						 						 						 
		</form>					 
	</div>
</div>
</aui:form>
<aui:script>
function submitEmail(){
	
	console.log("submitting form");
	$("#<portlet:namespace />emailForm").submit();
}

</aui:script>

<aui:script use="liferay-util-window,liferay-portlet-url">

	$('#emailButton').on('click', function(event) {
		
		var actionURL = Liferay.PortletURL.createActionURL();
		actionURL.setWindowState("<%= LiferayWindowState.POP_UP.toString() %>");
		actionURL.setName("/auth/otp");
		actionURL.setPortletId("<%=OtpPortletKeys.OTP%>");
		actionURL.setParameter("mvcRenderCommandName","/auth/otp");
		actionURL.setParameter("<%=OtpPortletKeys.CMD%>","<%=OtpPortletKeys.CMD_SEND%>");
		actionURL.setParameter("<%=OtpPortletKeys.REDIRECT_JS_METHOD%>","submitEmail");
		
		Liferay.Util.openWindow(
				{
					cache: false,
					dialog: {
						destroyOnHide: true,
						cssClass: 'atmc-otp-sm',
						headerContent: 'We have sent an OTP to the provided Mobile Number',
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal:true,
						resizable: false,
						width: 500,
						height: 200
					},
					dialogIframe: {
						id: '<portlet:namespace />dialog',
						uri: actionURL.toString()
					},
					uri: actionURL.toString()
				});
	    
	}); 

	
	
	</aui:script>