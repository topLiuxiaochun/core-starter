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
	
	private ThreadLocal<MessageConsumer> msgConsumerLocal = new ThreadLocal<MessageConsumer>();
	
	public void init() {
		try {
			connFactory = new ActiveMQConnectionFactory(DEFAULT_USER, DEFAULT_PASSWORD, DEFAULT_BROKER_URL);
			conn = connFactory.createConnection();
			conn.start();
			session = conn.createSession(true, Session.SESSION_TRANSACTED);
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
	
	public void getMessage(String message) throws JMSException, InterruptedException {
		//根据message创建消息模式point to point
		Queue queue = session.createQueue(message);
		
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
				System.out.println(Thread.currentThread().getName()+":我是消费者，我正在消费Msg【"+textMessage.getText()+"】--->"+count.getAndIncrement());
			} else {
				break;
			}
			
		}
	}
}
