package com.moodle.doer.common.session.core;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionContext;

import com.moodle.doer.common.session.HttpSessionListener;

@SuppressWarnings({ "serial", "deprecation" })
public class CachedHttpSession implements HttpSession, Serializable {
	protected long creationTime = 0L;
	protected String id;
	protected int maxInactiveInterval;
	protected long lastAccessedTime = 0L;
	protected transient boolean expired = false;
	protected transient boolean isNew = false;
	protected transient boolean isDirty = false;
	private transient HttpSessionListener listener;
	private Map<String, Object> data = new ConcurrentHashMap<String, Object>();

	@Override
	public Object getAttribute(String key) {
		return this.data.get(key);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Enumeration getAttributeNames() {
		final Iterator iterator = this.data.keySet().iterator();
		return new Enumeration() {
			public boolean hasMoreElements() {
				return iterator.hasNext();
			}

			public Object nextElement() {
				return iterator.next();
			}
		};
	}

	@Override
	public Object getValue(String key) {
		return this.data.get(key);
	}

	@Override
	public String[] getValueNames() {
		String[] names = new String[this.data.size()];
		return (String[]) this.data.keySet().toArray(names);
	}

	@Override
	public void invalidate() {
		this.expired = true;
		this.isDirty = true;
		if (this.listener != null)
			this.listener.onInvalidated(this);
	}

	@Override
	public boolean isNew() {
		return this.isNew;
	}

	@Override
	public void putValue(String s, Object o) {
		if (s == null || o == null)
			return;
		this.data.put(s, o);
		this.isDirty = true;

	}

	@Override
	public void removeAttribute(String s) {
		this.data.remove(s);
		this.isDirty = true;

	}

	@Override
	public void removeValue(String s) {
		this.data.remove(s);
		this.isDirty = true;
	}

	@Override
	public void setAttribute(String s, Object o) {
		if (s == null || o == null)
			return;
		this.data.put(s, o);
		this.isDirty = true;
	}

	public void setListener(HttpSessionListener listener) {
		this.listener = listener;
	}

	@Override
	public long getCreationTime() {
		return this.creationTime;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public long getLastAccessedTime() {
		return this.lastAccessedTime;
	}

	public void setLastAccessedTime(long lastAccessedTime) {
		this.lastAccessedTime = lastAccessedTime;
	}

	@Override
	public ServletContext getServletContext() {
		return null;
	}

	@Override
	public void setMaxInactiveInterval(int i) {
		this.maxInactiveInterval = i;
	}

	@Override
	public int getMaxInactiveInterval() {
		return this.maxInactiveInterval;
	}

	@Override
	public HttpSessionContext getSessionContext() {
		return null;
	}

}
