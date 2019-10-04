package com.example.demo;

import javax.jms.Queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class Config {

	@Bean
	Queue actiQueue() {

		return new ActiveMQQueue("standalone_queue");
	}

	@Bean
	ActiveMQConnectionFactory activeMQConnectionFactory() {
		ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory();
		activeMQConnectionFactory.setBrokerURL("tcp://localhost:61616");

		return activeMQConnectionFactory;
	}

	@Bean
	JmsTemplate jmsTemplate() {

		JmsTemplate template = new JmsTemplate(activeMQConnectionFactory());
		return template;
	}

}
