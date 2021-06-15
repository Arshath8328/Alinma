<%@page import="com.atmc.side.menu.constants.SideMenuPortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<Layout> siblingLayouts= (List)request.getAttribute(SideMenuPortletKeys.SIBLINGS_LAYOUTS_PUBLIC);
	
	Locale loc = themeDisplay.getLocale();
	
%>
<ul class="list-group">
<%
				for (Layout l :  siblingLayouts)
				{
					if(l.getHidden())
						continue;
					String style= "";
					if (l.getLayoutId() == themeDisplay.getLayout().getLayoutId())
					{
						// this the current page link
						// do whatever you want
						style = "active";
					}
					
%>
						<li class="list-group-item <%=style %>">
							<a href="/web/customer<%=l.getFriendlyURL(loc)%>"><span><%=l.getName(loc)%></span></a>
						</li>
<%
				}	
%>
	</ul>
