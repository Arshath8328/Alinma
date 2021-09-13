<%@page import="javax.portlet.PortletURL"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@ include file="/init.jsp" %>

<% 
String referenceNo =(String)request.getAttribute("referenceNo");
double amount =(double)request.getAttribute("amount");
boolean tpFlag=(boolean)request.getAttribute("tpFlag");

PortletURL printURl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
PortletURL downloadURl= PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);;
printURl.setParameter("download", "false");
String downloadUrlVal = downloadURl.toString(); 

String printURlVal =printURl.toString(); 
if(downloadUrlVal.indexOf("&p_p_lifecycle=1") != -1)
	downloadUrlVal = downloadUrlVal.substring(0, downloadUrlVal.lastIndexOf("&p_p_lifecycle=1"));
if(printURlVal.indexOf("&p_p_lifecycle=1") != -1)
	printURlVal = printURlVal.substring(0, printURlVal.lastIndexOf("&p_p_lifecycle=1"));

%>
 <portlet:resourceURL var="downloadURL">
 	<portlet:param name="download" value="true"/>
 </portlet:resourceURL>

<portlet:actionURL name="backToClaim" var="backToClaim">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>
<form id="backResultForm" name="backResultForm" role="form" action="<%=backToClaim%>" method="post">
	<input type="hidden" name="<portlet:namespace/>odsClmIntm" value=""/>
</form>
 
<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><liferay-ui:message key="report_claim"/></h3>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="" src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<div class="bg-primary pad-10">
			<div class="row vcenter">
				<div class="col-md-8 col-sm-12 col-xs-12 col-lg-8">
					<div class="media">
						<div class="media-left">
							<span class="glyphicon glyphicon-envelope gi-2x"></span>
						</div>
						<div class="media-body">
							<h4 class="media-heading"><liferay-ui:message key="email_sent_prov_addr"/></h4>
							<p><liferay-ui:message key="login_using_id"/></p>
						</div>
					</div>
				</div>
				<div class="col-md-2 col-xs-6 col-sm-6 col-lg-2">
					<a href="javascript:;" class="text-white" onclick="window.open('<%= printURlVal%>')"><span class="glyphicon glyphicon-print gi-2x"></span>&nbsp;&nbsp; <liferay-ui:message key="print_claim"/></a>
				</div>
				<div class="col-md-2 col-xs-6 col-sm-6 col-lg-2">
					<a href="<%= downloadUrlVal %>" class="text-white"><span class="glyphicon gi-2x glyphicon-download-alt"></span>&nbsp;&nbsp; <liferay-ui:message key="download_claim"/></a>
				</div>
			</div>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<h3 class="text-center"> <liferay-ui:message key="claim_submitted_success"/> </h3>
		<p class="text-center"><span class="text-muted"><liferay-ui:message key="claim_ref_no"/></span> <span class="text-primary"><%=referenceNo%></span></p>
		 <%
			if(tpFlag)
			{
				if(amount<=2000)
				{
			%>
					<p class="text-center text-primary"><liferay-ui:message key="claim_5days_msg"/></p>
			<%
				}
				else
				{
			%>
					<p class="text-center text-primary"><liferay-ui:message key="claim_15days_msg"/></p>
			<%
				}
			}
		%>
		<button class="btn btn-primary btn-outline" type="button" onclick="$('#backResultForm').submit();"><liferay-ui:message key="back_claims"/> </button>
	</div>
</div>