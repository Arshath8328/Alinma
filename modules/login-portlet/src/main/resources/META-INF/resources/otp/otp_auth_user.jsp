<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.otp.constants.OtpPortletKeys"%>
<%@ include file="init.jsp" %>
<%
	Log _log = LogFactoryUtil.getLog(this.getClass());

	_log.info("otp_auth_user.jsp");
	String redirect = ParamUtil.getString(request, OtpPortletKeys.REDIRECT_URL);
	String redirectJsMethod = ParamUtil.getString(request, OTPPortletKeys.REDIRECT_JS_METHOD);
	String mobile = ParamUtil.getString(request, OTPPortletKeys.MOBILE_NUMBER);
	if(mobile == null || mobile.equals(""))
		mobile = (String)request.getAttribute(OTPPortletKeys.MOBILE_NUMBER);
	boolean isOTPSent = ParamUtil.getBoolean(request, "otpSent");
	
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
	<%-- <portlet:param name="<%=OTPPortletKeys.MOBILE_NUMBER%>" value="<%=mobile%>" /> --%>
	<portlet:param name="<%=OTPPortletKeys.MODE_LOGIN%>" value="<%=String.valueOf(isLogin)%>" />
</portlet:actionURL>
<aui:form action="<%= validateOTPURL %>" cssClass="form pad-10" method="post" name="otpForm" role="form">
	<aui:input name="<%=OTPPortletKeys.REDIRECT_URL%>" type="hidden" value="<%= redirect %>" />
	<aui:input name="<%=OTPPortletKeys.REDIRECT_JS_METHOD%>" type="hidden" value="<%= redirectJsMethod %>" />
	<aui:input name="<%=OTPPortletKeys.MOBILE_NUMBER%>" type="hidden" value="<%= mobile %>" />
	<aui:input name="<%=OTPPortletKeys.MODE_LOGIN%>" type="hidden" value="<%= String.valueOf(isLogin) %>" />
	<div class="row">
		<div class="col-lg-12">
			<p><liferay-ui:message key="plz_enter_otp"/></p>
		</div>
	</div>
	<div class="row">
		<div class="col-lg-6 col-md-6 col-sm-6 col-xs-6">
			<aui:input autoFocus="<%= true %>" cssClass="form-control input-lg" showRequiredLabel="false" name="otp" id="otp" label="" placeholder="<%= LanguageUtil.get(request, "enter_otp") %>">
				<aui:validator name="required" />							
			</aui:input>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3">
			<c:choose>
				<c:when test="<%= isOTPSent %>">
					<div><liferay-ui:message key="otp_sent"/></div>
				</c:when>
				<c:otherwise>					 
				<div id="otplink" style="display:none">					 
					<aui:a cssClass="btn btn-link" href="<%=resendOTPURL%>"><liferay-ui:message key="resend"/></aui:a>
				</div>
				<div id="some_div"></div>
				</c:otherwise>
			</c:choose>
		</div>
		<div class="col-lg-3 col-md-3 col-sm-3 col-xs-3 text-right">
			<aui:button cssClass="btn btn-primary" type="submit" value="<%= LanguageUtil.get(request, "continue_btn") %>"/>
		</div>	
	</div>
</aui:form>		
  <script>
	var timeLeft = 30;
	var elem = document.getElementById('some_div');
	var timerId = setInterval(countdown, 1000);
	function countdown() {
	    if (timeLeft == -1) {
	        clearTimeout(timerId);
	        doSomething();
	    } else {
	        elem.innerHTML = 'Enter otp 00.'+timeLeft ;
	        timeLeft--;
	    }
	}
	function doSomething() {
		document.getElementById('otplink').style.display="block";
	     document.getElementById('some_div').style.display="none";
	}
	</script>

