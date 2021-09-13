<%@page import="policy.list.portlet.PolicyListPortlet"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.util.Date"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.liferay.portal.kernel.theme.ThemeDisplay"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="com.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="java.text.NumberFormat"%>
<%@ include file="init.jsp"%>
<%
 Log _log = LogFactoryUtil.getLog(PolicyListPortlet.class);
//_log.debug("performance test: start of JSP");
	List<Policy> policyList = (List)request.getAttribute("policyList");
	long count=(long)request.getAttribute("count");
	
	PortletURL cancelPolicyURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	cancelPolicyURL.setParameter("myview", "cancelPolicy");

	PortletURL addDriverEndors = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
	addDriverEndors.setParameter("myview", "add_driver");
	
	PortletURL polCnclDetURL = PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request),
			themeDisplay.getPlid(), PortletRequest.RENDER_PHASE);
		polCnclDetURL.setParameter("myview", "policyCnclList");
		

	boolean result = (request.getAttribute("result")!=null)?((Boolean)request.getAttribute("result")):false;
	_log.info("result>>>>>>>"+result);
	
	boolean polCnclReqExist = (request.getAttribute("policyCancReq")!=null)?((Boolean)request.getAttribute("policyCancReq")):false;
	_log.info("details>>>>>>>"+polCnclReqExist);
%>



<portlet:renderURL var="quotationsURL">
	<portlet:param name="myview" value="quotations"/>
</portlet:renderURL>

<portlet:actionURL name="policyDetails" var="detailsURL"/>



<div class="row margin-top">
	<div class="col-md-12 no-pad">
		<a class="btn btn-default pull-right btn-xs-block margin-bottom" href="/web/customer/buy_motor_policy">
			<i class="glyphicon glyphicon-plus"></i> <liferay-ui:message key="new_policy"/>
		</a>
		<div class="tab">
			<ul class="nav nav-tabs clearfix margin-bottom bg-body">
				<li class="active"><a href="#tab-1" role="tab" data-toggle="tab" style="padding:10px 15px;"><liferay-ui:message key="my_policies"/></a></li>
				<li><a href="${quotationsURL}" style="padding:10px 15px;"><liferay-ui:message key="my_quotes_list"/></a></li>
				<li><a href="<%=polCnclDetURL%>" style="padding: 10px 15px;"><liferay-ui:message key="policy_cncl_list" /></a></li>
			</ul>
			<aui:form method="post" name="detailsForm" id="detailsForm" >
				<table id="example" class="table ej-table table-striped">
					<thead>
						<tr>
							<th><liferay-ui:message key="policy"/></th>
							<th><liferay-ui:message key="exp"/></th>
							<th><liferay-ui:message key="desc_actions"/></th>
							<th><liferay-ui:message key="premium"/></th>
							<th><liferay-ui:message key="status"/></th>
							<th><liferay-ui:message key="policy_update" /></th>
							<th><liferay-ui:message key="renew" /></th>
						</tr>
					</thead>
					<tbody>
					<div id="aui_popup_content"></div>
						<div id="aui_popup_body" style="display: none;">
							<div class="text-center">
								<h3>
								<%
								if(result){%><liferay-ui:message key="pol_cncl_req_rcvd" />
								<%}if(polCnclReqExist){%><liferay-ui:message key="pol_cncl_req_exixt" /><%
								}
								%>
								</h3>
							</div>
						</div>
<%
	for(int policyCount=0; policyList!= null && policyCount<policyList.size();policyCount++)
	{
		Policy policy = (Policy)policyList.get(policyCount);
		String product = policy.getProduct();
		DateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		if(product!=null && ((product.equals("13101") || product.equals("13102") ||product.equals("430") ||product.equals("450") ||product.equals("470") ||product.equals("480") ||product.equals("490") ||product.equals("SMEE") ||product.equals("CCHA"))))
		{
			String expDate = simpleDateFormat.format(policy.getExpiryDate());
			String policyIcon = (product.equals("13101") || product.equals("13102"))?"transport-3":(product.equals("SMEE") || product.equals("CCHA"))?"healthy":"shield";
			String dets = "";
			String detsView = "life_policy_dets";
			long noOfRisk = policy.getNoOfRisk();
			String statusColor = "text-success";
			if(policy.getPolicyStatus()!=null && (policy.getPolicyStatus().equals("PR")||policy.getPolicyStatus().equals("Q")))
				statusColor = "";
			else if(policy.getPolicyStatus()!=null && policy.getPolicyStatus().equals("H"))
				statusColor = "text-warning";
			else if(policy.getPolicyStatus()!=null && (policy.getPolicyStatus().equals("EX")||policy.getPolicyStatus().equals("C")||policy.getPolicyStatus().equals("L")))
				statusColor = "text-danger";
			
			if(product.equals("13101") || product.equals("13102"))
			{
				if(noOfRisk>1)
					detsView = "vehicle_list";
				else
					detsView = "motor_policy_dets";
			}
			else if(product.equals("SMEE") || product.equals("CCHA"))
				detsView = "med_policy_dets";
			try{
				Gson gson = new Gson();
				dets = gson.toJson(policy);
				dets = dets.replaceAll("\"", "'");
			}
			catch(Exception e)
			{
				
			}
%>							
						<tr>
							<td data-label="Policy">
								<div class="btn btn-link no-pad" onclick="submitDetails('<%=policyCount %>');"><%=policy.getPolicyNo() %></div>
								<%
									    cancelPolicyURL.setParameter("polNumber", policy.getPolicyNo());
										polCnclDetURL.setParameter("iqamaId", policy.getInsuredId());
										addDriverEndors.setParameter("polNumber", policy.getPolicyNo());
										polCnclDetURL.setParameter("insuredId", policy.getInsuredId());

								%>
								<input id="myview_<%=policyCount %>" name="myview_<%=policyCount %>" type="hidden" value="<%=detsView %>" />
								<input id="policyDetails_<%=policyCount %>" name="policyDetails_<%=policyCount %>" type="hidden" value="<%=dets %>"/>
								<br />
								<small class="text-muted">
									<span class="icon icon-<%=policyIcon%>"></span>
									<%=(currLocale.equals("en_US"))?policy.getProductEn():policy.getProductAr() %>
								</small>
							</td>
							<td data-label="Expiration">
								<span class="<%=(new Date().getTime()>policy.getExpiryDate().getTime())?"text-danger":""%>"><%=expDate %></span>
							</td>
							<td data-label="Description/Actions">
<%
			if(noOfRisk >1 || (noOfRisk == 1 && !product.equals("13101") && !product.equals("13102")))
			{
				String numberDesc = (product.equals("13101") || product.equals("13102"))?"Vehicles":"Members";
%>								
									<div class="<%=(noOfRisk >1)?"round-link ":"" %>round round-sm hollow blue" <%=(noOfRisk>1)?"onclick=\"submitDetails('"+policyCount+"');\"":"" %>><%=noOfRisk%></div> <%=numberDesc %>
<%
			}
			else if(noOfRisk == 1 && (product.equals("13101") || product.equals("13102")))
			{
				List policyVehs = policy.getPolicyVehs();
				if(policyVehs !=null && !policyVehs.isEmpty())
				{
					PolicyVehicle pVeh = (PolicyVehicle)policyVehs.get(0);
%>
									<%=(currLocale.equals("en_US"))?(pVeh.getMakeEn()+" "+pVeh.getModelEn()):(pVeh.getMakeAr()+" "+pVeh.getModelAr()) %><%=", "+pVeh.getMfgYear() %><br />
									<small class="text-muted"><%=(currLocale.equals("en_US"))?(pVeh.getEnPlateNo()+" "+pVeh.getEnPlateL1()+" "+pVeh.getEnPlateL2()+" "+pVeh.getEnPlateL3()):(pVeh.getEnPlateNo()+" "+pVeh.getArPlateL1()+" "+pVeh.getArPlateL2()+" "+pVeh.getArPlateL3()) %></small>
<%
			
				}
			}
%>
							</td>
							<td data-label="Premium"><%=decimalFormat.format(Double.valueOf(policy.getTotalPremium())) %> SAR</td>
							<td data-label="Status"><span class="<%=statusColor%>"><%=(currLocale.equals("en_US"))?policy.getPolicyStatusEn():policy.getPolicyStatusAr() %>
							</span></td>
							<%
							
							long currDateTime =new Date().getTime();
							long toDateTime = policy.getExpiryDate().getTime();
							long daysDiff = (toDateTime - currDateTime)/ (1000 * 60 * 60 * 24);

							String pStatus = policy.getPolicyStatus();
							boolean withinExpiryPeriod = false;
						    int daysAfterExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysAfterExp"));
							if(pStatus != null && pStatus.equals("EX") && daysDiff<0)
							{
						        int daysTillExp = Integer.valueOf(PropsUtil.get("com.ejada.atmc.renewals.exirydate.daysTillExp"));
								if(Math.abs(daysDiff) <= daysTillExp)
									withinExpiryPeriod = true;
							}
							%>
							<td>
							<%
							if (!policy.getPolicyStatus().equals("EX"))
							{
							%>
							<div class="btn-group">
									<button type="button" class="btn btn-primary">Action</button>
									<button type="button" class="btn btn-primary dropdown-toggle"
										data-toggle="dropdown">
										<span class="caret"></span> <span class="sr-only">Toggle
											Dropdown</span>
									</button>
									<ul class="dropdown-menu" role="menu">
										<li><a href="<%=cancelPolicyURL%>">Cancel Policy</a></li>
										<li><a href="<%=addDriverEndors%>"> Add Driver</a></li>
										<!-- <li><a href="#">Add Covers</a></li>
										<li><a href="#">Custom To Plate </a></li> -->
									</ul>
								</div>
								<%
							}
								%>
								</td>
								<td>
							 <button class="btn btn-primary btn-lg btn-xs-block" type="button"  onclick="submitDetails('<%=policyCount %>');" <%=(daysDiff>daysAfterExp||(pStatus.equals("EX")&& !withinExpiryPeriod))?"disabled":"" %>><liferay-ui:message key="renew"/></button>
							
							</td>
						</tr>
<%
		}
	}
%>
					</tbody>
				</table>
			
				<nav aria-label="Page navigation">
				  <ul class="pagination">
				    
			    	<%
						int pageNo=1;
			    		int pagesize=10;
						for(int i=pagesize;i<count+pagesize;i+=pagesize){
									
								
					%>
					    <li>
					    	<%int endNo=i; %>
					    	<portlet:renderURL var="policyListfunction">
								<portlet:param name="myview" value="policy_list"/>
								<portlet:param name="pageNo" value="<%=pageNo+"" %>"/>
								<portlet:param name="pagesize" value="<%=pagesize+"" %>"/>
							</portlet:renderURL>
					    	<a href="${policyListfunction}"><%=pageNo%></a>
					    </li>
					   
			    	<%
			    		pageNo++;
			    		} 
			    	%>
		
				  </ul>
				</nav>
				
			</aui:form>
		</div>
	</div>
</div>
<script>

 var inputTemplate = "<input type='hidden' name='' value=''/>";

$(function(){
	$('.pagination a').filter(function(){return this.href==location.href}).parent().addClass('active').siblings().removeClass('active')
	$('.pagination a').click(function(){
		$(this).parent().addClass('active').siblings().removeClass('active')	
	})
})
function submitDetails(policyCount)
{
	var dets = $("#policyDetails_"+policyCount).val();
	var myview = $("#myview_"+policyCount).val();
	$('#<portlet:namespace/>detailsForm').find("input[type=hidden]").remove();
	$("#<portlet:namespace/>detailsForm").attr("action","<%=detailsURL%>");
	$(inputTemplate).attr('name','<portlet:namespace/>myview').val(myview).appendTo('#<portlet:namespace/>detailsForm');
	$(inputTemplate).attr('name','<portlet:namespace/>policyDetails').val(dets).appendTo('#<portlet:namespace/>detailsForm');
	$("#<portlet:namespace/>detailsForm").submit();
}
 </script>
 
 <aui:script>
var policyReqRcvd = <%=result%>;
var polCancExist = <%=polCnclReqExist%>; 
if(policyReqRcvd)
{
AUI().use('aui-modal', function(A) {
	var dialog = new A.Modal({
		title: "",
		cssClass: "compose-dialog",
		bodyContent: AUI().one('#aui_popup_body').html(),
		headerContent: '<h4><liferay-ui:message key="pol_cncl_req_rcvd" /></h4>',
		/* <h4 class="no-margin text-primary">'+((policyReqRcvd)?'<liferay-ui:message key="pol_cncl_req_rcvd"/>':(polCancExist)?'Policy Canclation Exist':"")+'</h4>', */
		centered: true,
		modal: true,
		height: 230,
		render: '#aui_popup_content'
	});
	dialog.addToolbar(
	      [
	        {
	          label: 'Done',
	          cssClass: 'btn-primary',
	          on: {
	            click: function() {
	            	dialog.hide();
	            }
	          }
	        }
	      ]
	    );
});
	}
	
	
	
if(polCancExist)
{
AUI().use('aui-modal', function(A) {
	var dialog = new A.Modal({
		title: "",
		cssClass: "compose-dialog",
		bodyContent: AUI().one('#aui_popup_body').html(),
		headerContent: '<h4><liferay-ui:message key="pol_cncl_req_rcvd" /></h4>',
		/* <h4 class="no-margin text-primary">'+((policyReqRcvd)?'<liferay-ui:message key="pol_cncl_req_rcvd"/>':(polCancExist)?'Policy Canclation Exist':"")+'</h4>', */
		centered: true,
		modal: true,
		height: 230,
		render: '#aui_popup_content'
	});
	dialog.addToolbar(
	      [
	        {
	          label: 'Done',
	          cssClass: 'btn-primary',
	          on: {
	            click: function() {
	            	dialog.hide();
	            }
	          }
	        }
	      ]
	    );
});
	}
	
	/* if(polCancExist=="PolicyCancExist")
		{
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				cssClass: "compose-dialog",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '<h4><liferay-ui:message key="pol_cncl_req_exixt" /></h4>',
				centered: true,
				modal: true,
				height: 230,
				render: '#aui_popup_content'
			});
			dialog.addToolbar(
			      [
			        {
			          label: 'Done',
			          cssClass: 'btn-primary',
			          on: {
			            click: function() {
			            	dialog.hide();
			            }
			          }
			        }
			      ]
			    );
		});
		} */

</aui:script>
		
 <%
 //_log.debug("performance test: end of JSP");
 %>