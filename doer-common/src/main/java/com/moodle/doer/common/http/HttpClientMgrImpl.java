package com.moodle.doer.common.http;

import java.util.Map;

import com.moodle.doer.common.http.retry.RetryStrategy;

public class HttpClientMgrImpl implements HttpClientMgr {
	private RetryStrategy strategy;
	
	public HttpClientMgrImpl(RetryStrategy strategy){
		this.strategy = strategy;
	}

	@Override
	public <T> T getJsonData(Class<T> clazz,String url,Map<String,String> param) throws Exception {
		return strategy.retry();
	}

}
