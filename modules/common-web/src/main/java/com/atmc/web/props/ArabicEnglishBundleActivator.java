package com.atmc.web.props;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ArabicEnglishBundleActivator implements BundleActivator {

	Log log = LogFactoryUtil.getLog(ArabicEnglishBundleActivator.class);

	@Override
	public void start(BundleContext context) throws Exception {
		log.info("Language Bundle started");
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		log.info("Language Bundle stopped");
	}

}
