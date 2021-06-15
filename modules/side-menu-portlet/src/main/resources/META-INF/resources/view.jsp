<%@page import="com.atmc.side.menu.constants.SideMenuPortletKeys"%>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<Layout> publicLayouts = (List)request.getAttribute(SideMenuPortletKeys.SITE_LAYOUTS_PUBLIC);
	List<Layout> privateLayouts = (List)request.getAttribute(SideMenuPortletKeys.SITE_LAYOUTS_PRIVATE);
	Long notificationsCount = (Long)request.getAttribute("notificationsCount");
	Locale loc = themeDisplay.getLocale();
	List<Layout> menuLayouts = themeDisplay.isSignedIn() ?privateLayouts : publicLayouts;
	String path = themeDisplay.isSignedIn() ? "/group/customer" : "/web/customer";
%>



	<div class="row">
	<div> 
		<nav id="atmc-menu" class="navbar navbar-default navbar-inverse" role="navigation"> 
			<div class="container-fluid"> 
				<div class="navbar-header"> 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
					</button>					 
				</div>				 
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
					<ul class="nav navbar-nav"> 		
<%
				for (Layout l :  menuLayouts)
				{
					if (!l.isRootLayout() || l.getHidden())
						continue;
					if (l.getFriendlyURL(loc).equals("/home"))
					{
%>
						<li>
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>"><span class="glyphicon glyphicon-home"></span></a>
						</li>
<%						
						continue;
					}
					if (l.getFriendlyURL(loc).equals("/dashboard"))
					{
%>
						<li>
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>"><span class="glyphicon glyphicon-th"></span></a>
						</li>
<%						
						continue;
					}
					if (l.getFriendlyURL(loc).equals("/notification"))
					{
%>
						<li>
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>">
							<%
								if (notificationsCount.longValue() > 0)
								{
							%>
							<span class="badge badge-primary" style="float:right;margin-top:-2px;"><%=notificationsCount%></span>
							<%
								}
							%>
							<span class="glyphicon glyphicon-bell"></span></a>
						</li>
<%						
						continue;
					}
%>						
						<li <%=l.hasChildren()?"class=\"dropdown\"":"" %>>
<%
					if (!l.hasChildren())
					{
%>						
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>"><%=l.getName(loc) %></a>
<% 
					}
					else
					{
						List<Layout>children = l.getChildren();
%>
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false"><%=l.getName(loc) %> <span class="caret"></span></a>
							<ul class="dropdown-menu">
<%
						for (Layout child :  children)
						{	
							if (child.getHidden())
								continue;
							if (child.hasChildren())
							{
								if(child.getLayoutType().isBrowsable()){
%>
									<li>
										<a href="<%=path %><%=child.getFriendlyURL(loc)%>"><%=child.getName(loc) %></a>
									</li>
<%
								}else {
%>
									<li class="dropdown-header"><%=child.getName(loc) %></li>
<% 
								}

								List<Layout>gChildren = child.getChildren();
								for (Layout gChild :  gChildren)
								{		
									if (gChild.getHidden())
										continue;
%>
								<li>
									<a href="<%=path %><%=gChild.getFriendlyURL(loc)%>"><%=gChild.getName(loc) %></a>
								</li>	
<%									
								}
							}
							else
							{
%>					
								<li>
									<a href="<%=path %><%=child.getFriendlyURL(loc)%>"><%=child.getName(loc) %></a>
								</li>
<%
							}
						}
%>
							</ul>						
<%
					}
%>		
						</li>
<%
				}
%>								
					</ul>					 
				</div>				 
			</div>			 
		</nav>
	</div>
</div>
<script>
$('ul.nav li.dropdown').hover(function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
	}, function() {
	  $(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
	});
</script>
<!-- 
	<div class="row" data-pg-collapsed>
	<div> 
		<nav class="navbar navbar-default navbar-inverse" role="navigation"> 
			<div class="container-fluid"> 
				<div class="navbar-header"> 
					<button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> 
						<span class="sr-only">Toggle navigation</span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
						<span class="icon-bar"></span> 
					</button>					 
				</div>				 
				<div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1"> 
					<ul class="nav navbar-nav"> 
						<li>
							<a href="#"><span class="glyphicon glyphicon-home"></span></a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">About Us <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Vision & Mission</a>
								</li>
								<li>
									<a href="#">ATMC Strategy</a>
								</li>
								<li>
									<a href="#">Sharia Board</a>
								</li>
								<li>
									<a href="#">Shareholders</a>
								</li>
								<li>
									<a href="#">Board of Directors</a>
								</li>
								<li>
									<a href="#">Senior Management</a>
								</li>
								<li>
									<a href="#">CEO’s Message</a>
								</li>
								<li>
									<a href="#">Awards</a>
								</li>
							</ul>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Individual <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Platinum Savings Program</a>
								</li>
								<li>
									<a href="#">Istithmar Program</a>
								</li>
								<li>
									<a href="#">Gold Savings Program</a>
								</li>
								<li>
									<a href="#">Ta’aleem Program</a>
								</li>
								<li>
									<a href="#">Zawaaj Program</a>
								</li>
							</ul>
						</li>						 
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Corporate <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li class="dropdown-header">Protection and Savings</li>
								<li>
									<a href="#">Group Term Insurance</a>
								</li>
								<li>
									<a href="#">Group Creditor Insurance</a>
								</li>
								<li class="dropdown-header">General Insurance</li>
								<li>
									<a href="#">Fire and Property Risks</a>
								</li>
								<li>
									<a href="#">Marine Insurance</a>
								</li>
								<li>
									<a href="#">Motor Insurance</a>
								</li>
								<li>
									<a href="#">Engineering Insurance</a>
								</li>
								<li>
									<a href="#">Accidents and Liability</a>
								</li>
								<li>
									<a href="#">Medical Insurance</a>
								</li>
								<li>
									<a href="#">Other Lines</a>
								</li>
							</ul>
						</li>
						<li>
							<a href="#">Shareholders Relation</a>
						</li>
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Career <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Life at ATMC</a>
								</li>
								<li>
									<a href="#">Vacancies</a>
								</li>
							</ul>
						</li>						 
						<li class="dropdown">
							<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Contact <span class="caret"></span></a>
							<ul class="dropdown-menu">
								<li>
									<a href="#">Customer Service</a>
								</li>
								<li>
									<a href="#">Branch Locator</a>
								</li>
							</ul>
						</li>
					</ul>					 
				</div>				 
			</div>			 
		</nav>
	</div>
</div>
	 -->