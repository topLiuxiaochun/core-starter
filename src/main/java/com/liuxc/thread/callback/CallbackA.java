package com.liuxc.thread.callback;

public class CallbackA implements BaseCallback {

	@Override
	public String getCurrentThreadName() {
		return "CallbackA";
	}

}
