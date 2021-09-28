<%@page import="com.ejada.atmc.acl.db.model.QuotationDriverseEndors"%>
<%@page import="com.liferay.portal.kernel.portlet.LiferayWindowState"%>
<%@page
	import="com.atmc.web.constants.AdminCustomerServiceListPortletKeys"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.sql.Blob"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.ejada.atmc.acl.db.model.PolicyCancelation"%>
<%@ include file="init.jsp"%>

<%
	SimpleDateFormat dmyDateFormatter = new SimpleDateFormat("dd/MM/yyyy");
	System.out.println("Inside Details jsp");

	QuotationDriverseEndors driverDetails = (QuotationDriverseEndors) request.getAttribute("driverDetails");

	String mobileNumber = (String) request.getAttribute("mobileNumber");
	String insuredEmail = (String) request.getAttribute("insuredEmail");

	System.out.println("driver Details " + driverDetails.toString());
%>

<portlet:renderURL var="rejecturl"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="myview" value="assign_to" />
	<portlet:param name="mobile" value="<%=mobileNumber%>" />
	<portlet:param name="insuredEmail" value="<%=insuredEmail%>" />
	<portlet:param name="policyNumber"
		value="<%=driverDetails.getPolicyNumber()%>" />
</portlet:renderURL>


<portlet:renderURL var="approveurl"
	windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<portlet:param name="myview" value="approve" />
	<portlet:param name="mobile" value="<%=mobileNumber%>" />
	<portlet:param name="insuredEmail" value="<%=insuredEmail%>" />
	<portlet:param name="policyNumber"
		value="<%=driverDetails.getPolicyNumber()%>" />
</portlet:renderURL>



<portlet:resourceURL var="workInprogressUrl">
	<portlet:param name="type" value="workinProgress" />
	<portlet:param name="mobile" value="<%=mobileNumber%>" />
	<portlet:param name="insuredEmail" value="<%=insuredEmail%>" />
	<portlet:param name="policyNumber"
		value="<%=driverDetails.getPolicyNumber()%>" />
</portlet:resourceURL>


<liferay-portlet:renderURL var="rejecturl" windowState="<%=LiferayWindowState.POP_UP.toString()%>">
	<liferay-portlet:param name="myview" value="assign_to" />
</liferay-portlet:renderURL>

<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<portlet:resourceURL var="captchaURL" />
<liferay-ui:error key="errorMessage"
	message="Please select the Captcha " />

<div class="container-fluid-1280">
	<h3 class="pull-right">
		<i class="material-icons">&#xE061;</i>
	</h3>
	<div class="tab">
		<ul class="nav nav-tabs">
			<li class="active"><a href="#tab-1" role="tab" data-toggle="tab"><liferay-ui:message
						key="drv_dets" /></a></li>
			<li><a href="#tab-2" role="tab" data-toggle="tab"><liferay-ui:message
						key="track_history" /></a></li>
		</ul>
	</div>
	<div class="tab-content bg-white pad-10">
		<div class="tab-pane fade in active" role="tabpanel" id="tab-1">
			<table class="table table-bordered">
				<tr>
					<td width="25%">
						<%-- <liferay-ui:message key="quote_ref"/> <span class="text-primary"><%=quotation.getReferenceNo()%></span><br/> --%>
						<liferay-ui:message key="policy_no" /> <span class="text-primary">
							<%=driverDetails.getPolicyNumber()%></span>
					</td>
					<td width="25%"><span class="text-muted"><liferay-ui:message
								key="requested_by" /></span><br /> <%=driverDetails.getDriverName()%>
					</td>
					<td width="25%"><span class="text-muted"><liferay-ui:message
								key="rejection_reason" /></span><br /></td>
					<td width="25%"><span class="text-muted"><liferay-ui:message
								key="date_received" /></span><br /> <%=dmyDateFormatter.format(driverDetails.getRequestedDate())%>
					</td>
				</tr>
			</table>
			<h4 class="text-primary">
				<liferay-ui:message key="aditional_driver_details" />
			</h4>
			<table class="table table-bordered">
				<tr>
					<td width="40%"><liferay-ui:message key="driver_name" /></td>
					<td width="60%" class="text-muted"><%=driverDetails.getDriverName()%></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_dob" /></td>
					<td class="text-muted"><%=driverDetails.getDriverDob()%></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_nat" /></td>
					<td class="text-muted"><%=driverDetails.getDriverNationality()%></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver_gender" /></td>
					<td class="text-muted"><%=driverDetails.getDriverGender()%></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="driver-N.C.D" /></td>
					<td class="text-muted">0<%=driverDetails.getNcdYears()%></td>
				</tr>
				<tr>
					<td><liferay-ui:message key="mobile_number" /></td>
					<td class="text-muted">0<%=mobileNumber != null ? driverDetails.getNcdYears() : 0%></td>
				</tr>
				<h4 class="text-primary">
					<liferay-ui:message key="drv_nat_addr" />
				</h4>
				<table class="table table-bordered">
					<tr>
						<td width="40%"><liferay-ui:message key="building_no" /></td>
						<td width="60%" class="text-muted"><%=driverDetails.getBuildNo()%></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="street_name" /></td>
						<td class="text-muted"><%=driverDetails.getStNameEn()%></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="city" /></td>
						<td class="text-muted"><%=driverDetails.getCityEn()%></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="district" /></td>
						<td class="text-muted"><%=driverDetails.getDistrictEn()%></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="zip_code" /></td>
						<td class="text-muted"><%=driverDetails.getZipCode()%></td>
					</tr>
					<tr>
						<td><liferay-ui:message key="add_info" /></td>
						<td class="text-muted">
						<td class="text-muted"><%=driverDetails.getAddNo()%></td>
						</td>
					</tr>
				</table>
			</table>
			<div class="row">
				<div class="col-md-12">
					<ul class="list-btns text-right">
						<li class="pull-left"><a
							class="btn btn-lg btn-xs-block btn-link text-muted" role="button"
							onclick="window.history.go(-1); return false;"> <i
								class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message
									key="back_button" />
						</a></li>
						<li><a role="button" class="btn btn-lg" onClick="Print();"><i
								class="material-icons text-primary md-36">&#xE8AD;</i></a></li>
						<li><a role="button" id="workInProgress"
							class="btn btn-primary btn-lg" href="javascript:void(0)"><liferay-ui:message
									key="work_in_progress" /></a></li>
						<%-- <li>
						<a role="button" id="reject"  class="btn btn-danger btn-outline btn-lg" href="javascript:void(0)"><liferay-ui:message key="reject"/></a>
				</li> --%>
						<li><a class="btn btn-primary btn-lg" id="approve"
							type="button" href="javascript:void(0)"><liferay-ui:message
									key="approve" /></a></li>

					</ul>
				</div>
			</div>
		</div>




		<div id="aui_popup_content">
			<div id="aui_popup_body" style="display: none;">
				<aui:form method="post" role="form" id="commentForm"
					name="commentForm">
					<aui:fieldset>
						<table class="table table-bordered borderless margin-top">
							<tbody>
								<tr>
									<div class="row">
										<div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
											<div class="form-group">
												<label class="control-label" for=""><liferay-ui:message
														key="attachments" /></label>
												<div class="form-control" id="listOfFiles">
													<ul>

													</ul>
												</div>
												<input class="btn btn-primary form-control"
													onclick="$('#<portlet:namespace/>uploadFile').click();"
													type="button"
													value='<liferay-ui:message key="add_attachment" />' />
												<aui:input multiple="multiple" type="file" name="uploadFile"
													id="uploadFile" cssClass="sr-only" label=""
													onchange="addFiles()">
													<aui:validator name="acceptFiles">'jpg,jpeg,pdf,png,doc,docx'</aui:validator>
													<%--<aui:validator name="custom" errorMessage="max_upload_size">
                                    	    function(val,node,junction){
                                    		    var uploadSize=true;
                                    		    var size=0;
                                    		    var fileInput = document.getElementById("<portlet:namespace/>uploadFile");
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
                                    	</aui:validator>--%>
													<aui:validator name="custom"
														errorMessage='<liferay-ui:message key="checkFileName"/>'>
					                        function(val,node,junction){
					                        	var fileInput = document.getElementById("<portlet:namespace />uploadFile");
												var fileName = "";
													if(fileInput.files.length>0)
														fileName = fileInput.files.item(0).name;
												var regex = /^[A-Za-z0-9]+\.[A-Za-z0-9]+$/;
												return regex.test(fileName);
											}
										</aui:validator>
												</aui:input>
											</div>
										</div>
									</div>
								</tr>
								<tr>
									<td class="text-left">
										<ul class="list-btns">
											<li><liferay-captcha:captcha url="<%=captchaURL%>" />
												<button class="btn btn-primary btn-lg btn-xs-block"
													type="button" id="submitBtn">
													<liferay-ui:message key="send" />
													<i class="material-icons md-24">&#xE163;</i>
												</button></li>
										</ul>
									</td>
								</tr>
							</tbody>
						</table>
					</aui:fieldset>
				</aui:form>
			</div>
		</div>

		<div id="close_popup_content"></div>
		<div id="close_popup_body" style="display: none;">
			<form method="post" name="closeForm">
				<div class="text-center">
					<div class="row">
						<div class="col-md-12">
							<h3 class="text-primary">
								<liferay-ui:message key="sure_to_close" />
							</h3>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<ul class="list-btns">
								<li><a role="button" class="btn btn-primary btn-lg" href=""
									id="confirmBtn"><liferay-ui:message key="yes" /></a></li>
								<li>
									<button class="btn btn-link text-muted btn-lg" type="button"
										onClick="$('.close').click().click();">
										<liferay-ui:message key="cancel" />
									</button>
								</li>

							</ul>
						</div>
					</div>
				</div>
			</form>
		</div>


		<div id="aui_popup_content_msg"></div>
		<div id="aui_popup_body_msg" style="display: none;">
			<div class="text-center">
				<h4>
					<liferay-ui:message key="message_sent" />
				</h4>
			</div>
		</div>

		<portlet:resourceURL var="resourceURL">
			<portlet:param name="actionName" value="comment" />
			<portlet:param name="refNo" value="" />
		</portlet:resourceURL>





		<aui:script use="liferay-util-window,liferay-portlet-url">
					$('#reject').on('click', function(event) {
						Liferay.Util.openWindow(
								{
									cache: false,
									dialog: {
										destroyOnHide: true,
										cssClass: 'atmc-popup',
										align: Liferay.Util.Window.ALIGN_CENTER,
										modal:true,
										resizable: false,
										width: 400,
										height: 400
									},
									dialogIframe: {
										id: '<portlet:namespace />dialog',
										uri: '<%=rejecturl.toString()%>'
									},
									uri: '<%=rejecturl.toString()%>'
								});
					    
					}); 
					
		/* approve code start */
		
		
		
		$('#approve').on('click', function(event) {
						Liferay.Util.openWindow(
								{
									cache: false,
									dialog: {
										destroyOnHide: true,
										cssClass: 'atmc-popup',
										align: Liferay.Util.Window.ALIGN_CENTER,
										modal:true,
										resizable: false,
										width: 400,
										height: 400
									},
									dialogIframe: {
										id: '<portlet:namespace />dialog',
										uri: '<%=approveurl.toString()%>'
									},
									uri: '<%=approveurl.toString()%>'
								});
					    
					}); 
		
		
		/* approve code end */	
		
					
					
					
					$('#workInProgress').on('click', function(event) {	
						AUI().use('aui-io-request', function(A){
							
					        A.io.request('<%=workInprogressUrl.toString()%>', {
					               method: 'post',
					               dataType: 'json',
					               /* form: {
					                   id: '<portlet:namespace />resourceURL'
					               }, */
					               on: {
					                    success: function(data)
					                    {
					                    	var res = this.get('responseData');
					                    	if(res == 'success') successFn();
					                    	else if(res == 'error') {
					                    		window.location = '/group/staff/cancle-policy';
					                    	}
					                    }
					               }
					            });
					    });
					 });
					
					
					function successFn()
					{
						AUI().use('aui-modal', function(A) {
								var dialog = new A.Modal({
									title: "",
									bodyContent: AUI().one('#aui_popup_body_msg').html(),
									headerContent: '<h3>
				<liferay-ui:message key="cust_serv" />
			</h3>',
									centered: true,
									modal: true,
									width: 500,
									height: 300,
									render: '#aui_popup_content_msg'
								});
								dialog.addToolbar(
								      [
								        {
								          label: 'Done',
								          cssClass: 'btn-primary',
								          on: {
								            click: function() {
								            	dialog.hide();
								            }
								          }
								        }
								      ]
								    );
								
							});	
					}
					
				</aui:script>