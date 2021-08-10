<%@page import="com.atmc.bsl.db.service.SrvReqLocalServiceUtil"%>
<%@page import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.search.ServiceRequestSearchTerms"%>
<%@page import="com.atmc.web.search.ServiceRequestSearch"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.model.RoleConstants"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="init.jsp" %>

<liferay-ui:success key="close_success" message="success_update_service_request"/>
<liferay-ui:error key="close_error" message="error_update_service_request" /> 


<%
	List<ServiceRequest> msgList = (List)request.getAttribute("msgsList");
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	
	
	
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("myview", "closed_requests");
	String portletURLString = portletURL.toString();
	portletURL.setParameter("displayStyle", displayStyle);
	
	pageContext.setAttribute("portletURL", portletURL);
	PortletURL iteratorURL = renderResponse.createRenderURL();
	String currLocale = themeDisplay.getLocale().toString();

	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol"); 

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
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
	
	ServiceRequestSearch srvReqSearchContainer = new ServiceRequestSearch(renderRequest, portletURL);
	ServiceRequestSearchTerms displayTerms = (ServiceRequestSearchTerms)srvReqSearchContainer.getDisplayTerms();
%>
<portlet:renderURL var="srvReqListURL">
	<portlet:param name="myview" value="view"/>
</portlet:renderURL>
<portlet:renderURL var="escalationsURL">
	<portlet:param name="myview" value="escalated_requests"/>
</portlet:renderURL>
<ul class="nav nav-tabs clearfix">
	<li><a href="${srvReqListURL}" ><liferay-ui:message key="requests_tab"/></a></li>
	<li><a href="${escalationsURL}"><liferay-ui:message key="escalation_tab"/></a></li>
	<li class="active"><a href="javascript:void(0);" role="tab" data-toggle="tab"><liferay-ui:message key="history_tab"/></a></li>
</ul>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= portletURLString %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>
<liferay-frontend:management-bar includeCheckBox="<%= true %>" searchContainerId="srvReqSearch">
	<liferay-frontend:management-bar-filters>
		<liferay-frontend:management-bar-sort
			orderByCol="<%= orderByCol %>"
			orderByType="<%= orderByType %>"
			orderColumns='<%=new String[]{"Date"} %>'
			portletURL="<%= portletURL %>"
		/>
	</liferay-frontend:management-bar-filters>

	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%= new String[] {"list"} %>'
			portletURL="<%= portletURL %>"
			selectedDisplayStyle="<%= displayStyle %>"
		/>
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:void(0);" icon="trash" id="deleteRoles" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>
<%if(isCustomerService){ %>
<liferay-frontend:add-menu>
    <liferay-frontend:add-menu-item  title='<%= LanguageUtil.get(request,"add_new_request") %>' url="/group/staff/compose_new_service_request" />
</liferay-frontend:add-menu>
<%} %>
<aui:form action="<%= portletURLString %>" cssClass="container-fluid-1280" method="get" name="fm">
	<aui:input name="deleteRoleIds" type="hidden" />

	<liferay-portlet:renderURLParams varImpl="portletURL" />
		<liferay-ui:search-container  
		iteratorURL="<%=iteratorURL%>"
		id="srvReqSearch"  
		orderByType="<%=orderByType %>"
		emptyResultsMessage="there-are-no-service-requests"
		searchContainer="<%= srvReqSearchContainer %>"
		>
				
		<liferay-ui:search-container-results>
		<%
			String searchkeywords = displayTerms.getKeywords();
			String orderCol = "";
			if(Validator.isNotNull(orderByCol))
			{
		        if(orderByCol.equals("Category"))
		        	orderCol = "REQUEST_CATEGORY";
		        else
	        		orderCol = "CREATION_DATE";
			}
			String[] statusList = new String[]{CustomerServiceRequestListPortletKeys.REQUEST_STATUS_CLOSED};
			msgList = SrvReqLocalServiceUtil.getSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole")
												,searchkeywords, false, srvReqSearchContainer.getStart(), srvReqSearchContainer.getEnd(), orderCol, orderByType);
		  	int count= SrvReqLocalServiceUtil.countSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole"), searchkeywords, false);
		  	System.out.println("jsp result count : " + count);
		  	
		 	System.out.println(searchkeywords);
		    srvReqSearchContainer.setResults(msgList);
		  	srvReqSearchContainer.setTotal(count);
		 
		 %>
		</liferay-ui:search-container-results> 

		<liferay-ui:search-container-row
			className="com.atmc.bsl.db.domain.serviceRequest.ServiceRequest" 
			keyProperty="referenceNo" 
			modelVar="srvReq"
		>
		<%
			SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
			String creationDate = dmyDateFormatter.format(srvReq.getCreationDate());
			
		%>

		<liferay-ui:search-container-column-text name="ref" orderable="true" >
			<portlet:renderURL var="detailsURL">
				<portlet:param name="myview" value="message_details"/>
				<portlet:param name="refNo" value="<%=srvReq.getReferenceNo()+""%>"/>
			</portlet:renderURL>
			<a href="${detailsURL}"><%=srvReq.getReferenceNo() + "<br/><span class='glyphicon glyphicon-calendar'></span> " + creationDate  %></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text property="iqamaId" name="policy_from" value="<%=srvReq.getCreatorUserName() + "<br/>" + srvReq.getIqamaId() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="policy_cat_product" value="<%=LanguageUtil.get(request,"Service_Request_Cat_" + srvReq.getRequestCategory().toLowerCase()) +", "+ LanguageUtil.get(request, "Service_Request_Type_" + srvReq.getRequestType()) + "<br/><span class='icon "+LanguageUtil.get(request, "Service_Request_Product_ICON_" + srvReq.getProductType())+"'></span><small class='text-muted'>" + LanguageUtil.get(request, "Service_Request_Product_" + srvReq.getProductType()) + "</small>"%>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Channel" value="<%=srvReq.getSource() %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="policy_status"  orderable="true" value="<%=LanguageUtil.get(request,"service_request_status_" + srvReq.getRequestStatus()) %>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/adminCustomerServiceList/action_buttons.jsp"/>
		</liferay-ui:search-container-row>

		<liferay-ui:search-iterator  searchContainer="<%= srvReqSearchContainer %>" markupView="lexicon" />
		</liferay-ui:search-container>
</aui:form>