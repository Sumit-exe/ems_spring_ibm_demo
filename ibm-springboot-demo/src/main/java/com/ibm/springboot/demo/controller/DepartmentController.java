package com.ibm.springboot.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.springboot.demo.Employee;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.service.DepartmentService;


@RestController
@RequestMapping("dept")
public class DepartmentController {

	
	@Autowired
	DepartmentService departmentService;

	@GetMapping("get-all-depts")
	public ResponseEntity<List<Department>> getAllEmps() {
		List<Department> deptList = departmentService.getAllDepartments();
		deptList.forEach(System.out::println);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "All employees data fetched successfully!");
		ResponseEntity<List<Department>> response = new ResponseEntity<List<Department>>(deptList, headers, status);
		return response;
	}

	@GetMapping("get-dept-by-id/{did}")
	public ResponseEntity<Department> getEmpById(@PathVariable(name = "did") String departmentId) {
		System.out.println(departmentId);
		Department employee = departmentService.getDepartmentById(departmentId);
		System.out.println(employee.toString());
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee data fetched successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(employee, headers, status);
		return response;
	}

//	@GetMapping("get-emp-by-name/{fname}")
//	public ResponseEntity<List<Employee>> getEmpName(@PathVariable(name = "fname") String firstName) {
//		List<Employee> empList = employeeService.getEmployeeByFirstName(firstName);
//		HttpStatus status = HttpStatus.OK;
//		HttpHeaders headers = new HttpHeaders();
//		headers.add("message", "Employees data fetched successfully!");
//		ResponseEntity<List<Employee>> response = new ResponseEntity<List<Employee>>(empList, headers, status);
//		return response;
//	}

	@PostMapping("add-dept")
	public ResponseEntity<Department> addEmp(@RequestBody Department department) {
		Department deptToBeAdded = departmentService.addDepartment(department);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee added successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeAdded, headers, status);
		return response;
	}
	@DeleteMapping("delete-dept/{did}")
	public ResponseEntity<Department> deleteDepartment(@PathVariable(name = "did") String employeeId) {
		Department deptToBeDeleted = departmentService.deleteDepartment(employeeId);
		HttpStatus status = HttpStatus.OK;
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "Employee Deleted successfully!");
		ResponseEntity<Department> response = new ResponseEntity<Department>(deptToBeDeleted, headers, status);
		return response;
	}
}
