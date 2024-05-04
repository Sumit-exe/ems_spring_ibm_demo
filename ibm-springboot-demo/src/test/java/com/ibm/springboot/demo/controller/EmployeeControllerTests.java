package com.ibm.springboot.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.ibm.springboot.demo.Employee;
import com.ibm.springboot.demo.controller.EmployeeController;
import com.ibm.springboot.demo.service.EmployeeServiceImpl;


@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTests {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private EmployeeServiceImpl	employeeService;
	
	@BeforeEach
	public void setUp() {
		List<Employee> empList = new ArrayList<>();
		empList.add(new Employee("101","sonu","sumit@gmail",39832L, 1000,10));
		empList.add(new Employee("102","sonu","sumit@gmail",39832L, 1000,10));
		empList.add(new Employee("103","sonu","sumit@gmail",39832L, 1000,10));
		empList.add(new Employee("104","sonu","sumit@gmail",39832L, 1000,10));
		when(employeeService.getAllEmployees()).thenReturn(empList);
//		return null;
	}
	
	
	@Test
	public void testEmployeeControllerStatus() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andExpect(status().isOk());
	}
	
	@Test
	public void testEmployeeControllerMediaType() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andExpect(content().contentType(MediaType.APPLICATION_JSON));
	}
	
	@Test
	public void testEmployeeControllerPrint() throws Exception {
		mockMvc.perform(get("/emp/get-all-emps")).andDo(print());
	}
//	
}
