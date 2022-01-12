<!DOCTYPE html>

<#include init />

<html class="${root_css_class}" dir="<@liferay.language key="lang.dir" />" lang="${w3c_language_id}">

<head>
	<title>${the_title}</title>
	
	<meta content="initial-scale=1.0, width=device-width" name="viewport" />

	<@liferay_util["include"] page=top_head_include />
</head>

<body class="${css_class}">
<title>${the_title}</title>
<!-- <@liferay_ui["quick-access"] contentId="#main-content" /> -->

<#if show_dockbar>
		<@liferay_util["include"] page=body_top_include />
		<@liferay.control_menu />
</#if>

<div id="wrapper">
<#if !request.getParameter("mobileView")??>
	<div id="headerTopBar" class="margin-bottom ">
		<div id="personalInfo" class="pull-right headerTopBar-right ${css_login_class}">
			<#assign VOID = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />	
				<@liferay_portlet["runtime"] 
					defaultPreferences="${freeMarkerPortletPreferences}" 
					portletName="ATMCPersonalInfo"
				/>
			<#if !is_signed_in>
			<a data-redirect="false" href="${sign_in_url}" id="sign-in" rel="nofollow" style="display:none;">${sign_in_text}</a>
			</#if>
			<span>
				<i class="material-icons" style="vertical-align:middle;">&#xE894;</i> 
				<@liferay_portlet["runtime"] 
				defaultPreferences="${freeMarkerPortletPreferences}" 
				portletName="com_liferay_site_navigation_language_web_portlet_SiteNavigationLanguagePortlet"
				/>
			</span>
			<#--<#assign VOID = freeMarkerPortletPreferences.reset() />--> 
		</div>
	</div>
	<div class="container">
		<div class="row vcenter margin-bottom">
			<div class="col-md-6 col-lg-6 col-sm-6 col-xs-7">
				<a class="${logo_css_class}" href="${site_default_url}">
					<img class="img-responsive pull-left" width="260" alt="${logo_description}" src="/o/atmc-theme/images/logo.svg"/>
				</a>
				<#if show_site_name>
					<span class="site-name" title="<@liferay.language_format arguments="${site_name}" key="go-to-x" />">
						${site_name}
					</span>
				</#if>
			</div>
			<#--<div class="col-md-6 col-lg-6 col-sm-6 col-xs-7 ">
				<img class="img-responsive pull-right" width="260" alt="customer" src="/o/atmc-theme/images/logo1.svg">
			</div>  -->
			<#-- <div class="col-sm-6 col-md-6 col-lg-6 text-right">
				<ul class="list-btns no-pad">
					
					<li><a href="/web/customer/claim_intimation" class="btn btn-default btn-lg hidden-xs">${report_claim_key}</a></li>
					
					<#if is_signed_in>
						<#if request.getSession().getAttribute("USERINFOKEY")??>
							<#assign userInfo = request.getSession().getAttribute("USERINFOKEY") />
								<#if !userInfo.isOrgMode()>
									<li><a href="/web/customer/buy_motor_policy" class="btn btn-lg btn-primary">${get_quot_key}</a></li>
								</#if>
						</#if>
					<#else>
						 <li><a href="/web/customer/buy_motor_policy" class="btn btn-lg btn-primary">${get_quot_key}</a></li>
					</#if>
				</ul>	
			</div>-->
		</div>
			<#assign VOID = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
			<@liferay_portlet["runtime"] 
				defaultPreferences="${freeMarkerPortletPreferences}" 
				portletName="ATMCMenu"
			/>
																				
			<#assign theme_display = themeDisplay />
			<#assign layout = theme_display.getLayout() />
			<#assign title = layout.getName(locale) />
			<#if !is_signed_in && title != "Home" && title != "Buy Motor Policy" && title != "Claim Intimation" && title != "Najm Claim" && title != "Muroor Claim" && title != "SetPassword">
				<@liferay.breadcrumbs default_preferences="${freeMarkerPortletPreferences}" />
			</#if>
			<#--<#assign VOID = freeMarkerPortletPreferences.reset() />--> 
	</div>
</#if>
	<section class="container" id="content">
		<h1 class="hide-accessible">${the_title}</h1>

		<#if selectable>
			<@liferay_util["include"] page=content_include />
		<#else>
			${portletDisplay.recycle()}

			${portletDisplay.setTitle(the_title)}

			<@liferay_theme["wrap-portlet"] page="portlet.ftl">
				<@liferay_util["include"] page=content_include />
			</@>
		</#if>
	</section>
	<#if !request.getParameter("mobileView")??>
		<#if !is_signed_in>
			<#assign VOID = freeMarkerPortletPreferences.getPreferences("portletSetupPortletDecoratorId", "barebone") />
				<@liferay_portlet["runtime"] 
				defaultPreferences="${freeMarkerPortletPreferences}" 
				portletName="ATMCFooter"
				/>
			<#--<#assign VOID = freeMarkerPortletPreferences.reset() />-->
		</#if>
	</#if>
</div>
<@liferay_util["include"] page=body_bottom_include />
<@liferay_util["include"] page=bottom_include />
</body>
</html>