package com.atmc.login.portlet;

import com.atmc.login.constants.LoginPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author Basel
 */
@Component(
		immediate = true,
		property = {"com.liferay.portlet.display-category=category.sample",
                "com.liferay.portlet.header-portlet-css=/css/main.css",
                "com.liferay.portlet.instanceable=false",
                "javax.portlet.display-name=Login Portlet",
                "javax.portlet.init-param.template-path=/",
                "javax.portlet.init-param.view-template=/login.jsp",
                "javax.portlet.name=" + LoginPortletKeys.LOGIN,
                "javax.portlet.resource-bundle=content.Language",
                "javax.portlet.security-role-ref=power-user,user" 
		},
		service = Portlet.class
)
public class LoginPortlet extends MVCPortlet {

	@Override
	protected void addSuccessMessage(ActionRequest actionRequest, ActionResponse actionResponse) {
		return;
	}

}