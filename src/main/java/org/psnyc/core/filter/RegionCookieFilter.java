package org.psnyc.core.filter;

import org.apache.commons.lang.StringUtils;
import org.psnyc.core.resource.Subsite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mohit on 8/20/14.
 */
public class RegionCookieFilter implements javax.servlet.Filter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RegionCookieFilter.class);

    private static final List<String> byPassList = new ArrayList<String>();

    static {
        byPassList.add("/images");
        byPassList.add("/js");
        byPassList.add("/css");
        byPassList.add("/fonts");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.debug("in init");
    }

    @Override
    public void destroy() {
        LOGGER.debug("in destroy");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        if (request instanceof HttpServletRequest) {
            boolean regionCookieSet = false;
            Cookie[] cookies = ((HttpServletRequest) request).getCookies();
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("region")) {
                    String regionName = cookie.getValue();
                    if (StringUtils.isNotEmpty(regionName)) {
                        regionCookieSet = true;
                    }
                }
            }

            if (!regionCookieSet) {
                String uriPath = ((HttpServletRequest) request).getRequestURI();
                HttpServletResponse httpResponse = (HttpServletResponse) response;
                if (uriPath.contains("/" + Subsite.US) || uriPath.contains("/" + Subsite.EU)) {
                    String region = uriPath.contains("/" + Subsite.US) ? Subsite.US : Subsite.EU;
                    Cookie cookie = new Cookie("region", region);
                    httpResponse.addCookie(cookie);
                }
            }
            chain.doFilter(request, response);
        }
    }

    private boolean isBypassList(String contextPath) {
        for (String byPass : byPassList) {
            if (contextPath.contains(byPass))
                return true;
        }
        return false;
    }
}
