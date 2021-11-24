<%@page import="com.google.gson.Gson"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="com.ejada.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%
	Policy policy = (Policy)request.getAttribute("policy");
	List<PolicyVehicle> policyVehsList = policy.getPolicyVehs();
%>
<portlet:renderURL var="policyListURL">
	<portlet:param name="myview" value="policy_list"/>
</portlet:renderURL>
<portlet:actionURL name="policyDetails" var="detailsURL"/>
<div class="row">
	<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12 no-pad">
		<h3 class="text-primary"><liferay-ui:message key="ins_veh_list"/></h3>
		<div class="portlet-content">
			<aui:form method="post" name="detailsForm" id="detailsForm" >
<%
	try
	{
		Gson gson = new Gson();
		String policyDets = gson.toJson(policy);
		policyDets = policyDets.replaceAll("\"", "'");
%>
			<input id="policyDets" name="policyDets" type="hidden" value="<%=policyDets %>"/>
			<table class="table">
				<tbody>
<%
		for(int vCount=0;vCount<policyVehsList.size();vCount++)
		{
			PolicyVehicle pVeh = policyVehsList.get(vCount);
			String dets ="";
			dets = gson.toJson(pVeh);
			dets = dets.replaceAll("\"", "'");
%>				
					<tr>
						<td>
							<div class="btn btn-link" onclick="submitDetails('<%=vCount %>');"><%=(currLocale.equals("en_US"))?(pVeh.getMakeEn()+" "+pVeh.getModelEn()):(pVeh.getMakeAr()+" "+pVeh.getModelAr()) %><%=" "+pVeh.getMfgYear() %></div>
							<input id="vehicleDetails_<%=vCount %>" name="vehicleDetails_<%=vCount %>" type="hidden" value="<%=dets %>"/>
						</td>
						<td class="text-muted"><%=(currLocale.equals("en_US"))?(pVeh.getEnPlateNo() +" "+pVeh.getEnPlateL1()+pVeh.getEnPlateL2()+pVeh.getEnPlateL3()):(pVeh.getArPlateNo()+pVeh.getArPlateL1()+pVeh.getArPlateL2()+pVeh.getArPlateL3())%></td>
						<td><span
							class="glyphicon glyphicon-chevron-right text-muted"></span></td>
					</tr>
<%
		}
	}
	catch(Exception e)
	{
		
	}
%>	
				</tbody>
			</table>
			</aui:form>
		</div>
	</div>
</div>
<div class="row">
	<div class="col-md-12 text-right no-pad">
		<ul class="list-btns">
			<li class="pull-left"><a
				class="btn btn-link btn-lg btn-xs-block" role="button" href="${policyListURL}">
					<i class="glyphicon glyphicon-arrow-left"></i> <liferay-ui:message key="back"/>
			</a></li>
		</ul>
	</div>
</div>
<script>
var inputTemplate = "<input type='hidden' name='' value=''/>";
function submitDetails(vehicleCount)
{
	var dets = $("#vehicleDetails_"+vehicleCount).val();
	var policyDets = $("#policyDets").val();
	$('#<portlet:namespace/>detailsForm').find("input[type=hidden]").remove();
	$("#<portlet:namespace/>detailsForm").attr("action","<%=detailsURL%>");
	$(inputTemplate).attr('name','<portlet:namespace/>myview').val('motor_policy_dets').appendTo('#<portlet:namespace/>detailsForm');
	$(inputTemplate).attr('name','<portlet:namespace/>vehicleDetails').val(dets).appendTo('#<portlet:namespace/>detailsForm');
	$(inputTemplate).attr('name','<portlet:namespace/>policyDetails').val(policyDets).appendTo('#<portlet:namespace/>detailsForm');
	$("#<portlet:namespace/>detailsForm").submit();
}
</script>