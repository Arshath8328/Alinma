<%@page import="admin.policy.list.portlet.AdminPolicyListPortlet"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayPortletResponse"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="java.util.ArrayList"%>
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

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="staffIteratorURL">
	<portlet:param name="mvcPath" value="/view2.jsp" />
</liferay-portlet:renderURL>
<style>
.popover {
	border-color: #C67;
	.
	popover-content
	{
	color
	:
	#C67;
}

.popover.bottom>.arrow {
	border-bottom-color: #C67;
	top: -9px;
}
</style>
<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="manage_policies"/></h1>
<%
	String displayStyle = ParamUtil.getString(request, "displayStyle", "list");
	Log _log = LogFactoryUtil.getLog(AdminPolicyListPortlet.class);
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

	PortletURL portletURL = PortletURLUtil.clone(navigationPortletURL, liferayPortletResponse);
	//add paramter navigation paramter to portletURL
	portletURL.setParameter("navigation", navigation);

	String portletURLString = portletURL.toString();
	portletURL.setParameter("displayStyle", displayStyle);
	pageContext.setAttribute("portletURL", portletURL);
	String currLocale = themeDisplay.getLocale().toString();
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

	QuotationSearch qoutationSearchContainer = new QuotationSearch(renderRequest, portletURL);
%>
<div style="padding: 20px 40px 40px 40px;">

	<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
		<aui:nav-bar-search>
			<aui:form action="<%=staffIteratorURL%>" name="searchFm">
				<liferay-ui:input-search markupView="lexicon" />
			</aui:form>
		</aui:nav-bar-search>
	</aui:nav-bar>


	<aui:form action="<%=staffIteratorURL%>"
		cssClass="container-fluid-fund-stmt" method="post" name="fm">
		<liferay-portlet:renderURLParams varImpl="staffIteratorURL" />

		<liferay-ui:search-container delta="10"
			displayTerms="<%=new DisplayTerms(renderRequest)%>"
			iteratorURL="<%=iteratorURL%>" emptyResultsMessage="No Records Found">

			<liferay-ui:search-container-results>
			<%
				DisplayTerms displayTerms = searchContainer.getDisplayTerms();
				String keywords = displayTerms.getKeywords();
				List<Quotation> quotationsList=new ArrayList<>();
				boolean conjunctionFlag = false;

				if (!Validator.isBlank(keywords)) {//Basic Search

					quotationsList=QuotationLocalServiceUtil.getQuotations(navigation,Long.valueOf(keywords),conjunctionFlag,qoutationSearchContainer.getStart(), qoutationSearchContainer.getEnd());
					Long count = QuotationLocalServiceUtil.getQuotationsCount(navigation, Long.valueOf(keywords), conjunctionFlag);
					searchContainer.setTotal(count.intValue());
					searchContainer.setResults(quotationsList);

					//psPolicies = LNP2_PolicyMastrLocalServiceUtil.searchPSPolicyByIqamaId(keywords);
					//searchContainer.setTotal(psPolicies.size());
					//searchContainer.setResults(ListUtil.subList(psPolicies, searchContainer.getStart(), searchContainer.getEnd()));
				} else {//No Search
					if(quotationsList.size()>0)
						quotationsList.clear();
					if(!keywords.equals(""))
						conjunctionFlag = true; 
					if(keywords.equals(""))
						keywords="0";
					quotationsList=QuotationLocalServiceUtil.getQuotations(null,Long.valueOf(keywords),false,searchContainer.getStart(), searchContainer.getEnd());
					Long count = QuotationLocalServiceUtil.getQuotationsCount(null, Long.valueOf(keywords), conjunctionFlag);
					searchContainer.setTotal(count.intValue());
					searchContainer.setResults(quotationsList);
					
					
					//psPolicies = LNP2_PolicyMastrLocalServiceUtil.findAllPSPolicy();
					//searchContainer.setTotal(psPolicies.size());
					//searchContainer.setResults(ListUtil.subList(psPolicies, searchContainer.getStart(), searchContainer.getEnd()));
				}
			%>
			</liferay-ui:search-container-results>
			<liferay-ui:search-container-row className="com.atmc.bsl.db.domain.quotation.Quotation" keyProperty="quotationId" modelVar="quotation">
		<%
			SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("EEE dd/MM/yyyy");
			try{
				try{
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
					%>
						<span class='text-muted glyphicon glyphicon-calendar'>
							<%=dmyDateFormatter.format(quotation.getQuotationHistory().get(0).getDateTime())%>
						</span>
					<%
						}
						boolean xx = quotation.getQuoteStatus().equals("RJ");
					%>
				</a>
			</liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			
			%>
			<liferay-ui:search-container-column-text name="Quotation Number" orderable="true" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Customer/ID" value="${quotation.insuredName}<br /><span class='text-muted'>${quotation.insuredId}</span>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			%>
			<liferay-ui:search-container-column-text name="Customer/ID" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Product" value="<%="<span class='icon icon-transport-3 text-muted'></span> "+(currLocale.equals("en_US") ? quotation.getProductDescEn():quotation.getProductDescAr())+"<br /><span class='text-muted'>"+((!quotation.getPolicyNo().equals(""))?quotation.getPolicyNo():LanguageUtil.get(request,"policy_not_issues"))%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			%>
			<liferay-ui:search-container-column-text name="Product" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
		<liferay-ui:search-container-column-text name="Insurance Type" value="<%=currLocale.equals("en_US") ? quotation.getVehicleIdDescEn():quotation.getVehicleIdDescAr()%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			%>
			<liferay-ui:search-container-column-text name="Insurance Type" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Channel" value="<%=LanguageUtil.get(request,"channel_code_"+quotation.getSource())%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			%>
			<liferay-ui:search-container-column-text name="Channel" value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-text name="Status"  value="<%=(quotation.getQuoteStatus().equals("RJ"))?(LanguageUtil.get(request,quotation.getQuoteStatus())+" <i class='material-icons text-danger' data-trigger='hover' data-toggle='popover' data-placement='bottom' data-content='"+((quotation.getQuotationHistory()!=null && !quotation.getQuotationHistory().isEmpty())?quotation.getQuotationHistory().get(0).getReason():"")+"'>&#xE88F;</i>"):LanguageUtil.get(request,quotation.getQuoteStatus())%>"></liferay-ui:search-container-column-text>
		<% }catch(Exception e){
			%>
			<liferay-ui:search-container-column-text name="Status"  value=""></liferay-ui:search-container-column-text>
		<%}try{ %>
			<liferay-ui:search-container-column-jsp path="/action_buttons.jsp"/>
		<% }catch(Exception e){} %>
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
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
			
		</liferay-ui:search-container>

	</aui:form>

</div>