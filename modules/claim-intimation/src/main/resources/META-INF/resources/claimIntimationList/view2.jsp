<%@page import="claim.intimation.portlet.ClaimIntimationListPortlet"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="java.text.DateFormat"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@page import="com.ejada.atmc.acl.db.custom.model.ClaimIntimationMtrDTO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.dao.search.DisplayTerms"%>
<%@page import="com.ejada.atmc.acl.db.model.ClaimIntimationMtr"%>
<%@page import="com.ejada.atmc.acl.db.service.ClaimIntimationMtrLocalServiceUtil"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@ include file="/init.jsp" %>

<%@page import="com.liferay.portal.kernel.util.ListUtil"%>
<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<style>
th{
	text-align: center;
    font-weight: bold !important;
}
.inner-table th {
    font-weight: bold;
    text-align: center;
    background-color:#d9edf7;
}
.inner-table td {
	padding: 10px;
}
.inner-table {
	padding: 0px;
}
details > summary {
  padding: 2px 6px;
  width: 15em;
  background-color: #ddd;
  border: none;
  box-shadow: 3px 3px 4px black;
  cursor: pointer;
}

details > table {
  border-radius: 0 0 10px 10px;
  background-color: #ddd;
  padding: 2px 6px;
  margin: 0;
  box-shadow: 3px 3px 4px black;
}

details[open] > summary {
  background-color: #ccf;
}
.inner-table {
	border-spacing: 0px;
}
.table-cell {
	text-align: center;
}
</style>
<liferay-portlet:renderURL varImpl="iteratorURL">
	<portlet:param name="mvcPath" value="/claimIntimationList/view2.jsp" />
</liferay-portlet:renderURL>

<portlet:actionURL name="updateStatus"  var="updateStatusURL">
</portlet:actionURL>
<liferay-portlet:renderURL varImpl="claimIntimationIteratorURL">
	<portlet:param name="mvcPath" value="/claimIntimationList/view2.jsp" />
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

<%
	Log _log = LogFactoryUtil.getLog(this.getClass());
	Map<String, List<String>> documents = new HashMap<>();
	String lang = themeDisplay.getLocale().toString();
%>
<aui:form action="<%= updateStatusURL %>" method="post" name="updateStatusForm" id="updateStatusForm" role="form">
	<aui:input type="hidden" name="claimStatus"/>
	<aui:input type="hidden" name="claimIntimationMtr"/>
</aui:form>
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
				claimIntimationList = ClaimIntimationMtrLocalServiceUtil.getAllClaims();
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
			
			<liferay-ui:search-container-column-text name="Refrence Number">
				<details>
				 <summary><%=claimIntimation.getIntimationReferenceNo() %></summary>
				  <p>
				    <% if(claimDTOSFromView!=null && !claimDTOSFromView.isEmpty()) {
					    	DateFormat df = new SimpleDateFormat("MM/dd/yy");
					    	%>
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
					               		<td><%=claimDTO.getCreationDate()!=null ? df.format(claimDTO.getCreationDate()) : ""%></td>
			              		 	</tr>
			              	<%}%>
			              		</tbody>
			              	</table> <%
			            } %>  
				  </p>
		         </details> 
              </liferay-ui:search-container-column-text>
            <liferay-ui:search-container-column-text name="Downloads">
            	<%
            		Map<String,List<String>> docs = ClaimIntimationListPortlet.getDownloadLinksOfdocuments(claimIntimation.getIntimationReferenceNo(), themeDisplay);
            		if(docs!=null) {
            			documents.putAll(docs);
            		}
            	%>
	            <a id="documents<%=String.valueOf(claimIntimation.getClaimIntimationMotorId())%>" 
	            onclick="downloadDocuments('<%=String.valueOf(claimIntimation.getIntimationReferenceNo())%>')"><img style="width:30%" src="https://img.icons8.com/pastel-glyph/64/000000/download--v1.png"/></a>
            </liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Claimant Type" value="<%= ClaimIntimationListPortlet.claimTypeCodeValuePair.get(claimIntimation.getClaimantType()) %>" />
			<liferay-ui:search-container-column-text name="Policy No" property="policyNo" />
			<liferay-ui:search-container-column-text name="Status">
				<select style="width: auto" onchange="updateStatusForm(<%= String.valueOf(claimIntimation.getClaimIntimationMotorId()) %>)" class="form-control" name="claimStatus" id="claimStatus<%= String.valueOf(claimIntimation.getClaimIntimationMotorId()) %>" label="">
					<%
						List<CodeMasterDetails> statusList = ClaimIntimationListPortlet.statusList;
						if(Validator.isNotNull(statusList)){
							for (CodeMasterDetails status : statusList) {
								String statusDesc = (lang.equals("en_US"))?status.getCodeDesc():status.getCodeDescAr();
								if(Integer.parseInt(status.getCodeSub())  <= 10) {
									if(status.getCodeSub().equals(String.valueOf(claimIntimation.getClaimStatus()))) {
										_log.info("Status: " +claimIntimation.getClaimIntimationMotorId() + " -> " +  statusDesc);
										%>
										<option value="<%=status.getCodeSub() %>" selected><%=statusDesc%></option>
										<%
									} else {
										%>
										<option value="<%=status.getCodeSub() %>"><%=statusDesc%></option>
										<% 
									}
								}
							}
						} %>
				</select>
			</liferay-ui:search-container-column-text>
			<liferay-ui:search-container-column-text name="Vehicle Plate No" property="vehiclePlateNo" />
			<liferay-ui:search-container-column-text name="Sequence No" property="sequenceNo" />
			<liferay-ui:search-container-column-text name="Chassis No" property="chassisNo" />
			<liferay-ui:search-container-column-text name="Iban No" property="ibanNumber" />
			<liferay-ui:search-container-column-text name="Email ID" property="emailId" />
			
			<liferay-ui:search-container-column-text name="Bank Name"> 
				<%=	 (lang.equals("en_US")) ? 	ClaimIntimationListPortlet.bankNameCodeValuePair.get(claimIntimation.getBankName())
						 					:	ClaimIntimationListPortlet.bankNameCodeValuePairAR.get(claimIntimation.getBankName()) %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Cause Of Loss" value="<%=
					 (lang.equals("en_US")) ? 	ClaimIntimationListPortlet.causeOfLossCodeValuePair.get(claimIntimation.getCauseOfLoss())
						 					:	ClaimIntimationListPortlet.causeOfLossCodeValuePairAR.get(claimIntimation.getCauseOfLoss()) %>" />

			<liferay-ui:search-container-column-text name="Date Of Loss" value="<%= new SimpleDateFormat("MM/dd/yy").format(claimIntimation.getDateOfLoss()) %>"/>
			
			<liferay-ui:search-container-column-text name="Accident City" value="<%= 
					(lang.equals("en_US")) 	? 	ClaimIntimationListPortlet.accidentCityCodeValuePair.get(claimIntimation.getAccidentCity()) 
											:	ClaimIntimationListPortlet.accidentCityCodeValuePairAR.get(claimIntimation.getAccidentCity()) %>"/>

			<liferay-ui:search-container-column-text name="Src Of Accident Report">
			 	<%= (lang.equals("en_US")) 	? 	ClaimIntimationListPortlet.sourceOfAccidentReportMap.get(claimIntimation.getSrcOfAccidentReport()) 
											:	ClaimIntimationListPortlet.sourceOfAccidentReportMapAR.get(claimIntimation.getSrcOfAccidentReport()) %>
			</liferay-ui:search-container-column-text>

			<liferay-ui:search-container-column-text name="Accident Report No" property="accidentReportNo" />
			
			<liferay-ui:search-container-column-text name="Vehicle Make" value="<%= 
					 (lang.equals("en_US")) ? 	ClaimIntimationListPortlet.vehicleMakeMap.get(claimIntimation.getVehicleMake()) 
					 						:	ClaimIntimationListPortlet.vehicleMakeMapAR.get(claimIntimation.getVehicleMake()) %>"/>

			<liferay-ui:search-container-column-text name="Vehicle Model" > 
				<%= ClaimIntimationListPortlet.vehicleModelMap.get(claimIntimation.getVehicleModel()) %>
			</liferay-ui:search-container-column-text>
			
			<liferay-ui:search-container-column-text name="Driver Name" property="driverName" />
			
			<liferay-ui:search-container-column-text name="Driver Nationality" value="<%= 
					 (lang.equals("en_US")) ? 	ClaimIntimationListPortlet.nationalityMap.get(claimIntimation.getDriverNationality()) 
					 						:	ClaimIntimationListPortlet.nationalityMapAR.get(claimIntimation.getDriverNationality()) %>"/>

			<liferay-ui:search-container-column-text name="Driver NationalId" property="driverNationalId" />
			<liferay-ui:search-container-column-text name="Driver BirthDate" value="<%= new SimpleDateFormat("MM/dd/yy").format(claimIntimation.getDriverBirthDate()) %>"/>
			<liferay-ui:search-container-column-text name="Driver Gender" ><p><%= ClaimIntimationListPortlet.genderMap.get(String.valueOf(claimIntimation.getDriverGender())) %></p></liferay-ui:search-container-column-text>
		</liferay-ui:search-container-row>
		<liferay-ui:search-iterator searchContainer="<%=searchContainer%>" />
	</liferay-ui:search-container>
</aui:form>

</div>
<script>
var documentsMap = new Map();
$(document).ready(function() {
	<% 
		for(Map.Entry<String, List<String>> set : documents.entrySet()) { %>
			var url = [];
			<%for(int i=0; i<set.getValue().size(); i++){%>
				url[<%=i%>] = '<%=set.getValue().get(i)%>';
			<%}
			%>
			documentsMap.set('<%=set.getKey()%>',url);
		<%}
	%>
});
function updateStatusForm(claimId){
	var statusform = document.getElementById("_ATMCClaimIntimationList_updateStatusForm");
	var changedStatus = statusform.elements['_ATMCClaimIntimationList_claimStatus'];
	var claimMtrId = statusform.elements['_ATMCClaimIntimationList_claimIntimationMtr'];
	changedStatus.value = document.getElementById('claimStatus'+claimId).value;
	claimMtrId.value = claimId;
	statusform.submit();
}

function downloadDocuments(intimationReferenceNo){
	for (let [key, value] of documentsMap.entries()) {
		if(key.localeCompare(intimationReferenceNo)==0) {
			for(let i=0; i<value.length; i++){
				window.open(value[i]);
			}
		}
	}
}
</script>