<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyCancelation"%>
<%@ include file="init.jsp" %>
<%
PolicyCancelation policydetails = (PolicyCancelation) request.getAttribute("cnclPolicyDetails");
System.out.print("policyNumber>>>>>>>>>>>>>>>"+policydetails);

%>

<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<div class="tab-content bg-white pad-10">
<h3 class="pull-right"><i class="material-icons">&#xE061;</i><%=LanguageUtil.get(request,policydetails.getStatus())%></h3>
	<div class="tab">
		<ul class="nav nav-tabs">
			<li class="active">
				<a href="#tab-1" role="tab" data-toggle="tab"><liferay-ui:message key="policy_request"/></a>
			</li>
			<li>
				<a href="#tab-2" role="tab" data-toggle="tab"><liferay-ui:message key="track_history"/></a>
			</li>
		</ul>
	</div>
		<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
			<table class="table table-bordered">
				<tr> 
					<td width="25%">
						<%-- <liferay-ui:message key="quote_ref"/> <span class="text-primary"><%=quotation.getReferenceNo()%></span><br/> --%>
						<liferay-ui:message key="policy_no"/> <span class="text-primary"> <%=policydetails.getPolicyNumber()%></span>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="requested_by"/></span><br/>
						<%=policydetails.getInsuredName() %>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="rejection_reason"/></span><br/>
						<%-- <%=policydetails.getRejReason()%> --%>
					</td> 
					<td width="25%">
						<span class="text-muted"><liferay-ui:message key="date_received"/></span><br/>
						<%=dateFormatter.format(policydetails.getCancllationReqDate()) %>
					</td> 
				</tr>
			</table>
			<h4 class="text-primary"><liferay-ui:message key="policy_holder_details"/></h4>
			<table class="table table-bordered">
				<tr> 
					<td width="40%"><liferay-ui:message key="id_number"/></td> 
					<td width="60%" class="text-muted"><%=policydetails.getInsuredId()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_name"/></td> 
					<td class="text-muted"><%=policydetails.getInsuredName()%></td> 
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_email"/></td> 
					<td class="text-muted"><%=policydetails.getInsuredEmail()%></td>
				</tr>
				 <tr> 
					<td><liferay-ui:message key="pol_ins_date"/></td> 
					<td class="text-muted"><%=policydetails.getPolicyInceptionDate()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="policy_holder_mob"/></td> 
					<td class="text-muted">0<%=policydetails.getInsuredMobile()%></td>  
				</tr>
				<tr> 
					<td><liferay-ui:message key="pol_exp_date"/></td> 
					<td class="text-muted"><%=dateFormatter.format(policydetails.getPolicyExpiryDate())%></td>
				</tr>
				 <tr> 
					<td><liferay-ui:message key="chassis_no"/></td> 
					<td class="text-muted"><%=policydetails.getVehicleChessisNo()%></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="veh_id_no"/></td> 
					<td class="text-muted"><%=policydetails.getVehicleSequence() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="cncl_reason"/></td> 
					<td class="text-muted"><%=policydetails.getReason() %></td>
				</tr>
				<tr> 
					<td><liferay-ui:message key="pol_canc_eff_date"/></td> 
					<td class="text-muted"><%=policydetails.getCancellationEffdate() %></td>
				</tr>
				
				
	
			</table>
			</div>
			<h4 class="text-primary"><liferay-ui:message key="attchements"/></h4>
			<portlet:actionURL var="submitFileAction" name="submitFile">
<portlet:param name="myview" value="details"/>
<portlet:param name="quotationId" value="<%=policydetails.getPolicyNumber()+"" %>"/>
</portlet:actionURL>

			<aui:form action="<%= submitFileAction %>" method="post" enctype="multipart/form-data" id="uploadForm" name="uploadForm" cssClass="form-inline" label="">
				<aui:fieldset label="" cssClass="row">
					<div class="col-md-12">
						<div class="form-group has-feedback"> 
							<input id="selectedFile" class="form-control" onclick="$('#<portlet:namespace/>adminFile').click();" placeholder="<liferay-ui:message key="select_file"/>"> 
							<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
						</div>
						<input class="btn btn-default" type="submit" id="<portlet:namespace/>uploadBtn" name="<portlet:namespace/>uploadBtn"  disabled="disabled" value='<liferay-ui:message key="upload"/>' />
						<br/>
						<aui:input type="file" name="adminFile" id="adminFile" cssClass="sr-only" label="" onChange="selectFile($(this))">
							<aui:validator name="required" errorMessage='Please Choose a File' />
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
												var fileInput = document.getElementById("<portlet:namespace/>adminFile");
												var fileName = "";
												if(fileInput.files.length>0)
													fileName = fileInput.files.item(0).name;
													var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
													return regex.test(fileName);
												}
										</aui:validator>
						</aui:input>
					</div>
				</aui:fieldset>
						<liferay-captcha:captcha url="<%=captchaURL%>" />
				
			</aui:form>
	</div>
	
	
	
<script>
	console.log('<portlet:namespace/>');
function selectFile() {
	var obj = document.getElementById("<portlet:namespace />adminFile"); 
	if(obj.files !=null  && obj.files.length > 0)
	{
		$("[id*='uploadBtn']").attr('disabled' , false);
		$('[id*="selectedFile"]').val(obj.files.item(0).name);
	}
	else
	{
		$('[id*="selectedFile"]').val('');
		$("[id*='uploadBtn']").attr('disabled' , true);
	}
		
};
function Print(){
	 self.print();
}
</script>
<aui:script>
var frmValidator;
$("#uploadBtn").on('click', function(){
	if (frmValidator)
		frmValidator.resetAllFields();
	var rules = {
		};
	
	AUI().use('aui-form-validator',
    function(A) {
    	 A.mix(A.config.FormValidator.RULES,{
    		checkFilename:function(val,node,junction){
				var fileInput = document.getElementById("<portlet:namespace/>adminFile");
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
         
         rules.<portlet:namespace/>adminFile = {
        		 required: false,
        		 checkFilename:true
         }
         
          
         var fieldStrings = {
       		  <portlet:namespace/>rafMobileNum: {
     		    	rangeLength:"Enter a Valid Mobile Number"
     		    },
     		   <portlet:namespace/>adminFile: {
     			  checkFilename:"Enter a Valid File Name"
     		   }
      		}; 
        
		   	frmValidator = new A.FormValidator(
		    {
		     boundingBox: "#<portlet:namespace/>uploadForm",
		     rules: rules,
		     fieldStrings: fieldStrings,
		     validateOnBlur: false
		    });
	
	      frmValidator.validate();
	      if(!frmValidator.hasErrors())
    	  {
    	 		$("#<portlet:namespace/>uploadForm").submit();
    	  }
	      
	});
});

	function validateFile()
	{
		var myFormValidator = eval('Liferay.Form._INSTANCES.<portlet:namespace/>uploadForm.formValidator');
		
		myFormValidator.validateField("<portlet:namespace/>adminFile");

		if (!myFormValidator.hasErrors()) {
			$("#<portlet:namespace/>uploadForm").submit();
		}
	}
	
	
</aui:script>
	