<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
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
<%@ include file="/init.jsp" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<%
String policyNumber = (String) request.getParameter("policyNumber");
System.out.println("policyNumber inside assign_to.jsp >>>>>>>>"+policyNumber);
%>

<liferay-ui:error key="close_error" message="error_update_service_request" />  

<div class="row">
	<div class="btn-toolbar-button close">
		<svg class="lexicon-icon" focusable="false" viewBox="0 0 512 512">
			<path class="lexicon-icon-outline" d="M295.781 256l205.205-205.205c10.998-10.998 10.998-28.814 0-39.781-10.998-10.998-28.815-10.998-39.781 0l-205.205 205.205-205.205-205.238c-10.966-10.998-28.814-10.998-39.781 0-10.998 10.998-10.998 28.814 0 39.781l205.205 205.238-205.205 205.205c-10.998 10.998-10.998 28.815 0 39.781 5.467 5.531 12.671 8.265 19.874 8.265s14.407-2.734 19.907-8.233l205.205-205.238 205.205 205.205c5.5 5.5 12.703 8.233 19.906 8.233s14.407-2.734 19.906-8.233c10.998-10.998 10.998-28.815 0-39.781l-205.238-205.205z"></path>
		</svg>
	</div>
</div>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>


<div class="container bg-white">
	<h3 class="text-primary"><liferay-ui:message key="reason_for_rej" /></h3>

	<portlet:actionURL var="approveUrl" name="approveDetails">
		<portlet:param name="myview" value="approve"/>
	</portlet:actionURL>
	
	
	<aui:form id="assignForm" action="${approveUrl}" name="assignForm" method="post" enctype="multipart/form-data" class="form-inline">
		<aui:fieldset>
			<aui:input type="hidden" name="policyNumber" id="refNo" value="<%=policyNumber %>" />
			<aui:input type="hidden" name="portletInstanceID" id="portletInstanceID" value="<%=request.getParameter("portletInstanceID") %>" />
			<div class="row">
				<div class="col-md-12">
					<form> 
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
									<aui:input multiple="multiple" type="file" name="uploadFile"  id="uploadFile" cssClass="sr-only" label="" onchange="addFiles()">
                                        <aui:validator name="acceptFiles">'jpg,jpeg,png,pdf,doc,docx'</aui:validator>
                                    	<%--<aui:validator name="custom" errorMessage="max_upload_size">
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
                                    	</aui:validator>--%>
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
									<liferay-captcha:captcha url="<%=captchaURL%>" />
								</div>									 
							</div>
						</div>
						<div class="row">
							<div class="col-md-12 no-pad">
								<ul class="list-btns">
									<li>
										<button onclick="validateAssignForm()" class="btn btn-primary btn-lg" type="submit">
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
<aui:script use="liferay-util-window,liferay-portlet-url">
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
});

</aui:script>
<script>
function addFiles()
{
	var selectedFiles = document.getElementById("<portlet:namespace/>uploadFile").files;
	$("#listOfFiles ul").html('');
	for(var i = 0 ; i < selectedFiles.length; i++)
	{
			$("#listOfFiles ul").append("<li><span>" + selectedFiles[i].name + "</span></li>")
	}
}



</script>

