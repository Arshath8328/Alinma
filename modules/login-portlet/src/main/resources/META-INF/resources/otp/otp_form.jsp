<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.atmc.web.constants.OTPPortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>

<%
	String redirect = ParamUtil.getString(request, OTPPortletKeys.REDIRECT_URL);
	String redirectJsMethod = ParamUtil.getString(request, OTPPortletKeys.REDIRECT_JS_METHOD);
	String mobile = ParamUtil.getString(request, OTPPortletKeys.MOBILE_NUMBER);
	String sendTo = ParamUtil.getString(request, OTPPortletKeys.SEND_TO);
	String screenName = ParamUtil.getString(request, "login");
	boolean isOTPSent = ParamUtil.getBoolean(request, "otpSent");
	System.out.println("otp_form_jsp_1");
%>
<portlet:actionURL name="/auth/otp"  var="validateOTPURL">
	<portlet:param name="mvcRenderCommandName" value="/auth/otp" />
	<portlet:param name="<%=OTPPortletKeys.CMD %>" value="<%=OTPPortletKeys.CMD_VALIDATE%>" />
</portlet:actionURL>
<portlet:actionURL name="/auth/otp"  var="resendOTPURL">
	<portlet:param name="mvcRenderCommandName" value="/auth/otp" />
	<portlet:param name="<%=OTPPortletKeys.CMD %>" value="<%=OTPPortletKeys.CMD_RESEND%>" />
	<portlet:param name="<%=OTPPortletKeys.REDIRECT_URL%>" value="<%=redirect%>" />
	<portlet:param name="<%=OTPPortletKeys.REDIRECT_JS_METHOD%>" value="<%=redirectJsMethod%>" />
    <portlet:param name="<%=OTPPortletKeys.MOBILE_NUMBER%>" value="<%=mobile%>" />
	<portlet:param name="<%=OTPPortletKeys.MODE_LOGIN%>" value="<%=String.valueOf(isLogin)%>" />
	<portlet:param name="<%=OTPPortletKeys.SEND_TO%>" value="<%=sendTo%>" />
	<portlet:param name="login" value="<%=screenName%>" />
</portlet:actionURL>
<aui:form action="<%= validateOTPURL %>" method="post" name="otpForm" role="form">
	<aui:input name="<%=OTPPortletKeys.REDIRECT_URL%>" type="hidden" value="<%= redirect %>" />
	<aui:input name="<%=OTPPortletKeys.REDIRECT_JS_METHOD%>" type="hidden" value="<%= redirectJsMethod %>" />
	<aui:input name="<%=OTPPortletKeys.MOBILE_NUMBER%>" type="hidden" value="<%= mobile %>" />
	<aui:input name="<%=OTPPortletKeys.MODE_LOGIN%>" type="hidden" value="<%= String.valueOf(isLogin) %>" />
	<div class="form-group"> 
		<label class="control-label" for="otp"><liferay-ui:message key="otp_sent_reg_mobile"/></label>							 
		<aui:input autoFocus="<%= true %>" cssClass="form-control input-lg" showRequiredLabel="false" name="otp" id="otp" label="" placeholder="<%= LanguageUtil.get(request, "enter_otp") %>">
			<aui:validator name="required" />							
		</aui:input>
	</div>						 
	<aui:button cssClass="btn btn-primary btn-lg" type="submit" value="<%= LanguageUtil.get(request, "continue_btn") %>"/>

	<c:choose>
	<c:when test="<%= isOTPSent %>">
		<div><liferay-ui:message key="otp_sent"/></div>
	</c:when>
	<c:otherwise>					 
		<aui:a href="<%=resendOTPURL%>"><liferay-ui:message key="resend"/></aui:a>
	</c:otherwise>
	</c:choose>	
</aui:form>