<%@page import="java.util.Date"%>
<%@page import="com.liferay.journal.model.JournalArticleDisplay"%>
<%@page import="com.liferay.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.journal.model.JournalArticle"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="java.util.List"%>
<%@ include file="init.jsp" %>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<%
Locale loc = themeDisplay.getLocale();
JournalArticle jouranl = JournalArticleLocalServiceUtil.getArticleByUrlTitle(themeDisplay.getScopeGroupId(),"Whistleblowing-Policy");
JournalArticleDisplay jouranldisplay = JournalArticleLocalServiceUtil.getArticleDisplay(themeDisplay.getScopeGroupId(), jouranl.getArticleId() ,"view",themeDisplay.getLanguageId(),themeDisplay);
%>
<portlet:actionURL var="reportFraud" name="reportFraudAction"></portlet:actionURL>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>
<form role="form" id="<portlet:namespace/>reportForm" onsubmit="return checkForm(this);" name="<portlet:namespace/>reportForm" action="<%=reportFraud%>" method="post"   enctype="multipart/form-data">

<liferay-ui:error key="email_failed" message="email_error_message" /> 
<liferay-ui:success key="email_success" message="email_success_message"/>
<liferay-ui:error key="file.failed" message="file.failed" />



<div class="row" data-pg-collapsed>
	<div class="col-md-12">
		<img class="img-responsive" src="/o/atmc-theme/images/report_a_fraud.png" width="100%" />
	</div>
</div><div class="row" data-pg-collapsed>
	<div class="col-md-12">
		<div class="bg-primary pad-10 clearfix">
			<div class="col-md-4">
				<div class="media">
					<div class="media-left media-middle">
						<span class="glyphicon glyphicon-earphone gi-2x"></span>
					</div>
					<div class="media-body">
						<p>
							<a href="tel:<%= LanguageUtil.get(request, "tel_no_1") %>" class="text-white"><%= LanguageUtil.get(request, "tel_no_1") %></a><br/>
							<a href="tel:<%= LanguageUtil.get(request, "tel_no_2") %>" class="text-white"><%= LanguageUtil.get(request, "tel_no_2") %></a><br/>
							<%-- <a href="tel:<%= LanguageUtil.get(request, "tel_no_3") %>" class="text-white"><%= LanguageUtil.get(request, "tel_no_3") %></a><br/> --%> 
							<liferay-ui:message key="appointments"/>
						</p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="media">
					<div class="media-left media-middle">
						<span class="glyphicon glyphicon-map-marker gi-2x"></span>
					</div>
					<div class="media-body">
					<!-- <liferay-ui:message key="head_branch"/><br/><p class="address"><a title="View Location Map" class="text-white" target="_blank" href="https://www.google.com.sa/maps/place/Alinma+Tokio+Marine+Company,+Head+Office/@24.7063722,46.6734443,17z/data=!3m1!4b1!4m5!3m4!1s0x3e2f0329fe7043c7:0xc02feb5a3a46feac!8m2!3d24.7063673!4d46.675633?hl=en&authuser=0" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span> <liferay-ui:message key="head_branch_add_1"/><br/></a></p> -->
						<liferay-ui:message key="head_branch"/><br /><p class="address"><a title="View Location Map" class="text-white" target="_blank" href="https://www.google.com.sa/maps/place/Alinma+Tokio+Marine+Company,+Head+Office/@24.7063722,46.6734443,17z/data=!3m1!4b1!4m5!3m4!1s0x3e2f0329fe7043c7:0xc02feb5a3a46feac!8m2!3d24.7063673!4d46.675633?hl=en&authuser=0" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span><liferay-ui:message key="head_branch_add_1"/></a></p>
					</div>
				</div>
			</div>
			<div class="col-md-4">
				<div class="media">
					<div class="media-left media-middle">
						<span class="glyphicon glyphicon-envelope gi-2x"></span>
					</div>
					<div class="media-body">
						<p><liferay-ui:message key="info_mail_2"/><br /><liferay-ui:message key="pobox"/></p>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
</div>
	</div>
</div><div class="row" data-pg-collapsed>
	<div class="col-xs-12 col-sm-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
		<h2 class="text-primary"><liferay-ui:message key="report_fraud"/></h2>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="date_of_incident"/></div>
			<div class="col-md-6">
				<div class="form-group">				
					<input type="date" name="<portlet:namespace/>dateOfIncident" id="<portlet:namespace/>dateOfIncident" class="form-control"/>					 
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="location_of_incident"/></div>
			<div class="col-md-6">
				<div class="form-group">				
				<select  name="<portlet:namespace/>locationOfIncident" id="<portlet:namespace/>locationOfIncident" class="form-control" label=""> 
						<option value="" selected disabled hidden><liferay-ui:message key="please_select_option"/></option>
						<option value="<%=LanguageUtil.get(request, "riyadh")%>" ><liferay-ui:message key="riyadh"/></option>
						<option value="<%=LanguageUtil.get(request, "jeddah")%>" ><liferay-ui:message key="jeddah"/></option>
						<option value="<%=LanguageUtil.get(request, "eastern_provinces")%>" ><liferay-ui:message key="eastern_provinces"/></option>
						<option value="-1" ><liferay-ui:message key="other"/></option>						 
				</select>						 
				</div>
			</div>
		</div>
		<div class="row location_other" style="display:none;">
			<div class="col-md-6"><liferay-ui:message key="other_plz_specify"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>other_location" id="<portlet:namespace/>other_location" class="form-control" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="i_am"/></div>
			<div class="col-md-6">
				<div class="form-group">				
					<select  name="<portlet:namespace/>rafIAM" id="<portlet:namespace/>rafIAM" class="form-control" label=""> 
						<option value="" selected disabled hidden><liferay-ui:message key="please_select_option"/></option>
						<option value="<%=LanguageUtil.get(request, "atmc_staff")%>" ><liferay-ui:message key="atmc_staff"/></option>
						<option value="<%=LanguageUtil.get(request, "atmc_policy_holder")%>" ><liferay-ui:message key="atmc_policy_holder"/></option>
						<option value="<%=LanguageUtil.get(request, "atmc_equity_holder")%>" ><liferay-ui:message key="atmc_equity_holder"/></option>
						<option value="-1" ><liferay-ui:message key="other"/></option>						 
					</select>					 
				</div>
			</div>
		</div>
		<div class="row rafIAM-other" style="display:none;">
			<div class="col-md-6"><liferay-ui:message key="other_plz_specify"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafOther" id="<portlet:namespace/>rafOther" class="form-control" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label="" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="which_describe_you"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<select name="<portlet:namespace/>rafDescribe" required="required" id="<portlet:namespace/>rafDescribe" class="form-control" label=""> 
						<option value="" selected disabled hidden><liferay-ui:message key="please_select_option"/></option>
						<option value="<%=LanguageUtil.get(request, "victim_abuse_fraud")%>"><liferay-ui:message key="victim_abuse_fraud"/></option>
						<option value="-1"><liferay-ui:message key="other_incidents"/></option>
					</select>					 
				</div>
			</div>
		</div>
		<div class="row rafDescribe-other">
			<div class="col-md-6"><liferay-ui:message key="other_plz_specify"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" required="required" class="form-control" name="<portlet:namespace/>rafDescribeOther" id="<portlet:namespace/>rafDescribeOther" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="case_related_to"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<select class="form-control" label="" required="required" name="<portlet:namespace/>rafCaseRelated" id="<portlet:namespace/>rafCaseRelated" > 
						<option value="" selected disabled hidden><liferay-ui:message key="please_select_option"/></option>
						<option value="<%=LanguageUtil.get(request, "cust_member_insured")%>"><liferay-ui:message key="cust_member_insured"/></option>
						<option value="<%=LanguageUtil.get(request, "service_provider")%>"><liferay-ui:message key="service_provider"/></option>
						<option value="<%=LanguageUtil.get(request, "staff_of_atmc")%>"><liferay-ui:message key="staff_of_atmc"/></option>
						<option value="-1"><liferay-ui:message key="other_party"/></option>						 
					</select>					 
				</div>
			</div>
		</div>
		<div class="row rafCaseRelated-other">
			<div class="col-md-6"><liferay-ui:message key="other_plz_specify"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafCaseRelatedOther" id="<portlet:namespace/>rafCaseRelatedOther" class="form-control" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label=""/> 
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="case_details"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<textarea name="<portlet:namespace/>caseDetails" required="required" id="<portlet:namespace/>caseDetails" class="form-control" maxlength="500" label="" rows="5" >	 
						<e:forHtmlContent value="${param.value}" />
					</textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="financial_loss"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<select class="form-control" label="" required="required" name="<portlet:namespace/>financialLoss" id="<portlet:namespace/>financialLoss" > 
						<option value="-2"><liferay-ui:message key="please_select_option"/></option>
						<option value="100,000"><liferay-ui:message key="less_than"/>Less than 100,000</option>
						<option value="100,000-1,000,000">100,000-1,000,000</option>
						<option value="1,000,000-2,000,000">1,000,000-2,000,000</option>
						<option value="2,000,000-5,000,000">2,000,000-5,000,000</option>
						<option value="5,000,000"><liferay-ui:message key="more_than"/> 5,000,000</option>						 
					</select>					 
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="any_other_loss"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>anyOtherLoss" id="<portlet:namespace/>anyOtherLoss" class="form-control" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label=""/>					 
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="likelyhood_of_case"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<select class="form-control" label="" name="<portlet:namespace/>likelyHoodOfCase" id="<portlet:namespace/>likelyHoodOfCase" > 
						<option value="-2"><liferay-ui:message key="please_select_option"/></option>
						<option value="<%=LanguageUtil.get(request, "once_every_5_yrs_more")%>"><liferay-ui:message key="once_every_5_yrs_more"/></option>
						<option value="<%=LanguageUtil.get(request, "once_every_3_5_yrs")%>"><liferay-ui:message key="once_every_3_5_yrs"/></option>
						<option value="<%=LanguageUtil.get(request, "once_every_1_3_yrs")%>"><liferay-ui:message key="once_every_1_3_yrs"/></option>
						<option value="<%=LanguageUtil.get(request, "once_anually")%>"><liferay-ui:message key="once_anually"/></option>
						<option value="<%=LanguageUtil.get(request, "once_or_more_every_quarter")%>"><liferay-ui:message key="once_or_more_every_quarter"/></option>						 
					</select>					 
				</div>
			</div>
		</div>
		<%-- <div class="row rafCaseRelated-other">
			<div class="col-md-6"><liferay-ui:message key="other_plz_specify"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafCaseRelatedOther" id="<portlet:namespace/>rafCaseRelatedOther" class="form-control" placeholder="<%=LanguageUtil.get(request, "specify_here")%>" label=""/> 
				</div>
			</div>
		</div> --%>
		<%-- <div class="row">
			<div class="col-md-6"><liferay-ui:message key="abuse_fraud_dtls"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<textarea name="<portlet:namespace/>rafDtlAbuse" id="<portlet:namespace/>rafDtlAbuse" class="form-control" maxlength="500" label="" rows="5" ></textarea>
				</div>
			</div>
		</div> --%>
		<h2 class="text-primary"><liferay-ui:message key="personal_info"/></h2>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="company_name"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafCompany" id="<portlet:namespace/>rafCompany" label="" class="form-control" placeholder=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="full_name"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafFullName" id="<portlet:namespace/>rafFullName" label="" class="form-control" placeholder=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="atmc_policy_no"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafPolicyNumber" id="<portlet:namespace/>rafPolicyNumber" label="" class="form-control" placeholder="">
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="mobile_number"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafMobileNum" id="<portlet:namespace/>rafMobileNum" label="" class="form-control" placeholder=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="e_mail"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="text" name="<portlet:namespace/>rafEmail" id="<portlet:namespace/>rafEmail" label="" class="form-control" placeholder=""/> 
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="additional_info"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<textarea name="<portlet:namespace/>rafAddInf" id="<portlet:namespace/>rafAddInf" class="form-control" maxlength="500" label="" rows="5" >
						<e:forHtmlContent value="${param.value}" />
					</textarea>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6"><liferay-ui:message key="attachments"/></div>
			<div class="col-md-6">
				<div class="form-group">
					<input type="file" name="<portlet:namespace/>idFile" id="<portlet:namespace/>idFile" label="" class="form-control" placeholder=""/>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-12 margin-bottom">
				<liferay-captcha:captcha url="<%=captchaURL%>" />
				<button type="button" id="submitBtn"  class="btn btn-lg btn-primary pull-right"><liferay-ui:message key="submit"/></button>
			</div>
		</div>
		<div>
		<input id="field_terms" onchange="this.setCustomValidity(validity.valueMissing ? 'Please indicate that you accept the Terms and Conditions' : '');" type="checkbox" required name="terms"> 
		<liferay-ui:message key="i_acknowledge" /> <a style="cursor: pointer; text-decoration: underline" onclick="myFunction()" id="myBtn"><liferay-ui:message key="Whistleblowing-Policy" /></a>
	</div>
	<div id="myModal" class="modal">
  <div class="modal-content">
    <span class="closeBtn">&times;</span>
   <div class="journal-article-preview"><%= jouranldisplay.getContent() %></div>
</div>
</div>
</div>

</form>
 



<script>
$(document).ready(function(){
	
	$("#<portlet:namespace/>locationOfIncident").on("change",function() {
		   $('.location_other').toggle(this.value == "-1");
		 }).change();
	
	
	$("#<portlet:namespace/>rafIAM").on("change",function() {
	   $('.rafIAM-other').toggle(this.value == "-1");
	 }).change();
	
	$("#<portlet:namespace/>rafDescribe").on("change",function() {
		   $('.rafDescribe-other').toggle(this.value == "-1");
		 }).change();
	
	$("#<portlet:namespace/>rafCaseRelated").on("change",function() {
		   $('.rafCaseRelated-other').toggle(this.value == "-1");
		 }).change();

	});
		document.getElementById("submitBtn").setCustomValidity("Please indicate that you accept the Terms and Conditions");
		function checkForm(form)
		  {
		    if(!form.terms.checked) {
		      alert("Please indicate that you accept the Terms and Conditions");
		      form.terms.focus();
		      return false;
		    }
		    return true;
		  }

	
</script>
<aui:script use="liferay-util-window,liferay-portlet-url">
var frmValidator;

$("#submitBtn").on('click', function(){
	if (frmValidator)
		frmValidator.resetAllFields();
	var rules = {
		};

	if($("#<portlet:namespace/>rafOther").is(":visible"))
	{
		rules.<portlet:namespace/>rafOther = {
				required: true
        }		
	}
	
	if($("#<portlet:namespace/>rafDescribeOther").is(":visible"))
	{
		rules.<portlet:namespace/>rafDescribeOther = {
				required: true
        }		
	}
	
	if($("#<portlet:namespace/>rafCaseRelatedOther").is(":visible"))
	{
		rules.<portlet:namespace/>rafCaseRelatedOther = {
				required: true
        }		
	}
	
	if($("#<portlet:namespace/>other_location").is(":visible"))
	{
		rules.<portlet:namespace/>other_location = {
				required: true
        }		
	}
	
	AUI().use('aui-base', 'io','aui-form-validator',
    function(A) {
    	 A.mix(A.config.FormValidator.RULES,{
    		 ksaMobile:function(val, fieldNode, ruleValue){
    				var allowedCharacters = '05';
    				var regex = new RegExp('(^05)([0-9]{8})');
    				return regex.test(val);
    				},
    		checkFilename:function(val,node,junction){
				var fileInput = document.getElementById("<portlet:namespace/>idFile");
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
             ksaMobile:"Enter a Valid Mobile Number",
             checkFilename:"Enter a Valid File Name"
          },
          true
         );
          
         rules.<portlet:namespace/>rafMobileNum = {
        		required: false,
        		number: true,
  		    	rangeLength: [10,10],
  		    	ksaMobile: true
         }
         
         rules.<portlet:namespace/>idFile = {
        		 required: false,
        		 checkFilename:true
         }
         
         rules.<portlet:namespace/>rafEmail = {
        		 required: false,
        		 email: true
         }
         
         rules.<portlet:namespace/>dateOfIncident = {
        		 required: true,
        		 custDropDown: true
         }
         
         rules.<portlet:namespace/>locationOfIncident = {
        		 required: true,
        		 custDropDown: true
         }
         
         rules.<portlet:namespace/>rafIAM = {
        		 required: true,
         }
         
         
         rules.<portlet:namespace/>rafDescribe = {
        		 required: true,
         }
         
         rules.<portlet:namespace/>rafCaseRelated = {
        		 required: true,
         }
         
         
         rules.<portlet:namespace/>rafPolicyNumber = {
        		 number: true
         }
         
         rules.<portlet:namespace/>rafFullName = {
        		 required: false
         }
         
         rules.<portlet:namespace/>rafDtlAbuse = {
        		 required: false
         } 
          
         var fieldStrings = {
       		  <portlet:namespace/>rafMobileNum: {
     		    	rangeLength:"Enter a Valid Mobile Number"
     		    },
     		   <portlet:namespace/>idFile: {
     			  checkFilename:"Enter a Valid File Name"
     		   }
      		}; 
        
		   	frmValidator = new A.FormValidator(
		    {
		     boundingBox: "#<portlet:namespace/>reportForm",
		     rules: rules,
		     fieldStrings: fieldStrings,
		     validateOnBlur: false
		    });
	
	      frmValidator.validate();
	      if(!frmValidator.hasErrors())
    	  {
    	 		$("#<portlet:namespace/>reportForm").submit();
    	  }
	      
	});
});

var modal = document.getElementById('myModal');
var btn = document.getElementById("myBtn");
var span = document.getElementsByClassName("closeBtn")[0];
btn.onclick = function() {
    modal.style.display = "block";
}
span.onclick = function() {
    modal.style.display = "none";
}
window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}





function agreeTerms(){
	if($('#termsAndCons').is(":checked")){
		$('#submitBtn').removeAttr('disabled');
	}
	else{
		$('#submitBtn').attr('disabled','true');
	}
}
</aui:script>




<style>
body {font-family: Arial, Helvetica, sans-serif;}

/* The Modal (background) */
.modal {
    display: none; /* Hidden by default */
    position: fixed; /* Stay in place */
    z-index: 1; /* Sit on top */
    /* padding-top: 100px; /* Location of the box */ */
    left: 0;
    top: 0;
    width: auto; /* Full width */
    height: auto; /* Full height */
    overflow: auto; /* Enable scroll if needed */
    background-color: rgb(0,0,0); /* Fallback color */
    background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
    background-color: #fefefe;
    margin: auto;
    /* padding: 20px; */
    border: 1px solid #888;
    width: 800px;
    padding-left: 24px;
    padding-right: 24px;
}

/* The Close Button */
.closeBtn {
    color: #aaaaaa;
    float: right;
    font-size: 28px;
    font-weight: bold;
}

.closeBtn:hover,
.closeBtn:focus {
    color: #000;
    text-decoration: none;
    cursor: pointer;
}
</style>
