package com.example.library.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;



//@RestController
public class MainController {
	
	

	private static Logger log = LoggerFactory.getLogger(MainController.class);
	
	//@GetMapping("/login")
	public String getRequest() {
		log.info("Inside Website's Login Request");
		return "home";
	}
	
	//@GetMapping("/register/{value}")
	public String registerUser(@PathVariable String value) {
		log.info("Inside Website's Register Request" + value);
		return "register ::: "+value;
	}
	
	//@GetMapping("/search")
	public String searchDetails() {
		log.info("Inside Website's Search Request");
		return "search";
	}
}
