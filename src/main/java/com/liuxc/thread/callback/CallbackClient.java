package com.liuxc.thread.callback;

public class CallbackClient {

	public static void main(String[] args) {

		System.out.println(execute(new CallbackA()));
		
		System.out.println(execute(new CallbackB()));
	}

	public static String execute(BaseCallback callback) {
		return callback.getCurrentThreadName();
	}
}
