<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.atmc.login.constants.LoginPortletKeys"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.liferay.portal.kernel.exception.UserScreenNameException"%>
<%@page import="com.liferay.portal.kernel.exception.UserPasswordException"%>
<%@page import="com.liferay.portal.kernel.exception.UserLockoutException"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.exception.PasswordExpiredException"%>
<%@page import="com.liferay.portal.kernel.exception.NoSuchUserException"%>
<%@page import="com.liferay.portal.kernel.exception.CookieNotSupportedException"%>
<%@page import="com.liferay.portal.kernel.exception.CompanyMaxUsersException"%>
<%@page import="com.liferay.portal.kernel.security.auth.AuthException"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<!-- <script src="https://www.google.com/recaptcha/api.js" async defer></script> -->


		<%

		String login = StringPool.BLANK;
		JournalArticle jouranl = null;
		try{
			jouranl = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),"information-security");
		} catch(Exception e) {
			
		}
		JournalArticleDisplay jouranldisplay = null;
		if(Validator.isNotNull(jouranl)){
			jouranldisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(), jouranl.getArticleId() ,"view",themeDisplay.getLanguageId(),themeDisplay);
			String content = jouranldisplay.getContent(); 
		}
		//String login = (String)SessionErrors.get(renderRequest, "login");

		String lang = themeDisplay.getLocale().toString();
//		if (Validator.isNull(login)) {
//			login = LoginUtil.getLogin(request, "login", company);
//		}

		String password = StringPool.BLANK;
		boolean rememberMe = ParamUtil.getBoolean(request, "rememberMe");
		String buyMotorMsg = ParamUtil.getString(request, "buyMotorMsg");
		String googleSiteKey =  PropsUtil.get("google.siteKey");

//		if (Validator.isNull(authType)) {
//			authType = company.getAuthType();
//		}
		%>
		
<portlet:actionURL name="/login/login"  var="loginActionURL">
	<portlet:param name="mvcRenderCommandName" value="/login/login" />
	<portlet:param name="<%=LoginPortletKeys.CMD %>" value="<%=LoginPortletKeys.CMD_AUTH %>" />
</portlet:actionURL>
<portlet:renderURL var="loginRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/login/login" />
</portlet:renderURL>
<portlet:renderURL var="registerRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/login/register" />
</portlet:renderURL>
<portlet:renderURL var="forgotPwdRenderURL">
	<portlet:param name="mvcRenderCommandName" value="/login/forgot_password" />
</portlet:renderURL>

<div class="row bg-white">
	<div class=" hidden-xs col-sm-4 col-md-4 col-lg-4 no-pad">
		<img src="/o/atmc-theme/images/login_bg.png" class="img-responsive" /> 
	</div>
	<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 no-pad">
		<div class="btn-toolbar-button close" style="float:right; margin:15px">
			<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
				<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
			</svg>
		</div>
		<div class="tab" role="tabpanel">
			<ul class="nav nav-tabs"> 
				<li class="active">
					<a href="<%=loginRenderURL%>"><liferay-ui:message key="login"/></a>
				</li>
				<li>
					<a href="<%=registerRenderURL%>"><liferay-ui:message key="register"/></a>
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
					<aui:form id="loginFormModal" action="<%= loginActionURL %>" autocomplete="off" cssClass="sign-in-form" method="post" name="loginFormModal" role="form" >
						<liferay-ui:error exception="<%= AuthException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= CompanyMaxUsersException.class %>" message="unable-to-log-in-because-the-maximum-number-of-users-has-been-reached" />
						<liferay-ui:error exception="<%= CookieNotSupportedException.class %>" message="authentication-failed-please-enable-browser-cookies" />
						<liferay-ui:error exception="<%= NoSuchUserException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= PasswordExpiredException.class %>" message="your-password-has-expired" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
						<liferay-ui:error exception="<%= UserLockoutException.LDAPLockout.class %>" message="this-account-is-locked" />
				
						<liferay-ui:error exception="<%= UserLockoutException.PasswordPolicyLockout.class %>">
				
							<%
							UserLockoutException.PasswordPolicyLockout ule = (UserLockoutException.PasswordPolicyLockout)errorException;
							%>
				
							<liferay-ui:message arguments="<%= ule.user.getUnlockDate() %>" key="this-account-is-locked-until-x" translateArguments="<%= false %>" />
						</liferay-ui:error>
				
						<liferay-ui:error exception="<%= UserPasswordException.class %>" message="authentication-failed" />
						<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" message="the-screen-name-cannot-be-blank" />
						<div style="color: red"><liferay-ui:message key="register_message"/> </div>
						<div class="form-group"> 
							<label class="control-label" for="login"><liferay-ui:message key="saudi_id_iqama"/></label>							 
							<aui:input cssClass="form-control input-lg" id="login" label="" name="login" showRequiredLabel="false" type="text" value="<%= login %>" placeholder="Please Enter your Saudi ID or Iqama">
								<aui:validator name="required" />
								<aui:validator name="number" />
								<aui:validator name="rangeLength">[10,10]</aui:validator>
							</aui:input>
						</div>						 
						<div class="form-group"> 
							<label class="control-label" for="password"><liferay-ui:message key="password"/></label>
							<a href="<%=forgotPwdRenderURL%>" class="pull-right text-muted"><liferay-ui:message key="forgot_psw"/></a>					 
							 <aui:input name="password" cssClass="form-control input-lg" id="password" label="" showRequiredLabel="false" type="password" value="<%= password %>" placeholder="Please Enter your Password">
								<aui:validator name="required" />
							</aui:input>
							 
						</div>						 
						<div class="checkbox">
							<div class="g-recaptcha required" data-sitekey="<%= googleSiteKey %>"data-callback="callback" ></div>
							<span id="callback-blankCatcha" class="captcha_error"></span><br>
							<label class="control-label"> 
								<aui:input checked="<%=rememberMe %>" name="rememberMe" label="remember" type="checkbox" />             
							</label>
						</div>						 
						<button class="btn btn-primary btn-lg" type="button" onclick="validateCompose()" ><liferay-ui:message key="login"/></button>
					</aui:form>	
					</br>
					<div><liferay-ui:message key="security-info-desc" /> <a style="cursor: pointer; text-decoration: underline" onclick="myFunction()" id="myBtn"><liferay-ui:message key="security-info" /></a>
					</div>
				</div>
			</div>	
		</div>	
		<div id="myModal" class="modal">
 		 <div class="modal-content">
    <span class="closeBtn">&times;</span>
   <div class="journal-article-preview"><%= Validator.isNotNull(jouranldisplay) ? jouranldisplay.getContent() : ""%></div>
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
		var myFormValidator = eval("Liferay.Form._INSTANCES.<portlet:namespace/>loginFormModal.formValidator");
		if(captchaValue.length == 0) {
			$("#callback-blankCatcha").append('<label id="temp"	style="color: #c60f13 !important; line-height: normal; font-size: 14px !important;">Captcha	is required.</label>');
			$("#callback-blankCatcha").show();
			myFormValidator.validateField("<portlet:namespace/>login");
			myFormValidator.validateField("<portlet:namespace/>password");
			return false;
		}else{
			myFormValidator.validateField("<portlet:namespace/>login");
			myFormValidator.validateField("<portlet:namespace/>password");
			if (!myFormValidator.hasErrors()) {
				$("#<portlet:namespace/>loginFormModal").submit();
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

var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("closeBtn")[0];
btn.onclick = function() {
    modal.style.display = "block";
}
span.onclick = function() {
    modal.style.display = "none";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}
</script>

<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    /* padding-top: 100px; /* Location of the box */ */
    left: 0;
    top: 0;
    width: auto; /* Full width */
    height: auto; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    /* padding: 20px; */
    border: 1px solid #888;
    width: auto;
    padding-left: 24px;
    padding-right: 24px;
}

/* The Close Button */
.closeBtn {
    color: #aaaaaa;
    <%%>
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.closeBtn:hover,
.closeBtn:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
/* 
@media screen and (max-height: 575px){
	#rc-imageselect, .g-recaptcha {
		transform:scale(0.77);
		-webkit-transform:scale(0.77);
		transform-origin:0 0;
		-webkit-transform-origin:0 0;
	}
} */

</style>


</body>
</html>
