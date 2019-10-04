package com.example.demo.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

	
	@JmsListener(destination = "standalone_queue")
	@SendTo("out_queue")
	public String consume(String message) {
		System.out.println("Recieved Message:::"+message);
		
		return message;
	}
}
