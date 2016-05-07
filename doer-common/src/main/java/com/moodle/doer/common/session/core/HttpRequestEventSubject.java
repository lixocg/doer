package com.moodle.doer.common.session.core;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.moodle.doer.common.session.HttpRequestListener;

public class HttpRequestEventSubject {
	private HttpRequestListener listener;

	public void attach(HttpRequestListener eventObserver) {
		this.listener = eventObserver;
	}

	public void detach() {
		this.listener = null;
	}

	public void completed(HttpServletRequest servletRequest,
			HttpServletResponse response) {
		if (this.listener != null)
			this.listener.onCompleted(servletRequest, response);
	}
}
