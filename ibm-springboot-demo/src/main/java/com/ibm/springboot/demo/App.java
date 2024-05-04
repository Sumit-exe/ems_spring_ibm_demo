package com.ibm.springboot.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;


//@Component
@SpringBootApplication
public class App {
	private static final Logger LOG = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		LOG.info("Application starting...");
		SpringApplication.run(App.class, args);
		LOG.info("Application started");
	}

}
