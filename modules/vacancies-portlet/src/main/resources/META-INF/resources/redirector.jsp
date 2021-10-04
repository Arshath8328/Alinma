<%@page import="vacancies.portlet.constants.VacanciesPortletKeys"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>
<%

	Locale theLocale = themeDisplay.getLocale();
	String  jobId = (String)request.getAttribute(VacanciesPortletKeys.JOB_ID);
	
	
%>
<div class="row">
	<div class="col-md-12 text-right no-pad">
		<ul class="list-btns">
			<li>
				<a class="btn btn-lg btn-xs-block btn-link text-muted" role="button" href="/web/customer/vacancies"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/> </a>
			</li>
			<li>
				<a href="/web/customer/vacancyapply?jobId=<%=jobId%>" class="btn btn-primary btn-lg btn-xs-block"> <liferay-ui:message key="apply_for_job"/></a>
			</li>
		</ul>
	</div>
</div>
