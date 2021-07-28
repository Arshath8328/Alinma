<%@page import="com.atmc.login.constants.LoginPortletKeys"%>
<%@page import="com.ejada.personal.info.constants.PersonalInfoBarPortletKeys"%>
<%-- <%@page import="com.atmc.web.util.SessionUtil"%>
<%@page import="com.atmc.web.common.UserInfo"%>
 --%>
 <%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.liferay.portal.kernel.model.Organization"%>
<%@ include file="/init.jsp" %>   


<% 
		String lang =themeDisplay.getLocale().toString();
		String custName = (lang.equals("en_US")?user.getFullName():(String)user.getExpandoBridge().getAttribute("arabicName",false));
		
//		UserInfo userInfo = SessionUtil.getUserInfo(request);
//		String displayName = (userInfo.isOrgMode())?userInfo.getSelectedOrgName():custName;
		String displayName = custName;
%>

<c:choose>
	<c:when test="<%= themeDisplay.isSignedIn() %>">
		<div class="dropdown">
			<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
			    <span class="glyphicon glyphicon-user"></span> <span class="hidden-xs"><%= HtmlUtil.escape(displayName)%></span> <span class="visible-xs-inline"><%= HtmlUtil.escape(displayName.split(" ")[0])%></span>
			    <span class="glyphicon glyphicon-menu-down"></span>
			</button>
			<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
				<%
						
						if (user.getOrganizations().isEmpty()){
				%>
							
							<li><a href="/group/customer/profile">View Profile</a></li>
				<%
							
						}
						else{
//								if (userInfo.isOrgMode()){
								if(1==1){
									PortletURL selectOwnURL = PortletURLFactoryUtil.create(request, PersonalInfoBarPortletKeys.PERSONALINFOBAR,themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
									selectOwnURL.setParameter(ActionRequest.ACTION_NAME, "selectOwn");

				%>
							<li><a href="<%=selectOwnURL.toString()%>"><span class="hidden-xs"><%= HtmlUtil.escape(custName)%></span> <span class="visible-xs-inline"><%= HtmlUtil.escape(custName.split(" ")[0])%></span></a></li>
				<% 							
								}
								
								for (Organization org : user.getOrganizations()) {
								
								
//								if (userInfo.isOrgMode() && org.getOrganizationId() == userInfo.getSelectedOrgId())
								if(1==1)
										continue;
								String orgCRNumber = (String)org.getExpandoBridge().getAttribute("CRNumber",false);
								PortletURL selectOrgURL = PortletURLFactoryUtil.create(request, PersonalInfoBarPortletKeys.PERSONALINFOBAR,themeDisplay.getPlid(), PortletRequest.ACTION_PHASE);
								selectOrgURL.setParameter(ActionRequest.ACTION_NAME, "selectOrg");
								selectOrgURL.setParameter("orgCRNumber", orgCRNumber);
								selectOrgURL.setParameter("orgName", org.getName());
								selectOrgURL.setParameter("orgId", String.valueOf(org.getOrganizationId()));

					%>
						<li><a href="<%=selectOrgURL.toString()%>"><%= org.getName() %></a></li>
					<%
							}
						}
					%>
			</ul>
		</div>
			<portlet:actionURL name="logout"  var="logoutURL">
			</portlet:actionURL>
			<a href="<%=logoutURL%>" class="logout_link"><liferay-ui:message key="logout"/></a>
	</c:when>
	<c:otherwise>

	<div id="openDiv" class="btn btn-primary btn-outline"><i class="material-icons">&#xE315;</i> <liferay-ui:message key="sign-in"/></div>
	
	<liferay-portlet:renderURL portletName="<%=LoginPortletKeys.LOGIN%>" var="loginPortletURL" windowState="<%= LiferayWindowState.POP_UP.toString() %>">
		<liferay-portlet:param name="mvcRenderCommandName" value="/login/login" />
	</liferay-portlet:renderURL>
	
	<aui:script use="liferay-util-window,liferay-portlet-url">
	A.one('#openDiv').on('click', function(event) {
		Liferay.Util.openWindow(
				{
					cache: false,
					dialog: {
						destroyOnHide: true,
						cssClass: 'atmc-popup',
						align: Liferay.Util.Window.ALIGN_CENTER,
						modal:true,
						resizable: false,
						width: 845,
						height: 421
					},
					dialogIframe: {
						id: '<portlet:namespace />dialog',
						uri: '<%=loginPortletURL.toString()%>'
					},
					uri: '<%=loginPortletURL.toString()%>'
				});
	    
	}); 
	</aui:script>

	</c:otherwise>
</c:choose>	
<style>
@media (max-width: 767px) {
    .atmc-popup {
		height: 80% !important;
		top: 10% !important;
	}
	.atmc-popup-content .modal-body{
		height: 100% !important;
		max-height: 100% !important;
	} 
	.atmc-popup .modal-content .dialog-iframe-node{
		height: 100% !important;
	}
}

</style>
