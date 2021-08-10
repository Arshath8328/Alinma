<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@ include file="/init.jsp" %>

<% 
long quotationid = Long.valueOf(request.getParameter("quotationId"));
String myParentView=String.valueOf(request.getParameter("myParentView"));
String insName=String.valueOf(request.getParameter("insName"));
String insEmail=String.valueOf(request.getParameter("insEmail"));
String insMobile=String.valueOf(request.getParameter("insMobile"));
%>
<portlet:actionURL var="viewURL" name="acceptQuotation"windowState="<%= LiferayWindowState.NORMAL.toString() %>" >
	<portlet:param name="myview" value="adminPolicyRedirect"/>
	<portlet:param name="myParentView" value="<%=myParentView%>"/>
	<portlet:param name="quotationId" value="<%=quotationid+""%>"/>
	<portlet:param name="insName" value="<%=insName%>"/>
	<portlet:param name="insEmail" value="<%=insEmail%>"/>
	<portlet:param name="insMobile" value="<%=insMobile%>"/>
</portlet:actionURL>
<div class="container">
	<aui:form action="<%=viewURL%>" method="post" >
		<div class="row">
			<div class="col-sm-12 col-xs-12 col-md-12">
				<h4 class="text-primary"><liferay-ui:message key="accept_new_policy"/></h4>
				<div class="form-group"> 
					<label class="control-label" for="formInput56"><liferay-ui:message key="rems"/></label>
						<aui:input type="Text" name="reason" label="" class="form-control" value="">
					</aui:input>
				</div>	
				<ul class="list-btns">
					<li>
						<button class="btn btn-primary btn-lg btn-xs-block" onclick="" type="submit"><liferay-ui:message key="confirm"/></button>
					</li>
					<li>
						<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="#" onclick="location.href = '${viewURL}'"><liferay-ui:message key="cancel"/></a>
					</li>
				</ul>			 
			</div>
		</div>
	</aui:form>
</div>
<script>
function  close(){
	$('.close').click().click();

}
</script>