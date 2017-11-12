/**
 * 
 */
package com.liuxc.thread.jms;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * activeMQ消费者
 * @since:2017年11月3日
 * @author:liuxc
 */
public class Consumer {

	private static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;
	private static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String DEFAULT_BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	
	private AtomicInteger count = new AtomicInteger();
	/*连接工厂*/
	private ConnectionFactory connFactory;
	/*连接对象*/
	private Connection conn;
	/*session对象*/
	private Session session;
	/*绑定消息生产者到线程上*/
	private ThreadLocal<MessageConsumer> msgConsumerLocal = new ThreadLocal<MessageConsumer>();
	
	/**
	 * 初始化session
	 * @since:2017年11月5日
	 * @author:liuxc
	 */
	public void init() {
		try {
			connFactory = new ActiveMQConnectionFactory(DEFAULT_USER, DEFAULT_PASSWORD, DEFAULT_BROKER_URL);
			
			conn = connFactory.createConnection();//创建connection对象时，传输默认是关闭状态，必须调用start方法开启
			
			conn.start();
			
			session = conn.createSession(true, Session.SESSION_TRANSACTED);
			
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void getMessage(String message) throws JMSException, InterruptedException {
		//根据message创建消息模式point to point
		Queue queue = session.createQueue(message);
		/*消息消费者*/
		MessageConsumer consumer = null;
		
		if(msgConsumerLocal.get() != null) {
			consumer = msgConsumerLocal.get();
		} else {
			consumer = session.createConsumer(queue);
			msgConsumerLocal.set(consumer);
		}
		
		while(true) {
			Thread.sleep(1000);
			
			TextMessage textMessage = (TextMessage) consumer.receive();
			
			if(textMessage != null){
				textMessage.acknowledge();
				System.out.println(Thread.currentThread().getName()+":我是消费者，"
						+ "正在消费Message【"+textMessage.getText()+"】--->"+count.getAndIncrement());
			} else {
				System.out.println("已经没有消费可消费......");
				break;
			}
			
		}
	}
}
