package com.atmc.ps.policy.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=PSPolicyStaff"
	    },
	    service = FriendlyURLMapper.class
	)

public class RoutesMapper extends DefaultFriendlyURLMapper {
	public RoutesMapper() {
	}

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "policy";
}
