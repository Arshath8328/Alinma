<%@ include file="/init.jsp" %>
<%
long quotationid = Long.valueOf(request.getParameter("quotationId"));
String myParentView=String.valueOf(request.getParameter("myParentView"));
%>
  <portlet:renderURL var="redirectURL" >
		<portlet:param name="myview" value="view"/>
 </portlet:renderURL>
<%if(myParentView.equals("view")){ %>
  <portlet:renderURL var="redirectURL" >
		<portlet:param name="myview" value="view"/>
 </portlet:renderURL>
 <%}else{ %>
 
 	<portlet:actionURL var="redirectURL" name="quotationDetails">
		<portlet:param name="myview" value="details"/>
		<portlet:param name="quotationId" value="<%=quotationid+""%>"/>
	</portlet:actionURL>
	<%} %>
<script>

AUI().ready(function() {    
	
	window.parent.location.href = '<%=redirectURL%>';
});

</script>
