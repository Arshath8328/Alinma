<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.model.Role"%>
<%@page import="com.atmc.bsl.db.domain.claim.Claim"%>
<%@ include file="/init.jsp" %>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.util.WebKeys"%>
<%@page import="com.google.gson.Gson"%>

<%
Claim claim = (Claim) request.getAttribute("view.jsp-claim");

ResultRow row = (ResultRow) request.getAttribute( WebKeys.SEARCH_CONTAINER_RESULT_ROW );
String claimString = "";
if (row != null) {
	claim = (Claim)row.getObject();
}
try{
	Gson gson = new Gson();
	claimString = gson.toJson(claim);
	claimString = claimString.replaceAll("\"", "'");
}
catch(Exception e)
{
	
}
List<Role> userRoles = themeDisplay.getUser().getRoles();
String roleName="";
for(Role role :userRoles){
	if(role.getName().equals("Claim Processor")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Claim Manager")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Surveyor")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Recovery")){
		roleName=role.getName();
		break;
	}
	else if(role.getName().equals("Finance")){
		roleName=role.getName();
		break;
	}
}

%>

<%
	if(claim.getWorkflowStatus()!=null && !claim.getWorkflowStatus().equals(""))
	{
%>
<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
 
	<portlet:renderURL var="details">
		<portlet:param name="myview" value="details"/>
		<portlet:param name="claimRefNo" value="<%=claim.getClaimNo()%>"/>
		<portlet:param name="policyNo" value="<%=claim.getPolicyNo()%>"/>
		<portlet:param name="policyProductDescAr" value="<%=claim.getProductDescAr()%>"/>
		<portlet:param name="policyProductDescEN" value="<%=claim.getProductDescEn()%>"/>
		<portlet:param name="policyProduct" value="<%=claim.getProduct()%>"/>
	</portlet:renderURL>
  <liferay-ui:icon  message="Details" url="<%=details.toString() %>" />
  
     <% if((roleName.equals("Claim Processor")&&claim.getWorkflowStatus().equals("SUBMITTED"))||roleName.equals("Claim Manager")||roleName.equals("Surveyor")||roleName.equals("Recovery")||roleName.equals("Finance")){ %>
	<portlet:actionURL  var="approve" name="updateStatus" >
		<portlet:param name="myview" value="view"/>
		<portlet:param name="refNo" value="<%=claim.getClaimNo()%>"/>
		<portlet:param name="newStatus" value="APPROVE"/>
	</portlet:actionURL >
  	<li  id="accept_<%=claim.getClaimNo()%>" url="${approve}">
		<a href="javascript:void(0)"><liferay-ui:message key="Accept" /></a>
	</li>
	<aui:script use="liferay-util-window,liferay-portlet-url">
		$('#accept_<%=claim.getClaimNo() %>').on('click', function(event) {
			//openModal();
			var url = $(this).attr('url');
			//alert(url);
			openModal();
			$("#confirmBtn").attr('href', url);
		});
		function openModal()
		{
			AUI().use('aui-modal', function(A) {
				var dialog = new A.Modal({
					title: "",
					bodyContent: $('#accept_popup_body').html(),
					headerContent: '',
					centered: true,
					modal: true,
					resizable: false,
					width: 600,
					height: 300,
					render: '#accept_popup_content'
				});						
				dialog.on('visibleChange', function(event) {
					if (!event.newVal) {
						//window.location = '/group/staff/manage_customer_service';
						$("#confirmBtn").attr('href', '');
					}
				});
			});
		}				
	</aui:script>
    <%} %>
  
  <% if(roleName.equals("Claim Manager")||roleName.equals("Recovery")){ %>
	<portlet:actionURL var="reject"  name="updateStatus" >
		<portlet:param name="myview" value="view"/>
		<portlet:param name="refNo" value="<%=claim.getClaimNo()%>"/>
		<portlet:param name="newStatus" value="CLAIMREJECTED"/>
	</portlet:actionURL>
	<li id="reject_<%=claim.getClaimNo()%>" url="${reject}">
				<a href="javascript:void(0)"><span class="text-danger"><liferay-ui:message key="reject" /></span></a>
	</li>
	<aui:script use="liferay-util-window,liferay-portlet-url">
		$('#reject_<%=claim.getClaimNo()%>').on('click', function(event) {
			//openModal();
			var url = $(this).attr('url');
			//alert(url);
			openRejectModal();
			$("#submitBtn").attr('href', url);
		});		
		function openRejectModal()
		{
			AUI().use('aui-modal', function(A) {
				var dialog = new A.Modal({
					title: "",
					bodyContent: $('#reject_popup_body').html(),
					headerContent: '',
					centered: true,
					modal: true,
					resizable: false,
					width: 600,
					height: 300,
					render: '#reject_popup_content'
				});						
				dialog.on('visibleChange', function(event) {
					if (!event.newVal) {
						//window.location = '/group/staff/manage_customer_service';
						$("#submitBtn").attr('href', '');
					}
				});
			});
		}			
	</aui:script>
  <%} %>

</liferay-ui:icon-menu>
<%	} %>
<div id="accept_popup_content"></div>
<div id="accept_popup_body" style="display:none;">
		<form method="post" >
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12">
					<h4 class="text-primary text-left"><liferay-ui:message key="Claims Request Managemen"/></h4>
					<div class="form-group text-left"> 
						<label class="control-label" for="formInput56"><liferay-ui:message key="Reason For Accepted"/></label>
							<aui:input type="Text" name="reason" label="" class="form-control" value="">
						</aui:input>
					</div>	
						 
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<a role="button" class="btn btn-primary btn-lg btn-xs-block" href="" id="confirmBtn"><liferay-ui:message key="confirm" /></a>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</form>

</div>



<div id="reject_popup_content"></div>
<div id="reject_popup_body" style="display:none;">
		<form method="post" >
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12 text-left">
					<h4 class="text-primary"><liferay-ui:message key="Claims Request Management"/></h4>
					<div class="form-group"> 
						<label class="control-label" for="formInput56"><liferay-ui:message key="Reason For Rejected"/></label>
							<aui:input type="Text" name="reason" label="" class="form-control" value="">
						</aui:input>
					</div>	
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<a role="button" class="btn btn-primary btn-lg btn-xs-block" href="" id="submitBtn"><liferay-ui:message key="confirm" /></a>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</form>

</div>