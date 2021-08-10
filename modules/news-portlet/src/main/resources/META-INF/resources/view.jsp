<%@page import="com.atmc.news.constants.NewsPortletKeys"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp"%>

<%
	Locale theLocale = themeDisplay.getLocale();
	List<String> newsArticles = (List<String>) request.getAttribute(NewsPortletKeys.NEWS);
%>
<div class="row">
	<div class="col-md-12 no-pad">
		<div id="carousel1" class="carousel slide news-carousel"
			data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#carousel1" data-slide-to="0" class="active"></li>
				<li data-target="#carousel1" data-slide-to="1"></li>
				<li data-target="#carousel1" data-slide-to="2"></li>
			</ol>
			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<%
					String active = "active";
					for (String newss : newsArticles) {
				%>
				<div class="carousel-item <%=active%>">
					<%=newss%>
				</div>

				<%
					active = "";
					}
				%>
			</div>
		</div>
	</div>
</div>
