package com.ibm.springboot.demo.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class EmployeeServiceAspect {
	private final Logger LOG = LoggerFactory.getLogger(this.getClass());
//	@Before("execution(* com.ibm.springboot.demo.service.*.*(..))")
//	public void serviceMethods() {
//		LOG.info("a method from EployeeServiceAspect");
//	}
//	@After("execution(* com.ibm.springboot.demo.service.*.*(..))")
//	public void serviceMethods2() {
//		LOG.info("a method from EployeeServiceAspect2");
//	}
//	@AfterReturning("execution(* com.ibm.springboot.demo.service.*.*(..))")
//    public void serviceMethods3() {
//        
//        // Log success message
//        System.out.println("Data Returned successfully");
//    }
//	@AfterThrowing("execution(* com.ibm.springboot.demo.service.*.*(..))")
//	public void serviceMethods4() {
//		LOG.info("Data could not be returned");
//	}
}
