package com.ibm.springboot.demo.exception;

public class DepartmentNotFoundExpection extends RuntimeException {
	private static final long serialVersionUID = -4373158775284035841L;
	
	public DepartmentNotFoundExpection(String message) {
		super(message);
	}
	
	public DepartmentNotFoundExpection() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}
