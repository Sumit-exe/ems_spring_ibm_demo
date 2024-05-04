package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundExpection;
import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.repository.DepartmentRepository;
import com.ibm.springboot.demo.repository.EmployeeRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	private final Logger LOG =  LoggerFactory.getLogger(this.getClass());

	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		
		List<Department> deptList = departmentRepository.findAll();
		if(deptList.isEmpty()) {
			String errorMessage = "No Departments are found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundExpection(errorMessage);
		}
		else {
			LOG.info("Getting all Departments");
			return deptList;
		}
	}

	@Override
	public Department getDepartmentById(String departmentId) {
		// TODO Auto-generated method stub
		LOG.info("Getting Department by Id");
		Optional<Department> deptOptional = departmentRepository.findById(departmentId);
		if(deptOptional.isEmpty()) {
			String errorMessage = "Department with the id " + departmentId + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundExpection(errorMessage);
		}else {
			return deptOptional.get(); 
			
		}
	}

	@Override
	public Department addDepartment(Department department) {
		// TODO Auto-generated method stub
		LOG.info("adding new Department");
		return departmentRepository.save(department);
	}

	@Override
	public Department deleteDepartment(String departmentId) {
		// TODO Auto-generated method stub
		LOG.info(departmentId);
		Department deptToBeDeleted = this.getDepartmentById(departmentId);
		if(deptToBeDeleted == null) {
			String errorMessage = "Department with DepartmentId" + departmentId+ "is not Found";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundExpection(errorMessage);
		}else {
			departmentRepository.deleteById(departmentId);
			LOG.info("Department with deparmentId" + departmentId +" is Deleted");
			return deptToBeDeleted;
		}
		
		
	}
	
	

}
