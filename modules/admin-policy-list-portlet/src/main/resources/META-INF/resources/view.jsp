<%@page import="admin.policy.list.portlet.AdminPolicyListPortlet"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.ejada.atmc.acl.db.service.QuotationsLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="com.atmc.bsl.db.service.QuotationLocalServiceUtil"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.atmc.web.search.QuotationSearchTerms"%>
<%@page import="com.atmc.web.search.QuotationSearch"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>

<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/init.jsp" %>
<style>
.popover {
	border-color: #C67;
.popover-content {
    color: #C67;
}
.popover.bottom > .arrow {
  border-bottom-color: #C67;
  top: -9px; }
</style>
<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="manage_policies"/></h1>
<%
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");


Log _log = LogFactoryUtil.getLog(AdminPolicyListPortlet.class);
//PortletURL portletURL = renderResponse.createRenderURL();
String orderByCol = ParamUtil.getString(request, "orderByCol"); 
String orderByType = ParamUtil.getString(request, "orderByType");
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
String navigation = ParamUtil.getString(request, "navigation", "status");
// create navigation url for status filter

PortletURL navigationPortletURL = renderResponse.createRenderURL();
		
// add paramter to navigationurl
if (delta > 0) {
	navigationPortletURL.setParameter("delta", String.valueOf(delta));
}

navigationPortletURL.setParameter("orderBycol", orderByCol);
navigationPortletURL.setParameter("orderByType", orderByType);

//create portletURL from navigationURL
PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);
//add paramter navigation paramter to portletURL
portletURL.setParameter("navigation", navigation);



String portletURLString = portletURL.toString();
portletURL.setParameter("displayStyle", displayStyle);
pageContext.setAttribute("portletURL", portletURL);
PortletURL iteratorURL = renderResponse.createRenderURL();
String currLocale = themeDisplay.getLocale().toString();

//orderByCol is the column name passed in the request while sorting

//orderByType is passed in the request while sorting. It can be either asc or desc
String sortingOrder = orderByType;
//Logic for toggle asc and desc
if(orderByType.equals("desc")){
  orderByType = "asc";
}else{
  orderByType = "desc";
}

if(Validator.isNull(orderByType)){
  orderByType = "desc";
}

QuotationSearch qoutationSearchContainer = new QuotationSearch(renderRequest, portletURL);
QuotationSearchTerms displayTerms = (QuotationSearchTerms)qoutationSearchContainer.getDisplayTerms();

//System.out.println("All good 1");


%>
<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= portletURLString %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>
<liferay-frontend:management-bar includeCheckBox="<%= false %>" searchContainerId="policySearch">
	<liferay-frontend:management-bar-filters>

		<%-- <liferay-frontend:management-bar-sort orderByCol="<%= orderByCol %>" orderByType="<%= orderByType %>" orderColumns='<%= new String[] {"Product","Status"} %>' portletURL="<%= portletURL %>"/> --%>
		<liferay-frontend:management-bar-navigation
		    navigationKeys='<%= new String[] {"status","PS","PSA","PP","PA","EX","RJ"} %>'
		    portletURL="<%= navigationPortletURL %>"
	    />
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons displayViews='<%= new String[] {"list"} %>' portletURL="<%= portletURL %>" selectedDisplayStyle="<%= displayStyle %>"/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteRoles" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<aui:form action="<%= portletURLString %>" cssClass="container-fluid-1280" method="get" name="fm">
	<aui:input name="deleteRoleIds" type="hidden" />

	<liferay-portlet:renderURLParams varImpl="portletURL" />
		<liferay-ui:search-container iteratorURL="<%=iteratorURL%>" id="policySearch" orderByType="<%=orderByType %>" searchContainer="<%= qoutationSearchContainer %>"> 
		<liferay-ui:search-container-results>
		<%
		
		List<Quotation> quotationsList=new ArrayList<Quotation>();//QuotationLocalServiceUtil.getAdminQuotations(qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());//
		
		//System.out.println("Retrieved Count:" + request.getAttribute("quotationsTotalCount"));
		int quotationsCount = (int)request.getAttribute("quotationsTotalCount");
		
		
		searchContainer.setTotal(quotationsCount);
		String searchkeywords = displayTerms.getKeywords();
		boolean conjunctionFlag = false;
		
		
		//System.out.println(navigation);
		if(searchkeywords!= null && !(searchkeywords.equals("")) && navigation.equals("status"))
		{
			//System.out.println("In 1");
			if(quotationsList.size()>0)
				quotationsList.clear();
	
			quotationsList=QuotationLocalServiceUtil.getQuotations(null,Long.valueOf(searchkeywords),false,qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
			Long count = QuotationLocalServiceUtil.getQuotationsCount(null, Long.valueOf(searchkeywords), conjunctionFlag);
			
			//System.out.println("Count:" + quotationsList.size());
			//System.out.println("Count again:" + count);
			
			searchContainer.setTotal(count.intValue());
		}
		else if (navigation.equals("status")) {
			//System.out.println("In 2");
			if(quotationsList.size()>0)
				quotationsList.clear();
			quotationsList=QuotationLocalServiceUtil.getAdminQuotations(qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
		}
		else{
			//System.out.println("In 3");
			
			if(quotationsList.size()>0)
				quotationsList.clear();
			if(!searchkeywords.equals(""))
				conjunctionFlag = true; 
			if(searchkeywords.equals(""))
				searchkeywords="0";
			//System.out.println(searchkeywords);
			quotationsList=QuotationLocalServiceUtil.getQuotations(navigation,Long.valueOf(searchkeywords),conjunctionFlag,qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
			Long count = QuotationLocalServiceUtil.getQuotationsCount(navigation, Long.valueOf(searchkeywords), conjunctionFlag);
			
			//System.out.println("Count:" + quotationsList.size());
			//System.out.println("Count again:" + count);
			
			searchContainer.setTotal(count.intValue());
		}
		
		 //_log.debug("//////////////// start Of Server Quot ////////////////////");
		 //_log.debug("quotationsList:" + quotationsList);
		 //_log.debug("//////////////// End Of Server Quot ////////////////////");
		
		searchContainer.setResults(quotationsList);
		%>
		</liferay-ui:search-container-results>
<% %>
		<liferay-ui:search-container-row className="com.atmc.bsl.db.domain.quotation.Quotation" keyProperty="quotationId" modelVar="quotation">
		<%
			SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
				//dmyDateFormatter.format(date);
			try{
				// _log.debug("/////////////////// start jsp Quotaion test /////////////////////");
				 //_log.debug("QuotationObj :"+quotation);
				try{
				
					// _log.debug("QuotationId"+quotation.getQuotationId());
					// _log.debug("ReferenceNo"+quotation.getReferenceNo());
		%>
			<liferay-ui:search-container-column-text name="Quotation Number" orderable="true" >
				<portlet:actionURL var="details" name="quotationDetails">
					<portlet:param name="myview" value="details"/>
					<portlet:param name="quotationId" value="<%=quotation.getQuotationId()+""%>"/>
				</portlet:actionURL>
				<a href="${details}" >
					<%=quotation.getReferenceNo()%><br/>
					<%
						if(quotation.getQuotationHistory()!=null && !quotation.getQuotationHistory().isEmpty())
						{
							
							// _log.debug("History not empty");
							// _log.debug(quotation.getQuotationHistory().get(0).toString());
							
					%>
						<span class='text-muted glyphicon glyphicon-calendar'>
							<%=dmyDateFormatter.format(quotation.getQuotationHistory().get(0).getDateTime())%>
						</span>
					<%
						}
						
					 	//_log.debug("before check");
						boolean xx = quotation.getQuoteStatus().equals("RJ");
						// _log.debug("after check");
					
					%>
				</a>
			</liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();
			%>
			<liferay-ui:search-container-column-text name="Quotation Number" orderable="true" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Customer/ID" value="${quotation.insuredName}<br /><span class='text-muted'>${quotation.insuredId}</span>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Customer/ID" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Product" value="<%="<span class='icon icon-transport-3 text-muted'></span> "+(currLocale.equals("en_US") ? quotation.getProductDescEn():quotation.getProductDescAr())+"<br /><span class='text-muted'>"+((!quotation.getPolicyNo().equals(""))?quotation.getPolicyNo():LanguageUtil.get(request,"policy_not_issues"))%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Product" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
		<liferay-ui:search-container-column-text name="Insurance Type" value="<%=currLocale.equals("en_US") ? quotation.getVehicleIdDescEn():quotation.getVehicleIdDescAr()%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Insurance Type" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Channel" value="<%=LanguageUtil.get(request,"channel_code_"+quotation.getSource())%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Channel" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Status"  value="<%=(quotation.getQuoteStatus().equals("RJ"))?(LanguageUtil.get(request,quotation.getQuoteStatus())+" <i class='material-icons text-danger' data-trigger='hover' data-toggle='popover' data-placement='bottom' data-content='"+((quotation.getQuotationHistory()!=null && !quotation.getQuotationHistory().isEmpty())?quotation.getQuotationHistory().get(0).getReason():"")+"'>&#xE88F;</i>"):LanguageUtil.get(request,quotation.getQuoteStatus())%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Status"  value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-jsp path="/action_buttons.jsp"/>
		<% }catch(Exception e){e.printStackTrace();} %>
<% _log.debug("/////////////////// end jsp Quotaion test /////////////////////");}catch(Exception e){
	 _log.debug("/////////////////// in Catch /////////////////////");
	%>
		
		<liferay-ui:search-container-column-text name="Quotation Number" orderable="true" >
			
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Customer/ID" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Product" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Channel" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Status"  value=""></liferay-ui:search-container-column-text>
		
<% } %>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator searchContainer="<%= searchContainer %>" markupView="lexicon" />
		</liferay-ui:search-container>
</aui:form>


<div id="accept_popup_content"></div>
<div id="accept_popup_body" style="display:none;">
		<form method="post" >
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12">
					<h4 class="text-primary text-left"><liferay-ui:message key="Accept New Policy Management"/></h4>
					<div class="form-group text-left"> 
						<label class="control-label" for="formInput56">Remarks</label>
							<aui:input type="Text" name="reason" label="" class="form-control" value="">
						</aui:input>
					</div>	
						 
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<a role="button" class="btn btn-primary btn-lg btn-xs-block" href="" id="confirmBtn"><liferay-ui:message key="confirm" /></a>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</form>

</div>




<div id="reject_popup_content"></div>
<div id="reject_popup_body" style="display:none;">
		<aui:form method="post" id="rejectForm" name="rejectForm" >
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-12 text-left">
					<label class="control-label" for="formInput56"><liferay-ui:message key="reason_rej"/></label>
					<aui:select  id="reason" name="reason" cssClass="form-control" label="">
						<aui:option value="0,0"><liferay-ui:message key="reject_reason_0" /></aui:option>
						<aui:option value="1,1"><liferay-ui:message key="reject_reason_1" /></aui:option>
						<aui:option value="2,1"><liferay-ui:message key="reject_reason_2" /></aui:option>
						<aui:option value="3,1"><liferay-ui:message key="reject_reason_3" /></aui:option>
						<aui:option value="4,1"><liferay-ui:message key="reject_reason_4" /></aui:option>
						<aui:option value="5,1"><liferay-ui:message key="reject_reason_5" /></aui:option>
						<aui:option value="6,1"><liferay-ui:message key="reject_reason_6" /></aui:option>
						<aui:validator name="required" errorMessage="required_field_validator"/>
					</aui:select>
				</div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns">
						<li>
							<button type="submit" role="button" class="btn btn-primary btn-lg btn-xs-block" id="submitBtn"><liferay-ui:message key="confirm" /></button>
						</li>
						<li>
							<a class="btn btn-link btn-lg btn-xs-block text-default" role="button" href="javascript:void(0);" onClick="$('.close').click().click();"><liferay-ui:message key="cancel"/></a>
						</li>
					</ul>		
				</div>				
			</div>
		</aui:form>

</div>
<script type="text/javascript">
$(function () {
	$('[data-toggle="popover"]').popover();
})
</script>