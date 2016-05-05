package com.moodle.doer.common.http.core;

public interface UnreliableCallable {
	public <T> T call() throws Exception;
}
