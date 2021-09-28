<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.exception.UserEmailAddressException"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.quotation.QuotationCover"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="java.util.Calendar"%>
<%@ include file="/init.jsp"%> 
<%
	Quotation quot = (Quotation)request.getAttribute("quot");
	List coversList = (List)request.getAttribute("coverList");
	
	boolean isBack = ParamUtil.getBoolean(request, "isBack");
	if(Validator.isNotNull(quot) && quot.isRenew())
		isBack = true;
	List dedVals = (List)request.getAttribute("dedVals");
	Gson gson = new Gson();
	String quotDets = gson.toJson(quot);
	quotDets = quotDets.replaceAll("\"", "'");
	int maxPremLimit = Integer.valueOf(PropsUtil.get("com.ejada.atmc.buymotor.maxPremLimit")); 
%>
<portlet:actionURL name="vehicleInfo" var="vehicleInfo">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>
<form id="vehicleInfoBackForm" name="vehicleInfoBackForm" role="form" action="<%=vehicleInfo %>" method="post">
	<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
	<input type="hidden" name="<portlet:namespace/>myview" value="vehicle_info"/>
</form>
<portlet:actionURL name="quotation" var="quotation">
</portlet:actionURL>
<%
    if(Validator.isNotNull(quot)) 
    		{ %>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?LanguageUtil.get(request, "comp_product"):LanguageUtil.get(request, "tpl_product") %></h3>
	</div>
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;">
				<span class="sr-only">100% Complete</span>
			</div>
		</div>
	</div>
</div>
<div class="row bg-white">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<div class="row">
			<div
				class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
				<div class="portlet-content">
					<ul class="nav nav-pills nav-stacked nav-justified">
						<li class="disabled">
							<a class="text-primary" href="javascript:void(0);">
								<i class="icon icon-id-card md-36"></i> 
								<liferay-ui:message key="personal_info"/>
							</a>
						</li>
						<li class="disabled">
							<a href="javascript:void(0);">
								<i class="icon icon-transport-3 md-36"></i>
								<liferay-ui:message key="vehicle_info"/>
							</a>
						</li>
						<li>
							<a href="javascript:void(0);">
								<i class="icon icon-shield md-36"></i>
								<liferay-ui:message key="insurance_options"/>
							</a>
						</li>
					</ul>
				</div>
			</div>
		</div>
		<div class="row">
			<div
				class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
				<div class="portlet-content">
					<aui:form id="form3" name="form3" role="form" action="<%=quotation %>" method="post">
						<liferay-ui:error key="<%= BuyMotorPolicyPortletKeys.PAYMENT_STATUS_FAIL %>" message="Payment Error" />
						<liferay-ui:error exception="<%= UserEmailAddressException.MustNotBeDuplicate.class %>" message="the-email-address-you-requested-is-already-taken" />
						<input type="hidden" name="<portlet:namespace/>myview" value="quotation" />
						<input type="hidden" name="<portlet:namespace/>quot" value="<%=quotDets %>"/>
						<div class="row">
							<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="form-group has-feedback">
									<label class="control-label"><liferay-ui:message key="eff_date"/></label>
									<input class="form-control" type="text" readonly="readonly" placeholder="12 / 10 / 2017" id="effDate" name="<portlet:namespace/>effDate" value="<%=dmyDateFormatter.format(quot.getPolicyEffDate()) %>" data-toggle="popover" data-trigger="hover" data-html="false" data-placement="top" data-content="<liferay-ui:message key='effDate_pmt_today_placeholder'/>" <%=(quot.isRenew())?"disabled":"" %>/>
									<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-md-12">
								<h3><liferay-ui:message key="serv_covs"/></h3>
								
									<div class="panel-group cover-type-group" id="accordion">
<%
	for(int cCount=0;coversList!=null && cCount<coversList.size();cCount++)
	{
		QuotationCover cover = (QuotationCover)coversList.get(cCount);
		String checked = "";
		QuotationCover selQuotCover = null;
		if(isBack && quot.getCoversList() !=null)
		{
			for(int selCoverCount=0; selCoverCount<quot.getCoversList().size(); selCoverCount++)
			{
				QuotationCover selectedCover = quot.getCoversList().get(selCoverCount);
				String displayedCoverCode = cover.getCoverCode();
				String selectedCoverCode = selectedCover.getCoverCode();
				if(displayedCoverCode != null && displayedCoverCode.equals(selectedCoverCode))
				{
					checked = "checked";
					selQuotCover = selectedCover;
					break;
				}
			}
		}
	
%>									
										<div class="panel panel-default">
											<div class="panel-heading" role="tab">
												<h4 class="panel-title">
												<div class="value-content">
													<label class="cover-val control-label">
														<input type="checkbox" <%=checked %> name="<portlet:namespace/>coverChk" onclick="manageCoverVals($(this));"/>
														<div></div>
													</label>
<%
		if(cover.getField1()!=null && cover.getField1().equals("Y"))
		{
			String delimVals = cover.getField3();
			String defVal = cover.getField4();
			if(delimVals !=null && !delimVals.equals(""))
			{	
				String[] vals = delimVals.split("\\|");
%>
													<span class="text-primary"><%="SAR "+numberFormat.format(cover.getCoverPrem()) %></span>
													<select class="form-control" name="<portlet:namespace/>coverPrem" onchange="calculateTotalPrem();" <%=(isBack && !checked.equals(""))?"":"disabled" %>>
<%
				for(int vCount=0; vCount<vals.length;vCount++)
				{
					String currVal = vals[vCount];
					if(isBack && !checked.equals(""))
					{
						if((selQuotCover.getCoverPrem()/Long.valueOf(currVal)) == cover.getCoverPrem())
							defVal = currVal;
					}
%>												
														<option value="<%=cover.getCoverCode()+";"+cover.getCoverPrem()+";"+((currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr())+";"+cover.getSectionCode()+";"+currVal%>" <%=(currVal.equals(defVal))?"selected":"" %>><%=currVal %> <%= (cover.getCoverCode() != null && (cover.getCoverCode().equals("31051") || cover.getCoverCode().equals("31052"))) ? LanguageUtil.get(request, "month") : ""  %></option>												
<%
				}
%>

													</select>
<%
		
			}
		}
		else
		{	
%>																								
												
													<span class="text-primary"><%="SAR "+numberFormat.format(cover.getCoverPrem()) %></span>
													<input type="hidden"  name="<portlet:namespace/>coverPrem"  value="<%=cover.getCoverCode()+";"+cover.getCoverPrem()+";"+((currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr())+";"+cover.getSectionCode()%>" <%=(isBack && !checked.equals(""))?"":"disabled" %>>
<%
		}
%>												
												</div>
<%
		if(cover.getField1()!=null && cover.getField1().equals("Y"))
		{
%>
												<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" href="#accordion-<%=cCount %>" class="accordion-toggle">
													<span class="hidden-md hidden-lg" style="width: 100px;display: inline-block;"><%=(currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr() %></span>
													<span class="hidden-xs hidden-sm"><%=(currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr() %></span>
												</a> 
<%
		}
		else
		{	
%>	
												<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" href="#accordion-<%=cCount %>" class="accordion-toggle">
													<%=(currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr() %>
												</a>

<%
		}
%>						
												</h4>
											</div>
											<div class="panel-collapse collapse" id="accordion-<%=cCount %>" role="tabpanel">
												<div class="panel-body">
													<p><%=(currLocale.equals("en_US") )?cover.getCoverDesc():cover.getCoverDescAr() %></p>
												</div>
											</div>
										</div>
<%
	}
%>										
									</div>	
							</div>
						</div>
						<div class="row vcenter">
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 no-pad">
								<h3 class="text-primary hidden">
									<small class="text-muted"><liferay-ui:message key="total_pmnt_amount"/></small><br /><liferay-ui:message key="sar"/>	<span class="totalPrem">1472.00</span> / <liferay-ui:message key="year"/>
								</h3>
							</div>
							<div
								class="text-right col-xs-12 col-sm-8 col-md-8 col-lg-8 no-pad">
								<ul class="list-btns">
									<li>
										<button class="btn btn-lg btn-xs-block btn-link text-muted" role="button" type="button" href="#" onclick="$('#vehicleInfoBackForm').submit();">
											<i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back_button"/>
										</button>
									</li>
									<li>
										<button class="btn btn-primary btn-lg btn-xs-block"	type="button" id="insSubmitBtn" onclick="validateInsFormAndSubmit();"><liferay-ui:message key="rev_quot"/></button>
									</li>
								</ul>
							</div>
						</div>
					</aui:form>
				</div>
			</div>
		</div>
	</div>
</div>
<div id="aui_popup_content">
</div>
<div id="aui_popup_body" style="display:none;">
	<div>
		Your Policy Total (<span class="totalPrem"></span> SAR) has exceeded SAMA limit for online purchase of policy. Please visit an ATMC branch to complete the purchase."
	</div>
</div>
<script>
$(function () {
    $('[data-toggle="popover"]').popover()
})
$("#effDate").calendarsPicker({
	calendar: $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>),
	dateFormat: 'dd/mm/yyyy',
	minDate: +1, 
	maxDate: +29,
	<%= currLocale.equals("en_US") ?"": " isRTL: true" %>
});
function validateInsFormAndSubmit()
{
    var frmValidator;
	AUI().use('aui-form-validator', function(A) {
		A.mix(A.config.FormValidator.RULES,
			{
				custDropDown:function(val, fieldNode, ruleValue){
					return (val != "-1");
				}
			},
		    true
		);
		
		A.mix(A.config.FormValidator.STRINGS,
			{
				custDropDown:'<liferay-ui:message key="plz_select_value"/>'
			},
			true
		);
		var rules = 
		{
			
		}
		if($(".covTypeOD").is(":visible"))
		{
			rules.<portlet:namespace/>dedValue = {
					custDropDown: true
	        };
			rules.<portlet:namespace/>vValue= {
				required: true,
				number: true,
				min:1
		    };
		    rules.<portlet:namespace/>repairOptions= {
				custDropDown: true
		    };
		}
		
		frmValidator = new A.FormValidator({
		    boundingBox: '#<portlet:namespace/>form3',
		    rules:rules
		    
		});
		
	});
	
	frmValidator.validate();
    
	if(!frmValidator.hasErrors()){
		//$("input[name='<portlet:namespace/>coverChk']").each(function(){
			//if(!$(this).is(":checked"))
			//{
				//$(this).closest("div").find("input[name='<portlet:namespace/>coverPrem']").property("disabled", false);
				//$(this).closest("div").find("select[name='<portlet:namespace/>coverPrem']").property("disabled", false);
			//}
		//});
		$("#<portlet:namespace/>form3").submit();
	}
}
calculateTotalPrem();

function calculateTotalPrem()
{
	var totalPrem =<%=quot.getGrossPrem()%>;
	var vat = <%=quot.getPolicyTaxes()%>;
	var	premVal =0;
	$("input[name='<portlet:namespace/>coverChk']:checked").each(function(){
		
		if($(this).closest("div").find("input[name='<portlet:namespace/>coverPrem']").length>0)
			premVal = $(this).closest("div").find("input[name='<portlet:namespace/>coverPrem']").val().split(";")[1];
		else if($(this).closest("div").find("select[name='<portlet:namespace/>coverPrem']").length>0)
		{
			var coverVals= $(this).closest("div").find("select[name='<portlet:namespace/>coverPrem'] option:selected").val().split(";")
			premVal = coverVals[1];
			var coverMonths = coverVals[4];
			premVal = coverMonths * premVal;
		}
		premVal = parseFloat(premVal);
		premVal += (vat * parseFloat(premVal));
		totalPrem += parseFloat(premVal);
	});
	$(".totalPrem").text(parseFloat(totalPrem).toFixed(2).replace(/(\d)(?=(\d{3})+\b)/g,'$1,'));
	
	if(totalPrem > <%=maxPremLimit%>)
	{
		$("#insSubmitBtn").attr("disabled","disabled");
		AUI().use('aui-modal', function(A) {
			var dialog = new A.Modal({
				title: "",
				bodyContent: AUI().one('#aui_popup_body').html(),
				headerContent: '',
				centered: true,
				modal: true,
				height: 200,
				render: '#aui_popup_content',
				close: true
			});
			dialog.render();
		});
	}
	else
	{
		$("#insSubmitBtn").removeAttr("disabled");
	}
}
function manageCoverVals(obj)
{
	if(obj.is(":checked"))
		obj.closest("div").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").removeAttr("disabled");
	else
		obj.closest("div").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").attr("disabled","disabled");
		
	calculateTotalPrem();
}
function manageCoverType(obj){
	if(obj.val()=="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE %>" && obj.is(":checked"))
	{
		$(".covTypeOD").show();
	}
	else
		$(".covTypeOD").hide();
	
	if(obj.val()=="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE %>" && obj.is(":checked") && <%=quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE)%>
	|| obj.val()=="<%=BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL %>" && obj.is(":checked") && <%=quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_TPL)%>
	)
	{
		$("#accordion").show();
		$("#accordion").find("input[type='checkbox']:checked").closest("div").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").removeAttr("disabled");
		
		$("#otherAccordion").hide();
		$("#otherAccordion").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").attr("disabled","disabled");
	}
	else
	{
		$("#accordion").hide();
		$("#accordion").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").attr("disabled","disabled");
		
		$("#otherAccordion").show();
		$("#otherAccordion").find("input[type='checkbox']:checked").closest("div").find("input[name='<portlet:namespace/>coverPrem'], select[name='<portlet:namespace/>coverPrem']").removeAttr("disabled");
	}

}
</script>
<% }%>