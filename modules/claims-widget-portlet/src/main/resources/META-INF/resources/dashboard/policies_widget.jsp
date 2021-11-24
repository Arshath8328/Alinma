<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.atmc.web.constants.PolicyListPortletKeys"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="java.util.List"%>
<%@ include file="/dashboard/init.jsp" %>


<div class="portlet-content no-pad">
	<ul class="list-group no-margin" style="min-height:311px;"> 
		<li class="list-group-item text-primary"><liferay-ui:message key="pols"/>
			<a href="/web/customer/buy_motor_policy" class="pull-right text-center width-60"><span class="glyphicon glyphicon-plus"></span></a>
		</li>	
<%
	String currLocale = themeDisplay.getLocale().toString();
	Log _log = LogFactoryUtil.getLog(this.getClass());

	List<Policy> policyList = (List<Policy>) request.getAttribute("policyList");
	if(policyList.isEmpty())
	{
%>
		<li class="list-group-item text-center" style="height:75px">
			<div class="text-muted">
				<liferay-ui:message key="no_pols"/>
			</div>
			<a href="/web/customer/buy_motor_policy" class="btn btn-default">
				<span class="glyphicon glyphicon-plus"></span> <liferay-ui:message key="open_pols"/>
			</a>
		</li>
<%
	}
	else
	{
		String pageName="/policies";
		long policiesPlid = 0L;
		String policiesPortletId = PolicyListPortletKeys.POLICYLIST;
		_log.info("current page name ---------------------- "+themeDisplay.getLayout().getName());
		Layout policiesPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), true, pageName);
		LayoutTypePortlet policiesLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(policiesPortletLayout);
		policiesPortletId = policiesLayoutTypePortlet.getPortletIds().get(0);
		policiesPlid = policiesPortletLayout.getPlid();
		_log.info("Pliid==>"+policiesPlid);
		
		
		PortletURL payUrl = PortletURLFactoryUtil.create(request, policiesPortletId, policiesPlid, PortletRequest.ACTION_PHASE);
		payUrl.setWindowState(WindowState.NORMAL);
		payUrl.setPortletMode(PortletMode.VIEW);
		payUrl.setParameter(ActionRequest.ACTION_NAME, "policyDetails");
		
		String policyDtlsPortletNamespace = PortalUtil.getPortletNamespace(policiesPortletId);
%>
		<form id="policyDtlsForm" name="policyDtlsForm" role="form" action="<%=payUrl.toString() %>" method="post">
			<input type="hidden" id="policyNo" name="<%=policyDtlsPortletNamespace %>policyNo" value=""/>
			<input type="hidden" id="myview" name="<%=policyDtlsPortletNamespace%>myview" value=""/>
		</form>	
<%
		for(int i=0;i<policyList.size();i++)
		{
			Policy policyData = policyList.get(i);
			String productType = ""; 
			String product = policyData.getProduct();
			long noOfRisk = policyData.getNoOfRisk();
			String detsView = "life_policy_dets";
			if(product.equals("13101") || product.equals("13102"))
			{
				if(noOfRisk>1)
					detsView = "vehicle_list";
				else
					detsView = "motor_policy_dets";
			}
			else if(product.equals("SMEE") || product.equals("CCHA"))
				detsView = "med_policy_dets";
			
			if(product.equals("13101")||product.equals("13102"))
			{
				productType = "Vehicles";
			}
			else if(product.equals("430")||product.equals("450")
					||product.equals("470")||product.equals("480")
					||product.equals("490")||product.equals("SMEE")
					||product.equals("CCHA"))
			{
				productType = "Members";
			}
			
			String statusColor = "text-success";
			if(policyData.getPolicyStatus()!=null && (policyData.getPolicyStatus().equals("PR")||policyData.getPolicyStatus().equals("Q")))
				statusColor = "";
			else if(policyData.getPolicyStatus()!=null && policyData.getPolicyStatus().equals("H"))
				statusColor = "text-warning";
			else if(policyData.getPolicyStatus()!=null && (policyData.getPolicyStatus().equals("EX")||policyData.getPolicyStatus().equals("C")||policyData.getPolicyStatus().equals("L")))
				statusColor = "text-danger";
			
			String policyIcon = (product.equals("13101") || product.equals("13102"))?"transport-3":(product.equals("SMEE") || product.equals("CCHA"))?"healthy":"shield";
%>
		<li class="list-group-item">
			<div class="pull-right text-center text-primary width-60">	
				<div class="round round-sm hollow blue"><%=policyData.getNoOfRisk()%></div>
				<br><%=productType%>
			</div>
			<div>
				<a onclick="policyDetails('<%=i%>');"><%=policyData.getPolicyNo()%></a>
		
				<input id="policyNo_<%=i %>" name="policyNo_<%=i %>" type="hidden" value="<%=policyData.getPolicyNo() %>" />
				<input id="detsView_<%=i %>" name="detsView_<%=i %>" type="hidden" value="<%=detsView %>" />
			</div> 
			<small class="<%=statusColor%>"><%=(currLocale.equals("en_US"))?policyData.getPolicyStatusEn():policyData.getPolicyStatusAr() %></small>
			<br>
			<span class="icon icon-<%=policyIcon%>"></span>&nbsp;<small class="text-muted"><%=(currLocale.equals("en_US"))?policyData.getProductEn():policyData.getProductAr()%></small>
		</li>
<%
		}
%>
		<li class="list-group-item text-center text-muted"> 
			<a href="/group/customer/policies"><liferay-ui:message key="view_all"/></a>
		</li>
<%
	}
%>							 
	</ul>
</div>		

<script>
function policyDetails(count)
{
	var policyNo = $("#policyNo_"+count).val();
	var detsView = $("#detsView_"+count).val();
	
	$("#policyNo").val(policyNo);
	$("#myview").val(detsView);
	
	$("#policyDtlsForm").submit();
}
</script>			 