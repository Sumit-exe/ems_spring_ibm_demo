package com.ibm.springboot.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Employee")
public class Employee {
	
	@Id
	private String eid ;
	private String firstName ;
	private String email;


	private Long aadhaar;
	private int salary;
	private int age ;

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String name, String eid,String email,Long aadhaar, int salary, int age) {
		super();
		this.eid = eid;
		this.firstName = name;
		this.email = email;
		this.aadhaar = aadhaar;
		this.salary = salary;
		this.age = age;
	}
	

	

	public String getEid() {
		return eid;
	}

	public void setEid(String eid) {
		this.eid = eid;
	}
	

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getAadhaar() {
		return aadhaar;
	}

	public void setAadhaar(Long aadhaar) {
		this.aadhaar = aadhaar;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + firstName + ", eid=" + eid + ", salary=" + salary + ", age=" + age + "]";
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
}
