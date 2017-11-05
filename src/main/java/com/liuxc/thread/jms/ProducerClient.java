/**
 * 
 */
package com.liuxc.thread.jms;

import javax.jms.JMSException;

/**
 * 生产者客户端
 * @since:2017年11月5日
 * @author:liuxc
 */
public class ProducerClient {

	/**
	 * @param args
	 * @since:2017年11月5日
	 * @author:liuxc
	 */
	public static void main(String[] args) {
		Producer p = new Producer();
		p.init();
		ProducerClient client = new ProducerClient();
		
		new Thread(client.new ProducerThread(p)).start();
		new Thread(client.new ProducerThread(p)).start();
		new Thread(client.new ProducerThread(p)).start();
		new Thread(client.new ProducerThread(p)).start();
		new Thread(client.new ProducerThread(p)).start();

	}
	
	private class ProducerThread implements Runnable {

		private Producer producer;
		
		public ProducerThread(Producer producer) {
			this.producer = producer;
		}

		@Override
		public void run() {
			while(true) {
				try {
					producer.sendMessage("active-mq");
				} catch (JMSException e) {
					e.printStackTrace();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
		}
		
	}
}
