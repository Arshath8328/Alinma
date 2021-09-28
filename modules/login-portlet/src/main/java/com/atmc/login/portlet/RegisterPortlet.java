package com.atmc.login.portlet;

import com.atmc.login.constants.RegisterPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;


/**
 * @author vidit
 */
@Component(
	immediate = true, 
	property = { 
		"com.liferay.portlet.display-category=ATMC", 
		"com.liferay.portlet.instanceable=false",
		"javax.portlet.display-name=ATMC Register Portlet",
		"javax.portlet.init-param.template-path=/register/", 
		"javax.portlet.init-param.view-template=/register/step1.jsp",
		"javax.portlet.name=" + RegisterPortletKeys.REGISTER,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" 
	},
	service = Portlet.class
)
public class RegisterPortlet extends MVCPortlet {

	public void step1Action(ActionRequest actionRequest, ActionResponse actionResponse) {
		actionRequest.setAttribute("step", "2");
	}

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}
}