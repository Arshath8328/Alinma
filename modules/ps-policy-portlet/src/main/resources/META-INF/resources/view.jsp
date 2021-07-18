<%@page import="com.ejada.atmc.acl.db.custom.model.PSPolicy"%>
<%@ include file="/init.jsp" %>

<%@page import="java.util.List"%>

<%
	List<PSPolicy> pspolicyList = (List) request.getAttribute("PSPolicyList");
	System.out.println("pspolicyList: "+pspolicyList);
%>

<div class="portlet-content">
	<div class="row margin-top">
		<div class="col-md-12 no-pad">
			<table class="table ej-table table-striped">
				<thead>
					<tr>
						<th>Proposal No</th>
						<th>Client Code</th>
						<th>Client Name</th>
						<th>Status Description</th>
						<th>Policy IssueDate</th>
						<th>Policy ExpiryDate</th>
					</tr>
				</thead>
				<tbody>
					
					<%
						for (PSPolicy psPolicy : pspolicyList) {
					%>
					<tr>
							<portlet:renderURL var="psDetail">
								<portlet:param name="mvcPath" value="/details.jsp"/>
								<portlet:param name="proposalNo" value="<%= String.valueOf(psPolicy.getProposal_no()) %>"/>
								<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
							</portlet:renderURL>
							<td data-label="Proposal No"><a href="<%= psDetail %>"><%= psPolicy.getProposal_no() %> </a> </td>
							<td data-label="Client Code"><%= psPolicy.getClient_Code() %></td>
							<td data-label=" Client Name"><%= psPolicy.getClient_name() %></td>
							<td data-label="Status Description"><%= psPolicy.getStatus_description() %></td>
							<td data-label=" Policy IssueDate"><%= psPolicy.getIssue_date() %></td>
							<td data-label=" Policy ExpiryDate"><%= psPolicy.getPolicy_expiry_date() %></td>
					</tr>
					<% 	
						}
					%>
					
				</tbody>
			</table>
		</div>
	</div>
</div>