/**
 * 
 */
package com.liuxc.thread.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 
 * @since:2017年11月12日
 * @author:liuxc
 */
public class SingleProducer {
	
	private static final String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
	private static final String queueName = "ActiveMQ_20171112";

	/**
	 * @param args
	 * @since:2017年11月12日
	 * @author:liuxc
	 * @throws JMSException 
	 */
	public static void main(String[] args) throws JMSException {
		// TODO Auto-generated method stub
		//创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		//创建连接
		Connection connection = connectionFactory.createConnection();
		//启动连接
		connection.start();
		//创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//创建会话模式
		Destination destination = session.createQueue(queueName);
		//创建生产者
		MessageProducer producer = session.createProducer(destination);
		//创建消息
		for(int i=0; i<100; i++) {
			TextMessage message = session.createTextMessage("message_" + i);
			//发送消息
			producer.send(message);
			System.out.println(message.getText());
		}
		//关闭连接
		connection.close();
	}

}
