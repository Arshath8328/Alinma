<%@page import="java.util.Locale"%>
<%@page import="java.util.List"%>
<%@ include file="/init.jsp" %>

<%String loc = themeDisplay.getLocale().toString();%>
<div class="row">
	<div class="col-md-12">
		<div id="map" class="acf-map" style="height: 400px;"></div>
		<script type="text/javascript" src="/o/atmc-theme/js/google_maps.js"></script>
	</div>
</div>
<div class="row">
	<div class="col-md-12 hidden">
		<div class="bg-brown pad-10 clearfix">
			<div class="col-md-12">
				<form class="form">
					<div class="row vcenter">
						<div class="col-xs-12 col-md-4">
							<select class="form-control" id="selectCity" name="selectCity"> 
								<option value="0"><liferay-ui:message key="all_cities"/></option>
								<option value="1"><liferay-ui:message key="riyadh"/></option>
								<option value="2"><liferay-ui:message key="jeddah"/></option>
								<option value="3"><liferay-ui:message key="al_khobar"/></option>															 
							</select>
						</div>
						<div class="col-xs-12 col-md-2">
							<button type="button" id="selectCityBtn" name="selectCityBtn" class="btn bt-lg btn-primary btn-lg btn-xs-block"><liferay-ui:message key="search"/></button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</div>
<div class="row margin-top">
<!--	<div class="col-md-4 col-sm-12 col-xs-12 col-lg-4 bg-body hidden">
		<div class="marker branch-details active" data-lat="24.706444" data-lng="46.675778">
			<h3 class="title"><liferay-ui:message key="all_cities"/></h3>
		</div>
	</div> -->
	<div class="col-md-4 col-sm-12 col-xs-12 col-lg-4 bg-body">
		<div class="marker branch-details" data-lat="24.706444" data-lng="46.675778">
			<h3 class="title"><liferay-ui:message key="head_branch"/></h3>
			<p class="address"><a title="View Location Map" target="_blank" href="https://www.google.com.sa/maps/place/Alinma+Tokio+Marine+Company,+Head+Office/@24.7063722,46.6734443,17z/data=!3m1!4b1!4m5!3m4!1s0x3e2f0329fe7043c7:0xc02feb5a3a46feac!8m2!3d24.7063673!4d46.675633?hl=en&authuser=0" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span> <liferay-ui:message key="head_branch_add_1"/><br/></a></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-phone text-primary"></span> <liferay-ui:message key="head_branch_add_2"/></p>
			<p class="phoneNo"><span class="glyphicon text-primary"></span> <liferay-ui:message key="head_branch_add_3"/></p>
			<p class="workHours"><span class="glyphicon glyphicon-time text-primary"></span> <liferay-ui:message key="head_branch_add_4"/></p> 
		</div>
	</div>
	<div class="col-md-4 col-sm-12 col-xs-12 col-lg-4 bg-body">
		<div class="marker branch-details" data-lat="24.689417" data-lng="46.723528">
			<h3 class="title"><liferay-ui:message key="riyadh_branch"/></h3>
			<p class="address"><a title="View Location Map" target="_blank" href="https://www.google.com/maps/place/24%C2%B046'44.9%22N+46%C2%B041'06.8%22E/@24.7791389,46.6874109,17z/data=!3m1!4b1!4m5!3m4!1s0x0:0x0!8m2!3d24.779144!4d46.68523?hl=en" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span> <liferay-ui:message key="riyadh_branch_add_1"/><br/></a></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-phone text-primary"></span> <liferay-ui:message key="riyadh_branch_add_2"/></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-earphone text-primary"></span> <liferay-ui:message key="riyadh_branch_add_3"/></p>
			<p class="workHours"><span class="glyphicon glyphicon-time text-primary"></span> <liferay-ui:message key="riyadh_branch_add_4"/></p> 
		</div>
	</div>
	<div class="col-md-4 col-xs-12 col-sm-12 col-lg-4 bg-body">
		<div class="marker branch-details" data-lat="21.506250" data-lng="39.178611">
			<h3 class="title"><liferay-ui:message key="jeddah_branch"/></h3>
			<p class="address"><a title="View Location Map" target="_blank" href="https://www.google.com.sa/maps/place/ATMC/@21.506152,39.1746873,17z/data=!4m5!3m4!1s0x15c3cfa3cf863931:0x102b25885d8e9a20!8m2!3d21.5062518!4d39.1786033?hl=en" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span> <liferay-ui:message key="jeddah_branch_add_1"/><br/></a></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-phone text-primary"></span> <liferay-ui:message key="jeddah_branch_add_2"/></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-earphone text-primary"></span> <liferay-ui:message key="jeddah_branch_add_3"/></p>
			<p class="workHours"><span class="glyphicon glyphicon-time text-primary"></span> <liferay-ui:message key="jeddah_branch_add_4"/></p>
		</div>
	</div>
	<div class="col-md-4 col-xs-12 col-sm-12 col-lg-4 bg-body col-margin-top">
		<div class="marker branch-details" data-lat="26.282795" data-lng="50.199639">
			<h3 class="title"><liferay-ui:message key="khobar_branch"/></h3>
			<p class="address"><a title="View Location Map" target="_blank" href="https://www.google.com/maps/place/Alinma+Tokio+Marine/@26.282795,50.199639,14z/data=!4m5!3m4!1s0x0:0xe057ca4e89956537!8m2!3d26.2827953!4d50.1996392?hl=en&amp;shorturl=1" rel="alternate"><span class="glyphicon glyphicon-map-marker text-primary"></span> <liferay-ui:message key="khobar_branch_add_1"/><br/></a></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-phone text-primary"></span> <liferay-ui:message key="khobar_branch_add_2"/></p>
			<p class="phoneNo"><span class="glyphicon glyphicon-earphone text-primary"></span> <liferay-ui:message key="khobar_branch_add_3"/></p>
			<p class="workHours"><span class="glyphicon glyphicon-time text-primary"></span> <liferay-ui:message key="khobar_branch_add_4"/></p>
		</div>
	</div>
	<div class="col-md-4 col-xs-12 col-sm-12 col-lg-4 bg-body col-margin-top">
    <div class="marker branch-details"> <h3 class="title"><liferay-ui:message key="site_name"/>  </h3>
       	 <p><liferay-ui:message key="saudi_stock_company"/></p>
       	 <p><liferay-ui:message key="lisence_no"/></p>
         <br>
    </div>
     </div>
	<div class="col-md-4 col-xs-12 col-sm-12 col-lg-4 bg-body col-margin-top">
    <div class="marker branch-details" > <h3 class="title"><liferay-ui:message key="national_address"/>  </h3>
       	 <p><liferay-ui:message key="national_address_dets"/></p>
       	 <p class="phoneNo"><span class="glyphicon glyphicon-phone text-primary"></span> <liferay-ui:message key="head_branch_add_2"/></p>
       	 <p><liferay-ui:message key="cust_serv"/>:<liferay-ui:message key="info_mail"/></p>
         <br>
    </div>
     </div>
</div>
<div class="row">
</div>

<script>
	$(document).ready(function(){
		$(".branch-details").on('click', function(){
			$('html, body').animate({
			        scrollTop: $("#map").offset().top - 20
			    }, 2000);
		});
	})
</script>
	