<%@page import="com.liferay.portal.kernel.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.taglib.ui.JournalArticleTag"%>
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<%@ include file="/firstLoginChgPwd/init.jsp" %> 

<%

JournalArticle jouranl = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),"terms-and-condition");
JournalArticleDisplay jouranldisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(), jouranl.getArticleId() ,"view",themeDisplay.getLanguageId(),themeDisplay);
%>  

<div class="row">
	<div class="portlet-content col-sm-12 col-xs-12 col-lg-12 col-md-12">
		<div class="row" data-pg-collapsed>
			<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
				<img class="img-responsive" src="/o/atmc-theme/images/set_password.png" width="100%" />
			</div>
		</div>
		<div class="row" data-pg-collapsed>
			<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1">
				<div class="portlet-content no-margin">
					<div class="row">
						<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
							<h4 class="text-primary"><liferay-ui:message key="finalizing_reg"/></h4>
							<p><liferay-ui:message key="plz_set_pass"/></p>
							
							<portlet:actionURL name="/login/firstLoginChgPwd"  var="changePwdURL">
								<portlet:param name="mvcRenderCommandName" value="/login/firstLoginChgPwd" />
							</portlet:actionURL>
							
							<aui:form action="<%= changePwdURL %>" method="post" name="changePwdForm" role="form" autocomplete="off">
								<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
								<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeNull.class %>" message="please-enter-an-email-address" />
								<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBePOP3User.class %>" message="the-email-address-you-requested-is-reserved" />
								<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeReserved.class %>" message="the-email-address-you-requested-is-reserved" />
								<liferay-ui:error exception="<%= UserEmailAddressException.MustNotUseCompanyMx.class %>" message="the-email-address-you-requested-is-not-valid-because-its-domain-is-reserved" />
								<liferay-ui:error exception="<%= UserEmailAddressException.MustValidate.class %>" message="please-enter-a-valid-email-address" />
								<liferay-ui:error exception="<%= UserPasswordException.MustMatch.class %>" message="the-passwords-you-entered-do-not-match" />
								<liferay-ui:error exception="<%= UserPasswordException.MustNotBeNull.class %>" message="the-password-cannot-be-blank" />
								<liferay-ui:error exception="<%= UserPasswordException.MustNotBeTrivial.class %>" message="that-password-uses-common-words-please-enter-a-password-that-is-harder-to-guess-i-e-contains-a-mix-of-numbers-and-letters" />
								<liferay-ui:error exception="<%= UserPasswordException.MustNotContainDictionaryWords.class %>" message="that-password-uses-common-dictionary-words" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeDuplicate.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNull.class %>" focusField="screenName" message="the-screen-name-cannot-be-blank" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeNumeric.class %>" focusField="screenName" message="the-screen-name-cannot-contain-only-numeric-values" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReserved.class %>" message="the-screen-name-you-requested-is-reserved" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeReservedForAnonymous.class %>" focusField="screenName" message="the-screen-name-you-requested-is-reserved-for-the-anonymous-user" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustNotBeUsedByGroup.class %>" focusField="screenName" message="the-screen-name-you-requested-is-already-taken-by-a-site" />
								<liferay-ui:error exception="<%= UserScreenNameException.MustProduceValidFriendlyURL.class %>" focusField="screenName" message="the-screen-name-you-requested-must-produce-a-valid-friendly-url" />
								<liferay-ui:error exception="<%= UserPasswordException.MustBeLonger.class %>">

									<%
									UserPasswordException.MustBeLonger upe = (UserPasswordException.MustBeLonger)errorException;
									%>
							
									<liferay-ui:message arguments="<%= String.valueOf(upe.minLength) %>" key="that-password-is-too-short" translateArguments="<%= false %>" />
								</liferay-ui:error>

							<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithModelListeners.class %>" message="that-password-is-invalid-please-enter-a-different-password" />

							<liferay-ui:error exception="<%= UserPasswordException.MustComplyWithRegex.class %>">

								<%
								UserPasswordException.MustComplyWithRegex upe = (UserPasswordException.MustComplyWithRegex)errorException;
								%>

								<liferay-ui:message arguments="<%= HtmlUtil.escape(upe.regex) %>" key="that-password-does-not-comply-with-the-regular-expression" translateArguments="<%= false %>" />
							</liferay-ui:error>
								
							<div class="row">
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
									<div class="form-group"> 
										<label class="control-label" for="password"><liferay-ui:message key="password"/></label>
									 <aui:input name="password" cssClass="form-control" id="password" label="" showRequiredLabel="false" type="password" placeholder="<%= LanguageUtil.get(request, "password") %>" data-toggle="tooltip" data-trigger="hover" data-html="true" data-placement="top">
										<aui:validator name="required" />
									</aui:input>
									 <input onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');" id="field_terms" type="checkbox" required name="terms"> 
														<liferay-ui:message key="terms-and-conditions-no1"/><span  id="termsCond"  style="cursor: pointer; text-decoration: underline" ><liferay-ui:message key="terms-and-conditions-no2"/></span></p> 
									</div>											 
								</div>
								<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
									<div class="form-group"> 
										<label class="control-label" for="passwordRepeat"><liferay-ui:message key="repeat_password"/></label>	
										 <aui:input name="passwordRepeat" cssClass="form-control" id="passwordRepeat" label="" showRequiredLabel="false" type="password" placeholder="<%= LanguageUtil.get(request, "repeat_password") %>">
											<aui:validator name="required" />
											<aui:validator name="equalTo">
												'#<portlet:namespace />password'
											</aui:validator>
										</aui:input>
									</div>											 
								</div>
							</div>
							<div class="row">
								<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 text-right">
									<ul class="list-btns">
										<li>
											<aui:button type="submit" value="Submit" />
										</li>
									</ul>
								</div>
							</div>
							</aui:form>
							<div class="jumbotron" style=" background-color: white;border: 1px solid black;" >
							<div>
								<h4><b><liferay-ui:message key="password-rules"/></b><h4>
								<h5><liferay-ui:message key="password-rules-no1"/></h5>
								<h5><liferay-ui:message key="password-rules-no2"/></h5>
								<h5><liferay-ui:message key="password-rules-no3"/></h5>
								<h5><liferay-ui:message key="password-rules-no4"/></h5>
								<h5><liferay-ui:message key="password-rules-no5"/></h5>
								<h5><liferay-ui:message key="password-rules-no6"/></h5>
							</div>
						 </div>
						</div>
					</div>
				</div>					 
			</div>
		</div>			 
	</div>
	
	<div id="myModal" class="modal">
	  <div class="modal-content">
    <span class="close">&times;</span>
   <div class="journal-article-preview"><%= jouranldisplay.getContent() %></div>
</div>
</div>
<script>
// Get the modal
var modal = document.getElementById('myModal');
var btn = document.getElementById("termsCond");
var span = document.getElementsByClassName("close")[0];
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

document.getElementById("field_terms").setCustomValidity("Please Read and Accept the terms and Conditions");
  function checkForm(form)
  {
    if(!form.terms.checked) {
      alert("Please indicate that you accept the Terms and Conditions");
      form.terms.focus();
      return false;
    }
    return true;
  }
</script>	




<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    padding-top: 100px; /* Location of the box */
    left: 0;
    top: 0;
    width: 100%; /* Full width */
    height: 100%; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    padding: 20px;
    border: 1px solid #888;
    width: 80%;
}

/* The Close Button */
.close {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.close:hover,
.close:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>

</body>
</html>
	
	

