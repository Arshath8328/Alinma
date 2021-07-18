<%@page import="com.ejada.atmc.acl.db.custom.model.PSPolicyDetail"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>

<%
	PSPolicyDetail psPolicyDetail = (PSPolicyDetail) request.getAttribute("psPolicyDetail");
	System.out.println("psPolicyDetail: "+psPolicyDetail);
	String redirect = ParamUtil.getString(request, "backURL");
	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
	Date date1 = new SimpleDateFormat("dd/MMM/yyyy").parse(psPolicyDetail.getInception_date());
	String fromDate = dateFormat.format(date1);
	String toDate = dateFormat.format(new Date());
	System.out.println("from Date : " + fromDate);
	System.out.println("to Date : " + toDate);
%>

<portlet:renderURL var="fundStatementInfo">
	<portlet:param name="mvcPath" value="/statement.jsp"/>
	<portlet:param name="proposalNo" value="<%=String.valueOf(psPolicyDetail.getProposal_no()) %>"/>
	<portlet:param name="cmd" value="details"/>
	<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
</portlet:renderURL>


	
<div class="container fund-stmt">
		<a href="<%=redirect%>">< Back</a>
		<br><br>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad ">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getProposal_no() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy_number_ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy_number"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getStatement_date() %></div>
            </div>
            <div class="col-md-2 cell-border-2 no-pad fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="statement.date.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="statement.date"/></div>
            </div>
        </div>
        <div class="row-divider"></div>
        <div class="row fundStmt-table-head border-2">
            <div class="col-md-6 no-pad ">
                <div class="stmt-title-left"><liferay-ui:message key="policy.details"/></div>
            </div>
            <div class="col-md-6 no-pad">
                <div class="stmt-title-right"><liferay-ui:message key="policy.details.ar"/></div>
            </div>
        </div>
        <div class="row-divider">
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad fundStmt-align-center">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getEmail_address() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="email.address.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="email.address"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getPolicy_holder() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy.holder.name.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy.holder.name"/></div>
            </div>
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getContact_no() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="contact.number.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="contact.number"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getProduct_desc().replaceAll("(\r\n|\n)", "<br />") %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.name.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.name"/></div>
            </div>
        </div>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center">
                    <div class="txt-align-center"><%= psPolicyDetail.getMailingAddress1().replaceAll("(\r\n|\n)", "<br />") %></div>
                </div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head">
                <div class="fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="mailing.address.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="mailing.address"/></div>
                </div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center">
                	<div class="txt-align-center"><%= psPolicyDetail.getNad_address1() %></div>
                </div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head">
                <div class="fundStmt-align-center">
                    <div class="txt-align-center"><liferay-ui:message key="home.address.ar"/></div>
                    <div class="txt-align-center"><liferay-ui:message key="home.address"/></div>
                </div>
            </div>
        </div>

        <div class="row-divider"></div>

        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getInception_date() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="policy.inception.date.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="policy.inception.date"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getStatus_descr() %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.status.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.status"/></div>
            </div>
        </div>
        <div class="row display-flex b-top b-right b-left">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= String.format("%.0f", psPolicyDetail.getPlan_duration()) %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="plan.duration.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="plan.duration"/></div>
            </div>
            <div class="col-md-4 no-pad cell-border-2">
                <div class="fundStmt-align-center"><%= String.format("%.0f", psPolicyDetail.getInstallment_amount()) %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="installment.amount.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="installment.amount"/></div>
            </div>
        </div>
        <div class="row display-flex border-2">
            <div class="col-md-3 no-pad">
                <div class="fundStmt-align-center"><%= psPolicyDetail.getFrequency() %></div>
            </div>
            <div class="col-md-3 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="payment.frequency.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="payment.frequency"/></div>
            </div>
            <div class="col-md-4 cell-border-2 no-pad">
                <div class="fundStmt-align-center"><%= String.format("%.0f", psPolicyDetail.getTotal_amount_received()) %></div>
            </div>
            <div class="col-md-2 no-pad cell-border-2 fundStmt-table-head fundStmt-align-center">
                <div class="txt-align-center"><liferay-ui:message key="total.amount.received.ar"/></div>
                <div class="txt-align-center"><liferay-ui:message key="total.amount.received"/></div>
            </div>
        </div>
		
		<aui:form id="fm" name="fm" role="form" action="<%=fundStatementInfo %>" method="post" enctype="multipart/form-data">
		<div class="row-divider-20"></div>
        <div class="row">
            <div class="col-md-4 col-md-offset-1">
                <div class="fundStmt-align-center">
					<div class="form-group has-feedback">
						<input id="fundStmtFromDate" name="<portlet:namespace/>fromDate" class="form-control" type="text" placeholder="fromDate" readonly="readonly" value="<%= fromDate %>"/>
						<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
					</div>
				</div>
            </div>
            <div class="col-md-4">
                <div class="fundStmt-align-center">
                	<div class="form-group has-feedback">
						<input id="fundStmtToDate" name="<portlet:namespace/>toDate" class="form-control" type="text" placeholder="toDate" readonly="readonly" />
						<span class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
					</div>
                </div>
            </div>
            <div class="col-md-2">
                <div class="fundStmt-align-center">
                	<button id="fundStmtSubmit" class="btn btn-primary btn-md" tabindex="33"  type="button" onclick="doSubmition();"><liferay-ui:message key="submit"/></button>
                </div>
            </div>
            <div class="col-md-offset-1"></div>
        </div>
		</aui:form>
    </div>
    
<aui:script>
$('#fundStmtToDate').calendarsPicker({
	maxDate: 0,
	defaultDate: <%= toDate %>,
	selectDefaultDate: true
});

/* $('#fundStmtFromDate').calendarsPicker({
	defaultDate: <%= fromDate %>,
	selectDefaultDate: true
}); */
$('#fundStmtFromDate').calendarsPicker('disable')

var frmValidator;
function doSubmition(){
	if(frmValidator)
		frmValidator.resetAllFields();
	var rules;
	$("#<portlet:namespace/>fm .form-validator-stack").remove();
	$("#<portlet:namespace/>fm .error-field").removeClass("error-field");
	$("#<portlet:namespace/>fm .has-error").removeClass("has-error");
	$("#<portlet:namespace/>fm input").removeAttr("aria-invalid");
	rules = {
		    <portlet:namespace/>toDate: {
		        required: true
		    },
		    <portlet:namespace/>fromDate: {
		        required: true
		    },
		}
		AUI().use('aui-form-validator', function(A) {
		    frmValidator = new A.FormValidator({
		        boundingBox: '#<portlet:namespace/>fm',
		        rules: rules,
		        validateOnBlur: false
		    });
		})
	frmValidator.validate();
	if(!frmValidator.hasErrors()){
		$("#<portlet:namespace/>fm").submit();
	}
}
</aui:script>
