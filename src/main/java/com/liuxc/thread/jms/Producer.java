/**
 * 
 */
package com.liuxc.thread.jms;

import java.util.concurrent.atomic.AtomicInteger;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * activeMQ生产者
 * @since:2017年11月3日
 * @author:liuxc
 */
public class Producer {

	private static final String DEFAULT_USER = ActiveMQConnection.DEFAULT_USER;
	private static final String DEFAULT_PASSWORD = ActiveMQConnection.DEFAULT_PASSWORD;
	private static final String DEFAULT_BROKER_URL = ActiveMQConnection.DEFAULT_BROKER_URL;
	/*原子性计数类*/
	private AtomicInteger count = new AtomicInteger();
	/*连接工厂*/
	private ConnectionFactory connFactory;
	/*连接对象*/
	private Connection conn;
	/*会话对象*/
	private Session session;
	/*绑定消息生产者到线程上*/
	private ThreadLocal<MessageProducer> msgProducerLocal = new ThreadLocal<MessageProducer>();
	
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
	
	public void sendMessage(String message) throws JMSException, InterruptedException {
		//根据message创建消息模式point to point，即消息队列
		Queue queue = session.createQueue(message);
		//消息生产者
		MessageProducer producer = null;
		
		if(msgProducerLocal.get() != null) {
			producer = msgProducerLocal.get();
		} else {
			producer = session.createProducer(queue);
			msgProducerLocal.set(producer);
		}
		
		while(true) {
			Thread.sleep(1000);
			
			int num = count.getAndIncrement();
			
			//创建一条消息
			TextMessage textMessage = session.createTextMessage(Thread.currentThread().getName()
					+ "producer:我是豆腐西施，正在生产东西！,count:" + num);
			
			System.out.println(Thread.currentThread().getName()
					+ "producer:我是豆腐西施，正在生产东西！,count:" + num);
			
			producer.send(textMessage);
			
			//提交事务
			session.commit();
		}
	}
}
