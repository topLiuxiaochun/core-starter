/**
 * 
 */
package com.liuxc.thread;

import java.util.concurrent.TimeUnit;

/**
 * 访问可变的共享变量
 * 参考Effective Java 第66条
 * @since:2018年1月3日
 * @author:liuxc
 */
public class AccessVariableShareField {

	private static volatile boolean stopRequested; 
	
	private static volatile int serialNum = 0;//最好将int类型替换为long类型，因为超过2的32次幂就会重复
	/**
	 * @param args
	 * @since:2018年1月3日
	 * @author:liuxc
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.out.println(stopRequested);
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println(stopRequested);
				int i = 0;
				while (!stopRequested) {
					i++;
					System.out.println(i);
				}
			}
		});
		thread.start();
		
//		TimeUnit.SECONDS.sleep(1);
		TimeUnit.MILLISECONDS.sleep(200);
		
		stopRequested = true;
		System.out.println(stopRequested);
		
		Thread aa = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 500; i++) {
					System.out.println("aa:" + getSerialNum());
				}
				
			}
		});
		aa.start();
		Thread bb = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 500; i++) {
					System.err.println("bb:" + getSerialNum());
				}
				
			}
		});
		bb.start();
		for (int i = 0; i < 200; i++) {
			Thread tt = new Thread(new Runnable() {
				
				@Override
				public void run() {
					StringBuffer buffer = new StringBuffer();
					for (int j = 0; j < 500; j++) {
						System.err.println(Thread.currentThread().getName() + getSerialNum());
					}
					
				}
			});
			tt.setName("tt" + i + "**");
			tt.start();
		}
		
	}

	public static int getSerialNum(){
		return serialNum++;
	}
}
