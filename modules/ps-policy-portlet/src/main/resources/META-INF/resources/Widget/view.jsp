<%@page import="com.atmc.ps.policy.constants.PsPolicyPortletKeys"%>
<%@page import="com.ejada.atmc.acl.db.custom.model.PSPolicy"%>
<%@ include file="/init.jsp" %>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil" %>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="javax.portlet.ActionRequest" %>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>


<%
	List<PSPolicy> pspolicyList = (List) request.getAttribute("PSPolicyList");
%>

<div class="portlet-content no-pad">
	<ul class="list-group no-margin" style="min-height: 311px;">
		<li class="list-group-item text-primary" style="height:50px;display: flex;align-items: center;"><liferay-ui:message key="ps.policy" /></li>
				
				<%
					for (PSPolicy psPolicy : pspolicyList) {
				%>
				
				<%
					String pageName="/ps-policy";
					long policiesPlid = 0L;
					String policiesPortletId = PsPolicyPortletKeys.PSPolicy;
					Layout policiesPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName);
					LayoutTypePortlet policiesLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(policiesPortletLayout);
					policiesPortletId = policiesLayoutTypePortlet.getPortletIds().get(0);
					policiesPlid = policiesPortletLayout.getPlid();
					
					PortletURL payUrl = PortletURLFactoryUtil.create(request, policiesPortletId, policiesPlid, PortletRequest.ACTION_PHASE);
					payUrl.setWindowState(WindowState.NORMAL);
					payUrl.setPortletMode(PortletMode.VIEW);
					payUrl.setParameter("mvcPath", "/details.jsp");
					payUrl.setParameter("proposalNo", String.valueOf(psPolicy.getProposal_no()));
					payUrl.setParameter("backURL", themeDisplay.getURLCurrent());
					
					String policyDtlsPortletNamespace = PortalUtil.getPortletNamespace(policiesPortletId);
				%>
				
				<li class="list-group-item">
					<div>
						<portlet:renderURL var="psDetail">
							<portlet:param name="mvcPath" value="/details.jsp"/>
							<portlet:param name="proposalNo" value="<%= String.valueOf(psPolicy.getProposal_no()) %>"/>
							<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
						</portlet:renderURL>
						<a href="<%= payUrl %>"><%=psPolicy.getProposal_no()%></a><br>
						<small class="text-muted"><%= psPolicy.getStatus_description() %></small>
					</div>
				</li>
				<%
					}
				%>
		<li class="list-group-item text-center text-muted"> 
			<a href="/group/customer/ps-policy"><liferay-ui:message key="view_all"/></a>
		</li>
	</ul>
</div>


