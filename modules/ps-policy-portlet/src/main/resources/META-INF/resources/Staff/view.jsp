<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ejada.atmc.acl.db.service.LNP2_PolicyMastrLocalServiceUtil"%>
<%@ include file="/init.jsp" %>
<%@page import="com.ejada.atmc.acl.db.custom.model.PSPolicy"%>

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/Staff/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="psPolicyIteratorURL">
	<portlet:param name="mvcPath" value="/Staff/view.jsp" />
</liferay-portlet:renderURL>

<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="pspolicy.staff"/></h1>

<div style="padding: 20px 40px 40px 40px;">

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= psPolicyIteratorURL %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>


<aui:form action="<%= psPolicyIteratorURL %>" cssClass="container-fluid-fund-stmt" method="post" name="fm">
	<liferay-portlet:renderURLParams varImpl="psPolicyIteratorURL" />

	<liferay-ui:search-container delta="10" displayTerms="<%=new DisplayTerms(renderRequest)%>"
		iteratorURL="<%=iteratorURL%>" emptyResultsMessage="No Records Found">

		<%-- <liferay-ui:search-form page="/Staff/search.jsp" servletContext="<%=application%>" /> --%>
		<liferay-ui:search-container-results>
			
			<%
			DisplayTerms displayTerms = searchContainer.getDisplayTerms();
			String keywords = displayTerms.getKeywords();
			List<PSPolicy> psPolicies = Collections.EMPTY_LIST;
			if (!Validator.isBlank(keywords)) {//Basic Search
				psPolicies = LNP2_PolicyMastrLocalServiceUtil.searchPSPolicyByIqamaId(keywords);
				searchContainer.setTotal(psPolicies.size());
				searchContainer.setResults(ListUtil.subList(psPolicies, searchContainer.getStart(), searchContainer.getEnd()));
			} else {//No Search
				psPolicies = LNP2_PolicyMastrLocalServiceUtil.findAllPSPolicy();
				searchContainer.setTotal(psPolicies.size());
				searchContainer.setResults(ListUtil.subList(psPolicies, searchContainer.getStart(), searchContainer.getEnd()));
			}
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.ejada.atmc.acl.db.custom.model.PSPolicy" keyProperty="proposal_no"
			modelVar="psPolicy" >

			<portlet:renderURL var="psDetail">
				<portlet:param name="mvcPath" value="/Staff/details.jsp"/>
				<portlet:param name="proposalNo" value="<%= String.valueOf(psPolicy.getProposal_no()) %>"/>
				<portlet:param name="backURL" value="<%= themeDisplay.getURLCurrent() %>"></portlet:param>
			</portlet:renderURL>
			
			<liferay-ui:search-container-column-text href="<%=psDetail%>" name="Proposal No" property="proposal_no" />
			
			<liferay-ui:search-container-column-text name="Iquma Id" property="iqumaId" />
			<liferay-ui:search-container-column-text name="Client Code" value="<%= String.valueOf(psPolicy.getClient_Code()) %>" />
			<liferay-ui:search-container-column-text name="Client Name" property="client_name" />
			<liferay-ui:search-container-column-text name="Status Description" property="status_description" />
			<liferay-ui:search-container-column-text name="Issue Date" property="issue_date" />
			<liferay-ui:search-container-column-text name="Policy Expiry Date" property="policy_expiry_date" />

		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</liferay-ui:search-container>

</aui:form>

</div>