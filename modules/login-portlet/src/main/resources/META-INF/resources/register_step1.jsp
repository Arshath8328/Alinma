<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> -->

<%
	String buyMotorMsg = ParamUtil.getString(request, "buyMotorMsg");
	String googleSiteKey =  PropsUtil.get("google.siteKey");
%>
<portlet:actionURL name="/login/register" var="validateUserURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
	<portlet:param name="mvcRenderCommandName" value="/login/register" />
	<portlet:param name="<%=LoginPortletKeys.CMD %>" value="<%=LoginPortletKeys.CMD_VALIDATE_USER%>" />
</portlet:actionURL>
<portlet:renderURL var="loginURL">
	<portlet:param name="mvcRenderCommandName" value="/login/login" />
</portlet:renderURL>
<portlet:renderURL var="registerURL">
	<portlet:param name="mvcRenderCommandName" value="/login/register" />
</portlet:renderURL>

<div class="row bg-white">
	<div class="hidden-xs col-sm-4 col-md-4 col-lg-4 no-pad">
		<img src="/o/atmc-theme/images/login_bg.png" class="img-responsive" /> 
	</div>
	<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 no-pad">
		<div class="btn-toolbar-button close">
			<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
				<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
			</svg>
		</div>
		<div class="tab" role="tabpanel">
			<ul class="nav nav-tabs"> 
				<li>
					<a href="<%=loginURL%>" ><liferay-ui:message key="login"/></a>
				</li>
				<li class="active">
					<a href="<%=registerURL%>" ><liferay-ui:message key="register"/></a>
				</li>						 
			</ul>
			<div class="tab-content tabs">
				<div role="tabpanel" class="tab-pane fade in active">
<%
	if(buyMotorMsg !=null)
	{
%>
					<liferay-ui:message key="<%=buyMotorMsg %>"/>
<%
	}
%>					
					<div style="color: red"><liferay-ui:message key="register_message"/> </div>
					<aui:form id="registerForm" action="<%= validateUserURL %>" method="post" name="registerForm" role="form">
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeDuplicate.class %>" message="error.register.login" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="error.register.buy.policy" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
						<div class="form-group"> 
							<label class="control-label" for="idiqama"><liferay-ui:message key="saudi_id_iqama"/></label>							 
							<aui:input autoFocus="<%= true %>" cssClass="form-control input-lg" showRequiredLabel="false" name="idiqama" id="idiqama" label="" placeholder="Please Enter your Saudi ID or Iqama">
								<aui:validator name="required" />
								<aui:validator name="number" />
								<aui:validator name="rangeLength">[10,10]</aui:validator>
							</aui:input>
						</div>						 
						<div class="form-group"> 
							<label class="control-label" for="emailAddress"><liferay-ui:message key="email"/></label>							 
							<aui:input  name="emailAddress" id="emailAddress" cssClass="form-control input-lg" showRequiredLabel="false" label="" placeholder="atmc@atmc.com">
								<aui:validator name="required" />
								<aui:validator name="email" />
							</aui:input>
							<div class="g-recaptcha required" data-sitekey="<%= googleSiteKey %>" data-callback="callback"></div>
							<span id="callback-blankCatcha" class="captcha_error"></span>
						</div>						 
						<button class="btn btn-primary btn-lg" type="button" onClick="validateCompose()"><liferay-ui:message key="submit"/></button>			 
					</aui:form>	
				</div>
			</div>
		</div>	 
	</div>
</div>
<script>
function validateCompose(){
	var elementExists = $(".g-recaptcha").length;
    if(elementExists>0){
    	$( "#temp" ).remove();
		var captchaValue = grecaptcha.getResponse();
		var myFormValidator = eval("Liferay.Form._INSTANCES.<portlet:namespace/>registerForm.formValidator");
		if(captchaValue.length == 0) {
			$("#callback-blankCatcha").append('<label id="temp"	style="color: #c60f13 !important; line-height: normal; font-size: 14px !important;">Captcha	is required.</label>');
			$("#callback-blankCatcha").show();
			myFormValidator.validateField("<portlet:namespace/>idiqama");
			myFormValidator.validateField("<portlet:namespace/>emailAddress");
			return false;
		}else{
			myFormValidator.validateField("<portlet:namespace/>idiqama");
			myFormValidator.validateField("<portlet:namespace/>emailAddress");
			if (!myFormValidator.hasErrors()) {
				$("#<portlet:namespace/>registerForm").submit();
			}
		}
     }
}
function callback(){
	$("#callback-blankCatcha").hide();
	$( "#temp" ).hide();
    return true; 
}
var captchaReload = function(langCode) {
    var url = "https://www.google.com/recaptcha/api.js?hl=" + langCode;
    $.getScript(url);
};
$(document).ready(function(){
	$(".btn-toolbar-button").on("click", function(){
		$('button.close', window.parent.document).click().click();
	});
	captchaReload(themeDisplay.getLanguageId().substr(0,2));
});
</script>