<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/init.jsp" %>

<% 
String refNo = String.valueOf(request.getParameter("refNo"));
String newStatus = String.valueOf(request.getParameter("newStatus"));
%>
<portlet:actionURL var="updateURL" name="updateStatus">
	<portlet:param name="myview" value="claimPolicyRedirect"/>
	<portlet:param name="refNo" value="<%=refNo%>"/>
	<portlet:param name="newStatus" value="<%=newStatus%>"/>
</portlet:actionURL>
<portlet:renderURL var="viewURL" >
	<portlet:param name="myview" value="view"/>
</portlet:renderURL>
<div class="container">
	<aui:form action="<%=updateURL%>" method="post" >
		<div class="row">
			<div class="col-sm-12 col-xs-12 col-md-12">
				<h4 class="text-primary"><liferay-ui:message key="Claims Request Management"/></h4>
				<div class="form-group"> 
					<label class="control-label" for="formInput56"><liferay-ui:message key="Reason For Rejected"/></label>
						<aui:input type="Text" name="reason" label="" class="form-control" value="">
					</aui:input>
				</div>	
				<ul class="list-btns">
					<li>
						<button class="btn btn-primary btn-lg btn-xs-block" type="submit"><liferay-ui:message key="confrim"/></button>
					</li>
					<li>
						<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="#" onclick="$('.close', window.parent.document.body).click().click()"><liferay-ui:message key="cancel"/></a>
					</li>
				</ul>			 
			</div>
		</div>
	</aui:form>
</div>