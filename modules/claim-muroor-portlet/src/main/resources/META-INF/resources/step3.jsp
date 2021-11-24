<%@page import="com.ejada.atmc.bsl.db.domain.quotation.CustomerMapDetails"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>
<%@taglib prefix="e" uri="https://www.owasp.org/index.php/OWASP_Java_Encoder_Project" %>

<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>

<%
	String[] plateLettersEn = {"A","B","D","E","G","H","J","K","L","N","R","S","T","U","V","X","Z"};
	String[] plateLettersAr = {"A","B","J","D","R","S","X","T","E","G","K","L","Z","N","H","U","V"};
	
	String currLocale = themeDisplay.getLocale().toString();
	List<CodeMasterDetails> citiesList = (List<CodeMasterDetails>) request.getAttribute("citiesList");
	List<CustomerMapDetails> insCompanies = (List<CustomerMapDetails>) request.getAttribute("insCompanies");
	
	boolean tpFlag = (Boolean) request.getAttribute("TP_TYPE_FLAG");
	boolean isBack = false;
	if(request.getAttribute("IS_BACK")!=null)
	{
		isBack = (Boolean) request.getAttribute("IS_BACK");
	}
	String selectedCity = "";
	String description = "";
	int selectedPercent =-1;
	String insComp="";
	String accidentTime="";
	String accidentDate = "";
	String timeGroup = "";
	String vehIdent = "";
	String plateLetter1="";
	String plateLetter2="";
	String plateLetter3="";
	String plateNo = "";
	
	if(isBack)
	{
		selectedCity = (String) request.getAttribute("SelectedCity");
		description = (String) request.getAttribute("Description");
		selectedPercent = (int) request.getAttribute("FaultPercent");
		insComp =(String) request.getAttribute("InsuranceCompany");
		accidentTime = (String) request.getAttribute("AccidentTime");
		accidentDate = (String) request.getAttribute("AccidentDate");
		timeGroup = (String) request.getAttribute("TimeGroup");
		if(tpFlag)
		{
			vehIdent = (String) request.getAttribute("VehIdentification"); 
			String[]data = vehIdent.split("-");
			
			plateLetter1 = data[0];
			plateLetter2 = data[1];
			plateLetter3 = data[2];
			
			plateNo = data[3];
		}
	}
%>

<portlet:actionURL name="applyDriverInfo" var="applyDriverInfo">
	<portlet:param name="isBack" value="true"/>
	<portlet:param name="myview" value="step2"/>
</portlet:actionURL>

<portlet:actionURL name="backToLanding" var="backToLanding">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>

<form id="driverInfoBackForm" name="driverInfoBackForm" role="form" action="<%=tpFlag?applyDriverInfo:backToLanding %>" method="post">
</form>

<portlet:actionURL var="applyAccidentInfo" name="applyAccidentInfo">
	<portlet:param name="myview" value="review"/>
</portlet:actionURL>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><liferay-ui:message key="report_claim"/></h3>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<%
			if(tpFlag)
			{
		%>
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="66" aria-valuemin="0" aria-valuemax="100" style="width: 66%;">
				<span class="sr-only">66% Complete</span>
			</div>
		</div>
		<%
			}
			else
			{
		%>	
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="50" aria-valuemin="0" aria-valuemax="100" style="width: 50%;">
				<span class="sr-only">50% Complete</span>
	</div>
</div>
		<%
			}
		%>	
	</div>
</div>

<div class="row">
	<div class="col-xs-12 col-sm-12 col-lg-8 col-lg-offset-2 col-md-10 col-md-offset-1">
		<div class="portlet-content">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1">
				<%
					if(tpFlag)
					{
				%>
					<ul class="nav nav-pills nav-stacked nav-justified">
						<li>
							<a class="text-primary" href="#"><i class="icon icon-transport-1 md-36"></i> <liferay-ui:message key="drv_info"/></a>
						</li>
						<li>
							<a href="#"><i class="icon icon-transport md-36"></i> <liferay-ui:message key="veh_acc_info"/> </a>
						</li>
						<li class="disabled">
							<a href="#"><i class="icon icon-list md-36"></i> <liferay-ui:message key="appr_accpt"/></a>
						</li>
					</ul>								 
				<%
					}
					else
					{
				%>	
						<ul class="nav nav-pills nav-stacked nav-justified">
							<li>
								<a class="text-primary" href="#"><i class="icon icon-transport md-36"></i><liferay-ui:message key="acc_parts"/></a>
							</li>
							<li class="disabled">
								<a href="#"><i class="icon icon-business-3 md-36"></i> <liferay-ui:message key="app_rev"/></a>
							</li>
						</ul>
				<%
					}
				%>							 
				</div>
			</div>
			<div class="row">
			<aui:form role="form" id="vehicleInfoForm" name="vehicleInfoForm" action="<%=applyAccidentInfo%>" method="post" >
			<liferay-ui:error key="claims_error_nopolicy" message="claims_error_nopolicy" />
			<liferay-ui:error key="claims_error_nopolicyveh" message="claims_error_nopolicyveh" />
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-10 col-lg-offset-1"> 
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="city_loc"/></label>
								<aui:select id="city" name="city" label="" onchange="updateCityName();">
								<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
					<%
							for(CodeMasterDetails cityDtls: citiesList)
							{
								boolean hasCity= (isBack && selectedCity!="" && selectedCity.equals(cityDtls.getCodeSub()));
					%>
					
									<aui:option selected="<%=hasCity%>" value="<%=cityDtls.getCodeSub()%>"><%=(currLocale.equals("en_US"))?cityDtls.getCodeDesc():cityDtls.getCodeDescAr()%></aui:option>
									
					<%
							}
					%>			
								</aui:select>
								<input id="cityName" name="<portlet:namespace/>cityName" type="hidden">
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
								<label class="control-label"><liferay-ui:message key="acc_date"/></label>
								<aui:input type="text" id="accidentDate" name="accidentDate" class="form-control" placeholder="dd/mm/yyyy" label="" value='<%=isBack?accidentDate:"" %>'>
								</aui:input>
								<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="acc_time"/></label>
								<div class="row">
									<div class="col-md-8 col-xs-8">
										<aui:input class="form-control" id="accidentTime" name="accidentTime" label="" type="text" placeholder="12:59" value='<%=isBack?accidentTime:"" %>' >
										</aui:input>
									</div>
									<div class="col-md-2 col-xs-2">
										<label class="radio-inline control-label"> 
										<input type="radio" name="<portlet:namespace/>group" value="PM" <%=(isBack&&timeGroup.equals("PM"))?"checked":""%>>PM</label>
									</div>
									<div class="col-md-2 col-xs-2">
										<label class="radio-inline control-label"> 
										<input type="radio" name="<portlet:namespace/>group" value="AM" <%=(isBack&&timeGroup.equals("PM"))?"":"checked"%>>AM</label>
									</div>
								</div>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="perc_resp_applicant"/></label>
								<aui:select class="form-control" name="faultpercent" id="faultpercent" label=""> 
									<aui:option selected="<%= (selectedPercent == -1)%>" value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
									<aui:option selected="<%= (selectedPercent == 0)%>" value="0">0%</aui:option>
									<aui:option selected="<%= (selectedPercent == 25)%>" value="25">25%</aui:option>
									<aui:option selected="<%= (selectedPercent == 50)%>" value="50">50%</aui:option>												 
									<aui:option selected="<%= (selectedPercent == 75)%>" value="75">75%</aui:option>												 
									<aui:option selected="<%= (selectedPercent == 100)%>" value="100">100%</aui:option>																		 
								</aui:select>
							</div>
						</div>
					</div>
<%
			if(tpFlag)
			{
%>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="atmc_plate_no"/></label>
								<aui:input class="form-control" type="text" id="plateNo" name="plateNo" label="" placeholder="Please Enter English Plate No" value="<%=plateNo %>" >
								</aui:input>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="claims_vehicle_plate_letters"/></label>
								<div class="row">
															
									<%
										for (int i=1; i <= 3; i++)
										{
											String selectName = "plateL" + i;
									%>
									<div class="col-md-4">
										
									<c:choose>
										<c:when test="<%= currLocale.equals("en_US") %>">
											<aui:select cssClass="form-control" name="<%=selectName %>" label="">
											<%
												for(int x=0;x<plateLettersEn.length;x++)
												{
													boolean selectedFlag = false;
													if(isBack)
													{
														if(selectName.equals("plateL1") && plateLetter1.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersEn[x])))
															selectedFlag = true;
														if(selectName.equals("plateL2") && plateLetter2.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersEn[x])))
															selectedFlag = true;
														if(selectName.equals("plateL3") && plateLetter3.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersEn[x])))
															selectedFlag = true;
													}
											%>
													<aui:option selected="<%=selectedFlag %>" value="<%=LanguageUtil.get(request,"plate_letter_"+plateLettersEn[x]) %>"><%=LanguageUtil.get(request,"plate_letter_"+plateLettersEn[x]) %></aui:option>
											<%
												}
											%>
											</aui:select>
										</c:when>
										<c:otherwise>
											<aui:select cssClass="form-control" name="<%=selectName %>" label="">
											<%
												for(int x=0;x<plateLettersAr.length;x++)
												{
													boolean selectedFlag = false;
													if(isBack)
													{
														if(selectName.equals("plateL1") && plateLetter1.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersAr[x])))
															selectedFlag = true;
														if(selectName.equals("plateL2") && plateLetter2.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersAr[x])))
															selectedFlag = true;
														if(selectName.equals("plateL3") && plateLetter3.equals(LanguageUtil.get(request,"plate_letter_"+plateLettersAr[x])))
															selectedFlag = true;
													}
											%>
													<aui:option selected="<%=selectedFlag %>" value="<%=LanguageUtil.get(request,"plate_letter_"+plateLettersAr[x]) %>"><%=LanguageUtil.get(request,"plate_letter_"+plateLettersAr[x]) %></aui:option>
											<%
												}
											%>
											</aui:select>
										</c:otherwise>
									</c:choose>
									</div>
									<% 
										}
									%>
								</div>
							</div>
						</div>
					</div>
					
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="applic_ins_co"/></label>
								<aui:select class="form-control" id="insuranceCompany" name="insuranceCompany" label=""  onchange="updateCompanyName();"> 
								<aui:option value="-1">Please select</aui:option> 

								<%
									for(CustomerMapDetails insuranceCompany : insCompanies)
									{
										boolean selectedFlg = ( isBack && insComp!="" && insComp.equals(insuranceCompany.getCode()));
								%>
								
										<aui:option class="option" selected="<%=selectedFlg%>" value="<%=insuranceCompany.getCode()%>"><%=(currLocale.equals("en_US"))?insuranceCompany.getName():insuranceCompany.getNameAr()%></aui:option>
								<%
									}
								%>
								
								</aui:select>
								<input id="companyName" name="<portlet:namespace/>companyName" type="hidden">
							</div>
						</div>
					</div>
<%
			}
%>
					<div class="row">
						<div class="col-sm-12 col-md-12 col-lg-12 col-xs-12">
							<div class="form-group">
								<label class="control-label"><liferay-ui:message key="acc_desc"/></label>
								<aui:input type="textarea" class="form-control" id="accidentDesc" name="accidentDesc" label="" rows="3" value='<%=isBack?description:"" %>'>
									<aui:validator name="required"  />
									<e:forHtmlContent value="${param.value}" />
								</aui:input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-right no-pad">
							<ul class="list-btns">
								<li>
									<button class="btn btn-lg text-muted btn-xs-block btn-link" type="button" onclick="$('#driverInfoBackForm').submit();"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back"/> </button>
								</li>
								<li>
									<button class="btn btn-primary btn-lg btn-xs-block" type="button" id="submitBtn"><liferay-ui:message key="continue"/> </button>
								</li>
							</ul>
						</div>
					</div>
				</div>
				</aui:form>
			</div>						 
		</div>
	</div>
</div>

<script>
$("#<portlet:namespace/>accidentDate").calendarsPicker({
	calendar: $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>),
	dateFormat: 'dd/mm/yyyy',
	maxDate: 0,
	<%= currLocale.equals("en_US") ? "":"isRTL: true," %>
	onClose: function(dates){
		var zDate = $("#<portlet:namespace/>accidentDate").val().split("/"); 
	}
});

function updateCityName()
{
	$("#cityName").val($("#<portlet:namespace/>city option:selected").text());
}

function updateCompanyName()
{
	$("#companyName").val($("#<portlet:namespace/>insuranceCompany option:selected").text());
}

updateCityName();
updateCompanyName();
</script>

<aui:script>
var frmValidator;
$("#submitBtn").on('click', function(){	
	if (frmValidator)
		frmValidator.resetAllFields();
	
	AUI().use('aui-form-validator',
	    function(A) {
	    	 A.mix(A.config.FormValidator.RULES,{
	             customRuleForCity:function (val, fieldNode, ruleValue) {
						return (val != '-1');
				 },
                 customRuleForPercentage:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
                 },
                 customRuleForInsurance:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
	    	   	 },
	    	   	 customRuleForTime: function(val, fieldNode, ruleValue) {
                     var regex = /^(([01][0-2]|0?[1-9]):([0-5][0-9]))/;
                     return regex.test(val);
                }
               },
	           true
	         );
             A.mix(A.config.FormValidator.STRINGS,
               {
            	customRuleForCity:"Please select city",
            	customRuleForPercentage:"Please select percentage of responsibility",
            	customRuleForInsurance:"Please select insurance company",
            	customRuleForTime:"Please insert valid Time"
               },
               true
              );
	                         
          var rules = {
   			    <portlet:namespace/>city: {
   			    	customRuleForCity: true
   			    },
   				<portlet:namespace/>faultpercent: {
   					customRuleForPercentage: true
   			    },
   				<portlet:namespace/>insuranceCompany: {
   					customRuleForInsurance: true
   			    },
   			    <portlet:namespace/>accidentTime: {
   			    	customRuleForTime: true
   			    },
   			    <portlet:namespace/>accidentDate:{
   			 		required:true
   			 	}
   			};

          var fieldStrings = {
   			};

	      frmValidator = new A.FormValidator({
	          boundingBox: "#<portlet:namespace/>vehicleInfoForm",
	          fieldStrings: fieldStrings,
	          rules: rules,
	          validateOnBlur: false
	        });
	      
	      frmValidator.validate();
	      if(!frmValidator.hasErrors())
    	  {
    	 		$("#<portlet:namespace/>vehicleInfoForm").submit();
    	  }
	    });
});
</aui:script>