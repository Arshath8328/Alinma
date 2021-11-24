<%@page import="com.liferay.portal.kernel.util.PropsUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.QuotationCover"%>
<%@page import="java.util.List"%>
<%@ include file="init.jsp"%>
<%

List<QuotationCover> coversList = (List<QuotationCover>) request.getAttribute("quotationCoverList");

int maxPremLimit = Integer.valueOf(PropsUtil.get("com.ejada.atmc.buymotor.maxPremLimit")); 

 %>

<%-- <div class="row bg-white">
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<div class="row">
			<div class="col-md-12">
				<h3>
					<liferay-ui:message key="serv_covs" />
				</h3>
				<div class="panel-group cover-type-group" id="accordion">
				<%
									for( QuotationCover cover : coversList)
									{
									%>
									<div class="panel panel-default">
											<div class="panel-heading" role="tab">
												<h4 class="panel-title">
												<div class="value-content">
													<label class="cover-val control-label">
														<input type="checkbox" <%=checked %> name="<portlet:namespace/>coverChk" onclick="manageCoverVals($(this));"/>
														<div></div>
													</label>
													<span class="text-primary"><%="SAR "+numberFormat.format(cover.getCoverPrem()) %></span>
													<select class="form-control" name="<portlet:namespace/>coverPrem" onchange="calculateTotalPrem();" <%=(isBack && !checked.equals(""))?"":"disabled" %>>
													<option value="<%=cover.getCoverCode()+";"+cover.getCoverPrem()+";"+((currLocale.equals("en_US") )?cover.getCoverName():cover.getCoverNameAr())+";"+cover.getSectionCode()+";"+currVal%>" <%=(currVal.equals(defVal))?"selected":"" %>><%=currVal %> <%= (cover.getCoverCode() != null && (cover.getCoverCode().equals("31051") || cover.getCoverCode().equals("31052"))) ? LanguageUtil.get(request, "month") : ""  %></option>												
													</select>
		<%
		}
		%>
		
	</div>
</div>
</div>
</div></div>
 --%>




<div class="row">
	<div class="col-md-12">
		<h3>
			<liferay-ui:message key="serv_covs" />
		</h3>
		<div class="panel-group cover-type-group" id="accordion">
			<%
			    for (int cCount = 0; coversList != null && cCount < coversList.size(); cCount++) {
					QuotationCover cover = (QuotationCover) coversList.get(cCount);
					String checked = "";
					QuotationCover selQuotCover = null;
			%>
			<div class="panel panel-default">
				<div class="panel-heading" role="tab">
					<h4 class="panel-title">
						<div class="value-content">
							<label class="cover-val control-label">
							<input type="checkbox" name="<portlet:namespace/>coverChk" onclick="manageCoverVals($(this));" />
							<div></div>
							</label>
							<span class="text-primary"><%="SAR " + numberFormat.format(cover.getCoverPrem())%></span>
	<input type="hidden" name="<portlet:namespace/>coverPrem" value="<%=cover.getCoverCode() + ";" + cover.getCoverPrem() + ";"+ ((currLocale.equals("en_US")) ? cover.getCoverName() : cover.getCoverNameAr()) + ";"
			    + cover.getSectionCode()%>">
						</div>
						<a role="button" data-toggle="collapse" data-parent="#accordion" aria-expanded="true" href="#accordion-<%=cCount%>"
							class="accordion-toggle"> <%=(currLocale.equals("en_US")) ? cover.getCoverName() : cover.getCoverNameAr()%>
						</a>
					</h4>
				</div>
				<div class="panel-collapse collapse" id="accordion-<%=cCount%>"
					role="tabpanel">
					<div class="panel-body">
						<p><%=(currLocale.equals("en_US")) ? cover.getCoverDesc() : cover.getCoverDescAr()%></p>
					</div>
				</div>
			</div>
			<%
			    }
			%>
		</div>
		<div class="row vcenter">
							<div class="col-xs-12 col-sm-4 col-md-4 col-lg-4 no-pad">
								<h3 class="text-primary hidden">
									<small class="text-muted"><liferay-ui:message key="total_pmnt_amount"/></small><br /><liferay-ui:message key="sar"/>
										<span class="totalPrem"></span> / <liferay-ui:message key="year"/>
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
	var totalPrem =0;
	var vat = 0;
	var	premVal =0;
	$("input[name='<portlet:namespace/>coverChk']:checked").each(function(){
		alert("inside calculate premium");
		if($(this).closest("div").find("input[name='<portlet:namespace/>coverPrem']").size()>0)
			premVal = $(this).closest("div").find("input[name='<portlet:namespace/>coverPrem']").val().split(";")[1];
		else if($(this).closest("div").find("select[name='<portlet:namespace/>coverPrem']").size()>0)
		{
			var coverVals= $(this).closest("div").find("select[name='<portlet:namespace/>coverPrem'] option:selected").val().split(";")
			premVal = coverVals[1];
			var coverMonths = coverVals[4];
			premVal = coverMonths * premVal;
		}
		premVal = parseFloat(premVal);
		premVal += (vat * parseFloat(premVal));
		totalPrem += parseFloat(premVal);
		alert(totalPrem);
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
	
	if(obj.val()=="<%="MCC" %>" && obj.is(":checked") && <%="MCC"%> || obj.val()=="<%="MCC" %>" && obj.is(":checked") && <%="MCC"%>)
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
 --%>