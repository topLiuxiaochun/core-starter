/**
 * 
 */
package com.liuxc.thread;

/**
 * 异步调用
 * @since:2017年10月31日
 * @author:liuxc
 */
public class AsynchronizedInvoke {

	/**
	 * @param args
	 * @since:2017年10月31日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		asynchronized();

	}

	public static void asynchronized() {
		
		new Thread() {

			@Override
			public void run() {
				System.out.println(Thread.currentThread().getName() + "execute");
			}
			
		}.start();
		
		System.out.println("main code execute");
	}
}
