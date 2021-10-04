<%@page import="com.liferay.portal.kernel.exception.UserPasswordException"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL var="viewURL" name="changePassword">
	<portlet:param name="myview" value="view"/>
</portlet:actionURL>
<portlet:renderURL var="viewCancelURL">
	<portlet:param name="myview" value="view"/>
</portlet:renderURL>

<aui:form action="<%=viewURL%>" method="post" >
<%
User  currentUser = PortalUtil.getUser(request);
String userPassword=currentUser.getPassword();
%>

<div class="row margin-top">
	<div class="col-sm-12 col-xs-12 col-md-12 no-pad">
		<form role="form" autocomplete="off">
			<table class="table table-bordered no-margin">
			 <liferay-ui:error key="password_mismatch" message="password_error_message" /> 
			  <liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="the-passwords-you-entered-do-not-match" />
			  <liferay-ui:error exception="<%= UserPasswordException.MustMatchCurrentPassword.class %>" message="password_error_message" />
			<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="the-password-cannot-be-blank" />
			<liferay-ui:error exception="<%= UserPasswordException.MustNotBeTrivial.class %>" message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
			<liferay-ui:error exception="<%= UserPasswordException.MustNotContainDictionaryWords.class %>" message="that-password-uses-common-dictionary-words" />
			<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>"/>
				<thead> 
					<tr> 
						<th><h4 class="text-primary"><liferay-ui:message key="edit_password"/></h4></th> 
					</tr>								 
				</thead>							 
				<tbody> 
					<tr> 
						<td>
							<div class="row">
								<div class="col-xs-12 col-lg-offset-1 col-sm-6 col-md-offset-1 col-md-4 col-lg-4">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="current_password"/></label>
										<aui:input type="password" name="currentPassword" id="currentPassword" label="" class="form-control" onchange="checkForConfirm();">
											<aui:validator name="required" errorMessage="required_field_validator"/>
										</aui:input>
									</div>												 
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-lg-offset-1 col-sm-6 col-md-offset-1 col-md-4 col-lg-4">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="new_password"/></label>
										<aui:input type="password"  name="newUserPassword" id="newUserPassword"  label="" class="form-control" onchange="checkForConfirm();">
											<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="minLength" errorMessage="password_length">8</aui:validator>
										</aui:input>
									</div>												 
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12 col-lg-offset-1 col-sm-6 col-md-offset-1 col-md-4 col-lg-4">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="confirm_password"/></label>
										<aui:input type="password" name="confirmUserPassword" id="confirmUserPassword" label="" class="form-control" onchange="checkForConfirm();">
											<aui:validator name="required" errorMessage="required_field_validator"/>
											<aui:validator name="equalTo"  errorMessage="password_matching">'#<portlet:namespace />newUserPassword'</aui:validator>
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
											<button class="btn btn-primary btn-lg btn-xs-block" type="submit" id="submitBtn" onclick="checkForConfirm();" disabled><liferay-ui:message key="update_button"/></button>
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


<script>

function checkForConfirm()
{
	if($('#<portlet:namespace />currentPassword').val()!="" && $('#<portlet:namespace />newUserPassword').val()!="" && $('#<portlet:namespace />confirmUserPassword').val()!="")
		$('#submitBtn').removeAttr('disabled');
	else
		$('#submitBtn').attr('disabled','disabled');
}

</script>