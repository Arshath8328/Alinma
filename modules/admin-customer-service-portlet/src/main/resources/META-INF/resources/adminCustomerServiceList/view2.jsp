<%@page import="admin.customer.service.constants.AdminCustomerServiceListPortletKeys"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.atmc.bsl.db.service.SrvReqLocalServiceUtil"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.commons.beanutils.BeanComparator"%>
<%@page import="java.util.Collections"%>
<%@page
	import="com.atmc.web.constants.CustomerServiceRequestListPortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.atmc.web.constants.MenuPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest"%>
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
<%@page
	import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page
	import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/adminCustomerServiceList/init.jsp"%>

<liferay-ui:success key="close_success" message="success_update_service_request"/>
<liferay-ui:error key="close_error" message="error_update_service_request" /> 

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/adminCustomerServiceList/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="requestIteratorURL">
	<portlet:param name="mvcPath" value="/adminCustomerServiceList/view.jsp" />
</liferay-portlet:renderURL>

<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="request.staff"/></h1>

<div style="padding: 20px 40px 40px 40px;">

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= requestIteratorURL %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>
<%
	String orderByCol = ParamUtil.getString(request, "orderByCol"); 

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	Log _log = LogFactoryUtil.getLog(this.getClass());
%>

<aui:form action="<%= requestIteratorURL %>" cssClass="container-fluid-fund-stmt" method="post" name="fm">
	<liferay-portlet:renderURLParams varImpl="requestIteratorURL" />

	<liferay-ui:search-container delta="10" displayTerms="<%=new DisplayTerms(renderRequest)%>"
		iteratorURL="<%=iteratorURL%>" emptyResultsMessage="No Records Found">

		<liferay-ui:search-container-results>
			<%
			DisplayTerms displayTerms = searchContainer.getDisplayTerms();
			String searchkeywords = displayTerms.getKeywords();
			String orderCol = "";
			if(Validator.isNotNull(orderByCol))
			{
		        if(orderByCol.equals("Category"))
		        	orderCol = "REQUEST_CATEGORY";
		        else
	        		orderCol = "CREATION_DATE";
			}
			List<ServiceRequest> msgList = Collections.EMPTY_LIST;
			
			boolean conjunctionFlag = false;
			
			String[] statusList = new String[]{CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW, CustomerServiceRequestListPortletKeys.REQUEST_STATUS_ASSIGNED, 
					CustomerServiceRequestListPortletKeys.REQUEST_STATUS_OPEN};
			if (!Validator.isBlank(searchkeywords)) {//Basic Search
				msgList = SrvReqLocalServiceUtil.getSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole")
						,searchkeywords, false, searchContainer.getStart(), searchContainer.getEnd(), orderCol, orderByType);
				int count= SrvReqLocalServiceUtil.countSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole"), searchkeywords, conjunctionFlag);
			  	_log.info("jsp result count : " + count);
			  	
			 	_log.info(searchkeywords);
			    searchContainer.setResults(msgList);
			  	searchContainer.setTotal(count);
			} else {//No Search
				if(msgList.size()>0)
					msgList.clear();
				if(!searchkeywords.equals(""))
					conjunctionFlag = true; 
				if(searchkeywords.equals(""))
					searchkeywords="0";
				msgList = SrvReqLocalServiceUtil.getSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole")
						,searchkeywords, false, searchContainer.getStart(), searchContainer.getEnd(), orderCol, orderByType);
				int count= SrvReqLocalServiceUtil.countSrvReqListByRoleStatusCustID(statusList, (String)request.getAttribute("userRole"), searchkeywords, conjunctionFlag);
			  	_log.info("jsp result count : " + count);
			  	
			 	_log.info(searchkeywords);
			    searchContainer.setResults(msgList);
			  	searchContainer.setTotal(count);
			}
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.ejada.atmc.bsl.db.domain.serviceRequest.ServiceRequest" 
			modelVar="srvReq" >

			<%
				SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
				String creationDate = dmyDateFormatter.format(srvReq.getCreationDate());
				String cssClass = "";
				if (!srvReq.getRequestStatus().equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_NEW) &&
						!srvReq.getRequestStatus().equals(CustomerServiceRequestListPortletKeys.REQUEST_STATUS_PENDING) && 
						srvReq.getAssignedTo().equals(AdminCustomerServiceListPortletKeys.USER_ROLES.CUSTOMER_SERVICE_ROLE.getValue())  )
				{
					cssClass = "text-success";
				}
			%>
			<liferay-ui:search-container-column-text name="ref" orderable="true" >
				<portlet:renderURL var="detailsURL">
					<portlet:param name="myview" value="message_details"/>
					<portlet:param name="refNo" value="<%=srvReq.getReferenceNo()+""%>"/>
				</portlet:renderURL>
				<a href="${detailsURL}"><%=srvReq.getReferenceNo() + "<br/><span class='glyphicon glyphicon-calendar'></span> " + creationDate  %></a>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text property="iqamaId" name="policy_from" orderable="true" value="<%=srvReq.getCreatorUserName() + "<br/>" + srvReq.getIqamaId() %>"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="policy_cat_product" orderable="true" value="<%=LanguageUtil.get(request,"Service_Request_Cat_" + srvReq.getRequestCategory().toLowerCase()) +", "+ LanguageUtil.get(request, "Service_Request_Type_" + srvReq.getRequestType()) + "<br/><span class='icon "+LanguageUtil.get(request, "Service_Request_Product_ICON_" + srvReq.getProductType())+" text-muted'></span> <small class='text-muted'>" + LanguageUtil.get(request, "Service_Request_Product_" + srvReq.getProductType()) + "</small>"%>"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Channel" orderable="true" value="<%=srvReq.getSource() %>"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="policy_assign_to" orderable="true" value="<%=srvReq.getAssignedTo() %>"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="policy_status" orderable="true" value="<%= "<span class='"+cssClass+"'>" + LanguageUtil.get(request,"service_request_status_" + srvReq.getRequestStatus()) + "</span>"%>"></liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-jsp path="/adminCustomerServiceList/action_buttons.jsp"/>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</liferay-ui:search-container>

</aui:form>

</div>