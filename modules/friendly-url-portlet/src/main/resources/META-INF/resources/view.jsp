<%@ include file="/init.jsp"%>

<portlet:renderURL var="renderURL">
	<portlet:param name="mvcRenderCommandName" value="/friendly/url" />
</portlet:renderURL>

<portlet:renderURL var="appviewurl">
	<portlet:param name="mvcRenderCommandName" value="/demo" />
</portlet:renderURL>

<%
	String resultActionURL = request.getAttribute("resultactionURL") != null
			? (String) request.getAttribute("resultactionURL")
			: "";
	if (!resultActionURL.equals("")) {
%>
<script>
			window.parent.location.href = "<%=resultActionURL%>
	"
</script>

<%
	}
%>
<portlet:actionURL name="action" var="actionURL">
	<portlet:param name="mvcPath" value="/message.jsp" />
</portlet:actionURL>
<a href="<%=actionURL%>">goto action</a>
<aui:form action="<%=appviewurl%>">
	<aui:input name="name">Enter your name </aui:input>
	<aui:button type="submit"> submit</aui:button>
</aui:form>