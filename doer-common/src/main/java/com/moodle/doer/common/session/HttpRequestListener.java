package com.moodle.doer.common.session;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * http请求监听器
 * 
 * @author lixiongcheng
 *
 */
public interface HttpRequestListener {
	/**
	 * 请求完成后触发
	 * 
	 * @param request
	 * @param response
	 */
	public void onCompleted(HttpServletRequest request, HttpServletResponse response);
}
