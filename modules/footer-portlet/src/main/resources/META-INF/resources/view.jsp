<%@page import="com.atmc.footer.constants.FooterPortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil" %>
<%@page import="java.util.Locale"%>
<%@page import="com.liferay.portal.kernel.model.Layout"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%
	List<Layout> menuLayouts = (List)request.getAttribute(FooterPortletKeys.SITE_LAYOUTS_PUBLIC);	
	Locale loc = themeDisplay.getLocale();
	
	String path =  "/web/customer";
%>
<footer id="siteFooter">
	<div class="footer">
		<div class="container">
			<div class="row vcenter"> 
				<div class="col-md-6 pad-5 center-small">
					<img src="/o/atmc-theme/images/logo_small.svg" class="logo" width="40" />
					<small class="text-muted"><liferay-ui:message key="copyright"/></small>
				</div>
				<div class="col-md-6 pad-5 text-right">
					<div class="social-networks">
						<h3 class="text-primary"><liferay-ui:message key="follow_us"/></h3>
						<a href="https://www.facebook.com/108112077221697/posts/153168416049396/" class="facebook" target="_blank"><i class="icon-facebook"></i></a>
						<a href="https://www.linkedin.com/company/alinmatokiomarine/" class="linkedin" target="_blank"><i class="icon-linkedin"></i></a>
						<a href="https://www.instagram.com/p/B5DYVGLARg4/?igshid=1geyf9tasawqw" class="instagram" target="_blank"><i class="icon-instagram"></i></a>
						<a href="https://twitter.com/atmc_sa/status/1196819412113928193?s=12" class="youtube" target="_blank"><i class="icon-twitter"></i></a>
					</div>
					<div id="toggleFooterDetails" class="btn btn-more">
						<span id="toggleIcon" class="icon-chevron-up"></span>
					</div><span id="moreTxt"><liferay-ui:message key="more"/></span>  
				</div>
			</div>
		</div>
	</div>
	<div id="footerDetails" class="footer-details" style="display:none;">
		<div class="container">
	<div class="row vcenter">
		<div class="col-sm-4">
			<%-- <div class="row vcenter vcenter-small">
				<div class="col-xs-3 col-md-3">
					<div class="nav-title">
						<liferay-ui:message key="sitemap"/>
					</div>		
				</div>
				<div class="col-xs-9 col-md-9">
					<ul class="footer-nav">
<%
						for (Layout l :  menuLayouts)
						{
							if (!l.isRootLayout() || l.getHidden())
								continue;
							if (l.getFriendlyURL(loc).equals("/home"))
								continue;
%>			
						<li>
							<a href="<%=path %><%=l.getFriendlyURL(loc)%>"><%=l.getName(loc) %></a>
						</li>
<%
						}
%>				
							 
					</ul>
				</div>
			</div> --%>
			
			<div class="row vcenter vcenter-small">
				<div class="col-xs-12 col-md-12" style="font-size: 11px;">
				<p><b><liferay-ui:message key="site_name"/></b></p>
				<p><liferay-ui:message key="saudi_stock_company"/>
				<br>
				<liferay-ui:message key="lisence_no"/>
				</p>
				</div>
				</div>
		</div>
		<div class="col-sm-2 text-center">
			<a href="/web/customer/faqs" class="btn btn-lg btn-default btn-outline btn-xs-block"><liferay-ui:message key="faqs"/></a>
		</div>
		<div class="col-sm-3" style="font-size: 11px;">
			<div class="media">
				<div class="media-left media-middle">
					<span class="glyphicon glyphicon-earphone gi-2x"></span>
				</div>
				<div class="media-body">
					<p>
						<a href="tel:<%= LanguageUtil.get(request, "tel_no_footer") %>" class="text-white"><%= LanguageUtil.get(request, "tel_no_footer") %></a><br />
						<small><liferay-ui:message key="toll_free"/></small>: <small><liferay-ui:message key="toll_free_no"/></small></br>
						<small><liferay-ui:message key="appointments"/></small>
					</p>
				</div>
			</div>
			<div class="media">
				<div class="media-left media-middle">
					<span class="glyphicon glyphicon-envelope gi-2x"></span>
				</div>
				<div class="media-body">
					<p><liferay-ui:message key="info_mail"/><br /><small><liferay-ui:message key="pobox"/></small></p>
				</div>
			</div>
		</div>
		<div class="col-sm-3" style="font-size: 11px;">
			<div class="media">
				<div class="media-left media-middle">
					<span class="glyphicon glyphicon-map-marker gi-2x"></span>
				</div>
				<div class="media-body">
					<p><liferay-ui:message key="national_address"/><br /><small><liferay-ui:message key="national_address_dets"/></small></p>
				</div>
			</div>
			<a href="/web/customer/report_a_fraud" class="btn btn-default btn-outline hidden-xs">
				<liferay-ui:message key="report_fraud"/>
			</a>
			<button type="button" class="btn btn-default btn-outline btn-xs-block hidden">
				<liferay-ui:message key="report_complaint"/>
			</button>
			
		</div>
	</div>
</div>
	</div>
</footer>
<script>
	if($('#siteFooter').length)
	{
		$("#toggleFooterDetails").on("click", function(){
			$("#footerDetails").slideToggle( "slow", function() {
				$("#toggleIcon").toggleClass("icon-chevron-up icon-chevron-down");
				$("#moreTxt").text($("#moreTxt").text() == '<%= LanguageUtil.get(request, "more") %>' ? '<%= LanguageUtil.get(request, "more_less") %>' : '<%= LanguageUtil.get(request, "more") %>');
			});
			$("html, body").animate({ scrollTop: $(document).height() }, "slow");
			return false;
		});
	}
</script>