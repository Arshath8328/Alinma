<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.search.ServiceRequestSearchTerms"%>
<%@page import="com.atmc.web.search.ServiceRequestSearch"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.atmc.web.constants.*"%>
<%@ include file="/adminCustomerServiceList/init.jsp" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<liferay-ui:error key="close_error" message="error_update_service_request" />  
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<div class="row">
	<div class="btn-toolbar-button close" style="opacity: 0 !important">
		<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
			<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
		</svg>
	</div>
</div>


<div class="container bg-white">
	<h3 class="text-primary" style="color: #3b73b9 !important"><liferay-ui:message key="assign_title" /></h3>

	<portlet:actionURL var="submitAssignAction" name="assignRequestToRole">
		<portlet:param name="myview" value="assign_to"/>
	</portlet:actionURL>
	<portlet:actionURL name="/adminCustomerServiceList/assign_to"  var="submitActionURL">
		<portlet:param name="mvcRenderCommandName" value="/adminCustomerServiceList/assign_to" />
		<portlet:param name="<%=AdminCustomerServiceListPortletKeys.CMD %>" value="<%=AdminCustomerServiceListPortletKeys.CMD_ASSIGN %>" />
	</portlet:actionURL>
	
	<aui:form id="assignForm" action="${submitActionURL}" name="assignForm" method="post" enctype="multipart/form-data" class="form-inline">
		<aui:fieldset>
			<aui:input type="hidden" name="refNo" id="refNo" value="<%=request.getParameter("refNo") %>" />
			<aui:input type="hidden" name="portletInstanceID" id="portletInstanceID" value="<%=request.getParameter("portletInstanceID") %>" />
			<div class="row">
				<div class="col-md-12">
					<form> 
						<div class="row">
							<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
								<div class="form-group"> 
									<label class="control-label" for="<portlet:namespace/>srvReqCatDD"><liferay-ui:message key="select_role" /></label>												 
									<select id="<portlet:namespace/>roleDD" name="<portlet:namespace/>roleDD" class="form-control"> 
										<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.FINANCE_ROLE.getValue()%>">Finance</option>
										<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.CLAIM_MANAGER_ROLE.getValue()%>">Claim Manager</option>
										<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.CLAIM_PROCESSOR_ROLE.getValue()%>">Claim Processor</option>
										<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.SURVEYOR_ROLE.getValue()%>">Surveyor</option>
										<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.RECOVERY_ROLE.getValue()%>">Recovery</option>
										<%
											if(userRole.equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue()))
									    	{
										%>
												<option value="<%=AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue()%>">Customer Care</option>
										<%
									    	}
										%>
									</select>
								</div>									 
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group"> 
									<label class="control-label" for="formInput56"><liferay-ui:message key="add_note" /></label>
									<aui:input type="textarea" cssClass="form-control" id="addNote" name="addNote" rows="1" placeholder='<%= LanguageUtil.get(request,"note") %>' label="">
										<aui:validator name="required"/>
										<e:forHtmlContent value="${param.value}" />
									</aui:input>
								</div>									 
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
								<div class="form-group"> 
									<label class="control-label" for=""><liferay-ui:message key="attachments" /></label>	
									<div class="form-control" id="listOfFiles">
										<ul>
										
										</ul>
									</div>
									<input class="btn btn-primary form-control" onclick="$('#<portlet:namespace/>uploadFile').click();" type="button" value='<liferay-ui:message key="add_attachment" />' />
									<aui:input multiple="multiple" type="file" name="uploadFile"  id="uploadFile" cssClass="sr-only" label="" onchange="addFiles()" >
                                        <aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
                                    	<aui:validator name="custom" errorMessage="max_upload_size">
                                            function(val,node,junction){
	                                            var uploadSize=true;
	                                            var size=0;
	                                            var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
	                                            for(var num1=0;num1<fileInput.files.length;num1++)
	                                            {
	                                                var file=fileInput.files[num1];
	                                                if(file.size>2097152)
	                                                {
	                                                    uploadSize=false;
	                                                }
	                                                else
	                                                {
	                                                    uploadSize=true;
	                                                }
	                                                size+=file.size;
	                                            }
	                                            if(uploadSize==true){
	                                                return true;
	                                            }else{
	                                                return false;
	                                            }
	                                        }
                                    	</aui:validator>
                                    	<aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
						                        function(val,node,junction){
						                        	var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
													var fileName = "";
														if(fileInput.files.length>0)
															fileName = fileInput.files.item(0).name;
													var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
													return regex.test(fileName);
												}
                   						</aui:validator>
                                    </aui:input>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 no-pad">
                                <liferay-captcha:captcha url="<%=captchaURL%>" />
								<ul class="list-btns">
									<li>
										<button id="submitBtn" class="btn btn-primary btn-lg" type="submit">
											<liferay-ui:message key="confirm" /> 
											<i class="material-icons md-24">&#xE163;</i>
										</button>
									</li>
									<li>
										<a onclick="$('button.close', window.parent.document).click().click();" id="cancelBtn" name="cancelBtn" 
												cssClass="btn btn-lg text-muted btn-link" role="button" href="javascript:;">
											<liferay-ui:message key="cancel" />
										</a>
									</li>
								</ul>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div class="row"></div>
		</aui:fieldset>
	</aui:form>
</div>
<%
	Boolean result = request.getAttribute("result") != null ? (Boolean)request.getAttribute("result") : false;
	String resultURL = request.getAttribute("resultURL") != null ? (String)request.getAttribute("resultURL") :  null;
%>

<script>

if(<%=result%>)
{
	//window.parent.location.href = '${successURL}';
	window.parent.location.href = "<%=resultURL%>";
}
var listOfFiles = new Array();

$(document).ready(function(){
	$(".btn-toolbar-button").on("click", function(){
		$('button.close', window.parent.document).click().click();
	});
	$('#<portlet:namespace/>uploadFile').attr('multiple', 'mutliple');
});


function addFiles()
{
	var selectedFiles = document.getElementById("<portlet:namespace/>uploadFile").files;
	$("#listOfFiles ul").html('');
	for(var i = 0 ; i < selectedFiles.length; i++)
	{
// 		if(!chkFileExists(selectedFiles[i]))
// 		{
			//listOfFiles.push(selectedFiles[i]);
			
			//$("#listOfFiles ul").append("<li><span>" + selectedFiles[i].name + "</span>-----<i onclick='deleteSelectedFile($(this), \""+selectedFiles[i].name+"\")' class='material-icons  btn btn-link'>&#xE872;</i></li>")
			$("#listOfFiles ul").append("<li><span>" + selectedFiles[i].name + "</span></li>")
// 		}
	}
}

// function chkFileExists(file)
// {
// 	var found = listOfFiles.find(function(element) {
// 	  return element.name == file.name;
// 	});
// 	return found != null;
// }

// function deleteSelectedFile(li, fileName)
// {
// 	for(var i = listOfFiles.length - 1; i >= 0; i--) {
// 	    if(listOfFiles[i].name === fileName) {
// 	    	listOfFiles.splice(i, 1);
// 	    	$(li).parent().remove();
// 	    }
// 	}
// }

</script>

<aui:script>
var frmValidator;
$("#submitBtn").on('click', function(){
	if (frmValidator)
		frmValidator.resetAllFields();
	var rules = {
		};
	
	AUI().use('aui-form-validator',
    function(A) {
    	 A.mix(A.config.FormValidator.RULES,{
    		checkFilename:function(val,node,junction){
				var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
				var fileName = "";
				if(fileInput.files.length>0)
					fileName = fileInput.files.item(0).name;
					var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
					return regex.test(fileName);
				}
               },
            true
			);
          A.mix(A.config.FormValidator.STRINGS,
          {
             checkFilename:"Enter a Valid File Name"
          },
          true
         );
         
         rules.<portlet:namespace/>uploadFile = {
        		 required: false,
        		 checkFilename:true
         }
         
          
         var fieldStrings = {
     		   <portlet:namespace/>uploadFile: {
     			  checkFilename:"Enter a Valid File Name"
     		   }
      		}; 
        
		   	frmValidator = new A.FormValidator(
		    {
		     boundingBox: "#<portlet:namespace/>assignForm",
		     rules: rules,
		     fieldStrings: fieldStrings,
		     validateOnBlur: false
		    });
	
	      frmValidator.validate();
	      if(!frmValidator.hasErrors())
    	  {
    	 		$("#<portlet:namespace/>assignForm").submit();
    	  }
	      
	});
	validateAssignForm();
});
	function validateAssignForm()
	{
		var myFormValidator = Liferay.Form._INSTANCES._ATMCAdminCSListPortlet_assignForm.formValidator;
		
		myFormValidator.validateField("<portlet:namespace/>roleDD");
		myFormValidator.validateField("<portlet:namespace/>addNote");

		
		if (!myFormValidator.hasErrors()) {
			submitForm();
		}
	}
	
</aui:script>