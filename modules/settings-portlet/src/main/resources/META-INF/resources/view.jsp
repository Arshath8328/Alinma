<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp" %>
<portlet:defineObjects />
<theme:defineObjects />
<portlet:renderURL var="updateEmailURL">
	<portlet:param name="myview" value="update-email"/>
</portlet:renderURL>
<portlet:renderURL var="updateMobileURL">
	<portlet:param name="myview" value="update-mobile"/>
</portlet:renderURL>
<portlet:renderURL var="changePasswordURL">
	<portlet:param name="myview" value="change-password"/>
</portlet:renderURL>
<% 

User currentUser = PortalUtil.getUser(request);
String userName=currentUser.getFullName();
String userEmail=currentUser.getEmailAddress();
String userPhone="";
if(!currentUser.getPhones().isEmpty()){
	userPhone=currentUser.getPhones().get(0).getNumber();
}
else{
	userPhone="";
}

String userPassword=currentUser.getPassword();
String error=(String)request.getAttribute("error");
%>

<div class="row">
	<div class="col-md-12 col-sm-12 col-xs-12 no-pad">
		<div class="profile-section">
			<div>
				<h1><span class="glyphicon glyphicon-user"></span><br><%=userName%></h1>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 no-pad">
		<div class="portlet-content no-margin">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
				    <liferay-ui:error key="password_mismatch" message="password_error_message" />
					<br/>
					<br/>
					<table class="table borderless"> 
						<tbody> 
							<tr> 
								<td><span class="fas fa-envelope text-muted"></span>&nbsp;&nbsp;&nbsp;&nbsp;<liferay-ui:message key="email"/></td> 
								<td><%=userEmail%></td> 
								<td class="text-center">
									<button type="button" class="btn btn-default" onclick="location.href = '${updateEmailURL}'"><liferay-ui:message key="edit_button"/></button>
								</td>
							</tr>
							<tr> 
								<td><span class="fas fa-phone-alt text-muted"></span>&nbsp;&nbsp;&nbsp;&nbsp;<liferay-ui:message key="mobile"/></td> 
								<td><%=userPhone%></td> 
								<td class="text-center">
									<button type="button" class="btn btn-default" onclick="location.href = '${updateMobileURL}'"><liferay-ui:message key="edit_button"/></button>
								</td>
							</tr>
							<tr> 
								<td><span class="fas fa-lock text-muted"></span>&nbsp;&nbsp;&nbsp;&nbsp;<liferay-ui:message key="passwrod"/></td> 
								<td>**********</td> 
								<td class="text-center">
									<button type="button" class="btn btn-default" onclick="location.href = '${changePasswordURL}'" ><liferay-ui:message key="edit_button"/></button>
								</td>
							</tr>									 
						</tbody>
					</table>
				</div>
			</div>
		</div>					 
	</div>
</div>
			