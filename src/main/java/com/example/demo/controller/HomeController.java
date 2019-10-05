package com.example.demo.controller;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/publish")
public class HomeController {

	@Autowired
	JmsTemplate template;
	@Autowired
	Queue queue;
	
	@GetMapping("/{message}")
	public String publishEvent(@PathVariable("message") String message) {
		
		template.convertAndSend(queue, message);
		return "publish success for "+message;
	}
	
}
