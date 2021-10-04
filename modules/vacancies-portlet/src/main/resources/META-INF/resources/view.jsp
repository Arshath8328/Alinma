<%@page import="vacancies.portlet.constants.VacanciesPortletKeys"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%	Locale theLocale = themeDisplay.getLocale();
	Vector<Set<String>> sets = (Vector<Set<String>>)request.getAttribute(VacanciesPortletKeys.VACANCIES);
	Set<String> vacancies = sets.get(0);
	Set<String> locs = sets.get(1);
	Set<String> deps = sets.get(2);
%>
<portlet:actionURL name="searchVacs" var="searchVacs" >
	<portlet:param name="myview" value="myvalue"/>
</portlet:actionURL>

<liferay-ui:error key="email_failed" message="email_error_message" />
<liferay-ui:success key="email_success" message="email_success_message"/>
<liferay-ui:error key="email_copy_failed" message="email_copy_error_message" />
<liferay-ui:success key="email_copy_success" message="email_copy_success_message"/>
<div class="row">
	<div class="col-md-12">
		<div class="bg-brown pad-10 clearfix margin-bottom">
			<div class="col-md-12">
				<form class="form" action="<%=searchVacs%>" method="post">
					<div class="row vcenter">
						<div class="col-xs-12 col-md-4">
						<select class="form-control" name="<portlet:namespace/>vacancyLocation">
							<option value="-1"><liferay-ui:message key="location"/></option>
<%

							for (String loc: locs)
							{
								String selected=(request.getParameter("vacancyLocation")!=null) && request.getParameter("vacancyLocation").equals(loc)?"selected": "";
%>
						 <option <%=selected%> value="<%=loc%>"><%=loc%></option>								
<%
							}
%>															 
							</select>							
						</div>
						<div class="col-xs-12 col-md-4">
							<select class="form-control" name="<portlet:namespace/>vacancyDepartment" >
							<option value="-1"><liferay-ui:message key="department"/></option> 
<%
							for (String dep: deps)
							{
								String selected = (request.getParameter("vacancyDepartment")!=null) && request.getParameter("vacancyDepartment").equals(dep)?" selected ": "";
%>							 
								<option <%=selected%> value="<%=dep%>"><%=dep%></option>								
<%
							}
%>									 
							</select>
						</div>
						<div class="col-md-4">
							<button type="submit" class="btn bt-lg btn-primary btn-lg pull-right btn-xs-block"><liferay-ui:message key="search"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="row">
<%
							for (String vac: vacancies)
							{
%>							 
								<%=vac%>								
<%
							}
%>	
	
</div>
<div class="row"></div>