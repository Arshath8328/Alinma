<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="javax.portlet.PortletRequest"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.portlet.PortletURLFactoryUtil"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.ejada.atmc.bsl.db.domain.quotation.Quotation"%>
<%@ include file="/init.jsp"%>
<%
	Quotation quot = (Quotation)request.getAttribute("quot");
	String backUrl = (isUserSignedIn)?"/group/customer/policies":"/web/customer/home";
	
	PortletURL downloadPolicyUrl =  PortletURLFactoryUtil.create(request, PortalUtil.getPortletId(request), themeDisplay.getPlid(), PortletRequest.RESOURCE_PHASE);
	downloadPolicyUrl.setParameter("type", "policy");
	downloadPolicyUrl.setParameter("policyNo", quot.getPolicyNo());
	downloadPolicyUrl.setParameter("quotId", ""+quot.getQuotationId());
	String backLabel =  (isUserSignedIn) ? LanguageUtil.get(request, "bck_to_policies") : LanguageUtil.get(request, "bck_to_home");
	
	boolean mobileView = (request.getAttribute("mobileView")!=null)?(Boolean)request.getAttribute("mobileView"):false;
	
	boolean quotePurchased = (request.getAttribute("quotePurchased")!=null)?(Boolean)request.getAttribute("quotePurchased"):false;
%>
<div class="row" <%=(mobileView)?"style='display:none'":"" %>>
	<div class="col-md-10 col-md-offset-1 portlet-content">
		<h3 class="text-primary"><%=(quot.getProductCode().equals(BuyMotorPolicyPortletKeys.PRODUCT_CODE_COMPREHENSIVE))?LanguageUtil.get(request, "comp_product"):LanguageUtil.get(request, "tpl_product") %></h3>
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<div class="bg-primary pad-10">
			<liferay-ui:message key="req_ref"/> #<%=quot.getPolicyRefNo() %>
			<a href="<%=downloadPolicyUrl.toString() %>" class="btn-link text-white pull-right">&nbsp;&nbsp;&nbsp;<i class="material-icons">&#xE2C4;</i> <liferay-ui:message key="download"/></a>
			<a href="" onclick="self.print();" class="btn-link text-white pull-right"><i class="material-icons ">&#xE8AD;</i> <liferay-ui:message key="print"/></a>
		</div>
		<div class="row">
			<div class="col-md-12 col-lg-12 col-xs-12 col-sm-12">
				<h3 class="text-center"><span class="glyphicon glyphicon-ok text-success"></span>  <liferay-ui:message key="policy_issued"/></h3> 
				<h3 class="text-center"><small class="text-muted"><liferay-ui:message key="policy"/>#</small> <%=quot.getPolicyNo() %></h3> 
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-12">
				<button type="button" class="btn btn-default" onclick="window.location.href='<%=backUrl%>'">
					<%=backLabel%>
				</button>
			</div>
		</div>
	</div>
</div>
<aui:script>
if(<%=quotePurchased%>)
	alert("<%=LanguageUtil.get(request, "policy_issued")%>");
	
if(<%=mobileView%>)
{
	window.parent.postMessage({
		'msgType': 'resultsPage',
		'policyRefNo': '<%=quot.getPolicyRefNo()%>',
	    'policyNo': '<%=quot.getPolicyNo()%>'
	}, "*");
}
(function (global)
{
	if(typeof (global) === "undefined")
	{
		throw new Error("window is undefined");
	}
    var _hash = "#";
    var noBackPlease = function () {
        global.location.href += "#";
	 
        global.setTimeout(function () {
            global.location.href += "#";
        }, 50);
	};
	 
    global.onhashchange = function () {
        if (global.location.hash !== _hash) {
            global.location.hash = _hash;
        }
    };
	 
	global.onload = function () {
		noBackPlease();
		// disables backspace on page except on input fields and textarea..
		document.body.onkeydown = function (e)
		{
            var elm = e.target.nodeName.toLowerCase();
            if (e.which === 8 && (elm !== 'input' && elm  !== 'textarea'))
            {
                e.preventDefault();
            }
            // stopping event bubbling up the DOM tree..
            e.stopPropagation();
	    };
	};
	 
})(window);	
</aui:script>