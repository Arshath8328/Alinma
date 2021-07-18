  <%@ include file="/init.jsp" %>
  <portlet:renderURL var="redirectURL" >
		<portlet:param name="myview" value="view"/>
</portlet:renderURL>
<script>
AUI().ready(function() {    
	
	window.parent.location.href = '<%=redirectURL%>';
});

</script>
