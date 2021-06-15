<#--
This file allows you to override and define new FreeMarker variables.
-->

<#if is_signed_in>
    <#assign css_login_class = "beforeLogin" />
<#else>
    <#assign css_login_class = "afterLogin" />
</#if>

<#assign get_quot_key = languageUtil.get(locale, "get_quot") />
<#assign report_claim_key = languageUtil.get(locale, "report_claim") />

