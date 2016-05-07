package com.moodle.doer.common.session.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 分布式session共享request解决方案
 * @author lixiongcheng
 *
 */
public class CachedHttpServletRequest extends HttpServletRequestWrapper {
	private CachedHttpSession cachedHttpSession;
	private CachedHttpSessionManager cachedHttpSessionManager;
	private HttpRequestEventSubject httpRequestEventSubject;
	private HttpServletResponse response;

	public CachedHttpServletRequest(HttpServletRequest request, HttpServletResponse response,
			CachedHttpSessionManager cachedHttpSessionManager, HttpRequestEventSubject httpRequestEventSubject) {
		super(request);
		this.response = response;
		this.cachedHttpSessionManager = cachedHttpSessionManager;
		this.httpRequestEventSubject = httpRequestEventSubject;
	}

	public HttpSession getSession(boolean create) {
		if (this.cachedHttpSession != null && !this.cachedHttpSession.expired)
			return this.cachedHttpSession;
		return this.cachedHttpSessionManager.create(this, this.response,this.httpRequestEventSubject, create);
	}

	public HttpSession getSession() {
		return getSession(true);
	}

}
