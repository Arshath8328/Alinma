<%@page import="cancel.policy.list.portlet.CancelPolicyListPortlet"%>
<%@page import="com.liferay.petra.string.StringPool"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyCancelation"%>
<%@page import="com.ejada.atmc.acl.db.service.PolicyCancelationLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.web.search.PolicySearchTerms"%>
<%@page import="com.atmc.web.search.Policysearch"%>
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
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.Comparator"%>
<%@page import="java.util.stream.Collectors"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>

<%@ include file="init.jsp" %>
<style>
.popover {
	border-color: #C67;
}
.popover-content {
    color: #C67;
}
.popover.bottom > .arrow {
  border-bottom-color: #C67;
  top: -9px; }
 
.status-popup .dialog-iframe-node{
	height: 100% !important;
	weight: 100%;
}
.status-popup .yui3-widget-content-expanded{
	padding: 10px;
}
.status-popup .dialog-iframe-bd {
    height: 100% !important;
}
.status-popup .modal-content .dialog-iframe-node {
    width: 100% !important;
}
.navbar.collapse-basic-search .basic-search {
    padding: 6px;
}
</style>



<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="manage_policies"/></h1>
<%
String displayStyle = ParamUtil.getString(request, "displayStyle", "list");


Log _log = LogFactoryUtil.getLog(CancelPolicyListPortlet.class);
//PortletURL portletURL = renderResponse.createRenderURL();
String orderByCol = ParamUtil.getString(request, "orderByCol"); 
String orderByType = ParamUtil.getString(request, "orderByType");
int delta = ParamUtil.getInteger(request, SearchContainer.DEFAULT_DELTA_PARAM);
_log.info("delta >>>>>>>>>>>>>>>"+delta);
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

Policysearch qoutationSearchContainer = new Policysearch(renderRequest, portletURL);
PolicySearchTerms displayTerms = (PolicySearchTerms)qoutationSearchContainer.getDisplayTerms();
_log.info("displayTerms >>>>>>>>>>>>>>"+displayTerms);
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
		<liferay-frontend:management-bar-sort 
			orderByCol="<%= orderByCol %>" 
			orderByType="<%= orderByType %>" 
			orderColumns='<%= new String[] {"status","policy_expiry_date","policy_cancellation_req_date","policy_cancel_eff_date"} %>' 
			portletURL="<%= portletURL %>"/>
			
		<liferay-frontend:management-bar-navigation
		    navigationKeys='<%= new String[] {"status","PU","PC","WP","EX","RJ"} %>'
		    portletURL="<%= navigationPortletURL %>"
	    />
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons 
			displayViews='<%= new String[] {"list"} %>' 
			portletURL="<%= portletURL %>" 
			selectedDisplayStyle="<%= displayStyle %>"/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:;" icon="trash" id="deleteRoles" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>

<aui:form action="<%= portletURLString %>"  method="get" name="fm">
	<aui:input name="deleteRoleIds" type="hidden" />

	<liferay-portlet:renderURLParams varImpl="portletURL" />
		<liferay-ui:search-container 
			iteratorURL="<%=iteratorURL%>" 
			id="policySearch" 
			orderByType="<%=orderByType %>" 
			searchContainer="<%= qoutationSearchContainer %>"> 
		<liferay-ui:search-container-results>
		<%
		int quotationsCount = (int)request.getAttribute("canclePolicyTotalCount");
		//searchContainer.setTotal(quotationsCount);
		%>
		
		<%-- <%
		
		List<Quotation> quotationsList=new ArrayList<Quotation>();//QuotationLocalServiceUtil.getAdminQuotations(qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());//
		int quotationsCount = (int)request.getAttribute("quotationsTotalCount");
		searchContainer.setTotal(quotationsCount);
		String searchkeywords = displayTerms.getKeywords();
		boolean conjunctionFlag = false;
		if(searchkeywords!= null && !(searchkeywords.equals("")) && navigation.equals("status"))
		{
			if(quotationsList.size()>0)
				quotationsList.clear();
	
			quotationsList=QuotationLocalServiceUtil.getQuotations(null,Long.valueOf(searchkeywords),false,qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
			Long count = QuotationLocalServiceUtil.getQuotationsCount(null, Long.valueOf(searchkeywords), conjunctionFlag);
			searchContainer.setTotal(count.intValue());
		}
		else if (navigation.equals("status")) {
			if(quotationsList.size()>0)
				quotationsList.clear();
			quotationsList=QuotationLocalServiceUtil.getAdminQuotations(qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
		}
		else{
			
			if(quotationsList.size()>0)
				quotationsList.clear();
			if(!searchkeywords.equals(""))
				conjunctionFlag = true; 
			if(searchkeywords.equals(""))
				searchkeywords="0";
			quotationsList=QuotationLocalServiceUtil.getQuotations(navigation,Long.valueOf(searchkeywords),conjunctionFlag,qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
			Long count = QuotationLocalServiceUtil.getQuotationsCount(navigation, Long.valueOf(searchkeywords), conjunctionFlag);
			
			
			searchContainer.setTotal(count.intValue());
		}
		
		
		searchContainer.setResults(quotationsList);
		%> --%>
		
		<%
		List<PolicyCancelation> policyCancelations =new ArrayList<PolicyCancelation>();
		//policyCancelations = PolicyCancelationLocalServiceUtil.getPolicyCancelations(-1, -1);
		searchContainer.setTotal(quotationsCount);
		String searchkeywords = displayTerms.getKeywords();
		if(searchkeywords!= null && !(searchkeywords.equals("")) && navigation.equals("status"))
		{
		    _log.info("nav status");
			if(policyCancelations.size()>0)
			    policyCancelations.clear();
			policyCancelations = PolicyCancelationLocalServiceUtil.getPolicyCancelations(-1, -1);
			//policyCancelations.add(PolicyCancelationLocalServiceUtil.findByPolicyNum(searchkeywords));
			searchContainer.setTotal(quotationsCount);
		}
		else if (navigation.equals("status")) {
		    _log.info("status = status ");
			if(policyCancelations.size()>0)
			    policyCancelations.clear();
			policyCancelations = PolicyCancelationLocalServiceUtil.getPolicyCancelations(-1, -1);
		}
		 else{
			_log.info("find by one status "+navigation);
			if(policyCancelations.size()>0)
			    policyCancelations.clear();
			if(!policyCancelations.equals(""))
			if(searchkeywords.equals(""))
				searchkeywords="0";
			policyCancelations =  PolicyCancelationLocalServiceUtil.statusAll(navigation);
			for(PolicyCancelation tset: policyCancelations)
			{
			    _log.info("policy Status >>>>>>>>>>>>>>"+tset.getStatus());   
			}
			
			searchContainer.setTotal(policyCancelations.size());
		} 
		//searchContainer.setResults(policyCancelations);
		List<PolicyCancelation> sortedCancelPolicies=new ArrayList<>();
		
		if(orderByType.equals("desc")){
			if(orderByCol.equals("Status")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getStatus).reversed()).collect(Collectors.toList());
			}else if(orderByCol.equals("Policy Expiry Date")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getPolicyExpiryDate).reversed()).collect(Collectors.toList());
			}else if(orderByCol.equals("Policy Cancellation Req Date")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getCancllationReqDate).reversed()).collect(Collectors.toList());
			}else{
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getCancellationEffdate).reversed()).collect(Collectors.toList());
			}
		}else{
			if(orderByCol.equals("Status")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getStatus)).collect(Collectors.toList());
			}else if(orderByCol.equals("Policy Expiry Date")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getPolicyExpiryDate)).collect(Collectors.toList());
			}else if(orderByCol.equals("Policy Cancellation Req Date")){
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getCancllationReqDate)).collect(Collectors.toList());
			}else{
				sortedCancelPolicies = policyCancelations.stream().sorted(Comparator.comparing(PolicyCancelation::getCancellationEffdate)).collect(Collectors.toList());
			}
		}
		
		if(!searchkeywords.isEmpty()){
			sortedCancelPolicies.clear();
			sortedCancelPolicies.add(PolicyCancelationLocalServiceUtil.findByPolicyNum(searchkeywords));
		}
		_log.info("sortedCancelPolicies : "+sortedCancelPolicies);
			
		List<PolicyCancelation> temp=new ArrayList<>();
		temp = ListUtil.subList(sortedCancelPolicies,searchContainer.getStart(),searchContainer.getEnd());
		_log.info("temp : "+temp);
		searchContainer.setTotal(sortedCancelPolicies.size());
		searchContainer.setResults(temp);
		
		_log.info("search Keyword >>>>>>>>>"+searchkeywords);
		_log.info("navigation >>>>>>>>>>>>"+navigation);
		
		%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row className="com.ejada.atmc.acl.db.model.PolicyCancelation" keyProperty="policyNumber" modelVar="policy">
		<%
			SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
				//dmyDateFormatter.format(date);
			try{
				try{
		%>
		
		<portlet:renderURL var="rejecturl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="myview" value="assign_to"/>
			<portlet:param name="policyNumber" value="<%=policy.getPolicyNumber() %>"/>
		</portlet:renderURL>


		<portlet:renderURL var="approveurl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
			<portlet:param name="myview" value="approve"/>
			<portlet:param name="policyNumber" value="<%=policy.getPolicyNumber() %>"/>
		</portlet:renderURL>
		
		
		<portlet:actionURL var="details" name="policyDetails">
					<portlet:param name="myview" value="details"/>
					<portlet:param name="policyNumber" value="<%=policy.getPolicyNumber()+""%>"/>
			</portlet:actionURL>
		
			<liferay-ui:search-container-column-text name="Policy Number" orderable="true"  value="<%=policy.getPolicyNumber() %>" href="${details}">
				<a href="${details}" ><%=policy.getPolicyNumber()%><br/></a>
			
			</liferay-ui:search-container-column-text>
		<% }catch(Exception e){
		    _log.info("inside catch block "+policy.getPolicyNumber());
			e.printStackTrace();
			
			%>
			<liferay-ui:search-container-column-text name="Policy Number" orderable="true"></liferay-ui:search-container-column-text>
		<%}
				try{ %>
			<liferay-ui:search-container-column-text name="Insured Name" orderable="true" value="<%=policy.getInsuredName()%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Insured Name" orderable="true"></liferay-ui:search-container-column-text>
		<%}
				try{ %>
			<liferay-ui:search-container-column-text name="Policy Expiry Date" orderable="true" value="<%=dmyDateFormatter.format(policy.getPolicyExpiryDate().getTime()) %>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Policy Expiry Date" orderable="true"></liferay-ui:search-container-column-text>
		<%}try{ %>
		<liferay-ui:search-container-column-text name="Policy Cancellation Req Date" orderable="true" value="<%=dmyDateFormatter.format(policy.getCancllationReqDate().getTime()) %>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Policy Cancellation Req Date" orderable="true"></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Policy Cancel Eff Date" orderable="true" value="<%=dmyDateFormatter.format(policy.getCancellationEffdate().getDate())%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Policy Cancel Eff Date" orderable="true" ></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Status" orderable="true" value="<%=policy.getStatus()%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			e.printStackTrace();%>
			<liferay-ui:search-container-column-text name="Status" orderable="true"></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text  name="action" > 
				<liferay-ui:icon-menu direction="left-side" icon="<%= StringPool.BLANK %>" markupView="lexicon" message="<%= StringPool.BLANK %>" showWhenSingleIcon="<%= true %>">
					<li  id="accept_" url="">
						<a href="javascript:void(0)" onclick="approvePopup(' ${approveurl} ')"><liferay-ui:message key="Accept" /></a>
					</li>
					<li id="reject_" url="" status="">
						<a href="javascript:void(0)" onclick="rejectPopup(' ${rejecturl} ')"><span class="text-danger"><liferay-ui:message key="reject" /></span></a>
					</li>
				</liferay-ui:icon-menu>
			</liferay-ui:search-container-column-text>
		<% }catch(Exception e){e.printStackTrace();} %>
<%
}catch(Exception e){
	%>
		<liferay-ui:search-container-column-text name="Policy Number" orderable="true" ></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Insured Name" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Policy Expiry Date" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Channel" value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Status"  value=""></liferay-ui:search-container-column-text>
		
<% } %>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer %>" markupView="lexicon" />
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

function approvePopup(url){
		Liferay.Util.openWindow(
				{
					cache: false,
					dialog: {
						destroyOnHide: true,
						cssClass: 'atmc-popup status-popup',
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal:true,
						resizable: false,
						width: 450,
						height: 450
					},
					dialogIframe: {
						id: '<portlet:namespace />dialog',
						uri: url.toString()
					},
					uri: url
				});
};

function rejectPopup(url){
			Liferay.Util.openWindow(
				{
					cache: false,
					dialog: {
						destroyOnHide: true,
						cssClass: 'atmc-popup status-popup',
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal:true,
						resizable: false,
						width: 450,
						height: 450
					},
					dialogIframe: {
						id: '<portlet:namespace />dialog',
						uri: url.toString()
					},
					uri: url
				});
	    
}
</script>