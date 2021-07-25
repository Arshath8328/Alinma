<%@ include file="/firstLoginChgPwd/init.jsp" %>   

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

							<portlet:actionURL name="/login/firstLoginChgPwd"  var="reminderQueryURL">
								<portlet:param name="mvcRenderCommandName" value="/login/firstLoginChgPwd" />
							</portlet:actionURL>
							
							
							<aui:form action='<%= reminderQueryURL %>' autocomplete='<%= GetterUtil.getBoolean(PropsUtil.get(PropsKeys.COMPANY_SECURITY_PASSWORD_REMINDER_QUERY_FORM_AUTOCOMPLETE)) ? "on" : "off" %>' cssClass="update-reminder-query" method="post" name="fm">
								<liferay-ui:error exception="<%= UserReminderQueryException.class %>" message="reminder-query-and-answer-cannot-be-empty" />
								<aui:input name="<%= FirstLoginChangePwdPortletKeys.CMD %>" type="hidden" value="<%= FirstLoginChangePwdPortletKeys.CMD_UPDATE_REMINDER_QUERY %>" />
							
								<aui:fieldset>
									<aui:select autoFocus="<%= true %>" cssClass="reminder-query-question" label="question" name="reminderQueryQuestion">
							
								<%
								for (String question : user.getReminderQueryQuestions()) {
								%>
							
									<aui:option label="<%= question %>" />
							
								<%
								}
								%>
							
								<aui:option label="<%= UsersAdmin.CUSTOM_QUESTION %>" />
							</aui:select>
							
										<div class="hide" id="customQuestionContainer">
											<aui:input autoFocus="<%= true %>"  cssClass="reminder-query-custom" label=""  name="reminderQueryCustomQuestion" />
										</div>
							
									<aui:input autocomplete="off" cssClass="reminder-query-answer" label="answer" maxlength="<%= ModelHintsConstants.TEXT_MAX_LENGTH %>" name="reminderQueryAnswer" showRequiredLabel="<%= false %>" size="50" type="text" value="<%= user.getReminderQueryAnswer() %>">
										<aui:validator name="required" />
									</aui:input>
								</aui:fieldset>
							
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
						</div>
					</div>
				</div>					 
			</div>
		</div>			 
	</div>

<aui:script sandbox="<%= true %>">
	var customQuestionContainer = $('#customQuestionContainer');
	var reminderQueryQuestion = $('#<portlet:namespace />reminderQueryQuestion');

	customQuestionContainer.toggleClass('hide', reminderQueryQuestion.val() != '<%= UsersAdmin.CUSTOM_QUESTION %>');

	reminderQueryQuestion.on(
		'change',
		function(event) {
			if (reminderQueryQuestion.val() == '<%= UsersAdmin.CUSTOM_QUESTION %>') {
					customQuestionContainer.removeClass('hide');
					Liferay.Util.focusFormField('#reminderQueryCustomQuestion');
			}
			else {
				customQuestionContainer.addClass('hide');
				Liferay.Util.focusFormField('#reminderQueryAnswer');
			}
		}
	);
</aui:script>
