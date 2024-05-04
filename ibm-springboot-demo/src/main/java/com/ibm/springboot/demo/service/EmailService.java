package com.ibm.springboot.demo.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;

import com.ibm.springboot.demo.Employee;

@Service
public class EmailService {

	private final Logger LOG = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JavaMailSender javaMailSender;

	public void sendEmail(Employee employee) {
		LOG.info(employee.getEmail());
		SimpleMailMessage mailMessage = new SimpleMailMessage();
		mailMessage.setFrom("sumits2700@gmail.com");
		mailMessage.setTo(employee.getEmail());
		String subject = employee.getFirstName() != null ? employee.getFirstName().toUpperCase() : "Employee" ;
		mailMessage.setSubject(subject  + "'s Data Accessed");
		mailMessage.setText("Hi " + employee.getFirstName() + ". \nYour data in the database with the id "
				+ employee.getEid() + " was accessed just now.");
		LOG.info(mailMessage.toString());
		javaMailSender.send(mailMessage);
	}
}