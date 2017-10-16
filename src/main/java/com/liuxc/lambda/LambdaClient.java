package com.liuxc.lambda;

import com.liuxc.lambda.intf.ICommonAppender;

/**
 * lambda表达式使用参考：http://www.importnew.com/16436.html
 * @author dell
 *
 */
public class LambdaClient {

	private String result;
	
	public LambdaClient(String result) {
		this.result = result;
	}

	public LambdaClient toLambdaClient() {
		LambdaClient client = new LambdaClient("666");
		return client;
	}
	
	public static void main(String[] args) {
//		append(value());

		String message = doAppend(() -> append("java8"));
		System.out.println(message);
	}

	public static String value() {
		return "suffix";
	}
	
	public static String append(String str) {
		StringBuffer sb = new StringBuffer("start use lambda ");
		sb.append(str);
		return sb.toString();
	}
	
	public static String doAppend(ICommonAppender append) {
		return append.doAppend();
		
	}
}
