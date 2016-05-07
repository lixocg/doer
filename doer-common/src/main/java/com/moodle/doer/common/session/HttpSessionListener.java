package com.moodle.doer.common.session;

import com.moodle.doer.common.session.core.CachedHttpSession;

/**
 * session监听器
 * 
 * @author lixiongcheng
 *
 */
public interface HttpSessionListener {
	/**
	 * session更新
	 * 
	 * @param cachedHttpSession
	 */
	public void onAttributeChanged(CachedHttpSession cachedHttpSession);

	/**
	 * session 失效
	 * 
	 * @param cachedHttpSession
	 */
	public void onInvalidated(CachedHttpSession cachedHttpSession);
}
