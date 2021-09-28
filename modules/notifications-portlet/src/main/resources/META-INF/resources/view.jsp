<%@page import="java.util.ArrayList"%>
<%@page import="com.liferay.portal.kernel.json.JSONArray"%>
<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONFactoryUtil"%>
<%@page import="com.liferay.portal.kernel.json.JSONObject"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="com.liferay.portal.kernel.model.UserNotificationEvent"%>
<%@page import="java.util.List"%>

<%@ include file="/init.jsp" %>

<% 

SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
List<UserNotificationEvent> notifications = (List<UserNotificationEvent>) request.getAttribute("notifications");
List<Long> unreadNotificationsIds = (List<Long>) request.getAttribute("unreadNotificationsIds");

%>
			<div class="row">
				<div class="col-md-12 col-lg-12 col-sm-12 col-xs-12">
					<h3 class="text-primary">Notifications</h3>
					<table class="table"> 
						<tbody> 
<%

						for (UserNotificationEvent notification : notifications) {
							
							String unreadClass = "";
							JSONObject jsonObject = JSONFactoryUtil.createJSONObject(notification.getPayload());
							String msgKey = jsonObject.getString("msgKey");
							JSONArray notificationParams = jsonObject.getJSONArray("notificationParams");
							
							ArrayList<String> paramsList = new ArrayList<String>();     
							 
							for(Object param : notificationParams){
								paramsList.add((String)param);
							}
							
							String message = LanguageUtil.format(locale, msgKey, paramsList.toArray(new String[paramsList.size()]));
								
							if (unreadNotificationsIds.contains(notification.getUserNotificationEventId()))
								unreadClass = "info";
%>
							<tr class="<%=unreadClass%>"> 
								<td> 
									<div class="text-muted">
										<span class="glyphicon glyphicon-star"></span><%=sdf.format(notification.getTimestamp()) %>
									</div>
									<p class="text-primary"><%=message %></p>
								</td>
							</tr>
							
<%

						}
%>							
						</tbody>
					</table>
				</div>
			</div>



