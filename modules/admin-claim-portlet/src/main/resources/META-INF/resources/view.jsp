<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.search.SearchContextFactory"%>
<%@page import="com.liferay.portal.kernel.search.SearchContext"%>
<%@page import="com.atmc.bsl.db.service.ClaimLocalServiceUtil"%>
<%@page import="com.atmc.web.search.ClaimSearchCon"%>
<%@page import="com.atmc.web.search.ClaimSearchTerms"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.bsl.db.domain.claim.Claim"%>
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

<%@page
	import="com.liferay.portal.kernel.security.permission.ActionKeys"%>
<%@page
	import="com.liferay.portal.kernel.service.permission.RolePermissionUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@ include file="/init.jsp"%>

<h1 class="text-center" style="margin-top: 0; padding-top: 10px;">
	<liferay-ui:message key="manage_claims" />
</h1>
<%
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");

	PortletURL navigationPortletURL = renderResponse.createRenderURL();
	PortletURL surveyorNavigationPortletURL = renderResponse.createRenderURL();

	PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);
	String portletURLString = portletURL.toString();
	portletURL.setParameter("displayStyle", displayStyle);

	//pageContext.setAttribute("portletURL", portletURL);
	PortletURL iteratorURL = renderResponse.createRenderURL();
	List<Claim> claimsList = (List<Claim>) request.getAttribute("claimsList");
	String currLocale = themeDisplay.getLocale().toString();
	String lang = themeDisplay.getLocale().toString();
	//orderByCol is the column name passed in the request while sorting
	String orderByCol = ParamUtil.getString(request, "orderByCol");

	//orderByType is passed in the request while sorting. It can be either asc or desc
	String orderByType = ParamUtil.getString(request, "orderByType");
	String sortingOrder = orderByType;
	//Logic for toggle asc and desc
	if (orderByType.equals("desc")) {
		orderByType = "asc";
	} else {
		orderByType = "desc";
	}

	if (Validator.isNull(orderByType)) {
		orderByType = "desc";
	}
	ClaimSearchCon claimSearch = new ClaimSearchCon(renderRequest, portletURL);

	ClaimSearchTerms displayTerms = (ClaimSearchTerms) claimSearch.getDisplayTerms();
	System.out.println(displayTerms.getStatus());
	String navigationStatus = ParamUtil.getString(request, "navigationStatus", "status");
	String statsVar = "";

	if (navigationStatus.equals("status")) {
		statsVar = "";
	} else if (navigationStatus.equals("SUBMITTED")) {
		statsVar = "SUBMITTED";
	} else if (navigationStatus.equals("MISSINGDOCUMENTSFROMCP")) {
		statsVar = "MISSINGDOCUMENTSFROMCP";
	} else if (navigationStatus.equals("CLAIMUNDERINVESTIGATION")) {
		statsVar = "CLAIMUNDERINVESTIGATION";
	} else if (navigationStatus.equals("RECOVERYDONE")) {
		statsVar = "RECOVERYDONE";
	} else if (navigationStatus.equals("APPROVEDBYCLAIMSMANAGER")) {
		statsVar = "APPROVEDBYCLAIMSMANAGER";
	} else if (navigationStatus.equals("RECOVERYREQUESTED")) {
		statsVar = "RECOVERYREQUESTED";
	} else if (navigationStatus.equals("SURVEYREQUIRED")) {
		statsVar = "SURVEYREQUIRED";
	} else if (navigationStatus.equals("REPAIRAPPROVED")) {
		statsVar = "REPAIRAPPROVED";
	} else if (navigationStatus.equals("SURVEYREJECTED")) {
		statsVar = "SURVEYREJECTED";
	} else if (navigationStatus.equals("CLAIMREJECTED")) {
		statsVar = "CLAIMREJECTED";
	} else if (navigationStatus.equals("PAYMENTREJECTED")) {
		statsVar = "PAYMENTREJECTED";

	} else if (navigationStatus.equals("MISSINGDOCUMENTSFROMCUSTOMER")) {
		statsVar = "MISSINGDOCUMENTSFROMCUSTOMER";

	} else if (navigationStatus.equals("RECOVERYNOTREQUIRED")) {
		statsVar = "RECOVERYNOTREQUIRED";

	}
	String navigationSurveyor = ParamUtil.getString(request, "navigationSurveyor", "surveyor");
	String surveyorVar = "";
	if (navigationSurveyor.equals("surveyor")) {
		surveyorVar = "";
	} else if (navigationSurveyor.equals("muroor")) {
		surveyorVar = "01";
	} else if (navigationSurveyor.equals("najm")) {
		surveyorVar = "03";
	}
%>

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%=portletURLString%>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>
<liferay-frontend:management-bar includeCheckBox="<%=false%>"
	searchContainerId="claimSearch">
	<liferay-frontend:management-bar-filters>

		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[]
							{ "status", "SUBMITTED", "MISSINGDOCUMENTSFROMCP", "CLAIMUNDERINVESTIGATION", "RECOVERYDONE", "APPROVEDBYCLAIMSMANAGER", "RECOVERYREQUESTED", "SURVEYREQUIRED",
									"REPAIRAPPROVED", "SURVEYREJECTED", "CLAIMREJECTED", "PAYMENTREJECTED", "MISSINGDOCUMENTSFROMCUSTOMER", "RECOVERYNOTREQUIRED" }%>'
			navigationParam="navigationStatus"
			portletURL="<%=navigationPortletURL%>" />
		<liferay-frontend:management-bar-navigation
			navigationKeys='<%=new String[] { "surveyor", "muroor", "najm" }%>'
			navigationParam="navigationSurveyor"
			portletURL="<%=surveyorNavigationPortletURL%>" />
	</liferay-frontend:management-bar-filters>
	<liferay-frontend:management-bar-buttons>
		<liferay-frontend:management-bar-display-buttons
			displayViews='<%=new String[] { "list" }%>'
			portletURL="<%=portletURL%>"
			selectedDisplayStyle="<%=displayStyle%>" />
	</liferay-frontend:management-bar-buttons>

	<liferay-frontend:management-bar-action-buttons>
		<liferay-frontend:management-bar-button href="javascript:;"
			icon="trash" id="deleteRoles" label="delete" />
	</liferay-frontend:management-bar-action-buttons>
</liferay-frontend:management-bar>
<aui:form action="<%=portletURLString%>"
	cssClass="container-fluid-1280" method="get" name="fm">
	<aui:input name="deleteRoleIds" type="hidden" />

	<liferay-portlet:renderURLParams varImpl="portletURL">
	</liferay-portlet:renderURLParams>
</aui:form>
<liferay-ui:search-container iteratorURL="<%=iteratorURL%>"
	id="claimSearch" searchContainer="<%=claimSearch%>">

	<liferay-ui:search-container-results>
		<%
			String searchkeywords = displayTerms.getKeywords();
					int count = ClaimLocalServiceUtil.findClaimsCountsPolicyStatusAdmin(statsVar, surveyorVar, searchkeywords);
					System.out.println("Claims Count:" + count);
					//	pageContext.setAttribute("results",ListUtil.subList(ClaimLocalServiceUtil.getAllClaims(statsVar,surveyorVar,searchkeywords), claimSearch.getStart(), claimSearch.getEnd()));
					// pageContext.setAttribute("total", count);
					searchContainer.setResults(ClaimLocalServiceUtil.getAllClaims(statsVar, surveyorVar, searchkeywords, claimSearch.getStart(), claimSearch.getEnd()));
					searchContainer.setTotal(count);
					System.out.println(searchkeywords);
		%>
	</liferay-ui:search-container-results>

	<liferay-ui:search-container-row
		className="com.atmc.bsl.db.domain.claim.Claim"
		keyProperty="claimId" modelVar="claim">

		<%
			SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
					//dmyDateFormatter.format(date);
					String policyType = (lang.equals("en_US") ? claim.getProductDescEn() : claim.getProductDescAr());
		%>

		<liferay-ui:search-container-column-text value=""></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="claimNo">
			<portlet:renderURL var="detailsURL">
				<portlet:param name="myview" value="details" />
				<portlet:param name="claimRefNo" value="<%=claim.getClaimNo()%>" />
				<portlet:param name="policyNo" value="<%=claim.getPolicyNo()%>" />
				<portlet:param name="policyProductDescAr"
					value="<%=claim.getProductDescAr()%>" />
				<portlet:param name="policyProductDescEN"
					value="<%=claim.getProductDescEn()%>" />
				<portlet:param name="policyProduct" value="<%=claim.getProduct()%>" />
			</portlet:renderURL>
			<a href="${detailsURL}"><%=claim.getClaimNo() + "<br />"
								+ ((claim.getClaimHistory() != null && !claim.getClaimHistory().isEmpty()) ? dmyDateFormatter.format(claim.getClaimHistory().get(0).getHisoryDate()) : " ")%></a>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Claimant/Policy"
			value="${claim.claimAntName}<br />${claim.policyNo}"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Claim Type/Product"
			value="<%=lang.equals("en_US") ? claim.getProductDescEn() : claim.getProductDescAr()%>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Surveyor"
			value="<%=LanguageUtil.get(request, "claim_status_" + claim.getReportType())%>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Channel"
			value="${claim.reportType}"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="ODS Status"
			value="${claim.claimStatus}"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="Workflow Status"
			value="<%=claim.getWorkflowStatus() != null ? (claim.getWorkflowStatus().equals("") ? "" : LanguageUtil.get(request, "claims_status_" + claim.getWorkflowStatus())) : ""%>"></liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-jsp path="/actionButtons.jsp" />
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator searchContainer="<%=claimSearch%>"
		markupView="lexicon" />
</liferay-ui:search-container>

