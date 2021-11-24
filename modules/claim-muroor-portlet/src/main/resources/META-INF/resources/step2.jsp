<%@page import="com.liferay.portal.kernel.model.User"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>
<%@page import="com.atmc.web.common.UserInfo"%>
<%@page import="com.atmc.web.util.SessionUtil"%>
<%@page import="java.util.List"%>
<%@page import="com.ejada.atmc.bsl.db.domain.codemaster.CodeMasterDetails"%>
<%@ include file="/init.jsp"%>

<link rel="stylesheet" type="text/css" href="/o/atmc-theme/vendor/jquery_calendars/css/smoothness.calendars.picker.css">
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.plus.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.plugin.min.js"></script> 
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.picker.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura.min.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars.ummalqura-ar.js"></script>
<script type="text/javascript" src="/o/atmc-theme/vendor/jquery_calendars/js/jquery.calendars-ar-EG.js"></script>

<%
	boolean isSignedIn = themeDisplay.isSignedIn();
	String id="";
	String email="";
	String mobile="";
	String name="";
	String amount ="";
	String nationality= "";
	String age= "";
	if(isSignedIn)
	{
		User  currentUser = PortalUtil.getUser(request);
		mobile = currentUser.getPhones().get(0).getNumber();
		
		id = currentUser.getScreenName();
		email = currentUser.getEmailAddress();
		name= currentUser.getFullName();
	}
	String currLocale = themeDisplay.getLocale().toString();
	List<CodeMasterDetails> nationalitiesList = (List<CodeMasterDetails>) request.getAttribute("nationalitiesList");
	boolean isBack = false;
	if(request.getAttribute("IS_BACK")!=null)
	{
		isBack = (Boolean) request.getAttribute("IS_BACK");
	}
	
	if(isBack)
	{
		id= (String) request.getAttribute("Id");
		name = (String) request.getAttribute("Name");
		mobile = (String) request.getAttribute("Mobile");
		email = (String) request.getAttribute("Email");
		amount = (String) request.getAttribute("Amount");
		nationality = (String) request.getAttribute("Nationality");
		age= (String) request.getAttribute("Age");
	}
%>

<portlet:actionURL var="applyDriverInfo" name="applyDriverInfo">
	<portlet:param name="myview" value="step3"/>
</portlet:actionURL>

<portlet:actionURL name="backToLanding" var="backToLanding">
	<portlet:param name="isBack" value="true"/>
</portlet:actionURL>

<form id="landingBackForm" name="landingBackForm" role="form" action="<%=backToLanding%>" method="post">
	<input type="hidden" name="<portlet:namespace/>odsClmIntm" value=""/>
</form>

<div class="row">
	<div class="col-md-10 col-md-offset-1">
		<h3 class="text-primary"><liferay-ui:message key="report_claim"/></h3>
	</div>
</div>
<div class="row">
	<div class="col-md-10 col-md-offset-1 col-sm-12 col-xs-12">
		<img class="img-responsive" src="/o/atmc-theme/images/review_quotation_image.png" width="100%" />
		<div class="progress progress-atmc">
			<div class="progress-bar" role="progressbar" aria-valuenow="33" aria-valuemin="0" aria-valuemax="100" style="width: 33%;">
				<span class="sr-only">33% Complete</span>
			</div>
	</div>
</div>
</div>
<div class="row">
	<div class="col-xs-12 col-sm-12 col-lg-10 col-lg-offset-1 col-md-10 col-md-offset-1">
		<div class="portlet-content">
			<div class="row">
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2">
					<ul class="nav nav-pills nav-stacked nav-justified">
						<li>
							<a class="text-primary" href="#"><i class="icon icon-transport-1 md-36"></i> <liferay-ui:message key="drv_info"/></a>
						</li>
						<li class="disabled">
							<a href="#"><i class="icon icon-transport md-36"></i> <liferay-ui:message key="veh_acc_info"/> </a>
						</li>
						<li class="disabled">
							<a href="#"><i class="icon icon-list md-36"></i><liferay-ui:message key="appr_accpt"/></a>
						</li>
					</ul>								 
				</div>
			</div>
			<div class="row">
				<aui:form role="form" id="driverInfoForm" name="driverInfoForm" action="<%=applyDriverInfo%>" method="post" >
				<div class="col-sm-12 col-xs-12 col-md-10 col-md-offset-1 col-lg-8 col-lg-offset-2"> 
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_32">
										<div>
											<div><liferay-ui:message key="applic_id_num"/></div>
										</div>
									</div>
								</label>
								<%
									if(isSignedIn)
									{
								%>
								
										<aui:input class="form-control" type="text" id="applicantId" name="applicantId" value="<%=id %>" readonly="true" label="">
											<aui:validator name="required" />
											<aui:validator name="number"/>
											<aui:validator name="rangeLength" errorMessage="Please enter a valid id">[10,10]</aui:validator>
											<aui:validator name="custom" errorMessage="Please enter a valid id">
												function(val, fieldNode, ruleValue){
								    				var flag = true;
								    				var keyLength = 10;
													var len = val.length;
												
													if(len < keyLength)
													{
														flag = false;
													}
													else
													{
														var iqamaNumber = new Array();
														var iqamaOddSum = new Array();
														var oddString = "";
														var oddValues = 0;
														var evenValues = 0;
														var totalValues = 0;
														var checkDigit = "";
														var checkDigitValue = 0;
												
														for(var i = 0; i < len-1; i++)
														{
															iqamaNumber[i] = eval(val.charAt(i));
														}
												
														for(var i = 0; i < len-1; i += 2)
														{
															oddString += (iqamaNumber[i] * 2).toString();
														}
												
														for(var i = 0; i < oddString.length; i++)
														{
															iqamaOddSum[i] = eval(oddString.charAt(i));
														}
												
														for(var i = 0; i < iqamaOddSum.length; i++)
														{
															oddValues += iqamaOddSum[i];
														}
												
														for(var i = 1; i < len-1; i += 2)
														{
															evenValues += iqamaNumber[i];
														}
												
														totalValues = evenValues + oddValues;
														checkDigit = totalValues.toString();
														checkDigit = checkDigit.charAt(checkDigit.length-1);
														checkDigitValue = eval(10 - checkDigit);
												
														if(checkDigitValue == 10)
														{
															if(checkDigitValue.toString().charAt(1) != val.charAt(len-1))
															{
																flag = false;
															}
														}
														else if(checkDigitValue.toString() != val.charAt(len-1))
														{
															flag = false;
														}
													}
													return flag;
								    			}
											</aui:validator>
										</aui:input>
								<%
									}
									else
									{
								%>
										<aui:input class="form-control" type="text" id="applicantId" name="applicantId" placeholder="Enter your Iqama or Saudi ID Number" value="<%=id %>" label="">
											<aui:validator name="required" />
											<aui:validator name="number"/>
											<aui:validator name="rangeLength" errorMessage="Please enter a valid id">[10,10]</aui:validator>
											<aui:validator name="custom" errorMessage="Please enter a valid id">
												function(val, fieldNode, ruleValue){
								    				var flag = true;
								    				var keyLength = 10;
													var len = val.length;
												
													if(len < keyLength)
													{
														flag = false;
													}
													else
													{
														var iqamaNumber = new Array();
														var iqamaOddSum = new Array();
														var oddString = "";
														var oddValues = 0;
														var evenValues = 0;
														var totalValues = 0;
														var checkDigit = "";
														var checkDigitValue = 0;
												
														for(var i = 0; i < len-1; i++)
														{
															iqamaNumber[i] = eval(val.charAt(i));
														}
												
														for(var i = 0; i < len-1; i += 2)
														{
															oddString += (iqamaNumber[i] * 2).toString();
														}
												
														for(var i = 0; i < oddString.length; i++)
														{
															iqamaOddSum[i] = eval(oddString.charAt(i));
														}
												
														for(var i = 0; i < iqamaOddSum.length; i++)
														{
															oddValues += iqamaOddSum[i];
														}
												
														for(var i = 1; i < len-1; i += 2)
														{
															evenValues += iqamaNumber[i];
														}
												
														totalValues = evenValues + oddValues;
														checkDigit = totalValues.toString();
														checkDigit = checkDigit.charAt(checkDigit.length-1);
														checkDigitValue = eval(10 - checkDigit);
												
														if(checkDigitValue == 10)
														{
															if(checkDigitValue.toString().charAt(1) != val.charAt(len-1))
															{
																flag = false;
															}
														}
														else if(checkDigitValue.toString() != val.charAt(len-1))
														{
															flag = false;
														}
													}
													return flag;
								    			}
											</aui:validator>
										</aui:input>
								<%
									}
								%>
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_18">
										<div>
											<div>Applicant Name</div>
										</div>
									</div>
								</label>
								<%
									if(isSignedIn)
									{
								%>
									<aui:input class="form-control" type="text" id="applicantName" name="applicantName" label="" placeholder="Enter your name" value="<%=name%>" readonly="true">
										<aui:validator name="required" />
									</aui:input>
								<%
									}
									else
									{
								%>
									<aui:input class="form-control" type="text" id="applicantName" name="applicantName" label="" placeholder="Enter your name" value="<%=name%>">
										<aui:validator name="required" />
									</aui:input>
								<%
									}
								%>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_21">
										<div>
											<div><liferay-ui:message key="mobile_number"/></div>
										</div>
									</div>
								</label>
								
								<%
									if(isSignedIn)
									{
								%>
								
										<aui:input class="form-control" type="text" id="mobile" name="mobile" label="" readonly="true" value="<%=mobile%>">
											<aui:validator name="required"/>
											<aui:validator name="number"/>
											<aui:validator name="rangeLength" errorMessage="Please enter a valid mobile number">[10,10]</aui:validator>
											<aui:validator name="custom" errorMessage="Please enter a valid mobile number">
												function(val, fieldNode, ruleValue){
								    				var allowedCharacters = '05';
								    				var regex = new RegExp('(^05)([0-9]{8})');
								    				return regex.test(val);
								    			}
											</aui:validator>
										</aui:input>
								<%
									}
									else
									{
								%>
										<aui:input class="form-control" type="text" id="mobile" name="mobile" label="" placeholder="05XXXXXXXX" value="<%=mobile%>">
											<aui:validator name="required"/>
											<aui:validator name="number"/>
											<aui:validator name="rangeLength" errorMessage="Please enter a valid mobile number">[10,10]</aui:validator>
											<aui:validator name="custom" errorMessage="Please enter a valid mobile number">
												function(val, fieldNode, ruleValue){
								    				var allowedCharacters = '05';
								    				var regex = new RegExp('(^05)([0-9]{8})');
								    				return regex.test(val);
								    			}
											</aui:validator>
										</aui:input>
								<%
									}
								%>
								
								
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_19">
										<div>
											<div><liferay-ui:message key="nationality"/></div>
										</div>
									</div>
								</label>
								<aui:select class="form-control" name="nationality" id="nationality" label="" > 
									<aui:option value="-1"><liferay-ui:message key="please_select_option"/></aui:option>
					<%
							for(CodeMasterDetails nationalityDtls: nationalitiesList)
							{
								boolean hasNat = (nationality!=""&& nationality.equals(nationalityDtls.getCodeSub())); 
					%>
									<aui:option selected="<%=hasNat%>" value="<%=nationalityDtls.getCodeSub()%>"><%=(currLocale.equals("en_US"))?nationalityDtls.getCodeDesc():nationalityDtls.getCodeDescAr()%></aui:option>
					<%
							}
					%>				
									<aui:validator name="custom" errorMessage='Please select nationality' > 
										function (val, fieldNode, ruleValue) {
											return (val != '-1');
										}
									</aui:validator>									 
								</aui:select>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_23">
										<div>
											<div><liferay-ui:message key="e_mail"/></div>
										</div>
									</div>
								</label>
								<%
									if(isSignedIn)
									{
								%>
								
										<aui:input class="form-control" type="email" id="mail" name="mail" label="" readonly="true" value="<%=email%>">
											<aui:validator name="required" />
											<aui:validator name="email" />
										</aui:input>
								<%
									}
									else
									{
								%>
										<aui:input class="form-control" type="email" id="mail" name="mail" label="" placeholder="Example@atmc.com.sa" value="<%=email%>">
											<aui:validator name="required" />
											<aui:validator name="email" />
										</aui:input>
								<%
									}
								%>
								
							</div>
						</div>
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group has-feedback">
								<label class="control-label">Applicant Age</label>
								<aui:input type="text" id="age" name="age" class="form-control" label="" title="" value="<%= age%>">
									<aui:validator name="required" />
									<aui:validator name="number" />
									<aui:validator name="min">16</aui:validator>
									<aui:validator name="rangeLength">[2,2]</aui:validator>
								</aui:input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-lg-6 col-md-6 col-sm-6">
							<div class="form-group">
								<label class="control-label">
									<div id="s-Text_33">
										<div>
											<div><liferay-ui:message key="compensation_amount"/>&nbsp;&nbsp;</div>
										</div>
									</div>
								</label>
								<aui:input class="form-control" type="text" name="compAmount" id="compAmount" label="" placeholder="Amount in SR" value="<%=amount %>">
									<aui:validator name="required" />
									<aui:validator name="number" />
								</aui:input>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 text-right no-pad">
							<ul class="list-btns">
								<li>
									<button class="btn btn-lg text-muted btn-xs-block btn-link" type="button" onclick="$('#landingBackForm').submit();"><i class="material-icons md-24">&#xE5C4;</i> <liferay-ui:message key="back"/> </button>
								</li>
								<li>
									<button class="btn btn-primary btn-lg btn-xs-block" id="submitBtn" type="submit"><liferay-ui:message key="continue"/> </button>
								</li>
							</ul>
						</div>
					</div>
				</div>
				</aui:form>
			</div>						 
		</div>
	</div>
</div>
