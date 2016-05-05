package com.moodle.doer.common.http.core.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.utils.URIBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moodle.doer.common.http.core.UnreliableCallable;
import com.moodle.doer.common.http.util.HttpClientUtil;
import com.moodle.doer.common.http.util.HttpResponseCallbackHandler;
import com.moodle.doer.common.http.util.callback.HttpResponseCallbackHandlerJsonHandler;

public class JsonHttpGet<T> implements UnreliableCallable {
	public static final Logger log = LoggerFactory.getLogger(JsonHttpGet.class);

	private HttpRequestBase request;

	private HttpResponseCallbackHandler<T> responseHandler;

	public JsonHttpGet(Class<T> clazz, String url, Map<String, String> param) throws URISyntaxException {
		// 创建uri
		URIBuilder builder = new URIBuilder(url);
		if (param != null) {
			for (String key : param.keySet()) {
				builder.addParameter(key, param.get(key));
			}
		}
		URI uri = builder.build();
		HttpGet request = new HttpGet(uri);
		request.addHeader("content-type", "application/json");
		this.request = request;
		this.responseHandler = new HttpResponseCallbackHandlerJsonHandler<T>(clazz);
	}

	@Override
	public T call() throws Exception {
		T result = HttpClientUtil.execute(request, responseHandler);
		return result;
	}

}
