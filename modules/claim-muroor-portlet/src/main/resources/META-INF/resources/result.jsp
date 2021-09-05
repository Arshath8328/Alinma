<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/init.jsp"%>

<%
	String referNo = (String) request.getAttribute("referenceNo");
	boolean tpFlag = (Boolean) request.getAttribute("TP_TYPE_FLAG");
	double amount=0;
	if(tpFlag)
		amount = (Double) request.getAttribute("Amount");
	
	PortletURL downloadURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadURL.setParameter("download", "true");
	String downloadURLVal = downloadURL.toString(); 
	if(downloadURLVal.indexOf("&p_p_lifecycle=1") != -1)
		downloadURLVal = downloadURLVal.substring(0, downloadURLVal.lastIndexOf("&p_p_lifecycle=1"));
	
	PortletURL printURL =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	printURL.setParameter("download", "false");
	String printURLVal = printURL.toString(); 
	if(printURLVal.indexOf("&p_p_lifecycle=1") != -1)
		printURLVal = printURLVal.substring(0, printURLVal.lastIndexOf("&p_p_lifecycle=1"));
%>

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
		<img class="img-responsive" src="/o/atmc-theme/images/najm_tlp_image.png" width="100%" />
	</div>
</div>

<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<div class="bg-primary pad-10">
			<div class="row vcenter">
				<div class="col-lg-7 col-md-7 col-sm-12 col-xs-12">
					<div class="media no-margin">
						<div class="media-left media-middle" style="line-height:1;">
							<i class="material-icons md-36">&#xE0E1;</i>
						</div>
						<div class="media-body">
							<h4 class="media-heading"><liferay-ui:message key="email_sent_prov_addr"/></h4>
							<p><liferay-ui:message key="login_using_id"/></p>
						</div>
					</div>
				</div>
				<div class="col-lg-5 col-md-5 col-sm-12 col-xs-12 text-right">
					<a href="javascript:;" onclick="window.open('<%= printURLVal%>')" class="btn btn-link text-white"><i class="material-icons md-36">&#xE8AD;</i> <liferay-ui:message key="print_claim"/></a>
					<a href="<%= downloadURLVal %>" class="btn btn-link text-white"><i class="material-icons md-36">&#xE2C4;</i> <liferay-ui:message key="download_claim"/></a>
				</div>
			</div>
		</div>
	</div>
</div>

<div class="row">
	<div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2 col-xs-12 col-sm-12">
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
				<h3 class="text-center"> <liferay-ui:message key="claim_submitted_success"/> </h3>
				<p class="text-center"><span class="text-muted"><liferay-ui:message key="claim_ref_no"/></span> <span class="text-primary"><%=referNo %></span></p>
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
			</div>
		</div>
		<div class="row">
				<div class="col-lg-8 col-lg-offset-2 col-md-8 col-md-offset-2 col-sm-12 col-xs-12">
					<div class="row">
						<div class="col-md-12">
							<h3><i class="material-icons md-36 text-warning">&#xE887;</i> <liferay-ui:message key="whats_next"/></h3>	
						</div>				
					</div>
					<div class="row vcenter"> 
						<div class="col-md-8"> 
							<p class="text-warning no-margin"><strong><liferay-ui:message key="visit_branch"/></strong></p> 
						</div> 
						<div class="col-md-4 no-pad">
							<a href="/web/customer/branch_locator" class="btn btn-default btn-outline pull-right"><i class="material-icons">&#xE0C8;</i> <liferay-ui:message key="branch_loc"/></a> 
						</div> 
					</div>
					<br/>
				</div>
			</div>
		<div class="row">
			<div class="col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2 col-xs-12 col-sm-12">
				<table class="table table-bordered"> 
					<thead> 
						<tr> 
							<th class="bg-gray"><liferay-ui:message key="doc_name"/></th> 
						</tr>									 
					</thead>								 
					<tbody> 
						<tr> 
							<td><liferay-ui:message key="police_rep"/></td> 
						</tr>									 
						<tr> 
							<td><liferay-ui:message key="sketch"/></td> 
						</tr>									 
						<tr>
							<td><liferay-ui:message key="copy_id"/></td>
						</tr>
						<tr>
							<td><liferay-ui:message key="copy_ist_card"/></td>
						</tr>
						<tr>
							<td><liferay-ui:message key="est_eval_report"/></td>
						</tr>
					</tbody>
				</table>							 
			</div>
		</div>					 
	</div>
</div>
<div class="row">
	<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
		<button class="btn btn-default btn-outline" type="button" onclick="$('#backResultForm').submit();"><liferay-ui:message key="back_claims"/></button>					 
	</div>
</div>