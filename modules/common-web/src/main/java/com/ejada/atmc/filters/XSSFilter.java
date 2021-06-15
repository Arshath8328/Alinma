/**
 * 
 */
package com.ejada.atmc.filters;

import com.ejada.atmc.web.constants.VacanciesPortletKeys;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.ParamUtil;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.osgi.service.component.annotations.Component;
import org.owasp.encoder.Encode;

/**
 * @author Gasser
 *
 */

@Component(
		immediate = true,
		property = { "servlet-context-name=", 
				"dispatcher=FORWARD", 
				"dispatcher=REQUEST", 
				"servlet-filter-name=Ejada XSS Filter",
				"url-pattern=/web/customer/*", 
				"url-pattern=/group/customer/*" },
		service = Filter.class
)
public class XSSFilter extends BaseFilter {

	private static final Log	_log			= LogFactoryUtil.getLog(XSSFilter.class);
	private List<String>		noCheckList		= new ArrayList<String>();
	private static final String	errorPageURL	= "/web/customer/error";

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {

		// _log.info("Filter is invoked");

		// response.setHeader("X-FRAME-OPTIONS", "SAMEORIGIN");

		if (request.getParameter(VacanciesPortletKeys.JOB_ID) != null) {
			_log.info("ObjID Found");
			boolean match = Pattern.matches("([0-9]+)", request.getParameter(VacanciesPortletKeys.JOB_ID));
			if (!match) {
				_log.info("ObjID not matched");
				if (isAjax(request)) {
					response.setContentType("text/html");
					response.getWriter().write("XSS_ERROR");
				} else {
					SessionErrors.add(request, "xss.error");
					response.sendRedirect(errorPageURL);
				}
				return;
			}
			_log.info("ObjID matching ok!");
		}

		if (request.getParameter("p_p_id") != null && !request.getParameter("p_p_id").startsWith("com_liferay")) {

			boolean validRequest = false;
			Iterator<Entry<String, String[]>> params = null;

			try {
				params = request.getParameterMap().entrySet().iterator();
				_log.info("XSSFilter Checked Request URL >>> " + request.getRequestURI() + "?" + request.getQueryString());

			} catch (Exception e) {
				if (e instanceof IllegalArgumentException) {
					_log.error("Invalid Request URL , Please check the queryString you typed.EXPIRING Session.");
				} else {
					_log.error("Un Excepected error occured , please make sure you typed a valid request.EXPIRING Session");
				}
				validRequest = false;

				if (isAjax(request)) {
					response.setContentType("text/html");
					response.getWriter().write("XSS_ERROR");
				} else {
					SessionErrors.add(request, "xss.error");
					response.sendRedirect(errorPageURL);
				}
				// don't continue the flow
				return;
			}
			// looping on all param map entries
			while (params.hasNext()) {
				Entry entry = params.next();
				String[] vals = (String[]) entry.getValue();
				// looping on all values of 1 param
				for (String val : vals) {
					_log.debug("key:" + entry.getKey() + ",value" + val);
					validRequest = XSSValidator.isValid(Encode.forHtml(val));
					if (validRequest) {
						validRequest = val.indexOf("\"-") == -1 && val.indexOf("\"*") == -1;
					}
					if (!validRequest)// param value is invalid
					{
						String key = (String) entry.getKey();
						boolean shouldCheck = true;
						// do we want to skip the param?
						for (String regex : noCheckList) {
							if (key.matches(regex)) {

								/**
								 * The no check list could include potentially threatening string that would allow script injection.
								 */
								if (val.contains("<script>")) {
									_log.debug(key + " matches the nocheck list but its value is potentially threatening with value:" + val);
									shouldCheck = true;//
								} else {
									_log.debug(key + " is invalid but macthes the nocheck list");
									shouldCheck = false;// skip
								}
								break;

							}
						}
						// we should not skip it
						if (shouldCheck) {
							_log.info("Cross site scripting XSS captured, expiring.Value captured " + val);
							if (isAjax(request)) {
								response.setContentType("text/html");
								response.getWriter().write("XSS_ERROR");
							} else {
								SessionErrors.add(request, "xss.error");
								response.sendRedirect(errorPageURL);
							}
							// don't continue the flow
							return;
						}
					}
				}
			}

		} else {

			_log.debug("XSSFilter: Liferay request SKIPPING.URI:" + request.getRequestURI());
		}

		boolean mobileView = ParamUtil.getBoolean(request, "mobileView", false);
		if (mobileView) {
			response.setHeader("Access-Control-Allow-Origin", "https://atmc.com.sa");
			response.setHeader("X-Frame-Options", "*");
		}

		super.processFilter(request, response, filterChain);
	}

	@Override
	protected Log getLog() {
		return _log;
	}

	public static boolean isAjax(HttpServletRequest request) {
		return "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
	}

}
