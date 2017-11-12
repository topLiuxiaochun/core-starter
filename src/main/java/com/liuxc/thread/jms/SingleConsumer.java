/**
 * 
 */
package com.liuxc.thread.jms;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

/**
 * 消费者。启动多个会平摊消费消息
 * @since:2017年11月12日
 * @author:liuxc
 */
public class SingleConsumer {
	
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
		//1.创建连接工厂
		ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
		//2.创建连接
		Connection connection = connectionFactory.createConnection();
		//3.启动连接
		connection.start();
		//4.创建会话
		Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		//5.创建会话模式
		Destination destination = session.createQueue(queueName);
		//6.创建消费者
		MessageConsumer consumer = session.createConsumer(destination);
		
		//7.创建监听器
		consumer.setMessageListener(new MessageListener() {
			
			@Override
			public void onMessage(Message message) {
				TextMessage textMessage = (TextMessage) message;
				try {
					System.out.println("message:" + textMessage.getText());
				} catch (JMSException e) {
					e.printStackTrace();
				}
				
			}
		});
	}

}
