<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.claim.Claim"%>
<%@page import="java.util.List"%>
<%@ include file="/dashboard/init.jsp" %>

<div class="portlet-content no-pad">
	<ul class="list-group no-margin" style="min-height:311px;"> 
		<li class="list-group-item text-primary"><liferay-ui:message key="claims"/>
			<a href="/web/customer/claim_intimation" class="pull-right text-center width-60"><span class="glyphicon glyphicon-plus"></span></a>
		</li>
		
		<%
			List<Claim> claimsList = (List<Claim>) request.getAttribute("claimsList");
			List<String> viewableStatuses = (List<String>) request.getAttribute("viewableStatuses");
			int l= claimsList.size();
			
			if(!(claimsList.isEmpty()))
			{
				for(int i=0;i<claimsList.size();i++)
				{
					Claim claimData = claimsList.get(i);
					String claimStatusKey ;
					String claimStatus ;					
					if (viewableStatuses.contains(claimData.getWorkflowStatus()) )
					{
						claimStatusKey = "claims_status_" + claimData.getWorkflowStatus();
					}
					else
					{
						claimStatusKey = "claims_status_CLAIMUNDERINVESTIGATION";
					}
					
					claimStatus = LanguageUtil.get(request,claimStatusKey);
					if (claimData.getWorkflowStatus().isEmpty())
					{
						l = l-1;
						continue;
					}
		%>	
		<li class="list-group-item">
			<%=claimData.getClaimNo()%> 
			<small class="text-danger"><%=claimStatus%></small>
			<br>
			<span class="icon icon-transport-3"></span>&nbsp;<span class="text-muted"><%=claimData.getTypeOfClaim()%></span>
			<%-- <br>
			<small class="text-muted"><%=claimData.getClaimIntmDate()%></small> --%>
		</li>
		<%
				}
			}
			if(!claimsList.isEmpty() && l != 0)
			{
		%>
		<li class="list-group-item text-center text-muted"> 
			<a href="/group/customer/claims"><liferay-ui:message key="view_all"/></a>
		</li>							 
		<%
			}
			if(claimsList.isEmpty() || l == 0)
			{
		%>
				<li class="list-group-item text-center" style="height:75px">
					<div class="text-muted">
						<liferay-ui:message key="no_active_claims"/>
					</div>
					<a href="/web/customer/claim_intimation" class="btn btn-default">
						<span class="glyphicon glyphicon-plus"></span> <liferay-ui:message key="open_claim"/>
					</a>
				</li>
		<%
			}
		%>
								 
	</ul>						 
</div>