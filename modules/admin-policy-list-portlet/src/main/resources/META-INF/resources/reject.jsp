<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/init.jsp" %>

<% 
long quotationid = Long.valueOf(request.getParameter("quotationId"));
String myParentView=String.valueOf(request.getParameter("myParentView"));
%>
<portlet:actionURL var="viewURL" name="rejectQuotation" windowState="<%= LiferayWindowState.NORMAL.toString() %>">
	<portlet:param name="myview" value="adminPolicyRedirect"/>
	<portlet:param name="myParentView" value="<%=myParentView%>"/>
		<portlet:param name="quotationId" value="<%=quotationid+""%>"/>
</portlet:actionURL>
<div class="container">
	<aui:form action="<%=viewURL%>" method="post" >
		<div class="row">
			<div class="col-sm-12 col-xs-12 col-md-12">
				<h4 class="text-primary"><liferay-ui:message key="Reject New Policy Request"/></h4>
				<div class="form-group">
					<label class="control-label" for="formInput56"><liferay-ui:message key="reason_rej"/></label>
					<aui:input type="Text" name="reason" label="" class="form-control" value="">
						<aui:validator name="required" errorMessage="required_field_validator"/>
					</aui:input>
				</div>	
				<ul class="list-btns">
					<li>
						<button class="btn btn-primary btn-lg btn-xs-block" type="submit"><liferay-ui:message key="confirm"/></button>
					</li>
					<li>
						<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="#" onclick="location.href = '${viewURL}'"><liferay-ui:message key="cancel"/></a>
					</li>
				</ul>					 
			</div>
		</div>
	</aui:form>
</div>