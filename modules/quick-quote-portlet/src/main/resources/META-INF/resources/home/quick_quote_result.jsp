<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.DecimalFormat"%>
<%@ include file="init.jsp" %>

<%
	Log _log = LogFactoryUtil.getLog(this.getClass());

	String manufactName = (String) request.getAttribute("MANUFACT_NAME");
	String manufactYear = (String) request.getAttribute("MANUFACT_YEAR");
	int year = Integer.valueOf(manufactYear);
	_log.info("MANUFACT_YEAR >>>>>>>>>>>>>>"+ year);
	String ODBasePerm = (String) request.getAttribute("OD_BASE_PERM");
	String TPBasePerm = (String) request.getAttribute("TP_BASE_PERM");
	_log.info("ODBasePerm   >>>>>>>>>>>>"+ ODBasePerm);
	_log.info("TPBasePerm >>>>>>>>>>>>>>"+ TPBasePerm);
%>

<portlet:renderURL var="startQuickQuote">
	<portlet:param name="myview" value="quick_quote"/>
</portlet:renderURL>

<div class="quick_quote" style="overflow:hidden;font-size:12px;">
	<h2 style="margin-top:0;"><liferay-ui:message key="quick_quote"/></h2>
	<p><liferay-ui:message key="motor_insurance_for"/><%=" "+manufactName%></p>
	<hr style="margin-top: 0;margin:10px;" />
	<div class="coverage_container clearfix" style="position: relative;width:40%;">
		<div class="coverage_section" style="float: left;width: calc(50% - 5px);text-align:center;background-color:rgba(255,255,255,0.2);margin-right: 5px;padding: 10px 5px;">
			<h4><liferay-ui:message key="third_party_cover"/></h4>
			<p><liferay-ui:message key="starting_from"/></p>
			<h2><small style="color:#FFF;"><liferay-ui:message key="sar"/></small> <%=TPBasePerm%></h2>
			<a href="/web/customer/buy_motor_policy"><div class="btn btn-lg btn-primary buynow-btn"><liferay-ui:message key="buy_now"/></div></a>
		</div>
		<%
		if(year<Calendar.getInstance().get(Calendar.YEAR)+2)
		{
		%>
		<div class="coverage_section" style="float:left;width: calc(50% - 5px);text-align:center;background-color:rgba(255,255,255,0.2);margin-left: 5px;padding: 10px 5px;">
			<h4><liferay-ui:message key="comprehensive_coverage"/></h4>
			<p><liferay-ui:message key="starting_from"/></p>
			<h2><small style="color:#FFF;"><liferay-ui:message key="sar"/></small> <%=ODBasePerm%></h2>
			<a href="/web/customer/buy_motor_policy"><div class="btn btn-lg btn-primary buynow-btn"><liferay-ui:message key="buy_now"/></div></a>
		</div>
		<%
		}
		else
		{
			%>
			
			<div class="coverage_section" style="float:left;width: calc(50% - 5px);text-align:center;background-color:rgba(255,255,255,0.2);margin-left: 5px;padding: 9px 5px;">
			<h4><liferay-ui:message key="comprehensive_coverage"/></h4>
			<br/>
			<h4><liferay-ui:message key="comprehensive_coverage_od"/></h4>
			<br />
		</div>
			
			
			<% 
		}
		%>
	</div>
	<div style="padding-top:2px;">
		<a href="<%=startQuickQuote%>" style="color:#fff;"><span class="glyphicon glyphicon-refresh"></span><liferay-ui:message key="get_another_quote"/></a> 
	</div>
	//<div><p><liferay-ui:message key="quick_quote_disclaimer"/></p>
	<p><a href="https://www.najm.sa/en/InsuranceRecords" target="_blank"><liferay-ui:message key="najm_website_link"/> </a></p>
	</div>
	
</div>