<%@ include file="init.jsp" %>

<portlet:renderURL var="redirectUrl">
    <portlet:param name="mvcRenderCommandName" value="/auth/otp" />
</portlet:renderURL>

<portlet:actionURL var="actionUrl" name="auth">
    <portlet:param name="mvcRenderCommandName" value="auth" />
</portlet:actionURL>

<a href="<%=redirectUrl%>">Direct to edit.jsp</a><br/>
<a href="<%=actionUrl%>">Direct to action</a><br/>