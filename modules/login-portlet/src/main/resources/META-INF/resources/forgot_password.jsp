<%--
/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */
--%>

<%@ include file="/init.jsp" %>

<%
User user2 = (User)request.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_USER);

if (Validator.isNull(authType)) {
	authType = company.getAuthType();
}

Integer reminderAttempts = (Integer)portletSession.getAttribute(WebKeys.FORGOT_PASSWORD_REMINDER_ATTEMPTS);

if (reminderAttempts == null) {
	reminderAttempts = 0;
}
%>

<portlet:actionURL name="/login/forgot_password" var="forgotPasswordURL">
	<portlet:param name="mvcRenderCommandName" value="/login/forgot_password" />
</portlet:actionURL>

<div class="row">
	<div class="hidden-xs col-sm-4 col-md-4 col-lg-4 no-pad">
		<img src="/o/atmc-theme/images/login_bg.png" class="img-responsive" /> 
	</div>
	<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 pad-10">
		<div class="btn-toolbar-button close" style="float:right; margin:15px">
			<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
				<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
			</svg>
		</div>
		<ul class="nav nav-tabs" data-pg-collapsed> 
			<li class="active">
				<a href=""><liferay-ui:message key="forgot_psw"/></a>
			</li>						 
		</ul>
			<aui:form action="<%= forgotPasswordURL %>" method="post" name="fm">
			<aui:input name="saveLastPath" type="hidden" value="<%= false %>" />
		
			<liferay-ui:error exception="<%= CaptchaConfigurationException.class %>" message="a-captcha-error-occurred-please-contact-an-administrator" />
			<liferay-ui:error exception="<%= CaptchaTextException.class %>" message="text-verification-failed" />
			<liferay-ui:error exception="<%= NoSuchUserException.class %>" message='<%= "the-" + TextFormatter.format(HtmlUtil.escape(authType), TextFormatter.K) + "-you-requested-is-not-registered-in-our-database" %>' />
			<liferay-ui:error exception="<%= RequiredReminderQueryException.class %>" message="you-have-not-configured-a-reminder-query" />
			<liferay-ui:error exception="<%= SendPasswordException.MustBeEnabled.class %>" message="password-recovery-is-disabled" />
			<liferay-ui:error exception="<%= UserActiveException.class %>" message="your-account-is-not-active" />
			<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
			<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />
			<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
		
			<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">
		
				<%
				UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
				%>
		
				<liferay-ui:message arguments="<%= ule.user.getUnlockDate() %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
			</liferay-ui:error>
		
			<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="answer_not_match" />
		
			<aui:fieldset>
				<c:choose>
					<c:when test="<%= user2 == null %>">
		
						<%
						String loginParameter = null;
						String loginLabel = null;
		
						if (authType.equals(CompanyConstants.AUTH_TYPE_EA)) {
							loginParameter = "emailAddress";
							loginLabel = "email-address";
						}
						else if (authType.equals(CompanyConstants.AUTH_TYPE_SN)) {
							loginParameter = "screenName";
							loginLabel = "screen-name";
						}
						else if (authType.equals(CompanyConstants.AUTH_TYPE_ID)) {
							loginParameter = "userId";
							loginLabel = "id";
						}
		
						String loginValue = ParamUtil.getString(request, loginParameter);
						%>
		
						<aui:input name="step" type="hidden" value="1" />
		
						<c:if test="<%= !GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED)) %>">
							<portlet:renderURL var="redirectURL">
								<portlet:param name="mvcRenderCommandName" value="/login/login" />
							</portlet:renderURL>
		
							<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />
						</c:if>
		
						<aui:input label="<%= loginLabel %>" name="<%= loginParameter %>" size="30" type="text" value="<%= loginValue %>">
							<aui:validator name="required" />
						</aui:input>
		
						<c:if test="<%= true %>">
							<portlet:resourceURL id="/login/captcha" var="captchaURL" />
		
							<liferay-captcha:captcha url="<%= captchaURL %>" />
						</c:if>
		
						<aui:button-row>
							<aui:button cssClass="btn-lg" type="submit" value='<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_ENABLED)) ? "next" : "send-new-password" %>' />
						</aui:button-row>
					</c:when>
					<c:when test="<%= (user2 != null) && Validator.isNotNull(user2.getEmailAddress()) %>">
						<aui:input name="step" type="hidden" value="2" />
						<aui:input name="emailAddress" type="hidden" value="<%= user2.getEmailAddress() %>" />
		
						<portlet:renderURL var="redirectURL">
							<portlet:param name="mvcRenderCommandName" value="/login/login" />
						</portlet:renderURL>
		
						<aui:input name="redirect" type="hidden" value="<%= redirectURL %>" />
		
						<c:if test="<%= Validator.isNotNull(user2.getReminderQueryQuestion()) && Validator.isNotNull(user2.getReminderQueryAnswer()) %>">
		
							<%
							String login = user2.getEmailAddress();
							%>
		
							<div class="alert alert-info">
								<liferay-ui:message arguments="<%= HtmlUtil.escape(login) %>" key="a-new-password-will-be-sent-to-x-if-you-can-correctly-answer-the-following-question" translateArguments="<%= false %>" />
							</div>
		
							<aui:input autoFocus="<%= true %>" label="<%= HtmlUtil.escape(LanguageUtil.get(request, user2.getReminderQueryQuestion())) %>" name="answer" type="text" />
						</c:if>
		
						<c:choose>
							<c:when test="<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.USERS_REMINDER_QUERIES_REQUIRED)) && !user2.hasReminderQuery() %>">
								<div class="alert alert-info">
									<liferay-ui:message key="the-password-cannot-be-reset-because-you-have-not-configured-a-reminder-query" />
								</div>
							</c:when>
							<c:otherwise>
								<c:if test="<%= reminderAttempts >= 3 %>">
									<portlet:resourceURL id="/login/captcha" var="captchaURL" />
		
									<liferay-captcha:captcha url="<%= captchaURL %>" />
								</c:if>
		
								<aui:button-row>
									<aui:button cssClass="btn-lg" type="submit" value='<%= company.isSendPasswordResetLink() ? "send-password-reset-link" : "send-new-password" %>' />
								</aui:button-row>
							</c:otherwise>
						</c:choose>
					</c:when>
					<c:otherwise>
						<div class="alert alert-warning">
							<liferay-ui:message key="email_not_provided" />
						</div>
					</c:otherwise>
				</c:choose>
			</aui:fieldset>
		</aui:form>		 
	</div>	
</div>
<script>
$(document).ready(function(){
	$(".btn-toolbar-button").on("click", function(){
		$('button.close', window.parent.document).click().click();
	});
});
</script>	 