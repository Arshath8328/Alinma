<%@page import="vacancies.portlet.constants.VacanciesPortletKeys"%>
<%@page import="com.liferay.portal.kernel.dao.orm.Session"%>
<%@page import="java.io.Console"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@ include file="init.jsp" %>

<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>

<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>
<%
	String  jobTitle = (String)request.getAttribute(VacanciesPortletKeys.JOB_TITLE);
	List<CodeMasterDetails> nationalityList = (List<CodeMasterDetails>)request.getAttribute("nationalityData");
	String currLocale = themeDisplay.getLocale().toString();
%>
<portlet:resourceURL var="captchaURL"/>
<liferay-ui:error key="errorMessage" message="Please select the Captcha "/>

<portlet:resourceURL var="captchaURL"/>
<portlet:actionURL var="applyVacancyForm" name="applyForVacancy"></portlet:actionURL>
<div class="row bt-white">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><liferay-ui:message key="app_for"/> <%=jobTitle %></h3>
		<aui:form id="vacancyForm" name="vacancyForm" role="form" action="<%=applyVacancyForm%>" method="post" enctype="multipart/form-data">
			<div class="row">
				<div class="col-md-12">
					<h4 class="text-primary"><liferay-ui:message key="personal_det"/></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="full_name"/></label> 
						<aui:input type="text" id="applicantName" name="applicantName" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_your_name") %>" label="" >
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="nationality"/></label> 
						<aui:select class="form-control" id="nationality" name="nationality" label="">
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
<%
				for(CodeMasterDetails nationalityDtls:nationalityList)
				{
%>
							<aui:option value="<%=(currLocale.equals("en_US"))?nationalityDtls.getCodeDesc():nationalityDtls.getCodeDescAr()%>"><%=(currLocale.equals("en_US"))?nationalityDtls.getCodeDesc():nationalityDtls.getCodeDescAr()%></aui:option>
<%
				}
%>
						</aui:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group has-feedback">
						<label class="control-label"><liferay-ui:message key="dob_h"/></label> 
						<aui:input type="text" id="appDOB_H" name="appDOB_H" class="form-control" readonly="readonly" placeholder="12/12/1411" label="" title="">
						</aui:input>
						<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="address"/></label> 
						<aui:input type="text" id="address" name="address" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_your_add") %>" label="" title=""/>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="gender"/></label>
						<aui:select class="form-control" id="gender" name="gender" label="" title="">
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "male")%>"><liferay-ui:message key="male"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "female")%>"><liferay-ui:message key="female"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "other")%>"><liferay-ui:message key="other"/></aui:option>
						</aui:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="marital_status"/></label>
							<aui:select class="form-control" id="maritalStatus" name="maritalStatus" label="" title="" >
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "single")%>"><liferay-ui:message key="single"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "married")%>"><liferay-ui:message key="married"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "other")%>"><liferay-ui:message key="other"/></aui:option>
						</aui:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="phone"/></label> 
						<aui:input type="text" id="phone" name="phone" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_your_phone")%>" label="" title="" >
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="email_address"/></label> 
						<aui:input type="email" id="mail" name="mail" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_your_email")%>" label="" title="">
						</aui:input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="text-primary"><liferay-ui:message key="qualifications"/></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="highest_deg"/></label>
						<aui:select	class="form-control" id="highestDegree" name="highestDegree" label="" title="" >
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "high_school")%>"><liferay-ui:message key="high_school"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "diploma")%>"><liferay-ui:message key="diploma"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "bachelors")%>"><liferay-ui:message key="bachelors"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "masters")%>"><liferay-ui:message key="masters"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "phd")%>"><liferay-ui:message key="phd"/></aui:option>
						</aui:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="major"/></label> 
						<aui:input type="text" id="major" name="major" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_your_major")%>" label="" title="">
						</aui:input>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<div class="form-group">
						<aui:input cssClass="control-label" id="ifceFlag" name="ifceFlag" type="checkbox" value="" label="<%=LanguageUtil.get(request, "ifce_certified")%>" title="" ></aui:input>
					</div>					
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="text-primary"><liferay-ui:message key="experience"/></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="years_exp"/></label>
						<aui:input type="text" id="yearsExp" name="yearsExp" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_years")%>" label="" title="">
						</aui:input>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="current_emp"/></label>
						<aui:input type="text" id="currentEmp" name="currentEmp" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_curr_emp")%>" label="" title="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="curr_pos"/></label> 
						<aui:input type="text" id="currentPos" name="currentPos" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_curr_pos")%>" label="" title="" />
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="curr_salary"/></label>
						<aui:input type="text" id="salary" name="salary" class="form-control" placeholder="<%=LanguageUtil.get(request, "enter_curr_salary_sar")%>" label="" title="" />
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<h4 class="text-primary"><liferay-ui:message key="skills"/></h4>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="pro_eng_lang"/></label>
						<aui:select class="form-control" id="enProficiency" name="engProficiency" label="" title="" >
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "beginner")%>"><liferay-ui:message key="beginner"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "intermediate")%>"><liferay-ui:message key="intermediate"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "fluent")%>"><liferay-ui:message key="fluent"/></aui:option>
						</aui:select>
					</div>
				</div>
				<div class="col-md-6">
					<div class="form-group">
						<label class="control-label"><liferay-ui:message key="computer_skills"/></label> 
						<aui:select class="form-control" id="computerSkills" name="computerSkills" label="" title="">
							<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "beginner")%>"><liferay-ui:message key="beginner"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "intermediate")%>"><liferay-ui:message key="intermediate"/></aui:option>
							<aui:option value="<%=LanguageUtil.get(request, "advanced")%>"><liferay-ui:message key="advanced"/></aui:option>
						</aui:select>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					<div class="form-group has-feedback">
						<label class="control-label"><liferay-ui:message key="resume"/></label> 
						<input id="selectedFile" name="<portlet:namespace/>selectedFile" class="form-control" placeholder='<liferay-ui:message key="sel_file_loc" />' onclick="$('#<portlet:namespace/>idFile').click();">  
						<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"></span>
						<aui:input type="file" name="idFile" id="idFile" cssClass="sr-only" label="" title="">
							<aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
								function(val,node,junction){
									var fileInput = document.getElementById("<portlet:namespace/>idFile");
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
				<div class="col-md-6 col-lg-6 col-sm-6 col-xs-12">
					<div class="form-group"> 
						<label class="checkbox-inline" for="<portlet:namespace/>sendCopyCB">												 
							<input type="checkbox" id="<portlet:namespace/>sendCopyCB" name="<portlet:namespace/>sendCopyCB" class="form-check-input" />
							<liferay-ui:message key="send_copy" />
						</label> 
					</div>											 
				</div>
			</div>
			<div class="row">
				<div class="col-md-12 text-right no-pad">
				<liferay-captcha:captcha url="<%=captchaURL%>" />
					<ul class="list-btns">
						<li><a class="btn btn-lg btn-xs-block btn-link text-muted" role="button" onclick="window.history.go(-1); return false;"> 
						<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
						</a>
						</li>
						<li>
							<button type="button" id="submitBtn" class="btn btn-primary btn-lg btn-xs-block"><liferay-ui:message key="submit"/></button>
						</li>
					</ul>
				</div>
			</div>
			<input type="hidden" value="<%=jobTitle%>" name="<portlet:namespace/>jobTitle"></input>
		</aui:form>
	</div>
</div>
<aui:script  use="liferay-util-window,liferay-portlet-url">

$("#<portlet:namespace/>appDOB_H").calendarsPicker({
	calendar: $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ?"": ",'ar'" %>),
	dateFormat: 'dd/mm/yyyy',
	yearRange: '-100:1439',
	<%= currLocale.equals("en_US") ?"": "isRTL: true," %>
	onClose: function(dates){
		var zDate = $('#<portlet:namespace/>appDOB_H').val().split("/"); 				
	}
});
document.getElementById('<portlet:namespace/>idFile').onchange = function () {
	document.getElementById('selectedFile').value =  this.files.item(0).name; 
};
var frmValidator;

$("#submitBtn").on('click', function(){	
	if (frmValidator)
		frmValidator.resetAllFields();
	Liferay.Form._INSTANCES._ATMCVacanciesForm_vacancyForm.formValidator.validate();
	var uploadSize=true;
	var fileInput = document.getElementById("<portlet:namespace/>idFile");
	var fileName = "";
		if(fileInput.files.length>0)
			fileName = fileInput.files.item(0).name;
	var size=0;
	if(fileInput.files.length>0)
	{
		for(var num1=0;num1<fileInput.files.length;num1++)
	    {
			var file=fileInput.files[num1];
			if(file.size>10485760)
			{
				fileInput.focus();
				uploadSize=false;
			}
			else
			{
				uploadSize=true;
			}
			
			size+=file.size;
		}
	}	
	AUI().use('aui-form-validator',
	    function(A) {
	    	 A.mix(A.config.FormValidator.RULES,{
	             customRuleForNationality:function(val, fieldNode, ruleValue) {
                    return (val != "-1");
                 },
                 customRuleForGender:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
                 },
                 customRuleForMaritalStatus:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
	    	   	 },
	    	   	 customRuleForHighestDegree:function(val, fieldNode, ruleValue) {
               	 return (val != "-1");
	    	   	 },
	    	   	 customRuleForComputerSkills:function(val, fieldNode, ruleValue) {
	               	 return (val != "-1");
	    	   	 },
	    	   	 customRuleForEnProficiency:function(val, fieldNode, ruleValue) {
	               	 return (val != "-1");
	    	   	 },
	    	   	 uploadFileSize:function(val, fieldNode, ruleValue){
	    	   		if(uploadSize)
	    	   			return true;
	    	   		else
	    	   			return false;
	    	   	 },
	    	   	 checkFileName:function(val, fieldNode, ruleValue){
	    	   	  	var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
	    	   	 	return regex.test(fileName);
	    	   	 },
	    	   	 checkMobile:function(val, fieldNode, ruleValue){
	    	 		var allowedCharacters = '05';
	    			var regex = new RegExp('(^05)([0-9]{8})');
	    			return regex.test(val);
	    	   	 }
                },
	            true
	         );
             A.mix(A.config.FormValidator.STRINGS,
               {
            	customRuleForNationality:'<liferay-ui:message key="customRuleForNationality"/>',
               	customRuleForGender:'<liferay-ui:message key="customRuleForGender"/>',
               	customRuleForMaritalStatus:'<liferay-ui:message key="customRuleForMaritalStatus"/>',
               	customRuleForHighestDegree:'<liferay-ui:message key="customRuleForHighestDegree"/>',
               	customRuleForComputerSkills: '<liferay-ui:message key="customRuleForComputerSkills"/>',
               	customRuleForEnProficiency: '<liferay-ui:message key="customRuleForEnProficiency"/>',
               	uploadFileSize:'<liferay-ui:message key="uploadFileSize"/>',
               	checkFileName:'<liferay-ui:message key="checkFileName"/>',
               	checkMobile:'<liferay-ui:message key="checkMobile"/>'
               },
               true
              );
	                         
          var rules = {
   			    <portlet:namespace/>nationality: {
   			    	customRuleForNationality: true
   			    },
   				<portlet:namespace/>gender: {
   					customRuleForGender: true
   			    },
   				<portlet:namespace/>maritalStatus: {
   					customRuleForMaritalStatus: true
   			    },
   			    <portlet:namespace/>highestDegree: {
   			    	customRuleForHighestDegree: true
   			    },
   			    <portlet:namespace/>selectedFile: {
   			    	required:true,
   			    	acceptFiles:'pdf,doc,docx',
   			    	uploadFileSize: true,
   			    	checkFileName:true
   			    },
   			 	<portlet:namespace/>computerSkills: {
   			 		customRuleForComputerSkills: true
   			 	},
   			 	<portlet:namespace/>engProficiency:{
   			 		customRuleForEnProficiency: true
   			 	},
   			    <portlet:namespace/>appDOB_H:{
   			 		required:true
   			 	},
   			    <portlet:namespace/>applicantName:{
   				 required:true
   			 	},
   			 	<portlet:namespace/>phone:{
   					required:true,
   					number:true,
   					rangeLength:[10,10],
   					checkMobile:true
   					
   			 	},
   			 	<portlet:namespace/>mail:{
   			 		required:true,
   			 		email:true
   			 	},
   			    <portlet:namespace/>major:{
   			    	required:true 
   			 	},
   			   <portlet:namespace/>yearsExp:{
   					required:true,
			 		number:true
   			 	}
   			};

          var fieldStrings = {
        		  <portlet:namespace/>phone: {
       		    	rangeLength:"Enter a Valid Mobile Number"
   			 	}
   			};

	      frmValidator = new A.FormValidator({
	          boundingBox: "#<portlet:namespace/>vacancyForm",
	          fieldStrings: fieldStrings,
	          rules: rules,
	          validateOnBlur: false
	        });
	      
	      frmValidator.validate();
	      if(!frmValidator.hasErrors())
    	  {
    	 		$("#<portlet:namespace/>vacancyForm").submit();
    	  }
	    });
});
</aui:script>