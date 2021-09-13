<%@page import="javax.portlet.PortletRequest"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="claim.management.constants.ClaimManagementPortletKeys"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.claim.Claim"%>
<%@ include file="/claimsmgmt/init.jsp" %>

<%
	List<Claim> claimsList = (List<Claim>) request.getAttribute("claimsList");
	List<String> viewableStatuses = (List<String>) request.getAttribute("viewableStatuses");
	String lang = themeDisplay.getLocale().toString();

%>

 			<div class="row margin-top">
				<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 no-pad">
					<h3 class="text-primary pad-5"><liferay-ui:message key="claims_list"/></h3>
					<table class="table ej-table table-striped"> 
						<thead> 
							<tr> 
								<th><liferay-ui:message key="claims_reference"/> #</th> 
								<th><liferay-ui:message key="claims_type"/></th> 
								<th><liferay-ui:message key="claims_policy_type"/></th> 
								<th><liferay-ui:message key="claims_list_date"/></th>
								<th><liferay-ui:message key="claims_status"/></th> 
							</tr>							 
						</thead>						 
						<tbody> 
<% 
				for (Claim claim : claimsList) {
					
					// skipping any claim has no workflow status. This means that this claim was not reported through this channel
					if (claim.getWorkflowStatus().isEmpty())
						continue;
					PortletURL getClaimDetailsURL = PortletURLFactoryUtil.create(request, ClaimManagementPortletKeys.CLAIMMANAGEMENT,themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
					getClaimDetailsURL.setParameter(ActionRequest.ACTION_NAME, "getClaimDetails");
					getClaimDetailsURL.setParameter("claimNumber", claim.getClaimNo());
					getClaimDetailsURL.setParameter("policyNumber", claim.getPolicyNo());
					getClaimDetailsURL.setParameter("productDescAr", claim.getProductDescAr());
					getClaimDetailsURL.setParameter("productDescEn", claim.getProductDescEn());
					getClaimDetailsURL.setParameter("product", claim.getProduct());
					getClaimDetailsURL.setParameter("reportType", claim.getReportType());
					String policyType = (lang.equals("en_US")?claim.getProductDescEn():claim.getProductDescAr());
					String claimStatusKey ;
					String claimStatus ;					
					if (viewableStatuses.contains(claim.getWorkflowStatus()) )
					{
						claimStatusKey = "claims_status_" + claim.getWorkflowStatus();
					}
					else
					{
						claimStatusKey = "claims_status_CLAIMUNDERINVESTIGATION";
					}
					
					claimStatus = LanguageUtil.get(request,claimStatusKey);
					
					getClaimDetailsURL.setParameter("claimStatusKey", claimStatusKey);

%>							
							
							<tr> 
								<td data-label="Claim Reference #">
									<a href="<%=getClaimDetailsURL%>"><%=claim.getClaimNo()%></a>
								</td>								 
								<td data-label="Claim Type"><%=claim.getTypeOfClaim()%></td>
								<td data-label="Policy Type"><%=policyType%></td> 
								<td data-label="Date"><fmt:formatDate pattern="dd/MM/yyyy" value="<%=claim.getClaimIntmDate()%>" /> </td> 
								<td data-label="Status"><%=claimStatus %></td>
							</tr>
							
<% 
				}
%>							
						</tbody>
					</table>
				</div>
			</div>
													 