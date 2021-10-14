<%@page import="com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.ejada.atmc.acl.db.model.ClaimIntimationMtr"%>
<%@page import="com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ejada.atmc.acl.db.service.LNP2_PolicyMastrLocalServiceUtil"%>
<%@ include file="/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>

<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/claimIntimationList/view.jsp" />
</liferay-portlet:renderURL>

<liferay-portlet:renderURL varImpl="claimIntimationIteratorURL">
	<portlet:param name="mvcPath" value="/claimIntimationList/view.jsp" />
</liferay-portlet:renderURL>

<h1 class="text-center" style="margin-top: 0;padding-top: 10px;"><liferay-ui:message key="claimIntimation.staff"/></h1>

<div style="padding: 20px 40px 40px 40px;">

<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav-bar-search>
		<aui:form action="<%= claimIntimationIteratorURL %>" name="searchFm">
			<liferay-ui:input-search markupView="lexicon" />
		</aui:form>
	</aui:nav-bar-search>
</aui:nav-bar>


<aui:form action="<%= claimIntimationIteratorURL %>" cssClass="container-fluid-fund-stmt" method="post" name="fm">
	<liferay-portlet:renderURLParams varImpl="claimIntimationIteratorURL" />

	<liferay-ui:search-container delta="10" displayTerms="<%=new DisplayTerms(renderRequest)%>"
		iteratorURL="<%=iteratorURL%>" emptyResultsMessage="No Records Found">

		<%-- <liferay-ui:search-form page="/Staff/search.jsp" servletContext="<%=application%>" /> --%>
		<liferay-ui:search-container-results>
			
			<%
			DisplayTerms displayTerms = searchContainer.getDisplayTerms();
			String keywords = displayTerms.getKeywords();
			List<ClaimIntimationMtr> claimIntimationList = Collections.EMPTY_LIST;
			if (!Validator.isBlank(keywords)) {//Basic Search
				claimIntimationList = ClaimIntimationMtrLocalServiceUtil.findClaimIntimationList(keywords);
				searchContainer.setTotal(claimIntimationList.size());
				searchContainer.setResults(ListUtil.subList(claimIntimationList, searchContainer.getStart(), searchContainer.getEnd()));
			} else {//No Search
				claimIntimationList = ClaimIntimationMtrLocalServiceUtil.getClaimIntimationMtrs(-1, -1);
				searchContainer.setTotal(claimIntimationList.size());
				searchContainer.setResults(ListUtil.subList(claimIntimationList, searchContainer.getStart(), searchContainer.getEnd()));
			}
			%>
		</liferay-ui:search-container-results>
		<liferay-ui:search-container-row
			className="com.ejada.atmc.acl.db.model.ClaimIntimationMtr" keyProperty="claimIntimationMotorId"
			modelVar="claimIntimation" >
			<%
				List<ClaimIntimationMtrDTO> claimDTOSFromView = ClaimIntimationMtrLocalServiceUtil.findClaimIntimationListFromView(claimIntimation.getIntimationReferenceNo());
			%>
			<liferay-ui:search-container-column-text name="CIM No" property="claimIntimationMotorId" />
			
			<liferay-ui:search-container-column-text name="Refrence Number">
				<div class="panel panel-default">
		            <div class="panel-heading" id="heading<%= claimIntimation.getClaimIntimationMotorId()%>" role="tab">
		               <a aria-controls="collapse<%= claimIntimation.getClaimIntimationMotorId()%>" aria-expanded="false" class="collapsed" 
		                data-toggle="collapse" href="#collapse<%= claimIntimation.getClaimIntimationMotorId()%>" role="button" target="_blank"><%=claimIntimation.getIntimationReferenceNo() %></a></h4>
		            </div>
		            <div aria-expanded="false" aria-labelledby="heading<%= claimIntimation.getClaimIntimationMotorId()%>" class="panel-collapse collapse" id="collapse<%= claimIntimation.getClaimIntimationMotorId()%>" role="tabpanel" style="height: 0px;">
		               <div class="panel-body">
		               <% if(claimDTOSFromView!=null && !claimDTOSFromView.isEmpty()) {%>
		              		 <table class="inner-table">
		              		 	<thead>
		              		 	<tr>
			              		 	<th>Claim Number</th>
			              		 	<th>Policy Number</th>
			              		 	<th>Claim Status</th>
			              		 	<th>Created By</th>
			              		 	<th>Creation Date</th>
		              		 	</tr>
		              		 	</thead>
		               		<%for(ClaimIntimationMtrDTO claimDTO : claimDTOSFromView) {
		              		 %>
		              		 	<tbody>
		              		 	<tr>
				               		<td><%=claimDTO.getClaimNumber() %></td>
				               		<td><%=claimDTO.getPolicyNumber() %></td>
				               		<td><%=claimDTO.getClaimStatus() %></td>
				               		<td><%=claimDTO.getCreatedBy()%></td>
				               		<td><%=claimDTO.getCreationDate() %></td>
		              		 	</tr>
		               		<%}%>
		              		 	</tbody>
		              		 </table>
		               <%	} %>   
		               </div>
		            </div>
		         </div> 
              </liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Claimant Type" property="claimantType" />
			<liferay-ui:search-container-column-text name="Policy No" property="policyNo" />
			<liferay-ui:search-container-column-text name="Vehicle Plate No" property="vehiclePlateNo" />
			<liferay-ui:search-container-column-text name="Sequence No" property="sequenceNo" />
			<liferay-ui:search-container-column-text name="Chassis No" property="chassisNo" />
			<liferay-ui:search-container-column-text name="Cause Of Loss" property="causeOfLoss" />
			<liferay-ui:search-container-column-text name="Date Of Loss" value="<%= new SimpleDateFormat("MM/dd/yy").format(claimIntimation.getDateOfLoss()) %>"/>
			<liferay-ui:search-container-column-text name="Accident City" property="accidentCity" />
			<liferay-ui:search-container-column-text name="Source Of Accident Report" property="srcOfAccidentReport" />
			<liferay-ui:search-container-column-text name="Accident Report No" property="accidentReportNo" />
			<liferay-ui:search-container-column-text name="Vehicle Make" property="vehicleMake" />
			<liferay-ui:search-container-column-text name="Vehicle Model" property="vehicleModel" />
			<liferay-ui:search-container-column-text name="Driver Name" property="driverName" />
			<liferay-ui:search-container-column-text name="Driver Nationality" property="driverNationality" />
			<liferay-ui:search-container-column-text name="Driver NationalId" property="driverNationalId" />
			<liferay-ui:search-container-column-text name="Driver BirthDate" value="<%= new SimpleDateFormat("MM/dd/yy").format(claimIntimation.getDriverBirthDate()) %>"/>
			<liferay-ui:search-container-column-text name="Driver Gender" property="driverGender" />
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</liferay-ui:search-container>
</aui:form>

</div>