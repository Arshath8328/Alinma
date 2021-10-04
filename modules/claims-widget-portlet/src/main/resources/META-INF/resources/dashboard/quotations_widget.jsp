<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="java.util.List"%>
<%@ include file="/dashboard/init.jsp" %>
<%
	String pageName="/buy_motor_policy";
	Log _log = LogFactoryUtil.getLog(this.getClass());

	long buyMotorPlid = 0L;
	String motorPortletId = BuyMotorPolicyPortletKeys.BUYMOTORPOLICY;
	try
	{
		_log.info("current page name ---------------------- "+themeDisplay.getLayout().getName());
		Layout motorPortletLayout = LayoutLocalServiceUtil.getFriendlyURLLayout(themeDisplay.getScopeGroupId(), false, pageName);
		LayoutTypePortlet buyMotorLayoutTypePortlet = LayoutTypePortletFactoryUtil.create(motorPortletLayout);
		motorPortletId = buyMotorLayoutTypePortlet.getPortletIds().get(0);
		buyMotorPlid = motorPortletLayout.getPlid();
		_log.info("Pliid==>"+buyMotorPlid);
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	
	PortletURL payUrl = PortletURLFactoryUtil.create(request, motorPortletId, buyMotorPlid, PortletRequest.ACTION_PHASE);
	payUrl.setWindowState(WindowState.NORMAL);
	payUrl.setPortletMode(PortletMode.VIEW);
	payUrl.setParameter(ActionRequest.ACTION_NAME, "payPolicy");
	
	String buyMotorPortletNamespace = PortalUtil.getPortletNamespace(motorPortletId);
	Gson gson = new Gson();
%>
<div class="portlet-content">
	<form id="payQuotForm" name="payQuotForm" role="form" action="<%=payUrl.toString() %>" method="post">
		<input type="hidden" id="quotId" name="<%=buyMotorPortletNamespace %>quotId" value=""/>
		<input type="hidden" name="<%=buyMotorPortletNamespace %>myview" value="quotation"/>
	</form>
<%

	List<Quotation> quotsList = (List<Quotation>) request.getAttribute("quotsList");
	if(quotsList.size()>0)
	{
		for(int i=0;i<quotsList.size();i++)
		{
			Quotation quote= quotsList.get(i);
			String quotDets = gson.toJson(quote);
			quotDets = quotDets.replaceAll("\"", "'");
			
			Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
			long currDate = cal.getTimeInMillis();
			Date expDate = quote.getVehicleEstExpiryDate();
			double diff = 0;
			
			if(currDate < expDate.getTime())
				diff = (expDate.getTime() - currDate);
			
			double diffHours = diff / (60 * 60 * 1000);
			double diffMins = (diffHours - Math.floor(diffHours))* 60;
			diffMins = Math.floor(diffMins);
%>

	<div class="row vcenter">
		<div class="col-xs-12 col-sm-8 col-md-8 col-lg-8 no-pad">
			<div class="media no-margin">
				<div class="media-left media-middle">
					<span class="glyphicon glyphicon-shopping-cart text-muted gi-2x"></span>
				</div>
				<div class="media-body">
					<h4 class="text-primary"><strong><liferay-ui:message key="quot"/> <%=quote.getReferenceNo()%> </strong>&nbsp;<liferay-ui:message key="pending_pmnt"/><br />
					<span class="text-muted"><liferay-ui:message key="remainig_time"/>&nbsp;<%=Math.round(Math.floor(diffHours)) %> H <%=Math.round(diffMins) %> M</span></h4>
				</div>
			</div>								 
		</div>
		<div class="col-md-4 col-sm-4 col-lg-4 col-xs-12 text-right no-pad">
			<input id="policy_<%=i %>" name="policy_<%=i %>" type="hidden" value="<%=quote.getQuotationId() %>" />
			<button class="btn btn-lg btn-default text-primary btn-xs-block" type="button" onclick="payPolicy('<%=i%>')"><liferay-ui:message key="pay_now"/></button>								 
		</div>
	</div>
<%
		}
	}
%>
</div>
<script>
var inputTemplate = "<input type='hidden' name='' value=''/>";
function payPolicy(policyCount)
{
	var dets = $("#policy_"+policyCount).val();
	$("#quotId").val(dets);
	$("#payQuotForm").submit();
}
</script>