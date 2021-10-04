<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.login.constants.LoginPortletKeys"%>
<%@ include file="init.jsp" %>
<% 
	Log _log = LogFactoryUtil.getLog(this.getClass());

	String loginActive = (isLogin)?"active":"";
	String registerActive = (isLogin)?"":"active";
	_log.info("otp_unauth_user.jsp");
%>
<liferay-portlet:renderURL portletName="<%=LoginPortletKeys.LOGIN%>" var="loginURL">
	<portlet:param name="mvcRenderCommandName" value="/login/login" />
</liferay-portlet:renderURL>					
<liferay-portlet:renderURL portletName="<%=LoginPortletKeys.LOGIN%>" var="registerURL">
	<portlet:param name="mvcRenderCommandName" value="/login/register" />
</liferay-portlet:renderURL>
			
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
				<li class="<%=loginActive%>">
					<a href="<%=loginURL%>" ><liferay-ui:message key="login"/></a>
				</li>
				<li class="<%=registerActive%>">
					<a href="<%=registerURL%>" ><liferay-ui:message key="register"/></a>
				</li>						 
			</ul>
			<div class="tab-content tabs">
				<div role="tabpanel" class="tab-pane fade in active">
					<%@ include file="/otp/otp_form.jsp" %>
				</div>
			</div>		
		</div>		
	</div>
</div>
<script>
$(document).ready(function(){
	$(".btn-toolbar-button").on("click", function(){
		$('button.close', window.parent.document).click().click();
	});
});
</script> 