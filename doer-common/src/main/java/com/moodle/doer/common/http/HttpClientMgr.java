package com.moodle.doer.common.http;

import java.util.Map;

public interface HttpClientMgr {
	<T> T getJsonData(Class<T> clazz, String url, Map<String, String> param) throws Exception;
}
