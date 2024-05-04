package com.ibm.springboot.demo.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Component
//@Controller
@RestController

@RequestMapping("hello")
public class HelloController {
	
	@GetMapping("/hi")
	public String hi() {
		System.out.println("hello world");
		return "HelloController wolrd";
	}

	@GetMapping("/hello")
	public String hello() {
		return "Sumit says hello";
	}
	
}
