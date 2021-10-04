<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page
	import="com.ejada.atmc.acl.db.service.CodeMasterMapLocalServiceUtil"%>
<%@page import="com.ejada.atmc.acl.db.model.CodeMasterMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.google.gson.GsonBuilder"%>
<%@page import="com.google.gson.JsonArray"%>
<%@page import="java.util.List"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>

<%@ include file="init.jsp"%>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/typeahead/bootstrap3-typeahead.js"></script>
<link rel="stylesheet" type="text/css"
	href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript"
	src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<style>
.col-3, .col-xs-3 {
    float: left !important;
    width: 23% !important;
    flex: 0 0 30% !important;
    max-width: 25% !important;
}
</style>
<%
	String manufactList = (String) request.getAttribute("manufactDataJson");
	String manufactMap = (String) request.getAttribute("manufactMapJson");
	List<CodeMasterDetails> manufacturerList = (List<CodeMasterDetails>) request
			.getAttribute("manufacturerList");
	Log _log = LogFactoryUtil.getLog(this.getClass());
	
	List<CodeMasterDetails> codeMasterList = (List<CodeMasterDetails>) request.getAttribute("bodyListData");
	String currLocale = themeDisplay.getLocale().toString();
	List dedVals = (List) request.getAttribute("dedVals");
%>

<portlet:actionURL var="applyQuickQuote" name="applyQuickQuote">
	<portlet:param name="myview" value="quick_quote_result" />
</portlet:actionURL>

<form id="quickQuoteForm" method="post" action="<%=applyQuickQuote%>">
	<div class="middle-wrap" style="position: relative; width: 200%;">
		<div class="pull-left inner-wrap has-error"
			style="width: 50%; padding: 5px;">
			<h2>
				<liferay-ui:message key="start_now" />
			</h2>
			<p>
				<liferay-ui:message key="best_insurance_ksa" />
			</p>
			<div class="quickquot-input-group input-group form-group"
				style="width: 50%; height:2.375rem">
				<div class="input-group-addon bt-white">
					<span class="icon icon-transport-3"></span>
					<liferay-ui:message key="motor" />
				</div>
				<input type="text" class="typeahead form-control" autocomplete="off"
					name="<portlet:namespace/>manufactName" id="query" style="height:100%" 
					placeholder='<liferay-ui:message key="enter_manufacturer"/>'>
				<div class="input-group-addon btn" onclick="validateForm();">
					<i class="material-icons md-36">&#xE315;</i>
				</div>
			</div>
			<br />
		</div>
		<div class="error_container"></div>
		<div class="pull-left vcenter inner-wrap"
			style="width: 50%; padding: 5px; padding-left: 0px !important;">
			<div class="pull-left" style="width: 10%">
				<div class="btn btn-link" onclick="backToStep1();">
					<i class="material-icons md-36">&#xE314;</i>
				</div>
			</div>
			<div class="col-xs-12 form-input-validation">
				<div class="pull-left col-xs-3">
					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>bodyType"
							id="bodyType">
							<option value="-1"><liferay-ui:message key="body_type" /></option>
							<%
								for (CodeMasterDetails codeMasterDtls : codeMasterList) {
							%>
							<option value="<%=codeMasterDtls.getCodeSub()%>"><%=(currLocale.equals("en_US")) ? codeMasterDtls.getCodeDesc() : codeMasterDtls.getCodeDescAr()%></option>

							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>year"
							id="year">
							<option value="-1"><liferay-ui:message
									key="manufacture_year" /></option>
							<%
								Calendar cal = new GregorianCalendar();
								cal.setTime(new Date());
								for (int yCount = 0; yCount < 11; yCount++) {
									int year = cal.get(Calendar.YEAR);
									cal.add(Calendar.YEAR, -1);
							%>
							<option value="<%=year%>"><%=year%></option>
							<%
								}
							%>
							<option value="2020"><liferay-ui:message
									key="above-10-yrs" /></option>
						</select>
					</div>

					<div class="form-group">
						<input type="text" class="form-control"
							placeholder='<liferay-ui:message key="veh_val_opt"/>'
							name="<portlet:namespace/>vehicleValue" id="vehicleValue">
					</div>

				</div>

				<div class="col-xs-3">
					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>ncd"
							id="ncd">
							<option value="-1"><liferay-ui:message
									key="driver-N.C.D" /></option>
							<option value="0">0%</option>
							<option value="1">10%-15%</option>
							<option value="2">20%-25%</option>
							<option value="3">30%-35%</option>
							<option value="4">40%-50%</option>
							<option value="5">50%-60%</option>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>region"
							id="region">
							<option value="-1"><liferay-ui:message key="region" /></option>
							<option value="RIYADH"><liferay-ui:message key="riyadh" /></option>
							<option value="SUDUS"><liferay-ui:message key="central" /></option>
							<option value="ARDAH"><liferay-ui:message key="eastern" /></option>
							<option value="AMIRAH"><liferay-ui:message key="western" /></option>
							<option value="AMRAT"><liferay-ui:message key="northern" /></option>
							<option value="ADAMAN"><liferay-ui:message
									key="southern" /></option>
						</select>
					</div>

					<div class="form-group">
						<select class="form-control"
							name="<portlet:namespace/>maritalStatus" id="maritalStatus">
							<option value="-1"><liferay-ui:message
									key="marital_status" /></option>
							<option value="1"><liferay-ui:message
									key="status_married" /></option>
							<option value="2"><liferay-ui:message
									key="status_unmarried" /></option>
							<%-- <option value="3"><liferay-ui:message key="status_widowed"/></option>
						<option value="4"><liferay-ui:message key="status_divorced"/></option>
						<option value="5"><liferay-ui:message key="status_seperated"/></option> --%>
							<option value="6"><liferay-ui:message
									key="status_others" /></option>
						</select>
					</div>


				</div>

				<div class="col-xs-3">

					<div class="form-group">
						<input type="number" class="form-control"
							name="<portlet:namespace/>driverAge" id="driverAge"
							placeholder="<%=LanguageUtil.get(request, "drivers_age")%>">
					</div>
					<div class="form-group">
						<select class="form-control"
							name="<portlet:namespace/>najmPlateType" id="najmPlateType">
							<option value="-1"><liferay-ui:message key="purpose_veh" /></option>
							<option value=414><liferay-ui:message key="Private-Car" /></option>
							<option value=413><liferay-ui:message
									key="Private-Transport" /></option>
						</select>
					</div>



					<input type="hidden" class="form-control"
						name="<portlet:namespace/>manufactMap" id="manufactMap" value="">

				</div>
				<div class="col-xs-3">

					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>dedValue"
							id="dedValue">
							<option value="-1" selected><liferay-ui:message
									key="ded_val" /></option>
							<%
								for (int pCount = 0; dedVals != null && pCount < dedVals.size(); pCount++) {
									CodeMasterDetails dVal = (CodeMasterDetails) dedVals.get(pCount);
									_log.info("" + dVal.getCodeDesc());
							%>
							<option value="<%=dVal.getCodeSub()%>"><%=dVal.getCodeDesc()%>
								SAR
							</option>
							<%
								}
							%>
						</select>
					</div>
					<div class="form-group">
						<select class="form-control" name="<portlet:namespace/>gender"
							id="gender">
							<option value="-1"><liferay-ui:message
									key="driver_gender" /></option>
							<option value="1"><liferay-ui:message
									key="driver-gender-m" /></option>
							<option value="2"><liferay-ui:message
									key="driver-gender-f" /></option>
						</select>
					</div>

					<button type="submit" class="btn btn-lg btn-primary pull-right"
						style="width: 176px;" onclick="validateStep2();">
						<liferay-ui:message key="get_price" />
					</button>
				</div>


			</div>
		</div>
	</div>
	<p style="font-size: 10px;">
		<a href="https://www.najm.sa/en/InsuranceRecords" target="_blank"><liferay-ui:message
				key="najm_website_link" /> </a>
	</p>
</form>


<script>
$(document).ready(function(){
	var manufactData = <%=manufactList%>;
	$('#query').typeahead({        
	    source: manufactData,
	    fitToElement:true
	});
});

var manufactMap = '<%=manufactMap%>';
var makeMap=JSON.parse(manufactMap);
var local = "<%=currLocale%>";

	function backToStep1() {
		if (local == "en_US") {
			$(".middle-wrap").animate({
				left : "0"
			});
		} else {
			$(".middle-wrap").animate({
				right : "0"
			});
		}
	}
</script>

<aui:script>

var frmValidator;
var frmValidator2;
function validateForm()
{
	AUI().use('aui-form-validator',function(A) {
		
		A.mix(A.config.FormValidator.RULES,
			{
		        fullNameManufacture: function(val, fieldNode, ruleValue){
		        	var enteredText  = $(".typeahead.form-control").val();
					  var selectedLi = $(".typeahead.dropdown-menu li.active");
					  if(selectedLi.hasClass('active') && enteredText == selectedLi.text())
					  	return true;
					  else 
						  return false;
				}
			},
		    true
		);
		var rules = {
				<portlet:namespace />manufactName: {
			       required: true,
			       fullNameManufacture:true
			    }
			};

		var fieldStrings = {
			 <portlet:namespace />manufactName: {
		       required: "A manufacturer must be selected."
		     }
		};
		
		if (typeof frmValidator === 'undefined' || frmValidator === null) 
		{
	    	frmValidator = new A.FormValidator(
	         {
	          boundingBox: "#quickQuoteForm",
	          fieldStrings: fieldStrings,
	          rules: rules,
	          fieldContainer: ".error_container"
	         });
		}
	      
	      frmValidator.validate();
		  if(!frmValidator.hasErrors()){
			  var manufactName = $("#query").val();
			  var codeSub = makeMap[manufactName];
			  
			  $("#manufactMap").val(codeSub);
			  
			  if(local == "en_US")
				{
					$(".middle-wrap").animate({left: "-102%"});
				}
				else
				{
					$(".middle-wrap").animate({right: "-102%"});
				}
		  }
	    });
}
	
function validateStep2()
{		
	AUI().use('aui-form-validator', function(A) {
	    	 A.mix(A.config.FormValidator.RULES,{
	             customRuleForYear:function(val, fieldNode, ruleValue) {
                    return (val != "-1");
                 },
                 customRuleForBodyType:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
                 },
                 customRuleFornajmPlateType:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
                 },
                 customRuleForgender:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
                 },
                 customRuleForRegion:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
	    	   	 },
	    	   	 customRuleFordedValue:function(val, fieldNode, ruleValue) {
                	 return (val != "-1");
	    	   	 },
	    	   	customRuleForncd:function(val, fieldNode, ruleValue) {
               	 return (val != "-1");
	    	   	 }
                },
	            true
	         );
             A.mix(A.config.FormValidator.STRINGS,
               {
            	customRuleForYear:"Year must be selected.",
               	customRuleForBodyType:"Body Type must be selected.",
               	customRuleFornajmPlateType:"Najm Plate Type must be selected.",
               	customRuleForgender:"Gender Must Be selected",
               	customRuleForRegion:"Region must be selected.",
               	customRuleFordedValue:"Deductible Must Be Selected",
               	customRuleForncd:"NCD Must Be Selected"
               },
               true
              );
	                         
          var rules = {
   			 <portlet:namespace />region: {
   					customRuleForRegion: true,
			    	required: true,
			    },
   				<portlet:namespace />year: {
   					customRuleForYear: true
   			    },
   				<portlet:namespace />najmPlateType: {
					customRuleFornajmPlateType: true
			    },
			    <portlet:namespace />gender: {
			    	customRuleForgender: true
			    },
   			 	<portlet:namespace />bodyType: {
   					customRuleForBodyType: true
   			    },
   			 	<portlet:namespace />ncd: {
    				customRuleForncd: true
 			    },
 			   <portlet:namespace />dedValue: {
  					customRuleFordedValue: true,
			    	
			    },
   			    <portlet:namespace />driverAge: {
   			    	required: true,
   			    	number:true,
   			    	min: 16,
   			    	rangeLength: [2,2]
   			    },
   			 	<portlet:namespace />vehicleValue: {
   			 		number:true
   			 	}
   			};

          var fieldStrings = {
        		  <portlet:namespace />driverAge: {
      		    	required: "Driver's Age must be entered.",
      		    	min: "Driver's Age must be 16 or above.",
      		    	rangeLength: "Enter a Valid Age"
      		    }
       		};
	        if (typeof frmValidator2 === 'undefined' || frmValidator2 === null) 
	  		{
		      frmValidator2 = new A.FormValidator({
		          boundingBox: "#quickQuoteForm",
		          fieldStrings: fieldStrings,
		          rules: rules
		        });
	  		}
	      
	      frmValidator2.validate();
	      
	    });
}	
</aui:script>