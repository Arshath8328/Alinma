<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyCancelation"%>
<%@ include file="init.jsp"%>

<%

List<PolicyCancelation> cnclPolicyList   = (List<PolicyCancelation>) request.getAttribute("cnclPolicyList");

PortletURL polCnclDetails = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
	themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	polCnclDetails.setParameter("myview", "canclePolicyDetails");
%>
<div class="row margin-top">
	<div class="col-md-12 no-pad">
		<button class="btn btn-default pull-right btn-xs-block margin-bottom" type="button">
			<i class="glyphicon glyphicon-plus"></i> <liferay-ui:message key="new_policy"/>
		</button>
		<div class="tab">
			<ul class="nav nav-tabs clearfix margin-bottom bg-body">
				<li><a href="${polCnclDetails}" style="padding:10px 15px;"><liferay-ui:message key="my_policies"/></a></li>
				<li class="active"><a href="#tab-2" role="tab" data-toggle="tab" style="padding:10px 15px;"><liferay-ui:message key="policy_cncl_list"/></a></li>
			</ul>
			<table class="table ej-table table-striped">
				<thead>
					<tr>
						<th><liferay-ui:message key="policy_no"/></th>
						<th><liferay-ui:message key="make"/></th>
						<th><liferay-ui:message key="mod_ver"/></th>
						<th><liferay-ui:message key="chassis_no_report"/></th>
						<th><liferay-ui:message key="status"/></th>
					</tr>
				</thead>
				<tbody>
 <%
	for(int quotationsCount=0; cnclPolicyList!= null && quotationsCount<cnclPolicyList.size();quotationsCount++)
	{
		PolicyCancelation quot = (PolicyCancelation)cnclPolicyList.get(quotationsCount);
		String status = quot.getStatus();
		polCnclDetails.setParameter("policyNumber", quot.getPolicyNumber());
		
		
%>				
					<tr>
						<td data-label="Policy No.#"><a href="<%=polCnclDetails%>"><%=quot.getPolicyNumber() %> </a>
						</td>
						<td data-label="Make"><%=quot.getVehMake() %> </td>
						<td data-label="Model"><%=quot.getVehModel() %></td>
						<td data-label="Chassis No."><%=quot.getVehicleChessisNo() %></td>
						<td data-label="Status">
							<%-- <span class="<%=(status!=null && (status.equals("PS")||status.equals("PP")))?"text-danger":(status!=null && (status.equals("RJ")))?"text-warning":"text-muted" %>"><liferay-ui:message key="<%=status %>"/></span> --%>
						<span><liferay-ui:message key="<%=status %>"/></span>
						</td>
					</tr>
<%
	}
%>	
				</tbody>
			</table>
		</div>
	</div>
</div>