<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="javax.portlet.ActionRequest"%>
<%@page import="javax.portlet.PortletMode"%>
<%@page import="javax.portlet.WindowState"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.model.LayoutTypePortlet"%>
<%@page import="com.liferay.portal.kernel.util.LayoutTypePortletFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.service.LayoutLocalServiceUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="java.util.TimeZone"%>
<%@page import="java.sql.Timestamp"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="com.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%
	List<Quotation> quotationsList = (List) request.getAttribute("quotationsList");

	String pageName="/buy_motor_policy";
	long buyMotorPlid = 0L;
	String motorPortletId = BuyMotorPolicyPortletKeys.BUYMOTORPOLICY;
	Log _log = LogFactoryUtil.getLog(this.getClass());

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
<portlet:renderURL var="policiesURL">
	<portlet:param name="myview" value="policy_list" />
</portlet:renderURL>

<form id="quoteDetsForm" name="quoteDetsForm" role="form" action="<%=payUrl.toString() %>" method="post">
	<input type="hidden" id="quotId" name="<%=buyMotorPortletNamespace %>quotId" value=""/>
	<input type="hidden" name="<%=buyMotorPortletNamespace %>myview" value="quotation"/>
</form>

<div class="row margin-top">
	<div class="col-md-12 no-pad">
		<button class="btn btn-default pull-right btn-xs-block margin-bottom" type="button">
			<i class="glyphicon glyphicon-plus"></i> <liferay-ui:message key="new_policy"/>
		</button>
		<div class="tab">
			<ul class="nav nav-tabs clearfix margin-bottom bg-body">
				<li><a href="${policiesURL}" style="padding:10px 15px;"><liferay-ui:message key="my_policies"/></a></li>
				<li class="active"><a href="#tab-2" role="tab" data-toggle="tab" style="padding:10px 15px;"><liferay-ui:message key="my_quotes_list"/></a></li>
			</ul>
			<table class="table ej-table table-striped">
				<thead>
					<tr>
						<th><liferay-ui:message key="req_ref"/></th>
						<th><liferay-ui:message key="make"/></th>
						<th><liferay-ui:message key="plate_no"/></th>
						<th><liferay-ui:message key="time_rem"/></th>
						<th><liferay-ui:message key="status"/></th>
					</tr>
				</thead>
				<tbody>
<%
	for(int quotationsCount=0; quotationsList!= null && quotationsCount<quotationsList.size();quotationsCount++)
	{
		Quotation quot = (Quotation)quotationsList.get(quotationsCount);	
		String quotDets = gson.toJson(quot);
		quotDets = quotDets.replaceAll("\"", "'");
		
		String status = quot.getQuoteStatus();
		Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
		long currDate = cal.getTimeInMillis();
		Date expDate = quot.getVehicleEstExpiryDate();
		double diff = 0;
		
		if(expDate != null && currDate < expDate.getTime())
			diff = (expDate.getTime() - currDate);
		
		double diffHours = diff / (60 * 60 * 1000);
		double diffMins = (diffHours - Math.floor(diffHours))* 60;
		diffMins = Math.floor(diffMins);
%>				
					<tr>
						<td data-label="Request Reference #">
							<input id="policy_<%=quotationsCount %>" name="policy_<%=quotationsCount %>" type="hidden" value="<%=quot.getQuotationId() %>" />
							<button class="btn btn-link" type="button" onclick="getQuotDets('<%=quotationsCount%>');"><%=quot.getReferenceNo() %></button>
						</td>
						<td data-label="Make"><%=(currLocale.equals("en_US"))?quot.getVehicleMakeEn():quot.getVehicleMakeAr() %></td>
						<td data-label="Plate No."><%=quot.getVehiclePlateNo()+" "+quot.getVehiclePlateL1()+" "+quot.getVehiclePlateL2()+" "+quot.getVehiclePlateL3()%></td>
						<td data-label="Time Remining"><%=Math.round(Math.floor(diffHours)) %> H <%=Math.round(diffMins) %> M</td>
						<td data-label="Status">
							<span class="<%=(status!=null && (status.equals("PS")||status.equals("PP")))?"text-danger":(status!=null && (status.equals("RJ")))?"text-warning":"text-muted" %>"><liferay-ui:message key="<%=status %>"/></span>
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
</div>
<script>
function getQuotDets(policyCount)
{
	var dets = $("#policy_"+policyCount).val();
	$("#quotId").val(dets);
	$("#quoteDetsForm").submit();
}
</script>