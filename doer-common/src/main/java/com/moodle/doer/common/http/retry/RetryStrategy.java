package com.moodle.doer.common.http.retry;

/**
 * 重试的策略
 *
 */
public interface RetryStrategy {

	<T> T retry() throws Exception;

}
