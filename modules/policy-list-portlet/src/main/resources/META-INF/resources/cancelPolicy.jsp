<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.ejada.atmc.acl.db.model.AtmcYakeenMakeModel"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyVEH"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyHDR"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="com.atmc.bsl.db.domain.policy.Policy"%>
<%@page import="com.atmc.web.constants.LoginPortletKeys"%>
<%@page import="com.atmc.bsl.db.exception.YaqeenException"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.liferay.portal.kernel.util.ParamUtil"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="com.atmc.bsl.db.domain.quotation.Quotation"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page import="com.atmc.web.constants.OTPPortletKeys"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.GregorianCalendar"%>
<%@page import="com.atmc.bsl.db.domain.policy.PolicyVehicle"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.atmc.web.constants.BuyMotorPolicyPortletKeys"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>
<%@ include file="init.jsp"%>
<%
	Log _log = LogFactoryUtil.getLog(this.getClass());

	PolicyHDR policy = (PolicyHDR) request.getAttribute("policyDetails");
	PolicyVEH policyVeh = (PolicyVEH) request.getAttribute("policyVehDetails");
	AtmcYakeenMakeModel makeModelDetails =(AtmcYakeenMakeModel) request.getAttribute("makeModelDetails");
	SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
	String expDate =  sdf.format(policy.getExpiryDate());
	_log.info(expDate);
	String currentDate =  sdf.format(new Date());
	_log.info(currentDate);
%>

<portlet:actionURL name="cancelPolicyDets" var="cancelPolicyDets" />

<form name="cancelPolicyDets" role="form" method="post" action="<%=cancelPolicyDets%>" id = "form_check">
	<ul class="list-group no-margin">
		<li class="list-group-item bg-gray"><liferay-ui:message
				key="policy_details" /></li>
		<br>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="policy_holder_name" /></label> 
					<input id="policyHolderName" name="<portlet:namespace/>policyHolderName" class="form-control" type="text" readonly="readonly" value="<%=policy.getInsuredName()%>" />
					<span class="glyphicon form-control-feedback  text-muted"></span>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="policy_no" /></label>
					<input class="form-control" tabindex="3" name="<portlet:namespace/>policy_no" id="policy_no"readonly="readonly" type="text" value="<%=policy.getPolicyNo()%>" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="make" /></label> 
					<input class="form-control" tabindex="2" name="<portlet:namespace/>veh_make" id="veh_make" type="text" readonly="readonly" value="<%=makeModelDetails.getYakeenMakeDesc()%>" />
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="mod_ver" /></label>
					<input class="form-control" tabindex="3" name="<portlet:namespace/>veh_model" id="veh_model"readonly="readonly" type="text" value="<%=makeModelDetails.getYakeenModelEnglish() %>" />
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="eng_chass_no" /></label> 
					<input class="form-control" tabindex="2" name="<portlet:namespace/>chassis_number" id="chassis_number" type="text" readonly="readonly" value="<%=policyVeh.getChassisNo() %>" />
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="mod_ver" /></label>
					<input class="form-control" tabindex="3" name="<portlet:namespace/>plate_number" id="plate_number"readonly="readonly" type="text" value="<%=policyVeh.getArPlateNo() %>" />
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="pol_exp_date" /></label> 
					<input class="form-control" tabindex="2" name="<portlet:namespace/>polExpiryDate" id="polExpiryDate" type="text" readonly="readonly" value="<%=dateFormatter.format(policy.getExpiryDate())%>" />
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="pol_ins_date" /></label> 
					<input id="issue_date" name="<portlet:namespace/>policyInceptionDate" class="form-control" type="text" readonly="readonly" value="<%=policy.getInceptionDate()%>" /> 
					<span class="glyphicon form-control-feedback text-muted"></span>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="form-group has-feedback">
					<label class="control-label">
					<liferay-ui:message key="cancelation_effective_date_hijri" /></label>
					 <input tabindex="25" id="TransDobH" name="<portlet:namespace/>TransDobH" required="required" class="form-control" type="text" placeholder="yyyy-mm-dd" readonly="readonly"/> <span
						class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
				<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message
							key="cancelation_effective_date_greg" /></label> 
							<input tabindex="26" id="TransDobG" name="<portlet:namespace/>TransDobG" required="required" class="form-control" type="text" placeholder="yyyy-mm-dd"
						readonly="readonly"  /> <span
						class="glyphicon form-control-feedback glyphicon-calendar text-muted"></span>
				</div>
			</div>
			
		</div>
		<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="veh_acc_no" /></label> 
					<aui:input id="ibanfile" name="ibanfile" required="required" class="form-control" type="file" >
					                    <aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
                                    	<aui:validator name="custom" errorMessage="max_upload_size">
                                    	    function(val,node,junction){
                                    		    var uploadSize=true;
                                    		    var size=0;
                                    		    var fileInput = document.getElementById("<portlet:namespace/>ibanfile");
                                    		    for(var num1=0;num1<fileInput.files.length;num1++)
                                    		    {
                                    			        var file=fileInput.files[num1];
                                    		            if(file.size>2097152)
                                    					{
                                    						uploadSize=false;
                                    					}
                                    					else
                                    					{
                                    					   uploadSize=true;
                                    					}
                                    					size+=file.size;
                                    			}
                                    			if(uploadSize==true){
                                    				return true;
                                    			}else{
                              						return false;
                                  				}
                                   			}
                                    	</aui:validator>
                                    	<aui:validator name="custom" errorMessage='<liferay-ui:message key="checkFileName"/>'>
											function(val,node,junction){
												var fileInput = document.getElementById("<portlet:namespace/>ibanfile");
												var fileName = "";
												if(fileInput.files.length>0)
													fileName = fileInput.files.item(0).name;
													var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
													return regex.test(fileName);
												}
										</aui:validator>
									</aui:input>
								<span class="glyphicon form-control-feedback  text-muted"></span>
				</div>
			</div>
			<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
					<div class="form-group has-feedback">
					<label class="control-label"><liferay-ui:message key="iban" /></label> 
					<input id="ibanNumber" name="<portlet:namespace/>ibanNumber" class="form-control" type="text" required="required"/> 
					<span class="glyphicon form-control-feedback  text-muted"></span>
				</div>
				<div class="row">
					<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
						<label class="control-label"><liferay-ui:message key="cncl_reason"/></label> 
						<select class="form-control" id="rejectionReason" name="<portlet:namespace/>rejectionReason"  required="required">
						<option value="-1"><liferay-ui:message key="please_select_option"/></option>
  						<option value="<%=LanguageUtil.get(request, "transfer_of_veh")%>"><liferay-ui:message key="transfer_of_veh"/></option>
  						<option value="<%=LanguageUtil.get(request, "other_policy_covering")%>"><liferay-ui:message key="other_policy_covering"/></option>
  						<option value="<%=LanguageUtil.get(request, "cncl_veh_reg")%>"><liferay-ui:message key="cncl_veh_reg"/></option>
  						<option value="<%=LanguageUtil.get(request, "pol_upgrd_comp")%>"><liferay-ui:message key="pol_upgrd_comp"/></option>
  						<option value="<%=LanguageUtil.get(request, "Pol_not_upload_najm")%>"><liferay-ui:message key="Pol_not_upload_najm"/></option>
  						<option value="<%=LanguageUtil.get(request, "transfer_of_veh")%>"><liferay-ui:message key="transfer_of_veh"/></option>
						</select>
					</div>
				</div>
			</div>
			<div style="color:red">
			<p><span><liferay-ui:message key="refund_method" /> </span>
			<br>
			<span><liferay-ui:message key="sama_rule" /> 
			</span></p>
			</div>
		</div>
	</ul>
	<ul class="list-group no-margin">
	<li class="list-group-item bg-gray"><liferay-ui:message key="policy_holders_declr" /></li>
				<div class="form-group ">
						<label class="control-label text-primary"><liferay-ui:message key="have_any_accident" /></label>
						<label class="switch control-label"> 
						<input type="checkbox" name="<portlet:namespace/>any_acccident" value="true" />
							<div></div> <span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>
					<div class="form-group ">
						<label class="control-label text-primary"><liferay-ui:message key="if_so_lodg_comp" /></label>
						<label class="switch control-label"> 
						<input type="checkbox" name="<portlet:namespace/>lodg_comp" value="true" />
							<div></div> <span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>
				</ul>
	<ul class="list-group no-margin">
		<li class="list-group-item bg-gray"><liferay-ui:message
				key="cncl_reason_atchmnt" /></li>
		<li class="list-group-item">
			<div class="row">
				<div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
					<p>
						<liferay-ui:message key="ans_me" />
					</p>
					<div class="form-group">
						<label class="control-label text-primary"><liferay-ui:message key="transfer_of_veh" /> </label> <label class="switch control-label">
							<input type="checkbox" id="transferOfVeh" name="<portlet:namespace/>transferOfVeh" value="true" onclick="shareListHideShow('t1')"  />
							<div></div><span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>

					<div class="row transferVehSale share-list" id="t1" style="display: none;">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName" name="<portlet:namespace/>validImageFileName" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName').val(this.files.item(0).name);"/>
								</div>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label text-primary"><liferay-ui:message key="other_policy_covering" /> </label>
						<label class="switch control-label"> <input type="checkbox" name="<portlet:namespace/>otherPolCovering" value="true"  onclick="shareListHideShow('t2')"/>
							 <div></div><span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>
					<div class="row otherPolCovering share-list" id="t2" style="display: none;">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName1" name="<portlet:namespace/>validImageFileName1" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName1').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName1').val(this.files.item(0).name);"/>
								</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="control-label text-primary"><liferay-ui:message key="cncl_veh_reg" />
						 </label> <label class="switch control-label"><input type="checkbox" name="<portlet:namespace/>cancelVehReg" value="true" onclick="shareListHideShow('t3')"/>
							<div></div><span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>

					<div class="row share-list" id="t3" style="display: none;">
						<%-- <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName" name="<portlet:namespace/>validImageFileName" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName').val(this.files.item(0).name);"/>
								</div>
						</div> --%>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName2" name="<portlet:namespace/>validImageFileName2" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName2').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName2').val(this.files.item(0).name);"/>
								</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="control-label text-primary"><liferay-ui:message key="pol_upgrd_comp" /></label> 
						<label class="switch control-label"><input type="checkbox" name="<portlet:namespace/>polUpgrade" value="true" onclick="shareListHideShow('t4')"/>
							<div></div><span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>

					<div class="row example share-list " id="t4" style="display: none;">
						<%-- <div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFile" name="<portlet:namespace/>validImageFile" class="form-control" onclick="$('#<portlet:namespace/>selectedCarFrontFile').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>carFrontFile" id="<portlet:namespace/>carFrontFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>selectedCarFrontFile').val(this.files.item(0).name);"/>
								</div> --%>
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName3" name="<portlet:namespace/>validImageFileName3" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName3').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName3').val(this.files.item(0).name);"/>
								</div>
						</div>
					</div>
					<div class="form-group ">
						<label class="control-label text-primary"><liferay-ui:message key="Pol_not_upload_najm" /></label>
						<label class="switch control-label"> <input type="checkbox" name="<portlet:namespace/>polNotUpdatedNajm" value="true" onclick="shareListHideShow('t5')"/>
							<div></div> <span label-yes='<liferay-ui:message key="yes"/>' label-no='<liferay-ui:message key="no"/>'></span>
						</label>
					</div>

					<div class="row share-list" id="t5" style="display: none;">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
								<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group has-feedback">
									<label class="control-label">
										<liferay-ui:message key="upload_valid_file"/>
									</label> 
									<input readonly id="<portlet:namespace/>validImageFileName4" name="<portlet:namespace/>validImageFileName4" class="form-control" onclick="$('#<portlet:namespace/>validImageFileName4').val('');$('#<portlet:namespace/>validImageFile').click();" value="" placeholder='<liferay-ui:message key="sel_file_loc"/>'/> 
									<span class="glyphicon form-control-feedback glyphicon-paperclip text-muted"/>
									<input type="file" name="<portlet:namespace/>validImageFile" id="<portlet:namespace/>validImageFile" class="sr-only" label="" onchange="$('#<portlet:namespace/>validImageFileName4').val(this.files.item(0).name);"/>
								</div>
						</div>
						</div>
					</div>
					<input type="hidden" value="<%=policy.getInsuredEmail()%>" name="<portlet:namespace/>insuredEmail">
					<input type="hidden" value="<%=policy.getInsuredMobile()%>" name="<portlet:namespace/>insuredMobile">
					<input type="hidden" value="<%=policyVeh.getChassisNo()%>" name="<portlet:namespace/>chassisNumber">
					<input type="hidden" value="<%=policyVeh.getVehicleSeqCustom()%>" name="<portlet:namespace/>vehSequence">
					<input type="hidden" value="<%=policy.getInsuredId()%>" name="<portlet:namespace/>insuredId">
				</div>
			</div>
		</li>
		<br>
		<p style="color: red;"><liferay-ui:message key="disclaimer-1" ></liferay-ui:message><br></p>
		<p><liferay-ui:message key="note"></liferay-ui:message></p>
		<liferay-ui:message key="disclaimer-2"></liferay-ui:message>
		<liferay-ui:message key="disclaimer-3"></liferay-ui:message><br>
		<liferay-ui:message key="disclaimer-4"></liferay-ui:message><br>
	</ul>
	<br>
	<button id="" class="btn btn-primary btn-lg btn-xs-block" tabindex="33" type="submit"> <liferay-ui:message key="proceed" />
	</button>
</form>







<script type="text/javascript">


$('#form_check').on('submit', function (e) {
	  if ($("input[type=checkbox]:checked").length === 0) {
	      e.preventDefault();
	      alert('Attach the valid document');
	      return false;
	  }
	});
	
function shareListHideShow(actionId){
    var divs = document.getElementsByClassName("share-list");
    for(var i=0;i<divs.length;i++) {
        if(divs[i].id == actionId){
            if(divs[i].style.display === "block"){
                divs[i].style.display = "none";
            }else{
                divs[i].style.display = "block";
            }
        }
        else
            divs[i].style.display = "none";
    }
}

/* 	function transferOfOwn() {
		if(obj.is(":checked"))
			$(".transferVehSale").show();
		else
			$(".transferVehSale").hide();
	} */
	$(TransDobH).calendarsPicker({
		calendar: $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ?"": ",'ar'" %>),
		dateFormat: 'yyyy-mm-dd',
		maxDate: '0',
		yearRange: '-100:1441',
		<%= currLocale.equals("en_US") ?"": "isRTL: true," %>
		onClose: function(dates){
			var zDate = $(TransDobH).val().split("-"); 
			if($(TransDobH).val() != "")
			{
				var jd = $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ?"": ",'ar'" %>).newDate(parseInt(zDate[0]), parseInt(zDate[1]), parseInt(zDate[2])).toJD();
				var convertedDate = $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar'" %>).fromJD(jd); 
				$(TransDobG).calendarsPicker('setDate', convertedDate);
			}
			else
			{
				$(TransDobG).val("");
			}	
			if($("#IstEmail").is(':visible'))		{	$("#IstEmail").click(); 	$("#IstEmail").focus();}
			if($("#CustMobileNo").is(':visible'))	{	$("#CustMobileNo").click();	$("#CustMobileNo").focus();}
			if($("#TransVehSeqNo").is(':visible'))	{	$("#TransVehSeqNo").click();$("#TransVehSeqNo").focus();}	
		}
	});
var expdate = <%=expDate%>;
var currentDate = <%=currentDate%>;
	$(TransDobG).calendarsPicker({
		calendar: $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>),
		dateFormat: 'yyyy-mm-dd',
		maxDate: '0',
		yearRange: '-100:2020',
		<%= currLocale.equals("en_US") ? "":"isRTL: true," %>
		onClose: function(dates){
			var zDate = $(TransDobG).val().split("-"); 
			if($(TransDobG).val() != "")
			{
				var jd = $.calendars.instance('gregorian'<%= currLocale.equals("en_US") ?"": ",'ar-EG'" %>).newDate(parseInt(zDate[0]), parseInt(zDate[1]), parseInt(zDate[2])).toJD();
				var convertedDate = $.calendars.instance('ummalqura'<%= currLocale.equals("en_US") ? "":",'ar'" %>).fromJD(jd); 
				$(TransDobH).calendarsPicker('setDate', convertedDate);
			}
			else
			{
				$(TransDobH).val("");
			}
			if($("#IstEmail").is(':visible'))		{	$("#IstEmail").click(); 	$("#IstEmail").focus();	}
			if($("#CustMobileNo").is(':visible'))	{	$("#CustMobileNo").click();	$("#CustMobileNo").focus();	}
			if($("#TransVehSeqNo").is(':visible'))	{	$("#TransVehSeqNo").click();$("#TransVehSeqNo").focus();	}	
		}
	});
	
		
</script>


	<style>
    .share-list {
        display:none;
    }
    </style>
	