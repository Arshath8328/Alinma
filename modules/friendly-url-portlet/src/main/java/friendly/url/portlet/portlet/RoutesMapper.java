package friendly.url.portlet.portlet;

import com.liferay.portal.kernel.portlet.DefaultFriendlyURLMapper;
import com.liferay.portal.kernel.portlet.FriendlyURLMapper;

import org.osgi.service.component.annotations.Component;

import friendly.url.portlet.constants.FriendlyUrlPortletKeys;

@Component(
	    property = {
	        "com.liferay.portlet.friendly-url-routes=META-INF/friendly-url-routes/routes.xml",
	        "javax.portlet.name=" + FriendlyUrlPortletKeys.FRIENDLYURL
	    },
	    service = FriendlyURLMapper.class
	)

public class RoutesMapper extends DefaultFriendlyURLMapper {
	public RoutesMapper() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String getMapping() {
		return _MAPPING;
	}

	private static final String _MAPPING = "usertoken";
}
