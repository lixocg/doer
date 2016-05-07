package com.moodle.doer.common.session.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moodle.doer.common.session.core.CachedHttpServletRequest;
import com.moodle.doer.common.session.core.CachedHttpSessionManager;
import com.moodle.doer.common.session.core.HttpRequestEventSubject;

public class CachedHttpSessionFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
		public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
		    HttpServletRequest request = (HttpServletRequest)servletRequest;

		    HttpServletResponse response = (HttpServletResponse)servletResponse;
		    CachedHttpSessionManager sessionManager=null;
		    HttpRequestEventSubject httpRequestEventSubject = new HttpRequestEventSubject();
		    CachedHttpServletRequest requestWrapper = new CachedHttpServletRequest(request, response,sessionManager,httpRequestEventSubject);
		    try {
		      filterChain.doFilter(requestWrapper, servletResponse);
		    }
		    finally {
		    	httpRequestEventSubject.completed(request, response);
		    }
		  }

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
