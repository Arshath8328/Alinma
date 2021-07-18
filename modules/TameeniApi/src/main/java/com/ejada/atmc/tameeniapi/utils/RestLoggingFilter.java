/**
 * 
 */
package com.ejada.atmc.tameeniapi.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

/**
 * @author Kareem Kahil
 *
 */

@Component(
		immediate = true,
		property =
		{ "servlet-context-name=", "dispatcher=FORWARD", "dispatcher=REQUEST", "servlet-filter-name=RestLoggingFilter", "url-pattern=/o/RestApi/invokeapi/*" },
		service = Filter.class
)
public class RestLoggingFilter extends BaseFilter {

	private static final Log _log = LogFactoryUtil.getLog(RestLoggingFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		/* wrap the request in order to read the inputstream multiple times */
		MultiReadHttpServletRequest multiReadRequest = new MultiReadHttpServletRequest((HttpServletRequest) request);
		String currentURL = (String) multiReadRequest.getAttribute("CURRENT_URL");
		String body = multiReadRequest.getBody();

		_log.info("Incoming Tameeni Request..." + currentURL);
		_log.info(body);

		chain.doFilter(multiReadRequest, response);
	}

	@Override
	protected Log getLog() {
		return _log;
	}
}
