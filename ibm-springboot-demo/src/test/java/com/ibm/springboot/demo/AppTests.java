package com.ibm.springboot.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ibm.springboot.demo.repository.EmployeeRepository;
import com.ibm.springboot.demo.service.EmployeeServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AppTests {
	
	@MockBean
	private static EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeServiceImpl employeeService;
	
	private static final Logger LOG = LoggerFactory.getLogger(AppTests.class);
//	@Test
//	void contextLoads() {
//	}
	
	
////	positive test case
//	@Test
//	public void testTest() {
//		Integer expected = 10;
//		Integer actual = 5+5;
//		
//		assertEquals(expected,actual);
//	}
//	
////	negative test case
//	@Test
//	public void testTest2() {
//		Integer unexpected = 10;
//		Integer actual = 5+6;
//		
//		assertNotEquals(unexpected,actual);
//	}
//	
//	@BeforeAll
//	public static void setUP() {
//		LOG.info("before All");
//	}
//	
//	@AfterAll
//	public static void tearDown() {
//		LOG.info("after All");
//	}
//	
	@BeforeEach
	public void setUp() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee());
		empList.add(new Employee());
		empList.add(new Employee());
		empList.add(new Employee());
		
		when(employeeRepository.findAll()).thenReturn(empList);
//		return null;
	}
	
	
	
	@Test
	public void testAllEmps() {
		assertEquals(employeeService.getAllEmployees().size(),4);
	}
	
	@Test
	void testAllEmpsTimes() {
		employeeRepository.findAll();
		employeeRepository.findAll();
		employeeRepository.findAll();
		verify(employeeRepository, times(3)).findAll();
	}

}
