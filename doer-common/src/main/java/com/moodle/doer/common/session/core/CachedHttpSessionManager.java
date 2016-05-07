package com.moodle.doer.common.session.core;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

public class CachedHttpSessionManager {

	public HttpSession create(CachedHttpServletRequest cachedHttpServletRequest,
			HttpServletResponse response, HttpRequestEventSubject httpRequestEventSubject, boolean create) {
		String sessionId = getRequestedSessionId(cachedHttpServletRequest);

		CachedHttpSession session = null;
		if ((StringUtils.isEmpty(sessionId)) && (!create))
			return null;
		if (StringUtils.isNotEmpty(sessionId)) {
			session = loadSession(sessionId);
		}
		if ((session == null) && (create)) {
			session = createEmptySession(cachedHttpServletRequest, response);
		}
		if (session != null)
			attachEvent(session, cachedHttpServletRequest, response, httpRequestEventSubject);
		return session;
	}

	private void attachEvent(CachedHttpSession session, CachedHttpServletRequest cachedHttpServletRequest,
			HttpServletResponse response, HttpRequestEventSubject httpRequestEventSubject) {
		// TODO Auto-generated method stub
		
	}

	private CachedHttpSession createEmptySession(CachedHttpServletRequest cachedHttpServletRequest,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		return null;
	}

	private CachedHttpSession loadSession(String sessionId) {
		// TODO Auto-generated method stub
		return null;
	}

	private String getRequestedSessionId(CachedHttpServletRequest cachedHttpServletRequest) {
		// TODO Auto-generated method stub
		return null;
	}

}
