<%@page import="com.atmc.otp.constants.OtpPortletKeys"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.model.User"%>
<%@ include file="/init.jsp" %>

<portlet:actionURL var="viewURL" name="updateMobile">
	<portlet:param name="myview" value="view"/>
</portlet:actionURL>
<portlet:renderURL var="viewCancelURL">
	<portlet:param name="myview" value="view"/>
</portlet:renderURL>


<aui:form id="mobileForm" name="mobileForm" action="<%=viewURL%>" method="post" >
<%
User  currentUser = PortalUtil.getUser(request);
String userPhone="";
if(!currentUser.getPhones().isEmpty()){
	userPhone=currentUser.getPhones().get(0).getNumber();
}
else{
	userPhone="";
}
%>
<div class="row margin-top">
	<div class="col-sm-12 col-xs-12 col-md-12 no-pad">
		<form role="form">
			<table class="table table-bordered no-margin"> 
				<thead> 
					<tr> 
						<th><h4 class="text-primary"><liferay-ui:message key="edit_mobile_number"/></h4></th> 
					</tr>								 
				</thead>							 
				<tbody> 
					<tr> 
						<td>
							<div class="row">
								<div class="col-xs-12 col-lg-offset-1 col-sm-6 col-md-offset-1 col-md-4 col-lg-4">
									<div class="form-group"> 
										<label class="control-label" for="formInput56"><liferay-ui:message key="mobile_number"/></label>
											<aui:input type="Text" id="userPhone" name="userPhone" label="" class="form-control" value="<%=userPhone%>">
												<aui:validator name="required" errorMessage="required_field_validator"/>
												<aui:validator name="number" errorMessage="pls_enter_valid_mobile"/>
											</aui:input>
									</div>												 
								</div>
							</div>
							<div class="row">
								<div class="col-sm-12 col-xs-12 text-right no-pad col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
									<ul class="list-btns">
										<li>
											<a class="btn btn-link btn-lg btn-xs-block text-muted" role="button" href="#" onclick="location.href = '${viewCancelURL}'"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/></a>
										</li>
										<li>
											<button id="button" class="btn btn-primary btn-lg btn-xs-block" type="button"><liferay-ui:message key="update_button"/></button>
										</li>
									</ul>
								</div>
							</div>
						</td>									 
					</tr>								 
				</tbody>
			</table>						 
		</form>					 
	</div>
</div>
</aui:form>
<form name="updateMobileForm" method="post" id="updateMobileForm" target="<portlet:namespace />dialog">
	<input type="hidden" name="<%=OtpPortletKeys.MOBILE_NUMBER%>" id="<%=OtpPortletKeys.MOBILE_NUMBER%>"/>
</form>
<aui:script>
function submitMobile(){
	
	console.log("submitting form");
	$("#<portlet:namespace />mobileForm").submit();
}

</aui:script>

<aui:script use="liferay-util-window,liferay-portlet-url">

	A.one('#button').on('click', function(event) {
		var inpObj = $("#<portlet:namespace />userPhone").val();
	    if (inpObj==""||isNaN(inpObj)) {
	    	return false;
	    }
		var actionURL = Liferay.PortletURL.createActionURL();
		actionURL.setWindowState("<%= LiferayWindowState.POP_UP.toString() %>");
		actionURL.setName("/auth/otp");
		actionURL.setPortletId("<%=OtpPortletKeys.OTP%>");
		actionURL.setParameter("mvcRenderCommandName","/auth/otp");
		actionURL.setParameter("<%=OtpPortletKeys.CMD%>","<%=OtpPortletKeys.CMD_SEND%>");
		actionURL.setParameter("<%=OtpPortletKeys.SEND_TO%>","<%=OtpPortletKeys.SEND_TO_EMAIL%>");
		actionURL.setParameter("<%=OtpPortletKeys.REDIRECT_JS_METHOD%>","submitMobile");
		
		Liferay.Util.openWindow(
				{
					cache: false,
					dialog: {
						destroyOnHide: true,
						cssClass: 'atmc-otp-sm',
						headerContent: 'We have sent an OTP to the provided Email Address',
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal:true,
						resizable: false,
						width: 500,
						height: 200,
						after: {
							render: function(evt) {
								$(".modal-body").append("<iframe class='dialog-iframe-node' frameborder='0' id='<portlet:namespace />dialog' name='<portlet:namespace />dialog'/>");
								$.when( $("#<portlet:namespace />dialog").length == 1).then(function(){
									$('#updateMobileForm').attr('action',actionURL);
									$('#updateMobileForm #<%=OtpPortletKeys.MOBILE_NUMBER%>').val($("#<portlet:namespace />userPhone").val());
									$('#updateMobileForm').submit();
									$(".modal-body").addClass("dialog-iframe-bd");
									$(".modal-body").css("padding","0px");
								});
							}
						}
					},
					dialogIframe: {
						id: '<portlet:namespace />dialog',
					},
					uri: ''
				});
	    
	}); 

	
	
	</aui:script>