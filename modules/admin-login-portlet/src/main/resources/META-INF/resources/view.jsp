<%@ include file="/init.jsp" %>
<%
		String redirect = ParamUtil.getString(request, "redirect");
		%>
<portlet:actionURL name="/adminLogin/adminLogin" var="loginURL">
</portlet:actionURL>
<portlet:renderURL var="forgotPwdRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/adminLogin/forgot_password" />
</portlet:renderURL>


<div class="vertical-center">                   
  <div class="container-fluid-1280">
  	<aui:form action="<%= loginURL %>" autocomplete='on' cssClass="sign-in-form" method="post" name="loginForm">
	<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
						<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
						<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
						<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
				
						<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>"/>
						<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />

<div class="row vcenter margin-bottom">
	<div class="col-xs-12 no-pad col-sm-12 col-md-4 col-lg-4">
		<img src="/o/atmc-theme/images/logo.svg" class="img-responsive pull-left" width="420" /> 
	</div>
</div>
<div class="row">
	<div class="col-md-4 col-lg-4 col-sm-12 col-xs-12">
		<form role="form" autocomplete="off"> 
			<div class="form-group">
				<label class="control-label"><liferay-ui:message key="user_name"/></label>							 
				<aui:input autoFocus="true" cssClass="clearable" name="login" type="Text" value="" label="">
					<aui:validator name="required" errorMessage="required_field_validator"/>
					<aui:validator name="email" errorMessage="pls_enter_valid_email"/>
				</aui:input> 
			</div>						 
			<div class="form-group"> 
				<label class="control-label"><liferay-ui:message key="Password"/></label>
				<a href="<%=forgotPwdRenderURL%>" class="pull-right text-muted"><liferay-ui:message key="forgot_psw"/></a>							 
				<aui:input name="password" type="password" label="">
					<aui:validator name="required" errorMessage="pls_enter_password"/>
				</aui:input>
			</div>						 
			<button class="btn btn-primary" type="submit"><liferay-ui:message key="admin_sign_in"/></button>						 
		</form>					 
	</div>
	<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
		<div class="jumbotron"> 
			<h1>Hello, world!</h1> 
			<p>This is a simple hero unit, a simple jumbotron-style component for calling extra attention to featured content or information.</p> 
			<p></p> 		
		</div>					 
	</div>
</div>
</aui:form>
  </div>
</div>
