package com.moodle.doer.common.http.retry.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.moodle.doer.common.http.core.UnreliableCallable;
import com.moodle.doer.common.http.retry.RetryStrategy;

/**
 * 轮循重试
 *
 */
public class RoundBinRetryStrategy implements RetryStrategy {

	protected static final Logger LOGGER = LoggerFactory.getLogger(RoundBinRetryStrategy.class);

	private int retryTimes;

	private int sleepSeconds;

	private UnreliableCallable unreliableCaller;

	public RoundBinRetryStrategy(UnreliableCallable unreliableCaller, int retryTimes, int sleepSeconds) {
		this.unreliableCaller = unreliableCaller;
		this.retryTimes = retryTimes;
		this.sleepSeconds = sleepSeconds;
	}

	/**
	 * @param unreliableImpl
	 * @param retryTimes
	 * @param sleepSeconds
	 */
	public <T> T retry() throws Exception {
		int cur_time = 0;
		for (; cur_time < retryTimes; ++cur_time) {
			try {
				return this.unreliableCaller.call();
			} catch (Exception e) {
				LOGGER.warn("cannot reach, will retry " + cur_time + " .... " + e.toString());
				try {
					Thread.sleep(sleepSeconds * 1000);
				} catch (InterruptedException e1) {
				}
			}
		}
		LOGGER.warn("finally failed....");
		throw new Exception();
	}
}
