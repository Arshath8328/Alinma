<%@ include file="/personalInfoBar/init.jsp" %>

<div class="row">
	<div class="col-md-4 col-lg-4 hidden-sm hidden-xs">
		<img src="/o/atmc-theme/images/login_bg.png" class="img-responsive" /> 
	</div>
	<div class="col-md-8 col-lg-8 col-sm-12 col-xs-12">
		<button type="button" class="close pull-right" data-dismiss="modal" aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
		<!-- Nav tabs -->
		<ul class="nav nav-tabs" role="tablist">
			<li role="presentation" class="active">
				<a href="#login" aria-controls="login" role="tab" data-toggle="tab"><liferay-ui:message key="login"/></a>
			</li>
			<li role="presentation">
				<a href="#register" aria-controls="register" role="tab" data-toggle="tab"><liferay-ui:message key="register"/></a>
			</li>
		</ul>
		<!-- Tab panes -->
		<div class="tab-content">
			<div role="tabpanel" class="tab-pane active" id="login">
			<liferay-portlet:runtime portletName="ATMCLogin" />
			</div>
			<div role="tabpanel" class="tab-pane" id="register">
			<liferay-portlet:runtime portletName="ATMCRegister" />
			</div>
			
		</div>
	</div>
</div>