/**
 * 
 */
package com.liuxc.thread.jms;

import javax.jms.JMSException;

/**
 * 消费者客户端
 * @since:2017年11月5日
 * @author:liuxc
 */
public class ConsumerClient {

	/**
	 * @param args
	 * @since:2017年11月5日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		Consumer c = new Consumer();
		c.init();
		ConsumerClient client = new ConsumerClient();
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		new Thread(client.new ConsumerThread(c)).start();
		new Thread(client.new ConsumerThread(c)).start();
		new Thread(client.new ConsumerThread(c)).start();
		new Thread(client.new ConsumerThread(c)).start();
		new Thread(client.new ConsumerThread(c)).start();

	}
	
	private class ConsumerThread implements Runnable {

		private Consumer consumer;
		
		public ConsumerThread(Consumer consumer) {
			this.consumer = consumer;
		}

		@Override
		public void run() {
			while(true) {
				try {
					consumer.getMessage("active-mq");
					Thread.sleep(10000);
				} catch (JMSException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
